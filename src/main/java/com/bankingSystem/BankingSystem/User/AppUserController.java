package com.bankingSystem.BankingSystem.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appUsers")
public class AppUserController {
    @Autowired
    private IServiceAppUser serviceAppUser;

    @PostMapping("/register")
    public ResponseEntity<AppUser>  registerAppUser(@RequestBody AppUser appUser){
        return new ResponseEntity<>(serviceAppUser.save(appUser), HttpStatus.CREATED);
    }

    @GetMapping("/{appUser}")
    public ResponseEntity<AppUser> getUserByUsername(@PathVariable String appUser){
        return serviceAppUser.findUserByUsername(appUser)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return new ResponseEntity<>(serviceAppUser.getAllUsers(), HttpStatus.OK);
    }
}
