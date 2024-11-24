package com.devEmersonc.gestion_de_inventarios;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionDeInventariosApplication {

	public static void main(String[] args) {
		//Carga las variables desde el archivo .env
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		//Configura las variables de entorno del sistema
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(GestionDeInventariosApplication.class, args);
	}

}
