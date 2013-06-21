package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public abstract class ASN1Type implements ASN1Constants {
    public int id;
    public int constrId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.010 -0400", hash_original_method = "E753351671CF761070C01803DBBE0A73", hash_generated_method = "734A547051B2ADEF13166CF828AC2F15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Type(int tagNumber) {
        this(CLASS_UNIVERSAL, tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.011 -0400", hash_original_method = "C924F9DEBC46E3FF1C759C2A69F62440", hash_generated_method = "88258B5C1D5743C643E4394614C2727D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Type(int tagClass, int tagNumber) {
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(tagClass);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("tagNumber < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid tagClass");
        } //End block
        {
            this.id = tagClass + tagNumber;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("tag long form not implemented");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.011 -0400", hash_original_method = "DD7F9B0A8E4884CD611E54C95FCD3DA3", hash_generated_method = "C4B5D62884DDA4558BBC64F738960718")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object decode(byte[] encoded) throws IOException {
        dsTaint.addTaint(encoded[0]);
        Object varCCC1E50A020252253FF30AEF86EB8BFA_1736757452 = (decode(new DerInputStream(encoded)));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.012 -0400", hash_original_method = "F94AEF08BB5C9E1C82DE4BF1B9366E55", hash_generated_method = "EF00C833FBFF8A991552DA026096BB6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object decode(byte[] encoded, int offset, int encodingLen) throws IOException {
        dsTaint.addTaint(encodingLen);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(encoded[0]);
        Object var1BE8D9705EF8A30CEEFA7B21D31E1F1A_2026453142 = (decode(new DerInputStream(encoded, offset, encodingLen)));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return decode(new DerInputStream(encoded, offset, encodingLen));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.012 -0400", hash_original_method = "602847E19184C464832C69984B020DF7", hash_generated_method = "7D3539D47583BDDF431410C0F41CA8AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object decode(InputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        Object varA8920D910130209AD222224239F11FE4_412044421 = (decode(new DerInputStream(in)));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return decode(new DerInputStream(in));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.012 -0400", hash_original_method = "CCC5058B0D0F74ECE196C136FC714A4E", hash_generated_method = "8B8D18F015B94C37F67DE96737E9281F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void verify(byte[] encoded) throws IOException {
        dsTaint.addTaint(encoded[0]);
        DerInputStream decoder;
        decoder = new DerInputStream(encoded);
        decoder.setVerify();
        decode(decoder);
        // ---------- Original Method ----------
        //DerInputStream decoder = new DerInputStream(encoded);
        //decoder.setVerify();
        //decode(decoder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.012 -0400", hash_original_method = "8A3EDFD20917FC2A32E2E1C169001F91", hash_generated_method = "60F796AF33E341B5FBC12FAED81A9E53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void verify(InputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        DerInputStream decoder;
        decoder = new DerInputStream(in);
        decoder.setVerify();
        decode(decoder);
        // ---------- Original Method ----------
        //DerInputStream decoder = new DerInputStream(in);
        //decoder.setVerify();
        //decode(decoder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.012 -0400", hash_original_method = "53BC043E630E35D0E0B116BF28EF4348", hash_generated_method = "9F380BEB097D849F9AB450614F1D79CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] encode(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DerOutputStream out;
        out = new DerOutputStream(this, object);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //DerOutputStream out = new DerOutputStream(this, object);
        //return out.encoded;
    }

    
    public abstract Object decode(BerInputStream in) throws IOException;

    
    public abstract boolean checkTag(int identifier);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.013 -0400", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "2EEBEC9B5BD5EF3C2F731B980A12BF95")
    @DSModeled(DSC.SAFE)
    protected Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return in.content;
    }

    
    public abstract void encodeASN(BerOutputStream out);

    
    public abstract void encodeContent(BerOutputStream out);

    
    public abstract void setEncodingContent(BerOutputStream out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.014 -0400", hash_original_method = "FA7F24CC02CDE7C91DB883C7C7C15F71", hash_generated_method = "0FF1BA8921FDBC0B9AA07C0F6A90AA9B")
    @DSModeled(DSC.SAFE)
    public int getEncodedLength(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        int len;
        len = 1;
        {
            {
                int cur;
                cur = out.length >> 8;
                {
                    cur = cur >> 8;
                } //End block
            } //End collapsed parenthetic
        } //End block
        len += out.length;
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.014 -0400", hash_original_method = "54C9519AE58EE8A367BF831B5FC731FF", hash_generated_method = "B89B6FD8DACC4B9B7A963D1E6A6267AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var3D5053E1C5B2408C61D29357E2D91AB5_787237614 = (getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
    }

    
}

