package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

public final class Timestamp implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.892 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "19EEE56AC3C62FACD5625A14E692FA43")

    private Date timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.892 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.892 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.893 -0400", hash_original_method = "AAE6CDDCBB2AA770835AE5337F9257E2", hash_generated_method = "C4CF743D8DABB29EAB8D05602EE01023")
    public  Timestamp(Date timestamp, CertPath signerCertPath) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timestamp == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("signerCertPath == null");
        } 
        this.timestamp = new Date(timestamp.getTime());
        this.signerCertPath = signerCertPath;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.893 -0400", hash_original_method = "5EC26C09389FD151E3B15C0B386F0A3D", hash_generated_method = "BCC388A9BCB60B221DD63490463467C9")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1023360633 = (obj == this);
        } 
        {
            Timestamp that = (Timestamp) obj;
            boolean var2709CFC34CE811BA8682DC086775E595_1157845208 = (timestamp.equals(that.timestamp)
                    && signerCertPath.equals(that.signerCertPath));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570928637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570928637;
        
        
            
        
        
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.894 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "F466F77F90FBE021A492768AA54A7539")
    public CertPath getSignerCertPath() {
        CertPath varB4EAC82CA7396A68D541C85D26508E83_1849077674 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1849077674 = signerCertPath;
        varB4EAC82CA7396A68D541C85D26508E83_1849077674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1849077674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.894 -0400", hash_original_method = "9F5E9DF58C2165A57C2B03C2ABFACB32", hash_generated_method = "DB5439DE2D80160CBD4839D0BFFE8637")
    public Date getTimestamp() {
        Date varB4EAC82CA7396A68D541C85D26508E83_118822948 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_118822948 = (Date) timestamp.clone();
        varB4EAC82CA7396A68D541C85D26508E83_118822948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_118822948;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.895 -0400", hash_original_method = "31DF5B7E8A0074E9903AAC481766C16B", hash_generated_method = "0DF57FA2DAFD3AE6373EC4ECD493A2B0")
    @Override
    public int hashCode() {
        {
            hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701652358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1701652358;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.895 -0400", hash_original_method = "515CC78E7249E5726FD47C9B8B62F1A0", hash_generated_method = "2DDA3043ACC45E91660DF7121885FAF8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_299890405 = null; 
        StringBuilder buf = new StringBuilder(256);
        buf.append("Timestamp [").append(timestamp).append(" certPath=");
        buf.append(signerCertPath.getCertificates().get(0)).append("]");
        varB4EAC82CA7396A68D541C85D26508E83_299890405 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_299890405.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299890405;
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.896 -0400", hash_original_field = "B3E56E4CB108BFE836E4A5A57F75FAC2", hash_generated_field = "E7A91C55874DE95C878CDAFEDEEC7D72")

    private static final long serialVersionUID = -5502683707821851294L;
}

