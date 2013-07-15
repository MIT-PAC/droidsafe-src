package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.942 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")

    private String target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.942 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")

    private String data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.943 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "C18A2496D5113AAA3D7AFB706BE663C1")
      ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        addTaint(document.getTaint());
        this.target = target;
        this.data = data;
        // ---------- Original Method ----------
        //this.target = target;
        //this.data = data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.943 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "A83879EE2DC388DFBB206F52E48F2510")
    public String getData() {
String var0C8B2C9585EB05DD9CD70726CF8CBC07_494748 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_494748.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_494748;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.943 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "B017825D0133A8C39CB08867E6BE3665")
    @Override
    public String getNodeName() {
String varA7DD35DE8EDE4A2FCAF77CE202E687B3_55422581 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_55422581.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_55422581;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.944 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "71B6B04B7BED44C234C108E632C8672D")
    @Override
    public short getNodeType() {
        short varC8FF66669CCAA4E21B35A66DEA340FB1_986658875 = (Node.PROCESSING_INSTRUCTION_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_2013301092 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2013301092;
        // ---------- Original Method ----------
        //return Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.944 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "21C5A1F823FD9AFCFE333943715EA2F8")
    @Override
    public String getNodeValue() {
String var0C8B2C9585EB05DD9CD70726CF8CBC07_1516942536 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_1516942536.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_1516942536;
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.944 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "8EB2DF024E8E09A6A0CEED58B1371649")
    public String getTarget() {
String varA7DD35DE8EDE4A2FCAF77CE202E687B3_1204873580 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_1204873580.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_1204873580;
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.944 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "764D2C61447051DD6595F6AB31D89D3E")
    public void setData(String data) throws DOMException {
        this.data = data;
        // ---------- Original Method ----------
        //this.data = data;
    }

    
}

