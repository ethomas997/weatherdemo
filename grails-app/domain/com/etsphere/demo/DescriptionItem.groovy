package com.etsphere.demo

/**
 * Weather information item for description.
 */
class DescriptionItem extends WeatherInfoItem {

    /**
     * Creates a weather information item for description.
     * @param str description text.
     */
    DescriptionItem(String str) {
        dataText = str
        description = 'Description:'
    }
}
