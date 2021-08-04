package com.pmb.moneytransfer.dto;

import com.pmb.moneytransfer.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO {
    String lastname;
    String description;
    double amount;
}
