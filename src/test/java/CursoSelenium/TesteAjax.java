package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {
    private WebDriver driver;
    private DSL dsl;


    @Before
    public void inicializando() {
        driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=dde8f");
        dsl = new DSL(driver);

    }

    @After
    public void finalizando(){
        driver.quit();
    }

    @Test
    public void deveInteragirAjax(){
        dsl.escrever("j_idt311:name", "Teste");
        dsl.clicarBotão("j_idt311:j_idt315");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBe(By.id("j_idt311:display"), "Teste"));
        Assert.assertEquals("Teste", dsl.obterTexto(By.id("j_idt311:display")));

    }
}
