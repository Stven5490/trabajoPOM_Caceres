Feature: Login y compras en el sistema

    Scenario: CP001 - Iniciar sesión correctamente
        Given el usuario está en la página de inicio
        When inicia sesión con usuario "standard_user" y clave "secret_sauce"
        Then debería redirigir a la URL "https://www.saucedemo.com/inventory.html"

    Scenario: CP002 - Login con usuario bloqueado
        Given el usuario está en la página de inicio
        When inicia sesión con usuario "locked_out_user" y clave "secret_sauce"
        Then debería mostrar el mensaje de bloqueo "Epic sadface: Sorry, this user has been locked out."

    Scenario: CP003 - Login con credenciales inválidas
        Given el usuario está en la página de inicio
        When inicia sesión con usuario "wrong_user" y clave "wrong_pass"
        Then debería mostrar el mensaje de error "Epic sadface: Username and password do not match any user in this service"

    Scenario: CP004 - Comprar artículos
        Given el usuario está en la página de inicio
        And inicia sesión con usuario "standard_user" y clave "secret_sauce"
        When agrega al carrito los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light"
        And completa el checkout con nombre "Juan", apellido "Pérez" y código postal "12345"
        Then debería ver el mensaje de compra exitosa "Thank you for your order!"

    Scenario: CP005 - Remover artículos antes de comprar
        Given el usuario está en la página de inicio
        And inicia sesión con usuario "standard_user" y clave "secret_sauce"
        When agrega al carrito los productos "Sauce Labs Backpack" y "Sauce Labs Bike Light"
        And remueve el producto "Sauce Labs Bike Light"
        And completa el checkout con nombre "Juan", apellido "Pérez" y código postal "12345"
        Then debería ver el mensaje de compra exitosa "Thank you for your order!"
