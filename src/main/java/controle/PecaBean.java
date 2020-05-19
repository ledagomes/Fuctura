package controle;

import java.util.ArrayList;
import java.util.List;

import dao.PecaDAO;
import dao.PecaDAOImpl;
import entidade.Peca;

public class PecaBean {
	
	private Peca peca;
	private List<Peca> listaPecas;
	private PecaDAO pecaDAO;

	
	public PecaBean() {

		this.pecaDAO = new PecaDAOImpl();
		
		this.peca = new Peca();
		
		this.listaPecas = new ArrayList<Peca>();
		
		this.listaPecas = this.pecaDAO.listaPecas();
		
	}

	public void salvar() {

		this.pecaDAO.inserir(this.peca);
		this.peca = new Peca();
		
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public List<Peca> getListaPecas() {
		return listaPecas;
	}

	public void setListaPecas(List<Peca> listaPecas) {
		this.listaPecas = listaPecas;
	}

	
	
}
