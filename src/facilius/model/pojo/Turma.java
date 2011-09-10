package facilius.model.pojo;

import java.util.ArrayList;

public class Turma {
	private Long id;
	private String descricao;
	private int ano;
	private ArrayList<UsuarioCursoTurma> usuarioTurma;
	private ArrayList<TurmaTipoNota> turmaTipoNota;
        private Disciplina disciplina;
        private Usuario professor;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return this.ano;
	}

	public ArrayList<UsuarioCursoTurma> getUsuarioTurma() {
		return usuarioTurma;
	}

	public void setUsuarioTurma(ArrayList<UsuarioCursoTurma> usuarioTurma) {
		this.usuarioTurma = usuarioTurma;
	}

	public ArrayList<TurmaTipoNota> getTurmaTipoNota() {
		return turmaTipoNota;
	}

	public void setTurmaTipoNota(ArrayList<TurmaTipoNota> turmaTipoNota) {
		this.turmaTipoNota = turmaTipoNota;
	}

    @Override
    public String toString() {
        return getDescricao() + " - " + getAno();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }


}