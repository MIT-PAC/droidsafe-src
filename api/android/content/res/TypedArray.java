package android.content.res;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

public class TypedArray {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.140 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private  Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.142 -0500", hash_original_field = "5B0AA5083BE633511718F93F8CB95A91", hash_generated_field = "5B0AA5083BE633511718F93F8CB95A91")
 XmlBlock.Parser mXml;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.144 -0500", hash_original_field = "A4F8D1E493616053569BD2AC1F0ABB08", hash_generated_field = "A4F8D1E493616053569BD2AC1F0ABB08")
 int[] mRsrcs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.146 -0500", hash_original_field = "8C2374D33A80477A0B3E51CE7EB85544", hash_generated_field = "8C2374D33A80477A0B3E51CE7EB85544")
 int[] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.148 -0500", hash_original_field = "2BB4F4BFBD9E11898040581D9D99B4FA", hash_generated_field = "2BB4F4BFBD9E11898040581D9D99B4FA")
 int[] mIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.150 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "FC3D477E7B6A4ACE9A379E6E41129BD1")
 int mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.152 -0500", hash_original_field = "654366000D5436FE48B31EFBD0B3756D", hash_generated_field = "654366000D5436FE48B31EFBD0B3756D")
 TypedValue mValue = new TypedValue();
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    TypedArray(Resources resources, int[] data, int[] indices, int len){
		mResources = resources;  //Preserved
		mData = data;  //Preserved
		mIndices = indices;  //Preserved
		addTaint(len);
		/*
		mResources = resources;
		mData = data;
		mIndices = indices;
		mLength = len;
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public int length(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLength;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getIndexCount(){
		// Original method
		/*
		{
        return mIndices[0];
    }
		*/
		return getTaintInt();
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getIndex(int at){
		// Original method
		/*
		{
        return mIndices[1+at];
    }
		*/
		return getTaintInt();
	}
    
    /**
     * Return the Resources object this array was loaded from.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.160 -0500", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "05B1D2D3E0E7E913183B96A460337403")
    
public Resources getResources() {
        return mResources;
    }
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence getText(int index){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return null;
        } else if (type == TypedValue.TYPE_STRING) {
            return loadStringValueAt(index);
        }
        TypedValue v = mValue;
        if (getValueAt(index, v)) {
            Log.w(Resources.TAG, "Converting to string: " + v);
            return v.coerceToString();
        }
        Log.w(Resources.TAG, "getString of bad type: 0x"
              + Integer.toHexString(type));
        return null;
    }
		*/
	}
    
	@DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getString(int index){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return null;
        } else if (type == TypedValue.TYPE_STRING) {
            return loadStringValueAt(index).toString();
        }
        TypedValue v = mValue;
        if (getValueAt(index, v)) {
            Log.w(Resources.TAG, "Converting to string: " + v);
            CharSequence cs = v.coerceToString();
            return cs != null ? cs.toString() : null;
        }
        Log.w(Resources.TAG, "getString of bad type: 0x"
              + Integer.toHexString(type));
        return null;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getNonResourceString(int index){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_STRING) {
            final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
            if (cookie < 0) {
                return mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]).toString();
            }
        }
        return null;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getNonConfigurationString(int index, int allowedChangingConfigs){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean getBoolean(int index, boolean defValue){
		return getTaintBoolean();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT) {
            return data[index+AssetManager.STYLE_DATA] != 0;
        }
        TypedValue v = mValue;
        if (getValueAt(index, v)) {
            Log.w(Resources.TAG, "Converting to boolean: " + v);
            return XmlUtils.convertValueToBoolean(
                v.coerceToString(), defValue);
        }
        Log.w(Resources.TAG, "getBoolean of bad type: 0x"
              + Integer.toHexString(type));
        return defValue;
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getInt(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT) {
            return data[index+AssetManager.STYLE_DATA];
        }
        TypedValue v = mValue;
        if (getValueAt(index, v)) {
            Log.w(Resources.TAG, "Converting to int: " + v);
            return XmlUtils.convertValueToInt(
                v.coerceToString(), defValue);
        }
        Log.w(Resources.TAG, "getInt of bad type: 0x"
              + Integer.toHexString(type));
        return defValue;
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getFloat(int index, float defValue){
		return getTaintFloat();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getColor(int index, int defValue){
		return getTaintInt();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public ColorStateList getColorStateList(int index){
		return mResources.loadColorStateList(mValue, mValue.resourceId);
		// Original method
		/*
		{
        final TypedValue value = mValue;
        if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            return mResources.loadColorStateList(value, value.resourceId);
        }
        return null;
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getInteger(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type >= TypedValue.TYPE_FIRST_INT
            && type <= TypedValue.TYPE_LAST_INT) {
            return data[index+AssetManager.STYLE_DATA];
        }
        throw new UnsupportedOperationException("Can't convert to integer: type=0x"
                + Integer.toHexString(type));
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getDimension(int index, float defValue){
		return getTaintFloat();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type == TypedValue.TYPE_DIMENSION) {
            return TypedValue.complexToDimension(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDimensionPixelOffset(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type == TypedValue.TYPE_DIMENSION) {
            return TypedValue.complexToDimensionPixelOffset(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getDimensionPixelSize(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type == TypedValue.TYPE_DIMENSION) {
            return TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        }
        throw new UnsupportedOperationException("Can't convert to dimension: type=0x"
                + Integer.toHexString(type));
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getLayoutDimension(int index, String name){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT) {
            return data[index+AssetManager.STYLE_DATA];
        } else if (type == TypedValue.TYPE_DIMENSION) {
            return TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        }
        throw new RuntimeException(getPositionDescription()
                + ": You must supply a " + name + " attribute.");
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getLayoutDimension(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type >= TypedValue.TYPE_FIRST_INT
                && type <= TypedValue.TYPE_LAST_INT) {
            return data[index+AssetManager.STYLE_DATA];
        } else if (type == TypedValue.TYPE_DIMENSION) {
            return TypedValue.complexToDimensionPixelSize(
                data[index+AssetManager.STYLE_DATA], mResources.mMetrics);
        }
        return defValue;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public float getFraction(int index, int base, int pbase, float defValue){
		return getTaintFloat();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return defValue;
        } else if (type == TypedValue.TYPE_FRACTION) {
            return TypedValue.complexToFraction(
                data[index+AssetManager.STYLE_DATA], base, pbase);
        }
        throw new UnsupportedOperationException("Can't convert to fraction: type=0x"
                + Integer.toHexString(type));
    }
		*/
	}
    
	@DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getResourceId(int index, int defValue){
		return getTaintInt();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        if (data[index+AssetManager.STYLE_TYPE] != TypedValue.TYPE_NULL) {
            final int resid = data[index+AssetManager.STYLE_RESOURCE_ID];
            if (resid != 0) {
                return resid;
            }
        }
        return defValue;
    }
		*/
	}
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public Drawable getDrawable(int index){
		return mResources.loadDrawable(mValue, mValue.resourceId);
		// Original method
		/*
		{
        final TypedValue value = mValue;
        if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            if (false) {
                System.out.println("******************************************************************");
                System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                System.out.println("******************************************************************");
            }
            return mResources.loadDrawable(value, value.resourceId);
        }
        return null;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CharSequence[] getTextArray(int index){
		return mResources.getTextArray(mValue.resourceId);
		// Original method
		/*
		{
        final TypedValue value = mValue;
        if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            if (false) {
                System.out.println("******************************************************************");
                System.out.println("Got drawable resource: type="
                                   + value.type
                                   + " str=" + value.string
                                   + " int=0x" + Integer.toHexString(value.data)
                                   + " cookie=" + value.assetCookie);
                System.out.println("******************************************************************");
            }
            return mResources.getTextArray(value.resourceId);
        }
        return null;
    }
		*/
	}

    /**
     * Retrieve the raw TypedValue for the attribute at <var>index</var>.
     * 
     * @param index Index of attribute to retrieve.
     * @param outValue TypedValue object in which to place the attribute's
     *                 data.
     * 
     * @return Returns true if the value was retrieved, else false. 
     */
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:01.212 -0500", hash_original_method = "0C857F8AC76CD5CFBE7569B581103BDD", hash_generated_method = "8BA02359D62F0CC748F75C0F18969D76")
    
public boolean getValue(int index, TypedValue outValue) {
        return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }
    
    @DSComment("data structure class")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public boolean hasValue(int index){
		return getTaintBoolean();
		// Original method
		/*
		{
        index *= AssetManager.STYLE_NUM_ENTRIES;
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        return type != TypedValue.TYPE_NULL;
    }
		*/
	}
    
    public TypedValue peekValue(int index){
		return mValue;
		// Original method
		/*
		{
        final TypedValue value = mValue;
        if (getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, value)) {
            return value;
        }
        return null;
    }
		*/
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public String getPositionDescription(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        return mXml != null ? mXml.getPositionDescription() : "<internal>";
    }
		*/
	}
    
	@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    public void recycle(){
		mResources.mCachedStyledAttributes = this;
		// Original method
		/*
		{
        synchronized (mResources.mTmpValue) {
            TypedArray cached = mResources.mCachedStyledAttributes;
            if (cached == null || cached.mData.length < mData.length) {
                mXml = null;
                mResources.mCachedStyledAttributes = this;
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean getValueAt(int index, TypedValue outValue){
		outValue.type = 0;
        outValue.data = getTaintInt();
        outValue.assetCookie = getTaintInt();
        outValue.resourceId = getTaintInt();
        outValue.changingConfigurations = getTaintInt();
        outValue.density = getTaintInt();
        outValue.string = loadStringValueAt(index);
		return getTaintBoolean();
		// Original method
		/*
		{
        final int[] data = mData;
        final int type = data[index+AssetManager.STYLE_TYPE];
        if (type == TypedValue.TYPE_NULL) {
            return false;
        }
        outValue.type = type;
        outValue.data = data[index+AssetManager.STYLE_DATA];
        outValue.assetCookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        outValue.resourceId = data[index+AssetManager.STYLE_RESOURCE_ID];
        outValue.changingConfigurations = data[index+AssetManager.STYLE_CHANGING_CONFIGURATIONS];
        outValue.density = data[index+AssetManager.STYLE_DENSITY];
        outValue.string = (type == TypedValue.TYPE_STRING) ? loadStringValueAt(index) : null;
        return true;
    }
		*/
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private CharSequence loadStringValueAt(int index){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        final int[] data = mData;
        final int cookie = data[index+AssetManager.STYLE_ASSET_COOKIE];
        if (cookie < 0) {
            if (mXml != null) {
                return mXml.getPooledString(
                    data[index+AssetManager.STYLE_DATA]);
            }
            return null;
        }
        return mResources.mAssets.getPooledString(
            cookie, data[index+AssetManager.STYLE_DATA]);
    }
		*/
	}
    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        return Arrays.toString(mData);
    }
		*/
	}
    
}

