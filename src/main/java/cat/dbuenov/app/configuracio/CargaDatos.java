package cat.dbuenov.app.configuracio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.dbuenov.app.bean.Empleat;
import cat.dbuenov.app.dades.BaseDeDades;

@Configuration
public class CargaDatos {
	
	@Bean
	CommandLineRunner iniciaBaseDatos (BaseDeDades baseDeDades) {

		return args ->{
			baseDeDades.save(new Empleat("Dani","Tecnic"));
			baseDeDades.save(new Empleat("Joan","comercial"));
			baseDeDades.save(new Empleat("Carles","Tecnic"));
			baseDeDades.save(new Empleat("Enric","Tecnic"));
			baseDeDades.save(new Empleat("Pep","Comercial"));
			baseDeDades.save(new Empleat("Marc","Gerent"));
			baseDeDades.save(new Empleat("Pau","comercial"));
			baseDeDades.save(new Empleat("Maria","Mestre"));
		};
	}	
}
