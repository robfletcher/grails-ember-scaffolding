var Scaffolding = Ember.Application.create({
	baseUrl: '',
	createUrl: function(action) {
		return Scaffolding.baseUrl.replace(/index$/, action);
	}
});

Scaffolding.ApplicationController = Ember.Controller.extend();
Scaffolding.ApplicationView = Ember.View.extend({ templateName: 'application' });

Scaffolding.NavbarController = Ember.Controller.extend();
Scaffolding.NavbarView = Ember.View.extend({
	templateName: 'navbar',
	classNames: ['nav']
});

Scaffolding.ListController = Ember.ArrayController.extend({});
Scaffolding.ListView = Ember.View.extend({
//	controller: Scaffolding.ListController,
	templateName: 'list',
	classNames: ['scaffold-list']
});

//Scaffolding.listController = Scaffolding.ListController.create();
//Scaffolding.ListView.create({
//	controller: Scaffolding.listController,
//	classNames: ['content scaffold-list']
//}).appendTo('body');

Scaffolding.Router = Ember.Router.extend({
	enableLogging: true,
	location: 'hash',

	root: Ember.State.extend({
		index: Ember.State.extend({
			route: '/',
			redirectsTo: 'list'
		}),
		list: Ember.State.extend({
			route: '/list',
			connectOutlets: function(router, context) {
				var appController = router.get('applicationController');
				appController.connectOutlet(Scaffolding.ListView);
			},
			setupControllers: function(manager) {
				var listController = manager.get('listController');
				listController.set('content', Scaffolding.List.findAll());
			}
//			controller: Scaffolding.listController
		})
	})
});

$(function() {
	Scaffolding.baseUrl = $('body').data('base-url');

	Scaffolding.initialize();
//	jQuery.getJSON(Scaffolding.createUrl('list'), function(data) {
//		Scaffolding.listController.set('content', data);
//	});
});
