package restaurantsvotes.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Tuple<K, V> {
    private K key;
    private V value;
}