package CursoSelenium.page;

import CursoSelenium.core.BasePage;
import CursoSelenium.core.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DesafioCadastroPage extends BasePage {


    public void setNome(String nome){
        dsl.escrever("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome){
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }

    public void setSexoFeminino(){
        dsl.clicarBotão("elementosForm:sexo:1");
    }

    public void setSexoMasculino(){
        dsl.clicarBotão("elementosForm:sexo:0");
    }

    public void setComidaPizza(){
        dsl.clicarBotão("elementosForm:comidaFavorita:2");
    }

    public void setComidaCarne(){
        dsl.clicarBotão("eelementosForm:comidaFavorita:0");
    }

    public void setComidaVegetariano(){
        dsl.clicarBotão("elementosForm:comidaFavorita:3");
    }

    public void setComidaFrango(){
        dsl.clicarBotão("elementosForm:comidaFavorita:1");
    }

    public void setEscolaridade(String valor){
        dsl.selecionarCombo("elementosForm:escolaridade",valor);
    }

    public void setEsportes(String... valores){
        for(String valor: valores)
            dsl.selecionarCombo("elementosForm:esportes", valor);
    }

    public void cadastrar(){
        dsl.clicarBotão("elementosForm:cadastrar");
    }

    public String obterResultado(){
        return dsl.obterTexto(By.xpath("//*[@id='resultado']/span"));
    }

}
