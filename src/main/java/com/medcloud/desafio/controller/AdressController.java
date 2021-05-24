package com.medcloud.desafio.controller;


import com.medcloud.desafio.model.patient.Adress;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("getCep")
@AllArgsConstructor
public class AdressController {


    @GetMapping(value = "/{cep}")
    public Adress obterCep(@PathVariable(name = "cep") String cep) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            String uri = "http://viacep.com.br/ws/{cep}/json/";
            Map<String, String> params = new HashMap<String, String>();
            params.put("cep", cep);
            Adress forObject = restTemplate.getForObject(uri, Adress.class, params);
            return forObject;
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), " CEP inválido");
        }
    }

}
