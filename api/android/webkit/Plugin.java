package android.webkit;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.android.internal.R;






public class Plugin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.752 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.752 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.752 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.753 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.753 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "07C654711F08D4910C73DE85CA1FE45A")

    private PreferencesClickHandler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.755 -0400", hash_original_method = "2C6736809EC9A23A73CBB94699301118", hash_generated_method = "F2CD37E74B8E122BF32354BA972A4B50")
    @Deprecated
    public  Plugin(String name,
                  String path,
                  String fileName,
                  String description) {
        mName = name;
        mPath = path;
        mFileName = fileName;
        mDescription = description;
        mHandler = new DefaultClickHandler();
        // ---------- Original Method ----------
        //mName = name;
        //mPath = path;
        //mFileName = fileName;
        //mDescription = description;
        //mHandler = new DefaultClickHandler();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.759 -0400", hash_original_method = "43BC08E1F7E5C666CAA2DF1AE267F887", hash_generated_method = "43B762BDDABA63590E64A3405E922A54")
    @Deprecated
    public String toString() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1013335966 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1013335966.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1013335966;
        // ---------- Original Method ----------
        //return mName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.760 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "10DB12065387BAF144EBFE57BED2802A")
    @Deprecated
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1661372478 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1661372478.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1661372478;
        // ---------- Original Method ----------
        //return mName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.760 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "085D81232FD566EC38737111A1222977")
    @Deprecated
    public String getPath() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_190092384 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_190092384.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_190092384;
        // ---------- Original Method ----------
        //return mPath;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.760 -0400", hash_original_method = "893C26134B08FF7C2100195EAF1C3901", hash_generated_method = "74B38EE804500713A27EB19F4D04A06C")
    @Deprecated
    public String getFileName() {
String var034A1EDD43045D5BE42C7869180FB3DC_1294775554 =         mFileName;
        var034A1EDD43045D5BE42C7869180FB3DC_1294775554.addTaint(taint);
        return var034A1EDD43045D5BE42C7869180FB3DC_1294775554;
        // ---------- Original Method ----------
        //return mFileName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.760 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "4F8DAFCB3580CAF0EE9A27DD747DBE37")
    @Deprecated
    public String getDescription() {
String var2094894B2BDB1315AACD05A5CC5702EE_42795367 =         mDescription;
        var2094894B2BDB1315AACD05A5CC5702EE_42795367.addTaint(taint);
        return var2094894B2BDB1315AACD05A5CC5702EE_42795367;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "78D9655716B683F94FF9836934A4E62F", hash_generated_method = "2801D43F1EEF02D42AA575BC5D0D1826")
    @Deprecated
    public void setName(String name) {
        mName = name;
        // ---------- Original Method ----------
        //mName = name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "8BE7E7F4D87C25C2488A32AE6A9F8AD7")
    @Deprecated
    public void setPath(String path) {
        mPath = path;
        // ---------- Original Method ----------
        //mPath = path;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "FADBE65C3B618F302C5F609E6BD9A536", hash_generated_method = "2CA8F8F699355A8FB34EE726CBFB218C")
    @Deprecated
    public void setFileName(String fileName) {
        mFileName = fileName;
        // ---------- Original Method ----------
        //mFileName = fileName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "7DA8CA555254FB07422E1E09F7168083", hash_generated_method = "5FAB393C51AB3F125A30A70FC6583651")
    @Deprecated
    public void setDescription(String description) {
        mDescription = description;
        // ---------- Original Method ----------
        //mDescription = description;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "3DA107FCB8BA400992AD2CF017DE732E", hash_generated_method = "E830DB1AD9EE5F238838A7BD3DF4E35E")
    @Deprecated
    public void setClickHandler(PreferencesClickHandler handler) {
        mHandler = handler;
        // ---------- Original Method ----------
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_method = "AC42238384201536C0DCECDF2B1C0CE7", hash_generated_method = "139329D5E01EE7540FFDCF0DA9AA313C")
    @Deprecated
    public void dispatchClickEvent(Context context) {
        addTaint(context.getTaint());
        if(mHandler != null)        
        {
            mHandler.handleClickEvent(context);
        } //End block
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.handleClickEvent(context);
        //}
    }

    
    private class DefaultClickHandler implements PreferencesClickHandler, DialogInterface.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.776 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "F83602A20E99C2560EE913CF62B217D5")

        private AlertDialog mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.777 -0400", hash_original_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3", hash_generated_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3")
        public DefaultClickHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.777 -0400", hash_original_method = "3FD5CDF9FCD323996A705BE973B806F6", hash_generated_method = "BCD363DE9DA8A92E84B034F0DC3A18E6")
        @Deprecated
        public void handleClickEvent(Context context) {
            if(mDialog == null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:52.777 -0400", hash_original_method = "AC430E0A291DF33FFA8EC94A86B6279D", hash_generated_method = "AB312E6E927EEF4A9B42A27EC852AA64")
        @Deprecated
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
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

