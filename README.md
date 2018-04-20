# MylistTodo
The ToDo application has an endpoint /todos where we can post our ToDo objects. A ToDo object contains the id,  one string representing our tasks for us to do later and a boolean that says whether it is done or not. We can always see them if you make a get request to /todos. In order to see a particular ToDo we will do a get request to /todos/{id}. And if we want to mark a ToDo as done we will post to /todos/{id}/done. This application will connect to a MongoDB in a local environment and Provide an additional application to the ToDo project. This Ui will display in one single page the list of all the ToDos with one button where we can mark them as “done”. In this page we will also be able to write new ToDos one by one in a text box and post them with one button

# technologies used
<ul>
<li> java9
<li> springBoot2
<li> thymeleaf
<li> MongoDB
<li> bootstrap 4
</ul>
