package intellias.impl;

import intellias.DataRow;
import intellias.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class InnerJoinOperationTest extends TestCase {

    @Test
    public void testJoin() {
        Collection<DataRow<Integer, String>> topCollection = new ArrayList<>();
        Collection<DataRow<Integer, String>> bottomCollection = new ArrayList<>();
        Collection<JoinedDataRow<Integer, String, String>> expected = new ArrayList<>();
        topCollection.add(new DataRow<>(0, "Ukraine"));
        topCollection.add(new DataRow<>(1, "Germany"));
        topCollection.add(new DataRow<>(2, "France"));
        bottomCollection.add(new DataRow<>(0, "Kyiv"));
        bottomCollection.add(new DataRow<>(1, "Berlin"));
        bottomCollection.add(new DataRow<>(3, "Budapest"));
        expected.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        expected.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        InnerJoinOperation<Integer, String, String> innerJoinOperation = new InnerJoinOperation<>();
        Collection<JoinedDataRow<Integer, String, String>> actual = innerJoinOperation.join(topCollection, bottomCollection);
        Assert.assertEquals(expected, actual);
    }
}