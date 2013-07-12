package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;

public final class ExtendedKeyUsage extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.871 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "B63F3A923567277A38E2C25A71F126D8")

    private List<String> keys;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.871 -0400", hash_original_method = "52F4822F456F1C9559212854B99C1B20", hash_generated_method = "0DAABCEEB9168D9F7C9191F2C42E9954")
    public  ExtendedKeyUsage(byte[] encoding) {
        super(encoding);
        addTaint(encoding[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.871 -0400", hash_original_method = "EC4A736D051BE2AF82868DFFF88ACC79", hash_generated_method = "F6B4DE9D4F2046EB17641A4FF6B0DE11")
    public List<String> getExtendedKeyUsage() throws IOException {
    if(keys == null)        
        {
            keys = (List<String>) ASN1.decode(getEncoded());
        } 
List<String> varB14736CAAF1705D7B3CD66C22C8D3EBC_1931646150 =         keys;
        varB14736CAAF1705D7B3CD66C22C8D3EBC_1931646150.addTaint(taint);
        return varB14736CAAF1705D7B3CD66C22C8D3EBC_1931646150;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.872 -0400", hash_original_method = "63AFE39A4816AB8A1F7656BFDDDB680C", hash_generated_method = "47FFB0930AD3A116970797A19FEBF648")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(keys);
        } 
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1949131910 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2065786954 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2065786954;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.873 -0400", hash_original_method = "4F87579E7E9CA4B1B17B20CD410B3E10", hash_generated_method = "D89135C7521E619869D7B4974467F11E")
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
            } 
            catch (IOException e)
            {
                super.dumpValue(sb);
                return;
            } 
        } 
        sb.append('[');
for(Iterator<?> it = keys.iterator();it.hasNext();)
        {
            sb.append(" \"").append(it.next()).append('"');
    if(it.hasNext())            
            {
                sb.append(',');
            } 
        } 
        sb.append(" ]\n");
        
        
        
            
                
            
                
                
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.873 -0400", hash_original_field = "1C1534A2AA96342A497C51FF8E5360A5", hash_generated_field = "BF598BD805210074FAC5B7D06116F7DE")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(new ASN1Oid() {
        public Object getDecodedObject(BerInputStream in) throws IOException {
            int[] oid = (int[]) super.getDecodedObject(in);
            return ObjectIdentifier.toString(oid);
        }
    });
}

