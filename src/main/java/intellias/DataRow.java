package intellias;

import java.util.Objects;

/*
    DataRow<K extends Comparable<K>, V>,
    where K is a generic type of the key,
    V is a generic type of the value.
*/
public class DataRow<K extends Comparable<K>, V> {
    private K key;
    private V value;

    public DataRow(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataRow<?, ?> dataRow = (DataRow<?, ?>) o;
        return Objects.equals(key, dataRow.key) && Objects.equals(value, dataRow.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
