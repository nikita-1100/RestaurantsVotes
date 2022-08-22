package restaurantsvotes.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name="menus", uniqueConstraints = {
        @UniqueConstraint( columnNames = { "restaurant_name", "dish_name", "date" } ) })
public class Menu extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_name", nullable = false)
    private Restaurant restaurant;

    @Column(name = "dish_name")
    private String dishname;

    @Column(name="price")
    private Integer price;

    @Column(name="date")
    private LocalDate date;
}
