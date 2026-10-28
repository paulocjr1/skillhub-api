package com.projeto.skillhub.entity;


import com.projeto.skillhub.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "solicitacoes_servicos")
public class SolicitacaoServico {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "usuario_solicitante_id")
    private Usuario usuarioSolicitante;

    @ManyToOne
    @JoinColumn(name = "usuario_prestador_id")
    private Usuario usuarioPrestador;

    @ManyToOne
    @JoinColumn(name = "servico_oferecido_id")
    private ServicoOferecido servicoOferecido;



    @CreationTimestamp
    private LocalDateTime dataRealizacao;

    @UpdateTimestamp
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusSolicitacao status;
}
