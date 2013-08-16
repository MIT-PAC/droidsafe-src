package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.content.res.AssetManager;
import android.util.Log;
import android.util.TypedValue;
import android.graphics.BitmapFactory;
import java.io.IOException;
import android.content.res.Resources;
public class Allocation extends BaseObj {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.634 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "CD9EE990878373ED9EA7539218CF9C59")

    Type mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.639 -0400", hash_original_field = "C4C105852193F50EEB9E84F09C746611", hash_generated_field = "46C0A7FFF0FFB93D952536F8E8BA5C29")

    Bitmap mBitmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.641 -0400", hash_original_field = "F2AAE19CC0AF4955036751775E00CA80", hash_generated_field = "455102E0D248DC24482D3093AA618A87")

    int mUsage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.643 -0400", hash_original_field = "590FC58004000E4620FB5D049229B727", hash_generated_field = "1EA0A10472B7C7B59A503123DD3AD568")

    Allocation mAdaptedAllocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.644 -0400", hash_original_field = "D414AFE54DCD557120A21C0DC90D9161", hash_generated_field = "1FF9B76BD894BB7012F7F3B358570205")

    boolean mConstrainedLOD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.651 -0400", hash_original_field = "3011910DEF6129D25B758B25F3EC6C2D", hash_generated_field = "348B2424577ECDC38E311FD999D29B92")

    boolean mConstrainedFace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.653 -0400", hash_original_field = "9EE70619739297B57C79A61C921C5142", hash_generated_field = "1CFCA3B29736345A883DCD8FFC987773")

    boolean mConstrainedY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.656 -0400", hash_original_field = "45468E9893EBFF1A802F36E810879237", hash_generated_field = "1678C7D3401C13859A995AFD4D4275F8")

    boolean mConstrainedZ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.658 -0400", hash_original_field = "F43FC42132C76664F95992EAC2F4C4F5", hash_generated_field = "30125E7FDD5750F30165219EF82021D8")

    int mSelectedY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.659 -0400", hash_original_field = "A1032BCF85FB2EFBC1A2EA24DCA1C78B", hash_generated_field = "BAE70EA9F4208C3B720719728E7BDDA3")

    int mSelectedZ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.660 -0400", hash_original_field = "2B1EA2F3F08D15F68FD23FB063FCB9E7", hash_generated_field = "DC59A891AEDB641EB500D06CE65ABB3D")

    int mSelectedLOD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.662 -0400", hash_original_field = "18C740294DA43AD47FD28E8F961F1CE1", hash_generated_field = "865E817C479D396BB5B31B01D35B7C2F")

    Type.CubemapFace mSelectedFace = Type.CubemapFace.POSITIVE_X;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.666 -0400", hash_original_field = "F9EB6BEA20F4B740123D42C64EC26B21", hash_generated_field = "C9FB47D56F7EDB1EE840BDC3AE79BB40")

    int mCurrentDimX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.667 -0400", hash_original_field = "072A22EEE2DFDC59909EFC46B5CB8E86", hash_generated_field = "A99E76F576811A9EDE6769AE3935BB39")

    int mCurrentDimY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.668 -0400", hash_original_field = "04E9FA2FFFA06A6480E2AB5A4EF6132F", hash_generated_field = "A7728265B3DADFFCB9152F4DE3CA6055")

    int mCurrentDimZ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.670 -0400", hash_original_field = "0D758DE1DCAF78AA652D9D5876132DB2", hash_generated_field = "6186AFFF0523CEF3E143CFF8B9F270A6")

    int mCurrentCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.692 -0400", hash_original_method = "665FE224B2EB4C9CAB6FB0250F8FC614", hash_generated_method = "53682B93F90282B971D57B215DE43838")
      Allocation(int id, RenderScript rs, Type t, int usage) {
        super(id, rs);
        addTaint(usage);
        addTaint(rs.getTaint());
        addTaint(id);
        if((usage & ~(USAGE_SCRIPT |
                       USAGE_GRAPHICS_TEXTURE |
                       USAGE_GRAPHICS_VERTEX |
                       USAGE_GRAPHICS_CONSTANTS |
                       USAGE_GRAPHICS_RENDER_TARGET)) != 0)        
        {
            RSIllegalArgumentException var6A841658D71305363942E52D64240E8B_685842845 = new RSIllegalArgumentException("Unknown usage specified.");
            var6A841658D71305363942E52D64240E8B_685842845.addTaint(taint);
            throw var6A841658D71305363942E52D64240E8B_685842845;
        } //End block
        mType = t;
        if(t != null)        
        {
            updateCacheInfo(t);
        } //End block
        // ---------- Original Method ----------
        //if ((usage & ~(USAGE_SCRIPT |
                       //USAGE_GRAPHICS_TEXTURE |
                       //USAGE_GRAPHICS_VERTEX |
                       //USAGE_GRAPHICS_CONSTANTS |
                       //USAGE_GRAPHICS_RENDER_TARGET)) != 0) {
            //throw new RSIllegalArgumentException("Unknown usage specified.");
        //}
        //mType = t;
        //if (t != null) {
            //updateCacheInfo(t);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.701 -0400", hash_original_method = "311D2B5BD14C46D52A18F5FB7D46A7CD", hash_generated_method = "1024BFAB78D99A8147D261236AF8469F")
    private int getIDSafe() {
        if(mAdaptedAllocation != null)        
        {
            int var5F22332DCCD06CFC1386F29714B82394_1693607346 = (mAdaptedAllocation.getID());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235962141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235962141;
        } //End block
        int varC628F1F1FB7F4D10C2D9ED56B8DD0FCF_1726783993 = (getID());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668182783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668182783;
        // ---------- Original Method ----------
        //if (mAdaptedAllocation != null) {
            //return mAdaptedAllocation.getID();
        //}
        //return getID();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.723 -0400", hash_original_method = "88EDB22B03764ACCBD1FBAF2EA2911C8", hash_generated_method = "7863CC3F71A0F93164267F42D93DEA05")
    private void updateCacheInfo(Type t) {
        mCurrentDimX = t.getX();
        mCurrentDimY = t.getY();
        mCurrentDimZ = t.getZ();
        mCurrentCount = mCurrentDimX;
        if(mCurrentDimY > 1)        
        {
            mCurrentCount *= mCurrentDimY;
        } //End block
        if(mCurrentDimZ > 1)        
        {
            mCurrentCount *= mCurrentDimZ;
        } //End block
        // ---------- Original Method ----------
        //mCurrentDimX = t.getX();
        //mCurrentDimY = t.getY();
        //mCurrentDimZ = t.getZ();
        //mCurrentCount = mCurrentDimX;
        //if (mCurrentDimY > 1) {
            //mCurrentCount *= mCurrentDimY;
        //}
        //if (mCurrentDimZ > 1) {
            //mCurrentCount *= mCurrentDimZ;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.733 -0400", hash_original_method = "65C711257F94F3105DCE4FED6B46495C", hash_generated_method = "52A09DCAE0270638B7B20A6858CF192F")
    private void validateIsInt32() {
        if((mType.mElement.mType == Element.DataType.SIGNED_32) ||
            (mType.mElement.mType == Element.DataType.UNSIGNED_32))        
        {
            return;
        } //End block
        RSIllegalArgumentException varAC8AA905C05506CA480E7B04476DD96E_1907877207 = new RSIllegalArgumentException(
            "32 bit integer source does not match allocation type " + mType.mElement.mType);
        varAC8AA905C05506CA480E7B04476DD96E_1907877207.addTaint(taint);
        throw varAC8AA905C05506CA480E7B04476DD96E_1907877207;
        // ---------- Original Method ----------
        //if ((mType.mElement.mType == Element.DataType.SIGNED_32) ||
            //(mType.mElement.mType == Element.DataType.UNSIGNED_32)) {
            //return;
        //}
        //throw new RSIllegalArgumentException(
            //"32 bit integer source does not match allocation type " + mType.mElement.mType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.745 -0400", hash_original_method = "6E4F71EB18D2F00682465DF6305D48C6", hash_generated_method = "D553438AAC765CF3893921147FF11FC5")
    private void validateIsInt16() {
        if((mType.mElement.mType == Element.DataType.SIGNED_16) ||
            (mType.mElement.mType == Element.DataType.UNSIGNED_16))        
        {
            return;
        } //End block
        RSIllegalArgumentException var0DE5FE1A93C1341E31EC84A815F5BED2_15847980 = new RSIllegalArgumentException(
            "16 bit integer source does not match allocation type " + mType.mElement.mType);
        var0DE5FE1A93C1341E31EC84A815F5BED2_15847980.addTaint(taint);
        throw var0DE5FE1A93C1341E31EC84A815F5BED2_15847980;
        // ---------- Original Method ----------
        //if ((mType.mElement.mType == Element.DataType.SIGNED_16) ||
            //(mType.mElement.mType == Element.DataType.UNSIGNED_16)) {
            //return;
        //}
        //throw new RSIllegalArgumentException(
            //"16 bit integer source does not match allocation type " + mType.mElement.mType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.755 -0400", hash_original_method = "ED6CF93005996273EC0803DD9A6B2BBC", hash_generated_method = "B286F3C3D7D5E059D2F0BEB09B3C1177")
    private void validateIsInt8() {
        if((mType.mElement.mType == Element.DataType.SIGNED_8) ||
            (mType.mElement.mType == Element.DataType.UNSIGNED_8))        
        {
            return;
        } //End block
        RSIllegalArgumentException varA56FDE8912E95CF51CC90A2485CAADDF_622844626 = new RSIllegalArgumentException(
            "8 bit integer source does not match allocation type " + mType.mElement.mType);
        varA56FDE8912E95CF51CC90A2485CAADDF_622844626.addTaint(taint);
        throw varA56FDE8912E95CF51CC90A2485CAADDF_622844626;
        // ---------- Original Method ----------
        //if ((mType.mElement.mType == Element.DataType.SIGNED_8) ||
            //(mType.mElement.mType == Element.DataType.UNSIGNED_8)) {
            //return;
        //}
        //throw new RSIllegalArgumentException(
            //"8 bit integer source does not match allocation type " + mType.mElement.mType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.762 -0400", hash_original_method = "22DC03BEB0D64704815FAFAD8DD448C1", hash_generated_method = "A4BAA085162676C3B4E9BEC2910C1A7D")
    private void validateIsFloat32() {
        if(mType.mElement.mType == Element.DataType.FLOAT_32)        
        {
            return;
        } //End block
        RSIllegalArgumentException var7F861B1A91FA0AB720AD24B2D7044CD7_1710600497 = new RSIllegalArgumentException(
            "32 bit float source does not match allocation type " + mType.mElement.mType);
        var7F861B1A91FA0AB720AD24B2D7044CD7_1710600497.addTaint(taint);
        throw var7F861B1A91FA0AB720AD24B2D7044CD7_1710600497;
        // ---------- Original Method ----------
        //if (mType.mElement.mType == Element.DataType.FLOAT_32) {
            //return;
        //}
        //throw new RSIllegalArgumentException(
            //"32 bit float source does not match allocation type " + mType.mElement.mType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.783 -0400", hash_original_method = "0F7CA754806BFED6B25F7C22657938DC", hash_generated_method = "55D874907951C4BF05A73AB5DAF785DF")
    private void validateIsObject() {
        if((mType.mElement.mType == Element.DataType.RS_ELEMENT) ||
            (mType.mElement.mType == Element.DataType.RS_TYPE) ||
            (mType.mElement.mType == Element.DataType.RS_ALLOCATION) ||
            (mType.mElement.mType == Element.DataType.RS_SAMPLER) ||
            (mType.mElement.mType == Element.DataType.RS_SCRIPT) ||
            (mType.mElement.mType == Element.DataType.RS_MESH) ||
            (mType.mElement.mType == Element.DataType.RS_PROGRAM_FRAGMENT) ||
            (mType.mElement.mType == Element.DataType.RS_PROGRAM_VERTEX) ||
            (mType.mElement.mType == Element.DataType.RS_PROGRAM_RASTER) ||
            (mType.mElement.mType == Element.DataType.RS_PROGRAM_STORE))        
        {
            return;
        } //End block
        RSIllegalArgumentException var9E217E8379F8184F76954DCD7F9655FD_1085748309 = new RSIllegalArgumentException(
            "Object source does not match allocation type " + mType.mElement.mType);
        var9E217E8379F8184F76954DCD7F9655FD_1085748309.addTaint(taint);
        throw var9E217E8379F8184F76954DCD7F9655FD_1085748309;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.797 -0400", hash_original_method = "CEBA9EC127886AA7BBE4344B60C3C2EC", hash_generated_method = "1951C04A49414A4EBDC5581F991B8906")
    @Override
     void updateFromNative() {
        super.updateFromNative();
        int typeID = mRS.nAllocationGetType(getID());
        if(typeID != 0)        
        {
            mType = new Type(typeID, mRS);
            mType.updateFromNative();
            updateCacheInfo(mType);
        } //End block
        // ---------- Original Method ----------
        //super.updateFromNative();
        //int typeID = mRS.nAllocationGetType(getID());
        //if(typeID != 0) {
            //mType = new Type(typeID, mRS);
            //mType.updateFromNative();
            //updateCacheInfo(mType);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.802 -0400", hash_original_method = "9C32C8CB3047BF2C1A7EE0D985A901B5", hash_generated_method = "ED948FEAC694DBA627CE11FB4A29ABD4")
    public Type getType() {
Type var4BA7381699FCDF343F6526506FD5D65C_222779120 =         mType;
        var4BA7381699FCDF343F6526506FD5D65C_222779120.addTaint(taint);
        return var4BA7381699FCDF343F6526506FD5D65C_222779120;
        // ---------- Original Method ----------
        //return mType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.808 -0400", hash_original_method = "401E03E52E40FA71066750AE07682BA7", hash_generated_method = "9D43234A28C365E3C7257E96C517495C")
    public void syncAll(int srcLocation) {
        addTaint(srcLocation);
switch(srcLocation){
        case USAGE_SCRIPT:
        case USAGE_GRAPHICS_CONSTANTS:
        case USAGE_GRAPHICS_TEXTURE:
        case USAGE_GRAPHICS_VERTEX:
        break;
        default:
        RSIllegalArgumentException varDC5696AF7F0890ABD9B239BCE534A567_1071347183 = new RSIllegalArgumentException("Source must be exactly one usage type.");
        varDC5696AF7F0890ABD9B239BCE534A567_1071347183.addTaint(taint);
        throw varDC5696AF7F0890ABD9B239BCE534A567_1071347183;
}        mRS.validate();
        mRS.nAllocationSyncAll(getIDSafe(), srcLocation);
        // ---------- Original Method ----------
        //switch (srcLocation) {
        //case USAGE_SCRIPT:
        //case USAGE_GRAPHICS_CONSTANTS:
        //case USAGE_GRAPHICS_TEXTURE:
        //case USAGE_GRAPHICS_VERTEX:
            //break;
        //default:
            //throw new RSIllegalArgumentException("Source must be exactly one usage type.");
        //}
        //mRS.validate();
        //mRS.nAllocationSyncAll(getIDSafe(), srcLocation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.816 -0400", hash_original_method = "1C2809FD292D672B4F67F7D52DEE8BA3", hash_generated_method = "67F24BB6D78D1BE0BDBA5F75B4D2D5A2")
    public void copyFrom(BaseObj[] d) {
        addTaint(d[0].getTaint());
        mRS.validate();
        validateIsObject();
        if(d.length != mCurrentCount)        
        {
            RSIllegalArgumentException var3622FCE148057513B40CE4546BCD0223_1407625635 = new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " +
                                                 mCurrentCount + ", array length = " + d.length);
            var3622FCE148057513B40CE4546BCD0223_1407625635.addTaint(taint);
            throw var3622FCE148057513B40CE4546BCD0223_1407625635;
        } //End block
        int i[] = new int[d.length];
for(int ct=0;ct < d.length;ct++)
        {
            i[ct] = d[ct].getID();
        } //End block
        copy1DRangeFromUnchecked(0, mCurrentCount, i);
        // ---------- Original Method ----------
        //mRS.validate();
        //validateIsObject();
        //if (d.length != mCurrentCount) {
            //throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " +
                                                 //mCurrentCount + ", array length = " + d.length);
        //}
        //int i[] = new int[d.length];
        //for (int ct=0; ct < d.length; ct++) {
            //i[ct] = d[ct].getID();
        //}
        //copy1DRangeFromUnchecked(0, mCurrentCount, i);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.837 -0400", hash_original_method = "68F022BD518BF34A861F2C9F1854EE2C", hash_generated_method = "318B067578F9516C35C04D32C57C2184")
    private void validateBitmapFormat(Bitmap b) {
        addTaint(b.getTaint());
        Bitmap.Config bc = b.getConfig();
switch(bc){
        case ALPHA_8:
        if(mType.getElement().mKind != Element.DataKind.PIXEL_A)        
        {
            RSIllegalArgumentException varC16C09682051D99585076F05CCDA9933_407328397 = new RSIllegalArgumentException("Allocation kind is " +
                                                     mType.getElement().mKind + ", type " +
                                                     mType.getElement().mType +
                                                     " of " + mType.getElement().getSizeBytes() +
                                                     " bytes, passed bitmap was " + bc);
            varC16C09682051D99585076F05CCDA9933_407328397.addTaint(taint);
            throw varC16C09682051D99585076F05CCDA9933_407328397;
        } //End block
        break;
        case ARGB_8888:
        if((mType.getElement().mKind != Element.DataKind.PIXEL_RGBA) ||
                (mType.getElement().getSizeBytes() != 4))        
        {
            RSIllegalArgumentException varC16C09682051D99585076F05CCDA9933_20526314 = new RSIllegalArgumentException("Allocation kind is " +
                                                     mType.getElement().mKind + ", type " +
                                                     mType.getElement().mType +
                                                     " of " + mType.getElement().getSizeBytes() +
                                                     " bytes, passed bitmap was " + bc);
            varC16C09682051D99585076F05CCDA9933_20526314.addTaint(taint);
            throw varC16C09682051D99585076F05CCDA9933_20526314;
        } //End block
        break;
        case RGB_565:
        if((mType.getElement().mKind != Element.DataKind.PIXEL_RGB) ||
                (mType.getElement().getSizeBytes() != 2))        
        {
            RSIllegalArgumentException varC16C09682051D99585076F05CCDA9933_1435712899 = new RSIllegalArgumentException("Allocation kind is " +
                                                     mType.getElement().mKind + ", type " +
                                                     mType.getElement().mType +
                                                     " of " + mType.getElement().getSizeBytes() +
                                                     " bytes, passed bitmap was " + bc);
            varC16C09682051D99585076F05CCDA9933_1435712899.addTaint(taint);
            throw varC16C09682051D99585076F05CCDA9933_1435712899;
        } //End block
        break;
        case ARGB_4444:
        if((mType.getElement().mKind != Element.DataKind.PIXEL_RGBA) ||
                (mType.getElement().getSizeBytes() != 2))        
        {
            RSIllegalArgumentException varC16C09682051D99585076F05CCDA9933_629537064 = new RSIllegalArgumentException("Allocation kind is " +
                                                     mType.getElement().mKind + ", type " +
                                                     mType.getElement().mType +
                                                     " of " + mType.getElement().getSizeBytes() +
                                                     " bytes, passed bitmap was " + bc);
            varC16C09682051D99585076F05CCDA9933_629537064.addTaint(taint);
            throw varC16C09682051D99585076F05CCDA9933_629537064;
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.850 -0400", hash_original_method = "EA8D3B5F0BE6DABF77176C0C9533D70D", hash_generated_method = "AB062425B71D3291ABA944B726F51778")
    private void validateBitmapSize(Bitmap b) {
        addTaint(b.getTaint());
        if((mCurrentDimX != b.getWidth()) || (mCurrentDimY != b.getHeight()))        
        {
            RSIllegalArgumentException var4C95D3DA8F562C9F4E3F394527340694_142820471 = new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
            var4C95D3DA8F562C9F4E3F394527340694_142820471.addTaint(taint);
            throw var4C95D3DA8F562C9F4E3F394527340694_142820471;
        } //End block
        // ---------- Original Method ----------
        //if((mCurrentDimX != b.getWidth()) || (mCurrentDimY != b.getHeight())) {
            //throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.855 -0400", hash_original_method = "407334247B0770162522DC9F49AB59F1", hash_generated_method = "F7275EDD48F1504B73F65F54C2D09DB2")
    public void copyFromUnchecked(int[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFromUnchecked(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.863 -0400", hash_original_method = "54011F5D28450E17A088B23862CB14CB", hash_generated_method = "9F624BA7DB560285154E759363F628D1")
    public void copyFromUnchecked(short[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFromUnchecked(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.867 -0400", hash_original_method = "C30FE6183FA56AAB4D4D014829EBBFDC", hash_generated_method = "D66B5F0533580AA467DC97F80FF655E1")
    public void copyFromUnchecked(byte[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFromUnchecked(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.872 -0400", hash_original_method = "8F953C76C1FB41C208B15E25F4581FF5", hash_generated_method = "8F88BEE20C101A0ED4B19CFA55708EAB")
    public void copyFromUnchecked(float[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFromUnchecked(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFromUnchecked(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.878 -0400", hash_original_method = "82E8721F348356C043C685C43214068C", hash_generated_method = "3EF89F52F34987833E2B5F77ACD2DAC8")
    public void copyFrom(int[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFrom(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.883 -0400", hash_original_method = "E045B23C5646055DFC50B85B83A4F6FC", hash_generated_method = "D5E5FFD6B8F5F7F46482DD3BBDECB45C")
    public void copyFrom(short[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFrom(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.890 -0400", hash_original_method = "F54BC10B0D60AEAE0067D3AFD674BB35", hash_generated_method = "321A021ECB8E78A103DEAD0EB7B062F0")
    public void copyFrom(byte[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFrom(0, mCurrentCount, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.899 -0400", hash_original_method = "0C41419913B85ADFA42D345CEAE65A53", hash_generated_method = "95217CA840AA931C942DAA5F8F31B654")
    public void copyFrom(float[] d) {
        addTaint(d[0]);
        mRS.validate();
        copy1DRangeFrom(0, mCurrentCount, d);
        // ---------- Original Method ----------
        //mRS.validate();
        //copy1DRangeFrom(0, mCurrentCount, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.906 -0400", hash_original_method = "512A5161660D68AB5470903C03DA343E", hash_generated_method = "29271C29202BE55335E821DE3ACCE66D")
    public void copyFrom(Bitmap b) {
        addTaint(b.getTaint());
        mRS.validate();
        validateBitmapSize(b);
        validateBitmapFormat(b);
        mRS.nAllocationCopyFromBitmap(getID(), b);
        // ---------- Original Method ----------
        //mRS.validate();
        //validateBitmapSize(b);
        //validateBitmapFormat(b);
        //mRS.nAllocationCopyFromBitmap(getID(), b);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.912 -0400", hash_original_method = "E70E78EB3719016B4E6FB42A9EB5810C", hash_generated_method = "239BB1AFB7763D6AC6D89DF1B857C4EC")
    public void setFromFieldPacker(int xoff, FieldPacker fp) {
        addTaint(fp.getTaint());
        addTaint(xoff);
        int eSize = mType.mElement.getSizeBytes();
        final byte[] data = fp.getData();
        int count = data.length / eSize;
        if((eSize * count) != data.length)        
        {
            RSIllegalArgumentException varC71C55BB936D805D685C7D92348B956D_1917074628 = new RSIllegalArgumentException("Field packer length " + data.length +
                                               " not divisible by element size " + eSize + ".");
            varC71C55BB936D805D685C7D92348B956D_1917074628.addTaint(taint);
            throw varC71C55BB936D805D685C7D92348B956D_1917074628;
        } //End block
        copy1DRangeFromUnchecked(xoff, count, data);
        // ---------- Original Method ----------
        //int eSize = mType.mElement.getSizeBytes();
        //final byte[] data = fp.getData();
        //int count = data.length / eSize;
        //if ((eSize * count) != data.length) {
            //throw new RSIllegalArgumentException("Field packer length " + data.length +
                                               //" not divisible by element size " + eSize + ".");
        //}
        //copy1DRangeFromUnchecked(xoff, count, data);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.925 -0400", hash_original_method = "507EA1A1B860EC041E68F02818C67D1F", hash_generated_method = "D82D2E67C6C66569E702B2F1B0A96AF5")
    public void setFromFieldPacker(int xoff, int component_number, FieldPacker fp) {
        addTaint(fp.getTaint());
        addTaint(component_number);
        addTaint(xoff);
        if(component_number >= mType.mElement.mElements.length)        
        {
            RSIllegalArgumentException var482973939BA7AF49EFFA28094D7B9F87_896325087 = new RSIllegalArgumentException("Component_number " + component_number + " out of range.");
            var482973939BA7AF49EFFA28094D7B9F87_896325087.addTaint(taint);
            throw var482973939BA7AF49EFFA28094D7B9F87_896325087;
        } //End block
        if(xoff < 0)        
        {
            RSIllegalArgumentException var17C2E8DF576A7E12CBFF0D1C2CD826A6_1432910286 = new RSIllegalArgumentException("Offset must be >= 0.");
            var17C2E8DF576A7E12CBFF0D1C2CD826A6_1432910286.addTaint(taint);
            throw var17C2E8DF576A7E12CBFF0D1C2CD826A6_1432910286;
        } //End block
        final byte[] data = fp.getData();
        int eSize = mType.mElement.mElements[component_number].getSizeBytes();
        if(data.length != eSize)        
        {
            RSIllegalArgumentException varF6F70C3014DBA99BF1110B5A85F7BA87_772531336 = new RSIllegalArgumentException("Field packer sizelength " + data.length +
                                               " does not match component size " + eSize + ".");
            varF6F70C3014DBA99BF1110B5A85F7BA87_772531336.addTaint(taint);
            throw varF6F70C3014DBA99BF1110B5A85F7BA87_772531336;
        } //End block
        mRS.nAllocationElementData1D(getIDSafe(), xoff, mSelectedLOD,
                                     component_number, data, data.length);
        // ---------- Original Method ----------
        //if (component_number >= mType.mElement.mElements.length) {
            //throw new RSIllegalArgumentException("Component_number " + component_number + " out of range.");
        //}
        //if(xoff < 0) {
            //throw new RSIllegalArgumentException("Offset must be >= 0.");
        //}
        //final byte[] data = fp.getData();
        //int eSize = mType.mElement.mElements[component_number].getSizeBytes();
        //if (data.length != eSize) {
            //throw new RSIllegalArgumentException("Field packer sizelength " + data.length +
                                               //" does not match component size " + eSize + ".");
        //}
        //mRS.nAllocationElementData1D(getIDSafe(), xoff, mSelectedLOD,
                                     //component_number, data, data.length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.936 -0400", hash_original_method = "C280AAD194909DEEA802F55F051EEFEF", hash_generated_method = "4A8ECBAB02592F7336664962A7A38B1D")
    private void data1DChecks(int off, int count, int len, int dataSize) {
        addTaint(dataSize);
        addTaint(len);
        addTaint(count);
        addTaint(off);
        mRS.validate();
        if(off < 0)        
        {
            RSIllegalArgumentException var17C2E8DF576A7E12CBFF0D1C2CD826A6_2058817417 = new RSIllegalArgumentException("Offset must be >= 0.");
            var17C2E8DF576A7E12CBFF0D1C2CD826A6_2058817417.addTaint(taint);
            throw var17C2E8DF576A7E12CBFF0D1C2CD826A6_2058817417;
        } //End block
        if(count < 1)        
        {
            RSIllegalArgumentException var2FC0DDB8670D5DFC1ED808281416361F_553503699 = new RSIllegalArgumentException("Count must be >= 1.");
            var2FC0DDB8670D5DFC1ED808281416361F_553503699.addTaint(taint);
            throw var2FC0DDB8670D5DFC1ED808281416361F_553503699;
        } //End block
        if((off + count) > mCurrentCount)        
        {
            RSIllegalArgumentException var8D1C9CA9A0AD3A7C00061A9204D74904_1026700217 = new RSIllegalArgumentException("Overflow, Available count " + mCurrentCount +
                                               ", got " + count + " at offset " + off + ".");
            var8D1C9CA9A0AD3A7C00061A9204D74904_1026700217.addTaint(taint);
            throw var8D1C9CA9A0AD3A7C00061A9204D74904_1026700217;
        } //End block
        if(len < dataSize)        
        {
            RSIllegalArgumentException var86C27261BF760EFFB652E9E75A1451EC_1651242940 = new RSIllegalArgumentException("Array too small for allocation type.");
            var86C27261BF760EFFB652E9E75A1451EC_1651242940.addTaint(taint);
            throw var86C27261BF760EFFB652E9E75A1451EC_1651242940;
        } //End block
        // ---------- Original Method ----------
        //mRS.validate();
        //if(off < 0) {
            //throw new RSIllegalArgumentException("Offset must be >= 0.");
        //}
        //if(count < 1) {
            //throw new RSIllegalArgumentException("Count must be >= 1.");
        //}
        //if((off + count) > mCurrentCount) {
            //throw new RSIllegalArgumentException("Overflow, Available count " + mCurrentCount +
                                               //", got " + count + " at offset " + off + ".");
        //}
        //if(len < dataSize) {
            //throw new RSIllegalArgumentException("Array too small for allocation type.");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.945 -0400", hash_original_method = "6F3414BDFDCAE5A0099FF42DC9162024", hash_generated_method = "EC3EDFD04FC1B1E37CB6D075055FD736")
    public void generateMipmaps() {
        mRS.nAllocationGenerateMipmaps(getID());
        // ---------- Original Method ----------
        //mRS.nAllocationGenerateMipmaps(getID());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.953 -0400", hash_original_method = "9BD1F31EAB786A33FC8D6DD03AC7DD13", hash_generated_method = "C6A811C67E40A3FB1FC830F181D4240D")
    public void copy1DRangeFromUnchecked(int off, int count, int[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        int dataSize = mType.mElement.getSizeBytes() * count;
        data1DChecks(off, count, d.length * 4, dataSize);
        mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
        // ---------- Original Method ----------
        //int dataSize = mType.mElement.getSizeBytes() * count;
        //data1DChecks(off, count, d.length * 4, dataSize);
        //mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.960 -0400", hash_original_method = "76B5FD8D10654A26BCBBF314A697FBF8", hash_generated_method = "A4B1EB17FA05BA4250B111F933C958E6")
    public void copy1DRangeFromUnchecked(int off, int count, short[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        int dataSize = mType.mElement.getSizeBytes() * count;
        data1DChecks(off, count, d.length * 2, dataSize);
        mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
        // ---------- Original Method ----------
        //int dataSize = mType.mElement.getSizeBytes() * count;
        //data1DChecks(off, count, d.length * 2, dataSize);
        //mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.966 -0400", hash_original_method = "C68391FBBAF4E4C2759F231D9BB3CE56", hash_generated_method = "5DAA22E737B6C02EE4141ADFF1C54E8A")
    public void copy1DRangeFromUnchecked(int off, int count, byte[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        int dataSize = mType.mElement.getSizeBytes() * count;
        data1DChecks(off, count, d.length, dataSize);
        mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
        // ---------- Original Method ----------
        //int dataSize = mType.mElement.getSizeBytes() * count;
        //data1DChecks(off, count, d.length, dataSize);
        //mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.971 -0400", hash_original_method = "0F7A0E2393C34E90AEC2D039DA3C1483", hash_generated_method = "0BB34BEA43C6D61147625BAAAF7E150B")
    public void copy1DRangeFromUnchecked(int off, int count, float[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        int dataSize = mType.mElement.getSizeBytes() * count;
        data1DChecks(off, count, d.length * 4, dataSize);
        mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
        // ---------- Original Method ----------
        //int dataSize = mType.mElement.getSizeBytes() * count;
        //data1DChecks(off, count, d.length * 4, dataSize);
        //mRS.nAllocationData1D(getIDSafe(), off, mSelectedLOD, count, d, dataSize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.977 -0400", hash_original_method = "D55849C3A95A52797F56CE21D0AC9A77", hash_generated_method = "6A5A04307EB278B8A3C67F606EB102AF")
    public void copy1DRangeFrom(int off, int count, int[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        validateIsInt32();
        copy1DRangeFromUnchecked(off, count, d);
        // ---------- Original Method ----------
        //validateIsInt32();
        //copy1DRangeFromUnchecked(off, count, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.984 -0400", hash_original_method = "1EAA6FDE909AE941C837793DE6358EFA", hash_generated_method = "9B978EB9C27825FC7CB29CE4A6BE970F")
    public void copy1DRangeFrom(int off, int count, short[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        validateIsInt16();
        copy1DRangeFromUnchecked(off, count, d);
        // ---------- Original Method ----------
        //validateIsInt16();
        //copy1DRangeFromUnchecked(off, count, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.989 -0400", hash_original_method = "3469D95A9F285D7729B7F7DF2EEF92C2", hash_generated_method = "A5F9453CBC38B4C571882745F0F21C86")
    public void copy1DRangeFrom(int off, int count, byte[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        validateIsInt8();
        copy1DRangeFromUnchecked(off, count, d);
        // ---------- Original Method ----------
        //validateIsInt8();
        //copy1DRangeFromUnchecked(off, count, d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.994 -0400", hash_original_method = "E6965F1E2FB321FAD1F4EA1126484F16", hash_generated_method = "8F8C6712C4559623E489A9354BC79ED8")
    public void copy1DRangeFrom(int off, int count, float[] d) {
        addTaint(d[0]);
        addTaint(count);
        addTaint(off);
        validateIsFloat32();
        copy1DRangeFromUnchecked(off, count, d);
        // ---------- Original Method ----------
        //validateIsFloat32();
        //copy1DRangeFromUnchecked(off, count, d);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:04.999 -0400", hash_original_method = "A7A26BCBBE62D435D0EFB88761B8B839", hash_generated_method = "3681DD6ED86D4C29A0664EB2D4B63A0C")
    public void copy1DRangeFrom(int off, int count, Allocation data, int dataOff) {
        addTaint(dataOff);
        addTaint(data.getTaint());
        addTaint(count);
        addTaint(off);
        mRS.nAllocationData2D(getIDSafe(), off, 0,
                              mSelectedLOD, mSelectedFace.mID,
                              count, 1, data.getID(), dataOff, 0,
                              data.mSelectedLOD, data.mSelectedFace.mID);
        // ---------- Original Method ----------
        //mRS.nAllocationData2D(getIDSafe(), off, 0,
                              //mSelectedLOD, mSelectedFace.mID,
                              //count, 1, data.getID(), dataOff, 0,
                              //data.mSelectedLOD, data.mSelectedFace.mID);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.007 -0400", hash_original_method = "549AEF19696CDA0CE15593CF21BCB97B", hash_generated_method = "09D14C980213800C8C31DB3566BA46FC")
    private void validate2DRange(int xoff, int yoff, int w, int h) {
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        if(mAdaptedAllocation != null)        
        {
        } //End block
        else
        {
            if(xoff < 0 || yoff < 0)            
            {
                RSIllegalArgumentException varE9C863E0C69F4F5E564948BE0CC23DD0_1380257716 = new RSIllegalArgumentException("Offset cannot be negative.");
                varE9C863E0C69F4F5E564948BE0CC23DD0_1380257716.addTaint(taint);
                throw varE9C863E0C69F4F5E564948BE0CC23DD0_1380257716;
            } //End block
            if(h < 0 || w < 0)            
            {
                RSIllegalArgumentException var8C77F5C05A2502932DEDB41A72F6704E_721209590 = new RSIllegalArgumentException("Height or width cannot be negative.");
                var8C77F5C05A2502932DEDB41A72F6704E_721209590.addTaint(taint);
                throw var8C77F5C05A2502932DEDB41A72F6704E_721209590;
            } //End block
            if(((xoff + w) > mCurrentDimX) || ((yoff + h) > mCurrentDimY))            
            {
                RSIllegalArgumentException varF39E4CE9D4E0FF48CD5C0978AA4DC130_1228949764 = new RSIllegalArgumentException("Updated region larger than allocation.");
                varF39E4CE9D4E0FF48CD5C0978AA4DC130_1228949764.addTaint(taint);
                throw varF39E4CE9D4E0FF48CD5C0978AA4DC130_1228949764;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAdaptedAllocation != null) {
        //} else {
            //if (xoff < 0 || yoff < 0) {
                //throw new RSIllegalArgumentException("Offset cannot be negative.");
            //}
            //if (h < 0 || w < 0) {
                //throw new RSIllegalArgumentException("Height or width cannot be negative.");
            //}
            //if (((xoff + w) > mCurrentDimX) || ((yoff + h) > mCurrentDimY)) {
                //throw new RSIllegalArgumentException("Updated region larger than allocation.");
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.020 -0400", hash_original_method = "B5CF3549C87A0C7A6D468F5569934765", hash_generated_method = "77932622724119EC0D85881CB638DD0A")
    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, byte[] data) {
        addTaint(data[0]);
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              w, h, data, data.length);
        // ---------- Original Method ----------
        //mRS.validate();
        //validate2DRange(xoff, yoff, w, h);
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              //w, h, data, data.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.025 -0400", hash_original_method = "1E0366E42882BACDF313C59C4D74B054", hash_generated_method = "BFA47A51E20F798EC66823D278468176")
    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, short[] data) {
        addTaint(data[0]);
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              w, h, data, data.length * 2);
        // ---------- Original Method ----------
        //mRS.validate();
        //validate2DRange(xoff, yoff, w, h);
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              //w, h, data, data.length * 2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.031 -0400", hash_original_method = "121F440BD580F4A6EA04D352E792872F", hash_generated_method = "70C7F7172E2660B05D175591A0F67A5E")
    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, int[] data) {
        addTaint(data[0]);
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              w, h, data, data.length * 4);
        // ---------- Original Method ----------
        //mRS.validate();
        //validate2DRange(xoff, yoff, w, h);
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              //w, h, data, data.length * 4);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.039 -0400", hash_original_method = "6CE72D2F101545C9487F397B5DC7D5E4", hash_generated_method = "088F6A93BA764D475D6046C28017893E")
    public void copy2DRangeFrom(int xoff, int yoff, int w, int h, float[] data) {
        addTaint(data[0]);
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              w, h, data, data.length * 4);
        // ---------- Original Method ----------
        //mRS.validate();
        //validate2DRange(xoff, yoff, w, h);
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID,
                              //w, h, data, data.length * 4);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.046 -0400", hash_original_method = "2D47F9E4EEBA0DDD1F9AB9C826991FF7", hash_generated_method = "206DA1A62661683395F8FF4F76B916FF")
    public void copy2DRangeFrom(int xoff, int yoff, int w, int h,
                                Allocation data, int dataXoff, int dataYoff) {
        addTaint(dataYoff);
        addTaint(dataXoff);
        addTaint(data.getTaint());
        addTaint(h);
        addTaint(w);
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validate2DRange(xoff, yoff, w, h);
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff,
                              mSelectedLOD, mSelectedFace.mID,
                              w, h, data.getID(), dataXoff, dataYoff,
                              data.mSelectedLOD, data.mSelectedFace.mID);
        // ---------- Original Method ----------
        //mRS.validate();
        //validate2DRange(xoff, yoff, w, h);
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff,
                              //mSelectedLOD, mSelectedFace.mID,
                              //w, h, data.getID(), dataXoff, dataYoff,
                              //data.mSelectedLOD, data.mSelectedFace.mID);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.054 -0400", hash_original_method = "E9C60CA998422120B69758A8DCF01F28", hash_generated_method = "0750DE9E9C1CA4671F9D7A33159CE7C8")
    public void copy2DRangeFrom(int xoff, int yoff, Bitmap data) {
        addTaint(data.getTaint());
        addTaint(yoff);
        addTaint(xoff);
        mRS.validate();
        validateBitmapFormat(data);
        validate2DRange(xoff, yoff, data.getWidth(), data.getHeight());
        mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID, data);
        // ---------- Original Method ----------
        //mRS.validate();
        //validateBitmapFormat(data);
        //validate2DRange(xoff, yoff, data.getWidth(), data.getHeight());
        //mRS.nAllocationData2D(getIDSafe(), xoff, yoff, mSelectedLOD, mSelectedFace.mID, data);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.058 -0400", hash_original_method = "5E3CAA2F54821F9B5D4C289C7A8559A4", hash_generated_method = "7533EEA4AC4DB7AAFDEAA8193959EDDB")
    public void copyTo(Bitmap b) {
        addTaint(b.getTaint());
        mRS.validate();
        validateBitmapFormat(b);
        validateBitmapSize(b);
        mRS.nAllocationCopyToBitmap(getID(), b);
        // ---------- Original Method ----------
        //mRS.validate();
        //validateBitmapFormat(b);
        //validateBitmapSize(b);
        //mRS.nAllocationCopyToBitmap(getID(), b);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.062 -0400", hash_original_method = "25DC8075DF7374531478BAA131CB7343", hash_generated_method = "D96C85B621AC34B82BE7615ED29524B1")
    public void copyTo(byte[] d) {
        addTaint(d[0]);
        validateIsInt8();
        mRS.validate();
        mRS.nAllocationRead(getID(), d);
        // ---------- Original Method ----------
        //validateIsInt8();
        //mRS.validate();
        //mRS.nAllocationRead(getID(), d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.066 -0400", hash_original_method = "9D52040F814FD0C684C6F66DC8E8CB93", hash_generated_method = "50FA690F2A7BD81F34AB8C7B2931C6B7")
    public void copyTo(short[] d) {
        addTaint(d[0]);
        validateIsInt16();
        mRS.validate();
        mRS.nAllocationRead(getID(), d);
        // ---------- Original Method ----------
        //validateIsInt16();
        //mRS.validate();
        //mRS.nAllocationRead(getID(), d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.072 -0400", hash_original_method = "379200F1BB84BA87FFEA29C22000A4D9", hash_generated_method = "2EA225A5BDD77F033D02757875FA0562")
    public void copyTo(int[] d) {
        addTaint(d[0]);
        validateIsInt32();
        mRS.validate();
        mRS.nAllocationRead(getID(), d);
        // ---------- Original Method ----------
        //validateIsInt32();
        //mRS.validate();
        //mRS.nAllocationRead(getID(), d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.077 -0400", hash_original_method = "5FBBCE58245F93A1688AB0878EC30A26", hash_generated_method = "0DE01F6D3942F8ED73480B081B5E9D8C")
    public void copyTo(float[] d) {
        addTaint(d[0]);
        validateIsFloat32();
        mRS.validate();
        mRS.nAllocationRead(getID(), d);
        // ---------- Original Method ----------
        //validateIsFloat32();
        //mRS.validate();
        //mRS.nAllocationRead(getID(), d);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.085 -0400", hash_original_method = "4D8212FF39765998C2ACC0C3F633686C", hash_generated_method = "32FF374DEC582212A7CD21D1202E81F3")
    public synchronized void resize(int dimX) {
        addTaint(dimX);
        if((mType.getY() > 0)|| (mType.getZ() > 0) || mType.hasFaces() || mType.hasMipmaps())        
        {
            RSInvalidStateException varBD02D34E6E5394BA13C8963500077F2F_1412500575 = new RSInvalidStateException("Resize only support for 1D allocations at this time.");
            varBD02D34E6E5394BA13C8963500077F2F_1412500575.addTaint(taint);
            throw varBD02D34E6E5394BA13C8963500077F2F_1412500575;
        } //End block
        mRS.nAllocationResize1D(getID(), dimX);
        mRS.finish();
        int typeID = mRS.nAllocationGetType(getID());
        mType = new Type(typeID, mRS);
        mType.updateFromNative();
        updateCacheInfo(mType);
        // ---------- Original Method ----------
        //if ((mType.getY() > 0)|| (mType.getZ() > 0) || mType.hasFaces() || mType.hasMipmaps()) {
            //throw new RSInvalidStateException("Resize only support for 1D allocations at this time.");
        //}
        //mRS.nAllocationResize1D(getID(), dimX);
        //mRS.finish();
        //int typeID = mRS.nAllocationGetType(getID());
        //mType = new Type(typeID, mRS);
        //mType.updateFromNative();
        //updateCacheInfo(mType);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createTyped(RenderScript rs, Type type, MipmapControl mips, int usage) {
        rs.validate();
        if (type.getID() == 0) {
            throw new RSInvalidStateException("Bad Type");
        }
        int id = rs.nAllocationCreateTyped(type.getID(), mips.mID, usage);
        if (id == 0) {
            throw new RSRuntimeException("Allocation creation failed.");
        }
        return new Allocation(id, rs, type, usage);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createTyped(RenderScript rs, Type type, int usage) {
        return createTyped(rs, type, MipmapControl.MIPMAP_NONE, usage);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createTyped(RenderScript rs, Type type) {
        return createTyped(rs, type, MipmapControl.MIPMAP_NONE, USAGE_SCRIPT);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createSized(RenderScript rs, Element e,
                                         int count, int usage) {
        rs.validate();
        Type.Builder b = new Type.Builder(rs, e);
        b.setX(count);
        Type t = b.create();
        int id = rs.nAllocationCreateTyped(t.getID(), MipmapControl.MIPMAP_NONE.mID, usage);
        if (id == 0) {
            throw new RSRuntimeException("Allocation creation failed.");
        }
        return new Allocation(id, rs, t, usage);
    }

    
        static public Allocation createSized(RenderScript rs, Element e, int count) {
        return createSized(rs, e, count, USAGE_SCRIPT);
    }

    
        static Element elementFromBitmap(RenderScript rs, Bitmap b) {
        final Bitmap.Config bc = b.getConfig();
        if (bc == Bitmap.Config.ALPHA_8) {
            return Element.A_8(rs);
        }
        if (bc == Bitmap.Config.ARGB_4444) {
            return Element.RGBA_4444(rs);
        }
        if (bc == Bitmap.Config.ARGB_8888) {
            return Element.RGBA_8888(rs);
        }
        if (bc == Bitmap.Config.RGB_565) {
            return Element.RGB_565(rs);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + bc);
    }

    
        static Type typeFromBitmap(RenderScript rs, Bitmap b,
                                       MipmapControl mip) {
        Element e = elementFromBitmap(rs, b);
        Type.Builder tb = new Type.Builder(rs, e);
        tb.setX(b.getWidth());
        tb.setY(b.getHeight());
        tb.setMipmaps(mip == MipmapControl.MIPMAP_FULL);
        return tb.create();
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createFromBitmap(RenderScript rs, Bitmap b,
                                              MipmapControl mips,
                                              int usage) {
        rs.validate();
        Type t = typeFromBitmap(rs, b, mips);
        int id = rs.nAllocationCreateFromBitmap(t.getID(), mips.mID, b, usage);
        if (id == 0) {
            throw new RSRuntimeException("Load failed.");
        }
        return new Allocation(id, rs, t, usage);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createFromBitmap(RenderScript rs, Bitmap b) {
        return createFromBitmap(rs, b, MipmapControl.MIPMAP_NONE,
                                USAGE_GRAPHICS_TEXTURE);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createCubemapFromBitmap(RenderScript rs, Bitmap b,
                                                     MipmapControl mips,
                                                     int usage) {
        rs.validate();
        int height = b.getHeight();
        int width = b.getWidth();
        if (width % 6 != 0) {
            throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
        }
        if (width / 6 != height) {
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        }
        boolean isPow2 = (height & (height - 1)) == 0;
        if (!isPow2) {
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        }
        Element e = elementFromBitmap(rs, b);
        Type.Builder tb = new Type.Builder(rs, e);
        tb.setX(height);
        tb.setY(height);
        tb.setFaces(true);
        tb.setMipmaps(mips == MipmapControl.MIPMAP_FULL);
        Type t = tb.create();
        int id = rs.nAllocationCubeCreateFromBitmap(t.getID(), mips.mID, b, usage);
        if(id == 0) {
            throw new RSRuntimeException("Load failed for bitmap " + b + " element " + e);
        }
        return new Allocation(id, rs, t, usage);
    }

    
        static public Allocation createCubemapFromBitmap(RenderScript rs,
                                                     Bitmap b) {
        return createCubemapFromBitmap(rs, b, MipmapControl.MIPMAP_NONE,
                                       USAGE_GRAPHICS_TEXTURE);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createCubemapFromCubeFaces(RenderScript rs,
                                                        Bitmap xpos,
                                                        Bitmap xneg,
                                                        Bitmap ypos,
                                                        Bitmap yneg,
                                                        Bitmap zpos,
                                                        Bitmap zneg,
                                                        MipmapControl mips,
                                                        int usage) {
        int height = xpos.getHeight();
        if (xpos.getWidth() != height ||
            xneg.getWidth() != height || xneg.getHeight() != height ||
            ypos.getWidth() != height || ypos.getHeight() != height ||
            yneg.getWidth() != height || yneg.getHeight() != height ||
            zpos.getWidth() != height || zpos.getHeight() != height ||
            zneg.getWidth() != height || zneg.getHeight() != height) {
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        }
        boolean isPow2 = (height & (height - 1)) == 0;
        if (!isPow2) {
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        }
        Element e = elementFromBitmap(rs, xpos);
        Type.Builder tb = new Type.Builder(rs, e);
        tb.setX(height);
        tb.setY(height);
        tb.setFaces(true);
        tb.setMipmaps(mips == MipmapControl.MIPMAP_FULL);
        Type t = tb.create();
        Allocation cubemap = Allocation.createTyped(rs, t, mips, usage);
        AllocationAdapter adapter = AllocationAdapter.create2D(rs, cubemap);
        adapter.setFace(Type.CubemapFace.POSITIVE_X);
        adapter.copyFrom(xpos);
        adapter.setFace(Type.CubemapFace.NEGATIVE_X);
        adapter.copyFrom(xneg);
        adapter.setFace(Type.CubemapFace.POSITIVE_Y);
        adapter.copyFrom(ypos);
        adapter.setFace(Type.CubemapFace.NEGATIVE_Y);
        adapter.copyFrom(yneg);
        adapter.setFace(Type.CubemapFace.POSITIVE_Z);
        adapter.copyFrom(zpos);
        adapter.setFace(Type.CubemapFace.NEGATIVE_Z);
        adapter.copyFrom(zneg);
        return cubemap;
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createCubemapFromCubeFaces(RenderScript rs,
                                                        Bitmap xpos,
                                                        Bitmap xneg,
                                                        Bitmap ypos,
                                                        Bitmap yneg,
                                                        Bitmap zpos,
                                                        Bitmap zneg) {
        return createCubemapFromCubeFaces(rs, xpos, xneg, ypos, yneg,
                                          zpos, zneg, MipmapControl.MIPMAP_NONE,
                                          USAGE_GRAPHICS_TEXTURE);
    }

    
        static public Allocation createFromBitmapResource(RenderScript rs,
                                                      Resources res,
                                                      int id,
                                                      MipmapControl mips,
                                                      int usage) {
        rs.validate();
        Bitmap b = BitmapFactory.decodeResource(res, id);
        Allocation alloc = createFromBitmap(rs, b, mips, usage);
        b.recycle();
        return alloc;
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createFromBitmapResource(RenderScript rs,
                                                      Resources res,
                                                      int id) {
        return createFromBitmapResource(rs, res, id,
                                        MipmapControl.MIPMAP_NONE,
                                        USAGE_GRAPHICS_TEXTURE);
    }

    
        @DSModeled(DSC.SAFE)
    static public Allocation createFromString(RenderScript rs,
                                              String str,
                                              int usage) {
        rs.validate();
        byte[] allocArray = null;
        try {
            allocArray = str.getBytes("UTF-8");
            Allocation alloc = Allocation.createSized(rs, Element.U8(rs), allocArray.length, usage);
            alloc.copyFrom(allocArray);
            return alloc;
        }
        catch (Exception e) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    
    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);
        int mID;
        @DSModeled(DSC.BAN)
        MipmapControl(int id) {
            mID = id;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.139 -0400", hash_original_field = "153DA292BFD8540CA3941A6308A1181A", hash_generated_field = "06CA9F64F5678EC367DCB8981FA5E914")

    public static final int USAGE_SCRIPT = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.141 -0400", hash_original_field = "932000F8C3588F66653C25804909DF44", hash_generated_field = "E1921C905C89D7B37889A81697E5C083")

    public static final int USAGE_GRAPHICS_TEXTURE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.145 -0400", hash_original_field = "C61A3F753DF5FE3CE7F80856E03CE3BF", hash_generated_field = "D78461A3746C21BD98EEE3B38299D6F2")

    public static final int USAGE_GRAPHICS_VERTEX = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.146 -0400", hash_original_field = "614653583DDDA75720D17F94383284C6", hash_generated_field = "39B183AD834C81DFE77B349B49963B4E")

    public static final int USAGE_GRAPHICS_CONSTANTS = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.148 -0400", hash_original_field = "7FB8E55F84D1D22DCE336402D5962F91", hash_generated_field = "A075DE6001096AED922B70169526411A")

    public static final int USAGE_GRAPHICS_RENDER_TARGET = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:05.149 -0400", hash_original_field = "70871790FAD11A97D529301C56FAB07C", hash_generated_field = "18989F68841E3941ED976F286530D512")

    static BitmapFactory.Options mBitmapOptions = new BitmapFactory.Options();
    static {
        mBitmapOptions.inScaled = false;
    }
    
}

