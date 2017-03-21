package com.etsphere.demo

/**
 * Main controller for application.
 */
class HomeController {

    def index() { }

    /**
     * Passes given zipcode value to WeatherInfoController.
     * @param zipcodeText entered zipcode value.
     */
    def enterZipcode(String zipcodeText) {
        if (zipcodeText) {
            redirect controller: 'WeatherInfo', params: [zipcode: zipcodeText]
        }
        else {          //if no text value then just reload page
            redirect action: 'index'
        }
    }
}
