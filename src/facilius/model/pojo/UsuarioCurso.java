package facilius.model.pojo;


public class UsuarioCurso {
	private Long id;
	private Long matricula;
	private Curso curso;
	private Usuario usuario;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}