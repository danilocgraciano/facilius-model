package facilius.model.pojo;

public class Frequencia {
	private Long id;
	private UsuarioCurso usuarioCurso;
	private Aula aula;
	private boolean status;

	public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
		this.usuarioCurso = usuarioCurso;
	}

	public UsuarioCurso getUsuarioCurso() {
		return this.usuarioCurso;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Aula getAula() {
		return this.aula;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return this.status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}