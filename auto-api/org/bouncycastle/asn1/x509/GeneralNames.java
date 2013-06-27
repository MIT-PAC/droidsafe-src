package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class GeneralNames extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.988 -0400", hash_original_field = "A8998C31A141924D06220074FCDC6925", hash_generated_field = "74CEDC81B0DB27B07D173878E0284C60")

    private GeneralName[] names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.989 -0400", hash_original_method = "F51AA332BBC1C75C23F2395E3D593569", hash_generated_method = "8BC893C6BAC23CD880DBCF48578BF738")
    public  GeneralNames(
        GeneralName  name) {
        this.names = new GeneralName[] { name };
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //this.names = new GeneralName[] { name };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.990 -0400", hash_original_method = "6F12A07D09CAFA480B0283A3B9FED616", hash_generated_method = "21D20E053986F4F98EAA26DF257A98CD")
    public  GeneralNames(
        ASN1Sequence  seq) {
        this.names = new GeneralName[seq.size()];
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_618340948 = (i != seq.size());
            {
                names[i] = GeneralName.getInstance(seq.getObjectAt(i));
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.995 -0400", hash_original_method = "9AED96B400BA543408C9F5E967093153", hash_generated_method = "629048392A7457123D9AA6EB37EBA903")
    public GeneralName[] getNames() {
        GeneralName[] varB4EAC82CA7396A68D541C85D26508E83_1571930482 = null; //Variable for return #1
        GeneralName[] tmp;
        tmp = new GeneralName[names.length];
        System.arraycopy(names, 0, tmp, 0, names.length);
        varB4EAC82CA7396A68D541C85D26508E83_1571930482 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_1571930482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571930482;
        // ---------- Original Method ----------
        //GeneralName[] tmp = new GeneralName[names.length];
        //System.arraycopy(names, 0, tmp, 0, names.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.007 -0400", hash_original_method = "04D00D35531AB013A64ACFCEB501C4EE", hash_generated_method = "85B5C28F65A4944F9CC95FB08267B393")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_848479529 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_848479529 = new DERSequence(names);
        varB4EAC82CA7396A68D541C85D26508E83_848479529.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848479529;
        // ---------- Original Method ----------
        //return new DERSequence(names);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.013 -0400", hash_original_method = "7DDFA5C3E7762D6D39ED7DFFF0863845", hash_generated_method = "7AB88E187659145922ED351D96C83CB9")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1496021773 = null; //Variable for return #1
        StringBuffer buf;
        buf = new StringBuffer();
        String sep;
        sep = System.getProperty("line.separator");
        buf.append("GeneralNames:");
        buf.append(sep);
        {
            int i;
            i = 0;
            {
                buf.append("    ");
                buf.append(names[i]);
                buf.append(sep);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1496021773 = buf.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1496021773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496021773;
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

