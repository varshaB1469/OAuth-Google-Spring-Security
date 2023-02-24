package com.example.ecommerce.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class OrderProductPK implements Serializable{
	
	
	  @JsonBackReference
	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id")
	    private Order order;

	    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	    @JoinColumn(name = "product_id")
	    private Product product;
}
