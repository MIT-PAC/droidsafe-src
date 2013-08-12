package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;



public class CertificateExpiredException extends CertificateException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.724 -0400", hash_original_method = "695ACDE1E8C2F900ABF7FF7E73A29503", hash_generated_method = "3E035F91FD1EAB99F6CA5B96A6EC5AFC")
    public  CertificateExpiredException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.724 -0400", hash_original_method = "308175145F4FC5BAB795337D4AA9A477", hash_generated_method = "A30B860C6CB55FC6EAE15A8B4C39A0E5")
    public  CertificateExpiredException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.724 -0400", hash_original_field = "C881639043E4788F90EB763CD807A287", hash_generated_field = "BBA2101CC7D0A65585475965F2362C16")

    private static final long serialVersionUID = 9071001339691533771L;
}

