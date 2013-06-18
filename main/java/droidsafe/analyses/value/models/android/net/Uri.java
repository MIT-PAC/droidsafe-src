package droidsafe.analyses.value.models.android.net;

import droidsafe.analyses.value.ValueAnalysisModeledObject;

import droidsafe.analyses.value.ValueAnalysisModelingSet;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;

/**
 * @author dpetters
 */
public class Uri extends ValueAnalysisModeledObject {

    public Set<String> uriString = new ValueAnalysisModelingSet<String>();

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
