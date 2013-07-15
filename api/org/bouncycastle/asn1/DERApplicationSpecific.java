package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERApplicationSpecific extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.878 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.879 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.879 -0400", hash_original_field = "48537581B9950DEA59270C7E6A7FC75B", hash_generated_field = "10C1AE9E7AE48DBBFF95B14599A41386")

    private byte[] octets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.879 -0400", hash_original_method = "F358753DF763D75E1752044681BF3AC8", hash_generated_method = "D55324640DF381B2652431FE7BF7FFCD")
      DERApplicationSpecific(
        boolean isConstructed,
        int     tag,
        byte[]  octets) {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.octets = octets;
        // ---------- Original Method ----------
        //this.isConstructed = isConstructed;
        //this.tag = tag;
        //this.octets = octets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.880 -0400", hash_original_method = "4CF4A9576D642E83593F5E4C6AD75E4B", hash_generated_method = "31E5815D9C59513C19B7E7F2E7F88BD4")
    public  DERApplicationSpecific(
        int    tag,
        byte[] octets) {
        this(false, tag, octets);
        addTaint(octets[0]);
        addTaint(tag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.880 -0400", hash_original_method = "6CD0D23957E9B404C2F9698016AC75E4", hash_generated_method = "9B40582C04B51417E3F8C2BD345D2E30")
    public  DERApplicationSpecific(
        int                  tag, 
        DEREncodable         object) throws IOException {
        this(true, tag, object);
        addTaint(object.getTaint());
        addTaint(tag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.881 -0400", hash_original_method = "C83BD1B204CE742C0B031F1EFE6A4686", hash_generated_method = "EDD48D5C6315731F611A3808207B50B6")
    public  DERApplicationSpecific(
        boolean      explicit,
        int          tag,
        DEREncodable object) throws IOException {
        addTaint(object.getTaint());
        byte[] data = object.getDERObject().getDEREncoded();
        this.isConstructed = explicit;
        this.tag = tag;
    if(explicit)        
        {
            this.octets = data;
        } //End block
        else
        {
            int lenBytes = getLengthOfLength(data);
            byte[] tmp = new byte[data.length - lenBytes];
            System.arraycopy(data, lenBytes, tmp, 0, tmp.length);
            this.octets = tmp;
        } //End block
        // ---------- Original Method ----------
        //byte[] data = object.getDERObject().getDEREncoded();
        //this.isConstructed = explicit;
        //this.tag = tag;
        //if (explicit)
        //{
            //this.octets = data;
        //}
        //else
        //{
            //int lenBytes = getLengthOfLength(data);
            //byte[] tmp = new byte[data.length - lenBytes];
            //System.arraycopy(data, lenBytes, tmp, 0, tmp.length);
            //this.octets = tmp;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.882 -0400", hash_original_method = "94BAC854E28F90CA4EA0E8959FF01D3B", hash_generated_method = "FF892D99A158EF6A4550DABFF09748C3")
    public  DERApplicationSpecific(int tagNo, ASN1EncodableVector vec) {
        addTaint(vec.getTaint());
        this.tag = tagNo;
        this.isConstructed = true;
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
for(int i = 0;i != vec.size();i++)
        {
            try 
            {
                bOut.write(((ASN1Encodable)vec.get(i)).getEncoded());
            } //End block
            catch (IOException e)
            {
                ASN1ParsingException var4DE0D7A9F34842E052907F36C623DFB9_934105515 = new ASN1ParsingException("malformed object: " + e, e);
                var4DE0D7A9F34842E052907F36C623DFB9_934105515.addTaint(taint);
                throw var4DE0D7A9F34842E052907F36C623DFB9_934105515;
            } //End block
        } //End block
        this.octets = bOut.toByteArray();
        // ---------- Original Method ----------
        //this.tag = tagNo;
        //this.isConstructed = true;
        //ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        //for (int i = 0; i != vec.size(); i++)
        //{
            //try
            //{
                //bOut.write(((ASN1Encodable)vec.get(i)).getEncoded());
            //}
            //catch (IOException e)
            //{
                //throw new ASN1ParsingException("malformed object: " + e, e);
            //}
        //}
        //this.octets = bOut.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.883 -0400", hash_original_method = "61F856A6747C3DB85AB853DB99D560A7", hash_generated_method = "356DFD74C405A7C0AE276191A87A7898")
    private int getLengthOfLength(byte[] data) {
        addTaint(data[0]);
        int count = 2;
        while
((data[count - 1] & 0x80) != 0)        
        {
            count++;
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_1643677378 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494515253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494515253;
        // ---------- Original Method ----------
        //int count = 2;
        //while((data[count - 1] & 0x80) != 0)
        //{
            //count++;
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.883 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "C13329593B1B30279C06173ABBB29F3B")
    public boolean isConstructed() {
        boolean var81C86C56F2FC47B77A343996A0249448_2082323601 = (isConstructed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394042716 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394042716;
        // ---------- Original Method ----------
        //return isConstructed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.883 -0400", hash_original_method = "1D312847F188B0EEDCC8340737DDA9DA", hash_generated_method = "3D223049867547EC328041ED1264E571")
    public byte[] getContents() {
        byte[] var48537581B9950DEA59270C7E6A7FC75B_1918899552 = (octets);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1332450296 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1332450296;
        // ---------- Original Method ----------
        //return octets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.883 -0400", hash_original_method = "8070D9796AF3020498C0A81362041E60", hash_generated_method = "D2E9DD6EE2CD9DB774F376AED9A9EC0B")
    public int getApplicationTag() {
        int varE4D23E841D8E8804190027BCE3180FA5_1290578916 = (tag);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890222267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890222267;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.884 -0400", hash_original_method = "E9ECF57BA1A3D60C7D24C2D1B840176E", hash_generated_method = "CE846661FB0099815F39A87F4107D32E")
    public DERObject getObject() throws IOException {
DERObject var7168AACCAD0A68A7098006CD429531D2_1197997594 =         new ASN1InputStream(getContents()).readObject();
        var7168AACCAD0A68A7098006CD429531D2_1197997594.addTaint(taint);
        return var7168AACCAD0A68A7098006CD429531D2_1197997594;
        // ---------- Original Method ----------
        //return new ASN1InputStream(getContents()).readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.884 -0400", hash_original_method = "8D6BE9D0FACD64D64BE0372060383689", hash_generated_method = "C7D9FB1E32C639FC363024C8B13DAD64")
    public DERObject getObject(int derTagNo) throws IOException {
        addTaint(derTagNo);
    if(derTagNo >= 0x1f)        
        {
            IOException var92FFAF43E64F20E86BED0C630E5E97C8_48888391 = new IOException("unsupported tag number");
            var92FFAF43E64F20E86BED0C630E5E97C8_48888391.addTaint(taint);
            throw var92FFAF43E64F20E86BED0C630E5E97C8_48888391;
        } //End block
        byte[] orig = this.getEncoded();
        byte[] tmp = replaceTagNumber(derTagNo, orig);
    if((orig[0] & DERTags.CONSTRUCTED) != 0)        
        {
            tmp[0] |= DERTags.CONSTRUCTED;
        } //End block
DERObject var6973B48E7C58DF1E1DC0711650513E93_1677426236 =         new ASN1InputStream(tmp).readObject();
        var6973B48E7C58DF1E1DC0711650513E93_1677426236.addTaint(taint);
        return var6973B48E7C58DF1E1DC0711650513E93_1677426236;
        // ---------- Original Method ----------
        //if (derTagNo >= 0x1f)
        //{
            //throw new IOException("unsupported tag number");
        //}
        //byte[] orig = this.getEncoded();
        //byte[] tmp = replaceTagNumber(derTagNo, orig);
        //if ((orig[0] & DERTags.CONSTRUCTED) != 0)
        //{
            //tmp[0] |= DERTags.CONSTRUCTED;
        //}
        //return new ASN1InputStream(tmp).readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.885 -0400", hash_original_method = "E93A5605AEDD2C30A620D419DCC3B82A", hash_generated_method = "844DC1361445FD7735AA01CE5CDD994A")
     void encode(DEROutputStream out) throws IOException {
        addTaint(out.getTaint());
        int classBits = DERTags.APPLICATION;
    if(isConstructed)        
        {
            classBits |= DERTags.CONSTRUCTED;
        } //End block
        out.writeEncoded(classBits, tag, octets);
        // ---------- Original Method ----------
        //int classBits = DERTags.APPLICATION;
        //if (isConstructed)
        //{
            //classBits |= DERTags.CONSTRUCTED; 
        //}
        //out.writeEncoded(classBits, tag, octets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.885 -0400", hash_original_method = "2058BDE8789C9C651125E90A6C9106EF", hash_generated_method = "B6B17B2491AA62881034A2685171D39C")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERApplicationSpecific))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1645106506 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766602385 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_766602385;
        } //End block
        DERApplicationSpecific other = (DERApplicationSpecific)o;
        boolean var6DD5FAB5AE37FFA3F7833728A9A6B96A_1554025159 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(octets, other.octets));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851210662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_851210662;
        // ---------- Original Method ----------
        //if (!(o instanceof DERApplicationSpecific))
        //{
            //return false;
        //}
        //DERApplicationSpecific other = (DERApplicationSpecific)o;
        //return isConstructed == other.isConstructed
            //&& tag == other.tag
            //&& Arrays.areEqual(octets, other.octets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.886 -0400", hash_original_method = "CE8CF2E74F2DF6C65F2B809B8ECF710B", hash_generated_method = "FA5A0CE94ED078E5D23C3DB6D35E1C69")
    public int hashCode() {
        int var75F6921E5BCCAA342C07FD19F33F5B75_569129203 = ((isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781908978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1781908978;
        // ---------- Original Method ----------
        //return (isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.887 -0400", hash_original_method = "DBC165FE2DD4A16BCAF214B19B914EC2", hash_generated_method = "111D0F469133BA9E0ABCAB7407BF8A41")
    private byte[] replaceTagNumber(int newTag, byte[] input) throws IOException {
        addTaint(input[0]);
        addTaint(newTag);
        int tagNo = input[0] & 0x1f;
        int index = 1;
    if(tagNo == 0x1f)        
        {
            tagNo = 0;
            int b = input[index++] & 0xff;
    if((b & 0x7f) == 0)            
            {
                ASN1ParsingException var6C2E65F6B8B36D8820E2B349F898A601_249396263 = new ASN1ParsingException("corrupted stream - invalid high tag number found");
                var6C2E65F6B8B36D8820E2B349F898A601_249396263.addTaint(taint);
                throw var6C2E65F6B8B36D8820E2B349F898A601_249396263;
            } //End block
            while
((b >= 0) && ((b & 0x80) != 0))            
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = input[index++] & 0xff;
            } //End block
            tagNo |= (b & 0x7f);
        } //End block
        byte[] tmp = new byte[input.length - index + 1];
        System.arraycopy(input, index, tmp, 1, tmp.length - 1);
        tmp[0] = (byte)newTag;
        byte[] varFA816EDB83E95BF0C8DA580BDFD491EF_250129865 = (tmp);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1469866557 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1469866557;
        // ---------- Original Method ----------
        //int tagNo = input[0] & 0x1f;
        //int index = 1;
        //if (tagNo == 0x1f)
        //{
            //tagNo = 0;
            //int b = input[index++] & 0xff;
            //if ((b & 0x7f) == 0) 
            //{
                //throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            //}
            //while ((b >= 0) && ((b & 0x80) != 0))
            //{
                //tagNo |= (b & 0x7f);
                //tagNo <<= 7;
                //b = input[index++] & 0xff;
            //}
            //tagNo |= (b & 0x7f);
        //}
        //byte[] tmp = new byte[input.length - index + 1];
        //System.arraycopy(input, index, tmp, 1, tmp.length - 1);
        //tmp[0] = (byte)newTag;
        //return tmp;
    }

    
}

