package CursoSelenium.test;

import CursoSelenium.core.BaseTest;
import CursoSelenium.core.DriverFactory;
import CursoSelenium.page.DesafioCadastroPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestDesafioCadastro extends BaseTest {

    private DesafioCadastroPage page;

    @Before
    public void inicializando() {
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        page = new DesafioCadastroPage();
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
        Assert.assertEquals("Cadastrado!", page.obterResultado());
    }
}
