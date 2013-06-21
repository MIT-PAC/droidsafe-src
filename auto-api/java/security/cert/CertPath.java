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
    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.621 -0400", hash_original_method = "302897E6BB0E40528F36909A6049B176", hash_generated_method = "EC6D91A243AE8CF8A0CDB8CC37CCE1F0")
    @DSModeled(DSC.SAFE)
    protected CertPath(String type) {
        dsTaint.addTaint(type);
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.622 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "AC38FD6D562C8CFA3E5E586F21D2F37D")
    @DSModeled(DSC.SAFE)
    public String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.623 -0400", hash_original_method = "8F841F69BEA866198CC0B2087E3E8CE8", hash_generated_method = "63896CE51ECC8F0532F5BB4EAD5743D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            CertPath o;
            o = (CertPath)other;
            {
                boolean var0B4325E6BB137D98ED2236D466B08DE0_1080688188 = (getType().equals(o.getType()));
                {
                    {
                        boolean varA9774916D2CD7B74DA51CC6C2F434D32_649145149 = (getCertificates().equals(o.getCertificates()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.623 -0400", hash_original_method = "E8BB667E09C60EB11FBFEAA1F9E519B1", hash_generated_method = "A27F17FAC3E2D5776FE11E123C1DD372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int hash;
        hash = getType().hashCode();
        hash = hash*31 + getCertificates().hashCode();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hash = getType().hashCode();
        //hash = hash*31 + getCertificates().hashCode();
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.623 -0400", hash_original_method = "476AF39C272D39EAE140D33789265072", hash_generated_method = "44D6CE19CF64443954631217FB4E5A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
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
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1180291696 = (i.hasNext());
            {
                sb.append("---------------certificate ");
                sb.append(n);
                sb.append("---------------\n");
                sb.append(((Certificate)i.next()).toString());
            } //End block
        } //End collapsed parenthetic
        sb.append("\n]");
        String var806458D832AB974D230FEE4CBBDBD390_1004398874 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.624 -0400", hash_original_method = "52819054EFF055A3D86733F1F32E0BA5", hash_generated_method = "AD4052C636C64C5B0F1FBFF490E56B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object writeReplace() throws ObjectStreamException {
        try 
        {
            Object var50E0BAF05F8A188C7768A0C07E3C1D61_1815759743 = (new CertPathRep(getType(), getEncoded()));
        } //End block
        catch (CertificateEncodingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not create serialization object: " + e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return new CertPathRep(getType(), getEncoded());
        //} catch (CertificateEncodingException e) {
            //throw new NotSerializableException("Could not create serialization object: " + e);
        //}
    }

    
    protected static class CertPathRep implements Serializable {
        private String type;
        private byte[] data;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.624 -0400", hash_original_method = "306F916982958535E78B2E37AF24DE52", hash_generated_method = "8780B2622E92F1D022DCFBAEBAE6F759")
        @DSModeled(DSC.SAFE)
        protected CertPathRep(String type, byte[] data) {
            dsTaint.addTaint(data[0]);
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //this.type = type;
            //this.data = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.624 -0400", hash_original_method = "901613A0C14C6295CBB5D8B0F4F8E8BD", hash_generated_method = "0F0AE517D0BE0E5D0460A287473EC870")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Object readResolve() throws ObjectStreamException {
            try 
            {
                CertificateFactory cf;
                cf = CertificateFactory.getInstance(type);
                Object var545959DF96C4F97FAD5D6DB2BCD2AF2F_2012256159 = (cf.generateCertPath(new ByteArrayInputStream(data)));
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new NotSerializableException("Could not resolve cert path: " + t);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //CertificateFactory cf = CertificateFactory.getInstance(type);
                //return cf.generateCertPath(new ByteArrayInputStream(data));
            //} catch (Throwable t) {
                //throw new NotSerializableException("Could not resolve cert path: " + t);
            //}
        }

        
        private static final long serialVersionUID = 3015633072427920915L;
        private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("type", String.class),
            new ObjectStreamField("data", byte[].class, true),
        };
    }


    
    private static final long serialVersionUID = 6068470306649138683L;
}

