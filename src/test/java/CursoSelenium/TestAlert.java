package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializando(){
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void finalizando(){
        driver.quit();
    }


    @Test
    public void interagirAlertaSimples(){
        dsl.clicarBotão("alert");
        String texto = dsl.obterTextoEAceita();
        Assert.assertEquals("Alert Simples", texto);
        dsl.escrever("elementosForm:nome", texto);
    }

    @Test
    public void interagirAlertConfirm(){
        dsl.clicarBotão("confirm");
        Assert.assertEquals("Confirm Simples", dsl.obterTextoEAceita());
        Assert.assertEquals("Confirmado", dsl.obterTextoEAceita());

    }

    @Test
    public void interagirAlertNotConfirm(){
        dsl.clicarBotão("confirm");
        Assert.assertEquals("Confirm Simples", dsl.obterTextoENega());
        Assert.assertEquals("Negado", dsl.obterTextoENega());
    }

    @Test
    public void interagirComPrompt(){
        dsl.clicarBotão("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("12");
        Assert.assertEquals("Era 12?", dsl.obterTextoEAceita());
        Assert.assertEquals(":D", dsl.obterTextoEAceita());

    }

}
