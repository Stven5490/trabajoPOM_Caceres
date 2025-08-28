package com.Stven5490.steps;

import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import com.Stven5490.hooks.*;

public class loginSteps {
    WebDriver driver = hooks.driver;

    @Given("el navegador esta abierto")
    public void abrirNavegador(){

    }

    @Given("estoy en la pagina de login")
    public void irPaginaLogin(){
        driver.get("http://localhost:8080/login");
    }

    @When("ingreso  usuario {string} y contraseña {string}")
    public void ingresarCredenciales(String user, String pass) {
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
    }

    @When("hago clic en el boton de login")
    public void clickBotonLogin() {
        driver.findElement(By.id("btnLogin")).click();
    }

    @Then("debo ver el mensaje {string}")
    public void validarMensaje(String mensajeEsperado) {
        String mensaje = driver.findElement(By.id("mensaje")).getText();
        assertEquals(mensajeEsperado, mensaje);
    }
}