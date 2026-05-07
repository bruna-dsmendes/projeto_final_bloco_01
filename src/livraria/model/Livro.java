package livraria.model;

public class Livro extends item {
	
	private String autor;

	public Livro(int id, String titulo, int tipo, float preco, int estoque, String autor) {
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

	@Override
	public int getQuantidade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setQuantidade(int i) {
		// TODO Auto-generated method stub
		
	}

}
