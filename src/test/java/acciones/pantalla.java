package acciones;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class pantalla {
    WebDriver driver;
    
    public WebDriver conectar(){  // void = no retorna ningún valor
        ChromeOptions nuevoargumento = new ChromeOptions(); 
        nuevoargumento.addArguments("--remote-allow-origins=*","--headless"); //,"--headless"
        driver = new ChromeDriver(nuevoargumento);
        return driver;
    }
    
    public void maximizar(){
        driver.manage().window().maximize();
    }
    
    public void escribir_Name(String selector, String texto_a_escribir){  // metodo escribir en un cuadro de texto
        driver.findElement(By.name(selector)).sendKeys(texto_a_escribir);
    }
     public void escribir_Id(String selector, String texto_a_escribir){  // metodo escribir en un cuadro de texto
        driver.findElement(By.id(selector)).sendKeys(texto_a_escribir);
    } 
     public void escribir_class(String selector, String texto_a_escribir){  // metodo escribir en un cuadro de texto
        driver.findElement(By.className(selector)).sendKeys(texto_a_escribir);
    }   
     
     ////////////////////////////////////////
   public void click_class(String selector){  // metodo escribir en un cuadro de texto
        driver.findElement(By.className(selector))
                .click();
   }
   public void click_id(String selector){  // metodo escribir en un cuadro de texto
        driver.findElement(By.id(selector))
                .click();
    }        
    public void click_name(String selector){  // metodo escribir en un cuadro de texto
        driver.findElement(By.id(selector))
                .click();
    }      
      public void click_css(String selector){  // metodo escribir en un cuadro de texto
        driver.findElement(By.cssSelector(selector))
                .click();
    }   
      public void esperar(int segundos) throws InterruptedException{
            Thread.sleep(segundos);
      }
    
    
}
