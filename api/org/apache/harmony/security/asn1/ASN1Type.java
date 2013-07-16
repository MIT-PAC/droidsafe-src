package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;

public abstract class ASN1Type implements ASN1Constants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.717 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.717 -0400", hash_original_field = "3F529AE098CE9C8443C9E279609AEE18", hash_generated_field = "24E4DDF4395B1AE964B45B713C719F1F")

    public int constrId;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.717 -0400", hash_original_method = "E753351671CF761070C01803DBBE0A73", hash_generated_method = "763C5C08EEE9DC836BBB64D168C02191")
    public  ASN1Type(int tagNumber) {
        this(CLASS_UNIVERSAL, tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.718 -0400", hash_original_method = "C924F9DEBC46E3FF1C759C2A69F62440", hash_generated_method = "D78CD4F3C68DE2DDD77F22C73FB126A6")
    public  ASN1Type(int tagClass, int tagNumber) {
    if(tagNumber < 0)        
        {
            IllegalArgumentException varB394477E1B9527F987AB61B6DAD092E1_1431102901 = new IllegalArgumentException("tagNumber < 0");
            varB394477E1B9527F987AB61B6DAD092E1_1431102901.addTaint(taint);
            throw varB394477E1B9527F987AB61B6DAD092E1_1431102901;
        } //End block
    if(tagClass != CLASS_UNIVERSAL && tagClass != CLASS_APPLICATION
                && tagClass != CLASS_CONTEXTSPECIFIC
                && tagClass != CLASS_PRIVATE)        
        {
            IllegalArgumentException varAF3E0A278465527E0F55E46BF63A9C7D_1781343100 = new IllegalArgumentException("invalid tagClass");
            varAF3E0A278465527E0F55E46BF63A9C7D_1781343100.addTaint(taint);
            throw varAF3E0A278465527E0F55E46BF63A9C7D_1781343100;
        } //End block
    if(tagNumber < 31)        
        {
            this.id = tagClass + tagNumber;
        } //End block
        else
        {
            IllegalArgumentException var45E3A3112A7E3D708B0E2604EAD4FEE9_1270649037 = new IllegalArgumentException("tag long form not implemented");
            var45E3A3112A7E3D708B0E2604EAD4FEE9_1270649037.addTaint(taint);
            throw var45E3A3112A7E3D708B0E2604EAD4FEE9_1270649037;
        } //End block
        this.constrId = this.id + PC_CONSTRUCTED;
        // ---------- Original Method ----------
        //if (tagNumber < 0) {
            //throw new IllegalArgumentException("tagNumber < 0");
        //}
        //if (tagClass != CLASS_UNIVERSAL && tagClass != CLASS_APPLICATION
                //&& tagClass != CLASS_CONTEXTSPECIFIC
                //&& tagClass != CLASS_PRIVATE) {
            //throw new IllegalArgumentException("invalid tagClass");
        //}
        //if (tagNumber < 31) {
            //this.id = tagClass + tagNumber;
        //} else {
            //throw new IllegalArgumentException("tag long form not implemented");
        //}
        //this.constrId = this.id + PC_CONSTRUCTED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.719 -0400", hash_original_method = "DD7F9B0A8E4884CD611E54C95FCD3DA3", hash_generated_method = "2A5BAA77A2AB12F6FDDFAA0ECE1A56BB")
    public final Object decode(byte[] encoded) throws IOException {
        addTaint(encoded[0]);
Object varA27427E0B663BE0893F37CE0F4386B67_909165490 =         decode(new DerInputStream(encoded));
        varA27427E0B663BE0893F37CE0F4386B67_909165490.addTaint(taint);
        return varA27427E0B663BE0893F37CE0F4386B67_909165490;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.720 -0400", hash_original_method = "F94AEF08BB5C9E1C82DE4BF1B9366E55", hash_generated_method = "738800A73214D3C702F31127F71210C5")
    public final Object decode(byte[] encoded, int offset, int encodingLen) throws IOException {
        addTaint(encodingLen);
        addTaint(offset);
        addTaint(encoded[0]);
Object var7AC0DDE2E3F29BE738B0D32693D4008D_338888488 =         decode(new DerInputStream(encoded, offset, encodingLen));
        var7AC0DDE2E3F29BE738B0D32693D4008D_338888488.addTaint(taint);
        return var7AC0DDE2E3F29BE738B0D32693D4008D_338888488;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded, offset, encodingLen));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.720 -0400", hash_original_method = "602847E19184C464832C69984B020DF7", hash_generated_method = "9DE825CAD6D3CC72CE37C79E97947670")
    public final Object decode(InputStream in) throws IOException {
        addTaint(in.getTaint());
Object var417CB3276EE229BF33C771F6ACA37265_1102470289 =         decode(new DerInputStream(in));
        var417CB3276EE229BF33C771F6ACA37265_1102470289.addTaint(taint);
        return var417CB3276EE229BF33C771F6ACA37265_1102470289;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(in));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.720 -0400", hash_original_method = "CCC5058B0D0F74ECE196C136FC714A4E", hash_generated_method = "C97148D73602A58C9A5418EBAB188F4D")
    public final void verify(byte[] encoded) throws IOException {
        addTaint(encoded[0]);
        DerInputStream decoder = new DerInputStream(encoded);
        decoder.setVerify();
        decode(decoder);
        // ---------- Original Method ----------
        //DerInputStream decoder = new DerInputStream(encoded);
        //decoder.setVerify();
        //decode(decoder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.721 -0400", hash_original_method = "8A3EDFD20917FC2A32E2E1C169001F91", hash_generated_method = "2D3814551CBD0CB3BF6C36859CFB74D7")
    public final void verify(InputStream in) throws IOException {
        addTaint(in.getTaint());
        DerInputStream decoder = new DerInputStream(in);
        decoder.setVerify();
        decode(decoder);
        // ---------- Original Method ----------
        //DerInputStream decoder = new DerInputStream(in);
        //decoder.setVerify();
        //decode(decoder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.721 -0400", hash_original_method = "53BC043E630E35D0E0B116BF28EF4348", hash_generated_method = "C3818B9DB8FE334ECDF702C4B019DFC0")
    public final byte[] encode(Object object) {
        addTaint(object.getTaint());
        DerOutputStream out = new DerOutputStream(this, object);
        byte[] varE9B38D70B0F43548A3244899042B58E2_493215525 = (out.encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_545251215 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_545251215;
        // ---------- Original Method ----------
        //DerOutputStream out = new DerOutputStream(this, object);
        //return out.encoded;
    }

    
    public abstract Object decode(BerInputStream in) throws IOException;

    
    public abstract boolean checkTag(int identifier);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.722 -0400", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "7AF82CF4C3F53F3B61CAA73663B20DD9")
    protected Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
Object var57556EEB4589CFB95311E6AAE5182292_2051022839 =         in.content;
        var57556EEB4589CFB95311E6AAE5182292_2051022839.addTaint(taint);
        return var57556EEB4589CFB95311E6AAE5182292_2051022839;
        // ---------- Original Method ----------
        //return in.content;
    }

    
    public abstract void encodeASN(BerOutputStream out);

    
    public abstract void encodeContent(BerOutputStream out);

    
    public abstract void setEncodingContent(BerOutputStream out);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.723 -0400", hash_original_method = "FA7F24CC02CDE7C91DB883C7C7C15F71", hash_generated_method = "2F73D63D0D92227C2F94C1357B4CA638")
    public int getEncodedLength(BerOutputStream out) {
        addTaint(out.getTaint());
        int len = 1;
        len++;
    if(out.length > 127)        
        {
            len++;
for(int cur = out.length >> 8;cur > 0;len++)
            {
                cur = cur >> 8;
            } //End block
        } //End block
        len += out.length;
        int varF5A8E923F8CD24B56B3BAB32358CC58A_850290243 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719085611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1719085611;
        // ---------- Original Method ----------
        //int len = 1;
        //len++;
        //if (out.length > 127) {
            //len++;
            //for (int cur = out.length >> 8; cur > 0; len++) {
                //cur = cur >> 8;
            //}
        //}
        //len += out.length;
        //return len;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.723 -0400", hash_original_method = "54C9519AE58EE8A367BF831B5FC731FF", hash_generated_method = "6BE06FD2938AFEC2A56F5853542CE7E3")
    @Override
    public String toString() {
String var54A56088BA1CC5BAD6315483DACF2971_1197177353 =         getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
        var54A56088BA1CC5BAD6315483DACF2971_1197177353.addTaint(taint);
        return var54A56088BA1CC5BAD6315483DACF2971_1197177353;
        // ---------- Original Method ----------
        //return getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
    }

    
}

