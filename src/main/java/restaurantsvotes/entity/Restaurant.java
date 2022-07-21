package restaurantsvotes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public class Restaurant extends BaseEntity{
    @Column(name = "name")
    private String name;
}




//{
//        "name":"Tom",
//        "role":"false",
//        "password":"INDIVIDUAL"
//        }
