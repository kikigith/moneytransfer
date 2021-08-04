package com.pmb.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)//cette seule relation suffit
    @JoinColumn(name="user1", nullable=false)
    private User user1;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user2", nullable=false)
    private User user2;

}
