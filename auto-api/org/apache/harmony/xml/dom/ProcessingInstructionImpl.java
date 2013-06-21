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
    private String target;
    private String data;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.435 -0400", hash_original_method = "87437044DD20821D3A88B8D33A6B0848", hash_generated_method = "34FE8D5AA32685FB5F9F56C267AD2304")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ProcessingInstructionImpl(DocumentImpl document, String target, String data) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(data);
        dsTaint.addTaint(target);
        // ---------- Original Method ----------
        //this.target = target;
        //this.data = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.435 -0400", hash_original_method = "CA0E91FD462850CF9A2412442DB68D19", hash_generated_method = "743BF434D22A187840080E28973F140E")
    @DSModeled(DSC.SAFE)
    public String getData() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.435 -0400", hash_original_method = "44DCC451FA6F3CA18022A718FA0AE60D", hash_generated_method = "1E1A7F314F063A7A9D859A6157028018")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.436 -0400", hash_original_method = "3B7DB8AF476DCFC46150583715993452", hash_generated_method = "8AA5FD95D6AB607CF4B078C6FFE9E58D")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.436 -0400", hash_original_method = "26741C8FC3CFA5C9E2871448A384408A", hash_generated_method = "B89BD035E0780015EE84E016D698840F")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeValue() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.436 -0400", hash_original_method = "067DF5651A33C6E6A710DDDF2900842F", hash_generated_method = "4D21F43DB2796F3FE15C2E034E523725")
    @DSModeled(DSC.SAFE)
    public String getTarget() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.436 -0400", hash_original_method = "985529340F1B642B4E22D59984257994", hash_generated_method = "828383CC3E0115AC85F42B0F8DD46A5A")
    @DSModeled(DSC.SAFE)
    public void setData(String data) throws DOMException {
        dsTaint.addTaint(data);
        // ---------- Original Method ----------
        //this.data = data;
    }

    
}

