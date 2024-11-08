package com.microservice.order.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @Column(name = "order_line_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long productId;

    private Integer quantity;

}
