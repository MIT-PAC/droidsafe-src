package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.InputType;
import android.text.Layout;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.PrintWriterPrinter;
import android.util.Printer;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.android.internal.R;

public class InputMethodService extends AbstractInputMethodService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.364 -0500", hash_original_field = "0625AD3B4C868F38322FC6675151E03D", hash_generated_field = "9CF0118E5FF5051520996A9D15AE838E")

    static final String TAG = "InputMethodService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.367 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.369 -0500", hash_original_field = "C54F28B48D3F711FE72FE0DC323508AF", hash_generated_field = "4162B60B07B580ECBA3A261DC0CE993C")

    public static final int BACK_DISPOSITION_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.372 -0500", hash_original_field = "43A0A4C1E48BB433E640B2F7163BCFF3", hash_generated_field = "2FD400F87EC4C6F865CBF8FCC35D4004")

    /**
     * This input method will not consume the back key.
     */
    public static final int BACK_DISPOSITION_WILL_NOT_DISMISS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.375 -0500", hash_original_field = "C0C30FF30280740136854AC0AAF9EECA", hash_generated_field = "29DE42E13303B8038ADAE4FF7EC30C01")

    /**
     * This input method will consume the back key.
     */
    public static final int BACK_DISPOSITION_WILL_DISMISS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.377 -0500", hash_original_field = "F15C0D2B2BF460DC18B2341B61D6D789", hash_generated_field = "721FB603FD5B2D4072E631AFBCE37007")

    /**
     * @hide
     * The IME is active.  It may or may not be visible.
     */
    public static final int IME_ACTIVE = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.379 -0500", hash_original_field = "481D11B00997DA7F6A1309A2BE5D9D50", hash_generated_field = "54453599413B853A6378E68D3D2217C5")

    public static final int IME_VISIBLE = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.737 -0500", hash_original_field = "A9F7A372B74E1AAEECF76942AFDCE029", hash_generated_field = "3B517107D2F173893643769189022B46")
    
    static final int MOVEMENT_DOWN = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.739 -0500", hash_original_field = "B4D08428A39E17E44F1EDD148C01C108", hash_generated_field = "31973F9CFC4CEDE663F654F0137BD973")

    static final int MOVEMENT_UP = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.382 -0500", hash_original_field = "01719032B78A2D912F910E37CD479B69", hash_generated_field = "01719032B78A2D912F910E37CD479B69")

    InputMethodManager mImm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.384 -0500", hash_original_field = "075FD7AAD50C5AD8803D9E3B208423A2", hash_generated_field = "075FD7AAD50C5AD8803D9E3B208423A2")
    
    int mTheme = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.387 -0500", hash_original_field = "B03B4DAE3F576B7166425BEE37B96C5E", hash_generated_field = "B03B4DAE3F576B7166425BEE37B96C5E")
    
    LayoutInflater mInflater;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.389 -0500", hash_original_field = "B7C98FA3B531CC028C7A59F94DC2AFFF", hash_generated_field = "B7C98FA3B531CC028C7A59F94DC2AFFF")

    TypedArray mThemeAttrs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.391 -0500", hash_original_field = "6D0C26C611FBD233667A9FA9104CED21", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

    View mRootView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.393 -0500", hash_original_field = "507E6EFA97CB0E77FA79A4D01B3ED4A3", hash_generated_field = "507E6EFA97CB0E77FA79A4D01B3ED4A3")

    SoftInputWindow mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.395 -0500", hash_original_field = "C9E05499054E8056F0A4805D1295DEC9", hash_generated_field = "C9E05499054E8056F0A4805D1295DEC9")

    boolean mInitialized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.397 -0500", hash_original_field = "FE6B5FDA79102585E4703AA7755D8A1D", hash_generated_field = "FE6B5FDA79102585E4703AA7755D8A1D")

    boolean mWindowCreated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.399 -0500", hash_original_field = "218C970370BBF49B29F07C78706BEE0F", hash_generated_field = "218C970370BBF49B29F07C78706BEE0F")

    boolean mWindowAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.401 -0500", hash_original_field = "71207F91BCFA87F10E39CE8F643F27A2", hash_generated_field = "71207F91BCFA87F10E39CE8F643F27A2")

    boolean mWindowVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.403 -0500", hash_original_field = "DC6F9BCE5EC968FD18904FAB6E1E26EA", hash_generated_field = "DC6F9BCE5EC968FD18904FAB6E1E26EA")

    boolean mWindowWasVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.405 -0500", hash_original_field = "393177CC055DA847245CCD680AD17E8C", hash_generated_field = "393177CC055DA847245CCD680AD17E8C")

    boolean mInShowWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.407 -0500", hash_original_field = "15182820025992AE750DB9E78ACD70F3", hash_generated_field = "15182820025992AE750DB9E78ACD70F3")

    ViewGroup mFullscreenArea;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.408 -0500", hash_original_field = "13D1A7834031B0B293BDFE378DF08473", hash_generated_field = "13D1A7834031B0B293BDFE378DF08473")

    FrameLayout mExtractFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.412 -0500", hash_original_field = "E6B39B5292209EE43935C8AAB586E41A", hash_generated_field = "E6B39B5292209EE43935C8AAB586E41A")

    FrameLayout mCandidatesFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.414 -0500", hash_original_field = "8060C3896FC8C6EEC2A4B224AC19B8A5", hash_generated_field = "8060C3896FC8C6EEC2A4B224AC19B8A5")

    FrameLayout mInputFrame;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.416 -0500", hash_original_field = "DD6EB7EC256F1225D4C6DC1A42FB765B", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")
    
    IBinder mToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.418 -0500", hash_original_field = "AFA59EA1150C21AB6E344984735AF2EB", hash_generated_field = "AFA59EA1150C21AB6E344984735AF2EB")
    
    InputBinding mInputBinding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.420 -0500", hash_original_field = "0C4E3C3C223DA7FB43EF5D532A5B3E04", hash_generated_field = "0C4E3C3C223DA7FB43EF5D532A5B3E04")

    InputConnection mInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.422 -0500", hash_original_field = "D15B1F449CE3CDE14A0008B2465EE7E3", hash_generated_field = "D15B1F449CE3CDE14A0008B2465EE7E3")

    boolean mInputStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.424 -0500", hash_original_field = "514EB139852D82B47A3950B6F3E19CF6", hash_generated_field = "514EB139852D82B47A3950B6F3E19CF6")

    boolean mInputViewStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.426 -0500", hash_original_field = "4626543A6FCF1F8B8B73D10B97975D09", hash_generated_field = "4626543A6FCF1F8B8B73D10B97975D09")

    boolean mCandidatesViewStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.429 -0500", hash_original_field = "60FF159378B9E2B6E495E1B7233D3981", hash_generated_field = "60FF159378B9E2B6E495E1B7233D3981")

    InputConnection mStartedInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.431 -0500", hash_original_field = "0A7D4D3889811FF61BF27942BE846641", hash_generated_field = "0A7D4D3889811FF61BF27942BE846641")

    EditorInfo mInputEditorInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.433 -0500", hash_original_field = "293541479A1626BCDA923AA8063FA9A6", hash_generated_field = "293541479A1626BCDA923AA8063FA9A6")
    
    int mShowInputFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.435 -0500", hash_original_field = "7599FBE37A9716825A76F29F0FE2FD55", hash_generated_field = "7599FBE37A9716825A76F29F0FE2FD55")

    boolean mShowInputRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.437 -0500", hash_original_field = "46B9F45DD04B32BAA4E84977F39214E7", hash_generated_field = "46B9F45DD04B32BAA4E84977F39214E7")

    boolean mLastShowInputRequested;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.439 -0500", hash_original_field = "A9B119877C3EB8E978CAEECF1D6BD14B", hash_generated_field = "A9B119877C3EB8E978CAEECF1D6BD14B")

    int mCandidatesVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.496 -0400", hash_original_field = "C0ED2CFA44D0D69EEA23C8E4C66CE227", hash_generated_field = "497159238D66DB93A282D483EC1CA3AC")

    CompletionInfo[] mCurCompletions = new CompletionInfo[10];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.443 -0500", hash_original_field = "0A08F53EED6C8EEC9D7CC85E98FAC447", hash_generated_field = "0A08F53EED6C8EEC9D7CC85E98FAC447")
    
    boolean mShowInputForced;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.445 -0500", hash_original_field = "269508F0F9EF09EB866044C649D586B1", hash_generated_field = "269508F0F9EF09EB866044C649D586B1")
    
    boolean mFullscreenApplied;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.447 -0500", hash_original_field = "9CA62515CAD4DE9A3596FC712B0811BA", hash_generated_field = "9CA62515CAD4DE9A3596FC712B0811BA")

    boolean mIsFullscreen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.449 -0500", hash_original_field = "77749D3AEC38C02813E052F85601DCFE", hash_generated_field = "77749D3AEC38C02813E052F85601DCFE")

    View mExtractView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.451 -0500", hash_original_field = "41C2A191F101A74E110D9728B296F375", hash_generated_field = "41C2A191F101A74E110D9728B296F375")

    boolean mExtractViewHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.453 -0500", hash_original_field = "10C7C27B9EFB4B449D020D2FD7D681C8", hash_generated_field = "10C7C27B9EFB4B449D020D2FD7D681C8")

    ExtractEditText mExtractEditText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.456 -0500", hash_original_field = "49FE9D4C4E2B1ED741DB08F3BECEA464", hash_generated_field = "49FE9D4C4E2B1ED741DB08F3BECEA464")

    ViewGroup mExtractAccessories;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.458 -0500", hash_original_field = "4EF514D7B6A680A68FB4FA03A08F5D2D", hash_generated_field = "4EF514D7B6A680A68FB4FA03A08F5D2D")

    Button mExtractAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.460 -0500", hash_original_field = "7C5C99560AB4918E13830D06100AC03C", hash_generated_field = "7C5C99560AB4918E13830D06100AC03C")

    ExtractedText mExtractedText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.462 -0500", hash_original_field = "E322EFE9A47EF352CC52DE566A5DCA94", hash_generated_field = "E322EFE9A47EF352CC52DE566A5DCA94")

    int mExtractedToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.464 -0500", hash_original_field = "DD75F3DC122E5FCA3B30C64DE9D6C9CD", hash_generated_field = "DD75F3DC122E5FCA3B30C64DE9D6C9CD")
    
    View mInputView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.466 -0500", hash_original_field = "77B5EB3473D5B10089CC95C2ED94891E", hash_generated_field = "77B5EB3473D5B10089CC95C2ED94891E")

    boolean mIsInputViewShown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.468 -0500", hash_original_field = "98EF9B06A59A7DC308ADD81484067F39", hash_generated_field = "98EF9B06A59A7DC308ADD81484067F39")
    
    int mStatusIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.470 -0500", hash_original_field = "FD8B0612F7004ABC6C691A56C2D256FE", hash_generated_field = "FD8B0612F7004ABC6C691A56C2D256FE")

    int mBackDisposition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.472 -0500", hash_original_field = "68F5252D64F8D4159C578F571A77AB54", hash_generated_field = "F25E6A5ACF83E487D08AEE0325304099")

    final Insets mTmpInsets = new Insets();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.475 -0500", hash_original_field = "18ECE134BF0FC41944D7DF74E92F279C", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

    final int[] mTmpLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.800 -0400", hash_original_field = "142F5B53CE3CC0CB3C0E6D7392FA4726", hash_generated_field = "9D9565E91A7FEF8950C3A14F9D3149EC")

    final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.800 -0400", hash_original_method = "3A80214106299C195F4E4A04B9DB62AA", hash_generated_method = "4D6CFA468B0FC825A18D2D61E083253E")
        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo info) {
            
            {
                boolean var1E9E12E1C314AB48D78EC2186631F908_497923133 = (isExtractViewShown());
                {
                    View decor = getWindow().getWindow().getDecorView();
                    info.contentInsets.top = info.visibleInsets.top
                        = decor.getHeight();
                    info.touchableRegion.setEmpty();
                    info.setTouchableInsets(ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME);
                } 
                {
                    onComputeInsets(mTmpInsets);
                    info.contentInsets.top = mTmpInsets.contentTopInsets;
                    info.visibleInsets.top = mTmpInsets.visibleTopInsets;
                    info.touchableRegion.set(mTmpInsets.touchableRegion);
                    info.setTouchableInsets(mTmpInsets.touchableInsets);
                } 
            } 
            addTaint(info.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.801 -0400", hash_original_field = "C94A4138F2315FEEC71C08F04887EF50", hash_generated_field = "637074E4948BB4D273503B0842435434")

    final View.OnClickListener mActionClickListener = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:34.801 -0400", hash_original_method = "F78C13955980C6EBFBCB4858D6B59E8E", hash_generated_method = "452C45D9980B5EA2C69EA15855896959")
        public void onClick(View v) {
            
            final EditorInfo ei = getCurrentInputEditorInfo();
            final InputConnection ic = getCurrentInputConnection();
            {
                {
                    ic.performEditorAction(ei.actionId);
                } 
                {
                    ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
                } 
            } 
            addTaint(v.getTaint());
            
        }
        
};
    
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.498 -0400", hash_original_method = "1525492D8EE98BBF3E2138610F838AAF", hash_generated_method = "1525492D8EE98BBF3E2138610F838AAF")
    public InputMethodService ()
    {
        //Synthesized constructor
    }

    /**
     * You can call this to customize the theme used by your IME's window.
     * This theme should typically be one that derives from
     * {@link android.R.style#Theme_InputMethod}, which is the default theme
     * you will get.  This must be set before {@link #onCreate}, so you
     * will typically call it in your constructor with the resource ID
     * of your custom theme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.563 -0500", hash_original_method = "A950397745137F47AE3797B428EC17A0", hash_generated_method = "48910AF45450371D16B062913B9456A9")
    
@Override
    public void setTheme(int theme) {
        if (mWindow != null) {
            throw new IllegalStateException("Must be called before onCreate()");
        }
        mTheme = theme;
    }
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.501 -0400", hash_original_method = "A4061C51E6B315B625647A4DAEF1D932", hash_generated_method = "DE550ABE012B963890E5EA21805F7878")
    @Override
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mTheme = Resources.selectSystemTheme(mTheme,
                getApplicationInfo().targetSdkVersion,
                R.style.Theme_InputMethod,
                R.style.Theme_Holo_InputMethod,
                R.style.Theme_DeviceDefault_InputMethod);
        super.setTheme(mTheme);
        super.onCreate();
        mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        mInflater = (LayoutInflater)getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        mWindow = new SoftInputWindow(this, mTheme, mDispatcherState);
        initViews();
        mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        for (int i = 0; i < mCurCompletions.length; i++)
            mCurCompletions[i] = new CompletionInfo(getTaintInt(), getTaintInt(), new String());
        // ---------- Original Method ----------
        //mTheme = Resources.selectSystemTheme(mTheme,
                //getApplicationInfo().targetSdkVersion,
                //android.R.style.Theme_InputMethod,
                //android.R.style.Theme_Holo_InputMethod,
                //android.R.style.Theme_DeviceDefault_InputMethod);
        //super.setTheme(mTheme);
        //super.onCreate();
        //mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //mInflater = (LayoutInflater)getSystemService(
                //Context.LAYOUT_INFLATER_SERVICE);
        //mWindow = new SoftInputWindow(this, mTheme, mDispatcherState);
        //initViews();
        //mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
    }

    /**
     * This is a hook that subclasses can use to perform initialization of
     * their interface.  It is called for you prior to any of your UI objects
     * being created, both after the service is first created and after a
     * configuration change happens.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.567 -0500", hash_original_method = "76EDD2B848D79265B59C656C09132FEB", hash_generated_method = "3E535ACAB5A6FF8B0E562E4F7C3A9AAD")
    
public void onInitializeInterface() {
        // Intentionally empty
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.569 -0500", hash_original_method = "F1A6BBC586CE4C5158D93D758F9EE4FD", hash_generated_method = "F1A6BBC586CE4C5158D93D758F9EE4FD")
    
void initialize() {
        if (!mInitialized) {
            mInitialized = true;
            onInitializeInterface();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.572 -0500", hash_original_method = "E6A2B0DBCD46A23062A8849E041DB211", hash_generated_method = "E6A2B0DBCD46A23062A8849E041DB211")
    
void initViews() {
        mInitialized = false;
        mWindowCreated = false;
        mShowInputRequested = false;
        mShowInputForced = false;
        
        mThemeAttrs = obtainStyledAttributes(android.R.styleable.InputMethodService);
        mRootView = mInflater.inflate(
                com.android.internal.R.layout.input_method, null);
        mWindow.setContentView(mRootView);
        mRootView.getViewTreeObserver().addOnComputeInternalInsetsListener(mInsetsComputer);
        if (Settings.System.getInt(getContentResolver(),
                Settings.System.FANCY_IME_ANIMATIONS, 0) != 0) {
            mWindow.getWindow().setWindowAnimations(
                    com.android.internal.R.style.Animation_InputMethodFancy);
        }
        mFullscreenArea = (ViewGroup)mRootView.findViewById(com.android.internal.R.id.fullscreenArea);
        mExtractViewHidden = false;
        mExtractFrame = (FrameLayout)mRootView.findViewById(android.R.id.extractArea);
        mExtractView = null;
        mExtractEditText = null;
        mExtractAccessories = null;
        mExtractAction = null;
        mFullscreenApplied = false;
        
        mCandidatesFrame = (FrameLayout)mRootView.findViewById(android.R.id.candidatesArea);
        mInputFrame = (FrameLayout)mRootView.findViewById(android.R.id.inputArea);
        mInputView = null;
        mIsInputViewShown = false;
        
        mExtractFrame.setVisibility(View.GONE);
        mCandidatesVisibility = getCandidatesHiddenVisibility();
        mCandidatesFrame.setVisibility(mCandidatesVisibility);
        mInputFrame.setVisibility(View.GONE);
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.575 -0500", hash_original_method = "03BF0E4B83AB5EEC5EA04DACA2552646", hash_generated_method = "D40287164AA9AAAE1B590009ABEE7DE5")
    
@Override public void onDestroy() {
        super.onDestroy();
        mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(
                mInsetsComputer);
        finishViews();
        if (mWindowAdded) {
            // Disable exit animation for the current IME window
            // to avoid the race condition between the exit and enter animations
            // when the current IME is being switched to another one.
            mWindow.getWindow().setWindowAnimations(0);
            mWindow.dismiss();
        }
    }

    /**
     * Take care of handling configuration changes.  Subclasses of
     * InputMethodService generally don't need to deal directly with
     * this on their own; the standard implementation here takes care of
     * regenerating the input method UI as a result of the configuration
     * change, so you can rely on your {@link #onCreateInputView} and
     * other methods being called as appropriate due to a configuration change.
     * 
     * <p>When a configuration change does happen,
     * {@link #onInitializeInterface()} is guaranteed to be called the next
     * time prior to any of the other input or UI creation callbacks.  The
     * following will be called immediately depending if appropriate for current 
     * state: {@link #onStartInput} if input is active, and
     * {@link #onCreateInputView} and {@link #onStartInputView} and related
     * appropriate functions if the UI is displayed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.578 -0500", hash_original_method = "0B7AD8CA788BAE093A6DAEC0C292F050", hash_generated_method = "3C3FB2193CDA202E9F0B430EB2E5CCE1")
    
@Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        
        boolean visible = mWindowVisible;
        int showFlags = mShowInputFlags;
        boolean showingInput = mShowInputRequested;
        CompletionInfo[] completions = mCurCompletions;
        initViews();
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        if (mInputStarted) {
            doStartInput(getCurrentInputConnection(),
                    getCurrentInputEditorInfo(), true);
        }
        if (visible) {
            if (showingInput) {
                // If we were last showing the soft keyboard, try to do so again.
                if (onShowInputRequested(showFlags, true)) {
                    showWindow(true);
                    if (completions != null) {
                        mCurCompletions = completions;
                        onDisplayCompletions(completions);
                    }
                } else {
                    hideWindow();
                }
            } else if (mCandidatesVisibility == View.VISIBLE) {
                // If the candidates are currently visible, make sure the
                // window is shown for them.
                showWindow(false);
            } else {
                // Otherwise hide the window.
                hideWindow();
            }
            // If user uses hard keyboard, IME button should always be shown.
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
        }
    }

    /**
     * Implement to return our standard {@link InputMethodImpl}.  Subclasses
     * can override to provide their own customized version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.580 -0500", hash_original_method = "4C23D68F9AF6231E77018CB50F89B333", hash_generated_method = "C7C71BAFF712FDD0BECF11035D8BAA0A")
    
@Override
    public AbstractInputMethodImpl onCreateInputMethodInterface() {
        return new InputMethodImpl();
    }
    
    /**
     * Implement to return our standard {@link InputMethodSessionImpl}.  Subclasses
     * can override to provide their own customized version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.582 -0500", hash_original_method = "A293E788F38BE631F0B24DA3CBEC4EAD", hash_generated_method = "44F452FDC8DF063912DEB30D3C56E8D4")
    
@Override
    public AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface() {
        return new InputMethodSessionImpl();
    }
    
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.584 -0500", hash_original_method = "F107DE3A8547E443866FF02369203993", hash_generated_method = "4CF1F70C1CBF341A5B589F607395DBC8")
    
public LayoutInflater getLayoutInflater() {
        return mInflater;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.586 -0500", hash_original_method = "B35683FF457638BA2516208C83F2FBFC", hash_generated_method = "3B26147A9537504F5487B422467FEB84")
    
public Dialog getWindow() {
        return mWindow;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.588 -0500", hash_original_method = "4B38ED63C74A7D25A43EF42301FB70B0", hash_generated_method = "8B3DE038281684AC4E01620DE43A32AD")
    
public void setBackDisposition(int disposition) {
        mBackDisposition = disposition;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.591 -0500", hash_original_method = "FA0668AA74F2A3E40C75CD8A8BEC8D4A", hash_generated_method = "00DCF349E7F676C605558BCC0EF33FD8")
    
public int getBackDisposition() {
        return mBackDisposition;
    }

    /**
     * Return the maximum width, in pixels, available the input method.
     * Input methods are positioned at the bottom of the screen and, unless
     * running in fullscreen, will generally want to be as short as possible
     * so should compute their height based on their contents.  However, they
     * can stretch as much as needed horizontally.  The function returns to
     * you the maximum amount of space available horizontally, which you can
     * use if needed for UI placement.
     * 
     * <p>In many cases this is not needed, you can just rely on the normal
     * view layout mechanisms to position your views within the full horizontal
     * space given to the input method.
     * 
     * <p>Note that this value can change dynamically, in particular when the
     * screen orientation changes.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.593 -0500", hash_original_method = "BF0CCCE3A6DFBF869485401A0C0B52E1", hash_generated_method = "ADEB78F689314EFFE444E49DCCCF5417")
    
public int getMaxWidth() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }
    
    /**
     * Return the currently active InputBinding for the input method, or
     * null if there is none.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.595 -0500", hash_original_method = "064CBE2A131D4B226EADDD6A40CEAEED", hash_generated_method = "B6BEA4C803EDE2F29CDE1D3E32D1286E")
    
public InputBinding getCurrentInputBinding() {
        return mInputBinding;
    }
    
    /**
     * Retrieve the currently active InputConnection that is bound to
     * the input method, or null if there is none.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.598 -0500", hash_original_method = "25EFF753F3CF5167178BD7379B9659BF", hash_generated_method = "773E32CFFB6DFB776828E00B3A745593")
    
public InputConnection getCurrentInputConnection() {
        InputConnection ic = mStartedInputConnection;
        if (ic != null) {
            return ic;
        }
        return mInputConnection;
    }
    
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.600 -0500", hash_original_method = "26F207E076BC370412C35CB8C7E97837", hash_generated_method = "632DACABD4ABB9A7681CFF8FCED9BF60")
    
public boolean getCurrentInputStarted() {
        return mInputStarted;
    }
    
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.602 -0500", hash_original_method = "659C592D4ABB3DB82261D1C4692ABF2E", hash_generated_method = "D176431D91B0F46E596F046F6DFE48B1")
    
public EditorInfo getCurrentInputEditorInfo() {
        return mInputEditorInfo;
    }
    
    /**
     * Re-evaluate whether the input method should be running in fullscreen
     * mode, and update its UI if this has changed since the last time it
     * was evaluated.  This will call {@link #onEvaluateFullscreenMode()} to
     * determine whether it should currently run in fullscreen mode.  You
     * can use {@link #isFullscreenMode()} to determine if the input method
     * is currently running in fullscreen mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.605 -0500", hash_original_method = "27763B4939D9D4CE4F4BEBC3E63AF469", hash_generated_method = "818B591695DAE11A4F7ABA1CB2E77633")
    
public void updateFullscreenMode() {
        boolean isFullscreen = mShowInputRequested && onEvaluateFullscreenMode();
        boolean changed = mLastShowInputRequested != mShowInputRequested;
        if (mIsFullscreen != isFullscreen || !mFullscreenApplied) {
            changed = true;
            mIsFullscreen = isFullscreen;
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) ic.reportFullscreenMode(isFullscreen);
            mFullscreenApplied = true;
            initialize();
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)
                    mFullscreenArea.getLayoutParams();
            if (isFullscreen) {
                mFullscreenArea.setBackgroundDrawable(mThemeAttrs.getDrawable(
                        com.android.internal.R.styleable.InputMethodService_imeFullscreenBackground));
                lp.height = 0;
                lp.weight = 1;
            } else {
                mFullscreenArea.setBackgroundDrawable(null);
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lp.weight = 0;
            }
            ((ViewGroup)mFullscreenArea.getParent()).updateViewLayout(
                    mFullscreenArea, lp);
            if (isFullscreen) {
                if (mExtractView == null) {
                    View v = onCreateExtractTextView();
                    if (v != null) {
                        setExtractView(v);
                    }
                }
                startExtractingText(false);
            }
            updateExtractFrameVisibility();
        }
        
        if (changed) {
            onConfigureWindow(mWindow.getWindow(), isFullscreen, !mShowInputRequested);
            mLastShowInputRequested = mShowInputRequested;
        }
    }
    
    /**
     * Update the given window's parameters for the given mode.  This is called
     * when the window is first displayed and each time the fullscreen or
     * candidates only mode changes.
     * 
     * <p>The default implementation makes the layout for the window
     * MATCH_PARENT x MATCH_PARENT when in fullscreen mode, and
     * MATCH_PARENT x WRAP_CONTENT when in non-fullscreen mode.
     * 
     * @param win The input method's window.
     * @param isFullscreen If true, the window is running in fullscreen mode
     * and intended to cover the entire application display.
     * @param isCandidatesOnly If true, the window is only showing the
     * candidates view and none of the rest of its UI.  This is mutually
     * exclusive with fullscreen mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.607 -0500", hash_original_method = "57F13E10195CB2F326F03FED8DB64B03", hash_generated_method = "88229C4551C9DA9B322C2C02C18D20F4")
    
public void onConfigureWindow(Window win, boolean isFullscreen,
            boolean isCandidatesOnly) {
        if (isFullscreen) {
            mWindow.getWindow().setLayout(MATCH_PARENT, MATCH_PARENT);
        } else {
            mWindow.getWindow().setLayout(MATCH_PARENT, WRAP_CONTENT);
        }
    }
    
    /**
     * Return whether the input method is <em>currently</em> running in
     * fullscreen mode.  This is the mode that was last determined and
     * applied by {@link #updateFullscreenMode()}.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.610 -0500", hash_original_method = "0B558CA7980DF9D2EBB981E6DDF5DF60", hash_generated_method = "B321AA08AAE634E6027026700009F5FD")
    
public boolean isFullscreenMode() {
        return mIsFullscreen;
    }
    
    /**
     * Override this to control when the input method should run in
     * fullscreen mode.  The default implementation runs in fullsceen only
     * when the screen is in landscape mode.  If you change what
     * this returns, you will need to call {@link #updateFullscreenMode()}
     * yourself whenever the returned value may have changed to have it
     * re-evaluated and applied.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.613 -0500", hash_original_method = "F5927891A0B192B06619C4589486FDC4", hash_generated_method = "4F7065D0C09D945EF9C05947187A0957")
    
public boolean onEvaluateFullscreenMode() {
        Configuration config = getResources().getConfiguration();
        if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            return false;
        }
        if (mInputEditorInfo != null
                && (mInputEditorInfo.imeOptions & EditorInfo.IME_FLAG_NO_FULLSCREEN) != 0) {
            return false;
        }
        return true;
    }

    /**
     * Controls the visibility of the extracted text area.  This only applies
     * when the input method is in fullscreen mode, and thus showing extracted
     * text.  When false, the extracted text will not be shown, allowing some
     * of the application to be seen behind.  This is normally set for you
     * by {@link #onUpdateExtractingVisibility}.  This controls the visibility
     * of both the extracted text and candidate view; the latter since it is
     * not useful if there is no text to see.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.615 -0500", hash_original_method = "D4950711A20DE11BC2C7EA5EC93FE5E0", hash_generated_method = "1DC4FCD3BF396E9625C846BD58EDCAA4")
    
public void setExtractViewShown(boolean shown) {
        if (mExtractViewHidden == shown) {
            mExtractViewHidden = !shown;
            updateExtractFrameVisibility();
        }
    }
    
    /**
     * Return whether the fullscreen extract view is shown.  This will only
     * return true if {@link #isFullscreenMode()} returns true, and in that
     * case its value depends on the last call to
     * {@link #setExtractViewShown(boolean)}.  This effectively lets you
     * determine if the application window is entirely covered (when this
     * returns true) or if some part of it may be shown (if this returns
     * false, though if {@link #isFullscreenMode()} returns true in that case
     * then it is probably only a sliver of the application).
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.617 -0500", hash_original_method = "DE07F0C980519D51E427F21507DA3D90", hash_generated_method = "FDF8A7945E1DE1CEF7141158AE75CEAE")
    
public boolean isExtractViewShown() {
        return mIsFullscreen && !mExtractViewHidden;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.620 -0500", hash_original_method = "7CD3F30CDD4A5DA751939DF09DB853BA", hash_generated_method = "7CD3F30CDD4A5DA751939DF09DB853BA")
    
void updateExtractFrameVisibility() {
        int vis;
        if (isFullscreenMode()) {
            vis = mExtractViewHidden ? View.INVISIBLE : View.VISIBLE;
            mExtractFrame.setVisibility(View.VISIBLE);
        } else {
            vis = View.VISIBLE;
            mExtractFrame.setVisibility(View.GONE);
        }
        updateCandidatesVisibility(mCandidatesVisibility == View.VISIBLE);
        if (mWindowWasVisible && mFullscreenArea.getVisibility() != vis) {
            int animRes = mThemeAttrs.getResourceId(vis == View.VISIBLE
                    ? com.android.internal.R.styleable.InputMethodService_imeExtractEnterAnimation
                    : com.android.internal.R.styleable.InputMethodService_imeExtractExitAnimation,
                    0);
            if (animRes != 0) {
                mFullscreenArea.startAnimation(AnimationUtils.loadAnimation(
                        this, animRes));
            }
        }
        mFullscreenArea.setVisibility(vis);
    }
    
    /**
     * Compute the interesting insets into your UI.  The default implementation
     * uses the top of the candidates frame for the visible insets, and the
     * top of the input frame for the content insets.  The default touchable
     * insets are {@link Insets#TOUCHABLE_INSETS_VISIBLE}.
     * 
     * <p>Note that this method is not called when
     * {@link #isExtractViewShown} returns true, since
     * in that case the application is left as-is behind the input method and
     * not impacted by anything in its UI.
     * 
     * @param outInsets Fill in with the current UI insets.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.623 -0500", hash_original_method = "46EC672E73C1227D1C1A9029A1E1F3EE", hash_generated_method = "940C942A0F46F3BC34C0A84D7E0CCE32")
    
public void onComputeInsets(Insets outInsets) {
        int[] loc = mTmpLocation;
        if (mInputFrame.getVisibility() == View.VISIBLE) {
            mInputFrame.getLocationInWindow(loc);
        } else {
            View decor = getWindow().getWindow().getDecorView();
            loc[1] = decor.getHeight();
        }
        if (isFullscreenMode()) {
            // In fullscreen mode, we never resize the underlying window.
            View decor = getWindow().getWindow().getDecorView();
            outInsets.contentTopInsets = decor.getHeight();
        } else {
            outInsets.contentTopInsets = loc[1];
        }
        if (mCandidatesFrame.getVisibility() == View.VISIBLE) {
            mCandidatesFrame.getLocationInWindow(loc);
        }
        outInsets.visibleTopInsets = loc[1];
        outInsets.touchableInsets = Insets.TOUCHABLE_INSETS_VISIBLE;
        outInsets.touchableRegion.setEmpty();
    }
    
    /**
     * Re-evaluate whether the soft input area should currently be shown, and
     * update its UI if this has changed since the last time it
     * was evaluated.  This will call {@link #onEvaluateInputViewShown()} to
     * determine whether the input view should currently be shown.  You
     * can use {@link #isInputViewShown()} to determine if the input view
     * is currently shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.625 -0500", hash_original_method = "0265E8D9142690DEBAB6C995400C2A87", hash_generated_method = "B3356D586EFD077C5B52395A3820E925")
    
public void updateInputViewShown() {
        boolean isShown = mShowInputRequested && onEvaluateInputViewShown();
        if (mIsInputViewShown != isShown && mWindowVisible) {
            mIsInputViewShown = isShown;
            mInputFrame.setVisibility(isShown ? View.VISIBLE : View.GONE);
            if (mInputView == null) {
                initialize();
                View v = onCreateInputView();
                if (v != null) {
                    setInputView(v);
                }
            }
        }
    }
    
    /**
     * Returns true if we have been asked to show our input view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.627 -0500", hash_original_method = "CE1497EC29214CA28D281C89DC587F5D", hash_generated_method = "DB3F46EC0312377E684FDABEA4C94E11")
    
public boolean isShowInputRequested() {
        return mShowInputRequested;
    }
    
    /**
     * Return whether the soft input view is <em>currently</em> shown to the
     * user.  This is the state that was last determined and
     * applied by {@link #updateInputViewShown()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.629 -0500", hash_original_method = "FAB0B10F230F7249B0A5682A6CF03BDF", hash_generated_method = "1F6F8E12409B80894F73502F5B02E332")
    
public boolean isInputViewShown() {
        return mIsInputViewShown && mWindowVisible;
    }
    
    /**
     * Override this to control when the soft input area should be shown to
     * the user.  The default implementation only shows the input view when
     * there is no hard keyboard or the keyboard is hidden.  If you change what
     * this returns, you will need to call {@link #updateInputViewShown()}
     * yourself whenever the returned value may have changed to have it
     * re-evaluated and applied.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.631 -0500", hash_original_method = "1FE8D4523FDD0EE9294351AC86397C44", hash_generated_method = "546D00F4FC759D3210AABB1BE082E59F")
    
public boolean onEvaluateInputViewShown() {
        Configuration config = getResources().getConfiguration();
        return config.keyboard == Configuration.KEYBOARD_NOKEYS
                || config.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES;
    }
    
    /**
     * Controls the visibility of the candidates display area.  By default
     * it is hidden.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.633 -0500", hash_original_method = "3ADC6F28D6F2E8A9F55D9BD9F82BC8D2", hash_generated_method = "DA1466E8A78C34D96D22AC6F8D4A0297")
    
public void setCandidatesViewShown(boolean shown) {
        updateCandidatesVisibility(shown);
        if (!mShowInputRequested && mWindowVisible != shown) {
            // If we are being asked to show the candidates view while the app
            // has not asked for the input view to be shown, then we need
            // to update whether the window is shown.
            if (shown) {
                showWindow(false);
            } else {
                hideWindow();
            }
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.636 -0500", hash_original_method = "4164AC2B45DCCBE42C527D3F966F5882", hash_generated_method = "4164AC2B45DCCBE42C527D3F966F5882")
    
void updateCandidatesVisibility(boolean shown) {
        int vis = shown ? View.VISIBLE : getCandidatesHiddenVisibility();
        if (mCandidatesVisibility != vis) {
            mCandidatesFrame.setVisibility(vis);
            mCandidatesVisibility = vis;
        }
    }
    
    /**
     * Returns the visibility mode (either {@link View#INVISIBLE View.INVISIBLE}
     * or {@link View#GONE View.GONE}) of the candidates view when it is not
     * shown.  The default implementation returns GONE when
     * {@link #isExtractViewShown} returns true,
     * otherwise VISIBLE.  Be careful if you change this to return GONE in
     * other situations -- if showing or hiding the candidates view causes
     * your window to resize, this can cause temporary drawing artifacts as
     * the resize takes place.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.638 -0500", hash_original_method = "587D3BCB04C3551F0F314F802D60C565", hash_generated_method = "D08FAE0D6A30FDFC765C1AC5C847B2DC")
    
public int getCandidatesHiddenVisibility() {
        return isExtractViewShown() ? View.GONE : View.INVISIBLE;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.641 -0500", hash_original_method = "09F11407FBE421F2EB35629AC776C29A", hash_generated_method = "CE678E027684AE2EBB4F6EEDD12ABAB6")
    
public void showStatusIcon(int iconResId) {
        mStatusIcon = iconResId;
        mImm.showStatusIcon(mToken, getPackageName(), iconResId);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.643 -0500", hash_original_method = "F1217201D04BC19DA5F1842A9EA12AC0", hash_generated_method = "852FF138F21E24A872AB2FB5B03F3E8A")
    
public void hideStatusIcon() {
        mStatusIcon = 0;
        mImm.hideStatusIcon(mToken);
    }
    
    /**
     * Force switch to a new input method, as identified by <var>id</var>.  This
     * input method will be destroyed, and the requested one started on the
     * current input field.
     * 
     * @param id Unique identifier of the new input method ot start.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.645 -0500", hash_original_method = "65B927BAD02A0A8652162D17880CBC94", hash_generated_method = "1B43AB2EE7C45366A2EF700FC28E9C9E")
    
public void switchInputMethod(String id) {
        mImm.setInputMethod(mToken, id);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.648 -0500", hash_original_method = "7F30721F4F1DC6518EC25FA69EEA9DD8", hash_generated_method = "A79C5D4CEE99E0EA5F26C13FD80C83FC")
    
public void setExtractView(View view) {
        mExtractFrame.removeAllViews();
        mExtractFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mExtractView = view;
        if (view != null) {
            mExtractEditText = (ExtractEditText)view.findViewById(
                    com.android.internal.R.id.inputExtractEditText);
            mExtractEditText.setIME(this);
            mExtractAction = (Button)view.findViewById(
                    com.android.internal.R.id.inputExtractAction);
            if (mExtractAction != null) {
                mExtractAccessories = (ViewGroup)view.findViewById(
                        com.android.internal.R.id.inputExtractAccessories);
            }
            startExtractingText(false);
        } else {
            mExtractEditText = null;
            mExtractAccessories = null;
            mExtractAction = null;
        }
    }
    
    /**
     * Replaces the current candidates view with a new one.  You only need to
     * call this when dynamically changing the view; normally, you should
     * implement {@link #onCreateCandidatesView()} and create your view when
     * first needed by the input method.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.650 -0500", hash_original_method = "8648EAF39F078D77783E311D9636B394", hash_generated_method = "E9A500E1CB4F88393500486BBFA81A7D")
    
public void setCandidatesView(View view) {
        mCandidatesFrame.removeAllViews();
        mCandidatesFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    
    /**
     * Replaces the current input view with a new one.  You only need to
     * call this when dynamically changing the view; normally, you should
     * implement {@link #onCreateInputView()} and create your view when
     * first needed by the input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.653 -0500", hash_original_method = "F530779F20B702B2AC3AEE15911FE235", hash_generated_method = "0B8F8727A5707060748344E3B149EA11")
    
public void setInputView(View view) {
        mInputFrame.removeAllViews();
        mInputFrame.addView(view, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mInputView = view;
    }
    
    /**
     * Called by the framework to create the layout for showing extacted text.
     * Only called when in fullscreen mode.  The returned view hierarchy must
     * have an {@link ExtractEditText} whose ID is 
     * {@link android.R.id#inputExtractEditText}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.655 -0500", hash_original_method = "A13C1AA9A5FD5770C02F503628C51194", hash_generated_method = "47C839EB720ED22E452F5F12BEEB5FA9")
    
public View onCreateExtractTextView() {
        return mInflater.inflate(
                com.android.internal.R.layout.input_method_extract_view, null);
    }
    
    /**
     * Create and return the view hierarchy used to show candidates.  This will
     * be called once, when the candidates are first displayed.  You can return
     * null to have no candidates view; the default implementation returns null.
     * 
     * <p>To control when the candidates view is displayed, use
     * {@link #setCandidatesViewShown(boolean)}.
     * To change the candidates view after the first one is created by this
     * function, use {@link #setCandidatesView(View)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.657 -0500", hash_original_method = "F89AAD61B39578A3862B8537E7226DB5", hash_generated_method = "729FDEE88380E59273098AB7D39A14E6")
    
public View onCreateCandidatesView() {
        return null;
    }
    
    /**
     * Create and return the view hierarchy used for the input area (such as
     * a soft keyboard).  This will be called once, when the input area is
     * first displayed.  You can return null to have no input area; the default
     * implementation returns null.
     * 
     * <p>To control when the input view is displayed, implement
     * {@link #onEvaluateInputViewShown()}.
     * To change the input view after the first one is created by this
     * function, use {@link #setInputView(View)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.659 -0500", hash_original_method = "75C53F9A7550BADCC3EEC67DE46E8BC4", hash_generated_method = "BCB084B65C5FA5F6A182B53EA2F44C7E")
    
public View onCreateInputView() {
        return null;
    }
    
    /**
     * Called when the input view is being shown and input has started on
     * a new editor.  This will always be called after {@link #onStartInput},
     * allowing you to do your general setup there and just view-specific
     * setup here.  You are guaranteed that {@link #onCreateInputView()} will
     * have been called some time before this function is called.
     * 
     * @param info Description of the type of text being edited.
     * @param restarting Set to true if we are restarting input on the
     * same text field as before.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.661 -0500", hash_original_method = "4B7A497965AEC42ECF0C79E271F7AFEF", hash_generated_method = "7AA061D048DFE3946E7BBEB04867DE6E")
    
public void onStartInputView(EditorInfo info, boolean restarting) {
        // Intentionally empty
    }
    
    /**
     * Called when the input view is being hidden from the user.  This will
     * be called either prior to hiding the window, or prior to switching to
     * another target for editing.
     * 
     * <p>The default
     * implementation uses the InputConnection to clear any active composing
     * text; you can override this (not calling the base class implementation)
     * to perform whatever behavior you would like.
     * 
     * @param finishingInput If true, {@link #onFinishInput} will be
     * called immediately after.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.664 -0500", hash_original_method = "126397FC018D546EBB3D17AA8B426F4F", hash_generated_method = "17C1B9A68732FF3A02D8C62F56E226D2")
    
public void onFinishInputView(boolean finishingInput) {
        if (!finishingInput) {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.finishComposingText();
            }
        }
    }
    
    /**
     * Called when only the candidates view has been shown for showing
     * processing as the user enters text through a hard keyboard.
     * This will always be called after {@link #onStartInput},
     * allowing you to do your general setup there and just view-specific
     * setup here.  You are guaranteed that {@link #onCreateCandidatesView()}
     * will have been called some time before this function is called.
     * 
     * <p>Note that this will <em>not</em> be called when the input method
     * is running in full editing mode, and thus receiving
     * {@link #onStartInputView} to initiate that operation.  This is only
     * for the case when candidates are being shown while the input method
     * editor is hidden but wants to show its candidates UI as text is
     * entered through some other mechanism.
     * 
     * @param info Description of the type of text being edited.
     * @param restarting Set to true if we are restarting input on the
     * same text field as before.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.666 -0500", hash_original_method = "C1D318033051A63629AB7F18935A055B", hash_generated_method = "25E04BF028F40DB40C0FBEA7308135A9")
    
public void onStartCandidatesView(EditorInfo info, boolean restarting) {
        // Intentionally empty
    }
    
    /**
     * Called when the candidates view is being hidden from the user.  This will
     * be called either prior to hiding the window, or prior to switching to
     * another target for editing.
     * 
     * <p>The default
     * implementation uses the InputConnection to clear any active composing
     * text; you can override this (not calling the base class implementation)
     * to perform whatever behavior you would like.
     * 
     * @param finishingInput If true, {@link #onFinishInput} will be
     * called immediately after.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.668 -0500", hash_original_method = "7B21B5BD050EBE81B79EA707D7F10503", hash_generated_method = "1C179D425D957582906CBEF39B44746E")
    
public void onFinishCandidatesView(boolean finishingInput) {
        if (!finishingInput) {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.finishComposingText();
            }
        }
    }
    
    /**
     * The system has decided that it may be time to show your input method.
     * This is called due to a corresponding call to your
     * {@link InputMethod#showSoftInput InputMethod.showSoftInput()}
     * method.  The default implementation uses
     * {@link #onEvaluateInputViewShown()}, {@link #onEvaluateFullscreenMode()},
     * and the current configuration to decide whether the input view should
     * be shown at this point.
     * 
     * @param flags Provides additional information about the show request,
     * as per {@link InputMethod#showSoftInput InputMethod.showSoftInput()}.
     * @param configChange This is true if we are re-showing due to a
     * configuration change.
     * @return Returns true to indicate that the window should be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.671 -0500", hash_original_method = "7116B74C32B9543E489CB78AF9B82E3D", hash_generated_method = "B06A550FB04263C3F83FE1F7FFECED63")
    
public boolean onShowInputRequested(int flags, boolean configChange) {
        if (!onEvaluateInputViewShown()) {
            return false;
        }
        if ((flags&InputMethod.SHOW_EXPLICIT) == 0) {
            if (!configChange && onEvaluateFullscreenMode()) {
                // Don't show if this is not explicitly requested by the user and
                // the input method is fullscreen.  That would be too disruptive.
                // However, we skip this change for a config change, since if
                // the IME is already shown we do want to go into fullscreen
                // mode at this point.
                return false;
            }
            Configuration config = getResources().getConfiguration();
            if (config.keyboard != Configuration.KEYBOARD_NOKEYS) {
                // And if the device has a hard keyboard, even if it is
                // currently hidden, don't show the input method implicitly.
                // These kinds of devices don't need it that much.
                return false;
            }
        }
        if ((flags&InputMethod.SHOW_FORCED) != 0) {
            mShowInputForced = true;
        }
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.673 -0500", hash_original_method = "119016FA69877024FD5AD688A6BA764A", hash_generated_method = "4F5292124B7B42EAFDAFC169BA6F844C")
    
public void showWindow(boolean showInput) {
        if (DEBUG) Log.v(TAG, "Showing window: showInput=" + showInput
                + " mShowInputRequested=" + mShowInputRequested
                + " mWindowAdded=" + mWindowAdded
                + " mWindowCreated=" + mWindowCreated
                + " mWindowVisible=" + mWindowVisible
                + " mInputStarted=" + mInputStarted);
        
        if (mInShowWindow) {
            Log.w(TAG, "Re-entrance in to showWindow");
            return;
        }
        
        try {
            mWindowWasVisible = mWindowVisible;
            mInShowWindow = true;
            showWindowInner(showInput);
        } finally {
            mWindowWasVisible = true;
            mInShowWindow = false;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.676 -0500", hash_original_method = "CB135560325B3F8C18497A9052C17028", hash_generated_method = "CB135560325B3F8C18497A9052C17028")
    
void showWindowInner(boolean showInput) {
        boolean doShowInput = false;
        boolean wasVisible = mWindowVisible;
        mWindowVisible = true;
        if (!mShowInputRequested) {
            if (mInputStarted) {
                if (showInput) {
                    doShowInput = true;
                    mShowInputRequested = true;
                }
            }
        } else {
            showInput = true;
        }

        if (DEBUG) Log.v(TAG, "showWindow: updating UI");
        initialize();
        updateFullscreenMode();
        updateInputViewShown();
        
        if (!mWindowAdded || !mWindowCreated) {
            mWindowAdded = true;
            mWindowCreated = true;
            initialize();
            if (DEBUG) Log.v(TAG, "CALL: onCreateCandidatesView");
            View v = onCreateCandidatesView();
            if (DEBUG) Log.v(TAG, "showWindow: candidates=" + v);
            if (v != null) {
                setCandidatesView(v);
            }
        }
        if (mShowInputRequested) {
            if (!mInputViewStarted) {
                if (DEBUG) Log.v(TAG, "CALL: onStartInputView");
                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, false);
            }
        } else if (!mCandidatesViewStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onStartCandidatesView");
            mCandidatesViewStarted = true;
            onStartCandidatesView(mInputEditorInfo, false);
        }
        
        if (doShowInput) {
            startExtractingText(false);
        }

        if (!wasVisible) {
            if (DEBUG) Log.v(TAG, "showWindow: showing!");
            mImm.setImeWindowStatus(mToken, IME_ACTIVE, mBackDisposition);
            onWindowShown();
            mWindow.show();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.678 -0500", hash_original_method = "AE7818A6DC114C265A5A8660654BB926", hash_generated_method = "4D27D30FD732E18954E05BA82231EA7C")
    
private void finishViews() {
        if (mInputViewStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onFinishInputView");
            onFinishInputView(false);
        } else if (mCandidatesViewStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onFinishCandidatesView");
            onFinishCandidatesView(false);
        }
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.681 -0500", hash_original_method = "09134BCCF788D1D9024485AE6DA1693C", hash_generated_method = "5FCAD915B8EA757F1183B8CD3FE2C705")
    
public void hideWindow() {
        finishViews();
        mImm.setImeWindowStatus(mToken, 0, mBackDisposition);
        if (mWindowVisible) {
            mWindow.hide();
            mWindowVisible = false;
            onWindowHidden();
            mWindowWasVisible = false;
        }
    }

    /**
     * Called when the input method window has been shown to the user, after
     * previously not being visible.  This is done after all of the UI setup
     * for the window has occurred (creating its views etc).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.683 -0500", hash_original_method = "D99B15EAA68884714BB333A2583A0571", hash_generated_method = "96B7150E198E857952BAC0B3F5B2B8B0")
    
public void onWindowShown() {
        // Intentionally empty
    }
    
    /**
     * Called when the input method window has been hidden from the user,
     * after previously being visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.685 -0500", hash_original_method = "C1BA79DB491FC590F2A9A222970A46B9", hash_generated_method = "4C269A9B8CE1079FC70128A466B93447")
    
public void onWindowHidden() {
        // Intentionally empty
    }
    
    /**
     * Called when a new client has bound to the input method.  This
     * may be followed by a series of {@link #onStartInput(EditorInfo, boolean)}
     * and {@link #onFinishInput()} calls as the user navigates through its
     * UI.  Upon this call you know that {@link #getCurrentInputBinding}
     * and {@link #getCurrentInputConnection} return valid objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.688 -0500", hash_original_method = "56BEE8816781B99E44028AA4DD49AFE8", hash_generated_method = "231ACEDE3A58D02028723C3B5DF99975")
    
public void onBindInput() {
        // Intentionally empty
    }
    
    /**
     * Called when the previous bound client is no longer associated
     * with the input method.  After returning {@link #getCurrentInputBinding}
     * and {@link #getCurrentInputConnection} will no longer return
     * valid objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.690 -0500", hash_original_method = "D52B154580F2280F1D8D5CF7DCC6C0BF", hash_generated_method = "7B9B1A1E919D89B8055019C1444F6632")
    
public void onUnbindInput() {
        // Intentionally empty
    }
    
    /**
     * Called to inform the input method that text input has started in an
     * editor.  You should use this callback to initialize the state of your
     * input to match the state of the editor given to it.
     * 
     * @param attribute The attributes of the editor that input is starting
     * in.
     * @param restarting Set to true if input is restarting in the same
     * editor such as because the application has changed the text in
     * the editor.  Otherwise will be false, indicating this is a new
     * session with the editor.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.692 -0500", hash_original_method = "3ADFFB39DB97C5354271962A42564DD7", hash_generated_method = "C1E9AD96C736581C1A705C6238BF6027")
    
public void onStartInput(EditorInfo attribute, boolean restarting) {
        // Intentionally empty
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.694 -0500", hash_original_method = "D870334B8409E203BCA5DBA60A032B6F", hash_generated_method = "D870334B8409E203BCA5DBA60A032B6F")
    
void doFinishInput() {
        if (mInputViewStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onFinishInputView");
            onFinishInputView(true);
        } else if (mCandidatesViewStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onFinishCandidatesView");
            onFinishCandidatesView(true);
        }
        mInputViewStarted = false;
        mCandidatesViewStarted = false;
        if (mInputStarted) {
            if (DEBUG) Log.v(TAG, "CALL: onFinishInput");
            onFinishInput();
        }
        mInputStarted = false;
        mStartedInputConnection = null;
        mCurCompletions = null;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.697 -0500", hash_original_method = "D70A8E32EEED9199B71D72D85567D543", hash_generated_method = "D70A8E32EEED9199B71D72D85567D543")
    
void doStartInput(InputConnection ic, EditorInfo attribute, boolean restarting) {
        if (!restarting) {
            doFinishInput();
        }
        mInputStarted = true;
        mStartedInputConnection = ic;
        mInputEditorInfo = attribute;
        initialize();
        if (DEBUG) Log.v(TAG, "CALL: onStartInput");
        onStartInput(attribute, restarting);
        if (mWindowVisible) {
            if (mShowInputRequested) {
                if (DEBUG) Log.v(TAG, "CALL: onStartInputView");
                mInputViewStarted = true;
                onStartInputView(mInputEditorInfo, restarting);
                startExtractingText(true);
            } else if (mCandidatesVisibility == View.VISIBLE) {
                if (DEBUG) Log.v(TAG, "CALL: onStartCandidatesView");
                mCandidatesViewStarted = true;
                onStartCandidatesView(mInputEditorInfo, restarting);
            }
        }
    }
    
    /**
     * Called to inform the input method that text input has finished in
     * the last editor.  At this point there may be a call to
     * {@link #onStartInput(EditorInfo, boolean)} to perform input in a
     * new editor, or the input method may be left idle.  This method is
     * <em>not</em> called when input restarts in the same editor.
     * 
     * <p>The default
     * implementation uses the InputConnection to clear any active composing
     * text; you can override this (not calling the base class implementation)
     * to perform whatever behavior you would like.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.699 -0500", hash_original_method = "E745A863BE4D98B94E02F169B272F08C", hash_generated_method = "1B6DE133E922D6BCF141B2D837C355BE")
    
public void onFinishInput() {
        InputConnection ic = getCurrentInputConnection();
        if (ic != null) {
            ic.finishComposingText();
        }
    }
    
    /**
     * Called when the application has reported auto-completion candidates that
     * it would like to have the input method displayed.  Typically these are
     * only used when an input method is running in full-screen mode, since
     * otherwise the user can see and interact with the pop-up window of
     * completions shown by the application.
     * 
     * <p>The default implementation here does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.701 -0500", hash_original_method = "75C3F475CAD98FE8CF4A523C8BDA8BB1", hash_generated_method = "EB17B144C38574BF696AAA7C1A153C30")
    
public void onDisplayCompletions(CompletionInfo[] completions) {
        // Intentionally empty
    }
    
    /**
     * Called when the application has reported new extracted text to be shown
     * due to changes in its current text state.  The default implementation
     * here places the new text in the extract edit text, when the input
     * method is running in fullscreen mode.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.704 -0500", hash_original_method = "CC541C375904CEFCC1DC228363FE0C44", hash_generated_method = "97E09452EA6DB754301C2DA73BB44033")
    
public void onUpdateExtractedText(int token, ExtractedText text) {
        if (mExtractedToken != token) {
            return;
        }
        if (text != null) {
            if (mExtractEditText != null) {
                mExtractedText = text;
                mExtractEditText.setExtractedText(text);
            }
        }
    }
    
    /**
     * Called when the application has reported a new selection region of
     * the text.  This is called whether or not the input method has requested
     * extracted text updates, although if so it will not receive this call
     * if the extracted text has changed as well.
     * 
     * <p>The default implementation takes care of updating the cursor in
     * the extract text, if it is being shown.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.706 -0500", hash_original_method = "08F34B1B106CF5B01DE522670D82A3BC", hash_generated_method = "B8226CECE01A1CE14F7C4DC9D2929B8E")
    
public void onUpdateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd) {
        final ExtractEditText eet = mExtractEditText;
        if (eet != null && isFullscreenMode() && mExtractedText != null) {
            final int off = mExtractedText.startOffset;
            eet.startInternalChanges();
            newSelStart -= off;
            newSelEnd -= off;
            final int len = eet.getText().length();
            if (newSelStart < 0) newSelStart = 0;
            else if (newSelStart > len) newSelStart = len;
            if (newSelEnd < 0) newSelEnd = 0;
            else if (newSelEnd > len) newSelEnd = len;
            eet.setSelection(newSelStart, newSelEnd);
            eet.finishInternalChanges();
        }
    }

    /**
     * Called when the user tapped or clicked a text view.
     * IMEs can't rely on this method being called because this was not part of the original IME
     * protocol, so applications with custom text editing written before this method appeared will
     * not call to inform the IME of this interaction.
     * @param focusChanged true if the user changed the focused view by this click.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.709 -0500", hash_original_method = "D49077B58DC986892621B88ACD9BF0F7", hash_generated_method = "4C27AC30A483FD0C067ED7852DD47C69")
    
public void onViewClicked(boolean focusChanged) {
        // Intentionally empty
    }

    /**
     * Called when the application has reported a new location of its text
     * cursor.  This is only called if explicitly requested by the input method.
     * The default implementation does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.712 -0500", hash_original_method = "F8EB5FE11A8138FB360940D74155758A", hash_generated_method = "26A1B5B7E7566CBB6755F894F024BF91")
    
public void onUpdateCursor(Rect newCursor) {
        // Intentionally empty
    }

    /**
     * Close this input method's soft input area, removing it from the display.
     * The input method will continue running, but the user can no longer use
     * it to generate input by touching the screen.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link InputMethodManager#HIDE_IMPLICIT_ONLY
     * InputMethodManager.HIDE_IMPLICIT_ONLY} bit set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.714 -0500", hash_original_method = "53762C81936F5FCD41F3F903406EE4C3", hash_generated_method = "B46FA1F5E173ACAAA99CB1E3409A3A33")
    
public void requestHideSelf(int flags) {
        mImm.hideSoftInputFromInputMethod(mToken, flags);
    }
    
    /**
     * Show the input method. This is a call back to the
     * IMF to handle showing the input method.
     * Close this input method's soft input area, removing it from the display.
     * The input method will continue running, but the user can no longer use
     * it to generate input by touching the screen.
     * @param flags Provides additional operating flags.  Currently may be
     * 0 or have the {@link InputMethodManager#SHOW_FORCED
     * InputMethodManager.} bit set.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.716 -0500", hash_original_method = "939E9922D22E9C6523AEB259C97CBC65", hash_generated_method = "AC9E94CA49B20B098BEE1E960A103A15")
    
private void requestShowSelf(int flags) {
        mImm.showSoftInputFromInputMethod(mToken, flags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.718 -0500", hash_original_method = "2F1E84CCA4C2BB5EFB606DA289F60F64", hash_generated_method = "532F138375D374C3C4D6D5EBF190BEBE")
    
private boolean handleBack(boolean doIt) {
        if (mShowInputRequested) {
            if (isExtractViewShown() && mExtractView instanceof ExtractEditLayout) {
                ExtractEditLayout extractEditLayout = (ExtractEditLayout) mExtractView;
                if (extractEditLayout.isActionModeStarted()) {
                    if (doIt) extractEditLayout.finishActionMode();
                    return true;
                }
            }
            // If the soft input area is shown, back closes it and we
            // consume the back key.
            if (doIt) requestHideSelf(0);
            return true;
        } else if (mWindowVisible) {
            if (mCandidatesVisibility == View.VISIBLE) {
                // If we are showing candidates even if no input area, then
                // hide them.
                if (doIt) setCandidatesViewShown(false);
            } else {
                // If we have the window visible for some other reason --
                // most likely to show candidates -- then just get rid
                // of it.  This really shouldn't happen, but just in case...
                if (doIt) hideWindow();
            }
            return true;
        }
        return false;
    }
    
    /**
     * Override this to intercept key down events before they are processed by the
     * application.  If you return true, the application will not itself
     * process the event.  If you return true, the normal application processing
     * will occur as if the IME had not seen the event at all.
     * 
     * <p>The default implementation intercepts {@link KeyEvent#KEYCODE_BACK
     * KeyEvent.KEYCODE_BACK} if the IME is currently shown, to
     * possibly hide it when the key goes up (if not canceled or long pressed).  In
     * addition, in fullscreen mode only, it will consume DPAD movement
     * events to move the cursor in the extracted text view, not allowing
     * them to perform navigation in the underlying application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.720 -0500", hash_original_method = "6D39318911C6DEDF33A28EA4D06A473F", hash_generated_method = "F127E7A97D763288753648CD374A349C")
    
public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (handleBack(false)) {
                event.startTracking();
                return true;
            }
            return false;
        }
        return doMovementKey(keyCode, event, MOVEMENT_DOWN);
    }

    /**
     * Default implementation of {@link KeyEvent.Callback#onKeyLongPress(int, KeyEvent)
     * KeyEvent.Callback.onKeyLongPress()}: always returns false (doesn't handle
     * the event).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.722 -0500", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "DCA1BD8CD57F309EE5CB42ADAEA0EA5E")
    
public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }

    /**
     * Override this to intercept special key multiple events before they are
     * processed by the
     * application.  If you return true, the application will not itself
     * process the event.  If you return true, the normal application processing
     * will occur as if the IME had not seen the event at all.
     * 
     * <p>The default implementation always returns false, except when
     * in fullscreen mode, where it will consume DPAD movement
     * events to move the cursor in the extracted text view, not allowing
     * them to perform navigation in the underlying application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.725 -0500", hash_original_method = "3CC4F52C9B71FCD2A0600FA46D6F06E5", hash_generated_method = "53B4454AF8CB4A812EC8CCE34A77FAE8")
    
public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
        return doMovementKey(keyCode, event, count);
    }

    /**
     * Override this to intercept key up events before they are processed by the
     * application.  If you return true, the application will not itself
     * process the event.  If you return true, the normal application processing
     * will occur as if the IME had not seen the event at all.
     * 
     * <p>The default implementation intercepts {@link KeyEvent#KEYCODE_BACK
     * KeyEvent.KEYCODE_BACK} to hide the current IME UI if it is shown.  In
     * addition, in fullscreen mode only, it will consume DPAD movement
     * events to move the cursor in the extracted text view, not allowing
     * them to perform navigation in the underlying application.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.728 -0500", hash_original_method = "BCD4505881DB97C910099D82B7A22807", hash_generated_method = "79FA93C01FDA614142FC510FDD99743C")
    
public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.isTracking()
                && !event.isCanceled()) {
            return handleBack(true);
        }
        
        return doMovementKey(keyCode, event, MOVEMENT_UP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.730 -0500", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "56A89B65D9F6FA0CA61A35612CFE0F8A")
    
@Override
    public boolean onTrackballEvent(MotionEvent event) {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.732 -0500", hash_original_method = "E2F219F9B605C6393794145B9C28D4D7", hash_generated_method = "F5A2E702956CDAF2C81B573F7AC65F06")
    
public void onAppPrivateCommand(String action, Bundle data) {
    }
    
    /**
     * Handle a request by the system to toggle the soft input area.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.734 -0500", hash_original_method = "F1BA2156F30663683BD63E2F68C8FA5C", hash_generated_method = "6B77577832037F933F5D23CF8D683943")
    
private void onToggleSoftInput(int showFlags, int hideFlags) {
        if (DEBUG) Log.v(TAG, "toggleSoftInput()");
        if (isInputViewShown()) {
            requestHideSelf(hideFlags);
        } else {
            requestShowSelf(showFlags);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.742 -0500", hash_original_method = "9C1F09BC7693D3503A84F47A8DD2E9B8", hash_generated_method = "9C1F09BC7693D3503A84F47A8DD2E9B8")
    
void reportExtractedMovement(int keyCode, int count) {
        int dx = 0, dy = 0;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                dx = -count;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                dx = count;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                dy = -count;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                dy = count;
                break;
        }
        onExtractedCursorMovement(dx, dy);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.745 -0500", hash_original_method = "CADA6E3534C513A6E5A0D2EB184E3B48", hash_generated_method = "EE57C150FBB5A198FA5A38641FDD67FB")
    
boolean doMovementKey(int keyCode, KeyEvent event, int count) {
        final ExtractEditText eet = mExtractEditText;
        if (isExtractViewShown() && isInputViewShown() && eet != null) {
            // If we are in fullscreen mode, the cursor will move around
            // the extract edit text, but should NOT cause focus to move
            // to other fields.
            MovementMethod movement = eet.getMovementMethod();
            Layout layout = eet.getLayout();
            if (movement != null && layout != null) {
                // We want our own movement method to handle the key, so the
                // cursor will properly move in our own word wrapping.
                if (count == MOVEMENT_DOWN) {
                    if (movement.onKeyDown(eet,
                            (Spannable)eet.getText(), keyCode, event)) {
                        reportExtractedMovement(keyCode, 1);
                        return true;
                    }
                } else if (count == MOVEMENT_UP) {
                    if (movement.onKeyUp(eet,
                            (Spannable)eet.getText(), keyCode, event)) {
                        return true;
                    }
                } else {
                    if (movement.onKeyOther(eet, (Spannable)eet.getText(), event)) {
                        reportExtractedMovement(keyCode, count);
                    } else {
                        KeyEvent down = KeyEvent.changeAction(event, KeyEvent.ACTION_DOWN);
                        if (movement.onKeyDown(eet,
                                (Spannable)eet.getText(), keyCode, down)) {
                            KeyEvent up = KeyEvent.changeAction(event, KeyEvent.ACTION_UP);
                            movement.onKeyUp(eet,
                                    (Spannable)eet.getText(), keyCode, up);
                            while (--count > 0) {
                                movement.onKeyDown(eet,
                                        (Spannable)eet.getText(), keyCode, down);
                                movement.onKeyUp(eet,
                                        (Spannable)eet.getText(), keyCode, up);
                            }
                            reportExtractedMovement(keyCode, count);
                        }
                    }
                }
            }
            // Regardless of whether the movement method handled the key,
            // we never allow DPAD navigation to the application.
            switch (keyCode) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                case KeyEvent.KEYCODE_DPAD_UP:
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Send the given key event code (as defined by {@link KeyEvent}) to the
     * current input connection is a key down + key up event pair.  The sent
     * events have {@link KeyEvent#FLAG_SOFT_KEYBOARD KeyEvent.FLAG_SOFT_KEYBOARD}
     * set, so that the recipient can identify them as coming from a software
     * input method, and
     * {@link KeyEvent#FLAG_KEEP_TOUCH_MODE KeyEvent.FLAG_KEEP_TOUCH_MODE}, so
     * that they don't impact the current touch mode of the UI.
     *
     * @param keyEventCode The raw key code to send, as defined by
     * {@link KeyEvent}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.748 -0500", hash_original_method = "79E896FD8459E186D0AA684976DF9590", hash_generated_method = "F7A3255D314ED060A32B9670A74A2B7B")
    
public void sendDownUpKeyEvents(int keyEventCode) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;
        long eventTime = SystemClock.uptimeMillis();
        ic.sendKeyEvent(new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
        ic.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime,
                KeyEvent.ACTION_UP, keyEventCode, 0, 0, KeyCharacterMap.VIRTUAL_KEYBOARD, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD|KeyEvent.FLAG_KEEP_TOUCH_MODE));
    }
    
    /**
     * Ask the input target to execute its default action via
     * {@link InputConnection#performEditorAction
     * InputConnection.performEditorAction()}.
     * 
     * @param fromEnterKey If true, this will be executed as if the user had
     * pressed an enter key on the keyboard, that is it will <em>not</em>
     * be done if the editor has set {@link EditorInfo#IME_FLAG_NO_ENTER_ACTION
     * EditorInfo.IME_FLAG_NO_ENTER_ACTION}.  If false, the action will be
     * sent regardless of how the editor has set that flag.
     * 
     * @return Returns a boolean indicating whether an action has been sent.
     * If false, either the editor did not specify a default action or it
     * does not want an action from the enter key.  If true, the action was
     * sent (or there was no input connection at all).
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.751 -0500", hash_original_method = "84DA6B1414DFECBCA6744FD6285B6A00", hash_generated_method = "5C9FEB501E23E15FCAEE85E25C8A3C18")
    
public boolean sendDefaultEditorAction(boolean fromEnterKey) {
        EditorInfo ei = getCurrentInputEditorInfo();
        if (ei != null &&
                (!fromEnterKey || (ei.imeOptions &
                        EditorInfo.IME_FLAG_NO_ENTER_ACTION) == 0) &&
                (ei.imeOptions & EditorInfo.IME_MASK_ACTION) !=
                    EditorInfo.IME_ACTION_NONE) {
            // If the enter key was pressed, and the editor has a default
            // action associated with pressing enter, then send it that
            // explicit action instead of the key event.
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.performEditorAction(ei.imeOptions&EditorInfo.IME_MASK_ACTION);
            }
            return true;
        }
        
        return false;
    }
    
    /**
     * Send the given UTF-16 character to the current input connection.  Most
     * characters will be delivered simply by calling
     * {@link InputConnection#commitText InputConnection.commitText()} with
     * the character; some, however, may be handled different.  In particular,
     * the enter character ('\n') will either be delivered as an action code
     * or a raw key event, as appropriate.
     * 
     * @param charCode The UTF-16 character code to send.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.754 -0500", hash_original_method = "CB96ACC643B76CE6B3516B92D9424351", hash_generated_method = "13B473258FD22DF6BB73073EF1198CD8")
    
public void sendKeyChar(char charCode) {
        switch (charCode) {
            case '\n': // Apps may be listening to an enter key to perform an action
                if (!sendDefaultEditorAction(true)) {
                    sendDownUpKeyEvents(KeyEvent.KEYCODE_ENTER);
                }
                break;
            default:
                // Make sure that digits go through any text watcher on the client side.
                if (charCode >= '0' && charCode <= '9') {
                    sendDownUpKeyEvents(charCode - '0' + KeyEvent.KEYCODE_0);
                } else {
                    InputConnection ic = getCurrentInputConnection();
                    if (ic != null) {
                        ic.commitText(String.valueOf((char) charCode), 1);
                    }
                }
                break;
        }
    }
    
    /**
     * This is called when the user has moved the cursor in the extracted
     * text view, when running in fullsreen mode.  The default implementation
     * performs the corresponding selection change on the underlying text
     * editor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.756 -0500", hash_original_method = "B848FD2302E48E43854FF3AB55ABE7CC", hash_generated_method = "767EE73F62A6B91421B36894A69F7389")
    
public void onExtractedSelectionChanged(int start, int end) {
        InputConnection conn = getCurrentInputConnection();
        if (conn != null) {
            conn.setSelection(start, end);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.759 -0500", hash_original_method = "56B9FB82082DF66D8709DA9479270344", hash_generated_method = "FFDD1D2F6C88C3AD3CD24EEA1F0480D5")
    
public void onExtractedDeleteText(int start, int end) {
        InputConnection conn = getCurrentInputConnection();
        if (conn != null) {
            conn.setSelection(start, start);
            conn.deleteSurroundingText(0, end-start);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.761 -0500", hash_original_method = "3752CFC0704EAA41A71F5FCC4C7F691D", hash_generated_method = "D8C72259ED01F82B801AA2D326DC1B16")
    
public void onExtractedReplaceText(int start, int end, CharSequence text) {
        InputConnection conn = getCurrentInputConnection();
        if (conn != null) {
            conn.setComposingRegion(start, end);
            conn.commitText(text, 1);
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.763 -0500", hash_original_method = "2386EADCDB176594EC064F3F20DE5D60", hash_generated_method = "F56E7C8ED610DCD80F994B3B58F61174")
    
public void onExtractedSetSpan(Object span, int start, int end, int flags) {
        InputConnection conn = getCurrentInputConnection();
        if (conn != null) {
            if (!conn.setSelection(start, end)) return;
            CharSequence text = conn.getSelectedText(InputConnection.GET_TEXT_WITH_STYLES);
            if (text instanceof Spannable) {
                ((Spannable) text).setSpan(span, 0, text.length(), flags);
                conn.setComposingRegion(start, end);
                conn.commitText(text, 1);
            }
        }
    }

    /**
     * This is called when the user has clicked on the extracted text view,
     * when running in fullscreen mode.  The default implementation hides
     * the candidates view when this happens, but only if the extracted text
     * editor has a vertical scroll bar because its text doesn't fit.
     * Re-implement this to provide whatever behavior you want.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.765 -0500", hash_original_method = "672EAF0A2CC265CDC19E0FE05714B327", hash_generated_method = "D171E0F07B5A0FE265727DFBBB97CC0A")
    
public void onExtractedTextClicked() {
        if (mExtractEditText == null) {
            return;
        }
        if (mExtractEditText.hasVerticalScrollBar()) {
            setCandidatesViewShown(false);
        }
    }
    
    public class InputMethodImpl extends AbstractInputMethodImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.585 -0400", hash_original_method = "F0421074EFC32AA5D8F43C6593C3D141", hash_generated_method = "F0421074EFC32AA5D8F43C6593C3D141")
        public InputMethodImpl ()
        {
            //Synthesized constructor
        }
        /**
         * Take care of attaching the given window token provided by the system.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.489 -0500", hash_original_method = "2246D0F0FC59D2518EAEE0F0671903AA", hash_generated_method = "08D5DBC9D55455EFFBD614E3A1EE290B")
        
public void attachToken(IBinder token) {
            if (mToken == null) {
                mToken = token;
                mWindow.setToken(token);
            }
        }
        
        /**
         * Handle a new input binding, calling
         * {@link InputMethodService#onBindInput InputMethodService.onBindInput()}
         * when done.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.492 -0500", hash_original_method = "96E89AA7F2E1A70ABC64DBDE36024534", hash_generated_method = "F9C58F54DC4C22C8995B6606861D42A5")
        
public void bindInput(InputBinding binding) {
            mInputBinding = binding;
            mInputConnection = binding.getConnection();
            if (DEBUG) Log.v(TAG, "bindInput(): binding=" + binding
                    + " ic=" + mInputConnection);
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) ic.reportFullscreenMode(mIsFullscreen);
            initialize();
            onBindInput();
        }

        /**
         * Clear the current input binding.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.494 -0500", hash_original_method = "5DFC78D3BA0A9E107E4BC0A877A8E6D3", hash_generated_method = "5D91647A8B04D60ECC6945E33ED3C269")
        
public void unbindInput() {
            if (DEBUG) Log.v(TAG, "unbindInput(): binding=" + mInputBinding
                    + " ic=" + mInputConnection);
            onUnbindInput();
            mInputStarted = false;
            mInputBinding = null;
            mInputConnection = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.496 -0500", hash_original_method = "ABB2165AD965E17C2FE21B1141C40C8F", hash_generated_method = "5F91421E6B10BF2DC642DD333F5EAA9B")
        
public void startInput(InputConnection ic, EditorInfo attribute) {
            if (DEBUG) Log.v(TAG, "startInput(): editor=" + attribute);
            doStartInput(ic, attribute, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.499 -0500", hash_original_method = "FBDDF384E0FE523BAEFE6359495BE0E1", hash_generated_method = "C639317931AB5D9D70A01AF7391D0BC1")
        
public void restartInput(InputConnection ic, EditorInfo attribute) {
            if (DEBUG) Log.v(TAG, "restartInput(): editor=" + attribute);
            doStartInput(ic, attribute, true);
        }

        /**
         * Handle a request by the system to hide the soft input area.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.502 -0500", hash_original_method = "3A4CCDB7EB28BA706C897E348F128E61", hash_generated_method = "8EBD056BBA0A688E469E7B3AA17A798D")
        
public void hideSoftInput(int flags, ResultReceiver resultReceiver) {
            if (DEBUG) Log.v(TAG, "hideSoftInput()");
            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
            mShowInputRequested = false;
            mShowInputForced = false;
            hideWindow();
            if (resultReceiver != null) {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_HIDDEN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            }
        }

        /**
         * Handle a request by the system to show the soft input area.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.505 -0500", hash_original_method = "FA726B6A215F3C1D91F0883D01FD2750", hash_generated_method = "764E7D0341458DB5856E045D356CF4BF")
        
public void showSoftInput(int flags, ResultReceiver resultReceiver) {
            if (DEBUG) Log.v(TAG, "showSoftInput()");
            boolean wasVis = isInputViewShown();
            mShowInputFlags = 0;
            if (onShowInputRequested(flags, false)) {
                showWindow(true);
            }
            // If user uses hard keyboard, IME button should always be shown.
            boolean showing = onEvaluateInputViewShown();
            mImm.setImeWindowStatus(mToken, IME_ACTIVE | (showing ? IME_VISIBLE : 0),
                    mBackDisposition);
            if (resultReceiver != null) {
                resultReceiver.send(wasVis != isInputViewShown()
                        ? InputMethodManager.RESULT_SHOWN
                        : (wasVis ? InputMethodManager.RESULT_UNCHANGED_SHOWN
                                : InputMethodManager.RESULT_UNCHANGED_HIDDEN), null);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.508 -0500", hash_original_method = "A5FC41682DA51C285C2C6651867F8D99", hash_generated_method = "B02E801B8BFC007EC6A831AC44A26D9C")
        
public void changeInputMethodSubtype(InputMethodSubtype subtype) {
            onCurrentInputMethodSubtypeChanged(subtype);
        }
        
    }
    
    public class InputMethodSessionImpl extends AbstractInputMethodSessionImpl {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.658 -0400", hash_original_method = "0FFA9D5BB925C1ECDC26428126FD587D", hash_generated_method = "0FFA9D5BB925C1ECDC26428126FD587D")
        public InputMethodSessionImpl ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.515 -0500", hash_original_method = "3439BC8F3B3DD615353E38FBC0555505", hash_generated_method = "38C4714CEF670A874F149A6EC262FAF6")
        
public void finishInput() {
            if (!isEnabled()) {
                return;
            }
            if (DEBUG) Log.v(TAG, "finishInput() in " + this);
            doFinishInput();
        }

        /**
         * Call {@link InputMethodService#onDisplayCompletions
         * InputMethodService.onDisplayCompletions()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.518 -0500", hash_original_method = "6A0353E151F9F29333A27C5421A53B38", hash_generated_method = "1F72F601EA3B1AB8699E6971CD929E7B")
        
public void displayCompletions(CompletionInfo[] completions) {
            if (!isEnabled()) {
                return;
            }
            mCurCompletions = completions;
            onDisplayCompletions(completions);
        }
        
        /**
         * Call {@link InputMethodService#onUpdateExtractedText
         * InputMethodService.onUpdateExtractedText()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.520 -0500", hash_original_method = "0102DD0EEEDCD27552C577307A27FE88", hash_generated_method = "7ABB7F4B4DE290873C2708D443E15A29")
        
public void updateExtractedText(int token, ExtractedText text) {
            if (!isEnabled()) {
                return;
            }
            onUpdateExtractedText(token, text);
        }
        
        /**
         * Call {@link InputMethodService#onUpdateSelection
         * InputMethodService.onUpdateSelection()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.523 -0500", hash_original_method = "8EA462F0F0CF12CBAE81AB6E28205A3D", hash_generated_method = "96D54095F35B207C6116CF5CDF141A5D")
        
public void updateSelection(int oldSelStart, int oldSelEnd,
                int newSelStart, int newSelEnd,
                int candidatesStart, int candidatesEnd) {
            if (!isEnabled()) {
                return;
            }
            InputMethodService.this.onUpdateSelection(oldSelStart, oldSelEnd,
                    newSelStart, newSelEnd, candidatesStart, candidatesEnd);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.525 -0500", hash_original_method = "7D0F3CDF004B0AA88B105A90C3B2EFF2", hash_generated_method = "10D0A909714CF4E81FAE797595666839")
        
@Override
        public void viewClicked(boolean focusChanged) {
            if (!isEnabled()) {
                return;
            }
            InputMethodService.this.onViewClicked(focusChanged);
        }

        /**
         * Call {@link InputMethodService#onUpdateCursor
         * InputMethodService.onUpdateCursor()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.529 -0500", hash_original_method = "5A756230FCCA173B557966360DF4EF77", hash_generated_method = "A531AC4D2D958013345C405E0332C83B")
        
public void updateCursor(Rect newCursor) {
            if (!isEnabled()) {
                return;
            }
            InputMethodService.this.onUpdateCursor(newCursor);
        }
        
        /**
         * Call {@link InputMethodService#onAppPrivateCommand
         * InputMethodService.onAppPrivateCommand()}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.532 -0500", hash_original_method = "681E840BDEA7B80F2F006F7D9B6B3563", hash_generated_method = "686B3486006AA2164D3BB2BD0348441F")
        
public void appPrivateCommand(String action, Bundle data) {
            if (!isEnabled()) {
                return;
            }
            InputMethodService.this.onAppPrivateCommand(action, data);
        }
        
        /**
         * 
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.534 -0500", hash_original_method = "F1C4F6A09FBC1E433445388BE149C06F", hash_generated_method = "26CA62075DF7CEE5ECACDC0ED1BC5765")
        
public void toggleSoftInput(int showFlags, int hideFlags) {
            InputMethodService.this.onToggleSoftInput(showFlags, hideFlags);
        }
        
    }
    
    public static final class Insets {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.547 -0500", hash_original_field = "D02500261CD6088744A8F89F1DC92774", hash_generated_field = "A903B8D9E85FE8268399FAA8EA9A5E31")

        public static final int TOUCHABLE_INSETS_FRAME
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_FRAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.550 -0500", hash_original_field = "E1CB5B3F9E2724F9116E828DF72060F3", hash_generated_field = "16D23B51E9664EA10F8919E161911777")

        public static final int TOUCHABLE_INSETS_CONTENT
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_CONTENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.552 -0500", hash_original_field = "8F8549F1D61B82B6884FF111314CD38E", hash_generated_field = "CFCF2141909DD954AF9ECFE0CCA49151")

        public static final int TOUCHABLE_INSETS_VISIBLE
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_VISIBLE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.555 -0500", hash_original_field = "86B335457F677482591633B0B938D331", hash_generated_field = "2D48D24763A14D18AF2E1A2EBFB364B0")

        public static final int TOUCHABLE_INSETS_REGION
                = ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.539 -0500", hash_original_field = "6C149DE39904D714F8BA4183DBF117CA", hash_generated_field = "0848E8A3B2603B51400EBA2544607CD8")

        public int contentTopInsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.542 -0500", hash_original_field = "3E8F29680BCA0697F15EF9FD118C89AB", hash_generated_field = "4E5B62BB5E3FD9065410077ABCEFD6F5")

        public int visibleTopInsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.544 -0500", hash_original_field = "0DC76966B2C3F66EA9CE70AE083247B7", hash_generated_field = "F49DB2DF83C2B114A730FA19005C8733")

        public final Region touchableRegion = new Region();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.557 -0500", hash_original_field = "5D04161B1B6B9AF4EA61E54C6A2E7C05", hash_generated_field = "70DA720827DA3605384693EAE5E21AF8")

        public int touchableInsets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:14.685 -0400", hash_original_method = "AB0F14C8125953D4D984387CD9B8D05E", hash_generated_method = "AB0F14C8125953D4D984387CD9B8D05E")
        public Insets ()
        {
            //Synthesized constructor
        }
    }

    /**
     * This is called when the user has performed a cursor movement in the
     * extracted text view, when it is running in fullscreen mode.  The default
     * implementation hides the candidates view when a vertical movement
     * happens, but only if the extracted text editor has a vertical scroll bar
     * because its text doesn't fit.
     * Re-implement this to provide whatever behavior you want.
     * @param dx The amount of cursor movement in the x dimension.
     * @param dy The amount of cursor movement in the y dimension.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.768 -0500", hash_original_method = "33B88CC3E792B5DBD4A2FEF9CD5D26B5", hash_generated_method = "9853EB0FE18E05CFC35A502566321118")
    
public void onExtractedCursorMovement(int dx, int dy) {
        if (mExtractEditText == null || dy == 0) {
            return;
        }
        if (mExtractEditText.hasVerticalScrollBar()) {
            setCandidatesViewShown(false);
        }
    }
    
    /**
     * This is called when the user has selected a context menu item from the
     * extracted text view, when running in fullscreen mode.  The default
     * implementation sends this action to the current InputConnection's
     * {@link InputConnection#performContextMenuAction(int)}, for it
     * to be processed in underlying "real" editor.  Re-implement this to
     * provide whatever behavior you want.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.770 -0500", hash_original_method = "FA4A3D7B1537F03835F5D4F28B4BC905", hash_generated_method = "3FC295F2B8792DFF6375DB94ED7036A1")
    
public boolean onExtractTextContextMenuItem(int id) {
        InputConnection ic = getCurrentInputConnection();
        if (ic != null) {
            ic.performContextMenuAction(id);
        }
        return true;
    }
    
    /**
     * Return text that can be used as a button label for the given
     * {@link EditorInfo#imeOptions EditorInfo.imeOptions}.  Returns null
     * if there is no action requested.  Note that there is no guarantee that
     * the returned text will be relatively short, so you probably do not
     * want to use it as text on a soft keyboard key label.
     * 
     * @param imeOptions The value from @link EditorInfo#imeOptions EditorInfo.imeOptions}.
     * 
     * @return Returns a label to use, or null if there is no action.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.773 -0500", hash_original_method = "9F91BE1CB3CE4671D110A2B57AE2570E", hash_generated_method = "2097EE534C4A509424A681A2B60AC2B1")
    
public CharSequence getTextForImeAction(int imeOptions) {
        switch (imeOptions&EditorInfo.IME_MASK_ACTION) {
            case EditorInfo.IME_ACTION_NONE:
                return null;
            case EditorInfo.IME_ACTION_GO:
                return getText(com.android.internal.R.string.ime_action_go);
            case EditorInfo.IME_ACTION_SEARCH:
                return getText(com.android.internal.R.string.ime_action_search);
            case EditorInfo.IME_ACTION_SEND:
                return getText(com.android.internal.R.string.ime_action_send);
            case EditorInfo.IME_ACTION_NEXT:
                return getText(com.android.internal.R.string.ime_action_next);
            case EditorInfo.IME_ACTION_DONE:
                return getText(com.android.internal.R.string.ime_action_done);
            case EditorInfo.IME_ACTION_PREVIOUS:
                return getText(com.android.internal.R.string.ime_action_previous);
            default:
                return getText(com.android.internal.R.string.ime_action_default);
        }
    }
    
    /**
     * Called when the fullscreen-mode extracting editor info has changed,
     * to determine whether the extracting (extract text and candidates) portion
     * of the UI should be shown.  The standard implementation hides or shows
     * the extract area depending on whether it makes sense for the
     * current editor.  In particular, a {@link InputType#TYPE_NULL}
     * input type or {@link EditorInfo#IME_FLAG_NO_EXTRACT_UI} flag will
     * turn off the extract area since there is no text to be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.776 -0500", hash_original_method = "8796655A783A46466BACE236BCA7DD97", hash_generated_method = "6332A21A5E186176E445234CB6F4490D")
    
public void onUpdateExtractingVisibility(EditorInfo ei) {
        if (ei.inputType == InputType.TYPE_NULL ||
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_EXTRACT_UI) != 0) {
            // No reason to show extract UI!
            setExtractViewShown(false);
            return;
        }
        
        setExtractViewShown(true);
    }
    
    /**
     * Called when the fullscreen-mode extracting editor info has changed,
     * to update the state of its UI such as the action buttons shown.
     * You do not need to deal with this if you are using the standard
     * full screen extract UI.  If replacing it, you will need to re-implement
     * this to put the appropriate action button in your own UI and handle it,
     * and perform any other changes.
     * 
     * <p>The standard implementation turns on or off its accessory area
     * depending on whether there is an action button, and hides or shows
     * the entire extract area depending on whether it makes sense for the
     * current editor.  In particular, a {@link InputType#TYPE_NULL} or 
     * {@link InputType#TYPE_TEXT_VARIATION_FILTER} input type will turn off the
     * extract area since there is no text to be shown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.778 -0500", hash_original_method = "EAD47E132E9ECD3692FAA5C1AB9CEE12", hash_generated_method = "74B77FCD3D8CFD9F8AD3D9CFBDDA46DB")
    
public void onUpdateExtractingViews(EditorInfo ei) {
        if (!isExtractViewShown()) {
            return;
        }
        
        if (mExtractAccessories == null) {
            return;
        }
        final boolean hasAction = ei.actionLabel != null || (
                (ei.imeOptions&EditorInfo.IME_MASK_ACTION) != EditorInfo.IME_ACTION_NONE &&
                (ei.imeOptions&EditorInfo.IME_FLAG_NO_ACCESSORY_ACTION) == 0 &&
                ei.inputType != InputType.TYPE_NULL);
        if (hasAction) {
            mExtractAccessories.setVisibility(View.VISIBLE);
            if (mExtractAction != null) {
                if (ei.actionLabel != null) {
                    mExtractAction.setText(ei.actionLabel);
                } else {
                    mExtractAction.setText(getTextForImeAction(ei.imeOptions));
                }
                mExtractAction.setOnClickListener(mActionClickListener);
            }
        } else {
            mExtractAccessories.setVisibility(View.GONE);
            if (mExtractAction != null) {
                mExtractAction.setOnClickListener(null);
            }
        }
    }
    
    /**
     * This is called when, while currently displayed in extract mode, the
     * current input target changes.  The default implementation will
     * auto-hide the IME if the new target is not a full editor, since this
     * can be an confusing experience for the user.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.781 -0500", hash_original_method = "B8550D5274B7AC063AD577912E9B5BF9", hash_generated_method = "6F42DACEDF3CE7220F439BE31B1E1843")
    
public void onExtractingInputChanged(EditorInfo ei) {
        if (ei.inputType == InputType.TYPE_NULL) {
            requestHideSelf(InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.784 -0500", hash_original_method = "4C67EC88DE5F38ABAC11BF6FC64666D8", hash_generated_method = "4C67EC88DE5F38ABAC11BF6FC64666D8")
    
void startExtractingText(boolean inputChanged) {
        final ExtractEditText eet = mExtractEditText;
        if (eet != null && getCurrentInputStarted()
                && isFullscreenMode()) {
            mExtractedToken++;
            ExtractedTextRequest req = new ExtractedTextRequest();
            req.token = mExtractedToken;
            req.flags = InputConnection.GET_TEXT_WITH_STYLES;
            req.hintMaxLines = 10;
            req.hintMaxChars = 10000;
            InputConnection ic = getCurrentInputConnection();
            mExtractedText = ic == null? null
                    : ic.getExtractedText(req, InputConnection.GET_EXTRACTED_TEXT_MONITOR);
            if (mExtractedText == null || ic == null) {
                Log.e(TAG, "Unexpected null in startExtractingText : mExtractedText = "
                        + mExtractedText + ", input connection = " + ic);
            }
            final EditorInfo ei = getCurrentInputEditorInfo();
            
            try {
                eet.startInternalChanges();
                onUpdateExtractingVisibility(ei);
                onUpdateExtractingViews(ei);
                int inputType = ei.inputType;
                if ((inputType&EditorInfo.TYPE_MASK_CLASS)
                        == EditorInfo.TYPE_CLASS_TEXT) {
                    if ((inputType&EditorInfo.TYPE_TEXT_FLAG_IME_MULTI_LINE) != 0) {
                        inputType |= EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE;
                    }
                }
                eet.setInputType(inputType);
                eet.setHint(ei.hintText);
                if (mExtractedText != null) {
                    eet.setEnabled(true);
                    eet.setExtractedText(mExtractedText);
                } else {
                    eet.setEnabled(false);
                    eet.setText("");
                }
            } finally {
                eet.finishInternalChanges();
            }
            
            if (inputChanged) {
                onExtractingInputChanged(ei);
            }
        }
    }

    // TODO: Handle the subtype change event
    /**
     * Called when the subtype was changed.
     * @param newSubtype the subtype which is being changed to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.786 -0500", hash_original_method = "18DCEDE4996E63CB2DB494AAC7CE4961", hash_generated_method = "1345081787D8CCFCF6D4FD4A931F0085")
    
protected void onCurrentInputMethodSubtypeChanged(InputMethodSubtype newSubtype) {
        if (DEBUG) {
            int nameResId = newSubtype.getNameResId();
            String mode = newSubtype.getMode();
            String output = "changeInputMethodSubtype:"
                + (nameResId == 0 ? "<none>" : getString(nameResId)) + ","
                + mode + ","
                + newSubtype.getLocale() + "," + newSubtype.getExtraValue();
            Log.v(TAG, "--- " + output);
        }
    }

    /**
     * Performs a dump of the InputMethodService's internal state.  Override
     * to add your own information to the dump.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:39.790 -0500", hash_original_method = "ABDAB14391C840F473C7CB9BB20D3C33", hash_generated_method = "52519F24079292405CF21B07A95F0496")
    
@Override protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        final Printer p = new PrintWriterPrinter(fout);
        p.println("Input method service state for " + this + ":");
        p.println("  mWindowCreated=" + mWindowCreated
                + " mWindowAdded=" + mWindowAdded);
        p.println("  mWindowVisible=" + mWindowVisible
                + " mWindowWasVisible=" + mWindowWasVisible
                + " mInShowWindow=" + mInShowWindow);
        p.println("  Configuration=" + getResources().getConfiguration());
        p.println("  mToken=" + mToken);
        p.println("  mInputBinding=" + mInputBinding);
        p.println("  mInputConnection=" + mInputConnection);
        p.println("  mStartedInputConnection=" + mStartedInputConnection);
        p.println("  mInputStarted=" + mInputStarted
                + " mInputViewStarted=" + mInputViewStarted
                + " mCandidatesViewStarted=" + mCandidatesViewStarted);
        
        if (mInputEditorInfo != null) {
            p.println("  mInputEditorInfo:");
            mInputEditorInfo.dump(p, "    ");
        } else {
            p.println("  mInputEditorInfo: null");
        }
        
        p.println("  mShowInputRequested=" + mShowInputRequested
                + " mLastShowInputRequested=" + mLastShowInputRequested
                + " mShowInputForced=" + mShowInputForced
                + " mShowInputFlags=0x" + Integer.toHexString(mShowInputFlags));
        p.println("  mCandidatesVisibility=" + mCandidatesVisibility
                + " mFullscreenApplied=" + mFullscreenApplied
                + " mIsFullscreen=" + mIsFullscreen
                + " mExtractViewHidden=" + mExtractViewHidden);
        
        if (mExtractedText != null) {
            p.println("  mExtractedText:");
            p.println("    text=" + mExtractedText.text.length() + " chars"
                    + " startOffset=" + mExtractedText.startOffset);
            p.println("    selectionStart=" + mExtractedText.selectionStart
                    + " selectionEnd=" + mExtractedText.selectionEnd
                    + " flags=0x" + Integer.toHexString(mExtractedText.flags));
        } else {
            p.println("  mExtractedText: null");
        }
        p.println("  mExtractedToken=" + mExtractedToken);
        p.println("  mIsInputViewShown=" + mIsInputViewShown
                + " mStatusIcon=" + mStatusIcon);
        p.println("Last computed insets:");
        p.println("  contentTopInsets=" + mTmpInsets.contentTopInsets
                + " visibleTopInsets=" + mTmpInsets.visibleTopInsets
                + " touchableInsets=" + mTmpInsets.touchableInsets
                + " touchableRegion=" + mTmpInsets.touchableRegion);
    }

    @Override
    
    public void droidsafeOnSubServiceHook() {
        super.droidsafeOnSubServiceHook();
        onBindInput();
        onComputeInsets(new Insets());
        onCreateCandidatesView();
        onCreateExtractTextView();
        onCreateInputView();
        onAppPrivateCommand(new String(),  new Bundle());
        onCreateInputMethodInterface();
        onCreateInputMethodSessionInterface();
        onDisplayCompletions(mCurCompletions);
        onEvaluateFullscreenMode();
        onEvaluateInputViewShown();
        onExtractedCursorMovement(getTaintInt(),  getTaintInt());
        onExtractedDeleteText(getTaintInt(),  getTaintInt());
        onExtractedTextClicked();
        onExtractingInputChanged(new EditorInfo());
        onFinishInput();
        onFinishInputView(getTaintBoolean());
        onInitializeInterface();
        onKeyDown(getTaintInt(), new KeyEvent(getTaintInt(), getTaintInt()));
        onKeyUp(getTaintInt(), new KeyEvent(getTaintInt(), getTaintInt()));
        onKeyLongPress(getTaintInt(), new KeyEvent(getTaintInt(), getTaintInt()));
        onKeyDown(getTaintInt(), new KeyEvent(getTaintInt(), getTaintInt()));
        onKeyMultiple(getTaintInt(), getTaintInt(), new KeyEvent(getTaintInt(), getTaintInt()));
        onShowInputRequested(getTaintInt(),  getTaintBoolean());
        onStartCandidatesView(new EditorInfo(), getTaintBoolean());
        onStartInput(new EditorInfo(), getTaintBoolean());
        onStartInputView(new EditorInfo(), getTaintBoolean());
        onTrackballEvent(MotionEvent.droidsafeObtainEvent());
        onUpdateCursor(new Rect());
        onUpdateExtractedText(getTaintInt(), new ExtractedText());
        onUpdateExtractingViews(new EditorInfo());
        onUpdateExtractingVisibility(new EditorInfo());
        
        onCurrentInputMethodSubtypeChanged(InputMethodSubtype.droidsafeObtainInputMethodSubtype());

        onUpdateSelection(getTaintInt(),  getTaintInt(),  getTaintInt(), getTaintInt(),  
                         getTaintInt(), getTaintInt());
        onViewClicked(getTaintBoolean());
        onWindowHidden();
        onWindowShown();
        
        onUnbindInput();
    }
}

