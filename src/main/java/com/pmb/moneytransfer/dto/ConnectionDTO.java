package com.pmb.moneytransfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConnectionDTO {
    private long id;
    private String email;
    private String firstname;
    private String lastname;
}
