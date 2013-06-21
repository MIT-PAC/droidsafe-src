package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Type;

public final class CRLNumber extends ExtensionValue {
    private BigInteger number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.562 -0400", hash_original_method = "F2D26D3BB1859BB9D7AC567B8EA30F7D", hash_generated_method = "082926ACA83A090DCCD7B1E74481CFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CRLNumber(byte[] encoding) throws IOException {
        super(encoding);
        dsTaint.addTaint(encoding[0]);
        number = new BigInteger((byte[]) ASN1.decode(encoding));
        // ---------- Original Method ----------
        //number = new BigInteger((byte[]) ASN1.decode(encoding));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.563 -0400", hash_original_method = "ABBA63B4278019F3F838A8B1357B04F0", hash_generated_method = "4FFC86E0F2B0F29A9AE01DDE5035CB4A")
    @DSModeled(DSC.SAFE)
    public BigInteger getNumber() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return number;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.563 -0400", hash_original_method = "264373D11CB6B7A95DC9A45E336ACDCB", hash_generated_method = "7ECF529574E3920794282C2210C70BCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(number.toByteArray());
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(number.toByteArray());
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.563 -0400", hash_original_method = "C82E67A30D76F52198943C49A8E53C0F", hash_generated_method = "F785CC7A040BFD2B0D1DDD3E70F82522")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("CRL Number: [ ").append(number).append(" ]\n");
    }

    
    public static final ASN1Type ASN1 = ASN1Integer.getInstance();
}

