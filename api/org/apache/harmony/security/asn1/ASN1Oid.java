package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public class ASN1Oid extends ASN1Primitive {

    /**
     * Returns ASN.1 Object Identifier type default implementation
     *
     * The default implementation works with encoding
     * that is represented as array of integers.
     *
     * @return ASN.1 Object Identifier type default implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.205 -0500", hash_original_method = "5E65A7295BE5D2F9170BAE5522B68E33", hash_generated_method = "1F1BE41A3621422B13C5D1294D1E6378")
    
public static ASN1Oid getInstance() {
        return ASN1;
    }

    /**
     * Returns ASN.1 Object Identifier type implementation
     *
     * This implementation works with encoding
     * that is mapped to java.lang.String object.
     *
     * @return ASN.1 Object Identifier type implementation
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.228 -0500", hash_original_method = "DE949297883E398E1EB4558C161D2578", hash_generated_method = "393C765E8DA9FA6B1298E887F199D60F")
    
public static ASN1Oid getInstanceForString() {
        return STRING_OID;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.199 -0500", hash_original_field = "F3A0F319DC5F03170274C5163D2FD8DB", hash_generated_field = "67D6F26FD049FE76173416774B5BEB68")

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

    /**
     * Constructs ASN.1 Object Identifier type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 Object Identifier type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.203 -0500", hash_original_method = "8EE7336DC066715E76590AA2BFCE7307", hash_generated_method = "68B37FC2A9638E2A5864F88359CE5FCA")
    
public ASN1Oid() {
        super(TAG_OID);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.207 -0500", hash_original_method = "3D94E48E0DC6BD33E3C9167EF5944677", hash_generated_method = "DACE7F80FA7E1155B471E3DD28D723C1")
    
public Object decode(BerInputStream in) throws IOException {
        in.readOID();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    /**
     * Extracts array of integers from BER input stream.
     *
     * @return array of integers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.210 -0500", hash_original_method = "F2E30F5A7FF0BD89B1DBA25737A1DD6D", hash_generated_method = "2DECE60E03D737615DA7DCAC4AF316F8")
    
@Override public Object getDecodedObject(BerInputStream in) throws IOException {
        // Allocate and decode
        int oidElement = in.oidElement;
        int[] oid = new int[oidElement];
        for (int id = 1, i = 0; id < oid.length; id++, i++) {
            int octet = in.buffer[in.contentOffset + i];
            oidElement = octet & 0x7F;
            while ((octet & 0x80) != 0) {
                i++;
                octet = in.buffer[in.contentOffset + i];
                oidElement = oidElement << 7 | (octet & 0x7f);
            }
            oid[id] = oidElement;
        }
        // Special handling for the first packed OID element
        if (oid[1] > 79) {
            oid[0] = 2;
            oid[1] = oid[1] - 80;
        } else {
            oid[0] = oid[1] / 40;
            oid[1] = oid[1] % 40;
        }
        return oid;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.212 -0500", hash_original_method = "2B9753A86B000221B8C7FE7F76F39078", hash_generated_method = "0F2D3B5DB62D81567C712329EAC4451C")
    
public void encodeContent(BerOutputStream out) {
        out.encodeOID();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:50.215 -0500", hash_original_method = "EFEF2EC121CF26DF89AF9E72AC4EE02E", hash_generated_method = "BFE853E80F39183052429A83100ADDCB")
    
public void setEncodingContent(BerOutputStream out) {
        int[] oid = (int[]) out.content;

        int length = 0;

        // first subidentifier
        int elem = oid[0] * 40 + oid[1];
        if (elem == 0) {
            length = 1;
        } else {
            for (; elem > 0; elem = elem >> 7) {
                length++;
            }
        }

        // the rest of subidentifiers
        for (int i = 2; i < oid.length; i++) {
            if (oid[i] == 0) {
                length++;
                continue;
            }
            for (elem = oid[i]; elem > 0; elem = elem >> 7) {
                length++;
            }
        }
        out.length = length;
    }
}

