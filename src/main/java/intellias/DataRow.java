package intellias;

/*
    DataRow<K extends Comparable<K>, V>,
    where K is a generic type of the key,
    V is a generic type of the value.
*/
public class DataRow<K extends Comparable<K>, V> {
    K key;
    V value;

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
}
