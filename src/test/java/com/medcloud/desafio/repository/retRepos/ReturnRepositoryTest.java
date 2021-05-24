package com.medcloud.desafio.repository.retRepos;

import com.medcloud.desafio.model.retPatient.Return;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
@DataJpaTest
@DisplayName("Testes para repositório return")
class ReturnRepositoryTest {

    @Autowired
    private ReturnRepository returnRepository;

    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @Test
    @DisplayName("Persistir nome e timestamp do paciente em banco")
    void save_PersistPatient_WhenSuccessful(){
        Return returnToBeSaved = createReturnToBeSaved();

        Return returnSaved = this.returnRepository.save(returnToBeSaved);

        Assertions.assertThat(returnSaved).isNotNull();
        Assertions.assertThat(returnSaved.getId()).isNotNull();

    }

    private Return createReturnToBeSaved(){
        return Return.builder()
                .name("Teste")
                .timestamp(timestamp)
                .build();
    }
}