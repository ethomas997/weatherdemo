package com.etsphere.demo

/**
 * Controller that receives zipcode value, queries weather-info service for
 * data, and delivers info data to view.
 */
class WeatherInfoController {

    def weatherInfoService

    /**
     * Queries WeatherInfoService with 'params.zipcode' value and shows response.
     */
    def index() {
        respond([zipcode: params.zipcode, weatherInfoData: weatherInfoService.getWeatherInfo(params.zipcode)])
     }

    /**
     * Handles submission via zipcode-text entry on weather-info page.
     * @param zipcodeText entered zipcode value.
     */
    def enterZipcode(String zipcodeText) {
        if (zipcodeText) {
            redirect controller: 'WeatherInfo', params: [zipcode: zipcodeText]
        }
        else {          //if no text value then go back to HomeController page
            redirect controller: 'Home'
        }
    }

    /**
     * Fallback exception handler.
     */
    def handleException(Exception ex) {
        render "Exception in WeatherInfoController: " + ex
    }
}
