package org.grails.jade.test

class PersonController {

    def echo() {
        render 'here'
    }

    def index() {}

    def model() {
        session.test = 'A session message'
        render view: 'model', model: [city: 'Philadelphia', team: 'Phillies', title: 'Model Page']
    }

    def flash() {
        flash.message = 'This is a flash message'
        redirect(action: 'index')
    }

    def layout() {
        render view: 'layoutTest', model: [title: 'Layout Test']
    }

    def list() {
        render view: 'list', model: [persons: Person.list()]
    }

    def other() {
    }

    def invalid(){}

    def coffeescript(){}

    def markdown(){}
}