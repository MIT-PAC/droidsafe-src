package droidsafe.analyses.attr.models.android.content;

import droidsafe.analyses.attr.AttrModeledClass;
import droidsafe.analyses.attr.models.android.content.Context;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class ContextWrapper extends Context {

    Context mBase;

    public ContextWrapper(AllocNode allocNode) {
        super(allocNode);
    }

    @Override
    public Set<String> getPackageName() {
        return mBase.getPackageName();
    }

    @Override
    public String dsDisplay(){
        String str = "<modeled ContextWrapper" + this.getId() + "> {";
        if (this.invalidated) {
            str += "invalidated";
        }
        return str + "}";
    }
}
