package com.netflix.grails.plugins.jade

/**
 * Convert an HttpServletRequest, HttpSession, or ServletContext to a map of attributes.
 */
class WebObjectConverter {

    static Map<String, Object> toMap(webObject) {
        (webObject.attributeNames as List).collectEntries { attributeName ->
            [attributeName, webObject.getAttribute(attributeName)]
        }
    }
}