var Scaffolding = Ember.Application.create();

Scaffolding.ListController = Ember.ArrayController.extend({});

Scaffolding.ListView = Ember.View.extend({
	controller: Scaffolding.ListController,
	templateName: 'list'
});

Scaffolding.listController = Scaffolding.ListController.create();
Scaffolding.ListView.create({
	controller: Scaffolding.listController,
	classNames: ['scaffold-list']
}).appendTo('#content');
jQuery.getJSON("list", function(data) {
	Scaffolding.listController.set('content', data);
});

//Scaffolding.Router = Ember.Router.extend({
//	root: Ember.State.extend({
//		index: Ember.State.extend({
//			route: '/',
//			redirectsTo: 'list'
//		}),
//		list: Ember.State.extend({
//			route: '/list',
//			controller: Scaffolding.listController
//		})
//	})
//});