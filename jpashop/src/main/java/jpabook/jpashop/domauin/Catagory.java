package jpabook.jpashop.domauin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Catagory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Catagory parent;

    @OneToMany(mappedBy = "parent")
    private List<Catagory> child=new ArrayList<>();

    @ManyToMany
    @JoinTable(name="CATEGORY_ITEM", /*중간 테이블을 만드는 과정 (다대다)*/
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name="ITEM_ID")
    )
    private  List<Item> items;

    public Catagory() {
    }
}
