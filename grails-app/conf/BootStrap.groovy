import grails.plugin.emberscaffolding.test.*
import java.text.SimpleDateFormat

class BootStrap {

	def init = { servletContext ->
		def date = new SimpleDateFormat('yyyy-MM-dd')

		new Pirate(name: 'Edward Teach', nickname: 'Blackbeard').save(failOnError: true	)
		new Pirate(name: 'Jack Rackham', nickname: 'Calico Jack', dateOfBirth: date.parse('1682-12-21')).save(failOnError: true)
	}

	def destroy = {
	}
}
