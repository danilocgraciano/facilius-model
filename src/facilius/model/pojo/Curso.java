package facilius.model.pojo;

import java.util.ArrayList;

public class Curso {
	private Long id;
	private String descricao;
	private ArrayList<UsuarioCurso> usuarioCurso;
	private ArrayList<Disciplina> disciplinas;

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<UsuarioCurso> getUsuarioCurso() {
		return usuarioCurso;
	}

	public void setUsuarioCurso(ArrayList<UsuarioCurso> usuarioCurso) {
		this.usuarioCurso = usuarioCurso;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}