package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public final class Accept extends ParametersHeader implements javax.sip.header.AcceptHeader {
    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.629 -0400", hash_original_method = "4311F842678DE87ACCC1A689A829FC2C", hash_generated_method = "078F21FB6AC134D27AFE15A2BEB94126")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Accept() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.629 -0400", hash_original_method = "B50D7EE39281F850FBFCC110ACB58D68", hash_generated_method = "9DA5D3F92CFE0B9348602ED28CD15D27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allowsAllContentTypes() {
        boolean var64DDE92D495F783D40417AA9F67FACBC_1456495714 = (mediaRange.type.compareTo(STAR) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return false;
        //else
            //return mediaRange.type.compareTo(STAR) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.629 -0400", hash_original_method = "A0A0F085E1B8E4ED63796A6BDE3F17D2", hash_generated_method = "4B17DC48DB1E5B469A82ED62CE68CC48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allowsAllContentSubTypes() {
        boolean var845E1A09F821006DFE97BDC77E980731_195833469 = (mediaRange.getSubtype().compareTo(STAR) == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mediaRange == null) {
            //return false;
        //} else
            //return mediaRange.getSubtype().compareTo(STAR) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.629 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "C15F6645DCB91779995DA7FDFA8D9F12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_592438642 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "2E9CDABA864012CB945701B1775B2668", hash_generated_method = "EBC43E2A533761C4D7DCD33C2E6F81A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        mediaRange.encode(buffer);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1037380424 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(';');
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mediaRange != null)
            //mediaRange.encode(buffer);
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(';');
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "4EAD22EF415BE692AD7FB9E4BB2368F8")
    @DSModeled(DSC.SAFE)
    public MediaRange getMediaRange() {
        return (MediaRange)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "44E6E041E8AD4F7B067250B3E11E39C2", hash_generated_method = "8081FA3312AC9602052FAEEDDB017175")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentType() {
        String var5DA10DF9F3BB98BD917EDDD88CF3568C_1384906006 = (mediaRange.getType());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "F0A4743083D481DF1A54A7DBA5F4C599", hash_generated_method = "776F4DA35A9EB62EC386A7FE546F799A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getContentSubType() {
        String var376FAA1381402F23E203922D47D049ED_800879148 = (mediaRange.getSubtype());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getSubtype();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "2956E51B04B3FEA729EF44EFAC0B4B09", hash_generated_method = "8C4634F13D00F82C32FDC576C815164B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getQValue() {
        float varFCCDE4ED6E8958DC6B6334A756EC9BB0_813885534 = (getParameterAsFloat(ParameterNames.Q));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getParameterAsFloat(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "43FA513912350854847003FDB290D6C5", hash_generated_method = "FA3F6FA420203A2EA7CE6F2E365F01FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasQValue() {
        boolean varA8464ED772B5E00402FF5E0AA2A3D240_1720722184 = (super.hasParameter(ParameterNames.Q));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.hasParameter(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.630 -0400", hash_original_method = "BF4B60E4788A555E5EC3F45CB4B13E83", hash_generated_method = "89EF342CEBC3F79A086D3DD96679DCC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeQValue() {
        super.removeParameter(ParameterNames.Q);
        // ---------- Original Method ----------
        //super.removeParameter(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.631 -0400", hash_original_method = "812F213530DE805FDEF52FE413B9F204", hash_generated_method = "78F12184D3EA9A7BA0CFF3A8DD29EACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentSubType(String subtype) {
        dsTaint.addTaint(subtype);
        mediaRange = new MediaRange();
        mediaRange.setSubtype(subtype);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(subtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.631 -0400", hash_original_method = "6381E85A55588E15B8DC137B6EE66A93", hash_generated_method = "9EE1A8DB91B94575FFDDC8315CA1FA4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentType(String type) {
        dsTaint.addTaint(type);
        mediaRange = new MediaRange();
        mediaRange.setType(type);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.631 -0400", hash_original_method = "E4B2DA5B904DBFAB5481CDBAB5D46DBA", hash_generated_method = "AD07DA22C062460D727B2110F0ABAF76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQValue(float qValue) throws InvalidArgumentException {
        dsTaint.addTaint(qValue);
        super.removeParameter(ParameterNames.Q);
        super.setParameter(ParameterNames.Q, qValue);
        // ---------- Original Method ----------
        //if (qValue == -1)
            //super.removeParameter(ParameterNames.Q);
        //super.setParameter(ParameterNames.Q, qValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.631 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "2E62B77BB68A7FC60960883C990D9F70")
    @DSModeled(DSC.SAFE)
    public void setMediaRange(MediaRange m) {
        dsTaint.addTaint(m.dsTaint);
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.631 -0400", hash_original_method = "0EF41097CC41F1F6A85A85E560745DC8", hash_generated_method = "740468001F326A5FB9CCAFDAE8A4993B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Accept retval;
        retval = (Accept) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Accept retval = (Accept) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -7866187924308658151L;
}

