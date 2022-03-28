package com.dio.livecoding.springboot.controller;

import javax.validation.Valid;

import com.dio.livecoding.springboot.dto.UserDTO;
import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")//aqui eu versionei
public class UserController {
    //injeção de dependencia
    @Autowired
    private final UserService userService;

    //para retornar todos os usuarios
    //quando eu digitar v1/users ele chama esse método
    @GetMapping //Anotação para mapear GETsolicitações HTTP
    public ResponseEntity<Iterable<UserModel>>getUsers(){
        return ResponseEntity.ok(userService.getUsers());//retornando o statuscode 200
    }
    //retornar um determinado usuário
    @GetMapping("/{id}") //fazer a rota quando eu passo um id
    public ResponseEntity<UserModel> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping //criando um determinado usuario
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }
    @PutMapping("/{id}") //como parametro a rota
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userService.update(id, userDTO));
    }
    @DeleteMapping("/{id}") //como parametro a rota
    public ResponseEntity<UserModel> delete(@PathVariable Long id){
        return ResponseEntity.ok(userService.delete(id));
    }

}
