package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import entidade.Veiculo;
import util.ConnectionFactory;


public class VeiculoDAOImpl implements VeiculoDAO {


	public void inserir(Veiculo veiculo) {

		String sql = "insert into VEICULO (modelo, fabricante, placa, km) values (?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getFabricante());
			ps.setString(3, veiculo.getPlaca());
			ps.setInt(4, veiculo.getKm());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	public void alterar(Veiculo veiculo) {

		String sql = "UPDATE VEICULO SET modelo = ?, fabricante = ? where placa = ? , km = ?";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getFabricante());
			ps.setString(3, veiculo.getPlaca());
			ps.setDouble(3, veiculo.getKm());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Veiculo veiculo) {

		String sql = "DELETE FROM VEICULO WHERE plcaca = ?";

		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, veiculo.getModelo());
			ps.setString(2, veiculo.getFabricante());
			ps.setString(3, veiculo.getPlaca());
			ps.setInt(3, veiculo.getKm());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	
	public Veiculo pesquisar(String placa) {

		String sql = "select V.Fabricante, V.Modelo, V.Km from USUARIO U where Placa = ?";
		
		Veiculo veiculo = null;
		
		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, placa);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				veiculo = new Veiculo();
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setFabricante(res.getString("FABRICANTE"));
				veiculo.setPlaca(res.getString("PLACA"));
				veiculo.setKm(res.getInt("Km"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculo;
	}

	
	public List<Veiculo> listaVeiculos() {

		String sql = "select U.CPF, U.NOME, U.SENHA from USUARIO U";
		
		List<Veiculo> listaVeiculos = null;
		
		Connection conexao;
		try {
			conexao = ConnectionFactory.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(res.getString("MODELO"));
				veiculo.setFabricante(res.getString("NOME"));
				veiculo.setPlaca(res.getString("PLACA"));
				veiculo.setKm(res.getInt("KM"));
				
				listaVeiculos.add(veiculo);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaVeiculos;

	}

}
