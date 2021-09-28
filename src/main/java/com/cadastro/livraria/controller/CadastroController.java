package com.cadastro.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.livraria.model.Cadastro;
import com.cadastro.livraria.repository.CadastroRepository;



@RestController
@CrossOrigin(origins = "*" , allowedHeaders ="*")
@RequestMapping("/cadastro")
public class CadastroController {

	
	
	@Autowired
	private CadastroRepository cadastrorepository;
	
	
	@GetMapping
	public ResponseEntity<List<Cadastro>> getAll(){
		
		return ResponseEntity.ok(cadastrorepository.findAll());		
	}
	
	
	@GetMapping("/{nome}")
	public ResponseEntity<Cadastro> getById(@PathVariable long id){
		
		return cadastrorepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
					
	}
	
	
	@PostMapping
	public ResponseEntity<Cadastro> post (@RequestBody Cadastro cadastro){
	
	        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrorepository.save(cadastro));
	}
	
	
	@PutMapping
	public ResponseEntity<Cadastro> put (@RequestBody Cadastro cadastro){
	
	        return ResponseEntity.ok(cadastrorepository.save(cadastro));
	       
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cadastrorepository.deleteById(id);
		
	}
	
	
	
	

	
	
}
