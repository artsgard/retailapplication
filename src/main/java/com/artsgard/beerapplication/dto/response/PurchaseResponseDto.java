package com.artsgard.beerapplication.dto.response;

import com.artsgard.beerapplication.entity.ProductEntity;
import lombok.Data;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author WillemDragstra
 *
 *
 */
@Data
public class PurchaseResponseDto implements Serializable {
    private static final long serialVersionUID = 3772629748968196173L;

    private String purchaseDetails;

    private String purchaseRef;

    private String username;

    private Boolean active;

    private Timestamp created;

    private Timestamp updated;

    private Timestamp purchaseDate;

    private List<String> productPurchaseReferenseList;

}