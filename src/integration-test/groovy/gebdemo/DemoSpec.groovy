package gebdemo

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class DemoSpec extends GebSpec {

    void 'test demo page'() {
        when:
        to DemoPage

        then:
        at DemoPage

        and:
        micronautLinkText == 'Micronaut Framework'
        grailsLinkText == 'Grails Framework'
//        micronautSummary == 'Microservice Framework'
//        grailsSummary == 'Web Application Framework'

    }
}
