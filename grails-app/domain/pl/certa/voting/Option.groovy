package pl.certa.voting

class Option {

	Integer optionNumber;
	String optionText;
	
	static hasMany = [voteValues:VoteValue]
	
	static constraints = {
    }

	@Override
	public String toString() {
		return optionText;
	}	
	
}
