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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.422 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.429 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "32FAE556A05A6016667B95DE68F07950")
    protected  CertPath(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.436 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "A69A359200B2A7E5B76C92C461544A17")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1470674527 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1470674527 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1470674527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1470674527;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.437 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "ABB2D8FAAAE848FE1E9518EEDD499224")
    public boolean equals(Object other) {
        {
            CertPath o;
            o = (CertPath)other;
            {
                boolean var0B4325E6BB137D98ED2236D466B08DE0_117870830 = (getType().equals(o.getType()));
                {
                    {
                        boolean varA9774916D2CD7B74DA51CC6C2F434D32_950073438 = (getCertificates().equals(o.getCertificates()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312275538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312275538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.437 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "930B7323FB2D7D8BDF38B7957B5AC230")
    public int hashCode() {
        int hash;
        hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572366338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572366338;
        // ---------- Original Method ----------
        //int hash = getType().hashCode();
        //hash = hash*31 + getCertificates().hashCode();
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.438 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "26477F8C2DB5AFC59DFB0FEE9E179A3E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2072937135 = null; //Variable for return #1
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
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_2036469328 = (i.hasNext());
            {
                sb.append("---------------certificate ");
                sb.append(n);
                sb.append("---------------\n");
                sb.append(((Certificate)i.next()).toString());
            } //End block
        } //End collapsed parenthetic
        sb.append("\n]");
        varB4EAC82CA7396A68D541C85D26508E83_2072937135 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2072937135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072937135;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.449 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "8D9A2582E0B8EC5DFEF52EE3A41B882C")
    protected Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_256636297 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_256636297 = new CertPathRep(getType(), getEncoded());
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_256636297.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_256636297;
        // ---------- Original Method ----------
        //try {
            //return new CertPathRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertPathRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.449 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.449 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.450 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "19372CAD6BE4BFEBCEC4EB919465B09C")
        protected  CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.450 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "1C22D40CD73B7BF17E0E2D5AA43F9A4F")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_2070811941 = null; //Variable for return #1
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                varB4EAC82CA7396A68D541C85D26508E83_2070811941 = cf.generateCertPath(new ByteArrayInputStream(data));
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve cert path: " + t);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2070811941.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2070811941;
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertPath(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve cert path: " + t);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.450 -0400", hash_original_field = "0B634D7FC833919416D0496374E4AF21", hash_generated_field = "017A01176455911575D44C45C38E3057")

        private static long serialVersionUID = 3015633072427920915L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.450 -0400", hash_original_field = "9F024A6EA4C454294BBA3B153ECEE2E9", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

        private static ObjectStreamField[] serialPersistentFields = ;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.450 -0400", hash_original_field = "38366AF561608EE79125A53C2B98C3CF", hash_generated_field = "81C567ABDF83BD657657903EBE8349A0")

    private static long serialVersionUID = 6068470306649138683L;
}

