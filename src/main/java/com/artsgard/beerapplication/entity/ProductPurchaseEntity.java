package com.artsgard.beerapplication.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="PRODUCT_PURCHASE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })

/**
 *
 * @author WillemDragstra
 *
 */
public class ProductPurchaseEntity implements Serializable {
    private static final long serialVersionUID = 3645685173222125757L;

    @EmbeddedId
    private ProductPurchaseEntityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id", nullable = false, insertable = false, updatable = false)
    private PurchaseEntity purchase;

    @Column(name = "PRODUCT_PURCHASE_DATE", nullable = false)
    private Timestamp productPurchaseDate;

    @Column(name = "PRODUCT_PURCHASE_COMMENT", nullable = true)
    private String productPurchaseComment;

    public ProductPurchaseEntity(ProductPurchaseEntityId id) {
        this.id = id;
    }

    public ProductPurchaseEntity(ProductEntity product, PurchaseEntity purchase) {
        this.purchase = purchase;
        this.product = product;
    }
}

