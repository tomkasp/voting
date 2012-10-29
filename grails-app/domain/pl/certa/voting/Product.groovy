package pl.certa.voting

import org.apache.commons.lang.builder.*

class Product {

	int productId
	String itemNumber
	String title
	String description
	String price
	String link
	String condition
	Boolean enabled = false
	String updateError
	
	Date dateCreated
	Date lastUpdated
	
    static constraints = {
		productId(unique: true)
		itemNumber(unique: true, nullable: true)
		title(nullable: true)
		description(nullable: true, size:0..4000)
		price(nullable: true)
		link(url: true, nullable: true)
		condition(nullable: true)
		enabled(nullable: false)
		manufacturer(nullable: true)
		updateError(nullable: true, size:0..4000)
    }
	
	static mapping = {
		condition column: 'cond'
	}
	
	static belongsTo = [manufacturer: Manufacturer]
	
	boolean equals(o) {
		if ( ! o instanceof Product ) {
			return false
		}
		def eb = new EqualsBuilder().append(productId, o.productId)
		eb.append(itemNumber, o.itemNumber)
		return eb.isEquals()
	}
	
	int hashCode() {
		def hcb = new HashCodeBuilder(17,37).append(productId)
		hcb.append(itemNumber)
		return hcb.toHashCode()
		
	}
}