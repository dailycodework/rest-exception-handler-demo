package com.fixdecode.restexceptiondemo.model;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllUsers(){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("Users found", userService.getAllUsers()))
                        .status(HttpStatus.OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping
    public ResponseEntity<ResponseMessage> addUser(@RequestBody @Valid User user){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("A new was added",userService.addUser(user)))
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                ResponseMessage.builder()
                        .data(Map.of("User found", userService.getUser(id)))
                        .status(HttpStatus.OK)
                        .statusCode(OK.value())
                        .build());
    }

}
