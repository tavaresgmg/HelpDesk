package com.tavaresgmg.helpdesk.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Chamado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.Auto)

    private Long id;

    private String titulo;
    private String descricao;
    private String status;
    private String prioridade;
    private Date dataCriacao;
    private Long idUsuario;
}
