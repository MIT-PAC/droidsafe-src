package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public abstract class CertPath implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.592 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.592 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "32FAE556A05A6016667B95DE68F07950")
    protected  CertPath(String type) {
        this.type = type;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.593 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "53E529FC7BD38791607C286D18472738")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_283962929 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_283962929.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_283962929;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.593 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "EDEDD49A695EC03F43008F4F8D0469AE")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(this == other)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_229118861 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093574979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093574979;
        } 
    if(other instanceof CertPath)        
        {
            CertPath o = (CertPath)other;
    if(getType().equals(o.getType()))            
            {
    if(getCertificates().equals(o.getCertificates()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1378454728 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197144807 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_197144807;
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_970778737 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_319279854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_319279854;
        
        
            
        
        
            
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.594 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "8A27AAB4F3247ACAF6CCC18EF664DB0D")
    public int hashCode() {
        int hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        int var0800FC577294C34E0B28AD2839435945_1467905892 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863897296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863897296;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.595 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "771F9F2387B7C6695CF8F10F699DA1F1")
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
        } 
        sb.append("\n]");
String var2460B846747F8B22185AD8BE722266A5_2102265923 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_2102265923.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_2102265923;
        
        
        
        
        
        
        
            
            
            
            
        
        
        
    }

    
    public abstract List<? extends Certificate> getCertificates();

    
    public abstract byte[] getEncoded()
        throws CertificateEncodingException;

    
    public abstract byte[] getEncoded(String encoding)
        throws CertificateEncodingException;

    
    public abstract Iterator<String> getEncodings();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.596 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "453941F1E15FAF72FD61394C775A4AD9")
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
Object varF32523CCB977B1DE0F6996279C4CFB92_1557455588 =             new CertPathRep(getType(), getEncoded());
            varF32523CCB977B1DE0F6996279C4CFB92_1557455588.addTaint(taint);
            return varF32523CCB977B1DE0F6996279C4CFB92_1557455588;
        } 
        catch (CertificateEncodingException e)
        {
            NotSerializableException varD10E63AB14446D5829D48417DD9728EF_590700439 = new NotSerializableException("Could not create serialization object: " + e);
            varD10E63AB14446D5829D48417DD9728EF_590700439.addTaint(taint);
            throw varD10E63AB14446D5829D48417DD9728EF_590700439;
        } 
        
        
            
        
            
        
    }

    
    protected static class CertPathRep implements Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.596 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.597 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BCB00A81B11593F3A75239028B6E65B9")

        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.597 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "19372CAD6BE4BFEBCEC4EB919465B09C")
        protected  CertPathRep(String type, byte[] data) {
            this.type = type;
            this.data = data;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.598 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "9DF590BD4B63796734745804D7BA313C")
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf = CertificateFactory.getInstance(type);
Object var4779577E48F22F818854F762C7F32E27_1873131898 =                 cf.generateCertPath(new ByteArrayInputStream(data));
                var4779577E48F22F818854F762C7F32E27_1873131898.addTaint(taint);
                return var4779577E48F22F818854F762C7F32E27_1873131898;
            } 
            catch (Throwable t)
            {
                NotSerializableException varE7122A44B8BF6A773A22CCDDF1A73575_1308842857 = new NotSerializableException("Could not resolve cert path: " + t);
                varE7122A44B8BF6A773A22CCDDF1A73575_1308842857.addTaint(taint);
                throw varE7122A44B8BF6A773A22CCDDF1A73575_1308842857;
            } 
            
            
                
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.598 -0400", hash_original_field = "0B634D7FC833919416D0496374E4AF21", hash_generated_field = "257527E5D7CAC38935714E2F9D854C92")

        private static final long serialVersionUID = 3015633072427920915L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.598 -0400", hash_original_field = "9F024A6EA4C454294BBA3B153ECEE2E9", hash_generated_field = "E876B47DC0C1A51B5A847035A18C8EA1")

        private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.598 -0400", hash_original_field = "38366AF561608EE79125A53C2B98C3CF", hash_generated_field = "22A8873A3B050ACEADFDDE2FD50272BD")

    private static final long serialVersionUID = 6068470306649138683L;
}

