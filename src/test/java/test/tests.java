package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.cartPage;
import pages.checkoutPage;
import pages.homePage;
import pages.loginPage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.dataDriven.getTestData;
import static utils.propertiesDriven.obtenerProperties;

public class tests {
    private WebDriver driver;
    ArrayList<String> data;
    private loginPage login;
    private homePage home;
    private cartPage cart;
    private checkoutPage checkout;
    public tests(){}

    @BeforeEach
    public void preCondiciones(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        data = new ArrayList<String>();
        login = new loginPage(driver);
        home = new homePage(driver);
        cart = new cartPage(driver);
        checkout = new checkoutPage(driver);
        home.cargarSitio(obtenerProperties("url"));
    }
    @AfterEach
    public void posCondiciones(){
        login.cerrarBrowser();
    }
    @Test
    public void CP001_iniciarSesion(){
        data = getTestData(obtenerProperties("CP001"));
        login.ejecutandoCaso(data.get(0));
        login.iniciarSesion(data.get(1), data.get(2));
        assertEquals(driver.getCurrentUrl(), data.get(3), "Usuario o contraseña invalida");
    }
    @Test
    public void CP002_lockedLogin(){
        data = getTestData(obtenerProperties("CP002"));
        login.ejecutandoCaso(data.get(0));
        login.iniciarSesion(data.get(1), data.get(2));
        assertEquals(data.get(3), login.obtenerBlockedLogin(), "Usuario desbloqueado");
    }
    @Test
    public void CP003_errorLogin(){
        data = getTestData(obtenerProperties("CP003"));
        login.ejecutandoCaso(data.get(0));
        login.iniciarSesion(data.get(1), data.get(2));
        assertEquals(data.get(3), login.obtenerErrorLogin(), "Usuario o contraseña valido");
    }
    @Test
    public void CP004_comprarArticulos(){
        CP001_iniciarSesion();
        data = getTestData(obtenerProperties("CP004"));
        login.ejecutandoCaso(data.get(0));
        home.agregarElemento(data.get(4));
        home.agregarElemento(data.get(5));
        home.irCarrito();
        cart.irCheckout();
        checkout.stepOne(data.get(6), data.get(7), data.get(8));
        checkout.stepTwo();
        assertEquals(data.get(9), checkout.obtenerCompleteOrder());
    }
    @Test
    public void CP005_remueveArticulos(){
        CP001_iniciarSesion();
        data = getTestData(obtenerProperties("CP005"));
        login.ejecutandoCaso(data.get(0));
        home.agregarElemento(data.get(4));
        home.agregarElemento(data.get(5));
        home.irCarrito();
        cart.removerArticulo(data.get(5));
        cart.irCheckout();
        checkout.stepOne(data.get(6), data.get(7), data.get(8));
        checkout.stepTwo();
        assertEquals(data.get(9), checkout.obtenerCompleteOrder());
        checkout.checkoutComplete();
    }
}
