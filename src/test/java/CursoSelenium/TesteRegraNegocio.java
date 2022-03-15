package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRegraNegocio {
    private WebDriver driver;
    private DSL dsl;
    private DesafioCadastroPage page;

    @Before
    public void inicializando(){
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
    public void testeCadastroSemSobrenome() {
        page.setNome("Bervelly");
        page.cadastrar();
        Assert.assertEquals("Sobrenome eh obrigatorio", dsl.obterTextoEAceita());

    }

    @Test
    public void testeCadastroSemNome() {
        page.cadastrar();
        Assert.assertEquals("Nome eh obrigatorio", dsl.obterTextoEAceita());

    }

    @Test
    public void testeCadastroSemSexo() {
       page.setNome("Bervelly");
       page.setSobrenome("Nobrega");
       page.cadastrar();
       Assert.assertEquals("Sexo eh obrigatorio", dsl.obterTextoEAceita());
    }

    @Test
    public void testeCadastro2Box() {
        page.setNome("Bervelly");
        page.setSobrenome("Nobrega");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setComidaVegetariano();
        page.cadastrar();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.obterTextoEAceita());
    }

    @Test
    public void testeCadastroEsportes() {
        page.setNome("Bervelly");
        page.setSobrenome("Nobrega");
        page.setSexoFeminino();
        page.setComidaPizza();
        page.setEsportes("Natacao", "O que eh esporte?");
        page.cadastrar();
        Assert.assertEquals("Voce faz esporte ou nao?", dsl.obterTextoEAceita());
    }
}
