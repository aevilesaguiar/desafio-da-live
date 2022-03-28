package com.dio.livecoding.springboot.service;
import com.dio.livecoding.springboot.dto.UserDTO;
import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j //parte de log

public class UserService {
    @Autowired//injeção
    private final UserRepository userRepository; //injetando o userRepository nesse service
/**
 * //esse método nós estamos retornando todos os usuarios. 
 * O iterable implemta uma coleção em que os dados da coleção 
 * são recuperados por um foreach
 */

    public Iterable<UserModel> getUsers(){
        log.error("getUsers");
        return userRepository.findAll();
    }

    public UserModel getUser(Long id){
        return userRepository.findById(id).orElseThrow(()->{
            log.error("User not found with id{}",id);
            return new RuntimeException("User not found with id:"+id);
        });

    }

    //criar um usuario

    public UserModel createUser(UserDTO userDTO){ //estou passando o UserDto por que eu não preciso passar o Id, pq o Id vai ser gerado automaticamente pelo hibernate
        log.error("createUser");
        UserModel userModel= UserModel.builder()
                            .name(userDTO.getName())
                            .email(userDTO.getEmail())
                            .build();
        return userRepository.save(userModel);
    }

    //classe para atualizar

    public UserModel update(Long id, UserDTO userDTO){
       UserModel userModel=userRepository.findById(id).orElseThrow(()->{//se ele não encontrar o id ele gera uma exceção
       log.error("User not found with id {}",id);
       return new RuntimeException("User not found with id: "+ id);
       });
       //se ele não encontrar o registro ele cria, se ele encontrar ele atualiza(faz um update)
       userModel.setName(userDTO.getName());
       userModel.setEmail(userDTO.getEmail());
       return userRepository.save(userModel);
    }


    public UserModel delete(Long id){
        UserModel userModel=userRepository.findById(id).orElseThrow(()->{//se ele não encontrar o id ele gera uma exceção
            log.error("User not found with id {}",id);
            return new RuntimeException("User not found with id: "+ id);
            });
            //se ele encontrar ele dar um delete
            userRepository.delete(userModel);
            return userModel;//ele diz que foi excluido
    }

}



