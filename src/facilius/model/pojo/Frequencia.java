package facilius.model.pojo;

public class Frequencia {
	private Long id;
	private UsuarioCursoTurma usuarioCursoTurma;
	private Aula aula;
	private java.util.Date data;
	private boolean status;
	private UsuarioCursoTurma turma;

	public void setTurma(UsuarioCursoTurma turmas) {
		this.turma = turmas;
	}

	public UsuarioCursoTurma getTurmas() {
		return this.turma;
	}

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

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}