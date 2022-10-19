package intellias.impl;

import intellias.DataRow;
import intellias.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.TestCase;
import org.junit.Assert;

public class LeftJoinOperationTest extends TestCase {
    Collection<DataRow<Integer, String>> leftCollection = new ArrayList<DataRow<Integer, String>>();
    Collection<DataRow<Integer, String>> rightCollection = new ArrayList<DataRow<Integer, String>>();

		leftCollection.add(new DataRow<Integer, String>(0,"Ukraine"));
		leftCollection.add(new DataRow<Integer, String>(1,"Germany"));
		leftCollection.add(new DataRow<Integer, String>(2,"France"));

		rightCollection.add(new DataRow<Integer, String>(0,"Kyiv"));
		rightCollection.add(new DataRow<Integer, String>(1,"Berlin"));
		rightCollection.add(new DataRow<Integer, String>(3,"Budapest"));

    LeftJoinOperation<Integer, String, String> leftJoinOperation = new LeftJoinOperation<Integer, String, String>();
    ArrayList<JoinedDataRow<Integer, String, String>> leftArrayList = (ArrayList<JoinedDataRow<Integer, String, String>>) leftJoinOperation
            .join(leftCollection, rightCollection);

    Collection<JoinedDataRow<Integer, String, String>> result = new ArrayList<JoinedDataRow<Integer, String, String>>();

		result.add(new JoinedDataRow<Integer, String, String>(0,"Ukraine","Kyiv"));
		result.add(new JoinedDataRow<Integer, String, String>(1,"Germany","Berlin"));
		result.add(new JoinedDataRow<Integer, String, String>(2,"France",null));

    Assert.assertEquals(leftArrayList,result);
}