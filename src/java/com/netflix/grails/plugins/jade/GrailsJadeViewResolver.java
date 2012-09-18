package com.netflix.grails.plugins.jade;

import de.neuland.jade4j.spring.view.JadeViewResolver;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

class GrailsJadeViewResolver extends JadeViewResolver {
    private final Log log = LogFactory.getLog(GrailsJadeViewResolver.class);

    public View loadView(String viewName, Locale locale) throws Exception{
        log.error("here");
        return super.loadView(viewName, locale);
    }

    public AbstractUrlBasedView buildView(String viewName) throws Exception{
        log.error("starting buildView with " + viewName);
        AbstractUrlBasedView view = super.buildView(viewName);
        log.error("buildView view url is " + view);
        return view;
    }
}