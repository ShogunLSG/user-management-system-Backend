package com.LSG.UMS.Models;

import java.util.Objects;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    public User(Long id, String name, String email, String password, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //getter and setters
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }
     public String getName() {
         return this.name;
     }

     public void setName(String name) {
         this.name = name;
     }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return this.role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "{" +
                    " id='" + getId() + "'" +
                    ", name='" + getName() + "'" +
                    ", email='" + getEmail() + "'" +
                    ", password='" + getPassword() + "'" +
                    ", role='" + getRole() + "'" +
                    "}";
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
        }
}
