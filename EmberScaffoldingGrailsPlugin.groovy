class EmberScaffoldingGrailsPlugin {
    
    def version = '1.0-SNAPSHOT'
    def grailsVersion = '2.0 > *'
    def dependsOn = [ember: '0.9.8.1 > *']
    def pluginExcludes = [
		'grails-app/conf/BootStrap.groovy',
        'grails-app/views/layouts/main.gsp',
        'grails-app/views/error.gsp'
    ]

    def title = 'Ember Scaffolding Plugin'
    def author = 'Rob Fletcher'
    def authorEmail = 'rob@freeside.co'
    def description = '''\
A plugin that enables Grails scaffolding to operate as an Ember.js one-page app.
'''

    def documentation = 'http://freeside.co/grails-ember-scaffolding'
    def license = 'MIT'
    def organization = [name: 'Freeside Software', url: 'http://freeside.co/']
    def issueManagement = [system: 'GitHub', url: 'https://github.com/robfletcher/grails-ember-scaffolding/issues']
    def scm = [url: 'https://github.com/robfletcher/grails-ember-scaffolding']

}
