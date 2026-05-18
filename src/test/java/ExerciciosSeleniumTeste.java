import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciciosSeleniumTeste {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void ending(){
        driver.quit();
    }

    @Test
    void ex1_inputs(){
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("25");

        String valor_input = input.getDomProperty("value");
        assertEquals("25", valor_input);
    }
    @Test
    void ex2_dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdown"));


        Select dropDown =  new Select(dropDownElement);
        dropDown.selectByVisibleText("Option 1");
        assertEquals("Option 1", dropDown.getFirstSelectedOption().getText());


        dropDown.selectByVisibleText("Option 2");
        assertEquals("Option 2", dropDown.getFirstSelectedOption().getText());
    }

    @Test
    void ex9_forgotPassword(){
        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement email =  driver.findElement(By.id("email"));
        WebElement botao =  driver.findElement(By.id("form_submit"));

        email.sendKeys("test@gmail.com");
        botao.click();

        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertEquals("Internal Server Error", h1.getText());
    }
}
