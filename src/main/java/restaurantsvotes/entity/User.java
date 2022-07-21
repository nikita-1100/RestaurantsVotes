package restaurantsvotes.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public class User extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name="role")
    private boolean role;

    @Column(name = "password")
    private String password;
}
