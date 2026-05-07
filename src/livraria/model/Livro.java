package livraria.model;

public class Livro extends item {
	
	private String autor;

	public Livro(int id, String titulo, int tipo, float preco, int estoque) {
		super(id, titulo, tipo, preco, estoque);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Autor: " + this.autor);
		
	}

}
