var Scaffolding = Ember.Application.create({
    baseUrl: '',
    createUrl: function(action) {
        return Scaffolding.baseUrl.replace(/index$/, action);
    }
});

Scaffolding.ListController = Ember.ArrayController.extend({});

Scaffolding.ListView = Ember.View.extend({
    controller: Scaffolding.ListController,
    templateName: 'list'
});

Scaffolding.listController = Scaffolding.ListController.create();
Scaffolding.ListView.create({
    controller: Scaffolding.listController,
    classNames: ['content scaffold-list']
}).appendTo('body');

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

$(function() {
    Scaffolding.baseUrl = $('body').data('base-url');

    jQuery.getJSON(Scaffolding.createUrl('list'), function(data) {
        Scaffolding.listController.set('content', data);
    });
});

/**
 * format a date using Moment.js
 * usage: {{dateFormat date format="MMMM YYYY"}}
 */
Handlebars.registerHelper('dateFormat', function(context, block) {
    console.log(this[context]);
    if (this[context]) {
        var dateAttr = Handlebars.Utils.escapeExpression(moment(this[context]).format('YYYY-MM-DD'));
        var format = block.hash.format || "MMM Do, YYYY";
        var dateText = Handlebars.Utils.escapeExpression(moment(this[context]).format(format));
        return new Handlebars.SafeString('<time datetime="' + dateAttr + '">' + dateText + '</time>');
    } else {
        return '';
    }
});