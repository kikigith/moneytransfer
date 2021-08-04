package com.pmb.moneytransfer.repository;

import com.pmb.moneytransfer.dto.ConnectionDTO;
import com.pmb.moneytransfer.model.Connection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer> {
    @Query("SELECT new com.pmb.moneytransfer.dto.ConnectionDTO(u.id,u.email,u.firstname,u.lastname) FROM User u " +
            "INNER JOIN Connection c ON c.user1=u.id WHERE c.user2=(SELECT id FROM User WHERE email=:userEmail)") //WHERE c.user2=(SELECT id FROM User WHERE email=:userEmail)
    List<ConnectionDTO> getUserConnections(@Param("userEmail") String userEmail);
}
