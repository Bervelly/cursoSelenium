package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {
    @Test
    public void testeTextField(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Ana");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Maria");
        Assert.assertEquals("Ana", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();

    }
    @Test
    public void testeTextArea() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("testando\n123\nteste");
        Assert.assertEquals("testando\n123\nteste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void interagirRadioButtom(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        Assert.assertTrue( driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
        driver.quit();
        }

    @Test
    public void interagirCheckBox(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
        driver.quit();
    }

    @Test
    public void interagirCombo(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        //combo.selectByIndex(4);
        //combo.selectByValue("superior");
        combo.selectByVisibleText("2o grau completo");
        Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
    }

    @Test
    public void validarValoresCombo(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        Assert.assertEquals(8, options.size());
        driver.quit();
    }

    @Test
    public void selecionarValoresComboMulti(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Corrida");

        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(3, allSelectedOptions.size());

        combo.deselectByVisibleText("Futebol");
        allSelectedOptions = combo.getAllSelectedOptions();
        Assert.assertEquals(2, allSelectedOptions.size());
        driver.quit();
    }

    @Test
    public void testandoBotão(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

    }

    @Test

    public void interagirLink(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
        driver.quit();
    }

    @Test
    public void retornaTexto(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                driver.findElement(By.className("facilAchar")).getText());

        Assert.assertEquals("Campo de Treinamento",
                driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }

}
