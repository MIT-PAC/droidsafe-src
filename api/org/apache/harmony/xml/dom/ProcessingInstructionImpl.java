package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;

public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.683 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")

    private String target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.684 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")

    private String data;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.684 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "C18A2496D5113AAA3D7AFB706BE663C1")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.684 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "03BA566306AF25E52E2D7173A1AE9E25")
    public String getData() {
String var0C8B2C9585EB05DD9CD70726CF8CBC07_444715485 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_444715485.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_444715485;
        // ---------- Original Method ----------
        //return data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.684 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "B10F67416A37CEC083330513AE00991C")
    @Override
    public String getNodeName() {
String varA7DD35DE8EDE4A2FCAF77CE202E687B3_332041242 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_332041242.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_332041242;
        // ---------- Original Method ----------
        //return target;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.685 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "4545FB3DA2D6CADC7D1213295E4EC7B3")
    @Override
    public short getNodeType() {
        short varC8FF66669CCAA4E21B35A66DEA340FB1_1829538246 = (Node.PROCESSING_INSTRUCTION_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1768508338 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1768508338;
        // ---------- Original Method ----------
        //return Node.PROCESSING_INSTRUCTION_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.685 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "E1D473DE99C91A8E2D719EF63815DE4C")
    @Override
    public String getNodeValue() {
String var0C8B2C9585EB05DD9CD70726CF8CBC07_235116002 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_235116002.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_235116002;
        // ---------- Original Method ----------
        //return data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.685 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "81B6FB9C4C8A3BD270EC4FE8B9377F80")
    public String getTarget() {
String varA7DD35DE8EDE4A2FCAF77CE202E687B3_512669107 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_512669107.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_512669107;
        // ---------- Original Method ----------
        //return target;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.686 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "764D2C61447051DD6595F6AB31D89D3E")
    public void setData(String data) throws DOMException {
        this.data = data;
        // ---------- Original Method ----------
        //this.data = data;
    }

    
}

