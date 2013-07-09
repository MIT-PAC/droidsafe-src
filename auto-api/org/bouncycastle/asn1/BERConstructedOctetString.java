package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString extends DEROctetString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.114 -0400", hash_original_field = "CFDB301C608FC54C7F65954F8C926AC1", hash_generated_field = "D188A20B051C25B638BF89B386738B27")

    private Vector octs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.114 -0400", hash_original_method = "96A22222F24F7723734E21B97561B17C", hash_generated_method = "C1D44138FF3FED3652C6EED803F0D733")
    public  BERConstructedOctetString(
        byte[]  string) {
        super(string);
        addTaint(string[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.114 -0400", hash_original_method = "B23653AD9C636FB498F558654B22BD33", hash_generated_method = "A7C7C4FD590A0745592E6B103FAC9518")
    public  BERConstructedOctetString(
        Vector  octs) {
        super(toBytes(octs));
        this.octs = octs;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.115 -0400", hash_original_method = "CE4C07C6769EB3D2F9B2CD6F7659BC47", hash_generated_method = "60D3AEAE16006787148F9FD2B4AC9D1E")
    public  BERConstructedOctetString(
        DERObject  obj) {
        super(obj);
        addTaint(obj.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.115 -0400", hash_original_method = "F960A8D6AB2284319611CDCB2C711139", hash_generated_method = "4A649F72AF77A12E8DEDF47A15E9BB7E")
    public  BERConstructedOctetString(
        DEREncodable  obj) {
        super(obj.getDERObject());
        addTaint(obj.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.115 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "50849FF11DF56C9CBD83C0625878C089")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_240017991 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_240017991;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.116 -0400", hash_original_method = "38D9AF5AE7D2EC02C67E2F99E80896DD", hash_generated_method = "91AD826A2330594F2D3DFC0DA388E5A8")
    public Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1307889533 = null; 
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1672325030 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1307889533 = generateOcts().elements();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1672325030 = octs.elements();
        Enumeration varA7E53CE21691AB073D9660D615818899_694330839; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_694330839 = varB4EAC82CA7396A68D541C85D26508E83_1307889533;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_694330839 = varB4EAC82CA7396A68D541C85D26508E83_1672325030;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_694330839.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_694330839;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.116 -0400", hash_original_method = "03E7802E2319FF252715B6886182CABF", hash_generated_method = "A9365E7E2B4EBA67C37DDC21A6B78275")
    private Vector generateOcts() {
        Vector varB4EAC82CA7396A68D541C85D26508E83_1165261329 = null; 
        Vector vec = new Vector();
        {
            int i = 0;
            i += MAX_LENGTH;
            {
                int end;
                {
                    end = string.length;
                } 
                {
                    end = i + MAX_LENGTH;
                } 
                byte[] nStr = new byte[end - i];
                System.arraycopy(string, i, nStr, 0, nStr.length);
                vec.addElement(new DEROctetString(nStr));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1165261329 = vec;
        varB4EAC82CA7396A68D541C85D26508E83_1165261329.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1165261329;
        
        
        
        
            
            
            
                
            
            
            
                
            
            
            
            
         
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.117 -0400", hash_original_method = "D3D7CE50527B3D09D53342883B1EBD33", hash_generated_method = "2DAC25052E2E5914DFA45155F6A14440")
    public void encode(
        DEROutputStream out) throws IOException {
        {
            out.write(CONSTRUCTED | OCTET_STRING);
            out.write(0x80);
            Enumeration e = getObjects();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_696543878 = (e.hasMoreElements());
                {
                    out.writeObject(e.nextElement());
                } 
            } 
            out.write(0x00);
            out.write(0x00);
        } 
        {
            super.encode(out);
        } 
        addTaint(out.getTaint());
        
        
        
            
            
            
            
            
                
            
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    public static BERConstructedOctetString fromSequence(ASN1Sequence seq) {
        Vector      v = new Vector();
        Enumeration e = seq.getObjects();
        while (e.hasMoreElements())
        {
            v.addElement(e.nextElement());
        }
        return new BERConstructedOctetString(v);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.118 -0400", hash_original_field = "8AC0E9948A4FB39CBF52BB6BAAB9680A", hash_generated_field = "A558926B6159DC43FD82B354BFE9D883")

    private static final int MAX_LENGTH = 1000;
}

