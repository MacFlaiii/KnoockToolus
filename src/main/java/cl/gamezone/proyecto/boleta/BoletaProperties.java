package cl.gamezone.proyecto.boleta;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.validation.annotation.Validated;

/*
    Nos Permite configurar la aplicación 
    https://www-baeldung-com.translate.goog/configuration-properties-in-spring-boot?_x_tr_sl=en&_x_tr_tl=es&_x_tr_hl=es&_x_tr_pto=tc
    https://danielme.com/2022/07/27/tips-spring-boot-propiedades-de-configuracion-personalizadas/
 */
// En el archivo de configuracion todas las propiedades tienen el prefijo hostConfig
// le dice a Spring qué sección representa esta clase.
@ConfigurationProperties(prefix = "server")
// Nombre del Archivo en la carpeta resources
@PropertySource("classpath:boleta.properties")
// => especifica la ruta completa
// @PropertySource("file:/opt/config/music.properties")  

// @Configuration  => Crea un bean Spring con estereotipo de configuración.
//  le dice a Spring que trate esto como una clase de configuración y lo registre como un Bean
@Configuration 
//@Validated 

public class BoletaProperties {
    //@NotBlank 
    
    private String hostName;   // hostConfig.hostName 
    private int port = 8091;   // hostConfig.port
    private String from;       // hostConfig.from
    public BoletaProperties(){
        System.out.println("puerto Boleta >=========:" + this.getPort());
    }
    // @Bean
    // public EmbeddedServletContainerCustomizer containerCustomizer() {
    //     return (container -> {
    //         container.setPort(port);
    //     });
    // }


    public String getHostName() {
        return hostName;
    }
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
}