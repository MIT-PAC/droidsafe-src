package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DERApplicationSpecific extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.247 -0400", hash_original_field = "81C86C56F2FC47B77A343996A0249448", hash_generated_field = "8267FCF370BB52E90BE4145558A847E9")

    private boolean isConstructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.247 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.247 -0400", hash_original_field = "48537581B9950DEA59270C7E6A7FC75B", hash_generated_field = "10C1AE9E7AE48DBBFF95B14599A41386")

    private byte[] octets;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.248 -0400", hash_original_method = "F358753DF763D75E1752044681BF3AC8", hash_generated_method = "D55324640DF381B2652431FE7BF7FFCD")
      DERApplicationSpecific(
        boolean isConstructed,
        int     tag,
        byte[]  octets) {
        this.isConstructed = isConstructed;
        this.tag = tag;
        this.octets = octets;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.248 -0400", hash_original_method = "4CF4A9576D642E83593F5E4C6AD75E4B", hash_generated_method = "398625EEBC3050D64E6C044BCD916368")
    public  DERApplicationSpecific(
        int    tag,
        byte[] octets) {
        this(false, tag, octets);
        addTaint(tag);
        addTaint(octets[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.248 -0400", hash_original_method = "6CD0D23957E9B404C2F9698016AC75E4", hash_generated_method = "F95ABA00D76006C6A7CD93E642B4A606")
    public  DERApplicationSpecific(
        int                  tag, 
        DEREncodable         object) throws IOException {
        this(true, tag, object);
        addTaint(tag);
        addTaint(object.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.248 -0400", hash_original_method = "C83BD1B204CE742C0B031F1EFE6A4686", hash_generated_method = "0E009BB875CC8556974CA4C786688953")
    public  DERApplicationSpecific(
        boolean      explicit,
        int          tag,
        DEREncodable object) throws IOException {
        byte[] data = object.getDERObject().getDEREncoded();
        this.isConstructed = explicit;
        this.tag = tag;
        {
            this.octets = data;
        } 
        {
            int lenBytes = getLengthOfLength(data);
            byte[] tmp = new byte[data.length - lenBytes];
            System.arraycopy(data, lenBytes, tmp, 0, tmp.length);
            this.octets = tmp;
        } 
        addTaint(object.getTaint());
        
        
        
        
        
        
            
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.249 -0400", hash_original_method = "94BAC854E28F90CA4EA0E8959FF01D3B", hash_generated_method = "01A1E0AC686FBA1DBC8CBA623E4E0794")
    public  DERApplicationSpecific(int tagNo, ASN1EncodableVector vec) {
        this.tag = tagNo;
        this.isConstructed = true;
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        {
            int i = 0;
            boolean varD4B755BB3F48B21BD56EC48340338FB2_2017794942 = (i != vec.size());
            {
                try 
                {
                    bOut.write(((ASN1Encodable)vec.get(i)).getEncoded());
                } 
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("malformed object: " + e, e);
                } 
            } 
        } 
        this.octets = bOut.toByteArray();
        addTaint(vec.getTaint());
        
        
        
        
        
        
            
            
                
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.249 -0400", hash_original_method = "61F856A6747C3DB85AB853DB99D560A7", hash_generated_method = "E44B4376E506897A0B21E43957AEBDA6")
    private int getLengthOfLength(byte[] data) {
        int count = 2;
        addTaint(data[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445052635 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445052635;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.249 -0400", hash_original_method = "4AFA588B499059410429802033BA5ED0", hash_generated_method = "FCB9BBF983714717105D81094DA51FA4")
    public boolean isConstructed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485649454 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485649454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.250 -0400", hash_original_method = "1D312847F188B0EEDCC8340737DDA9DA", hash_generated_method = "9C8462F33821AE516A769A7E13EEB1CE")
    public byte[] getContents() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1050940010 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1050940010;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.250 -0400", hash_original_method = "8070D9796AF3020498C0A81362041E60", hash_generated_method = "8FE5AD8A47FEBD8525F6891340982664")
    public int getApplicationTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564550740 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564550740;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.250 -0400", hash_original_method = "E9ECF57BA1A3D60C7D24C2D1B840176E", hash_generated_method = "5F9B4F17A64450644238B933FCC3F940")
    public DERObject getObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_595228696 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_595228696 = new ASN1InputStream(getContents()).readObject();
        varB4EAC82CA7396A68D541C85D26508E83_595228696.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_595228696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.251 -0400", hash_original_method = "8D6BE9D0FACD64D64BE0372060383689", hash_generated_method = "75B6EF51EC98A0E564DA42A2CF619DB1")
    public DERObject getObject(int derTagNo) throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1540386789 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("unsupported tag number");
        } 
        byte[] orig = this.getEncoded();
        byte[] tmp = replaceTagNumber(derTagNo, orig);
        {
            tmp[0] |= DERTags.CONSTRUCTED;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1540386789 = new ASN1InputStream(tmp).readObject();
        addTaint(derTagNo);
        varB4EAC82CA7396A68D541C85D26508E83_1540386789.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1540386789;
        
        
        
            
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.251 -0400", hash_original_method = "E93A5605AEDD2C30A620D419DCC3B82A", hash_generated_method = "399B4018491B48BCC2FF6D40CAF60ED1")
     void encode(DEROutputStream out) throws IOException {
        int classBits = DERTags.APPLICATION;
        {
            classBits |= DERTags.CONSTRUCTED;
        } 
        out.writeEncoded(classBits, tag, octets);
        addTaint(out.getTaint());
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.252 -0400", hash_original_method = "2058BDE8789C9C651125E90A6C9106EF", hash_generated_method = "D77B82C1679BD50F209C43E783D5FEDE")
     boolean asn1Equals(
        DERObject o) {
        DERApplicationSpecific other = (DERApplicationSpecific)o;
        boolean var9FA838EB46B0FFADB21702A81EC9477C_1745709030 = (isConstructed == other.isConstructed
            && tag == other.tag
            && Arrays.areEqual(octets, other.octets));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120474125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120474125;
        
        
        
            
        
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.252 -0400", hash_original_method = "CE8CF2E74F2DF6C65F2B809B8ECF710B", hash_generated_method = "326DCDDEFAB1C276DD991839B4A2E6AC")
    public int hashCode() {
        int varE64E1A0AB0154FE686008799DA931C7F_2057348117 = ((isConstructed ? 1 : 0) ^ tag ^ Arrays.hashCode(octets)); 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249093319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249093319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.253 -0400", hash_original_method = "DBC165FE2DD4A16BCAF214B19B914EC2", hash_generated_method = "42AFD0A6315433527690C2ECA6CDB543")
    private byte[] replaceTagNumber(int newTag, byte[] input) throws IOException {
        int tagNo = input[0] & 0x1f;
        int index = 1;
        {
            tagNo = 0;
            int b = input[index++] & 0xff;
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("corrupted stream - invalid high tag number found");
            } 
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = input[index++] & 0xff;
            } 
            tagNo |= (b & 0x7f);
        } 
        byte[] tmp = new byte[input.length - index + 1];
        System.arraycopy(input, index, tmp, 1, tmp.length - 1);
        tmp[0] = (byte)newTag;
        addTaint(newTag);
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_549894306 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_549894306;
        
        
        
        
        
            
            
            
            
                
            
            
            
                
                
                
            
            
        
        
        
        
        
    }

    
}

