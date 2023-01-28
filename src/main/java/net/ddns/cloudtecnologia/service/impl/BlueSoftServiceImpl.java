package net.ddns.cloudtecnologia.service.impl;

import net.ddns.cloudtecnologia.client.CosmosBlue;
import net.ddns.cloudtecnologia.rest.dto.BlueSoftDTO;
import net.ddns.cloudtecnologia.service.BlueSoftService;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BlueSoftServiceImpl implements BlueSoftService {

    CosmosBlue clienteBlueSoft = new CosmosBlue();

    @Override
    public BlueSoftDTO findProdutoByCode(String code) {
        return clienteBlueSoft.resposta(code);
    }

}
