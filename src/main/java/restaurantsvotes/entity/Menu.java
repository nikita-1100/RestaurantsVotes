package restaurantsvotes.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @Column(name = "dish_name")
    @Size(min = 1, max = 40)
    @NotBlank
    private String dishName;

    @Column(name="price")
    @Range(min = 0, max = 5000)
    private Integer price;

    @Column(name="date")
    @NotNull
    private LocalDate date;
}
