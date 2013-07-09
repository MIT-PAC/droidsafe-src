package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "F0FC83112FD93E69838BD6DEF95F60C7", hash_generated_field = "20DE7328B76C4576C54CEA1C31A5A5DD")

    private OnQueryTextListener mOnQueryChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "47454ABD361EC45738FEDA04F526AE1A", hash_generated_field = "3E6EDBFCD15829E88C823AD6BD9DA13F")

    private OnCloseListener mOnCloseListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "2E08BF2645EEF4C8B5A42084F390A4B5", hash_generated_field = "5ED7A88B9A58B568EB225F4FC003710B")

    private OnFocusChangeListener mOnQueryTextFocusChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "8DC5B64EAC058B5083CAE814ADBD7ED0", hash_generated_field = "8D8A066C35D08D2636C4C1260524D2BF")

    private OnSuggestionListener mOnSuggestionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "9F1F9A6115F6CABB1E5C631E50B730EC", hash_generated_field = "4CE2C18E09AA7469BBEF676CF87B216F")

    private OnClickListener mOnSearchClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "240C319CE9511A3C6618BAF616D6A95D", hash_generated_field = "DBB17EC605FD9389E7F62B38DE47A3A4")

    private boolean mIconifiedByDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "E490012EE9B46FF826CCD5B3B6B214A9", hash_generated_field = "77805A492451B977E1816BA9783A9397")

    private boolean mIconified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "63055E537713F24C4C86BE6E68415FCE", hash_generated_field = "2E9A26C4761764604246CFEB2C060F9B")

    private CursorAdapter mSuggestionsAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "B09C96F2B0035B8D0A17B69A9CB42922", hash_generated_field = "95F86E17693F7357E97225DE31C237B8")

    private View mSearchButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "4D64642D297528CE69B9092F8D62B333", hash_generated_field = "5B6BED2A64238CE3908B3B8A74F943A0")

    private View mSubmitButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "01BCA17D3E9DDD8BF5B44F3E2EF1EE68", hash_generated_field = "BFE96959B9AF28F7C0E58BC61493C3DB")

    private View mSearchPlate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.770 -0400", hash_original_field = "2BCB8DD6DB0886263B47A791A5E5A95E", hash_generated_field = "BC8307BFA7D8BAD259EA185F504A6263")

    private View mSubmitArea;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "9FCA0F272C23938FFED9C87C327F80A4", hash_generated_field = "F2F2EE3489EA7D1D3E79DE10F3C92864")

    private ImageView mCloseButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "3B421A34FA7A3F6F502112270464063B", hash_generated_field = "FA2C49A395FA13278ED063933D3B9887")

    private View mSearchEditFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "82862F97F98548A9593F66521F19EB37", hash_generated_field = "008F39BAA0ECCE0EB48B634A42A71E8D")

    private View mVoiceButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "FCAFC8BB77AF346B28F95EAD1A6AEA60", hash_generated_field = "2624CFC6240E328ABC658DAF35FB4ED1")

    private SearchAutoComplete mQueryTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "90D72399639ED88F9BD367E5BF80885E", hash_generated_field = "843247771C656AC3967CC38CD7762802")

    private View mDropDownAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "4DC96DD56935DDDBBA65DBA5782C5A44", hash_generated_field = "E9A5F2E0A5AECD994F77BB6139C386D7")

    private ImageView mSearchHintIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "F51306B58E2668509E9043E7735E1FA4", hash_generated_field = "F0EDF0CA4EF3F26D48862E3A0541ACC7")

    private boolean mSubmitButtonEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "F19769AB62A92C3C10630D0D10DC860A", hash_generated_field = "986A565C1B04C031BC149F5E489100AA")

    private CharSequence mQueryHint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "69EE6C3CFA8048276879EF4C552B5C72", hash_generated_field = "E038E258E9530F2A3E67A290C3460468")

    private boolean mQueryRefinement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "86A1AA993B9284C3D6B764E936CD37E9", hash_generated_field = "9D126837B9B8B29E1CD350C323EA754B")

    private boolean mClearingFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "C4C548A58212673838506E3498DE25A0", hash_generated_field = "538F7241A30BB30063B42E9CD336B31C")

    private int mMaxWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "56FEC094E1F34E5A1FBB51577926300D", hash_generated_field = "6F563F6D96E3715972347A08AA7ECEA8")

    private boolean mVoiceButtonEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "C4702E681C3BD612CDA9DBDCFA59D47C", hash_generated_field = "548274ED005EA0BA1FFEE17A1050C8BD")

    private CharSequence mOldQueryText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "336CD107D0D6B9BEBFB6CBC4E3350BF4", hash_generated_field = "3AEB2D2A42F37E91B98257CE593EDED2")

    private CharSequence mUserQuery;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "2ADA50DD7E29822F5E0707216EB09E8F", hash_generated_field = "EC81987BA3E4E312EA0C0424E31419B5")

    private boolean mExpandedInActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "BB450BF1FD38EAFA71E793F3C559386F", hash_generated_field = "1D7B31D5465A178BB6E6B80FD3070C61")

    private int mCollapsedImeOptions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "43A23F0BB5F798E421F2CC49BC43D947", hash_generated_field = "6F1511307A7DE5E4BDCE1D082D25D113")

    private SearchableInfo mSearchable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.771 -0400", hash_original_field = "9AD25D597D917C37D99A80719B4F8F99", hash_generated_field = "59F218E5E058390715FC276BA2A49292")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_field = "04D6CDF64323839563B4F92092B41FA4", hash_generated_field = "72504DA1E4071FF872DD4C2D7A26922B")

    private Intent mVoiceWebSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_field = "11E5F1DDAB281A77343908AB3E79EC12", hash_generated_field = "FEBA65D5D58AD1CB3F0ABB729B735300")

    private Intent mVoiceAppSearchIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.772 -0400", hash_original_field = "25DE515824825836C5E934A10C853314", hash_generated_field = "74F51E5C441F50D94EA029952A490911")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.777 -0400", hash_original_method = "C1ED4F339F78000C40B1DF7945901DEA", hash_generated_method = "599F11E85D18C4EE741C206F7CE214FA")
    public  SearchView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.779 -0400", hash_original_method = "3896FE61014E55816F436D09C274C5F6", hash_generated_method = "B5BE017F9A01F8196D283A5FA29BB0E6")
    public  SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.778 -0400", hash_original_method = "93DBFCC4F7C7F6082C428361FF73C717", hash_generated_method = "15BB0F029A2D9CBA0E147567850FF072")
            public void onFocusChange(View v, boolean hasFocus) {
                
                {
                    mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, hasFocus);
                } 
                addTaint(v.getTaint());
                addTaint(hasFocus);
                
                
                    
                
            }
});
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(R.styleable.SearchView_iconifiedByDefault, true));
        int maxWidth = a.getDimensionPixelSize(R.styleable.SearchView_maxWidth, -1);
        {
            setMaxWidth(maxWidth);
        } 
        CharSequence queryHint = a.getText(R.styleable.SearchView_queryHint);
        {
            boolean varC80C3FDE5CDED7C0FBD0A83E98220CA5_279927070 = (!TextUtils.isEmpty(queryHint));
            {
                setQueryHint(queryHint);
            } 
        } 
        int imeOptions = a.getInt(R.styleable.SearchView_imeOptions, -1);
        {
            setImeOptions(imeOptions);
        } 
        int inputType = a.getInt(R.styleable.SearchView_inputType, -1);
        {
            setInputType(inputType);
        } 
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
        {
            mDropDownAnchor.addOnLayoutChangeListener(new OnLayoutChangeListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.779 -0400", hash_original_method = "1877F5683C45A9DD10AF559CB44A52A8", hash_generated_method = "346E0E37BB8C5A92B30B1A933421EF74")
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom,
                        int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    
                    adjustDropDownSizeAndPosition();
                    addTaint(v.getTaint());
                    addTaint(left);
                    addTaint(top);
                    addTaint(right);
                    addTaint(bottom);
                    addTaint(oldLeft);
                    addTaint(oldTop);
                    addTaint(oldRight);
                    addTaint(oldBottom);
                    
                    
                }
});
        } 
        updateViewsVisibility(mIconifiedByDefault);
        updateQueryHint();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.780 -0400", hash_original_method = "D9A30BFA849ECE06409E134B6DE5C1F0", hash_generated_method = "4217E3830737A15019649D32BF3F9671")
    public void setSearchableInfo(SearchableInfo searchable) {
        mSearchable = searchable;
        {
            updateSearchAutoComplete();
            updateQueryHint();
        } 
        mVoiceButtonEnabled = hasVoiceSearch();
        {
            mQueryTextView.setPrivateImeOptions(IME_OPTION_NO_MICROPHONE);
        } 
        updateViewsVisibility(isIconified());
        
        
        
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.780 -0400", hash_original_method = "EBA44227BB74F0B08E6F1C70EA9AD0F7", hash_generated_method = "9F0ED82A7B1E8B7E54C4455D92283D55")
    public void setAppSearchData(Bundle appSearchData) {
        mAppSearchData = appSearchData;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.780 -0400", hash_original_method = "A9C55FF5F962662498ECAD2C137876AF", hash_generated_method = "89FA12C923C5B083B90193928D3BCB41")
    public void setImeOptions(int imeOptions) {
        mQueryTextView.setImeOptions(imeOptions);
        addTaint(imeOptions);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.781 -0400", hash_original_method = "48CC06180C89621288EE9E924CBC5764", hash_generated_method = "4BE085BDB602CE7E85A50562333E8D94")
    public void setInputType(int inputType) {
        mQueryTextView.setInputType(inputType);
        addTaint(inputType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.781 -0400", hash_original_method = "83E343EB647417E47B475AFEA392BC7D", hash_generated_method = "9394BC52FF7A7889659C051DE76B9D0B")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        {
            boolean var8DB70F00D9A309F787FE648FEF017045_1574255986 = (!isFocusable());
        } 
        {
            boolean varCD5C141A0C77A05F6864C5164FA139BA_88520501 = (!isIconified());
            {
                boolean result = mQueryTextView.requestFocus(direction, previouslyFocusedRect);
                {
                    updateViewsVisibility(false);
                } 
            } 
            {
                boolean var7EEFFE453EE8B06336FEADC34AE77D1B_2105008948 = (super.requestFocus(direction, previouslyFocusedRect));
            } 
        } 
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152363913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152363913;
        
        
        
        
            
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.781 -0400", hash_original_method = "65B369A9FAEBC12EA58ACD6F427C9883", hash_generated_method = "A6CAF4E8BDA1F89ACF64F4B0D6BA3049")
    @Override
    public void clearFocus() {
        mClearingFocus = true;
        setImeVisibility(false);
        super.clearFocus();
        mQueryTextView.clearFocus();
        mClearingFocus = false;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.782 -0400", hash_original_method = "5F51E4234BD6E41AFB4ED2E85F8CC1A5", hash_generated_method = "9ED055F823619F93416123D3D749DA22")
    public void setOnQueryTextListener(OnQueryTextListener listener) {
        mOnQueryChangeListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.782 -0400", hash_original_method = "5C0B64E237CFC180C92A60294DA35470", hash_generated_method = "53357DC670AF8DA5EBA61C8EACD2EFB0")
    public void setOnCloseListener(OnCloseListener listener) {
        mOnCloseListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.782 -0400", hash_original_method = "2E189EEDC80EC67610C89143836C4DBB", hash_generated_method = "0E136A746D1DACCB2ECA5B20AA0683B2")
    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        mOnQueryTextFocusChangeListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.782 -0400", hash_original_method = "5242CF20D6A154AA5BAD996C3A14A890", hash_generated_method = "B2386EAE9CE311FF03E5CAA313730E12")
    public void setOnSuggestionListener(OnSuggestionListener listener) {
        mOnSuggestionListener = listener;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.782 -0400", hash_original_method = "AFFD80E7D30CC6B8E84DA9D0AC11DA43", hash_generated_method = "8D05E5C8F36ECC1939C7C9EC7679070B")
    public void setOnSearchClickListener(OnClickListener listener) {
        mOnSearchClickListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.783 -0400", hash_original_method = "BDCF19F1BD9841AC2C41BDBA087D55A0", hash_generated_method = "7376F10CFAFEA0D95FF9DAB5B0D7CC11")
    public CharSequence getQuery() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_131191704 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_131191704 = mQueryTextView.getText();
        varB4EAC82CA7396A68D541C85D26508E83_131191704.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_131191704;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.783 -0400", hash_original_method = "5407FC5F92134D6A89C79A4C1515F538", hash_generated_method = "EB2D86A82E165C273B325C411E5C15A9")
    public void setQuery(CharSequence query, boolean submit) {
        mQueryTextView.setText(query);
        {
            mQueryTextView.setSelection(query.length());
            mUserQuery = query;
        } 
        {
            boolean var9242B3EAE17A7A89184E70A84C88F6F2_1415508834 = (submit && !TextUtils.isEmpty(query));
            {
                onSubmitQuery();
            } 
        } 
        addTaint(submit);
        
        
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.783 -0400", hash_original_method = "E72A59E6C313C94D91D305DFD6AC06A2", hash_generated_method = "C5258471F3F6A52B795E7A34BC1D0815")
    public void setQueryHint(CharSequence hint) {
        mQueryHint = hint;
        updateQueryHint();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.784 -0400", hash_original_method = "ACA6D63CA1F64B4CD762BEE0367B8A15", hash_generated_method = "C1C40590AD400E11F2F5E0F72062B442")
    public void setIconifiedByDefault(boolean iconified) {
        mIconifiedByDefault = iconified;
        updateViewsVisibility(iconified);
        updateQueryHint();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.784 -0400", hash_original_method = "B0C72E24DA4703D19B476F7F5669A367", hash_generated_method = "3FBC8B56C219BD2A0F8A2EAC40589F64")
    public boolean isIconfiedByDefault() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18044431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18044431;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.784 -0400", hash_original_method = "1D615B467973354655EE36C4E6E1B780", hash_generated_method = "C1BB4C26F03DA0B1EFB160E3FBBB56CB")
    public void setIconified(boolean iconify) {
        {
            onCloseClicked();
        } 
        {
            onSearchClicked();
        } 
        addTaint(iconify);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.784 -0400", hash_original_method = "844ED2B05054700D6A1A7C47A43DB3F5", hash_generated_method = "1948B38F80A6AAE7B8C9481228F7FEF4")
    public boolean isIconified() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382637772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382637772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.785 -0400", hash_original_method = "3C1CA8493C58EB873C43522E7F5B066C", hash_generated_method = "34E7EF197158544A73303BA658DD68FC")
    public void setSubmitButtonEnabled(boolean enabled) {
        mSubmitButtonEnabled = enabled;
        updateViewsVisibility(isIconified());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.785 -0400", hash_original_method = "A8CFD3302CC6C1FBD45FF4B867C72D5B", hash_generated_method = "3FFD653020685A81CC8D761F27D6C332")
    public boolean isSubmitButtonEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032932805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032932805;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.785 -0400", hash_original_method = "29051F8E555BD7A9218D5240E768869F", hash_generated_method = "F52DE3F2037C7D7B009F5749A8C303C2")
    public void setQueryRefinementEnabled(boolean enable) {
        mQueryRefinement = enable;
        {
            ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    enable ? SuggestionsAdapter.REFINE_ALL : SuggestionsAdapter.REFINE_BY_ENTRY);
        } 
        
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.786 -0400", hash_original_method = "A374A24A58636548BF0B2ADA0B696601", hash_generated_method = "19C6B9A335014A2A660CEDBE31D6699E")
    public boolean isQueryRefinementEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106182637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106182637;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.786 -0400", hash_original_method = "23DC9EA74A588F20B69495720EC7B1A3", hash_generated_method = "82E6E3C70E0F49F4867D93600C8A7BAD")
    public void setSuggestionsAdapter(CursorAdapter adapter) {
        mSuggestionsAdapter = adapter;
        mQueryTextView.setAdapter(mSuggestionsAdapter);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.787 -0400", hash_original_method = "D43CFDAE734651DCDEBEEE22CB7FB2A7", hash_generated_method = "5B50214F520FE04D02E97E0ECCA0C220")
    public CursorAdapter getSuggestionsAdapter() {
        CursorAdapter varB4EAC82CA7396A68D541C85D26508E83_774302654 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_774302654 = mSuggestionsAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_774302654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_774302654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.787 -0400", hash_original_method = "8FF296A57B18752E84CEF7286CDC8903", hash_generated_method = "EF695F3DEED2DE41932D6D479BE99F2A")
    public void setMaxWidth(int maxpixels) {
        mMaxWidth = maxpixels;
        requestLayout();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.787 -0400", hash_original_method = "455591DBA8980F8F128C9C99FA0F791A", hash_generated_method = "08DA95E5AF1EE4551EC0C48CDAEC10E5")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        {
            boolean var9CB88D429CDA0C605332B4B8BAA0D08B_815523926 = (isIconified());
            {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } 
        } 
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        
        {
            width = Math.min(mMaxWidth, width);
        } 
        {
            width = Math.min(getPreferredWidth(), width);
        } 
        
        
        {
            width = Math.min(mMaxWidth, width);
        } 
        
        
        width = mMaxWidth > 0 ? mMaxWidth : getPreferredWidth();
        
        widthMode = MeasureSpec.EXACTLY;
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, widthMode), heightMeasureSpec);
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.788 -0400", hash_original_method = "28B5EEA3A28B4F5F076920D5EA4FBBAC", hash_generated_method = "10BF949B78AAE38B5E86CE4C5D0AFA3E")
    private int getPreferredWidth() {
        int var1DFA48C11562BB9C778ED25A8E5697EF_1044923819 = (getContext().getResources()
                .getDimensionPixelSize(R.dimen.search_view_preferred_width));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934767813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934767813;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.788 -0400", hash_original_method = "7F3DE149B8C5E14764DBC69CC4EE105A", hash_generated_method = "EC69358BFB5EEB3427C766724565D8F2")
    private void updateViewsVisibility(final boolean collapsed) {
        mIconified = collapsed;
        int visCollapsed;
        visCollapsed = VISIBLE;
        visCollapsed = GONE;
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        mSearchButton.setVisibility(visCollapsed);
        updateSubmitButton(hasText);
        mSearchEditFrame.setVisibility(collapsed ? GONE : VISIBLE);
        mSearchHintIcon.setVisibility(mIconifiedByDefault ? GONE : VISIBLE);
        updateCloseButton();
        updateVoiceButton(!hasText);
        updateSubmitArea();
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.789 -0400", hash_original_method = "1F6B21487B2FA81D5679515DB4F108DF", hash_generated_method = "AD97C8C117EAC78E0C774E00BCB66632")
    private boolean hasVoiceSearch() {
        {
            boolean var7CD733601A61864D0CEC141D0D3E93F1_1349160257 = (mSearchable != null && mSearchable.getVoiceSearchEnabled());
            {
                Intent testIntent = null;
                {
                    boolean varE115433D5D367A06EC1291A48F299B73_1741909227 = (mSearchable.getVoiceSearchLaunchWebSearch());
                    {
                        testIntent = mVoiceWebSearchIntent;
                    } 
                    {
                        boolean varDE5F6591B1893B8D2949FC45E45FA986_19854137 = (mSearchable.getVoiceSearchLaunchRecognizer());
                        {
                            testIntent = mVoiceAppSearchIntent;
                        } 
                    } 
                } 
                {
                    ResolveInfo ri = getContext().getPackageManager().resolveActivity(testIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978631836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978631836;
        
        
            
            
                
            
                
            
            
                
                        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.789 -0400", hash_original_method = "E98BAF533B4581CBC109A603E4339AE5", hash_generated_method = "6C1E8643B2BEEE8CB52507226D5F990F")
    private boolean isSubmitAreaEnabled() {
        boolean var81656F16A1D45B5B6822129878881E75_1459089693 = ((mSubmitButtonEnabled || mVoiceButtonEnabled) && !isIconified());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020105649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020105649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.789 -0400", hash_original_method = "956EC0D217930FCBDABBCC447139885F", hash_generated_method = "B7FDA9AD7751BCC7EA67EDF8BFBB17BD")
    private void updateSubmitButton(boolean hasText) {
        int visibility = GONE;
        {
            boolean varC111929E1238EF6E7C5A396EC91615E0_504066858 = (mSubmitButtonEnabled && isSubmitAreaEnabled() && hasFocus()
                && (hasText || !mVoiceButtonEnabled));
            {
                visibility = VISIBLE;
            } 
        } 
        mSubmitButton.setVisibility(visibility);
        addTaint(hasText);
        
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.790 -0400", hash_original_method = "FF9871F833F63C36B3921C4F59B0ED2F", hash_generated_method = "39161940F6800A1E83269BEABE1FD14C")
    private void updateSubmitArea() {
        int visibility = GONE;
        {
            boolean var970FABBB7F1A591E8D4BEDE840BD2DF3_858870202 = (isSubmitAreaEnabled()
                && (mSubmitButton.getVisibility() == VISIBLE
                        || mVoiceButton.getVisibility() == VISIBLE));
            {
                visibility = VISIBLE;
            } 
        } 
        mSubmitArea.setVisibility(visibility);
        
        
        
                
                        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.790 -0400", hash_original_method = "31438C0932D7B883B0B6F7C1A8D11C73", hash_generated_method = "24CE7D666A82852EBB54C806573514B2")
    private void updateCloseButton() {
        final boolean hasText = !TextUtils.isEmpty(mQueryTextView.getText());
        final boolean showClose = hasText || (mIconifiedByDefault && !mExpandedInActionView);
        mCloseButton.setVisibility(showClose ? VISIBLE : GONE);
        mCloseButton.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.790 -0400", hash_original_method = "A19187F7BD510E54AC677DCF71153712", hash_generated_method = "E58D53BF8B2730472056F6D862C2F112")
    private void postUpdateFocusedState() {
        post(mUpdateDrawableStateRunnable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.790 -0400", hash_original_method = "2FABE728CB7CDC63DD618939E6086EE5", hash_generated_method = "8EE7E2F5D88995D04338ABEAF0F7352A")
    private void updateFocusedState() {
        boolean focused = mQueryTextView.hasFocus();
        mSearchPlate.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        mSubmitArea.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.791 -0400", hash_original_method = "466B44C18A399269336D5B13075B3DD5", hash_generated_method = "541E8F066DEA567D4C20FD5E338EC369")
    @Override
    protected void onDetachedFromWindow() {
        
        removeCallbacks(mUpdateDrawableStateRunnable);
        post(mReleaseCursorRunnable);
        super.onDetachedFromWindow();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.791 -0400", hash_original_method = "10C83777364EAA061E75B08DB527338D", hash_generated_method = "DF308AAB196512EE578F47AF89A8EFA0")
    private void setImeVisibility(final boolean visible) {
        {
            post(mShowImeRunnable);
        } 
        {
            removeCallbacks(mShowImeRunnable);
            InputMethodManager imm = (InputMethodManager)
                    getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            {
                imm.hideSoftInputFromWindow(getWindowToken(), 0);
            } 
        } 
        addTaint(visible);
        
        
            
        
            
            
                    
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.791 -0400", hash_original_method = "364D10214479FA13BFF6BDB192F3E0CD", hash_generated_method = "B80A5CCB6DF46041BC92C31F3029BD50")
     void onQueryRefine(CharSequence queryText) {
        
        setQuery(queryText);
        addTaint(queryText.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.791 -0400", hash_original_method = "E2E8A56E8AA279DA8CFFA9FDDF535879", hash_generated_method = "99F2FAF6BD1B672E24FE810460F107BA")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
        {
            boolean var5CB2730BDD0F8A6AFECB97402B427F1B_321581262 = ((actionKey != null) && (actionKey.getQueryActionMsg() != null));
            {
                launchQuerySearch(keyCode, actionKey.getQueryActionMsg(), mQueryTextView.getText()
                    .toString());
            } 
        } 
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1315512566 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395582263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395582263;
        
        
            
        
        
        
            
                    
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.792 -0400", hash_original_method = "2292125EFE6589DCDAE880647EC125AA", hash_generated_method = "8DF824B13A110B017956435C1B05A0F4")
    private boolean onSuggestionsKey(View v, int keyCode, KeyEvent event) {
        {
            boolean var96842DBF46FE1F5DB2349D1F8230BD47_363265940 = (event.getAction() == KeyEvent.ACTION_DOWN && event.hasNoModifiers());
            {
                {
                    int position = mQueryTextView.getListSelection();
                    boolean var524CB2E03CDD56BA662F9285090A5D2A_100549306 = (onItemClicked(position, KeyEvent.KEYCODE_UNKNOWN, null));
                } 
                {
                    int selPoint;
                    selPoint = 0;
                    selPoint = mQueryTextView
                        .length();
                    mQueryTextView.setSelection(selPoint);
                    mQueryTextView.setListSelection(0);
                    mQueryTextView.clearListSelection();
                    mQueryTextView.ensureImeVisible(true);
                } 
                {
                    boolean var404CC5C85EC37EE7D9EAFA6391F0B425_663251822 = (keyCode == KeyEvent.KEYCODE_DPAD_UP && 0 == mQueryTextView.getListSelection());
                } 
                SearchableInfo.ActionKeyInfo actionKey = mSearchable.findActionKey(keyCode);
                {
                    boolean varD6A63EA6CB82F1938533850645AC63CC_1390118694 = ((actionKey != null)
                    && ((actionKey.getSuggestActionMsg() != null) || (actionKey
                            .getSuggestActionMsgColumn() != null)));
                    {
                        int position = mQueryTextView.getListSelection();
                        {
                            Cursor c = mSuggestionsAdapter.getCursor();
                            {
                                boolean varAA3D0D8A8F9C1695507C58A83CA2F991_458471500 = (c.moveToPosition(position));
                                {
                                    final String actionMsg = getActionKeyMessage(c, actionKey);
                                    {
                                        boolean varCBF97EF6005E0ABB0B009E065E0E7581_83947518 = (actionMsg != null && (actionMsg.length() > 0));
                                        {
                                            boolean varEA30C83275615DF0CD0CC1A4EF5FFEC1_352486422 = (onItemClicked(position, keyCode, actionMsg));
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(v.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_227796025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_227796025;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.793 -0400", hash_original_method = "587CD5DA65D790D90BAF0DE8B5BB2354", hash_generated_method = "4F9919E3446A570E3E6C0D668710DEF9")
    private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(com.android.internal.R.attr.searchViewSearchIcon,
                outValue, true);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717821;
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.794 -0400", hash_original_method = "BEC25B8B383259674E4804BA5A8143D3", hash_generated_method = "334348FC5B02C53CF1586124788663D7")
    private CharSequence getDecoratedHint(CharSequence hintText) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1875380709 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_130752818 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1875380709 = hintText;
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (mQueryTextView.getTextSize() * 1.25);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        varB4EAC82CA7396A68D541C85D26508E83_130752818 = ssb;
        addTaint(hintText.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1864891489; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1864891489 = varB4EAC82CA7396A68D541C85D26508E83_1875380709;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1864891489 = varB4EAC82CA7396A68D541C85D26508E83_130752818;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1864891489.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1864891489;
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.795 -0400", hash_original_method = "86FF55CF6755F81D1B5EAA7CA81FA50B", hash_generated_method = "309E51F9A9B8C9A45D1B8B6BF3BA3834")
    private void updateQueryHint() {
        {
            mQueryTextView.setHint(getDecoratedHint(mQueryHint));
        } 
        {
            CharSequence hint = null;
            int hintId = mSearchable.getHintId();
            {
                hint = getContext().getString(hintId);
            } 
            {
                mQueryTextView.setHint(getDecoratedHint(hint));
            } 
        } 
        {
            mQueryTextView.setHint(getDecoratedHint(""));
        } 
        
        
            
        
            
            
            
                
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.795 -0400", hash_original_method = "923331D2E7E4B81B915A368FF3E97F8B", hash_generated_method = "3B6D5B592B40E4B368A0B792F7876333")
    private void updateSearchAutoComplete() {
        mQueryTextView.setDropDownAnimationStyle(0);
        mQueryTextView.setThreshold(mSearchable.getSuggestThreshold());
        mQueryTextView.setImeOptions(mSearchable.getImeOptions());
        int inputType = mSearchable.getInputType();
        {
            inputType &= ~InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
            {
                boolean var35AC7A1761C1124F307704E7A9FB2780_2042037102 = (mSearchable.getSuggestAuthority() != null);
                {
                    inputType |= InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE;
                } 
            } 
        } 
        mQueryTextView.setInputType(inputType);
        {
            mSuggestionsAdapter.changeCursor(null);
        } 
        {
            boolean var766631DCADAC65258B4B2AA4BC08BF1D_492573453 = (mSearchable.getSuggestAuthority() != null);
            {
                mSuggestionsAdapter = new SuggestionsAdapter(getContext(),
                    this, mSearchable, mOutsideDrawablesCache);
                mQueryTextView.setAdapter(mSuggestionsAdapter);
                ((SuggestionsAdapter) mSuggestionsAdapter).setQueryRefinement(
                    mQueryRefinement ? SuggestionsAdapter.REFINE_ALL
                    : SuggestionsAdapter.REFINE_BY_ENTRY);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.796 -0400", hash_original_method = "3C9F3ABEF9459DE6C607B751B6CB866E", hash_generated_method = "1E362C95F2396A57F3FAA39682267B97")
    private void updateVoiceButton(boolean empty) {
        int visibility = GONE;
        {
            boolean var90713B33485BF631D704E35E86303098_485778367 = (mVoiceButtonEnabled && !isIconified() && empty);
            {
                visibility = VISIBLE;
                mSubmitButton.setVisibility(GONE);
            } 
        } 
        mVoiceButton.setVisibility(visibility);
        addTaint(empty);
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.797 -0400", hash_original_method = "1411F54CFFACC3FC33F099091662F124", hash_generated_method = "F517C4F651804D7720139039594352FD")
    private void onTextChanged(CharSequence newText) {
        CharSequence text = mQueryTextView.getText();
        mUserQuery = text;
        boolean hasText = !TextUtils.isEmpty(text);
        updateSubmitButton(hasText);
        updateVoiceButton(!hasText);
        updateCloseButton();
        updateSubmitArea();
        {
            boolean var323E3AECC67129F3B90BD3247116BE94_1856032179 = (mOnQueryChangeListener != null && !TextUtils.equals(newText, mOldQueryText));
            {
                mOnQueryChangeListener.onQueryTextChange(newText.toString());
            } 
        } 
        mOldQueryText = newText.toString();
        
        
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.798 -0400", hash_original_method = "5AEA0BD14CD513B7E21145454A43DADF", hash_generated_method = "E20D50A3A4855510460EB97C168093A5")
    private void onSubmitQuery() {
        CharSequence query = mQueryTextView.getText();
        {
            boolean var0D033082B10BC0B3B14D4B2164FDB866_93412245 = (query != null && TextUtils.getTrimmedLength(query) > 0);
            {
                {
                    boolean varEB8F49EA341CCD6D5D4625046BE9A9DC_1680410903 = (mOnQueryChangeListener == null
                    || !mOnQueryChangeListener.onQueryTextSubmit(query.toString()));
                    {
                        {
                            launchQuerySearch(KeyEvent.KEYCODE_UNKNOWN, null, query.toString());
                            setImeVisibility(false);
                        } 
                        dismissSuggestions();
                    } 
                } 
            } 
        } 
        
        
        
            
                    
                
                    
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.798 -0400", hash_original_method = "8D9A2C9AF67AD5F3EB2818A3F7453E73", hash_generated_method = "D7D68B4D8980045DB76C85CF1D652798")
    private void dismissSuggestions() {
        mQueryTextView.dismissDropDown();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.798 -0400", hash_original_method = "E1C21CB17E5E6548A25ED1EEE1C98C9D", hash_generated_method = "52D207113058FFAB076ED8389D278F32")
    private void onCloseClicked() {
        CharSequence text = mQueryTextView.getText();
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_635914118 = (TextUtils.isEmpty(text));
            {
                {
                    {
                        boolean varD565EFD0C61B0AA0DDB6D792ED5EB23E_1503202898 = (mOnCloseListener == null || !mOnCloseListener.onClose());
                        {
                            clearFocus();
                            updateViewsVisibility(true);
                        } 
                    } 
                } 
            } 
            {
                mQueryTextView.setText("");
                mQueryTextView.requestFocus();
                setImeVisibility(true);
            } 
        } 
        
        
        
            
                
                    
                    
                
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.799 -0400", hash_original_method = "4C174341C531719A99E642D8022F787E", hash_generated_method = "A1D5AAB78161FB95636B4F354E411467")
    private void onSearchClicked() {
        updateViewsVisibility(false);
        mQueryTextView.requestFocus();
        setImeVisibility(true);
        {
            mOnSearchClickListener.onClick(this);
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.799 -0400", hash_original_method = "5B2168D9C175988BD80847D561C5C5CC", hash_generated_method = "C571DD8440CA37704B0FEDFF0D0F7E77")
    private void onVoiceClicked() {
        SearchableInfo searchable = mSearchable;
        try 
        {
            {
                boolean varA7C415A860984F74F13F2B5F35E99AF8_1236714153 = (searchable.getVoiceSearchLaunchWebSearch());
                {
                    Intent webSearchIntent = createVoiceWebSearchIntent(mVoiceWebSearchIntent,
                        searchable);
                    getContext().startActivity(webSearchIntent);
                } 
                {
                    boolean var645D8F4ECB1C0F7F11811AA98A572600_1359800723 = (searchable.getVoiceSearchLaunchRecognizer());
                    {
                        Intent appSearchIntent = createVoiceAppSearchIntent(mVoiceAppSearchIntent,
                        searchable);
                        getContext().startActivity(appSearchIntent);
                    } 
                } 
            } 
        } 
        catch (ActivityNotFoundException e)
        { }
        
        
            
        
        
        
            
                
                        
                
            
                
                        
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.800 -0400", hash_original_method = "4D3FC77D85FEC9D80C6560FAE74CDA60", hash_generated_method = "6E0E1D0043EBCD30A1C4BCDAE201C96D")
     void onTextFocusChanged() {
        
        updateViewsVisibility(isIconified());
        postUpdateFocusedState();
        {
            boolean varD5B56093B4D5DB9CF48D5816CF04A069_201886899 = (mQueryTextView.hasFocus());
            {
                forceSuggestionQuery();
            } 
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.800 -0400", hash_original_method = "6BC34AF35099192BA7E60BCC11E3C756", hash_generated_method = "39C6DB5AE969101BFF00F0D7A0CBD14C")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        super.onWindowFocusChanged(hasWindowFocus);
        postUpdateFocusedState();
        addTaint(hasWindowFocus);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.800 -0400", hash_original_method = "5D7477A3D9C6D568A19E621F4FAE5DD7", hash_generated_method = "657A76175C5C027E0A83AC8F0E70E279")
    @Override
    public void onActionViewCollapsed() {
        
        clearFocus();
        updateViewsVisibility(true);
        mQueryTextView.setImeOptions(mCollapsedImeOptions);
        mExpandedInActionView = false;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.800 -0400", hash_original_method = "F734C19BE6B7D5E142C7745125215DDF", hash_generated_method = "131F0E66390DDDCCE1C64EE3296721EB")
    @Override
    public void onActionViewExpanded() {
        
        mExpandedInActionView = true;
        mCollapsedImeOptions = mQueryTextView.getImeOptions();
        mQueryTextView.setImeOptions(mCollapsedImeOptions | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        mQueryTextView.setText("");
        setIconified(false);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.801 -0400", hash_original_method = "C8142821EB0396ABFD0EB3B305480E27", hash_generated_method = "E47D9586E961254546EB87C3EE667315")
    private void adjustDropDownSizeAndPosition() {
        {
            boolean varBDFC2850FDF993A89C978164A3FC182E_1834526273 = (mDropDownAnchor.getWidth() > 1);
            {
                Resources res = getContext().getResources();
                int anchorPadding = mSearchPlate.getPaddingLeft();
                Rect dropDownPadding = new Rect();
                int iconOffset;
                iconOffset = res.getDimensionPixelSize(R.dimen.dropdownitem_icon_width)
                    + res.getDimensionPixelSize(R.dimen.dropdownitem_text_padding_left);
                iconOffset = 0;
                mQueryTextView.getDropDownBackground().getPadding(dropDownPadding);
                mQueryTextView.setDropDownHorizontalOffset(-(dropDownPadding.left + iconOffset)
                    + anchorPadding);
                mQueryTextView.setDropDownWidth(mDropDownAnchor.getWidth() + dropDownPadding.left
                    + dropDownPadding.right + iconOffset - (anchorPadding));
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.801 -0400", hash_original_method = "5FDC493391F791D62FF75AE849BF4213", hash_generated_method = "B3CED1C482645F8E39CE128500C46A50")
    private boolean onItemClicked(int position, int actionKey, String actionMsg) {
        {
            boolean var350FE6BC9A4CD5C160297254EB8318B3_63887113 = (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionClick(position));
            {
                launchSuggestion(position, KeyEvent.KEYCODE_UNKNOWN, null);
                setImeVisibility(false);
                dismissSuggestions();
            } 
        } 
        addTaint(position);
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173253773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173253773;
        
        
                
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.802 -0400", hash_original_method = "08FFA8C71E803D9BC52878D0BDC1227B", hash_generated_method = "54685A66EB1E9CE25D53242306885031")
    private boolean onItemSelected(int position) {
        {
            boolean varD0AB4A987152B8EC35399136FBAE5E5E_209853784 = (mOnSuggestionListener == null
                || !mOnSuggestionListener.onSuggestionSelect(position));
            {
                rewriteQueryFromSuggestion(position);
            } 
        } 
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418774347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418774347;
        
        
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.802 -0400", hash_original_method = "FE5C7BD493A3B7C4988BF7B094450FE1", hash_generated_method = "F0B15012404509B53112285F7AF6FBE8")
    private void rewriteQueryFromSuggestion(int position) {
        CharSequence oldQuery = mQueryTextView.getText();
        Cursor c = mSuggestionsAdapter.getCursor();
        {
            boolean var13F64BF59FABCAB989EC616298EA3580_750610316 = (c.moveToPosition(position));
            {
                CharSequence newQuery = mSuggestionsAdapter.convertToString(c);
                {
                    setQuery(newQuery);
                } 
                {
                    setQuery(oldQuery);
                } 
            } 
            {
                setQuery(oldQuery);
            } 
        } 
        addTaint(position);
        
        
        
        
            
        
        
            
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.802 -0400", hash_original_method = "1026A945AA7D5E936A04225BB74423F6", hash_generated_method = "D17CAADE40EAB8F17BFE4BF45425E0C9")
    private boolean launchSuggestion(int position, int actionKey, String actionMsg) {
        Cursor c = mSuggestionsAdapter.getCursor();
        {
            boolean var74E5271F2D14A3901C9E07AB7568B5C7_264982921 = ((c != null) && c.moveToPosition(position));
            {
                Intent intent = createIntentFromSuggestion(c, actionKey, actionMsg);
                launchIntent(intent);
            } 
        } 
        addTaint(position);
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787301218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787301218;
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.803 -0400", hash_original_method = "B092F13CA13C6A372C37DCEFCF94B5BC", hash_generated_method = "707001C8A98FD878D136C21071E5A74A")
    private void launchIntent(Intent intent) {
        try 
        {
            getContext().startActivity(intent);
        } 
        catch (RuntimeException ex)
        { }
        addTaint(intent.getTaint());
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.803 -0400", hash_original_method = "39B31EC96E94C2151059B7594679485C", hash_generated_method = "F05438A71D7B4C218CB339EA2B853A36")
    private void setQuery(CharSequence query) {
        mQueryTextView.setText(query, true);
        mQueryTextView.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
        addTaint(query.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.803 -0400", hash_original_method = "A610C255BB7D93FEE4A49CEF406D7E3C", hash_generated_method = "0DF9B9ABEA85730F6434E90678395169")
    private void launchQuerySearch(int actionKey, String actionMsg, String query) {
        String action = Intent.ACTION_SEARCH;
        Intent intent = createIntent(action, null, null, query, actionKey, actionMsg);
        getContext().startActivity(intent);
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        addTaint(query.getTaint());
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.804 -0400", hash_original_method = "7931502AE551A2F220A0C85C1181EB09", hash_generated_method = "572E3B613C97747194DEB928FF5EF839")
    private Intent createIntent(String action, Uri data, String extraData, String query,
            int actionKey, String actionMsg) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_395360684 = null; 
        Intent intent = new Intent(action);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        {
            intent.setData(data);
        } 
        intent.putExtra(SearchManager.USER_QUERY, mUserQuery);
        {
            intent.putExtra(SearchManager.QUERY, query);
        } 
        {
            intent.putExtra(SearchManager.EXTRA_DATA_KEY, extraData);
        } 
        {
            intent.putExtra(SearchManager.APP_DATA, mAppSearchData);
        } 
        {
            intent.putExtra(SearchManager.ACTION_KEY, actionKey);
            intent.putExtra(SearchManager.ACTION_MSG, actionMsg);
        } 
        intent.setComponent(mSearchable.getSearchActivity());
        varB4EAC82CA7396A68D541C85D26508E83_395360684 = intent;
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        addTaint(extraData.getTaint());
        addTaint(query.getTaint());
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_395360684.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_395360684;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.805 -0400", hash_original_method = "88ED2A4CD1E55FCB278985A3652D43A1", hash_generated_method = "B7582AB19670D6CEDF205EA541BC5049")
    private Intent createVoiceWebSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_429903212 = null; 
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        varB4EAC82CA7396A68D541C85D26508E83_429903212 = voiceIntent;
        addTaint(baseIntent.getTaint());
        addTaint(searchable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_429903212.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_429903212;
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.807 -0400", hash_original_method = "7F7E8A56997E65BDFC7ADF14F1E923E9", hash_generated_method = "1D28493CABBABCAC3EB9904B3507B888")
    private Intent createVoiceAppSearchIntent(Intent baseIntent, SearchableInfo searchable) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1551494034 = null; 
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
        {
            boolean varBBE4CD039A6A00BFEFC751059FE85B4F_31879058 = (searchable.getVoiceLanguageModeId() != 0);
            {
                languageModel = resources.getString(searchable.getVoiceLanguageModeId());
            } 
        } 
        {
            boolean varAC8E073C8A191629EF47CD10960E1E5F_1943424505 = (searchable.getVoicePromptTextId() != 0);
            {
                prompt = resources.getString(searchable.getVoicePromptTextId());
            } 
        } 
        {
            boolean varC746CB3F134BCAA7F8EF0771FDB78FED_89503574 = (searchable.getVoiceLanguageId() != 0);
            {
                language = resources.getString(searchable.getVoiceLanguageId());
            } 
        } 
        {
            boolean var2E746E5A42346C8832AA6F44EE0CF45F_1126764859 = (searchable.getVoiceMaxResults() != 0);
            {
                maxResults = searchable.getVoiceMaxResults();
            } 
        } 
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, languageModel);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, prompt);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, language);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, maxResults);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, searchActivity == null ? null
                : searchActivity.flattenToShortString());
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT, pending);
        voiceIntent.putExtra(RecognizerIntent.EXTRA_RESULTS_PENDINGINTENT_BUNDLE, queryExtras);
        varB4EAC82CA7396A68D541C85D26508E83_1551494034 = voiceIntent;
        addTaint(baseIntent.getTaint());
        addTaint(searchable.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1551494034.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1551494034;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.809 -0400", hash_original_method = "830957C509294E2BDC3732D8A42E8F7A", hash_generated_method = "2AA639886FDA239FFC4BFCD124D3CE72")
    private Intent createIntentFromSuggestion(Cursor c, int actionKey, String actionMsg) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1083324253 = null; 
        Intent varB4EAC82CA7396A68D541C85D26508E83_882235456 = null; 
        try 
        {
            String action = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_ACTION);
            {
                action = mSearchable.getSuggestIntentAction();
            } 
            {
                action = Intent.ACTION_SEARCH;
            } 
            String data = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA);
            {
                data = mSearchable.getSuggestIntentData();
            } 
            {
                String id = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID);
                {
                    data = data + "/" + Uri.encode(id);
                } 
            } 
            Uri dataUri;
            dataUri = null;
            dataUri = Uri.parse(data);
            String query = getColumnString(c, SearchManager.SUGGEST_COLUMN_QUERY);
            String extraData = getColumnString(c, SearchManager.SUGGEST_COLUMN_INTENT_EXTRA_DATA);
            varB4EAC82CA7396A68D541C85D26508E83_1083324253 = createIntent(action, dataUri, extraData, query, actionKey, actionMsg);
        } 
        catch (RuntimeException e)
        {
            int rowNum;
            try 
            {
                rowNum = c.getPosition();
            } 
            catch (RuntimeException e2)
            {
                rowNum = -1;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_882235456 = null;
        } 
        addTaint(c.getTaint());
        addTaint(actionKey);
        addTaint(actionMsg.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1994838430; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1994838430 = varB4EAC82CA7396A68D541C85D26508E83_1083324253;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1994838430 = varB4EAC82CA7396A68D541C85D26508E83_882235456;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1994838430.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1994838430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.809 -0400", hash_original_method = "7E9F5D2AEBB04ECB1BF9832E28C48CE5", hash_generated_method = "842B7E3CB61461A203AD10E7DC7E1B6F")
    private void forceSuggestionQuery() {
        mQueryTextView.doBeforeTextChanged();
        mQueryTextView.doAfterTextChanged();
        
        
        
    }

    
        static boolean isLandscapeMode(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    
    public static class SearchAutoComplete extends AutoCompleteTextView {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.809 -0400", hash_original_field = "3C3C53D359DFC0BF874C1D7D1521B140", hash_generated_field = "2B2FC0AB3F9DED44C14A982417EA1993")

        private int mThreshold;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.809 -0400", hash_original_field = "D1972F87341AF3F5EA90C2B878C0DF14", hash_generated_field = "1366187FE3CF01EF5FC13B6B4154C3DB")

        private SearchView mSearchView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.810 -0400", hash_original_method = "0EFA734BA823B47BC95B6AD45B9E23E2", hash_generated_method = "3692FB45DDFB24E73BA43FB5045688AC")
        public  SearchAutoComplete(Context context) {
            super(context);
            mThreshold = getThreshold();
            addTaint(context.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.810 -0400", hash_original_method = "D2F6F380F4593BE38169820FCC450031", hash_generated_method = "D804F8CA9A4D3BF2C817008D029A0CFD")
        public  SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            mThreshold = getThreshold();
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.810 -0400", hash_original_method = "6D01382B108C5B979A3DE77D2755BA0A", hash_generated_method = "134653A25408180D2DFC090D8F0141D9")
        public  SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            mThreshold = getThreshold();
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            addTaint(defStyle);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.811 -0400", hash_original_method = "BBDE2605DAB20A62DF5DDA8DAF1B33B9", hash_generated_method = "0D212706D2CE79F99D27416EE240A973")
         void setSearchView(SearchView searchView) {
            mSearchView = searchView;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.811 -0400", hash_original_method = "2A2464279ECB52A9D86939A6AE2D6FFF", hash_generated_method = "688D0A5C066F7B7BC80C28BA72699E5D")
        @Override
        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            mThreshold = threshold;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.811 -0400", hash_original_method = "BA394CC4782335931E16390E53BDBA7F", hash_generated_method = "C2DCC3639821A1F2C44DC846D654FCF7")
        private boolean isEmpty() {
            boolean var3DC6FA609B5525FAC46D05EECEA6786A_471062982 = (TextUtils.getTrimmedLength(getText()) == 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_47858980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_47858980;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.811 -0400", hash_original_method = "04EDD552CD5932834AB8E3EAD2670FCB", hash_generated_method = "2E00CC1DC27537AD22A88B7817BCCBE4")
        @Override
        protected void replaceText(CharSequence text) {
            addTaint(text.getTaint());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.812 -0400", hash_original_method = "BBB8F048947DA4F8E171ED984E24E3AE", hash_generated_method = "65E30508731680C780234FF5491E8384")
        @Override
        public void performCompletion() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.812 -0400", hash_original_method = "3777C1088ADE560024EE2C32D034B492", hash_generated_method = "B382C80CAADD277920EC6236B4E70BEB")
        @Override
        public void onWindowFocusChanged(boolean hasWindowFocus) {
            
            super.onWindowFocusChanged(hasWindowFocus);
            {
                boolean var07827550B2C2F4C2AD19C2B83045B0B0_1248557287 = (hasWindowFocus && mSearchView.hasFocus() && getVisibility() == VISIBLE);
                {
                    InputMethodManager inputManager = (InputMethodManager) getContext()
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.showSoftInput(this, 0);
                    {
                        boolean var962BF569303E770457EF5B953E22B6C6_919133865 = (isLandscapeMode(getContext()));
                        {
                            ensureImeVisible(true);
                        } 
                    } 
                } 
            } 
            addTaint(hasWindowFocus);
            
            
            
                
                        
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.812 -0400", hash_original_method = "5F63BE621D8AAF87B5CC12EFB3AE40CE", hash_generated_method = "975839A07A74F2A3A30305B0A98BCCF9")
        @Override
        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            mSearchView.onTextFocusChanged();
            addTaint(focused);
            addTaint(direction);
            addTaint(previouslyFocusedRect.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.813 -0400", hash_original_method = "E5C7430DC03439C4054C8D137460F5A5", hash_generated_method = "A4B3E10F3F5692BD35BB8EB471372E97")
        @Override
        public boolean enoughToFilter() {
            boolean varC2A9CA7695220720B0749D6800887CAB_1341910522 = (mThreshold <= 0 || super.enoughToFilter());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1423933017 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1423933017;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.813 -0400", hash_original_method = "AB0021D21F9078098334FA1D38399275", hash_generated_method = "971CA6F22DCA443260E6E78E49131282")
        @Override
        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            
            {
                {
                    boolean var51947D54DEEA690F1B41A17DE6323711_1544179523 = (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0);
                    {
                        KeyEvent.DispatcherState state = getKeyDispatcherState();
                        {
                            state.startTracking(event, this);
                        } 
                    } 
                    {
                        boolean varA6D964A9D1A4D1D485BD8D60F2BFCDEE_949400396 = (event.getAction() == KeyEvent.ACTION_UP);
                        {
                            KeyEvent.DispatcherState state = getKeyDispatcherState();
                            {
                                state.handleUpEvent(event);
                            } 
                            {
                                boolean varBE09C907F92D135687297C67489D82A5_349922237 = (event.isTracking() && !event.isCanceled());
                                {
                                    mSearchView.clearFocus();
                                    mSearchView.setImeVisibility(false);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            boolean var5970925D52CD103B5580C9C1CCD0A863_172276923 = (super.onKeyPreIme(keyCode, event));
            addTaint(keyCode);
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258359289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258359289;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.813 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.813 -0400", hash_original_field = "0587D8CE40F7F4AC1343388C2FEA1ED4", hash_generated_field = "DEE7E6EBCAD52D0BE04774C5F3845528")

    private static final String LOG_TAG = "SearchView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:14.813 -0400", hash_original_field = "B8CF89EB7E6552EBC5C9FCBB33074205", hash_generated_field = "7875B207C54E2B6D5ABF1652FFF3F22A")

    private static final String IME_OPTION_NO_MICROPHONE = "nm";
}

