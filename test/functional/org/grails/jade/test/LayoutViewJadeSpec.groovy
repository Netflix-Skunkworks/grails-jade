package org.grails.jade.test

import geb.spock.GebReportingSpec
import pages.OtherPage

/**
 */
class LayoutViewJadeSpec extends GebReportingSpec {

    def "Render a page using an alternate layout"() {
        when:
        to OtherPage

        then:
        at OtherPage
        turtles.size() == 1
        turtles.text() == "Turtles"
    }
}
