package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.lang.reflect.Field;
public class Element extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.118 -0400", hash_original_field = "27DFA0EFE73BCB065533443A05E9DEE4", hash_generated_field = "205262C28D2B190751535A4911B3B259")

    int mSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.121 -0400", hash_original_field = "5F08D8DE811A201CF2BECC1D66F00FCC", hash_generated_field = "B4AACD1A33198C98C0C0D6BB21148E0E")

    Element[] mElements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.122 -0400", hash_original_field = "F458E8DD1F3D4CB057ABB781BF97671A", hash_generated_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E")

    String[] mElementNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.124 -0400", hash_original_field = "8CEBB4967C4FB046DD13A018630D8C5D", hash_generated_field = "CCF5C576DC1912807FD250325C1CD519")

    int[] mArraySizes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.126 -0400", hash_original_field = "719F288B84755037657CFC2F714A2014", hash_generated_field = "2E5F2887D0D6DD04ADD3744A455172F1")

    int[] mOffsetInBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.136 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "C0DAE69C302036895B5D54FD7E7F24F6")

    DataType mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.137 -0400", hash_original_field = "A57829A9478D9B821141F43000369D95", hash_generated_field = "8565922A5748730DA211092C23993311")

    DataKind mKind;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.139 -0400", hash_original_field = "90B22E8556054C0F15B0D3DA315A6CB4", hash_generated_field = "F95038D32AB5A54E42A838D357D13473")

    boolean mNormalized;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.140 -0400", hash_original_field = "2B1A0A11E8070F51942CBACB65953448", hash_generated_field = "9770236E3CE44E9B0E69591DDC704970")

    int mVectorSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.170 -0400", hash_original_method = "ED819749D70FA098614C1909362577A7", hash_generated_method = "CE2E8D46BE450D8CEBE76CA71A3A9B02")
      Element(int id, RenderScript rs, Element[] e, String[] n, int[] as) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        mSize = 0;
        mElements = e;
        mElementNames = n;
        mArraySizes = as;
        mOffsetInBytes = new int[mElements.length];
for(int ct = 0;ct < mElements.length;ct++)
        {
            mOffsetInBytes[ct] = mSize;
            mSize += mElements[ct].mSize * mArraySizes[ct];
        } //End block
        // ---------- Original Method ----------
        //mSize = 0;
        //mElements = e;
        //mElementNames = n;
        //mArraySizes = as;
        //mOffsetInBytes = new int[mElements.length];
        //for (int ct = 0; ct < mElements.length; ct++ ) {
            //mOffsetInBytes[ct] = mSize;
            //mSize += mElements[ct].mSize * mArraySizes[ct];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.197 -0400", hash_original_method = "803DBF0EEF773E6E2205B989242FDDA6", hash_generated_method = "D2721BDAA8186B0B6218CBB09FAFE982")
      Element(int id, RenderScript rs, DataType dt, DataKind dk, boolean norm, int size) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        if((dt != DataType.UNSIGNED_5_6_5) &&
            (dt != DataType.UNSIGNED_4_4_4_4) &&
            (dt != DataType.UNSIGNED_5_5_5_1))        
        {
            mSize = dt.mSize * size;
        } //End block
        else
        {
            mSize = dt.mSize;
        } //End block
        mType = dt;
        mKind = dk;
        mNormalized = norm;
        mVectorSize = size;
        // ---------- Original Method ----------
        //if ((dt != DataType.UNSIGNED_5_6_5) &&
            //(dt != DataType.UNSIGNED_4_4_4_4) &&
            //(dt != DataType.UNSIGNED_5_5_5_1)) {
            //mSize = dt.mSize * size;
        //} else {
            //mSize = dt.mSize;
        //}
        //mType = dt;
        //mKind = dk;
        //mNormalized = norm;
        //mVectorSize = size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.208 -0400", hash_original_method = "C4EFD6253604440679EF13CF69D2FF93", hash_generated_method = "30D29169204F7BA0FD51CFBBE19BD7A1")
      Element(int id, RenderScript rs) {
        super(id, rs);
        addTaint(rs.getTaint());
        addTaint(id);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.213 -0400", hash_original_method = "0A9009DB77E5CAA409A88E1F9233C5BB", hash_generated_method = "226DBE09E1C0C94BCF68E5340320ADA0")
    public int getSizeBytes() {
        int var27DFA0EFE73BCB065533443A05E9DEE4_1263664508 = (mSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6153862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6153862;
        // ---------- Original Method ----------
        //return mSize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.226 -0400", hash_original_method = "62F3D976050C390A4D28EE7C5F1BA715", hash_generated_method = "130FE49B10F3C1358AE34D5763958F38")
    public boolean isComplex() {
        if(mElements == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_28684182 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717699814 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_717699814;
        } //End block
for(int ct=0;ct < mElements.length;ct++)
        {
            if(mElements[ct].mElements != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_981068497 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1007881478 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1007881478;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1723722122 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1086749192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1086749192;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //return false;
        //}
        //for (int ct=0; ct < mElements.length; ct++) {
            //if (mElements[ct].mElements != null) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.238 -0400", hash_original_method = "D2C3182AD613A846205329B1E6C8F2DD", hash_generated_method = "E170803E5449688591A4E83F75A57C49")
    public int getSubElementCount() {
        if(mElements == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_515978202 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098051232 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1098051232;
        } //End block
        int varF64E87D190AF5F2B6586AA53B3F00F39_409853090 = (mElements.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715006448 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1715006448;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //return 0;
        //}
        //return mElements.length;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.245 -0400", hash_original_method = "14503E907986F4FAF260BC78C8B9B60E", hash_generated_method = "7657982606455F339312064001A7A68C")
    public Element getSubElement(int index) {
        addTaint(index);
        if(mElements == null)        
        {
            RSIllegalArgumentException var914CEAF3E794B1225B99CD0F88864A62_1561978398 = new RSIllegalArgumentException("Element contains no sub-elements");
            var914CEAF3E794B1225B99CD0F88864A62_1561978398.addTaint(taint);
            throw var914CEAF3E794B1225B99CD0F88864A62_1561978398;
        } //End block
        if(index < 0 || index >= mElements.length)        
        {
            RSIllegalArgumentException varAFE796EBE1BE73691C47EF864FF9DBFA_2045858236 = new RSIllegalArgumentException("Illegal sub-element index");
            varAFE796EBE1BE73691C47EF864FF9DBFA_2045858236.addTaint(taint);
            throw varAFE796EBE1BE73691C47EF864FF9DBFA_2045858236;
        } //End block
Element var01634E1010C71CE7AF89626E37E0002C_180239634 =         mElements[index];
        var01634E1010C71CE7AF89626E37E0002C_180239634.addTaint(taint);
        return var01634E1010C71CE7AF89626E37E0002C_180239634;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //throw new RSIllegalArgumentException("Element contains no sub-elements");
        //}
        //if (index < 0 || index >= mElements.length) {
            //throw new RSIllegalArgumentException("Illegal sub-element index");
        //}
        //return mElements[index];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.253 -0400", hash_original_method = "E8F6A160EAF7D73719B978688CDD0426", hash_generated_method = "1188009D492A8873F88E4F17A6037D7D")
    public String getSubElementName(int index) {
        addTaint(index);
        if(mElements == null)        
        {
            RSIllegalArgumentException var914CEAF3E794B1225B99CD0F88864A62_423479222 = new RSIllegalArgumentException("Element contains no sub-elements");
            var914CEAF3E794B1225B99CD0F88864A62_423479222.addTaint(taint);
            throw var914CEAF3E794B1225B99CD0F88864A62_423479222;
        } //End block
        if(index < 0 || index >= mElements.length)        
        {
            RSIllegalArgumentException varAFE796EBE1BE73691C47EF864FF9DBFA_52557622 = new RSIllegalArgumentException("Illegal sub-element index");
            varAFE796EBE1BE73691C47EF864FF9DBFA_52557622.addTaint(taint);
            throw varAFE796EBE1BE73691C47EF864FF9DBFA_52557622;
        } //End block
String var9EBA82020782C4E7141C35B9A8C03EC7_321162436 =         mElementNames[index];
        var9EBA82020782C4E7141C35B9A8C03EC7_321162436.addTaint(taint);
        return var9EBA82020782C4E7141C35B9A8C03EC7_321162436;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //throw new RSIllegalArgumentException("Element contains no sub-elements");
        //}
        //if (index < 0 || index >= mElements.length) {
            //throw new RSIllegalArgumentException("Illegal sub-element index");
        //}
        //return mElementNames[index];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.260 -0400", hash_original_method = "19B70985107F13C23CD2C2D21B16BDB6", hash_generated_method = "6EDCEA05FCE1D815A8241E240C049FF4")
    public int getSubElementArraySize(int index) {
        addTaint(index);
        if(mElements == null)        
        {
            RSIllegalArgumentException var914CEAF3E794B1225B99CD0F88864A62_332304800 = new RSIllegalArgumentException("Element contains no sub-elements");
            var914CEAF3E794B1225B99CD0F88864A62_332304800.addTaint(taint);
            throw var914CEAF3E794B1225B99CD0F88864A62_332304800;
        } //End block
        if(index < 0 || index >= mElements.length)        
        {
            RSIllegalArgumentException varAFE796EBE1BE73691C47EF864FF9DBFA_2004476367 = new RSIllegalArgumentException("Illegal sub-element index");
            varAFE796EBE1BE73691C47EF864FF9DBFA_2004476367.addTaint(taint);
            throw varAFE796EBE1BE73691C47EF864FF9DBFA_2004476367;
        } //End block
        int var7B272D3EEFE491DEB834C2706E837D8A_128286457 = (mArraySizes[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090582299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090582299;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //throw new RSIllegalArgumentException("Element contains no sub-elements");
        //}
        //if (index < 0 || index >= mElements.length) {
            //throw new RSIllegalArgumentException("Illegal sub-element index");
        //}
        //return mArraySizes[index];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.280 -0400", hash_original_method = "1AC48AE3A04EA0A2E41E968266E6585D", hash_generated_method = "5471ADEF5D725ACA42AF30A69E13CFB6")
    public int getSubElementOffsetBytes(int index) {
        addTaint(index);
        if(mElements == null)        
        {
            RSIllegalArgumentException var914CEAF3E794B1225B99CD0F88864A62_1126614232 = new RSIllegalArgumentException("Element contains no sub-elements");
            var914CEAF3E794B1225B99CD0F88864A62_1126614232.addTaint(taint);
            throw var914CEAF3E794B1225B99CD0F88864A62_1126614232;
        } //End block
        if(index < 0 || index >= mElements.length)        
        {
            RSIllegalArgumentException varAFE796EBE1BE73691C47EF864FF9DBFA_1265080032 = new RSIllegalArgumentException("Illegal sub-element index");
            varAFE796EBE1BE73691C47EF864FF9DBFA_1265080032.addTaint(taint);
            throw varAFE796EBE1BE73691C47EF864FF9DBFA_1265080032;
        } //End block
        int varF6FAE5503FF35058E957085F54C1C621_1889350679 = (mOffsetInBytes[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329995221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1329995221;
        // ---------- Original Method ----------
        //if (mElements == null) {
            //throw new RSIllegalArgumentException("Element contains no sub-elements");
        //}
        //if (index < 0 || index >= mElements.length) {
            //throw new RSIllegalArgumentException("Illegal sub-element index");
        //}
        //return mOffsetInBytes[index];
    }

    
        public static Element BOOLEAN(RenderScript rs) {
        if(rs.mElement_BOOLEAN == null) {
            rs.mElement_BOOLEAN = createUser(rs, DataType.BOOLEAN);
        }
        return rs.mElement_BOOLEAN;
    }

    
        public static Element U8(RenderScript rs) {
        if(rs.mElement_U8 == null) {
            rs.mElement_U8 = createUser(rs, DataType.UNSIGNED_8);
        }
        return rs.mElement_U8;
    }

    
        public static Element I8(RenderScript rs) {
        if(rs.mElement_I8 == null) {
            rs.mElement_I8 = createUser(rs, DataType.SIGNED_8);
        }
        return rs.mElement_I8;
    }

    
        public static Element U16(RenderScript rs) {
        if(rs.mElement_U16 == null) {
            rs.mElement_U16 = createUser(rs, DataType.UNSIGNED_16);
        }
        return rs.mElement_U16;
    }

    
        public static Element I16(RenderScript rs) {
        if(rs.mElement_I16 == null) {
            rs.mElement_I16 = createUser(rs, DataType.SIGNED_16);
        }
        return rs.mElement_I16;
    }

    
        public static Element U32(RenderScript rs) {
        if(rs.mElement_U32 == null) {
            rs.mElement_U32 = createUser(rs, DataType.UNSIGNED_32);
        }
        return rs.mElement_U32;
    }

    
        public static Element I32(RenderScript rs) {
        if(rs.mElement_I32 == null) {
            rs.mElement_I32 = createUser(rs, DataType.SIGNED_32);
        }
        return rs.mElement_I32;
    }

    
        public static Element U64(RenderScript rs) {
        if(rs.mElement_U64 == null) {
            rs.mElement_U64 = createUser(rs, DataType.UNSIGNED_64);
        }
        return rs.mElement_U64;
    }

    
        public static Element I64(RenderScript rs) {
        if(rs.mElement_I64 == null) {
            rs.mElement_I64 = createUser(rs, DataType.SIGNED_64);
        }
        return rs.mElement_I64;
    }

    
        public static Element F32(RenderScript rs) {
        if(rs.mElement_F32 == null) {
            rs.mElement_F32 = createUser(rs, DataType.FLOAT_32);
        }
        return rs.mElement_F32;
    }

    
        public static Element F64(RenderScript rs) {
        if(rs.mElement_F64 == null) {
            rs.mElement_F64 = createUser(rs, DataType.FLOAT_64);
        }
        return rs.mElement_F64;
    }

    
        @DSModeled(DSC.SAFE)
    public static Element ELEMENT(RenderScript rs) {
        if(rs.mElement_ELEMENT == null) {
            rs.mElement_ELEMENT = createUser(rs, DataType.RS_ELEMENT);
        }
        return rs.mElement_ELEMENT;
    }

    
        public static Element TYPE(RenderScript rs) {
        if(rs.mElement_TYPE == null) {
            rs.mElement_TYPE = createUser(rs, DataType.RS_TYPE);
        }
        return rs.mElement_TYPE;
    }

    
        @DSModeled(DSC.SAFE)
    public static Element ALLOCATION(RenderScript rs) {
        if(rs.mElement_ALLOCATION == null) {
            rs.mElement_ALLOCATION = createUser(rs, DataType.RS_ALLOCATION);
        }
        return rs.mElement_ALLOCATION;
    }

    
        public static Element SAMPLER(RenderScript rs) {
        if(rs.mElement_SAMPLER == null) {
            rs.mElement_SAMPLER = createUser(rs, DataType.RS_SAMPLER);
        }
        return rs.mElement_SAMPLER;
    }

    
        public static Element SCRIPT(RenderScript rs) {
        if(rs.mElement_SCRIPT == null) {
            rs.mElement_SCRIPT = createUser(rs, DataType.RS_SCRIPT);
        }
        return rs.mElement_SCRIPT;
    }

    
        public static Element MESH(RenderScript rs) {
        if(rs.mElement_MESH == null) {
            rs.mElement_MESH = createUser(rs, DataType.RS_MESH);
        }
        return rs.mElement_MESH;
    }

    
        public static Element PROGRAM_FRAGMENT(RenderScript rs) {
        if(rs.mElement_PROGRAM_FRAGMENT == null) {
            rs.mElement_PROGRAM_FRAGMENT = createUser(rs, DataType.RS_PROGRAM_FRAGMENT);
        }
        return rs.mElement_PROGRAM_FRAGMENT;
    }

    
        public static Element PROGRAM_VERTEX(RenderScript rs) {
        if(rs.mElement_PROGRAM_VERTEX == null) {
            rs.mElement_PROGRAM_VERTEX = createUser(rs, DataType.RS_PROGRAM_VERTEX);
        }
        return rs.mElement_PROGRAM_VERTEX;
    }

    
        public static Element PROGRAM_RASTER(RenderScript rs) {
        if(rs.mElement_PROGRAM_RASTER == null) {
            rs.mElement_PROGRAM_RASTER = createUser(rs, DataType.RS_PROGRAM_RASTER);
        }
        return rs.mElement_PROGRAM_RASTER;
    }

    
        public static Element PROGRAM_STORE(RenderScript rs) {
        if(rs.mElement_PROGRAM_STORE == null) {
            rs.mElement_PROGRAM_STORE = createUser(rs, DataType.RS_PROGRAM_STORE);
        }
        return rs.mElement_PROGRAM_STORE;
    }

    
        public static Element A_8(RenderScript rs) {
        if(rs.mElement_A_8 == null) {
            rs.mElement_A_8 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_A);
        }
        return rs.mElement_A_8;
    }

    
        public static Element RGB_565(RenderScript rs) {
        if(rs.mElement_RGB_565 == null) {
            rs.mElement_RGB_565 = createPixel(rs, DataType.UNSIGNED_5_6_5, DataKind.PIXEL_RGB);
        }
        return rs.mElement_RGB_565;
    }

    
        public static Element RGB_888(RenderScript rs) {
        if(rs.mElement_RGB_888 == null) {
            rs.mElement_RGB_888 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_RGB);
        }
        return rs.mElement_RGB_888;
    }

    
        public static Element RGBA_5551(RenderScript rs) {
        if(rs.mElement_RGBA_5551 == null) {
            rs.mElement_RGBA_5551 = createPixel(rs, DataType.UNSIGNED_5_5_5_1, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_5551;
    }

    
        public static Element RGBA_4444(RenderScript rs) {
        if(rs.mElement_RGBA_4444 == null) {
            rs.mElement_RGBA_4444 = createPixel(rs, DataType.UNSIGNED_4_4_4_4, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_4444;
    }

    
        public static Element RGBA_8888(RenderScript rs) {
        if(rs.mElement_RGBA_8888 == null) {
            rs.mElement_RGBA_8888 = createPixel(rs, DataType.UNSIGNED_8, DataKind.PIXEL_RGBA);
        }
        return rs.mElement_RGBA_8888;
    }

    
        public static Element F32_2(RenderScript rs) {
        if(rs.mElement_FLOAT_2 == null) {
            rs.mElement_FLOAT_2 = createVector(rs, DataType.FLOAT_32, 2);
        }
        return rs.mElement_FLOAT_2;
    }

    
        public static Element F32_3(RenderScript rs) {
        if(rs.mElement_FLOAT_3 == null) {
            rs.mElement_FLOAT_3 = createVector(rs, DataType.FLOAT_32, 3);
        }
        return rs.mElement_FLOAT_3;
    }

    
        public static Element F32_4(RenderScript rs) {
        if(rs.mElement_FLOAT_4 == null) {
            rs.mElement_FLOAT_4 = createVector(rs, DataType.FLOAT_32, 4);
        }
        return rs.mElement_FLOAT_4;
    }

    
        public static Element F64_2(RenderScript rs) {
        if(rs.mElement_DOUBLE_2 == null) {
            rs.mElement_DOUBLE_2 = createVector(rs, DataType.FLOAT_64, 2);
        }
        return rs.mElement_DOUBLE_2;
    }

    
        public static Element F64_3(RenderScript rs) {
        if(rs.mElement_DOUBLE_3 == null) {
            rs.mElement_DOUBLE_3 = createVector(rs, DataType.FLOAT_64, 3);
        }
        return rs.mElement_DOUBLE_3;
    }

    
        public static Element F64_4(RenderScript rs) {
        if(rs.mElement_DOUBLE_4 == null) {
            rs.mElement_DOUBLE_4 = createVector(rs, DataType.FLOAT_64, 4);
        }
        return rs.mElement_DOUBLE_4;
    }

    
        @DSModeled(DSC.SAFE)
    public static Element U8_2(RenderScript rs) {
        if(rs.mElement_UCHAR_2 == null) {
            rs.mElement_UCHAR_2 = createVector(rs, DataType.UNSIGNED_8, 2);
        }
        return rs.mElement_UCHAR_2;
    }

    
        public static Element U8_3(RenderScript rs) {
        if(rs.mElement_UCHAR_3 == null) {
            rs.mElement_UCHAR_3 = createVector(rs, DataType.UNSIGNED_8, 3);
        }
        return rs.mElement_UCHAR_3;
    }

    
        public static Element U8_4(RenderScript rs) {
        if(rs.mElement_UCHAR_4 == null) {
            rs.mElement_UCHAR_4 = createVector(rs, DataType.UNSIGNED_8, 4);
        }
        return rs.mElement_UCHAR_4;
    }

    
        @DSModeled(DSC.SAFE)
    public static Element I8_2(RenderScript rs) {
        if(rs.mElement_CHAR_2 == null) {
            rs.mElement_CHAR_2 = createVector(rs, DataType.SIGNED_8, 2);
        }
        return rs.mElement_CHAR_2;
    }

    
        public static Element I8_3(RenderScript rs) {
        if(rs.mElement_CHAR_3 == null) {
            rs.mElement_CHAR_3 = createVector(rs, DataType.SIGNED_8, 3);
        }
        return rs.mElement_CHAR_3;
    }

    
        public static Element I8_4(RenderScript rs) {
        if(rs.mElement_CHAR_4 == null) {
            rs.mElement_CHAR_4 = createVector(rs, DataType.SIGNED_8, 4);
        }
        return rs.mElement_CHAR_4;
    }

    
        public static Element U16_2(RenderScript rs) {
        if(rs.mElement_USHORT_2 == null) {
            rs.mElement_USHORT_2 = createVector(rs, DataType.UNSIGNED_16, 2);
        }
        return rs.mElement_USHORT_2;
    }

    
        public static Element U16_3(RenderScript rs) {
        if(rs.mElement_USHORT_3 == null) {
            rs.mElement_USHORT_3 = createVector(rs, DataType.UNSIGNED_16, 3);
        }
        return rs.mElement_USHORT_3;
    }

    
        public static Element U16_4(RenderScript rs) {
        if(rs.mElement_USHORT_4 == null) {
            rs.mElement_USHORT_4 = createVector(rs, DataType.UNSIGNED_16, 4);
        }
        return rs.mElement_USHORT_4;
    }

    
        public static Element I16_2(RenderScript rs) {
        if(rs.mElement_SHORT_2 == null) {
            rs.mElement_SHORT_2 = createVector(rs, DataType.SIGNED_16, 2);
        }
        return rs.mElement_SHORT_2;
    }

    
        public static Element I16_3(RenderScript rs) {
        if(rs.mElement_SHORT_3 == null) {
            rs.mElement_SHORT_3 = createVector(rs, DataType.SIGNED_16, 3);
        }
        return rs.mElement_SHORT_3;
    }

    
        public static Element I16_4(RenderScript rs) {
        if(rs.mElement_SHORT_4 == null) {
            rs.mElement_SHORT_4 = createVector(rs, DataType.SIGNED_16, 4);
        }
        return rs.mElement_SHORT_4;
    }

    
        public static Element U32_2(RenderScript rs) {
        if(rs.mElement_UINT_2 == null) {
            rs.mElement_UINT_2 = createVector(rs, DataType.UNSIGNED_32, 2);
        }
        return rs.mElement_UINT_2;
    }

    
        public static Element U32_3(RenderScript rs) {
        if(rs.mElement_UINT_3 == null) {
            rs.mElement_UINT_3 = createVector(rs, DataType.UNSIGNED_32, 3);
        }
        return rs.mElement_UINT_3;
    }

    
        public static Element U32_4(RenderScript rs) {
        if(rs.mElement_UINT_4 == null) {
            rs.mElement_UINT_4 = createVector(rs, DataType.UNSIGNED_32, 4);
        }
        return rs.mElement_UINT_4;
    }

    
        public static Element I32_2(RenderScript rs) {
        if(rs.mElement_INT_2 == null) {
            rs.mElement_INT_2 = createVector(rs, DataType.SIGNED_32, 2);
        }
        return rs.mElement_INT_2;
    }

    
        public static Element I32_3(RenderScript rs) {
        if(rs.mElement_INT_3 == null) {
            rs.mElement_INT_3 = createVector(rs, DataType.SIGNED_32, 3);
        }
        return rs.mElement_INT_3;
    }

    
        public static Element I32_4(RenderScript rs) {
        if(rs.mElement_INT_4 == null) {
            rs.mElement_INT_4 = createVector(rs, DataType.SIGNED_32, 4);
        }
        return rs.mElement_INT_4;
    }

    
        public static Element U64_2(RenderScript rs) {
        if(rs.mElement_ULONG_2 == null) {
            rs.mElement_ULONG_2 = createVector(rs, DataType.UNSIGNED_64, 2);
        }
        return rs.mElement_ULONG_2;
    }

    
        public static Element U64_3(RenderScript rs) {
        if(rs.mElement_ULONG_3 == null) {
            rs.mElement_ULONG_3 = createVector(rs, DataType.UNSIGNED_64, 3);
        }
        return rs.mElement_ULONG_3;
    }

    
        public static Element U64_4(RenderScript rs) {
        if(rs.mElement_ULONG_4 == null) {
            rs.mElement_ULONG_4 = createVector(rs, DataType.UNSIGNED_64, 4);
        }
        return rs.mElement_ULONG_4;
    }

    
        public static Element I64_2(RenderScript rs) {
        if(rs.mElement_LONG_2 == null) {
            rs.mElement_LONG_2 = createVector(rs, DataType.SIGNED_64, 2);
        }
        return rs.mElement_LONG_2;
    }

    
        public static Element I64_3(RenderScript rs) {
        if(rs.mElement_LONG_3 == null) {
            rs.mElement_LONG_3 = createVector(rs, DataType.SIGNED_64, 3);
        }
        return rs.mElement_LONG_3;
    }

    
        public static Element I64_4(RenderScript rs) {
        if(rs.mElement_LONG_4 == null) {
            rs.mElement_LONG_4 = createVector(rs, DataType.SIGNED_64, 4);
        }
        return rs.mElement_LONG_4;
    }

    
        public static Element MATRIX_4X4(RenderScript rs) {
        if(rs.mElement_MATRIX_4X4 == null) {
            rs.mElement_MATRIX_4X4 = createUser(rs, DataType.MATRIX_4X4);
        }
        return rs.mElement_MATRIX_4X4;
    }

    
        public static Element MATRIX4X4(RenderScript rs) {
        return MATRIX_4X4(rs);
    }

    
        public static Element MATRIX_3X3(RenderScript rs) {
        if(rs.mElement_MATRIX_3X3 == null) {
            rs.mElement_MATRIX_3X3 = createUser(rs, DataType.MATRIX_3X3);
        }
        return rs.mElement_MATRIX_3X3;
    }

    
        public static Element MATRIX_2X2(RenderScript rs) {
        if(rs.mElement_MATRIX_2X2 == null) {
            rs.mElement_MATRIX_2X2 = createUser(rs, DataType.MATRIX_2X2);
        }
        return rs.mElement_MATRIX_2X2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.500 -0400", hash_original_method = "8ECBC2337848BD749AC42873FE5AD6F5", hash_generated_method = "3A26DC27B56796C672735ABF399FDC65")
    @Override
     void updateFromNative() {
        super.updateFromNative();
        int[] dataBuffer = new int[5];
        mRS.nElementGetNativeData(getID(), dataBuffer);
        mNormalized = dataBuffer[2] == 1 ? true : false;
        mVectorSize = dataBuffer[3];
        mSize = 0;
for(DataType dt : DataType.values())
        {
            if(dt.mID == dataBuffer[0])            
            {
                mType = dt;
                mSize = mType.mSize * mVectorSize;
            } //End block
        } //End block
for(DataKind dk : DataKind.values())
        {
            if(dk.mID == dataBuffer[1])            
            {
                mKind = dk;
            } //End block
        } //End block
        int numSubElements = dataBuffer[4];
        if(numSubElements > 0)        
        {
            mElements = new Element[numSubElements];
            mElementNames = new String[numSubElements];
            mArraySizes = new int[numSubElements];
            mOffsetInBytes = new int[numSubElements];
            int[] subElementIds = new int[numSubElements];
            mRS.nElementGetSubElements(getID(), subElementIds, mElementNames, mArraySizes);
for(int i = 0;i < numSubElements;i ++)
            {
                mElements[i] = new Element(subElementIds[i], mRS);
                mElements[i].updateFromNative();
                mOffsetInBytes[i] = mSize;
                mSize += mElements[i].mSize * mArraySizes[i];
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
    static Element createUser(RenderScript rs, DataType dt) {
        DataKind dk = DataKind.USER;
        boolean norm = false;
        int vecSize = 1;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, vecSize);
        return new Element(id, rs, dt, dk, norm, vecSize);
    }

    
        @DSModeled(DSC.SAFE)
    public static Element createVector(RenderScript rs, DataType dt, int size) {
        if (size < 2 || size > 4) {
            throw new RSIllegalArgumentException("Vector size out of range 2-4.");
        }
        DataKind dk = DataKind.USER;
        boolean norm = false;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, size);
        return new Element(id, rs, dt, dk, norm, size);
    }

    
        public static Element createPixel(RenderScript rs, DataType dt, DataKind dk) {
        if (!(dk == DataKind.PIXEL_L ||
              dk == DataKind.PIXEL_A ||
              dk == DataKind.PIXEL_LA ||
              dk == DataKind.PIXEL_RGB ||
              dk == DataKind.PIXEL_RGBA ||
              dk == DataKind.PIXEL_DEPTH)) {
            throw new RSIllegalArgumentException("Unsupported DataKind");
        }
        if (!(dt == DataType.UNSIGNED_8 ||
              dt == DataType.UNSIGNED_16 ||
              dt == DataType.UNSIGNED_5_6_5 ||
              dt == DataType.UNSIGNED_4_4_4_4 ||
              dt == DataType.UNSIGNED_5_5_5_1)) {
            throw new RSIllegalArgumentException("Unsupported DataType");
        }
        if (dt == DataType.UNSIGNED_5_6_5 && dk != DataKind.PIXEL_RGB) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_5_5_5_1 && dk != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_4_4_4_4 && dk != DataKind.PIXEL_RGBA) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        if (dt == DataType.UNSIGNED_16 &&
            dk != DataKind.PIXEL_DEPTH) {
            throw new RSIllegalArgumentException("Bad kind and type combo");
        }
        int size = 1;
        switch (dk) {
        case PIXEL_LA:
            size = 2;
            break;
        case PIXEL_RGB:
            size = 3;
            break;
        case PIXEL_RGBA:
            size = 4;
            break;
        case PIXEL_DEPTH:
            size = 2;
            break;
        }
        boolean norm = true;
        int id = rs.nElementCreate(dt.mID, dk.mID, norm, size);
        return new Element(id, rs, dt, dk, norm, size);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.526 -0400", hash_original_method = "10DB51484387728F55F8C48219903602", hash_generated_method = "BC1AD983DE9F581843F62A938B43F1A3")
    public boolean isCompatible(Element e) {
        addTaint(e.getTaint());
        if(this.equals(e))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1699604304 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886963027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886963027;
        } //End block
        boolean var193B006526BB281B31DA6F8541C17297_1174701015 = (((mSize == e.mSize) &&
                (mType != null) &&
                (mType == e.mType) &&
                (mVectorSize == e.mVectorSize)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885739205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_885739205;
        // ---------- Original Method ----------
        //if (this.equals(e)) {
            //return true;
        //}
        //return ((mSize == e.mSize) &&
                //(mType != null) &&
                //(mType == e.mType) &&
                //(mVectorSize == e.mVectorSize));
    }

    
    public enum DataType {
        FLOAT_32 (2, 4),
        FLOAT_64 (3, 8),
        SIGNED_8 (4, 1),
        SIGNED_16 (5, 2),
        SIGNED_32 (6, 4),
        SIGNED_64 (7, 8),
        UNSIGNED_8 (8, 1),
        UNSIGNED_16 (9, 2),
        UNSIGNED_32 (10, 4),
        UNSIGNED_64 (11, 8),
        BOOLEAN(12, 1),
        UNSIGNED_5_6_5 (13, 2),
        UNSIGNED_5_5_5_1 (14, 2),
        UNSIGNED_4_4_4_4 (15, 2),
        MATRIX_4X4 (16, 64),
        MATRIX_3X3 (17, 36),
        MATRIX_2X2 (18, 16),
        RS_ELEMENT (1000, 4),
        RS_TYPE (1001, 4),
        RS_ALLOCATION (1002, 4),
        RS_SAMPLER (1003, 4),
        RS_SCRIPT (1004, 4),
        RS_MESH (1005, 4),
        RS_PROGRAM_FRAGMENT (1006, 4),
        RS_PROGRAM_VERTEX (1007, 4),
        RS_PROGRAM_RASTER (1008, 4),
        RS_PROGRAM_STORE (1009, 4);
        int mID;
        int mSize;
        DataType(int id, int size) {
            mID = id;
            mSize = size;
        }
    }

    
    public enum DataKind {
        USER (0),
        PIXEL_L (7),
        PIXEL_A (8),
        PIXEL_LA (9),
        PIXEL_RGB (10),
        PIXEL_RGBA (11),
        PIXEL_DEPTH (12);
        int mID;
        DataKind(int id) {
            mID = id;
        }
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.532 -0400", hash_original_field = "15EADDEB24354180E81F0ADC804C4CED", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.534 -0400", hash_original_field = "5F08D8DE811A201CF2BECC1D66F00FCC", hash_generated_field = "B4AACD1A33198C98C0C0D6BB21148E0E")

        Element[] mElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.535 -0400", hash_original_field = "F458E8DD1F3D4CB057ABB781BF97671A", hash_generated_field = "D62B64EBC8BFD8DAE5E1EC6F5A939D2E")

        String[] mElementNames;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.537 -0400", hash_original_field = "8CEBB4967C4FB046DD13A018630D8C5D", hash_generated_field = "CCF5C576DC1912807FD250325C1CD519")

        int[] mArraySizes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.538 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "228E80965D19F3262507FB2E30484C98")

        int mCount;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.546 -0400", hash_original_method = "728E8165442E638E6B663EFB1CAFAD98", hash_generated_method = "B53B1552DDFD01DAA6F10BE491EA7758")
        public  Builder(RenderScript rs) {
            mRS = rs;
            mCount = 0;
            mElements = new Element[8];
            mElementNames = new String[8];
            mArraySizes = new int[8];
            // ---------- Original Method ----------
            //mRS = rs;
            //mCount = 0;
            //mElements = new Element[8];
            //mElementNames = new String[8];
            //mArraySizes = new int[8];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.563 -0400", hash_original_method = "06213E432958F959DC8D842BD0BC1A12", hash_generated_method = "0727868D045243682D2C41D9CCDFBB4F")
        public Builder add(Element element, String name, int arraySize) {
            if(arraySize < 1)            
            {
                RSIllegalArgumentException var1684E38169F9F98A14E01440362A55B9_1178095233 = new RSIllegalArgumentException("Array size cannot be less than 1.");
                var1684E38169F9F98A14E01440362A55B9_1178095233.addTaint(taint);
                throw var1684E38169F9F98A14E01440362A55B9_1178095233;
            } //End block
            if(mCount == mElements.length)            
            {
                Element[] e = new Element[mCount + 8];
                String[] s = new String[mCount + 8];
                int[] as = new int[mCount + 8];
                System.arraycopy(mElements, 0, e, 0, mCount);
                System.arraycopy(mElementNames, 0, s, 0, mCount);
                System.arraycopy(mArraySizes, 0, as, 0, mCount);
                mElements = e;
                mElementNames = s;
                mArraySizes = as;
            } //End block
            mElements[mCount] = element;
            mElementNames[mCount] = name;
            mArraySizes[mCount] = arraySize;
            mCount++;
Builder var72A74007B2BE62B849F475C7BDA4658B_1536801776 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1536801776.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1536801776;
            // ---------- Original Method ----------
            //if (arraySize < 1) {
                //throw new RSIllegalArgumentException("Array size cannot be less than 1.");
            //}
            //if(mCount == mElements.length) {
                //Element[] e = new Element[mCount + 8];
                //String[] s = new String[mCount + 8];
                //int[] as = new int[mCount + 8];
                //System.arraycopy(mElements, 0, e, 0, mCount);
                //System.arraycopy(mElementNames, 0, s, 0, mCount);
                //System.arraycopy(mArraySizes, 0, as, 0, mCount);
                //mElements = e;
                //mElementNames = s;
                //mArraySizes = as;
            //}
            //mElements[mCount] = element;
            //mElementNames[mCount] = name;
            //mArraySizes[mCount] = arraySize;
            //mCount++;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.570 -0400", hash_original_method = "166A4AF2B4A563746350FD29F5208B27", hash_generated_method = "9DC1775C251D855613968F1F335C6666")
        public Builder add(Element element, String name) {
            addTaint(name.getTaint());
            addTaint(element.getTaint());
Builder var85D5A606F7A81D3A1DC23E062E8E81F3_1106238698 =             add(element, name, 1);
            var85D5A606F7A81D3A1DC23E062E8E81F3_1106238698.addTaint(taint);
            return var85D5A606F7A81D3A1DC23E062E8E81F3_1106238698;
            // ---------- Original Method ----------
            //return add(element, name, 1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:20.574 -0400", hash_original_method = "75B70D9FB26EF7CE7043E09D494022A0", hash_generated_method = "9C603EDDF654B8B290E6D1FB9EC2BAA8")
        public Element create() {
            mRS.validate();
            Element[] ein = new Element[mCount];
            String[] sin = new String[mCount];
            int[] asin = new int[mCount];
            java.lang.System.arraycopy(mElements, 0, ein, 0, mCount);
            java.lang.System.arraycopy(mElementNames, 0, sin, 0, mCount);
            java.lang.System.arraycopy(mArraySizes, 0, asin, 0, mCount);
            int[] ids = new int[ein.length];
for(int ct = 0;ct < ein.length;ct++)
            {
                ids[ct] = ein[ct].getID();
            } //End block
            int id = mRS.nElementCreate2(ids, sin, asin);
Element var65523B510FB847C555DA9134C7D9E2D1_1111998410 =             new Element(id, mRS, ein, sin, asin);
            var65523B510FB847C555DA9134C7D9E2D1_1111998410.addTaint(taint);
            return var65523B510FB847C555DA9134C7D9E2D1_1111998410;
            // ---------- Original Method ----------
            //mRS.validate();
            //Element[] ein = new Element[mCount];
            //String[] sin = new String[mCount];
            //int[] asin = new int[mCount];
            //java.lang.System.arraycopy(mElements, 0, ein, 0, mCount);
            //java.lang.System.arraycopy(mElementNames, 0, sin, 0, mCount);
            //java.lang.System.arraycopy(mArraySizes, 0, asin, 0, mCount);
            //int[] ids = new int[ein.length];
            //for (int ct = 0; ct < ein.length; ct++ ) {
                //ids[ct] = ein[ct].getID();
            //}
            //int id = mRS.nElementCreate2(ids, sin, asin);
            //return new Element(id, mRS, ein, sin, asin);
        }

        
    }


    
}

