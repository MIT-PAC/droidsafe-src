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
    protected String contentCoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.633 -0400", hash_original_method = "45FBA71B6A8F004018F3CEEA4ED1F1C4", hash_generated_method = "6F107BDA532202B5E7B29048E45E2E47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptEncoding() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "D7FA4A0D1D7B133EC4C2E19C83590E19", hash_generated_method = "B9D1AD3A7F3A991C594138EC66065032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String varFFB45C40AF627644780ECFF5921CFE15_1902471675 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "98075621BFB1005208DC6FCAC63FC820", hash_generated_method = "24CC3C5F4C68CB8D8173B2726308DA94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            buffer.append(contentCoding);
        } //End block
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1313469667 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentCoding != null) {
            //buffer.append(contentCoding);
        //}
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(SEMICOLON).append(parameters.encode());
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "6B0931DE2FCF1641F5A5332B85279714", hash_generated_method = "9272FA5F5A9726160D5B026878DA6488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getQValue() {
        float varEF77CF42E481EDA9660BAA3A17253A3D_1637900279 = (getParameterAsFloat("q"));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getParameterAsFloat("q");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "EF1274C134CEA0B72E03DC392C09F299", hash_generated_method = "0F3C3271FFE760AA71C76145B25C3C6F")
    @DSModeled(DSC.SAFE)
    public String getEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return contentCoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "76C27BE10969A23E1C16A937029760DA", hash_generated_method = "503E1B86EBD8F0674A5CFA7EF893AC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQValue(float q) throws InvalidArgumentException {
        dsTaint.addTaint(q);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("qvalue out of range!");
        super.setParameter("q", q);
        // ---------- Original Method ----------
        //if (q < 0.0 || q > 1.0)
            //throw new InvalidArgumentException("qvalue out of range!");
        //super.setParameter("q", q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.634 -0400", hash_original_method = "F19AC8B3279BF898A8AFB974FE7AAE2D", hash_generated_method = "79CCB8962E8DEDA962B1E70E9D8B5E98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncoding(String encoding) throws ParseException {
        dsTaint.addTaint(encoding);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" encoding parameter is null");
        // ---------- Original Method ----------
        //if (encoding == null)
            //throw new NullPointerException(" encoding parameter is null");
        //contentCoding = encoding;
    }

    
    private static final long serialVersionUID = -1476807565552873525L;
}

