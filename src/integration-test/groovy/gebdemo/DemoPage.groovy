package gebdemo

import geb.Page

class DemoPage extends Page {

    static url = '/demo'

    static at = {
        title == 'Demo Web Page'
    }

    static content = {
        micronautLinkText {
            $('a', href: 'https://micronaut.io').text()
        }
        grailsLinkText {
            $('a', href: 'https://grails.org').text()
        }
//        micronautSummary {
//
//        }
//        grailsSummary {
//
//        }
    }
}
