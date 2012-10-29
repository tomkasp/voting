package pl.certa.voting

import pl.certa.Person;

class Session {

	
	String title;
	String description;
	String place;
	Date startDate;
	Date endDate;
	Boolean status;
	
	static hasMany = [votings:Voting]
    
	static constraints = {
    }
	
	@Override
	public String toString() {
		return title;
	}
}
