package com.Stven5490.steps;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;
import pages.loginPage;

import utils.propertiesDriven;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import com.Stven5490.hooks.hooks;

public class stepsDefinition {
    WebDriver driver = hooks.driver;
    loginPage login;
    homePage home;
    cartPage cart;
    checkoutPage checkout;
    ArrayList<String> data;

    @Given("el usuario esta en la pagina de inicio")
    public void abrirPaginaInicio() {
        login = new loginPage(driver);
        home = new homePage(driver);
        cart = new cartPage(driver);
        checkout = new checkoutPage(driver);
        home.cargarSitio(propertiesDriven.obtenerProperties("url"));
    }

    @When("inicia sesion con usuario {string} y clave {string}")
    public void iniciarSesion(String usuario, String clave) {
        login.iniciarSesion(usuario, clave);
    }

    @Then("deberia redirigir a la URL {string}")
    public void validarUrl(String urlEsperada) {
        assertEquals(urlEsperada, driver.getCurrentUrl());
    }

    @Then("deberia mostrar el mensaje de bloqueo {string}")
    public void validarMensajeBloqueo(String mensajeEsperado) {
        assertEquals(mensajeEsperado, login.obtenerBlockedLogin());
    }

    @Then("deberia mostrar el mensaje de error {string}")
    public void validarMensajeError(String mensajeEsperado) {
        assertEquals(mensajeEsperado, login.obtenerErrorLogin());
    }

    @When("agrega al carrito los productos {string} y {string}")
    public void agregarProductos(String producto1, String producto2) {
        home.agregarElemento(producto1);
        home.agregarElemento(producto2);
        home.irCarrito();
    }

    @When("completa el checkout con nombre {string}, apellido {string} y codigo postal {string}")
    public void completarCheckout(String nombre, String apellido, String cp) {
        cart.irCheckout();
        checkout.stepOne(nombre, apellido, cp);
        checkout.stepTwo();
    }

    @Then("deberia ver el mensaje de compra exitosa {string}")
    public void validarCompraExitosa(String mensajeEsperado) {
        assertEquals(mensajeEsperado, checkout.obtenerCompleteOrder());
    }
}
