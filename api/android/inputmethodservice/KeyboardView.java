package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import com.android.internal.R;
import java.util.Map;
import android.inputmethodservice.Keyboard.Key;
import android.view.ViewConfiguration;
import android.media.AudioManager;
import android.graphics.Paint;
import android.os.Message;
import android.widget.PopupWindow;
import android.view.View;
import android.graphics.PorterDuff;
import java.util.HashMap;
import android.view.accessibility.AccessibilityManager;
import android.view.Gravity;
import android.graphics.Bitmap;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.GestureDetector;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.graphics.Region.Op;
import android.view.ViewGroup.LayoutParams;
import android.graphics.Paint.Align;
import java.util.List;
import android.provider.Settings;
import android.util.TypedValue;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.TextView;
import android.content.Context;
import android.util.AttributeSet;
import java.util.Arrays;
import android.graphics.Typeface;
public class KeyboardView extends View implements View.OnClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.737 -0400", hash_original_field = "EB5F5661FF2B3D043C638F1801BFC9A7", hash_generated_field = "EA895C687A2148F1E8F5491D6CC478D4")

    private Keyboard mKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.738 -0400", hash_original_field = "0C8DA07EDE1C1599E4109E436134549F", hash_generated_field = "C89CA751000FEA89D3E5BDE5F5F83FCC")

    private int mCurrentKeyIndex = NOT_A_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.738 -0400", hash_original_field = "DEC1B3F17547C75EB546E199C8E9B558", hash_generated_field = "DE5772C0F13964E46EB371040F09D9BD")

    private int mLabelTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.739 -0400", hash_original_field = "A8DC59462F9D704C89320143ABE40A70", hash_generated_field = "F46E834DED9C913BCF9BFD57D66B37E2")

    private int mKeyTextSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.739 -0400", hash_original_field = "9C8BB504D47CBD6A3339DA07B081588E", hash_generated_field = "34582DAC9CE24400CD80ECDC48BC5B61")

    private int mKeyTextColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.740 -0400", hash_original_field = "0021C70065C1D0F5DA3DE4086470A1AC", hash_generated_field = "E95B50404D53A741F5CBE2BA4A3E9431")

    private float mShadowRadius;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.740 -0400", hash_original_field = "469A474473C53256538C734E6BEFF666", hash_generated_field = "9EE546F5030429B79100604DCF47622D")

    private int mShadowColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.741 -0400", hash_original_field = "1B535260062C2EF01E7AB0C5EF3D6F6E", hash_generated_field = "2063F71D282A2B273A625008537C4E77")

    private float mBackgroundDimAmount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.741 -0400", hash_original_field = "837DC9FE8E6DA787937ADC1B95CF67EA", hash_generated_field = "192E13C6C859B4DEB60A0468CCF36463")

    private TextView mPreviewText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.742 -0400", hash_original_field = "0369EB32A9C9287677680FDBE4CFF95B", hash_generated_field = "8D881909C5773D6484D03D35CC15E15F")

    private PopupWindow mPreviewPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.742 -0400", hash_original_field = "852628EB1AD73FB434F986FCF9BFCC8B", hash_generated_field = "BE4C461E9FE6121290C88C8520893215")

    private int mPreviewTextSizeLarge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.743 -0400", hash_original_field = "970BB6E959D9DE8AE404E00454F71D15", hash_generated_field = "CF3BB08B6C16796B13803A13C739F6D3")

    private int mPreviewOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.743 -0400", hash_original_field = "EE71828713FAB658B22E9E748E8F7197", hash_generated_field = "849680C6259179657F43D68CE17BCBE7")

    private int mPreviewHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.744 -0400", hash_original_field = "4320F6224A7186BA79B47D0D7DD4ECFC", hash_generated_field = "8D34440C3CE03AE936288A3240E3A4DB")

    private final int[] mCoordinates = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.744 -0400", hash_original_field = "A159743C305938BDE02345EFA8664A9D", hash_generated_field = "A80DDD753A87ACCB6A078A916C879B2C")

    private PopupWindow mPopupKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.745 -0400", hash_original_field = "885F5579B05CBCC234DC6A3AF53DAEC3", hash_generated_field = "95037F87D14655069C9BAB8B7839F2A7")

    private View mMiniKeyboardContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.745 -0400", hash_original_field = "B01A897F93492370025F9174952938AE", hash_generated_field = "EB9E5D3BD11AFC0A76A85C6740CC46B2")

    private KeyboardView mMiniKeyboard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.746 -0400", hash_original_field = "E5F089A307B9162F3FD9D8FF0D38D6C3", hash_generated_field = "C6454CB1B3BEE200A8C034A5F092F63F")

    private boolean mMiniKeyboardOnScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.746 -0400", hash_original_field = "3E73D5FA5DAFF9AC7465C90D40A310A9", hash_generated_field = "85F54D255DF56C42DC5D058DAD221928")

    private View mPopupParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.747 -0400", hash_original_field = "D3D4BE7811513F0E44C48335069A73C1", hash_generated_field = "F6B2687649924F9B14E332E0AEDFFE54")

    private int mMiniKeyboardOffsetX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.747 -0400", hash_original_field = "F2D2C7AB12777A55F5F00DD502EA2C9F", hash_generated_field = "BB31B9175C4F08422519C879B919D31A")

    private int mMiniKeyboardOffsetY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.748 -0400", hash_original_field = "AB19CFE0C165B5FEE2392EFF11D6F7BB", hash_generated_field = "0C72631D75B4B3E1F94C4D0B359DFD69")

    private Map<Key,View> mMiniKeyboardCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.748 -0400", hash_original_field = "1FF7333D8075E8242307366B57B0CC5B", hash_generated_field = "9221A121DFD1534D10E61A085D0DDAAB")

    private Key[] mKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.749 -0400", hash_original_field = "B81A346F4B4D3F1D6EC68FBCFD58D3A8", hash_generated_field = "C43F29D81B1CAC71AFA3A21F6BB33642")

    private OnKeyboardActionListener mKeyboardActionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.749 -0400", hash_original_field = "7AD29364EC3F54849F971B5013E18D83", hash_generated_field = "29D4B8A705C3AACB317DF9F068EC7EB5")

    private int mVerticalCorrection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.750 -0400", hash_original_field = "31BCF1AFB6C03815E5B2B18F5591EF09", hash_generated_field = "F939B6CC64FA51F8C34ABDCE9B9025CF")

    private int mProximityThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.750 -0400", hash_original_field = "6D633FABC3A16F63AE289F077D83C001", hash_generated_field = "D12083F80EF47ABCCE4326BB1C4A72EA")

    private boolean mPreviewCentered = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.751 -0400", hash_original_field = "F2AB5685916BDCAA1DD46CE5A62BE512", hash_generated_field = "67E1EDFB9C5023C442613292F3D7DFA4")

    private boolean mShowPreview = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.751 -0400", hash_original_field = "F3EEAF235CBB2EBF41F494E3500BDD7D", hash_generated_field = "B7517BBE6A254CF1B659D57DB6F85838")

    private boolean mShowTouchPoints = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.752 -0400", hash_original_field = "440036F7F02822AAC7BFEDF5BDE6F011", hash_generated_field = "6F5A29D194E559647C0BBAD7F42F1AAF")

    private int mPopupPreviewX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.752 -0400", hash_original_field = "D8E52B5463BDC918578BAEFA058EB915", hash_generated_field = "2F1231FA7553F526ACC495C41B35E30A")

    private int mPopupPreviewY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.753 -0400", hash_original_field = "D642D80A8FCA2003A8773348481585E3", hash_generated_field = "028247CA17AFB4DEA8036DA03BF9BA75")

    private int mLastX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.753 -0400", hash_original_field = "048ECB2D11DDC21BDA8C31B82C3211AD", hash_generated_field = "4998BC9C8C127FC92D590DC22A506E51")

    private int mLastY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.754 -0400", hash_original_field = "9801264300876A677AA3DC64764E3FC2", hash_generated_field = "28E51E686EEF26C8A77C03ED820E724F")

    private int mStartX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.754 -0400", hash_original_field = "D2D722716779C955F0ECDDD867837AC9", hash_generated_field = "2C4FD2F4594E993A1C0AA896A5F50971")

    private int mStartY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.755 -0400", hash_original_field = "D2131F63DDA5CF4CAC7C3674D165A62C", hash_generated_field = "055D7B65DA8B42B81D7FF1F02542AA0E")

    private boolean mProximityCorrectOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.755 -0400", hash_original_field = "78E27F80AC0100441F897783EFA42851", hash_generated_field = "75BCEEBE83B26919B33E8EA8B289919E")

    private Paint mPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.755 -0400", hash_original_field = "9AC2544B5F9B8F60AA16656C94B57A8E", hash_generated_field = "017017AA9AF1862D01EDDEC3A7AB7775")

    private Rect mPadding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.756 -0400", hash_original_field = "51587355C5A724D8637EF803C946DD2D", hash_generated_field = "81CDF43B84B5DBDAAD8AA19BDADDFBB2")

    private long mDownTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.756 -0400", hash_original_field = "53D7B8E9446F78DF295678E09D79A139", hash_generated_field = "57FF426A06AEB02650CDDD86403C46CA")

    private long mLastMoveTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.757 -0400", hash_original_field = "02E87508A27E5DC058B82EFE34CB91A2", hash_generated_field = "B83FE9DDE3DBA13E72C0903F7616870E")

    private int mLastKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.757 -0400", hash_original_field = "71D7A121830E610D8D0F50D50EB5EF7B", hash_generated_field = "B6329AEDFAA5942C570E9522B1AB0DF6")

    private int mLastCodeX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.758 -0400", hash_original_field = "3DD0A75E3B4061003436CEEA55FD0DC3", hash_generated_field = "9674E73AD6D6BE399B2FCE0A0EBA50A2")

    private int mLastCodeY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.758 -0400", hash_original_field = "97A01E249CE8EEC30AD5A9228FBD9B66", hash_generated_field = "0ACDFB8A13E3AC80BD690ECD81BF4B0E")

    private int mCurrentKey = NOT_A_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.759 -0400", hash_original_field = "7056993725CE5AB9033EB749B5F72721", hash_generated_field = "D84E0FEE4AA62886D69462B05DA7C5BE")

    private int mDownKey = NOT_A_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.759 -0400", hash_original_field = "23E2C787C337C24DCAD99057602B2792", hash_generated_field = "83099104DF5E2049BD7A6A6EEFD97CEF")

    private long mLastKeyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.760 -0400", hash_original_field = "C04507409A8C947970CC30F371F9EB34", hash_generated_field = "3238C2554A609BAFA9CC0403F4E7333F")

    private long mCurrentKeyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.760 -0400", hash_original_field = "7CD9AB32EB3181041D8EBE862B958BE0", hash_generated_field = "10DDA8E67A2CAEDE256097A0E96FB56B")

    private int[] mKeyIndices = new int[12];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.761 -0400", hash_original_field = "EBDAC0BE41D965D60A46156878A6BB30", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

    private GestureDetector mGestureDetector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.761 -0400", hash_original_field = "1A391567A3D3871F9CEC71E5C9E19CFE", hash_generated_field = "93FF5290068694D5DEACB7295F3D9638")

    private int mPopupX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.762 -0400", hash_original_field = "EC4C054C0981885C8AF725E98F2FFDFD", hash_generated_field = "C1B8EBCAFCBC59E1AAC6671A6D699097")

    private int mPopupY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.762 -0400", hash_original_field = "B76EE08F7107B4563CBB5B5BB707856B", hash_generated_field = "6F4A4E9A4BB03BBEC9209281C6B42695")

    private int mRepeatKeyIndex = NOT_A_KEY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.763 -0400", hash_original_field = "D671609EC4D8166BB37E938384878BDA", hash_generated_field = "4E3C08F50583F7DA9B1F61D8BCE1B773")

    private int mPopupLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.763 -0400", hash_original_field = "D10B1038E1A3B083D1CFDFF24D0D56DB", hash_generated_field = "7DD9AADFF87E30AB9995EB8A832D74F8")

    private boolean mAbortKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.764 -0400", hash_original_field = "8742955A1F7DD3B5AF06829ADAE4274B", hash_generated_field = "9F963FBFBD0884A676CD5A20FAB7CCCF")

    private Key mInvalidatedKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.764 -0400", hash_original_field = "D25D1560DDF2EE21C79EA41449627D11", hash_generated_field = "828C354EC7D90693B129CDF5240DA9F2")

    private Rect mClipRegion = new Rect(0, 0, 0, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.765 -0400", hash_original_field = "F3EAE917D2EA0A201BF646E68663AEF8", hash_generated_field = "0E08036E156FB2B290E81A4D1442EDA7")

    private boolean mPossiblePoly;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.765 -0400", hash_original_field = "C04963640E4AE790859D1F3CBE37F825", hash_generated_field = "7D64A83672F3556909908897F070292F")

    private SwipeTracker mSwipeTracker = new SwipeTracker();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.765 -0400", hash_original_field = "529648F11DAE9538ABDCB0F4106DDF1B", hash_generated_field = "324B30FE2DB415F5D9D8416F5E183CF6")

    private int mSwipeThreshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.766 -0400", hash_original_field = "256E4CCA960E3694B4BEF00C21245429", hash_generated_field = "ABE85DFF8A613E1E322D044911F145B7")

    private boolean mDisambiguateSwipe;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.766 -0400", hash_original_field = "9A13D6A0BD15B41361F89C59E7AEE686", hash_generated_field = "D44441B64AA1E401B52CF3973D346A16")

    private int mOldPointerCount = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.767 -0400", hash_original_field = "6F4039FF896D92E5EEDE9E7391DA11B9", hash_generated_field = "5046955E78AAE03049207D19650EFDC5")

    private float mOldPointerX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.767 -0400", hash_original_field = "19B606D84031ECA9ED7C7A3F64703524", hash_generated_field = "50E24E821C20EB4B4CC719D4237FCB29")

    private float mOldPointerY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.768 -0400", hash_original_field = "D62E7DB3B24744BAD5FDC81ABD762AA9", hash_generated_field = "5060C49B7E654196FDDC4C72B44B5AE1")

    private Drawable mKeyBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.768 -0400", hash_original_field = "C709AB1682E6D7617BD3187C40ABEFB1", hash_generated_field = "D952C896296FDFFDABF5EE647776CFC7")

    private int[] mDistances = new int[MAX_NEARBY_KEYS];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.769 -0400", hash_original_field = "ACCBE82ABE4A67D639770A9CCA7DF7F7", hash_generated_field = "57AE7CDB9113481D001E5A457D9BB2D4")

    private int mLastSentIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.769 -0400", hash_original_field = "2A810CA91B408E7E005040CF1AE00C05", hash_generated_field = "07E68D77D0CFEDC8C199E70D36452698")

    private int mTapCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.770 -0400", hash_original_field = "A1A90812EAD8EC374024A683F804D427", hash_generated_field = "7E205E7360EB555A956B7E76312C9CF6")

    private long mLastTapTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.770 -0400", hash_original_field = "5BE73FFC973699A44B9730FE88892CEE", hash_generated_field = "1BA2EE4C558F52FAC2328CA0528C249B")

    private boolean mInMultiTap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.770 -0400", hash_original_field = "EFCDF5E6D1D7B1FA9F1CDEE40768418B", hash_generated_field = "BAE9233883B7555F6B48635EB0BF739F")

    private StringBuilder mPreviewLabel = new StringBuilder(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.771 -0400", hash_original_field = "BBE7EE221319E16AC87DAF3CE212CE09", hash_generated_field = "73B1BA0962F8573EE8C0FB4F081E852B")

    private boolean mDrawPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.772 -0400", hash_original_field = "6EB85BF689975FFAB520704329F11123", hash_generated_field = "70A4D6DA2C80F3262F91D524108ABB0A")

    private Rect mDirtyRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.772 -0400", hash_original_field = "0A6D158B6C8BF0C1A56582199871274D", hash_generated_field = "4001CBCBA6596C83067017D1D79DE3B0")

    private Bitmap mBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.773 -0400", hash_original_field = "BDE16AB556A3A28F67E18815125D496D", hash_generated_field = "A07183C57A14F39D38A0855766C37588")

    private boolean mKeyboardChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.773 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "8D4942A1FCE89D15FDC57EFABEDBC717")

    private Canvas mCanvas;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.774 -0400", hash_original_field = "7F1B3F6A6E334A72020206E0E9A4FF92", hash_generated_field = "0117A681BD7DAED5807B8E6C72FA3291")

    private AccessibilityManager mAccessibilityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.774 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "B52B11818937F27E927A20CDEBA27654")

    private AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.775 -0400", hash_original_field = "14A1E054FA70354360412722BD987DB6", hash_generated_field = "32514107C88AC65E6185731982308484")

    private boolean mHeadsetRequiredToHearPasswordsAnnounced;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.778 -0400", hash_original_field = "C3A21393E2E72FD28BCC59705980175D", hash_generated_field = "2DB2EAF070E3115EF7E5D1CB841D6176")

    Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.777 -0400", hash_original_method = "83770C9714E93038DDD3FEA1D740F753", hash_generated_method = "101C0E22731C5B3814A8469486033275")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case MSG_SHOW_PREVIEW:
            showKey(msg.arg1);
            break;
            case MSG_REMOVE_PREVIEW:
            mPreviewText.setVisibility(INVISIBLE);
            break;
            case MSG_REPEAT:
            if(repeatKey())            
            {
                Message repeat = Message.obtain(this, MSG_REPEAT);
                sendMessageDelayed(repeat, REPEAT_INTERVAL);
            } //End block
            break;
            case MSG_LONGPRESS:
            openPopupIfRequired((MotionEvent) msg.obj);
            break;
}
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_SHOW_PREVIEW:
                    //showKey(msg.arg1);
                    //break;
                //case MSG_REMOVE_PREVIEW:
                    //mPreviewText.setVisibility(INVISIBLE);
                    //break;
                //case MSG_REPEAT:
                    //if (repeatKey()) {
                        //Message repeat = Message.obtain(this, MSG_REPEAT);
                        //sendMessageDelayed(repeat, REPEAT_INTERVAL);                        
                    //}
                    //break;
                //case MSG_LONGPRESS:
                    //openPopupIfRequired((MotionEvent) msg.obj);
                    //break;
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.779 -0400", hash_original_method = "B288376D7B2CF1E43051C02ADD9C845F", hash_generated_method = "0668F9B7EED578A01EBF32C393CBEB3E")
    public  KeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.keyboardViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.794 -0400", hash_original_method = "80CA0EE637E9962775AB4968127C795F", hash_generated_method = "2751E8359B3FC69B2C71DD40BB4907EA")
    public  KeyboardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        TypedArray a = context.obtainStyledAttributes(
                attrs, android.R.styleable.KeyboardView, defStyle, 0);
        LayoutInflater inflate = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int previewLayout = 0;
        int keyTextSize = 0;
        int n = a.getIndexCount();
for(int i = 0;i < n;i++)
        {
            int attr = a.getIndex(i);
switch(attr){
            case com.android.internal.R.styleable.KeyboardView_keyBackground:
            mKeyBackground = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.KeyboardView_verticalCorrection:
            mVerticalCorrection = a.getDimensionPixelOffset(attr, 0);
            break;
            case com.android.internal.R.styleable.KeyboardView_keyPreviewLayout:
            previewLayout = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.KeyboardView_keyPreviewOffset:
            mPreviewOffset = a.getDimensionPixelOffset(attr, 0);
            break;
            case com.android.internal.R.styleable.KeyboardView_keyPreviewHeight:
            mPreviewHeight = a.getDimensionPixelSize(attr, 80);
            break;
            case com.android.internal.R.styleable.KeyboardView_keyTextSize:
            mKeyTextSize = a.getDimensionPixelSize(attr, 18);
            break;
            case com.android.internal.R.styleable.KeyboardView_keyTextColor:
            mKeyTextColor = a.getColor(attr, 0xFF000000);
            break;
            case com.android.internal.R.styleable.KeyboardView_labelTextSize:
            mLabelTextSize = a.getDimensionPixelSize(attr, 14);
            break;
            case com.android.internal.R.styleable.KeyboardView_popupLayout:
            mPopupLayout = a.getResourceId(attr, 0);
            break;
            case com.android.internal.R.styleable.KeyboardView_shadowColor:
            mShadowColor = a.getColor(attr, 0);
            break;
            case com.android.internal.R.styleable.KeyboardView_shadowRadius:
            mShadowRadius = a.getFloat(attr, 0f);
            break;
}
        } //End block
        a = mContext.obtainStyledAttributes(
                com.android.internal.R.styleable.Theme);
        mBackgroundDimAmount = a.getFloat(android.R.styleable.Theme_backgroundDimAmount, 0.5f);
        mPreviewPopup = new PopupWindow(context);
        if(previewLayout != 0)        
        {
            mPreviewText = (TextView) inflate.inflate(previewLayout, null);
            mPreviewTextSizeLarge = (int) mPreviewText.getTextSize();
            mPreviewPopup.setContentView(mPreviewText);
            mPreviewPopup.setBackgroundDrawable(null);
        } //End block
        else
        {
            mShowPreview = false;
        } //End block
        mPreviewPopup.setTouchable(false);
        mPopupKeyboard = new PopupWindow(context);
        mPopupKeyboard.setBackgroundDrawable(null);
        mPopupParent = this;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(keyTextSize);
        mPaint.setTextAlign(Align.CENTER);
        mPaint.setAlpha(255);
        mPadding = new Rect(0, 0, 0, 0);
        mMiniKeyboardCache = new HashMap<Key,View>();
        mKeyBackground.getPadding(mPadding);
        mSwipeThreshold = (int) (500 * getResources().getDisplayMetrics().density);
        mDisambiguateSwipe = getResources().getBoolean(
                com.android.internal.R.bool.config_swipeDisambiguation);
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        resetMultiTap();
        initGestureDetector();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.811 -0400", hash_original_method = "EB7C68519BBD5935E699A038D5D44150", hash_generated_method = "B48049B66BF8F951F384E441F62028D6")
    private void initGestureDetector() {
        mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.804 -0400", hash_original_method = "2781C8B4D42D388F24DF994E21193B51", hash_generated_method = "26649D2363A79B40F6DBE27649621A15")
        @Override
        public boolean onFling(MotionEvent me1, MotionEvent me2, 
                    float velocityX, float velocityY) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(velocityY);
            addTaint(velocityX);
            addTaint(me2.getTaint());
            addTaint(me1.getTaint());
            if(mPossiblePoly)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1934971643 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222958651 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_222958651;
            }
            final float absX = Math.abs(velocityX);
            final float absY = Math.abs(velocityY);
            float deltaX = me2.getX() - me1.getX();
            float deltaY = me2.getY() - me1.getY();
            int travelX = getWidth() / 2;
            int travelY = getHeight() / 2;
            mSwipeTracker.computeCurrentVelocity(1000);
            final float endingVelocityX = mSwipeTracker.getXVelocity();
            final float endingVelocityY = mSwipeTracker.getYVelocity();
            boolean sendDownKey = false;
            if(velocityX > mSwipeThreshold && absY < absX && deltaX > travelX)            
            {
                if(mDisambiguateSwipe && endingVelocityX < velocityX / 4)                
                {
                    sendDownKey = true;
                } //End block
                else
                {
                    swipeRight();
                    boolean varB326B5062B2F0E69046810717534CB09_420952061 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297187443 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_297187443;
                } //End block
            } //End block
            else
            if(velocityX < -mSwipeThreshold && absY < absX && deltaX < -travelX)            
            {
                if(mDisambiguateSwipe && endingVelocityX > velocityX / 4)                
                {
                    sendDownKey = true;
                } //End block
                else
                {
                    swipeLeft();
                    boolean varB326B5062B2F0E69046810717534CB09_345879674 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845643989 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845643989;
                } //End block
            } //End block
            else
            if(velocityY < -mSwipeThreshold && absX < absY && deltaY < -travelY)            
            {
                if(mDisambiguateSwipe && endingVelocityY > velocityY / 4)                
                {
                    sendDownKey = true;
                } //End block
                else
                {
                    swipeUp();
                    boolean varB326B5062B2F0E69046810717534CB09_1345870211 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817446053 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_817446053;
                } //End block
            } //End block
            else
            if(velocityY > mSwipeThreshold && absX < absY / 2 && deltaY > travelY)            
            {
                if(mDisambiguateSwipe && endingVelocityY < velocityY / 4)                
                {
                    sendDownKey = true;
                } //End block
                else
                {
                    swipeDown();
                    boolean varB326B5062B2F0E69046810717534CB09_909549583 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026989981 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026989981;
                } //End block
            } //End block
            if(sendDownKey)            
            {
                detectAndSendKey(mDownKey, mStartX, mStartY, me1.getEventTime());
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_150369496 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781964260 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781964260;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
});
        mGestureDetector.setIsLongpressEnabled(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.814 -0400", hash_original_method = "7AD9DD428DF8E7D6E8D91417D6DB1819", hash_generated_method = "7B9A6FF4EA2CC942E6DB354B5A69D299")
    public void setOnKeyboardActionListener(OnKeyboardActionListener listener) {
        mKeyboardActionListener = listener;
        // ---------- Original Method ----------
        //mKeyboardActionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.815 -0400", hash_original_method = "23010A325BF7C5CE115AD6532E7DE613", hash_generated_method = "EBA85B6AD2BFDBA82A5114535F7F12A3")
    protected OnKeyboardActionListener getOnKeyboardActionListener() {
OnKeyboardActionListener varCA74E3A39D116C170964E820A8E794C6_425890983 =         mKeyboardActionListener;
        varCA74E3A39D116C170964E820A8E794C6_425890983.addTaint(taint);
        return varCA74E3A39D116C170964E820A8E794C6_425890983;
        // ---------- Original Method ----------
        //return mKeyboardActionListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.818 -0400", hash_original_method = "27CAF8C973D7E7FB8A9EAE6FDFA442C5", hash_generated_method = "1C3E2C2CE8719181831FDD2D5E70144F")
    public void setKeyboard(Keyboard keyboard) {
        if(mKeyboard != null)        
        {
            showPreview(NOT_A_KEY);
        } //End block
        removeMessages();
        mKeyboard = keyboard;
        List<Key> keys = mKeyboard.getKeys();
        mKeys = keys.toArray(new Key[keys.size()]);
        requestLayout();
        mKeyboardChanged = true;
        invalidateAllKeys();
        computeProximityThreshold(keyboard);
        mMiniKeyboardCache.clear();
        mAbortKey = true;
        // ---------- Original Method ----------
        //if (mKeyboard != null) {
            //showPreview(NOT_A_KEY);
        //}
        //removeMessages();
        //mKeyboard = keyboard;
        //List<Key> keys = mKeyboard.getKeys();
        //mKeys = keys.toArray(new Key[keys.size()]);
        //requestLayout();
        //mKeyboardChanged = true;
        //invalidateAllKeys();
        //computeProximityThreshold(keyboard);
        //mMiniKeyboardCache.clear();
        //mAbortKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.820 -0400", hash_original_method = "984E33167FBB351AF6D207D6648DD7BE", hash_generated_method = "E07063A84AF8BC6549A47C5285A9A8AE")
    public Keyboard getKeyboard() {
Keyboard var0FC80BD37FFC31C3C7A9C3E1A563FDB2_798529270 =         mKeyboard;
        var0FC80BD37FFC31C3C7A9C3E1A563FDB2_798529270.addTaint(taint);
        return var0FC80BD37FFC31C3C7A9C3E1A563FDB2_798529270;
        // ---------- Original Method ----------
        //return mKeyboard;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.822 -0400", hash_original_method = "0E720862875FB23B0F0CBA22C126D93A", hash_generated_method = "E09099A4E467DF0C4F45E1920975DAEB")
    public boolean setShifted(boolean shifted) {
        addTaint(shifted);
        if(mKeyboard != null)        
        {
            if(mKeyboard.setShifted(shifted))            
            {
                invalidateAllKeys();
                boolean varB326B5062B2F0E69046810717534CB09_1761965748 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438122056 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438122056;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_330278587 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888604510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888604510;
        // ---------- Original Method ----------
        //if (mKeyboard != null) {
            //if (mKeyboard.setShifted(shifted)) {
                //invalidateAllKeys();
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.824 -0400", hash_original_method = "7ABCACB0E9394FD000A197B9A8A05ED8", hash_generated_method = "6CD372EC1EE980D24A5D51C61B3B961A")
    public boolean isShifted() {
        if(mKeyboard != null)        
        {
            boolean var799A8911709FCF3C32FD0C6E03E0F68F_939065076 = (mKeyboard.isShifted());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455821391 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_455821391;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_168472891 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211629462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211629462;
        // ---------- Original Method ----------
        //if (mKeyboard != null) {
            //return mKeyboard.isShifted();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.826 -0400", hash_original_method = "C5C34401DC7A97A27F769460DD216E94", hash_generated_method = "75B9BD5E7EDBF74C6A58EF54379BE458")
    public void setPreviewEnabled(boolean previewEnabled) {
        mShowPreview = previewEnabled;
        // ---------- Original Method ----------
        //mShowPreview = previewEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.827 -0400", hash_original_method = "37653BB5A476BD19CD2E3B8897347B3C", hash_generated_method = "3FCE320DE83AD975B21AE174A9D528A0")
    public boolean isPreviewEnabled() {
        boolean varB91FA51F23FC8ABDCE93A91241B4B478_1538571734 = (mShowPreview);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835139796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835139796;
        // ---------- Original Method ----------
        //return mShowPreview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.829 -0400", hash_original_method = "A44B8176E58DC2FB7752B0C5D42CC6EF", hash_generated_method = "673B634C9B7052C0DE7A8B0553908B37")
    public void setVerticalCorrection(int verticalOffset) {
        addTaint(verticalOffset);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.830 -0400", hash_original_method = "5971AB78FF80F5C9F5F808051286A0E1", hash_generated_method = "E98FDE4E324E0BDFA9B02B9798E539A7")
    public void setPopupParent(View v) {
        mPopupParent = v;
        // ---------- Original Method ----------
        //mPopupParent = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.833 -0400", hash_original_method = "1FBDD4D1B50AEDEAA839E9B93FCC4616", hash_generated_method = "39B35421F6A8D7841443D6ED5B38BED2")
    public void setPopupOffset(int x, int y) {
        mMiniKeyboardOffsetX = x;
        mMiniKeyboardOffsetY = y;
        if(mPreviewPopup.isShowing())        
        {
            mPreviewPopup.dismiss();
        } //End block
        // ---------- Original Method ----------
        //mMiniKeyboardOffsetX = x;
        //mMiniKeyboardOffsetY = y;
        //if (mPreviewPopup.isShowing()) {
            //mPreviewPopup.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.834 -0400", hash_original_method = "3DEAD8B7804C545A2916420746E3D700", hash_generated_method = "75C7F8FFCB02A1EA7D13B163235B0AF6")
    public void setProximityCorrectionEnabled(boolean enabled) {
        mProximityCorrectOn = enabled;
        // ---------- Original Method ----------
        //mProximityCorrectOn = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.836 -0400", hash_original_method = "1081F6AA68205DB94C7EE73A028D936B", hash_generated_method = "FAD214229031488675A39501BC67E535")
    public boolean isProximityCorrectionEnabled() {
        boolean varD2131F63DDA5CF4CAC7C3674D165A62C_198074036 = (mProximityCorrectOn);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991036791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991036791;
        // ---------- Original Method ----------
        //return mProximityCorrectOn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.837 -0400", hash_original_method = "517EB00C96BF10223527FB74EBBA7FDF", hash_generated_method = "9059545EF5777B113E36EB07F7C216AC")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        dismissPopupKeyboard();
        // ---------- Original Method ----------
        //dismissPopupKeyboard();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.839 -0400", hash_original_method = "781A450D3FB76D72B6A6868D87C7E6E3", hash_generated_method = "223BF3C711E3AF5E372F106B8C544192")
    private CharSequence adjustCase(CharSequence label) {
        addTaint(label.getTaint());
        if(mKeyboard.isShifted() && label != null && label.length() < 3
                && Character.isLowerCase(label.charAt(0)))        
        {
            label = label.toString().toUpperCase();
        } //End block
CharSequence var057F26F90053C562EFC08298AB91C2B1_45947701 =         label;
        var057F26F90053C562EFC08298AB91C2B1_45947701.addTaint(taint);
        return var057F26F90053C562EFC08298AB91C2B1_45947701;
        // ---------- Original Method ----------
        //if (mKeyboard.isShifted() && label != null && label.length() < 3
                //&& Character.isLowerCase(label.charAt(0))) {
            //label = label.toString().toUpperCase();
        //}
        //return label;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.841 -0400", hash_original_method = "D28640CD963FD005E83EC8007612A403", hash_generated_method = "55605C2673A5D5197BD71E33BDA152C4")
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        if(mKeyboard == null)        
        {
            setMeasuredDimension(mPaddingLeft + mPaddingRight, mPaddingTop + mPaddingBottom);
        } //End block
        else
        {
            int width = mKeyboard.getMinWidth() + mPaddingLeft + mPaddingRight;
            if(MeasureSpec.getSize(widthMeasureSpec) < width + 10)            
            {
                width = MeasureSpec.getSize(widthMeasureSpec);
            } //End block
            setMeasuredDimension(width, mKeyboard.getHeight() + mPaddingTop + mPaddingBottom);
        } //End block
        // ---------- Original Method ----------
        //if (mKeyboard == null) {
            //setMeasuredDimension(mPaddingLeft + mPaddingRight, mPaddingTop + mPaddingBottom);
        //} else {
            //int width = mKeyboard.getMinWidth() + mPaddingLeft + mPaddingRight;
            //if (MeasureSpec.getSize(widthMeasureSpec) < width + 10) {
                //width = MeasureSpec.getSize(widthMeasureSpec);
            //}
            //setMeasuredDimension(width, mKeyboard.getHeight() + mPaddingTop + mPaddingBottom);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.845 -0400", hash_original_method = "896596FB10EC8067ADB1D8FA588FB3CE", hash_generated_method = "CB6B30A7695FD03554653930ECF5E080")
    private void computeProximityThreshold(Keyboard keyboard) {
        addTaint(keyboard.getTaint());
        if(keyboard == null)        
        return;
        final Key[] keys = mKeys;
        if(keys == null)        
        return;
        int length = keys.length;
        int dimensionSum = 0;
for(int i = 0;i < length;i++)
        {
            Key key = keys[i];
            dimensionSum += Math.min(key.width, key.height) + key.gap;
        } //End block
        if(dimensionSum < 0 || length == 0)        
        return;
        mProximityThreshold = (int) (dimensionSum * 1.4f / length);
        mProximityThreshold *= mProximityThreshold;
        // ---------- Original Method ----------
        //if (keyboard == null) return;
        //final Key[] keys = mKeys;
        //if (keys == null) return;
        //int length = keys.length;
        //int dimensionSum = 0;
        //for (int i = 0; i < length; i++) {
            //Key key = keys[i];
            //dimensionSum += Math.min(key.width, key.height) + key.gap;
        //}
        //if (dimensionSum < 0 || length == 0) return;
        //mProximityThreshold = (int) (dimensionSum * 1.4f / length);
        //mProximityThreshold *= mProximityThreshold;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.847 -0400", hash_original_method = "4D975CF749492A65803F979B31DB3531", hash_generated_method = "51251E47A0AA514CFCB3EC6F2431052C")
    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        super.onSizeChanged(w, h, oldw, oldh);
        if(mKeyboard != null)        
        {
            mKeyboard.resize(w, h);
        } //End block
        mBuffer = null;
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //if (mKeyboard != null) {
            //mKeyboard.resize(w, h);
        //}
        //mBuffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.849 -0400", hash_original_method = "5BAC2E0CA78C3668D6E66F6C464B766C", hash_generated_method = "90C2037A062ABADDE0B0CE54F8A99DE1")
    @Override
    public void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
        if(mDrawPending || mBuffer == null || mKeyboardChanged)        
        {
            onBufferDraw();
        } //End block
        canvas.drawBitmap(mBuffer, 0, 0, null);
        // ---------- Original Method ----------
        //super.onDraw(canvas);
        //if (mDrawPending || mBuffer == null || mKeyboardChanged) {
            //onBufferDraw();
        //}
        //canvas.drawBitmap(mBuffer, 0, 0, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.856 -0400", hash_original_method = "96C74DEE432C032C16FED8A3134743B1", hash_generated_method = "782D67B96A64AE57B51FAB00B98600A7")
    private void onBufferDraw() {
        if(mBuffer == null || mKeyboardChanged)        
        {
            if(mBuffer == null || mKeyboardChanged &&
                    (mBuffer.getWidth() != getWidth() || mBuffer.getHeight() != getHeight()))            
            {
                final int width = Math.max(1, getWidth());
                final int height = Math.max(1, getHeight());
                mBuffer = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                mCanvas = new Canvas(mBuffer);
            } //End block
            invalidateAllKeys();
            mKeyboardChanged = false;
        } //End block
        final Canvas canvas = mCanvas;
        canvas.clipRect(mDirtyRect, Op.REPLACE);
        if(mKeyboard == null)        
        return;
        final Paint paint = mPaint;
        final Drawable keyBackground = mKeyBackground;
        final Rect clipRegion = mClipRegion;
        final Rect padding = mPadding;
        final int kbdPaddingLeft = mPaddingLeft;
        final int kbdPaddingTop = mPaddingTop;
        final Key[] keys = mKeys;
        final Key invalidKey = mInvalidatedKey;
        paint.setColor(mKeyTextColor);
        boolean drawSingleKey = false;
        if(invalidKey != null && canvas.getClipBounds(clipRegion))        
        {
            if(invalidKey.x + kbdPaddingLeft - 1 <= clipRegion.left &&
                  invalidKey.y + kbdPaddingTop - 1 <= clipRegion.top &&
                  invalidKey.x + invalidKey.width + kbdPaddingLeft + 1 >= clipRegion.right &&
                  invalidKey.y + invalidKey.height + kbdPaddingTop + 1 >= clipRegion.bottom)            
            {
                drawSingleKey = true;
            } //End block
        } //End block
        canvas.drawColor(0x00000000, PorterDuff.Mode.CLEAR);
        final int keyCount = keys.length;
for(int i = 0;i < keyCount;i++)
        {
            final Key key = keys[i];
            if(drawSingleKey && invalidKey != key)            
            {
                continue;
            } //End block
            int[] drawableState = key.getCurrentDrawableState();
            keyBackground.setState(drawableState);
            String label = key.label == null? null : adjustCase(key.label).toString();
            final Rect bounds = keyBackground.getBounds();
            if(key.width != bounds.right || 
                    key.height != bounds.bottom)            
            {
                keyBackground.setBounds(0, 0, key.width, key.height);
            } //End block
            canvas.translate(key.x + kbdPaddingLeft, key.y + kbdPaddingTop);
            keyBackground.draw(canvas);
            if(label != null)            
            {
                if(label.length() > 1 && key.codes.length < 2)                
                {
                    paint.setTextSize(mLabelTextSize);
                    paint.setTypeface(Typeface.DEFAULT_BOLD);
                } //End block
                else
                {
                    paint.setTextSize(mKeyTextSize);
                    paint.setTypeface(Typeface.DEFAULT);
                } //End block
                paint.setShadowLayer(mShadowRadius, 0, 0, mShadowColor);
                canvas.drawText(label,
                    (key.width - padding.left - padding.right) / 2
                            + padding.left,
                    (key.height - padding.top - padding.bottom) / 2
                            + (paint.getTextSize() - paint.descent()) / 2 + padding.top,
                    paint);
                paint.setShadowLayer(0, 0, 0, 0);
            } //End block
            else
            if(key.icon != null)            
            {
                final int drawableX = (key.width - padding.left - padding.right 
                                - key.icon.getIntrinsicWidth()) / 2 + padding.left;
                final int drawableY = (key.height - padding.top - padding.bottom 
                        - key.icon.getIntrinsicHeight()) / 2 + padding.top;
                canvas.translate(drawableX, drawableY);
                key.icon.setBounds(0, 0, 
                        key.icon.getIntrinsicWidth(), key.icon.getIntrinsicHeight());
                key.icon.draw(canvas);
                canvas.translate(-drawableX, -drawableY);
            } //End block
            canvas.translate(-key.x - kbdPaddingLeft, -key.y - kbdPaddingTop);
        } //End block
        mInvalidatedKey = null;
        if(mMiniKeyboardOnScreen)        
        {
            paint.setColor((int) (mBackgroundDimAmount * 0xFF) << 24);
            canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        } //End block
        if(DEBUG && mShowTouchPoints)        
        {
            paint.setAlpha(128);
            paint.setColor(0xFFFF0000);
            canvas.drawCircle(mStartX, mStartY, 3, paint);
            canvas.drawLine(mStartX, mStartY, mLastX, mLastY, paint);
            paint.setColor(0xFF0000FF);
            canvas.drawCircle(mLastX, mLastY, 3, paint);
            paint.setColor(0xFF00FF00);
            canvas.drawCircle((mStartX + mLastX) / 2, (mStartY + mLastY) / 2, 2, paint);
        } //End block
        mDrawPending = false;
        mDirtyRect.setEmpty();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.866 -0400", hash_original_method = "C473D2B758AAFCD419620D01C48167B2", hash_generated_method = "BF565A8EE941932988FCCA723D0C720E")
    private int getKeyIndices(int x, int y, int[] allKeys) {
        addTaint(allKeys[0]);
        addTaint(y);
        addTaint(x);
        final Key[] keys = mKeys;
        int primaryIndex = NOT_A_KEY;
        int closestKey = NOT_A_KEY;
        int closestKeyDist = mProximityThreshold + 1;
        java.util.Arrays.fill(mDistances, Integer.MAX_VALUE);
        int [] nearestKeyIndices = mKeyboard.getNearestKeys(x, y);
        final int keyCount = nearestKeyIndices.length;
for(int i = 0;i < keyCount;i++)
        {
            final Key key = keys[nearestKeyIndices[i]];
            int dist = 0;
            boolean isInside = key.isInside(x,y);
            if(isInside)            
            {
                primaryIndex = nearestKeyIndices[i];
            } //End block
            if(((mProximityCorrectOn 
                    && (dist = key.squaredDistanceFrom(x, y)) < mProximityThreshold) 
                    || isInside)
                    && key.codes[0] > 32)            
            {
                final int nCodes = key.codes.length;
                if(dist < closestKeyDist)                
                {
                    closestKeyDist = dist;
                    closestKey = nearestKeyIndices[i];
                } //End block
                if(allKeys == null)                
                continue;
for(int j = 0;j < mDistances.length;j++)
                {
                    if(mDistances[j] > dist)                    
                    {
                        System.arraycopy(mDistances, j, mDistances, j + nCodes,
                                mDistances.length - j - nCodes);
                        System.arraycopy(allKeys, j, allKeys, j + nCodes,
                                allKeys.length - j - nCodes);
for(int c = 0;c < nCodes;c++)
                        {
                            allKeys[j + c] = key.codes[c];
                            mDistances[j + c] = dist;
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(primaryIndex == NOT_A_KEY)        
        {
            primaryIndex = closestKey;
        } //End block
        int var34501E4EC7AFCAAB5B5935697C471326_210428120 = (primaryIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270232175 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_270232175;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.872 -0400", hash_original_method = "52A7E92418C73C96342342851CFE760F", hash_generated_method = "66EA3FB640CCA98BE76C80AB1A9A68C3")
    private void detectAndSendKey(int index, int x, int y, long eventTime) {
        addTaint(y);
        addTaint(x);
        if(index != NOT_A_KEY && index < mKeys.length)        
        {
            final Key key = mKeys[index];
            if(key.text != null)            
            {
                mKeyboardActionListener.onText(key.text);
                mKeyboardActionListener.onRelease(NOT_A_KEY);
            } //End block
            else
            {
                int code = key.codes[0];
                int[] codes = new int[MAX_NEARBY_KEYS];
                Arrays.fill(codes, NOT_A_KEY);
                getKeyIndices(x, y, codes);
                if(mInMultiTap)                
                {
                    if(mTapCount != -1)                    
                    {
                        mKeyboardActionListener.onKey(Keyboard.KEYCODE_DELETE, KEY_DELETE);
                    } //End block
                    else
                    {
                        mTapCount = 0;
                    } //End block
                    code = key.codes[mTapCount];
                } //End block
                mKeyboardActionListener.onKey(code, codes);
                mKeyboardActionListener.onRelease(code);
            } //End block
            mLastSentIndex = index;
            mLastTapTime = eventTime;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.875 -0400", hash_original_method = "B99959843F38A619DEB8B37FB5314914", hash_generated_method = "FD777586D9264390F8623139AE7626E4")
    private CharSequence getPreviewText(Key key) {
        addTaint(key.getTaint());
        if(mInMultiTap)        
        {
            mPreviewLabel.setLength(0);
            mPreviewLabel.append((char) key.codes[mTapCount < 0 ? 0 : mTapCount]);
CharSequence var3B8009DBC52123412327A0E0C562E082_447087581 =             adjustCase(mPreviewLabel);
            var3B8009DBC52123412327A0E0C562E082_447087581.addTaint(taint);
            return var3B8009DBC52123412327A0E0C562E082_447087581;
        } //End block
        else
        {
CharSequence var205FABBFF9568819CAC3C3C1D98F3426_1990994969 =             adjustCase(key.label);
            var205FABBFF9568819CAC3C3C1D98F3426_1990994969.addTaint(taint);
            return var205FABBFF9568819CAC3C3C1D98F3426_1990994969;
        } //End block
        // ---------- Original Method ----------
        //if (mInMultiTap) {
            //mPreviewLabel.setLength(0);
            //mPreviewLabel.append((char) key.codes[mTapCount < 0 ? 0 : mTapCount]);
            //return adjustCase(mPreviewLabel);
        //} else {
            //return adjustCase(key.label);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.878 -0400", hash_original_method = "561BE5D178CD3CF93CA2FD4A1DFD5618", hash_generated_method = "1384ECD5FC4436B355FB412BB4C85278")
    private void showPreview(int keyIndex) {
        int oldKeyIndex = mCurrentKeyIndex;
        final PopupWindow previewPopup = mPreviewPopup;
        mCurrentKeyIndex = keyIndex;
        final Key[] keys = mKeys;
        if(oldKeyIndex != mCurrentKeyIndex)        
        {
            if(oldKeyIndex != NOT_A_KEY && keys.length > oldKeyIndex)            
            {
                Key oldKey = keys[oldKeyIndex];
                oldKey.onReleased(mCurrentKeyIndex == NOT_A_KEY);
                invalidateKey(oldKeyIndex);
                sendAccessibilityEventForUnicodeCharacter(AccessibilityEvent.TYPE_VIEW_HOVER_EXIT,
                        oldKey.codes[0]);
            } //End block
            if(mCurrentKeyIndex != NOT_A_KEY && keys.length > mCurrentKeyIndex)            
            {
                Key newKey = keys[mCurrentKeyIndex];
                newKey.onPressed();
                invalidateKey(mCurrentKeyIndex);
                sendAccessibilityEventForUnicodeCharacter(AccessibilityEvent.TYPE_VIEW_HOVER_ENTER,
                        newKey.codes[0]);
            } //End block
        } //End block
        if(oldKeyIndex != mCurrentKeyIndex && mShowPreview)        
        {
            mHandler.removeMessages(MSG_SHOW_PREVIEW);
            if(previewPopup.isShowing())            
            {
                if(keyIndex == NOT_A_KEY)                
                {
                    mHandler.sendMessageDelayed(mHandler
                            .obtainMessage(MSG_REMOVE_PREVIEW), 
                            DELAY_AFTER_PREVIEW);
                } //End block
            } //End block
            if(keyIndex != NOT_A_KEY)            
            {
                if(previewPopup.isShowing() && mPreviewText.getVisibility() == VISIBLE)                
                {
                    showKey(keyIndex);
                } //End block
                else
                {
                    mHandler.sendMessageDelayed(
                            mHandler.obtainMessage(MSG_SHOW_PREVIEW, keyIndex, 0), 
                            DELAY_BEFORE_PREVIEW);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.889 -0400", hash_original_method = "100F18AFE995DB5043CBE9D74CDBF0D2", hash_generated_method = "F5D0F7245054714EFCED54CCEEBD2394")
    private void showKey(final int keyIndex) {
        addTaint(keyIndex);
        final PopupWindow previewPopup = mPreviewPopup;
        final Key[] keys = mKeys;
        if(keyIndex < 0 || keyIndex >= mKeys.length)        
        return;
        Key key = keys[keyIndex];
        if(key.icon != null)        
        {
            mPreviewText.setCompoundDrawables(null, null, null, 
                    key.iconPreview != null ? key.iconPreview : key.icon);
            mPreviewText.setText(null);
        } //End block
        else
        {
            mPreviewText.setCompoundDrawables(null, null, null, null);
            mPreviewText.setText(getPreviewText(key));
            if(key.label.length() > 1 && key.codes.length < 2)            
            {
                mPreviewText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mKeyTextSize);
                mPreviewText.setTypeface(Typeface.DEFAULT_BOLD);
            } //End block
            else
            {
                mPreviewText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mPreviewTextSizeLarge);
                mPreviewText.setTypeface(Typeface.DEFAULT);
            } //End block
        } //End block
        mPreviewText.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED), 
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
        int popupWidth = Math.max(mPreviewText.getMeasuredWidth(), key.width 
                + mPreviewText.getPaddingLeft() + mPreviewText.getPaddingRight());
        final int popupHeight = mPreviewHeight;
        LayoutParams lp = mPreviewText.getLayoutParams();
        if(lp != null)        
        {
            lp.width = popupWidth;
            lp.height = popupHeight;
        } //End block
        if(!mPreviewCentered)        
        {
            mPopupPreviewX = key.x - mPreviewText.getPaddingLeft() + mPaddingLeft;
            mPopupPreviewY = key.y - popupHeight + mPreviewOffset;
        } //End block
        else
        {
            mPopupPreviewX = 160 - mPreviewText.getMeasuredWidth() / 2;
            mPopupPreviewY = - mPreviewText.getMeasuredHeight();
        } //End block
        mHandler.removeMessages(MSG_REMOVE_PREVIEW);
        getLocationInWindow(mCoordinates);
        mCoordinates[0] += mMiniKeyboardOffsetX;
        mCoordinates[1] += mMiniKeyboardOffsetY;
        mPreviewText.getBackground().setState(
                key.popupResId != 0 ? LONG_PRESSABLE_STATE_SET : EMPTY_STATE_SET);
        mPopupPreviewX += mCoordinates[0];
        mPopupPreviewY += mCoordinates[1];
        getLocationOnScreen(mCoordinates);
        if(mPopupPreviewY + mCoordinates[1] < 0)        
        {
            if(key.x + key.width <= getWidth() / 2)            
            {
                mPopupPreviewX += (int) (key.width * 2.5);
            } //End block
            else
            {
                mPopupPreviewX -= (int) (key.width * 2.5);
            } //End block
            mPopupPreviewY += popupHeight;
        } //End block
        if(previewPopup.isShowing())        
        {
            previewPopup.update(mPopupPreviewX, mPopupPreviewY,
                    popupWidth, popupHeight);
        } //End block
        else
        {
            previewPopup.setWidth(popupWidth);
            previewPopup.setHeight(popupHeight);
            previewPopup.showAtLocation(mPopupParent, Gravity.NO_GRAVITY, 
                    mPopupPreviewX, mPopupPreviewY);
        } //End block
        mPreviewText.setVisibility(VISIBLE);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.904 -0400", hash_original_method = "D0CD4F0361B047F25CB522F4E5EFF159", hash_generated_method = "5C70E794E0816DB716C4ADE1BFF1C3C5")
    private void sendAccessibilityEventForUnicodeCharacter(int eventType, int code) {
        addTaint(code);
        addTaint(eventType);
        if(mAccessibilityManager.isEnabled())        
        {
            AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
            onInitializeAccessibilityEvent(event);
            String text = null;
            final boolean speakPassword = Settings.Secure.getInt(mContext.getContentResolver(),
                    Settings.Secure.ACCESSIBILITY_SPEAK_PASSWORD, 0) != 0;
            if(speakPassword || mAudioManager.isBluetoothA2dpOn()
                    || mAudioManager.isWiredHeadsetOn())            
            {
switch(code){
                case Keyboard.KEYCODE_ALT:
                text = mContext.getString(R.string.keyboardview_keycode_alt);
                break;
                case Keyboard.KEYCODE_CANCEL:
                text = mContext.getString(R.string.keyboardview_keycode_cancel);
                break;
                case Keyboard.KEYCODE_DELETE:
                text = mContext.getString(R.string.keyboardview_keycode_delete);
                break;
                case Keyboard.KEYCODE_DONE:
                text = mContext.getString(R.string.keyboardview_keycode_done);
                break;
                case Keyboard.KEYCODE_MODE_CHANGE:
                text = mContext.getString(R.string.keyboardview_keycode_mode_change);
                break;
                case Keyboard.KEYCODE_SHIFT:
                text = mContext.getString(R.string.keyboardview_keycode_shift);
                break;
                case '\n':
                text = mContext.getString(R.string.keyboardview_keycode_enter);
                break;
                default:
                text = String.valueOf((char) code);
}
            } //End block
            else
            if(!mHeadsetRequiredToHearPasswordsAnnounced)            
            {
                if(eventType == AccessibilityEvent.TYPE_VIEW_HOVER_EXIT)                
                {
                    mHeadsetRequiredToHearPasswordsAnnounced = true;
                } //End block
                text = mContext.getString(R.string.keyboard_headset_required_to_hear_password);
            } //End block
            else
            {
                text = mContext.getString(R.string.keyboard_password_character_no_headset);
            } //End block
            event.getText().add(text);
            mAccessibilityManager.sendAccessibilityEvent(event);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.907 -0400", hash_original_method = "6A419C09C1C26C01E94194577A06CA69", hash_generated_method = "9E4E531665E1667C8F619B8422A6898B")
    public void invalidateAllKeys() {
        mDirtyRect.union(0, 0, getWidth(), getHeight());
        mDrawPending = true;
        invalidate();
        // ---------- Original Method ----------
        //mDirtyRect.union(0, 0, getWidth(), getHeight());
        //mDrawPending = true;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.909 -0400", hash_original_method = "62674C0D32D49DFA23BF647483C8F7FF", hash_generated_method = "6D9E6D6D9EB918DB843B293BDA55BD7B")
    public void invalidateKey(int keyIndex) {
        addTaint(keyIndex);
        if(mKeys == null)        
        return;
        if(keyIndex < 0 || keyIndex >= mKeys.length)        
        {
            return;
        } //End block
        final Key key = mKeys[keyIndex];
        mInvalidatedKey = key;
        mDirtyRect.union(key.x + mPaddingLeft, key.y + mPaddingTop, 
                key.x + key.width + mPaddingLeft, key.y + key.height + mPaddingTop);
        onBufferDraw();
        invalidate(key.x + mPaddingLeft, key.y + mPaddingTop, 
                key.x + key.width + mPaddingLeft, key.y + key.height + mPaddingTop);
        // ---------- Original Method ----------
        //if (mKeys == null) return;
        //if (keyIndex < 0 || keyIndex >= mKeys.length) {
            //return;
        //}
        //final Key key = mKeys[keyIndex];
        //mInvalidatedKey = key;
        //mDirtyRect.union(key.x + mPaddingLeft, key.y + mPaddingTop, 
                //key.x + key.width + mPaddingLeft, key.y + key.height + mPaddingTop);
        //onBufferDraw();
        //invalidate(key.x + mPaddingLeft, key.y + mPaddingTop, 
                //key.x + key.width + mPaddingLeft, key.y + key.height + mPaddingTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.913 -0400", hash_original_method = "841EEC9CDBD0499FCF82CCA315D0D684", hash_generated_method = "6FB28206CFFD447FAA23A76C88870DC6")
    private boolean openPopupIfRequired(MotionEvent me) {
        addTaint(me.getTaint());
        if(mPopupLayout == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1094855097 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88010191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_88010191;
        } //End block
        if(mCurrentKey < 0 || mCurrentKey >= mKeys.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1023025748 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019931085 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019931085;
        } //End block
        Key popupKey = mKeys[mCurrentKey];
        boolean result = onLongPress(popupKey);
        if(result)        
        {
            mAbortKey = true;
            showPreview(NOT_A_KEY);
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1837093680 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1006296442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1006296442;
        // ---------- Original Method ----------
        //if (mPopupLayout == 0) {
            //return false;
        //}
        //if (mCurrentKey < 0 || mCurrentKey >= mKeys.length) {
            //return false;
        //}
        //Key popupKey = mKeys[mCurrentKey];
        //boolean result = onLongPress(popupKey);
        //if (result) {
            //mAbortKey = true;
            //showPreview(NOT_A_KEY);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.933 -0400", hash_original_method = "C27421F2D68DD4C608F1154E69D7AFFC", hash_generated_method = "17F164436A03D3432183A1CC8F973127")
    protected boolean onLongPress(Key popupKey) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int popupKeyboardId = popupKey.popupResId;
        if(popupKeyboardId != 0)        
        {
            mMiniKeyboardContainer = mMiniKeyboardCache.get(popupKey);
            if(mMiniKeyboardContainer == null)            
            {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                mMiniKeyboardContainer = inflater.inflate(mPopupLayout, null);
                mMiniKeyboard = (KeyboardView) mMiniKeyboardContainer.findViewById(
                        com.android.internal.R.id.keyboardView);
                View closeButton = mMiniKeyboardContainer.findViewById(
                        com.android.internal.R.id.closeButton);
                if(closeButton != null)                
                closeButton.setOnClickListener(this);
                mMiniKeyboard.setOnKeyboardActionListener(new OnKeyboardActionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.918 -0400", hash_original_method = "4DC39FBB6E00157FF925A9526A44F801", hash_generated_method = "512AD18E3ABCC737275C3960A2D6C681")
        public void onKey(int primaryCode, int[] keyCodes) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(keyCodes[0]);
            addTaint(primaryCode);
            mKeyboardActionListener.onKey(primaryCode, keyCodes);
            dismissPopupKeyboard();
            // ---------- Original Method ----------
            //mKeyboardActionListener.onKey(primaryCode, keyCodes);
            //dismissPopupKeyboard();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.920 -0400", hash_original_method = "C261A15AC7C157668CF84D3274C7BDAE", hash_generated_method = "B0C604F3064D678C93C79CEE4B55BD93")
        public void onText(CharSequence text) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(text.getTaint());
            mKeyboardActionListener.onText(text);
            dismissPopupKeyboard();
            // ---------- Original Method ----------
            //mKeyboardActionListener.onText(text);
            //dismissPopupKeyboard();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.921 -0400", hash_original_method = "A10E1DAC2EDBC7020DC2F7E4D98A3F64", hash_generated_method = "5F976117E69399C87D4A18BFE51CD3C6")
        public void swipeLeft() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.922 -0400", hash_original_method = "39C1073E449F390D664997ABE62AF951", hash_generated_method = "9CFB46C083FF396E413B5AD87FB897D1")
        public void swipeRight() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.923 -0400", hash_original_method = "E518075537708F9E99955A7C3231B70D", hash_generated_method = "96CDAE0D4D8413EF27D65DA19B3BF2F8")
        public void swipeUp() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.924 -0400", hash_original_method = "C6986FC144FCB0133646C59896DFDCFE", hash_generated_method = "D3F84C631847D5CC2999D71BB193BBDF")
        public void swipeDown() {
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.925 -0400", hash_original_method = "CDC5C8E2B3C6CB6317F3DB854344E976", hash_generated_method = "42F7BAE2942516B66103766EB27FD686")
        public void onPress(int primaryCode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(primaryCode);
            mKeyboardActionListener.onPress(primaryCode);
            // ---------- Original Method ----------
            //mKeyboardActionListener.onPress(primaryCode);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.926 -0400", hash_original_method = "304F15517CAA292476FE03D876404274", hash_generated_method = "9ADED263C3456E22D5DB0B67CCB61D31")
        public void onRelease(int primaryCode) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(primaryCode);
            mKeyboardActionListener.onRelease(primaryCode);
            // ---------- Original Method ----------
            //mKeyboardActionListener.onRelease(primaryCode);
        }
});
                Keyboard keyboard;
                if(popupKey.popupCharacters != null)                
                {
                    keyboard = new Keyboard(getContext(), popupKeyboardId, 
                            popupKey.popupCharacters, -1, getPaddingLeft() + getPaddingRight());
                } //End block
                else
                {
                    keyboard = new Keyboard(getContext(), popupKeyboardId);
                } //End block
                mMiniKeyboard.setKeyboard(keyboard);
                mMiniKeyboard.setPopupParent(this);
                mMiniKeyboardContainer.measure(
                        MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.AT_MOST), 
                        MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.AT_MOST));
                mMiniKeyboardCache.put(popupKey, mMiniKeyboardContainer);
            } //End block
            else
            {
                mMiniKeyboard = (KeyboardView) mMiniKeyboardContainer.findViewById(
                        com.android.internal.R.id.keyboardView);
            } //End block
            getLocationInWindow(mCoordinates);
            mPopupX = popupKey.x + mPaddingLeft;
            mPopupY = popupKey.y + mPaddingTop;
            mPopupX = mPopupX + popupKey.width - mMiniKeyboardContainer.getMeasuredWidth();
            mPopupY = mPopupY - mMiniKeyboardContainer.getMeasuredHeight();
            final int x = mPopupX + mMiniKeyboardContainer.getPaddingRight() + mCoordinates[0];
            final int y = mPopupY + mMiniKeyboardContainer.getPaddingBottom() + mCoordinates[1];
            mMiniKeyboard.setPopupOffset(x < 0 ? 0 : x, y);
            mMiniKeyboard.setShifted(isShifted());
            mPopupKeyboard.setContentView(mMiniKeyboardContainer);
            mPopupKeyboard.setWidth(mMiniKeyboardContainer.getMeasuredWidth());
            mPopupKeyboard.setHeight(mMiniKeyboardContainer.getMeasuredHeight());
            mPopupKeyboard.showAtLocation(this, Gravity.NO_GRAVITY, x, y);
            mMiniKeyboardOnScreen = true;
            invalidateAllKeys();
            boolean varB326B5062B2F0E69046810717534CB09_226610792 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121539795 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_121539795;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1254539171 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1263725300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1263725300;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.938 -0400", hash_original_method = "58E4B1A222A0D006A4E4D0141419C090", hash_generated_method = "C7D7E4A272F83F48526E52152A8F0E08")
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        if(mAccessibilityManager.isTouchExplorationEnabled() && event.getPointerCount() == 1)        
        {
            final int action = event.getAction();
switch(action){
            case MotionEvent.ACTION_HOVER_ENTER:
            case MotionEvent.ACTION_HOVER_MOVE:
            final int touchX = (int) event.getX() - mPaddingLeft;
            int touchY = (int) event.getY() - mPaddingTop;
            if(touchY >= -mVerticalCorrection)            
            {
                touchY += mVerticalCorrection;
            } //End block
            final int keyIndex = getKeyIndices(touchX, touchY, null);
            showPreview(keyIndex);
            break;
            case MotionEvent.ACTION_HOVER_EXIT:
            showPreview(NOT_A_KEY);
            break;
}
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_462463025 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179457059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179457059;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.944 -0400", hash_original_method = "4507CAB5EBD3B0A30CFA795E6B0CE2F1", hash_generated_method = "B83D5177D9B513B071BD22ADF0D52F60")
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int pointerCount = me.getPointerCount();
        final int action = me.getAction();
        boolean result = false;
        final long now = me.getEventTime();
        if(pointerCount != mOldPointerCount)        
        {
            if(pointerCount == 1)            
            {
                MotionEvent down = MotionEvent.obtain(now, now, MotionEvent.ACTION_DOWN,
                        me.getX(), me.getY(), me.getMetaState());
                result = onModifiedTouchEvent(down, false);
                down.recycle();
                if(action == MotionEvent.ACTION_UP)                
                {
                    result = onModifiedTouchEvent(me, true);
                } //End block
            } //End block
            else
            {
                MotionEvent up = MotionEvent.obtain(now, now, MotionEvent.ACTION_UP,
                        mOldPointerX, mOldPointerY, me.getMetaState());
                result = onModifiedTouchEvent(up, true);
                up.recycle();
            } //End block
        } //End block
        else
        {
            if(pointerCount == 1)            
            {
                result = onModifiedTouchEvent(me, false);
                mOldPointerX = me.getX();
                mOldPointerY = me.getY();
            } //End block
            else
            {
                result = true;
            } //End block
        } //End block
        mOldPointerCount = pointerCount;
        boolean varB4A88417B3D0170D754C647C30B7216A_2024184013 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896708266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896708266;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.966 -0400", hash_original_method = "9A66FA1609D53EFA58150B8A0FCB8ECB", hash_generated_method = "71A0593054DFE2EFD8625BF60B194E14")
    private boolean onModifiedTouchEvent(MotionEvent me, boolean possiblePoly) {
        int touchX = (int) me.getX() - mPaddingLeft;
        int touchY = (int) me.getY() - mPaddingTop;
        if(touchY >= -mVerticalCorrection)        
        touchY += mVerticalCorrection;
        final int action = me.getAction();
        final long eventTime = me.getEventTime();
        int keyIndex = getKeyIndices(touchX, touchY, null);
        mPossiblePoly = possiblePoly;
        if(action == MotionEvent.ACTION_DOWN)        
        mSwipeTracker.clear();
        mSwipeTracker.addMovement(me);
        if(mAbortKey
                && action != MotionEvent.ACTION_DOWN && action != MotionEvent.ACTION_CANCEL)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1348683350 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325022220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_325022220;
        } //End block
        if(mGestureDetector.onTouchEvent(me))        
        {
            showPreview(NOT_A_KEY);
            mHandler.removeMessages(MSG_REPEAT);
            mHandler.removeMessages(MSG_LONGPRESS);
            boolean varB326B5062B2F0E69046810717534CB09_1463644381 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162366687 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162366687;
        } //End block
        if(mMiniKeyboardOnScreen && action != MotionEvent.ACTION_CANCEL)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_998828779 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118305064 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_118305064;
        } //End block
switch(action){
        case MotionEvent.ACTION_DOWN:
        mAbortKey = false;
        mStartX = touchX;
        mStartY = touchY;
        mLastCodeX = touchX;
        mLastCodeY = touchY;
        mLastKeyTime = 0;
        mCurrentKeyTime = 0;
        mLastKey = NOT_A_KEY;
        mCurrentKey = keyIndex;
        mDownKey = keyIndex;
        mDownTime = me.getEventTime();
        mLastMoveTime = mDownTime;
        checkMultiTap(eventTime, keyIndex);
        mKeyboardActionListener.onPress(keyIndex != NOT_A_KEY ? 
                        mKeys[keyIndex].codes[0] : 0);
        if(mCurrentKey >= 0 && mKeys[mCurrentKey].repeatable)        
        {
            mRepeatKeyIndex = mCurrentKey;
            Message msg = mHandler.obtainMessage(MSG_REPEAT);
            mHandler.sendMessageDelayed(msg, REPEAT_START_DELAY);
            repeatKey();
            if(mAbortKey)            
            {
                mRepeatKeyIndex = NOT_A_KEY;
                break;
            } //End block
        } //End block
        if(mCurrentKey != NOT_A_KEY)        
        {
            Message msg = mHandler.obtainMessage(MSG_LONGPRESS, me);
            mHandler.sendMessageDelayed(msg, LONGPRESS_TIMEOUT);
        } //End block
        showPreview(keyIndex);
        break;
        case MotionEvent.ACTION_MOVE:
        boolean continueLongPress = false;
        if(keyIndex != NOT_A_KEY)        
        {
            if(mCurrentKey == NOT_A_KEY)            
            {
                mCurrentKey = keyIndex;
                mCurrentKeyTime = eventTime - mDownTime;
            } //End block
            else
            {
                if(keyIndex == mCurrentKey)                
                {
                    mCurrentKeyTime += eventTime - mLastMoveTime;
                    continueLongPress = true;
                } //End block
                else
                if(mRepeatKeyIndex == NOT_A_KEY)                
                {
                    resetMultiTap();
                    mLastKey = mCurrentKey;
                    mLastCodeX = mLastX;
                    mLastCodeY = mLastY;
                    mLastKeyTime =
                                    mCurrentKeyTime + eventTime - mLastMoveTime;
                    mCurrentKey = keyIndex;
                    mCurrentKeyTime = 0;
                } //End block
            } //End block
        } //End block
        if(!continueLongPress)        
        {
            mHandler.removeMessages(MSG_LONGPRESS);
            if(keyIndex != NOT_A_KEY)            
            {
                Message msg = mHandler.obtainMessage(MSG_LONGPRESS, me);
                mHandler.sendMessageDelayed(msg, LONGPRESS_TIMEOUT);
            } //End block
        } //End block
        showPreview(mCurrentKey);
        mLastMoveTime = eventTime;
        break;
        case MotionEvent.ACTION_UP:
        removeMessages();
        if(keyIndex == mCurrentKey)        
        {
            mCurrentKeyTime += eventTime - mLastMoveTime;
        } //End block
        else
        {
            resetMultiTap();
            mLastKey = mCurrentKey;
            mLastKeyTime = mCurrentKeyTime + eventTime - mLastMoveTime;
            mCurrentKey = keyIndex;
            mCurrentKeyTime = 0;
        } //End block
        if(mCurrentKeyTime < mLastKeyTime && mCurrentKeyTime < DEBOUNCE_TIME
                        && mLastKey != NOT_A_KEY)        
        {
            mCurrentKey = mLastKey;
            touchX = mLastCodeX;
            touchY = mLastCodeY;
        } //End block
        showPreview(NOT_A_KEY);
        Arrays.fill(mKeyIndices, NOT_A_KEY);
        if(mRepeatKeyIndex == NOT_A_KEY && !mMiniKeyboardOnScreen && !mAbortKey)        
        {
            detectAndSendKey(mCurrentKey, touchX, touchY, eventTime);
        } //End block
        invalidateKey(keyIndex);
        mRepeatKeyIndex = NOT_A_KEY;
        break;
        case MotionEvent.ACTION_CANCEL:
        removeMessages();
        dismissPopupKeyboard();
        mAbortKey = true;
        showPreview(NOT_A_KEY);
        invalidateKey(mCurrentKey);
        break;
}        mLastX = touchX;
        mLastY = touchY;
        boolean varB326B5062B2F0E69046810717534CB09_337065430 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1111970955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1111970955;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.971 -0400", hash_original_method = "1824B07D0D1DC18D1C7F955965AE03DE", hash_generated_method = "1AC2977B02DE860E7FCD6489165C7749")
    private boolean repeatKey() {
        Key key = mKeys[mRepeatKeyIndex];
        detectAndSendKey(mCurrentKey, key.x, key.y, mLastTapTime);
        boolean varB326B5062B2F0E69046810717534CB09_1966199753 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999295098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999295098;
        // ---------- Original Method ----------
        //Key key = mKeys[mRepeatKeyIndex];
        //detectAndSendKey(mCurrentKey, key.x, key.y, mLastTapTime);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.972 -0400", hash_original_method = "E311EE99DFD17FF74F47149470BADF24", hash_generated_method = "C70BB149F257C665B91AC5BA279A8756")
    protected void swipeRight() {
        mKeyboardActionListener.swipeRight();
        // ---------- Original Method ----------
        //mKeyboardActionListener.swipeRight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.973 -0400", hash_original_method = "F06A9E8E8529ED6F027C708A6E561BF3", hash_generated_method = "F8012F525DECDA873C133E697FF87608")
    protected void swipeLeft() {
        mKeyboardActionListener.swipeLeft();
        // ---------- Original Method ----------
        //mKeyboardActionListener.swipeLeft();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.974 -0400", hash_original_method = "B4EE4270465E482F662B868F04086F2D", hash_generated_method = "B8384E6F74BBA9453048C2E8D6BECA81")
    protected void swipeUp() {
        mKeyboardActionListener.swipeUp();
        // ---------- Original Method ----------
        //mKeyboardActionListener.swipeUp();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.974 -0400", hash_original_method = "046102819DD48F6283DB67AFBCA217CC", hash_generated_method = "08C06EF013D5A31989B3238AAE68F51A")
    protected void swipeDown() {
        mKeyboardActionListener.swipeDown();
        // ---------- Original Method ----------
        //mKeyboardActionListener.swipeDown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.976 -0400", hash_original_method = "9B9565973EC4CEC52B4AC42A01803AEB", hash_generated_method = "0D91FD57E088FC766265DFC572EA7131")
    public void closing() {
        if(mPreviewPopup.isShowing())        
        {
            mPreviewPopup.dismiss();
        } //End block
        removeMessages();
        dismissPopupKeyboard();
        mBuffer = null;
        mCanvas = null;
        mMiniKeyboardCache.clear();
        // ---------- Original Method ----------
        //if (mPreviewPopup.isShowing()) {
            //mPreviewPopup.dismiss();
        //}
        //removeMessages();
        //dismissPopupKeyboard();
        //mBuffer = null;
        //mCanvas = null;
        //mMiniKeyboardCache.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.977 -0400", hash_original_method = "661EA634037C92A538704E54EC4A3BC8", hash_generated_method = "0EA65AC3B065DBCA0F9A546F8F02DCAA")
    private void removeMessages() {
        mHandler.removeMessages(MSG_REPEAT);
        mHandler.removeMessages(MSG_LONGPRESS);
        mHandler.removeMessages(MSG_SHOW_PREVIEW);
        // ---------- Original Method ----------
        //mHandler.removeMessages(MSG_REPEAT);
        //mHandler.removeMessages(MSG_LONGPRESS);
        //mHandler.removeMessages(MSG_SHOW_PREVIEW);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.978 -0400", hash_original_method = "A62DD8F04C5EF3B1149CE1914F7FCC79", hash_generated_method = "C5BAEFCB862F1D47F9D253C194640647")
    @Override
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        closing();
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //closing();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.980 -0400", hash_original_method = "37A5173B1277346D2A06873E9E98265E", hash_generated_method = "9496DD948A554A0C105F7D3BD0C0F717")
    private void dismissPopupKeyboard() {
        if(mPopupKeyboard.isShowing())        
        {
            mPopupKeyboard.dismiss();
            mMiniKeyboardOnScreen = false;
            invalidateAllKeys();
        } //End block
        // ---------- Original Method ----------
        //if (mPopupKeyboard.isShowing()) {
            //mPopupKeyboard.dismiss();
            //mMiniKeyboardOnScreen = false;
            //invalidateAllKeys();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.981 -0400", hash_original_method = "A0DF881C3AD902D34564DDF5FF7CBB70", hash_generated_method = "3B41E334BA73F9D02D326EDC3F5296AA")
    public boolean handleBack() {
        if(mPopupKeyboard.isShowing())        
        {
            dismissPopupKeyboard();
            boolean varB326B5062B2F0E69046810717534CB09_284782170 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547003694 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_547003694;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1348498934 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510316045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510316045;
        // ---------- Original Method ----------
        //if (mPopupKeyboard.isShowing()) {
            //dismissPopupKeyboard();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.984 -0400", hash_original_method = "B7FA68F3C9665AB1B34A8D3EB9A4B77C", hash_generated_method = "EAD2309AFEC83CE70B5554355405C08B")
    private void resetMultiTap() {
        mLastSentIndex = NOT_A_KEY;
        mTapCount = 0;
        mLastTapTime = -1;
        mInMultiTap = false;
        // ---------- Original Method ----------
        //mLastSentIndex = NOT_A_KEY;
        //mTapCount = 0;
        //mLastTapTime = -1;
        //mInMultiTap = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.987 -0400", hash_original_method = "E40865BB0F35C5555FD5AC7537827099", hash_generated_method = "C9B452B942C387ED0EA6B017A3DE7459")
    private void checkMultiTap(long eventTime, int keyIndex) {
        addTaint(keyIndex);
        addTaint(eventTime);
        if(keyIndex == NOT_A_KEY)        
        return;
        Key key = mKeys[keyIndex];
        if(key.codes.length > 1)        
        {
            mInMultiTap = true;
            if(eventTime < mLastTapTime + MULTITAP_INTERVAL
                    && keyIndex == mLastSentIndex)            
            {
                mTapCount = (mTapCount + 1) % key.codes.length;
                return;
            } //End block
            else
            {
                mTapCount = -1;
                return;
            } //End block
        } //End block
        if(eventTime > mLastTapTime + MULTITAP_INTERVAL || keyIndex != mLastSentIndex)        
        {
            resetMultiTap();
        } //End block
        // ---------- Original Method ----------
        //if (keyIndex == NOT_A_KEY) return;
        //Key key = mKeys[keyIndex];
        //if (key.codes.length > 1) {
            //mInMultiTap = true;
            //if (eventTime < mLastTapTime + MULTITAP_INTERVAL
                    //&& keyIndex == mLastSentIndex) {
                //mTapCount = (mTapCount + 1) % key.codes.length;
                //return;
            //} else {
                //mTapCount = -1;
                //return;
            //}
        //}
        //if (eventTime > mLastTapTime + MULTITAP_INTERVAL || keyIndex != mLastSentIndex) {
            //resetMultiTap();
        //}
    }

    
    private static class SwipeTracker {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.989 -0400", hash_original_field = "8E2320838462AAF0B979C70F2E4730CE", hash_generated_field = "15EA52766B855930F76C72872830E734")

        final float mPastX[] = new float[NUM_PAST];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.989 -0400", hash_original_field = "0B9F3428A6762603AA7102CEC847ED75", hash_generated_field = "BAB3ACAD586B09B7E94BF8FA0B136C4E")

        final float mPastY[] = new float[NUM_PAST];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.990 -0400", hash_original_field = "591DFA19D2FB9E00BC701DE6826F8FC1", hash_generated_field = "C3712A7D74905C41E41754E5D41A1F84")

        final long mPastTime[] = new long[NUM_PAST];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.990 -0400", hash_original_field = "BC25413923BE9DD3356C08F88CF628DC", hash_generated_field = "5EB56D88536BDA960D4199A6AC605CCE")

        float mYVelocity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.990 -0400", hash_original_field = "57D4948CA406D75DAFBA90C0882083E1", hash_generated_field = "B38185C454827C70D05A324CEFDAB708")

        float mXVelocity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.991 -0400", hash_original_method = "B4C366B58C868F9BC83E6F215F55A14E", hash_generated_method = "B4C366B58C868F9BC83E6F215F55A14E")
        public SwipeTracker ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.992 -0400", hash_original_method = "53CB847D3AF872A20B25A4493987B7C1", hash_generated_method = "360FC756F6122E290B4EC178C9185CA5")
        public void clear() {
            mPastTime[0] = 0;
            // ---------- Original Method ----------
            //mPastTime[0] = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.993 -0400", hash_original_method = "6761B86D824AFFDB272486FC738A5AFC", hash_generated_method = "5CB9A511718E9DE42873FD7C65718539")
        public void addMovement(MotionEvent ev) {
            addTaint(ev.getTaint());
            long time = ev.getEventTime();
            final int N = ev.getHistorySize();
for(int i=0;i<N;i++)
            {
                addPoint(ev.getHistoricalX(i), ev.getHistoricalY(i),
                        ev.getHistoricalEventTime(i));
            } //End block
            addPoint(ev.getX(), ev.getY(), time);
            // ---------- Original Method ----------
            //long time = ev.getEventTime();
            //final int N = ev.getHistorySize();
            //for (int i=0; i<N; i++) {
                //addPoint(ev.getHistoricalX(i), ev.getHistoricalY(i),
                        //ev.getHistoricalEventTime(i));
            //}
            //addPoint(ev.getX(), ev.getY(), time);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:44.998 -0400", hash_original_method = "10CA611D62B6CE89EF867344E70F5656", hash_generated_method = "A18366D5D589C3688BDF46FD62468511")
        private void addPoint(float x, float y, long time) {
            addTaint(time);
            addTaint(y);
            addTaint(x);
            int drop = -1;
            int i;
            final long[] pastTime = mPastTime;
for(i=0;i<NUM_PAST;i++)
            {
                if(pastTime[i] == 0)                
                {
                    break;
                } //End block
                else
                if(pastTime[i] < time-LONGEST_PAST_TIME)                
                {
                    drop = i;
                } //End block
            } //End block
            if(i == NUM_PAST && drop < 0)            
            {
                drop = 0;
            } //End block
            if(drop == i)            
            drop--;
            final float[] pastX = mPastX;
            final float[] pastY = mPastY;
            if(drop >= 0)            
            {
                final int start = drop+1;
                final int count = NUM_PAST-drop-1;
                System.arraycopy(pastX, start, pastX, 0, count);
                System.arraycopy(pastY, start, pastY, 0, count);
                System.arraycopy(pastTime, start, pastTime, 0, count);
                i -= (drop+1);
            } //End block
            pastX[i] = x;
            pastY[i] = y;
            pastTime[i] = time;
            i++;
            if(i < NUM_PAST)            
            {
                pastTime[i] = 0;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.000 -0400", hash_original_method = "7AE3C8D32C98F8CD6F4600C66E9D240E", hash_generated_method = "0B65994CCFD349DB937547C3EC7594E2")
        public void computeCurrentVelocity(int units) {
            addTaint(units);
            computeCurrentVelocity(units, Float.MAX_VALUE);
            // ---------- Original Method ----------
            //computeCurrentVelocity(units, Float.MAX_VALUE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.006 -0400", hash_original_method = "8F744F2FA9C814B5018077599CE9EBAA", hash_generated_method = "6DB1C69B43D24DC90DC3C0FDDE9A16D0")
        public void computeCurrentVelocity(int units, float maxVelocity) {
            addTaint(units);
            final float[] pastX = mPastX;
            final float[] pastY = mPastY;
            final long[] pastTime = mPastTime;
            final float oldestX = pastX[0];
            final float oldestY = pastY[0];
            final long oldestTime = pastTime[0];
            float accumX = 0;
            float accumY = 0;
            int N = 0;
            while
(N < NUM_PAST)            
            {
                if(pastTime[N] == 0)                
                {
                    break;
                } //End block
                N++;
            } //End block
for(int i=1;i < N;i++)
            {
                final int dur = (int)(pastTime[i] - oldestTime);
                if(dur == 0)                
                continue;
                float dist = pastX[i] - oldestX;
                float vel = (dist/dur) * units;
                if(accumX == 0)                
                accumX = vel;
                else
                accumX = (accumX + vel) * .5f;
                dist = pastY[i] - oldestY;
                vel = (dist/dur) * units;
                if(accumY == 0)                
                accumY = vel;
                else
                accumY = (accumY + vel) * .5f;
            } //End block
            mXVelocity = accumX < 0.0f ? Math.max(accumX, -maxVelocity)
                    : Math.min(accumX, maxVelocity);
            mYVelocity = accumY < 0.0f ? Math.max(accumY, -maxVelocity)
                    : Math.min(accumY, maxVelocity);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.008 -0400", hash_original_method = "2F66357DD043F67D50DC8377A1F70BC4", hash_generated_method = "1325127EBC5B4B50FA70009334932821")
        public float getXVelocity() {
            float var57D4948CA406D75DAFBA90C0882083E1_388183928 = (mXVelocity);
                        float var546ADE640B6EDFBC8A086EF31347E768_1845402739 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1845402739;
            // ---------- Original Method ----------
            //return mXVelocity;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.010 -0400", hash_original_method = "73AA3D89DA3C408C7388B69E1FFC2A00", hash_generated_method = "70DDD5D7FABDFC2C4F1B92D8245EF258")
        public float getYVelocity() {
            float varBC25413923BE9DD3356C08F88CF628DC_2109502741 = (mYVelocity);
                        float var546ADE640B6EDFBC8A086EF31347E768_689591089 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_689591089;
            // ---------- Original Method ----------
            //return mYVelocity;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.010 -0400", hash_original_field = "E87B2955D3D2D729117CD4417214288A", hash_generated_field = "13CDE29C1460BF3EB0746B2A1E98B45B")

        static final int NUM_PAST = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.011 -0400", hash_original_field = "A50DA651CD55A97D7972F4E0968CF92A", hash_generated_field = "053E4777D78E2D9F5CF0B5522EEF094E")

        static final int LONGEST_PAST_TIME = 200;
    }


    
    public interface OnKeyboardActionListener {
        
        
        void onPress(int primaryCode);
        
        
        void onRelease(int primaryCode);

        
        void onKey(int primaryCode, int[] keyCodes);

        
        void onText(CharSequence text);
        
        
        void swipeLeft();
        
        
        void swipeRight();
        
        
        void swipeDown();
        
        
        void swipeUp();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.011 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.012 -0400", hash_original_field = "1715C8FDA600332C9FA488105DF0AC66", hash_generated_field = "BAEF4E1A9136B0B32BDD7D9A19447275")

    private static final int NOT_A_KEY = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.012 -0400", hash_original_field = "162581E5474D929ABD013544EA4DDEBD", hash_generated_field = "98328F0FBE5E36A2FCC1467CA055B74C")

    private static final int[] KEY_DELETE = { Keyboard.KEYCODE_DELETE };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.013 -0400", hash_original_field = "75E12692B1EA757EBB59139363482DED", hash_generated_field = "8AD3C47D60E3B96560584400A9EB6DCD")

    private static final int[] LONG_PRESSABLE_STATE_SET = { R.attr.state_long_pressable };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.013 -0400", hash_original_field = "BAF957CE49EE6C69D2B374E8D95E1BE1", hash_generated_field = "3D8E411A95F9BAAF27D04D85B3FF0438")

    private static final int MSG_SHOW_PREVIEW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.013 -0400", hash_original_field = "8C985E02DCB43ED2C83A4E206371704C", hash_generated_field = "BF50CFC29DC574EC42F212697E6E2559")

    private static final int MSG_REMOVE_PREVIEW = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.014 -0400", hash_original_field = "612DCFBDAA756F5F4B9707C8FCE4823A", hash_generated_field = "24DEB3A2BAA586AB57AC0053CA01363E")

    private static final int MSG_REPEAT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.014 -0400", hash_original_field = "0D75F332CCD0E863F596AC60C38FB0A4", hash_generated_field = "8A80B2155449A731A2F3D46618529E44")

    private static final int MSG_LONGPRESS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.015 -0400", hash_original_field = "496BBD783008A14FF04E0C2D49CE5732", hash_generated_field = "0A30DF52D843CD8376CF99575C6D7852")

    private static final int DELAY_BEFORE_PREVIEW = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.015 -0400", hash_original_field = "6C978BD11C47DF5B0F91E9B7AC7846BB", hash_generated_field = "9DC344FDCBF884390D802EFC3B902BEA")

    private static final int DELAY_AFTER_PREVIEW = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.016 -0400", hash_original_field = "E098CDC145C55CD199250288D97218B2", hash_generated_field = "5997B1305C377661E4F0280A3EED9CF0")

    private static final int DEBOUNCE_TIME = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.016 -0400", hash_original_field = "EDE4C95AD912841CEC3BD336FA54BA21", hash_generated_field = "EBF0B8189EF4FD2AAD08628A9A1EDCD4")

    private static final int REPEAT_INTERVAL = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.017 -0400", hash_original_field = "A589A2B680277A645540B025BB6AC196", hash_generated_field = "2E97753E3A29F6B90D01289698F52116")

    private static final int REPEAT_START_DELAY = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.017 -0400", hash_original_field = "03946F945DD14FD038A89AC23E3E9895", hash_generated_field = "A0C74D07DE33813B70581123FF749A35")

    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.017 -0400", hash_original_field = "630E97CC17DD960C09EFD3DB8828A47F", hash_generated_field = "64B9E16E32AEE498AF04FE4CCECFE27E")

    private static int MAX_NEARBY_KEYS = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-10-28 20:33:45.018 -0400", hash_original_field = "7CB57BEBE78B980AF6534C0241C6D665", hash_generated_field = "0EFFE6923F255038687B7F227BFDC6E8")

    private static final int MULTITAP_INTERVAL = 800;
}

