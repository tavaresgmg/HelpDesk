package src;
import java.util.Date;

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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitulo(int id){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public String getPrioridade(){
        return prioridade;
    } 

    public void setPrioridade(String prioridade){
        this.prioridade = prioridade;
    }

    public Date getDataCriacao(){
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
}


