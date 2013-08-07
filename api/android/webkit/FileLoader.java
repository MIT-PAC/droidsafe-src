package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

import android.content.res.AssetManager;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.util.TypedValue;

import com.android.internal.R;






class FileLoader extends StreamLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.381 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.381 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.381 -0400", hash_original_field = "B1028CE892468A1504CF91F79B7267EA", hash_generated_field = "B054B0568675CAED6B0FC902EBB17D6A")

    private boolean mAllowFileAccess;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.382 -0400", hash_original_method = "0A468BF2FF018C04A055F46D2001401C", hash_generated_method = "E973746798FDFFD1A55374158B76322E")
      FileLoader(String url, LoadListener loadListener, int type,
            boolean allowFileAccess) {
        super(loadListener);
        addTaint(loadListener.getTaint());
        mType = type;
        mAllowFileAccess = allowFileAccess;
        int index = url.indexOf('?');
        if(mType == TYPE_ASSET)        
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.ASSET_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.ASSET_BASE.length()));
        } //End block
        else
        if(mType == TYPE_RES)        
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.RESOURCE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.RESOURCE_BASE.length()));
        } //End block
        else
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.FILE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.FILE_BASE.length()));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.383 -0400", hash_original_method = "987DD890C3289D23A785AB1F430BD4A8", hash_generated_method = "D519123CC969EAE48C1467A1D5FC0B3C")
    private String errString(Exception ex) {
        addTaint(ex.getTaint());
        String exMessage = ex.getMessage();
        String errString = mContext.getString(R.string.httpErrorFileNotFound);
        if(exMessage != null)        
        {
            errString += " " + exMessage;
        } //End block
String varF917352FB1129841F1BC9CC901BB1B99_1636186718 =         errString;
        varF917352FB1129841F1BC9CC901BB1B99_1636186718.addTaint(taint);
        return varF917352FB1129841F1BC9CC901BB1B99_1636186718;
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.386 -0400", hash_original_method = "97D1B11BE7CB4BE78107ED00EAAEAEA4", hash_generated_method = "5FC633200B0758C2EA7303DE5673475B")
    @Override
    protected boolean setupStreamAndSendStatus() {
        try 
        {
            if(mType == TYPE_ASSET)            
            {
                try 
                {
                    mDataStream = mContext.getAssets().open(mPath);
                } //End block
                catch (java.io.FileNotFoundException ex)
                {
                    mDataStream = mContext.getAssets().openNonAsset(mPath);
                } //End block
            } //End block
            else
            if(mType == TYPE_RES)            
            {
                if(mPath == null || mPath.length() == 0)                
                {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    boolean var68934A3E9455FA72420237EB05902327_1187419188 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2025595285 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2025595285;
                } //End block
                int slash = mPath.indexOf('/');
                int dot = mPath.indexOf('.', slash);
                if(slash == -1 || dot == -1)                
                {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    boolean var68934A3E9455FA72420237EB05902327_1520651841 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997547898 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997547898;
                } //End block
                String subClassName = mPath.substring(0, slash);
                String fieldName = mPath.substring(slash + 1, dot);
                String errorMsg = null;
                try 
                {
                    final Class<?> d = mContext.getApplicationContext()
                            .getClassLoader().loadClass(
                                    mContext.getPackageName() + ".R$"
                                            + subClassName);
                    final Field field = d.getField(fieldName);
                    final int id = field.getInt(null);
                    TypedValue value = new TypedValue();
                    mContext.getResources().getValue(id, value, true);
                    if(value.type == TypedValue.TYPE_STRING)                    
                    {
                        mDataStream = mContext.getAssets().openNonAsset(
                                value.assetCookie, value.string.toString(),
                                AssetManager.ACCESS_STREAMING);
                    } //End block
                    else
                    {
                        errorMsg = "Only support TYPE_STRING for the res files";
                    } //End block
                } //End block
                catch (ClassNotFoundException e)
                {
                    errorMsg = "Can't find class:  "
                            + mContext.getPackageName() + ".R$" + subClassName;
                } //End block
                catch (SecurityException e)
                {
                    errorMsg = "Caught SecurityException: " + e;
                } //End block
                catch (NoSuchFieldException e)
                {
                    errorMsg = "Can't find field:  " + fieldName + " in "
                            + mContext.getPackageName() + ".R$" + subClassName;
                } //End block
                catch (IllegalArgumentException e)
                {
                    errorMsg = "Caught IllegalArgumentException: " + e;
                } //End block
                catch (IllegalAccessException e)
                {
                    errorMsg = "Caught IllegalAccessException: " + e;
                } //End block
                if(errorMsg != null)                
                {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    boolean var68934A3E9455FA72420237EB05902327_162772719 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367350485 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_367350485;
                } //End block
            } //End block
            else
            {
                if(!mAllowFileAccess)                
                {
                    mLoadListener.error(EventHandler.FILE_ERROR,
                            mContext.getString(R.string.httpErrorFileNotFound));
                    boolean var68934A3E9455FA72420237EB05902327_1394048159 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_871739560 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_871739560;
                } //End block
                mDataStream = new FileInputStream(mPath);
                mContentLength = (new File(mPath)).length();
            } //End block
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        catch (java.io.FileNotFoundException ex)
        {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_99629636 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1712114586 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1712114586;
        } //End block
        catch (java.io.IOException ex)
        {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
            boolean var68934A3E9455FA72420237EB05902327_235396215 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206092518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_206092518;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_125829729 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067983198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067983198;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.386 -0400", hash_original_method = "EECFC31B2787C18B03F2C6B112B9990D", hash_generated_method = "E46259D9AABAC67CD274455544731825")
    @Override
    protected void buildHeaders(Headers headers) {
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.387 -0400", hash_original_field = "DC873D9FC22AE0F3BA2786ED2D83AA0B", hash_generated_field = "1961BC7D2105DF0CF9A74E0FB587B24A")

    static final int TYPE_ASSET = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.387 -0400", hash_original_field = "409C348550739E902EC65BF8588EFA20", hash_generated_field = "37CFCBEAA36971A1B22E497F54B484AC")

    static final int TYPE_RES = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.387 -0400", hash_original_field = "DD6C634954B8927E0E83CC512CEAB424", hash_generated_field = "9E507F10BB893E2897D9DF437CDF3C57")

    static final int TYPE_FILE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.387 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
}

