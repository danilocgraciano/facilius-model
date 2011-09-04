package facilius.model.pojo;

public class Cidade {
	private Long id;
	private String descricao;
	private String uf;

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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

    @Override
    public String toString() {
        return getDescricao() + " - " + getUf();
    }

}