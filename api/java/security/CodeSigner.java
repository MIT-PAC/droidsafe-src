package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.security.cert.CertPath;






public final class CodeSigner implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.814 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.814 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "0D494C7F1B090A9E890D8617AD65E8BA")

    private Timestamp timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.814 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.815 -0400", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "D85F7F71B40235A43B03A76AC2F42688")
    public  CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
        if(signerCertPath == null)        
        {
            NullPointerException varAD3BDBD70F6B1C2E530A6596114697A8_587210903 = new NullPointerException("signerCertPath == null");
            varAD3BDBD70F6B1C2E530A6596114697A8_587210903.addTaint(taint);
            throw varAD3BDBD70F6B1C2E530A6596114697A8_587210903;
        } //End block
        this.signerCertPath = signerCertPath;
        this.timestamp = timestamp;
        // ---------- Original Method ----------
        //if (signerCertPath == null) {
            //throw new NullPointerException("signerCertPath == null");
        //}
        //this.signerCertPath = signerCertPath;
        //this.timestamp = timestamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.816 -0400", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "14024FDECFB7B7CEDDF2FD7E96ABAF54")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_219663423 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709715326 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709715326;
        } //End block
        if(obj instanceof CodeSigner)        
        {
            CodeSigner that = (CodeSigner) obj;
            if(!signerCertPath.equals(that.signerCertPath))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1499852047 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267916072 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267916072;
            } //End block
            boolean varFF12D6A406BF50E0FC2C438C5A86D757_2104745056 = (timestamp == null ? that.timestamp == null : timestamp
                    .equals(that.timestamp));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193025559 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193025559;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1552839998 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413821592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413821592;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (obj instanceof CodeSigner) {
            //CodeSigner that = (CodeSigner) obj;
            //if (!signerCertPath.equals(that.signerCertPath)) {
                //return false;
            //}
            //return timestamp == null ? that.timestamp == null : timestamp
                    //.equals(that.timestamp);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.817 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "5846CE6AEE4DD615A180943F8475F49E")
    public CertPath getSignerCertPath() {
CertPath varC4579A22BE0444B538B995294C4BD4B5_2052874052 =         signerCertPath;
        varC4579A22BE0444B538B995294C4BD4B5_2052874052.addTaint(taint);
        return varC4579A22BE0444B538B995294C4BD4B5_2052874052;
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.817 -0400", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "6163EFAB42BDF7F6A442A7AF63734120")
    public Timestamp getTimestamp() {
Timestamp var7D8A855DA9A411559B05DE99C498CFFA_1360587763 =         timestamp;
        var7D8A855DA9A411559B05DE99C498CFFA_1360587763.addTaint(taint);
        return var7D8A855DA9A411559B05DE99C498CFFA_1360587763;
        // ---------- Original Method ----------
        //return timestamp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.817 -0400", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "93110F779EC09B9E0A081FB48F2E0DFF")
    @Override
    public int hashCode() {
        if(hash == 0)        
        {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        } //End block
        int var0800FC577294C34E0B28AD2839435945_184562307 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889685488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889685488;
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = signerCertPath.hashCode()
                    //^ (timestamp == null ? 0 : timestamp.hashCode());
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.818 -0400", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "2ECEC630BEE12DC6988977EF1D7CF9B3")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        if(timestamp != null)        
        {
            buf.append("; ").append(timestamp);
        } //End block
        buf.append("]");
String var4FC680801218E6372BC708D6FA44AE60_710171365 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_710171365.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_710171365;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
        //if( timestamp != null ) {
            //buf.append("; ").append(timestamp);
        //}
        //buf.append("]");
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.818 -0400", hash_original_field = "30C3C6CD6B540195EBC607DF05762D73", hash_generated_field = "29E3705B91FEE287C2335C4D8AA59C47")

    private static final long serialVersionUID = 6819288105193937581L;
}

