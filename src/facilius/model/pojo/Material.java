package facilius.model.pojo;

public class Material {
	private Long id;
	private String nome;
	private String descricao;
	private byte arquivo;
        private Aula aula;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setArquivo(byte arquivo) {
		this.arquivo = arquivo;
	}

	public byte getArquivo() {
		return this.arquivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
}