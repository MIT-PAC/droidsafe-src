package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERApplicationSpecific extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.991 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.992 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.992 -0400", hash_original_field = "48537581B9950DEA59270C7E6A7FC75B", hash_generated_field = "10C1AE9E7AE48DBBFF95B14599A41386")

    private byte[] octets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.993 -0400", hash_original_method = "F358753DF763D75E1752044681BF3AC8", hash_generated_method = "D55324640DF381B2652431FE7BF7FFCD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.993 -0400", hash_original_method = "4CF4A9576D642E83593F5E4C6AD75E4B", hash_generated_method = "398625EEBC3050D64E6C044BCD916368")
    public  DERApplicationSpecific(
        int    tag,
        byte[] octets) {
        this(false, tag, octets);
        addTaint(tag);
        addTaint(octets[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.993 -0400", hash_original_method = "6CD0D23957E9B404C2F9698016AC75E4", hash_generated_method = "F95ABA00D76006C6A7CD93E642B4A606")
    public  DERApplicationSpecific(
        int                  tag, 
        DEREncodable         object) throws IOException {
        this(true, tag, object);
        addTaint(tag);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.008 -0400", hash_original_method = "C83BD1B204CE742C0B031F1EFE6A4686", hash_generated_method = "8EC07A8A45810312955B8781814EC6C5")
    public  DERApplicationSpecific(
        boolean      explicit,
        int          tag,
        DEREncodable object) throws IOException {
        byte[] data;
        data = object.getDERObject().getDEREncoded();
        this.isConstructed = explicit;
        this.tag = tag;
        {
            this.octets = data;
        } //End block
        {
            int lenBytes;
            lenBytes = getLengthOfLength(data);
            byte[] tmp;
            tmp = new byte[data.length - lenBytes];
            System.arraycopy(data, lenBytes, tmp, 0, tmp.length);
            this.octets = tmp;
        } //End block
        addTaint(object.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.009 -0400", hash_original_method = "94BAC854E28F90CA4EA0E8959FF01D3B", hash_generated_method = "3985A175FC477E0BA26374E79EE2BC70")
    public  DERApplicationSpecific(int tagNo, ASN1EncodableVector vec) {
        this.tag = tagNo;
        this.isConstructed = true;
        ByteArrayOutputStream bOut;
        bOut = new ByteArrayOutputStream();
        {
            int i;
            i = 0;
            boolean varD4B755BB3F48B21BD56EC48340338FB2_725630369 = (i != vec.size());
            {
                try 
                {
                    bOut.write(((ASN1Encodable)vec.get(i)).getEncoded());
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("malformed object: " + e, e);
                } //End block
            } //End block
        } //End collapsed parenthetic
        this.octets = bOut.toByteArray();
        addTaint(vec.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.009 -0400", hash_original_method = "61F856A6747C3DB85AB853DB99D560A7", hash_generated_method = "53379DF921C6B7A8E3B0FC46A32A1543")
    private int getLengthOfLength(byte[] data) {
        int count;
        count = 2;
        addTaint(data[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132880370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1132880370;
        // ---------- Original Method ----------
        //int count = 2;
        //while((data[count - 1] & 0x80) != 0)
        //{
            //count++;
        //}
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.010 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "91DE9AF4B5705D63A7CF5B6C951D1985")
    public boolean isConstructed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274708930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274708930;
        // ---------- Original Method ----------
        //return isConstructed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.010 -0400", hash_original_method = "1D312847F188B0EEDCC8340737DDA9DA", hash_generated_method = "A155E817F9CEB94183E0407997EC150C")
    public byte[] getContents() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2096012361 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2096012361;
        // ---------- Original Method ----------
        //return octets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.010 -0400", hash_original_method = "8070D9796AF3020498C0A81362041E60", hash_generated_method = "A416172F9D8F17E19706149167307C44")
    public int getApplicationTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336015540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1336015540;
        // ---------- Original Method ----------
        //return tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.011 -0400", hash_original_method = "E9ECF57BA1A3D60C7D24C2D1B840176E", hash_generated_method = "ACEF806F9713AC568479A8DDFA0E94D6")
    public DERObject getObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1609447042 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1609447042 = new ASN1InputStream(getContents()).readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1609447042.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1609447042;
        // ---------- Original Method ----------
        //return new ASN1InputStream(getContents()).readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.024 -0400", hash_original_method = "8D6BE9D0FACD64D64BE0372060383689", hash_generated_method = "D765AF6E201B490EF6F3F389629523C3")
    public DERObject getObject(int derTagNo) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_573075516 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unsupported tag number");
        } //End block
        byte[] orig;
        orig = this.getEncoded();
        byte[] tmp;
        tmp = replaceTagNumber(derTagNo, orig);
        {
            tmp[0] |= DERTags.CONSTRUCTED;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_573075516 = new ASN1InputStream(tmp).readObject();
        addTaint(derTagNo);
        varB4EAC82CA7396A68D541C85D26508E83_573075516.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573075516;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.024 -0400", hash_original_method = "E93A5605AEDD2C30A620D419DCC3B82A", hash_generated_method = "85B998346FDEED319D35A90EF43A1238")
     void encode(DEROutputStream out) throws IOException {
        int classBits;
        classBits = DERTags.APPLICATION;
        {
            classBits |= DERTags.CONSTRUCTED;
        } //End block
        out.writeEncoded(classBits, tag, octets);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //int classBits = DERTags.APPLICATION;
        //if (isConstructed)
        //{
            //classBits |= DERTags.CONSTRUCTED; 
        //}
        //out.writeEncoded(classBits, tag, octets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.025 -0400", hash_original_method = "2058BDE8789C9C651125E90A6C9106EF", hash_generated_method = "32BAC8F0D7AF85BA0EB222FD7338BC53")
     boolean asn1Equals(
        DERObject o) {
        DERApplicationSpecific other;
        other = (DERApplicationSpecific)o;
        boolean var9FA838EB46B0FFADB21702A81EC9477C_848504883 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(octets, other.octets));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808556204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_808556204;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.034 -0400", hash_original_method = "CE8CF2E74F2DF6C65F2B809B8ECF710B", hash_generated_method = "DBA315FE98CF22AFEB3825A8CB73C56B")
    public int hashCode() {
        int varE64E1A0AB0154FE686008799DA931C7F_978086958 = ((isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342867497 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_342867497;
        // ---------- Original Method ----------
        //return (isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.049 -0400", hash_original_method = "DBC165FE2DD4A16BCAF214B19B914EC2", hash_generated_method = "8E3D22AC3DE34424BD9750A91AD48E51")
    private byte[] replaceTagNumber(int newTag, byte[] input) throws IOException {
        int tagNo;
        tagNo = input[0] & 0x1f;
        int index;
        index = 1;
        {
            tagNo = 0;
            int b;
            b = input[index++] & 0xff;
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            } //End block
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = input[index++] & 0xff;
            } //End block
            tagNo |= (b & 0x7f);
        } //End block
        byte[] tmp;
        tmp = new byte[input.length - index + 1];
        System.arraycopy(input, index, tmp, 1, tmp.length - 1);
        tmp[0] = (byte)newTag;
        addTaint(newTag);
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_347764186 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_347764186;
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

