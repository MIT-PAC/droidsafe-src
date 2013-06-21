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
    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.930 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Event() {
        super(EVENT);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.930 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "2401AFFBC25EC5F562301AFC5A3BBAE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventType(String eventType) throws ParseException {
        dsTaint.addTaint(eventType);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventType is null");
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(" the eventType is null");
        //this.eventType = eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.930 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "C98A0BA88560DFB15A24DD3ACA4BE028")
    @DSModeled(DSC.SAFE)
    public String getEventType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.930 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "63A5DB9F4613B557167E81BE18D084BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEventId(String eventId) throws ParseException {
        dsTaint.addTaint(eventId);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventId parameter is null");
        setParameter(ParameterNames.ID, eventId);
        // ---------- Original Method ----------
        //if (eventId == null)
            //throw new NullPointerException(" the eventId parameter is null");
        //setParameter(ParameterNames.ID, eventId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.930 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "026D0F36E1AF48B8B731FBE569CE5688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEventId() {
        String var2D9765C3F4419AB5EDAC3A15C9397E4F_846706193 = (getParameter(ParameterNames.ID));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.931 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "840D74DBECCC45828A3AFE6B0B3E2E0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1662775466 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.931 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "5A0A669523702207E725D06B07A577B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(eventType);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_864252044 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (eventType != null)
            //buffer.append(eventType);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //this.parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.931 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "17AEEB78EA37E44215EC2A9A59BBC6B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean match(Event matchTarget) {
        dsTaint.addTaint(matchTarget.dsTaint);
        {
            boolean var45D64371529EB540545235AF8CB73642_1615759448 = (getEventId() == null && matchTarget.getEventId() != null);
            {
                boolean var90D7AD11C3E17CD756B19787A2034463_292852078 = (getEventId() != null && matchTarget.getEventId() == null);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        boolean varF81C3710566A8DAA1CBD8DD685B57C4E_982624327 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
        return dsTaint.getTaintBoolean();
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

    
    private static final long serialVersionUID = -6458387810431874841L;
}

