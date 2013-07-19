package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.header.AcceptLanguageHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.684 -0400", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "11DB9C05848E7350775B5746176F17CF")
    public  AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.684 -0400", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "2B1531DF775746F0C118016F8F483666")
    @Override
    public Object clone() {
        AcceptLanguageList retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_551470139 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_551470139.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_551470139;
        // ---------- Original Method ----------
        //AcceptLanguageList retval = new AcceptLanguageList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.685 -0400", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "DF4274CC819A0C699F72404CFF27A02C")
    public AcceptLanguage getFirst() {
        AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        if(retval != null)        
        {
AcceptLanguage varF9E19AD6135C970F387F77C6F3DE4477_2113607288 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2113607288.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2113607288;
        }
        else
        {
AcceptLanguage varE6C39D00C284C00444956A3AA96F5918_165716485 =         new AcceptLanguage();
        varE6C39D00C284C00444956A3AA96F5918_165716485.addTaint(taint);
        return varE6C39D00C284C00444956A3AA96F5918_165716485;
        }
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.685 -0400", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "0DBE0663024309A6956364FBDBA17E85")
    public AcceptLanguage getLast() {
        AcceptLanguage retval = (AcceptLanguage) super.getLast();
        if(retval != null)        
        {
AcceptLanguage varF9E19AD6135C970F387F77C6F3DE4477_194773564 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_194773564.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_194773564;
        }
        else
        {
AcceptLanguage varE6C39D00C284C00444956A3AA96F5918_1210039141 =         new AcceptLanguage();
        varE6C39D00C284C00444956A3AA96F5918_1210039141.addTaint(taint);
        return varE6C39D00C284C00444956A3AA96F5918_1210039141;
        }
        // ---------- Original Method ----------
        //AcceptLanguage retval = (AcceptLanguage) super.getLast();
        //if (retval != null)
            //return retval;
        //else
            //return new AcceptLanguage();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.685 -0400", hash_original_field = "2DC0C9505B6601CC65D202A5B3F50DF0", hash_generated_field = "7EA90335ABAD53EEB534CFBDFF1F0433")

    private static final long serialVersionUID = -3289606805203488840L;
}

