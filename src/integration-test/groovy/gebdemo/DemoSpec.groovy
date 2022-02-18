package gebdemo

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.htmlunit.HtmlUnitDriver
import spock.lang.IgnoreIf

@Integration
class DemoSpec extends GebSpec {

    @IgnoreIf({
        properties."geb.env" == 'htmlUnit'
    })
    void 'test demo page'() {
        when:
        to DemoPage

        then:
        def page = at DemoPage

        and:
        micronautLinkText == 'Micronaut Framework'
        grailsLinkText == 'Grails Framework'

        page.micronautSummary() == 'Microservice Framework'
        page.grailsSummary() == 'Web Application Framework'
    }
}
