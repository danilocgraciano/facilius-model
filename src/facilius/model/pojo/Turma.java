package facilius.model.pojo;

import java.util.ArrayList;

public class Turma {
	private long id;
	private String descricao;
	private int ano;
	ArrayList<UsuarioCursoTurma> usuarioTurma = new ArrayList<UsuarioCursoTurma>();
	ArrayList<TurmaTipoNota> turmaTipoNota = new ArrayList<TurmaTipoNota>();

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
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
}