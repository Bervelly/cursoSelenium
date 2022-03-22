package CursoSelenium.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DSL {


    // Escrever e clicar

    public void escrever(By by, String texto){
        DriverFactory.getDriver().findElement(by).clear();
        DriverFactory.getDriver().findElement(by).sendKeys(texto);
    }


    public void escrever(String id_campo, String texto){
        escrever(By.id(id_campo), texto);
    }

    public String obterValorCampo(String id_campo) {
        return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicarBotão(String id) {
        DriverFactory.getDriver().findElement(By.id(id)).click();
    }
    public void clicarBotãoRadio(By by){
        DriverFactory.getDriver().findElement(by).click();
    }

    public String obterValueElemento(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
    }

    public boolean verificandoOpçãoSelecionada(String id) {
        return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
    }

    public boolean verificandoOpçãoPrime(String id){
        return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
    }
    // Link

    public void clicarLink(String link) {
        DriverFactory.getDriver().findElement(By.linkText(link)).click();
    }

    // Textos

    public String obterTexto(By by) {
        return DriverFactory.getDriver().findElement(by).getText();
    }

    public String buscarTextoNaPag(String id) {
        return obterTexto(By.id(id));
    }

    // Combos

    public String obterValorCombo(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void selecionarCombo(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public List<String> obterValoresCombo(String id) {
        WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public int obterQuantidadeCombo (String id){
            WebElement element = DriverFactory.getDriver().findElement(By.id(id));
            Select combo = new Select(element);
            List<WebElement> options = combo.getOptions();
            return options.size();
    }

    public boolean verificarOpcaoCombo (String id, String opcao){
            WebElement element = DriverFactory.getDriver().findElement(By.id(id));
            Select combo = new Select(element);
            List<WebElement> options = combo.getOptions();
            for (WebElement option : options) {
                if (option.getText().equals(opcao)) {
                    return true;
                }
            }
            return false;
        }

    // Alertas

    public String alertaObterTexto() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        return alert.getText();
    }

    public String obterTextoEAceita(){
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
    }

    public String obterTextoENega() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
    }

    public void alertaEscrever(String valor) {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    // Frames e Janelas

    public void entrarFrame(String id) {
        DriverFactory.getDriver().switchTo().frame(id);
    }

    public void sairFrame(){
        DriverFactory.getDriver().switchTo().defaultContent();
    }

    public void trocarJanela(String id) {
        DriverFactory.getDriver().switchTo().window(id);
    }
}


