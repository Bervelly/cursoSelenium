package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class TestFramesEJanelas {
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
    public void testeFrame() {
        dsl.entrarFrame("frame1");
        dsl.clicarBotão("frameButton");
        String msg = dsl.obterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
        dsl.sairFrame();
        dsl.escrever("elementosForm:nome", msg);
    }

    @Test
    public void interagirPopUp(){
        dsl.entrarFrame("frame1");
        dsl.clicarBotão("frameButton");
        String msg = dsl.obterTextoEAceita();
        Assert.assertEquals("Frame OK!", msg);
        dsl.sairFrame();
        dsl.escrever("elementosForm:nome", msg);
    }

    @Test
    public void interagirNovaJanela() {
        dsl.clicarBotão("buttonPopUpHard");
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }
}
