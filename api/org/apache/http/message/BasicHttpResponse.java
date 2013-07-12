package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.ReasonPhraseCatalog;

public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.514 -0400", hash_original_field = "AA0D4A4A699CB2EF82685419DB641FCD", hash_generated_field = "4CCD72942F5376DF30647BDBD097E9E4")

    private StatusLine statusline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.514 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.514 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "66B942B399EC48BCD27B61E760B1CE99")

    private ReasonPhraseCatalog reasonCatalog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.514 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.515 -0400", hash_original_method = "A29A20D85E2A95F9F380E42B440BE20C", hash_generated_method = "AF36A742FC12389A0A811E145D239A44")
    public  BasicHttpResponse(final StatusLine statusline,
                             final ReasonPhraseCatalog catalog,
                             final Locale locale) {
        super();
    if(statusline == null)        
        {
            IllegalArgumentException var4709414B32B1770E2C45CBE97DD5D9E5_379965820 = new IllegalArgumentException("Status line may not be null.");
            var4709414B32B1770E2C45CBE97DD5D9E5_379965820.addTaint(taint);
            throw var4709414B32B1770E2C45CBE97DD5D9E5_379965820;
        } 
        this.statusline    = statusline;
        this.reasonCatalog = catalog;
        this.locale        = (locale != null) ? locale : Locale.getDefault();
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.515 -0400", hash_original_method = "AAC0170DE8A46A77F8ABEAF95E5D47DF", hash_generated_method = "1D6ED238FFB7668E21F795FEA61006F7")
    public  BasicHttpResponse(final StatusLine statusline) {
        this(statusline, null, null);
        addTaint(statusline.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.515 -0400", hash_original_method = "6506B3795A3A16C6E9B1FFC15C1ED834", hash_generated_method = "555CD811A3B58BF43063D7090991996F")
    public  BasicHttpResponse(final ProtocolVersion ver,
                             final int code,
                             final String reason) {
        this(new BasicStatusLine(ver, code, reason), null, null);
        addTaint(reason.getTaint());
        addTaint(code);
        addTaint(ver.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.516 -0400", hash_original_method = "90208803F02F793AFF747002BC8D1B69", hash_generated_method = "2D138342480A654F31E566CA74A2637A")
    public ProtocolVersion getProtocolVersion() {
ProtocolVersion varD90C043793F7774DAF136F85478656A2_985352847 =         this.statusline.getProtocolVersion();
        varD90C043793F7774DAF136F85478656A2_985352847.addTaint(taint);
        return varD90C043793F7774DAF136F85478656A2_985352847;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.516 -0400", hash_original_method = "17E71ED31D66483D3BDF78C743004CA2", hash_generated_method = "4D04E6944D786F5CBA3D9E887827F280")
    public StatusLine getStatusLine() {
StatusLine var3F6855B8C489EBE58B05E134AAAD021B_1429796868 =         this.statusline;
        var3F6855B8C489EBE58B05E134AAAD021B_1429796868.addTaint(taint);
        return var3F6855B8C489EBE58B05E134AAAD021B_1429796868;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.516 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "6578CA6DA869DE4160ADFA7CD217DE86")
    public HttpEntity getEntity() {
HttpEntity varB0390008473457B24431D383C02B7BE2_737418682 =         this.entity;
        varB0390008473457B24431D383C02B7BE2_737418682.addTaint(taint);
        return varB0390008473457B24431D383C02B7BE2_737418682;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.516 -0400", hash_original_method = "733D9DF7D9A8D6EAEA176BCCAA80EA96", hash_generated_method = "E261EBA653635DD0617243C084742701")
    public Locale getLocale() {
Locale var07CBB3424B1C5A44A7FC0518D56FE503_563862303 =         this.locale;
        var07CBB3424B1C5A44A7FC0518D56FE503_563862303.addTaint(taint);
        return var07CBB3424B1C5A44A7FC0518D56FE503_563862303;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.517 -0400", hash_original_method = "D370D995D9AEDFD784968CDDE918B3A9", hash_generated_method = "625CF1DED1F31B564ADB778DC0866EC3")
    public void setStatusLine(final StatusLine statusline) {
    if(statusline == null)        
        {
            IllegalArgumentException var1636A5AFF6F53BF0101E09315281948D_864088791 = new IllegalArgumentException("Status line may not be null");
            var1636A5AFF6F53BF0101E09315281948D_864088791.addTaint(taint);
            throw var1636A5AFF6F53BF0101E09315281948D_864088791;
        } 
        this.statusline = statusline;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.517 -0400", hash_original_method = "1BC8215859DBDD8C612AAF8D25EAF759", hash_generated_method = "536DAFF9BA693838F6F90920759EF12D")
    public void setStatusLine(final ProtocolVersion ver, final int code) {
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.518 -0400", hash_original_method = "6CC4B11D9AD32634701C1082F63EF70B", hash_generated_method = "B3CCD57AC733622755F9F233A81FF38D")
    public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason) {
        this.statusline = new BasicStatusLine(ver, code, reason);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.518 -0400", hash_original_method = "7D42455A6D5293330CE36AB0F03AF641", hash_generated_method = "00F9C756B89CB533C444745750A41BFC")
    public void setStatusCode(int code) {
        ProtocolVersion ver = this.statusline.getProtocolVersion();
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.519 -0400", hash_original_method = "8A9577D3FB93048CF250DA10DB0B55E0", hash_generated_method = "CE6AF14D3CBC8874CCF97D848DCEF167")
    public void setReasonPhrase(String reason) {
    if((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 (reason.indexOf('\r') >= 0)))        
        {
            IllegalArgumentException var9E32F7C57C8E470485D53529D69B0D89_422556152 = new IllegalArgumentException("Line break in reason phrase.");
            var9E32F7C57C8E470485D53529D69B0D89_422556152.addTaint(taint);
            throw var9E32F7C57C8E470485D53529D69B0D89_422556152;
        } 
        this.statusline = new BasicStatusLine(this.statusline.getProtocolVersion(),
                                              this.statusline.getStatusCode(),
                                              reason);
        
        
                                 
            
            
        
        
                                              
                                              
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.519 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.520 -0400", hash_original_method = "0DB1ABBE31592BCC04F2F708A5F68A93", hash_generated_method = "9FD9155061BE2067203DD07A072A3802")
    public void setLocale(Locale loc) {
    if(loc == null)        
        {
            IllegalArgumentException var375D7E0D2547FD54B345F11E55227B22_535419204 = new IllegalArgumentException("Locale may not be null.");
            var375D7E0D2547FD54B345F11E55227B22_535419204.addTaint(taint);
            throw var375D7E0D2547FD54B345F11E55227B22_535419204;
        } 
        this.locale = loc;
        final int code = this.statusline.getStatusCode();
        this.statusline = new BasicStatusLine
            (this.statusline.getProtocolVersion(), code, getReason(code));
        
        
            
        
        
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.521 -0400", hash_original_method = "FEEB8D9BF9C5F48AC25C3CD2E5553BCA", hash_generated_method = "EF6B1308E47B059FA74BAA35150511A7")
    protected String getReason(int code) {
        addTaint(code);
String var60644D7B8CCB006F15086BB6E0A0C18A_1675435821 =         (this.reasonCatalog == null) ?
            null : this.reasonCatalog.getReason(code, this.locale);
        var60644D7B8CCB006F15086BB6E0A0C18A_1675435821.addTaint(taint);
        return var60644D7B8CCB006F15086BB6E0A0C18A_1675435821;
        
        
            
    }

    
}

