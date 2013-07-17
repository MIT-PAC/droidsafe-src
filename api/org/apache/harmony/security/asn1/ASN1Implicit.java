package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public final class ASN1Implicit extends ASN1Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.318 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "97A5429C38872EFB5A45FC680B4DDEE1")

    private ASN1Type type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.318 -0400", hash_original_field = "D1A49B1D6CCB03EA6713AD822A73052F", hash_generated_field = "5F27CEAB9F1A8FD006A951F92DDD6657")

    private int taggingType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.319 -0400", hash_original_method = "885EAD88CE0EDAA6AE8B231FCD302B70", hash_generated_method = "EE0334A70E2F7916172C75D0B2C91EB7")
    public  ASN1Implicit(int tagNumber, ASN1Type type) {
        super(CLASS_CONTEXTSPECIFIC, tagNumber);
        addTaint(tagNumber);
        if((type instanceof ASN1Choice) || (type instanceof ASN1Any))        
        {
            IllegalArgumentException var9BEB172156F000642F9EFA4B65B94FA0_790887416 = new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
            var9BEB172156F000642F9EFA4B65B94FA0_790887416.addTaint(taint);
            throw var9BEB172156F000642F9EFA4B65B94FA0_790887416;
        } //End block
        this.type = type;
        if(type.checkTag(type.id))        
        {
            if(type.checkTag(type.constrId))            
            {
                taggingType = TAGGING_STRING;
            } //End block
            else
            {
                taggingType = TAGGING_PRIMITIVE;
            } //End block
        } //End block
        else
        {
            taggingType = TAGGING_CONSTRUCTED;
        } //End block
        // ---------- Original Method ----------
        //if ((type instanceof ASN1Choice) || (type instanceof ASN1Any)) {
            //throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        //}
        //this.type = type;
        //if (type.checkTag(type.id)) {
            //if (type.checkTag(type.constrId)) {
                //taggingType = TAGGING_STRING;
            //} else {
                //taggingType = TAGGING_PRIMITIVE;
            //}
        //} else {
            //taggingType = TAGGING_CONSTRUCTED;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.320 -0400", hash_original_method = "D92B272BF30997E81DA1469852FE3C4F", hash_generated_method = "5F6305743E8EBD2B13F76B265DFC66BD")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
switch(taggingType){
        case TAGGING_PRIMITIVE:
        boolean var059F0BC140DC22147067E95C6A163F73_896161547 = (id == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104192743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104192743;
        case TAGGING_CONSTRUCTED:
        boolean varE5CB062431BDDD9F33EB46F9EEFEE327_1666847155 = (constrId == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379926185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_379926185;
        default:
        boolean var6E228E0A69B3234996D00B3964901571_973025336 = (id == identifier || constrId == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143332379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143332379;
}
        // ---------- Original Method ----------
        //switch (taggingType) {
        //case TAGGING_PRIMITIVE:
            //return id == identifier;
        //case TAGGING_CONSTRUCTED:
            //return constrId == identifier;
        //default: 
            //return id == identifier || constrId == identifier;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.321 -0400", hash_original_method = "7AB778F30F3F4E1DD4EDD8138709F383", hash_generated_method = "3988A32C82BB61D8E130381331D298E0")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        if(!checkTag(in.tag))        
        {
            ASN1Exception var61912881525C5A231FE75D3C60EB7BAC_161602911 = new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    "[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    "but got " + Integer.toHexString(in.tag));
            var61912881525C5A231FE75D3C60EB7BAC_161602911.addTaint(taint);
            throw var61912881525C5A231FE75D3C60EB7BAC_161602911;
        } //End block
        if(id == in.tag)        
        {
            in.tag = type.id;
        } //End block
        else
        {
            in.tag = type.constrId;
        } //End block
        in.content = type.decode(in);
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1325270203 =             null;
            var540C13E9E156B687226421B24F2DF178_1325270203.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1325270203;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_53537010 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_53537010.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_53537010;
        // ---------- Original Method ----------
        //if (!checkTag(in.tag)) {
            //throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    //"[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    //"but got " + Integer.toHexString(in.tag));
        //}
        //if (id == in.tag) {
            //in.tag = type.id;
        //} else {
            //in.tag = type.constrId;
        //}
        //in.content = type.decode(in);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.322 -0400", hash_original_method = "5EC2F9C60EB654B91B6E1D4F997368F9", hash_generated_method = "8CBF357A56966242D0AC2E0008F40DC2")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        if(taggingType == TAGGING_CONSTRUCTED)        
        {
            out.encodeTag(constrId);
        } //End block
        else
        {
            out.encodeTag(id);
        } //End block
        encodeContent(out);
        // ---------- Original Method ----------
        //if (taggingType == TAGGING_CONSTRUCTED) {
            //out.encodeTag(constrId);
        //} else {
            //out.encodeTag(id);
        //}
        //encodeContent(out);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.322 -0400", hash_original_method = "774C00840199094903FD771E0305B5DA", hash_generated_method = "9C6475215BD1A1A441F56AB78292F79C")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        type.encodeContent(out);
        // ---------- Original Method ----------
        //type.encodeContent(out);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.323 -0400", hash_original_method = "142D84AECEAB554A6A5BF2DED12EF71F", hash_generated_method = "CD9684C32726C8F3F3E2ECE3E4486B3F")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        type.setEncodingContent(out);
        // ---------- Original Method ----------
        //type.setEncodingContent(out);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.323 -0400", hash_original_field = "FB409548849E29986196ACFE45A33892", hash_generated_field = "FC708BB1AC854A91B7DCE6A8ABC2B9F8")

    private static final int TAGGING_PRIMITIVE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.323 -0400", hash_original_field = "19C39931BDB0B9C880D081A28C29320F", hash_generated_field = "C4E8C04A9E28482ED140EBA565FF4791")

    private static final int TAGGING_CONSTRUCTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.323 -0400", hash_original_field = "CE1A7680B2ACB1874B766B87BC3FC771", hash_generated_field = "198AE5437257AB4D73B54A6904A66837")

    private static final int TAGGING_STRING = 2;
}

