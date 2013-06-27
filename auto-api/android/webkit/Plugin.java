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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.170 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.170 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.170 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.170 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.170 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "07C654711F08D4910C73DE85CA1FE45A")

    private PreferencesClickHandler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.178 -0400", hash_original_method = "2C6736809EC9A23A73CBB94699301118", hash_generated_method = "F2CD37E74B8E122BF32354BA972A4B50")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.179 -0400", hash_original_method = "43BC08E1F7E5C666CAA2DF1AE267F887", hash_generated_method = "2A11413BB37318DD676917742A73D629")
    @Deprecated
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_615257620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_615257620 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_615257620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_615257620;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.179 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "549DE1BCEE5180E8A2A3DF41DD6EB523")
    @Deprecated
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_171143780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_171143780 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_171143780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_171143780;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.180 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "D9063CA3A8B4CE3D09A821EAE561A6DD")
    @Deprecated
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1402546655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1402546655 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1402546655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1402546655;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.180 -0400", hash_original_method = "893C26134B08FF7C2100195EAF1C3901", hash_generated_method = "40E3B0A9535DDAAA120E85EB29665792")
    @Deprecated
    public String getFileName() {
        String varB4EAC82CA7396A68D541C85D26508E83_92824730 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_92824730 = mFileName;
        varB4EAC82CA7396A68D541C85D26508E83_92824730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_92824730;
        // ---------- Original Method ----------
        //return mFileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.201 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "D1848BDD798A26FAD89A8C05335FF45D")
    @Deprecated
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1734011212 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734011212 = mDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1734011212.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734011212;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.205 -0400", hash_original_method = "78D9655716B683F94FF9836934A4E62F", hash_generated_method = "2801D43F1EEF02D42AA575BC5D0D1826")
    @Deprecated
    public void setName(String name) {
        mName = name;
        // ---------- Original Method ----------
        //mName = name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.205 -0400", hash_original_method = "33BABAA311E3F3938C433EAC08EFC3BD", hash_generated_method = "8BE7E7F4D87C25C2488A32AE6A9F8AD7")
    @Deprecated
    public void setPath(String path) {
        mPath = path;
        // ---------- Original Method ----------
        //mPath = path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.206 -0400", hash_original_method = "FADBE65C3B618F302C5F609E6BD9A536", hash_generated_method = "2CA8F8F699355A8FB34EE726CBFB218C")
    @Deprecated
    public void setFileName(String fileName) {
        mFileName = fileName;
        // ---------- Original Method ----------
        //mFileName = fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.209 -0400", hash_original_method = "7DA8CA555254FB07422E1E09F7168083", hash_generated_method = "5FAB393C51AB3F125A30A70FC6583651")
    @Deprecated
    public void setDescription(String description) {
        mDescription = description;
        // ---------- Original Method ----------
        //mDescription = description;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.209 -0400", hash_original_method = "3DA107FCB8BA400992AD2CF017DE732E", hash_generated_method = "E830DB1AD9EE5F238838A7BD3DF4E35E")
    @Deprecated
    public void setClickHandler(PreferencesClickHandler handler) {
        mHandler = handler;
        // ---------- Original Method ----------
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.210 -0400", hash_original_method = "AC42238384201536C0DCECDF2B1C0CE7", hash_generated_method = "9F663745F2BD7F134212BFB334EB4EDE")
    @Deprecated
    public void dispatchClickEvent(Context context) {
        {
            mHandler.handleClickEvent(context);
        } //End block
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.handleClickEvent(context);
        //}
    }

    
    private class DefaultClickHandler implements PreferencesClickHandler, DialogInterface.OnClickListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.210 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "F83602A20E99C2560EE913CF62B217D5")

        private AlertDialog mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.210 -0400", hash_original_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3", hash_generated_method = "4B0F149C9C655DFB86CE4B1F7F82F0C3")
        public DefaultClickHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.211 -0400", hash_original_method = "3FD5CDF9FCD323996A705BE973B806F6", hash_generated_method = "55AF21C66B1076AFF8743241D590860F")
        @Deprecated
        public void handleClickEvent(Context context) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:59.220 -0400", hash_original_method = "AC430E0A291DF33FFA8EC94A86B6279D", hash_generated_method = "1D5D4FF75A48BD8D265C8A29B3785327")
        @Deprecated
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDialog.dismiss();
            mDialog = null;
            addTaint(dialog.getTaint());
            addTaint(which);
            // ---------- Original Method ----------
            //mDialog.dismiss();
            //mDialog = null;
        }

        
    }


    
    public interface PreferencesClickHandler {
        
        public void handleClickEvent(Context context);
    }
    
}

