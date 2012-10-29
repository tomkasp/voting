import pl.certa.Authority
import pl.certa.Person
import pl.certa.PersonAuthority
import pl.certa.voting.Manufacturer
import pl.certa.voting.Option
import pl.certa.voting.Product
import pl.certa.voting.Session
import pl.certa.voting.VoteValue
import pl.certa.voting.Voting
import pl.certa.voting.VotingType

class BootStrap {

	def springSecurityService

	def init = { servletContext ->
		if (!Person.count()) {
			createData()
		}
	}

	def destroy = {
	}

	private void createData() {
		def userRole = new Authority(authority: 'ROLE_USER').save()

		Session testSession = new Session(description:"test session", title:"tytul", place:"krakow", status:true, startDate:new Date(), endDate:new Date())
		Session testSession2 = new Session(description:"test session2", title:"tytul", place:"krakow", status:true, startDate:new Date(), endDate:new Date())
		def votingType = new VotingType(name:"jawne")
		def option = new Option(optionNumber: 0, optionText:"pierwsza opcja")
		def voteValue = new VoteValue(voteValue: 0)
		def voteValue2 = new VoteValue(voteValue:1)
		def voteValue3 = new VoteValue(voteValue: 2)
		def voteValue4 = new VoteValue(voteValue: 1)
		
		def voting = new Voting(title:"tytul", text:"text", votingType:votingType)
		
		option.addToVoteValues(voteValue)
		option.addToVoteValues(voteValue2)
		option.addToVoteValues(voteValue3)
		option.addToVoteValues(voteValue4)
		
		voting.addToOptions(option)
		
		if (!testSession.addToVotings(voting).save()) {
			log.error "Could not save user!!"
			log.error "${testSession.errors}"
		}
		testSession2.save();
		
		def manufacturer = new Manufacturer(name:"TOmek");
		def product = new Product(title:"test", price:"cena");
		manufacturer.addToProducts(product)
		
		if (!manufacturer.save()) {
			log.error "Could not save user!!"
			log.error "${manufacturer.errors}"
		}


		String password = 'a'

		[jeff: 'Jeff Brown', graeme: 'Graeme Rocher', burt: 'Burt Beckwith', peter: 'Peter Ledbrook'].each { userName, realName ->
			def user = new Person(username: userName, realName: realName, password: password, enabled: true).save()
			PersonAuthority.create user, userRole, true
		}
	}
}
