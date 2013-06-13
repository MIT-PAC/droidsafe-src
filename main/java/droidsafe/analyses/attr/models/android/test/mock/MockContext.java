package droidsafe.analyses.attr.models.android.test.mock;

import droidsafe.analyses.attr.AttrModeledClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class MockContext extends AttrModeledClass {


    public MockContext(AllocNode allocNode) {
        super(allocNode);
    }

    public void _init_(){
    }
}
