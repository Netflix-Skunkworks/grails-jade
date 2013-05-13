package org.grails.jade.test

import geb.spock.GebReportingSpec
import org.openqa.selenium.WebDriverException
import pages.InvalidPage
import pages.OtherPage

/**
 */
class InvalidViewJadeSpec extends GebReportingSpec{

    def "Render an invalid page that throws a jade exception"() {
        when:
        to InvalidPage

        then: 'no way to trap this other than selenium exception from func spec'
        thrown(WebDriverException)
    }
}
