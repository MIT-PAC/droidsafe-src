package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;
import java.text.ParseException;

public final class AcceptEncoding extends ParametersHeader implements AcceptEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.648 -0400", hash_original_field = "56FCF189DEA8F408DF7A954D27D868E1", hash_generated_field = "984A82245D6D3FDFD20ECFB9ACF6FE25")

    protected String contentCoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.649 -0400", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "6F107BDA532202B5E7B29048E45E2E47")
    public  AcceptEncoding() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.649 -0400", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "0973C7D62B6EE8E8ED4A55DE70C96776")
    protected String encodeBody() {
String var678B6FE61D54E5BD4E109D01C318C133_345340047 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_345340047.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_345340047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.650 -0400", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "D4C82926C7347B0C971055721D64E448")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(contentCoding != null)        
        {
            buffer.append(contentCoding);
        } 
    if(parameters != null && !parameters.isEmpty())        
        {
            buffer.append(SEMICOLON).append(parameters.encode());
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_258247648 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_258247648.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_258247648;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.651 -0400", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "7FD1FA0C35127444E7D387ECF51007AD")
    public float getQValue() {
        float varB32A63C25B3DB24FE25BBA1CA7CBBE2F_1671873177 = (getParameterAsFloat("q"));
                float var546ADE640B6EDFBC8A086EF31347E768_744205661 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_744205661;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.652 -0400", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "93FC652544AEFE4477D3DE9E3ECEBBB8")
    public String getEncoding() {
String var204FBF1658761434055013767DC5BA3A_194052905 =         contentCoding;
        var204FBF1658761434055013767DC5BA3A_194052905.addTaint(taint);
        return var204FBF1658761434055013767DC5BA3A_194052905;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.653 -0400", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "B0FBFFC39E0E75CDA3834B092532F921")
    public void setQValue(float q) throws InvalidArgumentException {
        addTaint(q);
    if(q < 0.0 || q > 1.0)        
        {
        InvalidArgumentException var9B8565E3F346FBBBFE76E5273CB2EE74_1818479519 = new InvalidArgumentException("qvalue out of range!");
        var9B8565E3F346FBBBFE76E5273CB2EE74_1818479519.addTaint(taint);
        throw var9B8565E3F346FBBBFE76E5273CB2EE74_1818479519;
        }
        super.setParameter("q", q);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.653 -0400", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "4635BE2B330DDD78369404E28EFC2182")
    public void setEncoding(String encoding) throws ParseException {
    if(encoding == null)        
        {
        NullPointerException var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_1165611684 = new NullPointerException(" encoding parameter is null");
        var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_1165611684.addTaint(taint);
        throw var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_1165611684;
        }
        contentCoding = encoding;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.654 -0400", hash_original_field = "0031F97100CEAAFDAA535A23985638A8", hash_generated_field = "4930A84A156D9023318126D844288C58")

    private static final long serialVersionUID = -1476807565552873525L;
}

