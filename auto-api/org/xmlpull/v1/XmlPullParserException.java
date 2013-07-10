package org.xmlpull.v1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class XmlPullParserException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.117 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "EDAD1988191BC8FE2A32ADF91A96320C")

    protected Throwable detail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.117 -0400", hash_original_field = "22776FFD2C63CB4C7CEDBC66AF6F6A56", hash_generated_field = "156AAEA15ABF3CBA31DAC677D9612539")

    protected int row = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.117 -0400", hash_original_field = "B3A19A47A90FB8C09BFA54CBD0EAC83C", hash_generated_field = "A5B3244522132AF33705DB6C2189351A")

    protected int column = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.117 -0400", hash_original_method = "81C346207A813FD28C849879E7041B6E", hash_generated_method = "B09839E492214B3948379BFD0CEB6868")
    public  XmlPullParserException(String s) {
        super(s);
        addTaint(s.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.118 -0400", hash_original_method = "28FAE29CB2E621B52838DE3161E10D49", hash_generated_method = "702DDD54A322997A4CC30F68A68CD103")
    public  XmlPullParserException(String msg, XmlPullParser parser, Throwable chain) {
        super ((msg == null ? "" : msg+" ")
               + (parser == null ? "" : "(position:"+parser.getPositionDescription()+") ")
               + (chain == null ? "" : "caused by: "+chain));
        {
            this.row = parser.getLineNumber();
            this.column = parser.getColumnNumber();
        } 
        this.detail = chain;
        addTaint(msg.getTaint());
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.118 -0400", hash_original_method = "94BA5080D380911C58CAC3733D4C69AF", hash_generated_method = "309F9176AC836BE21A9B19E0834C91A5")
    public Throwable getDetail() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1212704699 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1212704699 = detail;
        varB4EAC82CA7396A68D541C85D26508E83_1212704699.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1212704699;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.118 -0400", hash_original_method = "0760FB4E162E5971E2E765B2D1FE0093", hash_generated_method = "ED79BDD18F232C9A7903B6A1CD6B7047")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599705852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599705852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.119 -0400", hash_original_method = "52272B3AE5723072E22E93854866B927", hash_generated_method = "A27C417950D7F6CA057495C2617913A2")
    public int getColumnNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147107571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2147107571;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.119 -0400", hash_original_method = "5154476310B69FA819C717F88BC0BDF0", hash_generated_method = "BAFCA4B04999A280CFE0860DB3B9FE41")
    public void printStackTrace() {
        {
            super.printStackTrace();
        } 
        {
            {
                System.err.println(super.getMessage() + "; nested exception is:");
                detail.printStackTrace();
            } 
        } 
        
        
            
        
            
                
                
            
        
    }

    
}

