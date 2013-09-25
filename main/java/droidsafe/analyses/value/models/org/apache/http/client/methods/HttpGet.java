package droidsafe.analyses.value.models.org.apache.http.client.methods;

import droidsafe.analyses.value.RefVAModel;

import soot.jimple.spark.pag.AllocNode;

public class HttpGet extends RefVAModel {

    public HttpGet(AllocNode allocNode) {
        super(allocNode);
    }
}
