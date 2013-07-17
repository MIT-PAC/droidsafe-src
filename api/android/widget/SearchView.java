package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import static android.widget.SuggestionsAdapter.getColumnString;
import android.app.PendingIntent;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.CollapsibleActionView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;
import com.android.internal.R;
import java.util.WeakHashMap;

public class SearchView extends LinearLayout implements CollapsibleActionView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "F0FC83112FD93E69838BD6DEF95F60C7", hash_generated_field = "20DE7328B76C4576C54CEA1C31A5A5DD")

    private OnQueryTextListener mOnQueryChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "47454ABD361EC45738FEDA04F526AE1A", hash_generated_field = "3E6EDBFCD15829E88C823AD6BD9DA13F")

    private OnCloseListener mOnCloseListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "2E08BF2645EEF4C8B5A42084F390A4B5", hash_generated_field = "5ED7A88B9A58B568EB225F4FC003710B")

    private OnFocusChangeListener mOnQueryTextFocusChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "8DC5B64EAC058B5083CAE814ADBD7ED0", hash_generated_field = "8D8A066C35D08D2636C4C1260524D2BF")

    private OnSuggestionListener mOnSuggestionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "9F1F9A6115F6CABB1E5C631E50B730EC", hash_generated_field = "4CE2C18E09AA7469BBEF676CF87B216F")

    private OnClickListener mOnSearchClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "240C319CE9511A3C6618BAF616D6A95D", hash_generated_field = "DBB17EC605FD9389E7F62B38DE47A3A4")

    private boolean mIconifiedByDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "E490012EE9B46FF826CCD5B3B6B214A9", hash_generated_field = "77805A492451B977E1816BA9783A9397")

    private boolean mIconified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.830 -0400", hash_original_field = "63055E537713F24C4C86BE6E68415FCE", hash_generated_field = "2E9A26C4761764604246CFEB2C060F9B")

    private CursorAdapter mSuggestionsAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "B09C96F2B0035B8D0A17B69A9CB42922", hash_generated_field = "95F86E17693F7357E97225DE31C237B8")

    private View mSearchButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "4D64642D297528CE69B9092F8D62B333", hash_generated_field = "5B6BED2A64238CE3908B3B8A74F943A0")

    private View mSubmitButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "01BCA17D3E9DDD8BF5B44F3E2EF1EE68", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "2BCB8DD6DB0886263B47A791A5E5A95E", hash_generated_field = "BC8307BFA7D8BAD259EA185F504A6263")

    private View mSubmitArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "9FCA0F272C23938FFED9C87C327F80A4", hash_generated_field = "F2F2EE3489EA7D1D3E79DE10F3C92864")

    private ImageView mCloseButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "3B421A34FA7A3F6F502112270464063B", hash_generated_field = "FA2C49A395FA13278ED063933D3B9887")

    private View mSearchEditFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "82862F97F98548A9593F66521F19EB37", hash_generated_field = "008F39BAA0ECCE0EB48B634A42A71E8D")

    private View mVoiceButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "FCAFC8BB77AF346B28F95EAD1A6AEA60", hash_generated_field = "2624CFC6240E328ABC658DAF35FB4ED1")

    private SearchAutoComplete mQueryTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "90D72399639ED88F9BD367E5BF80885E", hash_generated_field = "843247771C656AC3967CC38CD7762802")

    private View mDropDownAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "4DC96DD56935DDDBBA65DBA5782C5A44", hash_generated_field = "E9A5F2E0A5AECD994F77BB6139C386D7")

    private ImageView mSearchHintIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "F51306B58E2668509E9043E7735E1FA4", hash_generated_field = "F0EDF0CA4EF3F26D48862E3A0541ACC7")

    private boolean mSubmitButtonEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "F19769AB62A92C3C10630D0D10DC860A", hash_generated_field = "986A565C1B04C031BC149F5E489100AA")

    private CharSequence mQueryHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "69EE6C3CFA8048276879EF4C552B5C72", hash_generated_field = "E038E258E9530F2A3E67A290C3460468")

    private boolean mQueryRefinement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "86A1AA993B9284C3D6B764E936CD37E9", hash_generated_field = "9D126837B9B8B29E1CD350C323EA754B")

    private boolean mClearingFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.831 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "56FEC094E1F34E5A1FBB51577926300D", hash_generated_field = "6F563F6D96E3715972347A08AA7ECEA8")

    private boolean mVoiceButtonEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "C4702E681C3BD612CDA9DBDCFA59D47C", hash_generated_field = "548274ED005EA0BA1FFEE17A1050C8BD")

    private CharSequence mOldQueryText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "336CD107D0D6B9BEBFB6CBC4E3350BF4", hash_generated_field = "3AEB2D2A42F37E91B98257CE593EDED2")

    private CharSequence mUserQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "2ADA50DD7E29822F5E0707216EB09E8F", hash_generated_field = "EC81987BA3E4E312EA0C0424E31419B5")

    private boolean mExpandedInActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "BB450BF1FD38EAFA71E793F3C559386F", hash_generated_field = "1D7B31D5465A178BB6E6B80FD3070C61")

    private int mCollapsedImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "9AD25D597D917C37D99A80719B4F8F99", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

    private Bundle mAppSearchData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "53A427FD16557EC7A190A6A22832513B", hash_generated_field = "BDCDEE8CB213AC6AC722C08C26B494D4")

    private Runnable mShowImeRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_method = "0C9F4768975D596BB26A07FA95497352", hash_generated_method = "EC092D8AB01C27482EC5C32D694A46BC")
        public void run() {
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            {
                imm.showSoftInputUnchecked(0, null);
            } 
            
            
                    
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_field = "E89A5EA49EA144C7FEB827EB20CCD537", hash_generated_field = "3E8E4FFE990C2F063F9CE6F2A6C2E370")

    private Runnable mUpdateDrawableStateRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_method = "E7E2D783E1837F9E8B1A28FF4E183514", hash_generated_method = "B3EAFD427E9292CB229208955575A412")
        public void run() {
            updateFocusedState();
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_field = "D5FA47F6738ED48B04D60BB4B31A6FC7", hash_generated_field = "710120C6C6D078D00159221C7E0B3868")

    private Runnable mReleaseCursorRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_method = "EDF4C3DBCA8CFDCCDE7923F1B773494D", hash_generated_method = "5D09A5A32E2149C6D8DDAB1034633D73")
        public void run() {
            {
                mSuggestionsAdapter.changeCursor(null);
            } 
            
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "04D6CDF64323839563B4F92092B41FA4", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private Intent mVoiceWebSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "11E5F1DDAB281A77343908AB3E79EC12", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private Intent mVoiceAppSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.832 -0400", hash_original_field = "25DE515824825836C5E934A10C853314", hash_generated_field = "74F51E5C441F50D94EA029952A490911")

    private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap<String, Drawable.ConstantState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.773 -0400", hash_original_field = "E56B6AE5C5C1EC6D8C4214BFA55B7404", hash_generated_field = "812B45A6385CB2DDD472ED087ABAB372")

    private final OnClickListener mOnClickListener = new OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.773 -0400", hash_original_method = "7A1C93089C02ACFF37CDB0A860AADCE9", hash_generated_method = "857C3F42BD32BE6A104B549FBE8CE91E")
        public void onClick(View v) {
            
            {
                onSearchClicked();
            } 
            {
                onCloseClicked();
            } 
            {
                onSubmitQuery();
            } 
            {
                onVoiceClicked();
            } 
            {
                forceSuggestionQuery();
            } 
            addTaint(v.getTaint());
            
            
                
            
                
            
                
            
                
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.774 -0400", hash_original_field = "D5990E38F43E01B338867BDD320AE319", hash_generated_field = "7B276C022FB97D5B1CD2C5016A1B8491")

    View.OnKeyListener mTextKeyListener = new View.OnKeyListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.774 -0400", hash_original_method = "6918EF31FF46DE3F47367E08809323A7", hash_generated_method = "9906D0F8658E4969EBB579595DF6BCD0")
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            
            {
                Log.d(LOG_TAG, "mTextListener.onKey(" + keyCode + "," + event + "), selection: "
                        + mQueryTextView.getListSelection());
            } 
            {
                boolean varE6EA52064C48DD8716C3E906CB173C57_800195026 = (mQueryTextView.isPopupShowing()
                    && mQueryTextView.getListSelection() != ListView.INVALID_POSITION);
                {
                    boolean var61B897F82409A70C761917364CAB3F30_1089778966 = (onSuggestionsKey(v, keyCode, event));
                } 
            } 
            {
                boolean varE59197EBDDDE38F1D5742B373FE3954C_759932118 = (!mQueryTextView.isEmpty() && event.hasNoModifiers());
                {
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_1893203567 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            {
                                v.cancelLongPress();
                                launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, mQueryTextView.getText()
                                .toString());
                            } 
                        } 
                    } 
                    {
                        boolean var53B1438B0BA4D5FAD39095EFE3E69325_1452623959 = (event.getAction() == KeyEvent.ACTION_DOWN);
                        {
                            SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
                            {
                                boolean var2CE6658B093840CDBB7A8A4DB4461BFB_1586593919 = ((actionKey != null) && (actionKey.getQueryActionMsg() != null));
                                {
                                    launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView
                                .getText().toString());
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(v.getTaint());
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1360017271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1360017271;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.775 -0400", hash_original_field = "0F7F47B24D27A009635AE79463FA69D4", hash_generated_field = "380D84078CA28357A5743A675FFCECE4")

    private final OnEditorActionListener mOnEditorActionListener = new OnEditorActionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.775 -0400", hash_original_method = "D29597D64DD97652D3ABF8CFD2738E45", hash_generated_method = "0CA87F83078E34E26C442713766DDE60")
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            
            onSubmitQuery();
            addTaint(v.getTaint());
            addTaint(actionId);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436174645 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436174645;
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.775 -0400", hash_original_field = "CA6AB8BFD0E4BC5A9CFF895D3BE46EF6", hash_generated_field = "9ADE8DB5434B809692CDCB9EC6070AA9")

    private final OnItemClickListener mOnItemClickListener = new OnItemClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.775 -0400", hash_original_method = "5E212E5821217E2BB1A383DD15E7F009", hash_generated_method = "B4B056AC6204886414378AA45400D874")
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            
            Log.d(LOG_TAG, "onItemClick() position " + position);
            onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null);
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.776 -0400", hash_original_field = "6A3EFB855A77C09B3BD750B0273F292F", hash_generated_field = "E135B253EAD2EE5A9F1E2C8A06E56941")

    private final OnItemSelectedListener mOnItemSelectedListener = new OnItemSelectedListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.776 -0400", hash_original_method = "86CEF1E2408F388AD82C104FE40AC329", hash_generated_method = "E1005CD7FCFF5871C5EF1DEFF67BDB1A")
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            
            Log.d(LOG_TAG, "onItemSelected() position " + position);
            SearchView.this.onItemSelected(position);
            addTaint(parent.getTaint());
            addTaint(view.getTaint());
            addTaint(position);
            addTaint(id);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.776 -0400", hash_original_method = "4FDA6539116BD7730EFFECAC0128D708", hash_generated_method = "2DDB29F13F7959438D3B545352D01AE8")
        public void onNothingSelected(AdapterView<?> parent) {
            
            Log.d(LOG_TAG, "onNothingSelected()");
            addTaint(parent.getTaint());
            
            
                
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.777 -0400", hash_original_field = "75D7929A1F386992A1A2654F9F8EC228", hash_generated_field = "853CD732CF6A0D9249B642D7554AB298")

    private TextWatcher mTextWatcher = new TextWatcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.776 -0400", hash_original_method = "EAE2EA11EF016FE6B504EAA4A71A905F", hash_generated_method = "B9D33D7ABAFF92DBB026AAD80BA044BF")
        public void beforeTextChanged(CharSequence s, int start, int before, int after) {
            addTaint(s.getTaint());
            addTaint(start);
            addTaint(before);
            addTaint(after);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.777 -0400", hash_original_method = "F1038C7BDD17D1F93B5C6C4513E79DEF", hash_generated_method = "E73A50E8246DFD8A4B60F7797FF258B8")
        public void onTextChanged(CharSequence s, int start,
                int before, int after) {
            
            SearchView.this.onTextChanged(s);
            addTaint(s.getTaint());
            addTaint(start);
            addTaint(before);
            addTaint(after);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.777 -0400", hash_original_method = "2B62725FCE5BAC340D42F3403AAE31A5", hash_generated_method = "B1E73F6E6A3A9E89AEF9681CB19F89E5")
        public void afterTextChanged(Editable s) {
            addTaint(s.getTaint());
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.833 -0400", hash_original_method = "C1ED4F339F78000C40B1DF7945901DEA", hash_generated_method = "599F11E85D18C4EE741C206F7CE214FA")
    public  SearchView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.838 -0400", hash_original_method = "3896FE61014E55816F436D09C274C5F6", hash_generated_method = "4DEDF8E7692F4FB5D988117CCAFD0A9B")
    public  SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.search_view, this, true);
        mSearchButton = findViewById(R.id.search_button);
        mQueryTextView = (SearchAutoComplete) findViewById(R.id.search_src_text);
        mQueryTextView.setSearchView(this);
        mSearchEditFrame = findViewById(R.id.search_edit_frame);
        mSearchPlate = findViewById(R.id.search_plate);
        mSubmitArea = findViewById(R.id.submit_area);
        mSubmitButton = findViewById(R.id.search_go_btn);
        mCloseButton = (ImageView) findViewById(R.id.search_close_btn);
        mVoiceButton = findViewById(R.id.search_voice_btn);
        mSearchHintIcon = (ImageView) findViewById(R.id.search_mag_icon);
        mSearchButton.setOnClickListener(mOnClickListener);
        mCloseButton.setOnClickListener(mOnClickListener);
        mSubmitButton.setOnClickListener(mOnClickListener);
        mVoiceButton.setOnClickListener(mOnClickListener);
        mQueryTextView.setOnClickListener(mOnClickListener);
        mQueryTextView.addTextChangedListener(mTextWatcher);
        mQueryTextView.setOnEditorActionListener(mOnEditorActionListener);
        mQueryTextView.setOnItemClickListener(mOnItemClickListener);
        mQueryTextView.setOnItemSelectedListener(mOnItemSelectedListener);
        mQueryTextView.setOnKeyListener(mTextKeyListener);
        mQueryTextView.setOnFocusChangeListener(new OnFocusChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.836 -0400", hash_original_method = "93DBFCC4F7C7F6082C428361FF73C717", hash_generated_method = "35BC3A2EE590A0CBA7725C5C7FE5697B")
        public void onFocusChange(View v, boolean hasFocus) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(hasFocus);
            addTaint(v.getTaint());
            if(mOnQueryTextFocusChangeListener != null)            
            {
                mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
            } //End block
            // ---------- Original Method ----------
            //if (mOnQueryTextFocusChangeListener != null) {
                    //mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                //}
        }
});
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int maxWidth = a.getDimensionPixelSize(R.styleable.SearchView_maxWidth, -1);
        if(maxWidth != -1)        
        {
            setMaxWidth(maxWidth);
        } //End block
        CharSequence queryHint = a.getText(R.styleable.SearchView_queryHint);
        if(!TextUtils.isEmpty(queryHint))        
        {
            setQueryHint(queryHint);
        } //End block
        int imeOptions = a.getInt(R.styleable.SearchView_imeOptions, -1);
        if(imeOptions != -1)        
        {
            setImeOptions(imeOptions);
        } //End block
        int inputType = a.getInt(R.styleable.SearchView_inputType, -1);
        if(inputType != -1)        
        {
            setInputType(inputType);
        } //End block
        a.recycle();
        boolean focusable = true;
        a = context.obtainStyledAttributes(attrs, R.styleable.View, 0, 0);
        focusable = a.getBoolean(R.styleable.View_focusable, focusable);
        a.recycle();
        setFocusable(focusable);
        mVoiceWebSearchIntent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
        mVoiceWebSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mVoiceWebSearchIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        mVoiceAppSearchIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mVoiceAppSearchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mDropDownAnchor = findViewById(mQueryTextView.getDropDownAnchor());
        if(mDropDownAnchor != null)        
        {
            mDropDownAnchor.addOnLayoutChangeListener(new OnLayoutChangeListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.837 -0400", hash_original_method = "1877F5683C45A9DD10AF559CB44A52A8", hash_generated_method = "980B5580CBF70B69F985ECDB71CD1E3D")
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom,
                        int oldLeft, int oldTop, int oldRight, int oldBottom) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(oldBottom);
            addTaint(oldRight);
            addTaint(oldTop);
            addTaint(oldLeft);
            addTaint(bottom);
            addTaint(right);
            addTaint(top);
            addTaint(left);
            addTaint(v.getTaint());
            adjustDropDownSizeAndPosition();
            // ---------- Original Method ----------
            //adjustDropDownSizeAndPosition();
        }
});
        } //End block
        updateViewsVisibility(mIconifiedByDefault);
        updateQueryHint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.839 -0400", hash_original_method = "D9A30BFA849ECE06409E134B6DE5C1F0", hash_generated_method = "3496D7408FBC228846DD9D01C696ABB1")
    public void setSearchableInfo(SearchableInfo searchable) {
        mSearchable = searchable;
        if(mSearchable != null)        
        {
            updateSearchAutoComplete();
            updateQueryHint();
        } //End block
        mVoiceButtonEnabled = hasVoiceSearch();
        if(mVoiceButtonEnabled)        
        {
            mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        } //End block
        updateViewsVisibility(isIconified());
        // ---------- Original Method ----------
        //mSearchable = searchable;
        //if (mSearchable != null) {
            //updateSearchAutoComplete();
            //updateQueryHint();
        //}
        //mVoiceButtonEnabled = hasVoiceSearch();
        //if (mVoiceButtonEnabled) {
            //mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        //}
        //updateViewsVisibility(isIconified());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.840 -0400", hash_original_method = "EBA44227BB74F0B08E6F1C70EA9AD0F7", hash_generated_method = "9F0ED82A7B1E8B7E54C4455D92283D55")
    public void setAppSearchData(Bundle appSearchData) {
        mAppSearchData = appSearchData;
        // ---------- Original Method ----------
        //mAppSearchData = appSearchData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.840 -0400", hash_original_method = "A9C55FF5F962662498ECAD2C137876AF", hash_generated_method = "47C805155EB2303DCD2D12B6679681B6")
    public void setImeOptions(int imeOptions) {
        addTaint(imeOptions);
        mQueryTextView.setImeOptions(imeOptions);
        // ---------- Original Method ----------
        //mQueryTextView.setImeOptions(imeOptions);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.840 -0400", hash_original_method = "48CC06180C89621288EE9E924CBC5764", hash_generated_method = "58C2982C0B7F38646113178BEEA89BFA")
    public void setInputType(int inputType) {
        addTaint(inputType);
        mQueryTextView.setInputType(inputType);
        // ---------- Original Method ----------
        //mQueryTextView.setInputType(inputType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.841 -0400", hash_original_method = "83E343EB647417E47B475AFEA392BC7D", hash_generated_method = "1D194FE8D22B8A43F986AAC59EEC290F")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        if(mClearingFocus)        
        {
        boolean var68934A3E9455FA72420237EB05902327_638845515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131920699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131920699;
        }
        if(!isFocusable())        
        {
        boolean var68934A3E9455FA72420237EB05902327_299216034 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805967137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805967137;
        }
        if(!isIconified())        
        {
            boolean result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
            if(result)            
            {
                updateViewsVisibility(false);
            } //End block
            boolean varB4A88417B3D0170D754C647C30B7216A_438356684 = (result);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654859934 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654859934;
        } //End block
        else
        {
            boolean var7099514E4AF279E1F75517A262FE9D78_1546481851 = (super.requestFocus(direction, previouslyFocusedRect));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942867074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_942867074;
        } //End block
        // ---------- Original Method ----------
        //if (mClearingFocus) return false;
        //if (!isFocusable()) return false;
        //if (!isIconified()) {
            //boolean result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
            //if (result) {
                //updateViewsVisibility(false);
            //}
            //return result;
        //} else {
            //return super.requestFocus(direction, previouslyFocusedRect);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.842 -0400", hash_original_method = "65B369A9FAEBC12EA58ACD6F427C9883", hash_generated_method = "A6CAF4E8BDA1F89ACF64F4B0D6BA3049")
    @Override
    public void clearFocus() {
        mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        mQueryTextView.clearFocus();
        mClearingFocus = false;
        // ---------- Original Method ----------
        //mClearingFocus = true;
        //setImeVisibility(false);
        //super.clearFocus();
        //mQueryTextView.clearFocus();
        //mClearingFocus = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.842 -0400", hash_original_method = "5F51E4234BD6E41AFB4ED2E85F8CC1A5", hash_generated_method = "9ED055F823619F93416123D3D749DA22")
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        mOnQueryChangeListener = listener;
        // ---------- Original Method ----------
        //mOnQueryChangeListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.842 -0400", hash_original_method = "5C0B64E237CFC180C92A60294DA35470", hash_generated_method = "53357DC670AF8DA5EBA61C8EACD2EFB0")
    public void setOnCloseListener(OnCloseListener listener) {
        mOnCloseListener = listener;
        // ---------- Original Method ----------
        //mOnCloseListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.843 -0400", hash_original_method = "2E189EEDC80EC67610C89143836C4DBB", hash_generated_method = "0E136A746D1DACCB2ECA5B20AA0683B2")
    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        mOnQueryTextFocusChangeListener = listener;
        // ---------- Original Method ----------
        //mOnQueryTextFocusChangeListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.843 -0400", hash_original_method = "5242CF20D6A154AA5BAD996C3A14A890", hash_generated_method = "B2386EAE9CE311FF03E5CAA313730E12")
    public void setOnSuggestionListener(OnSuggestionListener listener) {
        mOnSuggestionListener = listener;
        // ---------- Original Method ----------
        //mOnSuggestionListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.844 -0400", hash_original_method = "AFFD80E7D30CC6B8E84DA9D0AC11DA43", hash_generated_method = "8D05E5C8F36ECC1939C7C9EC7679070B")
    public void setOnSearchClickListener(OnClickListener listener) {
        mOnSearchClickListener = listener;
        // ---------- Original Method ----------
        //mOnSearchClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.844 -0400", hash_original_method = "BDCF19F1BD9841AC2C41BDBA087D55A0", hash_generated_method = "B57C6E8D84B2B47538E7C700AB768D2E")
    public CharSequence getQuery() {
CharSequence var4161B58CB13C29FF4C751FF181305C25_735035641 =         mQueryTextView.getText();
        var4161B58CB13C29FF4C751FF181305C25_735035641.addTaint(taint);
        return var4161B58CB13C29FF4C751FF181305C25_735035641;
        // ---------- Original Method ----------
        //return mQueryTextView.getText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.845 -0400", hash_original_method = "5407FC5F92134D6A89C79A4C1515F538", hash_generated_method = "58AC1AA4B3D3483F21A8D01E8A2E25B8")
    public void setQuery(CharSequence query, boolean submit) {
        addTaint(submit);
        mQueryTextView.setText(query);
        if(query != null)        
        {
            mQueryTextView.setSelection(query.length());
            mUserQuery = query;
        } //End block
        if(submit && !TextUtils.isEmpty(query))        
        {
            onSubmitQuery();
        } //End block
        // ---------- Original Method ----------
        //mQueryTextView.setText(query);
        //if (query != null) {
            //mQueryTextView.setSelection(query.length());
            //mUserQuery = query;
        //}
        //if (submit && !TextUtils.isEmpty(query)) {
            //onSubmitQuery();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.846 -0400", hash_original_method = "E72A59E6C313C94D91D305DFD6AC06A2", hash_generated_method = "C5258471F3F6A52B795E7A34BC1D0815")
    public void setQueryHint(CharSequence hint) {
        mQueryHint = hint;
        updateQueryHint();
        // ---------- Original Method ----------
        //mQueryHint = hint;
        //updateQueryHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.846 -0400", hash_original_method = "ACA6D63CA1F64B4CD762BEE0367B8A15", hash_generated_method = "B7C1B1C8EFE2D67C5019F175022CC745")
    public void setIconifiedByDefault(boolean iconified) {
        if(mIconifiedByDefault == iconified)        
        return;
        mIconifiedByDefault = iconified;
        updateViewsVisibility(iconified);
        updateQueryHint();
        // ---------- Original Method ----------
        //if (mIconifiedByDefault == iconified) return;
        //mIconifiedByDefault = iconified;
        //updateViewsVisibility(iconified);
        //updateQueryHint();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.847 -0400", hash_original_method = "B0C72E24DA4703D19B476F7F5669A367", hash_generated_method = "8052B4B5480A65FDB574312CAAF3A707")
    public boolean isIconfiedByDefault() {
        boolean var240C319CE9511A3C6618BAF616D6A95D_86665347 = (mIconifiedByDefault);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431507048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431507048;
        // ---------- Original Method ----------
        //return mIconifiedByDefault;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.847 -0400", hash_original_method = "1D615B467973354655EE36C4E6E1B780", hash_generated_method = "A8B9611C6E4CED09F69A92B7F090B061")
    public void setIconified(boolean iconify) {
        addTaint(iconify);
        if(iconify)        
        {
            onCloseClicked();
        } //End block
        else
        {
            onSearchClicked();
        } //End block
        // ---------- Original Method ----------
        //if (iconify) {
            //onCloseClicked();
        //} else {
            //onSearchClicked();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.847 -0400", hash_original_method = "844ED2B05054700D6A1A7C47A43DB3F5", hash_generated_method = "7C34161DD2B07BAC4ABD0789D7F2CD9D")
    public boolean isIconified() {
        boolean varE490012EE9B46FF826CCD5B3B6B214A9_592845334 = (mIconified);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808042082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_808042082;
        // ---------- Original Method ----------
        //return mIconified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.848 -0400", hash_original_method = "3C1CA8493C58EB873C43522E7F5B066C", hash_generated_method = "34E7EF197158544A73303BA658DD68FC")
    public void setSubmitButtonEnabled(boolean enabled) {
        mSubmitButtonEnabled = enabled;
        updateViewsVisibility(isIconified());
        // ---------- Original Method ----------
        //mSubmitButtonEnabled = enabled;
        //updateViewsVisibility(isIconified());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.848 -0400", hash_original_method = "A8CFD3302CC6C1FBD45FF4B867C72D5B", hash_generated_method = "58CE869669FDB3A8C5C8B995CDA31388")
    public boolean isSubmitButtonEnabled() {
        boolean varF51306B58E2668509E9043E7735E1FA4_751745979 = (mSubmitButtonEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126967293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126967293;
        // ---------- Original Method ----------
        //return mSubmitButtonEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.849 -0400", hash_original_method = "29051F8E555BD7A9218D5240E768869F", hash_generated_method = "73D925587824CA2A2369A86E172CA3AD")
    public void setQueryRefinementEnabled(boolean enable) {
        mQueryRefinement = enable;
        if(mSuggestionsAdapter instanceof SuggestionsAdapter)        
        {
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        } //End block
        // ---------- Original Method ----------
        //mQueryRefinement = enable;
        //if (mSuggestionsAdapter instanceof SuggestionsAdapter) {
            //((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    //enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.849 -0400", hash_original_method = "A374A24A58636548BF0B2ADA0B696601", hash_generated_method = "1732849AE2242F1B2D8F5B48C3110F67")
    public boolean isQueryRefinementEnabled() {
        boolean var69EE6C3CFA8048276879EF4C552B5C72_2103562051 = (mQueryRefinement);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_984517437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_984517437;
        // ---------- Original Method ----------
        //return mQueryRefinement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.849 -0400", hash_original_method = "23DC9EA74A588F20B69495720EC7B1A3", hash_generated_method = "82E6E3C70E0F49F4867D93600C8A7BAD")
    public void setSuggestionsAdapter(CursorAdapter adapter) {
        mSuggestionsAdapter = adapter;
        mQueryTextView.setAdapter(mSuggestionsAdapter);
        // ---------- Original Method ----------
        //mSuggestionsAdapter = adapter;
        //mQueryTextView.setAdapter(mSuggestionsAdapter);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.850 -0400", hash_original_method = "D43CFDAE734651DCDEBEEE22CB7FB2A7", hash_generated_method = "78B6F7039C9F994C0ADE7009AACC83C2")
    public CursorAdapter getSuggestionsAdapter() {
CursorAdapter varC836E41B4405C7DA08B60A1F24129CF9_645433658 =         mSuggestionsAdapter;
        varC836E41B4405C7DA08B60A1F24129CF9_645433658.addTaint(taint);
        return varC836E41B4405C7DA08B60A1F24129CF9_645433658;
        // ---------- Original Method ----------
        //return mSuggestionsAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.850 -0400", hash_original_method = "8FF296A57B18752E84CEF7286CDC8903", hash_generated_method = "EF695F3DEED2DE41932D6D479BE99F2A")
    public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;
        requestLayout();
        // ---------- Original Method ----------
        //mMaxWidth = maxpixels;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.851 -0400", hash_original_method = "455591DBA8980F8F128C9C99FA0F791A", hash_generated_method = "23E0D763BED8E6CB368C9241EABAED17")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        if(isIconified())        
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        } //End block
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
switch(widthMode){
        case MeasureSpec.AT_MOST:
        if(mMaxWidth > 0)        
        {
            width = Math.min(mMaxWidth, width);
        } //End block
        else
        {
            width = Math.min(getPreferredWidth(), width);
        } //End block
        break;
        case MeasureSpec.EXACTLY:
        if(mMaxWidth > 0)        
        {
            width = Math.min(mMaxWidth, width);
        } //End block
        break;
        case MeasureSpec.UNSPECIFIED:
        width = mMaxWidth > 0 ? mMaxWidth : getPreferredWidth();
        break;
}        widthMode = MeasureSpec.EXACTLY;
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.851 -0400", hash_original_method = "28B5EEA3A28B4F5F076920D5EA4FBBAC", hash_generated_method = "30945952332914F07BB654870985E9E3")
    private int getPreferredWidth() {
        int var314410EEEFF1B29C2124FD496B8E32FD_1375036588 = (getContext().getResources()
                .getDimensionPixelSize(R.dimen.search_view_preferred_width));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298349201 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298349201;
        // ---------- Original Method ----------
        //return getContext().getResources()
                //.getDimensionPixelSize(R.dimen.search_view_preferred_width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.852 -0400", hash_original_method = "7F3DE149B8C5E14764DBC69CC4EE105A", hash_generated_method = "F19080D6A42C7E560ADEC9CECAC4AD25")
    private void updateViewsVisibility(final boolean collapsed) {
        mIconified = collapsed;
        final int visCollapsed = collapsed ? VISIBLE : GONE;
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        updateCloseButton();
        updateVoiceButton(!hasText);
        updateSubmitArea();
        // ---------- Original Method ----------
        //mIconified = collapsed;
        //final int visCollapsed = collapsed ? VISIBLE : GONE;
        //final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        //mSearchButton.setVisibility(visCollapsed);
        //updateSubmitButton(hasText);
        //mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        //mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        //updateCloseButton();
        //updateVoiceButton(!hasText);
        //updateSubmitArea();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.852 -0400", hash_original_method = "1F6B21487B2FA81D5679515DB4F108DF", hash_generated_method = "4643C6D53BD0D0B55FD150C67BA43D36")
    private boolean hasVoiceSearch() {
        if(mSearchable != null && mSearchable.getVoiceSearchEnabled())        
        {
            Intent testIntent = null;
            if(mSearchable.getVoiceSearchLaunchWebSearch())            
            {
                testIntent = mVoiceWebSearchIntent;
            } //End block
            else
            if(mSearchable.getVoiceSearchLaunchRecognizer())            
            {
                testIntent = mVoiceAppSearchIntent;
            } //End block
            if(testIntent != null)            
            {
                ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean var82E36C23D5002FD568E9E6BB87ACB5C6_1717004911 = (ri != null);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1572405109 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1572405109;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_244816054 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480534232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480534232;
        // ---------- Original Method ----------
        //if (mSearchable != null && mSearchable.getVoiceSearchEnabled()) {
            //Intent testIntent = null;
            //if (mSearchable.getVoiceSearchLaunchWebSearch()) {
                //testIntent = mVoiceWebSearchIntent;
            //} else if (mSearchable.getVoiceSearchLaunchRecognizer()) {
                //testIntent = mVoiceAppSearchIntent;
            //}
            //if (testIntent != null) {
                //ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent,
                        //PackageManager.MATCH_DEFAULT_ONLY);
                //return ri != null;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.853 -0400", hash_original_method = "E98BAF533B4581CBC109A603E4339AE5", hash_generated_method = "76C05A529BC3CFFD1FC9BDF87C1C1C98")
    private boolean isSubmitAreaEnabled() {
        boolean varE9F0DE1C0B76C061A087B79ACBBBFDCB_567340180 = ((mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1546916256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1546916256;
        // ---------- Original Method ----------
        //return (mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.853 -0400", hash_original_method = "956EC0D217930FCBDABBCC447139885F", hash_generated_method = "49DD36A803515CE701F944EC17C7E658")
    private void updateSubmitButton(boolean hasText) {
        addTaint(hasText);
        int visibility = GONE;
        if(mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                && (hasText || !mVoiceButtonEnabled))        
        {
            visibility = VISIBLE;
        } //End block
        mSubmitButton.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                //&& (hasText || !mVoiceButtonEnabled)) {
            //visibility = VISIBLE;
        //}
        //mSubmitButton.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.854 -0400", hash_original_method = "FF9871F833F63C36B3921C4F59B0ED2F", hash_generated_method = "740A2C0B2CE571A3324DD7216523C314")
    private void updateSubmitArea() {
        int visibility = GONE;
        if(isSubmitAreaEnabled()
                && (mSubmitButton.getVisibility() == VISIBLE
                        || mVoiceButton.getVisibility() == VISIBLE))        
        {
            visibility = VISIBLE;
        } //End block
        mSubmitArea.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (isSubmitAreaEnabled()
                //&& (mSubmitButton.getVisibility() == VISIBLE
                        //|| mVoiceButton.getVisibility() == VISIBLE)) {
            //visibility = VISIBLE;
        //}
        //mSubmitArea.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.854 -0400", hash_original_method = "31438C0932D7B883B0B6F7C1A8D11C73", hash_generated_method = "24CE7D666A82852EBB54C806573514B2")
    private void updateCloseButton() {
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        final boolean showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        // ---------- Original Method ----------
        //final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        //final boolean showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        //mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        //mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.855 -0400", hash_original_method = "A19187F7BD510E54AC677DCF71153712", hash_generated_method = "E58D53BF8B2730472056F6D862C2F112")
    private void postUpdateFocusedState() {
        post(mUpdateDrawableStateRunnable);
        // ---------- Original Method ----------
        //post(mUpdateDrawableStateRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.855 -0400", hash_original_method = "2FABE728CB7CDC63DD618939E6086EE5", hash_generated_method = "8EE7E2F5D88995D04338ABEAF0F7352A")
    private void updateFocusedState() {
        boolean focused = mQueryTextView.hasFocus();
        mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
        // ---------- Original Method ----------
        //boolean focused = mQueryTextView.hasFocus();
        //mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        //mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.855 -0400", hash_original_method = "466B44C18A399269336D5B13075B3DD5", hash_generated_method = "541E8F066DEA567D4C20FD5E338EC369")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeCallbacks(mUpdateDrawableStateRunnable);
        post(mReleaseCursorRunnable);
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //removeCallbacks(mUpdateDrawableStateRunnable);
        //post(mReleaseCursorRunnable);
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.856 -0400", hash_original_method = "10C83777364EAA061E75B08DB527338D", hash_generated_method = "08711110AD11BC0D9126A2797350EE29")
    private void setImeVisibility(final boolean visible) {
        addTaint(visible);
        if(visible)        
        {
            post(mShowImeRunnable);
        } //End block
        else
        {
            removeCallbacks(mShowImeRunnable);
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imm != null)            
            {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visible) {
            //post(mShowImeRunnable);
        //} else {
            //removeCallbacks(mShowImeRunnable);
            //InputMethodManager imm = (InputMethodManager)
                    //getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            //if (imm != null) {
                //imm.hideSoftInputFromWindow(getWindowToken(), 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.856 -0400", hash_original_method = "364D10214479FA13BFF6BDB192F3E0CD", hash_generated_method = "D1087538E73CB9ADE78F4C5C6B3A5CDB")
     void onQueryRefine(CharSequence queryText) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(queryText.getTaint());
        setQuery(queryText);
        // ---------- Original Method ----------
        //setQuery(queryText);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.857 -0400", hash_original_method = "E2E8A56E8AA279DA8CFFA9FDDF535879", hash_generated_method = "3AA705BF01F0B15CC9E235BAF9891C05")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(mSearchable == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1169739750 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1933903734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1933903734;
        } //End block
        SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
        if((actionKey != null) && (actionKey.getQueryActionMsg() != null))        
        {
            launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView.getText()
                    .toString());
            boolean varB326B5062B2F0E69046810717534CB09_1859991119 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107328951 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107328951;
        } //End block
        boolean var947F0C250323B9F4475E02588E9A9740_1194154043 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144892510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144892510;
        // ---------- Original Method ----------
        //if (mSearchable == null) {
            //return false;
        //}
        //SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
        //if ((actionKey != null) && (actionKey.getQueryActionMsg() != null)) {
            //launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView.getText()
                    //.toString());
            //return true;
        //}
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.858 -0400", hash_original_method = "2292125EFE6589DCDAE880647EC125AA", hash_generated_method = "4000A5B4C5FD55E61524B04136DACC83")
    private boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(v.getTaint());
        if(mSearchable == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_542609355 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040855634 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040855634;
        } //End block
        if(mSuggestionsAdapter == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_688694811 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161872932 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161872932;
        } //End block
        if(event.getAction() == KeyEvent.ACTION_DOWN && event.hasNoModifiers())        
        {
            if(keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_SEARCH
                    || keyCode == KeyEvent.KEYCODE_TAB)            
            {
                int position = mQueryTextView.getListSelection();
                boolean var63B764998048DFFC77D0C19B9215E0AB_1222366054 = (onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330795809 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_330795809;
            } //End block
            if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT || keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)            
            {
                int selPoint = (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) ? 0 : mQueryTextView
                        .length();
                mQueryTextView.setSelection(selPoint);
                mQueryTextView.setListSelection(0);
                mQueryTextView.clearListSelection();
                mQueryTextView.ensureImeVisible(true);
                boolean varB326B5062B2F0E69046810717534CB09_65677447 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438983454 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438983454;
            } //End block
            if(keyCode == KeyEvent.KEYCODE_DPAD_UP && 0 == mQueryTextView.getListSelection())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1709426044 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161027255 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161027255;
            } //End block
            SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
            if((actionKey != null)
                    && ((actionKey.getSuggestActionMsg() != null) || (actionKey
                            .getSuggestActionMsgColumn() != null)))            
            {
                int position = mQueryTextView.getListSelection();
                if(position != ListView.INVALID_POSITION)                
                {
                    Cursor c = mSuggestionsAdapter.getCursor();
                    if(c.moveToPosition(position))                    
                    {
                        final String actionMsg = getActionKeyMessage(c, actionKey);
                        if(actionMsg != null && (actionMsg.length() > 0))                        
                        {
                            boolean varF716A8B12344019AD7C804FE05DA9905_53539924 = (onItemClicked(position, keyCode, actionMsg));
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919861585 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_919861585;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_303014355 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744612281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744612281;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static String getActionKeyMessage(Cursor c, SearchableInfo.ActionKeyInfo actionKey) {
        String result = null;
        final String column = actionKey.getSuggestActionMsgColumn();
        if (column != null) {
            result = SuggestionsAdapter.getColumnString(c, column);
        }
        if (result == null) {
            result = actionKey.getSuggestActionMsg();
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.860 -0400", hash_original_method = "587CD5DA65D790D90BAF0DE8B5BB2354", hash_generated_method = "ED6886EB3A0A1C66A93137EF2E62C6F6")
    private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(com.android.internal.R.attr.searchViewSearchIcon,
                outValue, true);
        int varCD80A69664CE0746D900F8403A3EB6B3_390881118 = (outValue.resourceId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896963838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_896963838;
        // ---------- Original Method ----------
        //TypedValue outValue = new TypedValue();
        //getContext().getTheme().resolveAttribute(com.android.internal.R.attr.searchViewSearchIcon,
                //outValue, true);
        //return outValue.resourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.861 -0400", hash_original_method = "BEC25B8B383259674E4804BA5A8143D3", hash_generated_method = "9F92E94CC3B7EA7812F8996D96B90279")
    private CharSequence getDecoratedHint(CharSequence hintText) {
        addTaint(hintText.getTaint());
        if(!mIconifiedByDefault)        
        {
CharSequence var05229D46C9F50D26451D3577D5D05DAF_763525123 =         hintText;
        var05229D46C9F50D26451D3577D5D05DAF_763525123.addTaint(taint);
        return var05229D46C9F50D26451D3577D5D05DAF_763525123;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
CharSequence varB7541BF5224ED050F3AA81EEC9EC1EE6_1571708700 =         ssb;
        varB7541BF5224ED050F3AA81EEC9EC1EE6_1571708700.addTaint(taint);
        return varB7541BF5224ED050F3AA81EEC9EC1EE6_1571708700;
        // ---------- Original Method ----------
        //if (!mIconifiedByDefault) return hintText;
        //SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        //ssb.append(hintText);
        //Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        //int textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        //searchIcon.setBounds(0, 0, textSize, textSize);
        //ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //return ssb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.862 -0400", hash_original_method = "86FF55CF6755F81D1B5EAA7CA81FA50B", hash_generated_method = "DB0A91532146866E385EE379AA7E30C7")
    private void updateQueryHint() {
        if(mQueryHint != null)        
        {
            mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        } //End block
        else
        if(mSearchable != null)        
        {
            CharSequence hint = null;
            int hintId = mSearchable.getHintId();
            if(hintId != 0)            
            {
                hint = getContext().getString(hintId);
            } //End block
            if(hint != null)            
            {
                mQueryTextView.setHint(getDecoratedHint(hint));
            } //End block
        } //End block
        else
        {
            mQueryTextView.setHint(getDecoratedHint(""));
        } //End block
        // ---------- Original Method ----------
        //if (mQueryHint != null) {
            //mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        //} else if (mSearchable != null) {
            //CharSequence hint = null;
            //int hintId = mSearchable.getHintId();
            //if (hintId != 0) {
                //hint = getContext().getString(hintId);
            //}
            //if (hint != null) {
                //mQueryTextView.setHint(getDecoratedHint(hint));
            //}
        //} else {
            //mQueryTextView.setHint(getDecoratedHint(""));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.864 -0400", hash_original_method = "923331D2E7E4B81B915A368FF3E97F8B", hash_generated_method = "876960BF7AD46AF2C816E8E65488D506")
    private void updateSearchAutoComplete() {
        mQueryTextView.setDropDownAnimationStyle(0);
        mQueryTextView.setThreshold(mSearchable.getSuggestThreshold());
        mQueryTextView.setImeOptions(mSearchable.getImeOptions());
        int inputType = mSearchable.getInputType();
        if((inputType & InputType.TYPE_MASK_CLASS) == InputType.TYPE_CLASS_TEXT)        
        {
            inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            if(mSearchable.getSuggestAuthority() != null)            
            {
                inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            } //End block
        } //End block
        mQueryTextView.setInputType(inputType);
        if(mSuggestionsAdapter != null)        
        {
            mSuggestionsAdapter.changeCursor(null);
        } //End block
        if(mSearchable.getSuggestAuthority() != null)        
        {
            mSuggestionsAdapter = new SuggestionsAdapter(getContext(),
                    this, mSearchable, mOutsideDrawablesCache);
            mQueryTextView.setAdapter(mSuggestionsAdapter);
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    mQueryRefinement ? SuggestionsAdapter.REFINE_ALL
                    : SuggestionsAdapter.REFINE_BY_ENTRY);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.865 -0400", hash_original_method = "3C9F3ABEF9459DE6C607B751B6CB866E", hash_generated_method = "0432811E5C3057CFEAF0552161C7FF95")
    private void updateVoiceButton(boolean empty) {
        addTaint(empty);
        int visibility = GONE;
        if(mVoiceButtonEnabled && !isIconified() && empty)        
        {
            visibility = VISIBLE;
            mSubmitButton.setVisibility(GONE);
        } //End block
        mVoiceButton.setVisibility(visibility);
        // ---------- Original Method ----------
        //int visibility = GONE;
        //if (mVoiceButtonEnabled && !isIconified() && empty) {
            //visibility = VISIBLE;
            //mSubmitButton.setVisibility(GONE);
        //}
        //mVoiceButton.setVisibility(visibility);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.865 -0400", hash_original_method = "1411F54CFFACC3FC33F099091662F124", hash_generated_method = "E0FF5CC689634B884A465BA6C619A7D7")
    private void onTextChanged(CharSequence newText) {
        CharSequence text = mQueryTextView.getText();
        mUserQuery = text;
        boolean hasText = !TextUtils.isEmpty(text);
        updateSubmitButton(hasText);
        updateVoiceButton(!hasText);
        updateCloseButton();
        updateSubmitArea();
        if(mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText))        
        {
            mOnQueryChangeListener.onQueryTextChange(newText.toString());
        } //End block
        mOldQueryText = newText.toString();
        // ---------- Original Method ----------
        //CharSequence text = mQueryTextView.getText();
        //mUserQuery = text;
        //boolean hasText = !TextUtils.isEmpty(text);
        //updateSubmitButton(hasText);
        //updateVoiceButton(!hasText);
        //updateCloseButton();
        //updateSubmitArea();
        //if (mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText)) {
            //mOnQueryChangeListener.onQueryTextChange(newText.toString());
        //}
        //mOldQueryText = newText.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.866 -0400", hash_original_method = "5AEA0BD14CD513B7E21145454A43DADF", hash_generated_method = "802621FA35C5719BFBECC4FE692CC48A")
    private void onSubmitQuery() {
        CharSequence query = mQueryTextView.getText();
        if(query != null && TextUtils.getTrimmedLength(query) > 0)        
        {
            if(mOnQueryChangeListener == null
                    || !mOnQueryChangeListener.onQueryTextSubmit(query.toString()))            
            {
                if(mSearchable != null)                
                {
                    launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                    setImeVisibility(false);
                } //End block
                dismissSuggestions();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //CharSequence query = mQueryTextView.getText();
        //if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            //if (mOnQueryChangeListener == null
                    //|| !mOnQueryChangeListener.onQueryTextSubmit(query.toString())) {
                //if (mSearchable != null) {
                    //launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                    //setImeVisibility(false);
                //}
                //dismissSuggestions();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.866 -0400", hash_original_method = "8D9A2C9AF67AD5F3EB2818A3F7453E73", hash_generated_method = "D7D68B4D8980045DB76C85CF1D652798")
    private void dismissSuggestions() {
        mQueryTextView.dismissDropDown();
        // ---------- Original Method ----------
        //mQueryTextView.dismissDropDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.867 -0400", hash_original_method = "E1C21CB17E5E6548A25ED1EEE1C98C9D", hash_generated_method = "3812D7237ED552D7149E42D01C609C52")
    private void onCloseClicked() {
        CharSequence text = mQueryTextView.getText();
        if(TextUtils.isEmpty(text))        
        {
            if(mIconifiedByDefault)            
            {
                if(mOnCloseListener == null || !mOnCloseListener.onClose())                
                {
                    clearFocus();
                    updateViewsVisibility(true);
                } //End block
            } //End block
        } //End block
        else
        {
            mQueryTextView.setText("");
            mQueryTextView.requestFocus();
            setImeVisibility(true);
        } //End block
        // ---------- Original Method ----------
        //CharSequence text = mQueryTextView.getText();
        //if (TextUtils.isEmpty(text)) {
            //if (mIconifiedByDefault) {
                //if (mOnCloseListener == null || !mOnCloseListener.onClose()) {
                    //clearFocus();
                    //updateViewsVisibility(true);
                //}
            //}
        //} else {
            //mQueryTextView.setText("");
            //mQueryTextView.requestFocus();
            //setImeVisibility(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.867 -0400", hash_original_method = "4C174341C531719A99E642D8022F787E", hash_generated_method = "AD3CF6DACCEEFB1DA72B0BA2672593C8")
    private void onSearchClicked() {
        updateViewsVisibility(false);
        mQueryTextView.requestFocus();
        setImeVisibility(true);
        if(mOnSearchClickListener != null)        
        {
            mOnSearchClickListener.onClick(this);
        } //End block
        // ---------- Original Method ----------
        //updateViewsVisibility(false);
        //mQueryTextView.requestFocus();
        //setImeVisibility(true);
        //if (mOnSearchClickListener != null) {
            //mOnSearchClickListener.onClick(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.868 -0400", hash_original_method = "5B2168D9C175988BD80847D561C5C5CC", hash_generated_method = "0495CEF7029815A4BD788E52F7F79A35")
    private void onVoiceClicked() {
        if(mSearchable == null)        
        {
            return;
        } //End block
        SearchableInfo searchable = mSearchable;
        try 
        {
            if(searchable.getVoiceSearchLaunchWebSearch())            
            {
                Intent webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        searchable);
                getContext().startActivity(webSearchIntent);
            } //End block
            else
            if(searchable.getVoiceSearchLaunchRecognizer())            
            {
                Intent appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        searchable);
                getContext().startActivity(appSearchIntent);
            } //End block
        } //End block
        catch (ActivityNotFoundException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (mSearchable == null) {
            //return;
        //}
        //SearchableInfo searchable = mSearchable;
        //try {
            //if (searchable.getVoiceSearchLaunchWebSearch()) {
                //Intent webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        //searchable);
                //getContext().startActivity(webSearchIntent);
            //} else if (searchable.getVoiceSearchLaunchRecognizer()) {
                //Intent appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        //searchable);
                //getContext().startActivity(appSearchIntent);
            //}
        //} catch (ActivityNotFoundException e) {
            //Log.w(LOG_TAG, "Could not find voice search activity");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.868 -0400", hash_original_method = "4D3FC77D85FEC9D80C6560FAE74CDA60", hash_generated_method = "57549D10DB73BE10967D8EC344DCF0DB")
     void onTextFocusChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        if(mQueryTextView.hasFocus())        
        {
            forceSuggestionQuery();
        } //End block
        // ---------- Original Method ----------
        //updateViewsVisibility(isIconified());
        //postUpdateFocusedState();
        //if (mQueryTextView.hasFocus()) {
            //forceSuggestionQuery();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.869 -0400", hash_original_method = "6BC34AF35099192BA7E60BCC11E3C756", hash_generated_method = "F312F39D5A9A10844FA0239A2329F3A9")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
        // ---------- Original Method ----------
        //super.onWindowFocusChanged(hasWindowFocus);
        //postUpdateFocusedState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.869 -0400", hash_original_method = "5D7477A3D9C6D568A19E621F4FAE5DD7", hash_generated_method = "657A76175C5C027E0A83AC8F0E70E279")
    @Override
    public void onActionViewCollapsed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearFocus();
        updateViewsVisibility(true);
        mQueryTextView.setImeOptions(mCollapsedImeOptions);
        mExpandedInActionView = false;
        // ---------- Original Method ----------
        //clearFocus();
        //updateViewsVisibility(true);
        //mQueryTextView.setImeOptions(mCollapsedImeOptions);
        //mExpandedInActionView = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.870 -0400", hash_original_method = "F734C19BE6B7D5E142C7745125215DDF", hash_generated_method = "446B126DD2AC9E88B342ACDAE0ADBF97")
    @Override
    public void onActionViewExpanded() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mExpandedInActionView)        
        return;
        mExpandedInActionView = true;
        mCollapsedImeOptions = mQueryTextView.getImeOptions();
        mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        mQueryTextView.setText("");
        setIconified(false);
        // ---------- Original Method ----------
        //if (mExpandedInActionView) return;
        //mExpandedInActionView = true;
        //mCollapsedImeOptions = mQueryTextView.getImeOptions();
        //mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        //mQueryTextView.setText("");
        //setIconified(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.870 -0400", hash_original_method = "C8142821EB0396ABFD0EB3B305480E27", hash_generated_method = "9FFC244716A34EC3A7AB2CDDA3F001E7")
    private void adjustDropDownSizeAndPosition() {
        if(mDropDownAnchor.getWidth() > 1)        
        {
            Resources res = getContext().getResources();
            int anchorPadding = mSearchPlate.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            int iconOffset = mIconifiedByDefault
                    ? res.getDimensionPixelSize(R.dimen.dropdownitem_icon_width)
                    + res.getDimensionPixelSize(R.dimen.dropdownitem_text_padding_left)
                    : 0;
            mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
            mQueryTextView.setDropDownHorizontalOffset(-(dropDownPadding.left + iconOffset)
                    + anchorPadding);
            mQueryTextView.setDropDownWidth(mDropDownAnchor.getWidth() + dropDownPadding.left
                    + dropDownPadding.right + iconOffset - (anchorPadding));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.871 -0400", hash_original_method = "5FDC493391F791D62FF75AE849BF4213", hash_generated_method = "817A7AB2B5FC71712025236E36E88BE6")
    private boolean onItemClicked(int position, int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        addTaint(position);
        if(mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionClick(position))        
        {
            launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
            setImeVisibility(false);
            dismissSuggestions();
            boolean varB326B5062B2F0E69046810717534CB09_1548928038 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033819221 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033819221;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1613027189 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268097151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268097151;
        // ---------- Original Method ----------
        //if (mOnSuggestionListener == null
                //|| !mOnSuggestionListener.onSuggestionClick(position)) {
            //launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
            //setImeVisibility(false);
            //dismissSuggestions();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.871 -0400", hash_original_method = "08FFA8C71E803D9BC52878D0BDC1227B", hash_generated_method = "0DE9FC3ED20BAFB7B01B6365598D7536")
    private boolean onItemSelected(int position) {
        addTaint(position);
        if(mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionSelect(position))        
        {
            rewriteQueryFromSuggestion(position);
            boolean varB326B5062B2F0E69046810717534CB09_1515831972 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1384005945 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1384005945;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_951429288 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965430866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965430866;
        // ---------- Original Method ----------
        //if (mOnSuggestionListener == null
                //|| !mOnSuggestionListener.onSuggestionSelect(position)) {
            //rewriteQueryFromSuggestion(position);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.872 -0400", hash_original_method = "FE5C7BD493A3B7C4988BF7B094450FE1", hash_generated_method = "8CB83939358B0B59D16425722A3C3915")
    private void rewriteQueryFromSuggestion(int position) {
        addTaint(position);
        CharSequence oldQuery = mQueryTextView.getText();
        Cursor c = mSuggestionsAdapter.getCursor();
        if(c == null)        
        {
            return;
        } //End block
        if(c.moveToPosition(position))        
        {
            CharSequence newQuery = mSuggestionsAdapter.convertToString(c);
            if(newQuery != null)            
            {
                setQuery(newQuery);
            } //End block
            else
            {
                setQuery(oldQuery);
            } //End block
        } //End block
        else
        {
            setQuery(oldQuery);
        } //End block
        // ---------- Original Method ----------
        //CharSequence oldQuery = mQueryTextView.getText();
        //Cursor c = mSuggestionsAdapter.getCursor();
        //if (c == null) {
            //return;
        //}
        //if (c.moveToPosition(position)) {
            //CharSequence newQuery = mSuggestionsAdapter.convertToString(c);
            //if (newQuery != null) {
                //setQuery(newQuery);
            //} else {
                //setQuery(oldQuery);
            //}
        //} else {
            //setQuery(oldQuery);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.873 -0400", hash_original_method = "1026A945AA7D5E936A04225BB74423F6", hash_generated_method = "05E72C80776422F10932111DA5CA98E2")
    private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        addTaint(position);
        Cursor c = mSuggestionsAdapter.getCursor();
        if((c != null) && c.moveToPosition(position))        
        {
            Intent intent = createIntentFromSuggestion(c, actionKey, actionMsg);
            launchIntent(intent);
            boolean varB326B5062B2F0E69046810717534CB09_315001298 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962630877 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_962630877;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1119580520 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602783992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602783992;
        // ---------- Original Method ----------
        //Cursor c = mSuggestionsAdapter.getCursor();
        //if ((c != null) && c.moveToPosition(position)) {
            //Intent intent = createIntentFromSuggestion(c, actionKey, actionMsg);
            //launchIntent(intent);
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.873 -0400", hash_original_method = "B092F13CA13C6A372C37DCEFCF94B5BC", hash_generated_method = "18FF810E17310C3371DD05FA1EF81F7C")
    private void launchIntent(Intent intent) {
        addTaint(intent.getTaint());
        if(intent == null)        
        {
            return;
        } //End block
        try 
        {
            getContext().startActivity(intent);
        } //End block
        catch (RuntimeException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //if (intent == null) {
            //return;
        //}
        //try {
            //getContext().startActivity(intent);
        //} catch (RuntimeException ex) {
            //Log.e(LOG_TAG, "Failed launch activity: " + intent, ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.873 -0400", hash_original_method = "39B31EC96E94C2151059B7594679485C", hash_generated_method = "AE74AA2CCFACA92F82D4AB0110C12415")
    private void setQuery(CharSequence query) {
        addTaint(query.getTaint());
        mQueryTextView.setText(query, true);
        mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
        // ---------- Original Method ----------
        //mQueryTextView.setText(query, true);
        //mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.874 -0400", hash_original_method = "A610C255BB7D93FEE4A49CEF406D7E3C", hash_generated_method = "62676E979FA343AA302F4D0BBE608A5A")
    private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        addTaint(query.getTaint());
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        getContext().startActivity(intent);
        // ---------- Original Method ----------
        //String action = Intent.ACTION_SEARCH;
        //Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        //getContext().startActivity(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.874 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "A6BCE38529BD3A06A3106CEF9A986793")
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        addTaint(query.getTaint());
        addTaint(extraData.getTaint());
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(data != null)        
        {
            intent.setData(data);
        } //End block
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        if(query != null)        
        {
            intent.putExtra(SearchManager.QUERY, query);
        } //End block
        if(extraData != null)        
        {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        } //End block
        if(mAppSearchData != null)        
        {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        } //End block
        if(actionKey != KeyEvent.KEYCODE_UNKNOWN)        
        {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        } //End block
        intent.setComponent(mSearchable.getSearchActivity());
Intent var095937E5B36214360A2644916BF0E8DF_1039486951 =         intent;
        var095937E5B36214360A2644916BF0E8DF_1039486951.addTaint(taint);
        return var095937E5B36214360A2644916BF0E8DF_1039486951;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.875 -0400", hash_original_method = "88ED2A4CD1E55FCB278985A3652D43A1", hash_generated_method = "15BA39194A4E4F14EC5EC1EE155FBE63")
    private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        addTaint(searchable.getTaint());
        addTaint(baseIntent.getTaint());
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
Intent var9DA5CAE69AD9A8348DD309D3014AC2CA_124380574 =         voiceIntent;
        var9DA5CAE69AD9A8348DD309D3014AC2CA_124380574.addTaint(taint);
        return var9DA5CAE69AD9A8348DD309D3014AC2CA_124380574;
        // ---------- Original Method ----------
        //Intent voiceIntent = new Intent(baseIntent);
        //ComponentName searchActivity = searchable.getSearchActivity();
        //voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                //: searchActivity.flattenToShortString());
        //return voiceIntent;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.876 -0400", hash_original_method = "7F7E8A56997E65BDFC7ADF14F1E923E9", hash_generated_method = "17429A7FD6F022B14984E6FD1A2BA2F6")
    private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        addTaint(searchable.getTaint());
        addTaint(baseIntent.getTaint());
        ComponentName searchActivity = searchable.getSearchActivity();
        Intent queryIntent = new Intent(Intent.ACTION_SEARCH);
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent,
                PendingIntent.FLAG_ONE_SHOT);
        Bundle queryExtras = new Bundle();
        Intent voiceIntent = new Intent(baseIntent);
        String languageModel = RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
        String prompt = null;
        String language = null;
        int maxResults = 1;
        Resources resources = getResources();
        if(searchable.getVoiceLanguageModeId() != 0)        
        {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        } //End block
        if(searchable.getVoicePromptTextId() != 0)        
        {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        } //End block
        if(searchable.getVoiceLanguageId() != 0)        
        {
            language = resources.getString(searchable.getVoiceLanguageId());
        } //End block
        if(searchable.getVoiceMaxResults() != 0)        
        {
            maxResults = searchable.getVoiceMaxResults();
        } //End block
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, languageModel);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, prompt);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, maxResults);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, pending);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, queryExtras);
Intent var9DA5CAE69AD9A8348DD309D3014AC2CA_1017424333 =         voiceIntent;
        var9DA5CAE69AD9A8348DD309D3014AC2CA_1017424333.addTaint(taint);
        return var9DA5CAE69AD9A8348DD309D3014AC2CA_1017424333;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.878 -0400", hash_original_method = "830957C509294E2BDC3732D8A42E8F7A", hash_generated_method = "9AECC35BF6D18546183C12EC69A8E29D")
    private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        addTaint(actionMsg.getTaint());
        addTaint(actionKey);
        addTaint(c.getTaint());
        try 
        {
            String action = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);
            if(action == null)            
            {
                action = mSearchable.getSuggestIntentAction();
            } //End block
            if(action == null)            
            {
                action = Intent.ACTION_SEARCH;
            } //End block
            String data = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            if(data == null)            
            {
                data = mSearchable.getSuggestIntentData();
            } //End block
            if(data != null)            
            {
                String id = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
                if(id != null)                
                {
                    data = data + "/" + Uri.encode(id);
                } //End block
            } //End block
            Uri dataUri = (data == null) ? null : Uri.parse(data);
            String query = getColumnString(c, SearchManager.SUGGEST_COLUMN_QUERY);
            String extraData = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA);
Intent varE35F359D165AC7F8F3391F4799F6DBB1_730089063 =             createIntent(action, dataUri, extraData, query, actionKey, actionMsg);
            varE35F359D165AC7F8F3391F4799F6DBB1_730089063.addTaint(taint);
            return varE35F359D165AC7F8F3391F4799F6DBB1_730089063;
        } //End block
        catch (RuntimeException e)
        {
            int rowNum;
            try 
            {
                rowNum = c.getPosition();
            } //End block
            catch (RuntimeException e2)
            {
                rowNum = -1;
            } //End block
Intent var540C13E9E156B687226421B24F2DF178_1033482812 =             null;
            var540C13E9E156B687226421B24F2DF178_1033482812.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1033482812;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.879 -0400", hash_original_method = "7E9F5D2AEBB04ECB1BF9832E28C48CE5", hash_generated_method = "842B7E3CB61461A203AD10E7DC7E1B6F")
    private void forceSuggestionQuery() {
        mQueryTextView.doBeforeTextChanged();
        mQueryTextView.doAfterTextChanged();
        // ---------- Original Method ----------
        //mQueryTextView.doBeforeTextChanged();
        //mQueryTextView.doAfterTextChanged();
    }

    
    static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    public static class SearchAutoComplete extends AutoCompleteTextView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.879 -0400", hash_original_field = "3C3C53D359DFC0BF874C1D7D1521B140", hash_generated_field = "2B2FC0AB3F9DED44C14A982417EA1993")

        private int mThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.879 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

        private SearchView mSearchView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.880 -0400", hash_original_method = "0EFA734BA823B47BC95B6AD45B9E23E2", hash_generated_method = "0911BD1B4E31E83CE8103B98B4122121")
        public  SearchAutoComplete(Context context) {
            super(context);
            addTaint(context.getTaint());
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.880 -0400", hash_original_method = "D2F6F380F4593BE38169820FCC450031", hash_generated_method = "0516E2ED8D08DA6CE4E482894C8BE3B2")
        public  SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.881 -0400", hash_original_method = "6D01382B108C5B979A3DE77D2755BA0A", hash_generated_method = "A986D7B0133C286B33CE6D5EDAE40098")
        public  SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            addTaint(defStyle);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            mThreshold = getThreshold();
            // ---------- Original Method ----------
            //mThreshold = getThreshold();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.881 -0400", hash_original_method = "BBDE2605DAB20A62DF5DDA8DAF1B33B9", hash_generated_method = "0D212706D2CE79F99D27416EE240A973")
         void setSearchView(SearchView searchView) {
            mSearchView = searchView;
            // ---------- Original Method ----------
            //mSearchView = searchView;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.882 -0400", hash_original_method = "2A2464279ECB52A9D86939A6AE2D6FFF", hash_generated_method = "688D0A5C066F7B7BC80C28BA72699E5D")
        @Override
        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            mThreshold = threshold;
            // ---------- Original Method ----------
            //super.setThreshold(threshold);
            //mThreshold = threshold;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.882 -0400", hash_original_method = "BA394CC4782335931E16390E53BDBA7F", hash_generated_method = "8D0CE20015AB501DC835A3FC85B30C88")
        private boolean isEmpty() {
            boolean var0F796EE0E04360F3B8250FD6792C943E_2039404241 = (TextUtils.getTrimmedLength(getText()) == 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367583089 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_367583089;
            // ---------- Original Method ----------
            //return TextUtils.getTrimmedLength(getText()) == 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.883 -0400", hash_original_method = "04EDD552CD5932834AB8E3EAD2670FCB", hash_generated_method = "2E00CC1DC27537AD22A88B7817BCCBE4")
        @Override
        protected void replaceText(CharSequence text) {
            addTaint(text.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.883 -0400", hash_original_method = "BBB8F048947DA4F8E171ED984E24E3AE", hash_generated_method = "65E30508731680C780234FF5491E8384")
        @Override
        public void performCompletion() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.884 -0400", hash_original_method = "3777C1088ADE560024EE2C32D034B492", hash_generated_method = "1035DE14D5988B77196BC6F5A4269CF0")
        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(hasWindowFocus);
            super.onWindowFocusChanged(hasWindowFocus);
            if(hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE)            
            {
                InputMethodManager inputManager = (InputMethodManager) getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(this, 0);
                if(isLandscapeMode(getContext()))                
                {
                    ensureImeVisible(true);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //super.onWindowFocusChanged(hasWindowFocus);
            //if (hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE) {
                //InputMethodManager inputManager = (InputMethodManager) getContext()
                        //.getSystemService(Context.INPUT_METHOD_SERVICE);
                //inputManager.showSoftInput(this, 0);
                //if (isLandscapeMode(getContext())) {
                    //ensureImeVisible(true);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.884 -0400", hash_original_method = "5F63BE621D8AAF87B5CC12EFB3AE40CE", hash_generated_method = "C1EA6C7BDBB5157DFAB67FE1484CC426")
        @Override
        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(previouslyFocusedRect.getTaint());
            addTaint(direction);
            addTaint(focused);
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            mSearchView.onTextFocusChanged();
            // ---------- Original Method ----------
            //super.onFocusChanged(focused, direction, previouslyFocusedRect);
            //mSearchView.onTextFocusChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.885 -0400", hash_original_method = "E5C7430DC03439C4054C8D137460F5A5", hash_generated_method = "B92E435A956ABF7B713900B8392C3BFC")
        @Override
        public boolean enoughToFilter() {
            boolean var162B72EE579B604D46B00E836B96BA04_2099596800 = (mThreshold <= 0 || super.enoughToFilter());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874877704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874877704;
            // ---------- Original Method ----------
            //return mThreshold <= 0 || super.enoughToFilter();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.885 -0400", hash_original_method = "AB0021D21F9078098334FA1D38399275", hash_generated_method = "A48EDB71C32980DB508CD6B0C95902BD")
        @Override
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(keyCode);
            if(keyCode == KeyEvent.KEYCODE_BACK)            
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null)                    
                    {
                        state.startTracking(event, this);
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_779132338 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536158768 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536158768;
                } //End block
                else
                if(event.getAction() == KeyEvent.ACTION_UP)                
                {
                    KeyEvent.DispatcherState state = getKeyDispatcherState();
                    if(state != null)                    
                    {
                        state.handleUpEvent(event);
                    } //End block
                    if(event.isTracking() && !event.isCanceled())                    
                    {
                        mSearchView.clearFocus();
                        mSearchView.setImeVisibility(false);
                        boolean varB326B5062B2F0E69046810717534CB09_1263325874 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336963970 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336963970;
                    } //End block
                } //End block
            } //End block
            boolean varD211DC142BF75E7E3C7CE1C752BD391A_1795148147 = (super.onKeyPreIme(keyCode, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920368847 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920368847;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public interface OnQueryTextListener {

        
        boolean onQueryTextSubmit(String query);

        
        boolean onQueryTextChange(String newText);
    }
    
    public interface OnCloseListener {

        
        boolean onClose();
    }
    
    public interface OnSuggestionListener {

        
        boolean onSuggestionSelect(int position);

        
        boolean onSuggestionClick(int position);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.886 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.886 -0400", hash_original_field = "0587D8CE40F7F4AC1343388C2FEA1ED4", hash_generated_field = "DEE7E6EBCAD52D0BE04774C5F3845528")

    private static final String LOG_TAG = "SearchView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:04.886 -0400", hash_original_field = "B8CF89EB7E6552EBC5C9FCBB33074205", hash_generated_field = "7875B207C54E2B6D5ABF1652FFF3F22A")

    private static final String IME_OPTION_NO_MICROPHONE = "nm";
}

