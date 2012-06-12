modules = {
    'moment' {
        resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js/moment', file: 'moment.min.js']
    }
	'ember-scaffolding' {
		dependsOn 'ember', 'moment'
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js', file: 'scaffolding-helpers.js']
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js', file: 'ember-scaffolding.js']
	}
}