package intellias.impl;

import intellias.DataRow;
import intellias.JoinOperation;
import intellias.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;

public class InnerJoinOperation<K extends Comparable<K>, V1, V2>
        implements
        JoinOperation<
                DataRow<K, V1>,
                DataRow<K, V2>,
                JoinedDataRow<K, V1, V2>
                > {
    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
                                                     Collection<DataRow<K, V2>> rightCollection) {
        Collection<JoinedDataRow<K, V1, V2>> collection = new ArrayList<>();
        for (DataRow<K, V1> leftElement : leftCollection) {
            for (DataRow<K, V2> rightElement : rightCollection) {
                if (leftElement.getKey().equals(rightElement.getKey())) {
                    collection.add(
                            new JoinedDataRow<>(leftElement.getKey(),
                                    leftElement.getValue(), rightElement.getValue()));
                }
            }
        }
        return collection;
    }
}
