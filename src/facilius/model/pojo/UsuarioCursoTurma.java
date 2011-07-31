package facilius.model.pojo;

import java.util.ArrayList;

public class UsuarioCursoTurma {
	private UsuarioCurso usuarioCurso;
	private Turma turma;
	ArrayList<ValorNota> notas = new ArrayList<ValorNota>();
	ArrayList<Frequencia> turmaFrequencia = new ArrayList<Frequencia>();
	UsuarioCurso usuarios;
	Turma turmas;

	public void setUsuarios(UsuarioCurso usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioCurso getUsuarios() {
		return this.usuarios;
	}

	public void setTurmas(Turma turmas) {
		this.turmas = turmas;
	}

	public Turma getTurmas() {
		return this.turmas;
	}

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
}