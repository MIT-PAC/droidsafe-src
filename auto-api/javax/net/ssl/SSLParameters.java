package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLParameters {
    private String[] cipherSuites;
    private String[] protocols;
    private boolean needClientAuth;
    private boolean wantClientAuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.090 -0400", hash_original_method = "022ED5C9FE213591085C06A06ECFC7AA", hash_generated_method = "BBDF6E2887D5278290E7EDE7DA43D833")
    @DSModeled(DSC.SAFE)
    public SSLParameters() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.090 -0400", hash_original_method = "A6B6F0535750EB460CCEE975AE95DC3A", hash_generated_method = "B46B0D133FEEABE6DD92CD110E7AAE7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLParameters(String[] cipherSuites) {
        dsTaint.addTaint(cipherSuites[0]);
        setCipherSuites(cipherSuites);
        // ---------- Original Method ----------
        //setCipherSuites(cipherSuites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.090 -0400", hash_original_method = "C1FFBB4FE86E468D8BAF1D7971E89CFD", hash_generated_method = "DB2821DE0FECFD243F6CB14A6D76A7B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLParameters(String[] cipherSuites,
                         String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        dsTaint.addTaint(cipherSuites[0]);
        setCipherSuites(cipherSuites);
        setProtocols(protocols);
        // ---------- Original Method ----------
        //setCipherSuites(cipherSuites);
        //setProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.090 -0400", hash_original_method = "4A4F1106EE48461B88F50C671836AAA1", hash_generated_method = "BF5C96B1D48C1FF925E0B58C52E118AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getCipherSuites() {
        String[] var1C1670CF580A12D62010B32C98953404_464214166 = (cipherSuites.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (cipherSuites == null) {
            //return null;
        //}
        //return cipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "9E670D049040F6D0CEE95ADCC5A2BB8E", hash_generated_method = "EF19848218FDC5BCD17E30298D4D29B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCipherSuites(String[] cipherSuites) {
        dsTaint.addTaint(cipherSuites[0]);
        this.cipherSuites = ((cipherSuites == null)
                             ? null
                             : cipherSuites.clone());
        // ---------- Original Method ----------
        //this.cipherSuites = ((cipherSuites == null)
                             //? null
                             //: cipherSuites.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "4DAE6AE8C86EF57BE9BF60BD0F445F08", hash_generated_method = "07A5C93F8AE32EF27702695920E8C0B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getProtocols() {
        String[] varC2CE7285B5FA6B0FABF72C01C0C3ED58_141121366 = (protocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //if (protocols == null) {
            //return null;
        //}
        //return protocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "EF8F568BAE6FA22D6783DD8D622D3566", hash_generated_method = "BCA63CD5A6668DF99215F81E3A52A23C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        this.protocols = ((protocols == null)
                             ? null
                             : protocols.clone());
        // ---------- Original Method ----------
        //this.protocols = ((protocols == null)
                             //? null
                             //: protocols.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "0562A9D6063DDE1E14D46646F3CBBD06", hash_generated_method = "0289FDA55FA2BF28F5512337DBD18BFC")
    @DSModeled(DSC.SAFE)
    public boolean getNeedClientAuth() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return needClientAuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "22A4FDEF203263AAF8FD895025373324", hash_generated_method = "A993518CADE612B3DDA41DAD744DA614")
    @DSModeled(DSC.SAFE)
    public void setNeedClientAuth(boolean needClientAuth) {
        dsTaint.addTaint(needClientAuth);
        this.wantClientAuth = false;
        // ---------- Original Method ----------
        //this.needClientAuth = needClientAuth;
        //this.wantClientAuth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.091 -0400", hash_original_method = "B012F9400DE611969BC8B2969D6766E0", hash_generated_method = "43E72F91F2D7D9B305E2FDDD81840CD1")
    @DSModeled(DSC.SAFE)
    public boolean getWantClientAuth() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return wantClientAuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.092 -0400", hash_original_method = "363F6F59B4A070AED132C2E96BCCEA5B", hash_generated_method = "080E71BAC0EAEC6B9D4510C05B086C45")
    @DSModeled(DSC.SAFE)
    public void setWantClientAuth(boolean wantClientAuth) {
        dsTaint.addTaint(wantClientAuth);
        this.needClientAuth = false;
        // ---------- Original Method ----------
        //this.wantClientAuth = wantClientAuth;
        //this.needClientAuth = false;
    }

    
}

