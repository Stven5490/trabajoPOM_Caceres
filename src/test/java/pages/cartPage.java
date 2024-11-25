package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.claseBase;

import java.util.HashMap;
import java.util.Map;

public class cartPage extends claseBase {
    public cartPage(WebDriver driver){
        super(driver);
    }
    By byBtnRemoveBackPack = By.id("remove-sauce-labs-fleece-jacket");
    By byBtnRemoveBikeLight = By.id("remove-sauce-labs-bike-light");
    By byBtnRemoveTShirt = By.id("remove-sauce-labs-bolt-t-shirt");
    By byBtnRemoveJacket = By.id("remove-sauce-labs-fleece-jacket");
    By byBtnRemoveOnesie = By.id("remove-sauce-labs-onesie");
    By byBtnRemoveShirt = By.id("remove-test.allthethings()-t-shirt-(red)");
    By byBtnCheckout = By.name("checkout");
    public void removerArticulo(String articulo){
        Map<String, By> articuloLocalizador = new HashMap<>();
        articuloLocalizador.put("Mochila", byBtnRemoveBackPack);
        articuloLocalizador.put("Luz bicicleta", byBtnRemoveBikeLight);
        articuloLocalizador.put("Polera negra", byBtnRemoveTShirt);
        articuloLocalizador.put("Poleron", byBtnRemoveJacket);
        articuloLocalizador.put("Body", byBtnRemoveOnesie);
        articuloLocalizador.put("Polera Roja", byBtnRemoveShirt);
        By localizador = articuloLocalizador.get(articulo);
        if (localizador != null){
            System.out.println("Removiendo del carrito: " + articulo);
            click(esperaExplicita(localizador));
        } else {
            System.err.println("Elemento seleccionado no existe: " + articulo);
        }
    }
    public void irCheckout(){
        System.out.println("Dirigiendo al Checkout");
        scroller(driver, 0, 1000);
        click(esperaExplicita(byBtnCheckout));
    }
}
