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
@Table(name="votes", uniqueConstraints = {
        @UniqueConstraint( columnNames = { "user_id", "date" } ) })


public class Vote extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_name", nullable = false)
    private Restaurant restaurant;

    @Column(name="date")
    private LocalDate date;
}
