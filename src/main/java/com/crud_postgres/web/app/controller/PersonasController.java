package com.crud_postgres.web.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crud_postgres.web.app.model.Personas;
import com.crud_postgres.web.app.repository.PersonasRepository;

@RestController
@RequestMapping("/api/personasCrud")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PersonasController {

	@Autowired
	PersonasRepository potencyInformationRepository;

	//buscar todos los registros
	@GetMapping("/getAll")
	public ResponseEntity<List<Personas>> getAllPotency(@RequestParam(required = false) String orderNumber) {
		try {
			List<Personas> potencyData = potencyInformationRepository.findAll();
			if (!potencyData.isEmpty()) {
				return new ResponseEntity<>(potencyData, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//buscar registros por identificador
	@GetMapping("/get/{id}")
	public ResponseEntity<Personas> getPotencyById(@PathVariable("id") long id) {
		Optional<Personas> potencyInfo = potencyInformationRepository.findById(id);
		if (potencyInfo.isPresent()) {
			return new ResponseEntity<>(potencyInfo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//crear nuevo registro
	@PostMapping("/new")
	public ResponseEntity<Personas> createPotency(@RequestBody Personas potencyInfo) {
		try {
			Personas _potencyData = potencyInformationRepository
					.save(new Personas(potencyInfo.getNombre(), potencyInfo.getApellido(),
							potencyInfo.getNacionalidad(), potencyInfo.getTelefono(), potencyInfo.getEdad(),
							potencyInfo.getFechaNacimiento(), potencyInfo.getDelete()));

			return new ResponseEntity<>(_potencyData, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//actualizar registros
	@PutMapping("/updateBy/{id}")
	public ResponseEntity<Personas> updatePotency(@PathVariable("id") long id,
			@RequestBody Personas potencyInfo) {
		try {
			Optional<Personas> potencyData = potencyInformationRepository.findById(id);
			if (potencyData.isPresent()) {
				Personas _potencyData = potencyData.get();
				_potencyData.setNombre(potencyInfo.getNombre());
				_potencyData.setApellido(potencyInfo.getApellido());
				_potencyData.setNacionalidad(potencyInfo.getNacionalidad());
				_potencyData.setTelefono(potencyInfo.getTelefono());
				_potencyData.setEdad(potencyInfo.getEdad());
				_potencyData.setFechaNacimiento(potencyInfo.getFechaNacimiento());
				_potencyData.setDelete(potencyInfo.getDelete());

				return new ResponseEntity<>(potencyInformationRepository.save(_potencyData), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	//eliminar registros
	@GetMapping("/deleteBy/{id}")
	public ResponseEntity<Personas> deletePotency(@PathVariable("id") long id) {
		try {
			Optional<Personas> potencyData = potencyInformationRepository.findById(id);
			if (potencyData.isPresent()) {
				Personas _potencyData = potencyData.get();
				_potencyData.setDelete(1);
				return new ResponseEntity<>(potencyInformationRepository.save(_potencyData), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	//Buscar por registro eliminado
	@GetMapping("/getAllDelete/{delete}")
	public ResponseEntity<List<Personas>> getPotencyByDelete(@PathVariable("delete") Integer delete) {
		List<Personas> potencyInfo = potencyInformationRepository.findByDelete(delete);
		if (!potencyInfo.isEmpty()) {
			return new ResponseEntity<>(potencyInfo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
