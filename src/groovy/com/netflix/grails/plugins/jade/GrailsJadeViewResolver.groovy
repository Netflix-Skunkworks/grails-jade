package com.netflix.grails.plugins.jade

import org.springframework.web.servlet.View
import de.neuland.jade4j.spring.view.JadeViewResolver
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.web.servlet.view.AbstractUrlBasedView

class GrailsJadeViewResolver extends JadeViewResolver {
    private final Log log = LogFactory.getLog(GrailsJadeViewResolver.class);

    View loadView(String viewName, Locale locale) {
        log.error 'here'
        super.loadView(viewName, locale)
    }

    AbstractUrlBasedView buildView(String viewName) {
        log.error("starting buildView with " + viewName);
        def view = super.buildView(viewName);
        log.error("buildView view url is " + view);
        view;
    }
}