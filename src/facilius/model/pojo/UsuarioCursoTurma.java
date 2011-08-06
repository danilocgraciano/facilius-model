package facilius.model.pojo;

import java.util.ArrayList;

public class UsuarioCursoTurma {
	private Long id;
	private UsuarioCurso usuarioCurso;
	private Turma turma;
	private ArrayList<ValorNota> notas;
	private ArrayList<Frequencia> turmaFrequencia;

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

	public ArrayList<ValorNota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<ValorNota> notas) {
		this.notas = notas;
	}

	public ArrayList<Frequencia> getTurmaFrequencia() {
		return turmaFrequencia;
	}

	public void setTurmaFrequencia(ArrayList<Frequencia> turmaFrequencia) {
		this.turmaFrequencia = turmaFrequencia;
	}
}