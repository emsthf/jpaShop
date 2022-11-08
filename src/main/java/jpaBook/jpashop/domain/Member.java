package jpaBook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")  // 회사마다 대소문자 룰이 다르다.
    private Long id;
    private String name;

    @Embedded  //값 타입 객체에 @Embadable 어노테이션이 붙어있으면 생략해도 되지만 명확하게 값 타입이라는 것을 알리기 위해 사용하는 것이 좋다.
    private Address address;

    @OneToMany(mappedBy = "member")  // 연관관계의 주인이 되는 필드 값(Order의 member)
    private List<Order> orders = new ArrayList<>();  // JPA 관례 상 배열 초기화. 그래야 데이터 없이 넣어서 NullPointerException 방지 가능

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
