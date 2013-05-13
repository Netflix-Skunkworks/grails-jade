package org.grails.jade.test

import geb.spock.GebReportingSpec
import pages.CoffeescriptPage
import pages.MarkdownPage

/**
 */
class ConfigFiltersJadeSpec extends GebReportingSpec {

    def "Ensure coffeescript filter processes content"() {
        when:
        to CoffeescriptPage

        then:
        at CoffeescriptPage
        bodytext.text() ==~ /Not Empty/
    }

    def "Ensure markdown filter processes content"() {
        when:
        to MarkdownPage

        then:
        at MarkdownPage
        bodytext.text() ==~ /Hello World/
        headerTags.size() > 0
//        bodytext ==~ /<h3>Hello World<\/h3>/
    }


}
