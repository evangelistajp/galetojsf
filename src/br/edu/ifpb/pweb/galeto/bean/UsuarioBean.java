package br.edu.ifpb.pweb.galeto.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.ifpb.pweb.galeto.controller.ControllerFacade;
import br.edu.ifpb.pweb.galeto.dao.DAO;
import br.edu.ifpb.pweb.galeto.dao.DAOAluno;
import br.edu.ifpb.pweb.galeto.dao.DAOUsuario;
import br.edu.ifpb.pweb.galeto.model.Aluno;
import br.edu.ifpb.pweb.galeto.model.Usuario;




@SessionScoped
@ManagedBean(name="usuario")
public class UsuarioBean {
	
	private ControllerFacade facade = new ControllerFacade();
	
	private String user;
	private String login;
	private String senha;
	private String nome,email,titulo;
	private int fone;
	private long matricula;
	private Usuario usuario;
	private Aluno aluno;
	private List<Aluno> alunos;
	
	
	@PostConstruct
	public void init(){
		
		Usuario usaurio = new Usuario("gg","gg","gg");
		DAO dusuario = new DAOUsuario();
		
		System.out.println("ok1");
		dusuario.open();
		dusuario.begin();
		
		dusuario.create(usaurio);
		dusuario.commit();
		System.out.println("ok2");
	}
	
	
	public String validarlogin() {
				
		usuario = facade.login(login, senha);
		
		if(usuario == null) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Autenticação invalida.","Usuario ou senha invalidos.");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//			DAO.close();
			return null;
		}else{
			return "concluinte";
		}
		
	}
	
	public void cadastraAluno(ActionEvent e){
		DAO.open();
		DAO.begin();
		aluno = facade.VerificarMatricula(matricula);
		if(aluno == null){
			facade.cadastrarAluno(this.nome,this.matricula,this.email,this.fone);
		}
		else{
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Autenticação invalida.","Aluno Ja Cadastrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		DAO.commit();
		System.out.println("Aluno Cadastrado");
	}
	
	public void listarAlunos(){

		DAOAluno daluno = new DAOAluno();
		this.alunos = daluno.readAll();
		//System.out.println(this.alunos.size());
		
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public ControllerFacade getFacade() {
		return facade;
	}

	public void setFacade(ControllerFacade facade) {
		this.facade = facade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
}
