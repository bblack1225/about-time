package com.blake.yu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calender")
public class Calender implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_date")
    private Date fullDate;

    private byte year;

    private byte month;

    private byte day;

    @Column(name = "day_of_week")
    private byte dayOfWeek;

    @Column(name = "is_holiday")
    private boolean isHoliday;

    @Column(name = "holiday_description")
    private String holidayDescription;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "calender")
    private List<Anniversary> anniversaryList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "calender")
    private List<Diary> diaryList;
}
