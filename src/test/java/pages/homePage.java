package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.claseBase;

import java.util.HashMap;
import java.util.Map;

public class homePage extends claseBase {
    public homePage(WebDriver driver){
        super(driver);
    }
    By byBtnBagPack = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By byBtnBikeLight = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    By byBtnTshirt = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
    By byBtnJacked = By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    By byBtnOnesie = By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
    By byBtnShirt = By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");
    By byBtnCarrito = By.className("shopping_cart_link");
    By bybtnLogout = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    public void agregarElemento(String articulo){
        Map<String, By> articuloLocalizador = new HashMap<>();
        articuloLocalizador.put("Mochila", byBtnBagPack);
        articuloLocalizador.put("Luz bicicleta", byBtnBikeLight);
        articuloLocalizador.put("Polera Negra", byBtnTshirt);
        articuloLocalizador.put("Poleron", byBtnJacked);
        articuloLocalizador.put("Body", byBtnOnesie);
        articuloLocalizador.put("Polera Roja", byBtnShirt);
        By localizador = articuloLocalizador.get(articulo);
        if (localizador != null){
            System.out.println("Agregando al carrito, " + articulo);
            click(esperaExplicita(localizador));
        } else {
            System.err.println("Elemento seleccionado no existe: " + articulo);
        }
    }
    public void irCarrito(){
        System.out.println("Ingresando al carrito");
        click(esperaExplicita(byBtnCarrito));
    }
    public void logout(){
        click(esperaExplicita(bybtnLogout));
    }
}
