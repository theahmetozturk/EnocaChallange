package com.enoca.project.model.entity;

import com.enoca.project.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company")
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "tax_number", length = 10)
    private String taxNumber;

    @OneToMany(
            mappedBy = "company",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST
            }
    )
    private List<Employee> employees;









}
