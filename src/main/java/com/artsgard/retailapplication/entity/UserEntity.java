package com.artsgard.retailapplication.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USER")

/**
 *
 * @author WillemDragstra
 *
 */
public class UserEntity implements Serializable {
    private static final long serialVersionUID = -7295822958316178942L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    //@NotNull
    //@Size(min = 2, max = 20)
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    //@NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;

    //@NotNull
    @Size(min = 2, max = 40)
    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;

    //@NotNull
    //@Email
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "REGISTER_DATE", nullable = false)
    private Timestamp registerDate;

    @Column(name = "MODIFICATION_DATE", nullable = true)
    private Timestamp modifactionDate;

    //@NotNull
    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval=true)
    private List<PurchaseEntity> userPurchases = new ArrayList<>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_COMPANY", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID"))
    private List<CompanyEntity> userCompanies = new ArrayList<>(0);

}
