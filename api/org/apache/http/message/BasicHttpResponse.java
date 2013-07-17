package org.apache.http.message;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.893 -0400", hash_original_field = "AA0D4A4A699CB2EF82685419DB641FCD", hash_generated_field = "4CCD72942F5376DF30647BDBD097E9E4")

    private StatusLine statusline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.893 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.893 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "66B942B399EC48BCD27B61E760B1CE99")

    private ReasonPhraseCatalog reasonCatalog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.893 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.894 -0400", hash_original_method = "A29A20D85E2A95F9F380E42B440BE20C", hash_generated_method = "F62FBB036191731763E50F35AFEE3CC1")
    public  BasicHttpResponse(final StatusLine statusline,
                             final ReasonPhraseCatalog catalog,
                             final Locale locale) {
        super();
        if(statusline == null)        
        {
            IllegalArgumentException var4709414B32B1770E2C45CBE97DD5D9E5_1422712833 = new IllegalArgumentException("Status line may not be null.");
            var4709414B32B1770E2C45CBE97DD5D9E5_1422712833.addTaint(taint);
            throw var4709414B32B1770E2C45CBE97DD5D9E5_1422712833;
        } //End block
        this.statusline    = statusline;
        this.reasonCatalog = catalog;
        this.locale        = (locale != null) ? locale : Locale.getDefault();
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null.");
        //}
        //this.statusline    = statusline;
        //this.reasonCatalog = catalog;
        //this.locale        = (locale != null) ? locale : Locale.getDefault();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.895 -0400", hash_original_method = "AAC0170DE8A46A77F8ABEAF95E5D47DF", hash_generated_method = "1D6ED238FFB7668E21F795FEA61006F7")
    public  BasicHttpResponse(final StatusLine statusline) {
        this(statusline, null, null);
        addTaint(statusline.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.895 -0400", hash_original_method = "6506B3795A3A16C6E9B1FFC15C1ED834", hash_generated_method = "555CD811A3B58BF43063D7090991996F")
    public  BasicHttpResponse(final ProtocolVersion ver,
                             final int code,
                             final String reason) {
        this(new BasicStatusLine(ver, code, reason), null, null);
        addTaint(reason.getTaint());
        addTaint(code);
        addTaint(ver.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.896 -0400", hash_original_method = "90208803F02F793AFF747002BC8D1B69", hash_generated_method = "CFE7516447259D80B03F14C7BBC40BC9")
    public ProtocolVersion getProtocolVersion() {
ProtocolVersion varD90C043793F7774DAF136F85478656A2_699467058 =         this.statusline.getProtocolVersion();
        varD90C043793F7774DAF136F85478656A2_699467058.addTaint(taint);
        return varD90C043793F7774DAF136F85478656A2_699467058;
        // ---------- Original Method ----------
        //return this.statusline.getProtocolVersion();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.896 -0400", hash_original_method = "17E71ED31D66483D3BDF78C743004CA2", hash_generated_method = "3D7A4E3AF14E1D175A6526D99805B107")
    public StatusLine getStatusLine() {
StatusLine var3F6855B8C489EBE58B05E134AAAD021B_175356872 =         this.statusline;
        var3F6855B8C489EBE58B05E134AAAD021B_175356872.addTaint(taint);
        return var3F6855B8C489EBE58B05E134AAAD021B_175356872;
        // ---------- Original Method ----------
        //return this.statusline;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.896 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "2886B2F531A3777B6C2E420297E292E7")
    public HttpEntity getEntity() {
HttpEntity varB0390008473457B24431D383C02B7BE2_1346307996 =         this.entity;
        varB0390008473457B24431D383C02B7BE2_1346307996.addTaint(taint);
        return varB0390008473457B24431D383C02B7BE2_1346307996;
        // ---------- Original Method ----------
        //return this.entity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.896 -0400", hash_original_method = "733D9DF7D9A8D6EAEA176BCCAA80EA96", hash_generated_method = "41063F1B5C1A8C2B772814190C280C76")
    public Locale getLocale() {
Locale var07CBB3424B1C5A44A7FC0518D56FE503_2015192595 =         this.locale;
        var07CBB3424B1C5A44A7FC0518D56FE503_2015192595.addTaint(taint);
        return var07CBB3424B1C5A44A7FC0518D56FE503_2015192595;
        // ---------- Original Method ----------
        //return this.locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.897 -0400", hash_original_method = "D370D995D9AEDFD784968CDDE918B3A9", hash_generated_method = "118160F34B7DA901A56F4D5BB557ABEB")
    public void setStatusLine(final StatusLine statusline) {
        if(statusline == null)        
        {
            IllegalArgumentException var1636A5AFF6F53BF0101E09315281948D_1595226606 = new IllegalArgumentException("Status line may not be null");
            var1636A5AFF6F53BF0101E09315281948D_1595226606.addTaint(taint);
            throw var1636A5AFF6F53BF0101E09315281948D_1595226606;
        } //End block
        this.statusline = statusline;
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null");
        //}
        //this.statusline = statusline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.897 -0400", hash_original_method = "1BC8215859DBDD8C612AAF8D25EAF759", hash_generated_method = "536DAFF9BA693838F6F90920759EF12D")
    public void setStatusLine(final ProtocolVersion ver, final int code) {
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        // ---------- Original Method ----------
        //this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.898 -0400", hash_original_method = "6CC4B11D9AD32634701C1082F63EF70B", hash_generated_method = "B3CCD57AC733622755F9F233A81FF38D")
    public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason) {
        this.statusline = new BasicStatusLine(ver, code, reason);
        // ---------- Original Method ----------
        //this.statusline = new BasicStatusLine(ver, code, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.898 -0400", hash_original_method = "7D42455A6D5293330CE36AB0F03AF641", hash_generated_method = "00F9C756B89CB533C444745750A41BFC")
    public void setStatusCode(int code) {
        ProtocolVersion ver = this.statusline.getProtocolVersion();
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        // ---------- Original Method ----------
        //ProtocolVersion ver = this.statusline.getProtocolVersion();
        //this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.899 -0400", hash_original_method = "8A9577D3FB93048CF250DA10DB0B55E0", hash_generated_method = "91ACF82945313113769D10BBF18FC6AC")
    public void setReasonPhrase(String reason) {
        if((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 (reason.indexOf('\r') >= 0)))        
        {
            IllegalArgumentException var9E32F7C57C8E470485D53529D69B0D89_982188233 = new IllegalArgumentException("Line break in reason phrase.");
            var9E32F7C57C8E470485D53529D69B0D89_982188233.addTaint(taint);
            throw var9E32F7C57C8E470485D53529D69B0D89_982188233;
        } //End block
        this.statusline = new BasicStatusLine(this.statusline.getProtocolVersion(),
                                              this.statusline.getStatusCode(),
                                              reason);
        // ---------- Original Method ----------
        //if ((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 //(reason.indexOf('\r') >= 0))
            //) {
            //throw new IllegalArgumentException("Line break in reason phrase.");
        //}
        //this.statusline = new BasicStatusLine(this.statusline.getProtocolVersion(),
                                              //this.statusline.getStatusCode(),
                                              //reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.900 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        // ---------- Original Method ----------
        //this.entity = entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.901 -0400", hash_original_method = "0DB1ABBE31592BCC04F2F708A5F68A93", hash_generated_method = "EC32EFF891F60CC525902A14B704B20D")
    public void setLocale(Locale loc) {
        if(loc == null)        
        {
            IllegalArgumentException var375D7E0D2547FD54B345F11E55227B22_369570033 = new IllegalArgumentException("Locale may not be null.");
            var375D7E0D2547FD54B345F11E55227B22_369570033.addTaint(taint);
            throw var375D7E0D2547FD54B345F11E55227B22_369570033;
        } //End block
        this.locale = loc;
        final int code = this.statusline.getStatusCode();
        this.statusline = new BasicStatusLine
            (this.statusline.getProtocolVersion(), code, getReason(code));
        // ---------- Original Method ----------
        //if (loc == null) {
            //throw new IllegalArgumentException("Locale may not be null.");
        //}
        //this.locale = loc;
        //final int code = this.statusline.getStatusCode();
        //this.statusline = new BasicStatusLine
            //(this.statusline.getProtocolVersion(), code, getReason(code));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.901 -0400", hash_original_method = "FEEB8D9BF9C5F48AC25C3CD2E5553BCA", hash_generated_method = "9C11798EEFBF59AB50E368580BEBDA51")
    protected String getReason(int code) {
        addTaint(code);
String var60644D7B8CCB006F15086BB6E0A0C18A_1484758995 =         (this.reasonCatalog == null) ?
            null : this.reasonCatalog.getReason(code, this.locale);
        var60644D7B8CCB006F15086BB6E0A0C18A_1484758995.addTaint(taint);
        return var60644D7B8CCB006F15086BB6E0A0C18A_1484758995;
        // ---------- Original Method ----------
        //return (this.reasonCatalog == null) ?
            //null : this.reasonCatalog.getReason(code, this.locale);
    }

    
}

