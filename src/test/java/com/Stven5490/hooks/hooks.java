package com.Stven5490.hooks;

import io.cucumber.java.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks {

    public static WebDriver driver;
    private int stepIndex;

    @Before
    public void setUp(Scenario scenario) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Reinicia contador de pasos por escenario
        stepIndex = 0;
    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario) {
        try {
            if (driver instanceof TakesScreenshot) {
                byte[] ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                stepIndex++;
                // El nombre es opcional, pero ayuda a identificar el orden
                scenario.attach(ss, "image/png", "step-" + stepIndex);
            }
        } catch (WebDriverException e) {
            // Si falla la captura (p.ej. ventana cerrada), no romper el test
            scenario.log("No se pudo tomar screenshot en el paso " + stepIndex + ": " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
