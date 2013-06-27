package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import javax.sip.header.ExtensionHeader;

public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.105 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.106 -0400", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4E41930010A8369BD320B3492D85970B")
    public  MinSE() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.112 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "4D4D4AD357300F038FCFF36F268DB626")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_167044410 = null; //Variable for return #1
        String retval;
        retval = Integer.toString(expires);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_294605605 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_167044410 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_167044410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_167044410;
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.114 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.115 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "2A85772F77AA97B74121ECB01E435296")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390213509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390213509;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.116 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.116 -0400", hash_original_field = "F4D2F38DED5855149C9EF7802D2BE091", hash_generated_field = "E1530D0326084B5B0CBC7960EB119C5D")

    public static final String NAME = "Min-SE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.116 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "53BFCEBE88DAA1CC27A27399F3FE4701")

    private static long serialVersionUID = 3134344915465784267L;
}

