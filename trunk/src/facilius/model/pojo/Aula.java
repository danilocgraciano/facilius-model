package facilius.model.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Aula {
	private Long id;
	private String titulo;
	private String descricao;
	private Date data;
        private Turma turma;
	private ArrayList<Frequencia> turmaFrequencia;
	private ArrayList<Material> materiais;

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

	public void setData(java.util.Date data) {
		this.data = data;
	}

	public java.util.Date getData() {
		return this.data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Frequencia> getTurmaFrequencia() {
		return turmaFrequencia;
	}

	public void setTurmaFrequencia(ArrayList<Frequencia> turmaFrequencia) {
		this.turmaFrequencia = turmaFrequencia;
	}

	public ArrayList<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(ArrayList<Material> materiais) {
		this.materiais = materiais;
	}

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return getTitulo();
    }


}