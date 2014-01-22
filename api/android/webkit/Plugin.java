package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.android.internal.R;

public class Plugin {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.446 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.448 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.450 -0500", hash_original_field = "EDC6D2A1228FB58172CCF792832A2DF2", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.452 -0500", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.454 -0500", hash_original_field = "F75D19262369695B2C36B948F5A59AD4", hash_generated_field = "07C654711F08D4910C73DE85CA1FE45A")

    private PreferencesClickHandler mHandler;

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.457 -0500", hash_original_method = "2C6736809EC9A23A73CBB94699301118", hash_generated_method = "FA204C43E31FADB50453EE1DB491CD0B")
    
@Deprecated
    public Plugin(String name,
                  String path,
                  String fileName,
                  String description) {
        mName = name;
        mPath = path;
        mFileName = fileName;
        mDescription = description;
        mHandler = new DefaultClickHandler();
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.459 -0500", hash_original_method = "43BC08E1F7E5C666CAA2DF1AE267F887", hash_generated_method = "268C93AA710221796FAC50220F034A57")
    
@Deprecated
    public String toString() {
        return mName;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.461 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "F288CD0DA0B9FE2CF53EC1E6FE93C324")
    
@Deprecated
    public String getName() {
        return mName;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.463 -0500", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "524CB7EEAE26D205257D996B6D82198A")
    
@Deprecated
    public String getPath() {
        return mPath;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.466 -0500", hash_original_method = "893C26134B08FF7C2100195EAF1C3901", hash_generated_method = "4003283A41A803B2C71BA0FE143C85AB")
    
@Deprecated
    public String getFileName() {
        return mFileName;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.468 -0500", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "978AAD7FDADAB8F9A67DF8A8E45462A6")
    
@Deprecated
    public String getDescription() {
        return mDescription;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.471 -0500", hash_original_method = "78D9655716B683F94FF9836934A4E62F", hash_generated_method = "07C363DB430221C98974FA43A6AE2701")
    
@Deprecated
    public void setName(String name) {
        mName = name;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.473 -0500", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "456A43FAFEE52839A788EB3CAD08A272")
    
@Deprecated
    public void setPath(String path) {
        mPath = path;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.475 -0500", hash_original_method = "FADBE65C3B618F302C5F609E6BD9A536", hash_generated_method = "0ED3D54CBA97F1147E13C8852AF42F26")
    
@Deprecated
    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.478 -0500", hash_original_method = "7DA8CA555254FB07422E1E09F7168083", hash_generated_method = "B2BD6572CDBB05AE6A33DA9F1D66A545")
    
@Deprecated
    public void setDescription(String description) {
        mDescription = description;
    }

    /**
     * @hide
     * @deprecated This interface was intended to be used by Gears. Since Gears was
     * deprecated, so is this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.480 -0500", hash_original_method = "3DA107FCB8BA400992AD2CF017DE732E", hash_generated_method = "4D3CE5C5DACFC4BA42A852AEF776A849")
    
@Deprecated
    public void setClickHandler(PreferencesClickHandler handler) {
        mHandler = handler;
    }

   /**
    * Invokes the click handler for this plugin.
    *
    * @hide
    * @deprecated This interface was intended to be used by Gears. Since Gears was
    * deprecated, so is this class.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.482 -0500", hash_original_method = "AC42238384201536C0DCECDF2B1C0CE7", hash_generated_method = "4B42DC459DBE90EBBDEE1436E097163E")
    
@Deprecated
    public void dispatchClickEvent(Context context) {
        if (mHandler != null) {
            mHandler.handleClickEvent(context);
        }
    }
    
    private class DefaultClickHandler implements PreferencesClickHandler, DialogInterface.OnClickListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.484 -0500", hash_original_field = "E9678224249A33E904175F62AC8914F6", hash_generated_field = "F83602A20E99C2560EE913CF62B217D5")

        private AlertDialog mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.777 -0400", hash_original_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3", hash_generated_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3")
        public DefaultClickHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.488 -0500", hash_original_method = "3FD5CDF9FCD323996A705BE973B806F6", hash_generated_method = "950438F720E998FC55FF81380C4E8EBD")
        
@Deprecated
        public void handleClickEvent(Context context) {
            // Show a simple popup dialog containing the description
            // string of the plugin.
            if (mDialog == null) {
                mDialog = new AlertDialog.Builder(context)
                        .setTitle(mName)
                        .setMessage(mDescription)
                        .setPositiveButton(R.string.ok, this)
                        .setCancelable(false)
                        .show();
            }
        }
        /**
         * @hide
         * @deprecated This interface was intended to be used by Gears. Since Gears was
         * deprecated, so is this class.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:39.490 -0500", hash_original_method = "AC430E0A291DF33FFA8EC94A86B6279D", hash_generated_method = "4399027B9BED386B4DFE50527A27EA78")
        
@Deprecated
        public void onClick(DialogInterface dialog, int which) {
            mDialog.dismiss();
            mDialog = null;
        }
        
    }
    
    public interface PreferencesClickHandler {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void handleClickEvent(Context context);
    }
    
}

