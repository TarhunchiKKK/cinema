package org.example.profiles;

import org.example.shared.interfaces.IHaveId;
import org.example.shared.interfaces.IPrintable;

public class Profile implements IHaveId, IPrintable {
    private Long id;

    private String email;

    private String password;

    private String role;

    public Profile(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Profile(Long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void print() {
        System.out.printf("%4d %20s %20s %s\n", this.id, this.email, this.password, this.role);
    }
}
