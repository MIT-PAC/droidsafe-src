package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements DERTags {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.671 -0400", hash_original_field = "AA9F73EEA60A006820D0F8768BC8A3FC", hash_generated_field = "D8A77E2E2DC8CA16CE4A344FA1118F72")

    private int limit;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.671 -0400", hash_original_field = "677A3369D53E6980D2B72D680BD4755C", hash_generated_field = "479E5A76190EF85C722BCE9E91B363C1")

    private boolean lazyEvaluate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.672 -0400", hash_original_method = "A509F95CC009C058902019FB1EA46111", hash_generated_method = "712E96BD7D3E62F77404E58E95566D4B")
    public  ASN1InputStream(
        InputStream is) {
        this(is, findLimit(is));
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.672 -0400", hash_original_method = "00EF7E908C3752F726679FF101FABBAF", hash_generated_method = "3463856FAA2DB77D2CE4E16A57C8AE31")
    public  ASN1InputStream(
        byte[] input) {
        this(new ByteArrayInputStream(input), input.length);
        addTaint(input[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.672 -0400", hash_original_method = "B0ECE654E14AB45AF60FAFEB349CC4AF", hash_generated_method = "611C1895748C709C464F4829B64083BB")
    public  ASN1InputStream(
        byte[] input,
        boolean lazyEvaluate) {
        this(new ByteArrayInputStream(input), input.length, lazyEvaluate);
        addTaint(lazyEvaluate);
        addTaint(input[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.673 -0400", hash_original_method = "EDCCEC3121F6C5E9B0FA391DCCD578AC", hash_generated_method = "30E22029645B9A707CD191A92111E3E5")
    public  ASN1InputStream(
        InputStream input,
        int         limit) {
        this(input, limit, false);
        addTaint(limit);
        addTaint(input.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.674 -0400", hash_original_method = "B7677C48F68A4418B50D4EB3534A5CED", hash_generated_method = "D4ED06E035F79507C3E1C2E566C6AD6B")
    public  ASN1InputStream(
        InputStream input,
        int         limit,
        boolean     lazyEvaluate) {
        super(input);
        addTaint(input.getTaint());
        this.limit = limit;
        this.lazyEvaluate = lazyEvaluate;
        // ---------- Original Method ----------
        //this.limit = limit;
        //this.lazyEvaluate = lazyEvaluate;
    }

    
    static int findLimit(InputStream in) {
        if (in instanceof LimitedInputStream)
        {
            return ((LimitedInputStream)in).getRemaining();
        }
        else if (in instanceof ByteArrayInputStream)
        {
            return ((ByteArrayInputStream)in).available();
        }
        return Integer.MAX_VALUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.674 -0400", hash_original_method = "CF3BC7CE74758708D5C7508F6ABCFCEC", hash_generated_method = "B7DE44E8DB1F9000A6688AE6B1C08A80")
    protected int readLength() throws IOException {
        int varC80E0DC01831B644FC078B296E30DF0A_1054798673 = (readLength(this, limit));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266354191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266354191;
        // ---------- Original Method ----------
        //return readLength(this, limit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.675 -0400", hash_original_method = "BA47F8F31DF51652E381DF5AC1EDFDE7", hash_generated_method = "C77362D896173E4240A109F59820D68A")
    protected void readFully(
        byte[]  bytes) throws IOException {
        addTaint(bytes[0]);
        if(Streams.readFully(this, bytes) != bytes.length)        
        {
            EOFException var21E10E3FDE2F28CF052B18FD81B49AC0_2128007582 = new EOFException("EOF encountered in middle of object");
            var21E10E3FDE2F28CF052B18FD81B49AC0_2128007582.addTaint(taint);
            throw var21E10E3FDE2F28CF052B18FD81B49AC0_2128007582;
        } //End block
        // ---------- Original Method ----------
        //if (Streams.readFully(this, bytes) != bytes.length)
        //{
            //throw new EOFException("EOF encountered in middle of object");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.676 -0400", hash_original_method = "FB275304C6A60067CFDA4B800CA085AD", hash_generated_method = "9A8A53FD47CC59ABB4A862214BE71FC0")
    protected DERObject buildObject(
        int       tag,
        int       tagNo,
        int       length) throws IOException {
        addTaint(length);
        addTaint(tagNo);
        addTaint(tag);
        boolean isConstructed = (tag & CONSTRUCTED) != 0;
        DefiniteLengthInputStream defIn = new DefiniteLengthInputStream(this, length);
        if((tag & APPLICATION) != 0)        
        {
DERObject varE34C51A9354A8B1A118F6CDDBBAC7679_934693354 =             new DERApplicationSpecific(isConstructed, tagNo, defIn.toByteArray());
            varE34C51A9354A8B1A118F6CDDBBAC7679_934693354.addTaint(taint);
            return varE34C51A9354A8B1A118F6CDDBBAC7679_934693354;
        } //End block
        if((tag & TAGGED) != 0)        
        {
DERObject var0ADBEA0CD0E4A395AB6A8BDE5DB1DF52_1350733324 =             new ASN1StreamParser(defIn).readTaggedObject(isConstructed, tagNo);
            var0ADBEA0CD0E4A395AB6A8BDE5DB1DF52_1350733324.addTaint(taint);
            return var0ADBEA0CD0E4A395AB6A8BDE5DB1DF52_1350733324;
        } //End block
        if(isConstructed)        
        {
switch(tagNo){
            case OCTET_STRING:
DERObject var77EA9382029402B6AF3BACBAF60EF53A_1065070753 =             new BERConstructedOctetString(buildDEREncodableVector(defIn).v);
            var77EA9382029402B6AF3BACBAF60EF53A_1065070753.addTaint(taint);
            return var77EA9382029402B6AF3BACBAF60EF53A_1065070753;
            case SEQUENCE:
            if(lazyEvaluate)            
            {
DERObject var7F7029B27A36368CD96B97187ADE8F74_314069414 =                 new LazyDERSequence(defIn.toByteArray());
                var7F7029B27A36368CD96B97187ADE8F74_314069414.addTaint(taint);
                return var7F7029B27A36368CD96B97187ADE8F74_314069414;
            } //End block
            else
            {
DERObject varB72ABBB4CF7C46F2BE0CB5E0449050FD_1298625139 =                 DERFactory.createSequence(buildDEREncodableVector(defIn));
                varB72ABBB4CF7C46F2BE0CB5E0449050FD_1298625139.addTaint(taint);
                return varB72ABBB4CF7C46F2BE0CB5E0449050FD_1298625139;
            } //End block
            case SET:
DERObject var9629FC4803A172D4CC1867B424C1D57F_1248949064 =             DERFactory.createSet(buildDEREncodableVector(defIn), false);
            var9629FC4803A172D4CC1867B424C1D57F_1248949064.addTaint(taint);
            return var9629FC4803A172D4CC1867B424C1D57F_1248949064;
            case EXTERNAL:
DERObject var9D666F162AC4110BC78A7E66734AFCFE_2117687488 =             new DERExternal(buildDEREncodableVector(defIn));
            var9D666F162AC4110BC78A7E66734AFCFE_2117687488.addTaint(taint);
            return var9D666F162AC4110BC78A7E66734AFCFE_2117687488;
            default:
DERObject varD10C2E8D563A110A48696C7D62447036_1324409214 =             new DERUnknownTag(true, tagNo, defIn.toByteArray());
            varD10C2E8D563A110A48696C7D62447036_1324409214.addTaint(taint);
            return varD10C2E8D563A110A48696C7D62447036_1324409214;
}
        } //End block
DERObject var72557301F4134763D6B451D02E18155C_236738327 =         createPrimitiveDERObject(tagNo, defIn.toByteArray());
        var72557301F4134763D6B451D02E18155C_236738327.addTaint(taint);
        return var72557301F4134763D6B451D02E18155C_236738327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.676 -0400", hash_original_method = "3644C80D3B1C21E0DE1F50623D57B77E", hash_generated_method = "9CE8C0A40298092966655AC1F730CA11")
     ASN1EncodableVector buildEncodableVector() throws IOException {
        ASN1EncodableVector v = new ASN1EncodableVector();
        DERObject o;
        while
((o = readObject()) != null)        
        {
            v.add(o);
        } //End block
ASN1EncodableVector var6DC76BC51820DD65E8396280E884AA78_1817258371 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1817258371.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1817258371;
        // ---------- Original Method ----------
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //DERObject o;
        //while ((o = readObject()) != null)
        //{
            //v.add(o);
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.677 -0400", hash_original_method = "758DE99B8F596F62A95AD037BCF1A83C", hash_generated_method = "1A2566261346FC36DF52CF403B61EC9F")
     ASN1EncodableVector buildDEREncodableVector(
        DefiniteLengthInputStream dIn) throws IOException {
        addTaint(dIn.getTaint());
ASN1EncodableVector var705FA4AEB2BCFF47B76DA61F226F7E26_273772086 =         new ASN1InputStream(dIn).buildEncodableVector();
        var705FA4AEB2BCFF47B76DA61F226F7E26_273772086.addTaint(taint);
        return var705FA4AEB2BCFF47B76DA61F226F7E26_273772086;
        // ---------- Original Method ----------
        //return new ASN1InputStream(dIn).buildEncodableVector();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.678 -0400", hash_original_method = "14F17C52EA17CC32DA8A973E14D77B9E", hash_generated_method = "92418AE2D3BBB0D2221A46813A159A8A")
    public DERObject readObject() throws IOException {
        int tag = read();
        if(tag <= 0)        
        {
            if(tag == 0)            
            {
                IOException var5C9B7C12641D8A4D21001643E6417EC5_849358402 = new IOException("unexpected end-of-contents marker");
                var5C9B7C12641D8A4D21001643E6417EC5_849358402.addTaint(taint);
                throw var5C9B7C12641D8A4D21001643E6417EC5_849358402;
            } //End block
DERObject var540C13E9E156B687226421B24F2DF178_1756676979 =             null;
            var540C13E9E156B687226421B24F2DF178_1756676979.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1756676979;
        } //End block
        int tagNo = readTagNumber(this, tag);
        boolean isConstructed = (tag & CONSTRUCTED) != 0;
        int length = readLength();
        if(length < 0)        
        {
            if(!isConstructed)            
            {
                IOException var0055B29725078D64828DFE2C61240180_1400694901 = new IOException("indefinite length primitive encoding encountered");
                var0055B29725078D64828DFE2C61240180_1400694901.addTaint(taint);
                throw var0055B29725078D64828DFE2C61240180_1400694901;
            } //End block
            IndefiniteLengthInputStream indIn = new IndefiniteLengthInputStream(this, limit);
            ASN1StreamParser sp = new ASN1StreamParser(indIn, limit);
            if((tag & APPLICATION) != 0)            
            {
DERObject var693ABAC9A9FF779289639FF2A3D198F6_653705925 =                 new BERApplicationSpecificParser(tagNo, sp).getLoadedObject();
                var693ABAC9A9FF779289639FF2A3D198F6_653705925.addTaint(taint);
                return var693ABAC9A9FF779289639FF2A3D198F6_653705925;
            } //End block
            if((tag & TAGGED) != 0)            
            {
DERObject var97EFBFC0B8A4F08549BDB35729FA95AE_544387232 =                 new BERTaggedObjectParser(true, tagNo, sp).getLoadedObject();
                var97EFBFC0B8A4F08549BDB35729FA95AE_544387232.addTaint(taint);
                return var97EFBFC0B8A4F08549BDB35729FA95AE_544387232;
            } //End block
switch(tagNo){
            case OCTET_STRING:
DERObject var2A744DACCC077923A0D7916B60B7B4B8_398497049 =             new BEROctetStringParser(sp).getLoadedObject();
            var2A744DACCC077923A0D7916B60B7B4B8_398497049.addTaint(taint);
            return var2A744DACCC077923A0D7916B60B7B4B8_398497049;
            case SEQUENCE:
DERObject varC8A113D46E9A75F8F3EE71CDF8CB5A1B_1469807322 =             new BERSequenceParser(sp).getLoadedObject();
            varC8A113D46E9A75F8F3EE71CDF8CB5A1B_1469807322.addTaint(taint);
            return varC8A113D46E9A75F8F3EE71CDF8CB5A1B_1469807322;
            case SET:
DERObject var7AA171027B889857ADAA933EB2461343_1146412495 =             new BERSetParser(sp).getLoadedObject();
            var7AA171027B889857ADAA933EB2461343_1146412495.addTaint(taint);
            return var7AA171027B889857ADAA933EB2461343_1146412495;
            case EXTERNAL:
DERObject var3518CBDB4D24245AB7060EECA43E77E7_1710079502 =             new DERExternalParser(sp).getLoadedObject();
            var3518CBDB4D24245AB7060EECA43E77E7_1710079502.addTaint(taint);
            return var3518CBDB4D24245AB7060EECA43E77E7_1710079502;
            default:
            IOException var7CA3C00DE0F222C95CF1D61190C120F3_2012371297 = new IOException("unknown BER object encountered");
            var7CA3C00DE0F222C95CF1D61190C120F3_2012371297.addTaint(taint);
            throw var7CA3C00DE0F222C95CF1D61190C120F3_2012371297;
}
        } //End block
        else
        {
            try 
            {
DERObject var9F04FABE8EE077714A8CD9610888B3CA_2091564994 =                 buildObject(tag, tagNo, length);
                var9F04FABE8EE077714A8CD9610888B3CA_2091564994.addTaint(taint);
                return var9F04FABE8EE077714A8CD9610888B3CA_2091564994;
            } //End block
            catch (IllegalArgumentException e)
            {
                ASN1Exception var30FC1394D6DD5B9F39A6694742A3F039_136287047 = new ASN1Exception("corrupted stream detected", e);
                var30FC1394D6DD5B9F39A6694742A3F039_136287047.addTaint(taint);
                throw var30FC1394D6DD5B9F39A6694742A3F039_136287047;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static int readTagNumber(InputStream s, int tag) throws IOException {
        int tagNo = tag & 0x1f;
        if (tagNo == 0x1f)
        {
            tagNo = 0;
            int b = s.read();
            if ((b & 0x7f) == 0) 
            {
                throw new IOException("corrupted stream - invalid high tag number found");
            }
            while ((b >= 0) && ((b & 0x80) != 0))
            {
                tagNo |= (b & 0x7f);
                tagNo <<= 7;
                b = s.read();
            }
            if (b < 0)
            {
                throw new EOFException("EOF found inside tag value.");
            }
            tagNo |= (b & 0x7f);
        }
        return tagNo;
    }

    
    static int readLength(InputStream s, int limit) throws IOException {
        int length = s.read();
        if (length < 0)
        {
            throw new EOFException("EOF found when length expected");
        }
        if (length == 0x80)
        {
            return -1;      
        }
        if (length > 127)
        {
            int size = length & 0x7f;
            if (size > 4)
            {
                throw new IOException("DER length more than 4 bytes: " + size);
            }
            length = 0;
            for (int i = 0; i < size; i++)
            {
                int next = s.read();
                if (next < 0)
                {
                    throw new EOFException("EOF found reading length");
                }
                length = (length << 8) + next;
            }
            if (length < 0)
            {
                throw new IOException("corrupted stream - negative length found");
            }
            if (length >= limit)   
            {
                throw new IOException("corrupted stream - out of bounds length found");
            }
        }
        return length;
    }

    
    static DERObject createPrimitiveDERObject(
        int     tagNo,
        byte[]  bytes) {
        switch (tagNo)
        {
            case BIT_STRING:
                return DERBitString.fromOctetString(bytes);
            case BMP_STRING:
                return new DERBMPString(bytes);
            case BOOLEAN:
                return DERBoolean.getInstance(bytes);
            case ENUMERATED:
                return new ASN1Enumerated(bytes);
            case GENERALIZED_TIME:
                return new ASN1GeneralizedTime(bytes);
            case GENERAL_STRING:
                return new DERGeneralString(bytes);
            case IA5_STRING:
                return new DERIA5String(bytes);
            case INTEGER:
                return new ASN1Integer(bytes);
            case NULL:
                return DERNull.INSTANCE;   
            case NUMERIC_STRING:
                return new DERNumericString(bytes);
            case OBJECT_IDENTIFIER:
                return new ASN1ObjectIdentifier(bytes);
            case OCTET_STRING:
                return new DEROctetString(bytes);
            case PRINTABLE_STRING:
                return new DERPrintableString(bytes);
            case T61_STRING:
                return new DERT61String(bytes);
            case UNIVERSAL_STRING:
                return new DERUniversalString(bytes);
            case UTC_TIME:
                return new ASN1UTCTime(bytes);
            case UTF8_STRING:
                return new DERUTF8String(bytes);
            case VISIBLE_STRING:
                return new DERVisibleString(bytes);
            default:
                return new DERUnknownTag(false, tagNo, bytes);
        }
    }

    
}

