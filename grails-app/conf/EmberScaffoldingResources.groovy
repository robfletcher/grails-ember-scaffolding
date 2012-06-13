modules = {
	'handlebars' {
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js/handlebars', file: 'handlebars-1.0.0.beta.6.js']
	}
	'moment' {
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js/moment', file: 'moment.min.js']
	}
	'ember-scaffolding' {
		dependsOn 'ember', 'moment'
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js', file: 'scaffolding-helpers.js']
		resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js', file: 'ember-scaffolding.js']
	}
	overrides {
		'ember' {
			dependsOn 'jquery', 'handlebars'
			resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js/ember', file: 'ember-latest.min.js'], nominify: true
		}
		'ember-dev' {
			dependsOn 'jquery', 'handlebars'
			resource id: 'js', url: [plugin: 'ember-scaffolding', dir: 'js/ember', file: 'ember-latest.js'], nominify: true
		}
	}
}