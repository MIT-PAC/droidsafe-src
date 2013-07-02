package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class ASN1Oid extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.590 -0400", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "5EE615B9F25ED765F08A7690EA0EA432")
    public  ASN1Oid() {
        super(TAG_OID);
        
    }

    
    public static ASN1Oid getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.591 -0400", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "3AEE50404A79B2B37F07B5FB65422915")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_952946386 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2131294019 = null; 
        in.readOID();
        {
            varB4EAC82CA7396A68D541C85D26508E83_952946386 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2131294019 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_26472351; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_26472351 = varB4EAC82CA7396A68D541C85D26508E83_952946386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_26472351 = varB4EAC82CA7396A68D541C85D26508E83_2131294019;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_26472351.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_26472351;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.592 -0400", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "B427C4888E0AA29F6FF209F6B3544B26")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1653387474 = null; 
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
                } 
                oid[id] = oidElement;
            } 
        } 
        {
            oid[0] = 2;
            oid[1] = oid[1] - 80;
        } 
        {
            oid[0] = oid[1] / 40;
            oid[1] = oid[1] % 40;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1653387474 = oid;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1653387474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1653387474;
        
        
        
        
            
            
            
                
                
                
            
            
        
        
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.592 -0400", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "3D5FB7A6CBD315FC4B0E01666B095C05")
    public void encodeContent(BerOutputStream out) {
        out.encodeOID();
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.594 -0400", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "20BA670D1328AD5E018A06311CBB63D5")
    public void setEncodingContent(BerOutputStream out) {
        int[] oid = (int[]) out.content;
        int length = 0;
        int elem = oid[0] * 40 + oid[1];
        {
            length = 1;
        } 
        {
            {
                elem = elem >> 7;
            } 
        } 
        {
            int i = 2;
            {
                {
                    elem = oid[i];
                    elem = elem >> 7;
                } 
            } 
        } 
        out.length = length;
        addTaint(out.getTaint());
        
        
        
        
        
            
        
            
                
            
        
        
            
                
                
            
            
                
            
        
        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.596 -0400", hash_original_method = "CDC9ED6FAB1ED0D19929BE7F36D72557", hash_generated_method = "1BFE9E939832A0646316571B458221A0")
        @Override
        public void setEncodingContent(BerOutputStream out) {
            out.content = ObjectIdentifier.toIntArray((String) out.content);
            super.setEncodingContent(out);
            addTaint(out.getTaint());
            
            
            
        }

        
};
}

