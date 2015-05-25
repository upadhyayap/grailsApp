package org.pramati.imaginea

import org.hibernate.Query;


class TaskController {
	
    def index = {
		def tasks = Task.findAllByStatus("Open", [sort: "deadline", order: "asc"])
		def tags = Tag.list(sort: "name", order: "asc")
		
		[tasks: tasks, tags: tags]
	}
	def createTask =  {
		render(template: "create")
	}
	def create =  {
		render(view: "create")
	}
	def saveTask = {
		Task task = new Task()
		task.summery = params.summery
		task.details = params.details
		task.deadline = params.deadline
		task.status = params.status.toString()
		task.timeSpent = params.timeSpent
		if(task.save()) {
			flash.message = "Task Created"
		}
		else {
			flash.message = "Error in creating task"
		}
		redirect(action: "index")
	}
	
	def markComplete = {
		if (params["markComplete"]) {
			//flash.message = params.taskid.size()
			params.taskid.each {
				/*def tasks = Task.createCriteria().get {
					'eq'('id', Long.parseLong(params.taskid))
				  }
					tasks.status = "Done"
					tasks.save()*/
				try{
						def tasks = Task.get(Long.parseLong(it.value.toString()))
						tasks.status = "Done"
						tasks.save(flush:true)
						flash.message = "Selected tasks have been marked as complete" 
					} catch (Exception e){
						e.printStackTrace();
					}
			}
/*
			List result = Task.executeQuery("FROM Task  where id in (:tasks)" ,
				[tasks:params.taskid.collect {it.value}.join(", ")]) 
			result.each {
				println it
			}*/
		}
		else if (params["deleteTask"]) {
			params.taskid.each {
			Task.executeUpdate("delete Task t where t.id=?",[Long.parseLong(it.value.toString())])
			}
			flash.message = "Selected tasks have been deleted sucessfully"
		}
		redirect(action: "index")
	}
	def OpenTaskList  = {
		def tasks = Task.findAllByStatus("Open", [sort: "deadline", order: "asc"])
		def tags = Tag.list(sort: "name", order: "asc")
		
		[tasks: tasks, tags: tags]
	}
	def DoneTaskList  = {
		def tasks = Task.findAllByStatus("Done", [sort: "deadline", order: "asc"])
		def tags = Tag.list(sort: "name", order: "asc")
		
		[tasks: tasks, tags: tags]
		render(view: "index")
	}
	def AllTaskList  = {
		def tasks = Task.findAll()
		def tags = Tag.list(sort: "name", order: "asc")
		
		[tasks: tasks, tags: tags]
	}
}
