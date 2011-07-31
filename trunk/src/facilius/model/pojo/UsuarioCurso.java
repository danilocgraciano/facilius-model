package facilius.model.pojo;

import java.util.ArrayList;

public class UsuarioCurso {
	private Long matricula;
	private Curso curso;
	private Usuario usuario;
	ArrayList<UsuarioCursoTurma> usuarioTurma = new ArrayList<UsuarioCursoTurma>();
	Usuario usuarios;
	Curso cursos;

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarios() {
		return this.usuarios;
	}

	public void setCursos(Curso cursos) {
		this.cursos = cursos;
	}

	public Curso getCursos() {
		return this.cursos;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Long getMatricula() {
		return this.matricula;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}