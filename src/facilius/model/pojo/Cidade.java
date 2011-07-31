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
}