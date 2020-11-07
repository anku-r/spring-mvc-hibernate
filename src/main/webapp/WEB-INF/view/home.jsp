<%@ include file="header.jsp" %>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Manage Comics Characters</h2>
					</div>
					<div class="col-sm-6">
						<a href="manage/addform" class="btn btn-success"><i class="material-icons">&#xE147;</i> <span>Add New Character</span></a>
						<button id="deleteAll" class="btn btn-danger"><i class="material-icons">&#xE15C;</i> <span>Delete</span></button>						
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>Name</th>
						<th>Real Name</th>
						<th>Category</th>
						<th>Publisher</th>
						<th>Date Of Birth</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="character" items="${characters}">
					<c:url var="updateLink" value="manage/updateform">
						<c:param name="id" value="${character.id}"/>
					</c:url>
					<tr>
						<td>
							<span class="custom-checkbox">
								<input type="checkbox" id="checkbox" name="delete" value="${character.id}">
								<label for="checkbox"></label>
							</span>
						</td>
						<td>${character.name}</td>
						<td>${character.realName}</td>
						<td>${character.category}</td>
						<td>${character.publisher}</td>
						<td>${character.dob}</td>
						<td>
							<a href="${updateLink}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
							<a href="manage/delete/${character.id}" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>