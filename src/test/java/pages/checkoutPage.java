package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.claseBase;

public class checkoutPage extends claseBase {
    public checkoutPage(WebDriver driver){
        super(driver);
    }
    By byTextBoxFirstName = By.id("first-name");
    By byTextBoxLastName = By.id("last-name");
    By byTextBoxPostalCode = By.id("postal-code");
    By byBtnContinue = By.id("continue");
    By byTextSauceCard = By.xpath("\"//*[@id=\\\"checkout_summary_container\\\"]/div/div[2]/div[2]\"");
    By byTextSubTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    By byTextTax = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    By byTextTotal = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
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
    public void stepTwo(String creditCard, String itemTotal, String tax, String total){
        Assertions.assertEquals(obtenerTexto(esperaExplicita(byTextSauceCard)), creditCard);
        Assertions.assertEquals(obtenerTexto(esperaExplicita(byTextSubTotal)), itemTotal);
        Assertions.assertEquals(obtenerTexto(esperaExplicita(byTextTax)), tax);
        Assertions.assertEquals(obtenerTexto(esperaExplicita(byTextTotal)), total);
        click(esperaExplicita(byBtnFinish));
    }
    public String obtenerCompleteOrder(){
        return obtenerTexto(esperaExplicita(byTextThksPurchase));
    }
    public void checkoutComplete(){
        click(esperaExplicita(byBtnBackHome));
    }
}
