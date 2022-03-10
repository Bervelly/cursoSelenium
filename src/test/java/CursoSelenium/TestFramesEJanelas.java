package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class TestFramesEJanelas {
    @Test
    public void testeFrame() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");

        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alerta = driver.switchTo().alert();
        String mensagem = alerta.getText();
        Assert.assertEquals("Frame OK!", mensagem);
        alerta.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(mensagem);
        driver.quit();
    }

    @Test
    public void interagirPopUp(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");

        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.close();
        driver.switchTo().window("");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("e agora?");
        driver.quit();
    }

    @Test
    public void interagirNovaJanela() {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");

        driver.findElement(By.id("buttonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.tagName("textarea")).sendKeys("Deu super certo");
        driver.quit();

    }
}
