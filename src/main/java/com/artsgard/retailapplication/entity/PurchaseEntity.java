package com.artsgard.retailapplication.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "PURCHASE")

/**
 *
 * @author WillemDragstra
 *
 */
public class PurchaseEntity implements Serializable {
    private static final long serialVersionUID = 5343446368991643576L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "PURCHASE_DETAILS", length = 500, unique = false, nullable = true)
    private String purchaseDetails;

    @Column(name = "PURCHASE_REF", length = 45, unique = false, nullable = false)
    private String purchaseRef;

    @Column(name = "CREATED", nullable = false)
    private Timestamp created;

    @Column(name = "UPDATED", nullable = true)
    private Timestamp updated;

    @Column(name = "PURCHASE_DATE", nullable = true)
    private Timestamp purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID", nullable=false)
    private UserEntity user;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="purchase", orphanRemoval = true)
    private List<ProductPurchaseEntity> productPurchases = new ArrayList<>(0);

}
