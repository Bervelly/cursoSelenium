package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRegraNegocio {
    @Test
    public void testeCadastroSemSobrenome() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Bervelly");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
        driver.quit();
    }

    @Test
    public void testeCadastroSemNome() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
        driver.quit();
    }

    @Test
    public void testeCadastroSemSexo() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Bervelly");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Nobrega");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
        alert.accept();
        driver.quit();
    }

    @Test
    public void testeCadastro2Box() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Bervelly");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Nobrega");
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        alert.accept();
        driver.quit();
    }
}
