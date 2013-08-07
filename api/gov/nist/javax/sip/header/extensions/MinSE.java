package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;






public class MinSE extends ParametersHeader implements ExtensionHeader, MinSEHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.813 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.813 -0400", hash_original_method = "FF95F949FD2A1D95680CD0A1163B2941", hash_generated_method = "4E41930010A8369BD320B3492D85970B")
    public  MinSE() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.814 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "7513E685800B7C9710DD9860C14090D5")
    public String encodeBody() {
        String retval = Integer.toString(expires);
        if(!parameters.isEmpty())        
        {
            retval += SEMICOLON + parameters.encode();
        } //End block
String varF9E19AD6135C970F387F77C6F3DE4477_410762751 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_410762751.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_410762751;
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.815 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "6F7519116CAC15CC7279C3AC78716FCF")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_438513671 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_438513671.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_438513671;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.815 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "CCD573350407CA2C2E9ED7C481767CEA")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_1846490968 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413299961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_413299961;
        // ---------- Original Method ----------
        //return expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.816 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "41BA68F4C96595731FE4035FEE4ECD4E")
    public void setExpires(int expires) throws InvalidArgumentException {
        if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_2032091516 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_2032091516.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_2032091516;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.816 -0400", hash_original_field = "F4D2F38DED5855149C9EF7802D2BE091", hash_generated_field = "E1530D0326084B5B0CBC7960EB119C5D")

    public static final String NAME = "Min-SE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.816 -0400", hash_original_field = "2F10AFAED544B12D512EC416C57EE12B", hash_generated_field = "C1F49009315AF076AF05EE2867D3FDEF")

    private static final long serialVersionUID = 3134344915465784267L;
}

