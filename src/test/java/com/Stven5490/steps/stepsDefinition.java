package steps;

import io.cucumber.java.en.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.Stven5490.hooks.hooks;
import com.Stven5490.pages.loginPage;
import com.Stven5490.pages.homePage;
import com.Stven5490.pages.cartPage;
import com.Stven5490.pages.checkoutPage;

import static org.junit.Assert.assertEquals;

public class stepsDefinition {
    WebDriver driver = hooks.driver;
    loginPage login;
    homePage home;
    cartPage cart;
    checkoutPage checkout;

    @Given("el usuario está en la página de inicio")
    public void abrirPaginaInicio() {
        login = new loginPage(driver);
        // Ajusta tu método/propiedad real de URL
        home.cargarSitio("https://www.saucedemo.com/");
        throw new io.cucumber.java.PendingException();
    }

    @When("inicia sesión con usuario {string} y clave {string}")
    public void iniciarSesion(String user, String pass) {
        login.iniciarSesion(user, pass);
        throw new io.cucumber.java.PendingException();
    }

    @Then("debería redirigir a la URL {string}")
    public void validarUrl(String expected) {
        assertEquals(expected, driver.getCurrentUrl());
        throw new io.cucumber.java.PendingException();
    }
}
