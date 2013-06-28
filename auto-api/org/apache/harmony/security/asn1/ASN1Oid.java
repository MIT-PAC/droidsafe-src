package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1Oid extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.590 -0400", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "5EE615B9F25ED765F08A7690EA0EA432")
    public  ASN1Oid() {
        super(TAG_OID);
        // ---------- Original Method ----------
    }

    
    public static ASN1Oid getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.591 -0400", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "3AEE50404A79B2B37F07B5FB65422915")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_952946386 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_2131294019 = null; //Variable for return #2
        in.readOID();
        {
            varB4EAC82CA7396A68D541C85D26508E83_952946386 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2131294019 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_26472351; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_26472351 = varB4EAC82CA7396A68D541C85D26508E83_952946386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_26472351 = varB4EAC82CA7396A68D541C85D26508E83_2131294019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_26472351.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_26472351;
        // ---------- Original Method ----------
        //in.readOID();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.592 -0400", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "B427C4888E0AA29F6FF209F6B3544B26")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1653387474 = null; //Variable for return #1
        int oidElement = in.oidElement;
        int[] oid = new int[oidElement];
        {
            int id = 1;
            int i = 0;
            {
                int octet = in.buffer[in.contentOffset + i];
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
        varB4EAC82CA7396A68D541C85D26508E83_1653387474 = oid;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1653387474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1653387474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.592 -0400", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "3D5FB7A6CBD315FC4B0E01666B095C05")
    public void encodeContent(BerOutputStream out) {
        out.encodeOID();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeOID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.594 -0400", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "20BA670D1328AD5E018A06311CBB63D5")
    public void setEncodingContent(BerOutputStream out) {
        int[] oid = (int[]) out.content;
        int length = 0;
        int elem = oid[0] * 40 + oid[1];
        {
            length = 1;
        } //End block
        {
            {
                elem = elem >> 7;
            } //End collapsed parenthetic
        } //End block
        {
            int i = 2;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.594 -0400", hash_original_field = "D50A76961EC7FDB68B43778986BD2D19", hash_generated_field = "67D6F26FD049FE76173416774B5BEB68")

    private static final ASN1Oid ASN1 = new ASN1Oid();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.597 -0400", hash_original_field = "A17235E1E62013241F58D7FEA3397ABE", hash_generated_field = "7C71E1FAB479FEB541AEBE0F6A00EF0D")

    private static final ASN1Oid STRING_OID = new ASN1Oid() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.596 -0400", hash_original_method = "EDD14D755051A488C2BFB6BEA216DB71", hash_generated_method = "AC1548FB73DFF4CDEBD6C8414C8C66BC")
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1332120319 = null; //Variable for return #1
            StringBuilder buf = new StringBuilder();
            int octet = in.buffer[in.contentOffset];
            int element = octet & 0x7F;
            int index = 0;
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
                int j = 2;
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
            varB4EAC82CA7396A68D541C85D26508E83_1332120319 = buf.toString();
            addTaint(in.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1332120319.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1332120319;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.596 -0400", hash_original_method = "CDC9ED6FAB1ED0D19929BE7F36D72557", hash_generated_method = "1BFE9E939832A0646316571B458221A0")
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

