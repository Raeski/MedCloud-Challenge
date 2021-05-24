package com.medcloud.desafio.repository.patient;

import com.medcloud.desafio.model.patient.Adress;
import com.medcloud.desafio.model.patient.Patient;
import com.medcloud.desafio.util.PatientCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes para repositório adress")
class AdressRepositoryTest {

    @Autowired
    private AdressRepository adressRepository;

    @Test
    @DisplayName("Persistir paciente em banco")
    void save_PersistPatient_WhenSuccessful(){
        Adress adressToBeSaved = createAdress;

        Adress adressSaved = this.adressRepository.save(adressToBeSaved);

        Assertions.assertThat(adressSaved).isNotNull();
        Assertions.assertThat(adressSaved.getId()).isNotNull();

    }

     Adress createAdress = new Adress( "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste", "Teste");


}