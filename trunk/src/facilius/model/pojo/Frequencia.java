package facilius.model.pojo;

public class Frequencia {
	private Long id;
	private UsuarioCursoTurma usuarioCursoTurma;
	private Aula aula;
	private boolean status;

	public void setUsuarioCursoTurma(UsuarioCursoTurma usuarioCursoTurma) {
		this.usuarioCursoTurma = usuarioCursoTurma;
	}

	public UsuarioCursoTurma getUsuarioCursoTurma() {
		return this.usuarioCursoTurma;
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