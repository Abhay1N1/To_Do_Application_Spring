<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-todo" style="background-color: green; color: black">Add Todo</a>
	</div>
	<br>
	<div class="panel panel-primary" style="background-color: cyan">
		<div class="panel-heading">
			<h3>List of TODO</h3>
		</div>
		<div class="panel-body" >
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">Description</th>
						<th width="40%">Target Date</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.description}</td>
							<td><fmt:formatDate value="${todo.targetDate}"
									pattern="dd/mm/yyyy" /></td>
							<td><a type="button" class="btn btn-success" style="background-color: green" 
								href="/update-todo?id=${todo.id}">Update</a>
							<a type="button" class="btn btn-warning" style="background-color: red"
								href="/delete-todo?id=${todo.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>