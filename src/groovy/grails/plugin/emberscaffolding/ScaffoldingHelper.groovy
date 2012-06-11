package grails.plugin.emberscaffolding

import org.codehaus.groovy.grails.web.binding.DefaultASTDatabindingHelper
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.codehaus.groovy.grails.commons.GrailsDomainClassProperty

class ScaffoldingHelper {

    static List<String> getBindableProperties(Class domainClass) {
		domainClass."$DefaultASTDatabindingHelper.DEFAULT_DATABINDING_WHITELIST".findAll {
			!it.endsWith('*')
		}
    }

    static List<GrailsDomainClassProperty> getBindableProperties(GrailsDomainClass domainClass) {
		def propertyNames = getBindableProperties(domainClass.clazz)
		propertyNames.collect {
			domainClass.getPropertyByName(it)
		}
    }

	static Map<String, Object> getBindablePropertyValues(domainInstance) {
		domainInstance.properties.getAt(getBindableProperties(domainInstance.getClass()))
	}

	static Collection<Map<String, Object>> getBindablePropertyValues(Collection domainInstances) {
		domainInstances.collect {
			getBindablePropertyValues(it)
		}
	}

}
