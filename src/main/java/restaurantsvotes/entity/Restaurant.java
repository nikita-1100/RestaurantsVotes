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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurant")
@JsonIgnoreProperties({"hibernateLazyInitializer", "new"})
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public class Restaurant extends BaseEntity{
    @Column(name = "name")
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;
}
