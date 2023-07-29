package com.enoca.project.model.entity;

import com.enoca.project.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "identity_number",length = 11)
    private String identityNumber;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "company_id")
    private Company company;

}
