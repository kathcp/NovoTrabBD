package dao;

import java.sql.SQLException;

import model.Fornecedor;
import model.OrdemServico;

public class TesteDao {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		TesteDao td = new TesteDao();
		td.testeAdicionarFornecedorDao();

	}
	
	void testeAdicionarFornecedorDao() throws ClassNotFoundException, SQLException{
		Fornecedor f = new Fornecedor();
		f.setCnpj("123456789");
		f.setNome("Kathleen");
		FornecedorDao fd = new FornecedorDaoImp();
		fd.adicionar(f);
		System.out.println("Adicionar Fornecedor OK");
	}
	void testeAdicionarServico() throws ClassNotFoundException, SQLException{
		OrdemServico os = new OrdemServico();
		OservicoDao fd = new OservicoDaoImp();
		fd.adicionar(os);
		System.out.println("Adicionar Ordem serviço OK");
	}
	

}
