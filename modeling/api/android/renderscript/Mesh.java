package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import android.util.Log;
public class Mesh extends BaseObj {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.420 -0500", hash_original_field = "228985299EC15EB3441845338D5404EE", hash_generated_field = "228985299EC15EB3441845338D5404EE")

    Allocation[] mVertexBuffers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.423 -0500", hash_original_field = "C14CB5DE54A58C061EDE9BEC8FDDA8BC", hash_generated_field = "C14CB5DE54A58C061EDE9BEC8FDDA8BC")

    Allocation[] mIndexBuffers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.424 -0500", hash_original_field = "F75E417667F120CCE412F4D29FAE2D75", hash_generated_field = "F75E417667F120CCE412F4D29FAE2D75")

    Primitive[] mPrimitives;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.427 -0500", hash_original_method = "C8590D08EE8DAE10D21AC3FD65BED1A9", hash_generated_method = "C8590D08EE8DAE10D21AC3FD65BED1A9")
    
Mesh(int id, RenderScript rs) {
        super(id, rs);
    }

    /**
    * @return number of allocations containing vertex data
    *
    **/
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.429 -0500", hash_original_method = "EFFB20897006BD21D9CD85929E5DBB71", hash_generated_method = "108A7A742C93887BB574D24D333B8BE5")
    
public int getVertexAllocationCount() {
        if(mVertexBuffers == null) {
            return 0;
        }
        return mVertexBuffers.length;
    }
    /**
    * @param slot index in the list of allocations to return
    * @return vertex data allocation at the given index
    *
    **/
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.431 -0500", hash_original_method = "EA40159658251D040B5268F69F9B14EF", hash_generated_method = "16EA7DA0DB23193059F7E5C3711D2A0C")
    
public Allocation getVertexAllocation(int slot) {
        return mVertexBuffers[slot];
    }

    /**
    * @return number of primitives or index sets in the mesh
    *
    **/
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.433 -0500", hash_original_method = "428E6D74220E844332BAD2A4C35405F1", hash_generated_method = "71EC77A216CF591AAA20717175399221")
    
public int getPrimitiveCount() {
        if(mIndexBuffers == null) {
            return 0;
        }
        return mIndexBuffers.length;
    }

    /**
    * @param slot locaton within the list of index set allocation
    * @return allocation containing primtive index data or null if
    *         the index data is not specified explicitly
    *
    **/
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.435 -0500", hash_original_method = "08B7801C574B5FE1151D8579346309F3", hash_generated_method = "A1E590859719B375A7BCC1366CE95A40")
    
public Allocation getIndexSetAllocation(int slot) {
        return mIndexBuffers[slot];
    }
    /**
    * @param slot locaiton within the list of index set primitives
    * @return index set primitive type
    *
    **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.437 -0500", hash_original_method = "C97CD8ECF86AEBA4746DF3BE7591FFF7", hash_generated_method = "036F75AFFEB13829470694CEC5DFC00F")
    
public Primitive getPrimitive(int slot) {
        return mPrimitives[slot];
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.440 -0500", hash_original_method = "3C1F4A6EE05921D340A62A6B7A4FB1EA", hash_generated_method = "8B97527B20335FD8EB6031D294C259C0")
    
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

        for(int i = 0; i < vtxCount; i ++) {
            if(vtxIDs[i] != 0) {
                mVertexBuffers[i] = new Allocation(vtxIDs[i], mRS, null, Allocation.USAGE_SCRIPT);
                mVertexBuffers[i].updateFromNative();
            }
        }

        for(int i = 0; i < idxCount; i ++) {
            if(idxIDs[i] != 0) {
                mIndexBuffers[i] = new Allocation(idxIDs[i], mRS, null, Allocation.USAGE_SCRIPT);
                mIndexBuffers[i].updateFromNative();
            }
            mPrimitives[i] = Primitive.values()[primitives[i]];
        }
    }
    
    public enum Primitive {
        POINT (0),
        LINE (1),
        LINE_STRIP (2),
        TRIANGLE (3),
        TRIANGLE_STRIP (4),
        TRIANGLE_FAN (5);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.414 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.417 -0500", hash_original_method = "46CFD72C86F0EF4DDDCAF5935C3616A1", hash_generated_method = "46CFD72C86F0EF4DDDCAF5935C3616A1")
            
Primitive(int id) {
            mID = id;
        }
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.444 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.446 -0500", hash_original_field = "455102E0D248DC24482D3093AA618A87", hash_generated_field = "455102E0D248DC24482D3093AA618A87")

        int mUsage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.461 -0500", hash_original_field = "E8E332765C92B2986C0EAE3D3BDB65E4", hash_generated_field = "E8E332765C92B2986C0EAE3D3BDB65E4")

        int mVertexTypeCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.463 -0500", hash_original_field = "539B737A39B7384A78AF1746E9278B0D", hash_generated_field = "539B737A39B7384A78AF1746E9278B0D")

        Entry[] mVertexTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.465 -0500", hash_original_field = "B9D0A03C9BDC29783A27CC44B9B1FABF", hash_generated_field = "B9D0A03C9BDC29783A27CC44B9B1FABF")

        Vector mIndexTypes;

        /**
        * Creates builder object
        * @param rs Context to which the mesh will belong.
        * @param usage specifies how the mesh allocations are to be
        *              handled, whether they need to be uploaded to a
        *              buffer on the gpu, maintain a cpu copy, etc
        */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.467 -0500", hash_original_method = "6A7DE29092EDA44714340A63C02A4D3B", hash_generated_method = "FE59A714AA86440F96C9684260C0FB9F")
        
public Builder(RenderScript rs, int usage) {
            mRS = rs;
            mUsage = usage;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
        }

        /**
        * @return internal index of the last vertex buffer type added to
        *         builder
        **/
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.469 -0500", hash_original_method = "F2CC44AB8332A9CEBA185D757457B141", hash_generated_method = "AB6444224FCF13EB25D4DC9D3EE44929")
        
public int getCurrentVertexTypeIndex() {
            return mVertexTypeCount - 1;
        }

        /**
        * @return internal index of the last index set added to the
        *         builder
        **/
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.471 -0500", hash_original_method = "390DA790368F4A077D3D7345AE862264", hash_generated_method = "3E79BFC79E6F8702652F2302554A8854")
        
public int getCurrentIndexSetIndex() {
            return mIndexTypes.size() - 1;
        }

        /**
        * Adds a vertex data type to the builder object
        *
        * @param t type of the vertex data allocation to be created
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.474 -0500", hash_original_method = "4288B76F5BEB205918AF7DDCE9EEE5BF", hash_generated_method = "1D1197DEDB5E6762F259CE237F1BB214")
        
public Builder addVertexType(Type t) throws IllegalStateException {
            if (mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }

            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].t = t;
            mVertexTypes[mVertexTypeCount].e = null;
            mVertexTypeCount++;
            return this;
        }

        /**
        * Adds a vertex data type to the builder object
        *
        * @param e element describing the vertex data layout
        * @param size number of elements in the buffer
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.477 -0500", hash_original_method = "FE7A9140417CA4AD355B5E4C1351F0BC", hash_generated_method = "DD4748BB53D7843472D4C3EC86AF1A5A")
        
public Builder addVertexType(Element e, int size) throws IllegalStateException {
            if (mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }

            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].t = null;
            mVertexTypes[mVertexTypeCount].e = e;
            mVertexTypes[mVertexTypeCount].size = size;
            mVertexTypeCount++;
            return this;
        }

        /**
        * Adds an index set data type to the builder object
        *
        * @param t type of the index set data, could be null
        * @param p primitive type
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.479 -0500", hash_original_method = "6F637DE57BFF0697961ABB272635A4DE", hash_generated_method = "A214DD609BE48B31838063BF1BAE6AA3")
        
public Builder addIndexSetType(Type t, Primitive p) {
            Entry indexType = new Entry();
            indexType.t = t;
            indexType.e = null;
            indexType.size = 0;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
            return this;
        }

        /**
        * Adds an index set primitive type to the builder object
        *
        * @param p primitive type
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.482 -0500", hash_original_method = "2E7034A69395E1E5DBB2950602CE4F4E", hash_generated_method = "5845989284F179105F977771244844BC")
        
public Builder addIndexSetType(Primitive p) {
            Entry indexType = new Entry();
            indexType.t = null;
            indexType.e = null;
            indexType.size = 0;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
            return this;
        }

        /**
        * Adds an index set data type to the builder object
        *
        * @param e element describing the index set data layout
        * @param size number of elements in the buffer
        * @param p primitive type
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.485 -0500", hash_original_method = "62E497D1E15AFECC6C75E1097FD3DEF1", hash_generated_method = "8AC45787E7FEC989E71E6363A176932F")
        
public Builder addIndexSetType(Element e, int size, Primitive p) {
            Entry indexType = new Entry();
            indexType.t = null;
            indexType.e = e;
            indexType.size = size;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
            return this;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.487 -0500", hash_original_method = "A5F13BDB43E03AFA74C8CAC08DECE9D7", hash_generated_method = "A5F13BDB43E03AFA74C8CAC08DECE9D7")
        
Type newType(Element e, int size) {
            Type.Builder tb = new Type.Builder(mRS, e);
            tb.setX(size);
            return tb.create();
        }

        /**
        * Create a Mesh object from the current state of the builder
        *
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.490 -0500", hash_original_method = "2B7677CA7551A1CB975DB188DC4C64F4", hash_generated_method = "0ABE137D752E72CFDE12717489F303EF")
        
public Mesh create() {
            mRS.validate();
            int[] vtx = new int[mVertexTypeCount];
            int[] idx = new int[mIndexTypes.size()];
            int[] prim = new int[mIndexTypes.size()];

            Allocation[] vertexBuffers = new Allocation[mVertexTypeCount];
            Allocation[] indexBuffers = new Allocation[mIndexTypes.size()];
            Primitive[] primitives = new Primitive[mIndexTypes.size()];

            for(int ct = 0; ct < mVertexTypeCount; ct ++) {
                Allocation alloc = null;
                Entry entry = mVertexTypes[ct];
                if (entry.t != null) {
                    alloc = Allocation.createTyped(mRS, entry.t, mUsage);
                } else if(entry.e != null) {
                    alloc = Allocation.createSized(mRS, entry.e, entry.size, mUsage);
                }
                vertexBuffers[ct] = alloc;
                vtx[ct] = alloc.getID();
            }

            for(int ct = 0; ct < mIndexTypes.size(); ct ++) {
                Allocation alloc = null;
                Entry entry = (Entry)mIndexTypes.elementAt(ct);
                if (entry.t != null) {
                    alloc = Allocation.createTyped(mRS, entry.t, mUsage);
                } else if(entry.e != null) {
                    alloc = Allocation.createSized(mRS, entry.e, entry.size, mUsage);
                }
                int allocID = (alloc == null) ? 0 : alloc.getID();
                indexBuffers[ct] = alloc;
                primitives[ct] = entry.prim;

                idx[ct] = allocID;
                prim[ct] = entry.prim.mID;
            }

            int id = mRS.nMeshCreate(vtx, idx, prim);
            Mesh newMesh = new Mesh(id, mRS);
            newMesh.mVertexBuffers = vertexBuffers;
            newMesh.mIndexBuffers = indexBuffers;
            newMesh.mPrimitives = primitives;

            return newMesh;
        }
        
        class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.448 -0500", hash_original_field = "905363B609753A7290BA348AA0EE865A", hash_generated_field = "905363B609753A7290BA348AA0EE865A")

            Type t;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.451 -0500", hash_original_field = "44BE21ACD70B32E38EE19EC4AA7174B9", hash_generated_field = "44BE21ACD70B32E38EE19EC4AA7174B9")

            Element e;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.453 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "673BDAEBF4FBC900963E210E042549D6")

            int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.501 -0500", hash_original_field = "D5219C1134DF6E7B6EDFCF6D15F9A2C5", hash_generated_field = "D5219C1134DF6E7B6EDFCF6D15F9A2C5")

            Primitive prim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.457 -0500", hash_original_field = "4DECCE63637B64496145E832A72ECA7C", hash_generated_field = "4DECCE63637B64496145E832A72ECA7C")

            int usage;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:52.044 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
            public Entry ()
            {
                //Synthesized constructor
            }

        }
        
    }
    
    public static class AllocationBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.496 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.505 -0500", hash_original_field = "E8E332765C92B2986C0EAE3D3BDB65E4", hash_generated_field = "E8E332765C92B2986C0EAE3D3BDB65E4")

        int mVertexTypeCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.507 -0500", hash_original_field = "539B737A39B7384A78AF1746E9278B0D", hash_generated_field = "539B737A39B7384A78AF1746E9278B0D")

        Entry[] mVertexTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.509 -0500", hash_original_field = "B9D0A03C9BDC29783A27CC44B9B1FABF", hash_generated_field = "B9D0A03C9BDC29783A27CC44B9B1FABF")

        Vector mIndexTypes;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.512 -0500", hash_original_method = "1C2A9BD6903F1FC6804233482DDA3B70", hash_generated_method = "A6F96A8F44933D5643BA348A94DB57BB")
        
public AllocationBuilder(RenderScript rs) {
            mRS = rs;
            mVertexTypeCount = 0;
            mVertexTypes = new Entry[16];
            mIndexTypes = new Vector();
        }

        /**
        * @return internal index of the last vertex buffer type added to
        *         builder
        **/
        @DSSource({DSSourceKind.LOCATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.514 -0500", hash_original_method = "F2CC44AB8332A9CEBA185D757457B141", hash_generated_method = "AB6444224FCF13EB25D4DC9D3EE44929")
        
public int getCurrentVertexTypeIndex() {
            return mVertexTypeCount - 1;
        }

        /**
        * @return internal index of the last index set added to the
        *         builder
        **/
        @DSSource({DSSourceKind.LOCATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.516 -0500", hash_original_method = "390DA790368F4A077D3D7345AE862264", hash_generated_method = "3E79BFC79E6F8702652F2302554A8854")
        
public int getCurrentIndexSetIndex() {
            return mIndexTypes.size() - 1;
        }

        /**
        * Adds an allocation containing vertex buffer data to the
        * builder
        *
        * @param a vertex data allocation
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.518 -0500", hash_original_method = "77399CB88844FFACF599E547771813AB", hash_generated_method = "95AE91D261F621CEFE3540302C0B4D7E")
        
public AllocationBuilder addVertexAllocation(Allocation a) throws IllegalStateException {
            if (mVertexTypeCount >= mVertexTypes.length) {
                throw new IllegalStateException("Max vertex types exceeded.");
            }

            mVertexTypes[mVertexTypeCount] = new Entry();
            mVertexTypes[mVertexTypeCount].a = a;
            mVertexTypeCount++;
            return this;
        }

        /**
        * Adds an allocation containing index buffer data and index type
        * to the builder
        *
        * @param a index set data allocation, could be null
        * @param p index set primitive type
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.521 -0500", hash_original_method = "F6D22E1C9E233B4CE6C95173573B1ADC", hash_generated_method = "6BCA618D48FCE08050F1572F5B36E241")
        
public AllocationBuilder addIndexSetAllocation(Allocation a, Primitive p) {
            Entry indexType = new Entry();
            indexType.a = a;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
            return this;
        }

        /**
        * Adds an index set type to the builder
        *
        * @param p index set primitive type
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.524 -0500", hash_original_method = "3F005229FAC5669CED0C1EDA320C3ED4", hash_generated_method = "58DD3E2A538F54ACD2033ECAA73C07AE")
        
public AllocationBuilder addIndexSetType(Primitive p) {
            Entry indexType = new Entry();
            indexType.a = null;
            indexType.prim = p;
            mIndexTypes.addElement(indexType);
            return this;
        }

        /**
        * Create a Mesh object from the current state of the builder
        *
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.527 -0500", hash_original_method = "26A045F795A631008C79D159817C5762", hash_generated_method = "258CC6A1F3B447429293C07E7A4C1F65")
        
public Mesh create() {
            mRS.validate();

            int[] vtx = new int[mVertexTypeCount];
            int[] idx = new int[mIndexTypes.size()];
            int[] prim = new int[mIndexTypes.size()];

            Allocation[] indexBuffers = new Allocation[mIndexTypes.size()];
            Primitive[] primitives = new Primitive[mIndexTypes.size()];
            Allocation[] vertexBuffers = new Allocation[mVertexTypeCount];

            for(int ct = 0; ct < mVertexTypeCount; ct ++) {
                Entry entry = mVertexTypes[ct];
                vertexBuffers[ct] = entry.a;
                vtx[ct] = entry.a.getID();
            }

            for(int ct = 0; ct < mIndexTypes.size(); ct ++) {
                Entry entry = (Entry)mIndexTypes.elementAt(ct);
                int allocID = (entry.a == null) ? 0 : entry.a.getID();
                indexBuffers[ct] = entry.a;
                primitives[ct] = entry.prim;

                idx[ct] = allocID;
                prim[ct] = entry.prim.mID;
            }

            int id = mRS.nMeshCreate(vtx, idx, prim);
            Mesh newMesh = new Mesh(id, mRS);
            newMesh.mVertexBuffers = vertexBuffers;
            newMesh.mIndexBuffers = indexBuffers;
            newMesh.mPrimitives = primitives;

            return newMesh;
        }
        
        class Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.499 -0500", hash_original_field = "0A5181B731DCCB4745C5810BC91FA8CC", hash_generated_field = "0A5181B731DCCB4745C5810BC91FA8CC")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.568 -0500", hash_original_field = "763DA14A918A15DB84400041DD8605D7", hash_generated_field = "43A680E9C8518C48BCC4E70F943AE42A")

        public static final int COLOR = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.570 -0500", hash_original_field = "C6BB4AF27C97402F33E80B9BB2F37B29", hash_generated_field = "6D62B99E0B040C5C3196106EE14343F8")

        public static final int NORMAL = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.573 -0500", hash_original_field = "B2281902A74AC2B708FD3D419013D95F", hash_generated_field = "2AAF2A9E805535208D91D224CD95EFD6")

        public static final int TEXTURE_0 = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.532 -0500", hash_original_field = "09E7F62ED7C9C7F4586D795077BFA466", hash_generated_field = "09E7F62ED7C9C7F4586D795077BFA466")

        float mVtxData[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.534 -0500", hash_original_field = "BF593DF59A5F954FABA9CA61996E3C84", hash_generated_field = "BF593DF59A5F954FABA9CA61996E3C84")

        int mVtxCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.536 -0500", hash_original_field = "5C5241866E4B058149AA37C090BCE02A", hash_generated_field = "5C5241866E4B058149AA37C090BCE02A")

        short mIndexData[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.538 -0500", hash_original_field = "E1ECB1DDEFFF13E68109AF61CC5BD569", hash_generated_field = "E1ECB1DDEFFF13E68109AF61CC5BD569")

        int mIndexCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.540 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.542 -0500", hash_original_field = "EC8CEE28EE8EC6C488BEE33A3E23406D", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

        Element mElement;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.544 -0500", hash_original_field = "EEDC8AAF9952117629CEBEE39820FEB4", hash_generated_field = "EEDC8AAF9952117629CEBEE39820FEB4")

        float mNX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.546 -0500", hash_original_field = "FBE457259607881D8AE24361D1690EC7", hash_generated_field = "FBE457259607881D8AE24361D1690EC7")

        float mNY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.548 -0500", hash_original_field = "D3095026A3695EF1B8793C370FD2BFC2", hash_generated_field = "D3095026A3695EF1B8793C370FD2BFC2")

        float mNZ = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.551 -0500", hash_original_field = "19A1C6A54E1A9D264A5DFA632BD248FF", hash_generated_field = "19A1C6A54E1A9D264A5DFA632BD248FF")

        float mS0 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.553 -0500", hash_original_field = "B4F0C2F01100EA5D2FFA93D6427B5372", hash_generated_field = "B4F0C2F01100EA5D2FFA93D6427B5372")

        float mT0 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.555 -0500", hash_original_field = "87BE476E4DB60BD355FC9D925BF8F8EC", hash_generated_field = "87BE476E4DB60BD355FC9D925BF8F8EC")

        float mR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.557 -0500", hash_original_field = "9A71E90DFDE5099D07C80770C63947DD", hash_generated_field = "9A71E90DFDE5099D07C80770C63947DD")

        float mG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.559 -0500", hash_original_field = "B102327E6DBC8B9CFDB80024C3AACD11", hash_generated_field = "B102327E6DBC8B9CFDB80024C3AACD11")

        float mB = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.561 -0500", hash_original_field = "1A7CFAD690644F721CD7875A70033C22", hash_generated_field = "1A7CFAD690644F721CD7875A70033C22")

        float mA = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.563 -0500", hash_original_field = "8C7E1C196B99C0E2B82C13F834059AE7", hash_generated_field = "8C7E1C196B99C0E2B82C13F834059AE7")

        int mVtxSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.565 -0500", hash_original_field = "4E5A87EA4636A8ACF68875B877F3A7B8", hash_generated_field = "4E5A87EA4636A8ACF68875B877F3A7B8")

        int mFlags;

        /**
        * @param rs Context to which the mesh will belong.
        * @param vtxSize specifies whether the vertex is a float2 or
        *                float3
        * @param flags bitfield that is a combination of COLOR, NORMAL,
        *              and TEXTURE_0 that specifies what vertex data
        *              channels are present in the mesh
        *
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.575 -0500", hash_original_method = "A02438D61B10D43188F1250B87238337", hash_generated_method = "9734513F6F6406800DEC0CF26EDE4EE1")
        
public TriangleMeshBuilder(RenderScript rs, int vtxSize, int flags) {
            mRS = rs;
            mVtxCount = 0;
            mIndexCount = 0;
            mVtxData = new float[128];
            mIndexData = new short[128];
            mVtxSize = vtxSize;
            mFlags = flags;

            if (vtxSize < 2 || vtxSize > 3) {
                throw new IllegalArgumentException("Vertex size out of range.");
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.578 -0500", hash_original_method = "A80B7EA88EEABE74223D464930207C93", hash_generated_method = "ACCD9CF94E95130FE0E7103C62F81191")
        
private void makeSpace(int count) {
            if ((mVtxCount + count) >= mVtxData.length) {
                float t[] = new float[mVtxData.length * 2];
                System.arraycopy(mVtxData, 0, t, 0, mVtxData.length);
                mVtxData = t;
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.580 -0500", hash_original_method = "9C257BDCAF09464D019E44935C728B31", hash_generated_method = "27F41139843D8C4D8AE05171392DB842")
        
private void latch() {
            if ((mFlags & COLOR) != 0) {
                makeSpace(4);
                mVtxData[mVtxCount++] = mR;
                mVtxData[mVtxCount++] = mG;
                mVtxData[mVtxCount++] = mB;
                mVtxData[mVtxCount++] = mA;
            }
            if ((mFlags & TEXTURE_0) != 0) {
                makeSpace(2);
                mVtxData[mVtxCount++] = mS0;
                mVtxData[mVtxCount++] = mT0;
            }
            if ((mFlags & NORMAL) != 0) {
                makeSpace(3);
                mVtxData[mVtxCount++] = mNX;
                mVtxData[mVtxCount++] = mNY;
                mVtxData[mVtxCount++] = mNZ;
            }
        }

        /**
        * Adds a float2 vertex to the mesh
        *
        * @param x position x
        * @param y position y
        *
        * @return this
        *
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.583 -0500", hash_original_method = "D39116CA0B2556B236E2A719F71CCF2D", hash_generated_method = "AFB55EFC777A028E15A3C37CA4364508")
        
public TriangleMeshBuilder addVertex(float x, float y) {
            if (mVtxSize != 2) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            makeSpace(2);
            mVtxData[mVtxCount++] = x;
            mVtxData[mVtxCount++] = y;
            latch();
            return this;
        }

        /**
        * Adds a float3 vertex to the mesh
        *
        * @param x position x
        * @param y position y
        * @param z position z
        *
        * @return this
        *
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.585 -0500", hash_original_method = "B58461FA5218392331985BFBE25F1947", hash_generated_method = "EF0980640685F1E6DD009AED23156E27")
        
public TriangleMeshBuilder addVertex(float x, float y, float z) {
            if (mVtxSize != 3) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            makeSpace(3);
            mVtxData[mVtxCount++] = x;
            mVtxData[mVtxCount++] = y;
            mVtxData[mVtxCount++] = z;
            latch();
            return this;
        }

        /**
        * Sets the texture coordinate for the last added vertex
        *
        * @param s texture coordinate s
        * @param t texture coordinate t
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.588 -0500", hash_original_method = "9F9ED6BD9ACDCF25B5DD5CE14A948BE1", hash_generated_method = "CC2EE78F78C9E279CF3542D153F6E385")
        
public TriangleMeshBuilder setTexture(float s, float t) {
            if ((mFlags & TEXTURE_0) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            mS0 = s;
            mT0 = t;
            return this;
        }

        /**
        * Sets the normal vector for the last added vertex
        *
        * @param x normal vector x
        * @param y normal vector y
        * @param z normal vector z
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.590 -0500", hash_original_method = "6234685D550C65A17B5448D24C5DE3DB", hash_generated_method = "2BC9BC8E2C17A37D9F6DAD03F7587FAB")
        
public TriangleMeshBuilder setNormal(float x, float y, float z) {
            if ((mFlags & NORMAL) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            mNX = x;
            mNY = y;
            mNZ = z;
            return this;
        }

        /**
        * Sets the color for the last added vertex
        *
        * @param r red component
        * @param g green component
        * @param b blue component
        * @param a alpha component
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.593 -0500", hash_original_method = "548191703C76A8B001B6DF95B2A3596B", hash_generated_method = "A6B88DC338E142CAB0D36BD69C2AF026")
        
public TriangleMeshBuilder setColor(float r, float g, float b, float a) {
            if ((mFlags & COLOR) == 0) {
                throw new IllegalStateException("add mistmatch with declared components.");
            }
            mR = r;
            mG = g;
            mB = b;
            mA = a;
            return this;
        }

        /**
        * Adds a new triangle to the mesh builder
        *
        * @param idx1 index of the first vertex in the triangle
        * @param idx2 index of the second vertex in the triangle
        * @param idx3 index of the third vertex in the triangle
        *
        * @return this
        **/
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.596 -0500", hash_original_method = "C9D8C24AD3C37A6598DC86CC627D46E8", hash_generated_method = "A68B6C3B0295C02912802728D6136C18")
        
public TriangleMeshBuilder addTriangle(int idx1, int idx2, int idx3) {
            if((idx1 >= mVtxCount) || (idx1 < 0) ||
               (idx2 >= mVtxCount) || (idx2 < 0) ||
               (idx3 >= mVtxCount) || (idx3 < 0)) {
               throw new IllegalStateException("Index provided greater than vertex count.");
            }
            if ((mIndexCount + 3) >= mIndexData.length) {
                short t[] = new short[mIndexData.length * 2];
                System.arraycopy(mIndexData, 0, t, 0, mIndexData.length);
                mIndexData = t;
            }
            mIndexData[mIndexCount++] = (short)idx1;
            mIndexData[mIndexCount++] = (short)idx2;
            mIndexData[mIndexCount++] = (short)idx3;
            return this;
        }

        /**
        * Creates the mesh object from the current state of the builder
        *
        * @param uploadToBufferObject specifies whether the vertex data
        *                             is to be uploaded into the buffer
        *                             object indicating that it's likely
        *                             not going to be modified and
        *                             rendered many times.
        *                             Alternatively, it indicates the
        *                             mesh data will be updated
        *                             frequently and remain in script
        *                             accessible memory
        *
        **/
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.599 -0500", hash_original_method = "2C3CCC3A0B0167433C5BE22C88A67CDC", hash_generated_method = "449300807E51E8F11A0B0C45F9B27BAA")
        
public Mesh create(boolean uploadToBufferObject) {
            Element.Builder b = new Element.Builder(mRS);
            int floatCount = mVtxSize;
            b.add(Element.createVector(mRS,
                                       Element.DataType.FLOAT_32,
                                       mVtxSize), "position");
            if ((mFlags & COLOR) != 0) {
                floatCount += 4;
                b.add(Element.F32_4(mRS), "color");
            }
            if ((mFlags & TEXTURE_0) != 0) {
                floatCount += 2;
                b.add(Element.F32_2(mRS), "texture0");
            }
            if ((mFlags & NORMAL) != 0) {
                floatCount += 3;
                b.add(Element.F32_3(mRS), "normal");
            }
            mElement = b.create();

            int usage = Allocation.USAGE_SCRIPT;
            if (uploadToBufferObject) {
                usage |= Allocation.USAGE_GRAPHICS_VERTEX;
            }

            Builder smb = new Builder(mRS, usage);
            smb.addVertexType(mElement, mVtxCount / floatCount);
            smb.addIndexSetType(Element.U16(mRS), mIndexCount, Primitive.TRIANGLE);

            Mesh sm = smb.create();

            sm.getVertexAllocation(0).copy1DRangeFromUnchecked(0, mVtxCount / floatCount, mVtxData);
            if(uploadToBufferObject) {
                if (uploadToBufferObject) {
                    sm.getVertexAllocation(0).syncAll(Allocation.USAGE_SCRIPT);
                }
            }

            sm.getIndexSetAllocation(0).copy1DRangeFromUnchecked(0, mIndexCount, mIndexData);
            if (uploadToBufferObject) {
                sm.getIndexSetAllocation(0).syncAll(Allocation.USAGE_SCRIPT);
            }

            return sm;
        }
    }
    
}

