package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class ExtendedKeyUsage extends ExtensionValue {
    private List<String> keys;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.647 -0400", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "6C1ED22FD5C8CDC2EFDA559F40B20330")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.647 -0400", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "EBC1014BFE1E14C70212AE51B695042A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> getExtendedKeyUsage() throws IOException {
        {
            keys = (List<String>) ASN1.decode(getEncoded());
        } //End block
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (keys == null) {
            //keys = (List<String>) ASN1.decode(getEncoded());
        //}
        //return keys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.647 -0400", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "889BF58A624909839A6E3F69D8515B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(keys);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keys);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.648 -0400", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "3C51A36CD852E3520F26F41608E26F0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Extended Key Usage: ");
        {
            try 
            {
                keys = getExtendedKeyUsage();
            } //End block
            catch (IOException e)
            {
                super.dumpValue(sb);
            } //End block
        } //End block
        sb.append('[');
        {
            Iterator<?> it;
            it = keys.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_890382211 = (it.hasNext());
            {
                sb.append(" \"").append(it.next()).append('"');
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1002481702 = (it.hasNext());
                    {
                        sb.append(',');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sb.append(" ]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("Extended Key Usage: ");
        //if (keys == null) {
            //try {
                //keys = getExtendedKeyUsage();
            //} catch (IOException e) {
                //super.dumpValue(sb);
                //return;
            //}
        //}
        //sb.append('[');
        //for (Iterator<?> it = keys.iterator(); it.hasNext();) {
            //sb.append(" \"").append(it.next()).append('"');
            //if (it.hasNext()) {
                //sb.append(',');
            //}
        //}
        //sb.append(" ]\n");
    }

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
}

