<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->  

<petclinic:layout pageName="home">
    <h2><c:out value="Create Product"></c:out></h2>
    <div class="row">
        <form:form modelAttribute="product" class="form-horizontal">
        	<petclinic:inputField label="Name" name="name"></petclinic:inputField>
        	<petclinic:inputField label="Price" name="price"></petclinic:inputField>
        	<div class="row">
        	    <form:select path="productType">
        			<c:forEach items="${ producttypes }" var="pt">
        				<form:option value="${ pt }"><c:out value="${ pt.getName() }"></c:out></form:option>
        			</c:forEach>
        		</form:select>
        	</div>
        	<div class="row">
					<form:button class="btn btn-secondary" type="submit">Confirm Product</form:button>        	
        	</div>
        </form:form>
    </div>
</petclinic:layout>
