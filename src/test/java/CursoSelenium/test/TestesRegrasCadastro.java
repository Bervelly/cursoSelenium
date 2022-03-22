package CursoSelenium.test;

import CursoSelenium.core.BaseTest;
import CursoSelenium.core.DSL;
import CursoSelenium.core.DriverFactory;
import CursoSelenium.page.DesafioCadastroPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestesRegrasCadastro extends BaseTest {

    private DSL dsl;
    private DesafioCadastroPage page;

    @Parameterized.Parameter
    public String nome;
    @Parameterized.Parameter (value=1)
    public String sobrenome;
    @Parameterized.Parameter(value=2)
    public List<String> comidas;
    @Parameterized.Parameter(value=3)
    public String sexo;
    @Parameterized.Parameter (value=4)
    public String [] esportes;
    @Parameterized.Parameter (value=5)
    public String msg;

    @Before
    public void inicializando(){
        DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        dsl = new DSL();
        page = new DesafioCadastroPage();
    }

    @Parameterized.Parameters
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
