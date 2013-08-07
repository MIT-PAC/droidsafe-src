package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;






public abstract class ASN1Type implements ASN1Constants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.450 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public int id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.450 -0400", hash_original_field = "3F529AE098CE9C8443C9E279609AEE18", hash_generated_field = "24E4DDF4395B1AE964B45B713C719F1F")

    public int constrId;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.450 -0400", hash_original_method = "E753351671CF761070C01803DBBE0A73", hash_generated_method = "763C5C08EEE9DC836BBB64D168C02191")
    public  ASN1Type(int tagNumber) {
        this(CLASS_UNIVERSAL, tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.452 -0400", hash_original_method = "C924F9DEBC46E3FF1C759C2A69F62440", hash_generated_method = "942E2D6E06331823C276284091BFCB4B")
    public  ASN1Type(int tagClass, int tagNumber) {
        if(tagNumber < 0)        
        {
            IllegalArgumentException varB394477E1B9527F987AB61B6DAD092E1_863356368 = new IllegalArgumentException("tagNumber < 0");
            varB394477E1B9527F987AB61B6DAD092E1_863356368.addTaint(taint);
            throw varB394477E1B9527F987AB61B6DAD092E1_863356368;
        } //End block
        if(tagClass != CLASS_UNIVERSAL && tagClass != CLASS_APPLICATION
                && tagClass != CLASS_CONTEXTSPECIFIC
                && tagClass != CLASS_PRIVATE)        
        {
            IllegalArgumentException varAF3E0A278465527E0F55E46BF63A9C7D_1629680237 = new IllegalArgumentException("invalid tagClass");
            varAF3E0A278465527E0F55E46BF63A9C7D_1629680237.addTaint(taint);
            throw varAF3E0A278465527E0F55E46BF63A9C7D_1629680237;
        } //End block
        if(tagNumber < 31)        
        {
            this.id = tagClass + tagNumber;
        } //End block
        else
        {
            IllegalArgumentException var45E3A3112A7E3D708B0E2604EAD4FEE9_1739860374 = new IllegalArgumentException("tag long form not implemented");
            var45E3A3112A7E3D708B0E2604EAD4FEE9_1739860374.addTaint(taint);
            throw var45E3A3112A7E3D708B0E2604EAD4FEE9_1739860374;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.453 -0400", hash_original_method = "DD7F9B0A8E4884CD611E54C95FCD3DA3", hash_generated_method = "2F5A60C6FBE3ECF283577571D6C82364")
    public final Object decode(byte[] encoded) throws IOException {
        addTaint(encoded[0]);
Object varA27427E0B663BE0893F37CE0F4386B67_12391168 =         decode(new DerInputStream(encoded));
        varA27427E0B663BE0893F37CE0F4386B67_12391168.addTaint(taint);
        return varA27427E0B663BE0893F37CE0F4386B67_12391168;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.454 -0400", hash_original_method = "F94AEF08BB5C9E1C82DE4BF1B9366E55", hash_generated_method = "A6E6772C785BD96B8AF3E5D61E52DB2A")
    public final Object decode(byte[] encoded, int offset, int encodingLen) throws IOException {
        addTaint(encodingLen);
        addTaint(offset);
        addTaint(encoded[0]);
Object var7AC0DDE2E3F29BE738B0D32693D4008D_2108353786 =         decode(new DerInputStream(encoded, offset, encodingLen));
        var7AC0DDE2E3F29BE738B0D32693D4008D_2108353786.addTaint(taint);
        return var7AC0DDE2E3F29BE738B0D32693D4008D_2108353786;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded, offset, encodingLen));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.454 -0400", hash_original_method = "602847E19184C464832C69984B020DF7", hash_generated_method = "169D38CBEE26C16045912169BBFA3599")
    public final Object decode(InputStream in) throws IOException {
        addTaint(in.getTaint());
Object var417CB3276EE229BF33C771F6ACA37265_802860314 =         decode(new DerInputStream(in));
        var417CB3276EE229BF33C771F6ACA37265_802860314.addTaint(taint);
        return var417CB3276EE229BF33C771F6ACA37265_802860314;
        // ---------- Original Method ----------
        //return decode(new DerInputStream(in));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.455 -0400", hash_original_method = "CCC5058B0D0F74ECE196C136FC714A4E", hash_generated_method = "C97148D73602A58C9A5418EBAB188F4D")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.455 -0400", hash_original_method = "8A3EDFD20917FC2A32E2E1C169001F91", hash_generated_method = "2D3814551CBD0CB3BF6C36859CFB74D7")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.456 -0400", hash_original_method = "53BC043E630E35D0E0B116BF28EF4348", hash_generated_method = "0DE781952D94404CDFCBA63B1FFCAC13")
    public final byte[] encode(Object object) {
        addTaint(object.getTaint());
        DerOutputStream out = new DerOutputStream(this, object);
        byte[] varE9B38D70B0F43548A3244899042B58E2_1431104859 = (out.encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_460528477 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_460528477;
        // ---------- Original Method ----------
        //DerOutputStream out = new DerOutputStream(this, object);
        //return out.encoded;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Object decode(BerInputStream in) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract boolean checkTag(int identifier);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.457 -0400", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "A3C3CE044F2FC08BB00E0956F22B25C4")
    protected Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
Object var57556EEB4589CFB95311E6AAE5182292_538628577 =         in.content;
        var57556EEB4589CFB95311E6AAE5182292_538628577.addTaint(taint);
        return var57556EEB4589CFB95311E6AAE5182292_538628577;
        // ---------- Original Method ----------
        //return in.content;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void encodeASN(BerOutputStream out);

    
    @DSModeled(DSC.SAFE)
    public abstract void encodeContent(BerOutputStream out);

    
    @DSModeled(DSC.SAFE)
    public abstract void setEncodingContent(BerOutputStream out);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.459 -0400", hash_original_method = "FA7F24CC02CDE7C91DB883C7C7C15F71", hash_generated_method = "F28B476EA8960F8CBEFA71783372CE2B")
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
        int varF5A8E923F8CD24B56B3BAB32358CC58A_1934119561 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164716706 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164716706;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.459 -0400", hash_original_method = "54C9519AE58EE8A367BF831B5FC731FF", hash_generated_method = "386BF2CF2C1116308F63B18B34BD2313")
    @Override
    public String toString() {
String var54A56088BA1CC5BAD6315483DACF2971_1695420448 =         getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
        var54A56088BA1CC5BAD6315483DACF2971_1695420448.addTaint(taint);
        return var54A56088BA1CC5BAD6315483DACF2971_1695420448;
        // ---------- Original Method ----------
        //return getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
    }

    
}

