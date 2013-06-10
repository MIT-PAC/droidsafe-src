package droidsafe.analyses.attr.models.android.content;

import droidsafe.analyses.attr.AttrModeledClass;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public abstract class Context extends AttrModeledClass {

    public Context(AllocNode allocNode) {
        super(allocNode);
    }
    
    /** Return the name of this application's package. */
    public abstract Set<String> getPackageName(); 
}
