package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Properties;

public abstract class Transformer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.047 -0400", hash_original_method = "962E0FC22D29E2A2CD7F27A68548CC24", hash_generated_method = "CCED2B9E561763560F0FF6AAF0DC8DE8")
    protected  Transformer() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.047 -0400", hash_original_method = "B0AC372F01A204B1818DEED996AF8866", hash_generated_method = "ECCA1BBEBBCD6552F55A35F39DCAD66E")
    public void reset() {
        UnsupportedOperationException var9FEFF5D8C55012A46466386638F52029_508227069 = new UnsupportedOperationException(
            "This Transformer, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            + "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            + " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            );
        var9FEFF5D8C55012A46466386638F52029_508227069.addTaint(taint);
        throw var9FEFF5D8C55012A46466386638F52029_508227069;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This Transformer, \"" + this.getClass().getName() + "\", does not support the reset functionality."
            //+ "  Specification \"" + this.getClass().getPackage().getSpecificationTitle() + "\""
            //+ " version \"" + this.getClass().getPackage().getSpecificationVersion() + "\""
            //);
    }

    
    public abstract void transform(Source xmlSource, Result outputTarget)
        throws TransformerException;

    
    public abstract void setParameter(String name, Object value);

    
    public abstract Object getParameter(String name);

    
    public abstract void clearParameters();

    
    public abstract void setURIResolver(URIResolver resolver);

    
    public abstract URIResolver getURIResolver();

    
    public abstract void setOutputProperties(Properties oformat);

    
    public abstract Properties getOutputProperties();

    
    public abstract void setOutputProperty(String name, String value)
        throws IllegalArgumentException;

    
    public abstract String getOutputProperty(String name)
        throws IllegalArgumentException;

    
    public abstract void setErrorListener(ErrorListener listener)
        throws IllegalArgumentException;

    
    public abstract ErrorListener getErrorListener();

    
}

