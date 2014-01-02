package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;






public final class ProcessingInstructionImpl extends LeafNodeImpl implements ProcessingInstruction {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.362 -0500", hash_original_field = "2951DDF7509EE06D6F75A4DFB645109B", hash_generated_field = "728A0F8A0D39D47E29A782F5DE5F964F")


    private String target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.364 -0500", hash_original_field = "B399DB9D51E3D670436439FBE17773A0", hash_generated_field = "2B992449EA610E50B67A821419D7EE9E")


    private String data;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.366 -0500", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "EC65D0A2EF668B6D696478BC0B4AAD7F")
    
ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        this.target = target; // TODO: validate that target is well-formed
        this.data = data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.368 -0500", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "1B47FDB82CBDDF81DD3E02B974723BE6")
    
public String getData() {
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.371 -0500", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "7C945CF086237D52018411452B0E2757")
    
@Override
    public String getNodeName() {
        return target;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.374 -0500", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "79C64D9180062E1618C10884865008E5")
    
@Override
    public short getNodeType() {
        return Node.PROCESSING_INSTRUCTION_NODE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.376 -0500", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "55A3B990051B9A0017EAF6026083BE8F")
    
@Override
    public String getNodeValue() {
        return data;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.378 -0500", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "EE99245634FBABC2EE661780F993FC49")
    
public String getTarget() {
        return target;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.380 -0500", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "BE68596F492041F849CE9EC9D7118802")
    
public void setData(String data) throws DOMException {
        this.data = data;
    }

    
}

