package com.projeto.skillhub.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "solicitacao_servico_id")
    private SolicitacaoServico solicitacaoServico;



    @ManyToOne
    @JoinColumn(name = "usuario_avaliador_id")
    private Usuario usuarioAvaliador;

    private Integer nota;
    private String comentario;



}
