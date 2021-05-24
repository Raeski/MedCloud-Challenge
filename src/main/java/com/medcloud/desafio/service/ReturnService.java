package com.medcloud.desafio.service;

import com.medcloud.desafio.model.patient.Patient;
import com.medcloud.desafio.model.retPatient.Return;
import com.medcloud.desafio.repository.retRepos.ReturnRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class ReturnService {

    @Autowired
    private ReturnRepository returnRepository;

    public Return saveSecondDataBase (Patient patient) throws Exception {
        try {
            Return aReturn = new Return();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            aReturn.setName(patient.getName());
            aReturn.setTimestamp(timestamp);
            return returnRepository.save(aReturn);
        } catch (Exception e) {
            throw new Exception("FAIL_TO_PERSIST_OBJECT_IN_DATABASE");
        }
    }
}
