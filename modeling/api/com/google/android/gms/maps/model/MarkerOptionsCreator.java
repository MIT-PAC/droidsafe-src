package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.IBinder;
import android.os.Parcelable;

public class MarkerOptionsCreator implements android.os.Parcelable.Creator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 10:04:18.119 -0400", hash_original_field = "BE7571FEE68510C5B2ABCBF2C7161CA5", hash_generated_field = "A4CA75FA70F636AD154C8D958F52817C")

    public static final int CONTENT_DESCRIPTION = 0;
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 10:04:18.206 -0400", hash_original_method = "30366B87AFEC637BAA5E05D3B236D25E", hash_generated_method = "BC5EA8986C0360590F8351CDBD17229D")
    
    public  Object createFromParcel(Parcel  r1)
    {
    	MarkerOptions options = new MarkerOptions();
    	float f = r1.readFloat();
    	options.alpha(f);
    	options.anchor(f, f);
    	options.rotation(f);
    	
    	boolean b = ((f) == 1);
    	options.flat(b);
    	options.draggable(b);
    	options.visible(b);

    	return options;
    }

    @DSSafe
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 10:04:18.199 -0400", hash_original_method = "CA11DFF75F0E87181B5E1251583553C5", hash_generated_method = "A10880B56629EEA2D9F33229531F720D")
    public  Object[] newArray(int  i0)
    {
    	MarkerOptions options = new MarkerOptions();
    	MarkerOptions[] optionsArray =  new MarkerOptions[i0];
    	optionsArray[0] = options;
        return optionsArray;
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public MarkerOptionsCreator(DSOnlyType dontcare) {
    	
    }
   
}
