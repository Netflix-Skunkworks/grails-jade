package org.grails.jade.test

import geb.spock.GebReportingSpec
import pages.ListPage
import pages.ModelPage
import spock.lang.Stepwise

/**
 */
@Stepwise
class ModelViewJadeSpec extends GebReportingSpec {

    def "Render a jade model view with a session variable"() {
        when:
        to ModelPage

        then:
        at ModelPage
        println session
        session ==~ /A session message/
        team ==~ /Phillies of/
        city ==~ /Philadelphia/
    }
}
