package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.URI;
import gov.nist.javax.sip.address.*;

public class RequestLine extends SIPObject implements SipRequestLine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.073 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.073 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.073 -0400", hash_original_field = "66D2C8863084D21925D8C4AD8BD49102", hash_generated_field = "0E22CDA9223E852519CAF5EA7723F865")

    protected String sipVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.073 -0400", hash_original_method = "E4B7F4B41910EC919E5F140217342F7C", hash_generated_method = "EAF4B8E6F66C463F263AD3BE32A3D88C")
    public  RequestLine() {
        sipVersion = "SIP/2.0";
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.073 -0400", hash_original_method = "FF0843F55ACEC2A8E2B69A1885A4A70E", hash_generated_method = "94E775391CAAE4815033C54C5EEE9CB9")
    public  RequestLine(GenericURI requestURI, String method) {
        this.uri = requestURI;
        this.method = method;
        this.sipVersion = "SIP/2.0";
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.074 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "A1F8E27C772AFCAEABA4821AB533568C")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_539585277 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_539585277 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_539585277.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_539585277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.074 -0400", hash_original_method = "4F6DB28D47CD31A53DCF9FC226D5B630", hash_generated_method = "A1D05C2D5DF41A11F3FCBB13A87A4AF4")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1946005905 = null; 
        {
            buffer.append(method);
            buffer.append(SP);
        } 
        {
            uri.encode(buffer);
            buffer.append(SP);
        } 
        buffer.append(sipVersion);
        buffer.append(NEWLINE);
        varB4EAC82CA7396A68D541C85D26508E83_1946005905 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1946005905.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1946005905;
        
        
            
            
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.075 -0400", hash_original_method = "F87CE2D8FFE3E61DA8A4BD8B0BDA0697", hash_generated_method = "6C810A6E2E5090067DB9B0A6BF73B7BD")
    public GenericURI getUri() {
        GenericURI varB4EAC82CA7396A68D541C85D26508E83_295105471 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_295105471 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_295105471.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_295105471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.075 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "093DEBDCEAE0CA59538B4792E64E9063")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_382853744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_382853744 = method;
        varB4EAC82CA7396A68D541C85D26508E83_382853744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_382853744;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.075 -0400", hash_original_method = "756FD7B4E35B001597A1BAB462C97AFC", hash_generated_method = "B0FDF97E230BD31BFB1AEAE067D86930")
    public String getSipVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_457657514 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_457657514 = sipVersion;
        varB4EAC82CA7396A68D541C85D26508E83_457657514.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_457657514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.076 -0400", hash_original_method = "E1410A4CC0BAAD1440D0D1F349F6B893", hash_generated_method = "9490E77B55167E8C08B818C0A6425D28")
    public void setUri(URI uri) {
        this.uri = (GenericURI)uri;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.076 -0400", hash_original_method = "190C52163DA3AE651D57D1F9409B666E", hash_generated_method = "0A32A302E12C16AB7BD122DBD89AC3B9")
    public void setMethod(String method) {
        this.method = method;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.076 -0400", hash_original_method = "1D61DBA7A6626C97B8FBAF50D3DDD562", hash_generated_method = "5D5262EE7BD591D6E71A6ED43A58938F")
    public void setSipVersion(String version) {
        this.sipVersion = version;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.077 -0400", hash_original_method = "4D5FB483F06B9DEED18B900A5129C79B", hash_generated_method = "3B45D6CE26A326D9D9C3F7E32FEF443D")
    public String getVersionMajor() {
        String varB4EAC82CA7396A68D541C85D26508E83_1951557337 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_148264258 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1951557337 = null;
        String major = null;
        boolean slash = false;
        {
            int i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_371288790 = (i < sipVersion.length());
            {
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_1388546182 = (sipVersion.charAt(i) == '.');
                } 
                {
                    major = "" + sipVersion.charAt(i);
                    major += sipVersion.charAt(i);
                } 
                {
                    boolean var0DA5D2C2C152124EEAFDE0E0B2B4C8B3_800194436 = (sipVersion.charAt(i) == '/');
                    slash = true;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_148264258 = major;
        String varA7E53CE21691AB073D9660D615818899_1124832782; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1124832782 = varB4EAC82CA7396A68D541C85D26508E83_1951557337;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1124832782 = varB4EAC82CA7396A68D541C85D26508E83_148264258;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1124832782.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1124832782;
        
        
            
        
        
        
            
                
            
                
                    
                
                    
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.080 -0400", hash_original_method = "4EF04355E0E174C22FDE9BF5C4BD4B3D", hash_generated_method = "1C3F5412288B13DC7104658896F3EBCE")
    public String getVersionMinor() {
        String varB4EAC82CA7396A68D541C85D26508E83_2051749707 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1482989905 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2051749707 = null;
        String minor = null;
        boolean dot = false;
        {
            int i = 0;
            boolean var169D7E26B3087AB149CABEB542BD5E41_2117514360 = (i < sipVersion.length());
            {
                {
                    minor = "" + sipVersion.charAt(i);
                    minor += sipVersion.charAt(i);
                } 
                {
                    boolean varA8700FADE3EA4C6331A22B4D0D4435B3_233126315 = (sipVersion.charAt(i) == '.');
                    dot = true;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1482989905 = minor;
        String varA7E53CE21691AB073D9660D615818899_1202146768; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1202146768 = varB4EAC82CA7396A68D541C85D26508E83_2051749707;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1202146768 = varB4EAC82CA7396A68D541C85D26508E83_1482989905;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1202146768.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1202146768;
        
        
            
        
        
        
            
                
                    
                
                    
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.081 -0400", hash_original_method = "1239840CE17889EA14CF87055D293638", hash_generated_method = "C991A9DBF20EFD1E52F87F402B276A29")
    public boolean equals(Object other) {
        boolean retval;
        {
            boolean varAC16F771BB29A32F2C455E410359AF13_228409473 = (!other.getClass().equals(this.getClass()));
        } 
        RequestLine that = (RequestLine) other;
        try 
        {
            retval =
                this.method.equals(that.method)
                    && this.uri.equals(that.uri)
                    && this.sipVersion.equals(that.sipVersion);
        } 
        catch (NullPointerException ex)
        {
            retval = false;
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866576483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866576483;
        
        
        
            
        
        
        
            
                
                    
                    
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.082 -0400", hash_original_method = "6B13CE61BDAF8DDF9CB0869D09E1BD0F", hash_generated_method = "E0DBE4FDE41E7EC0F4159F274852F72D")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1417451814 = null; 
        RequestLine retval = (RequestLine) super.clone();
        retval.uri = (GenericURI) this.uri.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1417451814 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1417451814.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1417451814;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.082 -0400", hash_original_field = "BA6FC0007D7D0CFBD660D7DEE05A678D", hash_generated_field = "ED5F8AB740667ACC3F117C961E7750C6")

    private static final long serialVersionUID = -3286426172326043129L;
}

