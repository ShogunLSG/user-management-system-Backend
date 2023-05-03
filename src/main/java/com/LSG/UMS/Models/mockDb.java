package com.LSG.UMS.Models;

import com.LSG.UMS.Models.User;

import java.util.List;

public class mockDb {

    public List<User> users;
    public mockDb() {
        this.users = List.of(
                new User("Miguel","miguel@gmail.com", "12345678", true),
                new User("Pepe","pepeTheFrog@gmail.com", "12345678", false),
                new User("IShowSpeed","Siwi7@gmail.com", "Suiiii", false)
        );
    }


    }