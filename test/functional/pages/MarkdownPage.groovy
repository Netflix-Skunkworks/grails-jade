package pages

import geb.Page

/**
 */
class MarkdownPage extends Page {

    static url = "person/markdown"

    static at = { title ==~ /Other Layout/ }

    static content = {
        bodytext { $("#bodytext") }
        headerTags { $('#bodytext h3') }
    }
}
