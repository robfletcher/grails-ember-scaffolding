<% import grails.persistence.Event %>
<%=packageName%>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title>\${entityName}</title>
		<r:require module="ember"/>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="\${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div class="content" role="main">
		</div>
		<script type="text/x-handlebars" data-template-name="\${entityName}-list">
			<g:include view="list.handlebars"/>
		</script>
	</body>
</html>
