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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.447 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.447 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

    private int mType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.447 -0400", hash_original_field = "B1028CE892468A1504CF91F79B7267EA", hash_generated_field = "B054B0568675CAED6B0FC902EBB17D6A")

    private boolean mAllowFileAccess;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.451 -0400", hash_original_method = "0A468BF2FF018C04A055F46D2001401C", hash_generated_method = "F0379FABEF38E855CB4A4462EAD0F703")
      FileLoader(String url, LoadListener loadListener, int type,
            boolean allowFileAccess) {
        super(loadListener);
        mType = type;
        mAllowFileAccess = allowFileAccess;
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
        addTaint(loadListener.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.453 -0400", hash_original_method = "987DD890C3289D23A785AB1F430BD4A8", hash_generated_method = "3BF2377F7EAA68E4131233370EECD1B4")
    private String errString(Exception ex) {
        String varB4EAC82CA7396A68D541C85D26508E83_1889399713 = null; //Variable for return #1
        String exMessage;
        exMessage = ex.getMessage();
        String errString;
        errString = mContext.getString(R.string.httpErrorFileNotFound);
        {
            errString += " " + exMessage;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1889399713 = errString;
        addTaint(ex.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1889399713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1889399713;
        // ---------- Original Method ----------
        //String exMessage = ex.getMessage();
        //String errString = mContext.getString(R.string.httpErrorFileNotFound);
        //if (exMessage != null) {
            //errString += " " + exMessage;
        //}
        //return errString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.455 -0400", hash_original_method = "97D1B11BE7CB4BE78107ED00EAAEAEA4", hash_generated_method = "36BC70638748BC6EAD773B3192DFA9DC")
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
                    boolean varD4B8FA11CB22531163AB9A0D260CA64A_1345018803 = (mPath == null || mPath.length() == 0);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213851583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213851583;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.480 -0400", hash_original_method = "EECFC31B2787C18B03F2C6B112B9990D", hash_generated_method = "E46259D9AABAC67CD274455544731825")
    @Override
    protected void buildHeaders(Headers headers) {
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.480 -0400", hash_original_field = "DC873D9FC22AE0F3BA2786ED2D83AA0B", hash_generated_field = "C6E7DE26281C3E805B821E47C91A2480")

    static int TYPE_ASSET = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.480 -0400", hash_original_field = "409C348550739E902EC65BF8588EFA20", hash_generated_field = "C1C866F12B7B8F03F89B45F4ADDD7F41")

    static int TYPE_RES = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.480 -0400", hash_original_field = "DD6C634954B8927E0E83CC512CEAB424", hash_generated_field = "F5A8D237DBEFAA5AF34F53679FCBAA73")

    static int TYPE_FILE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:58.480 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "E56CE2F3E60B73E43C117C0293F7827E")

    private static String LOGTAG = "webkit";
}

