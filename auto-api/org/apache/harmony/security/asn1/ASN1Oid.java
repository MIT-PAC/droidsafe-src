package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1Oid extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.379 -0400", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "5EE615B9F25ED765F08A7690EA0EA432")
    public  ASN1Oid() {
        super(TAG_OID);
        // ---------- Original Method ----------
    }

    
        public static ASN1Oid getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.380 -0400", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "4609DB6135487AE4405DF5EF37A26E83")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_148209280 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1914277046 = null; //Variable for return #2
        in.readOID();
        {
            varB4EAC82CA7396A68D541C85D26508E83_148209280 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1914277046 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1425647343; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1425647343 = varB4EAC82CA7396A68D541C85D26508E83_148209280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1425647343 = varB4EAC82CA7396A68D541C85D26508E83_1914277046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1425647343.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1425647343;
        // ---------- Original Method ----------
        //in.readOID();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.399 -0400", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "BD2088F97DC3BF673C95573C507427EB")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_174425132 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_174425132 = oid;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_174425132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_174425132;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.399 -0400", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "3D5FB7A6CBD315FC4B0E01666B095C05")
    public void encodeContent(BerOutputStream out) {
        out.encodeOID();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeOID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.401 -0400", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "8008C1624514B2CC6574BA8AB9BA4885")
    public void setEncodingContent(BerOutputStream out) {
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
            } //End collapsed parenthetic
        } //End block
        {
            int i;
            i = 2;
            {
                {
                    elem = oid[i];
                    elem = elem >> 7;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        out.length = length;
        addTaint(out.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.401 -0400", hash_original_field = "D50A76961EC7FDB68B43778986BD2D19", hash_generated_field = "1A6018AB71185A90855C47B469E88FF2")

    private static ASN1Oid ASN1 = new ASN1Oid();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.421 -0400", hash_original_field = "A17235E1E62013241F58D7FEA3397ABE", hash_generated_field = "78677887A8BC3DCE2C6D8FAC594DEABD")

    private static ASN1Oid STRING_OID = new ASN1Oid() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.420 -0400", hash_original_method = "EDD14D755051A488C2BFB6BEA216DB71", hash_generated_method = "8B708ADFBF62E8E328EB186C4843E3D4")
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_2114767923 = null; //Variable for return #1
            StringBuilder buf;
            buf = new StringBuilder();
            int octet;
            octet = in.buffer[in.contentOffset];
            int element;
            element = octet & 0x7F;
            int index;
            index = 0;
            {
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
                    octet = in.buffer[in.contentOffset + index];
                    element = octet & 0x7F;
                    {
                        octet = in.buffer[in.contentOffset + index];
                        element = element << 7 | (octet & 0x7f);
                    } //End block
                    buf.append(element);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2114767923 = buf.toString();
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2114767923.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2114767923;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.421 -0400", hash_original_method = "CDC9ED6FAB1ED0D19929BE7F36D72557", hash_generated_method = "1BFE9E939832A0646316571B458221A0")
        @Override
        public void setEncodingContent(BerOutputStream out) {
            out.content = ObjectIdentifier.toIntArray((String) out.content);
            super.setEncodingContent(out);
            addTaint(out.getTaint());
            // ---------- Original Method ----------
            //out.content = ObjectIdentifier.toIntArray((String) out.content);
            //super.setEncodingContent(out);
        }

        
};
}

