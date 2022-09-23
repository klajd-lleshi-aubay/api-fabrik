package com.sella.api.repository;

import com.sella.api.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
    TransactionType findByEnumerationAndValue(String enumeration, String value);
}
