package pages

import geb.Page

/**
 */
class IndexPage extends Page {
    static url = "person/index"

    static at = { title ==~ /Index Page/ }

    static content = {
        flash { $("#flash") }
    }
}
