<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Home Page</div>
		<div class="panel-body" style="background-color: cyan">
			Welcome to the home page, ${name}!! <a href="/list-todos" style="color: red">Press here </a> to edit your
			todo list.....
		</div>
	</div>
</div>
<%@ include file="common/footer.jsp"%>