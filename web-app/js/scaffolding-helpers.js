/**
 * format a date using Moment.js
 * usage: {{dateFormat date format="MMMM YYYY"}}
 */
Handlebars.registerHelper('dateFormat', function(context, block) {
    if (this[context]) {
        var dateAttr = Handlebars.Utils.escapeExpression(moment(this[context]).format('YYYY-MM-DD'));
        var format = block.hash.format || "MMM Do, YYYY";
        var dateText = Handlebars.Utils.escapeExpression(moment(this[context]).format(format));
        return new Handlebars.SafeString('<time datetime="' + dateAttr + '">' + dateText + '</time>');
    } else {
        return '';
    }
});