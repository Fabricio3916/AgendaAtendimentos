package dev.add.AgendaAtendimentos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_tecnico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    @OneToMany(mappedBy = "tecnico")
    private List<Atendimento> atendimentos = new ArrayList<>();

}
