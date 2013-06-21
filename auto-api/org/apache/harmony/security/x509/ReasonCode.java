package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Enumerated;
import org.apache.harmony.security.asn1.ASN1Type;

public final class ReasonCode extends ExtensionValue {
    private byte code;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.911 -0400", hash_original_method = "82F7372CC184C4A16042B3B65BCB1447", hash_generated_method = "AEBBD6E8A4D5ABF185D3BD8215391E66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReasonCode(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        this.code = ((byte[]) ASN1.decode(encoding))[0];
        // ---------- Original Method ----------
        //this.code = ((byte[]) ASN1.decode(encoding))[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.911 -0400", hash_original_method = "410E015295E6E50D0A716577DAE7F9D9", hash_generated_method = "96DD6C047CC40E79615D9F24E1DDBCFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(new byte[] { code });
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(new byte[] { code });
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.911 -0400", hash_original_method = "12E79139137D00D785F5C6D5EDD972F8", hash_generated_method = "52D1EA9D68ECA424256B66FBBB04292B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Reason Code: [ ");
        //Begin case UNSPECIFIED 
        sb.append("unspecified");
        //End case UNSPECIFIED 
        //Begin case KEY_COMPROMISE 
        sb.append("keyCompromise");
        //End case KEY_COMPROMISE 
        //Begin case CA_COMPROMISE 
        sb.append("cACompromise");
        //End case CA_COMPROMISE 
        //Begin case AFFILIATION_CHANGED 
        sb.append("affiliationChanged");
        //End case AFFILIATION_CHANGED 
        //Begin case SUPERSEDED 
        sb.append("superseded");
        //End case SUPERSEDED 
        //Begin case CESSATION_OF_OPERATION 
        sb.append("cessationOfOperation");
        //End case CESSATION_OF_OPERATION 
        //Begin case CERTIFICATE_HOLD 
        sb.append("certificateHold");
        //End case CERTIFICATE_HOLD 
        //Begin case REMOVE_FROM_CRL 
        sb.append("removeFromCRL");
        //End case REMOVE_FROM_CRL 
        //Begin case PRIVILEGE_WITHDRAWN 
        sb.append("privilegeWithdrawn");
        //End case PRIVILEGE_WITHDRAWN 
        //Begin case AA_COMPROMISE 
        sb.append("aACompromise");
        //End case AA_COMPROMISE 
        sb.append(" ]\n");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final byte UNSPECIFIED = 0;
    public static final byte KEY_COMPROMISE = 1;
    public static final byte CA_COMPROMISE = 2;
    public static final byte AFFILIATION_CHANGED = 3;
    public static final byte SUPERSEDED = 4;
    public static final byte CESSATION_OF_OPERATION = 5;
    public static final byte CERTIFICATE_HOLD = 6;
    public static final byte REMOVE_FROM_CRL = 8;
    public static final byte PRIVILEGE_WITHDRAWN = 9;
    public static final byte AA_COMPROMISE = 10;
    public static final ASN1Type ASN1 = ASN1Enumerated.getInstance();
}

