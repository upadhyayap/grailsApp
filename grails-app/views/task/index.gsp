<!DOCTYPE html>
<html>
<head>
    <title>TO DO Task Manager</title>
    <blueprint:resources/>
    <g:javascript library='jquery' />
    <r:layoutResources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
    <g:javascript src="toDoApp.js" />
</head>
<body>
    <div class="container">
        <h1 class="span-24 last">To Do Task Manager</h1>
        <div class="span-24 last">
            <div class="span-16">
            <div id = "flashMessage">
            	<h2> ${flash.message}</h2>
            </div>
            <div id="msg">
                <h2>Open Tasks</h2>
                </div>
            </div>
            <div class="span-4">
                <ul class="actions">
					
				</ul>
            </div>
            <div class="span-4 last"></div>
        </div>
        <div class="span-20" id ="create">
         
        </div>
            <form method="post" action="/my-app/task/markComplete">
            <div class="span-20">
             <g:render template="taskCard" collection="${tasks}" var="task"/>
             
             </fieldset>
				<fieldset class="buttons">
					<input type="submit" id="markComplete" value="markComplete"  class="markComplete"  name="markComplete">
					<input type="submit" id="deleteTask"   value="deleteTask"    class="deleteTask"    name="deleteTask">
				</fieldset>
        </div>
       </form>
        <div class="span-4 last">
            <dl class="sidebar">
                <dt>Task <g:link action="create">New Task</g:link> </dt>
                <dd>
                    <ul>
                        <li><g:link action="OpenTaskList" update="create">Open </g:link></li>
                        <li><g:link action="DoneTaskTask" update="create">Done </g:link></li>
                        <li><g:link action="AllTaskList" update="create">All </g:link></li>
                    </ul>
                </dd>
                Tag <a class="create" href="/my-app/tag/create">New Tag</a>
                <dd>
                    <ul>
                       <li>Work</li>
                        <li>Home</li>
                    </ul>
                </dd>
            </dl>
        </div>
    </div>
</body>
</html>