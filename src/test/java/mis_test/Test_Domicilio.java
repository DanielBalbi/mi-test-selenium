package mis_test;

import acciones.elementos; // acciones para los elementos ( escribir, seleccionar, click etc)
import acciones.pantalla; // acciones para las pantallas (Maximizar, minimizar...)
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Domicilio {
pantalla mis_acciones= new pantalla();   // instancia de las acciones de pantallas
elementos mis_elementos = new elementos(); // instanciando las acciones de los elementos
WebDriver mi_driver = mis_acciones.conectar();

    @BeforeMethod
    public void setUpMethod() throws Exception {     
        mi_driver.get("https://www.emaras.com.ar/");    
    }
    
    @Test
    public void Test_Domicilio() throws InterruptedException {
    
   mis_acciones.maximizar();
   mis_acciones.escribir_Name(pantallas.login.txt_usuario, datos.consorcios.usuario);
    // mi_driver.findElement(By.name(pantallas.login.txt_usuario)).sendKeys(datos.consorcios.usuario);

    mis_acciones.escribir_Name(pantallas.login.txt_clave,
                                datos.consorcios.clave);

    mis_acciones.click_id(pantallas.login.btn_ingresar);
             /////////////////////////  ingresando en la pantalla de la selección del edificio
    //// seleccion del edificio. Renglón nro 3
     mis_acciones.click_css(pantallas.consorcios.nro_consorcio);
    
    ///// despliega el menú "Usuarios" 
    mi_driver.findElement(By.cssSelector(pantallas.menu.usuarios)).click();
    Thread.sleep(1000);
    // hacé click en la opción "Datos Administración" dentro del menu usuarios
    mi_driver.findElement(By.cssSelector(pantallas.menu.administracion)).click();
    Thread.sleep(1000);  
    /// cambio datos del domicilio
    mi_driver.findElement(By.name(pantallas.administracion.txt_domicilio)).click();
    mi_driver.findElement(By.name(pantallas.administracion.txt_domicilio)).clear();

    mis_acciones.escribir_Name(pantallas.administracion.txt_domicilio
                                , datos.consorcios.calle);

    mis_acciones.esperar(2000);
    mi_driver.findElement(By.cssSelector(pantallas.administracion.btn_grabar)).click();
    mi_driver.findElement(By.cssSelector(pantallas.administracion.lnk_cerrar_sesion)).click();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
      mi_driver.close();
        
    }
    
}
