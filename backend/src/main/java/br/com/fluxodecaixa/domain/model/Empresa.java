package br.com.fluxodecaixa.domain.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Data
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(columnDefinition = "uuid", name = "emp_id", nullable = false, updatable = false)
    private UUID id;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "emp_razao_social")
    private String razaoSocial;

    @NotEmpty
    @Size(max = 14)
    @Column(name = "emp_inscricao")
    private String inscricao;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_email")
    private String email;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_endereco")
    private String endereco;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "emp_telefone")
    private String telefone;

    @Column(name = "emp_ativa")
    private Boolean ativa;

}
