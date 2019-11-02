package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @NotNull
    @Column(name = "cat_codigo")
    private Integer codigo;

    @Size(max = 100)
    @NotEmpty
    @Column(name = "cat_descricao")
    private String descricao;
}
