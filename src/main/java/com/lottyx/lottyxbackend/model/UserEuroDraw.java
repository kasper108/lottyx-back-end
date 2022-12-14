package com.lottyx.lottyxbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_euro_jackpot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEuroDraw {

    @Id
    @Column(name = "id" , unique = true, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number_one", nullable = false)
    private byte numberOne;

    @Column(name = "number_two", nullable = false)
    private byte numberTwo;

    @Column(name = "number_three", nullable = false)
    private byte numberThree;

    @Column(name = "number_four", nullable = false)
    private byte numberFour;

    @Column(name = "number_five", nullable = false)
    private byte numberFive;

    @Column(name = "additional_one", nullable = false)
    private byte additionalOne;

    @Column(name = "additional_two", nullable = false)
    private byte additionalTwo;

    @Column(name = "date_modified", nullable = false)
    private Date dateModified;

}
