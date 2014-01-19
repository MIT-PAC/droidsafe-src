package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;

public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.869 -0500", hash_original_field = "D9859D2DC4F9E5867AA6A26BB559533E", hash_generated_field = "4CCD72942F5376DF30647BDBD097E9E4")

    private StatusLine          statusline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.871 -0500", hash_original_field = "84BEE3610D6DA557FD534AD24775E93F", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity          entity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.875 -0500", hash_original_field = "D8E058CC9400D2B49594453D57519F61", hash_generated_field = "66B942B399EC48BCD27B61E760B1CE99")

    private ReasonPhraseCatalog reasonCatalog;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.878 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale              locale;

    /**
     * Creates a new response.
     * This is the constructor to which all others map.
     *
     * @param statusline        the status line
     * @param catalog           the reason phrase catalog, or
     *                          <code>null</code> to disable automatic
     *                          reason phrase lookup
     * @param locale            the locale for looking up reason phrases, or
     *                          <code>null</code> for the system locale
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.881 -0500", hash_original_method = "A29A20D85E2A95F9F380E42B440BE20C", hash_generated_method = "A59FDEF13035105775FFBF5C1559BF57")
    
public BasicHttpResponse(final StatusLine statusline,
                             final ReasonPhraseCatalog catalog,
                             final Locale locale) {
        super();
        if (statusline == null) {
            throw new IllegalArgumentException("Status line may not be null.");
        }
        this.statusline    = statusline;
        this.reasonCatalog = catalog;
        this.locale        = (locale != null) ? locale : Locale.getDefault();
    }

    /**
     * Creates a response from a status line.
     * The response will not have a reason phrase catalog and
     * use the system default locale.
     *
     * @param statusline        the status line
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.884 -0500", hash_original_method = "AAC0170DE8A46A77F8ABEAF95E5D47DF", hash_generated_method = "0303EF5FD77338E65FA4817037189CB6")
    
public BasicHttpResponse(final StatusLine statusline) {
        this(statusline, null, null);
    }

    /**
     * Creates a response from elements of a status line.
     * The response will not have a reason phrase catalog and
     * use the system default locale.
     *
     * @param ver       the protocol version of the response
     * @param code      the status code of the response
     * @param reason    the reason phrase to the status code, or
     *                  <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.887 -0500", hash_original_method = "6506B3795A3A16C6E9B1FFC15C1ED834", hash_generated_method = "CC65B08E151A2078BB23C8227F59BC6B")
    
public BasicHttpResponse(final ProtocolVersion ver,
                             final int code,
                             final String reason) {
        this(new BasicStatusLine(ver, code, reason), null, null);
    }

    // non-javadoc, see interface HttpMessage
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.889 -0500", hash_original_method = "90208803F02F793AFF747002BC8D1B69", hash_generated_method = "116490FDB9CFC58F547476EB349C29C7")
    
public ProtocolVersion getProtocolVersion() {
        return this.statusline.getProtocolVersion();
    }

    // non-javadoc, see interface HttpResponse
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.892 -0500", hash_original_method = "17E71ED31D66483D3BDF78C743004CA2", hash_generated_method = "8ABB7B3878FF89EA492FEE050D9D5995")
    
public StatusLine getStatusLine() {
        return this.statusline; 
    }

    // non-javadoc, see interface HttpResponse
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.894 -0500", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "F26E442D152B9CF496C6F072484628AD")
    
public HttpEntity getEntity() {
        return this.entity;
    }

    // non-javadoc, see interface HttpResponse
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.896 -0500", hash_original_method = "733D9DF7D9A8D6EAEA176BCCAA80EA96", hash_generated_method = "CCD4021A5F38FD450220610E2095A85C")
    
public Locale getLocale() {
        return this.locale;
    }

    // non-javadoc, see interface HttpResponse
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.898 -0500", hash_original_method = "D370D995D9AEDFD784968CDDE918B3A9", hash_generated_method = "3EE5491478A04AEA0AB403B5E2172CD4")
    
public void setStatusLine(final StatusLine statusline) {
        if (statusline == null) {
            throw new IllegalArgumentException("Status line may not be null");
        }
        this.statusline = statusline;
    }

    // non-javadoc, see interface HttpResponse
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.900 -0500", hash_original_method = "1BC8215859DBDD8C612AAF8D25EAF759", hash_generated_method = "4239ABFBE7F30A1D74A85984AB874748")
    
public void setStatusLine(final ProtocolVersion ver, final int code) {
        // arguments checked in BasicStatusLine constructor
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    // non-javadoc, see interface HttpResponse
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.902 -0500", hash_original_method = "6CC4B11D9AD32634701C1082F63EF70B", hash_generated_method = "91AB09417C98E00D98C7ABD6DA3869A1")
    
public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason) {
        // arguments checked in BasicStatusLine constructor
        this.statusline = new BasicStatusLine(ver, code, reason);
    }

    // non-javadoc, see interface HttpResponse
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.905 -0500", hash_original_method = "7D42455A6D5293330CE36AB0F03AF641", hash_generated_method = "2CD76105C8047D9A893926BAC0F9255A")
    
public void setStatusCode(int code) {
        // argument checked in BasicStatusLine constructor
        ProtocolVersion ver = this.statusline.getProtocolVersion();
        this.statusline = new BasicStatusLine(ver, code, getReason(code));
    }

    // non-javadoc, see interface HttpResponse
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.908 -0500", hash_original_method = "8A9577D3FB93048CF250DA10DB0B55E0", hash_generated_method = "83FA437DE0BA59FFEC73B29FD04AB860")
    
public void setReasonPhrase(String reason) {

        if ((reason != null) && ((reason.indexOf('\n') >= 0) ||
                                 (reason.indexOf('\r') >= 0))
            ) {
            throw new IllegalArgumentException("Line break in reason phrase.");
        }
        this.statusline = new BasicStatusLine(this.statusline.getProtocolVersion(),
                                              this.statusline.getStatusCode(),
                                              reason);
    }

    // non-javadoc, see interface HttpResponse
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.910 -0500", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "79AAFF6E92B5322E414271D0A9826A70")
    
public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }

    // non-javadoc, see interface HttpResponse
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.912 -0500", hash_original_method = "0DB1ABBE31592BCC04F2F708A5F68A93", hash_generated_method = "28FE45C7E0F441580F6306A8B04503A1")
    
public void setLocale(Locale loc) {
        if (loc == null) {
            throw new IllegalArgumentException("Locale may not be null.");
        }
        this.locale = loc;
        final int code = this.statusline.getStatusCode();
        this.statusline = new BasicStatusLine
            (this.statusline.getProtocolVersion(), code, getReason(code));
    }

    /**
     * Looks up a reason phrase.
     * This method evaluates the currently set catalog and locale.
     * It also handles a missing catalog.
     *
     * @param code      the status code for which to look up the reason
     *
     * @return  the reason phrase, or <code>null</code> if there is none
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.915 -0500", hash_original_method = "FEEB8D9BF9C5F48AC25C3CD2E5553BCA", hash_generated_method = "5F374C21892D63154BFD6314348D2005")
    
protected String getReason(int code) {
        return (this.reasonCatalog == null) ?
            null : this.reasonCatalog.getReason(code, this.locale);
    }
    
}

