
<%@ page import="pl.certa.voting.Option" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'option.label', default: 'Option')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-option" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-option" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list option">
			
				<g:if test="${optionInstance?.optionNumber}">
				<li class="fieldcontain">
					<span id="optionNumber-label" class="property-label"><g:message code="option.optionNumber.label" default="Option Number" /></span>
					
						<span class="property-value" aria-labelledby="optionNumber-label"><g:fieldValue bean="${optionInstance}" field="optionNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${optionInstance?.optionText}">
				<li class="fieldcontain">
					<span id="optionText-label" class="property-label"><g:message code="option.optionText.label" default="Option Text" /></span>
					
						<span class="property-value" aria-labelledby="optionText-label"><g:fieldValue bean="${optionInstance}" field="optionText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${optionInstance?.voteValues}">
				<li class="fieldcontain">
					<span id="voteValues-label" class="property-label"><g:message code="option.voteValues.label" default="Vote Values" /></span>
					
						<g:each in="${optionInstance.voteValues}" var="v">
						<span class="property-value" aria-labelledby="voteValues-label"><g:link controller="voteValue" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${optionInstance?.id}" />
					<g:link class="edit" action="edit" id="${optionInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
