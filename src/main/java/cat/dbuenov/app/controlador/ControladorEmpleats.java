package cat.dbuenov.app.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cat.dbuenov.app.bean.Empleat;
import cat.dbuenov.app.dades.BaseDeDades;
import cat.dbuenov.app.errors.EmpleatNotFoundException;

@RestController
public class ControladorEmpleats {
	
	private final BaseDeDades baseDeDades;
	
	public ControladorEmpleats(BaseDeDades baseDeDades) {
		this.baseDeDades= baseDeDades;
	}
	
	// Mostra tots els empleats
	
	@GetMapping("/empleats")
	public List<Empleat> mostraTots(){
		return baseDeDades.findAll();		
	}
	
	// Crea un empleat

	/*
	@PostMapping("/empleats")
	public Empleat nouEmpleat(@RequestBody Empleat nouEmplat) {
		//nouEmplat.setSou();
		return baseDeDades.save(nouEmplat);		
	}
	*/
	
	@PostMapping("/empleats")
	public Empleat nouEmpleat(@RequestParam(name="nom",required=true) String nom, @RequestParam(name="feina",required=true) String feina) {
		Empleat empleat = new Empleat(nom, feina);
		return baseDeDades.save(empleat);
		
	}
	
	// Mostra un empleat
	
	@GetMapping("/empleats/{id}")
	public Empleat mostraEmpleat(@PathVariable Long id) {

		return baseDeDades.findById(id).orElseThrow(() -> new EmpleatNotFoundException(id));
	}
	
	// Mostra empleats per feina
	
	@GetMapping("/feines/{feina}")
	public List<Empleat> mostraEmpleatsFeina(@PathVariable String feina){
		
		List<Empleat> empleats = baseDeDades.findAll();	
		List<Empleat> empleatsPerFeina = new ArrayList<Empleat>();		
		
		for (Empleat empleat : empleats) {
			if(empleat.getFeina().equalsIgnoreCase(feina)) {
				empleatsPerFeina.add(empleat);
			}
		}
		return empleatsPerFeina;
		
	}	

	// Actualitza un empleat
	
	@PutMapping("/empleats/{id}")
	public Empleat canviarEmpleat(@RequestBody Empleat nouEmpleat, @PathVariable Long id) {

		return baseDeDades.findById(id)
				.map(empleat -> {
					empleat.setNom(nouEmpleat.getNom());
					empleat.setFeina(nouEmpleat.getFeina());
					return baseDeDades.save(empleat);
				})
				.orElseGet(() -> {
					nouEmpleat.setId(id);
					return baseDeDades.save(nouEmpleat);
				});
	}

	// Esborra un empleat
	
	@DeleteMapping("/empleats/{id}")
	public void esborraEmpleat(@PathVariable Long id) {
		baseDeDades.deleteById(id);
	}

}
