package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class CertPath implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.744 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.760 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "32FAE556A05A6016667B95DE68F07950")
    protected  CertPath(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.761 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "785BB7DC888B21C500BC9B2B8DFBE7F9")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_462449065 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_462449065 = type;
        varB4EAC82CA7396A68D541C85D26508E83_462449065.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_462449065;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.761 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "7C535BA43735E724CF2EE9B16FE24112")
    public boolean equals(Object other) {
        {
            CertPath o;
            o = (CertPath)other;
            {
                boolean var0B4325E6BB137D98ED2236D466B08DE0_326030578 = (getType().equals(o.getType()));
                {
                    {
                        boolean varA9774916D2CD7B74DA51CC6C2F434D32_1485403605 = (getCertificates().equals(o.getCertificates()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608195517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608195517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.762 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "11B012D495704007934C2FC5406B09A0")
    public int hashCode() {
        int hash;
        hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599802319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1599802319;
        // ---------- Original Method ----------
        //int hash = getType().hashCode();
        //hash = hash*31 + getCertificates().hashCode();
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.764 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "6A18CA5ED44D73BC02BF8181100D33D7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_224939817 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(getType());
        sb.append(" Cert Path, len=");
        sb.append(getCertificates().size());
        sb.append(": [\n");
        int n;
        n = 1;
        {
            Iterator<? extends Certificate> i;
            i = getCertificates().iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1405923548 = (i.hasNext());
            {
                sb.append("---------------certificate ");
                sb.append(n);
                sb.append("---------------\n");
                sb.append(((Certificate)i.next()).toString());
            } //End block
        } //End collapsed parenthetic
        sb.append("\n]");
        varB4EAC82CA7396A68D541C85D26508E83_224939817 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_224939817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_224939817;
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

    
    public abstract List<? extends Certificate> getCertificates();

    
    public abstract byte[] getEncoded()
        throws CertificateEncodingException;

    
    public abstract byte[] getEncoded(String encoding)
        throws CertificateEncodingException;

    
    public abstract Iterator<String> getEncodings();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.779 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "7319E0910C7C124134FAFD5DFF6A2F21")
    protected Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2074403595 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2074403595 = new CertPathRep(getType(), getEncoded());
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2074403595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2074403595;
        // ---------- Original Method ----------
        //try {
            //return new CertPathRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertPathRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.779 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.779 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.780 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "19372CAD6BE4BFEBCEC4EB919465B09C")
        protected  CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.791 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "56B0561CC8A01FF0936F5AB1E32F7D2B")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_8191789 = null; //Variable for return #1
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                varB4EAC82CA7396A68D541C85D26508E83_8191789 = cf.generateCertPath(new ByteArrayInputStream(data));
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve cert path: " + t);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_8191789.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_8191789;
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertPath(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve cert path: " + t);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.884 -0400", hash_original_field = "0B634D7FC833919416D0496374E4AF21", hash_generated_field = "017A01176455911575D44C45C38E3057")

        private static long serialVersionUID = 3015633072427920915L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.884 -0400", hash_original_field = "9F024A6EA4C454294BBA3B153ECEE2E9", hash_generated_field = "AA3ACD5D61FE427C1A83E23F0DF55483")

        private static ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.884 -0400", hash_original_field = "38366AF561608EE79125A53C2B98C3CF", hash_generated_field = "81C567ABDF83BD657657903EBE8349A0")

    private static long serialVersionUID = 6068470306649138683L;
}

