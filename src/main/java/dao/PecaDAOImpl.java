package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidade.Peca;
import util.ConnectionFactory;

public class PecaDAOImpl implements PecaDAO {

	public void inserir(Peca peca) {

		String sql = "insert into PECA (nome, quantidade, precoUnitario, ) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, peca.getNome());
			ps.setDouble(2, peca.getQuantidade());
			ps.setDouble(3, peca.getPrecoUnitario());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public void alterar(Peca peca) {

		String sql = "UPDATE PECA SET nome = ?, quantidade = ? , precoUnitario = ? where ID = ?";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, peca.getNome());
			ps.setDouble(2, peca.getQuantidade());
			ps.setDouble(3, peca.getPrecoUnitario());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Peca peca) {

		String sql = "DELETE FROM PECA WHERE Id = ?";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setDouble(1, peca.getId());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

		public Peca pesquisar(String Id) {

		String sql = "select P.NOME, P.QUANTIDADE, P.PRECO_UNITARIO from PECA U where id = ?";
		
		Peca peca = null;
		
		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, Id);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				peca = new Peca();
				peca.setQuantidade(res.getDouble("QUANTIDADE"));
				peca.setNome(res.getString("NOME"));
				peca.setPrecoUnitario(res.getDouble("PRECO_UNITARIO"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return peca;
	}

	public List<Peca> listaPecas() {

		String sql = "select P.NOME, P.QUANTIDADE, P.PRECO_UNITARIO from PECA P where id = ?";
		
		List<Peca> listaPecas = null;
		
		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Peca peca = new Peca();
				peca.setQuantidade(res.getDouble("QUANTIDADE"));
				peca.setNome(res.getString("NOME"));
				peca.setPrecoUnitario(res.getDouble("PRECO_UNITARIO"));
				
				listaPecas.add(peca);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaPecas;

	}

}
