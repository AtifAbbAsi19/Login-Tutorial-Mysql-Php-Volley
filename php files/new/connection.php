<?php

$server_name = "localhost"; //servername
$user_name = "root"; //username
$password = ""; //password
$db= 'androidtesting'; //database name
$conn = mysqli_connect($server_name, $user_name, $password,$db);

if(!$conn){


echo "Failed to connect to MySQL: " . mysqli_connect_error();
	die("Error Connection");
}else{

echo "success";

}

?>