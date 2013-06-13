package droidsafe.analyses.attr.models.android.net;

import droidsafe.analyses.attr.AttrModeledClass;

import droidsafe.analyses.attr.AttrModelingSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class Uri extends AttrModeledClass {

    public Set<String> uriString = new AttrModelingSet<String>();

    public Uri(){}

    public Uri(AllocNode allocNode) {
        super(allocNode);
    }

    public Uri(Set<String> uriStringParam) {
        this.uriString.addAll(uriStringParam);
    }

    public void _init_(Set<String> uriStringParam){
        this.uriString.addAll(uriStringParam);
    }
}
