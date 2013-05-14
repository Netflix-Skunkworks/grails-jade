package pages

import geb.Page

/**
 */
class OtherPage extends Page {

    static url = "person/other"

    static at = { title ==~ /Other Layout/ }

    static content = {
        turtles { $("#turtles") }
    }
}
