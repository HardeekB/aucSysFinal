
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Auction Site</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:300;400;600;700;800&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="/css/bidderDashboard.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="wrapper">
            <div class="sidebar">
                <div class="sidebar-text d-flex flex-column h-100 justify-content-center text-center">
                    <!-- <img  src="/img/sik2.jpeg" alt="Image"> -->
                    <img  src="https://media.istockphoto.com/photos/gavel-on-auction-word-picture-id917901978?k=20&m=917901978&s=612x612&w=0&h=NULGu8-bVpy28gbW6AZbZlEVra-Q4s2rg607emPfkCs=" alt="Image">
                   <!--  for image border => class="mx-auto d-block w-75 bg-primary img-fluid rounded-circle mb-4 p-3" -->
                    <h1 class="font-weight-bold">Auctionsite</h1>
                    <p class="mb-4">
                    “Auction System” is a web-based application which will help users to buy or sell item; they can trade anything they want
                    by posting ad. This application will allow users to post their products for auction. bidder can register and can bid for
                    any available product. An online auction is an auction which is held over the internet. It is a popular method for
                    buying and selling products and services. Online Auction System helps customer to sell and buy product in best price.
                    
                    </p>
                    
                    <a href="/auctionCatalog" style="background-color:green" class="btn btn-lg btn-block btn-primary mt-auto">Add Auction Events</a>
                    <!-- <a href="/auctioneer/logout" style="background-color:red" class="btn btn-lg btn-block btn-primary mt-auto">Log Out</a> -->
                </div>
                <div class="sidebar-icon d-flex flex-column h-100 justify-content-center text-right">
                    <i class="fas fa-2x fa-angle-double-right text-primary"></i>
                </div>
            </div>
            <div class="content">
            
                <!-- Navbar Start -->
                <div class="container p-0">
                    <nav class="navbar navbar-expand-lg bg-secondary navbar-dark">
                        <a href="" class="navbar-brand d-block d-lg-none" style="width: 750px;">Home</a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav m-auto">
                                <a href="index.html" class="nav-item nav-link active"></a>
                                <!-- <a href="about.jsp" class="nav-item nav-link">About</a> -->
                                <a href="/auctioneer/logout" class="nav-item nav-link">Logout</a>
                            </div>
                        </div>
                    </nav>
                </div>
                <!-- Navbar End -->
                
               
                
                
                <!-- Blog List Start -->
                
                   <!--  for main.......... -->
                
                <c:forEach var="auction" items="${auctionList}">
                <div class="container bg-white pt-7" style="margin-left: 13px; margin-top: 7px; width: 96.6%;">
                    <div class="row blog-item px-3 pb-5">
                        <!-- <br><br> -->
                        <div class="col-md-5">
                            
                            <img src="/auctionimage/${auction.autionImage}" class="img-fluid mb-4 mb-md-0" alt="..." style="margin-top: 10px;">
                        </div>
                        <div class="col-md-5">
                            <!-- <br><br> -->
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold" style="margin-top: 4px;">${auction.eventName}</h3>
                            
                            <div class="d-flex mb-3">
                            	
                                <small class="mr-2 text-muted"><i class="fa fa-calendar"></i> ${auction.startDate} &nbsp &nbsp</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock-o"></i>${auction.startTime} &nbsp &nbsp</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock-o"></i>${auction.endTime} &nbsp &nbsp</small>
                            </div>
                            
                            <p>
                                <i class="fa fa-mobile " style="font-size:20px"></i>&nbsp;${auction.contact}
                            </p>
                            
                            <a class="btn btn-link p-0" href="/auctioneer/event/${auction.event_id}">Enter Into Auction <i class="fa fa-angle-right"></i></a>
                             <%-- <a href="/bidder/event/${auction.event_id}" class="btn btn-primary">Go somewhere</a> --%>
                        </div>
                    </div>
                    
                    
  
                </div>
                </c:forEach>
                
                
                

            </div>
        </div>
        
        
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/lib/easing/easing.min.js"></script>
        <script src="/lib/waypoints/waypoints.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="/mail/jqBootstrapValidation.min.js"></script>
        <script src="/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="/js/main.js"></script>
    </body>
</html>

