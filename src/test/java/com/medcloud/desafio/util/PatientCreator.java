package com.medcloud.desafio.util;

import com.medcloud.desafio.model.patient.Adress;
import com.medcloud.desafio.model.patient.Patient;

public class PatientCreator {


    public static Adress createAdress = new Adress(1L, "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste");

    public static Patient createPatientToBeSaved(){
        return Patient.builder()
                .name("Teste")
                .sexo("Teste")
                .email("Teste")
                .dataDeNascimento("Teste")
                .doencas("Teste")
                .id_adress(createAdress)
                .build();
    }
}
