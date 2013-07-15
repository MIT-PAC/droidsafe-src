package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class GeneralNames extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.077 -0400", hash_original_field = "A8998C31A141924D06220074FCDC6925", hash_generated_field = "74CEDC81B0DB27B07D173878E0284C60")

    private GeneralName[] names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.077 -0400", hash_original_method = "F51AA332BBC1C75C23F2395E3D593569", hash_generated_method = "AACD523E399433764EB6C8C7D1E5A05B")
    public  GeneralNames(
        GeneralName  name) {
        addTaint(name.getTaint());
        this.names = new GeneralName[] { name };
        // ---------- Original Method ----------
        //this.names = new GeneralName[] { name };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.078 -0400", hash_original_method = "6F12A07D09CAFA480B0283A3B9FED616", hash_generated_method = "6B0C6093C710D50C58BB353912FB2203")
    public  GeneralNames(
        ASN1Sequence  seq) {
        this.names = new GeneralName[seq.size()];
for(int i = 0;i != seq.size();i++)
        {
            names[i] = GeneralName.getInstance(seq.getObjectAt(i));
        } //End block
        // ---------- Original Method ----------
        //this.names = new GeneralName[seq.size()];
        //for (int i = 0; i != seq.size(); i++)
        //{
            //names[i] = GeneralName.getInstance(seq.getObjectAt(i));
        //}
    }

    
        public static GeneralNames getInstance(
        Object  obj) {
        if (obj == null || obj instanceof GeneralNames)
        {
            return (GeneralNames)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new GeneralNames((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static GeneralNames getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.078 -0400", hash_original_method = "9AED96B400BA543408C9F5E967093153", hash_generated_method = "3E755C267439B2508A935EBBDF420712")
    public GeneralName[] getNames() {
        GeneralName[] tmp = new GeneralName[names.length];
        System.arraycopy(names, 0, tmp, 0, names.length);
GeneralName[] var3F12A0424932F6B5155AA6C49B63FE6E_297255891 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_297255891.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_297255891;
        // ---------- Original Method ----------
        //GeneralName[] tmp = new GeneralName[names.length];
        //System.arraycopy(names, 0, tmp, 0, names.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.079 -0400", hash_original_method = "04D00D35531AB013A64ACFCEB501C4EE", hash_generated_method = "6213496E73514B6D7A37D51E34D5B20F")
    public DERObject toASN1Object() {
DERObject varFA028EE8512E8E6D5C4DBDCDB27CF46F_91400780 =         new DERSequence(names);
        varFA028EE8512E8E6D5C4DBDCDB27CF46F_91400780.addTaint(taint);
        return varFA028EE8512E8E6D5C4DBDCDB27CF46F_91400780;
        // ---------- Original Method ----------
        //return new DERSequence(names);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.079 -0400", hash_original_method = "7DDFA5C3E7762D6D39ED7DFFF0863845", hash_generated_method = "A2D56375D86539388F5BB8156EF6206A")
    public String toString() {
        StringBuffer buf = new StringBuffer();
        String sep = System.getProperty("line.separator");
        buf.append("GeneralNames:");
        buf.append(sep);
for(int i = 0;i != names.length;i++)
        {
            buf.append("    ");
            buf.append(names[i]);
            buf.append(sep);
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_1406346281 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1406346281.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1406346281;
        // ---------- Original Method ----------
        //StringBuffer  buf = new StringBuffer();
        //String        sep = System.getProperty("line.separator");
        //buf.append("GeneralNames:");
        //buf.append(sep);
        //for (int i = 0; i != names.length; i++)
        //{
            //buf.append("    ");
            //buf.append(names[i]);
            //buf.append(sep);
        //}
        //return buf.toString();
    }

    
}

