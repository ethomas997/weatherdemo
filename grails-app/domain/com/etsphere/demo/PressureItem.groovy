package com.etsphere.demo

/**
 * Weather information item for pressure.
 */
class PressureItem extends WeatherInfoItem {

    /**
     * Creates a weather information item for pressure.
     * @param hpaVal pressure in hectopascals.
     */
    PressureItem(float hpaVal) {
        dataText = pressHpaToIn(hpaVal)
        description = 'Pressure:'
        suffix = ' in.'
    }

    /**
     * Converts a pressure value from hectopascals to inches-of-mercury.
     * @param hpaVal pressure in hectopascals.
     * @return PressureItem in inches-of-mercury.
     */
    def pressHpaToIn(float hpaVal) {
        (hpaVal / 33.86f).round(2)
    }
}
