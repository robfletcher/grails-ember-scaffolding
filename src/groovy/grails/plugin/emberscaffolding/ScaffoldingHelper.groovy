package grails.plugin.emberscaffolding

import org.codehaus.groovy.grails.web.binding.DefaultASTDatabindingHelper

class ScaffoldingHelper {

    static List<String> getBindableProperties(Class domainClass) {
		domainClass."$DefaultASTDatabindingHelper.DEFAULT_DATABINDING_WHITELIST".findAll {
			!it.endsWith('_*')
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
