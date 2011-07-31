package facilius.model.pojo;

public class TurmaTipoNota {
	private Turma turma;
	private TipoNota tipoNota;
	Turma turmas;
	TipoNota notas;

	public void setTurmas(Turma turmas) {
		this.turmas = turmas;
	}

	public Turma getTurmas() {
		return this.turmas;
	}

	public void setNotas(TipoNota notas) {
		this.notas = notas;
	}

	public TipoNota getNotas() {
		return this.notas;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}

	public TipoNota getTipoNota() {
		return this.tipoNota;
	}
}