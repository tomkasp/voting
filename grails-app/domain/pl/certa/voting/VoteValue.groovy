package pl.certa.voting

import com.sun.org.apache.bcel.internal.generic.RETURN;

import pl.certa.Person;

class VoteValue {

	Integer voteValue;
	//	Integer voteVersion;

	//	static belongsTo = [person:Person, option:Option]

	static constraints = {
	}


	@Override
	public String toString() {
		switch (voteValue) {
			case 0:
				return "Przeciw"
				
			case 1:

				return "Za"

			case 2:

				return "Wstrzymuje się"

			default:
				break;
		}
	}

}
