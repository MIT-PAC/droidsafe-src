package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import android.util.Log;
public class Mesh extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.731 -0400", hash_original_field = "3C3414985F5E196A31E2564A62383C2D", hash_generated_field = "228985299EC15EB3441845338D5404EE")

    Allocation[] mVertexBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.734 -0400", hash_original_field = "CF9F9A6C7F18D30F07BA81459606A62B", hash_generated_field = "C14CB5DE54A58C061EDE9BEC8FDDA8BC")

    Allocation[] mIndexBuffers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.736 -0400", hash_original_field = "CFE5F82B122DA1BD8BF55F41FC0B4862", hash_generated_field = "F75E417667F120CCE412F4D29FAE2D75")

    Primitive[] mPrimitives;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.743 -0400", hash_original_method = "C8590D08EE8DAE10D21AC3FD65BED1A9", hash_generated_method = "1C1FD9D713C0B0B663728440F3FDF1E2")
      Mesh(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.760 -0400", hash_original_method = "EFFB20897006BD21D9CD85929E5DBB71", hash_generated_method = "829459E3C86B5E3D578830BD3552E3B3")
    public int getVertexAllocationCount() {
        if(mVertexBuffers == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1824582432 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569194803 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569194803;
        } //End block
        int varB3C144C0A9687850FC70F66901BA63AC_263445351 = (mVertexBuffers.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83471536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83471536;
        // ---------- Original Method ----------
        //if(mVertexBuffers == null) {
            //return 0;
        //}
        //return mVertexBuffers.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.767 -0400", hash_original_method = "EA40159658251D040B5268F69F9B14EF", hash_generated_method = "AA45515ED04F7FDF207F4FACC4997C46")
    public Allocation getVertexAllocation(int slot) {
        addTaint(slot);
Allocation varAC9AD75199CCA1C9A5962A9C64AC83EB_190844094 =         mVertexBuffers[slot];
        varAC9AD75199CCA1C9A5962A9C64AC83EB_190844094.addTaint(taint);
        return varAC9AD75199CCA1C9A5962A9C64AC83EB_190844094;
        // ---------- Original Method ----------
        //return mVertexBuffers[slot];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.777 -0400", hash_original_method = "428E6D74220E844332BAD2A4C35405F1", hash_generated_method = "D28C332AF19B4E597028371FD53C3135")
    public int getPrimitiveCount() {
        if(mIndexBuffers == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1318287604 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108781925 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108781925;
        } //End block
        int var89EEC3F9993561C84E15FE7513BE69E7_1475277506 = (mIndexBuffers.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554965074 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554965074;
        // ---------- Original Method ----------
        //if(mIndexBuffers == null) {
            //return 0;
        //}
        //return mIndexBuffers.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.787 -0400", hash_original_method = "08B7801C574B5FE1151D8579346309F3", hash_generated_method = "5AAD07E6F7025FC16B5591D740910C61")
    public Allocation getIndexSetAllocation(int slot) {
        addTaint(slot);
Allocation varAB83D15F79B8459AA517B41C3C50A9E1_1411138097 =         mIndexBuffers[slot];
        varAB83D15F79B8459AA517B41C3C50A9E1_1411138097.addTaint(taint);
        return varAB83D15F79B8459AA517B41C3C50A9E1_1411138097;
        // ---------- Original Method ----------
        //return mIndexBuffers[slot];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.796 -0400", hash_original_method = "C97CD8ECF86AEBA4746DF3BE7591FFF7", hash_generated_method = "77220E57322E96A812D87BDB2D131EAB")
    public Primitive getPrimitive(int slot) {
        addTaint(slot);
Primitive varBDF236DFA00ECADECBA3634A2A098BA9_475455561 =         mPrimitives[slot];
        varBDF236DFA00ECADECBA3634A2A098BA9_475455561.addTaint(taint);
        return varBDF236DFA00ECADECBA3634A2A098BA9_475455561;
        // ---------- Original Method ----------
        //return mPrimitives[slot];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.837 -0400", hash_original_method = "3C1F4A6EE05921D340A62A6B7A4FB1EA", hash_generated_method = "4242E43631838844B6ED819BC505F412")
    @Override
     void updateFromNative() {
        super.updateFromNative();
        int vtxCount = mRS.nMeshGetVertexBufferCount(getID());
        int idxCount = mRS.nMeshGetIndexCount(getID());
        int[] vtxIDs = new int[vtxCount];
        int[] idxIDs = new int[idxCount];
        int[] primitives = new int[idxCount];
        mRS.nMeshGetVertices(getID(), vtxIDs, vtxCount);
        mRS.nMeshGetIndices(getID(), idxIDs, primitives, idxCount);
        mVertexBuffers = new Allocation[vtxCount];
        mIndexBuffers = new Allocation[idxCount];
        mPrimitives = new Primitive[idxCount];
for(int i = 0;i < vtxCount;i ++)
        {
            if(vtxIDs[i] != 0)            
            {
                mVertexBuffers[i] = new Allocation(vtxIDs[i], mRS, null, Allocation.USAGE_SCRIPT);
                mVertexBuffers[i].updateFromNative();
            } //End block
        } //End block
for(int i = 0;i < idxCount;i ++)
        {
            if(idxIDs[i] != 0)            
            {
                mIndexBuffers[i] = new Allocation(idxIDs[i], mRS, null, Allocation.USAGE_SCRIPT);
                mIndexBuffers[i].updateFromNative();
            } //End block
            mPrimitives[i] = Primitive.values()[primitives[i]];
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public enum Primitive {
        POINT (0),
        LINE (1),
        LINE_STRIP (2),
        TRIANGLE (3),
        TRIANGLE_STRIP (4),
        TRIANGLE_FAN (5);
        int mID;
        @DSModeled(DSC.SAFE)
        Primitive(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.849 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.851 -0400", hash_original_field = "F2AAE19CC0AF4955036751775E00CA80", hash_generated_field = "455102E0D248DC24482D3093AA618A87")

        int mUsage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.858 -0400", hash_original_field = "4E3D82BC2F29A854086EDB7DBF65B393", hash_generated_field = "E8E332765C92B2986C0EAE3D3BDB65E4")

        int mVertexTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.864 -0400", hash_original_field = "4EA1FDBD9DECEBC2BDB74CD6C169FAF9", hash_generated_field = "539B737A39B7384A78AF1746E9278B0D")

        Entry[] mVertexTypes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.866 -0400", hash_original_field = "65125FAFDCB13B8B5B0B0F57D35B4C76", hash_generated_field = "B9D0A03C9BDC29783A27CC44B9B1FABF")

        Vector mIndexTypes;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.884 -0400", hash_original_method = "6A7DE29092EDA44714340A63C02A4D3B", hash_generated_method = "BD3A77C2AB52D03AEE51EE610D9C0D1E")
        public  Builder(RenderScript rs, int usage) {
            mRS = rs;
            mUsage = usage;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
            // ---------- Original Method ----------
            //mRS = rs;
            //mUsage = usage;
            //mVertexTypeCount = 0;
            //mVertexTypes = new Entry[16];
            //mIndexTypes = new Vector();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.888 -0400", hash_original_method = "F2CC44AB8332A9CEBA185D757457B141", hash_generated_method = "97ABEEF1417149DF002CA62EF71E3FC5")
        public int getCurrentVertexTypeIndex() {
            int var7FB0BD12D9B5B135C3D9C6B825F2E79B_2131222428 = (mVertexTypeCount - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93853582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93853582;
            // ---------- Original Method ----------
            //return mVertexTypeCount - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.893 -0400", hash_original_method = "390DA790368F4A077D3D7345AE862264", hash_generated_method = "9244BCB5B78CE07F3333B218B5D91652")
        public int getCurrentIndexSetIndex() {
            int varF12821C73C5836F088E70DD1BF98F142_2104680234 = (mIndexTypes.size() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119560511 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119560511;
            // ---------- Original Method ----------
            //return mIndexTypes.size() - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.905 -0400", hash_original_method = "4288B76F5BEB205918AF7DDCE9EEE5BF", hash_generated_method = "AD28E84EF23703831BD4BE32A3F6A9F0")
        public Builder addVertexType(Type t) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length)            
            {
                IllegalStateException varF1477694D907257F4988D408153F7BA2_1417098458 = new IllegalStateException("Max vertex types exceeded.");
                varF1477694D907257F4988D408153F7BA2_1417098458.addTaint(taint);
                throw varF1477694D907257F4988D408153F7BA2_1417098458;
            } //End block
            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].t = t;
            mVertexTypes[mVertexTypeCount].e = null;
            mVertexTypeCount++;
Builder var72A74007B2BE62B849F475C7BDA4658B_786121630 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_786121630.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_786121630;
            // ---------- Original Method ----------
            //if (mVertexTypeCount >= mVertexTypes.length) {
                //throw new IllegalStateException("Max vertex types exceeded.");
            //}
            //mVertexTypes[mVertexTypeCount] = new Entry();
            //mVertexTypes[mVertexTypeCount].t = t;
            //mVertexTypes[mVertexTypeCount].e = null;
            //mVertexTypeCount++;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.924 -0400", hash_original_method = "FE7A9140417CA4AD355B5E4C1351F0BC", hash_generated_method = "A01948C35A51CE38625245BC153D8787")
        public Builder addVertexType(Element e, int size) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length)            
            {
                IllegalStateException varF1477694D907257F4988D408153F7BA2_1804501980 = new IllegalStateException("Max vertex types exceeded.");
                varF1477694D907257F4988D408153F7BA2_1804501980.addTaint(taint);
                throw varF1477694D907257F4988D408153F7BA2_1804501980;
            } //End block
            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].t = null;
            mVertexTypes[mVertexTypeCount].e = e;
            mVertexTypes[mVertexTypeCount].size = size;
            mVertexTypeCount++;
Builder var72A74007B2BE62B849F475C7BDA4658B_1276349180 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1276349180.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1276349180;
            // ---------- Original Method ----------
            //if (mVertexTypeCount >= mVertexTypes.length) {
                //throw new IllegalStateException("Max vertex types exceeded.");
            //}
            //mVertexTypes[mVertexTypeCount] = new Entry();
            //mVertexTypes[mVertexTypeCount].t = null;
            //mVertexTypes[mVertexTypeCount].e = e;
            //mVertexTypes[mVertexTypeCount].size = size;
            //mVertexTypeCount++;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.939 -0400", hash_original_method = "6F637DE57BFF0697961ABB272635A4DE", hash_generated_method = "A21B0028D7E19E93005D7C4D7DBA2462")
        public Builder addIndexSetType(Type t, Primitive p) {
            addTaint(p.getTaint());
            addTaint(t.getTaint());
            Entry indexType = new Entry();
            indexType.t = t;
            indexType.e = null;
            indexType.size = 0;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
Builder var72A74007B2BE62B849F475C7BDA4658B_367214056 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_367214056.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_367214056;
            // ---------- Original Method ----------
            //Entry indexType = new Entry();
            //indexType.t = t;
            //indexType.e = null;
            //indexType.size = 0;
            //indexType.prim = p;
            //mIndexTypes.addElement(indexType);
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.950 -0400", hash_original_method = "2E7034A69395E1E5DBB2950602CE4F4E", hash_generated_method = "AF5F820A51641E503F00034DB655E14A")
        public Builder addIndexSetType(Primitive p) {
            addTaint(p.getTaint());
            Entry indexType = new Entry();
            indexType.t = null;
            indexType.e = null;
            indexType.size = 0;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
Builder var72A74007B2BE62B849F475C7BDA4658B_881271597 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_881271597.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_881271597;
            // ---------- Original Method ----------
            //Entry indexType = new Entry();
            //indexType.t = null;
            //indexType.e = null;
            //indexType.size = 0;
            //indexType.prim = p;
            //mIndexTypes.addElement(indexType);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.969 -0400", hash_original_method = "62E497D1E15AFECC6C75E1097FD3DEF1", hash_generated_method = "10351A0441F0B1B0172DBFA5310232C0")
        public Builder addIndexSetType(Element e, int size, Primitive p) {
            addTaint(p.getTaint());
            addTaint(size);
            addTaint(e.getTaint());
            Entry indexType = new Entry();
            indexType.t = null;
            indexType.e = e;
            indexType.size = size;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
Builder var72A74007B2BE62B849F475C7BDA4658B_1830093078 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1830093078.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1830093078;
            // ---------- Original Method ----------
            //Entry indexType = new Entry();
            //indexType.t = null;
            //indexType.e = e;
            //indexType.size = size;
            //indexType.prim = p;
            //mIndexTypes.addElement(indexType);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:51.980 -0400", hash_original_method = "A5F13BDB43E03AFA74C8CAC08DECE9D7", hash_generated_method = "DE47BE93CA433BC79DFD2FE486931FA5")
         Type newType(Element e, int size) {
            addTaint(size);
            addTaint(e.getTaint());
            Type.Builder tb = new Type.Builder(mRS, e);
            tb.setX(size);
Type varD9C3C9A77E2D57500CF7BDC1E9D64E5D_507088897 =             tb.create();
            varD9C3C9A77E2D57500CF7BDC1E9D64E5D_507088897.addTaint(taint);
            return varD9C3C9A77E2D57500CF7BDC1E9D64E5D_507088897;
            // ---------- Original Method ----------
            //Type.Builder tb = new Type.Builder(mRS, e);
            //tb.setX(size);
            //return tb.create();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.022 -0400", hash_original_method = "2B7677CA7551A1CB975DB188DC4C64F4", hash_generated_method = "02768B2ADBD0C4038D408AF2C65F1EC8")
        public Mesh create() {
            mRS.validate();
            int[] vtx = new int[mVertexTypeCount];
            int[] idx = new int[mIndexTypes.size()];
            int[] prim = new int[mIndexTypes.size()];
            Allocation[] vertexBuffers = new Allocation[mVertexTypeCount];
            Allocation[] indexBuffers = new Allocation[mIndexTypes.size()];
            Primitive[] primitives = new Primitive[mIndexTypes.size()];
for(int ct = 0;ct < mVertexTypeCount;ct ++)
            {
                Allocation alloc = null;
                Entry entry = mVertexTypes[ct];
                if(entry.t != null)                
                {
                    alloc = Allocation.createTyped(mRS, entry.t, mUsage);
                } //End block
                else
                if(entry.e != null)                
                {
                    alloc = Allocation.createSized(mRS, entry.e, entry.size, mUsage);
                } //End block
                vertexBuffers[ct] = alloc;
                vtx[ct] = alloc.getID();
            } //End block
for(int ct = 0;ct < mIndexTypes.size();ct ++)
            {
                Allocation alloc = null;
                Entry entry = (Entry)mIndexTypes.elementAt(ct);
                if(entry.t != null)                
                {
                    alloc = Allocation.createTyped(mRS, entry.t, mUsage);
                } //End block
                else
                if(entry.e != null)                
                {
                    alloc = Allocation.createSized(mRS, entry.e, entry.size, mUsage);
                } //End block
                int allocID = (alloc == null) ? 0 : alloc.getID();
                indexBuffers[ct] = alloc;
                primitives[ct] = entry.prim;
                idx[ct] = allocID;
                prim[ct] = entry.prim.mID;
            } //End block
            int id = mRS.nMeshCreate(vtx, idx, prim);
            Mesh newMesh = new Mesh(id, mRS);
            newMesh.mVertexBuffers = vertexBuffers;
            newMesh.mIndexBuffers = indexBuffers;
            newMesh.mPrimitives = primitives;
Mesh var4FF8CA43AF3D1A757E7FE6BFD5517AE1_2129636113 =             newMesh;
            var4FF8CA43AF3D1A757E7FE6BFD5517AE1_2129636113.addTaint(taint);
            return var4FF8CA43AF3D1A757E7FE6BFD5517AE1_2129636113;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        class Entry {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.033 -0400", hash_original_field = "E358EFA489F58062F10DD7316B65649E", hash_generated_field = "905363B609753A7290BA348AA0EE865A")

            Type t;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.036 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "44BE21ACD70B32E38EE19EC4AA7174B9")

            Element e;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.039 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

            int size;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.041 -0400", hash_original_field = "60BEC1A80A84D0258EDC5AAF54952563", hash_generated_field = "D5219C1134DF6E7B6EDFCF6D15F9A2C5")

            Primitive prim;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.042 -0400", hash_original_field = "9366282E11C151558BDFAAB4A264AA1B", hash_generated_field = "4DECCE63637B64496145E832A72ECA7C")

            int usage;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.044 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
            public Entry ()
            {
                //Synthesized constructor
            }


        }


        
    }


    
    public static class AllocationBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.047 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.049 -0400", hash_original_field = "4E3D82BC2F29A854086EDB7DBF65B393", hash_generated_field = "E8E332765C92B2986C0EAE3D3BDB65E4")

        int mVertexTypeCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.051 -0400", hash_original_field = "4EA1FDBD9DECEBC2BDB74CD6C169FAF9", hash_generated_field = "539B737A39B7384A78AF1746E9278B0D")

        Entry[] mVertexTypes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.052 -0400", hash_original_field = "65125FAFDCB13B8B5B0B0F57D35B4C76", hash_generated_field = "B9D0A03C9BDC29783A27CC44B9B1FABF")

        Vector mIndexTypes;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.059 -0400", hash_original_method = "1C2A9BD6903F1FC6804233482DDA3B70", hash_generated_method = "C7B60159E3E1252A7663ADF6EA085592")
        public  AllocationBuilder(RenderScript rs) {
            mRS = rs;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
            // ---------- Original Method ----------
            //mRS = rs;
            //mVertexTypeCount = 0;
            //mVertexTypes = new Entry[16];
            //mIndexTypes = new Vector();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.063 -0400", hash_original_method = "F2CC44AB8332A9CEBA185D757457B141", hash_generated_method = "C78AEEE46C26FC1A7BB8CA5488B70071")
        public int getCurrentVertexTypeIndex() {
            int var7FB0BD12D9B5B135C3D9C6B825F2E79B_1876312561 = (mVertexTypeCount - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428685418 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428685418;
            // ---------- Original Method ----------
            //return mVertexTypeCount - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.069 -0400", hash_original_method = "390DA790368F4A077D3D7345AE862264", hash_generated_method = "8F9180C4A9CA1E1CAE71B2C23748A122")
        public int getCurrentIndexSetIndex() {
            int varF12821C73C5836F088E70DD1BF98F142_1614773477 = (mIndexTypes.size() - 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098538014 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098538014;
            // ---------- Original Method ----------
            //return mIndexTypes.size() - 1;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.084 -0400", hash_original_method = "77399CB88844FFACF599E547771813AB", hash_generated_method = "AF3169A9EFF5D958E63C0F008D046386")
        public AllocationBuilder addVertexAllocation(Allocation a) throws IllegalStateException {
            if(mVertexTypeCount >= mVertexTypes.length)            
            {
                IllegalStateException varF1477694D907257F4988D408153F7BA2_262745139 = new IllegalStateException("Max vertex types exceeded.");
                varF1477694D907257F4988D408153F7BA2_262745139.addTaint(taint);
                throw varF1477694D907257F4988D408153F7BA2_262745139;
            } //End block
            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].a = a;
            mVertexTypeCount++;
AllocationBuilder var72A74007B2BE62B849F475C7BDA4658B_343023201 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_343023201.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_343023201;
            // ---------- Original Method ----------
            //if (mVertexTypeCount >= mVertexTypes.length) {
                //throw new IllegalStateException("Max vertex types exceeded.");
            //}
            //mVertexTypes[mVertexTypeCount] = new Entry();
            //mVertexTypes[mVertexTypeCount].a = a;
            //mVertexTypeCount++;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.097 -0400", hash_original_method = "F6D22E1C9E233B4CE6C95173573B1ADC", hash_generated_method = "2C2B095FBEAD9370C73AB696019ECAE5")
        public AllocationBuilder addIndexSetAllocation(Allocation a, Primitive p) {
            addTaint(p.getTaint());
            addTaint(a.getTaint());
            Entry indexType = new Entry();
            indexType.a = a;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
AllocationBuilder var72A74007B2BE62B849F475C7BDA4658B_1197927845 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1197927845.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1197927845;
            // ---------- Original Method ----------
            //Entry indexType = new Entry();
            //indexType.a = a;
            //indexType.prim = p;
            //mIndexTypes.addElement(indexType);
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.103 -0400", hash_original_method = "3F005229FAC5669CED0C1EDA320C3ED4", hash_generated_method = "CD7F48B1AA7513E3C1C7C068883D4846")
        public AllocationBuilder addIndexSetType(Primitive p) {
            addTaint(p.getTaint());
            Entry indexType = new Entry();
            indexType.a = null;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
AllocationBuilder var72A74007B2BE62B849F475C7BDA4658B_1813115322 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1813115322.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1813115322;
            // ---------- Original Method ----------
            //Entry indexType = new Entry();
            //indexType.a = null;
            //indexType.prim = p;
            //mIndexTypes.addElement(indexType);
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.122 -0400", hash_original_method = "26A045F795A631008C79D159817C5762", hash_generated_method = "C1A9C848CD1A63735EF199E7F7459259")
        public Mesh create() {
            mRS.validate();
            int[] vtx = new int[mVertexTypeCount];
            int[] idx = new int[mIndexTypes.size()];
            int[] prim = new int[mIndexTypes.size()];
            Allocation[] indexBuffers = new Allocation[mIndexTypes.size()];
            Primitive[] primitives = new Primitive[mIndexTypes.size()];
            Allocation[] vertexBuffers = new Allocation[mVertexTypeCount];
for(int ct = 0;ct < mVertexTypeCount;ct ++)
            {
                Entry entry = mVertexTypes[ct];
                vertexBuffers[ct] = entry.a;
                vtx[ct] = entry.a.getID();
            } //End block
for(int ct = 0;ct < mIndexTypes.size();ct ++)
            {
                Entry entry = (Entry)mIndexTypes.elementAt(ct);
                int allocID = (entry.a == null) ? 0 : entry.a.getID();
                indexBuffers[ct] = entry.a;
                primitives[ct] = entry.prim;
                idx[ct] = allocID;
                prim[ct] = entry.prim.mID;
            } //End block
            int id = mRS.nMeshCreate(vtx, idx, prim);
            Mesh newMesh = new Mesh(id, mRS);
            newMesh.mVertexBuffers = vertexBuffers;
            newMesh.mIndexBuffers = indexBuffers;
            newMesh.mPrimitives = primitives;
Mesh var4FF8CA43AF3D1A757E7FE6BFD5517AE1_1618959338 =             newMesh;
            var4FF8CA43AF3D1A757E7FE6BFD5517AE1_1618959338.addTaint(taint);
            return var4FF8CA43AF3D1A757E7FE6BFD5517AE1_1618959338;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        class Entry {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.127 -0400", hash_original_field = "0CC175B9C0F1B6A831C399E269772661", hash_generated_field = "0A5181B731DCCB4745C5810BC91FA8CC")

            Allocation a;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.131 -0400", hash_original_field = "60BEC1A80A84D0258EDC5AAF54952563", hash_generated_field = "D5219C1134DF6E7B6EDFCF6D15F9A2C5")

            Primitive prim;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.133 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
            public Entry ()
            {
                //Synthesized constructor
            }


        }


        
    }


    
    public static class TriangleMeshBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.136 -0400", hash_original_field = "D1956F7567DBA6C3E26083D1C10F3907", hash_generated_field = "09E7F62ED7C9C7F4586D795077BFA466")

        float mVtxData[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.138 -0400", hash_original_field = "D8C001A60CFB058B963E1BDE94D0E87D", hash_generated_field = "BF593DF59A5F954FABA9CA61996E3C84")

        int mVtxCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.139 -0400", hash_original_field = "D9C20FDFFB777860F6D3244315B29A7A", hash_generated_field = "5C5241866E4B058149AA37C090BCE02A")

        short mIndexData[];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.140 -0400", hash_original_field = "486156B8DE66CB43383902BBA13912F1", hash_generated_field = "E1ECB1DDEFFF13E68109AF61CC5BD569")

        int mIndexCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.141 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.143 -0400", hash_original_field = "08E316DDB61D78B6AA0D6372095F762A", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

        Element mElement;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.145 -0400", hash_original_field = "B87A344A1912F72D38AE26C491A0B1C5", hash_generated_field = "EEDC8AAF9952117629CEBEE39820FEB4")

        float mNX = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.148 -0400", hash_original_field = "F4404C86D8DA7E8D72477F9ADAB6DE9F", hash_generated_field = "FBE457259607881D8AE24361D1690EC7")

        float mNY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.150 -0400", hash_original_field = "B8B1E2569502EA4C7A9ED7BA4D987D9A", hash_generated_field = "D3095026A3695EF1B8793C370FD2BFC2")

        float mNZ = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.151 -0400", hash_original_field = "CDB7CBA2518249088B4DDEEF2551C504", hash_generated_field = "19A1C6A54E1A9D264A5DFA632BD248FF")

        float mS0 = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.154 -0400", hash_original_field = "3CFC1B7D98AF7E1894638A1275AE1B04", hash_generated_field = "B4F0C2F01100EA5D2FFA93D6427B5372")

        float mT0 = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.155 -0400", hash_original_field = "CA75BD972A33578C7B31F36BBE6A82FD", hash_generated_field = "87BE476E4DB60BD355FC9D925BF8F8EC")

        float mR = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.157 -0400", hash_original_field = "9116BF0A98D999EDA8232848B7BA9E31", hash_generated_field = "9A71E90DFDE5099D07C80770C63947DD")

        float mG = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.158 -0400", hash_original_field = "2D166EC8003C29192F28144C616FE79B", hash_generated_field = "B102327E6DBC8B9CFDB80024C3AACD11")

        float mB = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.160 -0400", hash_original_field = "5FB2AC6174919E66CD6A0B3B9904DCB1", hash_generated_field = "1A7CFAD690644F721CD7875A70033C22")

        float mA = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.162 -0400", hash_original_field = "DF416B8B0978D2427BC6DBBD4CB9F47A", hash_generated_field = "8C7E1C196B99C0E2B82C13F834059AE7")

        int mVtxSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.165 -0400", hash_original_field = "9C3CD7D37D3E1E66BE9B3B005FC98B3A", hash_generated_field = "4E5A87EA4636A8ACF68875B877F3A7B8")

        int mFlags;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.174 -0400", hash_original_method = "A02438D61B10D43188F1250B87238337", hash_generated_method = "A7E039F9C95FB53F7B4BD1AF33E88189")
        public  TriangleMeshBuilder(RenderScript rs, int vtxSize, int flags) {
            mRS = rs;
            mVtxCount = 0;
            mIndexCount = 0;
            mVtxData = new float[128];
            mIndexData = new short[128];
            mVtxSize = vtxSize;
            mFlags = flags;
            if(vtxSize < 2 || vtxSize > 3)            
            {
                IllegalArgumentException varA396432527F50DA663AD9E6B86D0E879_204253626 = new IllegalArgumentException("Vertex size out of range.");
                varA396432527F50DA663AD9E6B86D0E879_204253626.addTaint(taint);
                throw varA396432527F50DA663AD9E6B86D0E879_204253626;
            } //End block
            // ---------- Original Method ----------
            //mRS = rs;
            //mVtxCount = 0;
            //mIndexCount = 0;
            //mVtxData = new float[128];
            //mIndexData = new short[128];
            //mVtxSize = vtxSize;
            //mFlags = flags;
            //if (vtxSize < 2 || vtxSize > 3) {
                //throw new IllegalArgumentException("Vertex size out of range.");
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.180 -0400", hash_original_method = "A80B7EA88EEABE74223D464930207C93", hash_generated_method = "20B5A873C2A32460E0E2C9333C508534")
        private void makeSpace(int count) {
            addTaint(count);
            if((mVtxCount + count) >= mVtxData.length)            
            {
                float t[] = new float[mVtxData.length * 2];
                System.arraycopy(mVtxData, 0, t, 0, mVtxData.length);
                mVtxData = t;
            } //End block
            // ---------- Original Method ----------
            //if ((mVtxCount + count) >= mVtxData.length) {
                //float t[] = new float[mVtxData.length * 2];
                //System.arraycopy(mVtxData, 0, t, 0, mVtxData.length);
                //mVtxData = t;
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.193 -0400", hash_original_method = "9C257BDCAF09464D019E44935C728B31", hash_generated_method = "5C29D1257CC99DCB18121248433715C0")
        private void latch() {
            if((mFlags & COLOR) != 0)            
            {
                makeSpace(4);
                mVtxData[mVtxCount++] = mR;
                mVtxData[mVtxCount++] = mG;
                mVtxData[mVtxCount++] = mB;
                mVtxData[mVtxCount++] = mA;
            } //End block
            if((mFlags & TEXTURE_0) != 0)            
            {
                makeSpace(2);
                mVtxData[mVtxCount++] = mS0;
                mVtxData[mVtxCount++] = mT0;
            } //End block
            if((mFlags & NORMAL) != 0)            
            {
                makeSpace(3);
                mVtxData[mVtxCount++] = mNX;
                mVtxData[mVtxCount++] = mNY;
                mVtxData[mVtxCount++] = mNZ;
            } //End block
            // ---------- Original Method ----------
            //if ((mFlags & COLOR) != 0) {
                //makeSpace(4);
                //mVtxData[mVtxCount++] = mR;
                //mVtxData[mVtxCount++] = mG;
                //mVtxData[mVtxCount++] = mB;
                //mVtxData[mVtxCount++] = mA;
            //}
            //if ((mFlags & TEXTURE_0) != 0) {
                //makeSpace(2);
                //mVtxData[mVtxCount++] = mS0;
                //mVtxData[mVtxCount++] = mT0;
            //}
            //if ((mFlags & NORMAL) != 0) {
                //makeSpace(3);
                //mVtxData[mVtxCount++] = mNX;
                //mVtxData[mVtxCount++] = mNY;
                //mVtxData[mVtxCount++] = mNZ;
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.202 -0400", hash_original_method = "D39116CA0B2556B236E2A719F71CCF2D", hash_generated_method = "4CDA88E029B2BD7BCB563B63989A1E96")
        public TriangleMeshBuilder addVertex(float x, float y) {
            if(mVtxSize != 2)            
            {
                IllegalStateException varA7806C43605FF024306CA4830A9C0C33_698527716 = new IllegalStateException("add mistmatch with declared components.");
                varA7806C43605FF024306CA4830A9C0C33_698527716.addTaint(taint);
                throw varA7806C43605FF024306CA4830A9C0C33_698527716;
            } //End block
            makeSpace(2);
            mVtxData[mVtxCount++] = x;
            mVtxData[mVtxCount++] = y;
            latch();
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_1583783483 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1583783483.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1583783483;
            // ---------- Original Method ----------
            //if (mVtxSize != 2) {
                //throw new IllegalStateException("add mistmatch with declared components.");
            //}
            //makeSpace(2);
            //mVtxData[mVtxCount++] = x;
            //mVtxData[mVtxCount++] = y;
            //latch();
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.211 -0400", hash_original_method = "B58461FA5218392331985BFBE25F1947", hash_generated_method = "AF38A1CF9A44B9500A1B7E97B21DE190")
        public TriangleMeshBuilder addVertex(float x, float y, float z) {
            if(mVtxSize != 3)            
            {
                IllegalStateException varA7806C43605FF024306CA4830A9C0C33_281269480 = new IllegalStateException("add mistmatch with declared components.");
                varA7806C43605FF024306CA4830A9C0C33_281269480.addTaint(taint);
                throw varA7806C43605FF024306CA4830A9C0C33_281269480;
            } //End block
            makeSpace(3);
            mVtxData[mVtxCount++] = x;
            mVtxData[mVtxCount++] = y;
            mVtxData[mVtxCount++] = z;
            latch();
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_1585987793 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1585987793.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1585987793;
            // ---------- Original Method ----------
            //if (mVtxSize != 3) {
                //throw new IllegalStateException("add mistmatch with declared components.");
            //}
            //makeSpace(3);
            //mVtxData[mVtxCount++] = x;
            //mVtxData[mVtxCount++] = y;
            //mVtxData[mVtxCount++] = z;
            //latch();
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.220 -0400", hash_original_method = "9F9ED6BD9ACDCF25B5DD5CE14A948BE1", hash_generated_method = "86A490B142E7CD9994C569C091FC61A1")
        public TriangleMeshBuilder setTexture(float s, float t) {
            if((mFlags & TEXTURE_0) == 0)            
            {
                IllegalStateException varA7806C43605FF024306CA4830A9C0C33_132031705 = new IllegalStateException("add mistmatch with declared components.");
                varA7806C43605FF024306CA4830A9C0C33_132031705.addTaint(taint);
                throw varA7806C43605FF024306CA4830A9C0C33_132031705;
            } //End block
            mS0 = s;
            mT0 = t;
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_1387428722 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1387428722.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1387428722;
            // ---------- Original Method ----------
            //if ((mFlags & TEXTURE_0) == 0) {
                //throw new IllegalStateException("add mistmatch with declared components.");
            //}
            //mS0 = s;
            //mT0 = t;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.229 -0400", hash_original_method = "6234685D550C65A17B5448D24C5DE3DB", hash_generated_method = "6DA5959985891A58DAD58F7DC5C5088A")
        public TriangleMeshBuilder setNormal(float x, float y, float z) {
            if((mFlags & NORMAL) == 0)            
            {
                IllegalStateException varA7806C43605FF024306CA4830A9C0C33_150809038 = new IllegalStateException("add mistmatch with declared components.");
                varA7806C43605FF024306CA4830A9C0C33_150809038.addTaint(taint);
                throw varA7806C43605FF024306CA4830A9C0C33_150809038;
            } //End block
            mNX = x;
            mNY = y;
            mNZ = z;
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_1742096910 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1742096910.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1742096910;
            // ---------- Original Method ----------
            //if ((mFlags & NORMAL) == 0) {
                //throw new IllegalStateException("add mistmatch with declared components.");
            //}
            //mNX = x;
            //mNY = y;
            //mNZ = z;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.243 -0400", hash_original_method = "548191703C76A8B001B6DF95B2A3596B", hash_generated_method = "EF232935224B727DA93C75C72E479774")
        public TriangleMeshBuilder setColor(float r, float g, float b, float a) {
            if((mFlags & COLOR) == 0)            
            {
                IllegalStateException varA7806C43605FF024306CA4830A9C0C33_1924877745 = new IllegalStateException("add mistmatch with declared components.");
                varA7806C43605FF024306CA4830A9C0C33_1924877745.addTaint(taint);
                throw varA7806C43605FF024306CA4830A9C0C33_1924877745;
            } //End block
            mR = r;
            mG = g;
            mB = b;
            mA = a;
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_30733350 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_30733350.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_30733350;
            // ---------- Original Method ----------
            //if ((mFlags & COLOR) == 0) {
                //throw new IllegalStateException("add mistmatch with declared components.");
            //}
            //mR = r;
            //mG = g;
            //mB = b;
            //mA = a;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.252 -0400", hash_original_method = "C9D8C24AD3C37A6598DC86CC627D46E8", hash_generated_method = "C9B261C79F9C64D4AD85DFA74F965F8D")
        public TriangleMeshBuilder addTriangle(int idx1, int idx2, int idx3) {
            if((idx1 >= mVtxCount) || (idx1 < 0) ||
               (idx2 >= mVtxCount) || (idx2 < 0) ||
               (idx3 >= mVtxCount) || (idx3 < 0))            
            {
                IllegalStateException varA9C525B4D3F14A00974CA923105A314B_902587192 = new IllegalStateException("Index provided greater than vertex count.");
                varA9C525B4D3F14A00974CA923105A314B_902587192.addTaint(taint);
                throw varA9C525B4D3F14A00974CA923105A314B_902587192;
            } //End block
            if((mIndexCount + 3) >= mIndexData.length)            
            {
                short t[] = new short[mIndexData.length * 2];
                System.arraycopy(mIndexData, 0, t, 0, mIndexData.length);
                mIndexData = t;
            } //End block
            mIndexData[mIndexCount++] = (short)idx1;
            mIndexData[mIndexCount++] = (short)idx2;
            mIndexData[mIndexCount++] = (short)idx3;
TriangleMeshBuilder var72A74007B2BE62B849F475C7BDA4658B_1267960466 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1267960466.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1267960466;
            // ---------- Original Method ----------
            //if((idx1 >= mVtxCount) || (idx1 < 0) ||
               //(idx2 >= mVtxCount) || (idx2 < 0) ||
               //(idx3 >= mVtxCount) || (idx3 < 0)) {
               //throw new IllegalStateException("Index provided greater than vertex count.");
            //}
            //if ((mIndexCount + 3) >= mIndexData.length) {
                //short t[] = new short[mIndexData.length * 2];
                //System.arraycopy(mIndexData, 0, t, 0, mIndexData.length);
                //mIndexData = t;
            //}
            //mIndexData[mIndexCount++] = (short)idx1;
            //mIndexData[mIndexCount++] = (short)idx2;
            //mIndexData[mIndexCount++] = (short)idx3;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.266 -0400", hash_original_method = "2C3CCC3A0B0167433C5BE22C88A67CDC", hash_generated_method = "8A79B40562512CF4B5AB4AD93F139E50")
        public Mesh create(boolean uploadToBufferObject) {
            addTaint(uploadToBufferObject);
            Element.Builder b = new Element.Builder(mRS);
            int floatCount = mVtxSize;
            b.add(Element.createVector(mRS,
                                       Element.DataType.FLOAT_32,
                                       mVtxSize), "position");
            if((mFlags & COLOR) != 0)            
            {
                floatCount += 4;
                b.add(Element.F32_4(mRS), "color");
            } //End block
            if((mFlags & TEXTURE_0) != 0)            
            {
                floatCount += 2;
                b.add(Element.F32_2(mRS), "texture0");
            } //End block
            if((mFlags & NORMAL) != 0)            
            {
                floatCount += 3;
                b.add(Element.F32_3(mRS), "normal");
            } //End block
            mElement = b.create();
            int usage = Allocation.USAGE_SCRIPT;
            if(uploadToBufferObject)            
            {
                usage |= Allocation.USAGE_GRAPHICS_VERTEX;
            } //End block
            Builder smb = new Builder(mRS, usage);
            smb.addVertexType(mElement, mVtxCount / floatCount);
            smb.addIndexSetType(Element.U16(mRS), mIndexCount, Primitive.TRIANGLE);
            Mesh sm = smb.create();
            sm.getVertexAllocation(0).copy1DRangeFromUnchecked(0, mVtxCount / floatCount, mVtxData);
            if(uploadToBufferObject)            
            {
                if(uploadToBufferObject)                
                {
                    sm.getVertexAllocation(0).syncAll(Allocation.USAGE_SCRIPT);
                } //End block
            } //End block
            sm.getIndexSetAllocation(0).copy1DRangeFromUnchecked(0, mIndexCount, mIndexData);
            if(uploadToBufferObject)            
            {
                sm.getIndexSetAllocation(0).syncAll(Allocation.USAGE_SCRIPT);
            } //End block
Mesh var5220340E6E130A2892C45EE6A9FC8EEF_1093901950 =             sm;
            var5220340E6E130A2892C45EE6A9FC8EEF_1093901950.addTaint(taint);
            return var5220340E6E130A2892C45EE6A9FC8EEF_1093901950;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.272 -0400", hash_original_field = "B2136B393557757400A32F114682085B", hash_generated_field = "43A680E9C8518C48BCC4E70F943AE42A")

        public static final int COLOR = 0x0001;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.274 -0400", hash_original_field = "2F3F48E48AC519F9DE0EA9ADDA8B1DAB", hash_generated_field = "6D62B99E0B040C5C3196106EE14343F8")

        public static final int NORMAL = 0x0002;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.277 -0400", hash_original_field = "7A3C2E07AF98FE9FF2A3028CAF03BD8E", hash_generated_field = "2AAF2A9E805535208D91D224CD95EFD6")

        public static final int TEXTURE_0 = 0x0100;
    }


    
}

