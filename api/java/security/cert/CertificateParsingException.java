package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;



public class CertificateParsingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.956 -0400", hash_original_method = "52C1CA38DD038BC33FD4ADF2F8CE17BE", hash_generated_method = "7D00B39D2745C634B4988C0485121EF5")
    public  CertificateParsingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.956 -0400", hash_original_method = "8DA8B534EA167A5C50442E9F25486020", hash_generated_method = "B20A17E5EA8D79E40D983186BAEA27C7")
    public  CertificateParsingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.957 -0400", hash_original_method = "7DFD64EF17D16B3CA905ED3004EA7773", hash_generated_method = "3B61250E5399BB4D01CA6E0F570A64E4")
    public  CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.957 -0400", hash_original_method = "655AB0A50E551680E7DF5C232C5D908E", hash_generated_method = "ADE038C680AFEC87C884763142874BA2")
    public  CertificateParsingException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.957 -0400", hash_original_field = "DD366147DF16CFCE91DD1289251E3597", hash_generated_field = "9FB65A3F56B8D84968FA0A283A775A80")

    private static final long serialVersionUID = -7989222416793322029L;
}

