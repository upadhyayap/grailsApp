function markComplete() {
	var taskids = [];
	$.each($("[name='taskid']"),function(index,value){
		if(value.checked === true) {
			taskids.push(value.value);
		}
	});
	var newData = ${remoteFunction(controller: 'TaskController', action: 'markComplete', params: taskids.join(" , "))};
}