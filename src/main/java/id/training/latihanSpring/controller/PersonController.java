package id.training.latihanSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.training.latihanSpring.dto.PersonDto;
import id.training.latihanSpring.entity.PersonEntity;
import id.training.latihanSpring.repository.PersonRepository;
import id.training.latihanSpring.repository.DetailBiodataRepository;
import id.training.latihanSpring.entity.DetailBiodataEntity;
import id.training.latihanSpring.dto.DetailBiodataDto;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	

	@Autowired
	DetailBiodataRepository detailBiodataRepository;
	
	@GetMapping("/get-all")
	public List<PersonEntity> getPerson() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return personEntities;
	}
	
	@GetMapping("/respon-entity")
	public ResponseEntity<?> getAll() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody PersonDto dto){
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
	@GetMapping("/get-bio")
	public ResponseEntity<?> getBiodata(){
		List<DetailBiodataEntity> detailBiodataEntites = detailBiodataRepository.findAll();
		return ResponseEntity.ok(detailBiodataEntites);
	}
	
	@PostMapping("/post-person-bio")	
	public ResponseEntity<?> insertBiodata(@RequestBody DetailBiodataDto dto){
		DetailBiodataEntity detailBiodataEntity = new DetailBiodataEntity();
		detailBiodataEntity.setDomisili(dto.getDomisili());
		detailBiodataEntity.setHobi(dto.getHobi());
		detailBiodataEntity.setJenisKelamin(dto.getJenisKelamin());
		detailBiodataEntity.setTanggalLahir(dto.getTanggalLahir());
		detailBiodataEntity.setUsia(dto.getUsia());
		
		detailBiodataRepository.save(detailBiodataEntity);
		return ResponseEntity.ok(detailBiodataEntity);

		
		
	}
}
