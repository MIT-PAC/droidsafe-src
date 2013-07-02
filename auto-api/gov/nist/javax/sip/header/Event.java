package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;

public class Event extends ParametersHeader implements EventHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.504 -0400", hash_original_field = "2F264034C73ACBD6BAAE70DD7EDB3D3F", hash_generated_field = "8B4AE3944FE26E1E3D2F161694AF8E90")

    protected String eventType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.505 -0400", hash_original_method = "4CF8CB38A5AC53FB99D6035A88D058D2", hash_generated_method = "BB45294AF8494FB6A0990700F3F53A05")
    public  Event() {
        super(EVENT);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.505 -0400", hash_original_method = "BF3A0863A1B04A86A1E3BEB9A70A1FC1", hash_generated_method = "DA9CA205E48AC787CBDB2DD50CAB270D")
    public void setEventType(String eventType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventType is null");
        this.eventType = eventType;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.506 -0400", hash_original_method = "801AF3F6658A2A453A4D4DA9830DAF46", hash_generated_method = "41D2A3579A196DA86F28246B5292D623")
    public String getEventType() {
        String varB4EAC82CA7396A68D541C85D26508E83_258698599 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_258698599 = eventType;
        varB4EAC82CA7396A68D541C85D26508E83_258698599.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_258698599;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.506 -0400", hash_original_method = "4973DD9F7CE5F7FF3C7544616AFD9DF0", hash_generated_method = "8712C4ABB1260592E51136AF233350C6")
    public void setEventId(String eventId) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(" the eventId parameter is null");
        setParameter(ParameterNames.ID, eventId);
        addTaint(eventId.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.507 -0400", hash_original_method = "19BA40738893C0C7644CB14978576CB8", hash_generated_method = "8F880384BA072615BDE1AA807253A519")
    public String getEventId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1569748033 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1569748033 = getParameter(ParameterNames.ID);
        varB4EAC82CA7396A68D541C85D26508E83_1569748033.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1569748033;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.507 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "09E9B75036F6BF059B7E206321409518")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1661514453 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1661514453 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1661514453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1661514453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.508 -0400", hash_original_method = "0038FEB21AC4FB99162300562E578118", hash_generated_method = "A7B1C125CB119D984717F24E1FA24DD7")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1224722394 = null; 
        buffer.append(eventType);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1077147336 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                this.parameters.encode(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1224722394 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1224722394.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1224722394;
        
        
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.509 -0400", hash_original_method = "597DA81ECE5B3A826C9242118BC9B66A", hash_generated_method = "505BD52BE5D94127C32E87064C32EDEC")
    public boolean match(Event matchTarget) {
        {
            boolean var45D64371529EB540545235AF8CB73642_1763980268 = (getEventId() == null && matchTarget.getEventId() != null);
            {
                boolean var90D7AD11C3E17CD756B19787A2034463_578921418 = (getEventId() != null && matchTarget.getEventId() == null);
            } 
        } 
        boolean varF81C3710566A8DAA1CBD8DD685B57C4E_1551946140 = (matchTarget.eventType.equalsIgnoreCase(this.eventType)
            && ((this.getEventId() == matchTarget.getEventId())
                || this.getEventId().equalsIgnoreCase(matchTarget.getEventId())));
        addTaint(matchTarget.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149784697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149784697;
        
        
            
        
            
        
            
        
            
        
            
        
            
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.509 -0400", hash_original_field = "C15D83E5CFF4F10DB607135176CA639C", hash_generated_field = "63F6460E52154D5BD98308ED4780F1F5")

    private static final long serialVersionUID = -6458387810431874841L;
}

