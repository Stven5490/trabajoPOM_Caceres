package com.Stven5490.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Stven5490.utils.claseBase;


public class checkoutPage extends claseBase {
    public checkoutPage(WebDriver driver){
        super(driver);
    }
    By byTextBoxFirstName = By.id("first-name");
    By byTextBoxLastName = By.id("last-name");
    By byTextBoxPostalCode = By.id("postal-code");
    By byBtnContinue = By.id("continue");
    By byBtnFinish = By.id("finish");
    By byTextThksPurchase = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    By byBtnBackHome = By.id("back-to-products");
    public void stepOne(String firstName, String lastName, String postalCode){
        System.out.println("Ingresando datos...");
        System.out.println("Ingresando nombre: " + firstName);
        agregarTexto(esperaExplicita(byTextBoxFirstName), firstName);
        System.out.println("Ingresando apellido: " + lastName);
        agregarTexto(esperaExplicita(byTextBoxLastName), lastName);
        System.out.println("Agregando codigo postal: " + postalCode);
        agregarTexto(esperaExplicita(byTextBoxPostalCode), postalCode);
        System.out.println("Continuando con la compra...");
        click(esperaExplicita(byBtnContinue));
    }
    public void stepTwo(){
        System.out.println("Finalizando compra...");
        scroller(driver, 0, 1000);
        click(esperaExplicita(byBtnFinish));
    }
    public String obtenerCompleteOrder(){
        return obtenerTexto(esperaExplicita(byTextThksPurchase));
    }
    public void checkoutComplete(){
        click(esperaExplicita(byBtnBackHome));
    }
}
