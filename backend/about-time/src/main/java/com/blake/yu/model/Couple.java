package com.blake.yu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "couple")
public class Couple implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "meet_at")
    private Date meetAt;

    @Column(name = "together_at")
    private Date togetherAt;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "couple")
    private List<Account> accounts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "couple")
    private List<ToDoList> toDoLists;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "couple")
    private List<VisitedPlace> visitedPlaces;
}
