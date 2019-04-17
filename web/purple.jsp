<html>
<head>
  <title>The Oracle of Fortune</title>
</head>
<body>
  <h3>Guess Your Fate:</h3>
  <form method="get">
    <input type="text" name="inputNumber">
  </form>
  
  <%    int num = Integer.parseInt(request.getParameter("inputNumber"));   
            double num2 = Math.random();
          
  
    %>
  
  <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
       
</body>
</html>