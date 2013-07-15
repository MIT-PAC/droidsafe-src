package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SSLParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.859 -0400", hash_original_field = "1C532BC39D7AA0CB5600E8C5B247F609", hash_generated_field = "411F1A5A89267DD4FA4546E0300DEE75")

    private String[] cipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.859 -0400", hash_original_field = "66203C461B36A2AF573149F0AA6164FF", hash_generated_field = "DC671C4B6787E3B95959CD8B3344C9E7")

    private String[] protocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.859 -0400", hash_original_field = "AB2177731EDE446534AF45C842A8755B", hash_generated_field = "D1808204922229004297FAD1D2005F13")

    private boolean needClientAuth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.859 -0400", hash_original_field = "86DEF88DB1B1A166C8B59083E28A44E5", hash_generated_field = "3F96E6A31CF0EB182354E75513AE65DF")

    private boolean wantClientAuth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.860 -0400", hash_original_method = "022ED5C9FE213591085C06A06ECFC7AA", hash_generated_method = "BBDF6E2887D5278290E7EDE7DA43D833")
    public  SSLParameters() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.860 -0400", hash_original_method = "A6B6F0535750EB460CCEE975AE95DC3A", hash_generated_method = "AA57B220E35B5A8F336C31FBD94F869B")
    public  SSLParameters(String[] cipherSuites) {
        addTaint(cipherSuites[0].getTaint());
        setCipherSuites(cipherSuites);
        // ---------- Original Method ----------
        //setCipherSuites(cipherSuites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.860 -0400", hash_original_method = "C1FFBB4FE86E468D8BAF1D7971E89CFD", hash_generated_method = "65FDBF87BECA71AB659229328EC278E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.861 -0400", hash_original_method = "4A4F1106EE48461B88F50C671836AAA1", hash_generated_method = "9DE8139D674E0190DFD65CC0F6CF71A5")
    public String[] getCipherSuites() {
    if(cipherSuites == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1316054808 =             null;
            var540C13E9E156B687226421B24F2DF178_1316054808.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1316054808;
        } //End block
String[] var7F6A794107009E794CDF4DF232EEFD7F_1132607272 =         cipherSuites.clone();
        var7F6A794107009E794CDF4DF232EEFD7F_1132607272.addTaint(taint);
        return var7F6A794107009E794CDF4DF232EEFD7F_1132607272;
        // ---------- Original Method ----------
        //if (cipherSuites == null) {
            //return null;
        //}
        //return cipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.861 -0400", hash_original_method = "9E670D049040F6D0CEE95ADCC5A2BB8E", hash_generated_method = "4B64EAD1DECBC9F9BF26C083131225FE")
    public void setCipherSuites(String[] cipherSuites) {
        this.cipherSuites = ((cipherSuites == null)
                             ? null
                             : cipherSuites.clone());
        // ---------- Original Method ----------
        //this.cipherSuites = ((cipherSuites == null)
                             //? null
                             //: cipherSuites.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.862 -0400", hash_original_method = "4DAE6AE8C86EF57BE9BF60BD0F445F08", hash_generated_method = "28E8B51883012FA9130FCD9AB0DFACE5")
    public String[] getProtocols() {
    if(protocols == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_823963598 =             null;
            var540C13E9E156B687226421B24F2DF178_823963598.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_823963598;
        } //End block
String[] var30954653E130D93F309E891186F9A8E2_913848948 =         protocols.clone();
        var30954653E130D93F309E891186F9A8E2_913848948.addTaint(taint);
        return var30954653E130D93F309E891186F9A8E2_913848948;
        // ---------- Original Method ----------
        //if (protocols == null) {
            //return null;
        //}
        //return protocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.876 -0400", hash_original_method = "EF8F568BAE6FA22D6783DD8D622D3566", hash_generated_method = "9E02EDF06381A48F6DDCDB7FDE37BC1B")
    public void setProtocols(String[] protocols) {
        this.protocols = ((protocols == null)
                             ? null
                             : protocols.clone());
        // ---------- Original Method ----------
        //this.protocols = ((protocols == null)
                             //? null
                             //: protocols.clone());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.876 -0400", hash_original_method = "0562A9D6063DDE1E14D46646F3CBBD06", hash_generated_method = "E604EE52A97213C5DE8FB60D5BD80E9C")
    public boolean getNeedClientAuth() {
        boolean varAB2177731EDE446534AF45C842A8755B_2136712897 = (needClientAuth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837819894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837819894;
        // ---------- Original Method ----------
        //return needClientAuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.877 -0400", hash_original_method = "22A4FDEF203263AAF8FD895025373324", hash_generated_method = "7190D12EE7B69134109AE618F466102E")
    public void setNeedClientAuth(boolean needClientAuth) {
        this.needClientAuth = needClientAuth;
        this.wantClientAuth = false;
        // ---------- Original Method ----------
        //this.needClientAuth = needClientAuth;
        //this.wantClientAuth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.877 -0400", hash_original_method = "B012F9400DE611969BC8B2969D6766E0", hash_generated_method = "9607834B644DFD3A076CC8598897118D")
    public boolean getWantClientAuth() {
        boolean var86DEF88DB1B1A166C8B59083E28A44E5_1129922069 = (wantClientAuth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106686754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106686754;
        // ---------- Original Method ----------
        //return wantClientAuth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.877 -0400", hash_original_method = "363F6F59B4A070AED132C2E96BCCEA5B", hash_generated_method = "9B8353396C409A957C3BF33E58027F47")
    public void setWantClientAuth(boolean wantClientAuth) {
        this.wantClientAuth = wantClientAuth;
        this.needClientAuth = false;
        // ---------- Original Method ----------
        //this.wantClientAuth = wantClientAuth;
        //this.needClientAuth = false;
    }

    
}

