package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.690 -0400", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "11DB9C05848E7350775B5746176F17CF")
    public  AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.691 -0400", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "17A2BA5FCCCB6DF5BD378811E637D73B")
    @Override
    public Object clone() {
        AcceptLanguageList retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1949219861 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1949219861.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1949219861;
        // ---------- Original Method ----------
        //AcceptLanguageList retval = new AcceptLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.691 -0400", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "883A2F371ED0926AD57062F1BF4912B4")
    public AcceptLanguage getFirst() {
        AcceptLanguage retval = (AcceptLanguage) super.getFirst();
    if(retval != null)        
        {
AcceptLanguage varF9E19AD6135C970F387F77C6F3DE4477_567250190 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_567250190.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_567250190;
        }
        else
        {
AcceptLanguage varE6C39D00C284C00444956A3AA96F5918_1568613459 =         new AcceptLanguage();
        varE6C39D00C284C00444956A3AA96F5918_1568613459.addTaint(taint);
        return varE6C39D00C284C00444956A3AA96F5918_1568613459;
        }
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.691 -0400", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "B1A8A7FB049CDCA724D68206AC7CAB02")
    public AcceptLanguage getLast() {
        AcceptLanguage retval = (AcceptLanguage) super.getLast();
    if(retval != null)        
        {
AcceptLanguage varF9E19AD6135C970F387F77C6F3DE4477_457527595 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_457527595.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_457527595;
        }
        else
        {
AcceptLanguage varE6C39D00C284C00444956A3AA96F5918_2051898570 =         new AcceptLanguage();
        varE6C39D00C284C00444956A3AA96F5918_2051898570.addTaint(taint);
        return varE6C39D00C284C00444956A3AA96F5918_2051898570;
        }
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getLast();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.692 -0400", hash_original_field = "2DC0C9505B6601CC65D202A5B3F50DF0", hash_generated_field = "7EA90335ABAD53EEB534CFBDFF1F0433")

    private static final long serialVersionUID = -3289606805203488840L;
}

