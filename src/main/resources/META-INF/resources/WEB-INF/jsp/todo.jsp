 <%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>
		<div class="container">
		
		<hr>
		   <h1>Enter Workout Details </h1>
		 <form:form  method="post" modelAttribute="todo">
		 <fieldset class="mb-3">
		       <form:label path="description">Description</form:label>
		       Description: <form:input type="text"  path="description"  required="required"/>
		       <form:errors path="description"   cssClass="text-warning"></form:errors>
		  </fieldset>
		  
		  	 <fieldset class="mb-3">
		       <form:label path="targetDate">Target Date</form:label>
		       Description: <form:input type="text"  path="targetDate"  required="required"/>
		       <form:errors path="targetDate"   cssClass="text-warning"></form:errors>
		  </fieldset>
		  
		       <input type="submit" class="btn btn-success">
		       <form:input type="hidden"  path="id" />
		       <form:input type="hidden"  path="done" />
		 </form:form>
	           </div>
           <%@ include file="common/footer.jspf" %>
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'  
            });
            </script>
	 </body>
</html>
