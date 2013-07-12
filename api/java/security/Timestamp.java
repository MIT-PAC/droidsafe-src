package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

public final class Timestamp implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.568 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "19EEE56AC3C62FACD5625A14E692FA43")

    private Date timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.569 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.569 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.569 -0400", hash_original_method = "AAE6CDDCBB2AA770835AE5337F9257E2", hash_generated_method = "BC774CFA5280133E491024017D29646C")
    public  Timestamp(Date timestamp, CertPath signerCertPath) {
    if(timestamp == null)        
        {
            NullPointerException varB5EEE829907E8F9314B751A32399ED45_829382120 = new NullPointerException("timestamp == null");
            varB5EEE829907E8F9314B751A32399ED45_829382120.addTaint(taint);
            throw varB5EEE829907E8F9314B751A32399ED45_829382120;
        } 
    if(signerCertPath == null)        
        {
            NullPointerException varAD3BDBD70F6B1C2E530A6596114697A8_1466299513 = new NullPointerException("signerCertPath == null");
            varAD3BDBD70F6B1C2E530A6596114697A8_1466299513.addTaint(taint);
            throw varAD3BDBD70F6B1C2E530A6596114697A8_1466299513;
        } 
        this.timestamp = new Date(timestamp.getTime());
        this.signerCertPath = signerCertPath;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.570 -0400", hash_original_method = "5EC26C09389FD151E3B15C0B386F0A3D", hash_generated_method = "F4420974A408B54B4306670F2A25BC71")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_458498095 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829717898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_829717898;
        } 
    if(obj instanceof Timestamp)        
        {
            Timestamp that = (Timestamp) obj;
            boolean varEC08B8B81AF7E2D4D32089CA1D12837F_1342848976 = (timestamp.equals(that.timestamp)
                    && signerCertPath.equals(that.signerCertPath));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647936079 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_647936079;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1921385489 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779975228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779975228;
        
        
            
        
        
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.571 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "376CBF8490741D62AF1B6C6FA13F3A8A")
    public CertPath getSignerCertPath() {
CertPath varC4579A22BE0444B538B995294C4BD4B5_1473273335 =         signerCertPath;
        varC4579A22BE0444B538B995294C4BD4B5_1473273335.addTaint(taint);
        return varC4579A22BE0444B538B995294C4BD4B5_1473273335;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.571 -0400", hash_original_method = "9F5E9DF58C2165A57C2B03C2ABFACB32", hash_generated_method = "D2D4C5BCE1B5E69E19B1CE1250CD124C")
    public Date getTimestamp() {
Date var9C830804DEBADE9F0F9D7100079F1F4C_1601913173 =         (Date) timestamp.clone();
        var9C830804DEBADE9F0F9D7100079F1F4C_1601913173.addTaint(taint);
        return var9C830804DEBADE9F0F9D7100079F1F4C_1601913173;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.572 -0400", hash_original_method = "31DF5B7E8A0074E9903AAC481766C16B", hash_generated_method = "C938CE73D39E1C1B3B5C6E49B1976BC8")
    @Override
    public int hashCode() {
    if(hash == 0)        
        {
            hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        } 
        int var0800FC577294C34E0B28AD2839435945_2120073975 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146724844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146724844;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.572 -0400", hash_original_method = "515CC78E7249E5726FD47C9B8B62F1A0", hash_generated_method = "7E5FEE091E92DE5F3A98B60E6B88ACF1")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        buf.append("Timestamp [").append(timestamp).append(" certPath=");
        buf.append(signerCertPath.getCertificates().get(0)).append("]");
String var4FC680801218E6372BC708D6FA44AE60_2082760459 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_2082760459.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_2082760459;
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.572 -0400", hash_original_field = "B3E56E4CB108BFE836E4A5A57F75FAC2", hash_generated_field = "E7A91C55874DE95C878CDAFEDEEC7D72")

    private static final long serialVersionUID = -5502683707821851294L;
}

