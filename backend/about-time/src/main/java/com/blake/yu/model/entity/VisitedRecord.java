package com.blake.yu.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visited_record")
public class VisitedRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "visited_date")
    private Date visitedDate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private byte rate;

    @Column(name = "would_want_to_return_visit")
    private boolean wouldWantToReturnVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    private VisitedPlace visitedPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    private Couple couple;
}
