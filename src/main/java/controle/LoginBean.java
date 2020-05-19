package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;

public class LoginBean {

	private String txtUsuario;
	private String txtSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario;
	private String msgCadastroUsuario;
	
	private UsuarioDAO usuarioDAO;

	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	
	public String entrar() {

		boolean achou = false;

		this.listaUsuarios = this.usuarioDAO.listaUsuarios();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (usuarioPesquisa.getEmail().equals(this.txtUsuario) && usuarioPesquisa.getEmail().equals(this.txtSenha)) {

				achou = true;
			}
		}

		if (achou) {
			return "";
		} else {
			return "";
		}

	}


	public void criarUsuario() {

		Usuario novo = new Usuario();

		novo.setNome(this.usuario.getNome());
		novo.setEmail(this.usuario.getEmail());
		novo.setSenha(this.usuario.getSenha());

		boolean achou = false;
		
		this.listaUsuarios = this.usuarioDAO.listaUsuarios();
		
		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getEmail().equals(this.usuario.getEmail())) {
				achou = true;
			}
		}
		
		if(achou) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario j� existe!!!"));
		}else {
			this.listaUsuarios.add(novo);
			this.usuarioDAO.inserir(novo);
			
			this.usuario = new Usuario();	
		}
	}

	public String getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(String txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMsgCadastroUsuario() {
		return msgCadastroUsuario;
	}

	public void setMsgCadastroUsuario(String msgCadastroUsuario) {
		this.msgCadastroUsuario = msgCadastroUsuario;
	}

}
