package livraria.controller;

import java.util.ArrayList;

import livraria.model.item;
import livraria.repository.Repository;

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
