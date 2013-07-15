package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.*;
import javax.sip.header.ExtensionHeader;

public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.712 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.713 -0400", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4E41930010A8369BD320B3492D85970B")
    public  MinSE() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.713 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "7D76788F459776379C0C29E1D15FA6D2")
    public String encodeBody() {
        String retval = Integer.toString(expires);
    if(!parameters.isEmpty())        
        {
            retval += SEMICOLON + parameters.encode();
        } //End block
String varF9E19AD6135C970F387F77C6F3DE4477_733151534 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_733151534.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_733151534;
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.714 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "B14436B77303963D02FEFFE26EE215A7")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_747876608 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_747876608.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_747876608;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.714 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "2EF32E3D8796B4888CF799F65F9B06D4")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_176595072 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375915159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375915159;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.715 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "C1478A5718DFCA03DD72C668B1830225")
    public void setExpires(int expires) throws InvalidArgumentException {
    if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_111801643 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_111801643.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_111801643;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.715 -0400", hash_original_field = "F4D2F38DED5855149C9EF7802D2BE091", hash_generated_field = "E1530D0326084B5B0CBC7960EB119C5D")

    public static final String NAME = "Min-SE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.716 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
}

