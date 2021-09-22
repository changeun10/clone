package jpabook.jpabook.domain.item;

import jpabook.jpabook.domain.Category;
import jpabook.jpabook.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    public List<Category> categories = new ArrayList<>();

    //구현 method//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int result = this.stockQuantity - quantity;
        if (result<0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = result;
    }
}
