package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.WebView;

public class Plugin {
    private String mName;
    private String mPath;
    private String mFileName;
    private String mDescription;
    private PreferencesClickHandler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.621 -0400", hash_original_method = "2C6736809EC9A23A73CBB94699301118", hash_generated_method = "E7240EC797ED103BB8756D77D2E99855")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public Plugin(String name,
                  String path,
                  String fileName,
                  String description) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(name);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(path);
        mHandler = new DefaultClickHandler();
        // ---------- Original Method ----------
        //mName = name;
        //mPath = path;
        //mFileName = fileName;
        //mDescription = description;
        //mHandler = new DefaultClickHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.621 -0400", hash_original_method = "43BC08E1F7E5C666CAA2DF1AE267F887", hash_generated_method = "A1FAB505268EA40B856761D82EE1CFA1")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.621 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "6F53963C46DDD941AB9086410BF8CEA8")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.621 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "4C103DD13FD409724078C05040A4A3E4")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.622 -0400", hash_original_method = "893C26134B08FF7C2100195EAF1C3901", hash_generated_method = "C5EC30EEB5E9E7DB202238076B6934B9")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String getFileName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.622 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "A2C3D3F4ABEF63F33DAD21CB3A38C9FD")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.622 -0400", hash_original_method = "78D9655716B683F94FF9836934A4E62F", hash_generated_method = "1694E5DFE1DD9868D250B20CF8B73576")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setName(String name) {
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
        //mName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.622 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "448508F5B1B37F110F66A4F1DC6C6AEB")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setPath(String path) {
        dsTaint.addTaint(path);
        // ---------- Original Method ----------
        //mPath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.622 -0400", hash_original_method = "FADBE65C3B618F302C5F609E6BD9A536", hash_generated_method = "376798CAC2B622CF8B2E95C1B4E3614B")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setFileName(String fileName) {
        dsTaint.addTaint(fileName);
        // ---------- Original Method ----------
        //mFileName = fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.623 -0400", hash_original_method = "7DA8CA555254FB07422E1E09F7168083", hash_generated_method = "E20FA771D19B9CB92BF7BFB1771AB088")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setDescription(String description) {
        dsTaint.addTaint(description);
        // ---------- Original Method ----------
        //mDescription = description;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.623 -0400", hash_original_method = "3DA107FCB8BA400992AD2CF017DE732E", hash_generated_method = "9CB274BB43D3E13F46AAFAA00B063FE9")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setClickHandler(PreferencesClickHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.623 -0400", hash_original_method = "AC42238384201536C0DCECDF2B1C0CE7", hash_generated_method = "7073BF8D809FE35761B8A1CC903C3961")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void dispatchClickEvent(Context context) {
        dsTaint.addTaint(context.dsTaint);
        {
            mHandler.handleClickEvent(context);
        } //End block
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.handleClickEvent(context);
        //}
    }

    
    private class DefaultClickHandler implements PreferencesClickHandler, DialogInterface.OnClickListener {
        private AlertDialog mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.623 -0400", hash_original_method = "4C8442792629946ACD0FFD081F2D79AF", hash_generated_method = "4C8442792629946ACD0FFD081F2D79AF")
                public DefaultClickHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.623 -0400", hash_original_method = "3FD5CDF9FCD323996A705BE973B806F6", hash_generated_method = "B00EE585012D9F606C3CCC06313AD57F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Deprecated
        public void handleClickEvent(Context context) {
            dsTaint.addTaint(context.dsTaint);
            {
                mDialog = new AlertDialog.Builder(context)
                        .setTitle(mName)
                        .setMessage(mDescription)
                        .setPositiveButton(R.string.ok, this)
                        .setCancelable(false)
                        .show();
            } //End block
            // ---------- Original Method ----------
            //if (mDialog == null) {
                //mDialog = new AlertDialog.Builder(context)
                        //.setTitle(mName)
                        //.setMessage(mDescription)
                        //.setPositiveButton(R.string.ok, this)
                        //.setCancelable(false)
                        //.show();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.624 -0400", hash_original_method = "AC430E0A291DF33FFA8EC94A86B6279D", hash_generated_method = "FF62B3D705D8E52007BA7A372443744C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Deprecated
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(which);
            dsTaint.addTaint(dialog.dsTaint);
            mDialog.dismiss();
            mDialog = null;
            // ---------- Original Method ----------
            //mDialog.dismiss();
            //mDialog = null;
        }

        
    }


    
    public interface PreferencesClickHandler {
        
        public void handleClickEvent(Context context);
    }
    
}

