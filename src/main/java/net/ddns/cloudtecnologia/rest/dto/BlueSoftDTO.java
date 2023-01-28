package net.ddns.cloudtecnologia.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlueSoftDTO {
    private String titulo;
    private String gtinEanUpc;
    private String ncm;
    private String categoria;
    private String descricao;
}
