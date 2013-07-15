package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.text.ParseException;

public class Event extends ParametersHeader implements EventHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.361 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.361 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    public  Event() {
        super(EVENT);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.362 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "9DF290A81FBCF2984840D442A94CE807")
    public void setEventType(String eventType) throws ParseException {
    if(eventType == null)        
        {
        NullPointerException var8D078570FE4A445E59E55801636CD094_1376737336 = new NullPointerException(" the eventType is null");
        var8D078570FE4A445E59E55801636CD094_1376737336.addTaint(taint);
        throw var8D078570FE4A445E59E55801636CD094_1376737336;
        }
        this.eventType = eventType;
        // ---------- Original Method ----------
        //if (eventType == null)
            //throw new NullPointerException(" the eventType is null");
        //this.eventType = eventType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.362 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "52E825DAB02F054F579F394E77AC4895")
    public String getEventType() {
String var9BA45280620AE5369B32F31629C1D3A0_1654515527 =         eventType;
        var9BA45280620AE5369B32F31629C1D3A0_1654515527.addTaint(taint);
        return var9BA45280620AE5369B32F31629C1D3A0_1654515527;
        // ---------- Original Method ----------
        //return eventType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.362 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "3BA65B6249F3CD04E4E95EF888B6FB0C")
    public void setEventId(String eventId) throws ParseException {
        addTaint(eventId.getTaint());
    if(eventId == null)        
        {
        NullPointerException var9179565D5C854E15CF86FA10A65340FA_1317583139 = new NullPointerException(" the eventId parameter is null");
        var9179565D5C854E15CF86FA10A65340FA_1317583139.addTaint(taint);
        throw var9179565D5C854E15CF86FA10A65340FA_1317583139;
        }
        setParameter(ParameterNames.ID, eventId);
        // ---------- Original Method ----------
        //if (eventId == null)
            //throw new NullPointerException(" the eventId parameter is null");
        //setParameter(ParameterNames.ID, eventId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.363 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "C7812EEDE746B51B782A5943DF4D6BCB")
    public String getEventId() {
String varB7F1BC93A3AA1A1C6B16961CD90C179C_1347258213 =         getParameter(ParameterNames.ID);
        varB7F1BC93A3AA1A1C6B16961CD90C179C_1347258213.addTaint(taint);
        return varB7F1BC93A3AA1A1C6B16961CD90C179C_1347258213;
        // ---------- Original Method ----------
        //return getParameter(ParameterNames.ID);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.363 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "6C8DBFA1D938B1D2F16A7812504823FB")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_421913878 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_421913878.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_421913878;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.363 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "087B6EC54F8A0339F6603E17E8115DBF")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(eventType != null)        
        buffer.append(eventType);
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            this.parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1590821149 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1590821149.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1590821149;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.364 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "93E9EC0D59B759954FD18A17355E857B")
    public boolean match(Event matchTarget) {
        addTaint(matchTarget.getTaint());
    if(matchTarget.eventType == null && this.eventType != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_182772473 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438276166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438276166;
        }
        else
    if(matchTarget.eventType != null && this.eventType == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1427037049 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139798254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139798254;
        }
        else
    if(this.eventType == null && matchTarget.eventType == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_649693523 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126922520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126922520;
        }
        else
    if(getEventId() == null && matchTarget.getEventId() != null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_871274253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966355055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966355055;
        }
        else
    if(getEventId() != null && matchTarget.getEventId() == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1216797021 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_899594944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_899594944;
        }
        boolean varBEC522F09B916BA3BE3AF6F7E2E85589_955318031 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695332397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695332397;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.365 -0400", hash_original_field = "C15D83E5CFF4F10DB607135176CA639C", hash_generated_field = "63F6460E52154D5BD98308ED4780F1F5")

    private static final long serialVersionUID = -6458387810431874841L;
}

