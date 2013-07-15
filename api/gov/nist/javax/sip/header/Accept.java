package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;

public final class Accept extends ParametersHeader implements javax.sip.header.AcceptHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.633 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.634 -0400", hash_original_method = "4311F842678DE87ACCC1A689A829FC2C", hash_generated_method = "078F21FB6AC134D27AFE15A2BEB94126")
    public  Accept() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.634 -0400", hash_original_method = "B50D7EE39281F850FBFCC110ACB58D68", hash_generated_method = "579EF1DF2F30795068D5EB66E85810D8")
    public boolean allowsAllContentTypes() {
    if(mediaRange == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_966639130 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456032148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456032148;
        }
        else
        {
        boolean var90E206375514C913D083106CFA6CFC88_454409328 = (mediaRange.type.compareTo(STAR) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051733235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051733235;
        }
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return false;
        //else
            //return mediaRange.type.compareTo(STAR) == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.635 -0400", hash_original_method = "A0A0F085E1B8E4ED63796A6BDE3F17D2", hash_generated_method = "0588A29890751F988A1514C26E1A0951")
    public boolean allowsAllContentSubTypes() {
    if(mediaRange == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1376123909 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649739082 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_649739082;
        } //End block
        else
        {
        boolean varE47320815CB2B08BC1CCD3925631C8E2_243587290 = (mediaRange.getSubtype().compareTo(STAR) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312780945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312780945;
        }
        // ---------- Original Method ----------
        //if (mediaRange == null) {
            //return false;
        //} else
            //return mediaRange.getSubtype().compareTo(STAR) == 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.635 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "73744BA2B1BF9E93AAF82E8DE7BAF515")
    protected String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_177498422 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_177498422.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_177498422;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.636 -0400", hash_original_method = "2E9CDABA864012CB945701B1775B2668", hash_generated_method = "3E5ABD31ACA8F250B5B551E42D72744E")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(mediaRange != null)        
        mediaRange.encode(buffer);
    if(parameters != null && !parameters.isEmpty())        
        {
            buffer.append(';');
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_17789004 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_17789004.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_17789004;
        // ---------- Original Method ----------
        //if (mediaRange != null)
            //mediaRange.encode(buffer);
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(';');
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.636 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "2CEEC17911B94115D465099CBFCDDBB1")
    public MediaRange getMediaRange() {
MediaRange varF0641D8BD2A6E7A6B70BF4AB4A7ED980_1574649872 =         mediaRange;
        varF0641D8BD2A6E7A6B70BF4AB4A7ED980_1574649872.addTaint(taint);
        return varF0641D8BD2A6E7A6B70BF4AB4A7ED980_1574649872;
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.636 -0400", hash_original_method = "44E6E041E8AD4F7B067250B3E11E39C2", hash_generated_method = "E17A54C586A07A15A3FD5444D89D0419")
    public String getContentType() {
    if(mediaRange == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2004823581 =         null;
        var540C13E9E156B687226421B24F2DF178_2004823581.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2004823581;
        }
        else
        {
String varBE7CEA1AED9255E3CEB9DE67727E4D55_348960877 =         mediaRange.getType();
        varBE7CEA1AED9255E3CEB9DE67727E4D55_348960877.addTaint(taint);
        return varBE7CEA1AED9255E3CEB9DE67727E4D55_348960877;
        }
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getType();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.637 -0400", hash_original_method = "F0A4743083D481DF1A54A7DBA5F4C599", hash_generated_method = "BA586B34D78D91B2C3E15DBE206294BC")
    public String getContentSubType() {
    if(mediaRange == null)        
        {
String var540C13E9E156B687226421B24F2DF178_257479435 =         null;
        var540C13E9E156B687226421B24F2DF178_257479435.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_257479435;
        }
        else
        {
String varD3ACE00ECCF711AACD3A2776FDD4FB3F_1674536508 =         mediaRange.getSubtype();
        varD3ACE00ECCF711AACD3A2776FDD4FB3F_1674536508.addTaint(taint);
        return varD3ACE00ECCF711AACD3A2776FDD4FB3F_1674536508;
        }
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getSubtype();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.637 -0400", hash_original_method = "2956E51B04B3FEA729EF44EFAC0B4B09", hash_generated_method = "96803071AB72F5F5CEFC313E647CE72E")
    public float getQValue() {
        float var7A25F492305572B004A678BA9268B425_41386667 = (getParameterAsFloat(ParameterNames.Q));
                float var546ADE640B6EDFBC8A086EF31347E768_1217574040 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1217574040;
        // ---------- Original Method ----------
        //return getParameterAsFloat(ParameterNames.Q);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.637 -0400", hash_original_method = "43FA513912350854847003FDB290D6C5", hash_generated_method = "308C2F5B44EDFC1738B47DA13C180F1B")
    public boolean hasQValue() {
        boolean var36AF058309954913D86A35585192382F_934762613 = (super.hasParameter(ParameterNames.Q));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242112197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242112197;
        // ---------- Original Method ----------
        //return super.hasParameter(ParameterNames.Q);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.637 -0400", hash_original_method = "BF4B60E4788A555E5EC3F45CB4B13E83", hash_generated_method = "89EF342CEBC3F79A086D3DD96679DCC5")
    public void removeQValue() {
        super.removeParameter(ParameterNames.Q);
        // ---------- Original Method ----------
        //super.removeParameter(ParameterNames.Q);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.638 -0400", hash_original_method = "812F213530DE805FDEF52FE413B9F204", hash_generated_method = "1D5132351266E178D3968AE956A1F095")
    public void setContentSubType(String subtype) {
        addTaint(subtype.getTaint());
    if(mediaRange == null)        
        mediaRange = new MediaRange();
        mediaRange.setSubtype(subtype);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(subtype);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.638 -0400", hash_original_method = "6381E85A55588E15B8DC137B6EE66A93", hash_generated_method = "DEC21F083A4AFA0AA29B41A4933658F0")
    public void setContentType(String type) {
        addTaint(type.getTaint());
    if(mediaRange == null)        
        mediaRange = new MediaRange();
        mediaRange.setType(type);
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.638 -0400", hash_original_method = "E4B2DA5B904DBFAB5481CDBAB5D46DBA", hash_generated_method = "802C78AB4B91409241D13F2737E03684")
    public void setQValue(float qValue) throws InvalidArgumentException {
        addTaint(qValue);
    if(qValue == -1)        
        super.removeParameter(ParameterNames.Q);
        super.setParameter(ParameterNames.Q, qValue);
        // ---------- Original Method ----------
        //if (qValue == -1)
            //super.removeParameter(ParameterNames.Q);
        //super.setParameter(ParameterNames.Q, qValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.639 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.639 -0400", hash_original_method = "0EF41097CC41F1F6A85A85E560745DC8", hash_generated_method = "61CE536146D939803519CEAD3C97EB62")
    public Object clone() {
        Accept retval = (Accept) super.clone();
    if(this.mediaRange != null)        
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1286405480 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1286405480.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1286405480;
        // ---------- Original Method ----------
        //Accept retval = (Accept) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.639 -0400", hash_original_field = "9F9BCA318B9143C3A7133286BB978428", hash_generated_field = "67A05C878CFE3A4D19A95E223075CE16")

    private static final long serialVersionUID = -7866187924308658151L;
}

