package pl.certa.voting

class Manufacturer {

    String name
	
	static constraints = {
    }
	
	static hasMany = [products:Product]
}
