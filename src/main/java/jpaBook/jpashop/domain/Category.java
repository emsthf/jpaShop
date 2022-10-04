package jpaBook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;  // 상위 카테고리. 셀프 맵핑도 JPA에서 지원한다.

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();  // 양방향으로 해서 자식 카테고리를 만들 수도 있다.

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),  // 내가 조인하는 컬럼 명
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")  // 반대쪽이 조인하는 컬럼 명
    )
    private List<Item> items = new ArrayList<>();
}
