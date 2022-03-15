package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestesRegrasCadastro {
    private WebDriver driver;
    private DSL dsl;
    private DesafioCadastroPage page;

    @Parameter
    public String nome;
    @Parameter(value=1)
    public String sobrenome;
    @Parameter(value=2)
    public List<String> comidas;
    @Parameter(value=3)
    public String sexo;
    @Parameter(value=4)
    public String [] esportes;
    @Parameter(value=5)
    public String msg;

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

    @Parameters
    public static Collection<Object[]> getCollection(){
        return Arrays.asList(new Object[][]{
                {"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
        });
        }

    @Test
    public void testeRegrasCadastro() {
        page.setNome(nome);
        page.setSobrenome(sobrenome);
        if(sexo.equals("Masculino")){
            page.setSexoMasculino();
        } else {
            page.setSexoFeminino();
        }
        if (comidas.contains("Carne")) page.setComidaCarne();
        if (comidas.contains("Frango")) page.setComidaFrango();
        if (comidas.contains("Vegetariano")) page.setComidaVegetariano();
        if (comidas.contains("Pizza")) page.setComidaPizza();
        page.setEsportes(esportes);
        page.cadastrar();
        System.out.println(msg);
        Assert.assertEquals(msg, dsl.obterTextoEAceita());
    }
}
