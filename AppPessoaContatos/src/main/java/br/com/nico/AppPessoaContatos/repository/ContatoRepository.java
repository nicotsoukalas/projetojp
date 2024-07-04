package br.com.nico.AppPessoaContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nico.AppPessoaContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

	    List<Contato> findByPessoaId(Long id);
	
}
