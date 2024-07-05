package br.com.nico.AppPessoaContatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nico.AppPessoaContatos.dto.PessoaDTO;
import br.com.nico.AppPessoaContatos.model.Pessoa;
import br.com.nico.AppPessoaContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Grava o registro de uma pessoa")
	@PostMapping 			// 		(/api/pessoas)POST 
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) { 
		Pessoa newPessoa = pessoaService.save(pessoa);
		if(newPessoa == null) {
			return ResponseEntity.notFound().build();
		} else {	
		return ResponseEntity.ok(newPessoa);
		}
	}

	@Operation(summary = "Busca pessoa por ID")
	@GetMapping("/{id}")	 // 	(/api/pessoas/{id}) //GET Pessoa por ID
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id) {  
		Optional<Pessoa> pessoa = pessoaService.findById(id);
		if(pessoa.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			
		} return ResponseEntity.ok(pessoa);
	}
	
	@Operation(summary = "Busca todos os registros de pessoas")
	@GetMapping 			// 		(/api/pessoas) GET lista todas as Pessoas
	public ResponseEntity<List<Pessoa>> findAll() { 	
		List<Pessoa> pessoa = pessoaService.findAll();
		if(pessoa == null) {
			return ResponseEntity.notFound().build();
		} 
		if(pessoa.size() == 0) {
			return ResponseEntity.noContent().build();
		}
			return ResponseEntity.ok(pessoa);
		
	}
	
	@Operation(summary = "Atualiza o registro de uma pessoa. Validação por ID")
	@PutMapping("/{id}")				//		(/api/pessoas/{id}) PUT atualiza uma Pessoa existente
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoa.setId(id);
		Pessoa updPessoa = pessoaService.update(pessoa);
		if(updPessoa == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updPessoa);
		}
	}
	
	@Operation(summary = "Exclui o registro de uma pessoa por ID")
	@DeleteMapping("/{id}")			//	(/api/pessoas/{id}) DELETE  remove uma Pessoa por ID
	public ResponseEntity<?> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
	
	@Operation(summary = "Busca dados de mala direta por ID")
	@GetMapping("/maladireta/{id}") // (/api/pessoas/maladireta/{id}) GET retorna dados de uma Pessoa por ID
    public ResponseEntity<PessoaDTO> findPessoaByIdMalaDireta(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isPresent()) {
            PessoaDTO pessoaDTO = new PessoaDTO(pessoa.get());
            return ResponseEntity.ok(pessoaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
