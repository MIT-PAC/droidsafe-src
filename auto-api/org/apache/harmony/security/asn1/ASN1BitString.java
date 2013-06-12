package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import libcore.util.EmptyArray;

public class ASN1BitString extends ASN1StringType {
    private static final ASN1BitString ASN1 = new ASN1BitString();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "AD601F3532730C1588B10C0B2F4700C0", hash_generated_method = "646406D8A2F994C77239AB18E2322B53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1BitString() {
        super(TAG_BITSTRING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "66B1F67B2E4924691687068C01957881", hash_generated_method = "09FC42AAA2010F0F571B2693B7BFC711")
    public static ASN1BitString getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "BF14955802A2C4E7FA1CD34E2A56A014", hash_generated_method = "8D5BE3D2EBCADFE0A42656E4305D670B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readBitString();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1538905689 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readBitString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "E5B2C829F55FF77DE885EB0182CA875F", hash_generated_method = "C3F87C0035697CCF4BF7724B218A52B3")
    @DSModeled(DSC.SAFE)
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        byte[] bytes;
        bytes = new byte[in.length - 1];
        System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                in.length - 1);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte[] bytes = new byte[in.length - 1];
        //System.arraycopy(in.buffer, in.contentOffset + 1, bytes, 0,
                //in.length - 1);
        //return new BitString(bytes, in.buffer[in.contentOffset]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "F26C5493E5849E857C2B791290EA66B7", hash_generated_method = "A671E972352EAD75E6BEBDD31EF5B996")
    @DSModeled(DSC.SAFE)
    @Override
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeBitString();
        // ---------- Original Method ----------
        //out.encodeBitString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "FF34851DE63579E10DEA6E02E8081017", hash_generated_method = "41A48B00799A746730653C933207BCF3")
    @DSModeled(DSC.SAFE)
    @Override
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.length = ((BitString) out.content).bytes.length + 1;
        // ---------- Original Method ----------
        //out.length = ((BitString) out.content).bytes.length + 1;
    }

    
    public static class ASN1NamedBitList extends ASN1BitString {
        private static final byte[] SET_MASK = { (byte) 128, 64, 32, 16, 8, 4, 2, 1};
        private static final BitString emptyString = new BitString(EmptyArray.BYTE, 0);
        private static final int INDEFINITE_SIZE = -1;
        private final int minBits;
        private final int maxBits;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "C4F695AEADF70B93944D050F01760534", hash_generated_method = "CA852FCC8AE07A9A5F369DEA3670A1F5")
        @DSModeled(DSC.SAFE)
        public ASN1NamedBitList(int minBits) {
            dsTaint.addTaint(minBits);
            this.minBits = minBits;
            this.maxBits = INDEFINITE_SIZE;
            // ---------- Original Method ----------
            //this.minBits = minBits;
            //this.maxBits = INDEFINITE_SIZE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.623 -0400", hash_original_method = "039CEFCC208866EAEA17CE6A32A74892", hash_generated_method = "A5341ED418AA743A100CA304E4B11E95")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            boolean[] value;
            int unusedBits;
            unusedBits = in.buffer[in.contentOffset];
            int bitsNumber;
            bitsNumber = (in.length - 1) * 8 - unusedBits;
            {
                {
                    value = new boolean[bitsNumber];
                } //End block
                {
                    {
                        value = new boolean[bitsNumber];
                    } //End block
                    {
                        value = new boolean[minBits];
                    } //End block
                } //End block
            } //End block
            {
                {
                	if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 Named Bitstring: size constraints");
                } //End block
                value = new boolean[maxBits];
            } //End block
            int i;
            i = 1;
            int j;
            j = 0;
            byte octet;
            octet = in.buffer[in.contentOffset + i];
            {
                int size;
                size = in.length - 1;
                {
                    {
                        int k;
                        k = 0;
                        {
                            value[j] = (SET_MASK[k] & octet) != 0;
                        } //End block
                    } //End collapsed parenthetic
                    i++;
                    octet = in.buffer[in.contentOffset + i];
                } //End block
            } //End collapsed parenthetic
            {
                int k;
                k = 0;
                {
                    value[j] = (SET_MASK[k] & octet) != 0;
                } //End block
            } //End collapsed parenthetic
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.624 -0400", hash_original_method = "41EEFA120EBBC70AD57105C61092B6CF", hash_generated_method = "F550E7F6564BBE254174F5AECFBD3100")
        @DSModeled(DSC.SAFE)
        @Override
        public void setEncodingContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            boolean[] toEncode;
            toEncode = (boolean[]) out.content;
            int index;
            index = toEncode.length - 1;
            {
                index--;
            } //End block
            {
                out.content = emptyString;
                out.length = 1;
            } //End block
            {
                int unusedBits;
                unusedBits = 7 - index % 8;
                byte[] bytes;
                bytes = new byte[index / 8 + 1];
                int j;
                j = 0;
                index = bytes.length - 1;
                {
                    int i;
                    i = 0;
                    {
                        {
                            int k;
                            k = 0;
                            {
                                {
                                    bytes[i] = (byte) (bytes[i] | SET_MASK[k]);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    int k;
                    k = 0;
                    {
                        {
                            bytes[index] = (byte) (bytes[index] | SET_MASK[k]);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                out.content = new BitString(bytes, unusedBits);
                out.length = bytes.length + 1;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}


