package com.etsphere.demo

/**
 * Parent class for displayed weather information items.  Subclasses can
 * customize the parts of the item to be displayed.
 */
class WeatherInfoItem {

    String dataText = ''
    String description = ''
    String suffix = ''

    /**
     * Creates a weather information item.
     * @param str text to display.
     */
    WeatherInfoItem(String str) {
        dataText = str
    }

    /**
     * Returns the description text for the item (left side).
     * @return Description text.
     */
    def getItemDescText() {
        description
    }

    /**
     * Returns the data text for the item (right side).
     * @return Data text.
     */
    def getItemDataText() {
        dataText + suffix
    }
}
