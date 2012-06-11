package grails.plugin.emberscaffolding

import grails.plugin.emberscaffolding.test.Pirate
import grails.test.mixin.Mock
import spock.lang.Specification

@Mock(Pirate)
class ScaffoldingHelperSpec extends Specification {

	void 'can get list of bindable properties for a domain class'() {
		expect:
		ScaffoldingHelper.getBindableProperties(Pirate) == ['name', 'nickname', 'dateOfBirth']
	}

	void 'can get property values for a domain instance'() {
		given:
		def pirate = new Pirate(name: 'Edward Teach', nickname: 'Blackbeard')

		expect:
		ScaffoldingHelper.getBindablePropertyValues(pirate) == [name: pirate.name, nickname: pirate.nickname, dateOfBirth: pirate.dateOfBirth]
	}

	void 'can get property values for a collection of domain instances'() {
		given:
		def pirates = [
		        new Pirate(name: 'Edward Teach', nickname: 'Blackbeard'),
		        new Pirate(name: 'Jack Rackham', nickname: 'Calico Jack', dateOfBirth: new Date(1682, 12, 21))
		]

		expect:
		ScaffoldingHelper.getBindablePropertyValues(pirates) == [
				[name: pirates[0].name, nickname: pirates[0].nickname, dateOfBirth: pirates[0].dateOfBirth],
				[name: pirates[1].name, nickname: pirates[1].nickname, dateOfBirth: pirates[1].dateOfBirth]
		]
	}

}
