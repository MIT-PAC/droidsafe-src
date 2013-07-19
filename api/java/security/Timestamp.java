package java.security;

// Droidsafe Imports
import java.io.Serializable;
import java.security.cert.CertPath;
import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Timestamp implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.567 -0400", hash_original_field = "D7E6D55BA379A13D08C25D15FAF2A23B", hash_generated_field = "19EEE56AC3C62FACD5625A14E692FA43")

    private Date timestamp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.567 -0400", hash_original_field = "6E0FA7FC9CEF8E5B39B9BB28B636A6B5", hash_generated_field = "FC883EA50AB2FDD2C3073E407E6CEA66")

    private CertPath signerCertPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.567 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "0316D82713F1CE4A6BE9BC97E8C831C1")

    private transient int hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.568 -0400", hash_original_method = "AAE6CDDCBB2AA770835AE5337F9257E2", hash_generated_method = "045A38CDC8121B61CEAB4A3A4D231109")
    public  Timestamp(Date timestamp, CertPath signerCertPath) {
        if(timestamp == null)        
        {
            NullPointerException varB5EEE829907E8F9314B751A32399ED45_1384788433 = new NullPointerException("timestamp == null");
            varB5EEE829907E8F9314B751A32399ED45_1384788433.addTaint(taint);
            throw varB5EEE829907E8F9314B751A32399ED45_1384788433;
        } //End block
        if(signerCertPath == null)        
        {
            NullPointerException varAD3BDBD70F6B1C2E530A6596114697A8_2045161508 = new NullPointerException("signerCertPath == null");
            varAD3BDBD70F6B1C2E530A6596114697A8_2045161508.addTaint(taint);
            throw varAD3BDBD70F6B1C2E530A6596114697A8_2045161508;
        } //End block
        this.timestamp = new Date(timestamp.getTime());
        this.signerCertPath = signerCertPath;
        // ---------- Original Method ----------
        //if (timestamp == null) {
            //throw new NullPointerException("timestamp == null");
        //}
        //if (signerCertPath == null) {
            //throw new NullPointerException("signerCertPath == null");
        //}
        //this.timestamp = new Date(timestamp.getTime());
        //this.signerCertPath = signerCertPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.569 -0400", hash_original_method = "5EC26C09389FD151E3B15C0B386F0A3D", hash_generated_method = "67D29F80AD604685490A3D49FEC60F21")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_575698210 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041961915 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041961915;
        } //End block
        if(obj instanceof Timestamp)        
        {
            Timestamp that = (Timestamp) obj;
            boolean varEC08B8B81AF7E2D4D32089CA1D12837F_597064757 = (timestamp.equals(that.timestamp)
                    && signerCertPath.equals(that.signerCertPath));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2054802919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2054802919;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2055685232 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91229567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91229567;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (obj instanceof Timestamp) {
            //Timestamp that = (Timestamp) obj;
            //return timestamp.equals(that.timestamp)
                    //&& signerCertPath.equals(that.signerCertPath);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.569 -0400", hash_original_method = "30F2DDB76579221F80A186A0F4D6B0C1", hash_generated_method = "9C715E7C96C5D5A3DA15A1F57F2A21D6")
    public CertPath getSignerCertPath() {
CertPath varC4579A22BE0444B538B995294C4BD4B5_177677939 =         signerCertPath;
        varC4579A22BE0444B538B995294C4BD4B5_177677939.addTaint(taint);
        return varC4579A22BE0444B538B995294C4BD4B5_177677939;
        // ---------- Original Method ----------
        //return signerCertPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.570 -0400", hash_original_method = "9F5E9DF58C2165A57C2B03C2ABFACB32", hash_generated_method = "DB5BBC3050E695D4D7BDFD12884CB354")
    public Date getTimestamp() {
Date var9C830804DEBADE9F0F9D7100079F1F4C_843730742 =         (Date) timestamp.clone();
        var9C830804DEBADE9F0F9D7100079F1F4C_843730742.addTaint(taint);
        return var9C830804DEBADE9F0F9D7100079F1F4C_843730742;
        // ---------- Original Method ----------
        //return (Date) timestamp.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.570 -0400", hash_original_method = "31DF5B7E8A0074E9903AAC481766C16B", hash_generated_method = "6E34CAEFC72CCE2D934E39C46BD57C17")
    @Override
    public int hashCode() {
        if(hash == 0)        
        {
            hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1896467987 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134171518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134171518;
        // ---------- Original Method ----------
        //if (hash == 0) {
            //hash = timestamp.hashCode() ^ signerCertPath.hashCode();
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.571 -0400", hash_original_method = "515CC78E7249E5726FD47C9B8B62F1A0", hash_generated_method = "AA18F8559CBFA850D371888EBAA43F94")
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(256);
        buf.append("Timestamp [").append(timestamp).append(" certPath=");
        buf.append(signerCertPath.getCertificates().get(0)).append("]");
String var4FC680801218E6372BC708D6FA44AE60_1908844435 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1908844435.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1908844435;
        // ---------- Original Method ----------
        //StringBuilder buf = new StringBuilder(256);
        //buf.append("Timestamp [").append(timestamp).append(" certPath=");
        //buf.append(signerCertPath.getCertificates().get(0)).append("]");
        //return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.571 -0400", hash_original_field = "B3E56E4CB108BFE836E4A5A57F75FAC2", hash_generated_field = "E7A91C55874DE95C878CDAFEDEEC7D72")

    private static final long serialVersionUID = -5502683707821851294L;
}

