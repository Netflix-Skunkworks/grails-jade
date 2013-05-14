package org.grails.jade.test

import grails.plugin.spock.IntegrationSpec

/**
 */
class PersonControllerSpec extends IntegrationSpec {

    private controller

    static transactional = false

    def setup() {
        controller = new PersonController()
    }

    def "Get a list view"() {
        when:
        controller.list()

        then:
        controller.response.status == 200
        controller.modelAndView.model
    }

    def "Get a model view"() {
        when:
        controller.model()

        then:
        controller.response.status == 200
        controller.modelAndView.model
        controller.modelAndView.model.team
        controller.modelAndView.model.city
    }

}
