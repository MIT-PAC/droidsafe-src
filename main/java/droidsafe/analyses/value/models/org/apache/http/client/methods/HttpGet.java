package droidsafe.analyses.value.models.org.apache.http.client.methods;

import java.util.Set;

import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.value.models.java.net.URI;

public class HttpGet extends HttpRequestBase {

    public HttpGet(AllocNode allocNode) {
        super(allocNode);
    }

    public void _init_() {
        super._init_();
        /*
        super();
        */
    }

    public void _init_(final URI uri) {
        super._init_();
        setURI(uri);
        /*
        super();
        setURI(uri);
        */
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid.
     */
    public void _init_(final Set<String> uri) {
        super._init_();
        if (!this.uri.string.containsAll(uri)) {
            setURI(URI.create(uri));
        }
        /*
        super();
        setURI(URI.create(uri));
         */
    }

    //@Override
    public String getMethod() {
        __ds__invalidate();
        return null;
        /*
        return METHOD_NAME;
        */
    }
}
