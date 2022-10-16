<script type="text/javascript">  
function matchpass(){  
var firstpassword=document.f1.password.value;  
var secondpassword=document.f1.password2.value;  
  
if(firstpassword==secondpassword){  
return true;  
}  
else{  
alert("password must be same!");  
return false;  
}  
}  
</script>  
  
<form name="f1" action="register.jsp" onsubmit="return matchpass()">  
Password:<input type="password" name="password" /><br/>  
Re-enter Password:<input type="password" name="password2"/><br/>  
<input type="submit">  
</form>  
Test it Now
JavaScript Number Validation
Let's validate the textfield for numeric value only. Here, we are using isNaN() function.

<script>  
function validate(){  
var num=document.myform.num.value;  
if (isNaN(num)){  
  document.getElementById("numloc").innerHTML="Enter Numeric value only";  
  return false;  
}else{  
  return true;  
  }  
}  
</script>  
<form name="myform" onsubmit="return validate()" >  
Number: <input type="text" name="num"><span id="numloc"></span><br/>  
<input type="submit" value="submit">  
</form>  
