<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
<script
    src="https://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous">
</script>
<script> 
$(function(){
  $("#header1").load("userheader.html"); 
  $("#footer").load("footer.html"); 
});
</script> 
</head>
<body>
<div id="header1"></div>
<!-- Contact Start -->
            <!-- Contact Start -->
                <div class="contact-text" style="border:1px solid black" align="center">
                    <div class="p-lg-5 ps-lg-0">
                        <h1 class="text-primary">Registration</h1>
                        <form>
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="name" placeholder="Your Name" minlength=3 required>
                                        <label for="name">First Name</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="name" placeholder="Your Email" required> 
                                        <label for="email">Last Name</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="name" pattern="\d*" minlength=10 maxlength=10 required>
                                        <label for="email">Phone Number</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="email" class="form-control" id="email" placeholder="Your Email" required>
                                        <label for="email">Email ID</label>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="subject" placeholder="Subject">
                                        <label for="subject">Address</label>
                                    </div>
                                </div>
                                
                                <div class="col-12">
                                    <div class="form-floating">
                                        <textarea class="form-control" placeholder="Leave a message here" id="message" style="height: 100px" required></textarea>
                                        <label for="message">Availability</label>
                                    </div>
                                </div>
                                    <div class="form-floating">
                                       <label style="margin-top:-10px;">SIN</label>
                                       <input type="file" id="myFile" name="filename" required>
                                      </div>
                                    <div class="form-floating">
                                    
                                        <label style="margin-top:-10px;">Photo ID</label>
                                        <input type="file" id="myFile" name="filename" required>
                                        
                                </div>
                                <div class="form-floating">
                                    
                                      <label style="margin-top:-10px;">Study Permit</label>
                                      <input type="file" id="myFile" name="filename" required>
                                </div>
                                
                                <div class="col-12">
                                    <button class="btn btn-primary rounded-pill py-3 px-5" type="submit">Registration</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
          
    <!-- Contact End -->

                      

<div id="footer"></div>
</body>
</html>
