package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.006 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")

    private String target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.006 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")

    private String data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.006 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "E0EFB6408EE83853FF025A7DEEE3D801")
      ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        this.target = target;
        this.data = data;
        addTaint(document.getTaint());
        // ---------- Original Method ----------
        //this.target = target;
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.007 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "ADE10362FC6D5271F64D4869A7C98636")
    public String getData() {
        String varB4EAC82CA7396A68D541C85D26508E83_249283211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_249283211 = data;
        varB4EAC82CA7396A68D541C85D26508E83_249283211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_249283211;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.007 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "0FE9A328D17A3A8FCEB3E86BE1E41858")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_777978301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_777978301 = target;
        varB4EAC82CA7396A68D541C85D26508E83_777978301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777978301;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.008 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "4D50BAA289F61FF80520E873899FFD2B")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1296684401 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1296684401;
        // ---------- Original Method ----------
        //return Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.009 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "32F65FA4D7247AC1D7FDA8D1EA6240DA")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1012932195 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1012932195 = data;
        varB4EAC82CA7396A68D541C85D26508E83_1012932195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1012932195;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.009 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "4E03F817DD6401CB0C3E390E5C33031D")
    public String getTarget() {
        String varB4EAC82CA7396A68D541C85D26508E83_214264966 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_214264966 = target;
        varB4EAC82CA7396A68D541C85D26508E83_214264966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214264966;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.009 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "764D2C61447051DD6595F6AB31D89D3E")
    public void setData(String data) throws DOMException {
        this.data = data;
        // ---------- Original Method ----------
        //this.data = data;
    }

    
}

