package net.ddns.cloudtecnologia.service;

import net.ddns.cloudtecnologia.rest.dto.BlueSoftDTO;

public interface BlueSoftService {
    BlueSoftDTO findProdutoByCode(String code);
}
