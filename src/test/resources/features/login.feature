Feature: login de usuario
    Como usuario del sistema
    quiero iniciar sesion
    para poder acceder a mis funcionalidades

Background: 
    Given el navegador esta abierto
    And estoy en la pagina de login

Scenario:
    When ingreso usuario "admin" y contraseña "12345"
    And hago clic en el boton login
    Then debo ver el mensaje "Bienvenido admin"

Scenario:
    When ingreso usuario "admin" y contraseña "wrong"
    And hago clic en el boton login
    Then debo ver el mensaje "Credenciales invalidas"