package com.SpringTech.GameApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

//    @NotBlank(message = "please add employee name")
//    @Length(max=5, min=1)
//    @Size(max = 10,min = 0)
//    @Email
    private String name;
    @Positive
    private int temperature;

//    @PastOrPresent
//    @FutureOrPresent
    //@Temporal(TemporalType.TIMESTAMP)
//    private Date date;


}
