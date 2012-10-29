package pl.certa.voting

import grails.converters.JSON

class SessionController {

	static scaffold = Session
	
	def index() {
		
	}
	
	def test() {
		log.info("test")
	}
	
	def seevoting(){
//		log.info("test");
//		redirect(action: "show", id: 4, params: [author: "Stephen King"])
//		redirect(action: "show", id: 4, params: [author: "Stephen King"])
		
		redirect(controller: "voting", action: "index", params: [sessionId: params.id]);
	}
	
	def dataTablesSource(){
		
		def propertiesToRender = ['title', 'description', 'place', 'startDate', 'endDate']
		
			def filters = []
			propertiesToRender.each { prop ->
			   filters << "p.${prop} like :filter"
			}
			def filter = filters.join(" OR ")
		
			def dataToRender = [:]
			dataToRender.sEcho = params.sEcho
			dataToRender.aaData=[]                // Array of products.
		
			dataToRender.iTotalRecords = Product.countByEnabled(true)
			dataToRender.iTotalDisplayRecords = dataToRender.iTotalRecords
		
			def query = new StringBuilder("from Session as p")
			if ( params.sSearch ) {
			   query.append(" where (${filter})")
			}
			def sortDir = params.sSortDir_0?.equalsIgnoreCase('asc') ? 'asc' : 'desc'
			def sortProperty = propertiesToRender[params.iSortCol_0 as int]
			query.append(" order by p.${sortProperty} ${sortDir}")
		
			def sessions = []
			if ( params.sSearch ) {
			   // Revise the number of total display records after applying the filter
			   def countQuery = new StringBuilder("select count(*) from Session as p")
			   if ( params.sSearch ) {
				  countQuery.append(" where (${filter})")
			   }
			   def result = Session.executeQuery(countQuery.toString(),
												 [filter: "%${params.sSearch}%"])
			   if ( result ) {
				  dataToRender.iTotalDisplayRecords = result[0]
			   }
			   sessions = Session.findAll(query.toString(),
				  [filter: "%${params.sSearch}%"],
				  [max: params.iDisplayLength as int, offset: params.iDisplayStart as int])
			} else {
			   sessions = Session.findAll(query.toString(),
			   [max: params.iDisplayLength as int, offset: params.iDisplayStart as int])
			}
		
			sessions?.each { ses ->
			   dataToRender.aaData << [//"<g:link action=\"index\" id=\"2\">ses.title</g:link>",
				   					   "<a href=../session/seevoting?id=" +ses.id+ ">" +ses.title+"</a>",
				   					   ses.description,
									   ses.place,
									   ses.startDate,
									   ses.endDate]
			}
		
			render dataToRender as JSON
			
	}
}
