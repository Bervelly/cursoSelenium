package CursoSelenium.test;

import CursoSelenium.core.DSL;
import CursoSelenium.core.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrimeJava {

    private DSL dsl;


    @Before
    public void inicializando() {

        DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=20f67");
        dsl = new DSL();

    }

    @After
    public void finalizando(){
       DriverFactory.KillDriver();
    }

    @Test
    public void testandoRadioPrime(){
        dsl.clicarBotãoRadio(By.xpath("//*[@id='j_idt312:console']/tbody//td//label[@for='j_idt312:console:0']"));
        Assert.assertTrue(dsl.verificandoOpçãoPrime("j_idt312:console:0"));
    }

    @Test
    public void testandoComboPrime(){
        DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=8791b");
        dsl.clicarBotão("j_idt311:option_label");
        dsl.clicarBotão("j_idt311:option_items");
        Assert.assertEquals("Option1", dsl.obterTexto(By.id("j_idt311:option_1")));
    }
}
