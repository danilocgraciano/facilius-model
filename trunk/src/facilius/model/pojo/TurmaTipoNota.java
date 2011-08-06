package facilius.model.pojo;

public class TurmaTipoNota {
	private Long id;
	private Turma turma;
	private TipoNota tipoNota;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}