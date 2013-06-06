import org.grails.jade.test.Person

class BootStrap {

    def init = { servletContext ->
        2.times { new Person(name: 'Person ' + UUID.randomUUID()).save() }
    }
    def destroy = {
    }
}
