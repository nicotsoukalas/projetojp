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
	
	public Pessoa save(Pessoa pessoa) {  //	Criar Pessoa Falta tratamento Se algum campo for nulo
//		
//		//pesquisar se o produto existe
//				Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
//				
//				//se o produto existir, atualizo:
//				if(findProduto.isPresent()) {
//					//criar um novo objeto do produto  
//					// e lançar os dados do objeto de parâmetro neste novo obj e grava
//					Produto updProduto = findProduto.get(); //setId
//					updProduto.setCodigoBarras(produto.getCodigoBarras());
//					updProduto.setNome(produto.getNome());
//					updProduto.setPreco(produto.getPreco());
//					//retornar o objeto gravado
//					return produtoRepository.save(updProduto); //"UPDATE"
//				}		
//				//retornar o objeto gravado
//				return produtoRepository.save(produto);  //"INSERT"
		
		return pessoaRepository.save(pessoa);
	}

	public Optional<Pessoa> findById(Long id) {  //	Obter Pessoa por ID
		return pessoaRepository.findById(id);
	}

	public List<Pessoa> findAll() {  //	Listar todas as Pessoas
		return pessoaRepository.findAll();
	}
	
	public Pessoa update(Pessoa pessoa) {  //	Atualizar Pessoa por ID Falta tratamento
		return pessoaRepository.save(pessoa);
				
		
//			Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
//			
//			//se o produto existir, atualizo:
//			if(findProduto.isPresent()) {
//				//criar um novo objeto do produto  
//				// e lançar os dados do objeto de parâmetro neste novo obj e grava
//				Produto updProduto = findProduto.get(); //setId
//				updProduto.setCodigoBarras(produto.getCodigoBarras());
//				updProduto.setNome(produto.getNome());
//				updProduto.setPreco(produto.getPreco());
//				//retornar o objeto gravado
//				return produtoRepository.save(updProduto); //"UPDATE"
//			}		
//			//retornar o objeto gravado
//			return produtoRepository.save(produto);  //"INSERT"
//				
				
				
	}
	
//	Obter Pessoa por ID para mala direta

	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}

}
