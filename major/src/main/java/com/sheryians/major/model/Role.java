package com.sheryians.major.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int roleId;

    @Column(nullable = false,unique = true)
    @NotEmpty
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
