package pl.certa.voting

class VotingType {

	String name;
	
	static belongsTo = [voting:Voting]
	
    static constraints = {
    }
	
	@Override
	public String toString() {
		return name;
	}
}
