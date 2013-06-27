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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.131 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")

    private String target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.131 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")

    private String data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.131 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "E0EFB6408EE83853FF025A7DEEE3D801")
      ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        this.target = target;
        this.data = data;
        addTaint(document.getTaint());
        // ---------- Original Method ----------
        //this.target = target;
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.132 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "36F273DB08B89EED3568FC4327B4055B")
    public String getData() {
        String varB4EAC82CA7396A68D541C85D26508E83_1797781373 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797781373 = data;
        varB4EAC82CA7396A68D541C85D26508E83_1797781373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797781373;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.132 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "A53F7A95B7DE60775B019C3B84B8B117")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1779104131 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1779104131 = target;
        varB4EAC82CA7396A68D541C85D26508E83_1779104131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779104131;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.132 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "A65E132AB07FCFC1DCBC4303CD5FE5B0")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1567472184 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1567472184;
        // ---------- Original Method ----------
        //return Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.133 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "F59E530A55F797BBBF4F3C2F77FB1683")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_404158608 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_404158608 = data;
        varB4EAC82CA7396A68D541C85D26508E83_404158608.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_404158608;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.134 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "0E888621AA000D5BA5B46D285898DA98")
    public String getTarget() {
        String varB4EAC82CA7396A68D541C85D26508E83_584798785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_584798785 = target;
        varB4EAC82CA7396A68D541C85D26508E83_584798785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_584798785;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.134 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "764D2C61447051DD6595F6AB31D89D3E")
    public void setData(String data) throws DOMException {
        this.data = data;
        // ---------- Original Method ----------
        //this.data = data;
    }

    
}

