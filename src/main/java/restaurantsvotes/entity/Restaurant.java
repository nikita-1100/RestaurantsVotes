package restaurantsvotes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@JsonIgnoreProperties({"hibernateLazyInitializer", "new"})
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public class Restaurant{
    @Id
    @Column(name = "name")
    private String name;
}




//{
//        "name":"Tom",
//        "role":"false",
//        "password":"INDIVIDUAL"
//        }
