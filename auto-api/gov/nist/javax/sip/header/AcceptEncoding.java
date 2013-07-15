package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;
import java.text.ParseException;

public final class AcceptEncoding extends ParametersHeader implements AcceptEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.793 -0400", hash_original_field = "56FCF189DEA8F408DF7A954D27D868E1", hash_generated_field = "984A82245D6D3FDFD20ECFB9ACF6FE25")

    protected String contentCoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.793 -0400", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "6F107BDA532202B5E7B29048E45E2E47")
    public  AcceptEncoding() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.794 -0400", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "6B1A0DC04F1D305FEFA730D4B239674A")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1709799063 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1709799063 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1709799063.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1709799063;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.795 -0400", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "AE13B071572111ECF26C7A78ACBD973A")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_923361141 = null; 
        {
            buffer.append(contentCoding);
        } 
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1894192545 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON).append(parameters.encode());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_923361141 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_923361141.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_923361141;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.795 -0400", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "BDC70F16F3115F25B1CF26057D36F931")
    public float getQValue() {
        float varEF77CF42E481EDA9660BAA3A17253A3D_1761140003 = (getParameterAsFloat("q"));
        float var546ADE640B6EDFBC8A086EF31347E768_259273750 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_259273750;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.796 -0400", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "4321E496F9EC6E91FBC20C569DAC3C24")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1835607606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1835607606 = contentCoding;
        varB4EAC82CA7396A68D541C85D26508E83_1835607606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1835607606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.796 -0400", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "595FA9BEF345126828385567ED9E1FB9")
    public void setQValue(float q) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        super.setParameter("q", q);
        addTaint(q);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.798 -0400", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "43BC18818B31C6B63B967DE38BA5BF62")
    public void setEncoding(String encoding) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" encoding parameter is null");
        contentCoding = encoding;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.798 -0400", hash_original_field = "0031F97100CEAAFDAA535A23985638A8", hash_generated_field = "4930A84A156D9023318126D844288C58")

    private static final long serialVersionUID = -1476807565552873525L;
}

