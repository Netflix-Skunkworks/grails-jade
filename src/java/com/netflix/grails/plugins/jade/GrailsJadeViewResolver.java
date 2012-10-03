package com.netflix.grails.plugins.jade;

import de.neuland.jade4j.spring.view.JadeViewResolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

class GrailsJadeViewResolver extends JadeViewResolver {
    private final Log log = LogFactory.getLog(GrailsJadeViewResolver.class);

    @Override
    public AbstractUrlBasedView buildView(String viewName) throws Exception{
        log.debug("starting buildView with " + viewName);
        AbstractUrlBasedView view = super.buildView(viewName);
        log.debug("buildView view url is " + viewName);
        return view;
    }

    @Override
    protected Class requiredViewClass() {
        return GrailsJadeView.class;
    }

}