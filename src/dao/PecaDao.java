package dao;

import java.util.List;

import model.Peca;

public interface PecaDao {

	public List<Peca> listarPorId(int numero);

	public void adicionar(Peca p);

	public void excluir(int codigo);

	void atualizar(Peca p);

	List<Peca> pesquisar(String nome);

	Peca buscar(int codigo);

}
