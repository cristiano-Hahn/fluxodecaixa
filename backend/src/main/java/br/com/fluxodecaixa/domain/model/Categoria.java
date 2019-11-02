package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(columnDefinition = "uuid", name = "cat_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "cat_emp_id", referencedColumnName = "emp_id")
    private Empresa empresa;

    @NotNull
    @Column(name = "cat_codigo", unique = true)
    private Integer codigo;

    @Size(max = 100)
    @NotEmpty
    @Column(name = "cat_descricao")
    private String descricao;
}
