package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.EventHeader;






public class Event extends ParametersHeader implements EventHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.355 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.355 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    public  Event() {
        super(EVENT);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.356 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "692CCEA9A62E7AD5753DBDBCE9557A7F")
    public void setEventType(String eventType) throws ParseException {
        if(eventType == null)        
        {
        NullPointerException var8D078570FE4A445E59E55801636CD094_1170619067 = new NullPointerException(" the eventType is null");
        var8D078570FE4A445E59E55801636CD094_1170619067.addTaint(taint);
        throw var8D078570FE4A445E59E55801636CD094_1170619067;
        }
        this.eventType = eventType;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(" the eventType is null");
        //this.eventType = eventType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.357 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "B0ABEE8EAA2EC9066BF65D40313559BF")
    public String getEventType() {
String var9BA45280620AE5369B32F31629C1D3A0_1579070431 =         eventType;
        var9BA45280620AE5369B32F31629C1D3A0_1579070431.addTaint(taint);
        return var9BA45280620AE5369B32F31629C1D3A0_1579070431;
        // ---------- Original Method ----------
        //return eventType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.357 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "7C1298E650F102F73914FC80DA2A2D71")
    public void setEventId(String eventId) throws ParseException {
        addTaint(eventId.getTaint());
        if(eventId == null)        
        {
        NullPointerException var9179565D5C854E15CF86FA10A65340FA_509754100 = new NullPointerException(" the eventId parameter is null");
        var9179565D5C854E15CF86FA10A65340FA_509754100.addTaint(taint);
        throw var9179565D5C854E15CF86FA10A65340FA_509754100;
        }
        setParameter(ParameterNames.ID, eventId);
        // ---------- Original Method ----------
        //if (eventId == null)
            //throw new NullPointerException(" the eventId parameter is null");
        //setParameter(ParameterNames.ID, eventId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.357 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "0FB4A00FC6DFB4C29C4BD68D8B4304CF")
    public String getEventId() {
String varB7F1BC93A3AA1A1C6B16961CD90C179C_1170821126 =         getParameter(ParameterNames.ID);
        varB7F1BC93A3AA1A1C6B16961CD90C179C_1170821126.addTaint(taint);
        return varB7F1BC93A3AA1A1C6B16961CD90C179C_1170821126;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ID);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.358 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "2D347E0730A8287F80DCC12C00E5186D")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1772872945 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1772872945.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1772872945;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.358 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "BD45CD50190DDCF0D873888EE64A4902")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(eventType != null)        
        buffer.append(eventType);
        if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1994884216 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1994884216.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1994884216;
        // ---------- Original Method ----------
        //if (eventType != null)
            //buffer.append(eventType);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //this.parameters.encode(buffer);
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.359 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "A431C53B54B79F570EE094305CE41A9B")
    public boolean match(Event matchTarget) {
        addTaint(matchTarget.getTaint());
        if(matchTarget.eventType == null && this.eventType != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_356948704 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933822688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933822688;
        }
        else
        if(matchTarget.eventType != null && this.eventType == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_459207963 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003627460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003627460;
        }
        else
        if(this.eventType == null && matchTarget.eventType == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1791510512 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1824986023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1824986023;
        }
        else
        if(getEventId() == null && matchTarget.getEventId() != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2551716 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351016697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351016697;
        }
        else
        if(getEventId() != null && matchTarget.getEventId() == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1048135117 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_143570849 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_143570849;
        }
        boolean varBEC522F09B916BA3BE3AF6F7E2E85589_1122265994 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276721699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276721699;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.359 -0400", hash_original_field = "C15D83E5CFF4F10DB607135176CA639C", hash_generated_field = "63F6460E52154D5BD98308ED4780F1F5")

    private static final long serialVersionUID = -6458387810431874841L;
}

