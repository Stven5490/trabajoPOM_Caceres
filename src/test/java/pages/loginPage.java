package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.claseBase;

public class loginPage extends claseBase {
    public loginPage(WebDriver driver){
        super(driver);
        maximizarBrowser();
    }
    By byTxtBoxUserName = By.id("user-name");
    By byTxtBoxPassword = By.id("password");
    By byBtnLogin = By.id("login-button");
    By byTxtLockedLogin = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By byTxtErrorLogin = byTxtLockedLogin;
    public void iniciarSesion(String userName, String passWord){
        System.out.println("Ingresando datos del usuario");
        agregarTexto(esperaExplicita(byTxtBoxUserName), userName);
        System.out.println("Ingresando clave");
        agregarTexto(esperaExplicita(byTxtBoxPassword), passWord);
        click(esperaExplicita(byBtnLogin));
    }
    public String obtenerBlockedLogin(){
        return obtenerTexto(esperaExplicita(byTxtLockedLogin));
    }
    public String obtenerErrorLogin(){
        return obtenerTexto(esperaExplicita(byTxtErrorLogin));
    }
}
