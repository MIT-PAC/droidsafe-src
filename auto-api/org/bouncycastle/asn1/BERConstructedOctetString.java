package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class BERConstructedOctetString extends DEROctetString {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.788 -0400", hash_original_field = "CFDB301C608FC54C7F65954F8C926AC1", hash_generated_field = "D188A20B051C25B638BF89B386738B27")

    private Vector octs;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.796 -0400", hash_original_method = "96A22222F24F7723734E21B97561B17C", hash_generated_method = "C1D44138FF3FED3652C6EED803F0D733")
    public  BERConstructedOctetString(
        byte[]  string) {
        super(string);
        addTaint(string[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.799 -0400", hash_original_method = "B23653AD9C636FB498F558654B22BD33", hash_generated_method = "A7C7C4FD590A0745592E6B103FAC9518")
    public  BERConstructedOctetString(
        Vector  octs) {
        super(toBytes(octs));
        this.octs = octs;
        // ---------- Original Method ----------
        //this.octs = octs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.799 -0400", hash_original_method = "CE4C07C6769EB3D2F9B2CD6F7659BC47", hash_generated_method = "60D3AEAE16006787148F9FD2B4AC9D1E")
    public  BERConstructedOctetString(
        DERObject  obj) {
        super(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.799 -0400", hash_original_method = "F960A8D6AB2284319611CDCB2C711139", hash_generated_method = "4A649F72AF77A12E8DEDF47A15E9BB7E")
    public  BERConstructedOctetString(
        DEREncodable  obj) {
        super(obj.getDERObject());
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.800 -0400", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "06B90BCB585FC3CD6AF3E843D16E5846")
    public byte[] getOctets() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2017989414 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2017989414;
        // ---------- Original Method ----------
        //return string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.812 -0400", hash_original_method = "38D9AF5AE7D2EC02C67E2F99E80896DD", hash_generated_method = "E6745596A2D7C52517A8F6FD7E9A3298")
    public Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1735313816 = null; //Variable for return #1
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_2087718657 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1735313816 = generateOcts().elements();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2087718657 = octs.elements();
        Enumeration varA7E53CE21691AB073D9660D615818899_1494519527; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1494519527 = varB4EAC82CA7396A68D541C85D26508E83_1735313816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1494519527 = varB4EAC82CA7396A68D541C85D26508E83_2087718657;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1494519527.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1494519527;
        // ---------- Original Method ----------
        //if (octs == null)
        //{
            //return generateOcts().elements();
        //}
        //return octs.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.820 -0400", hash_original_method = "03E7802E2319FF252715B6886182CABF", hash_generated_method = "77BE5CCE390736D715802754F647EEF1")
    private Vector generateOcts() {
        Vector varB4EAC82CA7396A68D541C85D26508E83_2057530760 = null; //Variable for return #1
        Vector vec;
        vec = new Vector();
        {
            int i;
            i = 0;
            i += MAX_LENGTH;
            {
                int end;
                {
                    end = string.length;
                } //End block
                {
                    end = i + MAX_LENGTH;
                } //End block
                byte[] nStr;
                nStr = new byte[end - i];
                System.arraycopy(string, i, nStr, 0, nStr.length);
                vec.addElement(new DEROctetString(nStr));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2057530760 = vec;
        varB4EAC82CA7396A68D541C85D26508E83_2057530760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2057530760;
        // ---------- Original Method ----------
        //Vector vec = new Vector();
        //for (int i = 0; i < string.length; i += MAX_LENGTH) 
        //{ 
            //int end; 
            //if (i + MAX_LENGTH > string.length) 
            //{ 
                //end = string.length; 
            //} 
            //else 
            //{ 
                //end = i + MAX_LENGTH; 
            //} 
            //byte[] nStr = new byte[end - i]; 
            //System.arraycopy(string, i, nStr, 0, nStr.length); 
            //vec.addElement(new DEROctetString(nStr)); 
         //}
        //return vec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.820 -0400", hash_original_method = "D3D7CE50527B3D09D53342883B1EBD33", hash_generated_method = "7B78ED6BEC4174D2DB8C212EB8485D2C")
    public void encode(
        DEROutputStream out) throws IOException {
        {
            out.write(CONSTRUCTED | OCTET_STRING);
            out.write(0x80);
            Enumeration e;
            e = getObjects();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_1852488973 = (e.hasMoreElements());
                {
                    out.writeObject(e.nextElement());
                } //End block
            } //End collapsed parenthetic
            out.write(0x00);
            out.write(0x00);
        } //End block
        {
            super.encode(out);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        //{
            //out.write(CONSTRUCTED | OCTET_STRING);
            //out.write(0x80);
            //Enumeration e = getObjects();
            //while (e.hasMoreElements())
            //{
                //out.writeObject(e.nextElement());
            //}
            //out.write(0x00);
            //out.write(0x00);
        //}
        //else
        //{
            //super.encode(out);
        //}
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.821 -0400", hash_original_field = "8AC0E9948A4FB39CBF52BB6BAAB9680A", hash_generated_field = "DEC490DCF262DDAB3CCD984A9F03299F")

    private static int MAX_LENGTH = 1000;
}

