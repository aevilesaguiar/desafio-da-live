package com.dio.livecoding.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_user") //nome da tabela
@Data //implementa a parte do get/sett
@Builder //quando eu quero criar uma instancia dessa classe
@NoArgsConstructor//construtores sem argumento
@AllArgsConstructor//construtores com argumentos
public class UserModel {

    @Id //ele é primary key
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)//informa a estrategia que estou usando, o BD, o jpa e o hibernete gerar um id incremental 
    private Long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "E-mail is required")
    @Email(message = "E-mail is invalid")
    private String email;

    
}
