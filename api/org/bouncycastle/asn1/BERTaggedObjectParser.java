package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.024 -0400", hash_original_field = "B52D9E9D9646E0353AB30807D53B3F06", hash_generated_field = "FF4CF5F81862B8524694C4DB9DDE635D")

    private boolean _constructed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.024 -0400", hash_original_field = "EAE2E4D0FF1C370A789CC8A0673A645C", hash_generated_field = "62F1DF151C857CACD0771E182D275DC9")

    private int _tagNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.024 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.025 -0400", hash_original_method = "CEDFC0E6C0BD9B3FF1D771A70B508D94", hash_generated_method = "B703C029B21604584D735A1A457A8E9F")
    protected  BERTaggedObjectParser(
        int         baseTag,
        int         tagNumber,
        InputStream contentStream) {
        this((baseTag & DERTags.CONSTRUCTED) != 0, tagNumber, new ASN1StreamParser(contentStream));
        addTaint(contentStream.getTaint());
        addTaint(tagNumber);
        addTaint(baseTag);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.026 -0400", hash_original_method = "641FC71F34D5E5D1E36A069067B2FFCA", hash_generated_method = "4224D6E59DB0E81A205C5A86FC970910")
      BERTaggedObjectParser(
        boolean             constructed,
        int                 tagNumber,
        ASN1StreamParser    parser) {
        _constructed = constructed;
        _tagNumber = tagNumber;
        _parser = parser;
        // ---------- Original Method ----------
        //_constructed = constructed;
        //_tagNumber = tagNumber;
        //_parser = parser;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.026 -0400", hash_original_method = "E640F7F01BC858A63ED48B7251E0457D", hash_generated_method = "BD888C6378C76BF934840AB821B92FFC")
    public boolean isConstructed() {
        boolean varB52D9E9D9646E0353AB30807D53B3F06_338420292 = (_constructed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459355779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459355779;
        // ---------- Original Method ----------
        //return _constructed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.026 -0400", hash_original_method = "B35ABF3B77036668E0072FBBE52EC3E8", hash_generated_method = "E41AF6831F6EE6636E9853E4FAF4D9C4")
    public int getTagNo() {
        int varEAE2E4D0FF1C370A789CC8A0673A645C_296176731 = (_tagNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673651076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673651076;
        // ---------- Original Method ----------
        //return _tagNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.027 -0400", hash_original_method = "4AD739EA93AB775B40026E215844A8E7", hash_generated_method = "05CE4052B836A0DECB550048A036155E")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) throws IOException {
        addTaint(isExplicit);
        addTaint(tag);
        if(isExplicit)        
        {
            if(!_constructed)            
            {
                IOException var550978CC5739B156929713E053AB0F8F_20983823 = new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
                var550978CC5739B156929713E053AB0F8F_20983823.addTaint(taint);
                throw var550978CC5739B156929713E053AB0F8F_20983823;
            } //End block
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_1718340329 =             _parser.readObject();
            var7FA56CC8A68C244D303C7C9A462CBFE7_1718340329.addTaint(taint);
            return var7FA56CC8A68C244D303C7C9A462CBFE7_1718340329;
        } //End block
DEREncodable varC0A7EA330C97F08D8F4E627A246A5388_1441408177 =         _parser.readImplicit(_constructed, tag);
        varC0A7EA330C97F08D8F4E627A246A5388_1441408177.addTaint(taint);
        return varC0A7EA330C97F08D8F4E627A246A5388_1441408177;
        // ---------- Original Method ----------
        //if (isExplicit)
        //{
            //if (!_constructed)
            //{
                //throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
            //}
            //return _parser.readObject();
        //}
        //return _parser.readImplicit(_constructed, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.027 -0400", hash_original_method = "966C66B264046D402E2F3ED8541B4BF3", hash_generated_method = "670F673EEFDC299E5972EF4E8C789F89")
    public DERObject getLoadedObject() throws IOException {
DERObject var8672A79C191ABECE380987F377B9DD0A_986898948 =         _parser.readTaggedObject(_constructed, _tagNumber);
        var8672A79C191ABECE380987F377B9DD0A_986898948.addTaint(taint);
        return var8672A79C191ABECE380987F377B9DD0A_986898948;
        // ---------- Original Method ----------
        //return _parser.readTaggedObject(_constructed, _tagNumber);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.027 -0400", hash_original_method = "8993E91076953DCCDD0896DB0B3E91BE", hash_generated_method = "53C80C4132CE5C77C7B21B24CEF5317C")
    public DERObject getDERObject() {
        try 
        {
DERObject var86ADD3CA276150B281C3CAF65FB31CFA_1656497835 =             this.getLoadedObject();
            var86ADD3CA276150B281C3CAF65FB31CFA_1656497835.addTaint(taint);
            return var86ADD3CA276150B281C3CAF65FB31CFA_1656497835;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var8E62F5E57FC8734C351E697F3199D23E_1503884120 = new ASN1ParsingException(e.getMessage());
            var8E62F5E57FC8734C351E697F3199D23E_1503884120.addTaint(taint);
            throw var8E62F5E57FC8734C351E697F3199D23E_1503884120;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return this.getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException(e.getMessage());
        //}
    }

    
}

