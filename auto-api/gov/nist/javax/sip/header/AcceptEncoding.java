package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;
import java.text.ParseException;

public final class AcceptEncoding extends ParametersHeader implements AcceptEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.142 -0400", hash_original_field = "56FCF189DEA8F408DF7A954D27D868E1", hash_generated_field = "984A82245D6D3FDFD20ECFB9ACF6FE25")

    protected String contentCoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.143 -0400", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "6F107BDA532202B5E7B29048E45E2E47")
    public  AcceptEncoding() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.143 -0400", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "E64553418A0F6EAA503CBBD180E1DC48")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_2106052937 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2106052937 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2106052937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2106052937;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.149 -0400", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "C42A45E6732362A835395E6407888683")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_477140318 = null; //Variable for return #1
        {
            buffer.append(contentCoding);
        } //End block
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_2119693381 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_477140318 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_477140318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_477140318;
        // ---------- Original Method ----------
        //if (contentCoding != null) {
            //buffer.append(contentCoding);
        //}
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(SEMICOLON).append(parameters.encode());
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.149 -0400", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "18052901FB0D9324BB2BF8BF64ECD8B1")
    public float getQValue() {
        float varEF77CF42E481EDA9660BAA3A17253A3D_1775002487 = (getParameterAsFloat("q"));
        float var546ADE640B6EDFBC8A086EF31347E768_377615936 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_377615936;
        // ---------- Original Method ----------
        //return getParameterAsFloat("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.151 -0400", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "B0212AA791AA7C9742A74174F0F95555")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_635164674 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_635164674 = contentCoding;
        varB4EAC82CA7396A68D541C85D26508E83_635164674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_635164674;
        // ---------- Original Method ----------
        //return contentCoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.151 -0400", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "595FA9BEF345126828385567ED9E1FB9")
    public void setQValue(float q) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        super.setParameter("q", q);
        addTaint(q);
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //super.setParameter("q", q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.164 -0400", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "43BC18818B31C6B63B967DE38BA5BF62")
    public void setEncoding(String encoding) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" encoding parameter is null");
        contentCoding = encoding;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(" encoding parameter is null");
        //contentCoding = encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.164 -0400", hash_original_field = "0031F97100CEAAFDAA535A23985638A8", hash_generated_field = "A158EBDDDEED6AF7A00154A93A5A5E96")

    private static long serialVersionUID = -1476807565552873525L;
}

