package com.artsgard.retailapplication.entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "purchaseId", "productId" })

/**
 *
 * @author WillemDragstra
 *
 */
public class ProductPurchaseEntityId implements Serializable {

    private static final long serialVersionUID = -5998324119897948326L;

    @Column(name = "purchase_id", insertable = false, updatable = false, unique = true, nullable = false)
    private Long purchaseId;

    @Column(name = "product_id", insertable = false, updatable = false, unique = true, nullable = false)
    private Long productId;

}