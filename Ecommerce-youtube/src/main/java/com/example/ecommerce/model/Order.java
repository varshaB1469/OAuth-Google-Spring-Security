package com.example.ecommerce.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateCreated;
	
	private String status;
	
	 @JsonManagedReference
	    @OneToMany(mappedBy = "pk.order")
//	    @Valid
	    private List<OrderProduct> orderProducts = new ArrayList<>();

	 @Transient
	    public Double getTotalOrderPrice() {
	        double sum = 0D;
	        List<OrderProduct> orderProducts = getOrderProducts();
	        for (OrderProduct op : orderProducts) {
	            sum += op.getTotalPrice();
	        }
	        return sum;
	    }
	 
	 @Transient
	    public int getNumberOfProducts() {
	        return this.orderProducts.size();
	    }
}
