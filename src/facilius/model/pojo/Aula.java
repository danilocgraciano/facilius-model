package facilius.model.pojo;

import java.util.ArrayList;

public class Aula {
	private Long id;
	private String titulo;
	private String descricao;
	private String data;
	ArrayList<Frequencia> turmaFrequencia = new ArrayList<Frequencia>();
	ArrayList<Material> materiais = new ArrayList<Material>();

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return this.data;
	}
}