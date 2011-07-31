package facilius.model.pojo;

import java.util.ArrayList;

public class Curso {
	private long id;
	private String descricao;
	ArrayList<UsuarioCurso> usuarioCurso = new ArrayList<UsuarioCurso>();
	ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
}