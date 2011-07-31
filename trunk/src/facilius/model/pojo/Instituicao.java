package facilius.model.pojo;

public class Instituicao {
	private Long id;
	private String nome;
	private String endereco;
	private String bairro;
	private String numero;
	private String telefone1;
	private String telefone2;
	private byte logo;
	Cidade cidade;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone1() {
		return this.telefone1;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone2() {
		return this.telefone2;
	}

	public void setLogo(byte logo) {
		this.logo = logo;
	}

	public byte getLogo() {
		return this.logo;
	}
}