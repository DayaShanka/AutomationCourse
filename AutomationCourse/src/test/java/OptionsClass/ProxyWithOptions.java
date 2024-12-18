package OptionsClass;  

import org.openqa.selenium.Proxy; // Import the Proxy class  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.chrome.ChromeOptions;  

public class ProxyWithOptions {  

    public static void main(String[] args) {  

        // Set the path for the ChromeDriver executable  
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");  

        // Create ChromeOptions instance  
        ChromeOptions options = new ChromeOptions();  

        // Add the WebDriver proxy capability.  
        Proxy p = new Proxy();  
        p.setHttpProxy("myhttpproxy:3337");  
        options.setCapability("proxy", p);  

        // Initialize the ChromeDriver with the proxy options  
        WebDriver driver = new ChromeDriver(options);  

        // Your test code goes here  

        // Clean up and close the browser  
        driver.quit();  
    }  
}