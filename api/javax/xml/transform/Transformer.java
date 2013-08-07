package javax.xml.transform;

// Droidsafe Imports
import droidsafe.annotations.*;
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

    
    @DSModeled(DSC.SAFE)
    public abstract void transform(Source xmlSource, Result outputTarget)
        throws TransformerException;

    
    @DSModeled(DSC.SAFE)
    public abstract void setParameter(String name, Object value);

    
    @DSModeled(DSC.SAFE)
    public abstract Object getParameter(String name);

    
    @DSModeled(DSC.SAFE)
    public abstract void clearParameters();

    
    @DSModeled(DSC.SAFE)
    public abstract void setURIResolver(URIResolver resolver);

    
    @DSModeled(DSC.SAFE)
    public abstract URIResolver getURIResolver();

    
    @DSModeled(DSC.SAFE)
    public abstract void setOutputProperties(Properties oformat);

    
    @DSModeled(DSC.SAFE)
    public abstract Properties getOutputProperties();

    
    @DSModeled(DSC.SAFE)
    public abstract void setOutputProperty(String name, String value)
        throws IllegalArgumentException;

    
    @DSModeled(DSC.SAFE)
    public abstract String getOutputProperty(String name)
        throws IllegalArgumentException;

    
    @DSModeled(DSC.SAFE)
    public abstract void setErrorListener(ErrorListener listener)
        throws IllegalArgumentException;

    
    @DSModeled(DSC.SAFE)
    public abstract ErrorListener getErrorListener();

    
}

