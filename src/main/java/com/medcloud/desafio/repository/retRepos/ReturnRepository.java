package com.medcloud.desafio.repository.retRepos;

import com.medcloud.desafio.model.retPatient.Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnRepository  extends JpaRepository<Return, Long> {
}
