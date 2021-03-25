package com.artsgard.retailapplication.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import lombok.*;

/**
 *
 * @author WillemDragstra
 *
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = -209313219653499455L;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    //@NotNull
    //@Size(min = 2, max = 100)
    @Column(name = "NAME", length = 100, unique = true, nullable = false)
    private String name;

    //@NotNull
    @Column(name = "PRODUCT_REF", length = 100, unique = true, nullable = false)
    private String productRef;

    @Column(name = "DESCRIPTION", length = 100,unique = false, nullable = true)
    private String description;

    //@NotNull
    //@DecimalMin(value = "0.0", inclusive = false)
    //@Digits(integer=12, fraction=2)
    @Column(name = "PRICE", length = 100, unique = false, nullable = false)
    private BigDecimal price;

    //@NotNull
    @Column(name = "PROMOTION", length = 100, nullable = false)
    private Boolean promotion;

    //@NotNull
    @Column(name = "GRADUATION", length = 100, nullable = false)
    private String graduation;

    public enum BeerType {
        PILS, HELLES, STARKBIER, ALTBIER, DUNKELBIER
    }

    //@NotNull
    @Column(name = "beer_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BeerType beerType;

    //@NotNull
    @Column(name = "NATIONALITY", nullable = false)
    String nationality;

    @Column(name = "CREATION_DATE", nullable = false)
    private Timestamp creationDate;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="product", orphanRemoval = true)
    private List<ProductPurchaseEntity> purchaseOrders = new ArrayList<>(0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID", nullable=true)
    private CompanyEntity company;
}
