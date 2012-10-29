
<%@ page import="pl.certa.voting.Option"%>
<!DOCTYPE html>
<html>
<head>
<%--<meta name="layout" content="main">--%>
<%--<link rel="stylesheet"--%>
<%--	href="${resource(dir:'css',file:'demo_page.css')}" />--%>
<%--<link rel="stylesheet"--%>
<%--	href="${resource(dir:'css',file:'jquery.dataTables.css')}" />--%>

<link rel="stylesheet" href="${resource(dir:'css',file:'rowhiglith.css')}"/>

<link rel='stylesheet'
	href='http://www.datatables.net//release-datatables/media/css/demo_table.css' />

<g:javascript src="DataTables-1.9.4/media/js/jquery.js" />
<g:javascript src="DataTables-1.9.4/media/js/jquery.dataTables.js" />

<script type="text/javascript">

function renderPriceWithCents(obj) {
    var num = obj.aData[obj.iDataColumn]
    return num;
 }

 var oTable;

 $(document).ready(function() {
	 	
		
		 /* Add/remove class to a row when clicked on */
		$('#example tr').click( function() {
			$(this).toggleClass('row_selected');
			alert("a");
		} );

		$('#example').css( 'cursor', 'pointer' );

	   oTable = $('#example').dataTable({
       sScrollY: '70%',
       bProcessing: true,
       bServerSide: true,
       sAjaxSource: '${request.contextPath + '/session/dataTablesSource'}' ,
       bJQueryUI: true,
       sPaginationType: "full_numbers",
       aLengthMenu: [[100, 500, 1000, 5000, -1], [100, 500, 1000, 5000, "All"]],
       iDisplayLength: 500,
       aoColumnDefs: [{
          fnRender: renderPriceWithCents,
          aTargets: [2]
       }],
       fnDrawCallback: function( nRow, aData, iDisplayIndex) {
           clickRowHandler( nRow, aData, iDisplayIndex);
       }
    });
 });

 function clickRowHandler( nRow, aData, iDisplayIndex) {
	 
     $('#example tbody tr').bind('click', function () {
    	 var parentLink = $(this).children()[1];    	 
     });
 }
</script>

</head>
<body>
	<h1>Live example</h1>
	<g:link action="index" id="2">ses.title</g:link>
	<div id="demo">
		<table cellpadding="0" cellspacing="0" border="0" class="display"
			id="example" width="100%">
			<thead>
				<tr>
					<th>Tytuł</th>
					<th>Opis</th>
					<th>Miejsce</th>
					<th>Data rozpoczęcia</th>
					<th>Data zakończenia</th>
				</tr>
		
			</thead>
			<tbody>


			</tbody>
		</table>
	</div>
</body>
</html>
