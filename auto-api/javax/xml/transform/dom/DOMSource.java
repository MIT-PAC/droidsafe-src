package javax.xml.transform.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.xml.transform.Source;
import org.w3c.dom.Node;

public class DOMSource implements Source {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.520 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "FF348B25B2CE5FD5278D4CA5F8E8C280")

    private Node node;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.520 -0400", hash_original_field = "3CB0FD2F5B64458EA38FA1B4C3A9ED1C", hash_generated_field = "83BD3571475BC4C0C301203EC49F6EAB")

    private String systemID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.521 -0400", hash_original_method = "C22C4B52562F798E2DC7E2B5F763062E", hash_generated_method = "839CD9DE42EFD6F922A393B3D648B5DB")
    public  DOMSource() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.521 -0400", hash_original_method = "7C7F7287E74EAB9B8232F0908501FA89", hash_generated_method = "8778B4BC70602109375D8910E496B6C8")
    public  DOMSource(Node n) {
        setNode(n);
        addTaint(n.getTaint());
        // ---------- Original Method ----------
        //setNode(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.521 -0400", hash_original_method = "27D1704B3C4A5B83EAF9B6B6BE5CC0DE", hash_generated_method = "593F89CA79622B170DA8C44BB6FA2B2E")
    public  DOMSource(Node node, String systemID) {
        setNode(node);
        setSystemId(systemID);
        addTaint(node.getTaint());
        addTaint(systemID.getTaint());
        // ---------- Original Method ----------
        //setNode(node);
        //setSystemId(systemID);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.521 -0400", hash_original_method = "4F37876713B3FCA5FC091F96D4BE4E11", hash_generated_method = "D39A5CE56B7B3F94F5AFBE14C42F2B9B")
    public void setNode(Node node) {
        this.node = node;
        // ---------- Original Method ----------
        //this.node = node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.522 -0400", hash_original_method = "10E144C61713FDC7DCDB7ABF8ED1C0C7", hash_generated_method = "D6A3400DA27F396B08A6C450FBE01E3E")
    public Node getNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1645944511 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1645944511 = node;
        varB4EAC82CA7396A68D541C85D26508E83_1645944511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1645944511;
        // ---------- Original Method ----------
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.522 -0400", hash_original_method = "E981DAB2BFA2B95115ED74FBC4FCBCC2", hash_generated_method = "8DE75C9EC5B78E696D327E1572E2C1F7")
    public void setSystemId(String systemID) {
        this.systemID = systemID;
        // ---------- Original Method ----------
        //this.systemID = systemID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.522 -0400", hash_original_method = "2FF877EC5EDDB8E93544988C2CFEB0F3", hash_generated_method = "858FF1F6A54B1CDD8F321FB31B8F2450")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_354179833 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_354179833 = this.systemID;
        varB4EAC82CA7396A68D541C85D26508E83_354179833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_354179833;
        // ---------- Original Method ----------
        //return this.systemID;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.522 -0400", hash_original_field = "12FFEB49A7ED7FEA6811F6D59C637F3D", hash_generated_field = "544E5A424F01A7FBB778D82E3C1AE2BE")

    public static final String FEATURE =
        "http://javax.xml.transform.dom.DOMSource/feature";
}

