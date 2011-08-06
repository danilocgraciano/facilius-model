package facilius.model.pojo;

public class ValorNota {

	private Long id;
	private float valor;
	private TipoNota tipoNota;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return this.valor;
	}

	public TipoNota getTipoNota() {
		return tipoNota;
	}

	public void setTipoNota(TipoNota tipoNota) {
		this.tipoNota = tipoNota;
	}
}