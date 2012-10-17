<html>
<head>
<meta name="layout" content="main" />
<title>What Are You Doing?</title>
</head>
<body>
	<h1>Create User</h1>
	<div class="updatStatusForm">
		<g:formRemote url="[action: 'saveUser']" update="messages" name="updateStatusForm">
			 <g:textArea name="message" value=""/><br/>
           	 <g:submitButton name="Update Status"/>
		</g:formRemote>
	</div>
</body>
</html>