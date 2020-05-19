package entidade;

import java.util.List;


public class Veiculo {

	private String modelo;
	private String fabricante;
	private int km;
	private String placa;
	
	
	private List<Peca> pecas;
	

		public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public List<Peca> getPecas() {
		return pecas;
	}


	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}


	public int getKm() {
		return km;
	}


	public void setKm(int km) {
		this.km = km;
	}

}
