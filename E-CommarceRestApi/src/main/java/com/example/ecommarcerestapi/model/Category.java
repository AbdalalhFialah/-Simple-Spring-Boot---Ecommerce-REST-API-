package com.example.ecommarcerestapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long category_id;

    @Column(name = "category_name" )
    private String category_name;
    @Column(name ="Creation_Date" )
    private String CreationDate;
    @Column(name = "description" )
    private String description;

}
