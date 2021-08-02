package com.blake.yu.model.entity;

import com.blake.yu.model.request.CreateAccountRequest;
import com.blake.yu.util.DateUtils;
import lombok.*;

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
@Table(name = "account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String email;

    private String password;

    private byte gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "invite_code")
    private String inviteCode;

    @Column(name = "is_enable")
    private boolean isEnable;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;

    @Column(name = "modified_at", updatable = false, insertable = false)
    private Timestamp modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Couple couple;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<Diary> diaryList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<Note> createNoteList;

    @SneakyThrows
    public Account(CreateAccountRequest request) {
        Date birthDate = DateUtils.parse(request.getBirthDate());
        this.name = request.getName();
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.gender = request.getGender();
        this.birthDate = birthDate;
        this.isEnable = true;
    }
}
