package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    private By usernameInput = By.id("username");

    private By passwordInput = By.id("password");

    private By loginButton = By.cssSelector("button[type='submit']");

    private By mensagem  = By.id("flash");

    public void abrirPagina(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void preencherUsuario(String usuario){
        driver.findElement(usernameInput).sendKeys(usuario);
    }
    public void preencherSenha(String senha){
        driver.findElement(passwordInput).sendKeys(senha);
    }
    public void clicarLogin(){
        driver.findElement(loginButton).click();
    }
    public String obterMensagem(){
        return driver.findElement(mensagem).getText();
    }
}
