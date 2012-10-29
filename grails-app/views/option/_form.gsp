<%@ page import="pl.certa.voting.Option" %>



<div class="fieldcontain ${hasErrors(bean: optionInstance, field: 'optionNumber', 'error')} required">
	<label for="optionNumber">
		<g:message code="option.optionNumber.label" default="Option Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="optionNumber" type="number" value="${optionInstance.optionNumber}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: optionInstance, field: 'optionText', 'error')} ">
	<label for="optionText">
		<g:message code="option.optionText.label" default="Option Text" />
		
	</label>
	<g:textField name="optionText" value="${optionInstance?.optionText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: optionInstance, field: 'voteValues', 'error')} ">
	<label for="voteValues">
		<g:message code="option.voteValues.label" default="Vote Values" />
		
	</label>
	<g:select name="voteValues" from="${pl.certa.voting.VoteValue.list()}" multiple="multiple" optionKey="id" size="5" value="${optionInstance?.voteValues*.id}" class="many-to-many"/>
</div>

