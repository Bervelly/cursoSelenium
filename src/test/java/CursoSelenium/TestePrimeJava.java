package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrimeJava {
    private WebDriver driver;
    private DSL dsl;


    @Before
    public void inicializando() {
        driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=20f67");
        dsl = new DSL(driver);

    }

    @After
    public void finalizando(){
        driver.quit();
    }

    @Test
    public void testandoRadioPrime(){
        dsl.clicarBotãoRadio(By.xpath("//*[@id='j_idt312:console']/tbody//td//label[@for='j_idt312:console:0']"));
        Assert.assertTrue(dsl.verificandoOpçãoPrime("j_idt312:console:0"));
    }

    @Test
    public void testandoComboPrime(){
        driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=8791b");
        dsl.clicarBotão("j_idt311:option_label");
        dsl.clicarBotão("j_idt311:option_items");
        Assert.assertEquals("Option1", dsl.obterTexto(By.id("j_idt311:option_1")));
    }
}
