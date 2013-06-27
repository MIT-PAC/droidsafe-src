package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public final class Accept extends ParametersHeader implements javax.sip.header.AcceptHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.062 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.063 -0400", hash_original_method = "4311F842678DE87ACCC1A689A829FC2C", hash_generated_method = "078F21FB6AC134D27AFE15A2BEB94126")
    public  Accept() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.064 -0400", hash_original_method = "B50D7EE39281F850FBFCC110ACB58D68", hash_generated_method = "9610D3D32723C9E698946034A635944D")
    public boolean allowsAllContentTypes() {
        boolean var64DDE92D495F783D40417AA9F67FACBC_2011000165 = (mediaRange.type.compareTo(STAR) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1639377340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1639377340;
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return false;
        //else
            //return mediaRange.type.compareTo(STAR) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.064 -0400", hash_original_method = "A0A0F085E1B8E4ED63796A6BDE3F17D2", hash_generated_method = "E9CF5B28E2E91E3EFEA693971C9F1798")
    public boolean allowsAllContentSubTypes() {
        boolean var845E1A09F821006DFE97BDC77E980731_765038281 = (mediaRange.getSubtype().compareTo(STAR) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526672419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526672419;
        // ---------- Original Method ----------
        //if (mediaRange == null) {
            //return false;
        //} else
            //return mediaRange.getSubtype().compareTo(STAR) == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.065 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "DE7B3E28B50FC413E9054E7564BABB67")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_21209313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_21209313 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_21209313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_21209313;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.073 -0400", hash_original_method = "2E9CDABA864012CB945701B1775B2668", hash_generated_method = "A3E88A809E68CCAA0E6FE48190D3F636")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1356619059 = null; //Variable for return #1
        mediaRange.encode(buffer);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_174646882 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(';');
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1356619059 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1356619059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1356619059;
        // ---------- Original Method ----------
        //if (mediaRange != null)
            //mediaRange.encode(buffer);
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(';');
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.085 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "FDC89008A892F06F0B095CB7914D5BAF")
    public MediaRange getMediaRange() {
        MediaRange varB4EAC82CA7396A68D541C85D26508E83_72813172 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_72813172 = mediaRange;
        varB4EAC82CA7396A68D541C85D26508E83_72813172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_72813172;
        // ---------- Original Method ----------
        //return mediaRange;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.086 -0400", hash_original_method = "44E6E041E8AD4F7B067250B3E11E39C2", hash_generated_method = "3DCC22F1189B9D88FAD22293050712D9")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_797962944 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1453010830 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_797962944 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1453010830 = mediaRange.getType();
        String varA7E53CE21691AB073D9660D615818899_999208457; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_999208457 = varB4EAC82CA7396A68D541C85D26508E83_797962944;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_999208457 = varB4EAC82CA7396A68D541C85D26508E83_1453010830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_999208457.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_999208457;
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.086 -0400", hash_original_method = "F0A4743083D481DF1A54A7DBA5F4C599", hash_generated_method = "E7A7F7C839CB2852783CF8A2192A1652")
    public String getContentSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_115017232 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1426779116 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_115017232 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1426779116 = mediaRange.getSubtype();
        String varA7E53CE21691AB073D9660D615818899_1223709494; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1223709494 = varB4EAC82CA7396A68D541C85D26508E83_115017232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1223709494 = varB4EAC82CA7396A68D541C85D26508E83_1426779116;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1223709494.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1223709494;
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //return null;
        //else
            //return mediaRange.getSubtype();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.086 -0400", hash_original_method = "2956E51B04B3FEA729EF44EFAC0B4B09", hash_generated_method = "80667AD7A96207DC72F5AC5A6A1772CB")
    public float getQValue() {
        float varFCCDE4ED6E8958DC6B6334A756EC9BB0_563235 = (getParameterAsFloat(ParameterNames.Q));
        float var546ADE640B6EDFBC8A086EF31347E768_479976336 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_479976336;
        // ---------- Original Method ----------
        //return getParameterAsFloat(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.087 -0400", hash_original_method = "43FA513912350854847003FDB290D6C5", hash_generated_method = "323D348027F96C99BE855B50997E22A7")
    public boolean hasQValue() {
        boolean varA8464ED772B5E00402FF5E0AA2A3D240_1736232134 = (super.hasParameter(ParameterNames.Q));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423564422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423564422;
        // ---------- Original Method ----------
        //return super.hasParameter(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.087 -0400", hash_original_method = "BF4B60E4788A555E5EC3F45CB4B13E83", hash_generated_method = "89EF342CEBC3F79A086D3DD96679DCC5")
    public void removeQValue() {
        super.removeParameter(ParameterNames.Q);
        // ---------- Original Method ----------
        //super.removeParameter(ParameterNames.Q);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.087 -0400", hash_original_method = "812F213530DE805FDEF52FE413B9F204", hash_generated_method = "1CBB0A59F6E745D67FD31DA1C8332E48")
    public void setContentSubType(String subtype) {
        mediaRange = new MediaRange();
        mediaRange.setSubtype(subtype);
        addTaint(subtype.getTaint());
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setSubtype(subtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.092 -0400", hash_original_method = "6381E85A55588E15B8DC137B6EE66A93", hash_generated_method = "B6E555F4520B093CCD5B4242AA516043")
    public void setContentType(String type) {
        mediaRange = new MediaRange();
        mediaRange.setType(type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //if (mediaRange == null)
            //mediaRange = new MediaRange();
        //mediaRange.setType(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.093 -0400", hash_original_method = "E4B2DA5B904DBFAB5481CDBAB5D46DBA", hash_generated_method = "3FA4205ACD2550423F1FE6C948A2B8C3")
    public void setQValue(float qValue) throws InvalidArgumentException {
        super.removeParameter(ParameterNames.Q);
        super.setParameter(ParameterNames.Q, qValue);
        addTaint(qValue);
        // ---------- Original Method ----------
        //if (qValue == -1)
            //super.removeParameter(ParameterNames.Q);
        //super.setParameter(ParameterNames.Q, qValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.105 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        // ---------- Original Method ----------
        //mediaRange = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.113 -0400", hash_original_method = "0EF41097CC41F1F6A85A85E560745DC8", hash_generated_method = "D8C23D8FA7D25038F57C6F0FD22B0EED")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1634119858 = null; //Variable for return #1
        Accept retval;
        retval = (Accept) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1634119858 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1634119858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634119858;
        // ---------- Original Method ----------
        //Accept retval = (Accept) super.clone();
        //if (this.mediaRange != null)
            //retval.mediaRange = (MediaRange) this.mediaRange.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.114 -0400", hash_original_field = "9F9BCA318B9143C3A7133286BB978428", hash_generated_field = "EF7DBC23F0DB92B79D4002DEEE32F7CE")

    private static long serialVersionUID = -7866187924308658151L;
}

