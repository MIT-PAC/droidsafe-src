package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.content.res.AssetManager;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;

class FileLoader extends StreamLoader {
    private String mPath;
    private int mType;
    private boolean mAllowFileAccess;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.200 -0400", hash_original_method = "0A468BF2FF018C04A055F46D2001401C", hash_generated_method = "A78DEBD759C27DE52836557DDBC24DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     FileLoader(String url, LoadListener loadListener, int type,
            boolean allowFileAccess) {
        super(loadListener);
        dsTaint.addTaint(type);
        dsTaint.addTaint(allowFileAccess);
        dsTaint.addTaint(loadListener.dsTaint);
        dsTaint.addTaint(url);
        int index;
        index = url.indexOf('?');
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.ASSET_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.ASSET_BASE.length()));
        } //End block
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.RESOURCE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.RESOURCE_BASE.length()));
        } //End block
        {
            mPath = index > 0 ? URLUtil.stripAnchor(
                    url.substring(URLUtil.FILE_BASE.length(), index)) :
                    URLUtil.stripAnchor(url.substring(
                            URLUtil.FILE_BASE.length()));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.200 -0400", hash_original_method = "987DD890C3289D23A785AB1F430BD4A8", hash_generated_method = "CBFC86B60229BE343D95257CBD41E89B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String errString(Exception ex) {
        dsTaint.addTaint(ex.dsTaint);
        String exMessage;
        exMessage = ex.getMessage();
        String errString;
        errString = mContext.getString(R.string.httpErrorFileNotFound);
        {
            errString += " " + exMessage;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.201 -0400", hash_original_method = "97D1B11BE7CB4BE78107ED00EAAEAEA4", hash_generated_method = "1D0D24D21E5E795EAFF6FACAACB3B60C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean setupStreamAndSendStatus() {
        try 
        {
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
            {
                {
                    boolean varD4B8FA11CB22531163AB9A0D260CA64A_848999902 = (mPath == null || mPath.length() == 0);
                    {
                        mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                    } //End block
                } //End collapsed parenthetic
                int slash;
                slash = mPath.indexOf('/');
                int dot;
                dot = mPath.indexOf('.', slash);
                {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                } //End block
                String subClassName;
                subClassName = mPath.substring(0, slash);
                String fieldName;
                fieldName = mPath.substring(slash + 1, dot);
                String errorMsg;
                errorMsg = null;
                try 
                {
                    Class<?> d;
                    d = mContext.getApplicationContext()
                            .getClassLoader().loadClass(
                                    mContext.getPackageName() + ".R$"
                                            + subClassName);
                    Field field;
                    field = d.getField(fieldName);
                    int id;
                    id = field.getInt(null);
                    TypedValue value;
                    value = new TypedValue();
                    mContext.getResources().getValue(id, value, true);
                    {
                        mDataStream = mContext.getAssets().openNonAsset(
                                value.assetCookie, value.string.toString(),
                                AssetManager.ACCESS_STREAMING);
                    } //End block
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
                {
                    mLoadListener.error(EventHandler.FILE_ERROR, mContext
                            .getString(R.string.httpErrorFileNotFound));
                } //End block
            } //End block
            {
                {
                    mLoadListener.error(EventHandler.FILE_ERROR,
                            mContext.getString(R.string.httpErrorFileNotFound));
                } //End block
                mDataStream = new FileInputStream(mPath);
                mContentLength = (new File(mPath)).length();
            } //End block
            mLoadListener.status(1, 1, 200, "OK");
        } //End block
        catch (java.io.FileNotFoundException ex)
        {
            mLoadListener.error(EventHandler.FILE_NOT_FOUND_ERROR, errString(ex));
        } //End block
        catch (java.io.IOException ex)
        {
            mLoadListener.error(EventHandler.FILE_ERROR, errString(ex));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.202 -0400", hash_original_method = "EECFC31B2787C18B03F2C6B112B9990D", hash_generated_method = "2C7F8C1D8F5501140935BC5FE033B58E")
    @DSModeled(DSC.SAFE)
    @Override
    protected void buildHeaders(Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        // ---------- Original Method ----------
    }

    
    static final int TYPE_ASSET = 1;
    static final int TYPE_RES = 2;
    static final int TYPE_FILE = 3;
    private static final String LOGTAG = "webkit";
}

