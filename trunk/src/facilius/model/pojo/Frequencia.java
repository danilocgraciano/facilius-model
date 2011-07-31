package facilius.model.pojo;

public class Frequencia {
	private UsuarioCursoTurma usuarioCursoTurma;
	private Aula aula;
	private String nome;
	private boolean status;
	UsuarioCursoTurma turmas;
	Aula aulas;

	public void setTurmas(UsuarioCursoTurma turmas) {
		this.turmas = turmas;
	}

	public UsuarioCursoTurma getTurmas() {
		return this.turmas;
	}

	public void setAulas(Aula aulas) {
		this.aulas = aulas;
	}

	public Aula getAulas() {
		return this.aulas;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return this.status;
	}
}