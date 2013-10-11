package droidsafe.analyses.value.models.org.apache.http.client.methods;

import droidsafe.analyses.value.RefVAModel;
import org.apache.http.message.AbstractHttpMessage;
import soot.jimple.spark.pag.AllocNode;

public abstract class HttpRequestBase extends RefVAModel {

    public HttpRequestBase(AllocNode allocNode) {
        super(allocNode);
    }
}
