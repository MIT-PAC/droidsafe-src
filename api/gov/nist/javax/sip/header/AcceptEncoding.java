package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;
import java.text.ParseException;

public final class AcceptEncoding extends ParametersHeader implements AcceptEncodingHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.601 -0400", hash_original_field = "56FCF189DEA8F408DF7A954D27D868E1", hash_generated_field = "984A82245D6D3FDFD20ECFB9ACF6FE25")

    protected String contentCoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.601 -0400", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "6F107BDA532202B5E7B29048E45E2E47")
    public  AcceptEncoding() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.602 -0400", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "9A487DC5DFFF72117309E17D194E71FA")
    protected String encodeBody() {
String var678B6FE61D54E5BD4E109D01C318C133_843435307 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_843435307.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_843435307;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.602 -0400", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "51EBBD2AD4F7C31BACE5AF9FF4C89520")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(contentCoding != null)        
        {
            buffer.append(contentCoding);
        } //End block
        if(parameters != null && !parameters.isEmpty())        
        {
            buffer.append(SEMICOLON).append(parameters.encode());
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_2128750305 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_2128750305.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_2128750305;
        // ---------- Original Method ----------
        //if (contentCoding != null) {
            //buffer.append(contentCoding);
        //}
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(SEMICOLON).append(parameters.encode());
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.602 -0400", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "F30D78B55AE844CF4FEBD2ABC12AE571")
    public float getQValue() {
        float varB32A63C25B3DB24FE25BBA1CA7CBBE2F_328425585 = (getParameterAsFloat("q"));
                float var546ADE640B6EDFBC8A086EF31347E768_325759231 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_325759231;
        // ---------- Original Method ----------
        //return getParameterAsFloat("q");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.603 -0400", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "F0D94A1395C0DE2782F3E1E34C5758CA")
    public String getEncoding() {
String var204FBF1658761434055013767DC5BA3A_505233720 =         contentCoding;
        var204FBF1658761434055013767DC5BA3A_505233720.addTaint(taint);
        return var204FBF1658761434055013767DC5BA3A_505233720;
        // ---------- Original Method ----------
        //return contentCoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.603 -0400", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "5DA601916ED9780895BA3CA32576F1BC")
    public void setQValue(float q) throws InvalidArgumentException {
        addTaint(q);
        if(q < 0.0 || q > 1.0)        
        {
        InvalidArgumentException var9B8565E3F346FBBBFE76E5273CB2EE74_869694543 = new InvalidArgumentException("qvalue out of range!");
        var9B8565E3F346FBBBFE76E5273CB2EE74_869694543.addTaint(taint);
        throw var9B8565E3F346FBBBFE76E5273CB2EE74_869694543;
        }
        super.setParameter("q", q);
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //super.setParameter("q", q);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.604 -0400", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "D9F2BAD2545D2DC2E87835EF005E51A2")
    public void setEncoding(String encoding) throws ParseException {
        if(encoding == null)        
        {
        NullPointerException var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_828831738 = new NullPointerException(" encoding parameter is null");
        var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_828831738.addTaint(taint);
        throw var0ED6CDED5AF85B40EFCA89EEF0EBB2CF_828831738;
        }
        contentCoding = encoding;
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(" encoding parameter is null");
        //contentCoding = encoding;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.604 -0400", hash_original_field = "0031F97100CEAAFDAA535A23985638A8", hash_generated_field = "4930A84A156D9023318126D844288C58")

    private static final long serialVersionUID = -1476807565552873525L;
}

