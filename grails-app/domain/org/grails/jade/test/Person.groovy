package org.grails.jade.test

class Person {

    String name

    static constraints = {
        name blank: false, nullable: false
    }
}
