package br.edu.ifpb.pweb.galeto.bean;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;

import br.edu.ifpb.pweb.galeto.controller.ControllerFacade;
import br.edu.ifpb.pweb.galeto.dao.DAO;
import br.edu.ifpb.pweb.galeto.dao.DAOAluno;
import br.edu.ifpb.pweb.galeto.dao.DAOProfessor;
import br.edu.ifpb.pweb.galeto.dao.DAOUsuario;
import br.edu.ifpb.pweb.galeto.model.Aluno;
import br.edu.ifpb.pweb.galeto.model.Professor;
import br.edu.ifpb.pweb.galeto.model.Usuario;




@SessionScoped
@ManagedBean(name="usuario")
public class UsuarioBean {
	
	private ControllerFacade facade = new ControllerFacade();
	
	private String user;
	private String login;
	private String senha;
	private String nome,email,titulo;
	private String nomeprofessor;
	private int fone;
	private long matricula;
	private String matriculaprofessor;
	private Usuario usuario;
	private Aluno aluno;
	private Professor professor;
	private Aluno alunoselecionado;
	private List<Aluno> alunos;
	private List<Professor> professores;
	
	@PostConstruct
	public void init(){
		
		Usuario usaurio = new Usuario("heremita","123","heremita@gmail.com",1);
		Usuario usaurio2 = new Usuario("valeria","123","valeria@gmail.com", 2);
		DAO dusuario = new DAOUsuario();
		
		dusuario.open();
		dusuario.begin();
		
		dusuario.create(usaurio);
		dusuario.create(usaurio2);
		dusuario.commit();

	}
	
	
	public String validarlogin() {
				
		usuario = facade.login(this.login, this.senha);
		
		if(usuario == null) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Autenticação invalida.","Usuario ou senha invalidos.");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);

			return null;
		}else{
			if (usuario.getTipo() == 1) {
				return "concluinte";
			}else{
				return "processo";
			}
			
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
	
	public void cadastrarProfessor(ActionEvent e){
		DAO.open();
		DAO.begin();
		professor = facade.VerificarProfessor(matriculaprofessor);
		if(professor == null){
			facade.cadastrarProfessor(this.nomeprofessor,this.matriculaprofessor);
			
		}else{
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Autenticação invalida.","Professor Ja Cadastrado");
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		DAO.commit();
		System.out.println("Professor Cadastrado");
	}

	
	public void listarAlunos(){

		DAOAluno daluno = new DAOAluno();
		this.alunos = daluno.readAll();
		
		
	}
	
	public void listarProfessor(){
		DAOProfessor dprofessor = new DAOProfessor();
		this.professores = dprofessor.readAll();
		
	}

	
	public String seleciona(Aluno aluno){
		this.alunoselecionado = aluno;
		this.loadFlash();
		return "aluno.jsf?faces-redirect=true";
	}
	public void loadFlash(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("aluno", this.alunoselecionado);
		flash.put("Alunos",this.alunos);
	}
	
	public void excluirAluno(Aluno aluno){
		DAOAluno daluno = new DAOAluno();
		daluno.begin();
		daluno.delete(daluno.findByMatricula(matricula));
		daluno.commit();
		this.listarAlunos();
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


	public String getNomeprofessor() {
		return nomeprofessor;
	}


	public void setNomeprofessor(String nomeprofessor) {
		this.nomeprofessor = nomeprofessor;
	}


	public String getMatriculaprofessor() {
		return matriculaprofessor;
	}


	public void setMatriculaprofessor(String matriculaprofessor) {
		this.matriculaprofessor = matriculaprofessor;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public List<Professor> getProfessores() {
		return professores;
	}


	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	
	
}
