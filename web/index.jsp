<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 07.08.12
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
      <h1>File Upload with Jersey</h1>

      <form action="http://localhost:8080/rest/uploadZip" method="post" enctype="multipart/form-data">

          <p>
              Select a file : <input type="file" name="zipFile" size="45" />
          </p>

          <input type="submit" value="Upload It" />
      </form>
  </body>
</html>