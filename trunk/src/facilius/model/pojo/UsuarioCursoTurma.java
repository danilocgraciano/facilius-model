package facilius.model.pojo;

public class UsuarioCursoTurma {
	private Long id;
	private UsuarioCurso usuarioCurso;
	private Turma turma;

	public void setUsuarioCurso(UsuarioCurso usuarioCurso) {
		this.usuarioCurso = usuarioCurso;
	}

	public UsuarioCurso getUsuarioCurso() {
		return this.usuarioCurso;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Override
    public String toString() {
        return getUsuarioCurso().getMatricula() + " - " + getUsuarioCurso().getUsuario().getNome();
    }

}