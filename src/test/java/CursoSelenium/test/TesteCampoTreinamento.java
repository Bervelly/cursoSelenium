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

import java.util.Arrays;
import java.util.List;

public class TesteCampoTreinamento {

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
    public void testeTextField(){
        dsl.escrever("elementosForm:nome","Ana");
        dsl.escrever("elementosForm:sobrenome","Maria");
        Assert.assertEquals("Ana", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void testeTextArea() {
        dsl.escrever("elementosForm:sugestoes","testando\n123\nteste");
        Assert.assertEquals("testando\n123\nteste", dsl.obterValorCampo("elementosForm:sugestoes"));
    }

    @Test
    public void interagirRadioButtom(){
        dsl.clicarBotão("elementosForm:sexo:1");
        Assert.assertTrue( dsl.verificandoOpçãoSelecionada("elementosForm:sexo:1"));
        }

    @Test
    public void interagirCheckBox(){
        dsl.clicarBotão("elementosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.verificandoOpçãoSelecionada("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void interagirCombo(){
       dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
        //combo.selectByIndex(4);
        //combo.selectByValue("superior");
        Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
    }

    @Test
    public void validarValoresCombo(){
        Assert.assertEquals(8, dsl.obterQuantidadeCombo("elementosForm:escolaridade"));
        Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));
    }

    @Test
    public void selecionarValoresComboMulti(){
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(3, opcoesMarcadas.size());

        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
        Assert.assertEquals(2, opcoesMarcadas.size());
        Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));
    }


    @Test
    public void testandoBotão(){
        dsl.clicarBotão("buttonSimple");
        Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
    }

    @Test

    public void interagirLink(){
        dsl.clicarLink("Voltar");
        Assert.assertEquals("Voltou!", dsl.buscarTextoNaPag("resultado"));
    }

    @Test
    public void retornaTexto(){
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                dsl.obterTexto(By.className("facilAchar")));

        Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));

    }

}
