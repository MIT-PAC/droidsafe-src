package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.*;

public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.859 -0400", hash_original_field = "86E632F72B9E07ED6667FBC88CAC9E93", hash_generated_field = "3DCB42D88F9099A5D16D2C3D4422D6B7")

    protected String dispositionType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.860 -0400", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "30697E61C2A62E132F1F2ECEC533B294")
    public  ContentDisposition() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.860 -0400", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "087B73F515A92A69051D67F79D814E33")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1816853606 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer(dispositionType);
        {
            boolean var0D32F672AFA5F784DED3919887902299_1697114968 = (!this.parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1816853606 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1816853606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1816853606;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer(dispositionType);
        //if (!this.parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.868 -0400", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "157F515106160D420C46FCAD8B49535F")
    public void setDispositionType(String dispositionType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        this.dispositionType = dispositionType;
        // ---------- Original Method ----------
        //if (dispositionType == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        //this.dispositionType = dispositionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.869 -0400", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "3C821D26D2423DF233400F59C711FABF")
    public String getDispositionType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1568465936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1568465936 = this.dispositionType;
        varB4EAC82CA7396A68D541C85D26508E83_1568465936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1568465936;
        // ---------- Original Method ----------
        //return this.dispositionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.873 -0400", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "7D986E3DD73065446FB8EE66F892899E")
    public String getHandling() {
        String varB4EAC82CA7396A68D541C85D26508E83_1817556840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1817556840 = this.getParameter("handling");
        varB4EAC82CA7396A68D541C85D26508E83_1817556840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1817556840;
        // ---------- Original Method ----------
        //return this.getParameter("handling");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.873 -0400", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "3B5D28B005B96508C6481678E08CEEEA")
    public void setHandling(String handling) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        this.setParameter("handling", handling);
        addTaint(handling.getTaint());
        // ---------- Original Method ----------
        //if (handling == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", ContentDisposition, setHandling(), the handling parameter is null");
        //this.setParameter("handling", handling);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.874 -0400", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "FABA7552A5239D3D49235DC9AB3B50F7")
    public String getContentDisposition() {
        String varB4EAC82CA7396A68D541C85D26508E83_378276446 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_378276446 = this.encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_378276446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_378276446;
        // ---------- Original Method ----------
        //return this.encodeBody();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.874 -0400", hash_original_field = "BEA47888ED57494C760553D19E44266B", hash_generated_field = "95B0C941859014CCCF87CEFD870CF66B")

    private static long serialVersionUID = 835596496276127003L;
}

