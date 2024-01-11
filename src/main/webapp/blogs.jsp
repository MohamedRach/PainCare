<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/7/2024
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.paincare.Bean.blogBean" %>
<html>
<head>
    <title>Blogs</title>


    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet"
    />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="./assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="./assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="./assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="./assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
    <script src="./assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="./assets/js/config.js"></script>
    <style>
        .blogs {
            display: flex;
            flex-direction: row;
            column-gap: 50px;
            margin-left: 25px;
            flex-wrap: wrap;

        }
        .blog {
            margin-top: 20px;
            width: 30%;
        }
        .butt{ width:10%; color: white; margin-left: 29px; margin-top: 20px;}
        .link {
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
<% ArrayList<blogBean> blogs = (ArrayList<blogBean>) request.getAttribute("blogs");%>
<div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
        <!-- Menu -->

        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
            <div class="app-brand demo">

            </div>

            <div class="menu-inner-shadow"></div>

            <ul class="menu-inner py-1">
                <!-- Dashboard -->
                <li class="menu-item">
                    <a href="/dashboard" class="menu-link">
                        <i class="menu-icon tf-icons bx bx-home-circle"></i>
                    </a>
                </li>

                <!-- Layouts -->
                <li class="menu-item">
                    <a href="/test" class="menu-link ">
                        <i class='menu-icon tf-icons bx bx-health'></i>
                    </a>
                </li>
                <li class="menu-item ">
                    <a href="/pain" class="menu-link ">
                        <i class='menu-icon tf-icons bx bxs-clinic'></i>
                    </a>
                </li>
                <li class="menu-item active">
                    <a href="/blog" class="menu-link ">
                        <i class='menu-icon tf-icons bx bxl-blogger' ></i>
                    </a>
                </li>


            </ul>
        </aside>
        <div class="layout-page">
        <nav
                class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                id="layout-navbar"
        >
            <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
                <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                    <i class="bx bx-menu bx-sm"></i>
                </a>
            </div>

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
                <!-- Search -->
                <div class="navbar-nav align-items-center">

                </div>
                <!-- /Search -->

                <ul class="navbar-nav flex-row align-items-center ms-auto">
                    <!-- Place this tag where you want the button to render. -->


                    <!-- User -->
                    <li class="nav-item navbar-dropdown dropdown-user dropdown">
                        <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                            <div class="avatar avatar-online">
                                <i class="menu-icon tf-icons bx bxs-user"></i>
                            </div>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li>
                                <a class="dropdown-item" href="#">
                                    <div class="d-flex">
                                        <div class="flex-shrink-0 me-3">
                                            <div class="avatar avatar-online">
                                                <i class="menu-icon tf-icons bx bxs-user"></i>
                                            </div>
                                        </div>

                                    </div>
                                </a>
                            </li>
                            <li>
                                <div class="dropdown-divider"></div>
                            </li>
                            <li>
                                <a class="dropdown-item" href="user-profile"> <!-- Ajoutez l'URL de redirection -->
                                    <i class="bx bx-user me-2"></i>
                                    <span class="align-middle">My Profile</span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="/logout">
                                    <i class="bx bx-power-off me-2"></i>
                                    <span class="align-middle">Log Out</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!--/ User -->
                </ul>
            </div>
        </nav>
            <button class="btn btn-primary butt"><a class="link" href="/addblog">Add blog</a></button>
            <div class="blogs">
                <%
                    // Your array


                    // Loop to display array elements
                    for (blogBean blog : blogs) {
                %>
            <div class="blog">
                <div class="card">
                    <img class="blog-image" src="./posts/1704563365382.png" alt="Blog Image">

                    <div class="card-body">

                        <h5 class="card-title"><%= blog.getTitle()%></h5>


                        <%
                            String description = blog.getDescription();
                            String truncatedDescription = (description.length() > 100) ? description.substring(0, 100) + "..." : description;
                        %>
                        <p class="card-text"><%= truncatedDescription %></p>

                    </div>

                    <div class="card-body">
                        <a href="/blog?id=<%=blog.getId()%>">read more</a>


                    </div>
                </div>
            </div>
             <% }%>



            </div>
        </div>
    </div>
</div>
<script src="./assets/vendor/libs/jquery/jquery.js"></script>
<script src="./assets/vendor/libs/popper/popper.js"></script>
<script src="./assets/vendor/js/bootstrap.js"></script>
<script src="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="./assets/vendor/js/menu.js"></script>
<script src="./assets/vendor/js/menu.js"></script>
<!-- endbuild -->

<!-- Vendors JS -->


<!-- Main JS -->
<script src="./assets/js/main.js"></script>

<!-- Page JS -->
<!--<script src="./assets/js/dashboards-analytics.js"></script>-->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
