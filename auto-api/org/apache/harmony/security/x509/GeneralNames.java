package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class GeneralNames {
    private List<GeneralName> generalNames;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.784 -0400", hash_original_method = "900922C5A2333ABDC3D6DB9D2843B6C9", hash_generated_method = "8A74688EB414143E6D1C7929DFB8071B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GeneralNames() {
        generalNames = new ArrayList<GeneralName>();
        // ---------- Original Method ----------
        //generalNames = new ArrayList<GeneralName>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.784 -0400", hash_original_method = "FCF1D75BDAE857F225708496A2E96EC2", hash_generated_method = "3A0845361D4D266B5C0D81DE38178A7A")
    @DSModeled(DSC.SAFE)
    public GeneralNames(List<GeneralName> generalNames) {
        dsTaint.addTaint(generalNames.dsTaint);
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.784 -0400", hash_original_method = "84AB2B2BC22C66DEEE9A4059D9B177CB", hash_generated_method = "8B37EBD3FAAF89412039ED74F29B727A")
    @DSModeled(DSC.SAFE)
    private GeneralNames(List<GeneralName> generalNames, byte[] encoding) {
        dsTaint.addTaint(generalNames.dsTaint);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.784 -0400", hash_original_method = "0BE5F893124FC75916B0920319238607", hash_generated_method = "0C8455B32E9042461762454B8BEF0752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<GeneralName> getNames() {
        {
            boolean var133461071AA2D0765E0C74451BBECA7C_968037637 = ((generalNames == null) || (generalNames.size() == 0));
        } //End collapsed parenthetic
        List<GeneralName> var75D52145DD6514AC509C8119B5982DB7_184682024 = (new ArrayList<GeneralName>(generalNames));
        return (List<GeneralName>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if ((generalNames == null) || (generalNames.size() == 0)) {
            //return null;
        //}
        //return new ArrayList<GeneralName>(generalNames);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.786 -0400", hash_original_method = "393D0968412D8AD2DE170EB074DB113A", hash_generated_method = "663F4EFCF4D02E9C5B8CCFEBE3C0FA0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> getPairsList() {
        Collection<List<?>> result;
        result = new ArrayList<List<?>>();
        {
            Iterator<GeneralName> var48792B06BC03602C9020A2E3077F838C_1689035050 = (generalNames).iterator();
            var48792B06BC03602C9020A2E3077F838C_1689035050.hasNext();
            GeneralName generalName = var48792B06BC03602C9020A2E3077F838C_1689035050.next();
            {
                result.add(generalName.getAsList());
            } //End block
        } //End collapsed parenthetic
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<List<?>> result = new ArrayList<List<?>>();
        //if (generalNames == null) {
            //return result;
        //}
        //for (GeneralName generalName : generalNames) {
            //result.add(generalName.getAsList());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.786 -0400", hash_original_method = "62FCFAA5CD61EB40B84DD9F5E8E0A72D", hash_generated_method = "8DB0CE4EF37F7B3731D32F6D60BD7A6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addName(GeneralName name) {
        dsTaint.addTaint(name.dsTaint);
        encoding = null;
        {
            generalNames = new ArrayList<GeneralName>();
        } //End block
        generalNames.add(name);
        // ---------- Original Method ----------
        //encoding = null;
        //if (generalNames == null) {
            //generalNames = new ArrayList<GeneralName>();
        //}
        //generalNames.add(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.786 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.788 -0400", hash_original_method = "78509CF3CFA7027FFCDFED35C29E300D", hash_generated_method = "592EFA311EA9DC86C7C12BF45063394C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        {
            Iterator<GeneralName> var48792B06BC03602C9020A2E3077F838C_1671410410 = (generalNames).iterator();
            var48792B06BC03602C9020A2E3077F838C_1671410410.hasNext();
            GeneralName generalName = var48792B06BC03602C9020A2E3077F838C_1671410410.next();
            {
                sb.append(prefix);
                sb.append(generalName);
                sb.append('\n');
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (generalNames == null) {
            //return;
        //}
        //for (GeneralName generalName : generalNames) {
            //sb.append(prefix);
            //sb.append(generalName);
            //sb.append('\n');
        //}
    }

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralName.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.789 -0400", hash_original_method = "9A3FA9B8D9477389BCCE5A60E545BDE1", hash_generated_method = "F3BAE93A8F5CCF0381EE534A5F2C953A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var3C8A691F4AC649939E74A38A16FD0E38_1829821490 = (new GeneralNames((List<GeneralName>) in.content, in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new GeneralNames((List<GeneralName>) in.content, in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.789 -0400", hash_original_method = "0E3B702024D2ADCD7756F36AE80C73BB", hash_generated_method = "8A5574A859881E47C58418646EA26A65")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            GeneralNames gns;
            gns = (GeneralNames) object;
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //GeneralNames gns = (GeneralNames) object;
            //return gns.generalNames;
        }

        
}; //Transformed anonymous class
}

