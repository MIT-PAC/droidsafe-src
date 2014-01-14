package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public final class AlternativeName extends ExtensionValue {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.717 -0500", hash_original_field = "CBB1706FA59C7E15342C93018C8CFC52", hash_generated_field = "FD153840F9D7B8B665F7ED602C76121F")

    // by this object
    public static final boolean ISSUER = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.720 -0500", hash_original_field = "F1348733A100C28BFB2709A7B3083355", hash_generated_field = "936E14E3BE58C80A27331B11D5D14123")

    public static final boolean SUBJECT = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.722 -0500", hash_original_field = "FBECE0D7B468AE64F390034873B4558D", hash_generated_field = "146204F60619F6B5AD05FE88D008D17D")

    private boolean which;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.724 -0500", hash_original_field = "5CB3AB8BFD3E1ED9D018C93F3EB8ED2D", hash_generated_field = "2EF7A1335D6CE946FADF8342BE852EA9")

    private GeneralNames alternativeNames;

    /**
     * Creates the extension object on the base of its encoded form.
     * @param which specifies which alternative names are given
     * (Subject's or Issuer's)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.727 -0500", hash_original_method = "1E01F580CB089394F15961B5A9E514F5", hash_generated_method = "C52CE02B17695298AAA11044E27D9872")
    
public AlternativeName(boolean which, byte[] encoding) throws IOException {
        super(encoding);
        this.which = which;
        this.alternativeNames = (GeneralNames) GeneralNames.ASN1.decode(encoding);
    }

    /**
     * Returns ASN.1 encoded form of this X.509 AlternativeName value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.729 -0500", hash_original_method = "A70D2DB25ABF0E0F1A8BC79C0C161D91", hash_generated_method = "3C321A36632237FCFC346BED27B4846F")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = GeneralNames.ASN1.encode(alternativeNames);
        }
        return encoding;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.731 -0500", hash_original_method = "62E9965B6B09CF0D2F916BAB455CC9AA", hash_generated_method = "A849C735DE47F0D40BB4C8459BD22AED")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append((which) ? "Subject" : "Issuer").append(" Alternative Names [\n");
        alternativeNames.dumpValue(sb, prefix + "  ");
        sb.append(prefix).append("]\n");
    }
}

