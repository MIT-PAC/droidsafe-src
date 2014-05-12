package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class BasicStatusLine implements StatusLine, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.462 -0500", hash_original_field = "5C2189D2BE02C09FF0D009DED07099CB", hash_generated_field = "B0C987478D9E25110C6180A23291A8F7")

    /** The protocol version. */
    private  ProtocolVersion protoVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.464 -0500", hash_original_field = "7D58E974091311E54CFA3738B5F585EF", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private  int statusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.467 -0500", hash_original_field = "3FAD2DC6D188281A1174ECE25C647B14", hash_generated_field = "6AD67BCB7682DA68E3445B9AD0549128")

    private  String reasonPhrase;

    // ----------------------------------------------------------- Constructors
    /**
     * Creates a new status line with the given version, status, and reason.
     *
     * @param version           the protocol version of the response
     * @param statusCode        the status code of the response
     * @param reasonPhrase      the reason phrase to the status code, or
     *                          <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.469 -0500", hash_original_method = "E6F861CC92981BDB285C9E8C86704EF5", hash_generated_method = "34BD51EF454D782A4C0B0E8176E57191")
    
public BasicStatusLine(final ProtocolVersion version, int statusCode,
                           final String reasonPhrase) {
        super();
        if (version == null) {
            throw new IllegalArgumentException
                ("Protocol version may not be null.");
        }
        if (statusCode < 0) {
            throw new IllegalArgumentException
                ("Status code may not be negative.");
        }
        this.protoVersion = version;
        this.statusCode   = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * @return the Status-Code
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.472 -0500", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "5DD64D66E1754A99091F8C05EA6F76CC")
    
public int getStatusCode() {
        return this.statusCode;
    }

    /**
     * @return the HTTP-Version
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.474 -0500", hash_original_method = "428750DB8A2FD05AED2F69E1D46A4B0B", hash_generated_method = "D606DE127964866CAD801CD33EF92F81")
    
public ProtocolVersion getProtocolVersion() {
        return this.protoVersion;
    }

    /**
     * @return the Reason-Phrase
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.476 -0500", hash_original_method = "F68F7EAA9CC529FF206693909CBAA2FE", hash_generated_method = "6BA049AAFCC9C116961789DBBA2FFEE4")
    
public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.479 -0500", hash_original_method = "B124288BE18B40A8DA205B6ACD4ADD5F", hash_generated_method = "372C8D3644A67E69E738BA086B81962D")
    
public String toString() {
        // no need for non-default formatting in toString()
        return BasicLineFormatter.DEFAULT
            .formatStatusLine(null, this).toString();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.482 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    
public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}

