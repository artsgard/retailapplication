package com.artsgard.beerapplication.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "COMPANY")

/**
 *
 * @author WillemDragstra
 *
 */
public class CompanyEntity implements Serializable {
    private static final long serialVersionUID = 7299843115411952010L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "COMPANY_NAME", nullable = false, unique = true)
    private String companyName;

    @Column(name = "COMPANY_REF", nullable = false)
    private String companyRef;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "REGISTER_DATE", nullable = true)
    private Timestamp registerDate;
/*
    @ManyToOne(fetch = FetchType.LAZY,  optional = true)
    @JoinColumn(name="USER_ID", nullable=true, unique = true)
    private UserEntity user;
*/
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_COMPANY", joinColumns = @JoinColumn(name = "COMPANY_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<UserEntity> companyUsers = new ArrayList<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", orphanRemoval=true)
    private List<ProductEntity> companyProducts = new ArrayList<>(0);

}
