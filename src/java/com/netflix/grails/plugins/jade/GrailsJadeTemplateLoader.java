package com.netflix.grails.plugins.jade;

import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import javax.annotation.PostConstruct;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ResourceLoader;

class GrailsJadeTemplateLoader extends SpringTemplateLoader implements ApplicationContextAware {
    protected final Log log = LogFactory.getLog(getClass());

    private ApplicationContext applicationContext;

    @PostConstruct public void init() {
        //if we are in development or config is set to reloadable GSPs then this is the one we want
        if(applicationContext.containsBeanDefinition("groovyPageResourceLoader")){
            log.debug("must be runnning in dev so using the groovyPageResourceLoader");
            setResourceLoader((ResourceLoader)applicationContext.getBean("groovyPageResourceLoader"));
        }else{
            //in a production deployment, so just use the applicationContext
            setResourceLoader((ResourceLoader)applicationContext);
        }
        super.init();
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}