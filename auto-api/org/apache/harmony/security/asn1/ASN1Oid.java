package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class ASN1Oid extends ASN1Primitive {
    private static final ASN1Oid ASN1 = new ASN1Oid();
    private static final ASN1Oid STRING_OID = new ASN1Oid() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "EDD14D755051A488C2BFB6BEA216DB71", hash_generated_method = "B3ABCB58339DD1BCDF2B27B7DF2604B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            StringBuilder buf;
            buf = new StringBuilder();
            int octet;
            octet = in.buffer[in.contentOffset];
            int element;
            element = octet & 0x7F;
            int index;
            index = 0;
            {
                index++;
                octet = in.buffer[in.contentOffset + index];
                element = element << 7 | (octet & 0x7F);
            } //End block
            {
                buf.append('2');
                buf.append('.');
                buf.append(element - 80);
            } //End block
            {
                buf.append(element / 40);
                buf.append('.');
                buf.append(element % 40);
            } //End block
            {
                int j;
                j = 2;
                {
                    buf.append('.');
                    index++;
                    octet = in.buffer[in.contentOffset + index];
                    element = octet & 0x7F;
                    {
                        index++;
                        octet = in.buffer[in.contentOffset + index];
                        element = element << 7 | (octet & 0x7f);
                    } //End block
                    buf.append(element);
                } //End block
            } //End collapsed parenthetic
            Object var2557D01FB48266732A30DA13EA1C8FCE_1107344774 = (buf.toString());
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "CDC9ED6FAB1ED0D19929BE7F36D72557", hash_generated_method = "4EE1D72503E5E308119954427B9B5ECC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setEncodingContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            out.content = ObjectIdentifier.toIntArray((String) out.content);
            super.setEncodingContent(out);
            // ---------- Original Method ----------
            //out.content = ObjectIdentifier.toIntArray((String) out.content);
            //super.setEncodingContent(out);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "71B3D97DCD15AC82D3C4535418BEAD54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Oid() {
        super(TAG_OID);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "5E65A7295BE5D2F9170BAE5522B68E33", hash_generated_method = "1F1BE41A3621422B13C5D1294D1E6378")
    public static ASN1Oid getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "C7F59880E6629D5C4BD68A55900D8B6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readOID();
        Object var883E4A51D9FE1FCA5622395E00C94DE9_20420642 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readOID();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.649 -0400", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "0799E0691811B325297924CF57F47659")
    @DSModeled(DSC.SAFE)
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        int oidElement;
        oidElement = in.oidElement;
        int[] oid;
        oid = new int[oidElement];
        {
            int id, i;
            id = 1;
            i = 0;
            {
                int octet;
                octet = in.buffer[in.contentOffset + i];
                oidElement = octet & 0x7F;
                {
                    i++;
                    octet = in.buffer[in.contentOffset + i];
                    oidElement = oidElement << 7 | (octet & 0x7f);
                } //End block
                oid[id] = oidElement;
            } //End block
        } //End collapsed parenthetic
        {
            oid[0] = 2;
            oid[1] = oid[1] - 80;
        } //End block
        {
            oid[0] = oid[1] / 40;
            oid[1] = oid[1] % 40;
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int oidElement = in.oidElement;
        //int[] oid = new int[oidElement];
        //for (int id = 1, i = 0; id < oid.length; id++, i++) {
            //int octet = in.buffer[in.contentOffset + i];
            //oidElement = octet & 0x7F;
            //while ((octet & 0x80) != 0) {
                //i++;
                //octet = in.buffer[in.contentOffset + i];
                //oidElement = oidElement << 7 | (octet & 0x7f);
            //}
            //oid[id] = oidElement;
        //}
        //if (oid[1] > 79) {
            //oid[0] = 2;
            //oid[1] = oid[1] - 80;
        //} else {
            //oid[0] = oid[1] / 40;
            //oid[1] = oid[1] % 40;
        //}
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.650 -0400", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "2BB91D903898B6CD65C9F32014244385")
    @DSModeled(DSC.SAFE)
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeOID();
        // ---------- Original Method ----------
        //out.encodeOID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.650 -0400", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "7BD9108AC0F2725BD5F778340DE027F0")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        int[] oid;
        oid = (int[]) out.content;
        int length;
        length = 0;
        int elem;
        elem = oid[0] * 40 + oid[1];
        {
            length = 1;
        } //End block
        {
            {
                elem = elem >> 7;
                {
                    length++;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int i;
            i = 2;
            {
                {
                    length++;
                } //End block
                {
                    elem = oid[i];
                    elem = elem >> 7;
                    {
                        length++;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        out.length = length;
        // ---------- Original Method ----------
        //int[] oid = (int[]) out.content;
        //int length = 0;
        //int elem = oid[0] * 40 + oid[1];
        //if (elem == 0) {
            //length = 1;
        //} else {
            //for (; elem > 0; elem = elem >> 7) {
                //length++;
            //}
        //}
        //for (int i = 2; i < oid.length; i++) {
            //if (oid[i] == 0) {
                //length++;
                //continue;
            //}
            //for (elem = oid[i]; elem > 0; elem = elem >> 7) {
                //length++;
            //}
        //}
        //out.length = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.650 -0400", hash_original_method = "DE949297883E398E1EB4558C161D2578", hash_generated_method = "393C765E8DA9FA6B1298E887F199D60F")
    public static ASN1Oid getInstanceForString() {
        return STRING_OID;
    }

    
}


