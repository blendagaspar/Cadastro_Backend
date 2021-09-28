package com.cadastro.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadastro.livraria.model.Cadastro;




public interface CadastroRepository  extends JpaRepository<Cadastro, Long >  {

	
	public List<Cadastro> findAllByNomeContainingIgnoreCase(String nome);
	
	
}
