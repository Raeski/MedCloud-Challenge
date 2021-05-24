package com.medcloud.desafio.service;

import com.medcloud.desafio.controller.AdressController;
import com.medcloud.desafio.model.patient.Adress;
import com.medcloud.desafio.repository.patient.AdressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private AdressController adressController;

    public Adress getAdress(String cep) {
        Adress getCep = adressController.obterCep(cep);
        return adressRepository.save(getCep);
    }
}
