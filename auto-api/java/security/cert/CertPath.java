package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class CertPath implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.931 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.931 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "32FAE556A05A6016667B95DE68F07950")
    protected  CertPath(String type) {
        this.type = type;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.932 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "14E52E951FCDCF195AD444E9BEF3B81F")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1859497746 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1859497746 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1859497746.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1859497746;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.932 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "570EC309722D943E74D629DEC50E90B7")
    public boolean equals(Object other) {
        {
            CertPath o = (CertPath)other;
            {
                boolean var0B4325E6BB137D98ED2236D466B08DE0_339897857 = (getType().equals(o.getType()));
                {
                    {
                        boolean varA9774916D2CD7B74DA51CC6C2F434D32_37452503 = (getCertificates().equals(o.getCertificates()));
                    } 
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_231471544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_231471544;
        
        
            
        
        
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.933 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "B7FA1700773B4AF5289C16C125619031")
    public int hashCode() {
        int hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055252263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055252263;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.933 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "709C06EC1C19287F31C4E5AC4568605E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_535775254 = null; 
        StringBuilder sb = new StringBuilder(getType());
        sb.append(" Cert Path, len=");
        sb.append(getCertificates().size());
        sb.append(": [\n");
        int n = 1;
        {
            Iterator<? extends Certificate> i = getCertificates().iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1541396669 = (i.hasNext());
            {
                sb.append("---------------certificate ");
                sb.append(n);
                sb.append("---------------\n");
                sb.append(((Certificate)i.next()).toString());
            } 
        } 
        sb.append("\n]");
        varB4EAC82CA7396A68D541C85D26508E83_535775254 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_535775254.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_535775254;
        
        
        
        
        
        
        
            
            
            
            
        
        
        
    }

    
    public abstract List<? extends Certificate> getCertificates();

    
    public abstract byte[] getEncoded()
        throws CertificateEncodingException;

    
    public abstract byte[] getEncoded(String encoding)
        throws CertificateEncodingException;

    
    public abstract Iterator<String> getEncodings();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.935 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "1B8B88EB281B9BAF2B56165F969EB907")
    protected Object writeReplace() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_707694917 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_707694917 = new CertPathRep(getType(), getEncoded());
        } 
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_707694917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_707694917;
        
        
            
        
            
        
    }

    
    protected static class CertPathRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.935 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.935 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.935 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "19372CAD6BE4BFEBCEC4EB919465B09C")
        protected  CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.935 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "EA67C13153CD68B4E44FF041C090C57E")
        protected Object readResolve() throws ObjectStreamException {
            Object varB4EAC82CA7396A68D541C85D26508E83_196295507 = null; 
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
                varB4EAC82CA7396A68D541C85D26508E83_196295507 = cf.generateCertPath(new ByteArrayInputStream(data));
            } 
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve cert path: " + t);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_196295507.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_196295507;
            
            
                
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.936 -0400", hash_original_field = "0B634D7FC833919416D0496374E4AF21", hash_generated_field = "257527E5D7CAC38935714E2F9D854C92")

        private static final long serialVersionUID = 3015633072427920915L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.936 -0400", hash_original_field = "9F024A6EA4C454294BBA3B153ECEE2E9", hash_generated_field = "E876B47DC0C1A51B5A847035A18C8EA1")

        private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.936 -0400", hash_original_field = "38366AF561608EE79125A53C2B98C3CF", hash_generated_field = "22A8873A3B050ACEADFDDE2FD50272BD")

    private static final long serialVersionUID = 6068470306649138683L;
}

