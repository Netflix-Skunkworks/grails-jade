package pages

import geb.Page

/**
 */
class CoffeescriptPage extends Page {

    static url = "person/coffeescript"

    static at = { title ==~ /Other Layout/ }

    static content = {
        bodytext { $("#bodytext") }
    }
}
