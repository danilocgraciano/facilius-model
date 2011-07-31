package facilius.model.pojo;

import java.util.ArrayList;

public class Usuario {
	private Long id;
	private String login;
	private String nome;
	private byte foto;
	private String senha;
	private String email;
	private int tipo;
	ArrayList<UsuarioCurso> usuarioCurso = new ArrayList<UsuarioCurso>();

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setFoto(byte foto) {
		this.foto = foto;
	}

	public byte getFoto() {
		return this.foto;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return this.tipo;
	}
}