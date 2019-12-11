package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "usuario", schema = "public")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "usu_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "usu_emp_id", referencedColumnName = "emp_id")
    private Empresa empresa;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "usu_email", unique = true)
    private String email;

    @Size(max = 255)
    @NotEmpty
    @Column(name = "usu_senha")
    private String senha;

    @Column(name = "usu_ativo")
    private Boolean ativo;

}
