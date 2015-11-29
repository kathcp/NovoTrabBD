package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.PecaDao;
import dao.PecaDaoImp;
import model.Peca;

@ManagedBean
@SessionScoped
public class PecaMB implements Serializable{

	private static final long serialVersionUID = 9066993122881238696L;
	
	private Peca pecaAtual = new Peca();
	private PecaDao pecaDAO = new PecaDaoImp();
	private List<Peca> pecas = new ArrayList<Peca>();
	
		
	public Peca getPecaAtual() {
		return pecaAtual;
	}

	public void setPecaAtual(Peca pecaAtual) {
		this.pecaAtual = pecaAtual;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public String adicionar() {

		try {
			pecaDAO.adicionar(pecaAtual);
			pecaAtual = new Peca();
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Peça adicionada com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao adicionar a peça!", ""));
			e.printStackTrace();
		}
		return "";
	}
	
	public String remover(Peca p) {
		try {
			pecaDAO.remover(p);
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Peça excluida com sucesso!", ""));
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir a peça!", ""));
			e.printStackTrace();
		}
		return "";
	}
	
	public String listarPorId(int id){
		try {
			pecas = pecaDAO.listarPorId(id);
		} catch (Exception e) {
			FacesContext fc = FacesContext.getCurrentInstance();
			fc.addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar peças!", ""));
			e.printStackTrace();
		}
		return "";
	}
	
	public void refresh() {
		pecaAtual = new Peca();
	}
	
}
