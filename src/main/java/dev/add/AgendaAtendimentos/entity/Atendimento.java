package dev.add.AgendaAtendimentos.entity;

import dev.add.AgendaAtendimentos.entity.enums.Status;
import dev.add.AgendaAtendimentos.entity.enums.TipoAtendimento;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_atendimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipoAtendimento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @Column(name = "abertura")
    @CreationTimestamp
    private LocalDateTime aberturaAtendimento;

}
