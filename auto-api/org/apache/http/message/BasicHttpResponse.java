package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.ReasonPhraseCatalog;

public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.998 -0400", hash_original_field = "AA0D4A4A699CB2EF82685419DB641FCD", hash_generated_field = "4CCD72942F5376DF30647BDBD097E9E4")

    private StatusLine statusline;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.998 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.998 -0400", hash_original_field = "7396F84CD8586AB513EED3D2A634318F", hash_generated_field = "66B942B399EC48BCD27B61E760B1CE99")

    private ReasonPhraseCatalog reasonCatalog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.998 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.998 -0400", hash_original_method = "A29A20D85E2A95F9F380E42B440BE20C", hash_generated_method = "E6B191761C70742AE073C529C068F53B")
    public  BasicHttpResponse(final StatusLine statusline,
                             final ReasonPhraseCatalog catalog,
                             final Locale locale) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.999 -0400", hash_original_method = "AAC0170DE8A46A77F8ABEAF95E5D47DF", hash_generated_method = "1D6ED238FFB7668E21F795FEA61006F7")
    public  BasicHttpResponse(final StatusLine statusline) {
        this(statusline, null, null);
        addTaint(statusline.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.999 -0400", hash_original_method = "6506B3795A3A16C6E9B1FFC15C1ED834", hash_generated_method = "68473424008F5EE575B9E678640A069C")
    public  BasicHttpResponse(final ProtocolVersion ver,
                             final int code,
                             final String reason) {
        this(new BasicStatusLine(ver, code, reason), null, null);
        addTaint(ver.getTaint());
        addTaint(code);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.999 -0400", hash_original_method = "90208803F02F793AFF747002BC8D1B69", hash_generated_method = "8C562E1D86B2099669EB8A2F9D469216")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1402346604 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1402346604 = this.statusline.getProtocolVersion();
        varB4EAC82CA7396A68D541C85D26508E83_1402346604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1402346604;
        // ---------- Original Method ----------
        //return this.statusline.getProtocolVersion();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.000 -0400", hash_original_method = "17E71ED31D66483D3BDF78C743004CA2", hash_generated_method = "043286822E67A9F6B4A090E1C6C45632")
    public StatusLine getStatusLine() {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_708637177 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_708637177 = this.statusline;
        varB4EAC82CA7396A68D541C85D26508E83_708637177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708637177;
        // ---------- Original Method ----------
        //return this.statusline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.000 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "C59C8C8BE99B2B6EFC2426BAB748F6C7")
    public HttpEntity getEntity() {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_60659544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_60659544 = this.entity;
        varB4EAC82CA7396A68D541C85D26508E83_60659544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_60659544;
        // ---------- Original Method ----------
        //return this.entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.001 -0400", hash_original_method = "733D9DF7D9A8D6EAEA176BCCAA80EA96", hash_generated_method = "092F1445BA4E65A11CB3CC5135D83499")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_895257086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_895257086 = this.locale;
        varB4EAC82CA7396A68D541C85D26508E83_895257086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895257086;
        // ---------- Original Method ----------
        //return this.locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.001 -0400", hash_original_method = "D370D995D9AEDFD784968CDDE918B3A9", hash_generated_method = "7208B815153DE79D0FF5850E13D7B60D")
    public void setStatusLine(final StatusLine statusline) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Status line may not be null");
        } //End block
        this.statusline = statusline;
        // ---------- Original Method ----------
        //if (statusline == null) {
            //throw new IllegalArgumentException("Status line may not be null");
        //}
        //this.statusline = statusline;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.001 -0400", hash_original_method = "1BC8215859DBDD8C612AAF8D25EAF759", hash_generated_method = "536DAFF9BA693838F6F90920759EF12D")
    public void setStatusLine(final ProtocolVersion ver, final int code) {
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        // ---------- Original Method ----------
        //this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.002 -0400", hash_original_method = "6CC4B11D9AD32634701C1082F63EF70B", hash_generated_method = "B3CCD57AC733622755F9F233A81FF38D")
    public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason) {
        this.statusline = new BasicStatusLine(ver, code, reason);
        // ---------- Original Method ----------
        //this.statusline = new BasicStatusLine(ver, code, reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.002 -0400", hash_original_method = "7D42455A6D5293330CE36AB0F03AF641", hash_generated_method = "A5FF50AA32055722D8112BC0D92EAE2E")
    public void setStatusCode(int code) {
        ProtocolVersion ver;
        ver = this.statusline.getProtocolVersion();
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
        // ---------- Original Method ----------
        //ProtocolVersion ver = this.statusline.getProtocolVersion();
        //this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.011 -0400", hash_original_method = "8A9577D3FB93048CF250DA10DB0B55E0", hash_generated_method = "D5435798272AC8313727D1D546DEFADA")
    public void setReasonPhrase(String reason) {
        {
            boolean varCB07399EE36E1AEB38CD197AB4F4DEB6_2143524265 = ((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 (reason.indexOf('\r') >= 0)));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Line break in reason phrase.");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.017 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        // ---------- Original Method ----------
        //this.entity = entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.018 -0400", hash_original_method = "0DB1ABBE31592BCC04F2F708A5F68A93", hash_generated_method = "5B47B8F4B89327157FCE9B1C70B81CBD")
    public void setLocale(Locale loc) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Locale may not be null.");
        } //End block
        this.locale = loc;
        int code;
        code = this.statusline.getStatusCode();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.018 -0400", hash_original_method = "FEEB8D9BF9C5F48AC25C3CD2E5553BCA", hash_generated_method = "210A83A4B70721BC7689C8C52B0C406B")
    protected String getReason(int code) {
        String varB4EAC82CA7396A68D541C85D26508E83_1620278420 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1620278420 = (this.reasonCatalog == null) ?
            null : this.reasonCatalog.getReason(code, this.locale);
        addTaint(code);
        varB4EAC82CA7396A68D541C85D26508E83_1620278420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1620278420;
        // ---------- Original Method ----------
        //return (this.reasonCatalog == null) ?
            //null : this.reasonCatalog.getReason(code, this.locale);
    }

    
}

