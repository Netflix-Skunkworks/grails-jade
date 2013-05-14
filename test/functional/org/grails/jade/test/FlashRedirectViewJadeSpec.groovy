package org.grails.jade.test

import geb.spock.GebReportingSpec
import pages.FlashPage
import pages.IndexPage

/**
 */
class FlashRedirectViewJadeSpec extends GebReportingSpec {

    def "Go to a page and ger redirected with a flash message"() {
        when:
        to FlashPage

        then:
        at IndexPage
        flash.text() ==~ /This is a flash message/
    }
}
