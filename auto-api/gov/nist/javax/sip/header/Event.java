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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.978 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.983 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    public  Event() {
        super(EVENT);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.984 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "DA9CA205E48AC787CBDB2DD50CAB270D")
    public void setEventType(String eventType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventType is null");
        this.eventType = eventType;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(" the eventType is null");
        //this.eventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.984 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "FF7C59714564DB7C8DDC41382E14FE50")
    public String getEventType() {
        String varB4EAC82CA7396A68D541C85D26508E83_797025403 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_797025403 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_797025403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_797025403;
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.984 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "8712C4ABB1260592E51136AF233350C6")
    public void setEventId(String eventId) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventId parameter is null");
        setParameter(ParameterNames.ID, eventId);
        addTaint(eventId.getTaint());
        // ---------- Original Method ----------
        //if (eventId == null)
            //throw new NullPointerException(" the eventId parameter is null");
        //setParameter(ParameterNames.ID, eventId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.985 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "AA810D2ABA0815F7845735A7672297EC")
    public String getEventId() {
        String varB4EAC82CA7396A68D541C85D26508E83_909343754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_909343754 = getParameter(ParameterNames.ID);
        varB4EAC82CA7396A68D541C85D26508E83_909343754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909343754;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.985 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "6DEF502850D882ADB0F890DD1361DD66")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_881593449 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_881593449 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_881593449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881593449;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.997 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "575484DF73AD7E56DAEB5F1A3EF8FBFC")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1714890866 = null; //Variable for return #1
        buffer.append(eventType);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_497556105 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1714890866 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1714890866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1714890866;
        // ---------- Original Method ----------
        //if (eventType != null)
            //buffer.append(eventType);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //this.parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.997 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "1B715B4111C76498A5CB2B172E938342")
    public boolean match(Event matchTarget) {
        {
            boolean var45D64371529EB540545235AF8CB73642_1776059774 = (getEventId() == null && matchTarget.getEventId() != null);
            {
                boolean var90D7AD11C3E17CD756B19787A2034463_289283132 = (getEventId() != null && matchTarget.getEventId() == null);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        boolean varF81C3710566A8DAA1CBD8DD685B57C4E_1165316531 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
        addTaint(matchTarget.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256805888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_256805888;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.997 -0400", hash_original_field = "C15D83E5CFF4F10DB607135176CA639C", hash_generated_field = "1BF66545D3A696899826185EC8EDDDD0")

    private static long serialVersionUID = -6458387810431874841L;
}

