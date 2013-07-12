package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString extends DEROctetString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.792 -0400", hash_original_field = "CFDB301C608FC54C7F65954F8C926AC1", hash_generated_field = "D188A20B051C25B638BF89B386738B27")

    private Vector octs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.793 -0400", hash_original_method = "96A22222F24F7723734E21B97561B17C", hash_generated_method = "C1D44138FF3FED3652C6EED803F0D733")
    public  BERConstructedOctetString(
        byte[]  string) {
        super(string);
        addTaint(string[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.793 -0400", hash_original_method = "B23653AD9C636FB498F558654B22BD33", hash_generated_method = "A7C7C4FD590A0745592E6B103FAC9518")
    public  BERConstructedOctetString(
        Vector  octs) {
        super(toBytes(octs));
        this.octs = octs;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.793 -0400", hash_original_method = "CE4C07C6769EB3D2F9B2CD6F7659BC47", hash_generated_method = "60D3AEAE16006787148F9FD2B4AC9D1E")
    public  BERConstructedOctetString(
        DERObject  obj) {
        super(obj);
        addTaint(obj.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.794 -0400", hash_original_method = "F960A8D6AB2284319611CDCB2C711139", hash_generated_method = "4A649F72AF77A12E8DEDF47A15E9BB7E")
    public  BERConstructedOctetString(
        DEREncodable  obj) {
        super(obj.getDERObject());
        addTaint(obj.getTaint());
        
    }

    
        @DSModeled(DSC.SPEC)
    static private byte[] toBytes(
        Vector  octs) {
        ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        for (int i = 0; i != octs.size(); i++)
        {
            try
            {
                DEROctetString  o = (DEROctetString)octs.elementAt(i);
                bOut.write(o.getOctets());
            }
            catch (ClassCastException e)
            {
                throw new IllegalArgumentException(octs.elementAt(i).getClass().getName() + " found in input should only contain DEROctetString");
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException("exception converting octets " + e.toString());
            }
        }
        return bOut.toByteArray();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.794 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "B8E98218F33A31E8FF93F5AB4F63D52C")
    public byte[] getOctets() {
        byte[] varB45CFFE084DD3D20D928BEE85E7B0F21_1218440339 = (string);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1872839468 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1872839468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.795 -0400", hash_original_method = "38D9AF5AE7D2EC02C67E2F99E80896DD", hash_generated_method = "BE64342A04FE2395C61674D6DFA55A29")
    public Enumeration getObjects() {
    if(octs == null)        
        {
Enumeration varD907AA51D3F166881E0645B04A1A14D5_112204214 =             generateOcts().elements();
            varD907AA51D3F166881E0645B04A1A14D5_112204214.addTaint(taint);
            return varD907AA51D3F166881E0645B04A1A14D5_112204214;
        } 
Enumeration var1B9859BDE61F66EA282C2AFE1BCE9641_1901768494 =         octs.elements();
        var1B9859BDE61F66EA282C2AFE1BCE9641_1901768494.addTaint(taint);
        return var1B9859BDE61F66EA282C2AFE1BCE9641_1901768494;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.796 -0400", hash_original_method = "03E7802E2319FF252715B6886182CABF", hash_generated_method = "E24ABBE559FC533D285C13BFC917CAD9")
    private Vector generateOcts() {
        Vector vec = new Vector();
for(int i = 0;i < string.length;i += MAX_LENGTH)
        {
            int end;
    if(i + MAX_LENGTH > string.length)            
            {
                end = string.length;
            } 
            else
            {
                end = i + MAX_LENGTH;
            } 
            byte[] nStr = new byte[end - i];
            System.arraycopy(string, i, nStr, 0, nStr.length);
            vec.addElement(new DEROctetString(nStr));
        } 
Vector var9D8DE77A4073B06987457FB88C5516C3_1367949729 =         vec;
        var9D8DE77A4073B06987457FB88C5516C3_1367949729.addTaint(taint);
        return var9D8DE77A4073B06987457FB88C5516C3_1367949729;
        
        
        
        
            
            
            
                
            
            
            
                
            
            
            
            
         
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.796 -0400", hash_original_method = "D3D7CE50527B3D09D53342883B1EBD33", hash_generated_method = "C4AF688A4ED18762DC4FEA158EF07667")
    public void encode(
        DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
    if(out instanceof ASN1OutputStream || out instanceof BEROutputStream)        
        {
            out.write(CONSTRUCTED | OCTET_STRING);
            out.write(0x80);
            Enumeration e = getObjects();
            while
(e.hasMoreElements())            
            {
                out.writeObject(e.nextElement());
            } 
            out.write(0x00);
            out.write(0x00);
        } 
        else
        {
            super.encode(out);
        } 
        
        
        
            
            
            
            
            
                
            
            
            
        
        
        
            
        
    }

    
        public static BERConstructedOctetString fromSequence(ASN1Sequence seq) {
        Vector      v = new Vector();
        Enumeration e = seq.getObjects();
        while (e.hasMoreElements())
        {
            v.addElement(e.nextElement());
        }
        return new BERConstructedOctetString(v);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.797 -0400", hash_original_field = "8AC0E9948A4FB39CBF52BB6BAAB9680A", hash_generated_field = "A558926B6159DC43FD82B354BFE9D883")

    private static final int MAX_LENGTH = 1000;
}

