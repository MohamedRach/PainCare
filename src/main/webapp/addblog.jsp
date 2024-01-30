<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Blog</title>
    <!-- Favicon -->


    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet" />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="./assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="./assets/vendor/css/core.css" class="template-customizer-core-css" />
    <link rel="stylesheet" href="./assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="./assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet" href="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
    <link rel="stylesheet" href="./assets/vendor/libs/apex-charts/apex-charts.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="./assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="./assets/js/config.js"></script>
    <script>
        function redirectToUpdateProfile() {
            window.location.href = "/Update-user-profile";
        }
    </script>
    <script>
        function previewImage() {
            var input = document.getElementById('image');
            var preview = document.getElementById('imagePreview');
            var file = input.files[0];
            var reader = new FileReader();

            reader.onload = function(e) {
                preview.src = e.target.result;
                preview.style.display = 'block';
            };

            reader.readAsDataURL(file);
        }
    </script>
    <style>
        .form-group {
            display: flex;
            flex-direction: column;
            margin-bottom: 10px;
        }

        .form-group label {
            margin-bottom: 0; /* Remove margin-bottom for labels */
        }

        .form-group input,
        .form-group textarea {
            padding: 5px;
            margin: 0;
            box-sizing: border-box;
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
                <li class="menu-item active">
                    <a href="/blog" class="menu-link ">
                        <i class='menu-icon tf-icons bx bxl-blogger' ></i>
                    </a>
                </li>
                <li class="menu-item">
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
            <div class="layout-wrapper layout-content-navbar">
                <div class="layout-container">
                    <!-- Menu -->
                    <!-- Ajoutez ici le code du menu si nécessaire -->

                    <div class="layout-page">
                        <!-- Navbar -->
                        <!-- Ajoutez ici le code de la barre de navigation si nécessaire -->



                        <div class="content-wrapper">
                            <!-- Content -->
                            <div class="container">
                                <div class="col-md-8 offset-2 col-xm-8 col-sm-8">
                                    <div class="card my-5">
                                        <div class="card-header">
                                            <span>Blog</span>
                                        </div>
                                        <div class="card-body">
                                            <form action="addblog" method="post" enctype="multipart/form-data" >
                                                <div class="form-group">
                                                    <label for="blogTitle">Blog Title:</label>
                                                    <input type="text" id="blogTitle" name="title" placeholder="Enter blog title" required>
                                                </div>

                                                <div class="form-group">
                                                    <label for="blogDescription">Blog Description:</label>
                                                    <textarea id="blogDescription" name="description" rows="4" placeholder="Enter blog description" required></textarea>
                                                </div>
                                                <label for="image">Image:</label>
                                                <input type="file" id="image" name="image" accept="image/*" required onchange="previewImage()">
                                                <br>

                                                <img id="imagePreview" src="#" alt="Aper�u de l'image" style="display: none;">
                                                <br>


                                                <div class="form-group">
                                                    <input type="submit" value="Add Blog">
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="./assets/vendor/js/bootstrap.js"></script>
<script src="./assets/vendor/js/menu.js"></script>
</body>
</html>