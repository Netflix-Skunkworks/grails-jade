grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsCentral()
        mavenCentral()
        mavenRepo "https://raw.github.com/neuland/jade4j/master/releases"
        mavenRepo "https://raw.github.com/neuland/spring-jade4j/master/releases"
    }
    dependencies {
        compile "de.neuland:jade4j:0.3.4"
        compile "de.neuland:spring-jade4j:0.3.0"
    }

    plugins {
        compile ':plugin-config:0.1.5'

        build(":tomcat:$grailsVersion",
              ":release:2.0.3",
              ":rest-client-builder:1.0.2") {
            export = false
        }
    }
}
