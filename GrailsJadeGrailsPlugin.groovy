class GrailsJadeGrailsPlugin {
    // the plugin version
    def version = "1.0"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.1 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/**/*",
            "grails-app/controllers/**/*",
            "grails-app/domain/**/*",
            "web-app/**/*",
            "lib/**/*"
    ]

    // TODO Fill in these fields
    def title = "Jade Plugin" // Headline display name of the plugin
    def author = "Jason Gritman"
    def authorEmail = "jgritman@netflix.com"
    def description = 'Support for rendering Jade templates as views.'

    // URL to the plugin's documentation
    def documentation = "https://github.com/Netflix-Skunkworks/grails-jade"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [[name: "Christian Oestreich", email: "acetrike@gmail.com"]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "github", url: "https://github.com/Netflix-Skunkworks/grails-jade/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/Netflix-Skunkworks/grails-jade" ]

    def doWithSpring = {
        def jadeConfig = application.mergedConfig.asMap(true).grails.plugin.jade
        jadeTemplateLoader(com.netflix.grails.plugins.jade.GrailsJadeTemplateLoader) {
            basePath = '/grails-app/views'
        }
        jadeConfiguration(de.neuland.jade4j.JadeConfiguration) {
            prettyPrint = jadeConfig.prettyPrint
            caching = jadeConfig.caching
            sharedVariables = jadeConfig.sharedVariables
            templateLoader = ref('jadeTemplateLoader')
        }
        jadeViewResolver(com.netflix.grails.plugins.jade.GrailsJadeViewResolver) {
            prefix = ''
            suffix = '.jade'
            configuration = ref('jadeConfiguration')
            renderExceptions = jadeConfig.renderExceptions
            order = 10
        }
    }

    def doWithApplicationContext = { applicationContext ->
        def config = application.mergedConfig.asMap(true).grails.plugin.jade
        de.neuland.jade4j.JadeConfiguration jadeConfiguration = applicationContext.getBean("jadeConfiguration")
        config?.filters?.each { k, v ->
            log.debug "Adding grails-jade filter for $k"
            jadeConfiguration?.setFilter(k, v)
        }
    }
}
