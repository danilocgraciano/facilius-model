package facilius.model.pojo;

public class TipoNota {

    private Long id;
    private boolean oficial;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOficial(boolean oficial) {
        this.oficial = oficial;
    }

    public boolean isOficial() {
        return this.oficial;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

}
