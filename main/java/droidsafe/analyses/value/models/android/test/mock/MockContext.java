package droidsafe.analyses.value.models.android.test.mock;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class MockContext extends ValueAnalysisModeledObject {


    public MockContext(AllocNode allocNode) {
        super(allocNode);
    }

    public void _init_(){
    }
}
