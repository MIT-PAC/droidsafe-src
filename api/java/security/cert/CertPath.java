package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;






public abstract class CertPath implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.618 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.619 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "32FAE556A05A6016667B95DE68F07950")
    protected  CertPath(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.619 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "4DC4C4B6DF7772E5659454A7F3708FEC")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1160410815 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1160410815.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1160410815;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.620 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "8D4806A1193367F3DF0F31EE17F74935")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(this == other)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1660602100 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562395827 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562395827;
        } //End block
        if(other instanceof CertPath)        
        {
            CertPath o = (CertPath)other;
            if(getType().equals(o.getType()))            
            {
                if(getCertificates().equals(o.getCertificates()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1816122694 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400934492 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_400934492;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_671825992 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028100883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028100883;
        // ---------- Original Method ----------
        //if (this == other) {
            //return true;
        //}
        //if (other instanceof CertPath) {
            //CertPath o = (CertPath)other;
            //if (getType().equals(o.getType())) {
                //if (getCertificates().equals(o.getCertificates())) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.621 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "24C52F000BA8340F32C2EF9C6DD402AB")
    public int hashCode() {
        int hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        int var0800FC577294C34E0B28AD2839435945_1728132734 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35514899 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_35514899;
        // ---------- Original Method ----------
        //int hash = getType().hashCode();
        //hash = hash*31 + getCertificates().hashCode();
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.621 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "3729E237A84A54874DAC8CED89C85EBE")
    public String toString() {
        StringBuilder sb = new StringBuilder(getType());
        sb.append(" Cert Path, len=");
        sb.append(getCertificates().size());
        sb.append(": [\n");
        int n = 1;
for(Iterator<? extends Certificate> i=getCertificates().iterator();i.hasNext();n++)
        {
            sb.append("---------------certificate ");
            sb.append(n);
            sb.append("---------------\n");
            sb.append(((Certificate)i.next()).toString());
        } //End block
        sb.append("\n]");
String var2460B846747F8B22185AD8BE722266A5_891863046 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_891863046.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_891863046;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(getType());
        //sb.append(" Cert Path, len=");
        //sb.append(getCertificates().size());
        //sb.append(": [\n");
        //int n=1;
        //for (Iterator<? extends Certificate> i=getCertificates().iterator(); i.hasNext(); n++) {
            //sb.append("---------------certificate ");
            //sb.append(n);
            //sb.append("---------------\n");
            //sb.append(((Certificate)i.next()).toString());
        //}
        //sb.append("\n]");
        //return sb.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract List<? extends Certificate> getCertificates();

    
    @DSModeled(DSC.SAFE)
    public abstract byte[] getEncoded()
        throws CertificateEncodingException;

    
    @DSModeled(DSC.SAFE)
    public abstract byte[] getEncoded(String encoding)
        throws CertificateEncodingException;

    
    @DSModeled(DSC.SAFE)
    public abstract Iterator<String> getEncodings();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.623 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "B608B58785A9F121248EA00CD765020A")
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
Object varF32523CCB977B1DE0F6996279C4CFB92_2089604252 =             new CertPathRep(getType(), getEncoded());
            varF32523CCB977B1DE0F6996279C4CFB92_2089604252.addTaint(taint);
            return varF32523CCB977B1DE0F6996279C4CFB92_2089604252;
        } //End block
        catch (CertificateEncodingException e)
        {
            NotSerializableException varD10E63AB14446D5829D48417DD9728EF_440171043 = new NotSerializableException("Could not create serialization object: " + e);
            varD10E63AB14446D5829D48417DD9728EF_440171043.addTaint(taint);
            throw varD10E63AB14446D5829D48417DD9728EF_440171043;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return new CertPathRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertPathRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.623 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.623 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.623 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "19372CAD6BE4BFEBCEC4EB919465B09C")
        protected  CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.624 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "4AE8F69DEC71F391F69CE3ABEFEC8A62")
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
Object var4779577E48F22F818854F762C7F32E27_1834783897 =                 cf.generateCertPath(new ByteArrayInputStream(data));
                var4779577E48F22F818854F762C7F32E27_1834783897.addTaint(taint);
                return var4779577E48F22F818854F762C7F32E27_1834783897;
            } //End block
            catch (Throwable t)
            {
                NotSerializableException varE7122A44B8BF6A773A22CCDDF1A73575_638132191 = new NotSerializableException("Could not resolve cert path: " + t);
                varE7122A44B8BF6A773A22CCDDF1A73575_638132191.addTaint(taint);
                throw varE7122A44B8BF6A773A22CCDDF1A73575_638132191;
            } //End block
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertPath(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve cert path: " + t);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.624 -0400", hash_original_field = "0B634D7FC833919416D0496374E4AF21", hash_generated_field = "257527E5D7CAC38935714E2F9D854C92")

        private static final long serialVersionUID = 3015633072427920915L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.624 -0400", hash_original_field = "9F024A6EA4C454294BBA3B153ECEE2E9", hash_generated_field = "E876B47DC0C1A51B5A847035A18C8EA1")

        private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.624 -0400", hash_original_field = "38366AF561608EE79125A53C2B98C3CF", hash_generated_field = "22A8873A3B050ACEADFDDE2FD50272BD")

    private static final long serialVersionUID = 6068470306649138683L;
}

