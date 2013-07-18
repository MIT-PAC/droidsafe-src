package javax.xml.transform.dom;

// Droidsafe Imports
import javax.xml.transform.Source;

import org.w3c.dom.Node;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DOMSource implements Source {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.132 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "FF348B25B2CE5FD5278D4CA5F8E8C280")

    private Node node;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.132 -0400", hash_original_field = "3CB0FD2F5B64458EA38FA1B4C3A9ED1C", hash_generated_field = "83BD3571475BC4C0C301203EC49F6EAB")

    private String systemID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.133 -0400", hash_original_method = "C22C4B52562F798E2DC7E2B5F763062E", hash_generated_method = "839CD9DE42EFD6F922A393B3D648B5DB")
    public  DOMSource() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.133 -0400", hash_original_method = "7C7F7287E74EAB9B8232F0908501FA89", hash_generated_method = "7AE67A1BF840E9386D5FE2E4755F7F30")
    public  DOMSource(Node n) {
        addTaint(n.getTaint());
        setNode(n);
        // ---------- Original Method ----------
        //setNode(n);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.133 -0400", hash_original_method = "27D1704B3C4A5B83EAF9B6B6BE5CC0DE", hash_generated_method = "9BE3BBB8AF49CB55C6CF288389CE7F07")
    public  DOMSource(Node node, String systemID) {
        addTaint(systemID.getTaint());
        addTaint(node.getTaint());
        setNode(node);
        setSystemId(systemID);
        // ---------- Original Method ----------
        //setNode(node);
        //setSystemId(systemID);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.134 -0400", hash_original_method = "4F37876713B3FCA5FC091F96D4BE4E11", hash_generated_method = "D39A5CE56B7B3F94F5AFBE14C42F2B9B")
    public void setNode(Node node) {
        this.node = node;
        // ---------- Original Method ----------
        //this.node = node;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.134 -0400", hash_original_method = "10E144C61713FDC7DCDB7ABF8ED1C0C7", hash_generated_method = "B9F5AED4A38A90FFAAB53E454F5950C4")
    public Node getNode() {
Node var1924C94B76524D1C3D7310EA17B0EF94_624744070 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_624744070.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_624744070;
        // ---------- Original Method ----------
        //return node;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.135 -0400", hash_original_method = "E981DAB2BFA2B95115ED74FBC4FCBCC2", hash_generated_method = "8DE75C9EC5B78E696D327E1572E2C1F7")
    public void setSystemId(String systemID) {
        this.systemID = systemID;
        // ---------- Original Method ----------
        //this.systemID = systemID;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.136 -0400", hash_original_method = "2FF877EC5EDDB8E93544988C2CFEB0F3", hash_generated_method = "4C2C1B2C7F50A5D6E6C085BD5CE9B071")
    public String getSystemId() {
String var64F7B4425A5091DCABF710CFF5E36BC2_1493941814 =         this.systemID;
        var64F7B4425A5091DCABF710CFF5E36BC2_1493941814.addTaint(taint);
        return var64F7B4425A5091DCABF710CFF5E36BC2_1493941814;
        // ---------- Original Method ----------
        //return this.systemID;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.136 -0400", hash_original_field = "12FFEB49A7ED7FEA6811F6D59C637F3D", hash_generated_field = "544E5A424F01A7FBB778D82E3C1AE2BE")

    public static final String FEATURE =
        "http://javax.xml.transform.dom.DOMSource/feature";
}

