package com.netflix.grails.plugins.jade;

import de.neuland.jade4j.spring.view.JadeView;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.groovy.grails.web.servlet.mvc.GrailsWebRequest;
import org.codehaus.groovy.grails.web.util.WebUtils;

class GrailsJadeView extends JadeView {

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        GrailsWebRequest webRequest = WebUtils.retrieveGrailsWebRequest();
        model.put("params", webRequest.getParams());
        model.put("request", webRequest);
        model.put("session", webRequest.getSession());
        model.put("application", webRequest.getServletContext());
        model.put("flash", webRequest.getAttributes().getFlashScope(request));
        super.renderMergedOutputModel(model, request, response);
    }
}