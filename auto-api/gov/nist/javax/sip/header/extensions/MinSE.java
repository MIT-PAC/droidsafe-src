package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import javax.sip.header.ExtensionHeader;

public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.025 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.025 -0400", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4E41930010A8369BD320B3492D85970B")
    public  MinSE() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.026 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "8832AEB4BEB4DB5DD811CFD6EFD4AE60")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_18302069 = null; 
        String retval = Integer.toString(expires);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_679062146 = (!parameters.isEmpty());
            {
                retval += SEMICOLON + parameters.encode();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_18302069 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_18302069.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_18302069;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.027 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.027 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "6F14D6831CFBA48AD2A044267332EEA9")
    public int getExpires() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299666758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299666758;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.027 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "1F94C2B6C4EFAB2003C10C5168D24F2A")
    public void setExpires(int expires) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad argument " + expires);
        this.expires = expires;
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.027 -0400", hash_original_field = "F4D2F38DED5855149C9EF7802D2BE091", hash_generated_field = "E1530D0326084B5B0CBC7960EB119C5D")

    public static final String NAME = "Min-SE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.027 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
}

