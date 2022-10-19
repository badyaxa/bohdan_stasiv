package intellias;

/*
    JoinedDataRow<K extends Comparable<K>, V1, V2>,
    where K is a generic type of the key,
    V1 and V2 are generic types of the values
*/
public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    K key;
    V1 value1;
    V2 value2;

    public JoinedDataRow(K key, V1 value1, V2 value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public K getKey() {
        return key;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}
