package com.pmb.moneytransfer.repository;

import com.pmb.moneytransfer.dto.TransactionDTO;
import com.pmb.moneytransfer.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    @Query("SELECT new com.pmb.moneytransfer.dto.TransactionDTO(u.lastname, t.description, t.amount) FROM User u " +
            "INNER JOIN Transaction t ON t.beneficiary.id=u.id WHERE t.sender.id=(SELECT id FROM User WHERE email=:userEmail) order by t.transactionDate desc")
    List<TransactionDTO> getUserTransactions(@Param("userEmail") String userEmail);
}
