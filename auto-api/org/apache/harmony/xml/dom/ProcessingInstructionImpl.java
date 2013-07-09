package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.392 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")

    private String target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.392 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")

    private String data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.392 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "E0EFB6408EE83853FF025A7DEEE3D801")
      ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        this.target = target;
        this.data = data;
        addTaint(document.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.393 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "7D75EC400001E9A9CCA94483130429CD")
    public String getData() {
        String varB4EAC82CA7396A68D541C85D26508E83_2145186498 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2145186498 = data;
        varB4EAC82CA7396A68D541C85D26508E83_2145186498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2145186498;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.393 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "2163DBB8EC77C7A93E04143F89630CB2")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_39425506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_39425506 = target;
        varB4EAC82CA7396A68D541C85D26508E83_39425506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_39425506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.394 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "B719B73781DC5934299FB737F87C5506")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_172698925 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_172698925;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.394 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "B57330AC1C6BEC955B1BD8146E03CF5A")
    @Override
    public String getNodeValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1860424524 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1860424524 = data;
        varB4EAC82CA7396A68D541C85D26508E83_1860424524.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1860424524;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.395 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "B2B53FB9EE8B89D522C3AEFE5DA31857")
    public String getTarget() {
        String varB4EAC82CA7396A68D541C85D26508E83_1152832683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1152832683 = target;
        varB4EAC82CA7396A68D541C85D26508E83_1152832683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1152832683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.395 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "764D2C61447051DD6595F6AB31D89D3E")
    public void setData(String data) throws DOMException {
        this.data = data;
        
        
    }

    
}

