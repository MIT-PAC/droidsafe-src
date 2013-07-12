package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.cert.CertPath;

public final class CodeSigner implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.944 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.944 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "0D494C7F1B090A9E890D8617AD65E8BA")

    private Timestamp timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.944 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.945 -0400", hash_original_method = "2D1A8E0F0018E23D2016EEE74572794C", hash_generated_method = "F119C4A671142E8AC99DD114ACF76DC3")
    public  CodeSigner(CertPath signerCertPath, Timestamp timestamp) {
    if(signerCertPath == null)        
        {
            NullPointerException varAD3BDBD70F6B1C2E530A6596114697A8_1757225745 = new NullPointerException("signerCertPath == null");
            varAD3BDBD70F6B1C2E530A6596114697A8_1757225745.addTaint(taint);
            throw varAD3BDBD70F6B1C2E530A6596114697A8_1757225745;
        } 
        this.signerCertPath = signerCertPath;
        this.timestamp = timestamp;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.946 -0400", hash_original_method = "9391ADEEB71A28BB26D9308D62C031F2", hash_generated_method = "1EFAF2A4644CAAB55FE7A1176159FF8E")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_294746743 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940472004 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_940472004;
        } 
    if(obj instanceof CodeSigner)        
        {
            CodeSigner that = (CodeSigner) obj;
    if(!signerCertPath.equals(that.signerCertPath))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1097755736 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593684766 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_593684766;
            } 
            boolean varFF12D6A406BF50E0FC2C438C5A86D757_1312063114 = (timestamp == null ? that.timestamp == null : timestamp
                    .equals(that.timestamp));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_344815889 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_344815889;
        } 
        boolean var68934A3E9455FA72420237EB05902327_582979114 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336785082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336785082;
        
        
            
        
        
            
            
                
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.946 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "E248F023712F89DE6755F2D64E51AFED")
    public CertPath getSignerCertPath() {
CertPath varC4579A22BE0444B538B995294C4BD4B5_1971977180 =         signerCertPath;
        varC4579A22BE0444B538B995294C4BD4B5_1971977180.addTaint(taint);
        return varC4579A22BE0444B538B995294C4BD4B5_1971977180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.946 -0400", hash_original_method = "F117DFA1A6EB777CC4A763885DD30F8B", hash_generated_method = "FEF9F73E6A124870465A4A272A8D12B6")
    public Timestamp getTimestamp() {
Timestamp var7D8A855DA9A411559B05DE99C498CFFA_1241577390 =         timestamp;
        var7D8A855DA9A411559B05DE99C498CFFA_1241577390.addTaint(taint);
        return var7D8A855DA9A411559B05DE99C498CFFA_1241577390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.947 -0400", hash_original_method = "4C01119C48849B3B8C0F3B7EFA427DC4", hash_generated_method = "741E187C9A1B0B2C11D1E86775F5DD2F")
    @Override
    public int hashCode() {
    if(hash == 0)        
        {
            hash = signerCertPath.hashCode()
                    ^ (timestamp == null ? 0 : timestamp.hashCode());
        } 
        int var0800FC577294C34E0B28AD2839435945_898963470 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227228748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1227228748;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.947 -0400", hash_original_method = "9AD37782FDC32A71B028636E3AD750B0", hash_generated_method = "C357FBE25F8416D0C4F97A30FA41EB30")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        buf.append("CodeSigner [").append(signerCertPath.getCertificates().get(0));
    if(timestamp != null)        
        {
            buf.append("; ").append(timestamp);
        } 
        buf.append("]");
String var4FC680801218E6372BC708D6FA44AE60_484820216 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_484820216.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_484820216;
        
        
        
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.947 -0400", hash_original_field = "30C3C6CD6B540195EBC607DF05762D73", hash_generated_field = "29E3705B91FEE287C2335C4D8AA59C47")

    private static final long serialVersionUID = 6819288105193937581L;
}

