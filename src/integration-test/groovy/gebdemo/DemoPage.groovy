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
        grailsLink {
            $('a', href: 'https://grails.org')
        }
        grailsLinkText {
            grailsLink.text()
        }
        micronautSummaryTitle {
            $('u').find { it.$('b').text() == 'Micronaut Summary:' }
        }
        grailsSummaryTitle {
            $('u').find { it.$('b').text() == 'Grails Summary:' }
        }
    }

    private static final String NON_HTMLUNIT_TEXT_EXTRACTOR = '''let ret = '';
                      |for (e = arguments[0].nextSibling; e && e.nextSibling && e != arguments[1]; e = e.nextSibling) {
                      |    ret += e.textContent;
                      |}
                      |return ret;'''.stripMargin()

    String getMicronautSummary() {
        driver.executeScript(NON_HTMLUNIT_TEXT_EXTRACTOR, micronautSummaryTitle.singleElement(), grailsLink.singleElement()).trim()
    }

    String getGrailsSummary() {
        driver.executeScript(NON_HTMLUNIT_TEXT_EXTRACTOR, grailsSummaryTitle.singleElement(), null).trim()
    }
}
