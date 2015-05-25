package org.pramati.imaginea

class Task {
	
	String summery
	String details
	Date dateCreated
	Date deadline
	String status
	long timeSpent = 0L
	static hasmany = [tags:Tag]
	static constraints = {
		summery blank:false ,unique:true
		details blank:false
		status inlist: ["open","Done"]
		deadline nullable:true
		timeSpent min:0L
	}
	String toString() {
		summery
	}
	
}
