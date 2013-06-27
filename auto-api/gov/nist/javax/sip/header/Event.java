package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class Event extends ParametersHeader implements EventHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.960 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.969 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    public  Event() {
        super(EVENT);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.986 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "DA9CA205E48AC787CBDB2DD50CAB270D")
    public void setEventType(String eventType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventType is null");
        this.eventType = eventType;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(" the eventType is null");
        //this.eventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.987 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "94AD49A1E5E130FDA3B3912FA76644CC")
    public String getEventType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1503375619 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1503375619 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_1503375619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1503375619;
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.987 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "8712C4ABB1260592E51136AF233350C6")
    public void setEventId(String eventId) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventId parameter is null");
        setParameter(ParameterNames.ID, eventId);
        addTaint(eventId.getTaint());
        // ---------- Original Method ----------
        //if (eventId == null)
            //throw new NullPointerException(" the eventId parameter is null");
        //setParameter(ParameterNames.ID, eventId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.988 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "0647980363C3BC7D722C72473984F93F")
    public String getEventId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1260582256 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1260582256 = getParameter(ParameterNames.ID);
        varB4EAC82CA7396A68D541C85D26508E83_1260582256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260582256;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.988 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "73B12CE9FF662843AABE65A865C83EBF")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1409051300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1409051300 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1409051300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1409051300;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.990 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "06AD7E9A89D7A2C7BC2AB5B80D341426")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_642906677 = null; //Variable for return #1
        buffer.append(eventType);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_38146884 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_642906677 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_642906677.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_642906677;
        // ---------- Original Method ----------
        //if (eventType != null)
            //buffer.append(eventType);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //this.parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.990 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "7A0E453F88C4C0B9CF04F34145FB81D6")
    public boolean match(Event matchTarget) {
        {
            boolean var45D64371529EB540545235AF8CB73642_699208687 = (getEventId() == null && matchTarget.getEventId() != null);
            {
                boolean var90D7AD11C3E17CD756B19787A2034463_740258071 = (getEventId() != null && matchTarget.getEventId() == null);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        boolean varF81C3710566A8DAA1CBD8DD685B57C4E_1819469115 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
        addTaint(matchTarget.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723035097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723035097;
        // ---------- Original Method ----------
        //if (matchTarget.eventType == null && this.eventType != null)
            //return false;
        //else if (matchTarget.eventType != null && this.eventType == null)
            //return false;
        //else if (this.eventType == null && matchTarget.eventType == null)
            //return false;
        //else if (getEventId() == null && matchTarget.getEventId() != null)
            //return false;
        //else if (getEventId() != null && matchTarget.getEventId() == null)
            //return false;
        //return matchTarget.eventType.equalsIgnoreCase(this.eventType)
            //&& ((this.getEventId() == matchTarget.getEventId())
                //|| this.getEventId().equalsIgnoreCase(matchTarget.getEventId()));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.990 -0400", hash_original_field = "C15D83E5CFF4F10DB607135176CA639C", hash_generated_field = "1BF66545D3A696899826185EC8EDDDD0")

    private static long serialVersionUID = -6458387810431874841L;
}

