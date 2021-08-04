package com.pmb.moneytransfer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "the field firstname is mandatory")
    private String firstname;
    @NotBlank(message = "field lastname is mandatory")
    private String lastname;
    @Email(message = "please enter a valid email address")
    private String email;
    private String password;
    private double balance;





    public User(){}
    private User(UserBuilder userBuilder){
        this.id = userBuilder.id;
        this.firstname = userBuilder.firstname;
        this.lastname = userBuilder.lastname;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.balance = userBuilder.balance;
    }

    public static class UserBuilder{
        private long id;
        private String firstname;
        private String lastname;
        private String email;
        private String password;
        private double balance;

        public UserBuilder(long id, String email){
            this.id=id;
            this.email=email;
        }

        public UserBuilder firstname(String value){
            this.firstname=value;
            return this;
        }

        public UserBuilder lastname(String value){
            this.lastname=value;
            return this;
        }

        public UserBuilder password(String value){
            this.password=value;
            return this;
        }

        public UserBuilder balance(double value){
            this.balance=value;
            return this;
        }

        public User build(){
            User buildUser = new User(this);
            return buildUser;
        }
    }

}
