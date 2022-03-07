package CursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {
    @Test
    public void testeTextField(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Testando");
        Assert.assertEquals("Testando", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();

    }
    @Test
    public void testeTextArea(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("testando\n123\nteste");
        Assert.assertEquals("testando\n123\nteste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();

    }

}
