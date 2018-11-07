<%--
  Created by IntelliJ IDEA.
  User: chsiao
  Date: 10/4/18
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Jersey WebSocket</title>
  </head>
  <body>
  <table>
    <tr>
      <td colspan="2">
        <input type="text" id="username" placeholder="Username"/>
        <button type="button" onclick="connect();" >Connect</button>
      </td>
    </tr>
    <tr>
      <td>
        <textarea readonly="true" rows="10" cols="80" id="log"></textarea>
      </td>
    </tr>
    <tr>
      <td>
        <input type="text" size="51" id="msg" placeholder="Message"/>
        <button type="button" onclick="send();" >Send</button>
      </td>
    </tr>
  </table>
  </body>
  <script src="websocket.js"></script>
</html>
