package intellias.impl;

import intellias.DataRow;
import intellias.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class RightJoinOperationTest extends TestCase {
    @Test
    public void testJoin() {
        Collection<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        Collection<DataRow<Integer, String>> rightCollection = new ArrayList<>();
        Collection<JoinedDataRow<Integer, String, String>> expected = new ArrayList<>();
        leftCollection.add(new DataRow<>(0, "Ukraine"));
        leftCollection.add(new DataRow<>(1, "Germany"));
        leftCollection.add(new DataRow<>(2, "France"));
        rightCollection.add(new DataRow<>(0, "Kyiv"));
        rightCollection.add(new DataRow<>(1, "Berlin"));
        rightCollection.add(new DataRow<>(3, "Budapest"));
        expected.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
        expected.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
        expected.add(new JoinedDataRow<>(3, null, "Budapest"));
        RightJoinOperation<Integer, String, String> rightJoinOperation = new RightJoinOperation<>();
        Collection<JoinedDataRow<Integer, String, String>> actual = rightJoinOperation.join(leftCollection, rightCollection);
        Assert.assertEquals(expected, actual);
    }
}
