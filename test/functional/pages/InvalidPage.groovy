package pages

import geb.Page

/**
 */
class InvalidPage extends Page {

    static url = "person/invalid"

    static at = { title ==~ /Jade Compiler Exception/ }

    static content = {
        detail { $("#detail") }
    }
}
