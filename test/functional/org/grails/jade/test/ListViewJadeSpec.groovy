package org.grails.jade.test

import geb.spock.GebReportingSpec
import pages.ListPage
import spock.lang.Stepwise

/**
 */
@Stepwise
class ListViewJadeSpec extends GebReportingSpec {

    def "Render a jade list view with a single person"() {
        when:
        to ListPage

        then:
        at ListPage
        personCount.size() == 1
    }

    def "Render a jade list view with that adds another person"() {
        when:
        to ListPage

        then:
        at ListPage
        personCount.size() == 2
    }
}
