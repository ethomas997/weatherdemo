package com.etsphere.demo

/**
 * Weather information item for temperature.
 */
class TemperatureItem extends WeatherInfoItem {

    /**
     * Creates a weather information item for temperature.
     * @param kelvinVal temperature in Kelvin degrees.
     */
    TemperatureItem(float kelvinVal) {
        dataText = tempKToF(kelvinVal)
        description = 'Temperature:'
        suffix = "\u00B0 F"
    }

    /**
     * Converts a temperature value from Kelvin to Fahrenheit degrees.
     * @param kelvinVal temperature in Kelvin degrees.
     * @return Temperature in Fahrenheit degrees.
     */
    def tempKToF(float kelvinVal) {
        ((kelvinVal - 273.15f) * 9 / 5 + 32).round(1)
    }
}
