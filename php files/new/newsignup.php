<?PHP

include("connection.php");

if(isset($_POST['name']) && isset($_POST['email'])&& isset($_POST['password'])){
	$name=$_POST["name"];
    $email=$_POST["email"];
    $password=$_POST["password"];
    
	$result = mysqli_query($conn, "SELECT email FROM customers WHERE email = '".$email."'");	
	if(mysqli_num_rows($result) > 0)
	{	
		echo "email exist";
		exit;
	}			
	else
	{	
      $query="INSERT INTO auth(name,email,password)VALUES('$name','$email','$password')";

      $data=mysqli_query($conn,$query);
 
   if ($data) {

              echo "success";
           

         } else {

         echo "failure"

         }

		exit;
	}	
}				

?>