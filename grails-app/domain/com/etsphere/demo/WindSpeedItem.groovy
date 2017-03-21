package com.etsphere.demo

/**
 * Weather information item for wind speed.
 */
class WindSpeedItem extends WeatherInfoItem {

    /**
     * Creates a weather information item for wind speed.
     * @param msVal wind speed in meters-per-second.
     */
    WindSpeedItem(float msVal) {
        dataText = speedMsToMph(msVal)
        description = 'Wind Speed:'
        suffix = ' MPH'
    }

    /**
     * Converts a velocity value from meters-per-second to miles-per-hour.
     * @param msVal velocity in meters-per-second.
     * @return Velocity in miles-per-hour.
     */
    def speedMsToMph(float msVal) {
        (msVal * 3600 / 1609.3f).round(1)
    }
}
