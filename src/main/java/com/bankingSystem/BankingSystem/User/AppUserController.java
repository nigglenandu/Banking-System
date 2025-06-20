package com.bankingSystem.BankingSystem.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appUsers")
public class AppUserController {
    @Autowired
    private IServiceAppUser serviceAppUser;

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerAppUser(@RequestBody AppUser appUser){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceAppUser.save(appUser));
    }

    @GetMapping("/{appUser}")
    public ResponseEntity<AppUser> getUserByUsername(@PathVariable String appUser){
        return serviceAppUser.findUserByUsername(appUser)
                .map(value -> ResponseEntity.ok(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.ok(serviceAppUser.getAllUsers());
    }
}