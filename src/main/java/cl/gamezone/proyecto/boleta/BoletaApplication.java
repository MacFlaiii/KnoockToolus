package cl.gamezone.proyecto.boleta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
@SpringBootApplicationes una anotación de conveniencia que agrega todo lo siguiente:
    @Configuration  :   Etiqueta la clase como una fuente de definiciones de beans para el contexto de la aplicación.
    @EnableAutoConfiguration  :  Indica a Spring Boot que comience a agregar beans según la configuración de la ruta de clases
                                , otros beans y diversas propiedades. 
                                Por ejemplo, si spring-webmvcestá en la ruta de clases, 
                                esta anotación marca la aplicación como una aplicación web y activa comportamientos clave,
                                como la configuración de un archivo DispatcherServlet.
    @ComponentScan  :   Le dice a Spring que busque otros componentes, 
                          configuraciones y servicios en el com/examplepaquete, 
                          lo que le permite encontrar los controladores.
 */
@SpringBootApplication
@EnableDiscoveryClient
// Clase que contiene la configuración del MicroServicio
// Le dice a Spring que trate a esta clase como un consumidor de valores de application.yml/application.properties
@EnableConfigurationProperties(BoletaProperties.class)

// @ComponentScan(basePackages="cl.harrys.aseo")
// @EnableJpaRepositories("cl.harrys.aseo.repository")
// @EntityScan("cl.harrys.aseo.dto")
public class BoletaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoletaApplication.class, args);
        // SpringApplication app = new SpringApplication(BancoApplication.class);
        // app.setDefaultProperties(Collections.singletonMap("server.port","8092"));
        // app.run(args);
	}

}