package grails.plugin.emberscaffolding.test

class Pirate {

	String name
	String nickname
	Date dateOfBirth

    static constraints = {
    	name blank: false
    	dateOfBirth nullable: true
    }

}
