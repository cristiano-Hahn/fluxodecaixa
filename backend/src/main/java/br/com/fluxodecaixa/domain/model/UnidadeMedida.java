package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "unidade_medida")
public class UnidadeMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "und_id", nullable = false, updatable = false)
    private UUID id;

    @NotNull
    @Column(name = "und_codigo")
    private Integer codigo;

    @Size(max = 3)
    @NotEmpty
    @Column(name = "und_sigla")
    private String sigla;

    @Size(max = 100)
    @NotEmpty
    @Column(name = "und_descricao")
    private String descricao;

}
