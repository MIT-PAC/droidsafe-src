package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.lang.reflect.Field;
public class Type extends BaseObj {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.018 -0500", hash_original_field = "166EAD939F5B09E30CBCA868F3EBACAE", hash_generated_field = "166EAD939F5B09E30CBCA868F3EBACAE")

    int mDimX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.020 -0500", hash_original_field = "52E465806612DCEB5EFA0AB2B3ADAE76", hash_generated_field = "52E465806612DCEB5EFA0AB2B3ADAE76")

    int mDimY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.022 -0500", hash_original_field = "CECA88AF13F74CDB4E12BE33048A317C", hash_generated_field = "CECA88AF13F74CDB4E12BE33048A317C")

    int mDimZ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.024 -0500", hash_original_field = "25321B8A368E9568ECB8D39F78480AB5", hash_generated_field = "25321B8A368E9568ECB8D39F78480AB5")

    boolean mDimMipmaps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.027 -0500", hash_original_field = "DFD2959534422FCC872B818F7E0B6875", hash_generated_field = "DFD2959534422FCC872B818F7E0B6875")

    boolean mDimFaces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.028 -0500", hash_original_field = "E724C728128A53C10A09F06C64DDD490", hash_generated_field = "E724C728128A53C10A09F06C64DDD490")

    int mElementCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.030 -0500", hash_original_field = "EC8CEE28EE8EC6C488BEE33A3E23406D", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

    Element mElement;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.057 -0500", hash_original_method = "16C6269A6A80062F3C7B05511AF2EA14", hash_generated_method = "16C6269A6A80062F3C7B05511AF2EA14")
    
Type(int id, RenderScript rs) {
        super(id, rs);
    }

    /**
     * Return the element associated with this Type.
     *
     * @return Element
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.039 -0500", hash_original_method = "4A983E462672C2EA1E6C39A6A01B91CB", hash_generated_method = "D36EAF357291305E00905E7D38FC8987")
    
public Element getElement() {
        return mElement;
    }

    /**
     * Return the value of the X dimension.
     *
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.041 -0500", hash_original_method = "B8C0887F5E9E541E727ECCD0086F5E5B", hash_generated_method = "C3E376CA9068FEA6A69EEB85328B8C4E")
    
public int getX() {
        return mDimX;
    }

    /**
     * Return the value of the Y dimension or 0 for a 1D allocation.
     *
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.044 -0500", hash_original_method = "5E9C3BBA0D7932B9CBA182F8B32036BC", hash_generated_method = "F0577C464B17A02017BA91EF44D925A3")
    
public int getY() {
        return mDimY;
    }

    /**
     * Return the value of the Z dimension or 0 for a 1D or 2D allocation.
     *
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.046 -0500", hash_original_method = "E315B95FC6DF6C1A4510539F8CFF9FC2", hash_generated_method = "61ABC746DD74FAB75CAB1606DF4A5A23")
    
public int getZ() {
        return mDimZ;
    }

    /**
     * Return if the Type has a mipmap chain.
     *
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.048 -0500", hash_original_method = "4B051F35B9C270411E541578F7D74139", hash_generated_method = "CAA61CEDD6773BF38F3304301B6F4716")
    
public boolean hasMipmaps() {
        return mDimMipmaps;
    }

    /**
     * Return if the Type is a cube map.
     *
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.050 -0500", hash_original_method = "A298ED811BA5BE2EDFB864807B88B98E", hash_generated_method = "CCF6C2B2D75122A7B8B8B267C87CE322")
    
public boolean hasFaces() {
        return mDimFaces;
    }

    /**
     * Return the total number of accessable cells in the Type.
     *
     * @return int
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.052 -0500", hash_original_method = "48334469C8B133AB7598FD3FC5B4F37B", hash_generated_method = "07B3E2B76BEDBA594AEC525B81BB271B")
    
public int getCount() {
        return mElementCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.055 -0500", hash_original_method = "2C27E4A52BBF3CC9203234C207690BDD", hash_generated_method = "2C27E4A52BBF3CC9203234C207690BDD")
    
void calcElementCount() {
        boolean hasLod = hasMipmaps();
        int x = getX();
        int y = getY();
        int z = getZ();
        int faces = 1;
        if (hasFaces()) {
            faces = 6;
        }
        if (x == 0) {
            x = 1;
        }
        if (y == 0) {
            y = 1;
        }
        if (z == 0) {
            z = 1;
        }

        int count = x * y * z * faces;

        while (hasLod && ((x > 1) || (y > 1) || (z > 1))) {
            if(x > 1) {
                x >>= 1;
            }
            if(y > 1) {
                y >>= 1;
            }
            if(z > 1) {
                z >>= 1;
            }

            count += x * y * z * faces;
        }
        mElementCount = count;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.060 -0500", hash_original_method = "D9C91D8B790AFADAD6800FA858F1EFFA", hash_generated_method = "24B69C690FA1AA47BA6F18E4A983AE74")
    
@Override
    void updateFromNative() {
        // We have 6 integer to obtain mDimX; mDimY; mDimZ;
        // mDimLOD; mDimFaces; mElement;
        int[] dataBuffer = new int[6];
        mRS.nTypeGetNativeData(getID(), dataBuffer);

        mDimX = dataBuffer[0];
        mDimY = dataBuffer[1];
        mDimZ = dataBuffer[2];
        mDimMipmaps = dataBuffer[3] == 1 ? true : false;
        mDimFaces = dataBuffer[4] == 1 ? true : false;

        int elementID = dataBuffer[5];
        if(elementID != 0) {
            mElement = new Element(elementID, mRS);
            mElement.updateFromNative();
        }
        calcElementCount();
    }
    
    public enum CubemapFace {
        POSITIVE_X (0),
        NEGATIVE_X (1),
        POSITIVE_Y (2),
        NEGATIVE_Y (3),
        POSITIVE_Z (4),
        NEGATIVE_Z (5),
        @Deprecated
        POSITVE_X (0),
        @Deprecated
        POSITVE_Y (2),
        @Deprecated
        POSITVE_Z (4);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.033 -0500", hash_original_field = "0B53E374282B34FB268F3024A1E73BA5", hash_generated_field = "0B53E374282B34FB268F3024A1E73BA5")

        int mID;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.035 -0500", hash_original_method = "7F0480675545CC5C5FE59A3A30729560", hash_generated_method = "7F0480675545CC5C5FE59A3A30729560")
            
CubemapFace(int id) {
            mID = id;
        }
    }
    
    public static class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.063 -0500", hash_original_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C", hash_generated_field = "AD6E2452AD39DF3B497ED4B7E83C4E0C")

        RenderScript mRS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.065 -0500", hash_original_field = "19CD781E8EBBB291E01238A36BA4EFE0", hash_generated_field = "19CD781E8EBBB291E01238A36BA4EFE0")

        int mDimX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.067 -0500", hash_original_field = "52E465806612DCEB5EFA0AB2B3ADAE76", hash_generated_field = "52E465806612DCEB5EFA0AB2B3ADAE76")

        int mDimY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.069 -0500", hash_original_field = "CECA88AF13F74CDB4E12BE33048A317C", hash_generated_field = "CECA88AF13F74CDB4E12BE33048A317C")

        int mDimZ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.072 -0500", hash_original_field = "25321B8A368E9568ECB8D39F78480AB5", hash_generated_field = "25321B8A368E9568ECB8D39F78480AB5")

        boolean mDimMipmaps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.074 -0500", hash_original_field = "DFD2959534422FCC872B818F7E0B6875", hash_generated_field = "DFD2959534422FCC872B818F7E0B6875")

        boolean mDimFaces;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.076 -0500", hash_original_field = "EC8CEE28EE8EC6C488BEE33A3E23406D", hash_generated_field = "EC8CEE28EE8EC6C488BEE33A3E23406D")

        Element mElement;

        /**
         * Create a new builder object.
         *
         * @param rs
         * @param e The element for the type to be created.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.078 -0500", hash_original_method = "7F91DC25C3C3CDE10A09CD9C14BFD4B5", hash_generated_method = "A69BA93BB45D8DD9CC8C1228B4D15887")
        
public Builder(RenderScript rs, Element e) {
            e.checkValid();
            mRS = rs;
            mElement = e;
        }

        /**
         * Add a dimension to the Type.
         *
         *
         * @param value
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.080 -0500", hash_original_method = "49C74CAE6836798531411A61C63C5943", hash_generated_method = "7A1E15900F801E6272BB39F7A1A7BF36")
        
public Builder setX(int value) {
            if(value < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension X are not valid.");
            }
            mDimX = value;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.083 -0500", hash_original_method = "DFB03FCEFD1326FB2171A041DB523085", hash_generated_method = "3AD63D81C725F1F4DE1D4824205DB86A")
        
public Builder setY(int value) {
            if(value < 1) {
                throw new RSIllegalArgumentException("Values of less than 1 for Dimension Y are not valid.");
            }
            mDimY = value;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.085 -0500", hash_original_method = "6FF2F97061E56A03E659E1B7B4FEDFAC", hash_generated_method = "8347A30040E5AD98F09C2ACC01143311")
        
public Builder setMipmaps(boolean value) {
            mDimMipmaps = value;
            return this;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.088 -0500", hash_original_method = "A3F9FA926CF212B551274C553F57A403", hash_generated_method = "7E79D368FFD6012497169A4412D60FE0")
        
public Builder setFaces(boolean value) {
            mDimFaces = value;
            return this;
        }

        /**
         * Validate structure and create a new type.
         *
         * @return Type
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:07.091 -0500", hash_original_method = "FE3D5B55E53BDF1600935D20E2D4BB17", hash_generated_method = "C63988662C52768F3AC4AD1066D1DB21")
        
public Type create() {
            if (mDimZ > 0) {
                if ((mDimX < 1) || (mDimY < 1)) {
                    throw new RSInvalidStateException("Both X and Y dimension required when Z is present.");
                }
                if (mDimFaces) {
                    throw new RSInvalidStateException("Cube maps not supported with 3D types.");
                }
            }
            if (mDimY > 0) {
                if (mDimX < 1) {
                    throw new RSInvalidStateException("X dimension required when Y is present.");
                }
            }
            if (mDimFaces) {
                if (mDimY < 1) {
                    throw new RSInvalidStateException("Cube maps require 2D Types.");
                }
            }

            int id = mRS.nTypeCreate(mElement.getID(), mDimX, mDimY, mDimZ, mDimMipmaps, mDimFaces);
            Type t = new Type(id, mRS);
            t.mElement = mElement;
            t.mDimX = mDimX;
            t.mDimY = mDimY;
            t.mDimZ = mDimZ;
            t.mDimMipmaps = mDimMipmaps;
            t.mDimFaces = mDimFaces;

            t.calcElementCount();
            return t;
        }
        
    }
    
}

