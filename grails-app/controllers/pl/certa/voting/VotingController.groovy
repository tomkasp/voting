package pl.certa.voting

import grails.converters.JSON

class VotingController {
	
	int sessionId;
   
	def index(){
	   if(params.sessionId)
		sessionId = params.sessionId
   }
   
   def dataTableSource(){
	   	   def propertiesToRender = ['title', 'text']
	   
		   def filters = []
	   
		   def dataToRender = [:]
		   dataToRender.sEcho = params.sEcho
		   dataToRender.aaData=[]                // Array of products.
	   
	
		   def result = []
		   if ( params.sSearch ) {

		   } else {
			   def session = Session.get(sessionId);
			   session.votings
			   result = session.votings;
		   }
		   
/*		   dataToRender.iTotalRecords = Product.countByEnabled(true)
		   dataToRender.iTotalDisplayRecords = dataToRender.iTotalRecords*/
	   
		   result?.each { res ->
			  dataToRender.aaData << [res.title,
									  res.text]
		   }
	   
		   render dataToRender as JSON
   }
	   
}
