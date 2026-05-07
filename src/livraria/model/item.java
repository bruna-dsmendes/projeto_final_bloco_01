package livraria.model;

public abstract class item {
	
	private int id;
    private String titulo;
    private int tipo;
    private float preco;
    private int estoque;
    
    public item(int id, String titulo, int tipo, float preco, int estoque) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.preco = preco;
        this.estoque = estoque;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }
    
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void visualizar() {
        String tipoStr = "";
        
        switch(this.tipo) {
            case 1:
                tipoStr = "Livro";
                break;
            default:
                tipoStr = "Desconhecido";
        }
        System.out.println("\n\n***********************************************************");
        System.out.println("Dados do Produto:");
        System.out.println("***********************************************************");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.titulo);
        System.out.println("Tipo: " + tipoStr);
        System.out.println("Preço: R$ " + this.preco);
        System.out.println("Estoque: " + this.estoque);
    }
	public abstract int getQuantidade();
	public abstract void setQuantidade(int i);
}
