package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Peca;

public class PecaDaoImp implements PecaDao {

	@Override
	public void adicionar(Peca p) {
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"insert into tb_peca (codigo, nome, nfiscal, valor, qtde, cnpj_fornecedor,"
				+ " placa) values ( ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt( 1, p.getCodigo());
			ps.setString( 2,  p.getNome());
			ps.setInt( 3,  p.getNfiscal() );
			ps.setDouble(4, p.getValor());
			ps.setInt(5, p.getQtde());
			ps.setString(6, p.getCnpjFornecedor());
			ps.setString(7, p.getPlaca());
		//	ps.setDate( 8,  new java.sql.Date( p.getDtServico().getTime() ) );
			ps.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public 	void excluir(int codigo){
		// TODO Auto-generated method stub
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"delete from tb_pecas where codigo = ?");
			ps.setInt( 1, codigo );
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void atualizar(Peca p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Peca> pesquisar(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Peca buscar(int codigo) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"select * from tb_peca where codigo = ? ");
				ps.setInt( 1, codigo );
				ResultSet rs = ps.executeQuery();
				if ( rs.next() ) { 
					Peca p = new Peca();
					p.setCodigo( rs.getInt("codigo"));
					p.setNome(rs.getString("nome"));
					p.setnFiscal(rs.getInt("nfiscal"));
					p.setValor(rs.getDouble("valor"));
					p.setQtde(rs.getInt("qtde"));
					p.setCnpjFornecedor(rs.getString("cnpj_fornecedor"));	
					p.setPlaca(rs.getString("placa"));
					ps.setString(7, p.getPlaca());
					return p;
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;			
	}

	@Override
	public List<Peca> listarPorId(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	/*	@Override
		public void excluir(int codigo) {
			try {
				PreparedStatement ps = con.prepareStatement(
					"delete from aluno where id = ?");
				ps.setLong( 1, id );
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void atualizar(Peca p) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Peca> pesquisar(String nome) {
			List<Aluno> alunos = new ArrayList<Aluno>();
			try {
				PreparedStatement ps = con.prepareStatement(
					"select * from aluno where nome like ? ");
				ps.setString( 1, "%" + nome + "%" );
				ResultSet rs = ps.executeQuery();
				while ( rs.next() ) { 
					Aluno a = new Aluno();
					a.setId( rs.getLong("id") );
					a.setRa( rs.getString("ra") );
					a.setNome( rs.getString("nome") );
					a.setNascimento( rs.getDate("nascimento") );
					alunos.add( a );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return alunos;
		}

		@Override
		public Peca buscar(int codigo) {
			try {
				PreparedStatement ps = con.prepareStatement(
					"select * from aluno where id = ? ");
				ps.setLong( 1, id );
				ResultSet rs = ps.executeQuery();
				if ( rs.next() ) { 
					Aluno a = new Aluno();
					a.setId( rs.getLong("id") );
					a.setRa( rs.getString("ra") );
					a.setNome( rs.getString("nome") );
					a.setNascimento( rs.getDate("nascimento") );
					return a;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	*/
}

