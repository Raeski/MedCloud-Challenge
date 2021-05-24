package com.medcloud.desafio.repository.patient;

import com.medcloud.desafio.model.patient.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
}
