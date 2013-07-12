package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class ASN1Oid extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.657 -0400", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "5EE615B9F25ED765F08A7690EA0EA432")
    public  ASN1Oid() {
        super(TAG_OID);
        // ---------- Original Method ----------
    }

    
        public static ASN1Oid getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.657 -0400", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "DD5431F7897BED749A8C27C8950374E7")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readOID();
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_474582724 =             null;
            var540C13E9E156B687226421B24F2DF178_474582724.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_474582724;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_631293542 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_631293542.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_631293542;
        // ---------- Original Method ----------
        //in.readOID();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.659 -0400", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "E0009DB2D444CD7456920816811CA3C6")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        int oidElement = in.oidElement;
        int[] oid = new int[oidElement];
for(int id = 1, i = 0;id < oid.length;id++,i++)
        {
            int octet = in.buffer[in.contentOffset + i];
            oidElement = octet & 0x7F;
            while
((octet & 0x80) != 0)            
            {
                i++;
                octet = in.buffer[in.contentOffset + i];
                oidElement = oidElement << 7 | (octet & 0x7f);
            } //End block
            oid[id] = oidElement;
        } //End block
    if(oid[1] > 79)        
        {
            oid[0] = 2;
            oid[1] = oid[1] - 80;
        } //End block
        else
        {
            oid[0] = oid[1] / 40;
            oid[1] = oid[1] % 40;
        } //End block
Object var6EE0E520E830DF58CC7591C0A7BECFB6_54025979 =         oid;
        var6EE0E520E830DF58CC7591C0A7BECFB6_54025979.addTaint(taint);
        return var6EE0E520E830DF58CC7591C0A7BECFB6_54025979;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.659 -0400", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "CCA01931BD8DFF43CF235A94311C1003")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeOID();
        // ---------- Original Method ----------
        //out.encodeOID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.660 -0400", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "AA8F06F23BB1045643198CC6D3E70EA0")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        int[] oid = (int[]) out.content;
        int length = 0;
        int elem = oid[0] * 40 + oid[1];
    if(elem == 0)        
        {
            length = 1;
        } //End block
        else
        {
for(;elem > 0;elem = elem >> 7)
            {
                length++;
            } //End block
        } //End block
for(int i = 2;i < oid.length;i++)
        {
    if(oid[i] == 0)            
            {
                length++;
                continue;
            } //End block
for(elem = oid[i];elem > 0;elem = elem >> 7)
            {
                length++;
            } //End block
        } //End block
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

    
        public static ASN1Oid getInstanceForString() {
        return STRING_OID;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.661 -0400", hash_original_field = "D50A76961EC7FDB68B43778986BD2D19", hash_generated_field = "67D6F26FD049FE76173416774B5BEB68")

    private static final ASN1Oid ASN1 = new ASN1Oid();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.597 -0400", hash_original_field = "A17235E1E62013241F58D7FEA3397ABE", hash_generated_field = "7C71E1FAB479FEB541AEBE0F6A00EF0D")

    private static final ASN1Oid STRING_OID = new ASN1Oid() {        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.596 -0400", hash_original_method = "EDD14D755051A488C2BFB6BEA216DB71", hash_generated_method = "AC1548FB73DFF4CDEBD6C8414C8C66BC")
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1332120319 = null; 
            StringBuilder buf = new StringBuilder();
            int octet = in.buffer[in.contentOffset];
            int element = octet & 0x7F;
            int index = 0;
            {
                octet = in.buffer[in.contentOffset + index];
                element = element << 7 | (octet & 0x7F);
            } 
            {
                buf.append('2');
                buf.append('.');
                buf.append(element - 80);
            } 
            {
                buf.append(element / 40);
                buf.append('.');
                buf.append(element % 40);
            } 
            {
                int j = 2;
                {
                    buf.append('.');
                    octet = in.buffer[in.contentOffset + index];
                    element = octet & 0x7F;
                    {
                        octet = in.buffer[in.contentOffset + index];
                        element = element << 7 | (octet & 0x7f);
                    } 
                    buf.append(element);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1332120319 = buf.toString();
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1332120319.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1332120319;
            
            
        }

        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.596 -0400", hash_original_method = "CDC9ED6FAB1ED0D19929BE7F36D72557", hash_generated_method = "1BFE9E939832A0646316571B458221A0")
        @Override
        public void setEncodingContent(BerOutputStream out) {
            out.content = ObjectIdentifier.toIntArray((String) out.content);
            super.setEncodingContent(out);
            addTaint(out.getTaint());
            
            
            
        }

        
};
}

