package br.com.fluxodecaixa.interfaces.transfer.util;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
public class IdDto {
    @NotNull
    UUID id;
}
