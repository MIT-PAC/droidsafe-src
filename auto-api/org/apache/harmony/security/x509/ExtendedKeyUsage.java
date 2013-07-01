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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.842 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "B63F3A923567277A38E2C25A71F126D8")

    private List<String> keys;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.842 -0400", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "0DAABCEEB9168D9F7C9191F2C42E9954")
    public  ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.842 -0400", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "EE4449DD4FA3F9E22EE2BC1DE5E08524")
    public List<String> getExtendedKeyUsage() throws IOException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_548368421 = null; //Variable for return #1
        {
            keys = (List<String>) ASN1.decode(getEncoded());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_548368421 = keys;
        varB4EAC82CA7396A68D541C85D26508E83_548368421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548368421;
        // ---------- Original Method ----------
        //if (keys == null) {
            //keys = (List<String>) ASN1.decode(getEncoded());
        //}
        //return keys;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.843 -0400", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "A280CCEAB2E07C99976E1A80BD99483D")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(keys);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1002681355 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1002681355;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keys);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.843 -0400", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "CA87616B48BD9C1D7390B5ECEA8FBC16")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
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
            Iterator<?> it = keys.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1336301141 = (it.hasNext());
            {
                sb.append(" \"").append(it.next()).append('"');
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1757589194 = (it.hasNext());
                    {
                        sb.append(',');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sb.append(" ]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.844 -0400", hash_original_field = "1C1534A2AA96342A497C51FF8E5360A5", hash_generated_field = "BF598BD805210074FAC5B7D06116F7DE")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
    /*
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    
    */
}

