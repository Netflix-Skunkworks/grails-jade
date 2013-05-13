package pages

import geb.Page

/**
 */
class ListPage extends Page {

    static url = "person/list"

    static at = { title ==~ /My Site -/ }

    static content = {
        personCount { $("body").find("li") }
    }
}
