package restaurantsvotes.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "new"})
@Table(name="menu", uniqueConstraints = {
        @UniqueConstraint( columnNames = { "restaurant_name", "dish_name", "date" } ) })
public class Menu extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_name", nullable = false)
    private Restaurant restaurant;

    @Column(name = "dish_name")
    private String dishName;

    @Column(name="price")
    private Integer price;

    @Column(name="date")
    private LocalDate date;
}
