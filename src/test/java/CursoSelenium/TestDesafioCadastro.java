package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDesafioCadastro {

    @Test
    public void testeDesafio(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Bervelly");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Nobrega");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Especializacao"); ;
        new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Corrida");
        driver.findElement(By.id("elementosForm:cadastrar")).click();

        Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        driver.quit();
    }
}
