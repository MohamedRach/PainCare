<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eeeeee;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            display: flex;
            width: 800px;
            height: 400px;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        .left-side {
            flex: 1;
            padding: 16px;
        }

        .right-side {
            flex: 1;
            background: linear-gradient(to bottom, #fa889b, #eb95a8);
            color: #ffffff;
            display: flex;
            align-items: center;
            justify-content: center;
        }


        .form-container {
            width: 200px;
            margin: 0 auto;
        }

        .left-side h1 {
            text-align: center; /* Ajout de cette propriété pour centrer le texte */
            margin-bottom: 16px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input {
            margin-bottom: 16px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background: linear-gradient(to bottom, #c0ece8, #ffffff);
        }

        button {
            padding: 8px;
            color: #ffffff;
            background-color: #eb95a8;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            transition-duration: 0.4s;
        }

        button:hover {
            background-color: #a86bf4;
        }

        a {
            color: #000;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .signin {
            max-width: 320px;
            display: flex;
            padding: 0.5rem 1.4rem;
            font-size: 0.875rem;
            line-height: 1.25rem;
            font-weight: 700;
            text-align: center;
            font-family: "Montserrat", sans-serif;
            vertical-align: middle;
            align-items: center;
            border-radius: 0.5rem;
            border: 1px solid rgba(255, 255, 255, 0.25);
            gap: 0.75rem;
            color: black;
            background-color: white;
            cursor: pointer;
            transition: all 0.25s cubic-bezier(0, 0.87, 0.12, 1);
            margin: 16px auto; /* Ajustez cette valeur selon vos besoins */
        }

        .signin:hover {
            transform: scale(1.025);
        }

        .signin:active {
            transform: scale(0.975);
        }

        .signin svg {
            height: 24px;
            width: auto;
        }

        .local-login-button {
            width: 100px;
            margin: 0 auto; /* Ajustez cette valeur selon vos besoins */
        }

        .registration-message {
            text-align: center;
            margin-top: 16px;
        }
        </style>
</head>
<body>
<div class="container">
    <div class="left-side">
        <h1>Login</h1>
        <div class="form-container">
            <form method="post" action="/login">
                <input type="text" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Password" required>
                <button type="submit" class="local-login-button">Login</button>
            </form>
        </div>
        <!-- Bouton Sign in with Google -->
        <form action="/login" method="post">
            <input type="hidden" value="normal" name="type">
            <button type="submit" class="signin">
                <svg
                        viewBox="0 0 256 262"
                        preserveAspectRatio="xMidYMid"
                        xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                            d="M255.878 133.451c0-10.734-.871-18.567-2.756-26.69H130.55v48.448h71.947c-1.45 12.04-9.283 30.172-26.69 42.356l-.244 1.622 38.755 30.023 2.685.268c24.659-22.774 38.875-56.282 38.875-96.027"
                            fill="#4285F4"
                    ></path>
                    <path
                            d="M130.55 261.1c35.248 0 64.839-11.605 86.453-31.622l-41.196-31.913c-11.024 7.688-25.82 13.055-45.257 13.055-34.523 0-63.824-22.773-74.269-54.25l-1.531.13-40.298 31.187-.527 1.465C35.393 231.798 79.49 261.1 130.55 261.1"
                            fill="#34A853"
                    ></path>
                    <path
                            d="M56.281 156.37c-2.756-8.123-4.351-16.827-4.351-25.82 0-8.994 1.595-17.697 4.206-25.82l-.073-1.73L15.26 71.312l-1.335.635C5.077 89.644 0 109.517 0 130.55s5.077 40.905 13.925 58.602l42.356-32.782"
                            fill="#FBBC05"
                    ></path>
                    <path
                            d="M130.55 50.479c24.514 0 41.05 10.589 50.479 19.438l36.844-35.974C195.245 12.91 165.798 0 130.55 0 79.49 0 35.393 29.301 13.925 71.947l42.211 32.783c10.59-31.477 39.891-54.251 74.414-54.251"
                            fill="#EB4335"
                    ></path>
                </svg>
                Login with Google
            </button>
        </form>
        <!-- Message d'inscription -->
        <p class="registration-message">Vous n'avez pas de compte ? <a href="/signup" style="color: blue;">Inscrivez-vous</a>.</p>
    </div>
    <div class="right-side">
        <!-- Contenu à droite -->
        <img src="../assets/img/elements/b.png" alt="Logo" width="250" height="250">

    </div>
</div>
</body>
</html>
