package com.trainitg.eventsourcing.rest.repository;

import com.trainitg.eventsourcing.rest.entity.OpenAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountJPARepository extends JpaRepository<OpenAccountEntity,String> {

}
