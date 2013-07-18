package android.content.res;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.android.internal.util.XmlUtils;
import java.util.Arrays;

public class TypedArray {
    private final Resources mResources;
    XmlBlock.Parser mXml;
    int[] mRsrcs;
    int[] mData;
    int[] mIndices;
    int mLength;
    TypedValue mValue = new TypedValue();
    
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

    
    public int length(){
		return getTaintInt();
		// Original method
		/*
		{
        return mLength;
    }
		*/
	}

    
    public int getIndexCount(){
		// Original method
		/*
		{
        return mIndices[0];
    }
		*/
		return getTaintInt();
	}

    
    public int getIndex(int at){
		// Original method
		/*
		{
        return mIndices[1+at];
    }
		*/
		return getTaintInt();
	}

    
    public Resources getResources(){
		return mResources;
		// Original method
		/*
		{
        return mResources;
    }
		*/
	}

    
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

    
    @DSModeled(DSC.SAFE)
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

    
    public String getNonConfigurationString(int index, int allowedChangingConfigs){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
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

    
    public float getFloat(int index, float defValue){
		return getTaintFloat();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
    public int getColor(int index, int defValue){
		return getTaintInt();
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
	}

    
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

    
    @DSModeled(DSC.SAFE)
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

    
    public boolean getValue(int index, TypedValue outValue){
		return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
		// Original method
		/*
		{
        return getValueAt(index*AssetManager.STYLE_NUM_ENTRIES, outValue);
    }
		*/
	}

    
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

    
    @DSModeled(DSC.SAFE)
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

