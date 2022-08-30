package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders",uniqueConstraints = {
        @UniqueConstraint(columnNames = "idcustomer")
})
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Date createDate;
    @Column(nullable = false, length = 100)
    private String address;

    @ManyToOne @JoinColumn( name = "idcustomer")
    Customer orderCustomer;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY)
    List<OrderDetail> orderDetails;
}
