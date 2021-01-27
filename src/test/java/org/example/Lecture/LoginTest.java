package org.example.Lecture;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginTest {
    private WebDriver webDriver;
    private static String URL = LoginTest.class.getClassLoader().getResource("index.html").toExternalForm();
    private WebElement loginInput;
    private WebElement passwordInput;


    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();

    }
//    запускается перед каждым тестом
    @Before
    public void setUp() throws InterruptedException {
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        Thread.sleep(1000);
        loginInput =webDriver.findElement(By.id("login"));
        passwordInput = webDriver.findElement(By.id("password"));


    }

    @Test
    public void login() throws InterruptedException {
//        эмуляция ввода sendKeys
        Thread.sleep(2000);
        loginInput.sendKeys("a");
        Thread.sleep(2000);
        passwordInput.sendKeys("p");
//        отправка формы
        passwordInput.submit();
        Thread.sleep(10000);
        List<WebElement> p = webDriver.findElements(By.tagName("p"));
        int count = 0;
        for(WebElement i: p){
            count++;

            System.out.println(count-1 + " " + i + "" +i.getText());
        }
        Assert.assertEquals("Login: a",p.get(0).getText());
        Assert.assertEquals("Password: p",p.get(2).getText());
    }

    @After
    public void tearDown(){
        webDriver.quit();


    }
}
