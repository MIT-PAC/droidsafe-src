package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.385 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "67AFEE1CECFFBA6E89413397161A2E7D")

    protected String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.386 -0400", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "E16B4249E7E1D0E0C17B6F77DF99E8B5")
    public  ExtensionHeaderImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.386 -0400", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "CE11635C6A2DA477CA25FDD83D492784")
    public  ExtensionHeaderImpl(String headerName) {
        super(headerName);
        addTaint(headerName.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.387 -0400", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "7150688FF648DA10E3C0AED69DF6B1CC")
    public void setName(String headerName) {
        addTaint(headerName.getTaint());
        this.headerName = headerName;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.388 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "811C079A212601355D5034023F0D4C0B")
    public void setValue(String value) {
        this.value = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.389 -0400", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "F42BED6DC274AD227B7653A6684E307A")
    public String getHeaderValue() {
    if(this.value != null)        
        {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_1746307728 =             this.value;
            varD64EF4B55BF21CB8765EC6BE5560B5B8_1746307728.addTaint(taint);
            return varD64EF4B55BF21CB8765EC6BE5560B5B8_1746307728;
        } 
        else
        {
            String encodedHdr = null;
            try 
            {
                encodedHdr = this.encode();
            } 
            catch (Exception ex)
            {
String var540C13E9E156B687226421B24F2DF178_1361446692 =                 null;
                var540C13E9E156B687226421B24F2DF178_1361446692.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1361446692;
            } 
            StringBuffer buffer = new StringBuffer(encodedHdr);
            while
(buffer.length() > 0 && buffer.charAt(0) != ':')            
            {
                buffer.deleteCharAt(0);
            } 
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
String varD64EF4B55BF21CB8765EC6BE5560B5B8_589337224 =             this.value;
            varD64EF4B55BF21CB8765EC6BE5560B5B8_589337224.addTaint(taint);
            return varD64EF4B55BF21CB8765EC6BE5560B5B8_589337224;
        } 
        
        
            
        
            
            
                
            
                
            
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.389 -0400", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "89C5E28BF13FBDACCFBD29FFEF9D0BEC")
    public String encode() {
String varAC4D3DF473F5E1099900E2CFA3922002_1688307762 =         new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString();
        varAC4D3DF473F5E1099900E2CFA3922002_1688307762.addTaint(taint);
        return varAC4D3DF473F5E1099900E2CFA3922002_1688307762;
        
        
            
            
            
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.389 -0400", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "18CC21F7B397786A40C096B066E86C23")
    public String encodeBody() {
String var650A235F8D00B3E802F034AA253BD873_467915838 =         this.getHeaderValue();
        var650A235F8D00B3E802F034AA253BD873_467915838.addTaint(taint);
        return var650A235F8D00B3E802F034AA253BD873_467915838;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.390 -0400", hash_original_field = "17BBB107160A1B885287E0DF95FB240C", hash_generated_field = "2299100AA92F5021DFDAE61FD8547A67")

    private static final long serialVersionUID = -8693922839612081849L;
}

