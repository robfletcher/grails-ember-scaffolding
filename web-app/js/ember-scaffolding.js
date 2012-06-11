var App = Ember.Application.create();

App.List = Ember.Object.extend({});

App.ListController = Ember.ArrayController.extend({});

App.ListView = Ember.View.extend({
	controller: App.ListController,
	templateName: 'list'
});

App.listController = App.ListController.create();
App.ListView.create({controller: App.listController}).appendTo('#content');
jQuery.getJSON("list", function(data) {
	App.listController.set('content', data);
});

//App.Router = Ember.Router.extend({
//	root: Ember.State.extend({
//		index: Ember.State.extend({
//			route: '/',
//			redirectsTo: 'list'
//		}),
//		list: Ember.State.extend({
//			route: '/list',
//			connectOutlets: function(router) {
//				router.get('applicationController').connectOutlet(App.ListView, App.List.find());
//			}
//		})
//	})
//});