package com.fiap.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cliente")
public class UserCredential {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String cpf;

}