package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;




public class GeneralNames extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.716 -0400", hash_original_field = "A8998C31A141924D06220074FCDC6925", hash_generated_field = "74CEDC81B0DB27B07D173878E0284C60")

    private GeneralName[] names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.717 -0400", hash_original_method = "F51AA332BBC1C75C23F2395E3D593569", hash_generated_method = "AACD523E399433764EB6C8C7D1E5A05B")
    public  GeneralNames(
        GeneralName  name) {
        addTaint(name.getTaint());
        this.names = new GeneralName[] { name };
        // ---------- Original Method ----------
        //this.names = new GeneralName[] { name };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.718 -0400", hash_original_method = "6F12A07D09CAFA480B0283A3B9FED616", hash_generated_method = "6B0C6093C710D50C58BB353912FB2203")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.720 -0400", hash_original_method = "9AED96B400BA543408C9F5E967093153", hash_generated_method = "00BA1A777D88104556142170D818D44C")
    public GeneralName[] getNames() {
        GeneralName[] tmp = new GeneralName[names.length];
        System.arraycopy(names, 0, tmp, 0, names.length);
GeneralName[] var3F12A0424932F6B5155AA6C49B63FE6E_1837056744 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1837056744.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1837056744;
        // ---------- Original Method ----------
        //GeneralName[] tmp = new GeneralName[names.length];
        //System.arraycopy(names, 0, tmp, 0, names.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.720 -0400", hash_original_method = "04D00D35531AB013A64ACFCEB501C4EE", hash_generated_method = "F948B176B922A1891C7D83C87025FAFB")
    public DERObject toASN1Object() {
DERObject varFA028EE8512E8E6D5C4DBDCDB27CF46F_1709320671 =         new DERSequence(names);
        varFA028EE8512E8E6D5C4DBDCDB27CF46F_1709320671.addTaint(taint);
        return varFA028EE8512E8E6D5C4DBDCDB27CF46F_1709320671;
        // ---------- Original Method ----------
        //return new DERSequence(names);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.720 -0400", hash_original_method = "7DDFA5C3E7762D6D39ED7DFFF0863845", hash_generated_method = "17AC37207F0B4CDD5328DC7DB20AAF0E")
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
String var4FC680801218E6372BC708D6FA44AE60_595380278 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_595380278.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_595380278;
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

