package facilius.model.pojo;

public class ValorNota {
	private Long id;
	private float valor;
	TipoNota tipo;

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return this.valor;
	}
}