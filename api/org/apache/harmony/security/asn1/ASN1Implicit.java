package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public final class ASN1Implicit extends ASN1Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.527 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "97A5429C38872EFB5A45FC680B4DDEE1")

    private ASN1Type type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.527 -0400", hash_original_field = "D1A49B1D6CCB03EA6713AD822A73052F", hash_generated_field = "5F27CEAB9F1A8FD006A951F92DDD6657")

    private int taggingType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.528 -0400", hash_original_method = "885EAD88CE0EDAA6AE8B231FCD302B70", hash_generated_method = "C123286DF8C880CF7F5CC8925E8025C4")
    public  ASN1Implicit(int tagNumber, ASN1Type type) {
        super(CLASS_CONTEXTSPECIFIC, tagNumber);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        } 
        this.type = type;
        {
            boolean var7D16F4D21FCDA7B88995592766A30F11_138514530 = (type.checkTag(type.id));
            {
                {
                    boolean var198894DB5720C5DF4565C2CB8C2924C0_1379585915 = (type.checkTag(type.constrId));
                    {
                        taggingType = TAGGING_STRING;
                    } 
                    {
                        taggingType = TAGGING_PRIMITIVE;
                    } 
                } 
            } 
            {
                taggingType = TAGGING_CONSTRUCTED;
            } 
        } 
        addTaint(tagNumber);
        
        
            
        
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.528 -0400", hash_original_method = "D92B272BF30997E81DA1469852FE3C4F", hash_generated_method = "595720F65C3F1D11B671DE75E915D99E")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2133216515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2133216515;
        
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.531 -0400", hash_original_method = "7AB778F30F3F4E1DD4EDD8138709F383", hash_generated_method = "A99129BF57014A6E60F6CB256E56AFB2")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_803392947 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1925252329 = null; 
        {
            boolean var766EA6E7D31783D8197180D70708A15A_332230238 = (!checkTag(in.tag));
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    "[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    "but got " + Integer.toHexString(in.tag));
            } 
        } 
        {
            in.tag = type.id;
        } 
        {
            in.tag = type.constrId;
        } 
        in.content = type.decode(in);
        {
            varB4EAC82CA7396A68D541C85D26508E83_803392947 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1925252329 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1824568352; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1824568352 = varB4EAC82CA7396A68D541C85D26508E83_803392947;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1824568352 = varB4EAC82CA7396A68D541C85D26508E83_1925252329;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1824568352.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1824568352;
        
        
            
                    
                    
        
        
            
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.532 -0400", hash_original_method = "5EC2F9C60EB654B91B6E1D4F997368F9", hash_generated_method = "CC3D3DA42FE0B58BBBF7DFEE1F37C190")
    public void encodeASN(BerOutputStream out) {
        {
            out.encodeTag(constrId);
        } 
        {
            out.encodeTag(id);
        } 
        encodeContent(out);
        addTaint(out.getTaint());
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.533 -0400", hash_original_method = "774C00840199094903FD771E0305B5DA", hash_generated_method = "B634C0F6CFCE72DC7759DA451C566F15")
    public void encodeContent(BerOutputStream out) {
        type.encodeContent(out);
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.533 -0400", hash_original_method = "142D84AECEAB554A6A5BF2DED12EF71F", hash_generated_method = "C766A6615417BC63F27B41B692AEF6AF")
    public void setEncodingContent(BerOutputStream out) {
        type.setEncodingContent(out);
        addTaint(out.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.533 -0400", hash_original_field = "FB409548849E29986196ACFE45A33892", hash_generated_field = "FC708BB1AC854A91B7DCE6A8ABC2B9F8")

    private static final int TAGGING_PRIMITIVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.533 -0400", hash_original_field = "19C39931BDB0B9C880D081A28C29320F", hash_generated_field = "C4E8C04A9E28482ED140EBA565FF4791")

    private static final int TAGGING_CONSTRUCTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.533 -0400", hash_original_field = "CE1A7680B2ACB1874B766B87BC3FC771", hash_generated_field = "198AE5437257AB4D73B54A6904A66837")

    private static final int TAGGING_STRING = 2;
}

