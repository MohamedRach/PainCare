
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Dashboard</title>
  <!-- Favicon -->


  <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com" />
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
  <link
          href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
          rel="stylesheet"
  />

  <!-- Icons. Uncomment required icon fonts -->
  <link rel="stylesheet" href="./assets/vendor/fonts/boxicons.css" />
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
          integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
          crossorigin="anonymous"
          referrerpolicy="no-referrer"
  />
  <!-- Core CSS -->
  <link rel="stylesheet" href="./assets/vendor/css/core.css" class="template-customizer-core-css" />
  <link rel="stylesheet" href="./assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
  <link rel="stylesheet" href="./assets/css/demo.css" />
  <link rel="stylesheet" href="./assets/vendor/css/calendar.css" />





  <!-- Page CSS -->



  <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
  <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
  <script src="./assets/js/config.js"></script>
  <style>
    .col-lg-4 {
      flex: 0 0 auto;
      width: 30%;
    }
  </style>
</head>
<body>
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
        <li class="menu-item">
          <a href="/blog" class="menu-link ">
            <i class='menu-icon tf-icons bx bxl-blogger' ></i>
          </a>
        </li>
        <li class="menu-item active">
          <a href="/calendar" class="menu-link">
            <i class="menu-icon tf-icons bx bx-calendar"></i>
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
      <div class="content-wrapper">
        <!-- Content -->
        <div class="container">
          <div class="left">
            <div class="calendar">
              <div class="month">
                <i class="fas fa-angle-left prev"></i>
                <div class="date">december 2015</div>
                <i class="fas fa-angle-right next"></i>
              </div>
              <div class="weekdays">
                <div>Sun</div>
                <div>Mon</div>
                <div>Tue</div>
                <div>Wed</div>
                <div>Thu</div>
                <div>Fri</div>
                <div>Sat</div>
              </div>
              <div class="days"></div>
              <div class="goto-today">
                <div class="goto">
                  <input type="text" placeholder="mm/yyyy" class="date-input" />
                  <button class="goto-btn">Go</button>
                </div>
                <button class="today-btn">Today</button>
              </div>
            </div>
          </div>
          <div class="right">
            <div class="today-date">
              <div class="event-day">wed</div>
              <div class="event-date">12th december 2022</div>
            </div>
            <div class="events"></div>
            <div class="add-event-wrapper">
              <div class="add-event-header">
                <div class="title">Add Event</div>
                <i class="fas fa-times close"></i>
              </div>
              <div class="add-event-body">
                <form onsubmit="submitForm()">
                <div class="add-event-input">
                  <input type="text" placeholder="Event Name" class="event-name" name="eventName" />
                </div>
                <div class="add-event-input">
                  <input
                          type="text"
                          placeholder="Event Time From"
                          class="event-time-from"
                          name="timeFrom"
                  />
                </div>
                <div class="add-event-input">
                  <input
                          type="text"
                          placeholder="Event Time To"
                          class="event-time-to"
                          name="timeTo"
                  />
                </div>
                  <div class="add-event-footer">
                    <button type="submit" class="add-event-btn">Add Event</button>
                  </div>
                </form>
              </div>

            </div>
          </div>
          <button class="add-event">
            Add Event
          </button>
        </div>



      </div>


    </div>
  </div>
</div>
<!-- Core JS -->
<!-- build:js assets/vendor/js/core.js -->

<script src="./assets/vendor/js/bootstrap.js"></script>

<script src="./assets/vendor/js/menu.js"></script>
<!-- endbuild -->



<!-- Main JS -->
<script src="./assets/js/main.js"></script>
<script src="./assets/js/script.js"></script>
<!-- Page JS -->
<!--<script src="./assets/js/dashboards-analytics.js"></script>-->

<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>

</body>
</html>
