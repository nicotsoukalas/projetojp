package br.com.nico.AppPessoaContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nico.AppPessoaContatos.model.Pessoa;
import br.com.nico.AppPessoaContatos.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa save(Pessoa pessoa) {  
		
		if(pessoa.getId() == null) {
			return pessoaRepository.save(pessoa);
		}
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId()); // caso atualização
			if(findPessoa.isPresent()) { 
				Pessoa updPessoa = findPessoa.get(); // define o id em updPessoa			
	            updPessoa.setNome(pessoa.getNome());
	            updPessoa.setEndereco(pessoa.getEndereco());
	            updPessoa.setCep(pessoa.getCep());
	            updPessoa.setCidade(pessoa.getCidade());
	            updPessoa.setUf(pessoa.getUf());
				return pessoaRepository.save(updPessoa); // update
			} else {
				System.out.println("Pessoa não encontrada neste Id. Gravando nova pessoa");
				return pessoaRepository.save(pessoa); // insert
			}
		
	}

	public Optional<Pessoa> findById(Long id) {  //	Obter Pessoa por ID
		return pessoaRepository.findById(id);
	}

	public List<Pessoa> findAll() {  //	Listar todas as Pessoas
		return pessoaRepository.findAll();
	}
	
	public Pessoa update(Pessoa pessoa) {  //	Atualizar Pessoa por ID Falta tratamento
		
		Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoa.getId());
		
		if(findPessoa.isPresent()) {
			Pessoa updPessoa = findPessoa.get();
			updPessoa.setNome(pessoa.getNome());
            updPessoa.setEndereco(pessoa.getEndereco());
            updPessoa.setCep(pessoa.getCep());
            updPessoa.setCidade(pessoa.getCidade());
            updPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(updPessoa); // update
		}
		return pessoaRepository.save(pessoa);

	}

//	Obter Pessoa por ID para mala direta

	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}

}
