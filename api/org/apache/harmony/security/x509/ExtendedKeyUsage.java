package org.apache.harmony.security.x509;

// Droidsafe Imports
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class ExtendedKeyUsage extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.097 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "B63F3A923567277A38E2C25A71F126D8")

    private List<String> keys;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.097 -0400", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "0DAABCEEB9168D9F7C9191F2C42E9954")
    public  ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.098 -0400", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "227979EA9673942B6D33484C08EE7779")
    public List<String> getExtendedKeyUsage() throws IOException {
        if(keys == null)        
        {
            keys = (List<String>) ASN1.decode(getEncoded());
        } //End block
List<String> varB14736CAAF1705D7B3CD66C22C8D3EBC_656235496 =         keys;
        varB14736CAAF1705D7B3CD66C22C8D3EBC_656235496.addTaint(taint);
        return varB14736CAAF1705D7B3CD66C22C8D3EBC_656235496;
        // ---------- Original Method ----------
        //if (keys == null) {
            //keys = (List<String>) ASN1.decode(getEncoded());
        //}
        //return keys;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.098 -0400", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "015B8AFF40B79DC6CE4429205E292AE8")
    @Override
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(keys);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1853455968 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1491102540 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1491102540;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(keys);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.099 -0400", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "D89135C7521E619869D7B4974467F11E")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Extended Key Usage: ");
        if(keys == null)        
        {
            try 
            {
                keys = getExtendedKeyUsage();
            } //End block
            catch (IOException e)
            {
                super.dumpValue(sb);
                return;
            } //End block
        } //End block
        sb.append('[');
for(Iterator<?> it = keys.iterator();it.hasNext();)
        {
            sb.append(" \"").append(it.next()).append('"');
            if(it.hasNext())            
            {
                sb.append(',');
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.100 -0400", hash_original_field = "1C1534A2AA96342A497C51FF8E5360A5", hash_generated_field = "BF598BD805210074FAC5B7D06116F7DE")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
}

