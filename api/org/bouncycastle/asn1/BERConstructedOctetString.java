package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;






public class BERConstructedOctetString extends DEROctetString {

    /**
     * convert a vector of octet strings into a single byte string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.221 -0500", hash_original_method = "4664D1B75E47F4959701A1C01649EB42", hash_generated_method = "742B75D7CF6C93094988DF6E137F66E2")
    
static private byte[] toBytes(
        Vector  octs)
    {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.247 -0500", hash_original_method = "97CC42610E3B4CC19FC8B98F6BF4FA86", hash_generated_method = "1034A4471D1DB825017C54606D3A04E6")
    
public static BERConstructedOctetString fromSequence(ASN1Sequence seq)
    {
        Vector      v = new Vector();
        Enumeration e = seq.getObjects();

        while (e.hasMoreElements())
        {
            v.addElement(e.nextElement());
        }

        return new BERConstructedOctetString(v);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.219 -0500", hash_original_field = "ED3A10016B0D2340E52BBB0634E8DD9F", hash_generated_field = "A558926B6159DC43FD82B354BFE9D883")

    private static final int MAX_LENGTH = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.224 -0500", hash_original_field = "5DA4E18E3EB8D14327A16281BB82EBB3", hash_generated_field = "D188A20B051C25B638BF89B386738B27")


    private Vector  octs;

    /**
     * @param string the octets making up the octet string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.226 -0500", hash_original_method = "96A22222F24F7723734E21B97561B17C", hash_generated_method = "F48FAA735D14660586C009BE487C9604")
    
public BERConstructedOctetString(
        byte[]  string)
    {
        super(string);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.229 -0500", hash_original_method = "B23653AD9C636FB498F558654B22BD33", hash_generated_method = "9D6ADC2356E68F3DEF4F99CD768048C0")
    
public BERConstructedOctetString(
        Vector  octs)
    {
        super(toBytes(octs));

        this.octs = octs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.232 -0500", hash_original_method = "CE4C07C6769EB3D2F9B2CD6F7659BC47", hash_generated_method = "6E83EB39467485B89C34D58C1EC34667")
    
public BERConstructedOctetString(
        DERObject  obj)
    {
        super(obj);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.235 -0500", hash_original_method = "F960A8D6AB2284319611CDCB2C711139", hash_generated_method = "EE8B736B4410D150BFC4C54E67862943")
    
public BERConstructedOctetString(
        DEREncodable  obj)
    {
        super(obj.getDERObject());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.237 -0500", hash_original_method = "C5326C1D0359BDCEF8241B3A70DD591D", hash_generated_method = "94D2EF08EA4C68EF88007C34B3811270")
    
public byte[] getOctets()
    {
        return string;
    }

    /**
     * return the DER octets that make up this string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.239 -0500", hash_original_method = "38D9AF5AE7D2EC02C67E2F99E80896DD", hash_generated_method = "104D5AD3EA6882071BD9EFE033D48B55")
    
public Enumeration getObjects()
    {
        if (octs == null)
        {
            return generateOcts().elements();
        }

        return octs.elements();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.241 -0500", hash_original_method = "03E7802E2319FF252715B6886182CABF", hash_generated_method = "792D08AC6A43E9804EEE0BCE0AF8FF5D")
    
private Vector generateOcts() 
    { 
        Vector vec = new Vector(); 
        for (int i = 0; i < string.length; i += MAX_LENGTH) 
        { 
            int end; 

            if (i + MAX_LENGTH > string.length) 
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
        
         return vec; 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.244 -0500", hash_original_method = "D3D7CE50527B3D09D53342883B1EBD33", hash_generated_method = "F90FE6D021EA51EE61FD714A879B9874")
    
public void encode(
        DEROutputStream out)
        throws IOException
    {
        if (out instanceof ASN1OutputStream || out instanceof BEROutputStream)
        {
            out.write(CONSTRUCTED | OCTET_STRING);

            out.write(0x80);

            //
            // write out the octet array
            //
            Enumeration e = getObjects();
            while (e.hasMoreElements())
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
}

