<%@ page language="java" contentType="text/html; 
charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">
@import url(css/main.css);
</style>
</head>
<body>

	<div id="global">
		<form action="product_save3" method="post">
			<fieldset>
				<legend>Add a product(基于注解的Controller会被触发)</legend>
				<p>
					<label for="name">Product Name: </label> <input type="text"
						id="name" name="name" tabindex="1">
				</p>
				<p>
					<label for="description">Description: </label> <input type="text"
						id="description" name="description" tabindex="2">
				</p>
				<p>
					<label for="price">Price: </label> <input type="text" id="price"
						name="price" tabindex="3">
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form>
		<form action="product_save4" method="post">
			<fieldset>
				<legend>Add a product(基于注解的依赖注入Controller会被触发)</legend>
				<p>
					<label for="name">Product Name: </label> <input type="text"
						id="name" name="name" tabindex="1">
				</p>
				<p>
					<label for="description">Description: </label> <input type="text"
						id="description" name="description" tabindex="2">
				</p>
				<p>
					<label for="price">Price: </label> <input type="text" id="price"
						name="price" tabindex="3">
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form>
	</div>
</body>
</html>
