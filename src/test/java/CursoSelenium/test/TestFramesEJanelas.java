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

public class TestFramesEJanelas {

    private DSL dsl;

    @Before
    public void inicializando(){

        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        dsl = new DSL();
    }

    @After
    public void finalizando(){
        DriverFactory.KillDriver();
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
        System.out.println(DriverFactory.getDriver().getWindowHandle());
        System.out.println(DriverFactory.getDriver().getWindowHandles());
        dsl.trocarJanela((String) DriverFactory.getDriver().getWindowHandles().toArray()[1]);
        dsl.escrever(By.tagName("textarea"), "Deu certo?");
        dsl.trocarJanela((String) DriverFactory.getDriver().getWindowHandles().toArray()[0]);
        dsl.escrever(By.tagName("textarea"), "e agora?");
    }
}
