package src;

public class chamados {
    private int id;
    private String titulo;
    private String descricao;
    private String status;
    private String prioridade;
    private Date dataCriacao;
    private int idUsuario;

    public void Chamados (int id, String titulo, String descricao, String status, String prioridade, Date dataCriacao, int idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.prioridade = prioridade;
        this.dataCriacao = dataCriacao;
        this.idUsuario = idUsuario;
    }
}
