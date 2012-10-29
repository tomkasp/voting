package pl.certa.voting

class Voting {

//	Integer votingNumber;
	String title;
	String text;
//	Integer maxVotesCount;
//	Date startDate;
//	Date endDate;
//	String formula;
//	Boolean status;
//	Boolean secret;
//	Integer lastVotingOption;
//	Integer optionsCount;
//	Boolean isTerminalControlAutomatci;
//	Boolean isResultsShowingLive;
	

	
	static hasOne =  [votingType:VotingType]
	static hasMany = [options:Option]
	
    static constraints = {
		
    }

	@Override
	public String toString() {
		return title;
	}	
	
}
