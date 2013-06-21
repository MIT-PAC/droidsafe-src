package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class ContentInfo {
    private int[] oid;
    private Object content;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.166 -0400", hash_original_method = "A1561DFF6C4CF564DBA671C7F4145BEE", hash_generated_method = "BB74E144C665A7778478D662723CFB67")
    @DSModeled(DSC.SAFE)
    private ContentInfo(int[] oid, Object content, byte[] encoding) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(oid[0]);
        dsTaint.addTaint(encoding[0]);
        // ---------- Original Method ----------
        //this.oid = oid;
        //this.content = content;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.166 -0400", hash_original_method = "FEA779456A4B7718EE7D788C42FE9ED3", hash_generated_method = "45EF282F90E5AD4DC29EF2E49A76380C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SignedData getSignedData() {
        {
            boolean var39A0E72567E8CA5BEA10BAB9AB37B8BD_1714913034 = (Arrays.equals(oid, SIGNED_DATA));
        } //End collapsed parenthetic
        return (SignedData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (Arrays.equals(oid, SIGNED_DATA)) {
            //return (SignedData)content;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.166 -0400", hash_original_method = "7EF6AE96CD0AADFF5C056ACE9B248CB2", hash_generated_method = "6B73667F1680CA8373A396F6B91BA612")
    @DSModeled(DSC.SAFE)
    public Object getContent() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.166 -0400", hash_original_method = "47E7DB6049BFBF7F7143C81AA2952707", hash_generated_method = "23B07BD35A7AD222840F40BACA0D7F09")
    @DSModeled(DSC.SAFE)
    public int[] getContentType() {
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.166 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.170 -0400", hash_original_method = "E27EF60D80B9BCE694BEF49083131D32", hash_generated_method = "2193F1C3951EA225EC5565346BBC07A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("==== ContentInfo:");
        res.append("\n== ContentType (OID): ");
        {
            int i = oid[0];
            {
                res.append(i);
                res.append(' ');
            } //End block
        } //End collapsed parenthetic
        res.append("\n== Content: ");
        {
            res.append("\n");
            res.append(content.toString());
        } //End block
        res.append("\n== Content End");
        res.append("\n==== ContentInfo End\n");
        String var3F7A63C0290A7D59CE78DF2F46EB4AAE_641566025 = (res.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("==== ContentInfo:");
        //res.append("\n== ContentType (OID): ");
        //for (int i : oid) {
            //res.append(i);
            //res.append(' ');
        //}
        //res.append("\n== Content: ");
        //if (content != null) {
            //res.append("\n");
            //res.append(content.toString());
        //}
        //res.append("\n== Content End");
        //res.append("\n==== ContentInfo End\n");
        //return res.toString();
    }

    
    public static final int[] DATA = new int[] {1, 2, 840, 113549, 1, 7, 1};
    public static final int[] SIGNED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 2};
    public static final int[] ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 3};
    public static final int[] SIGNED_AND_ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 4};
    public static final int[] DIGESTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 5};
    public static final int[] ENCRYPTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 6};
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
                ASN1Oid.getInstance(),
                new ASN1Explicit(0, ASN1Any.getInstance())
                }) {        {
            setOptional(1); 
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.170 -0400", hash_original_method = "DE814BC7A3ADD369EC16BC4834AE1E64", hash_generated_method = "63F122975F1F20927EF75EFB4F5119F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            ContentInfo ci;
            ci = (ContentInfo) object;
            values[0] = ci.oid;
            {
                {
                    boolean var7B5F396FBF63E2FD3691C916106DD7DC_310053266 = (Arrays.equals(ci.oid, DATA));
                    {
                        {
                            values[1] =
                            ASN1OctetString.getInstance().encode(ci.content);
                        } //End block
                    } //End block
                    {
                        values[1] = SignedData.ASN1.encode(ci.content);
                    } //End block
                    {
                        values[1] = ci.content;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //ContentInfo ci = (ContentInfo) object;
            //values[0] = ci.oid;
            //if (ci.content != null) {
                //if (Arrays.equals(ci.oid, DATA)) {
                    //if (ci.content != null) {
                        //values[1] =
                            //ASN1OctetString.getInstance().encode(ci.content);
                    //}
                //} else if (ci.content instanceof SignedData) {
                    //values[1] = SignedData.ASN1.encode(ci.content);
                //} else {
                    //values[1] = ci.content;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.171 -0400", hash_original_method = "C3EAC210669809D55F8F3014F8B268F8", hash_generated_method = "FC4386E6104FD865EAE02C9EC2D53667")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            int[] oid;
            oid = (int[]) values[0];
            {
                boolean var28ECC7BECFBC4E132BA25B25BB1C368A_134839393 = (Arrays.equals(oid, DATA));
                {
                    {
                        Object varD09F70C08277AC19D85715B28EB2C902_1596817797 = (new ContentInfo(oid,
                            ASN1OctetString.getInstance().decode((byte[])values[1]),
                            in.getEncoded()));
                    } //End block
                    {
                        Object var226995A98F453B65840DD85F16F1BA8B_1009628866 = (new ContentInfo((int[])values[0], null,
                            in.getEncoded()));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varF40B0D033986B8626C48A2FA6A8824EA_545613397 = (Arrays.equals(oid, SIGNED_DATA));
                {
                    Object var1FB0079ADE0EA206ED71736B3B09B99D_1992613880 = (new ContentInfo((int[])values[0],
                        SignedData.ASN1.decode((byte[])values[1]),
                        in.getEncoded()));
                } //End block
            } //End collapsed parenthetic
            Object var3E65F3A1585AACC9DD099CA157AB8924_1139972542 = (new ContentInfo((int[]) values[0], values[1], in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
}; //Transformed anonymous class
}

