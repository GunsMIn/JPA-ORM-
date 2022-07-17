package jpabook.jpashop.domauin;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery {//order테이블과 1대1관계

    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;

    @OneToOne(mappedBy = "delivery",fetch = LAZY)
    private Order order;

    private DeliveryStatus status;
}
