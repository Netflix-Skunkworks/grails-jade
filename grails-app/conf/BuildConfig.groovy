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
        mavenRepo "https://raw.github.com/neuland/jade4j-coffeescript-filter/master/releases"
    }
    dependencies {
        compile "de.neuland:jade4j:0.3.9"
        compile "de.neuland:spring-jade4j:0.3.2"
        test("org.spockframework:spock-grails-support:0.7-groovy-2.0"){
            export = false
        }

        test("org.gebish:geb-spock:0.9.0-RC-1") {
            export = false
        }

        test('org.seleniumhq.selenium:selenium-htmlunit-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }

        test('org.seleniumhq.selenium:selenium-chrome-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }

        test('org.seleniumhq.selenium:selenium-firefox-driver:2.25.0') {
            excludes 'xmlbeans', 'spring-web', 'spring-core', 'xml-apis'
            export = false
        }

        test('jade4j-coffeescript-filter:jade4j-coffeescript-filter:0.2.0',
             'org.markdownj:markdownj:0.3.0-1.0.2b4',
             'jcoffeescript:jcoffeescript:1.1'){
            export = false
        }
    }

    plugins {
        compile ':plugin-config:0.1.8'

        //uncomment this to release - conflicts with GEB... *sigh*
        // build ':release:2.2.1', ':rest-client-builder:1.0.3', {
        //     export = false
        // }

        build(":build-test-data:2.0.5",
              ":tomcat:$grailsVersion",
              ":rest-client-builder:1.0.2") {
            export = false
        }

        test(":geb:0.7.2") {
            export = false
        }

        test(":spock:0.7") {
            exclude "spock-grails-support"
            export = false
        }
    }
}
