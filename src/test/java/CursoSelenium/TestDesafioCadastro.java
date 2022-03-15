package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDesafioCadastro {

    private WebDriver driver;
    private DSL dsl;
    private DesafioCadastroPage page;

    @Before
    public void inicializando() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        dsl = new DSL(driver);
        page = new DesafioCadastroPage(driver);
    }

    @After
    public void finalizando(){
        driver.quit();
    }

    @Test
    public void testeDesafio(){
        page.setNome("Bervelly");
        page.setSobrenome("Nobrega");
        page.setSexoFeminino();
        page.setComidaPizza();
        page.setEscolaridade("Especializacao");
        page.setEsportes("Corrida");
        page.cadastrar();
        Assert.assertTrue(page.obterResultado().startsWith("Cadastrado!"));
    }
}
