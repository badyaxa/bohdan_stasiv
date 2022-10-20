package intellias.impl;

import intellias.DataRow;
import intellias.JoinOperation;
import intellias.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RightJoinOperation<K extends Comparable<K>, V1, V2>
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
        for (DataRow<K, V2> rightElement : rightCollection) {
            List<DataRow<K, V1>> leftFilteredList = leftCollection.stream()
                    .filter(dr -> dr.getKey().equals(rightElement.getKey()))
                    .collect(Collectors.toList());
            if (leftFilteredList.isEmpty()) {
                collection.add(
                        new JoinedDataRow<>(rightElement.getKey(), null, rightElement.getValue()));
                continue;
            }
            for (DataRow<K, V1> leftElement : leftFilteredList) {
                if (leftElement.getKey().equals(rightElement.getKey())) {
                    collection.add(
                            new JoinedDataRow<>(rightElement.getKey(),
                                    leftElement.getValue(), rightElement.getValue()));
                }
            }
        }
        return collection;
    }
}
