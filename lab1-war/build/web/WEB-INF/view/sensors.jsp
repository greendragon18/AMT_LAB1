<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
    <title>Sensors</title>
  </head>
  <body>

    <form name="form_sensors" action="update" method="POST">

      <table>
      <tr>
        <th></th>
        <th>ID</th>
        <th>Description</th>
        <th>Type</th>
        <th></th>
      </tr>
      <c:forEach items="${sensors}" var="sensor">
        <tr>
          <td><input type="radio" name="id_sensor" value="${sensor.id}" /></td>
          <td><c:out value="${sensor.id}"/></td>
          <td><c:out value="${sensor.description}"/></td>
          <td><c:out value="${sensor.type}"/></td>
          <td><a href="delete?id=${sensor.id}">Supprimer</a></td>
        </tr>
      </c:forEach>
      </table>

    </form>

    <a href="new">New sensor</a>

  </body>
</html>