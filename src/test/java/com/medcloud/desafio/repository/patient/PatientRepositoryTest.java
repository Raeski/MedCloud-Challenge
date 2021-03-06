package com.medcloud.desafio.repository.patient;

import com.medcloud.desafio.model.patient.Adress;
import com.medcloud.desafio.model.patient.Patient;
import com.medcloud.desafio.util.PatientCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes para repositório patient")
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;


    @Test
    @DisplayName("Persistir paciente em banco")
    void save_PersistPatient_WhenSuccessful(){
        Patient patientToBeSaved = PatientCreator.createPatientToBeSaved();

        Patient patientSaved = this.patientRepository.save(patientToBeSaved);

        Assertions.assertThat(patientSaved).isNotNull();
        Assertions.assertThat(patientSaved.getId()).isNotNull();

    }

}