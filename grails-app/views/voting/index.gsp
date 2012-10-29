
<%@ page import="pl.certa.voting.Option"%>
<!DOCTYPE html>
<html>
<head>
<%--<meta name="layout" content="main">--%>
<%--<link rel="stylesheet"--%>
<%--	href="${resource(dir:'css',file:'demo_page.css')}" />--%>
<%--<link rel="stylesheet"--%>
<%--	href="${resource(dir:'css',file:'jquery.dataTables.css')}" />--%>



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

	   oTable = $('#example').dataTable({
		    sScrollY: '70%',
		    bProcessing: true,
		    bServerSide: true,
		    sAjaxSource: '${request.contextPath + '/voting/dataTableSource'}' ,
		    bJQueryUI: true,
		    sPaginationType: "full_numbers",
		    aLengthMenu: [[100, 500, 1000, 5000, -1], [100, 500, 1000, 5000, "All"]],
		    iDisplayLength: 500,
		    fnDrawCallback: function( nRow, aData, iDisplayIndex) {
		        
		    }
    });
 });

</script>

</head>
<body>
	<h1>Voting</h1>
	<div id="demo">
		<table cellpadding="0" cellspacing="0" border="0" class="display"
			id="example" width="100%">
			<thead>
				<tr>
					<th>Tytuł</th>
					<th>Treść</th>
				</tr>

			</thead>
			<tbody>


			</tbody>
		</table>
	</div>
</body>
</html>
