package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.ReasonPhraseCatalog;

public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.089 -0400", hash_original_field = "AA0D4A4A699CB2EF82685419DB641FCD", hash_generated_field = "4CCD72942F5376DF30647BDBD097E9E4")

    private StatusLine statusline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.090 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.090 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "66B942B399EC48BCD27B61E760B1CE99")

    private ReasonPhraseCatalog reasonCatalog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.090 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.090 -0400", hash_original_method = "A29A20D85E2A95F9F380E42B440BE20C", hash_generated_method = "E6B191761C70742AE073C529C068F53B")
    public  BasicHttpResponse(final StatusLine statusline,
                             final ReasonPhraseCatalog catalog,
                             final Locale locale) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null.");
        } 
        this.statusline    = statusline;
        this.reasonCatalog = catalog;
        this.locale        = (locale != null) ? locale : Locale.getDefault();
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.091 -0400", hash_original_method = "AAC0170DE8A46A77F8ABEAF95E5D47DF", hash_generated_method = "1D6ED238FFB7668E21F795FEA61006F7")
    public  BasicHttpResponse(final StatusLine statusline) {
        this(statusline, null, null);
        addTaint(statusline.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.091 -0400", hash_original_method = "6506B3795A3A16C6E9B1FFC15C1ED834", hash_generated_method = "68473424008F5EE575B9E678640A069C")
    public  BasicHttpResponse(final ProtocolVersion ver,
                             final int code,
                             final String reason) {
        this(new BasicStatusLine(ver, code, reason), null, null);
        addTaint(ver.getTaint());
        addTaint(code);
        addTaint(reason.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.092 -0400", hash_original_method = "90208803F02F793AFF747002BC8D1B69", hash_generated_method = "8D4C238B1901D0DB19E98E03D73E881E")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_80934876 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_80934876 = this.statusline.getProtocolVersion();
        varB4EAC82CA7396A68D541C85D26508E83_80934876.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_80934876;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.092 -0400", hash_original_method = "17E71ED31D66483D3BDF78C743004CA2", hash_generated_method = "F149CEC5D9FB9C3CB594825963F732C0")
    public StatusLine getStatusLine() {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_96192844 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_96192844 = this.statusline;
        varB4EAC82CA7396A68D541C85D26508E83_96192844.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_96192844;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.093 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "A8F15AA14E62E270819A1337B31449ED")
    public HttpEntity getEntity() {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1248759369 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1248759369 = this.entity;
        varB4EAC82CA7396A68D541C85D26508E83_1248759369.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1248759369;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.094 -0400", hash_original_method = "733D9DF7D9A8D6EAEA176BCCAA80EA96", hash_generated_method = "C7350DE13F7F24E3DBF057879E153BF3")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1100872172 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1100872172 = this.locale;
        varB4EAC82CA7396A68D541C85D26508E83_1100872172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1100872172;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.094 -0400", hash_original_method = "D370D995D9AEDFD784968CDDE918B3A9", hash_generated_method = "7208B815153DE79D0FF5850E13D7B60D")
    public void setStatusLine(final StatusLine statusline) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null");
        } 
        this.statusline = statusline;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.095 -0400", hash_original_method = "1BC8215859DBDD8C612AAF8D25EAF759", hash_generated_method = "536DAFF9BA693838F6F90920759EF12D")
    public void setStatusLine(final ProtocolVersion ver, final int code) {
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.095 -0400", hash_original_method = "6CC4B11D9AD32634701C1082F63EF70B", hash_generated_method = "B3CCD57AC733622755F9F233A81FF38D")
    public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason) {
        this.statusline = new BasicStatusLine(ver, code, reason);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.095 -0400", hash_original_method = "7D42455A6D5293330CE36AB0F03AF641", hash_generated_method = "00F9C756B89CB533C444745750A41BFC")
    public void setStatusCode(int code) {
        ProtocolVersion ver = this.statusline.getProtocolVersion();
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.096 -0400", hash_original_method = "8A9577D3FB93048CF250DA10DB0B55E0", hash_generated_method = "867F589F01B8381E82519894918E819D")
    public void setReasonPhrase(String reason) {
        {
            boolean varCB07399EE36E1AEB38CD197AB4F4DEB6_1169265972 = ((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 (reason.indexOf('\r') >= 0)));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Line break in reason phrase.");
            } 
        } 
        this.statusline = new BasicStatusLine(this.statusline.getProtocolVersion(),
                                              this.statusline.getStatusCode(),
                                              reason);
        
        
                                 
            
            
        
        
                                              
                                              
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.096 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.097 -0400", hash_original_method = "0DB1ABBE31592BCC04F2F708A5F68A93", hash_generated_method = "39B18A6D5CEFFB1C1FB367D53EB7845B")
    public void setLocale(Locale loc) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Locale may not be null.");
        } 
        this.locale = loc;
        final int code = this.statusline.getStatusCode();
        this.statusline = new BasicStatusLine
            (this.statusline.getProtocolVersion(), code, getReason(code));
        
        
            
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.097 -0400", hash_original_method = "FEEB8D9BF9C5F48AC25C3CD2E5553BCA", hash_generated_method = "CE1F117E9DBC172445C075B5F931B0F7")
    protected String getReason(int code) {
        String varB4EAC82CA7396A68D541C85D26508E83_578377970 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_578377970 = (this.reasonCatalog == null) ?
            null : this.reasonCatalog.getReason(code, this.locale);
        addTaint(code);
        varB4EAC82CA7396A68D541C85D26508E83_578377970.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_578377970;
        
        
            
    }

    
}

