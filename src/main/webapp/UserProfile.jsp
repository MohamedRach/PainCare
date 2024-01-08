<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>


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
                <div class="formbold-main-wrapper">
                    <!-- Author: FormBold Team -->
                    <!-- Learn More: https://formbold.com -->
                    <div class="formbold-form-wrapper">
                        <div class="card mb-4 col-4 ml-4">
                            <form action="/test" method="post">
                                <div class="container-xxl flex-grow-1 container-p-y">

                                    <c:if test="${not empty user}">
                                        <div class="card mb-4">
                                            <div class="card-header d-flex justify-content-between align-items-center">
                                                <h5 class="mb-0">User Information</h5>
                                            </div>
                                            <div class="card-body">
                                                <table class="table">
                                                    <tr>
                                                        <th>Nom:</th>
                                                        <td>${user.nom}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Prenom:</th>-
                                                        <td>${user.prenom}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Email:</th>
                                                        <td>${user.email}</td>
                                                    </tr>
                                                    <!-- Add more fields as needed -->
                                                </table>
                                                <button type="button" class="btn btn-primary" onclick="redirectToUpdateProfile()">Modifier le profil</button>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>





                        </form>
                    </div>
                    </div>
                </div>
            </div>


                    <script>
                        const totalSteps = 15;
                        const formSubmitBtn = document.querySelector('.formbold-btn');
                        const formBackBtn = document.querySelector('.formbold-back-btn');
                        let currentStep = 1;

                        formSubmitBtn.addEventListener("click", function (event) {
                            console.log(currentStep)
                            event.preventDefault();

                            const currentStepForm = document.querySelector(".formbold-form-step-" + currentStep);
                            console.log(currentStepForm)
                            const nextStep = currentStep + 1;

                            if (currentStep < totalSteps) {
                                currentStepForm.classList.remove('active');

                                const nextStepForm = document.querySelector(".formbold-form-step-" + nextStep);
                                console.log(nextStepForm)
                                nextStepForm.classList.add('active');

                                formBackBtn.classList.add('active');
                                currentStep++;
                                formSubmitBtn.textContent = (nextStep === totalSteps) ? 'Submit' : 'Next';
                            } else {
                                // You've reached the last step, submit the form
                                document.querySelector('form').submit();
                            }
                        });

                        formBackBtn.addEventListener("click", function (event) {
                            event.preventDefault();
                            console.log(currentStep)
                            const currentStepForm = document.querySelector(".formbold-form-step-" + currentStep);
                            const prevStep = currentStep - 1;

                            if (currentStep > 2) {
                                const prevStepForm = document.querySelector(".formbold-form-step-" + prevStep);

                                currentStepForm.classList.remove('active');
                                prevStepForm.classList.add('active');
                                currentStep--;


                            } else {
                                const prevStepForm = document.querySelector(".formbold-form-step-" + prevStep);

                                currentStepForm.classList.remove('active');
                                prevStepForm.classList.add('active');
                                currentStep--;
                                formBackBtn.classList.remove('active');
                                formSubmitBtn.textContent = 'Next';
                            }
                        });


                    </script>

</body>
</html>
