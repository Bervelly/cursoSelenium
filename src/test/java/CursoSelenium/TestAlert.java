package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
    @Test
    public void interagiAlertaSimples(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Alert Simples", alert.getText());
        alert.accept();
        String texto = alert.getText();

        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();
    }

    @Test
    public void interagirAlertConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals("Confirmado", alert.getText() );
        alert.accept();
        driver.quit();
    }

    @Test
    public void interagirAlertNotConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals("Negado", alert.getText());
        driver.quit();
    }

    @Test
    public void interagirComPrompt(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Digite um numero", alert.getText());
        alert.sendKeys("12");
        alert.accept();
        Assert.assertEquals("Era 12?", alert.getText());
        alert.accept();
        Assert.assertEquals(":D", alert.getText());
        alert.accept();
        driver.quit();

    }

}
