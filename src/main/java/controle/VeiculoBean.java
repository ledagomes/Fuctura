package controle;

import java.util.ArrayList;
import java.util.List;

import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Veiculo;

public class VeiculoBean {
	
	private Veiculo veiculo;
	private List<Veiculo> listaVeiculos;
	private VeiculoDAO veiculoDAO;

	
	public VeiculoBean() {

		this.veiculoDAO = new VeiculoDAOImpl();
		
		this.veiculo = new Veiculo();
		
		this.listaVeiculos = new ArrayList<Veiculo>();
		
		this.listaVeiculos = this.veiculoDAO.listaVeiculos();
		
	}

	public void salvar() {

		this.veiculoDAO.inserir(this.veiculo);
		this.veiculo = new Veiculo();
		
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	
}
