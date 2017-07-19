<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>View Product</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>${message}</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product_upload.name}<br/>
        Description: ${product_upload.description}<br/>
        Price: $${product_upload.price}
    </p>
</div>
</body>
</html>