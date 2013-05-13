package pages

import geb.Page

/**
 */
class ModelPage extends Page {

    static url = "person/model"

    static at = { title ==~ /Model Page/ }

    static content = {
        session { $("#session").text() }
        team { $("#team").text() }
        city { $("#city").text() }
    }
}
