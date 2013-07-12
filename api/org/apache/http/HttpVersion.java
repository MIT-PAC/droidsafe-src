package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public final class HttpVersion extends ProtocolVersion implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.921 -0400", hash_original_method = "150D62CB24782FBFD68E18019E7202DB", hash_generated_method = "5A98695477A818F3B86276B2130B84D6")
    public  HttpVersion(int major, int minor) {
        super(HTTP, major, minor);
        addTaint(minor);
        addTaint(major);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.921 -0400", hash_original_method = "102B5DD63D8812CA09E006716DE254FA", hash_generated_method = "51DFF82EAB52EFB6CFA66613B432F26E")
    public ProtocolVersion forVersion(int major, int minor) {
        addTaint(minor);
        addTaint(major);
    if((major == this.major) && (minor == this.minor))        
        {
ProtocolVersion var72A74007B2BE62B849F475C7BDA4658B_1380326068 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1380326068.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1380326068;
        } 
    if(major == 1)        
        {
    if(minor == 0)            
            {
ProtocolVersion var5EEF0429DA9861C325774B40B1988C10_1198535701 =                 HTTP_1_0;
                var5EEF0429DA9861C325774B40B1988C10_1198535701.addTaint(taint);
                return var5EEF0429DA9861C325774B40B1988C10_1198535701;
            } 
    if(minor == 1)            
            {
ProtocolVersion var538DF995AF12E5D64EEE991AADA55B15_1202516356 =                 HTTP_1_1;
                var538DF995AF12E5D64EEE991AADA55B15_1202516356.addTaint(taint);
                return var538DF995AF12E5D64EEE991AADA55B15_1202516356;
            } 
        } 
    if((major == 0) && (minor == 9))        
        {
ProtocolVersion var0DFF6ED6E4AEC821AD210B8B263E0B40_1801230595 =             HTTP_0_9;
            var0DFF6ED6E4AEC821AD210B8B263E0B40_1801230595.addTaint(taint);
            return var0DFF6ED6E4AEC821AD210B8B263E0B40_1801230595;
        } 
ProtocolVersion varDC7E309066B4DB283EFEDC0B8DEBBD39_1273141414 =         new HttpVersion(major, minor);
        varDC7E309066B4DB283EFEDC0B8DEBBD39_1273141414.addTaint(taint);
        return varDC7E309066B4DB283EFEDC0B8DEBBD39_1273141414;
        
        
            
        
        
            
                
            
            
                
            
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.922 -0400", hash_original_field = "D2B91B05E2609572189EF6CCE02A44D3", hash_generated_field = "4AA18FBAD714C83CF6883EBA6D23F39C")

    private static final long serialVersionUID = -5856653513894415344L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.922 -0400", hash_original_field = "5BC6464C73A79B42771FD59D331B1E8E", hash_generated_field = "BD0B770B1DA58B440FD2A9FDBB7EFD6F")

    public static final String HTTP = "HTTP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.922 -0400", hash_original_field = "7DA3371948BD80535FAFD5437F115A9E", hash_generated_field = "F13F8B26DBE79268EEE81DDB7ABECF4F")

    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.922 -0400", hash_original_field = "793E47850E63B266B1ABA0AB1FF24EE7", hash_generated_field = "16A7185B0988E5CE22D3E365290FDDBF")

    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.922 -0400", hash_original_field = "B3E73FA4EB1CB3473D353EBAE8B995B4", hash_generated_field = "E158A70472CF43C3AF1C153DDD6B4EF4")

    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
}

