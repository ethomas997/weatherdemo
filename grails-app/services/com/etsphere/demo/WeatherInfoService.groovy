package com.etsphere.demo

import grails.transaction.Transactional
import groovy.json.JsonSlurper

/**
 * Service that fetches and returns weather-info data for the given zipcode.
 */
@Transactional
class WeatherInfoService {
    /** API key for weather-info query. */
    final String fetchWeatherKeyString = '2b18a620f62bf8c7a888246784e28394'

    /**
     * Fetches and returns weather-info data for the given zipcode.
     * @param zipcode zipcode value.
     * @return A list of weather-info-data items, or an empty list if error.
     */
    def getWeatherInfo(String zipcode) {
        try {
            //build URL using zipcode and API key:
            String fetchWeatherUrlString = "http://api.openweathermap.org/" +
                    "data/2.5/weather?zip=${zipcode},us&APPID=${fetchWeatherKeyString}"
            //send query and receive JSON data:
            String jsonStr = fetchWeatherUrlString.toURL().text
            //println 'jsonStr: ' + JsonOutput.prettyPrint(jsonStr)

            //convert JSON to map:
            def jsonMap = new JsonSlurper().parseText(jsonStr)

            //build and return list of items of interest:
            [infoItems: [
                    new TemperatureItem(jsonMap.main.temp),
                    new DescriptionItem(jsonMap.weather[0].description),
                    new WindSpeedItem(jsonMap.wind.speed),
                    new PressureItem(jsonMap.main.pressure) ],
             locationName: jsonMap.name,
             locationUrl : latLonToMapUrl(jsonMap.coord.lat, jsonMap.coord.lon)]
        }
        catch(Exception ex) {
            ex.printStackTrace()
            []          //if error then return empty list
        }
    }

    /**
     * Converts map-coordinate value to a map-URL string.
     * @param latVal latitude value.
     * @param lonVal longitude value.
     * @return A map-URL string.
     */
    def latLonToMapUrl(float latVal, float lonVal) {
        "http://www.google.com/maps/@${latVal},${lonVal},14z"
    }
}
