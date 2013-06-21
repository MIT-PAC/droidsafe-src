package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MediaRange extends SIPObject {
    protected String type;
    protected String subtype;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.013 -0400", hash_original_method = "A8D138215FF2330241D1163A7469BE2F", hash_generated_method = "94D7E99B7301CFEA2E8CC360FD81F551")
    @DSModeled(DSC.SAFE)
    public MediaRange() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.013 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "AC38FD6D562C8CFA3E5E586F21D2F37D")
    @DSModeled(DSC.SAFE)
    public String getType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.014 -0400", hash_original_method = "F553636983A7698A0C67E9F36C861E72", hash_generated_method = "BA3875105663A7762A0152605D06420E")
    @DSModeled(DSC.SAFE)
    public String getSubtype() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return subtype;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.014 -0400", hash_original_method = "1F9FAB648DA6511C86522C3730D40F12", hash_generated_method = "36523E48FA26F437A6C72D55CFCA969E")
    @DSModeled(DSC.SAFE)
    public void setType(String t) {
        dsTaint.addTaint(t);
        // ---------- Original Method ----------
        //type = t;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.014 -0400", hash_original_method = "3A0BB05139828A93AF0155E2224A9877", hash_generated_method = "4C9D234E1C540F6EC1A89B2B2B45E545")
    @DSModeled(DSC.SAFE)
    public void setSubtype(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //subtype = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.014 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1911F343B3E4264CE9413A7C18CFA369")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_1842270486 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.014 -0400", hash_original_method = "65E8BB72BD507B7E1F69F2EFA7F6C332", hash_generated_method = "91B7C91E865572245C57FFE9DF73CD63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        StringBuffer var30442E915656923DAAC2376524EFEB7E_1596815517 = (buffer.append(type)
                .append(SLASH)
                .append(subtype));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return buffer.append(type)
                //.append(SLASH)
                //.append(subtype);
    }

    
    private static final long serialVersionUID = -6297125815438079210L;
}

