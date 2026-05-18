package POM_2.tests;

import POM_2.pages.HomePage;
import POM_2.pages.ProductPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompraTest {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;

    @BeforeEach
    void setup(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }
    @AfterEach
    void finalizar(){
        driver.quit();
    }

    @Test
    void deveAdicionarProdutoAoCarrinho(){
        homePage.abrirPagina();
        homePage.clicarCatalog();


        homePage.clicarProdutoGreyJacket();

        assertTrue(productPage.obterNomeProduto().contains("Grey"));

        productPage.adicionarAoCarrinho();

         productPage.esperarCarrinhoAtualizar();


        assertTrue(productPage.obterQuantidadeCarrinho().contains("1"));

    }
















}
