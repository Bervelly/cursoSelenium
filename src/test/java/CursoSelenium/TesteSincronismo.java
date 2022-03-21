package CursoSelenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TesteSincronismo {

        private WebDriver driver;
        private DSL dsl;


    @Before
    public void inicializando() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        dsl = new DSL(driver);

    }

    @After
    public void finalizando(){
        driver.quit();
    }

        @Test
    public void deveInteragirEsperaFixa() throws InterruptedException {
            dsl.clicarBotão("buttonDelay");
            Thread.sleep(8000);
            dsl.escrever("novoCampo","deu certo?");
        }
        @Test
    public void deveInteragirEsperaImplicita() {
        dsl.clicarBotão("buttonDelay");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dsl.escrever("novoCampo","deu certo?");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }

        @Test
    public void deveInteragirEsperaExplicita() {
            dsl.clicarBotão("buttonDelay");
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
            dsl.escrever("novoCampo", "deu certo?");
        }
    }
