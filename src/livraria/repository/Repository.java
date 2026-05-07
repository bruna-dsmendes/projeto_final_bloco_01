package livraria.repository;

import livraria.model.item;

public interface Repository {

	 public void procurarPorId(int id);
	    public void listarTodas();
	    public void cadastrar(item produto);
	    public void atualizar(item produto);
	    public void deletar(int id);
}
