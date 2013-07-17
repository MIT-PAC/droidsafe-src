package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SSLParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.739 -0400", hash_original_field = "1C532BC39D7AA0CB5600E8C5B247F609", hash_generated_field = "411F1A5A89267DD4FA4546E0300DEE75")

    private String[] cipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.739 -0400", hash_original_field = "66203C461B36A2AF573149F0AA6164FF", hash_generated_field = "DC671C4B6787E3B95959CD8B3344C9E7")

    private String[] protocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.739 -0400", hash_original_field = "AB2177731EDE446534AF45C842A8755B", hash_generated_field = "D1808204922229004297FAD1D2005F13")

    private boolean needClientAuth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.739 -0400", hash_original_field = "86DEF88DB1B1A166C8B59083E28A44E5", hash_generated_field = "3F96E6A31CF0EB182354E75513AE65DF")

    private boolean wantClientAuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.739 -0400", hash_original_method = "022ED5C9FE213591085C06A06ECFC7AA", hash_generated_method = "BBDF6E2887D5278290E7EDE7DA43D833")
    public  SSLParameters() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.740 -0400", hash_original_method = "A6B6F0535750EB460CCEE975AE95DC3A", hash_generated_method = "AA57B220E35B5A8F336C31FBD94F869B")
    public  SSLParameters(String[] cipherSuites) {
        addTaint(cipherSuites[0].getTaint());
        setCipherSuites(cipherSuites);
        // ---------- Original Method ----------
        //setCipherSuites(cipherSuites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.740 -0400", hash_original_method = "C1FFBB4FE86E468D8BAF1D7971E89CFD", hash_generated_method = "65FDBF87BECA71AB659229328EC278E0")
    public  SSLParameters(String[] cipherSuites,
                         String[] protocols) {
        addTaint(protocols[0].getTaint());
        addTaint(cipherSuites[0].getTaint());
        setCipherSuites(cipherSuites);
        setProtocols(protocols);
        // ---------- Original Method ----------
        //setCipherSuites(cipherSuites);
        //setProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.740 -0400", hash_original_method = "4A4F1106EE48461B88F50C671836AAA1", hash_generated_method = "90F1B67A990AAC47BBD782D3BEB51270")
    public String[] getCipherSuites() {
        if(cipherSuites == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1599393439 =             null;
            var540C13E9E156B687226421B24F2DF178_1599393439.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1599393439;
        } //End block
String[] var7F6A794107009E794CDF4DF232EEFD7F_825872535 =         cipherSuites.clone();
        var7F6A794107009E794CDF4DF232EEFD7F_825872535.addTaint(taint);
        return var7F6A794107009E794CDF4DF232EEFD7F_825872535;
        // ---------- Original Method ----------
        //if (cipherSuites == null) {
            //return null;
        //}
        //return cipherSuites.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.741 -0400", hash_original_method = "9E670D049040F6D0CEE95ADCC5A2BB8E", hash_generated_method = "4B64EAD1DECBC9F9BF26C083131225FE")
    public void setCipherSuites(String[] cipherSuites) {
        this.cipherSuites = ((cipherSuites == null)
                             ? null
                             : cipherSuites.clone());
        // ---------- Original Method ----------
        //this.cipherSuites = ((cipherSuites == null)
                             //? null
                             //: cipherSuites.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.742 -0400", hash_original_method = "4DAE6AE8C86EF57BE9BF60BD0F445F08", hash_generated_method = "7C32F538937F55EE5D6F5F9B290A6F57")
    public String[] getProtocols() {
        if(protocols == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_793656975 =             null;
            var540C13E9E156B687226421B24F2DF178_793656975.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_793656975;
        } //End block
String[] var30954653E130D93F309E891186F9A8E2_294553224 =         protocols.clone();
        var30954653E130D93F309E891186F9A8E2_294553224.addTaint(taint);
        return var30954653E130D93F309E891186F9A8E2_294553224;
        // ---------- Original Method ----------
        //if (protocols == null) {
            //return null;
        //}
        //return protocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.742 -0400", hash_original_method = "EF8F568BAE6FA22D6783DD8D622D3566", hash_generated_method = "9E02EDF06381A48F6DDCDB7FDE37BC1B")
    public void setProtocols(String[] protocols) {
        this.protocols = ((protocols == null)
                             ? null
                             : protocols.clone());
        // ---------- Original Method ----------
        //this.protocols = ((protocols == null)
                             //? null
                             //: protocols.clone());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.743 -0400", hash_original_method = "0562A9D6063DDE1E14D46646F3CBBD06", hash_generated_method = "F08C1A7706A7C2F795CD799D30DC8C63")
    public boolean getNeedClientAuth() {
        boolean varAB2177731EDE446534AF45C842A8755B_489285895 = (needClientAuth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051706161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051706161;
        // ---------- Original Method ----------
        //return needClientAuth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.743 -0400", hash_original_method = "22A4FDEF203263AAF8FD895025373324", hash_generated_method = "7190D12EE7B69134109AE618F466102E")
    public void setNeedClientAuth(boolean needClientAuth) {
        this.needClientAuth = needClientAuth;
        this.wantClientAuth = false;
        // ---------- Original Method ----------
        //this.needClientAuth = needClientAuth;
        //this.wantClientAuth = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.744 -0400", hash_original_method = "B012F9400DE611969BC8B2969D6766E0", hash_generated_method = "436CA4B479600AD8D8235F1E3FB95F14")
    public boolean getWantClientAuth() {
        boolean var86DEF88DB1B1A166C8B59083E28A44E5_215346180 = (wantClientAuth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68290146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_68290146;
        // ---------- Original Method ----------
        //return wantClientAuth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.744 -0400", hash_original_method = "363F6F59B4A070AED132C2E96BCCEA5B", hash_generated_method = "9B8353396C409A957C3BF33E58027F47")
    public void setWantClientAuth(boolean wantClientAuth) {
        this.wantClientAuth = wantClientAuth;
        this.needClientAuth = false;
        // ---------- Original Method ----------
        //this.wantClientAuth = wantClientAuth;
        //this.needClientAuth = false;
    }

    
}

