package livraria.controller;

import java.util.ArrayList;

import livraria.model.Livro;
import livraria.model.item;
import livraria.repository.Repository;
import livraria.util.Cores;

public class LivroController implements Repository {

	private ArrayList<item> listaLivros = new ArrayList<item>();
	int id = 0;

	@Override
	public void procurarPorId(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("\nO Produto ID: " + id + " não foi encontrado!");
		}
	}

	public void buscarPorNomeOuAutor(String termo) {
	    String termoBusca = termo.trim().toUpperCase();
	    var listaFiltrada = listaLivros.stream()
	        .filter(p -> ((Livro) p).getTitulo().toUpperCase().contains(termoBusca) || 
	                     ((Livro) p).getAutor().toUpperCase().contains(termoBusca))
	        .toList();

	    if (listaFiltrada.isEmpty()) {
	        System.out.println("\nNenhum livro encontrado com o termo: " + termo);
	    } else {
	        listaFiltrada.forEach(p -> p.visualizar());
	    }
	}
	public void filtrarPorPreco(float min, float max) {
	    listaLivros.stream()
	        .filter(p -> p.getPreco() >= min && p.getPreco() <= max)
	        .forEach(p -> p.visualizar());
	}
	
	public void relatorioEstoqueBaixo() {
	    System.out.println("\n--- ALERTA DE REPOSIÇÃO ---");
	    listaLivros.stream()
	        .filter(p -> p.getQuantidade() < 2)
	        .forEach(p -> System.out.println("ID: " + p.getId() + " | Título: " + p.getTitulo() + " | Qtd: " + p.getQuantidade()));
	
	}
	
	public void venderLivro(int id, int quantidade) {
		    var buscaProduto = buscarNaCollection(id);

		    if (buscaProduto != null) {
		        
		        if (buscaProduto.getEstoque() >= quantidade) {
		            
		        	int novoEstoque = buscaProduto.getEstoque() - quantidade;
		            buscaProduto.setEstoque(novoEstoque);
		            
		            System.out.println(Cores.TEXT_CYAN + "\nVENDA CONCLUÍDA!" + Cores.TEXT_RESET);
		            System.out.println("Livro: " + buscaProduto.getTitulo());
		            System.out.println("Quantidade restante: " + buscaProduto.getEstoque());
		        } else {
		            System.out.println(Cores.TEXT_RED + "\nEstoque insuficiente! Disponível: " 
		                               + buscaProduto.getEstoque() + Cores.TEXT_RESET);
		        }
		    } else {
		        System.out.println(Cores.TEXT_RED + "\nLivro com ID " + id + " não encontrado!" + Cores.TEXT_RESET);
		   
	    }
	}
	
	
	@Override
	public void listarTodas() {
		for (var produto : listaLivros) {
			produto.visualizar();
		}
	}

	@Override
	public void cadastrar(item produto) {
		this.id++;
		produto.setId(this.id);
		listaLivros.add(produto);
		System.out.println("\nO livro " + produto.getTitulo() + " foi inserido com sucesso!");

	}

	@Override
	public void atualizar(item produto) {

		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {
			listaLivros.set(listaLivros.indexOf(buscaProduto), produto);
			System.out.println("\nO livro ID: " + produto.getId() + " foi atualizado com sucesso!");
		} else {
			System.out.println("\nO livro ID: " + produto.getId() + " não foi encontrado!");
		}
	}

	@Override
	public void deletar(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (listaLivros.remove(produto) == true) {
				System.out.println("\nO livro ID: " + id + " foi excluído com sucesso!");
			}
		} else {
			System.out.println("\nO livro ID: " + id + " não foi encontrado!");
		}
}
	public item buscarNaCollection(int id) {
		for (var produto : listaLivros) {
			if (produto.getId() == id) {
				return produto;
			}

		}
		return null;
	}

	public int gerarNumero() {
		return 0;
	}
}
