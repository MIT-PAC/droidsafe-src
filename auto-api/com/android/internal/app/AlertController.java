package com.android.internal.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import com.android.internal.R;
import android.app.AlertDialog;
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
import java.lang.ref.WeakReference;

public class AlertController {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "864CF846AE5CEA3E3FF02D8EF1852410", hash_generated_field = "2B4497FE8D3BE69F04001AB183F843A0")

    private DialogInterface mDialogInterface;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "B242999524A78B5E31650BFBB7850632")

    private CharSequence mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

    private ListView mListView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "E606D96B6FC531BB030B680E135C95D0")

    private View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "1118F3E1721DAF8FB4872146DA12E56F", hash_generated_field = "19A8BE4EA4CB90940A5BCBECC9F99055")

    private int mViewSpacingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "E7238771FCAB61AE32E851A5F82687D8", hash_generated_field = "6557ACD495F3B6484326AC57AECFA558")

    private int mViewSpacingTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "D8563F961A4F1D04632FC413D194B935", hash_generated_field = "47FEE73BA7B0F5642CD916931DB4B990")

    private int mViewSpacingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.868 -0400", hash_original_field = "7686141D1F92DBAA062C3A41CF84AF7D", hash_generated_field = "E6D3207EA728175311B7208886F6CFF1")

    private int mViewSpacingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "9516D9606C5F2B9AA236056257DD4D2C", hash_generated_field = "0F9BEABC6DA1B172890E35E612ED5285")

    private boolean mViewSpacingSpecified = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "75F78D14707C729A400B0BE258E854BF", hash_generated_field = "2DE16827139A20C2B2C0D130D64C1F22")

    private Button mButtonPositive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "988E62DDADD4AB2C15DA76094B45A53A", hash_generated_field = "ADEC89EC1C6163464CAB74778BA7F455")

    private CharSequence mButtonPositiveText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "D7558B1B938CF00A65A59E324437A261", hash_generated_field = "4C64AEB4AC17D726F0EC573D273C85E4")

    private Message mButtonPositiveMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "88EA7194116B3A5C3357680B0010372C", hash_generated_field = "B5032704B1FD6BFE5557786C4C3D3EFC")

    private Button mButtonNegative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "F3C8CB7B6AF91B005C215285579E176A", hash_generated_field = "D91959E3DC6E2952E856CD3FA0A399C6")

    private CharSequence mButtonNegativeText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "D83B863ADC3A0C7CA896C00DC3E81E99", hash_generated_field = "41F19F2D8C745871D17F5F9D098B77CB")

    private Message mButtonNegativeMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "42F562B750FB94F752CED2D5A7D96F4A", hash_generated_field = "C9AFBBF32C64214706F68A15A4CC359B")

    private Button mButtonNeutral;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "02A0EAFE8EF65C34F613FD654D297098", hash_generated_field = "16D3F864CF92B4D23F4B348C46186A72")

    private CharSequence mButtonNeutralText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "A8DB47DDFD50DC1DB5355A07E37A1C74", hash_generated_field = "DE3A282A2612C858747AAF0293D78E5E")

    private Message mButtonNeutralMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "742BD4BD054C4DB97746CDC3A67828A6", hash_generated_field = "48D52DD8E91130A1127C5E6751BAFC93")

    private ScrollView mScrollView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "9329C54D0A335D1F39ACADDA890BE9BF", hash_generated_field = "B9362750FD7578B98AC9480BFD1C22E4")

    private int mIconId = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "1BF6A6ADCCEDB69D0EE1AAE044F85531", hash_generated_field = "411E3339296CF54457E86988903AF1A7")

    private ImageView mIconView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "5F3FDB05EE6E2581CC95AB22CADCE47B", hash_generated_field = "3B26FAD098CFEC3A217F2BF71097A83E")

    private TextView mTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "768B4DEF5F289C647A0FFACAF09B88CB", hash_generated_field = "461DDCE97AF551A1C6803EBC4533C15B")

    private TextView mMessageView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "8D3447425F259899E340C82F15B1EF12", hash_generated_field = "E82D7636327F928026C806257B855F78")

    private View mCustomTitleView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "1C487D484535FC8A97D2E914DF5BE34E", hash_generated_field = "5757562CC2DDACDF9B83AC60F3588BE8")

    private boolean mForceInverseBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "A2C57E1A405B74F862E9C4EE2D8802BC", hash_generated_field = "7A33F03E17B63A6DBC30C9361577261E")

    private int mCheckedItem = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "C7233221258077AFF87568AE23D21DC7", hash_generated_field = "C70E5EEEC2873FFD1D1516A4074C73D3")

    private int mAlertDialogLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "30EB1DE4C06AF6D6E7B3DAB8786D2F90", hash_generated_field = "386A7DC9605332794254886861F5C37D")

    private int mListLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "F636C3082B858731F5363B1354BED39E", hash_generated_field = "8704F6656CC8C6AA48BBAD3808E8165C")

    private int mMultiChoiceItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "7220B540F0497331D9152B9E4D69FA83", hash_generated_field = "482A719AFBD82F78F9D4411A75756FC3")

    private int mSingleChoiceItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "48D561BAD63D4E9CABCA21962B404CFD", hash_generated_field = "E1CB1AD1E8153C313B8B64994AF8C7E5")

    private int mListItemLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.869 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.871 -0400", hash_original_method = "1F16FD36E11C30DD7C480C9A0A11F40F", hash_generated_method = "DFBC9F682E66FF7187788968A9D5DC2F")
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
        
        
    }

    
        private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogCenterButtons,
                outValue, true);
        return outValue.data != 0;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.872 -0400", hash_original_method = "9A4AA3E1D6FBAA7AEFBA0C5C78FA5BFD", hash_generated_method = "E98531D1F4F433A67CEF302CE4CE9238")
    public void installContent() {
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        {
            boolean varAB694981E47E161D0D13D676835C3CCC_1079391574 = (mView == null || !canTextInput(mView));
            {
                mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            } 
        } 
        mWindow.setContentView(mAlertDialogLayout);
        setupView();
        
        
        
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.873 -0400", hash_original_method = "27E388CB8AFA6CAD5DDDE89F3EB645E1", hash_generated_method = "4F48F621CF498D3769331E920198D886")
    public void setTitle(CharSequence title) {
        mTitle = title;
        {
            mTitleView.setText(title);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.873 -0400", hash_original_method = "94C17D404D39F375178D63AA6F858393", hash_generated_method = "9AE38CE4ED732D893D2FAE27057216F6")
    public void setCustomTitle(View customTitleView) {
        mCustomTitleView = customTitleView;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.874 -0400", hash_original_method = "BE4B8F8527E733138AAA8E77FCFD81CC", hash_generated_method = "D179C467E8D42A1C66F463F558A4C89E")
    public void setMessage(CharSequence message) {
        mMessage = message;
        {
            mMessageView.setText(message);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.874 -0400", hash_original_method = "042A2BE3A9972DB9108969963EFE2152", hash_generated_method = "1380E8C1F04845590815286ECEC42D4D")
    public void setView(View view) {
        mView = view;
        mViewSpacingSpecified = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.875 -0400", hash_original_method = "2847E990E96B77DB4BD87DDDB577F2D4", hash_generated_method = "C1AF1001A46546F3ACEDC1DB21C0A963")
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        mView = view;
        mViewSpacingSpecified = true;
        mViewSpacingLeft = viewSpacingLeft;
        mViewSpacingTop = viewSpacingTop;
        mViewSpacingRight = viewSpacingRight;
        mViewSpacingBottom = viewSpacingBottom;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.875 -0400", hash_original_method = "F0CE922A10C717C707A211DED1E4F7AA", hash_generated_method = "884A9BE346DCC6FED6F337B0080B1ADA")
    public void setButton(int whichButton, CharSequence text,
            DialogInterface.OnClickListener listener, Message msg) {
        {
            msg = mHandler.obtainMessage(whichButton, listener);
        } 
        
        mButtonPositiveText = text;
        
        
        mButtonPositiveMessage = msg;
        
        
        mButtonNegativeText = text;
        
        
        mButtonNegativeMessage = msg;
        
        
        mButtonNeutralText = text;
        
        
        mButtonNeutralMessage = msg;
        
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Button does not exist");
        
        addTaint(whichButton);
        addTaint(listener.getTaint());
        
        
            
        
        
            
                
                
                
            
                
                
                
            
                
                
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.876 -0400", hash_original_method = "FB4271E4605E30D98972B290FB7DEC88", hash_generated_method = "0176D164EFC68B725D39639B13EC798B")
    public void setIcon(int resId) {
        mIconId = resId;
        {
            {
                mIconView.setImageResource(mIconId);
            } 
            {
                mIconView.setVisibility(View.GONE);
            } 
        } 
        
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.876 -0400", hash_original_method = "5C2407A3F3458DD1635D398D03E8F03F", hash_generated_method = "5F81E06242EDAF70870C7F4E905F2256")
    public void setIcon(Drawable icon) {
        mIcon = icon;
        {
            mIconView.setImageDrawable(icon);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.876 -0400", hash_original_method = "19D779B93DDFF4465E595606B06C3EFE", hash_generated_method = "2877CEF8117E45CC2D5B31E05B27DD1D")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mForceInverseBackground = forceInverseBackground;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.877 -0400", hash_original_method = "3273CA9467A607A59D9BD9C18D0394BC", hash_generated_method = "FDED9D9D967A1B836928B05023D803D7")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1858768853 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1858768853 = mListView;
        varB4EAC82CA7396A68D541C85D26508E83_1858768853.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1858768853;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.877 -0400", hash_original_method = "3833583B80F66F9531985629B1AE2E3F", hash_generated_method = "5B859A8710073887BE6EF128E6430F70")
    public Button getButton(int whichButton) {
        Button varB4EAC82CA7396A68D541C85D26508E83_1828451288 = null; 
        Button varB4EAC82CA7396A68D541C85D26508E83_2083774762 = null; 
        Button varB4EAC82CA7396A68D541C85D26508E83_294642646 = null; 
        Button varB4EAC82CA7396A68D541C85D26508E83_1634576496 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1828451288 = mButtonPositive;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2083774762 = mButtonNegative;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_294642646 = mButtonNeutral;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1634576496 = null;
        
        addTaint(whichButton);
        Button varA7E53CE21691AB073D9660D615818899_2112885985; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2112885985 = varB4EAC82CA7396A68D541C85D26508E83_1828451288;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2112885985 = varB4EAC82CA7396A68D541C85D26508E83_2083774762;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2112885985 = varB4EAC82CA7396A68D541C85D26508E83_294642646;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2112885985 = varB4EAC82CA7396A68D541C85D26508E83_1634576496;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2112885985.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2112885985;
        
        
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.878 -0400", hash_original_method = "B7833AF2811E127AB8391879126162ED", hash_generated_method = "233E4A04788FB1DF749052C7565CB479")
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        boolean varB0629CF80F4172C61489257E2E1A4A2C_469264350 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813672693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813672693;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.878 -0400", hash_original_method = "98FE899904FE72C0DB5091897F5A09B0", hash_generated_method = "81A0B8906EE29F52651E80E684173A3F")
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        boolean varB0629CF80F4172C61489257E2E1A4A2C_962668842 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_757783597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_757783597;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.879 -0400", hash_original_method = "0CE32455CB333C36B4EB85B89D65D186", hash_generated_method = "96E327DC2F066CB0796AFB01B3440B4C")
    private void setupView() {
        LinearLayout contentPanel = (LinearLayout) mWindow.findViewById(R.id.contentPanel);
        setupContent(contentPanel);
        boolean hasButtons = setupButtons();
        LinearLayout topPanel = (LinearLayout) mWindow.findViewById(R.id.topPanel);
        TypedArray a = mContext.obtainStyledAttributes(
                null, com.android.internal.R.styleable.AlertDialog, com.android.internal.R.attr.alertDialogStyle, 0);
        boolean hasTitle = setupTitle(topPanel);
        View buttonPanel = mWindow.findViewById(R.id.buttonPanel);
        {
            buttonPanel.setVisibility(View.GONE);
            mWindow.setCloseOnTouchOutsideIfNotSet(true);
        } 
        FrameLayout customPanel = null;
        {
            customPanel = (FrameLayout) mWindow.findViewById(R.id.customPanel);
            FrameLayout custom = (FrameLayout) mWindow.findViewById(R.id.custom);
            custom.addView(mView, new LayoutParams(MATCH_PARENT, MATCH_PARENT));
            {
                custom.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                        mViewSpacingBottom);
            } 
            {
                ((LinearLayout.LayoutParams) customPanel.getLayoutParams()).weight = 0;
            } 
        } 
        {
            mWindow.findViewById(R.id.customPanel).setVisibility(View.GONE);
        } 
        {
            View divider = null;
            {
                divider = mWindow.findViewById(R.id.titleDivider);
            } 
            {
                divider = mWindow.findViewById(R.id.titleDividerTop);
            } 
            {
                divider.setVisibility(View.VISIBLE);
            } 
        } 
        setBackground(topPanel, contentPanel, customPanel, hasButtons, a, hasTitle, buttonPanel);
        a.recycle();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.880 -0400", hash_original_method = "291261EC5A45F15B0AF035A0FADD9120", hash_generated_method = "48072D46DB986961EA3F83148620EB17")
    private boolean setupTitle(LinearLayout topPanel) {
        boolean hasTitle = true;
        {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            topPanel.addView(mCustomTitleView, 0, lp);
            View titleTemplate = mWindow.findViewById(R.id.title_template);
            titleTemplate.setVisibility(View.GONE);
        } 
        {
            final boolean hasTextTitle = !TextUtils.isEmpty(mTitle);
            mIconView = (ImageView) mWindow.findViewById(R.id.icon);
            {
                mTitleView = (TextView) mWindow.findViewById(R.id.alertTitle);
                mTitleView.setText(mTitle);
                {
                    mIconView.setImageResource(mIconId);
                } 
                {
                    mIconView.setImageDrawable(mIcon);
                } 
                {
                    mTitleView.setPadding(mIconView.getPaddingLeft(),
                            mIconView.getPaddingTop(),
                            mIconView.getPaddingRight(),
                            mIconView.getPaddingBottom());
                    mIconView.setVisibility(View.GONE);
                } 
            } 
            {
                View titleTemplate = mWindow.findViewById(R.id.title_template);
                titleTemplate.setVisibility(View.GONE);
                mIconView.setVisibility(View.GONE);
                topPanel.setVisibility(View.GONE);
                hasTitle = false;
            } 
        } 
        addTaint(topPanel.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034608458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034608458;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.880 -0400", hash_original_method = "887622C8B8EC01B1F9012F53B044827B", hash_generated_method = "C6C7C8E5F34B65AC7B46F229DAF694EC")
    private void setupContent(LinearLayout contentPanel) {
        mScrollView = (ScrollView) mWindow.findViewById(R.id.scrollView);
        mScrollView.setFocusable(false);
        mMessageView = (TextView) mWindow.findViewById(R.id.message);
        {
            mMessageView.setText(mMessage);
        } 
        {
            mMessageView.setVisibility(View.GONE);
            mScrollView.removeView(mMessageView);
            {
                contentPanel.removeView(mWindow.findViewById(R.id.scrollView));
                contentPanel.addView(mListView,
                        new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
                contentPanel.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 0, 1.0f));
            } 
            {
                contentPanel.setVisibility(View.GONE);
            } 
        } 
        addTaint(contentPanel.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.881 -0400", hash_original_method = "5BA34AF0614F863A3B9D6C4A8679B5AF", hash_generated_method = "401276D61D9DD9BB11650C027E5CEC86")
    private boolean setupButtons() {
        int BIT_BUTTON_POSITIVE = 1;
        int BIT_BUTTON_NEGATIVE = 2;
        int BIT_BUTTON_NEUTRAL = 4;
        int whichButtons = 0;
        mButtonPositive = (Button) mWindow.findViewById(R.id.button1);
        mButtonPositive.setOnClickListener(mButtonHandler);
        {
            boolean var93FA727FD667414F3938FEED09717F2A_1500352464 = (TextUtils.isEmpty(mButtonPositiveText));
            {
                mButtonPositive.setVisibility(View.GONE);
            } 
            {
                mButtonPositive.setText(mButtonPositiveText);
                mButtonPositive.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_POSITIVE;
            } 
        } 
        mButtonNegative = (Button) mWindow.findViewById(R.id.button2);
        mButtonNegative.setOnClickListener(mButtonHandler);
        {
            boolean var505565EA7766DA4AFDFEB9FF9ACE7D96_222324852 = (TextUtils.isEmpty(mButtonNegativeText));
            {
                mButtonNegative.setVisibility(View.GONE);
            } 
            {
                mButtonNegative.setText(mButtonNegativeText);
                mButtonNegative.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_NEGATIVE;
            } 
        } 
        mButtonNeutral = (Button) mWindow.findViewById(R.id.button3);
        mButtonNeutral.setOnClickListener(mButtonHandler);
        {
            boolean var5386D208F588E97ACB39A369F476A793_570219287 = (TextUtils.isEmpty(mButtonNeutralText));
            {
                mButtonNeutral.setVisibility(View.GONE);
            } 
            {
                mButtonNeutral.setText(mButtonNeutralText);
                mButtonNeutral.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_NEUTRAL;
            } 
        } 
        {
            boolean var4F7576D2B8F76BB57F10978A4D9C1675_1734009937 = (shouldCenterSingleButton(mContext));
            {
                {
                    centerButton(mButtonPositive);
                } 
                {
                    centerButton(mButtonNeutral);
                } 
                {
                    centerButton(mButtonNeutral);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_911068632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_911068632;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.881 -0400", hash_original_method = "28BC3CB500322D129CBA8E7C7A78AD5A", hash_generated_method = "633F3955F82B01296A8A534384E1512B")
    private void centerButton(Button button) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.weight = 0.5f;
        button.setLayoutParams(params);
        View leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        {
            leftSpacer.setVisibility(View.VISIBLE);
        } 
        View rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        {
            rightSpacer.setVisibility(View.VISIBLE);
        } 
        addTaint(button.getTaint());
        
        
        
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.883 -0400", hash_original_method = "6198B5046244FDCE77443F1833B74949", hash_generated_method = "A048C3E7516E297362446E451360BE57")
    private void setBackground(LinearLayout topPanel, LinearLayout contentPanel,
            View customPanel, boolean hasButtons, TypedArray a, boolean hasTitle, 
            View buttonPanel) {
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
        {
            views[pos] = topPanel;
            light[pos] = false;
        } 
        views[pos] = (contentPanel.getVisibility() == View.GONE) 
                ? null : contentPanel;
        light[pos] = mListView != null;
        {
            views[pos] = customPanel;
            light[pos] = mForceInverseBackground;
        } 
        {
            views[pos] = buttonPanel;
            light[pos] = true;
        } 
        boolean setView = false;
        {
            pos=0;
            {
                View v = views[pos];
                {
                    {
                        lastView.setBackgroundResource(lastLight ? topBright : topDark);
                    } 
                    {
                        lastView.setBackgroundResource(lastLight ? centerBright : centerDark);
                    } 
                    setView = true;
                } 
                lastView = v;
                lastLight = light[pos];
            } 
        } 
        {
            {
                lastView.setBackgroundResource(
                        lastLight ? (hasButtons ? bottomMedium : bottomBright) : bottomDark);
            } 
            {
                lastView.setBackgroundResource(lastLight ? fullBright : fullDark);
            } 
        } 
        {
            mListView.setAdapter(mAdapter);
            {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            } 
        } 
        addTaint(topPanel.getTaint());
        addTaint(contentPanel.getTaint());
        addTaint(customPanel.getTaint());
        addTaint(hasButtons);
        addTaint(a.getTaint());
        addTaint(hasTitle);
        addTaint(buttonPanel.getTaint());
        
        
    }

    
    private static final class ButtonHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.883 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "436872B12AE04B06D18A845CB0719BC2")

        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.884 -0400", hash_original_method = "94BD8A25739D33DF469E488FF271595A", hash_generated_method = "4185F310EECDDCDB1822BCA414EA5D62")
        public  ButtonHandler(DialogInterface dialog) {
            mDialog = new WeakReference<DialogInterface>(dialog);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.885 -0400", hash_original_method = "278B02327B6D097A80A5697E74542815", hash_generated_method = "25807EC7DE0094C6AA427F95B7789EEA")
        @Override
        public void handleMessage(Message msg) {
            
            ((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
            
            
            ((DialogInterface) msg.obj).dismiss();
            
            addTaint(msg.getTaint());
            
            
                
                
                
                    
                    
                
                    
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.885 -0400", hash_original_field = "9C7A29A1867BAE0555E957D87915449A", hash_generated_field = "837E07B94F9B99EC5A8E2663317A1F02")

        private static final int MSG_DISMISS_DIALOG = 1;
    }


    
    public static class RecycleListView extends ListView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.885 -0400", hash_original_field = "EEFDF834178AFE02FE8117D28C71CF20", hash_generated_field = "3DD4A4EF0D713F0ADFB04515FD02F627")

        boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.886 -0400", hash_original_method = "EE9FD5306D2F93DFDAA34BAADCE625A8", hash_generated_method = "9DC75BF16ABC669F3AA08697B9DBBF0A")
        public  RecycleListView(Context context) {
            super(context);
            addTaint(context.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.886 -0400", hash_original_method = "FD9F3D8D98E58119FCDEC82734593D0D", hash_generated_method = "0044E01C50CE07678F11B4FD3D121B21")
        public  RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.886 -0400", hash_original_method = "B696B9456EBFFE7A743BD389E8B7B605", hash_generated_method = "E078CC3665394D63A1EAA23CBC44A10F")
        public  RecycleListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            addTaint(defStyle);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_method = "9DCA0509220194E0D65C0AA0793BD261", hash_generated_method = "20305F10D3512EFFBCB9FC8E461F6420")
        @Override
        protected boolean recycleOnMeasure() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821640162 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_821640162;
            
            
        }

        
    }


    
    public static class AlertParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

        public Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "26B6EDB1B2B17244BBBF36956F817F15")

        public LayoutInflater mInflater;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "3E3764214A015E132F5BD47D9BC8E0B7", hash_generated_field = "C2DC3CCA222E71D43D27ECAB851034A0")

        public int mIconId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "E5243F47D3999E8E6530788895E90100")

        public Drawable mIcon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "04F7F9DD6D2510CBB15DFDFFE1807D8E")

        public CharSequence mTitle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "8D3447425F259899E340C82F15B1EF12", hash_generated_field = "814166582DF1A24C00D1625C5488672A")

        public View mCustomTitleView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "E05582EF743E1ACAA4AA9356CB30BC94")

        public CharSequence mMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "EF6BA7E2934EE938E1075151D930563A", hash_generated_field = "2CA24C7B094B26BA6E936F6BBC901F5D")

        public CharSequence mPositiveButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "14D30E0C536B9FAFB9EB169A4742623E", hash_generated_field = "1BE202C2CAD8DB621DCDD3372ED2D171")

        public DialogInterface.OnClickListener mPositiveButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "480C6129BEBC705E36C19ADB4B0F8B3C", hash_generated_field = "2D3FBAA9E0AD2228B46D75FBECE56655")

        public CharSequence mNegativeButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "DB0BCBC46B1D543C8137D88883360FDF", hash_generated_field = "B8D1F988895A94C1B77F97F848992793")

        public DialogInterface.OnClickListener mNegativeButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "74FB7576A510184675BE65231720E60C", hash_generated_field = "C67CE1D73A0301923AC9C0DDF272716F")

        public CharSequence mNeutralButtonText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "B67A046222E4A19F7183D5F929307B28", hash_generated_field = "C6F2573A08FEF0DF77F903DEE8742754")

        public DialogInterface.OnClickListener mNeutralButtonListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "895157BE8E63EE5D1276B7D79E82D10B", hash_generated_field = "690DB816AF9947EBA54C6AD5450363A0")

        public boolean mCancelable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "3FB4AF9CA69AF46ED977BB7342A8B1AB", hash_generated_field = "D57560FB4E6739D7CCFF128C31469BB1")

        public DialogInterface.OnCancelListener mOnCancelListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "CA7076FF3B23B43DA0C003C9464E1AB3")

        public DialogInterface.OnKeyListener mOnKeyListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "81B576C1AEA8031B0352003E1201CB4F", hash_generated_field = "770D760EB2D47D87B74F516C630F54A9")

        public CharSequence[] mItems;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "25FA7FD85E13A481D223BDA4FAF494D1")

        public ListAdapter mAdapter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "D617C33C039CBCFD65B3C22DBA07CFF5")

        public DialogInterface.OnClickListener mOnClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6C373AA66951237B18143051CA3FC35A")

        public View mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "1118F3E1721DAF8FB4872146DA12E56F", hash_generated_field = "133421CFB34A08A745D0DABDF172D654")

        public int mViewSpacingLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "E7238771FCAB61AE32E851A5F82687D8", hash_generated_field = "AACBB04D340CCDFCD16549D9477D1053")

        public int mViewSpacingTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "D8563F961A4F1D04632FC413D194B935", hash_generated_field = "B5693872E335B49FF25BCA5D1000771A")

        public int mViewSpacingRight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "7686141D1F92DBAA062C3A41CF84AF7D", hash_generated_field = "16138D3B0F72ADA1373081D480EF4F2A")

        public int mViewSpacingBottom;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "9516D9606C5F2B9AA236056257DD4D2C", hash_generated_field = "15FC623F24AED707F20028F138CB4155")

        public boolean mViewSpacingSpecified = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "226005F926E9D782070A79CF1A4B053C", hash_generated_field = "34261E0AFA1935DD7182F7BE1D273C66")

        public boolean[] mCheckedItems;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.887 -0400", hash_original_field = "3367E3A98A655AF3148902A101B93604", hash_generated_field = "2928823CCF761707AADE97A3C31F0E37")

        public boolean mIsMultiChoice;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "7924285A5210ACFFD6981B4B89F826F1", hash_generated_field = "264C969397A5870832FCC712B67D9AED")

        public boolean mIsSingleChoice;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "A2C57E1A405B74F862E9C4EE2D8802BC", hash_generated_field = "B28C90765377E391E20D88849A9B1FCD")

        public int mCheckedItem = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "E90DDAAFA67CE915947F43C5BD0B1329", hash_generated_field = "C1D53F530A35F1502CC3200362215D8B")

        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6691A457869D5E472564204CDF0EADCB")

        public Cursor mCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "10A803290AD7773E329F678004D91D34", hash_generated_field = "8663F263214822FF04034DE81B9E539F")

        public String mLabelColumn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "CBF8F9FD70EDD094D7E542C4739E6288", hash_generated_field = "D868CCDF8866E0B4C22A7B4AB9003B23")

        public String mIsCheckedColumn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "1C487D484535FC8A97D2E914DF5BE34E", hash_generated_field = "CEBAA7027B15CFA5FFECBE008E938B45")

        public boolean mForceInverseBackground;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "773B78B8354D6C9F88CCABB4FB2C5772", hash_generated_field = "E0E2BC3A5346F1A907B72B36F89366E0")

        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "E15AD44F9720EAFA479AD8F9FB960029", hash_generated_field = "3AB01332941910606794E5FE4F180916")

        public OnPrepareListViewListener mOnPrepareListViewListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_field = "EEFDF834178AFE02FE8117D28C71CF20", hash_generated_field = "D4A086061D2FEBA35D1D1938D92E949F")

        public boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.888 -0400", hash_original_method = "30F42D5772B75365825E237386B4299E", hash_generated_method = "CF26A7D12C986291CBAD02E9F9FA57B8")
        public  AlertParams(Context context) {
            mContext = context;
            mCancelable = true;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.889 -0400", hash_original_method = "80497DB7CC0D98B7F92FD843E557F0AA", hash_generated_method = "98793534BD040238D3ABB043FC01803C")
        public void apply(AlertController dialog) {
            {
                dialog.setCustomTitle(mCustomTitleView);
            } 
            {
                {
                    dialog.setTitle(mTitle);
                } 
                {
                    dialog.setIcon(mIcon);
                } 
                {
                    dialog.setIcon(mIconId);
                } 
            } 
            {
                dialog.setMessage(mMessage);
            } 
            {
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, mPositiveButtonText,
                        mPositiveButtonListener, null);
            } 
            {
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, mNegativeButtonText,
                        mNegativeButtonListener, null);
            } 
            {
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, mNeutralButtonText,
                        mNeutralButtonListener, null);
            } 
            {
                dialog.setInverseBackgroundForced(true);
            } 
            {
                createListView(dialog);
            } 
            {
                {
                    dialog.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                            mViewSpacingBottom);
                } 
                {
                    dialog.setView(mView);
                } 
            } 
            addTaint(dialog.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.895 -0400", hash_original_method = "8E786D28D6E36F7AAC42E3AE032D9CF8", hash_generated_method = "84C23EA054B8EAFE71104E02B1A1C7A6")
        private void createListView(final AlertController dialog) {
            final RecycleListView listView = (RecycleListView)
                    mInflater.inflate(dialog.mListLayout, null);
            ListAdapter adapter;
            {
                {
                    adapter = new ArrayAdapter<CharSequence>(
                            mContext, dialog.mMultiChoiceItemLayout, R.id.text1, mItems) {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.890 -0400", hash_original_method = "23A354B1E3F11023EC3EF5623A4E6D9E", hash_generated_method = "50B3B2CD5B3DB7CF9D523D056653AAA5")
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View varB4EAC82CA7396A68D541C85D26508E83_1569502143 = null; 
                            View view = super.getView(position, convertView, parent);
                            {
                                boolean isItemChecked = mCheckedItems[position];
                                {
                                    listView.setItemChecked(position, true);
                                } 
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_1569502143 = view;
                            addTaint(position);
                            addTaint(convertView.getTaint());
                            addTaint(parent.getTaint());
                            varB4EAC82CA7396A68D541C85D26508E83_1569502143.addTaint(getTaint()); 
                            return varB4EAC82CA7396A68D541C85D26508E83_1569502143;
                            
                            
                            
                                
                                
                                    
                                
                            
                            
                        }
};
                } 
                {
                    adapter = new CursorAdapter(mContext, mCursor, false) {                        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.890 -0400", hash_original_field = "5ED5AAFE00FF0DB57B0F6F660CFDC780", hash_generated_field = "6AE1690622EE66BC1693CD9F6D6F3F96")
                        private int mLabelIndex;
                        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.890 -0400", hash_original_field = "E79E3F680505689336A5849A5AC0B273", hash_generated_field = "671FFD450B2DD86945A5580E97F76CDA")
                        private int mIsCheckedIndex;
                        {
                            final Cursor cursor = getCursor();
                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.891 -0400", hash_original_method = "9923C63783513415221DB53D1A04C6D7", hash_generated_method = "D9C8C264EEA7990BEED948A1AE665654")
                        @Override
                        public void bindView(View view, Context context, Cursor cursor) {
                            CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                            text.setText(cursor.getString(mLabelIndex));
                            listView.setItemChecked(cursor.getPosition(),
                                    cursor.getInt(mIsCheckedIndex) == 1);
                            addTaint(view.getTaint());
                            addTaint(context.getTaint());
                            addTaint(cursor.getTaint());
                            
                            
                            
                            
                                    
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.891 -0400", hash_original_method = "87A8136D8ED8F9724DD65BD87F7B3B3A", hash_generated_method = "49ADAA7AB525536AAC7F54C710B6D1CF")
                        @Override
                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
                            View varB4EAC82CA7396A68D541C85D26508E83_1554263762 = null; 
                            varB4EAC82CA7396A68D541C85D26508E83_1554263762 = mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    parent, false);
                            addTaint(context.getTaint());
                            addTaint(cursor.getTaint());
                            addTaint(parent.getTaint());
                            varB4EAC82CA7396A68D541C85D26508E83_1554263762.addTaint(getTaint()); 
                            return varB4EAC82CA7396A68D541C85D26508E83_1554263762;
                            
                            
                                    
                        }
};
                } 
            } 
            {
                int layout;
                layout = dialog.mSingleChoiceItemLayout;
                layout = dialog.mListItemLayout;
                {
                    adapter = (mAdapter != null) ? mAdapter
                            : new ArrayAdapter<CharSequence>(mContext, layout, R.id.text1, mItems);
                } 
                {
                    adapter = new SimpleCursorAdapter(mContext, layout, 
                            mCursor, new String[]{mLabelColumn}, new int[]{R.id.text1});
                } 
            } 
            {
                mOnPrepareListViewListener.onPrepareListView(listView);
            } 
            dialog.mAdapter = adapter;
            dialog.mCheckedItem = mCheckedItem;
            {
                listView.setOnItemClickListener(new OnItemClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.893 -0400", hash_original_method = "8EA9AA28841E6789D2A0900FF06F5143", hash_generated_method = "4247682D5E3A87E064C3FFDCB18EE12E")
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        
                        mOnClickListener.onClick(dialog.mDialogInterface, position);
                        {
                            dialog.mDialogInterface.dismiss();
                        } 
                        addTaint(parent.getTaint());
                        addTaint(v.getTaint());
                        addTaint(position);
                        addTaint(id);
                        
                        
                        
                            
                        
                    }
});
            } 
            {
                listView.setOnItemClickListener(new OnItemClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:18.895 -0400", hash_original_method = "A7D02743B14CEBBCE2076709416E7025", hash_generated_method = "C2265E766B1EE0541DDBAB09B83F92CD")
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        
                        {
                            mCheckedItems[position] = listView.isItemChecked(position);
                        } 
                        mOnCheckboxClickListener.onClick(
                                dialog.mDialogInterface, position, listView.isItemChecked(position));
                        addTaint(parent.getTaint());
                        addTaint(v.getTaint());
                        addTaint(position);
                        addTaint(id);
                        
                        
                            
                        
                        
                                
                    }
});
            } 
            {
                listView.setOnItemSelectedListener(mOnItemSelectedListener);
            } 
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            } 
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            } 
            listView.mRecycleOnMeasure = mRecycleOnMeasure;
            dialog.mListView = listView;
            
            
        }

        
        public interface OnPrepareListViewListener {
            
            
            void onPrepareListView(ListView listView);
        }
        
    }


    
}

