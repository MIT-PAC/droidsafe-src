package com.android.internal.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.android.internal.R;






public class AlertController {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "864CF846AE5CEA3E3FF02D8EF1852410", hash_generated_field = "2B4497FE8D3BE69F04001AB183F843A0")

    private DialogInterface mDialogInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "1118F3E1721DAF8FB4872146DA12E56F", hash_generated_field = "19A8BE4EA4CB90940A5BCBECC9F99055")

    private int mViewSpacingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "E7238771FCAB61AE32E851A5F82687D8", hash_generated_field = "6557ACD495F3B6484326AC57AECFA558")

    private int mViewSpacingTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "D8563F961A4F1D04632FC413D194B935", hash_generated_field = "47FEE73BA7B0F5642CD916931DB4B990")

    private int mViewSpacingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "7686141D1F92DBAA062C3A41CF84AF7D", hash_generated_field = "E6D3207EA728175311B7208886F6CFF1")

    private int mViewSpacingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "9516D9606C5F2B9AA236056257DD4D2C", hash_generated_field = "0F9BEABC6DA1B172890E35E612ED5285")

    private boolean mViewSpacingSpecified = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.886 -0400", hash_original_field = "75F78D14707C729A400B0BE258E854BF", hash_generated_field = "2DE16827139A20C2B2C0D130D64C1F22")

    private Button mButtonPositive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "988E62DDADD4AB2C15DA76094B45A53A", hash_generated_field = "ADEC89EC1C6163464CAB74778BA7F455")

    private CharSequence mButtonPositiveText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "D7558B1B938CF00A65A59E324437A261", hash_generated_field = "4C64AEB4AC17D726F0EC573D273C85E4")

    private Message mButtonPositiveMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "88EA7194116B3A5C3357680B0010372C", hash_generated_field = "B5032704B1FD6BFE5557786C4C3D3EFC")

    private Button mButtonNegative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "F3C8CB7B6AF91B005C215285579E176A", hash_generated_field = "D91959E3DC6E2952E856CD3FA0A399C6")

    private CharSequence mButtonNegativeText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "D83B863ADC3A0C7CA896C00DC3E81E99", hash_generated_field = "41F19F2D8C745871D17F5F9D098B77CB")

    private Message mButtonNegativeMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "42F562B750FB94F752CED2D5A7D96F4A", hash_generated_field = "C9AFBBF32C64214706F68A15A4CC359B")

    private Button mButtonNeutral;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "02A0EAFE8EF65C34F613FD654D297098", hash_generated_field = "16D3F864CF92B4D23F4B348C46186A72")

    private CharSequence mButtonNeutralText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "A8DB47DDFD50DC1DB5355A07E37A1C74", hash_generated_field = "DE3A282A2612C858747AAF0293D78E5E")

    private Message mButtonNeutralMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "742BD4BD054C4DB97746CDC3A67828A6", hash_generated_field = "48D52DD8E91130A1127C5E6751BAFC93")

    private ScrollView mScrollView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "9329C54D0A335D1F39ACADDA890BE9BF", hash_generated_field = "B9362750FD7578B98AC9480BFD1C22E4")

    private int mIconId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

    private ImageView mIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "768B4DEF5F289C647A0FFACAF09B88CB", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "8D3447425F259899E340C82F15B1EF12", hash_generated_field = "E82D7636327F928026C806257B855F78")

    private View mCustomTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "1C487D484535FC8A97D2E914DF5BE34E", hash_generated_field = "5757562CC2DDACDF9B83AC60F3588BE8")

    private boolean mForceInverseBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.887 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "A2C57E1A405B74F862E9C4EE2D8802BC", hash_generated_field = "7A33F03E17B63A6DBC30C9361577261E")

    private int mCheckedItem = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "C7233221258077AFF87568AE23D21DC7", hash_generated_field = "C70E5EEEC2873FFD1D1516A4074C73D3")

    private int mAlertDialogLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "30EB1DE4C06AF6D6E7B3DAB8786D2F90", hash_generated_field = "386A7DC9605332794254886861F5C37D")

    private int mListLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "F636C3082B858731F5363B1354BED39E", hash_generated_field = "8704F6656CC8C6AA48BBAD3808E8165C")

    private int mMultiChoiceItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "7220B540F0497331D9152B9E4D69FA83", hash_generated_field = "482A719AFBD82F78F9D4411A75756FC3")

    private int mSingleChoiceItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "48D561BAD63D4E9CABCA21962B404CFD", hash_generated_field = "E1CB1AD1E8153C313B8B64994AF8C7E5")

    private int mListItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.888 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.870 -0400", hash_original_field = "64F9D11F1E11AE4CE243EDB97198552B", hash_generated_field = "A4A348A11ABF8F43A17AFAE144216A4B")

    View.OnClickListener mButtonHandler = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.870 -0400", hash_original_method = "23692F5F6532A376A1C310E4C1F7AE36", hash_generated_method = "C93E9241920A99CF968E82D80BD17750")
        public void onClick(View v) {
            
            Message m = null;
            {
                m = Message.obtain(mButtonPositiveMessage);
            } 
            {
                m = Message.obtain(mButtonNegativeMessage);
            } 
            {
                m = Message.obtain(mButtonNeutralMessage);
            } 
            {
                m.sendToTarget();
            } 
            mHandler.obtainMessage(ButtonHandler.MSG_DISMISS_DIALOG, mDialogInterface)
                    .sendToTarget();
            addTaint(v.getTaint());
            
            
            
                
            
                
            
                
            
            
                
            
            
                    
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.890 -0400", hash_original_method = "1F16FD36E11C30DD7C480C9A0A11F40F", hash_generated_method = "DFBC9F682E66FF7187788968A9D5DC2F")
    public  AlertController(Context context, DialogInterface di, Window window) {
        mContext = context;
        mDialogInterface = di;
        mWindow = window;
        mHandler = new ButtonHandler(di);
        TypedArray a = context.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);
        mAlertDialogLayout = a.getResourceId(com.android.internal.R.styleable.AlertDialog_layout,
                com.android.internal.R.layout.alert_dialog);
        mListLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listLayout,
                com.android.internal.R.layout.select_dialog);
        mMultiChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_multiChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_multichoice);
        mSingleChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_singleChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_singlechoice);
        mListItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listItemLayout,
                com.android.internal.R.layout.select_dialog_item);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogCenterButtons,
                outValue, true);
        return outValue.data != 0;
    }

    
    @DSModeled(DSC.SPEC)
    static boolean canTextInput(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup vg = (ViewGroup)v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            v = vg.getChildAt(i);
            if (canTextInput(v)) {
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.891 -0400", hash_original_method = "9A4AA3E1D6FBAA7AEFBA0C5C78FA5BFD", hash_generated_method = "859ADF5F3CE51944AF3FB43100541FDD")
    public void installContent() {
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        if(mView == null || !canTextInput(mView))        
        {
            mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        } //End block
        mWindow.setContentView(mAlertDialogLayout);
        setupView();
        // ---------- Original Method ----------
        //mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        //if (mView == null || !canTextInput(mView)) {
            //mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    //WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        //}
        //mWindow.setContentView(mAlertDialogLayout);
        //setupView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.892 -0400", hash_original_method = "27E388CB8AFA6CAD5DDDE89F3EB645E1", hash_generated_method = "99034EDF81223EE300730CC7AA6ADA86")
    public void setTitle(CharSequence title) {
        mTitle = title;
        if(mTitleView != null)        
        {
            mTitleView.setText(title);
        } //End block
        // ---------- Original Method ----------
        //mTitle = title;
        //if (mTitleView != null) {
            //mTitleView.setText(title);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.892 -0400", hash_original_method = "94C17D404D39F375178D63AA6F858393", hash_generated_method = "9AE38CE4ED732D893D2FAE27057216F6")
    public void setCustomTitle(View customTitleView) {
        mCustomTitleView = customTitleView;
        // ---------- Original Method ----------
        //mCustomTitleView = customTitleView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.892 -0400", hash_original_method = "BE4B8F8527E733138AAA8E77FCFD81CC", hash_generated_method = "FA9834353B2D93C4C845DF619C31B3E6")
    public void setMessage(CharSequence message) {
        mMessage = message;
        if(mMessageView != null)        
        {
            mMessageView.setText(message);
        } //End block
        // ---------- Original Method ----------
        //mMessage = message;
        //if (mMessageView != null) {
            //mMessageView.setText(message);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.893 -0400", hash_original_method = "042A2BE3A9972DB9108969963EFE2152", hash_generated_method = "1380E8C1F04845590815286ECEC42D4D")
    public void setView(View view) {
        mView = view;
        mViewSpacingSpecified = false;
        // ---------- Original Method ----------
        //mView = view;
        //mViewSpacingSpecified = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.894 -0400", hash_original_method = "2847E990E96B77DB4BD87DDDB577F2D4", hash_generated_method = "C1AF1001A46546F3ACEDC1DB21C0A963")
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        mView = view;
        mViewSpacingSpecified = true;
        mViewSpacingLeft = viewSpacingLeft;
        mViewSpacingTop = viewSpacingTop;
        mViewSpacingRight = viewSpacingRight;
        mViewSpacingBottom = viewSpacingBottom;
        // ---------- Original Method ----------
        //mView = view;
        //mViewSpacingSpecified = true;
        //mViewSpacingLeft = viewSpacingLeft;
        //mViewSpacingTop = viewSpacingTop;
        //mViewSpacingRight = viewSpacingRight;
        //mViewSpacingBottom = viewSpacingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.895 -0400", hash_original_method = "F0CE922A10C717C707A211DED1E4F7AA", hash_generated_method = "224AB3EEC28B8A3A62E6EC31F8A9E80F")
    public void setButton(int whichButton, CharSequence text,
            DialogInterface.OnClickListener listener, Message msg) {
        addTaint(listener.getTaint());
        addTaint(whichButton);
        if(msg == null && listener != null)        
        {
            msg = mHandler.obtainMessage(whichButton, listener);
        } //End block
switch(whichButton){
        case DialogInterface.BUTTON_POSITIVE:
        mButtonPositiveText = text;
        mButtonPositiveMessage = msg;
        break;
        case DialogInterface.BUTTON_NEGATIVE:
        mButtonNegativeText = text;
        mButtonNegativeMessage = msg;
        break;
        case DialogInterface.BUTTON_NEUTRAL:
        mButtonNeutralText = text;
        mButtonNeutralMessage = msg;
        break;
        default:
        IllegalArgumentException var661B5FFF38B2C82FCB833501EEADAC79_752164148 = new IllegalArgumentException("Button does not exist");
        var661B5FFF38B2C82FCB833501EEADAC79_752164148.addTaint(taint);
        throw var661B5FFF38B2C82FCB833501EEADAC79_752164148;
}
        // ---------- Original Method ----------
        //if (msg == null && listener != null) {
            //msg = mHandler.obtainMessage(whichButton, listener);
        //}
        //switch (whichButton) {
            //case DialogInterface.BUTTON_POSITIVE:
                //mButtonPositiveText = text;
                //mButtonPositiveMessage = msg;
                //break;
            //case DialogInterface.BUTTON_NEGATIVE:
                //mButtonNegativeText = text;
                //mButtonNegativeMessage = msg;
                //break;
            //case DialogInterface.BUTTON_NEUTRAL:
                //mButtonNeutralText = text;
                //mButtonNeutralMessage = msg;
                //break;
            //default:
                //throw new IllegalArgumentException("Button does not exist");
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "FB4271E4605E30D98972B290FB7DEC88", hash_generated_method = "64DA2043EAACEF45E7481B1A047D3916")
    public void setIcon(int resId) {
        mIconId = resId;
        if(mIconView != null)        
        {
            if(resId > 0)            
            {
                mIconView.setImageResource(mIconId);
            } //End block
            else
            if(resId == 0)            
            {
                mIconView.setVisibility(View.GONE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mIconId = resId;
        //if (mIconView != null) {
            //if (resId > 0) {
                //mIconView.setImageResource(mIconId);
            //} else if (resId == 0) {
                //mIconView.setVisibility(View.GONE);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "5C2407A3F3458DD1635D398D03E8F03F", hash_generated_method = "5F3F6BBEB99C48A445515D28F9602DEB")
    public void setIcon(Drawable icon) {
        mIcon = icon;
        if((mIconView != null) && (mIcon != null))        
        {
            mIconView.setImageDrawable(icon);
        } //End block
        // ---------- Original Method ----------
        //mIcon = icon;
        //if ((mIconView != null) && (mIcon != null)) {
            //mIconView.setImageDrawable(icon);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "19D779B93DDFF4465E595606B06C3EFE", hash_generated_method = "2877CEF8117E45CC2D5B31E05B27DD1D")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mForceInverseBackground = forceInverseBackground;
        // ---------- Original Method ----------
        //mForceInverseBackground = forceInverseBackground;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "3273CA9467A607A59D9BD9C18D0394BC", hash_generated_method = "FA5BED84660DC1465C4522F7546855D4")
    public ListView getListView() {
ListView varD1B2FEEA91DDD2A777490FD0D2D97D45_1345938530 =         mListView;
        varD1B2FEEA91DDD2A777490FD0D2D97D45_1345938530.addTaint(taint);
        return varD1B2FEEA91DDD2A777490FD0D2D97D45_1345938530;
        // ---------- Original Method ----------
        //return mListView;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "3833583B80F66F9531985629B1AE2E3F", hash_generated_method = "57A54B81D6B88CA8FEEF423F6757CF8D")
    public Button getButton(int whichButton) {
        addTaint(whichButton);
switch(whichButton){
        case DialogInterface.BUTTON_POSITIVE:
Button varCEA403552DDCF28E114F36E0C0116424_687821655 =         mButtonPositive;
        varCEA403552DDCF28E114F36E0C0116424_687821655.addTaint(taint);
        return varCEA403552DDCF28E114F36E0C0116424_687821655;
        case DialogInterface.BUTTON_NEGATIVE:
Button varCC93FB29A1F065700EBB344490FE7FFB_959245534 =         mButtonNegative;
        varCC93FB29A1F065700EBB344490FE7FFB_959245534.addTaint(taint);
        return varCC93FB29A1F065700EBB344490FE7FFB_959245534;
        case DialogInterface.BUTTON_NEUTRAL:
Button var2757E8E54B8DD4F72782D88CF7B1E31D_963433509 =         mButtonNeutral;
        var2757E8E54B8DD4F72782D88CF7B1E31D_963433509.addTaint(taint);
        return var2757E8E54B8DD4F72782D88CF7B1E31D_963433509;
        default:
Button var540C13E9E156B687226421B24F2DF178_1888362512 =         null;
        var540C13E9E156B687226421B24F2DF178_1888362512.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1888362512;
}
        // ---------- Original Method ----------
        //switch (whichButton) {
            //case DialogInterface.BUTTON_POSITIVE:
                //return mButtonPositive;
            //case DialogInterface.BUTTON_NEGATIVE:
                //return mButtonNegative;
            //case DialogInterface.BUTTON_NEUTRAL:
                //return mButtonNeutral;
            //default:
                //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "B7833AF2811E127AB8391879126162ED", hash_generated_method = "52F6C7EC45C1AA598C3C8141DDB62E07")
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var85C3250DB4E2765E09048811225B4E8E_1090294293 = (mScrollView != null && mScrollView.executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373173223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373173223;
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.896 -0400", hash_original_method = "98FE899904FE72C0DB5091897F5A09B0", hash_generated_method = "563F9811B2429B42AB2E66BA8DFD6E62")
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var85C3250DB4E2765E09048811225B4E8E_1280434167 = (mScrollView != null && mScrollView.executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697512437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_697512437;
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.897 -0400", hash_original_method = "0CE32455CB333C36B4EB85B89D65D186", hash_generated_method = "AE804F87FF9C732A76621C7D609125EF")
    private void setupView() {
        LinearLayout contentPanel = (LinearLayout) mWindow.findViewById(R.id.contentPanel);
        setupContent(contentPanel);
        boolean hasButtons = setupButtons();
        LinearLayout topPanel = (LinearLayout) mWindow.findViewById(R.id.topPanel);
        TypedArray a = mContext.obtainStyledAttributes(
                null, com.android.internal.R.styleable.AlertDialog, com.android.internal.R.attr.alertDialogStyle, 0);
        boolean hasTitle = setupTitle(topPanel);
        View buttonPanel = mWindow.findViewById(R.id.buttonPanel);
        if(!hasButtons)        
        {
            buttonPanel.setVisibility(View.GONE);
            mWindow.setCloseOnTouchOutsideIfNotSet(true);
        } //End block
        FrameLayout customPanel = null;
        if(mView != null)        
        {
            customPanel = (FrameLayout) mWindow.findViewById(R.id.customPanel);
            FrameLayout custom = (FrameLayout) mWindow.findViewById(R.id.custom);
            custom.addView(mView, new LayoutParams(MATCH_PARENT, MATCH_PARENT));
            if(mViewSpacingSpecified)            
            {
                custom.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                        mViewSpacingBottom);
            } //End block
            if(mListView != null)            
            {
                ((LinearLayout.LayoutParams) customPanel.getLayoutParams()).weight = 0;
            } //End block
        } //End block
        else
        {
            mWindow.findViewById(R.id.customPanel).setVisibility(View.GONE);
        } //End block
        if(hasTitle)        
        {
            View divider = null;
            if(mMessage != null || mView != null || mListView != null)            
            {
                divider = mWindow.findViewById(R.id.titleDivider);
            } //End block
            else
            {
                divider = mWindow.findViewById(R.id.titleDividerTop);
            } //End block
            if(divider != null)            
            {
                divider.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        setBackground(topPanel, contentPanel, customPanel, hasButtons, a, hasTitle, buttonPanel);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.897 -0400", hash_original_method = "291261EC5A45F15B0AF035A0FADD9120", hash_generated_method = "56CBB8368035EDEE4FCD9C988D6A418C")
    private boolean setupTitle(LinearLayout topPanel) {
        addTaint(topPanel.getTaint());
        boolean hasTitle = true;
        if(mCustomTitleView != null)        
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            topPanel.addView(mCustomTitleView, 0, lp);
            View titleTemplate = mWindow.findViewById(R.id.title_template);
            titleTemplate.setVisibility(View.GONE);
        } //End block
        else
        {
            final boolean hasTextTitle = !TextUtils.isEmpty(mTitle);
            mIconView = (ImageView) mWindow.findViewById(R.id.icon);
            if(hasTextTitle)            
            {
                mTitleView = (TextView) mWindow.findViewById(R.id.alertTitle);
                mTitleView.setText(mTitle);
                if(mIconId > 0)                
                {
                    mIconView.setImageResource(mIconId);
                } //End block
                else
                if(mIcon != null)                
                {
                    mIconView.setImageDrawable(mIcon);
                } //End block
                else
                if(mIconId == 0)                
                {
                    mTitleView.setPadding(mIconView.getPaddingLeft(),
                            mIconView.getPaddingTop(),
                            mIconView.getPaddingRight(),
                            mIconView.getPaddingBottom());
                    mIconView.setVisibility(View.GONE);
                } //End block
            } //End block
            else
            {
                View titleTemplate = mWindow.findViewById(R.id.title_template);
                titleTemplate.setVisibility(View.GONE);
                mIconView.setVisibility(View.GONE);
                topPanel.setVisibility(View.GONE);
                hasTitle = false;
            } //End block
        } //End block
        boolean var6F1AA56C3249B71AB948A281BD122769_958219270 = (hasTitle);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094336854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094336854;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.898 -0400", hash_original_method = "887622C8B8EC01B1F9012F53B044827B", hash_generated_method = "F359A7C03078FD262952FA0D9953A7A2")
    private void setupContent(LinearLayout contentPanel) {
        addTaint(contentPanel.getTaint());
        mScrollView = (ScrollView) mWindow.findViewById(R.id.scrollView);
        mScrollView.setFocusable(false);
        mMessageView = (TextView) mWindow.findViewById(R.id.message);
        if(mMessageView == null)        
        {
            return;
        } //End block
        if(mMessage != null)        
        {
            mMessageView.setText(mMessage);
        } //End block
        else
        {
            mMessageView.setVisibility(View.GONE);
            mScrollView.removeView(mMessageView);
            if(mListView != null)            
            {
                contentPanel.removeView(mWindow.findViewById(R.id.scrollView));
                contentPanel.addView(mListView,
                        new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
                contentPanel.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 0, 1.0f));
            } //End block
            else
            {
                contentPanel.setVisibility(View.GONE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.899 -0400", hash_original_method = "5BA34AF0614F863A3B9D6C4A8679B5AF", hash_generated_method = "014BA26BCABE890F37A941C8F0696704")
    private boolean setupButtons() {
        int BIT_BUTTON_POSITIVE = 1;
        int BIT_BUTTON_NEGATIVE = 2;
        int BIT_BUTTON_NEUTRAL = 4;
        int whichButtons = 0;
        mButtonPositive = (Button) mWindow.findViewById(R.id.button1);
        mButtonPositive.setOnClickListener(mButtonHandler);
        if(TextUtils.isEmpty(mButtonPositiveText))        
        {
            mButtonPositive.setVisibility(View.GONE);
        } //End block
        else
        {
            mButtonPositive.setText(mButtonPositiveText);
            mButtonPositive.setVisibility(View.VISIBLE);
            whichButtons = whichButtons | BIT_BUTTON_POSITIVE;
        } //End block
        mButtonNegative = (Button) mWindow.findViewById(R.id.button2);
        mButtonNegative.setOnClickListener(mButtonHandler);
        if(TextUtils.isEmpty(mButtonNegativeText))        
        {
            mButtonNegative.setVisibility(View.GONE);
        } //End block
        else
        {
            mButtonNegative.setText(mButtonNegativeText);
            mButtonNegative.setVisibility(View.VISIBLE);
            whichButtons = whichButtons | BIT_BUTTON_NEGATIVE;
        } //End block
        mButtonNeutral = (Button) mWindow.findViewById(R.id.button3);
        mButtonNeutral.setOnClickListener(mButtonHandler);
        if(TextUtils.isEmpty(mButtonNeutralText))        
        {
            mButtonNeutral.setVisibility(View.GONE);
        } //End block
        else
        {
            mButtonNeutral.setText(mButtonNeutralText);
            mButtonNeutral.setVisibility(View.VISIBLE);
            whichButtons = whichButtons | BIT_BUTTON_NEUTRAL;
        } //End block
        if(shouldCenterSingleButton(mContext))        
        {
            if(whichButtons == BIT_BUTTON_POSITIVE)            
            {
                centerButton(mButtonPositive);
            } //End block
            else
            if(whichButtons == BIT_BUTTON_NEGATIVE)            
            {
                centerButton(mButtonNeutral);
            } //End block
            else
            if(whichButtons == BIT_BUTTON_NEUTRAL)            
            {
                centerButton(mButtonNeutral);
            } //End block
        } //End block
        boolean var19F38614A10EED603262B286E33EAB06_399186378 = (whichButtons != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523800936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523800936;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.900 -0400", hash_original_method = "28BC3CB500322D129CBA8E7C7A78AD5A", hash_generated_method = "949041D966EAE0F7020A1C774161C6B8")
    private void centerButton(Button button) {
        addTaint(button.getTaint());
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.weight = 0.5f;
        button.setLayoutParams(params);
        View leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        if(leftSpacer != null)        
        {
            leftSpacer.setVisibility(View.VISIBLE);
        } //End block
        View rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        if(rightSpacer != null)        
        {
            rightSpacer.setVisibility(View.VISIBLE);
        } //End block
        // ---------- Original Method ----------
        //LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        //params.gravity = Gravity.CENTER_HORIZONTAL;
        //params.weight = 0.5f;
        //button.setLayoutParams(params);
        //View leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        //if (leftSpacer != null) {
            //leftSpacer.setVisibility(View.VISIBLE);
        //}
        //View rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        //if (rightSpacer != null) {
            //rightSpacer.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.901 -0400", hash_original_method = "6198B5046244FDCE77443F1833B74949", hash_generated_method = "92E795C6584D29684A7A24905B121C7C")
    private void setBackground(LinearLayout topPanel, LinearLayout contentPanel,
            View customPanel, boolean hasButtons, TypedArray a, boolean hasTitle, 
            View buttonPanel) {
        addTaint(buttonPanel.getTaint());
        addTaint(hasTitle);
        addTaint(a.getTaint());
        addTaint(hasButtons);
        addTaint(customPanel.getTaint());
        addTaint(contentPanel.getTaint());
        addTaint(topPanel.getTaint());
        int fullDark = a.getResourceId(
                R.styleable.AlertDialog_fullDark, R.drawable.popup_full_dark);
        int topDark = a.getResourceId(
                R.styleable.AlertDialog_topDark, R.drawable.popup_top_dark);
        int centerDark = a.getResourceId(
                R.styleable.AlertDialog_centerDark, R.drawable.popup_center_dark);
        int bottomDark = a.getResourceId(
                R.styleable.AlertDialog_bottomDark, R.drawable.popup_bottom_dark);
        int fullBright = a.getResourceId(
                R.styleable.AlertDialog_fullBright, R.drawable.popup_full_bright);
        int topBright = a.getResourceId(
                R.styleable.AlertDialog_topBright, R.drawable.popup_top_bright);
        int centerBright = a.getResourceId(
                R.styleable.AlertDialog_centerBright, R.drawable.popup_center_bright);
        int bottomBright = a.getResourceId(
                R.styleable.AlertDialog_bottomBright, R.drawable.popup_bottom_bright);
        int bottomMedium = a.getResourceId(
                R.styleable.AlertDialog_bottomMedium, R.drawable.popup_bottom_medium);
        View[] views = new View[4];
        boolean[] light = new boolean[4];
        View lastView = null;
        boolean lastLight = false;
        int pos = 0;
        if(hasTitle)        
        {
            views[pos] = topPanel;
            light[pos] = false;
            pos++;
        } //End block
        views[pos] = (contentPanel.getVisibility() == View.GONE) 
                ? null : contentPanel;
        light[pos] = mListView != null;
        pos++;
        if(customPanel != null)        
        {
            views[pos] = customPanel;
            light[pos] = mForceInverseBackground;
            pos++;
        } //End block
        if(hasButtons)        
        {
            views[pos] = buttonPanel;
            light[pos] = true;
        } //End block
        boolean setView = false;
for(pos=0;pos<views.length;pos++)
        {
            View v = views[pos];
            if(v == null)            
            {
                continue;
            } //End block
            if(lastView != null)            
            {
                if(!setView)                
                {
                    lastView.setBackgroundResource(lastLight ? topBright : topDark);
                } //End block
                else
                {
                    lastView.setBackgroundResource(lastLight ? centerBright : centerDark);
                } //End block
                setView = true;
            } //End block
            lastView = v;
            lastLight = light[pos];
        } //End block
        if(lastView != null)        
        {
            if(setView)            
            {
                lastView.setBackgroundResource(
                        lastLight ? (hasButtons ? bottomMedium : bottomBright) : bottomDark);
            } //End block
            else
            {
                lastView.setBackgroundResource(lastLight ? fullBright : fullDark);
            } //End block
        } //End block
        if((mListView != null) && (mAdapter != null))        
        {
            mListView.setAdapter(mAdapter);
            if(mCheckedItem > -1)            
            {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class ButtonHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.901 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.901 -0400", hash_original_method = "94BD8A25739D33DF469E488FF271595A", hash_generated_method = "4185F310EECDDCDB1822BCA414EA5D62")
        public  ButtonHandler(DialogInterface dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_method = "278B02327B6D097A80A5697E74542815", hash_generated_method = "64745579D50BDC6C685010CF9CF4324F")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case DialogInterface.BUTTON_POSITIVE:
            case DialogInterface.BUTTON_NEGATIVE:
            case DialogInterface.BUTTON_NEUTRAL:
            ((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
            break;
            case MSG_DISMISS_DIALOG:
            ((DialogInterface) msg.obj).dismiss();
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case DialogInterface.BUTTON_POSITIVE:
                //case DialogInterface.BUTTON_NEGATIVE:
                //case DialogInterface.BUTTON_NEUTRAL:
                    //((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
                    //break;
                //case MSG_DISMISS_DIALOG:
                    //((DialogInterface) msg.obj).dismiss();
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "9C7A29A1867BAE0555E957D87915449A", hash_generated_field = "837E07B94F9B99EC5A8E2663317A1F02")

        private static final int MSG_DISMISS_DIALOG = 1;
    }


    
    public static class RecycleListView extends ListView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "EEFDF834178AFE02FE8117D28C71CF20", hash_generated_field = "3DD4A4EF0D713F0ADFB04515FD02F627")

        boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_method = "EE9FD5306D2F93DFDAA34BAADCE625A8", hash_generated_method = "9DC75BF16ABC669F3AA08697B9DBBF0A")
        public  RecycleListView(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_method = "FD9F3D8D98E58119FCDEC82734593D0D", hash_generated_method = "89CC3056B21BFD4D3EF37F5A44EA57E5")
        public  RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_method = "B696B9456EBFFE7A743BD389E8B7B605", hash_generated_method = "B5A4A17DE1430AEE76B00ABB7D830C28")
        public  RecycleListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            addTaint(defStyle);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_method = "9DCA0509220194E0D65C0AA0793BD261", hash_generated_method = "9C7D50EF2D7B756C8AE27DA7A31F1250")
        @Override
        protected boolean recycleOnMeasure() {
            boolean varA222FEC0D8C8BFB88171658E6BDCDBB1_1611336528 = (mRecycleOnMeasure);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_302531905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_302531905;
            // ---------- Original Method ----------
            //return mRecycleOnMeasure;
        }

        
    }


    
    public static class AlertParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

        public Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "26B6EDB1B2B17244BBBF36956F817F15")

        public LayoutInflater mInflater;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "3E3764214A015E132F5BD47D9BC8E0B7", hash_generated_field = "C2DC3CCA222E71D43D27ECAB851034A0")

        public int mIconId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "E5243F47D3999E8E6530788895E90100")

        public Drawable mIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.902 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "04F7F9DD6D2510CBB15DFDFFE1807D8E")

        public CharSequence mTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "8D3447425F259899E340C82F15B1EF12", hash_generated_field = "814166582DF1A24C00D1625C5488672A")

        public View mCustomTitleView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "E05582EF743E1ACAA4AA9356CB30BC94")

        public CharSequence mMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "EF6BA7E2934EE938E1075151D930563A", hash_generated_field = "2CA24C7B094B26BA6E936F6BBC901F5D")

        public CharSequence mPositiveButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "14D30E0C536B9FAFB9EB169A4742623E", hash_generated_field = "1BE202C2CAD8DB621DCDD3372ED2D171")

        public DialogInterface.OnClickListener mPositiveButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "480C6129BEBC705E36C19ADB4B0F8B3C", hash_generated_field = "2D3FBAA9E0AD2228B46D75FBECE56655")

        public CharSequence mNegativeButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "DB0BCBC46B1D543C8137D88883360FDF", hash_generated_field = "B8D1F988895A94C1B77F97F848992793")

        public DialogInterface.OnClickListener mNegativeButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "74FB7576A510184675BE65231720E60C", hash_generated_field = "C67CE1D73A0301923AC9C0DDF272716F")

        public CharSequence mNeutralButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "B67A046222E4A19F7183D5F929307B28", hash_generated_field = "C6F2573A08FEF0DF77F903DEE8742754")

        public DialogInterface.OnClickListener mNeutralButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "895157BE8E63EE5D1276B7D79E82D10B", hash_generated_field = "690DB816AF9947EBA54C6AD5450363A0")

        public boolean mCancelable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "3FB4AF9CA69AF46ED977BB7342A8B1AB", hash_generated_field = "D57560FB4E6739D7CCFF128C31469BB1")

        public DialogInterface.OnCancelListener mOnCancelListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "CA7076FF3B23B43DA0C003C9464E1AB3")

        public DialogInterface.OnKeyListener mOnKeyListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "770D760EB2D47D87B74F516C630F54A9")

        public CharSequence[] mItems;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "25FA7FD85E13A481D223BDA4FAF494D1")

        public ListAdapter mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "D617C33C039CBCFD65B3C22DBA07CFF5")

        public DialogInterface.OnClickListener mOnClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6C373AA66951237B18143051CA3FC35A")

        public View mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "1118F3E1721DAF8FB4872146DA12E56F", hash_generated_field = "133421CFB34A08A745D0DABDF172D654")

        public int mViewSpacingLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "E7238771FCAB61AE32E851A5F82687D8", hash_generated_field = "AACBB04D340CCDFCD16549D9477D1053")

        public int mViewSpacingTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "D8563F961A4F1D04632FC413D194B935", hash_generated_field = "B5693872E335B49FF25BCA5D1000771A")

        public int mViewSpacingRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "7686141D1F92DBAA062C3A41CF84AF7D", hash_generated_field = "16138D3B0F72ADA1373081D480EF4F2A")

        public int mViewSpacingBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "9516D9606C5F2B9AA236056257DD4D2C", hash_generated_field = "15FC623F24AED707F20028F138CB4155")

        public boolean mViewSpacingSpecified = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "226005F926E9D782070A79CF1A4B053C", hash_generated_field = "34261E0AFA1935DD7182F7BE1D273C66")

        public boolean[] mCheckedItems;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "3367E3A98A655AF3148902A101B93604", hash_generated_field = "2928823CCF761707AADE97A3C31F0E37")

        public boolean mIsMultiChoice;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "7924285A5210ACFFD6981B4B89F826F1", hash_generated_field = "264C969397A5870832FCC712B67D9AED")

        public boolean mIsSingleChoice;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "A2C57E1A405B74F862E9C4EE2D8802BC", hash_generated_field = "B28C90765377E391E20D88849A9B1FCD")

        public int mCheckedItem = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "E90DDAAFA67CE915947F43C5BD0B1329", hash_generated_field = "C1D53F530A35F1502CC3200362215D8B")

        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6691A457869D5E472564204CDF0EADCB")

        public Cursor mCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "10A803290AD7773E329F678004D91D34", hash_generated_field = "8663F263214822FF04034DE81B9E539F")

        public String mLabelColumn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "CBF8F9FD70EDD094D7E542C4739E6288", hash_generated_field = "D868CCDF8866E0B4C22A7B4AB9003B23")

        public String mIsCheckedColumn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "1C487D484535FC8A97D2E914DF5BE34E", hash_generated_field = "CEBAA7027B15CFA5FFECBE008E938B45")

        public boolean mForceInverseBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "773B78B8354D6C9F88CCABB4FB2C5772", hash_generated_field = "E0E2BC3A5346F1A907B72B36F89366E0")

        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "E15AD44F9720EAFA479AD8F9FB960029", hash_generated_field = "3AB01332941910606794E5FE4F180916")

        public OnPrepareListViewListener mOnPrepareListViewListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.903 -0400", hash_original_field = "EEFDF834178AFE02FE8117D28C71CF20", hash_generated_field = "D4A086061D2FEBA35D1D1938D92E949F")

        public boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.904 -0400", hash_original_method = "30F42D5772B75365825E237386B4299E", hash_generated_method = "CF26A7D12C986291CBAD02E9F9FA57B8")
        public  AlertParams(Context context) {
            mContext = context;
            mCancelable = true;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // ---------- Original Method ----------
            //mContext = context;
            //mCancelable = true;
            //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.904 -0400", hash_original_method = "80497DB7CC0D98B7F92FD843E557F0AA", hash_generated_method = "728B1E6D7CE5A8064263FCBDDE2875DF")
        public void apply(AlertController dialog) {
            addTaint(dialog.getTaint());
            if(mCustomTitleView != null)            
            {
                dialog.setCustomTitle(mCustomTitleView);
            } //End block
            else
            {
                if(mTitle != null)                
                {
                    dialog.setTitle(mTitle);
                } //End block
                if(mIcon != null)                
                {
                    dialog.setIcon(mIcon);
                } //End block
                if(mIconId >= 0)                
                {
                    dialog.setIcon(mIconId);
                } //End block
            } //End block
            if(mMessage != null)            
            {
                dialog.setMessage(mMessage);
            } //End block
            if(mPositiveButtonText != null)            
            {
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, mPositiveButtonText,
                        mPositiveButtonListener, null);
            } //End block
            if(mNegativeButtonText != null)            
            {
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, mNegativeButtonText,
                        mNegativeButtonListener, null);
            } //End block
            if(mNeutralButtonText != null)            
            {
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, mNeutralButtonText,
                        mNeutralButtonListener, null);
            } //End block
            if(mForceInverseBackground)            
            {
                dialog.setInverseBackgroundForced(true);
            } //End block
            if((mItems != null) || (mCursor != null) || (mAdapter != null))            
            {
                createListView(dialog);
            } //End block
            if(mView != null)            
            {
                if(mViewSpacingSpecified)                
                {
                    dialog.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                            mViewSpacingBottom);
                } //End block
                else
                {
                    dialog.setView(mView);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.909 -0400", hash_original_method = "8E786D28D6E36F7AAC42E3AE032D9CF8", hash_generated_method = "5413B48DB0A86CB2A67A914F80BCEDF2")
        private void createListView(final AlertController dialog) {
            final RecycleListView listView = (RecycleListView)
                    mInflater.inflate(dialog.mListLayout, null);
            ListAdapter adapter;
            if(mIsMultiChoice)            
            {
                if(mCursor == null)                
                {
                    adapter = new ArrayAdapter<CharSequence>(
                            mContext, dialog.mMultiChoiceItemLayout, R.id.text1, mItems) {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.905 -0400", hash_original_method = "23A354B1E3F11023EC3EF5623A4E6D9E", hash_generated_method = "31EF9650D9ABA521E2AB88DBE1FF4338")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                addTaint(parent.getTaint());
                addTaint(convertView.getTaint());
                addTaint(position);
                View view = super.getView(position, convertView, parent);
                if(mCheckedItems != null)                
                {
                    boolean isItemChecked = mCheckedItems[position];
                    if(isItemChecked)                    
                    {
                        listView.setItemChecked(position, true);
                    } //End block
                } //End block
View var057D265746AE9672AFE5F9FF6338071D_1051870120 =                 view;
                var057D265746AE9672AFE5F9FF6338071D_1051870120.addTaint(taint);
                return var057D265746AE9672AFE5F9FF6338071D_1051870120;
                // ---------- Original Method ----------
                //View view = super.getView(position, convertView, parent);
                //if (mCheckedItems != null) {
                                //boolean isItemChecked = mCheckedItems[position];
                                //if (isItemChecked) {
                                    //listView.setItemChecked(position, true);
                                //}
                            //}
                //return view;
            }
};
                } //End block
                else
                {
                    adapter = new CursorAdapter(mContext, mCursor, false) {            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.906 -0400", hash_original_field = "5ED5AAFE00FF0DB57B0F6F660CFDC780", hash_generated_field = "6AE1690622EE66BC1693CD9F6D6F3F96")
            private int mLabelIndex;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.906 -0400", hash_original_field = "E79E3F680505689336A5849A5AC0B273", hash_generated_field = "671FFD450B2DD86945A5580E97F76CDA")
            private int mIsCheckedIndex;
            {
                            final Cursor cursor = getCursor();
                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
                        }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.907 -0400", hash_original_method = "9923C63783513415221DB53D1A04C6D7", hash_generated_method = "A18EBC5E24A1CA6072668D82FF83494B")
            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                addTaint(cursor.getTaint());
                addTaint(context.getTaint());
                addTaint(view.getTaint());
                CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                text.setText(cursor.getString(mLabelIndex));
                listView.setItemChecked(cursor.getPosition(),
                                    cursor.getInt(mIsCheckedIndex) == 1);
                // ---------- Original Method ----------
                //CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                //text.setText(cursor.getString(mLabelIndex));
                //listView.setItemChecked(cursor.getPosition(),
                                    //cursor.getInt(mIsCheckedIndex) == 1);
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.907 -0400", hash_original_method = "87A8136D8ED8F9724DD65BD87F7B3B3A", hash_generated_method = "AF0B21A5393ABC6D9F5DBF930E17DE2C")
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                addTaint(parent.getTaint());
                addTaint(cursor.getTaint());
                addTaint(context.getTaint());
View varA4A56AFDB09A7DD3F399605CCE039BDA_2017821537 =                 mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    parent, false);
                varA4A56AFDB09A7DD3F399605CCE039BDA_2017821537.addTaint(taint);
                return varA4A56AFDB09A7DD3F399605CCE039BDA_2017821537;
                // ---------- Original Method ----------
                //return mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    //parent, false);
            }
};
                } //End block
            } //End block
            else
            {
                int layout = mIsSingleChoice 
                        ? dialog.mSingleChoiceItemLayout : dialog.mListItemLayout;
                if(mCursor == null)                
                {
                    adapter = (mAdapter != null) ? mAdapter
                            : new ArrayAdapter<CharSequence>(mContext, layout, R.id.text1, mItems);
                } //End block
                else
                {
                    adapter = new SimpleCursorAdapter(mContext, layout, 
                            mCursor, new String[]{mLabelColumn}, new int[]{R.id.text1});
                } //End block
            } //End block
            if(mOnPrepareListViewListener != null)            
            {
                mOnPrepareListViewListener.onPrepareListView(listView);
            } //End block
            dialog.mAdapter = adapter;
            dialog.mCheckedItem = mCheckedItem;
            if(mOnClickListener != null)            
            {
                listView.setOnItemClickListener(new OnItemClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.908 -0400", hash_original_method = "8EA9AA28841E6789D2A0900FF06F5143", hash_generated_method = "327EA68169D6C6DA06750D340AF01F8D")
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(id);
                addTaint(position);
                addTaint(v.getTaint());
                addTaint(parent.getTaint());
                mOnClickListener.onClick(dialog.mDialogInterface, position);
                if(!mIsSingleChoice)                
                {
                    dialog.mDialogInterface.dismiss();
                } //End block
                // ---------- Original Method ----------
                //mOnClickListener.onClick(dialog.mDialogInterface, position);
                //if (!mIsSingleChoice) {
                            //dialog.mDialogInterface.dismiss();
                        //}
            }
});
            } //End block
            else
            if(mOnCheckboxClickListener != null)            
            {
                listView.setOnItemClickListener(new OnItemClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:09.909 -0400", hash_original_method = "A7D02743B14CEBBCE2076709416E7025", hash_generated_method = "C49D47F54C65B1B37C55B74C400028A4")
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(id);
                addTaint(position);
                addTaint(v.getTaint());
                addTaint(parent.getTaint());
                if(mCheckedItems != null)                
                {
                    mCheckedItems[position] = listView.isItemChecked(position);
                } //End block
                mOnCheckboxClickListener.onClick(
                                dialog.mDialogInterface, position, listView.isItemChecked(position));
                // ---------- Original Method ----------
                //if (mCheckedItems != null) {
                            //mCheckedItems[position] = listView.isItemChecked(position);
                        //}
                //mOnCheckboxClickListener.onClick(
                                //dialog.mDialogInterface, position, listView.isItemChecked(position));
            }
});
            } //End block
            if(mOnItemSelectedListener != null)            
            {
                listView.setOnItemSelectedListener(mOnItemSelectedListener);
            } //End block
            if(mIsSingleChoice)            
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            } //End block
            else
            if(mIsMultiChoice)            
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            } //End block
            listView.mRecycleOnMeasure = mRecycleOnMeasure;
            dialog.mListView = listView;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public interface OnPrepareListViewListener {
            
            
            void onPrepareListView(ListView listView);
        }
        
    }


    
}

