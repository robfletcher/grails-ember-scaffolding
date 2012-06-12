<% import grails.persistence.Event %>
<% import grails.plugin.emberscaffolding.ScaffoldingHelper %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title>\${entityName}</title>
		<r:require module="ember-scaffolding"/>
	</head>
	<body data-base-url="\${createLink(action: 'index')}">
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<script type="text/x-handlebars" data-template-name="list">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<table>
				<thead>
					<tr><% props = ScaffoldingHelper.getBindableProperties(domainClass)
						for (p in props) { %>
						<th><g:message code="${domainClass.propertyName}.${p.name}.label" default="${p.naturalName}" /></th>
					<% } %></tr>
				</thead>
				<tbody>
					{{#each Scaffolding.listController}}
						<tr><% for (p in props) { %>
                            <% if (p.type == Date) { %><td>{{dateFormat ${p.name}}}</td><% }
                            else { %><td>{{${p.name}}}</td><% } %>
						<% } %></tr>
					{{/each}}
				</tbody>
			</table>
		</script>
	</body>
</html>
