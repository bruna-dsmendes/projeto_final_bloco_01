package livraria;

import java.util.Scanner;

import livraria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println( Cores.TEXT_BLUE + Cores.ANSI_WHITE_BACKGROUND +"******************************************");
			System.out.println("                                          ");
			System.out.println("         REFÚGIO LITERÁRIO                ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("                                          ");
			System.out.println("  1 - Cadastrar livro                     ");
			System.out.println("  2 - Listar todos os livros da unidade   ");
			System.out.println("  3 - Buscar livro                        ");
			System.out.println("  4 - Atualizar quantidade                ");
			System.out.println("  5 - Vendido (excluir)                   ");
			System.out.println("  0 - Sair                                ");
			System.out.println("                                          ");
			System.out.println("******************************************");
			System.out.println("Entre com a opção desejada:               ");
			System.out.println("                                          " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

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

			break;

		case 2:
			System.out.println("Listas todos os livros da unidade\n\n");

			break; 
			
		case 3:
			System.out.println("Buscar livro por número de cadastro\n\n");

			break;

		case 4:
			System.out.println("Atualizar quantidade disponivel\n\n");

			break;

		case 5:
			System.out.println("Livro esgotado (apagar do estoque)\n\n");

			break;
			
		default:
			System.out.println("\nOpção inválida!\n");

			break;
	
		}
	}
}
	public static void sobre() {
		System.out.println("\n*****************************************"     );
		System.out.println("Projeto Desenvolvido por: Bruna Mendes"     );
		System.out.println("Generation Brasil - brunam@generation.org");
		System.out.println("github.com/bruna-dsmendes");
		System.out.println("*****************************************" );
	}
}