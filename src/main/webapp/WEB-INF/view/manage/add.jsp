<%@ include file="../header.jsp" %>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Manage Comics Characters</h2>
					</div>
					<div class="col-sm-6">
						<a href="${pageContext.request.contextPath}" class="btn btn-danger"><span>Cancel</span></a>						
					</div>
				</div>
			</div>
			<form:form modelAttribute="character" action="add">
					<div class="form-group">
						<label>Name</label>
						<form:input path="name" class="form-control"/>
						<form:errors path="name" cssClass="error"/>
					</div>
					<div class="form-group">
						<label>Real Name</label> 
						<form:input path="realName" class="form-control"/>
						<form:errors path="realName" cssClass="error"/>
					</div>
					<div class="form-group">
						<label>Category</label>
						<form:select path="category" class="form-control">
							<form:options items="${Category.values()}" />			
						</form:select>
					</div>
					<div class="form-group">
						<label>Publisher</label>
						<form:select path="publisher" class="form-control">
							<form:options items="${Publisher.values()}" />			
						</form:select>
					</div>
					<div class="form-group">
						<label>Date of Birth</label> 
						<form:input path="dob" class="form-control" type="date"/>
						<form:errors path="dob" cssClass="error"/>
					</div>
					<button type="reset" class="btn btn-default">Reset</button> 
					<button type="submit" class="btn btn-info">Save</button>
			</form:form>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>
