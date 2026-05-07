package livraria;

import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.controller.LivroController;
import livraria.model.Livro;
import livraria.util.Cores;

public class Menu {
	static LivroController produtos = new LivroController();
	private static final Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao, id, tipo, estoque;
		String titulo, autor;
		float preco;

		while (true) {

			System.out.println(
					Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND + "******************************************");
			System.out.println("                                          ");
			System.out.println("         REFÚGIO LITERÁRIO                ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("                                          ");
			System.out.println("  1 - Cadastrar livro                     ");
			System.out.println("  2 - Listar todos os livros da unidade   ");
			System.out.println("  3 - Buscar livro por ID                 ");
			System.out.println("  4 - Atualizar informações               ");
			System.out.println("  5 - Excluir (Fora de catalogo)          ");
			System.out.println("  6 - Filtrar por faixa de preço          ");
			System.out.println("  7 - Registrar Venda                     ");
			System.out.println("  0 - Sair                                ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("Entre com a opção desejada:               ");
			System.out.println("                                          " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(Cores.TEXT_RED + "\nEntrada inválida! Por favor, digite um número correspondente ás opções do menu." + Cores.TEXT_RESET);
				leia.nextLine();
				opcao = -1;
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nLivraria Refúgio Literário                   "
						+ "\nLer é a imaginação que te                    "
						+ "\npermite andar por vários mundos              ");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar livros\n\n");
				System.out.println("Digite o Nome do Livro: ");
				titulo = leia.nextLine().trim().toUpperCase();

				System.out.println("Digite o Autor do Livro: ");
				autor = leia.nextLine().trim().toUpperCase();

				do {
					try {
						System.out.println("Digite o Preço do Livro (R$): ");
						preco = leia.nextFloat();
						if (preco <= 0) {
							System.out.println(Cores.TEXT_RED + "O preço deve ser maior que zero!" + Cores.TEXT_RESET);
						}
					} catch (InputMismatchException e) {
						System.out.println(Cores.TEXT_RED + "ERRO: Digite apenas números com vírgula (ex: 15,59)."
								+ Cores.TEXT_RESET);
						preco = 0;
					}
				} while (preco <= 0);

				do {
					try {
						System.out.println("Digite o Estoque Inicial: ");
						estoque = leia.nextInt();
						if (estoque < 0) {
							System.out.println(Cores.TEXT_RED + "O estoque não pode ser negativo!" + Cores.TEXT_RESET);
						}
					} catch (InputMismatchException e) {
						System.out.println(Cores.TEXT_RED + "ERRO: Digite apenas números inteiros!" + Cores.TEXT_RESET);
						leia.nextLine();
						estoque = -1;
					}
				} while (estoque < 0);
				leia.nextLine();

				tipo = 1;

				produtos.cadastrar(new Livro(produtos.gerarNumero(), titulo, tipo, preco, estoque, autor));
				break;

			case 2:
				System.out.println("Listas todos os livros da unidade\n\n");
				produtos.listarTodas();
				break;

			case 3:
				System.out.println("Buscar livro por número de cadastro\n\n");

				System.out.println("Digite o ID do Produto: ");
				id = leia.nextInt();
				produtos.procurarPorId(id);
				break;

			case 4:
				System.out.println("Atualizar quantidade disponivel\n\n");
				System.out.println("Digite o ID do Produto: ");
				id = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(id);

				if (buscaProduto != null) {
					leia.nextLine();

					System.out.println("Digite o Novo Nome do Livro: ");
					titulo = leia.nextLine();

					System.out.println("Digite o Novo Autor do Livro: ");
					autor = leia.nextLine();

					System.out.println("Digite o Novo Preço do Livro (R$): ");
					preco = leia.nextFloat();

					System.out.println("Digite o Novo Estoque: ");
					estoque = leia.nextInt();

					tipo = buscaProduto.getTipo();

					produtos.atualizar(new Livro(id, titulo, tipo, preco, estoque, autor));
				} else {
					System.out.println("Produto não encontrado!");
				}

				break;

			case 5:
				System.out.println("Livro esgotado!)\n\n");
				System.out.println("Digite o ID do Produto: ");
				id = leia.nextInt();
				produtos.deletar(id);

				break;
				
			case 6:
			    System.out.println("Filtrar por Faixa de Preço\n");
			    System.out.println("Preço Mínimo: ");
			    float min = leia.nextFloat();
			    System.out.println("Preço Máximo: ");
			    float max = leia.nextFloat();
			    produtos.filtrarPorPreco(min, max);
			    break;
			    
			case 7:
			    System.out.println("Registrar Venda\n");
			    System.out.println("Digite o ID do Livro: ");
			    id = leia.nextInt();
			    System.out.println("Quantidade vendida: ");
			    int qtdVenda = leia.nextInt();
			    produtos.venderLivro(id, qtdVenda);
			    break;

			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);

				break;

			}
		}
	}

	public static void sobre() {
		System.out.println("\n*****************************************");
		System.out.println("Projeto Desenvolvido por: Bruna Mendes");
		System.out.println("Generation Brasil - brunam@generation.org");
		System.out.println("github.com/bruna-dsmendes");
		System.out.println("*****************************************");
	}
}