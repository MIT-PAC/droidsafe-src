package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.annotation.Widget;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Proxy;
import android.net.ProxyProperties;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.util.AttributeSet;
import android.util.EventLog;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.HardwareCanvas;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebTextView.AutoCompleteAdapter;
import android.webkit.WebViewCore.DrawData;
import android.webkit.WebViewCore.EventHub;
import android.webkit.WebViewCore.TouchEventData;
import android.webkit.WebViewCore.TouchHighlightData;
import android.widget.AbsoluteLayout;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.OverScroller;
import android.widget.Toast;
import junit.framework.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import static javax.microedition.khronos.egl.EGL10.*;

public class WebView extends AbsoluteLayout implements ViewTreeObserver.OnGlobalFocusChangeListener, ViewGroup.OnHierarchyChangeListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "F9F7A5E45113174158FDC3089D6C6283", hash_generated_field = "6CC6F5C62728D3C43873C2A6A3501E11")

    private InnerGlobalLayoutListener mGlobalLayoutListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "0E0493252E026C6EA3F70ED0CEA041F3", hash_generated_field = "FD3918832A54C40DD17CB93DF3C9E96F")

    private InnerScrollChangedListener mScrollChangedListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "283494DD2489884EBB23EB11D733BBAA", hash_generated_field = "AD74579540B42D36D4D6B2635A693432")

    private boolean mAutoRedraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "631EA221F424C96FC79D8EF82B96482B", hash_generated_field = "7D5C951A42871D1563A5277A77D69AA0")

    private AlertDialog mListBoxDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.326 -0400", hash_original_field = "1DCBF34BD649218E7E7E803AE2E625E3", hash_generated_field = "3814D5F998B935779FE7312845980E33")

    private Rect mGLRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "7884AA5B33C53128E178BF578BDB1C5A", hash_generated_field = "45B9392D3B777549E12DB3B5CC7CCFB0")

    private Rect mViewRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "6E968EC3CE4F44C293C8CC1068A55218", hash_generated_field = "C92D6FBB3DDC767AAE7AB89773B57609")

    private RectF mVisibleContentRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "58BC8D59DE819547D473EF71E61BA24F", hash_generated_field = "6BED6DB5622AA2BCDA57E6A48F00385A")

    private boolean mGLViewportEmpty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "1229A917B4D1D7ED185029644D045D14", hash_generated_field = "B46B2FBDC77E7FD9B4E8141E1595B5DC")

    private SslCertificate mCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "CAA038815C3D0F5CB3961BAB79010E61", hash_generated_field = "2BD5B1AE4AB832378640307848134713")

    private int mNativeClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "81AD246FEEE7A484C6193AF867C6EF00", hash_generated_field = "F1FD27CC75E819B7519464DBAA075663")

    Handler mPrivateHandler = new PrivateHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "F87E097FF47BA15D994C901A5A6D99A5", hash_generated_field = "AFC642D7CC3CCD87E0FAB3BD2F752688")

    private WebTextView mWebTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "9456149C71095D688A9DAD35901D5775", hash_generated_field = "CE8894D1C6FD3CAD90CF4E2DA3FDFD51")

    private int mTextGeneration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "E0A5EC485E1AB1339DCAF115AA8CA6AB", hash_generated_field = "998C24A93F5A243548630A07FBEEBABF")

    ViewManager mViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "8736C5FCC696BB24A7172AFF742B5642", hash_generated_field = "E9614F2B38AB4DEABFFB87F7486CC59B")

    PluginFullScreenHolder mFullScreenHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "86DEF530EB8B5EC2AE73B42C569FD23E", hash_generated_field = "BD4968058047E8092403B263696B6E7C")

    private int mLastTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "39477E387A7C3E4961468DBE4905BD45", hash_generated_field = "69A36CEAFC0963888AC8B4ED2F6D4978")

    private int mLastTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "3EBA7D9209AD375AB705928FB27FBC2B", hash_generated_field = "4D8D56CD18597A03E84AFA3541D74E0F")

    private int mStartTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "B83D230CA90AA46F0C6A30E0AAC3CB3B", hash_generated_field = "CEF59ED5F74695F1C489B12BA9877E2B")

    private int mStartTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "1CD1134B2ECCABF83DF9A5F9EF7AD3D9", hash_generated_field = "5C401664BB9D608028617F5EDF66E2AF")

    private float mAverageAngle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "97232569F8A97636E52CBF699FA36058", hash_generated_field = "47C433080713997997212745A4983F8F")

    private long mLastTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "BEE1113C77861A2600AB5722E55AA68B", hash_generated_field = "0990A940DEEA6D528A067E6EA87B7F9C")

    private long mLastSentTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "F6A36EBCCDACC91845D214DEBFD2393F", hash_generated_field = "561D6233D1FB6E93F053BC05FD8FA507")

    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "507D8F8387EDC230B54D84A5AD8E5830")

    VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "91DDB870C2F2A4ADB7E5CD21262D80AB", hash_generated_field = "F4AD22AFC08761D5F541EC696D9C09FE")

    private int mMaximumFling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "2576CD7ADC881F56890EF9B827984445", hash_generated_field = "36A6D141DB1FFF457C16610ED5D633AD")

    private float mLastVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "38861757C9935B722CDBC8FAA59326C8", hash_generated_field = "C0F88FE2C7B9E7C7BB7B21BE6A587FCF")

    private float mLastVelX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "A7C0A582CF6C6FEDA681D202ABEFCD38", hash_generated_field = "28065D974B22FD4A98645752CE5547CF")

    private float mLastVelY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.327 -0400", hash_original_field = "91572FA34BDD6F68B726B50C83FB5238", hash_generated_field = "607EC8CFE97408F4374FF8F7ACABB92F")

    private int mCurrentScrollingLayerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "2A1146D1F64188A252C8E3346E729DDB", hash_generated_field = "2C565358915D9304934306126B23D037")

    private Rect mScrollingLayerRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "461524481BA85E1763B9C327D56C2779", hash_generated_field = "066849BFFA66413DA55C64140E71033C")

    private int mTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "B48B34463BD947BC8FA39E87FA3940DF", hash_generated_field = "A09D145690CCE7A19F079502BA967C9A")

    private boolean mForwardTouchEvents = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "DF19140A515EFFD1E2B2BC58874945B7", hash_generated_field = "E1D1C001302DE5375C735E7EF10D1D17")

    private int mPreventDefault = PREVENT_DEFAULT_IGNORE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "00424BCD47A1D1F32C7A4DCCF85229CA", hash_generated_field = "7A19B98B2EFB8BB31AEC747F1CA41B97")

    private boolean mConfirmMove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "00B4977EA0CCB7CE00BDFAF3F868B20F", hash_generated_field = "BFA5428ED65131EF1CA223DF188A1122")

    private boolean mDeferTouchProcess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "B054F7035076C1AC0991A455B3154B5A", hash_generated_field = "9F890F647D029D28EDDE18F99565D3EC")

    private int mDeferTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "5D2AA10D50C57E3B997C5B872BD919DA", hash_generated_field = "0B464B8324C284C9331034B27020C3DF")

    private float mLastDeferTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "FE45999F6371D9229F7127CEE75A1CE3", hash_generated_field = "BB913DF57D5D59E382435C22DB0D167C")

    private float mLastDeferTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "733138DD0E6826F705B37E7B22FD49C1", hash_generated_field = "1AAAA5D187A798CA7E8F507E98CEFDFE")

    boolean mDragFromTextInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "DAD3A38A52F21026BBC341FAA256F725", hash_generated_field = "73F680AEDB48E6ACAF7DB5B88D2B7A20")

    private boolean mDrawCursorRing = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "E5E0AF0CF7EBA0195F7043E5E0A523EC", hash_generated_field = "4940A67E026325EBC1382989DD930EDC")

    private boolean mIsPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "319A7C3B614BC1472DF37FFF84145BC0", hash_generated_field = "9F291EA33B1111436C86DAFA7D749E10")

    private HitTestResult mInitialHitTestResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "1E242EFC2D09358FD71C3C1F7213838B", hash_generated_field = "3648C260E562DC86BDAAC7F94E7352D4")

    private int mNavSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "73C5E2D5ECE0EA511A9594C461C19390", hash_generated_field = "B290C2276932B172EE2AB0CAFBE30BAE")

    boolean mWidthCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "D476D4A439B1ACBFD02CFE299CF64FB4", hash_generated_field = "61DC23F447FF0AD3EC3A81B971B9006E")

    boolean mHeightCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "B7A225A89985C2F4AD49415356B283C2", hash_generated_field = "0A23B55D1A7DFF5E5D35E13264ADE9DE")

    int mLastWidthSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "5C861C15724C8416BEC6F0FCF23FE8C7", hash_generated_field = "DC0C48A78A79993E34C7065A16800A42")

    int mLastHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "95E3B6E798315DEF186341A6887424F3", hash_generated_field = "03CB436788BF47F35B484535A1648867")

    int mLastActualHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.328 -0400", hash_original_field = "8CAE9DDC87DDEC99A752E150A6F5EE2F", hash_generated_field = "5F8C94CB44AF6FE0EF7A765D1E3AFD13")

    private int mContentWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.336 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.336 -0400", hash_original_field = "1E54F53AE3E1C8B8A15A951BCE77B126", hash_generated_field = "9218818BF270D645A91FA187FE0DB745")

    private boolean mOverlayHorizontalScrollbar = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.336 -0400", hash_original_field = "CD5EA9067C416EBE91DDE5675BE3BA1B", hash_generated_field = "C373EF1100F74B3BFFFB5DEE30CCBD07")

    private boolean mOverlayVerticalScrollbar = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "63F6CA74EEC786DAEE7A49BF47815C33")

    OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "E56E9228A5AACA55E31613E7D75FBAC2", hash_generated_field = "3C483E4AA361608032CA95612E8DD525")

    private boolean mInOverScrollMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "7B0FA1257BD698096D1B4055A23524FB", hash_generated_field = "DC1AD28F6DE5AE5C8271D33DC8A73FB4")

    private boolean mWrapContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "2CD2F011886EB329722C01D53AAD1158", hash_generated_field = "9FDC3D0BB72A7D1D7962780902257BB3")

    private int mHeldMotionless;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "501651D2D9CDF82EB68647AFA394001A", hash_generated_field = "0EF707A46ED94117316BA91515555C35")

    private AccessibilityInjector mAccessibilityInjector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "9B2A884FD52D291BA7C8707BFD34EE95", hash_generated_field = "8427EB0277906CD3E949E13293EBEFB6")

    private boolean mAccessibilityScriptInjected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "2B2A7D23B49A9F6C312AFA3CB2DE3E9C", hash_generated_field = "61AC3E065C8F6175E76224FE4B7A0FF2")

    private Region mTextSelectionRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "4B4DC0386BBEFEBC172968A7DC512309", hash_generated_field = "BD311CF93A193EF9001A97A5DA8FE989")

    private Paint mTextSelectionPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "F005B92875383CAF2D0DB91BD5A06195", hash_generated_field = "19F67E28C78216AF79F5581C6BC23DEC")

    private Region mTouchHighlightRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "1CD5876DA908B551FE7B696524AAF1CE", hash_generated_field = "FA05D517E862A9B2474EE135EA332D18")

    private Paint mTouchHightlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "621C5AE5845066BF4D6199BCBECC6B1D", hash_generated_field = "CCDC3EB9EBCFF4D16ABA2CE80EB3455A")

    private Paint mTouchCrossHairColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "FA58B09EC58295EE657C6DB007ACFBC3", hash_generated_field = "1735D38F75F52C24227B746378768B7B")

    private int mTouchHighlightX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "0382BD0FE846CC0A70AF1041656AB97E", hash_generated_field = "44E768B9D358A889E8F0FC8017DD211E")

    private int mTouchHighlightY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "759C5A16C191C0BE465C99BF80A22070", hash_generated_field = "BCDAE3999FBCFDE5BC7A1BE619AB74DD")

    private long mTouchHighlightRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "DD91CBEAFCEF912983FE3661E07D2F39", hash_generated_field = "B9D740536C60C6D670F313EEADBF93E0")

    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "96860C09A1BA3099AD8D1DF6F1CBC12B", hash_generated_field = "D395AA199126908FEE3B0F46BA4F9C62")

    private boolean mBlockWebkitViewMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "17569E5D7AFEAF1F09675CAFEE70AC45", hash_generated_field = "0E203AC987BF40A8DEA081542906FFB5")

    private int mInitialScaleInPercent = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "96C56F8983B9F3C60DFD313C8334C7F2", hash_generated_field = "C15F1FC7F9EA7829C177678DC8510856")

    private boolean mSendScrollEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "C33D97725BC57DA6085707EA571DC635", hash_generated_field = "006CA1330A69406C602E466B10C43D72")

    private int mSnapScrollMode = SNAP_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "3E6B71038C2F931B40871ADC21100E0A", hash_generated_field = "761337948FA4302FD3F9FCADBD7D6775")

    private boolean mSnapPositive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.337 -0400", hash_original_field = "6A001518D701D6CB7B53ADEF55E3DE3F", hash_generated_field = "E5F7424044C4D04F0D77F776582A67ED")

    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "82FBFD1714C191943520823A75AEA1E2", hash_generated_field = "4A97F423DAA345C75890FCC344743D6F")

    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "4CDBB0B2FA9CF742D95CBF19A618E45C", hash_generated_field = "4036B77E67867608087C8B2F001B55D5")

    private TextToSpeech mTextToSpeech;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "BD6DEF1112239E4FD783977C03835AC3", hash_generated_field = "1642D7423FB15C64A4AAEE8A9C5243AD")

    private Pattern mMatchAxsUrlParameterPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "12FFA59C64ABCA100CADAD14F3FD0971", hash_generated_field = "8B88748678D320254190188B25A37155")

    private OverScrollGlow mOverScrollGlow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "253CDCFA3EDA8CD5A1C74364F08744EB", hash_generated_field = "6DAF40C63FBB9494FA268E54C51A621E")

    private Vector<Integer> mKeysPressed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "9A53CADB33F5EF303A655D0610777BC3", hash_generated_field = "5D52BE334296C573389C0CB6810E8EF8")

    private long mLastTouchUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "1AF983C29060F075D25F478B9AD3B9FF", hash_generated_field = "EF5F7F128924D81624F7C082EE5C57AB")

    private WebViewCore.AutoFillData mAutoFillData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "1CDAE4CD4FD9DD53B530C97864727050", hash_generated_field = "72384577DFC3FC75A8B033CE6FF0A482")

    private int mBackgroundColor = Color.WHITE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "1E1680EF469A58DE61BC02D7AFF61B2E", hash_generated_field = "ABB6666AC59D2544A6D12F224E33C262")

    private int mAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "270BCD801986623A11031595AB527ABF", hash_generated_field = "A4B68D036567B21BC4865DE6F61A2F9B")

    private int mAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "02BDCA068C258B2AE7788247D564611A", hash_generated_field = "D6CD5D682502282E9E072F16ACF14D05")

    private int mMinAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "641BB905CC99A501F0B0F8356763995C", hash_generated_field = "DC36203DB61C91E1CACF31ED43B3363B")

    private int mMaxAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "25F76E58B1DE86A232329EAD37D8C757", hash_generated_field = "57F79EF124C5DBD88EF9E9E66F10A308")

    private int mMinAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "691CA821B0A61C2E346F0E8E6011C386", hash_generated_field = "CE9836AC2A30ED3AE38A49B2B5FD58DC")

    private int mMaxAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "0FAB21F904D8725647FA51D825321CFE", hash_generated_field = "C04A6808A8A8B578AE175BC815BEE12B")

    private Rect mScrollingLayerBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "17862449FB2B442EDC276FAB4B340E0E", hash_generated_field = "D0A94ECA1348E1AFEFD396947BC74CA0")

    private boolean mSentAutoScrollMessage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "51E582AA9ED1103B99D1859ED86F2854", hash_generated_field = "5796C2C2882E1F8C78F3A034FC3ED80F")

    private TouchEventQueue mTouchEventQueue = new TouchEventQueue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "FC1A1C2CFC7559351BA0746CF8CD1A87", hash_generated_field = "333D865FCED73682C738B5A705E887AA")

    private boolean mPictureUpdatePausedForFocusChange = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "5F766E69223CE3A2DD6353FDB4DA4646", hash_generated_field = "4A0FE46DD2984BED2A76807E9415B4B3")

    private PictureListener mPictureListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "E18B289B1AA9BF6AD41D419FE01ECF5C", hash_generated_field = "4EFDB68AF38CE1FE479B1628CB5C7FFE")

    private int mCachedOverlappingActionModeHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "786E4D2F6EFE89D31565DA0FBE9E6BFF", hash_generated_field = "3E16AF791F0C585BB692C30369E75608")

    private View mTitleBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "8A19A8B2E6CC6A8D99F96047D8675D0D", hash_generated_field = "82DF3ED5B282B44B1689BB6A67100AAF")

    private int mTitleGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "A522C70E18CD127AD691E6C09162B718", hash_generated_field = "CC333D0F8AD8FFDB25F1E8D239DE82EF")

    private Rect mLastVisibleRectSent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.338 -0400", hash_original_field = "87BDD77C765BA4E430F3B4163B2BF16A", hash_generated_field = "9D8EB240679F63D7259D12AA2646AE20")

    private Rect mLastGlobalRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "C986798C734C496FF0C3E00A9F0B3B1C", hash_generated_field = "DBEA6A01B6683DAB3422424D4E5AF629")

    private Rect mVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "67FC07F6472A7CF0FC43C91CA1D4DE06", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "89FE35C70477102B77E7D54111929F5B", hash_generated_field = "F65CE097DE2BD38B5640202605D44DCF")

    private Point mScrollOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "182F4E4C854FDC192EE5021ED6D73891", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "C4180242D5623216D09A451DBE43E063", hash_generated_field = "E9C8FCC78A563BE608DAE1158D0138F1")

    private Rect mContentVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "199407FA51469180784ACB4D27639417", hash_generated_field = "18201BE28AF4897CDDE04B91A8BAC40D")

    private FindActionModeCallback mFindCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "F1DB086181F0CAC01A724E5F6A7B01A7", hash_generated_field = "339E62FC94CB6B24EC49EE818A39B374")

    private boolean mFindIsUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.350 -0400", hash_original_field = "97CF19FB685E1A8A858ED964EA1788D6", hash_generated_field = "B9830F0B5F0F8F825605A44BD1F53A5D")

    private String mLastFind;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "89EE3BF752EA23CCAF0158617873F303", hash_generated_field = "11CC91033432A6D33F6833384C84316E")

    private String mPageThatNeedsToSlideTitleBarOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "7901B46F62AE2A39929FC7686BE3652E", hash_generated_field = "39C14D863975598F1C60036A4E9EC22E")

    private int mYDistanceToSlideTitleOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "981019EBE62A3A536D4CB6BC9F6F8F10", hash_generated_field = "A47FD3369D923B9B9858ECC0900495AB")

    private int mOrientation = Configuration.ORIENTATION_UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "0BC67DE7618E378A590238F274E662F1", hash_generated_field = "CFB51504048F92C552B87D79FF631083")

    private SelectActionModeCallback mSelectCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "F23C74FF3A4CFCDCF12548440968300D", hash_generated_field = "90E44F77594CC0840E573E38FC952FFA")

    private DrawFilter mZoomFilter = new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "7FCBABA887C1AA6F4DB8B724B4D064B7", hash_generated_field = "A6A584467284B8F74D3C2E18A620E79C")

    private DrawFilter mScrollFilter = new PaintFlagsDrawFilter(SCROLL_BITS, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "F3965BD9CE5BD1D03F6F6203AE992A4E", hash_generated_field = "51BC097A03E0230FE4DFAD304AA0C022")

    private boolean mDrawHistory = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "A3DEC6AFE03B45A019E4379B3CC37DA6", hash_generated_field = "E6AB03F308839A8ED10716B0A06579B2")

    private Picture mHistoryPicture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "FCAA8D38A90DCCE574CDD58B10BDC3DE", hash_generated_field = "0C64A62751DA7E49704757557E14D916")

    private int mHistoryWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "DE2C97D507C51A2C10B04B06C4A0520E", hash_generated_field = "75F48CB3330D09CEFA904F7B84BDA417")

    private int mHistoryHeight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "683052C48052D547F9C4DC5445DC348E", hash_generated_field = "7C2550436BC0D9C9C62992FF098D00A6")

    private boolean mGotCenterDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "2BCFC118E8C010852ED640AC6552D75C", hash_generated_field = "4552704BCBDED6171FFAB0743A94FADB")

    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "A5876C56A233FC714E9E635000FC8324", hash_generated_field = "C1BDD4A6558DC5330CEE7B5578017A71")

    private long mTrackballFirstTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "4F199D2B7F6B6927B5DB55656A242B98", hash_generated_field = "7A8E9CA6466F4282ADE2CFEAB9543F99")

    private long mTrackballLastTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "6293B146FD282AC72DBA2F0AB6B0AC97", hash_generated_field = "D0AAD41F7AF21E3C814A3CE6751CC65E")

    private float mTrackballRemainsX = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "B2F0B8878F51B0E28A6BEF74822FA868", hash_generated_field = "43DEE62CF8478127489DCB48CC70FD45")

    private float mTrackballRemainsY = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "C7D88DC101403CC24F4E91CFBF164519", hash_generated_field = "7912151F282E7C954771498A3F49BAA2")

    private int mTrackballXMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "03A8324A1166DF2061C66FA4F1B4B614", hash_generated_field = "E884F524A10E52504DC2311DBDFD6B80")

    private int mTrackballYMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "B5FAF4AB270D8A7A37D27E98B4B0DA18", hash_generated_field = "17DE07DD7201E373F3679F7C8E42D936")

    private boolean mSelectingText = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "5CF44BCD23C9689722F24A78A3607960", hash_generated_field = "E66D148FB016EBE0AB6A510827B8EDE8")

    private boolean mSelectionStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "2DC721FB7A3355375D94983913C44B71", hash_generated_field = "A0828D99C4C5AD1E7FE83A66318FB99D")

    private boolean mExtendSelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "66CA05FE0F91FDFE03B5D50C0A49D303", hash_generated_field = "2908E3A71D3F7575EE5D63922F38ADEA")

    private boolean mDrawSelectionPointer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "FCD57EA55C1642A2C24E20C0B62317F7", hash_generated_field = "DF8E0D848DB8117787785920A7B48359")

    private int mSelectX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.351 -0400", hash_original_field = "9915E013A84779B49E4428F98E4F07FE", hash_generated_field = "FE7922D4E6B26989A17C6608E2D41B9A")

    private int mSelectY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "4CDBF52C30D68AEC1295EF779063DEAE", hash_generated_field = "F7FF545538C9AFAAB77E510B3626B30E")

    private boolean mFocusSizeChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "BDBAF306CE7923A2CD4FBC04A8D8990B", hash_generated_field = "9FA6435FA400DA07C2707641944C195D")

    private boolean mTrackballDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "15CB522E76D287D5578A77504CB5F3BF", hash_generated_field = "7F383DE2FB2467193D38739089AE9AA7")

    private long mTrackballUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "02AA2026C10F3BF98FC17F7FD0E5857A", hash_generated_field = "36CFD91777BA610BB27907D3ED4B1532")

    private long mLastCursorTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "E56966E13D19AF45D41D8A9B8A5BB828", hash_generated_field = "628DA4E196378CFBF1F4C373208CA500")

    private Rect mLastCursorBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "4CAE411D150BF4CB8D1C810C5FF6BB7E", hash_generated_field = "448727DCE5669EFD2A0C0572D1060E63")

    private boolean mMapTrackballToArrowKeys = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "105553D6B610F07A7928FCC8D847A035", hash_generated_field = "AD498406B1DE6FEBF53F73747731D143")

    private DrawData mDelaySetPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "AA72F0DA830E064FB42B03478A210C1D", hash_generated_field = "200C54AE573D3744441934A403CEA512")

    private DrawData mLoadedPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.352 -0400", hash_original_field = "79ABB18FC2CD6E346A08940B8816FEAD", hash_generated_field = "0BBC35906DDA57724DA9629F2934A2C3")

    private Message mListBoxMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.363 -0400", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "76CCE6E01409674C3B15972BB599643B")
    public  WebView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.364 -0400", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "AEDAEDCB684C4CD96578416A0420598D")
    public  WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.364 -0400", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "DDB3AE0225F2C452A7044B5986F7AC3C")
    public  WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.364 -0400", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "DEAA26941AA68230DE61FB80B1123115")
    public  WebView(Context context, AttributeSet attrs, int defStyle,
            boolean privateBrowsing) {
        this(context, attrs, defStyle, null, privateBrowsing);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(privateBrowsing);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.376 -0400", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "FB8C7E363D890A457FB580DCBFCCD3D1")
    protected  WebView(Context context, AttributeSet attrs, int defStyle,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyle);
        checkThread();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid context argument");
        } //End block
        JniUtil.setContext(context);
        mCallbackProxy = new CallbackProxy(context, this);
        mViewManager = new ViewManager(this);
        L10nUtils.setApplicationContext(context.getApplicationContext());
        mWebViewCore = new WebViewCore(context, this, mCallbackProxy, javaScriptInterfaces);
        mDatabase = WebViewDatabase.getInstance(context);
        mScroller = new OverScroller(context, null, 0, 0, false);
        mZoomManager = new ZoomManager(this, mCallbackProxy);
        init();
        setupPackageListener(context);
        setupProxyListener(context);
        updateMultiTouchSupport(context);
        {
            startPrivateBrowsing();
        } //End block
        mAutoFillData = new WebViewCore.AutoFillData();
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(privateBrowsing);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.377 -0400", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "04CCCA39115104D6AC5BA74803FE09D2")
     void incrementTextGeneration() {
        // ---------- Original Method ----------
        //mTextGeneration++;
    }

    
        private static synchronized void setupProxyListener(Context context) {
        if (sProxyReceiver != null || sNotificationsEnabled == false) {
            return;
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Proxy.PROXY_CHANGE_ACTION);
        sProxyReceiver = new ProxyReceiver();
        Intent currentProxy = context.getApplicationContext().registerReceiver(
                sProxyReceiver, filter);
        if (currentProxy != null) {
            handleProxyBroadcast(currentProxy);
        }
    }

    
        private static synchronized void disableProxyListener(Context context) {
        if (sProxyReceiver == null)
            return;
        context.getApplicationContext().unregisterReceiver(sProxyReceiver);
        sProxyReceiver = null;
    }

    
        private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyProperties = (ProxyProperties)intent.getExtra(Proxy.EXTRA_PROXY_INFO);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, null);
            return;
        }
        WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, proxyProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.472 -0400", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "26CEC807EA7AF79F53EF071A14717969")
    private void setupPackageListener(Context context) {
        {
            IntentFilter filter;
            filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addDataScheme("package");
            BroadcastReceiver packageListener;
            packageListener = new PackageListener();
            context.getApplicationContext().registerReceiver(packageListener, filter);
            sPackageInstallationReceiverAdded = true;
        } //End block
        AsyncTask<Void, Void, Set<String>> task;
        task = new AsyncTask<Void, Void, Set<String>>() {
            @Override
            protected Set<String> doInBackground(Void... unused) {
                Set<String> installedPackages = new HashSet<String>();
                PackageManager pm = mContext.getPackageManager();
                for (String name : sGoogleApps) {
                    try {
                        PackageInfo pInfo = pm.getPackageInfo(name,
                                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);
                        installedPackages.add(name);
                    } catch (PackageManager.NameNotFoundException e) {
                    }
                }
                return installedPackages;
            }
            @Override
            protected void onPostExecute(Set<String> installedPackages) {
                if (mWebViewCore != null) {
                    mWebViewCore.sendMessage(EventHub.ADD_PACKAGE_NAMES, installedPackages);
                }
            }
        };
        task.execute();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.485 -0400", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "BF74BFBB573850BF530E6100C5C3FAA9")
     void updateMultiTouchSupport(Context context) {
        mZoomManager.updateMultiTouchSupport(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //mZoomManager.updateMultiTouchSupport(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.487 -0400", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "39EDB1E80A24887C5DE1449C7D64FFC5")
    private void init() {
        OnTrimMemoryListener.init(getContext());
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        ViewConfiguration configuration;
        configuration = ViewConfiguration.get(getContext());
        int slop;
        slop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = slop * slop;
        slop = configuration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = slop * slop;
        float density;
        density = getContext().getResources().getDisplayMetrics().density;
        mNavSlop = (int) (16 * density);
        mZoomManager.init(density);
        mMaximumFling = configuration.getScaledMaximumFlingVelocity();
        DRAG_LAYER_INVERSE_DENSITY_SQUARED = 1 / (density * density);
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
        setScrollBarStyle(super.getScrollBarStyle());
        mKeysPressed = new Vector<Integer>(2);
        mHTML5VideoViewProxy = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.488 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "40EC0FD73E1F82E62D1AD0BBE2E2360E")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326040762 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326040762;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.488 -0400", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "1BBE3540D6BB8697029A7685B5568566")
    private void addAccessibilityApisToJavaScript() {
        {
            boolean varBB290631FF6BE4C8F44D202E8FB380A0_1346447667 = (AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled());
            {
                Context ctx;
                ctx = getContext();
                {
                    String packageName;
                    packageName = ctx.getPackageName();
                    {
                        mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            packageName + ".**webview**");
                        addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()
                //&& getSettings().getJavaScriptEnabled()) {
            //final Context ctx = getContext();
            //if (ctx != null) {
                //final String packageName = ctx.getPackageName();
                //if (packageName != null) {
                    //mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            //packageName + ".**webview**");
                    //addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.488 -0400", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "A2288C92C983D5D3246AA0C172C80D09")
    private void removeAccessibilityApisFromJavaScript() {
        {
            removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        } //End block
        // ---------- Original Method ----------
        //if (mTextToSpeech != null) {
            //removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            //mTextToSpeech.shutdown();
            //mTextToSpeech = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.489 -0400", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "BF2F1698187FD089D29324B55BE56A7C")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.489 -0400", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "B09761E9ADCE969CDE361462F6847709")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        int convertedContentWidth;
        convertedContentWidth = contentToViewX(getContentWidth());
        int adjustedViewWidth;
        adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        int convertedContentHeight;
        convertedContentHeight = contentToViewY(getContentHeight());
        int adjustedViewHeight;
        adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityEvent(event);
        //event.setScrollable(isScrollableForAccessibility());
        //event.setScrollX(mScrollX);
        //event.setScrollY(mScrollY);
        //final int convertedContentWidth = contentToViewX(getContentWidth());
        //final int adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        //event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        //final int convertedContentHeight = contentToViewY(getContentHeight());
        //final int adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        //event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.489 -0400", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "0C214812C4A4C574430679331225CBC2")
    private boolean isScrollableForAccessibility() {
        boolean var2E51EF2A2B51F29427B40369CE73A1BE_1234270680 = ((contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74116683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74116683;
        // ---------- Original Method ----------
        //return (contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                //|| contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.501 -0400", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "8DB6F7DE3422AA77FA17DE80FDD068CC")
    @Override
    public void setOverScrollMode(int mode) {
        super.setOverScrollMode(mode);
        {
            {
                mOverScrollGlow = new OverScrollGlow(this);
            } //End block
        } //End block
        {
            mOverScrollGlow = null;
        } //End block
        addTaint(mode);
        // ---------- Original Method ----------
        //super.setOverScrollMode(mode);
        //if (mode != OVER_SCROLL_NEVER) {
            //if (mOverScrollGlow == null) {
                //mOverScrollGlow = new OverScrollGlow(this);
            //}
        //} else {
            //mOverScrollGlow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.502 -0400", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "0FBDFE892DDC5866C382EB0E0F39675C")
     void adjustDefaultZoomDensity(int zoomDensity) {
        float density;
        density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
        addTaint(zoomDensity);
        // ---------- Original Method ----------
        //final float density = mContext.getResources().getDisplayMetrics().density
                //* 100 / zoomDensity;
        //updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.503 -0400", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "688F1816A2901C03B061988243CC1670")
     void updateDefaultZoomDensity(float density) {
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //mNavSlop = (int) (16 * density);
        //mZoomManager.updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.532 -0400", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "CB5A0CCEEEE44EF020AE2C6C8402DDA0")
     boolean onSavePassword(String schemePlusHost, String username,
            String password, final Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean rVal;
        rVal = false;
        {
            mDatabase.setUsernamePassword(schemePlusHost, username, password);
        } //End block
        {
            Message remember;
            remember = mPrivateHandler.obtainMessage(
                    REMEMBER_PASSWORD);
            remember.getData().putString("host", schemePlusHost);
            remember.getData().putString("username", username);
            remember.getData().putString("password", password);
            remember.obj = resumeMsg;
            Message neverRemember;
            neverRemember = mPrivateHandler.obtainMessage(
                    NEVER_REMEMBER_PASSWORD);
            neverRemember.getData().putString("host", schemePlusHost);
            neverRemember.getData().putString("username", username);
            neverRemember.getData().putString("password", password);
            neverRemember.obj = resumeMsg;
            new AlertDialog.Builder(getContext())
                    .setTitle(com.android.internal.R.string.save_password_label)
                    .setMessage(com.android.internal.R.string.save_password_message)
                    .setPositiveButton(com.android.internal.R.string.save_password_notnow,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.530 -0400", hash_original_method = "99DE72360AB23E9BF4985BE8ED3FB8CE", hash_generated_method = "047177DCDA433E769B05E9723991172F")
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    resumeMsg.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    // ---------- Original Method ----------
                    //resumeMsg.sendToTarget();
                }
})
                    .setNeutralButton(com.android.internal.R.string.save_password_remember,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.531 -0400", hash_original_method = "BC12A66C673827B889B0C1DFB7251A66", hash_generated_method = "42BE6E1313BE7B33B1DC669B1F3396A7")
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    remember.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    // ---------- Original Method ----------
                    //remember.sendToTarget();
                }
})
                    .setNegativeButton(com.android.internal.R.string.save_password_never,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.531 -0400", hash_original_method = "873315778F761CDAFA793A9437C366FC", hash_generated_method = "9F2C8A88C91D099DE00989B2C8E7E335")
                public void onClick(DialogInterface dialog, int which) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    neverRemember.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    // ---------- Original Method ----------
                    //neverRemember.sendToTarget();
                }
})
                    .setOnCancelListener(new OnCancelListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.532 -0400", hash_original_method = "93C3AC18FD9E5633ABD9F836EA5CC3F9", hash_generated_method = "A876EDE090C42B673504583186D51370")
                public void onCancel(DialogInterface dialog) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    resumeMsg.sendToTarget();
                    addTaint(dialog.getTaint());
                    // ---------- Original Method ----------
                    //resumeMsg.sendToTarget();
                }
}).show();
            rVal = true;
        } //End block
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(resumeMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_39434448 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_39434448;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.533 -0400", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "5EC9E0986DCAB66F1E34844CECF5992D")
    @Override
    public void setScrollBarStyle(int style) {
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        } //End block
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        } //End block
        super.setScrollBarStyle(style);
        addTaint(style);
        // ---------- Original Method ----------
        //if (style == View.SCROLLBARS_INSIDE_INSET
                //|| style == View.SCROLLBARS_OUTSIDE_INSET) {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        //} else {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        //}
        //super.setScrollBarStyle(style);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.545 -0400", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "49957A37EDFF2774BB0F59A959CBDB39")
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayHorizontalScrollbar = overlay;
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayHorizontalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.546 -0400", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "B9F69862443AC26CC9A977C090485865")
    public void setVerticalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayVerticalScrollbar = overlay;
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayVerticalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.546 -0400", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "EBCEC25CDA7CE052CE06FEF9F4232BAB")
    public boolean overlayHorizontalScrollbar() {
        checkThread();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920830272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920830272;
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayHorizontalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.546 -0400", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "AFF96E08B96FE478A62B39528D377AD4")
    public boolean overlayVerticalScrollbar() {
        checkThread();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129281799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129281799;
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayVerticalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.547 -0400", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "C4D186AACFFEE704139820400116B66E")
     int getViewWidth() {
        {
            boolean var292598F3B8B58F58543813175CA4B8DD_337918997 = (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar);
            {
                int var6198C346AE8689F1D3DC081BB775DCCC_2078516470 = (getWidth());
            } //End block
            {
                int var140744BAF485A6F88159B58920081848_2082702888 = (Math.max(0, getWidth() - getVerticalScrollbarWidth()));
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769808118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769808118;
        // ---------- Original Method ----------
        //if (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar) {
            //return getWidth();
        //} else {
            //return Math.max(0, getWidth() - getVerticalScrollbarWidth());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.547 -0400", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "F0C3435879B05FD27D682BDB878E9978")
    protected int getTitleHeight() {
        {
            Object var89620761E813C776D9C3C42E19001F67_978161655 = (mTitleBar.getHeight());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708550461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708550461;
        // ---------- Original Method ----------
        //return mTitleBar != null ? mTitleBar.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.547 -0400", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "21862C1B09E0D586D1B1AC7114B16451")
    public int getVisibleTitleHeight() {
        checkThread();
        int var723012357A221391980D0C0C10B6FF34_92135462 = (getVisibleTitleHeightImpl());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485279931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485279931;
        // ---------- Original Method ----------
        //checkThread();
        //return getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.548 -0400", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "7742A94566FD7D6CF14CEC846DD9A165")
    private int getVisibleTitleHeightImpl() {
        int var92FBB9603EF7E293DE9CA0F22B9E46D3_1218720285 = (Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630067581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1630067581;
        // ---------- Original Method ----------
        //return Math.max(getTitleHeight() - Math.max(0, mScrollY),
                //getOverlappingActionModeHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.553 -0400", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "7DBB0C18B15017CC144844591B92ABEE")
    private int getOverlappingActionModeHeight() {
        {
            getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            mCachedOverlappingActionModeHeight = Math.max(0,
                    mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638722250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638722250;
        // ---------- Original Method ----------
        //if (mFindCallback == null) {
            //return 0;
        //}
        //if (mCachedOverlappingActionModeHeight < 0) {
            //getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            //mCachedOverlappingActionModeHeight = Math.max(0,
                    //mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        //}
        //return mCachedOverlappingActionModeHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.556 -0400", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "DAEADCFB8330A40A3016485F7A7BBF2C")
     int getViewHeight() {
        int varD548A0758944BD119F0830EAB903948B_94679511 = (getViewHeightWithTitle() - getVisibleTitleHeightImpl());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399998940 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399998940;
        // ---------- Original Method ----------
        //return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.557 -0400", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "B16C439A3EACC926A047C2E2FDF459C4")
     int getViewHeightWithTitle() {
        int height;
        height = getHeight();
        {
            boolean varEFFBBF75692B423920E06898DB33B47D_1989451373 = (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar);
            {
                height -= getHorizontalScrollbarHeight();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446591422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1446591422;
        // ---------- Original Method ----------
        //int height = getHeight();
        //if (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar) {
            //height -= getHorizontalScrollbarHeight();
        //}
        //return height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.568 -0400", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "36D528C53011D970EFB7359A718F28AD")
    public SslCertificate getCertificate() {
        SslCertificate varB4EAC82CA7396A68D541C85D26508E83_565716347 = null; //Variable for return #1
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_565716347 = mCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_565716347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565716347;
        // ---------- Original Method ----------
        //checkThread();
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.568 -0400", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "7ABF7DE15A0CC376B74CCCEE0287D121")
    public void setCertificate(SslCertificate certificate) {
        checkThread();
        mCertificate = certificate;
        // ---------- Original Method ----------
        //checkThread();
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "setCertificate=" + certificate);
        //}
        //mCertificate = certificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.568 -0400", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "121BB62325326162CB4746406BA8C639")
    public void savePassword(String host, String username, String password) {
        checkThread();
        mDatabase.setUsernamePassword(host, username, password);
        addTaint(host.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setUsernamePassword(host, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.569 -0400", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "3592FC1AE9692AE0D81C80A8D8C55954")
    public void setHttpAuthUsernamePassword(String host, String realm,
            String username, String password) {
        checkThread();
        mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.569 -0400", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "92403980A972B382258E5BB714391941")
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1319878670 = null; //Variable for return #1
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1319878670 = mDatabase.getHttpAuthUsernamePassword(host, realm);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1319878670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1319878670;
        // ---------- Original Method ----------
        //checkThread();
        //return mDatabase.getHttpAuthUsernamePassword(host, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.569 -0400", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "96EAAC7786E159D4BA71959CCD2826C5")
    private void clearActionModes() {
        {
            mSelectCallback.finish();
        } //End block
        {
            mFindCallback.finish();
        } //End block
        // ---------- Original Method ----------
        //if (mSelectCallback != null) {
            //mSelectCallback.finish();
        //}
        //if (mFindCallback != null) {
            //mFindCallback.finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.570 -0400", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "448F915BE7E908A0F655BF91243B2A40")
    private void clearHelpers() {
        clearTextEntry();
        clearActionModes();
        dismissFullScreenMode();
        cancelSelectDialog();
        // ---------- Original Method ----------
        //clearTextEntry();
        //clearActionModes();
        //dismissFullScreenMode();
        //cancelSelectDialog();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.570 -0400", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "6484E292F95762A26C284C86BD93A17F")
    private void cancelSelectDialog() {
        {
            mListBoxDialog.cancel();
            mListBoxDialog = null;
        } //End block
        // ---------- Original Method ----------
        //if (mListBoxDialog != null) {
            //mListBoxDialog.cancel();
            //mListBoxDialog = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.570 -0400", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "38021AB430F2F37CB9A4606BEC6303C5")
    public void destroy() {
        checkThread();
        destroyImpl();
        // ---------- Original Method ----------
        //checkThread();
        //destroyImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.593 -0400", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "780F377B513A7B5883C80A512598480F")
    private void destroyImpl() {
        clearHelpers();
        {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        } //End block
        {
            mWebTextView.remove();
            mWebTextView = null;
        } //End block
        nativeStopGL();
        {
            mCallbackProxy.setWebViewClient(null);
            mCallbackProxy.setWebChromeClient(null);
            {
                WebViewCore webViewCore;
                webViewCore = mWebViewCore;
                mWebViewCore = null;
                webViewCore.destroy();
            } //End block
            mPrivateHandler.removeCallbacksAndMessages(null);
            mCallbackProxy.removeCallbacksAndMessages(null);
            {
                mCallbackProxy.notify();
            } //End block
        } //End block
        {
            nativeDestroy();
            mNativeClass = 0;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @Deprecated
    public static void enablePlatformNotifications() {
        checkThread();
        synchronized (WebView.class) {
            Network.enablePlatformNotifications();
            sNotificationsEnabled = true;
            Context context = JniUtil.getContext();
            if (context != null)
                setupProxyListener(context);
        }
    }

    
        @Deprecated
    public static void disablePlatformNotifications() {
        checkThread();
        synchronized (WebView.class) {
            Network.disablePlatformNotifications();
            sNotificationsEnabled = false;
            Context context = JniUtil.getContext();
            if (context != null)
                disableProxyListener(context);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.594 -0400", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "B71D193F47F9D4DFA364F5F09F93088B")
    public void setJsFlags(String flags) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
        addTaint(flags.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.595 -0400", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "B1147815A844E554696EC64B02A849F1")
    public void setNetworkAvailable(boolean networkUp) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                networkUp ? 1 : 0, 0);
        addTaint(networkUp);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                //networkUp ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.595 -0400", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "E3CFD48EACF65E5DCFD1A333E96C4204")
    public void setNetworkType(String type, String subtype) {
        checkThread();
        Map<String, String> map;
        map = new HashMap<String, String>();
        map.put("type", type);
        map.put("subtype", subtype);
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
        addTaint(type.getTaint());
        addTaint(subtype.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //Map<String, String> map = new HashMap<String, String>();
        //map.put("type", type);
        //map.put("subtype", subtype);
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.603 -0400", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "4DDFC334AB656A641BBF1CB9A53E65E9")
    public WebBackForwardList saveState(Bundle outState) {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1561580273 = null; //Variable for return #1
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1363337066 = null; //Variable for return #2
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1551075366 = null; //Variable for return #3
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1799992386 = null; //Variable for return #4
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1456936951 = null; //Variable for return #5
        checkThread();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1561580273 = null;
        } //End block
        WebBackForwardList list;
        list = copyBackForwardList();
        int currentIndex;
        currentIndex = list.getCurrentIndex();
        int size;
        size = list.getSize();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1363337066 = null;
        } //End block
        outState.putInt("index", currentIndex);
        ArrayList<byte[]> history;
        history = new ArrayList<byte[]>(size);
        {
            int i;
            i = 0;
            {
                WebHistoryItem item;
                item = list.getItemAtIndex(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1551075366 = null;
                } //End block
                byte[] data;
                data = item.getFlattenedData();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1799992386 = null;
                } //End block
                history.add(data);
            } //End block
        } //End collapsed parenthetic
        outState.putSerializable("history", history);
        {
            outState.putBundle("certificate",
                               SslCertificate.saveState(mCertificate));
        } //End block
        outState.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(outState);
        varB4EAC82CA7396A68D541C85D26508E83_1456936951 = list;
        addTaint(outState.getTaint());
        WebBackForwardList varA7E53CE21691AB073D9660D615818899_739352285; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_739352285 = varB4EAC82CA7396A68D541C85D26508E83_1561580273;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_739352285 = varB4EAC82CA7396A68D541C85D26508E83_1363337066;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_739352285 = varB4EAC82CA7396A68D541C85D26508E83_1551075366;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_739352285 = varB4EAC82CA7396A68D541C85D26508E83_1799992386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_739352285 = varB4EAC82CA7396A68D541C85D26508E83_1456936951;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_739352285.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_739352285;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.607 -0400", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "033F45154FEC0870C06AE68E36821C40")
    @Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        checkThread();
        Picture p;
        p = capturePicture();
        File temp;
        temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.607 -0400", hash_original_method = "71F2765D1125FA36D6758E11ABE47081", hash_generated_method = "4F46149694C62E2224995F4104868B9C")
            public void run() {
                FileOutputStream out;
                out = null;
                try 
                {
                    out = new FileOutputStream(temp);
                    p.writeToStream(out);
                    temp.renameTo(dest);
                } //End block
                catch (Exception e)
                { }
                finally 
                {
                    {
                        try 
                        {
                            out.close();
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                    temp.delete();
                } //End block
                // ---------- Original Method ----------
                //FileOutputStream out = null;
                //try {
                    //out = new FileOutputStream(temp);
                    //p.writeToStream(out);
                    //temp.renameTo(dest);
                //} catch (Exception e) {
                //} finally {
                    //if (out != null) {
                        //try {
                            //out.close();
                        //} catch (Exception e) {
                        //}
                    //}
                    //temp.delete();
                //}
            }
}).start();
        b.putInt("scrollX", mScrollX);
        b.putInt("scrollY", mScrollY);
        mZoomManager.saveZoomState(b);
        addTaint(b.getTaint());
        addTaint(dest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363849515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363849515;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.628 -0400", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "BDD8C4297556C6DCFCD37CCF0F6F7327")
    private void restoreHistoryPictureFields(Picture p, Bundle b) {
        int sx;
        sx = b.getInt("scrollX", 0);
        int sy;
        sy = b.getInt("scrollY", 0);
        mDrawHistory = true;
        mHistoryPicture = p;
        mScrollX = sx;
        mScrollY = sy;
        mZoomManager.restoreZoomState(b);
        float scale;
        scale = mZoomManager.getScale();
        mHistoryWidth = Math.round(p.getWidth() * scale);
        mHistoryHeight = Math.round(p.getHeight() * scale);
        invalidate();
        addTaint(b.getTaint());
        // ---------- Original Method ----------
        //int sx = b.getInt("scrollX", 0);
        //int sy = b.getInt("scrollY", 0);
        //mDrawHistory = true;
        //mHistoryPicture = p;
        //mScrollX = sx;
        //mScrollY = sy;
        //mZoomManager.restoreZoomState(b);
        //final float scale = mZoomManager.getScale();
        //mHistoryWidth = Math.round(p.getWidth() * scale);
        //mHistoryHeight = Math.round(p.getHeight() * scale);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.657 -0400", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "157800FFC51797D8D1D97D555D0C5DCC")
    @Deprecated
    public boolean restorePicture(Bundle b, File src) {
        checkThread();
        {
            boolean varE83409CFB365F3AF171C437BEF6A7D4D_1156700214 = (!src.exists());
        } //End collapsed parenthetic
        try 
        {
            FileInputStream in;
            in = new FileInputStream(src);
            Bundle copy;
            copy = new Bundle(b);
            new Thread(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.657 -0400", hash_original_method = "724A0503E9DDAB096FD7727D625B3A77", hash_generated_method = "27298C9B315EE4F972D78313BD26CF85")
                public void run() {
                    try 
                    {
                        Picture p;
                        p = Picture.createFromStream(in);
                        {
                            mPrivateHandler.post(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.657 -0400", hash_original_method = "C56555B2959C7B009BAA3230DF6B18BD", hash_generated_method = "99D4A60111AD5243B646F29DC3E7007E")
                                public void run() {
                                    restoreHistoryPictureFields(p, copy);
                                    // ---------- Original Method ----------
                                    //restoreHistoryPictureFields(p, copy);
                                }
});
                        } //End block
                    } //End block
                    finally 
                    {
                        try 
                        {
                            in.close();
                        } //End block
                        catch (Exception e)
                        { }
                    } //End block
                    // ---------- Original Method ----------
                    //try {
                        //final Picture p = Picture.createFromStream(in);
                        //if (p != null) {
                            //mPrivateHandler.post(new Runnable() {
                                //public void run() {
                                    //restoreHistoryPictureFields(p, copy);
                                //}
                            //});
                        //}
                    //} finally {
                        //try {
                            //in.close();
                        //} catch (Exception e) {
                        //}
                    //}
                }
}).start();
        } //End block
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } //End block
        addTaint(b.getTaint());
        addTaint(src.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046381412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046381412;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.658 -0400", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "AAF101B2DFFE13CA966FD408EB954735")
    public boolean saveViewState(OutputStream stream) {
        try 
        {
            boolean varD8E0513B299C4708A843791F787A4612_864894936 = (ViewStateSerializer.serializeViewState(stream, this));
        } //End block
        catch (IOException e)
        { }
        addTaint(stream.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_89370900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_89370900;
        // ---------- Original Method ----------
        //try {
            //return ViewStateSerializer.serializeViewState(stream, this);
        //} catch (IOException e) {
            //Log.w(LOGTAG, "Failed to saveViewState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.658 -0400", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "E1C8FB3CFAA713C483F24255663BF2ED")
    public boolean loadViewState(InputStream stream) {
        try 
        {
            mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            mBlockWebkitViewMessages = true;
            setNewPicture(mLoadedPicture, true);
            mLoadedPicture.mViewState = null;
        } //End block
        catch (IOException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987864373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_987864373;
        // ---------- Original Method ----------
        //try {
            //mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            //mBlockWebkitViewMessages = true;
            //setNewPicture(mLoadedPicture, true);
            //mLoadedPicture.mViewState = null;
            //return true;
        //} catch (IOException e) {
            //Log.w(LOGTAG, "Failed to loadViewState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.659 -0400", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "732621B4DF183E8125FE78ECB6DCCC1E")
    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
        // ---------- Original Method ----------
        //mBlockWebkitViewMessages = false;
        //mLoadedPicture = null;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.660 -0400", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "6E8EC0F6DB36899FE85E57BFA21D5B0E")
    public WebBackForwardList restoreState(Bundle inState) {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_760316681 = null; //Variable for return #1
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_822831025 = null; //Variable for return #2
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_2114129655 = null; //Variable for return #3
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_525566830 = null; //Variable for return #4
        checkThread();
        WebBackForwardList returnList;
        returnList = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_760316681 = returnList;
        } //End block
        {
            boolean var2DC9EFB7F916A118778C320ECAEAF366_366640816 = (inState.containsKey("index") && inState.containsKey("history"));
            {
                mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));
                WebBackForwardList list;
                list = mCallbackProxy.getBackForwardList();
                int index;
                index = inState.getInt("index");
                {
                    List<byte[]> history;
                    history = (List<byte[]>) inState.getSerializable("history");
                    int size;
                    size = history.size();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_822831025 = null;
                    } //End block
                    {
                        int i;
                        i = 0;
                        {
                            byte[] data;
                            data = history.remove(0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2114129655 = null;
                            } //End block
                            WebHistoryItem item;
                            item = new WebHistoryItem(data);
                            list.addHistoryItem(item);
                        } //End block
                    } //End collapsed parenthetic
                    returnList = copyBackForwardList();
                    returnList.setCurrentIndex(index);
                } //End block
                {
                    boolean varA762F755263E0165E9C21EFA8E349BE2_2144485387 = (inState.getBoolean("privateBrowsingEnabled"));
                    {
                        getSettings().setPrivateBrowsingEnabled(true);
                    } //End block
                } //End collapsed parenthetic
                mZoomManager.restoreZoomState(inState);
                mWebViewCore.removeMessages();
                mWebViewCore.sendMessage(EventHub.RESTORE_STATE, index);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_525566830 = returnList;
        WebBackForwardList varA7E53CE21691AB073D9660D615818899_272712809; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_272712809 = varB4EAC82CA7396A68D541C85D26508E83_760316681;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_272712809 = varB4EAC82CA7396A68D541C85D26508E83_822831025;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_272712809 = varB4EAC82CA7396A68D541C85D26508E83_2114129655;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_272712809 = varB4EAC82CA7396A68D541C85D26508E83_525566830;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_272712809.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_272712809;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.661 -0400", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "E2F8EA7B289D935D185CCD3A0D96C130")
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
        addTaint(url.getTaint());
        addTaint(additionalHttpHeaders.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url, additionalHttpHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.674 -0400", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "24C00BEDCD1E8705D96E05202A2A3385")
    private void loadUrlImpl(String url, Map<String, String> extraHeaders) {
        switchOutDrawHistory();
        WebViewCore.GetUrlData arg;
        arg = new WebViewCore.GetUrlData();
        arg.mUrl = url;
        arg.mExtraHeaders = extraHeaders;
        mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        clearHelpers();
        addTaint(url.getTaint());
        addTaint(extraHeaders.getTaint());
        // ---------- Original Method ----------
        //switchOutDrawHistory();
        //WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        //arg.mUrl = url;
        //arg.mExtraHeaders = extraHeaders;
        //mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        //clearHelpers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.674 -0400", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "55B96F0FDDFA5E946455029D5EADA0CB")
    public void loadUrl(String url) {
        checkThread();
        loadUrlImpl(url);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.674 -0400", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "7CA7E52126ED4448E3184304DDCA2AE1")
    private void loadUrlImpl(String url) {
        loadUrlImpl(url, null);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //if (url == null) {
            //return;
        //}
        //loadUrlImpl(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.675 -0400", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "295D91241E09B3E3C28D3F7134526432")
    public void postUrl(String url, byte[] postData) {
        checkThread();
        {
            boolean var4F95E4BDE23CE2774CDB1234D95999CA_1270532973 = (URLUtil.isNetworkUrl(url));
            {
                switchOutDrawHistory();
                WebViewCore.PostUrlData arg;
                arg = new WebViewCore.PostUrlData();
                arg.mUrl = url;
                arg.mPostData = postData;
                mWebViewCore.sendMessage(EventHub.POST_URL, arg);
                clearHelpers();
            } //End block
            {
                loadUrlImpl(url);
            } //End block
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        addTaint(postData[0]);
        // ---------- Original Method ----------
        //checkThread();
        //if (URLUtil.isNetworkUrl(url)) {
            //switchOutDrawHistory();
            //WebViewCore.PostUrlData arg = new WebViewCore.PostUrlData();
            //arg.mUrl = url;
            //arg.mPostData = postData;
            //mWebViewCore.sendMessage(EventHub.POST_URL, arg);
            //clearHelpers();
        //} else {
            //loadUrlImpl(url);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.675 -0400", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "57093C4DAC7FB94A2276E35291C35BE3")
    public void loadData(String data, String mimeType, String encoding) {
        checkThread();
        loadDataImpl(data, mimeType, encoding);
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //loadDataImpl(data, mimeType, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.676 -0400", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "65D542248757233622E7EF684DDE4025")
    private void loadDataImpl(String data, String mimeType, String encoding) {
        StringBuilder dataUrl;
        dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        {
            boolean var42C80751A5B21E94C93713173917F7B9_1970455904 = ("base64".equals(encoding));
            {
                dataUrl.append(";base64");
            } //End block
        } //End collapsed parenthetic
        dataUrl.append(",");
        dataUrl.append(data);
        loadUrlImpl(dataUrl.toString());
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        // ---------- Original Method ----------
        //StringBuilder dataUrl = new StringBuilder("data:");
        //dataUrl.append(mimeType);
        //if ("base64".equals(encoding)) {
            //dataUrl.append(";base64");
        //}
        //dataUrl.append(",");
        //dataUrl.append(data);
        //loadUrlImpl(dataUrl.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.677 -0400", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "C84CB06D4BBEB16D4FBEF0614CB1E4AD")
    public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        checkThread();
        {
            boolean var66719BDAFAA36B530D74BC3839E26AEE_545864425 = (baseUrl != null && baseUrl.toLowerCase().startsWith("data:"));
            {
                loadDataImpl(data, mimeType, encoding);
            } //End block
        } //End collapsed parenthetic
        switchOutDrawHistory();
        WebViewCore.BaseUrlData arg;
        arg = new WebViewCore.BaseUrlData();
        arg.mBaseUrl = baseUrl;
        arg.mData = data;
        arg.mMimeType = mimeType;
        arg.mEncoding = encoding;
        arg.mHistoryUrl = historyUrl;
        mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        clearHelpers();
        addTaint(baseUrl.getTaint());
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        addTaint(historyUrl.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (baseUrl != null && baseUrl.toLowerCase().startsWith("data:")) {
            //loadDataImpl(data, mimeType, encoding);
            //return;
        //}
        //switchOutDrawHistory();
        //WebViewCore.BaseUrlData arg = new WebViewCore.BaseUrlData();
        //arg.mBaseUrl = baseUrl;
        //arg.mData = data;
        //arg.mMimeType = mimeType;
        //arg.mEncoding = encoding;
        //arg.mHistoryUrl = historyUrl;
        //mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        //clearHelpers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.677 -0400", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "84864D77370F74BC26B21B7246B02AFF")
    public void saveWebArchive(String filename) {
        checkThread();
        saveWebArchiveImpl(filename, false, null);
        addTaint(filename.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(filename, false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.689 -0400", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "28DC10B689ED103B34E9A1B4EBFC11E7")
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
        addTaint(basename.getTaint());
        addTaint(autoname);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(basename, autoname, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.689 -0400", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "F2EF15EAE862FCC49D90ACF820842AF1")
    private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
        addTaint(basename.getTaint());
        addTaint(autoname);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            //new SaveWebArchiveMessage(basename, autoname, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.689 -0400", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "2C395E4AC53467FAD68E24848E941787")
    public void stopLoading() {
        checkThread();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
        // ---------- Original Method ----------
        //checkThread();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.STOP_LOADING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.690 -0400", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "8F4D6179589A516B470113791CFEE8A4")
    public void reload() {
        checkThread();
        clearHelpers();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.RELOAD);
        // ---------- Original Method ----------
        //checkThread();
        //clearHelpers();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.RELOAD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.690 -0400", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "B1CFB9A71C379BFA1FCFEAD433F11F90")
    public boolean canGoBack() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_623205485 = (l.getClearPending());
                {
                    boolean var206A5F4DC30C9911DE984FA8A632E8D0_1502204770 = (l.getCurrentIndex() > 0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194548419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194548419;
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //return l.getCurrentIndex() > 0;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.690 -0400", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "63D2353E5F881AC0C773B9FBCC91A18D")
    public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.691 -0400", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "E55C565EC82A8CCE1712A12445D171CD")
    public boolean canGoForward() {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_1102274221 = (l.getClearPending());
                {
                    boolean varCC6932F1C4388293E5C6020CC2BE99D1_152713707 = (l.getCurrentIndex() < l.getSize() - 1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509849532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509849532;
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //return l.getCurrentIndex() < l.getSize() - 1;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.691 -0400", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "7DBF91244690F3215087518F21FF9C8A")
    public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.692 -0400", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "2596842ED940CC513FB1E1C52839484F")
    public boolean canGoBackOrForward(int steps) {
        checkThread();
        WebBackForwardList l;
        l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_1348537556 = (l.getClearPending());
                {
                    int newIndex;
                    newIndex = l.getCurrentIndex() + steps;
                    boolean varC96153442818D1ECADD5777B6D61A76F_717797884 = (newIndex >= 0 && newIndex < l.getSize());
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(steps);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140212792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140212792;
        // ---------- Original Method ----------
        //checkThread();
        //WebBackForwardList l = mCallbackProxy.getBackForwardList();
        //synchronized (l) {
            //if (l.getClearPending()) {
                //return false;
            //} else {
                //int newIndex = l.getCurrentIndex() + steps;
                //return newIndex >= 0 && newIndex < l.getSize();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.692 -0400", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "ABFA7D864F6303240B59D0F63705A218")
    public void goBackOrForward(int steps) {
        checkThread();
        goBackOrForwardImpl(steps);
        addTaint(steps);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(steps);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.692 -0400", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "EE65BD760FCE049A904C0471FA3FC639")
    private void goBackOrForwardImpl(int steps) {
        goBackOrForward(steps, false);
        addTaint(steps);
        // ---------- Original Method ----------
        //goBackOrForward(steps, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.699 -0400", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "1DC4E0D76CB6E1A79A3D0ACBE1BD9353")
    private void goBackOrForward(int steps, boolean ignoreSnapshot) {
        {
            clearHelpers();
            mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    ignoreSnapshot ? 1 : 0);
        } //End block
        addTaint(steps);
        addTaint(ignoreSnapshot);
        // ---------- Original Method ----------
        //if (steps != 0) {
            //clearHelpers();
            //mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    //ignoreSnapshot ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.699 -0400", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "1B5B4C99D99AD1170E486EF4AD3E65C7")
    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        boolean varB1BAC2416E34E6087A203AED7444A817_1082740869 = (getSettings().isPrivateBrowsingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055390285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055390285;
        // ---------- Original Method ----------
        //checkThread();
        //return getSettings().isPrivateBrowsingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.711 -0400", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "07E57C68BA1FFA2F79AE67648A8B3103")
    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
        // ---------- Original Method ----------
        //getSettings().setPrivateBrowsingEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.712 -0400", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "A85906286D67AAAD89518C0A760538F1")
    private boolean extendScroll(int y) {
        int finalY;
        finalY = mScroller.getFinalY();
        int newY;
        newY = pinLocY(finalY + y);
        mScroller.setFinalY(newY);
        mScroller.extendDuration(computeDuration(0, y));
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625588432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625588432;
        // ---------- Original Method ----------
        //int finalY = mScroller.getFinalY();
        //int newY = pinLocY(finalY + y);
        //if (newY == finalY) return false;
        //mScroller.setFinalY(newY);
        //mScroller.extendDuration(computeDuration(0, y));
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.713 -0400", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "1F1393D46310FC5EBA0990BD5654F88C")
    public boolean pageUp(boolean top) {
        checkThread();
        nativeClearCursor();
        {
            boolean varEC29A5852D76967DDCD92AF6EF13DA1B_47274445 = (pinScrollTo(mScrollX, 0, true, 0));
        } //End block
        int h;
        h = getHeight();
        int y;
        {
            y = -h + PAGE_SCROLL_OVERLAP;
        } //End block
        {
            y = -h / 2;
        } //End block
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_1752471208 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1477058842 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_1341797377 = (extendScroll(y));
        } //End flattened ternary
        addTaint(top);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684118556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684118556;
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) {
            //return false;
        //}
        //nativeClearCursor();
        //if (top) {
            //return pinScrollTo(mScrollX, 0, true, 0);
        //}
        //int h = getHeight();
        //int y;
        //if (h > 2 * PAGE_SCROLL_OVERLAP) {
            //y = -h + PAGE_SCROLL_OVERLAP;
        //} else {
            //y = -h / 2;
        //}
        //return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                //: extendScroll(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.713 -0400", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "BF1FDC035F915034AA820AE537F4BED7")
    public boolean pageDown(boolean bottom) {
        checkThread();
        nativeClearCursor();
        {
            boolean var20824CBC7D9295AF4224D9CEA1714AF5_1807067839 = (pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0));
        } //End block
        int h;
        h = getHeight();
        int y;
        {
            y = h - PAGE_SCROLL_OVERLAP;
        } //End block
        {
            y = h / 2;
        } //End block
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_383139164 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1045093348 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_1841797283 = (extendScroll(y));
        } //End flattened ternary
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115611839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115611839;
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) {
            //return false;
        //}
        //nativeClearCursor();
        //if (bottom) {
            //return pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0);
        //}
        //int h = getHeight();
        //int y;
        //if (h > 2 * PAGE_SCROLL_OVERLAP) {
            //y = h - PAGE_SCROLL_OVERLAP;
        //} else {
            //y = h / 2;
        //}
        //return mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                //: extendScroll(y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.714 -0400", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "96502640F44EE6B02C635F6CE1A50F1B")
    public void clearView() {
        checkThread();
        mContentWidth = 0;
        mContentHeight = 0;
        setBaseLayer(0, null, false, false, false);
        mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        // ---------- Original Method ----------
        //checkThread();
        //mContentWidth = 0;
        //mContentHeight = 0;
        //setBaseLayer(0, null, false, false, false);
        //mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.714 -0400", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "F305959C82A241612C452B0DD7F6C877")
    public Picture capturePicture() {
        Picture varB4EAC82CA7396A68D541C85D26508E83_629712475 = null; //Variable for return #1
        Picture varB4EAC82CA7396A68D541C85D26508E83_1061883635 = null; //Variable for return #2
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_629712475 = null;
        Picture result;
        result = new Picture();
        nativeCopyBaseContentToPicture(result);
        varB4EAC82CA7396A68D541C85D26508E83_1061883635 = result;
        Picture varA7E53CE21691AB073D9660D615818899_1937881540; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1937881540 = varB4EAC82CA7396A68D541C85D26508E83_629712475;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1937881540 = varB4EAC82CA7396A68D541C85D26508E83_1061883635;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1937881540.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1937881540;
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) return null;
        //Picture result = new Picture();
        //nativeCopyBaseContentToPicture(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.715 -0400", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "CEE64E0EE645EB258F91E3659AFB5644")
    private boolean inEditingMode() {
        boolean var5AD34046046BD5597D48FAE1E55DF94F_850306923 = (mWebTextView != null && mWebTextView.getParent() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736236692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736236692;
        // ---------- Original Method ----------
        //return mWebTextView != null && mWebTextView.getParent() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.715 -0400", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "6DF4037692FB306884D2188E06A303F2")
    private void clearTextEntry() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_838268183 = (inEditingMode());
            {
                mWebTextView.remove();
            } //End block
            {
                hideSoftKeyboard();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.remove();
        //} else {
            //hideSoftKeyboard();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.715 -0400", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "FE3EB21D8FB67D48C0FF140E9ADFAFFD")
    public float getScale() {
        checkThread();
        float var7BDB5950E779A8350C7AFF5485D9A1D9_1411147367 = (mZoomManager.getScale());
        float var546ADE640B6EDFBC8A086EF31347E768_705206142 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_705206142;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.716 -0400", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "6B89B33ED9CA5F4AC98C840B34C0A57A")
     float getTextHandleScale() {
        float density;
        density = mContext.getResources().getDisplayMetrics().density;
        float varE59D2240C31D06227A739295405DD61F_2026087768 = (density / getScale());
        float var546ADE640B6EDFBC8A086EF31347E768_187818691 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_187818691;
        // ---------- Original Method ----------
        //float density = mContext.getResources().getDisplayMetrics().density;
        //return density / getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.716 -0400", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "4BD50FA93ED4A15E9E46DA01D5C5265E")
     float getReadingLevelScale() {
        float var44DB53B9B3C50B031CB12B3205E80427_565441641 = (mZoomManager.getReadingLevelScale());
        float var546ADE640B6EDFBC8A086EF31347E768_1094190470 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1094190470;
        // ---------- Original Method ----------
        //return mZoomManager.getReadingLevelScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.716 -0400", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "A669DD2428D6D398CDA8A0507B53AE6C")
    public void setInitialScale(int scaleInPercent) {
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
        addTaint(scaleInPercent);
        // ---------- Original Method ----------
        //checkThread();
        //mZoomManager.setInitialScaleInPercent(scaleInPercent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.730 -0400", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "44C10A2BC78BACE99A8B9013C9643D7C")
    public void invokeZoomPicker() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_1213133104 = (!getSettings().supportZoom());
        } //End collapsed parenthetic
        clearHelpers();
        mZoomManager.invokeZoomPicker();
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return;
        //}
        //clearHelpers();
        //mZoomManager.invokeZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.730 -0400", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "381C2E9F98639B9578AA3DF3C84AF47F")
    public HitTestResult getHitTestResult() {
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_1150651082 = null; //Variable for return #1
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1150651082 = hitTestResult(mInitialHitTestResult);
        varB4EAC82CA7396A68D541C85D26508E83_1150651082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1150651082;
        // ---------- Original Method ----------
        //checkThread();
        //return hitTestResult(mInitialHitTestResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.731 -0400", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "7A12142CCA3FB3B648F8C4953FC36EB8")
    private HitTestResult hitTestResult(HitTestResult fallback) {
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_1058519243 = null; //Variable for return #1
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_1208825453 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1058519243 = null;
        } //End block
        HitTestResult result;
        result = new HitTestResult();
        {
            boolean var5225ACD2E56334E54962D68427F36819_1722769659 = (nativeHasCursorNode());
            {
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_219078132 = (nativeCursorIsTextInput());
                    {
                        result.setType(HitTestResult.EDIT_TEXT_TYPE);
                    } //End block
                    {
                        String text;
                        text = nativeCursorText();
                        {
                            {
                                boolean varC002F8AFED7F549F33D23662D5EE005B_690688179 = (text.startsWith(SCHEME_TEL));
                                {
                                    result.setType(HitTestResult.PHONE_TYPE);
                                    result.setExtra(text.substring(SCHEME_TEL.length()));
                                } //End block
                                {
                                    boolean var8892C872AF1A0DE7CA908AB563D8630A_1374130192 = (text.startsWith(SCHEME_MAILTO));
                                    {
                                        result.setType(HitTestResult.EMAIL_TYPE);
                                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                                    } //End block
                                    {
                                        boolean varC83048191C80A2E63B6D052EA1A2AF29_667688969 = (text.startsWith(SCHEME_GEO));
                                        {
                                            result.setType(HitTestResult.GEO_TYPE);
                                            result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                                        } //End block
                                        {
                                            boolean var559FEC73A68A4A49F5AE8D79C0655989_1647935973 = (nativeCursorIsAnchor());
                                            {
                                                result.setType(HitTestResult.SRC_ANCHOR_TYPE);
                                                result.setExtra(text);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                result = fallback;
            } //End block
        } //End collapsed parenthetic
        int type;
        type = result.getType();
        {
            int contentX;
            contentX = viewToContentX(mLastTouchX + mScrollX);
            int contentY;
            contentY = viewToContentY(mLastTouchY + mScrollY);
            String text;
            text = nativeImageURI(contentX, contentY);
            {
                result.setType(type == HitTestResult.UNKNOWN_TYPE ?
                        HitTestResult.IMAGE_TYPE :
                        HitTestResult.SRC_IMAGE_ANCHOR_TYPE);
                result.setExtra(text);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1208825453 = result;
        addTaint(fallback.getTaint());
        HitTestResult varA7E53CE21691AB073D9660D615818899_1907960381; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1907960381 = varB4EAC82CA7396A68D541C85D26508E83_1058519243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1907960381 = varB4EAC82CA7396A68D541C85D26508E83_1208825453;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1907960381.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1907960381;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.732 -0400", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "2D9829986B8484AC80155FD938D0409A")
    private void domChangedFocus() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1412965607 = (inEditingMode());
            {
                mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.739 -0400", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "FFDE794FA2BD4AA4188487605108B61F")
    public void requestFocusNodeHref(Message hrefMsg) {
        checkThread();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        {
            boolean var5225ACD2E56334E54962D68427F36819_490076499 = (nativeHasCursorNode());
            {
                Rect cursorBounds;
                cursorBounds = nativeGetCursorRingBounds();
                {
                    boolean var445EE3E02909E3AEE38EC98CDB8981EE_1078513809 = (!cursorBounds.contains(contentX, contentY));
                    {
                        int slop;
                        slop = viewToContentDimension(mNavSlop);
                        cursorBounds.inset(-slop, -slop);
                        {
                            boolean varADAA650ED0CC8F602CC684B55A8BD54B_1145995279 = (cursorBounds.contains(contentX, contentY));
                            {
                                contentX = (int) cursorBounds.centerX();
                                contentY = (int) cursorBounds.centerY();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                contentX, contentY, hrefMsg);
        addTaint(hrefMsg.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (hrefMsg == null) {
            //return;
        //}
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //if (nativeHasCursorNode()) {
            //Rect cursorBounds = nativeGetCursorRingBounds();
            //if (!cursorBounds.contains(contentX, contentY)) {
                //int slop = viewToContentDimension(mNavSlop);
                //cursorBounds.inset(-slop, -slop);
                //if (cursorBounds.contains(contentX, contentY)) {
                    //contentX = (int) cursorBounds.centerX();
                    //contentY = (int) cursorBounds.centerY();
                //}
            //}
        //}
        //mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                //contentX, contentY, hrefMsg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.740 -0400", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "24A5F26A8FAF397E8317B17ACFFFF6DB")
    public void requestImageRef(Message msg) {
        checkThread();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        String ref;
        ref = nativeImageURI(contentX, contentY);
        Bundle data;
        data = msg.getData();
        data.putString("url", ref);
        msg.setData(data);
        msg.sendToTarget();
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //String ref = nativeImageURI(contentX, contentY);
        //Bundle data = msg.getData();
        //data.putString("url", ref);
        //msg.setData(data);
        //msg.sendToTarget();
    }

    
        static int pinLoc(int x, int viewMax, int docMax) {
        if (docMax < viewMax) {   
            x = 0;
        } else if (x < 0) {
            x = 0;
        } else if (x + viewMax > docMax) {
            x = docMax - viewMax;
        }
        return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.752 -0400", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "13B768E98F30644E0530634DFEA8FDE5")
     int pinLocX(int x) {
        int var07118715F745D512C238AD2FEDFE6515_1615689642 = (pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange()));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797194328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797194328;
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return x;
        //return pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.753 -0400", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "05E67B46BBBBB90F1C2A9E139890E268")
     int pinLocY(int y) {
        int var2B535EA2474A113BEF6C4806B3E88FC9_761066908 = (pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight()));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614160312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614160312;
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return y;
        //return pinLoc(y, getViewHeightWithTitle(),
                      //computeRealVerticalScrollRange() + getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.754 -0400", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "ACD1483F1BBDEE0E7592DDAEFDFCCB2F")
    public void setEmbeddedTitleBar(View v) {
        {
            removeView(mTitleBar);
        } //End block
        {
            addView(v, new AbsoluteLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        } //End block
        mTitleBar = v;
        // ---------- Original Method ----------
        //if (mTitleBar == v) return;
        //if (mTitleBar != null) {
            //removeView(mTitleBar);
        //}
        //if (null != v) {
            //addView(v, new AbsoluteLayout.LayoutParams(
                    //ViewGroup.LayoutParams.MATCH_PARENT,
                    //ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        //}
        //mTitleBar = v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.754 -0400", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "105D592E955DBF7BD60D7B2C46CA6B79")
    public void setTitleBarGravity(int gravity) {
        mTitleGravity = gravity;
        invalidate();
        // ---------- Original Method ----------
        //mTitleGravity = gravity;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.755 -0400", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "51A127A3521AC199DA69A0A7C5E5C980")
    private int viewToContentDimension(int d) {
        int var6C6E42DD517C7D3B9A717F110B422373_1908502349 = (Math.round(d * mZoomManager.getInvScale()));
        addTaint(d);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597429598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_597429598;
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.755 -0400", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "02617AA80D8CED8590F8AC88CB8DF44F")
     int viewToContentX(int x) {
        int var8DEE0558B14D500E1B85CE5222A73912_1324770031 = (viewToContentDimension(x));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540587223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540587223;
        // ---------- Original Method ----------
        //return viewToContentDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.758 -0400", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "4908EB6DAEE88CA451F922B0F1D74771")
     int viewToContentY(int y) {
        int var7B97DA5C6E7937A4956BCED3C768F5E3_721092315 = (viewToContentDimension(y - getTitleHeight()));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535859364 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535859364;
        // ---------- Original Method ----------
        //return viewToContentDimension(y - getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.764 -0400", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "25844ADD43E28F6DB45E3AC1E687C2FD")
    private float viewToContentXf(int x) {
        float var8A8AB39BD9FBE3D7753B44FE92DB7211_548250784 = (x * mZoomManager.getInvScale());
        addTaint(x);
        float var546ADE640B6EDFBC8A086EF31347E768_1074656141 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1074656141;
        // ---------- Original Method ----------
        //return x * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.768 -0400", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "954FE6354555D8E94BC5F19A34F4AEC2")
    private float viewToContentYf(int y) {
        float var831D90CB537843A85A184EBC2C0DA386_928166867 = ((y - getTitleHeight()) * mZoomManager.getInvScale());
        addTaint(y);
        float var546ADE640B6EDFBC8A086EF31347E768_158537319 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_158537319;
        // ---------- Original Method ----------
        //return (y - getTitleHeight()) * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.769 -0400", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "C20530EBBCAF83E47E232F2AACEC66BB")
     int contentToViewDimension(int d) {
        int var330434C37CE0501EDFCFE74FEF711C69_796123146 = (Math.round(d * mZoomManager.getScale()));
        addTaint(d);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337205180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337205180;
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.769 -0400", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "717C84000A1D2C4C0FB57072C071043F")
     int contentToViewX(int x) {
        int var5F9CD9178F56CA92BE57B17CD7626740_1866543235 = (contentToViewDimension(x));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845445276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845445276;
        // ---------- Original Method ----------
        //return contentToViewDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.781 -0400", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "5B10583E9FBE49F42FD67EA3D3ED7ED6")
     int contentToViewY(int y) {
        int varFF4BC4A064C1180EFE780BDD5AD7DDE0_92250783 = (contentToViewDimension(y) + getTitleHeight());
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926760977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926760977;
        // ---------- Original Method ----------
        //return contentToViewDimension(y) + getTitleHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.781 -0400", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "690E860B69DB2D21D5CB715A0E0322A3")
    private Rect contentToViewRect(Rect x) {
        Rect varB4EAC82CA7396A68D541C85D26508E83_330829205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_330829205 = new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom));
        addTaint(x.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_330829205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_330829205;
        // ---------- Original Method ----------
        //return new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        //contentToViewX(x.right), contentToViewY(x.bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.781 -0400", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "74741CC19AFF5C0702026E38C8BA3FC4")
    private void viewInvalidate(int l, int t, int r, int b) {
        float scale;
        scale = mZoomManager.getScale();
        int dy;
        dy = getTitleHeight();
        invalidate((int)Math.floor(l * scale),
                   (int)Math.floor(t * scale) + dy,
                   (int)Math.ceil(r * scale),
                   (int)Math.ceil(b * scale) + dy);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //invalidate((int)Math.floor(l * scale),
                   //(int)Math.floor(t * scale) + dy,
                   //(int)Math.ceil(r * scale),
                   //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.782 -0400", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "B4E2F05E4ABCDC1F1A2DB0FA35190D7D")
    private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        float scale;
        scale = mZoomManager.getScale();
        int dy;
        dy = getTitleHeight();
        postInvalidateDelayed(delay,
                              (int)Math.floor(l * scale),
                              (int)Math.floor(t * scale) + dy,
                              (int)Math.ceil(r * scale),
                              (int)Math.ceil(b * scale) + dy);
        addTaint(delay);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //postInvalidateDelayed(delay,
                              //(int)Math.floor(l * scale),
                              //(int)Math.floor(t * scale) + dy,
                              //(int)Math.ceil(r * scale),
                              //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.782 -0400", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "B54B454F3534075365CB5855DEB81B75")
    private void invalidateContentRect(Rect r) {
        viewInvalidate(r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //viewInvalidate(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.782 -0400", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "5847048DB193138D46100A4DCE1A2FEE")
    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.783 -0400", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "13A85CE6B39D7B33D042534033397FBE")
    private void recordNewContentSize(int w, int h, boolean updateLayout) {
        {
            mContentWidth = w;
            mContentHeight = h;
            {
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_327582183 = (!mScroller.isFinished());
                    {
                        mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                        mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        contentSizeChanged(updateLayout);
        addTaint(updateLayout);
        // ---------- Original Method ----------
        //if ((w | h) == 0) {
            //return;
        //}
        //if (mContentWidth != w || mContentHeight != h) {
            //mContentWidth = w;
            //mContentHeight = h;
            //if (!mDrawHistory) {
                //updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                //if (!mScroller.isFinished()) {
                    //mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                    //mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                //}
            //}
        //}
        //contentSizeChanged(updateLayout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.791 -0400", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "213094CBB0F2C3AFD7DD9E550BE54FD4")
     Rect sendOurVisibleRect() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_932901977 = null; //Variable for return #1
        Rect varB4EAC82CA7396A68D541C85D26508E83_701312913 = null; //Variable for return #2
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_1122595740 = (mZoomManager.isPreventingWebkitUpdates());
            varB4EAC82CA7396A68D541C85D26508E83_932901977 = mLastVisibleRectSent;
        } //End collapsed parenthetic
        calcOurContentVisibleRect(mVisibleRect);
        {
            boolean var00DE442F9F80E5CC469870BAE951674E_653088101 = (!mVisibleRect.equals(mLastVisibleRectSent));
            {
                {
                    mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                    mWebViewCore.removeMessages(EventHub.SET_SCROLL_OFFSET);
                    mWebViewCore.sendMessage(EventHub.SET_SCROLL_OFFSET,
                        nativeMoveGeneration(), mSendScrollEvent ? 1 : 0, mScrollOffset);
                } //End block
                mLastVisibleRectSent.set(mVisibleRect);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3D2FB3EC4A2EF0714518F74D7378575D_458401591 = (getGlobalVisibleRect(mGlobalVisibleRect)
                && !mGlobalVisibleRect.equals(mLastGlobalRect));
            {
                {
                    mWebViewCore.sendMessage(EventHub.SET_GLOBAL_BOUNDS, mGlobalVisibleRect);
                } //End block
                mLastGlobalRect.set(mGlobalVisibleRect);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_701312913 = mVisibleRect;
        Rect varA7E53CE21691AB073D9660D615818899_1563949822; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1563949822 = varB4EAC82CA7396A68D541C85D26508E83_932901977;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1563949822 = varB4EAC82CA7396A68D541C85D26508E83_701312913;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1563949822.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1563949822;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.803 -0400", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "621284844C145592B489342B5A7E1CD8")
    private void calcOurVisibleRect(Rect r) {
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //getGlobalVisibleRect(r, mGlobalVisibleOffset);
        //r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.803 -0400", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "E477C760DC9C30F068516CB5785134AA")
    private void calcOurContentVisibleRect(Rect r) {
        calcOurVisibleRect(r);
        r.left = viewToContentX(r.left);
        r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        r.right = viewToContentX(r.right);
        r.bottom = viewToContentY(r.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //calcOurVisibleRect(r);
        //r.left = viewToContentX(r.left);
        //r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentX(r.right);
        //r.bottom = viewToContentY(r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.804 -0400", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "ADD074226841074401ED75CFBAECD66A")
    private void calcOurContentVisibleRectF(RectF r) {
        calcOurVisibleRect(mContentVisibleRect);
        r.left = viewToContentXf(mContentVisibleRect.left);
        r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        r.right = viewToContentXf(mContentVisibleRect.right);
        r.bottom = viewToContentYf(mContentVisibleRect.bottom);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //calcOurVisibleRect(mContentVisibleRect);
        //r.left = viewToContentXf(mContentVisibleRect.left);
        //r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentXf(mContentVisibleRect.right);
        //r.bottom = viewToContentYf(mContentVisibleRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.809 -0400", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "C0029B3C81DFB14F1AF0E234EF4B1979")
     boolean sendViewSizeZoom(boolean force) {
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_173959459 = (mZoomManager.isPreventingWebkitUpdates());
        } //End collapsed parenthetic
        int viewWidth;
        viewWidth = getViewWidth();
        int newWidth;
        newWidth = Math.round(viewWidth * mZoomManager.getInvScale());
        int viewHeight;
        viewHeight = getViewHeightWithTitle() - getTitleHeight();
        int newHeight;
        newHeight = Math.round(viewHeight * mZoomManager.getInvScale());
        float heightWidthRatio;
        heightWidthRatio = (float) viewHeight / viewWidth;
        {
            newHeight = 0;
            heightWidthRatio = 0;
        } //End block
        int actualViewHeight;
        actualViewHeight = Math.round(getViewHeight() * mZoomManager.getInvScale());
        {
            ViewSizeData data;
            data = new ViewSizeData();
            data.mWidth = newWidth;
            data.mHeight = newHeight;
            data.mHeightWidthRatio = heightWidthRatio;
            data.mActualViewHeight = actualViewHeight;
            data.mTextWrapWidth = Math.round(viewWidth / mZoomManager.getTextWrapScale());
            data.mScale = mZoomManager.getScale();
            data.mIgnoreHeight = mZoomManager.isFixedLengthAnimationInProgress()
                    && !mHeightCanMeasure;
            data.mAnchorX = mZoomManager.getDocumentAnchorX();
            data.mAnchorY = mZoomManager.getDocumentAnchorY();
            mWebViewCore.sendMessage(EventHub.VIEW_SIZE_CHANGED, data);
            mLastWidthSent = newWidth;
            mLastHeightSent = newHeight;
            mLastActualHeightSent = actualViewHeight;
            mZoomManager.clearDocumentAnchor();
        } //End block
        addTaint(force);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834557149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834557149;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.810 -0400", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "66D3D3FD49D711BB73D221CCBEFC543D")
     void updateDoubleTapZoom(int doubleTapZoom) {
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
        addTaint(doubleTapZoom);
        // ---------- Original Method ----------
        //mZoomManager.updateDoubleTapZoom(doubleTapZoom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.810 -0400", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "26D72F3D2CAB69BBB25793DF5076F673")
    private int computeRealHorizontalScrollRange() {
        {
            int varFC9DBABA45B6BB7366F73B80D989E991_853249386 = ((int) Math.floor(mContentWidth * mZoomManager.getScale()));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816254102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816254102;
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryWidth;
        //} else {
            //return (int) Math.floor(mContentWidth * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.830 -0400", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "F51061D395B3F0AB191492FF5421FE31")
    @Override
    protected int computeHorizontalScrollRange() {
        int range;
        range = computeRealHorizontalScrollRange();
        int scrollX;
        scrollX = mScrollX;
        int overscrollRight;
        overscrollRight = computeMaxScrollX();
        {
            range -= scrollX;
        } //End block
        {
            range += scrollX - overscrollRight;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269727730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269727730;
        // ---------- Original Method ----------
        //int range = computeRealHorizontalScrollRange();
        //final int scrollX = mScrollX;
        //final int overscrollRight = computeMaxScrollX();
        //if (scrollX < 0) {
            //range -= scrollX;
        //} else if (scrollX > overscrollRight) {
            //range += scrollX - overscrollRight;
        //}
        //return range;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.830 -0400", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "27CA1524484CF8154B3A683A0133594E")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var39399E7590852488423D31BF8E113523_1623955299 = (Math.max(mScrollX, 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802156645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802156645;
        // ---------- Original Method ----------
        //return Math.max(mScrollX, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.831 -0400", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "01ADAD905D31B8AF3BCB2FA798663A90")
    private int computeRealVerticalScrollRange() {
        {
            int var6B23C2077842EB549029F0B0D2DC4BA6_1761180207 = ((int) Math.floor(mContentHeight * mZoomManager.getScale()));
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155751910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155751910;
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryHeight;
        //} else {
            //return (int) Math.floor(mContentHeight * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.831 -0400", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "9DAFC091927B095E6F27DD4EF8E04C92")
    @Override
    protected int computeVerticalScrollRange() {
        int range;
        range = computeRealVerticalScrollRange();
        int scrollY;
        scrollY = mScrollY;
        int overscrollBottom;
        overscrollBottom = computeMaxScrollY();
        {
            range -= scrollY;
        } //End block
        {
            range += scrollY - overscrollBottom;
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067748837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067748837;
        // ---------- Original Method ----------
        //int range = computeRealVerticalScrollRange();
        //final int scrollY = mScrollY;
        //final int overscrollBottom = computeMaxScrollY();
        //if (scrollY < 0) {
            //range -= scrollY;
        //} else if (scrollY > overscrollBottom) {
            //range += scrollY - overscrollBottom;
        //}
        //return range;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.832 -0400", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "367764CD2D154A1D51FA2C3E911131CB")
    @Override
    protected int computeVerticalScrollOffset() {
        int var34E847664C51512EE9641EF813607EB4_171549203 = (Math.max(mScrollY - getTitleHeight(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067652310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2067652310;
        // ---------- Original Method ----------
        //return Math.max(mScrollY - getTitleHeight(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.832 -0400", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "6A7548ECDEAD2FAE6EFC697930C5B391")
    @Override
    protected int computeVerticalScrollExtent() {
        int varE85BFDDBDAAF56CEC1CA21E104DA822F_943783246 = (getViewHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531576039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1531576039;
        // ---------- Original Method ----------
        //return getViewHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.845 -0400", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "C078B8AB53436C68A73322BA00A5B7EA")
    @Override
    protected void onDrawVerticalScrollBar(Canvas canvas,
                                           Drawable scrollBar,
                                           int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            t -= mScrollY;
        } //End block
        scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        scrollBar.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(scrollBar.getTaint());
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //if (mScrollY < 0) {
            //t -= mScrollY;
        //}
        //scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.846 -0400", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "CC63AE8D6EE9FB3164E527B461D76879")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            scrollLayerTo(scrollX, scrollY);
        } //End block
        mInOverScrollMode = false;
        int maxX;
        maxX = computeMaxScrollX();
        int maxY;
        maxY = computeMaxScrollY();
        {
            scrollX = pinLocX(scrollX);
        } //End block
        {
            mInOverScrollMode = true;
        } //End block
        {
            mInOverScrollMode = true;
        } //End block
        int oldX;
        oldX = mScrollX;
        int oldY;
        oldY = mScrollY;
        super.scrollTo(scrollX, scrollY);
        {
            mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        } //End block
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        // ---------- Original Method ----------
        //if (mTouchMode == TOUCH_DRAG_LAYER_MODE) {
            //scrollLayerTo(scrollX, scrollY);
            //return;
        //}
        //mInOverScrollMode = false;
        //int maxX = computeMaxScrollX();
        //int maxY = computeMaxScrollY();
        //if (maxX == 0) {
            //scrollX = pinLocX(scrollX);
        //} else if (scrollX < 0 || scrollX > maxX) {
            //mInOverScrollMode = true;
        //}
        //if (scrollY < 0 || scrollY > maxY) {
            //mInOverScrollMode = true;
        //}
        //int oldX = mScrollX;
        //int oldY = mScrollY;
        //super.scrollTo(scrollX, scrollY);
        //if (mOverScrollGlow != null) {
            //mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.847 -0400", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "F2F511E15A363C6031E12FB936EE3D00")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_856242358 = null; //Variable for return #1
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_856242358 = h != null ? h.getUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_856242358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_856242358;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.847 -0400", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "D8C28B8D27AC9400E0178CCD16C4E93B")
    public String getOriginalUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1962012969 = null; //Variable for return #1
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1962012969 = h != null ? h.getOriginalUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1962012969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1962012969;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getOriginalUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.856 -0400", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "14DBCB7131C97D1998D18849E6F68C10")
    public String getTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_1680715525 = null; //Variable for return #1
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1680715525 = h != null ? h.getTitle() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1680715525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1680715525;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTitle() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.856 -0400", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "2F9B4BDC33366237CA426EF71ADA634A")
    public Bitmap getFavicon() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1919853385 = null; //Variable for return #1
        checkThread();
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1919853385 = h != null ? h.getFavicon() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1919853385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1919853385;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getFavicon() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.857 -0400", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "8D8EBF9DAF1DFAA612AA9E1AB32A8C9F")
    public String getTouchIconUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1752578876 = null; //Variable for return #1
        WebHistoryItem h;
        h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1752578876 = h != null ? h.getTouchIconUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1752578876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1752578876;
        // ---------- Original Method ----------
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTouchIconUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.857 -0400", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "8913C7C3FF9966C9480EC59B1DA08EA7")
    public int getProgress() {
        checkThread();
        int var7E8F23F5531EF375BC02F70B93667140_240802884 = (mCallbackProxy.getProgress());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810978923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1810978923;
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getProgress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.857 -0400", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "E36152CC517026EA6A021A4404B1F2C8")
    public int getContentHeight() {
        checkThread();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254101277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254101277;
        // ---------- Original Method ----------
        //checkThread();
        //return mContentHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.858 -0400", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "8F82486350B46D08E1C5FC703576091B")
    public int getContentWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533432915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533432915;
        // ---------- Original Method ----------
        //return mContentWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.858 -0400", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "0796C1C48EAD4512CFD7326BBFD27CAD")
    public int getPageBackgroundColor() {
        int varDEEC2470ADDE0DE678B2B89837C36FF8_1719505373 = (nativeGetBackgroundColor());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939839705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_939839705;
        // ---------- Original Method ----------
        //return nativeGetBackgroundColor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.868 -0400", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "651F867BAFC105E7B600DA6E0DB6200B")
    public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.871 -0400", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "FCEBD265F9D78FA6297E394388314989")
    public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.884 -0400", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "9A2C91217964AFD85BD7C1DC25019147")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
        {
            mIsPaused = true;
            mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            {
                mHTML5VideoViewProxy.pauseAndDispatch();
            } //End block
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            cancelSelectDialog();
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (!mIsPaused) {
            //mIsPaused = true;
            //mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            //if (mHTML5VideoViewProxy != null) {
                //mHTML5VideoViewProxy.pauseAndDispatch();
            //}
            //if (mNativeClass != 0) {
                //nativeSetPauseDrawing(mNativeClass, true);
            //}
            //cancelSelectDialog();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.885 -0400", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "FCFC44FC2D661CF352F4B01F8E0B1C18")
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowVisibilityChanged(visibility);
        updateDrawingState();
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //updateDrawingState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.885 -0400", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "9F4726F6CBF62887F82242D3B0349A1F")
     void updateDrawingState() {
        {
            boolean var7C64E366ECC1C3C33738983696089D46_537642869 = (getWindowVisibility() != VISIBLE);
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_54444553 = (getVisibility() != VISIBLE);
                {
                    nativeSetPauseDrawing(mNativeClass, true);
                } //End block
                {
                    nativeSetPauseDrawing(mNativeClass, false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mNativeClass == 0 || mIsPaused) return;
        //if (getWindowVisibility() != VISIBLE) {
            //nativeSetPauseDrawing(mNativeClass, true);
        //} else if (getVisibility() != VISIBLE) {
            //nativeSetPauseDrawing(mNativeClass, true);
        //} else {
            //nativeSetPauseDrawing(mNativeClass, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.886 -0400", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "FED5B336FC4FDC2946193D66C38CB80D")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
        {
            mIsPaused = false;
            mWebViewCore.sendMessage(EventHub.ON_RESUME);
            {
                nativeSetPauseDrawing(mNativeClass, false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mIsPaused) {
            //mIsPaused = false;
            //mWebViewCore.sendMessage(EventHub.ON_RESUME);
            //if (mNativeClass != 0) {
                //nativeSetPauseDrawing(mNativeClass, false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.901 -0400", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "38CD861632ACB5E10861065040E95DEF")
    public boolean isPaused() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192163322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192163322;
        // ---------- Original Method ----------
        //return mIsPaused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.902 -0400", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "7D54396D1E9C804F1A90D8C86B6B65FA")
    public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.902 -0400", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "0D4899F7FD9DC156BDFBF42FF0AB7E69")
    public void clearCache(boolean includeDiskFiles) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                includeDiskFiles ? 1 : 0, 0);
        addTaint(includeDiskFiles);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                //includeDiskFiles ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.902 -0400", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "73092FB4E3DE4D8A4A7736918A176A74")
    public void clearFormData() {
        checkThread();
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1309782916 = (inEditingMode());
            {
                mWebTextView.setAdapterCustom(null);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //checkThread();
        //if (inEditingMode()) {
            //mWebTextView.setAdapterCustom(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.903 -0400", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "2F018CB7C6DC1FE54A157AEDF3AD6E80")
    public void clearHistory() {
        checkThread();
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.getBackForwardList().setClearPending();
        //mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.903 -0400", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "36E442E384C566FE65DE22F84677463B")
    public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.904 -0400", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "29137080ACDE2386B78BC82AC2166FBD")
    public WebBackForwardList copyBackForwardList() {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1907129060 = null; //Variable for return #1
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1907129060 = mCallbackProxy.getBackForwardList().clone();
        varB4EAC82CA7396A68D541C85D26508E83_1907129060.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1907129060;
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getBackForwardList().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.904 -0400", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "22FA17683790C382B57E0A3D679867C2")
    public void findNext(boolean forward) {
        checkThread();
        nativeFindNext(forward);
        addTaint(forward);
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //nativeFindNext(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.920 -0400", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "EDCC29049619DB9A27EE6C93F867D5BB")
    public int findAll(String find) {
        checkThread();
        int result;
        result = nativeFindAll(find.toLowerCase(),
                find.toUpperCase(), find.equalsIgnoreCase(mLastFind));
        result = 0;
        invalidate();
        mLastFind = find;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371995333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371995333;
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return 0;
        //int result = find != null ? nativeFindAll(find.toLowerCase(),
                //find.toUpperCase(), find.equalsIgnoreCase(mLastFind)) : 0;
        //invalidate();
        //mLastFind = find;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.921 -0400", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "4ECDD6B41CDD27006B0AE6129453DFA5")
    public boolean showFindDialog(String text, boolean showIme) {
        checkThread();
        FindActionModeCallback callback;
        callback = new FindActionModeCallback(mContext);
        {
            boolean varD263546D355C6FB3DF70E9DF8F0F7FDE_1148531145 = (getParent() == null || startActionMode(callback) == null);
        } //End collapsed parenthetic
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = callback;
        setFindIsUp(true);
        mFindCallback.setWebView(this);
        {
            mFindCallback.showSoftInput();
        } //End block
        {
            mFindCallback.setText(text);
            mFindCallback.findAll();
        } //End block
        {
            text = mLastFind;
        } //End block
        {
            mFindCallback.setText(text);
        } //End block
        addTaint(text.getTaint());
        addTaint(showIme);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363515862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363515862;
        // ---------- Original Method ----------
        //checkThread();
        //FindActionModeCallback callback = new FindActionModeCallback(mContext);
        //if (getParent() == null || startActionMode(callback) == null) {
            //return false;
        //}
        //mCachedOverlappingActionModeHeight = -1;
        //mFindCallback = callback;
        //setFindIsUp(true);
        //mFindCallback.setWebView(this);
        //if (showIme) {
            //mFindCallback.showSoftInput();
        //} else if (text != null) {
            //mFindCallback.setText(text);
            //mFindCallback.findAll();
            //return true;
        //}
        //if (text == null) {
            //text = mLastFind;
        //}
        //if (text != null) {
            //mFindCallback.setText(text);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.921 -0400", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "004C2AC6F57CA6FE3ADD79D9BCCEDF05")
    private void setFindIsUp(boolean isUp) {
        mFindIsUp = isUp;
        nativeSetFindIsUp(isUp);
        // ---------- Original Method ----------
        //mFindIsUp = isUp;
        //if (0 == mNativeClass) return;
        //nativeSetFindIsUp(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.922 -0400", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "D5C019F7132710972CFF6BC9093724D1")
     int findIndex() {
        int var790C769C9D30EC8562E6C6B0E7276107_1511775787 = (nativeFindIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776402816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776402816;
        // ---------- Original Method ----------
        //if (0 == mNativeClass) return -1;
        //return nativeFindIndex();
    }

    
        public static String findAddress(String addr) {
        checkThread();
        return findAddress(addr, false);
    }

    
        public static String findAddress(String addr, boolean caseInsensitive) {
        return WebViewCore.nativeFindAddress(addr, caseInsensitive);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.934 -0400", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "1AF0A7969A405E9ACF74B77D7B7D1CBC")
    public void clearMatches() {
        checkThread();
        nativeSetFindIsEmpty();
        invalidate();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0)
            //return;
        //nativeSetFindIsEmpty();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.934 -0400", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "948A2F13512D200DBE7FFC5B15A696B2")
     void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
        clearMatches();
        setFindIsUp(false);
        pinScrollTo(mScrollX, mScrollY, false, 0);
        invalidate();
        // ---------- Original Method ----------
        //mFindCallback = null;
        //mCachedOverlappingActionModeHeight = -1;
        //if (mWebViewCore == null) {
            //return;
        //}
        //clearMatches();
        //setFindIsUp(false);
        //pinScrollTo(mScrollX, mScrollY, false, 0);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.935 -0400", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "3103CDCAFE9D854CB60AB60E61FA0C11")
    public void documentHasImages(Message response) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (response == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.936 -0400", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "A83853DA38B09ACCE7BA0F75693DED2D")
    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.forceFinished(true);
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.941 -0400", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "6A86F8C32625EB71A90B5253BCE4612E")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_966555783 = (mScroller.computeScrollOffset());
            {
                int oldX;
                oldX = mScrollX;
                int oldY;
                oldY = mScrollY;
                int x;
                x = mScroller.getCurrX();
                int y;
                y = mScroller.getCurrY();
                invalidate();
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_2133266783 = (!mScroller.isFinished());
                    {
                        int rangeX;
                        rangeX = computeMaxScrollX();
                        int rangeY;
                        rangeY = computeMaxScrollY();
                        int overflingDistance;
                        overflingDistance = mOverflingDistance;
                        {
                            oldX = mScrollingLayerRect.left;
                            oldY = mScrollingLayerRect.top;
                            rangeX = mScrollingLayerRect.right;
                            rangeY = mScrollingLayerRect.bottom;
                            overflingDistance = 0;
                        } //End block
                        overScrollBy(x - oldX, y - oldY, oldX, oldY,
                        rangeX, rangeY,
                        overflingDistance, overflingDistance, false);
                        {
                            mOverScrollGlow.absorbGlow(x, y, oldX, oldY, rangeX, rangeY);
                        } //End block
                    } //End block
                    {
                        {
                            mScrollX = x;
                            mScrollY = y;
                        } //End block
                        {
                            scrollLayerTo(x, y);
                        } //End block
                        abortAnimation();
                        nativeSetIsScrolling(false);
                        {
                            WebViewCore.resumePriority();
                            {
                                WebViewCore.resumeUpdatePicture(mWebViewCore);
                            } //End block
                        } //End block
                        {
                            sendOurVisibleRect();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                super.computeScroll();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.073 -0400", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "9A67CBAEF8EBBB17AC6D00ACF10632ED")
    private void scrollLayerTo(int x, int y) {
        nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        mScrollingLayerRect.left = x;
        mScrollingLayerRect.top = y;
        onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        invalidate();
        // ---------- Original Method ----------
        //if (x == mScrollingLayerRect.left && y == mScrollingLayerRect.top) {
            //return;
        //}
        //nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        //mScrollingLayerRect.left = x;
        //mScrollingLayerRect.top = y;
        //onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        //invalidate();
    }

    
        private static int computeDuration(int dx, int dy) {
        int distance = Math.max(Math.abs(dx), Math.abs(dy));
        int duration = distance * 1000 / STD_SPEED;
        return Math.min(duration, MAX_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.074 -0400", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "63CA4680F97E73FD5CAF386E2D51DF88")
    private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        boolean varDDCD3B201102A2B6BF7DF6BB672D50B5_1203074318 = (pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration));
        addTaint(dx);
        addTaint(dy);
        addTaint(animate);
        addTaint(animationDuration);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641412003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641412003;
        // ---------- Original Method ----------
        //return pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.074 -0400", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "9A8D358092C675ECD495D5127280ABFA")
    private boolean pinScrollTo(int x, int y, boolean animate, int animationDuration) {
        x = pinLocX(x);
        y = pinLocY(y);
        int dx;
        dx = x - mScrollX;
        int dy;
        dy = y - mScrollY;
        abortAnimation();
        {
            mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            awakenScrollBars(mScroller.getDuration());
            invalidate();
        } //End block
        {
            scrollTo(x, y);
        } //End block
        addTaint(x);
        addTaint(y);
        addTaint(animate);
        addTaint(animationDuration);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_384986052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_384986052;
        // ---------- Original Method ----------
        //x = pinLocX(x);
        //y = pinLocY(y);
        //int dx = x - mScrollX;
        //int dy = y - mScrollY;
        //if ((dx | dy) == 0) {
            //return false;
        //}
        //abortAnimation();
        //if (animate) {
            //mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    //animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            //awakenScrollBars(mScroller.getDuration());
            //invalidate();
        //} else {
            //scrollTo(x, y);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.075 -0400", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "8562FAC508539AC8CB7E2F42B4CE3A14")
    private boolean setContentScrollBy(int cx, int cy, boolean animate) {
        cx = contentToViewDimension(cx);
        cy = contentToViewDimension(cy);
        {
            {
                Rect tempRect;
                tempRect = new Rect();
                calcOurVisibleRect(tempRect);
                tempRect.offset(cx, cy);
                requestRectangleOnScreen(tempRect);
            } //End block
            boolean var3FCDFFB9E4E3AC0EFF489E7F0EAB193B_519545859 = (cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0));
        } //End block
        {
            boolean var29BB42B254A3ABD17ABD36618645F129_2006661964 = (pinScrollBy(cx, cy, animate, 0));
        } //End block
        addTaint(cx);
        addTaint(cy);
        addTaint(animate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461271648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461271648;
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return false;
        //}
        //cx = contentToViewDimension(cx);
        //cy = contentToViewDimension(cy);
        //if (mHeightCanMeasure) {
            //if (cy != 0) {
                //Rect tempRect = new Rect();
                //calcOurVisibleRect(tempRect);
                //tempRect.offset(cx, cy);
                //requestRectangleOnScreen(tempRect);
            //}
            //return cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0);
        //} else {
            //return pinScrollBy(cx, cy, animate, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.077 -0400", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "FF087F6777B3DE1118FABF8CF93039F6")
     void onPageStarted(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setCertificate(null);
        mAccessibilityScriptInjected = false;
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //setCertificate(null);
        //mAccessibilityScriptInjected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.078 -0400", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "FBD1BCD6849775C7629174AFFCD1D4B4")
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean varE94AF5A5E140E4B674F99180E2533924_1469952882 = (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    && mScrollX == 0 && mScrollY == 0);
                {
                    pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        SLIDE_TITLE_DURATION);
                } //End block
            } //End collapsed parenthetic
            mPageThatNeedsToSlideTitleBarOffScreen = null;
        } //End block
        mZoomManager.onPageFinished(url);
        injectAccessibilityForUrl(url);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //if (mPageThatNeedsToSlideTitleBarOffScreen != null) {
            //if (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    //&& mScrollX == 0 && mScrollY == 0) {
                //pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        //SLIDE_TITLE_DURATION);
            //}
            //mPageThatNeedsToSlideTitleBarOffScreen = null;
        //}
        //mZoomManager.onPageFinished(url);
        //injectAccessibilityForUrl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.092 -0400", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "9CCE50B615DAC78F2F5C3CA3E7FA5031")
    private void injectAccessibilityForUrl(String url) {
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(mContext);
        {
            boolean var2F55789C2BAEC4B54A3769DF00E1201A_1343336775 = (!accessibilityManager.isEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var257A8D7DF44254A8F3AFFC587333D831_768025824 = (!getSettings().getJavaScriptEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } //End block
        } //End collapsed parenthetic
        int axsParameterValue;
        axsParameterValue = getAxsUrlParameterValue(url);
        {
            boolean onDeviceScriptInjectionEnabled;
            onDeviceScriptInjectionEnabled = (Settings.Secure.getInt(mContext
                    .getContentResolver(), Settings.Secure.ACCESSIBILITY_SCRIPT_INJECTION, 0) == 1);
            {
                ensureAccessibilityScriptInjectorInstance(false);
                loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
                mAccessibilityScriptInjected = true;
            } //End block
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } //End block
        } //End block
        {
            ensureAccessibilityScriptInjectorInstance(true);
        } //End block
        {
            ensureAccessibilityScriptInjectorInstance(false);
            loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
        } //End block
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.093 -0400", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "335FDA94246D087A35BA7BC63B85318F")
    private void ensureAccessibilityScriptInjectorInstance(boolean present) {
        {
            {
                mAccessibilityInjector = new AccessibilityInjector(this);
            } //End block
        } //End block
        {
            mAccessibilityInjector = null;
        } //End block
        addTaint(present);
        // ---------- Original Method ----------
        //if (present) {
            //if (mAccessibilityInjector == null) {
                //mAccessibilityInjector = new AccessibilityInjector(this);
            //}
        //} else {
            //mAccessibilityInjector = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.106 -0400", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "9E1E570146402CB5F19DCB6507D7DC20")
    private int getAxsUrlParameterValue(String url) {
        {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        } //End block
        Matcher matcher;
        matcher = mMatchAxsUrlParameterPattern.matcher(url);
        {
            boolean var0CA07C7E05B5FB943A39E313382D5DA2_1842917088 = (matcher.find());
            {
                String keyValuePair;
                keyValuePair = url.substring(matcher.start(), matcher.end());
                int varB4575FE2088203A669F7AEBE1DD89AA0_182951709 = (Integer.parseInt(keyValuePair.split("=")[1]));
            } //End block
        } //End collapsed parenthetic
        addTaint(url.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372325223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1372325223;
        // ---------- Original Method ----------
        //if (mMatchAxsUrlParameterPattern == null) {
            //mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        //}
        //Matcher matcher = mMatchAxsUrlParameterPattern.matcher(url);
        //if (matcher.find()) {
            //String keyValuePair = url.substring(matcher.start(), matcher.end());
            //return Integer.parseInt(keyValuePair.split("=")[1]);
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.117 -0400", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "DE2CDBD3F92E9D93E8C3B68DC6CD01B7")
    private boolean setContentScrollTo(int cx, int cy) {
        int vx;
        int vy;
        {
            vx = 0;
            vy = 0;
        } //End block
        {
            vx = contentToViewX(cx);
            vy = contentToViewY(cy);
        } //End block
        {
            {
                boolean varBB2C6738F4D3DE5D7DC74ECC3D92899E_1507985902 = (getProgress() < 100);
                {
                    mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                    mYDistanceToSlideTitleOffScreen = vy;
                } //End block
                {
                    pinScrollTo(vx, vy, true, SLIDE_TITLE_DURATION);
                } //End block
            } //End collapsed parenthetic
        } //End block
        pinScrollTo(vx, vy, false, 0);
        addTaint(cx);
        addTaint(cy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527974082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527974082;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.120 -0400", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "C71FB6A8C0B35BC34157D377B558C66C")
    private void spawnContentScrollTo(int cx, int cy) {
        int vx;
        vx = contentToViewX(cx);
        int vy;
        vy = contentToViewY(cy);
        pinScrollTo(vx, vy, true, 0);
        addTaint(cx);
        addTaint(cy);
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return;
        //}
        //int vx = contentToViewX(cx);
        //int vy = contentToViewY(cy);
        //pinScrollTo(vx, vy, true, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.120 -0400", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "8AEE7C980E0EA5CA85A34B7FAC909EE2")
    private void contentSizeChanged(boolean updateLayout) {
        {
            {
                boolean var687FC976609C320EB23E747E9ECBC12A_2087939510 = (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout);
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7183AB9F5F71646AEDE7ABA21E1DCB83_666854895 = (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    || updateLayout);
                {
                    requestLayout();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sendViewSizeZoom(false);
        } //End block
        addTaint(updateLayout);
        // ---------- Original Method ----------
        //if ((mContentWidth | mContentHeight) == 0) {
            //return;
        //}
        //if (mHeightCanMeasure) {
            //if (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    //|| updateLayout) {
                //requestLayout();
            //}
        //} else if (mWidthCanMeasure) {
            //if (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    //|| updateLayout) {
                //requestLayout();
            //}
        //} else {
            //sendViewSizeZoom(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.122 -0400", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "F3B729784BD18A25F5FDBD218DCB7288")
    public void setWebViewClient(WebViewClient client) {
        checkThread();
        mCallbackProxy.setWebViewClient(client);
        addTaint(client.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebViewClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.124 -0400", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "D4FB6C5AEDF54B4CFE58F9AD68AD07D1")
    public WebViewClient getWebViewClient() {
        WebViewClient varB4EAC82CA7396A68D541C85D26508E83_514900651 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_514900651 = mCallbackProxy.getWebViewClient();
        varB4EAC82CA7396A68D541C85D26508E83_514900651.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514900651;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebViewClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.124 -0400", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "7DE0F204CFF3CDDC346E0D85FFBBBA36")
    public void setDownloadListener(DownloadListener listener) {
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setDownloadListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.126 -0400", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "3D9E8DD1B6C4DFF817488E138E88D2CD")
    public void setWebChromeClient(WebChromeClient client) {
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
        addTaint(client.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebChromeClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.126 -0400", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "09674571C7A8D5620342EFB6C96FE0C5")
    public WebChromeClient getWebChromeClient() {
        WebChromeClient varB4EAC82CA7396A68D541C85D26508E83_540487514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_540487514 = mCallbackProxy.getWebChromeClient();
        varB4EAC82CA7396A68D541C85D26508E83_540487514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_540487514;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebChromeClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.127 -0400", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "151C3157D35633F4DDA39549C419F0CD")
    public void setWebBackForwardListClient(WebBackForwardListClient client) {
        mCallbackProxy.setWebBackForwardListClient(client);
        addTaint(client.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.setWebBackForwardListClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.128 -0400", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "2FC711086962FBCE4C859F7E414D1DA1")
    public WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient varB4EAC82CA7396A68D541C85D26508E83_1643916146 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1643916146 = mCallbackProxy.getWebBackForwardListClient();
        varB4EAC82CA7396A68D541C85D26508E83_1643916146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1643916146;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebBackForwardListClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.155 -0400", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "C3EF422014BE5A0F4249AE48165752C1")
    @Deprecated
    public void setPictureListener(PictureListener listener) {
        checkThread();
        mPictureListener = listener;
        // ---------- Original Method ----------
        //checkThread();
        //mPictureListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.155 -0400", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "AB44FF5C87D068F8B66D0EB04B5B59EC")
    public void externalRepresentation(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.156 -0400", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "F1D6619F174949CADCC64CC888204E8C")
    public void documentAsText(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.156 -0400", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "622B8AAE179508F4718625CF702AD656")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        checkThread();
        WebViewCore.JSInterfaceData arg;
        arg = new WebViewCore.JSInterfaceData();
        arg.mObject = obj;
        arg.mInterfaceName = interfaceName;
        mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
        addTaint(obj.getTaint());
        addTaint(interfaceName.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (obj == null) {
            //return;
        //}
        //WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
        //arg.mObject = obj;
        //arg.mInterfaceName = interfaceName;
        //mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.157 -0400", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "9AACA8614F8D05DB52D6E07CB677981D")
    public void removeJavascriptInterface(String interfaceName) {
        checkThread();
        {
            WebViewCore.JSInterfaceData arg;
            arg = new WebViewCore.JSInterfaceData();
            arg.mInterfaceName = interfaceName;
            mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        } //End block
        addTaint(interfaceName.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (mWebViewCore != null) {
            //WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            //arg.mInterfaceName = interfaceName;
            //mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.157 -0400", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "FBBC07E35F2EEA5C9415154DF442BF41")
    public WebSettings getSettings() {
        WebSettings varB4EAC82CA7396A68D541C85D26508E83_844173565 = null; //Variable for return #1
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_844173565 = (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
        varB4EAC82CA7396A68D541C85D26508E83_844173565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_844173565;
        // ---------- Original Method ----------
        //checkThread();
        //return (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
    }

    
        @Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.158 -0400", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "F63CF9890D2496C37BAC81075ED36118")
    @Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        checkThread();
        addTaint(reloadOpenPages);
        // ---------- Original Method ----------
        //checkThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.160 -0400", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "BEAE568C699B53DE3C1A331CAAB56BE9")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mPrivateHandler.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.159 -0400", hash_original_method = "C35D8FF76F468647EBD4843DB70BD70E", hash_generated_method = "1D1962C885A4B76385563869BB6544A0")
                    @Override
                    public void run() {
                        destroy();
                        // ---------- Original Method ----------
                        //destroy();
                    }
});
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (mNativeClass != 0) {
                //mPrivateHandler.post(new Runnable() {
                    //@Override
                    //public void run() {
                        //destroy();
                    //}
                //});
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.162 -0400", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "CEAE0C4400376008D02687D3AF8F37D0")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        {
            mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            int newTop;
            newTop = 0;
            {
                newTop = Math.min(0, mScrollY);
            } //End block
            {
                newTop = mScrollY;
            } //End block
            mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            mTitleBar.setTop(newTop);
        } //End block
        boolean var2713BACF81F43D1C388D129F1A927E0D_591167111 = (super.drawChild(canvas, child, drawingTime));
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_153338916 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_153338916;
        // ---------- Original Method ----------
        //if (child == mTitleBar) {
            //mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            //int newTop = 0;
            //if (mTitleGravity == Gravity.NO_GRAVITY) {
                //newTop = Math.min(0, mScrollY);
            //} else if (mTitleGravity == Gravity.TOP) {
                //newTop = mScrollY;
            //}
            //mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            //mTitleBar.setTop(newTop);
        //}
        //return super.drawChild(canvas, child, drawingTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.163 -0400", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "B19EBDB86B0C7374E5043A66E795BD08")
    private void drawContent(Canvas canvas, boolean drawRings) {
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
        addTaint(canvas.getTaint());
        addTaint(drawRings);
        // ---------- Original Method ----------
        //drawCoreAndCursorRing(canvas, mBackgroundColor,
                //mDrawCursorRing && drawRings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.176 -0400", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "57930526223745B18D01C276A5148C64")
    private void drawOverScrollBackground(Canvas canvas) {
        {
            mOverScrollBackground = new Paint();
            Bitmap bm;
            bm = BitmapFactory.decodeResource(
                    mContext.getResources(),
                    com.android.internal.R.drawable.status_bar_background);
            mOverScrollBackground.setShader(new BitmapShader(bm,
                    Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            mOverScrollBorder = new Paint();
            mOverScrollBorder.setStyle(Paint.Style.STROKE);
            mOverScrollBorder.setStrokeWidth(0);
            mOverScrollBorder.setColor(0xffbbbbbb);
        } //End block
        int top;
        top = 0;
        int right;
        right = computeRealHorizontalScrollRange();
        int bottom;
        bottom = top + computeRealVerticalScrollRange();
        canvas.save();
        canvas.translate(mScrollX, mScrollY);
        canvas.clipRect(-mScrollX, top - mScrollY, right - mScrollX, bottom
                - mScrollY, Region.Op.DIFFERENCE);
        canvas.drawPaint(mOverScrollBackground);
        canvas.restore();
        canvas.drawRect(-1, top - 1, right, bottom, mOverScrollBorder);
        canvas.clipRect(0, top, right, bottom);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.179 -0400", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "41C1BB81314858C923A7480D9205CF1A")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            canvas.drawColor(mBackgroundColor);
        } //End block
        {
            canvas.drawColor(mBackgroundColor);
        } //End block
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_242413364 = (canvas.isHardwareAccelerated());
            {
                {
                    mIncrementEGLContextHack = true;
                    EGL10 egl;
                    egl = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglDisplay;
                    eglDisplay = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    int[] version;
                    version = new int[2];
                    egl.eglInitialize(eglDisplay, version);
                } //End block
                mZoomManager.setHardwareAccelerated();
            } //End block
        } //End collapsed parenthetic
        int saveCount;
        saveCount = canvas.save();
        {
            boolean var4322EE85B805CBD21A094B57F62ADC23_1716792657 = (mInOverScrollMode && !getSettings()
                .getUseWebViewBackgroundForOverscrollBackground());
            {
                drawOverScrollBackground(canvas);
            } //End block
        } //End collapsed parenthetic
        {
            canvas.translate(0, getTitleHeight());
        } //End block
        boolean drawJavaRings;
        drawJavaRings = !mTouchHighlightRegion.isEmpty()
                && (mTouchMode == TOUCH_INIT_MODE
                || mTouchMode == TOUCH_SHORTPRESS_START_MODE
                || mTouchMode == TOUCH_SHORTPRESS_MODE
                || mTouchMode == TOUCH_DONE_MODE);
        boolean drawNativeRings;
        drawNativeRings = !drawJavaRings;
        {
            drawNativeRings = !drawJavaRings && !isInTouchMode();
        } //End block
        drawContent(canvas, drawNativeRings);
        canvas.restoreToCount(saveCount);
        {
            invalidate();
        } //End block
        mWebViewCore.signalRepaintDone();
        {
            boolean varEFDBDAC0A2DEB3E5103984743E3C9A57_1538933832 = (mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas));
            {
                invalidate();
            } //End block
        } //End collapsed parenthetic
        {
            long delay;
            delay = System.currentTimeMillis() - mTouchHighlightRequested;
            {
                boolean varBCA1B79D766932AE90DE8B5336B437FC_178083768 = (delay < ViewConfiguration.getTapTimeout());
                {
                    Rect r;
                    r = mTouchHighlightRegion.getBounds();
                    postInvalidateDelayed(delay, r.left, r.top, r.right, r.bottom);
                } //End block
                {
                    {
                        mTouchHightlightPaint = new Paint();
                        mTouchHightlightPaint.setColor(HIGHLIGHT_COLOR);
                    } //End block
                    RegionIterator iter;
                    iter = new RegionIterator(mTouchHighlightRegion);
                    Rect r;
                    r = new Rect();
                    {
                        boolean var777D1BAEECB4D7088A7F6E66A69B6796_973582743 = (iter.next(r));
                        {
                            canvas.drawRect(r, mTouchHightlightPaint);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var7909E0FF363982F909528C78CCCF0F02_1914901071 = (getSettings().getNavDump());
                {
                    {
                        {
                            mTouchCrossHairColor = new Paint();
                            mTouchCrossHairColor.setColor(Color.RED);
                        } //End block
                        canvas.drawLine(mTouchHighlightX - mNavSlop,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    + mNavSlop + 1, mTouchHighlightY + mNavSlop
                                    + 1, mTouchCrossHairColor);
                        canvas.drawLine(mTouchHighlightX + mNavSlop + 1,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    - mNavSlop,
                            mTouchHighlightY + mNavSlop + 1,
                            mTouchCrossHairColor);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.179 -0400", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "34A310392E72BEC0A58EE1BE45DD1549")
    private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
        // ---------- Original Method ----------
        //mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        //mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        //setTouchHighlightRects(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.180 -0400", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "6021645F500B5EC19CBD1C4A017AD7F8")
    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        {
            mWrapContent = true;
        } //End block
        super.setLayoutParams(params);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (params.height == LayoutParams.WRAP_CONTENT) {
            //mWrapContent = true;
        //}
        //super.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.180 -0400", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "D27A1F4E9158A9813BBB37E2EA1A8D43")
    @Override
    public boolean performLongClick() {
        {
            boolean var88AD79EA276C28AD3B3469360BCE1788_309988889 = (getParent() == null);
        } //End collapsed parenthetic
        ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        {
            boolean var13D92B99C938B0F2FF8CCF00F803E8A6_409094476 = (detector != null && detector.isInProgress());
        } //End collapsed parenthetic
        {
            boolean var780C0185A33DB3757005E772477A414D_900662779 = (mNativeClass != 0 && nativeCursorIsTextInput());
            {
                centerKeyPressOnTextField();
                rebuildWebTextView();
            } //End block
            {
                clearTextEntry();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1163031254 = (inEditingMode());
            {
                mWebTextView.ensureLayout();
                AbsoluteLayout.LayoutParams params;
                params = (AbsoluteLayout.LayoutParams) mWebTextView.getLayoutParams();
                MotionEvent fake;
                fake = MotionEvent.obtain(mLastTouchTime,
                    mLastTouchTime, MotionEvent.ACTION_DOWN,
                    mLastTouchX - params.x + mScrollX,
                    mLastTouchY - params.y + mScrollY, 0);
                mWebTextView.dispatchTouchEvent(fake);
                boolean var8E1B4A2E9B8893A37E1A84490A65FC9A_2042219897 = (mWebTextView.performLongClick());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varC298D59926924FB0808A70DC864C4372_1150246332 = (super.performLongClick());
        } //End collapsed parenthetic
        boolean isSelecting;
        isSelecting = selectText();
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1470976995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1470976995;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.189 -0400", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "D8A0ECAB1C1F295E3C0019C767BF5B99")
    public boolean selectText() {
        int x;
        x = viewToContentX(mLastTouchX + mScrollX);
        int y;
        y = viewToContentY(mLastTouchY + mScrollY);
        boolean varB29E32086CAB7981D2C629145B25F904_572411302 = (selectText(x, y));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_45156190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_45156190;
        // ---------- Original Method ----------
        //int x = viewToContentX(mLastTouchX + mScrollX);
        //int y = viewToContentY(mLastTouchY + mScrollY);
        //return selectText(x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.189 -0400", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "37E24D92984427DFD9A70510B2AECDD9")
     boolean selectText(int x, int y) {
        {
            boolean varC5ECEC29B03BE800BB553180A5BFDF02_403687613 = (!setUpSelect(true, x, y));
        } //End collapsed parenthetic
        nativeSetExtendSelection();
        mDrawSelectionPointer = false;
        mTouchMode = TOUCH_DRAG_MODE;
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107398850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107398850;
        // ---------- Original Method ----------
        //if (!setUpSelect(true, x, y)) {
            //return false;
        //}
        //nativeSetExtendSelection();
        //mDrawSelectionPointer = false;
        //mTouchMode = TOUCH_DRAG_MODE;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.190 -0400", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "F99C07CA889DE93B7B3F7B16E73BA782")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCachedOverlappingActionModeHeight = -1;
        {
            selectionDone();
        } //End block
        mOrientation = newConfig.orientation;
        {
            mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        } //End block
        // ---------- Original Method ----------
        //mCachedOverlappingActionModeHeight = -1;
        //if (mSelectingText && mOrientation != newConfig.orientation) {
            //selectionDone();
        //}
        //mOrientation = newConfig.orientation;
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.191 -0400", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "AD48D56528787235EC7050CE291AEAE0")
    private boolean didUpdateWebTextViewDimensions(int intersection) {
        Rect contentBounds;
        contentBounds = nativeFocusCandidateNodeBounds();
        Rect vBox;
        vBox = contentToViewRect(contentBounds);
        Rect visibleRect;
        visibleRect = new Rect();
        calcOurVisibleRect(visibleRect);
        offsetByLayerScrollPosition(vBox);
        boolean onScreen;
        //Begin case FULLY_ON_SCREEN 
        onScreen = visibleRect.contains(vBox);
        //End case FULLY_ON_SCREEN 
        //Begin case INTERSECTS_SCREEN 
        onScreen = Rect.intersects(visibleRect, vBox);
        //End case INTERSECTS_SCREEN 
        //Begin case ANYWHERE 
        onScreen = true;
        //End case ANYWHERE 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "invalid parameter passed to didUpdateWebTextViewDimensions");
        //End case default 
        {
            mWebTextView.setRect(vBox.left, vBox.top, vBox.width(),
                    vBox.height());
            mWebTextView.updateTextSize();
            updateWebTextViewPadding();
        } //End block
        {
            mWebTextView.remove();
        } //End block
        addTaint(intersection);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255604312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255604312;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.191 -0400", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "6FF8C68E6537E2A2F0185658B3EFC7A2")
    private void offsetByLayerScrollPosition(Rect box) {
        {
            boolean var9CB7C6698CC8E4B39807B6B5CCF588EA_1530806442 = ((mCurrentScrollingLayerId != 0)
                && (mCurrentScrollingLayerId == nativeFocusCandidateLayerId()));
            {
                box.offsetTo(box.left - mScrollingLayerRect.left,
                    box.top - mScrollingLayerRect.top);
            } //End block
        } //End collapsed parenthetic
        addTaint(box.getTaint());
        // ---------- Original Method ----------
        //if ((mCurrentScrollingLayerId != 0)
                //&& (mCurrentScrollingLayerId == nativeFocusCandidateLayerId())) {
            //box.offsetTo(box.left - mScrollingLayerRect.left,
                    //box.top - mScrollingLayerRect.top);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.191 -0400", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "A0B57FA589AEBAA7F23307B996001032")
     void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                isPictureAfterFirstLayout, registerPageSwapCallback);
        {
            mHTML5VideoViewProxy.setBaseLayer(layer);
        } //End block
        addTaint(layer);
        addTaint(invalRegion.getTaint());
        addTaint(showVisualIndicator);
        addTaint(isPictureAfterFirstLayout);
        addTaint(registerPageSwapCallback);
        // ---------- Original Method ----------
        //if (mNativeClass == 0)
            //return;
        //nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                //isPictureAfterFirstLayout, registerPageSwapCallback);
        //if (mHTML5VideoViewProxy != null) {
            //mHTML5VideoViewProxy.setBaseLayer(layer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.192 -0400", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "1339F226F7217C708F4FA28D05890D10")
     int getBaseLayer() {
        int var56C10FDD99E0FDF412C413A619660025_1695210276 = (nativeGetBaseLayer());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517101400 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517101400;
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return 0;
        //}
        //return nativeGetBaseLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.192 -0400", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "84F9838CF4C4F7D4470C8B59207FE441")
    private void onZoomAnimationStart() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1374153331 = (inEditingMode());
            {
                mWebTextView.setVisibility(INVISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.setVisibility(INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.192 -0400", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "9E86D24AE3636AD72093EFC9DB78641E")
    private void onZoomAnimationEnd() {
        {
            boolean var7CF3A0FDB7A5E846FB3F76D951F33983_483193508 = (inEditingMode()
                && didUpdateWebTextViewDimensions(FULLY_ON_SCREEN));
            {
                mWebTextView.setVisibility(VISIBLE);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& didUpdateWebTextViewDimensions(FULLY_ON_SCREEN)) {
            //mWebTextView.setVisibility(VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.193 -0400", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "1DA8D4977752B15EE1DC244719C6FA7D")
     void onFixedLengthZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //WebViewCore.pauseUpdatePicture(getWebViewCore());
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.193 -0400", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "101EE64BBEBED819506DCE68CFA9A134")
     void onFixedLengthZoomAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            WebViewCore.resumeUpdatePicture(mWebViewCore);
        } //End block
        onZoomAnimationEnd();
        // ---------- Original Method ----------
        //if (!mBlockWebkitViewMessages && !mSelectingText) {
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
        //}
        //onZoomAnimationEnd();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.209 -0400", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "B5AE886ACE6D7FF5C3CE835DB00C53C1")
    private void drawCoreAndCursorRing(Canvas canvas, int color,
        boolean drawCursorRing) {
        {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            canvas.drawPicture(mHistoryPicture);
        } //End block
        boolean animateZoom;
        animateZoom = mZoomManager.isFixedLengthAnimationInProgress();
        boolean animateScroll;
        animateScroll = ((!mScroller.isFinished()
                || mVelocityTracker != null)
                && (mTouchMode != TOUCH_DRAG_MODE ||
                mHeldMotionless != MOTIONLESS_TRUE))
                || mDeferTouchMode == TOUCH_DRAG_MODE;
        {
            {
                mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                mHeldMotionless = MOTIONLESS_FALSE;
            } //End block
            {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(DRAG_HELD_MOTIONLESS), MOTIONLESS_TIME);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                mHeldMotionless = MOTIONLESS_PENDING;
            } //End block
        } //End block
        int saveCount;
        saveCount = canvas.save();
        {
            mZoomManager.animateZoom(canvas);
        } //End block
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1239499370 = (!canvas.isHardwareAccelerated());
            {
                canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            } //End block
        } //End collapsed parenthetic
        boolean UIAnimationsRunning;
        UIAnimationsRunning = false;
        {
            boolean var438456B32769D6A7B316667DCB4406FE_1841997100 = (mNativeClass != 0 && !canvas.isHardwareAccelerated()
                && nativeEvaluateLayersAnimations(mNativeClass));
            {
                UIAnimationsRunning = true;
                mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
                invalidate();
            } //End block
        } //End collapsed parenthetic
        int extras;
        extras = DRAW_EXTRAS_NONE;
        {
            extras = DRAW_EXTRAS_FIND;
        } //End block
        {
            extras = DRAW_EXTRAS_SELECTION;
            nativeSetSelectionPointer(mNativeClass,
                    mDrawSelectionPointer,
                    mZoomManager.getInvScale(), mSelectX, mSelectY - getTitleHeight());
        } //End block
        {
            extras = DRAW_EXTRAS_CURSOR_RING;
        } //End block
        calcOurContentVisibleRectF(mVisibleContentRect);
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_1351701987 = (canvas.isHardwareAccelerated());
            {
                Rect glRectViewport;
                glRectViewport = null;
                glRectViewport = mGLRectViewport;
                Rect viewRectViewport;
                viewRectViewport = null;
                viewRectViewport = mViewRectViewport;
                int functor;
                functor = nativeGetDrawGLFunction(mNativeClass, glRectViewport,
                    viewRectViewport, mVisibleContentRect, getScale(), extras);
                ((HardwareCanvas) canvas).callDrawGLFunction(functor);
                {
                    boolean varB9C4161DF2F7ECD45BDF12D53A873278_1159629708 = (mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled());
                    {
                        mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                        nativeUseHardwareAccelSkia(mHardwareAccelSkia);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                DrawFilter df;
                df = null;
                {
                    boolean varDFCE6862E0CA36047A4C3134A0AB6043_2109913277 = (mZoomManager.isZoomAnimating() || UIAnimationsRunning);
                    {
                        df = mZoomFilter;
                    } //End block
                    {
                        df = mScrollFilter;
                    } //End block
                } //End collapsed parenthetic
                canvas.setDrawFilter(df);
                int content;
                content = nativeDraw(canvas, mVisibleContentRect, color,
                    extras, false);
                canvas.setDrawFilter(null);
                {
                    mWebViewCore.sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        canvas.restoreToCount(saveCount);
        {
            drawTextSelectionHandles(canvas);
        } //End block
        {
            {
                mTouchMode = TOUCH_SHORTPRESS_MODE;
            } //End block
        } //End block
        {
            mFocusSizeChanged = false;
            {
                boolean varF6566AA8A24398D5119084D846E17436_30325624 = (!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode());
                {
                    didUpdateWebTextViewDimensions(ANYWHERE);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(canvas.getTaint());
        addTaint(color);
        addTaint(drawCursorRing);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.211 -0400", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "9A3E52267FAD066A047CB44A274F249D")
    private void drawTextSelectionHandles(Canvas canvas) {
        {
            mTextSelectionPaint = new Paint();
            mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        } //End block
        mTextSelectionRegion.setEmpty();
        nativeGetTextSelectionRegion(mNativeClass, mTextSelectionRegion);
        Rect r;
        r = new Rect();
        RegionIterator iter;
        iter = new RegionIterator(mTextSelectionRegion);
        Rect clip;
        clip = canvas.getClipBounds();
        {
            boolean varE3C5F3369D1CDF36597C49DAB102029E_244248983 = (iter.next(r));
            {
                r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
                {
                    boolean var6DFFCCE966800787D5E5EFDDEDE35151_1294822714 = (r.intersect(clip));
                    {
                        canvas.drawRect(r, mTextSelectionPaint);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mSelectHandleLeft = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_left);
        } //End block
        int[] handles;
        handles = new int[4];
        nativeGetSelectionHandles(mNativeClass, handles);
        int start_x;
        start_x = contentToViewDimension(handles[0]);
        int start_y;
        start_y = contentToViewDimension(handles[1]);
        int end_x;
        end_x = contentToViewDimension(handles[2]);
        int end_y;
        end_y = contentToViewDimension(handles[3]);
        start_x -= (mSelectHandleLeft.getIntrinsicWidth() * 3) / 4;
        mSelectHandleLeft.setBounds(start_x, start_y,
                start_x + mSelectHandleLeft.getIntrinsicWidth(),
                start_y + mSelectHandleLeft.getIntrinsicHeight());
        {
            mSelectHandleRight = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_right);
        } //End block
        end_x -= mSelectHandleRight.getIntrinsicWidth() / 4;
        mSelectHandleRight.setBounds(end_x, end_y,
                end_x + mSelectHandleRight.getIntrinsicWidth(),
                end_y + mSelectHandleRight.getIntrinsicHeight());
        {
            mSelectHandleLeft.setAlpha(125);
            mSelectHandleRight.setAlpha(125);
        } //End block
        mSelectHandleLeft.draw(canvas);
        mSelectHandleRight.draw(canvas);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.212 -0400", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "6D505BD4C6373D13601AF5AD25582BAE")
     boolean drawHistory() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141691754 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141691754;
        // ---------- Original Method ----------
        //return mDrawHistory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.212 -0400", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "5EA72BDE6C4E5A9F378582F1E2433B92")
     int getHistoryPictureWidth() {
        {
            Object var5C92612DE9888EAC00CA7C21ECDC0B5E_258783506 = (mHistoryPicture.getWidth());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108983630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108983630;
        // ---------- Original Method ----------
        //return (mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.216 -0400", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "459B18823B2A2AEEF7DEF43A899F5829")
     void switchOutDrawHistory() {
        {
            boolean var4213A82FBAD6D3C76E09EE9714EFE36E_1904738045 = (mDrawHistory && (getProgress() == 100 || nativeHasContent()));
            {
                mDrawHistory = false;
                mHistoryPicture = null;
                invalidate();
                int oldScrollX;
                oldScrollX = mScrollX;
                int oldScrollY;
                oldScrollY = mScrollY;
                mScrollX = pinLocX(mScrollX);
                mScrollY = pinLocY(mScrollY);
                {
                    onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
                } //End block
                {
                    sendOurVisibleRect();
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (null == mWebViewCore) return;
        //if (mDrawHistory && (getProgress() == 100 || nativeHasContent())) {
            //mDrawHistory = false;
            //mHistoryPicture = null;
            //invalidate();
            //int oldScrollX = mScrollX;
            //int oldScrollY = mScrollY;
            //mScrollX = pinLocX(mScrollX);
            //mScrollY = pinLocY(mScrollY);
            //if (oldScrollX != mScrollX || oldScrollY != mScrollY) {
                //onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
            //} else {
                //sendOurVisibleRect();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.217 -0400", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "AA0CE738B88A59E26A9F4329085B4053")
     WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData varB4EAC82CA7396A68D541C85D26508E83_1011278061 = null; //Variable for return #1
        WebViewCore.CursorData result;
        result = cursorDataNoPosition();
        Point position;
        position = nativeCursorPosition();
        result.mX = position.x;
        result.mY = position.y;
        varB4EAC82CA7396A68D541C85D26508E83_1011278061 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1011278061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1011278061;
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = cursorDataNoPosition();
        //Point position = nativeCursorPosition();
        //result.mX = position.x;
        //result.mY = position.y;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.218 -0400", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "85D874420DBCC1F59AE126B4664CC74E")
     WebViewCore.CursorData cursorDataNoPosition() {
        WebViewCore.CursorData varB4EAC82CA7396A68D541C85D26508E83_636545174 = null; //Variable for return #1
        WebViewCore.CursorData result;
        result = new WebViewCore.CursorData();
        result.mMoveGeneration = nativeMoveGeneration();
        result.mFrame = nativeCursorFramePointer();
        varB4EAC82CA7396A68D541C85D26508E83_636545174 = result;
        varB4EAC82CA7396A68D541C85D26508E83_636545174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636545174;
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = new WebViewCore.CursorData();
        //result.mMoveGeneration = nativeMoveGeneration();
        //result.mFrame = nativeCursorFramePointer();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.218 -0400", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "21CA8B4B81117206265DA6C61F515619")
     void deleteSelection(int start, int end) {
        WebViewCore.TextSelectionData data;
        data = new WebViewCore.TextSelectionData(start, end);
        mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                data);
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //mTextGeneration++;
        //WebViewCore.TextSelectionData data
                //= new WebViewCore.TextSelectionData(start, end);
        //mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                //data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.220 -0400", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "91B7B763D0AA43085D3C084297DA933B")
     void setSelection(int start, int end) {
        {
            mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        } //End block
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.220 -0400", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "72443D4D12A15819F4C389C60E25FC30")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_394849392 = null; //Variable for return #1
        InputConnection connection;
        connection = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        varB4EAC82CA7396A68D541C85D26508E83_394849392 = connection;
        addTaint(outAttrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_394849392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394849392;
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.224 -0400", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "8827461EA207508CD1AFDEEB872028ED")
    private void displaySoftKeyboard(boolean isTextView) {
        InputMethodManager imm;
        imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean zoom;
        zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        } //End block
        {
            rebuildWebTextView();
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_870341689 = (inEditingMode());
                {
                    imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                    {
                        didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        imm.showSoftInput(this, 0);
        addTaint(isTextView);
        // ---------- Original Method ----------
        //InputMethodManager imm = (InputMethodManager)
                //getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        //boolean zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        //if (zoom) {
            //mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            //mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        //}
        //if (isTextView) {
            //rebuildWebTextView();
            //if (inEditingMode()) {
                //imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                //if (zoom) {
                    //didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                //}
                //return;
            //}
        //}
        //imm.showSoftInput(this, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.224 -0400", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "E9F54869C428411BCB1CF89A90851AE4")
    private void hideSoftKeyboard() {
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean var1C65995F61E387B4C34088A3BF18BF15_1251275180 = (imm != null && (imm.isActive(this)
                || (inEditingMode() && imm.isActive(mWebTextView))));
            {
                imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null && (imm.isActive(this)
                //|| (inEditingMode() && imm.isActive(mWebTextView)))) {
            //imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.237 -0400", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "150CD761F08CBF13E28CCEE3CA0A839F")
     void rebuildWebTextView() {
        {
            boolean varD65E3F1F95872BCE9675FDBCB6E52A34_1944623918 = (!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus()));
        } //End collapsed parenthetic
        boolean alreadyThere;
        alreadyThere = inEditingMode();
        {
            boolean var7605F9B50D3E6B1FCD1B43262B1DB86A_1526249185 = (0 == mNativeClass || !nativeFocusCandidateIsTextInput());
            {
                {
                    mWebTextView.remove();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mWebTextView = new WebTextView(mContext, WebView.this, mAutoFillData.getQueryId());
            mTextGeneration = 0;
        } //End block
        mWebTextView.updateTextSize();
        updateWebTextViewPosition();
        String text;
        text = nativeFocusCandidateText();
        int nodePointer;
        nodePointer = nativeFocusCandidatePointer();
        mWebTextView.setNodePointer(nodePointer);
        mWebTextView.setType(nativeFocusCandidateType());
        mWebTextView.setGravityForRtl(nativeFocusCandidateIsRtlText());
        {
            text = "";
        } //End block
        mWebTextView.setTextAndKeepSelection(text);
        InputMethodManager imm;
        imm = InputMethodManager.peekInstance();
        {
            boolean varBCF51FD17B0A78CB3F43132D03F914EA_495162725 = (imm != null && imm.isActive(mWebTextView));
            {
                imm.restartInput(mWebTextView);
                mWebTextView.clearComposingText();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1232775428 = (isFocused());
            {
                mWebTextView.requestFocus();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.238 -0400", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "E99FAB6024A66C07204006B4A9AEF707")
    private void updateWebTextViewPosition() {
        Rect visibleRect;
        visibleRect = new Rect();
        calcOurContentVisibleRect(visibleRect);
        Rect bounds;
        bounds = nativeFocusCandidateNodeBounds();
        Rect vBox;
        vBox = contentToViewRect(bounds);
        offsetByLayerScrollPosition(vBox);
        mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        {
            boolean var5F1F7DC9987FB452C0CD065A1A522578_244335701 = (!Rect.intersects(bounds, visibleRect));
            {
                revealSelection();
            } //End block
        } //End collapsed parenthetic
        updateWebTextViewPadding();
        // ---------- Original Method ----------
        //Rect visibleRect = new Rect();
        //calcOurContentVisibleRect(visibleRect);
        //Rect bounds = nativeFocusCandidateNodeBounds();
        //Rect vBox = contentToViewRect(bounds);
        //offsetByLayerScrollPosition(vBox);
        //mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        //if (!Rect.intersects(bounds, visibleRect)) {
            //revealSelection();
        //}
        //updateWebTextViewPadding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.243 -0400", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "297491AEC1F1D93CAB767A3EDBD5D37D")
     void updateWebTextViewPadding() {
        Rect paddingRect;
        paddingRect = nativeFocusCandidatePaddingRect();
        {
            mWebTextView.setPadding(
                    contentToViewDimension(paddingRect.left),
                    contentToViewDimension(paddingRect.top),
                    contentToViewDimension(paddingRect.right),
                    contentToViewDimension(paddingRect.bottom));
        } //End block
        // ---------- Original Method ----------
        //Rect paddingRect = nativeFocusCandidatePaddingRect();
        //if (paddingRect != null) {
            //mWebTextView.setPadding(
                    //contentToViewDimension(paddingRect.left),
                    //contentToViewDimension(paddingRect.top),
                    //contentToViewDimension(paddingRect.right),
                    //contentToViewDimension(paddingRect.bottom));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.243 -0400", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "C79360889439696E82BC1DD990D797CB")
     void revealSelection() {
        {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.247 -0400", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "EDE0DC793CB8733BBA58937CAC23733A")
     void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        {
            boolean varF44B622654F1EDE6833649178C55B74F_904817170 = (mWebViewCore.getSettings().getSaveFormData());
            {
                Message update;
                update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
                update.arg1 = nodePointer;
                RequestFormData updater;
                updater = new RequestFormData(name, getUrl(),
                    update, autoFillable, autoComplete);
                Thread t;
                t = new Thread(updater);
                t.start();
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(nodePointer);
        addTaint(autoFillable);
        addTaint(autoComplete);
        // ---------- Original Method ----------
        //if (mWebViewCore.getSettings().getSaveFormData()) {
            //Message update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
            //update.arg1 = nodePointer;
            //RequestFormData updater = new RequestFormData(name, getUrl(),
                    //update, autoFillable, autoComplete);
            //Thread t = new Thread(updater);
            //t.start();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.248 -0400", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "4E406C36A9EFE6FCE6CD5643E5552132")
     void requestLabel(int framePointer, int nodePointer) {
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
        addTaint(framePointer);
        addTaint(nodePointer);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                //nodePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.248 -0400", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "095BD32945AB1C2E270DEA25ED8552A3")
    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
        // ---------- Original Method ----------
        //nativeDumpDisplayTree(getUrl());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.248 -0400", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "C493561456B7E508A662A631D1007010")
    public void dumpDomTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
        addTaint(toFile);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.248 -0400", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "A26D8E7753BF05537B07532849ADBB9D")
    public void dumpRenderTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
        addTaint(toFile);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.249 -0400", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "5A01FAE035DC9B2B19C3CFCD95128CE9")
    public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.249 -0400", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "39F9B2BF9F6D95390C669F91AF6E2339")
    public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
        addTaint(canProvideAlpha);
        addTaint(alpha);
        addTaint(canProvideBeta);
        addTaint(beta);
        addTaint(canProvideGamma);
        addTaint(gamma);
        // ---------- Original Method ----------
        //mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                //canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.249 -0400", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "AD73DDA9DEE4DBACADAAC65BAB256F86")
    public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.250 -0400", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "EFD82A698867ED1725F70B9EFE04090A")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var858C72F44AB8CD41BC0BE3BD37D47DCB_136446916 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913263512 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913263512;
        // ---------- Original Method ----------
        //if (mBlockWebkitViewMessages) {
            //return false;
        //}
        //if (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null) {
            //mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            //mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.263 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "DA0D872F5407B678B5935F4CFA630F67")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228377673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228377673;
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.270 -0400", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "F0D162416A97BB5156B0E9F2C6D191FB")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var057857A71DAAF22FA381D228F5183695_2138560959 = (event.isCtrlPressed());
        } //End collapsed parenthetic
        {
            mAutoRedraw = !mAutoRedraw;
            {
                invalidate();
            } //End block
        } //End block
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_144073669 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_199480112 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1274010288 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                    } //End block
                    {
                        mAccessibilityScriptInjected = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_253136724 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_543046225 = (mAccessibilityInjector.onKeyEvent(event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mAccessibilityInjector = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_763993934 = (event.hasNoModifiers());
                {
                    pageUp(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_2097594287 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageUp(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_768842032 = (event.hasNoModifiers());
                {
                    pageDown(false);
                } //End block
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_1582093680 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageDown(true);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        {
            boolean var4D7637BE3E5BB8DFB8BE9F5DEBBD0190_635194635 = (keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers());
            {
                pageUp(true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCDA174DB103BE1133CABA578513ECF4C_1990893632 = (keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers());
            {
                pageDown(true);
            } //End block
        } //End collapsed parenthetic
        {
            switchOutDrawHistory();
            {
                boolean var5EC168B85D610989E99D878E0C758737_1058105921 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
            {
                boolean varAC7A24F7600680817ED76B813249DD81_1705810172 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                {
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    pageUp(true);
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    pageDown(true);
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    nativeClearCursor();
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    boolean var563F44E657D7D016C02306EF7D73B63C_390646547 = (pinScrollTo(0, mScrollY, true, 0));
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    nativeClearCursor();
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    boolean var05C6B866B6258D11272BBA227622E49C_972161449 = (pinScrollTo(mContentWidth, mScrollY, true, 0));
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                } //End block
            } //End collapsed parenthetic
            {
                int xRate;
                xRate = 1;
                xRate = 0;
                int yRate;
                yRate = 1;
                yRate = 0;
                int multiplier;
                multiplier = event.getRepeatCount() + 1;
                moveSelection(xRate * multiplier, yRate * multiplier);
            } //End block
            {
                boolean varECFDC30B9B17E54572F391464D24DDCA_1794966897 = (navHandledKey(keyCode, 1, false, event.getEventTime()));
                {
                    playSoundEffect(keyCodeToSoundsEffect(keyCode));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            switchOutDrawHistory();
            boolean wantsKeyEvents;
            wantsKeyEvents = nativeCursorNodePointer() == 0
                || nativeCursorWantsKeyEvents();
            {
                boolean var1C3F6BC8881ADE70AD0B6D90845DAEAD_699665317 = (event.getRepeatCount() == 0);
                {
                    mGotCenterDown = true;
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var887BE5E0D671A1E9580BF5C98186B06D_2144270076 = (getSettings().getNavDump());
            {
                //Begin case KeyEvent.KEYCODE_4 
                dumpDisplayTree();
                //End case KeyEvent.KEYCODE_4 
                //Begin case KeyEvent.KEYCODE_5 KeyEvent.KEYCODE_6 
                dumpDomTree(keyCode == KeyEvent.KEYCODE_5);
                //End case KeyEvent.KEYCODE_5 KeyEvent.KEYCODE_6 
                //Begin case KeyEvent.KEYCODE_7 KeyEvent.KEYCODE_8 
                dumpRenderTree(keyCode == KeyEvent.KEYCODE_7);
                //End case KeyEvent.KEYCODE_7 KeyEvent.KEYCODE_8 
                //Begin case KeyEvent.KEYCODE_9 
                nativeInstrumentReport();
                //End case KeyEvent.KEYCODE_9 
            } //End block
        } //End collapsed parenthetic
        {
            boolean varFBB0B09776F969247DB212E1762B7005_1005897468 = (nativeCursorIsTextInput());
            {
                mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
                rebuildWebTextView();
                {
                    boolean var91CFAA6DBB8ACD778F334172661A353F_1124315450 = (inEditingMode());
                    {
                        mWebTextView.setDefaultSelection();
                        boolean var0E01D6F0C9B3C4661498B390117F08D9_326005239 = (mWebTextView.dispatchKeyEvent(event));
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean var4BF8F7F944B1F59AAF473CC034212BAF_578137532 = (nativeHasFocusNode());
                {
                    rebuildWebTextView();
                    {
                        boolean varCC7B651C81D6575D905B32AE4D2DE9FF_2102457479 = (inEditingMode());
                        {
                            mWebTextView.setDefaultSelection();
                            boolean var94D478091AA1B30B7403F71D4EA231CE_467912281 = (mWebTextView.dispatchKeyEvent(event));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_1968395599 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6858501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_6858501;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.279 -0400", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "BE227CF9260653D0030E8B794DA7607D")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varFB3D894E81BEF45C7836AA612BE5CF4E_1286622372 = (keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode());
            {
                String text;
                text = nativeCursorText();
                {
                    boolean var0730AC3C43F6F231E2E36B9DE5B4A786_1612177329 = (!nativeCursorIsTextInput() && text != null
                    && text.startsWith(SCHEME_TEL));
                    {
                        Intent intent;
                        intent = new Intent(Intent.ACTION_DIAL, Uri.parse(text));
                        getContext().startActivity(intent);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_489553618 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } //End collapsed parenthetic
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_510318342 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_694374676 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_UP, event);
                    } //End block
                    {
                        mAccessibilityScriptInjected = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_218172707 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_2077579654 = (mAccessibilityInjector.onKeyEvent(event));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        mAccessibilityInjector = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var5EC168B85D610989E99D878E0C758737_1791682602 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varF2C062DAF4D50BEAFF0E218848138E20_158735578 = (isEnterActionKey(keyCode));
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mGotCenterDown = false;
                {
                    {
                        copySelection();
                        selectionDone();
                    } //End block
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } //End block
                } //End block
                Rect visibleRect;
                visibleRect = sendOurVisibleRect();
                {
                    boolean var1C0F8D4E9F76762BB9ABC943F1506101_584819539 = (!nativeCursorIntersects(visibleRect));
                } //End collapsed parenthetic
                WebViewCore.CursorData data;
                data = cursorData();
                mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
                playSoundEffect(SoundEffectConstants.CLICK);
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_1201602417 = (nativeCursorIsTextInput());
                    {
                        rebuildWebTextView();
                        centerKeyPressOnTextField();
                        {
                            boolean varDB1B9C12ED48DAB084977319495C514C_2044893577 = (inEditingMode());
                            {
                                mWebTextView.setDefaultSelection();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                clearTextEntry();
                nativeShowCursorTimed();
                {
                    boolean var34E3725E8E3257788672BB9D0420AAC0_214061077 = (mCallbackProxy.uiOverrideUrlLoading(nativeCursorText()));
                } //End collapsed parenthetic
                {
                    boolean var2B73408B18669E3ED44DEC84F3F8FE87_1303816053 = (nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents());
                    {
                        mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_992037471 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_638563783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_638563783;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.297 -0400", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "B2E890FBD877A20991116430484D607B")
    private boolean setUpSelect(boolean selectWord, int x, int y) {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_1523201861 = (inFullScreenMode());
        } //End collapsed parenthetic
        nativeResetSelection();
        {
            boolean var5D0F3C45A3AF9494DFD7437F551FA15B_820894629 = (selectWord && !nativeWordSelection(x, y));
            {
                selectionDone();
            } //End block
        } //End collapsed parenthetic
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
        {
            boolean varB8A3B697E17C784F74A8FDA17CF85863_1369329525 = (startActionMode(mSelectCallback) == null);
            {
                selectionDone();
            } //End block
        } //End collapsed parenthetic
        mExtendSelection = false;
        mSelectingText = mDrawSelectionPointer = true;
        {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        } //End block
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        {
            boolean var5225ACD2E56334E54962D68427F36819_1767616510 = (nativeHasCursorNode());
            {
                Rect rect;
                rect = nativeCursorNodeBounds();
                mSelectX = contentToViewX(rect.left);
                mSelectY = contentToViewY(rect.top);
            } //End block
            {
                boolean varBE337274F3E43C04FF66B457B0EF7AE1_1398023326 = (mLastTouchY > getVisibleTitleHeightImpl());
                {
                    mSelectX = mScrollX + mLastTouchX;
                    mSelectY = mScrollY + mLastTouchY;
                } //End block
                {
                    mSelectX = mScrollX + getViewWidth() / 2;
                    mSelectY = mScrollY + getViewHeightWithTitle() / 2;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        nativeHideCursor();
        mMinAutoScrollX = 0;
        mMaxAutoScrollX = getViewWidth();
        mMinAutoScrollY = 0;
        mMaxAutoScrollY = getViewHeightWithTitle();
        mCurrentScrollingLayerId = nativeScrollableLayer(viewToContentX(mSelectX),
                viewToContentY(mSelectY), mScrollingLayerRect,
                mScrollingLayerBounds);
        {
            {
                mMinAutoScrollX = Math.max(mMinAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.left));
                mMaxAutoScrollX = Math.min(mMaxAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.right));
            } //End block
            {
                mMinAutoScrollY = Math.max(mMinAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.top));
                mMaxAutoScrollY = Math.min(mMaxAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.bottom));
            } //End block
        } //End block
        mMinAutoScrollX += SELECT_SCROLL;
        mMaxAutoScrollX -= SELECT_SCROLL;
        mMinAutoScrollY += SELECT_SCROLL;
        mMaxAutoScrollY -= SELECT_SCROLL;
        addTaint(selectWord);
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854491594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_854491594;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.299 -0400", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "397EF000EB5841A9556B40D05B9E7E33")
    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //setUpSelect(false, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.299 -0400", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "552FDEAEAE3E11074F5D36E4B6D52FA1")
    public void selectAll() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_1184955555 = (inFullScreenMode());
        } //End collapsed parenthetic
        {
            Point select;
            select = nativeSelectableText();
            {
                boolean varAEB90306D9A88D63001E6EB8A442969D_2138352739 = (!selectText(select.x, select.y));
            } //End collapsed parenthetic
        } //End block
        nativeSelectAll();
        mDrawSelectionPointer = false;
        mExtendSelection = true;
        invalidate();
        // ---------- Original Method ----------
        //if (0 == mNativeClass) return;
        //if (inFullScreenMode()) return;
        //if (!mSelectingText) {
            //Point select = nativeSelectableText();
            //if (!selectText(select.x, select.y)) return;
        //}
        //nativeSelectAll();
        //mDrawSelectionPointer = false;
        //mExtendSelection = true;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.300 -0400", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "52C98EE1C4524A42D0A6137208BBFA56")
     void selectionDone() {
        {
            mSelectingText = false;
            {
                setLayerType(LAYER_TYPE_NONE, null);
            } //End block
            mSelectCallback.finish();
            mSelectCallback = null;
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            invalidate();
            mAutoScrollX = 0;
            mAutoScrollY = 0;
            mSentAutoScrollMessage = false;
        } //End block
        // ---------- Original Method ----------
        //if (mSelectingText) {
            //mSelectingText = false;
            //if (DEBUG_TEXT_HANDLES) {
                //setLayerType(LAYER_TYPE_NONE, null);
            //}
            //mSelectCallback.finish();
            //mSelectCallback = null;
            //WebViewCore.resumePriority();
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
            //invalidate(); 
            //mAutoScrollX = 0;
            //mAutoScrollY = 0;
            //mSentAutoScrollMessage = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.305 -0400", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "403CBF1989A802137830BE9A65722A93")
    public boolean copySelection() {
        boolean copiedSomething;
        copiedSomething = false;
        String selection;
        selection = getSelection();
        {
            Toast.makeText(mContext
                    , com.android.internal.R.string.text_copied
                    , Toast.LENGTH_SHORT).show();
            copiedSomething = true;
            ClipboardManager cm;
            cm = (ClipboardManager)getContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(selection);
        } //End block
        invalidate();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538702105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538702105;
        // ---------- Original Method ----------
        //boolean copiedSomething = false;
        //String selection = getSelection();
        //if (selection != null && selection != "") {
            //if (DebugFlags.WEB_VIEW) {
                //Log.v(LOGTAG, "copySelection \"" + selection + "\"");
            //}
            //Toast.makeText(mContext
                    //, com.android.internal.R.string.text_copied
                    //, Toast.LENGTH_SHORT).show();
            //copiedSomething = true;
            //ClipboardManager cm = (ClipboardManager)getContext()
                    //.getSystemService(Context.CLIPBOARD_SERVICE);
            //cm.setText(selection);
        //}
        //invalidate();
        //return copiedSomething;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.306 -0400", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "9E3B42ED2C272593AC1F4469F90A6F51")
    public SearchBox getSearchBox() {
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_1435487056 = null; //Variable for return #1
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_1486266522 = null; //Variable for return #2
        {
            boolean var575F4597422E60100014A3F178C01D0F_654355171 = ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1435487056 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1486266522 = mWebViewCore.getBrowserFrame().getSearchBox();
        SearchBox varA7E53CE21691AB073D9660D615818899_1741289237; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1741289237 = varB4EAC82CA7396A68D541C85D26508E83_1435487056;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1741289237 = varB4EAC82CA7396A68D541C85D26508E83_1486266522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1741289237.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1741289237;
        // ---------- Original Method ----------
        //if ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null)) {
            //return null;
        //}
        //return mWebViewCore.getBrowserFrame().getSearchBox();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.308 -0400", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "9700CD307560D6506F29BA8C5D8D8F58")
     String getSelection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1069370338 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1261612619 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1069370338 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1261612619 = nativeGetSelection();
        String varA7E53CE21691AB073D9660D615818899_218483302; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_218483302 = varB4EAC82CA7396A68D541C85D26508E83_1069370338;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_218483302 = varB4EAC82CA7396A68D541C85D26508E83_1261612619;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_218483302.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_218483302;
        // ---------- Original Method ----------
        //if (mNativeClass == 0) return "";
        //return nativeGetSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.310 -0400", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "B0D008EB660150E79F602AFAE45FF92A")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_740887138 = (hasWindowFocus());
            setActive(true);
        } //End collapsed parenthetic
        ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        {
            mGlobalLayoutListener = new InnerGlobalLayoutListener();
            treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        } //End block
        {
            mScrollChangedListener = new InnerScrollChangedListener();
            treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        } //End block
        addAccessibilityApisToJavaScript();
        mTouchEventQueue.reset();
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //if (hasWindowFocus()) setActive(true);
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //if (mGlobalLayoutListener == null) {
            //mGlobalLayoutListener = new InnerGlobalLayoutListener();
            //treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        //}
        //if (mScrollChangedListener == null) {
            //mScrollChangedListener = new InnerScrollChangedListener();
            //treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        //}
        //addAccessibilityApisToJavaScript();
        //mTouchEventQueue.reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.314 -0400", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "E32A5615AB4F36FF624BB5BF803E481B")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_329050420 = (hasWindowFocus());
            setActive(false);
        } //End collapsed parenthetic
        ViewTreeObserver treeObserver;
        treeObserver = getViewTreeObserver();
        {
            treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            mGlobalLayoutListener = null;
        } //End block
        {
            treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            mScrollChangedListener = null;
        } //End block
        removeAccessibilityApisFromJavaScript();
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //clearHelpers();
        //mZoomManager.dismissZoomPicker();
        //if (hasWindowFocus()) setActive(false);
        //final ViewTreeObserver treeObserver = getViewTreeObserver();
        //if (mGlobalLayoutListener != null) {
            //treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            //mGlobalLayoutListener = null;
        //}
        //if (mScrollChangedListener != null) {
            //treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            //mScrollChangedListener = null;
        //}
        //removeAccessibilityApisFromJavaScript();
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.325 -0400", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "ED1A1C337A69915E6C6C26CE222A7D32")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onVisibilityChanged(changedView, visibility);
        {
            mZoomManager.dismissZoomPicker();
        } //End block
        updateDrawingState();
        addTaint(changedView.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != View.VISIBLE && mZoomManager != null) {
            //mZoomManager.dismissZoomPicker();
        //}
        //updateDrawingState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.325 -0400", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "B273FE7D61E13E6CE45FEB7014C0E93B")
    @Deprecated
    public void onChildViewAdded(View parent, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.326 -0400", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "C170B29F38EB702918070B8FAF483BB6")
    @Deprecated
    public void onChildViewRemoved(View p, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(p.getTaint());
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.326 -0400", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "03699C1B0285E84E7176C9EC92F4A5C1")
    @Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldFocus.getTaint());
        addTaint(newFocus.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.327 -0400", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "139F321F073E049B4B4A59AEE7C05B27")
     void setActive(boolean active) {
        {
            {
                boolean varC68F8DA53A6E7AE533DF2B6E0273984A_1837089520 = (hasFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
                {
                    mDrawCursorRing = false;
                    {
                        boolean var82DF510B98047A24212E03E202533075_161191352 = (!inEditingMode());
                        {
                            setFocusControllerActive(false);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB5F2F3BA6162A40E6EBD61229A1DF48F_53187618 = (!mZoomManager.isZoomPickerVisible());
                {
                    mDrawCursorRing = false;
                } //End block
            } //End collapsed parenthetic
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            mTouchMode = TOUCH_DONE_MODE;
            setFocusControllerActive(false);
        } //End block
        invalidate();
        addTaint(active);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.345 -0400", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "0AF9CDADC64859E8681F32E2F6EB0A1F")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setActive(hasWindowFocus);
        {
            JWebCoreJavaBridge.setActiveWebView(this);
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = false;
            } //End block
        } //End block
        {
            JWebCoreJavaBridge.removeActiveWebView(this);
            WebSettings settings;
            settings = getSettings();
            {
                boolean var1D74215CA3033399C095EF1282AE5BE7_71778789 = (settings != null && settings.enableSmoothTransition() &&
                    mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore));
                {
                    WebViewCore.pauseUpdatePicture(mWebViewCore);
                    mPictureUpdatePausedForFocusChange = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        super.onWindowFocusChanged(hasWindowFocus);
        addTaint(hasWindowFocus);
        // ---------- Original Method ----------
        //setActive(hasWindowFocus);
        //if (hasWindowFocus) {
            //JWebCoreJavaBridge.setActiveWebView(this);
            //if (mPictureUpdatePausedForFocusChange) {
                //WebViewCore.resumeUpdatePicture(mWebViewCore);
                //mPictureUpdatePausedForFocusChange = false;
            //}
        //} else {
            //JWebCoreJavaBridge.removeActiveWebView(this);
            //final WebSettings settings = getSettings();
            //if (settings != null && settings.enableSmoothTransition() &&
                    //mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore)) {
                //WebViewCore.pauseUpdatePicture(mWebViewCore);
                //mPictureUpdatePausedForFocusChange = true;
            //}
        //}
        //super.onWindowFocusChanged(hasWindowFocus);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.345 -0400", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "A1384AD20E5374D9BEF18AEB73755D7C")
     void setFocusControllerActive(boolean active) {
        mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        } //End block
        addTaint(active);
        // ---------- Original Method ----------
        //if (mWebViewCore == null) return;
        //mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        //if (active && mListBoxMessage != null) {
            //mWebViewCore.sendMessage(mListBoxMessage);
            //mListBoxMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.346 -0400", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "944CAD9C9BD3ABEA52FFF3ABE120943D")
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var7FF7C69BF2546C1B46A75E34BBC40609_1395168733 = (hasWindowFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDrawCursorRing = false;
            {
                boolean varD52AFE2B2A5DD9C2C2CA64ADDFB71D04_1468984763 = (!inEditingMode());
                {
                    setFocusControllerActive(false);
                } //End block
            } //End collapsed parenthetic
            mKeysPressed.clear();
        } //End block
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "MT focusChanged " + focused + ", " + direction);
        //}
        //if (focused) {
            //if (hasWindowFocus()) {
                //mDrawCursorRing = !inEditingMode();
                //setFocusControllerActive(true);
            //}
        //} else {
            //mDrawCursorRing = false;
            //if (!inEditingMode()) {
                //setFocusControllerActive(false);
            //}
            //mKeysPressed.clear();
        //}
        //super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.373 -0400", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "54B66956DF54307731708D012EE1FC6D")
     void setGLRectViewport() {
        boolean visible;
        visible = getGlobalVisibleRect(mGLRectViewport);
        {
            View rootView;
            rootView = getRootView();
            int rootViewHeight;
            rootViewHeight = rootView.getHeight();
            mViewRectViewport.set(mGLRectViewport);
            int savedWebViewBottom;
            savedWebViewBottom = mGLRectViewport.bottom;
            mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            mGLViewportEmpty = false;
        } //End block
        {
            mGLViewportEmpty = true;
        } //End block
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
        // ---------- Original Method ----------
        //boolean visible = getGlobalVisibleRect(mGLRectViewport);
        //if (visible) {
            //View rootView = getRootView();
            //int rootViewHeight = rootView.getHeight();
            //mViewRectViewport.set(mGLRectViewport);
            //int savedWebViewBottom = mGLRectViewport.bottom;
            //mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            //mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            //mGLViewportEmpty = false;
        //} else {
            //mGLViewportEmpty = true;
        //}
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                //mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.373 -0400", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "2EC4C55B466120168D088DA956D51431")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed;
        changed = super.setFrame(left, top, right, bottom);
        {
            sendViewSizeZoom(false);
        } //End block
        setGLRectViewport();
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720467584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_720467584;
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(left, top, right, bottom);
        //if (!changed && mHeightCanMeasure) {
            //sendViewSizeZoom(false);
        //}
        //setGLRectViewport();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.374 -0400", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "01B49159AC19BD0BCCE208ABC1BAA61A")
    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSizeChanged(w, h, ow, oh);
        int newMaxViewportWidth;
        newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        {
            sMaxViewportWidth = newMaxViewportWidth;
        } //End block
        mZoomManager.onSizeChanged(w, h, ow, oh);
        {
            setNewPicture(mLoadedPicture, false);
        } //End block
        addTaint(w);
        addTaint(h);
        addTaint(ow);
        addTaint(oh);
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, ow, oh);
        //int newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        //if (newMaxViewportWidth > sMaxViewportWidth) {
            //sMaxViewportWidth = newMaxViewportWidth;
        //}
        //mZoomManager.onSizeChanged(w, h, ow, oh);
        //if (mLoadedPicture != null && mDelaySetPicture == null) {
            //setNewPicture(mLoadedPicture, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.374 -0400", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "5DA2D554C13B66B2800B00638B8D0202")
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onScrollChanged(l, t, oldl, oldt);
        {
            sendOurVisibleRect();
            int titleHeight;
            titleHeight = getTitleHeight();
            {
                boolean varB4D4A6A79DEACE1E888BD156FFAF1F5C_876561634 = (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0));
                {
                    sendViewSizeZoom(false);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(l);
        addTaint(t);
        addTaint(oldl);
        addTaint(oldt);
        // ---------- Original Method ----------
        //super.onScrollChanged(l, t, oldl, oldt);
        //if (!mInOverScrollMode) {
            //sendOurVisibleRect();
            //int titleHeight = getTitleHeight();
            //if (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0)) {
                //sendViewSizeZoom(false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.380 -0400", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "DF9360A4F85A1BE32EA29209B253B3E4")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_444609986 = (event.getAction());
            //Begin case KeyEvent.ACTION_DOWN 
            mKeysPressed.add(Integer.valueOf(event.getKeyCode()));
            //End case KeyEvent.ACTION_DOWN 
            //Begin case KeyEvent.ACTION_UP 
            int location;
            location = mKeysPressed.indexOf(Integer.valueOf(event.getKeyCode()));
            //End case KeyEvent.ACTION_UP 
            //Begin case KeyEvent.ACTION_UP 
            {
                mKeysPressed.remove(location);
            } //End block
            //End case KeyEvent.ACTION_UP 
        } //End collapsed parenthetic
        {
            boolean var5B06505CBCDCB8DEE1F6FB0FBB28CE94_78357361 = (inEditingMode() && mWebTextView.isFocused());
            {
                boolean var055C27F4AD9E2119212195DD41858BDC_682350609 = (mWebTextView.dispatchKeyEvent(event));
            } //End block
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_1524013477 = (super.dispatchKeyEvent(event));
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570634486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570634486;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.381 -0400", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "D34463C06617FCAACFA8596D1DDCCA21")
    private boolean hitFocusedPlugin(int contentX, int contentY) {
        {
            Rect r;
            r = nativeFocusNodeBounds();
        } //End block
        boolean varAADFA5397280FFF07498DCDB610497F5_721647236 = (nativeFocusIsPlugin()
                && nativeFocusNodeBounds().contains(contentX, contentY));
        addTaint(contentX);
        addTaint(contentY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959525324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959525324;
        // ---------- Original Method ----------
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "nativeFocusIsPlugin()=" + nativeFocusIsPlugin());
            //Rect r = nativeFocusNodeBounds();
            //Log.v(LOGTAG, "nativeFocusNodeBounds()=(" + r.left + ", " + r.top
                    //+ ", " + r.right + ", " + r.bottom + ")");
        //}
        //return nativeFocusIsPlugin()
                //&& nativeFocusNodeBounds().contains(contentX, contentY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.381 -0400", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "BA07CBE04B35147054B189B75F74DC2A")
    private boolean shouldForwardTouchEvent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620317851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620317851;
        // ---------- Original Method ----------
        //if (mFullScreenHolder != null) return true;
        //if (mBlockWebkitViewMessages) return false;
        //return mForwardTouchEvents
                //&& !mSelectingText
                //&& mPreventDefault != PREVENT_DEFAULT_IGNORE
                //&& mPreventDefault != PREVENT_DEFAULT_NO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.382 -0400", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "420AE86ABC289F6C7E18A95CFFB4183E")
    private boolean inFullScreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339156527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339156527;
        // ---------- Original Method ----------
        //return mFullScreenHolder != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.382 -0400", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "832116194BAEC98704F9A491521F5DD0")
    private void dismissFullScreenMode() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_783960540 = (inFullScreenMode());
            {
                mFullScreenHolder.hide();
                mFullScreenHolder = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (inFullScreenMode()) {
            //mFullScreenHolder.hide();
            //mFullScreenHolder = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.389 -0400", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "ADA24DB953E0EB7EB11E71E67325FC31")
     void onPinchToZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelTouch();
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //cancelTouch();
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.390 -0400", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "4AD7518CAF79EBF2E3378FCEB538018C")
     void onPinchToZoomAnimationEnd(ScaleGestureDetector detector) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onZoomAnimationEnd();
        mTouchMode = TOUCH_PINCH_DRAG;
        mConfirmMove = true;
        startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
        addTaint(detector.getTaint());
        // ---------- Original Method ----------
        //onZoomAnimationEnd();
        //mTouchMode = TOUCH_PINCH_DRAG;
        //mConfirmMove = true;
        //startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.390 -0400", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "20D90342D64ED25038CE671383C58505")
    private void startScrollingLayer(float x, float y) {
        int contentX;
        contentX = viewToContentX((int) x + mScrollX);
        int contentY;
        contentY = viewToContentY((int) y + mScrollY);
        mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                mScrollingLayerRect, mScrollingLayerBounds);
        {
            mTouchMode = TOUCH_DRAG_LAYER_MODE;
        } //End block
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //int contentX = viewToContentX((int) x + mScrollX);
        //int contentY = viewToContentY((int) y + mScrollY);
        //mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                //mScrollingLayerRect, mScrollingLayerBounds);
        //if (mCurrentScrollingLayerId != 0) {
            //mTouchMode = TOUCH_DRAG_LAYER_MODE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.396 -0400", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "F6FE1BBF8999C258E6711E68A73367E2")
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.CursorData data;
        data = cursorDataNoPosition();
        data.mX = viewToContentX((int) event.getX() + mScrollX);
        data.mY = viewToContentY((int) event.getY() + mScrollY);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588936975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588936975;
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return false;
        //}
        //WebViewCore.CursorData data = cursorDataNoPosition();
        //data.mX = viewToContentX((int) event.getX() + mScrollX);
        //data.mY = viewToContentY((int) event.getY() + mScrollY);
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.397 -0400", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "CD2943763AEBD74AC1DD1D57610F3876")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varAD562CF087912EB5FF0170636C3B2B0D_1472145105 = (mNativeClass == 0 || (!isClickable() && !isLongClickable()));
        } //End collapsed parenthetic
        {
            boolean varDD40B025666699E2A78E1AD03139D936_1983125250 = (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO);
            {
                passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
            } //End block
            {
                mTouchEventQueue.enqueueTouchEvent(ev);
            } //End block
        } //End collapsed parenthetic
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710603587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710603587;
        // ---------- Original Method ----------
        //if (mNativeClass == 0 || (!isClickable() && !isLongClickable())) {
            //return false;
        //}
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, ev + " at " + ev.getEventTime()
                //+ " mTouchMode=" + mTouchMode
                //+ " numPointers=" + ev.getPointerCount());
        //}
        //if (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO) {
            //passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
        //} else {
            //mTouchEventQueue.enqueueTouchEvent(ev);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.399 -0400", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "5DA3A02AA086C1E1113D61FDDD907ABB")
    private float calculateDragAngle(int dx, int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        float var0DC0C40463DA1E6DC4A725D44FA13B49_2076067539 = ((float) Math.atan2(dy, dx));
        addTaint(dx);
        addTaint(dy);
        float var546ADE640B6EDFBC8A086EF31347E768_1646576091 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1646576091;
        // ---------- Original Method ----------
        //dx = Math.abs(dx);
        //dy = Math.abs(dy);
        //return (float) Math.atan2(dy, dx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.520 -0400", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "CB735239FDA2F0BB0B64427D4C20D4ED")
    private boolean handleTouchEventCommon(MotionEvent ev, int action, int x, int y) {
        long eventTime;
        eventTime = ev.getEventTime();
        x = Math.min(x, getViewWidth() - 1);
        y = Math.min(y, getViewHeightWithTitle() - 1);
        int deltaX;
        deltaX = mLastTouchX - x;
        int deltaY;
        deltaY = mLastTouchY - y;
        int contentX;
        contentX = viewToContentX(x + mScrollX);
        int contentY;
        contentY = viewToContentY(y + mScrollY);
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mPreventDefault = PREVENT_DEFAULT_NO;
            mConfirmMove = false;
            mInitialHitTestResult = null;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_2135290795 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    mTouchMode = TOUCH_DRAG_START_MODE;
                    mConfirmMove = true;
                    nativeSetIsScrolling(false);
                } //End block
                {
                    boolean varBDC63CBFC1D5292A90395B799377E3CA_1019910210 = (mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP));
                    {
                        mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_1760167579 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                removeTouchHighlight();
                            } //End block
                        } //End collapsed parenthetic
                        {
                            mTouchMode = TOUCH_DOUBLE_TAP_MODE;
                        } //End block
                        {
                            doShortPress();
                            mTouchMode = TOUCH_INIT_MODE;
                            mDeferTouchProcess = !mBlockWebkitViewMessages
                                && (!inFullScreenMode() && mForwardTouchEvents)
                                ? hitFocusedPlugin(contentX, contentY)
                                : false;
                        } //End block
                    } //End block
                    {
                        mTouchMode = TOUCH_INIT_MODE;
                        mDeferTouchProcess = !mBlockWebkitViewMessages
                            && (!inFullScreenMode() && mForwardTouchEvents)
                            ? hitFocusedPlugin(contentX, contentY)
                            : false;
                        {
                            mWebViewCore.sendMessage(
                                EventHub.UPDATE_FRAME_CACHE_IF_LOADING);
                        } //End block
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_981460382 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                TouchHighlightData data;
                                data = new TouchHighlightData();
                                data.mX = contentX;
                                data.mY = contentY;
                                data.mNativeLayerRect = new Rect();
                                data.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, data.mNativeLayerRect, null);
                                data.mSlop = viewToContentDimension(mNavSlop);
                                mTouchHighlightRegion.setEmpty();
                                {
                                    mTouchHighlightRequested = System.currentTimeMillis();
                                    mWebViewCore.sendMessageAtFrontOfQueue(
                                    EventHub.GET_TOUCH_HIGHLIGHT_RECTS, data);
                                } //End block
                                {
                                    {
                                        boolean varD778979F37708EA925216FB277FD8D27_1871191356 = (getSettings().getNavDump());
                                        {
                                            mTouchHighlightX = (int) x + mScrollX;
                                            mTouchHighlightY = (int) y + mScrollY;
                                            mPrivateHandler.postDelayed(new Runnable() {                                                
                                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.424 -0400", hash_original_method = "7498706CCC2860B05B7071008D2A72AF", hash_generated_method = "BDEB34128B671E054A924D53CAF12B4F")
                                                public void run() {
                                                    mTouchHighlightX = mTouchHighlightY = 0;
                                                    invalidate();
                                                    // ---------- Original Method ----------
                                                    //mTouchHighlightX = mTouchHighlightY = 0;
                                                    //invalidate();
                                                }
}, TOUCH_HIGHLIGHT_ELAPSE_TIME);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            EventLog.writeEvent(EventLogTags.BROWSER_DOUBLE_TAP_DURATION,
                                (eventTime - mLastTouchUpTime), eventTime);
                        } //End block
                        {
                            mDrawSelectionPointer = false;
                            mSelectionStarted = nativeStartSelection(contentX, contentY);
                            invalidate();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            {
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_SHORTPRESS, TAP_TIMEOUT);
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_LONGPRESS, LONG_PRESS_TIMEOUT);
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_1114547442 = (inFullScreenMode() || mDeferTouchProcess);
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_MAYBE_YES;
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var8932DD5DB07C85349F24CECE7642DABD_2015101840 = (shouldForwardTouchEvent());
                    {
                        TouchEventData ted;
                        ted = new TouchEventData();
                        ted.mAction = action;
                        ted.mIds = new int[1];
                        ted.mIds[0] = ev.getPointerId(0);
                        ted.mPoints = new Point[1];
                        ted.mPoints[0] = new Point(contentX, contentY);
                        ted.mPointsInView = new Point[1];
                        ted.mPointsInView[0] = new Point(x, y);
                        ted.mMetaState = ev.getMetaState();
                        ted.mReprocess = mDeferTouchProcess;
                        ted.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, ted.mNativeLayerRect, null);
                        ted.mSequence = mTouchEventQueue.nextTouchSequence();
                        mTouchEventQueue.preQueueTouchEventData(ted);
                        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                        {
                            mLastTouchX = x;
                            mLastTouchY = y;
                        } //End block
                        {
                            boolean var6904F2C5D7BEAFC799CAAF4B382483D5_270303113 = (!inFullScreenMode());
                            {
                                mPrivateHandler.removeMessages(PREVENT_DEFAULT_TIMEOUT);
                                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                    .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                            action, 0), TAP_TIMEOUT);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            startTouch(x, y, eventTime);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            boolean firstMove;
            firstMove = false;
            {
                mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                mConfirmMove = true;
                firstMove = true;
                {
                    mTouchMode = TOUCH_INIT_MODE;
                } //End block
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_1214539418 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varD5BC4EB905AD1A9E62B09D5876DE7CFA_1828645875 = (shouldForwardTouchEvent() && mConfirmMove && (firstMove
                        || eventTime - mLastSentTouchTime > mCurrentTouchInterval));
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
                    ted.mAction = action;
                    ted.mIds = new int[1];
                    ted.mIds[0] = ev.getPointerId(0);
                    ted.mPoints = new Point[1];
                    ted.mPoints[0] = new Point(contentX, contentY);
                    ted.mPointsInView = new Point[1];
                    ted.mPointsInView[0] = new Point(x, y);
                    ted.mMetaState = ev.getMetaState();
                    ted.mReprocess = mDeferTouchProcess;
                    ted.mNativeLayer = mCurrentScrollingLayerId;
                    ted.mNativeLayerRect.set(mScrollingLayerRect);
                    ted.mSequence = mTouchEventQueue.nextTouchSequence();
                    mTouchEventQueue.preQueueTouchEventData(ted);
                    mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                    mLastSentTouchTime = eventTime;
                    {
                        boolean varEF4783D596E01CB01D0208E403EB969C_2033481551 = (firstMove && !inFullScreenMode());
                        {
                            mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                        action, 0), TAP_TIMEOUT);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                mVelocityTracker.addMovement(ev);
            } //End block
            {
                ViewParent parent;
                parent = getParent();
                {
                    parent.requestDisallowInterceptTouchEvent(true);
                } //End block
                mAutoScrollX = x <= mMinAutoScrollX ? -SELECT_SCROLL
                            : x >= mMaxAutoScrollX ? SELECT_SCROLL : 0;
                mAutoScrollY = y <= mMinAutoScrollY ? -SELECT_SCROLL
                            : y >= mMaxAutoScrollY ? SELECT_SCROLL : 0;
                {
                    mSentAutoScrollMessage = true;
                    mPrivateHandler.sendEmptyMessageDelayed(
                                SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                } //End block
                {
                    nativeExtendSelection(contentX, contentY);
                    invalidate();
                } //End block
            } //End block
            {
                {
                    mLastTouchTime = eventTime;
                } //End block
                ScaleGestureDetector detector;
                detector = mZoomManager.getMultiTouchGestureDetector();
                mAverageAngle = calculateDragAngle(deltaX, deltaY);
                {
                    boolean varA7D01DAA9313836025F53EEF13EC7FDA_838854559 = (detector == null || !detector.isInProgress());
                    {
                        {
                            mSnapScrollMode = SNAP_X;
                            mSnapPositive = deltaX > 0;
                            mAverageAngle = ANGLE_HORIZ;
                        } //End block
                        {
                            mSnapScrollMode = SNAP_Y;
                            mSnapPositive = deltaY > 0;
                            mAverageAngle = ANGLE_VERT;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mTouchMode = TOUCH_DRAG_MODE;
                mLastTouchX = x;
                mLastTouchY = y;
                deltaX = 0;
                deltaY = 0;
                startScrollingLayer(x, y);
                startDrag();
            } //End block
            boolean done;
            done = false;
            boolean keepScrollBarsVisible;
            keepScrollBarsVisible = false;
            {
                keepScrollBarsVisible = done = true;
            } //End block
            {
                mAverageAngle +=
                        (calculateDragAngle(deltaX, deltaY) - mAverageAngle)
                        / MMA_WEIGHT_N;
                {
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        mSnapScrollMode = SNAP_X;
                        mSnapPositive = deltaX > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_HORIZ) / 2;
                    } //End block
                    {
                        mSnapScrollMode = SNAP_Y;
                        mSnapPositive = deltaY > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_VERT) / 2;
                    } //End block
                } //End block
                {
                    {
                        deltaY = 0;
                    } //End block
                    {
                        deltaX = 0;
                    } //End block
                } //End block
                mLastTouchX = x;
                mLastTouchY = y;
                {
                    mHeldMotionless = MOTIONLESS_FALSE;
                    nativeSetIsScrolling(true);
                } //End block
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    nativeSetIsScrolling(false);
                    keepScrollBarsVisible = true;
                } //End block
                mLastTouchTime = eventTime;
            } //End block
            doDrag(deltaX, deltaY);
            {
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    invalidate();
                } //End block
                awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(),
                            false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                            .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
            } //End block
            {
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_692766842 = (!isFocused());
                requestFocus();
            } //End collapsed parenthetic
            {
                boolean var4F0E2B9C4455366734F8A4D46CDF3837_161415254 = (shouldForwardTouchEvent());
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
                    ted.mIds = new int[1];
                    ted.mIds[0] = ev.getPointerId(0);
                    ted.mAction = action;
                    ted.mPoints = new Point[1];
                    ted.mPoints[0] = new Point(contentX, contentY);
                    ted.mPointsInView = new Point[1];
                    ted.mPointsInView[0] = new Point(x, y);
                    ted.mMetaState = ev.getMetaState();
                    ted.mReprocess = mDeferTouchProcess;
                    ted.mNativeLayer = mCurrentScrollingLayerId;
                    ted.mNativeLayerRect.set(mScrollingLayerRect);
                    ted.mSequence = mTouchEventQueue.nextTouchSequence();
                    mTouchEventQueue.preQueueTouchEventData(ted);
                    mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                } //End block
            } //End collapsed parenthetic
            mLastTouchUpTime = eventTime;
            {
                mAutoScrollX = mAutoScrollY = 0;
            } //End block
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_DOUBLE_TAP_MODE 
            {
                boolean var99D9C999635D25840B0CAFFCC353615B_2084700935 = (inFullScreenMode() || mDeferTouchProcess);
                {
                    TouchEventData ted;
                    ted = new TouchEventData();
                    ted.mIds = new int[1];
                    ted.mIds[0] = ev.getPointerId(0);
                    ted.mAction = WebViewCore.ACTION_DOUBLETAP;
                    ted.mPoints = new Point[1];
                    ted.mPoints[0] = new Point(contentX, contentY);
                    ted.mPointsInView = new Point[1];
                    ted.mPointsInView[0] = new Point(x, y);
                    ted.mMetaState = ev.getMetaState();
                    ted.mReprocess = mDeferTouchProcess;
                    ted.mNativeLayer = nativeScrollableLayer(
                                    contentX, contentY,
                                    ted.mNativeLayerRect, null);
                    ted.mSequence = mTouchEventQueue.nextTouchSequence();
                    mTouchEventQueue.preQueueTouchEventData(ted);
                    mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                } //End block
                {
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    mTouchMode = TOUCH_DONE_MODE;
                } //End block
            } //End collapsed parenthetic
            //End case TOUCH_DOUBLE_TAP_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            {
                {
                    boolean var9A35F484FD2A3035C5778E7274850AEE_1031057243 = (mPreventDefault != PREVENT_DEFAULT_YES
                                    && (computeMaxScrollX() > 0
                                            || computeMaxScrollY() > 0));
                    {
                        WebViewCore.reducePriority();
                        WebViewCore.pauseUpdatePicture(mWebViewCore);
                    } //End block
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    {
                        boolean var52238646ADDC3EDB53CF60FF8D752DAA_2016716267 = (!nativeHitSelection(contentX, contentY));
                        {
                            selectionDone();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var7ECA0E1176F50826819D1E05F7BE240D_1205903790 = (mTouchMode == TOUCH_INIT_MODE
                                    && (canZoomIn() || canZoomOut()));
                    {
                        mPrivateHandler.sendEmptyMessageDelayed(
                                        RELEASE_SINGLE_TAP, ViewConfiguration
                                                .getDoubleTapTimeout());
                    } //End block
                    {
                        doShortPress();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case TOUCH_INIT_MODE TOUCH_SHORTPRESS_START_MODE TOUCH_SHORTPRESS_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            {
                {
                    mVelocityTracker.addMovement(ev);
                } //End block
                mHeldMotionless = MOTIONLESS_IGNORE;
                doFling();
            } //End block
            {
                {
                    boolean varBCFC69392A8766EDCCDAD1B162C3D405_46555919 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    computeMaxScrollX(), 0,
                                    computeMaxScrollY()));
                    {
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            mHeldMotionless = MOTIONLESS_TRUE;
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            invalidate();
            //End case TOUCH_DRAG_MODE TOUCH_DRAG_LAYER_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            mLastVelocity = 0;
            //End case TOUCH_DRAG_START_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            WebViewCore.resumePriority();
            //End case TOUCH_DRAG_START_MODE 
            //Begin case TOUCH_DRAG_START_MODE 
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
            //End case TOUCH_DRAG_START_MODE 
            stopTouch();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            {
                mScroller.springBack(mScrollX, mScrollY, 0,
                            computeMaxScrollX(), 0, computeMaxScrollY());
                invalidate();
            } //End block
            cancelWebCoreTouchEvent(contentX, contentY, false);
            cancelTouch();
        } //End block
        //End case MotionEvent.ACTION_CANCEL 
        addTaint(ev.getTaint());
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142482282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142482282;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.528 -0400", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "B529AF586117C961D18553E43D63A6F5")
    private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        TouchEventData ted;
        ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        int count;
        count = ev.getPointerCount();
        ted.mIds = new int[count];
        ted.mPoints = new Point[count];
        ted.mPointsInView = new Point[count];
        {
            int c;
            c = 0;
            {
                ted.mIds[c] = ev.getPointerId(c);
                int x;
                x = viewToContentX((int) ev.getX(c) + mScrollX);
                int y;
                y = viewToContentY((int) ev.getY(c) + mScrollY);
                ted.mPoints[c] = new Point(x, y);
                ted.mPointsInView[c] = new Point((int) ev.getX(c), (int) ev.getY(c));
            } //End block
        } //End collapsed parenthetic
        {
            ted.mActionIndex = ev.getActionIndex();
        } //End block
        ted.mMetaState = ev.getMetaState();
        ted.mReprocess = true;
        ted.mMotionEvent = MotionEvent.obtain(ev);
        ted.mSequence = sequence;
        mTouchEventQueue.preQueueTouchEventData(ted);
        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
        cancelLongPress();
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        addTaint(ev.getTaint());
        addTaint(sequence);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.540 -0400", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "8D8A52E658531487EBAED3406130CF0B")
     void handleMultiTouchInWebView(MotionEvent ev) {
        ScaleGestureDetector detector;
        detector = mZoomManager.getMultiTouchGestureDetector();
        float x;
        x = ev.getX();
        float y;
        y = ev.getY();
        {
            detector.onTouchEvent(ev);
            {
                boolean var57DA30FC8CBBE7A73D9281B93734CBB1_1727352554 = (detector.isInProgress());
                {
                    mLastTouchTime = ev.getEventTime();
                    x = detector.getFocusX();
                    y = detector.getFocusY();
                    cancelLongPress();
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    {
                        boolean var1701A38F89582DE3B703C873F3E6A99C_1545431252 = (!mZoomManager.supportsPanDuringZoom());
                    } //End collapsed parenthetic
                    mTouchMode = TOUCH_DRAG_MODE;
                    {
                        mVelocityTracker = VelocityTracker.obtain();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int action;
        action = ev.getActionMasked();
        {
            cancelTouch();
            action = MotionEvent.ACTION_DOWN;
        } //End block
        {
            boolean var3FCFE6069F8C28D647A3D03480A488F3_876654345 = (action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2);
            {
                mLastTouchX = Math.round(x);
                mLastTouchY = Math.round(y);
            } //End block
        } //End collapsed parenthetic
        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.542 -0400", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "4079A4E6E3BDCCDE27C66257CD3E2306")
    private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        {
            boolean var3C4264CDBD1B465E519441FFC519D662_585191026 = (shouldForwardTouchEvent());
            {
                {
                    mWebViewCore.removeMessages(EventHub.TOUCH_EVENT);
                } //End block
                TouchEventData ted;
                ted = new TouchEventData();
                ted.mIds = new int[1];
                ted.mIds[0] = 0;
                ted.mPoints = new Point[1];
                ted.mPoints[0] = new Point(x, y);
                ted.mPointsInView = new Point[1];
                int viewX;
                viewX = contentToViewX(x) - mScrollX;
                int viewY;
                viewY = contentToViewY(y) - mScrollY;
                ted.mPointsInView[0] = new Point(viewX, viewY);
                ted.mAction = MotionEvent.ACTION_CANCEL;
                ted.mNativeLayer = nativeScrollableLayer(
                    x, y, ted.mNativeLayerRect, null);
                ted.mSequence = mTouchEventQueue.nextTouchSequence();
                mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                mPreventDefault = PREVENT_DEFAULT_IGNORE;
                {
                    mTouchEventQueue.ignoreCurrentlyMissingEvents();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        addTaint(removeEvents);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.542 -0400", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "0D7562C6FBA96481178741005DE5C3EB")
    private void startTouch(float x, float y, long eventTime) {
        mStartTouchX = mLastTouchX = Math.round(x);
        mStartTouchY = mLastTouchY = Math.round(y);
        mLastTouchTime = eventTime;
        mVelocityTracker = VelocityTracker.obtain();
        mSnapScrollMode = SNAP_NONE;
        mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                ViewConfiguration.getTapTimeout());
        // ---------- Original Method ----------
        //mStartTouchX = mLastTouchX = Math.round(x);
        //mStartTouchY = mLastTouchY = Math.round(y);
        //mLastTouchTime = eventTime;
        //mVelocityTracker = VelocityTracker.obtain();
        //mSnapScrollMode = SNAP_NONE;
        //mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                //ViewConfiguration.getTapTimeout());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.551 -0400", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "319FC1C72835795F52968677012BD08A")
    private void startDrag() {
        WebViewCore.reducePriority();
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);
        {
            nativeHideCursor();
        } //End block
        {
            mZoomManager.invokeZoomPicker();
        } //End block
        // ---------- Original Method ----------
        //WebViewCore.reducePriority();
        //WebViewCore.pauseUpdatePicture(mWebViewCore);
        //nativeSetIsScrolling(true);
        //if (!mDragFromTextInput) {
            //nativeHideCursor();
        //}
        //if (mHorizontalScrollBarMode != SCROLLBAR_ALWAYSOFF
                //|| mVerticalScrollBarMode != SCROLLBAR_ALWAYSOFF) {
            //mZoomManager.invokeZoomPicker();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.561 -0400", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "025E0A602C34E6718F40E2F8F624D119")
    private void doDrag(int deltaX, int deltaY) {
        {
            int oldX;
            oldX = mScrollX;
            int oldY;
            oldY = mScrollY;
            int rangeX;
            rangeX = computeMaxScrollX();
            int rangeY;
            rangeY = computeMaxScrollY();
            int overscrollDistance;
            overscrollDistance = mOverscrollDistance;
            {
                int contentX;
                contentX = viewToContentDimension(deltaX);
                int contentY;
                contentY = viewToContentDimension(deltaY);
                int maxX;
                maxX = mScrollingLayerRect.right;
                int maxY;
                maxY = mScrollingLayerRect.bottom;
                int resultX;
                resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                int resultY;
                resultY = Math.max(0,
                        Math.min(mScrollingLayerRect.top + contentY, maxY));
                {
                    mTouchMode = TOUCH_DRAG_LAYER_MODE;
                    deltaX = contentX;
                    deltaY = contentY;
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = maxX;
                    rangeY = maxY;
                } //End block
                {
                    mTouchMode = TOUCH_DRAG_MODE;
                } //End block
            } //End block
            {
                mOverScrollGlow.setOverScrollDeltas(deltaX, deltaY);
            } //End block
            overScrollBy(deltaX, deltaY, oldX, oldY,
                    rangeX, rangeY,
                    mOverscrollDistance, mOverscrollDistance, true);
            {
                boolean var5792E174AFE968D06415B5B7AAC36535_873710809 = (mOverScrollGlow != null && mOverScrollGlow.isAnimating());
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        mZoomManager.keepZoomPickerVisible();
        addTaint(deltaX);
        addTaint(deltaY);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.562 -0400", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "059038C4D349AF7A2187BFE4652B2106")
    private void stopTouch() {
        {
            boolean varCAF00077668D04F986EAAEC815FA20E7_1257741151 = (mScroller.isFinished() && !mSelectingText
                && (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE));
            {
                WebViewCore.resumePriority();
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                nativeSetIsScrolling(false);
            } //End block
        } //End collapsed parenthetic
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        {
            mOverScrollGlow.releaseAll();
        } //End block
        // ---------- Original Method ----------
        //if (mScroller.isFinished() && !mSelectingText
                //&& (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE)) {
            //WebViewCore.resumePriority();
            //WebViewCore.resumeUpdatePicture(mWebViewCore);
            //nativeSetIsScrolling(false);
        //}
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
        //if (mOverScrollGlow != null) {
            //mOverScrollGlow.releaseAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.563 -0400", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "EA26FD1E906282285B5B900587B2C9BB")
    private void cancelTouch() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        } //End block
        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
        {
            boolean varAC20DC667EA914A16B375E9527C79DFD_697875016 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
            } //End block
        } //End collapsed parenthetic
        mHeldMotionless = MOTIONLESS_TRUE;
        mTouchMode = TOUCH_DONE_MODE;
        nativeHideCursor();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.564 -0400", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "C33DFC2CB03AB3D4B35704522A024BF4")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1968588650 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_407719581 = (event.getAction());
                    //Begin case MotionEvent.ACTION_SCROLL 
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_1130118948 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                            {
                                vscroll = 0;
                                hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            } //End block
                            {
                                vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                            } //End block
                        } //End collapsed parenthetic
                        {
                            int vdelta;
                            vdelta = (int) (vscroll * getVerticalScrollFactor());
                            int hdelta;
                            hdelta = (int) (hscroll * getHorizontalScrollFactor());
                            {
                                boolean var2D3D9D2324BD436DC860CC59381AD41D_22655186 = (pinScrollBy(hdelta, vdelta, false, 0));
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    //End case MotionEvent.ACTION_SCROLL 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1191123494 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246073256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246073256;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.573 -0400", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "791AAE015ADF7CA304395081F6AC4FBB")
    public void setMapTrackballToArrowKeys(boolean setMap) {
        checkThread();
        mMapTrackballToArrowKeys = setMap;
        // ---------- Original Method ----------
        //checkThread();
        //mMapTrackballToArrowKeys = setMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.579 -0400", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "6AC8F93A7F315BEE56D465931AC8D27F")
     void resetTrackballTime() {
        mTrackballLastTime = 0;
        // ---------- Original Method ----------
        //mTrackballLastTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.584 -0400", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "A44B3EBAF647BC64CED7834A9519ACF1")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        long time;
        time = ev.getEventTime();
        {
            boolean varF89B2554B17216A1EC58B9D61476F71F_1396886842 = ((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0);
            {
                {
                    boolean varF71C9C4037B7A9B705CFAAB9834929D8_941186873 = (ev.getY() > 0);
                    pageDown(true);
                } //End collapsed parenthetic
                {
                    boolean var07FD34B1A3496FC381CDBE7EFC3BB0AA_66387341 = (ev.getY() < 0);
                    pageUp(true);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_1933901651 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                mTrackballDown = true;
                {
                    boolean varD7E949BAB427F90FF96CAA2888F6F2C4_1746478886 = (time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds()));
                    {
                        nativeSelectBestAt(mLastCursorBounds);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varAFC77293C02F773029137FDE42129C14_1024543624 = (isInTouchMode());
                    requestFocusFromTouch();
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9BE2C50B8CBB194C9242022F6D5B67CC_1168685485 = (ev.getAction() == MotionEvent.ACTION_UP);
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mTrackballDown = false;
                mTrackballUpTime = time;
                {
                    {
                        copySelection();
                        selectionDone();
                    } //End block
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var963F7CE81FE031C5E5B8879F84F3644B_1560376434 = ((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
                AccessibilityManager.getInstance(mContext).isEnabled());
        } //End collapsed parenthetic
        switchOutDrawHistory();
        {
            mTrackballFirstTime = time;
            mTrackballXMove = mTrackballYMove = 0;
        } //End block
        mTrackballLastTime = time;
        mTrackballRemainsX += ev.getX();
        mTrackballRemainsY += ev.getY();
        doTrackball(time, ev.getMetaState());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983403659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983403659;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.586 -0400", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "33684803CB6F23034F4154CE372A5BC2")
     void moveSelection(float xRate, float yRate) {
        int width;
        width = getViewWidth();
        int height;
        height = getViewHeight();
        mSelectX += xRate;
        mSelectY += yRate;
        int maxX;
        maxX = width + mScrollX;
        int maxY;
        maxY = height + mScrollY;
        mSelectX = Math.min(maxX, Math.max(mScrollX - SELECT_CURSOR_OFFSET
                , mSelectX));
        mSelectY = Math.min(maxY, Math.max(mScrollY - SELECT_CURSOR_OFFSET
                , mSelectY));
        nativeMoveSelection(viewToContentX(mSelectX), viewToContentY(mSelectY));
        int scrollX;
        scrollX = SELECT_CURSOR_OFFSET;
        scrollX = 0;
        int scrollY;
        scrollY = SELECT_CURSOR_OFFSET;
        scrollY = 0;
        pinScrollBy(scrollX, scrollY, true, 0);
        Rect select;
        select = new Rect(mSelectX, mSelectY, mSelectX + 1, mSelectY + 1);
        requestRectangleOnScreen(select);
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.595 -0400", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "0BDD49B94DC1B6206387BD567FF9BBCE")
    private int scaleTrackballX(float xRate, int width) {
        int xMove;
        xMove = (int) (xRate / TRACKBALL_SCALE * width);
        int nextXMove;
        nextXMove = xMove;
        {
            {
                xMove -= mTrackballXMove;
            } //End block
        } //End block
        {
            xMove -= mTrackballXMove;
        } //End block
        mTrackballXMove = nextXMove;
        addTaint(xRate);
        addTaint(width);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445188265 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445188265;
        // ---------- Original Method ----------
        //int xMove = (int) (xRate / TRACKBALL_SCALE * width);
        //int nextXMove = xMove;
        //if (xMove > 0) {
            //if (xMove > mTrackballXMove) {
                //xMove -= mTrackballXMove;
            //}
        //} else if (xMove < mTrackballXMove) {
            //xMove -= mTrackballXMove;
        //}
        //mTrackballXMove = nextXMove;
        //return xMove;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.596 -0400", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "31D81CE602177CBEA429AB782370F124")
    private int scaleTrackballY(float yRate, int height) {
        int yMove;
        yMove = (int) (yRate / TRACKBALL_SCALE * height);
        int nextYMove;
        nextYMove = yMove;
        {
            {
                yMove -= mTrackballYMove;
            } //End block
        } //End block
        {
            yMove -= mTrackballYMove;
        } //End block
        mTrackballYMove = nextYMove;
        addTaint(yRate);
        addTaint(height);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577253038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577253038;
        // ---------- Original Method ----------
        //int yMove = (int) (yRate / TRACKBALL_SCALE * height);
        //int nextYMove = yMove;
        //if (yMove > 0) {
            //if (yMove > mTrackballYMove) {
                //yMove -= mTrackballYMove;
            //}
        //} else if (yMove < mTrackballYMove) {
            //yMove -= mTrackballYMove;
        //}
        //mTrackballYMove = nextYMove;
        //return yMove;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.597 -0400", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "8604812B3E01A90DF3BDE85FC734F01D")
    private int keyCodeToSoundsEffect(int keyCode) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
        addTaint(keyCode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963101780 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963101780;
        // ---------- Original Method ----------
        //switch(keyCode) {
            //case KeyEvent.KEYCODE_DPAD_UP:
                //return SoundEffectConstants.NAVIGATION_UP;
            //case KeyEvent.KEYCODE_DPAD_RIGHT:
                //return SoundEffectConstants.NAVIGATION_RIGHT;
            //case KeyEvent.KEYCODE_DPAD_DOWN:
                //return SoundEffectConstants.NAVIGATION_DOWN;
            //case KeyEvent.KEYCODE_DPAD_LEFT:
                //return SoundEffectConstants.NAVIGATION_LEFT;
        //}
        //throw new IllegalArgumentException("keyCode must be one of " +
                //"{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                //"KEYCODE_DPAD_LEFT}.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.618 -0400", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "085190ED6132963124D40A786CCDA142")
    private void doTrackball(long time, int metaState) {
        int elapsed;
        elapsed = (int) (mTrackballLastTime - mTrackballFirstTime);
        {
            elapsed = TRACKBALL_TIMEOUT;
        } //End block
        float xRate;
        xRate = mTrackballRemainsX * 1000 / elapsed;
        float yRate;
        yRate = mTrackballRemainsY * 1000 / elapsed;
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeight();
        {
            {
                mSelectX = contentToViewX(nativeSelectionX());
                mSelectY = contentToViewY(nativeSelectionY());
                mDrawSelectionPointer = mExtendSelection = true;
                nativeSetExtendSelection();
            } //End block
            moveSelection(scaleTrackballX(xRate, viewWidth),
                    scaleTrackballY(yRate, viewHeight));
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } //End block
        float ax;
        ax = Math.abs(xRate);
        float ay;
        ay = Math.abs(yRate);
        float maxA;
        maxA = Math.max(ax, ay);
        int width;
        width = mContentWidth - viewWidth;
        int height;
        height = mContentHeight - viewHeight;
        width = 0;
        height = 0;
        ax = Math.abs(mTrackballRemainsX * TRACKBALL_MULTIPLIER);
        ay = Math.abs(mTrackballRemainsY * TRACKBALL_MULTIPLIER);
        maxA = Math.max(ax, ay);
        int count;
        count = Math.max(0, (int) maxA);
        int oldScrollX;
        oldScrollX = mScrollX;
        int oldScrollY;
        oldScrollY = mScrollY;
        {
            int selectKeyCode;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_LEFT;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
            count = Math.min(count, TRACKBALL_MOVE_COUNT);
            {
                boolean var13243A190284240A17DA938A95FFCA4B_1205653789 = (mNativeClass != 0 && nativePageShouldHandleShiftAndArrows());
                {
                    {
                        int i;
                        i = 0;
                        {
                            letPageHandleNavKey(selectKeyCode, time, true, metaState);
                        } //End block
                    } //End collapsed parenthetic
                    letPageHandleNavKey(selectKeyCode, time, false, metaState);
                } //End block
                {
                    boolean var9216DDA0E70E02F03C94252CA6894A26_2053132027 = (navHandledKey(selectKeyCode, count, false, time));
                    {
                        playSoundEffect(keyCodeToSoundsEffect(selectKeyCode));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } //End block
        {
            int xMove;
            xMove = scaleTrackballX(xRate, width);
            int yMove;
            yMove = scaleTrackballY(yRate, height);
            {
                boolean var1510D01512E341B4186F1DC473D82D5C_817685289 = (Math.abs(mScrollX - oldScrollX) > Math.abs(xMove));
                {
                    xMove = 0;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varEA9F4D4529504DF5B7FB3F15ED262404_375454219 = (Math.abs(mScrollY - oldScrollY) > Math.abs(yMove));
                {
                    yMove = 0;
                } //End block
            } //End collapsed parenthetic
            {
                pinScrollBy(xMove, yMove, true, 0);
            } //End block
        } //End block
        addTaint(time);
        addTaint(metaState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.619 -0400", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "70425307FE810523F65E21A0BAA9A931")
     int computeMaxScrollX() {
        int varA25CFD9DF68C570DBFC28D80EAD42611_1595276258 = (Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012680663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012680663;
        // ---------- Original Method ----------
        //return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.619 -0400", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "DABBCFCED2FE4547EA094DBED20AC4BD")
     int computeMaxScrollY() {
        int varBA3EE78DB7716D218FE9D8E3CD2F2343_908014335 = (Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138573230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138573230;
        // ---------- Original Method ----------
        //return Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                //- getViewHeightWithTitle(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.620 -0400", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "F551E523E481A233F65F353E27AEDF89")
     boolean updateScrollCoordinates(int x, int y) {
        int oldX;
        oldX = mScrollX;
        int oldY;
        oldY = mScrollY;
        mScrollX = x;
        mScrollY = y;
        {
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        } //End block
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707606453 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707606453;
        // ---------- Original Method ----------
        //int oldX = mScrollX;
        //int oldY = mScrollY;
        //mScrollX = x;
        //mScrollY = y;
        //if (oldX != mScrollX || oldY != mScrollY) {
            //onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.620 -0400", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "5F5421322FCE4E8262F4AA0CAC479CF1")
    public void flingScroll(int vx, int vy) {
        checkThread();
        mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
        addTaint(vx);
        addTaint(vy);
        // ---------- Original Method ----------
        //checkThread();
        //mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                //computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.624 -0400", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "D64804782012F689ABF2FDF3142A1A54")
    private void doFling() {
        int maxX;
        maxX = computeMaxScrollX();
        int maxY;
        maxY = computeMaxScrollY();
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int vx;
        vx = (int) mVelocityTracker.getXVelocity();
        int vy;
        vy = (int) mVelocityTracker.getYVelocity();
        int scrollX;
        scrollX = mScrollX;
        int scrollY;
        scrollY = mScrollY;
        int overscrollDistance;
        overscrollDistance = mOverscrollDistance;
        int overflingDistance;
        overflingDistance = mOverflingDistance;
        {
            scrollX = mScrollingLayerRect.left;
            scrollY = mScrollingLayerRect.top;
            maxX = mScrollingLayerRect.right;
            maxY = mScrollingLayerRect.bottom;
            overscrollDistance = overflingDistance = 0;
        } //End block
        {
            {
                vy = 0;
            } //End block
            {
                vx = 0;
            } //End block
        } //End block
        {
            WebViewCore.resumePriority();
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
            {
                boolean var294FD332965037BDDAF5E40360BE82C6_380260641 = (mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY));
                {
                    invalidate();
                } //End block
            } //End collapsed parenthetic
        } //End block
        float currentVelocity;
        currentVelocity = mScroller.getCurrVelocity();
        float velocity;
        velocity = (float) Math.hypot(vx, vy);
        {
            float deltaR;
            deltaR = (float) (Math.abs(Math.atan2(mLastVelY, mLastVelX)
                    - Math.atan2(vy, vx)));
            float circle;
            circle = (float) (Math.PI) * 2.0f;
            {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
            } //End block
        } //End block
        {
            boolean var7D437B480773CFFE36BF196E1126697F_1819358368 = ((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy));
            {
                vx = 0;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var062E5EDAB50CDBF113CFC310D559CF03_1034890771 = ((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx));
            {
                vy = 0;
            } //End block
        } //End collapsed parenthetic
        {
            {
                vx = 0;
            } //End block
            {
                vy = 0;
            } //End block
        } //End block
        mLastVelX = vx;
        mLastVelY = vy;
        mLastVelocity = velocity;
        mScroller.fling(scrollX, scrollY, -vx, -vy, 0, maxX, 0, maxY,
                maxX == 0 ? 0 : overflingDistance, overflingDistance);
        int time;
        time = mScroller.getDuration();
        {
            awakenScrollBars(time);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.641 -0400", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "603121C7329697CB0BB228B1D81BBD8A")
    @Deprecated
    public View getZoomControls() {
        View varB4EAC82CA7396A68D541C85D26508E83_1800692225 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_22501458 = null; //Variable for return #2
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_1109621514 = (!getSettings().supportZoom());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1800692225 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_22501458 = mZoomManager.getExternalZoomPicker();
        View varA7E53CE21691AB073D9660D615818899_2060526079; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2060526079 = varB4EAC82CA7396A68D541C85D26508E83_1800692225;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2060526079 = varB4EAC82CA7396A68D541C85D26508E83_22501458;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2060526079.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2060526079;
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return null;
        //}
        //return mZoomManager.getExternalZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.642 -0400", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "E0110D1A2A491ABF92EE451CB29B8360")
     void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
        // ---------- Original Method ----------
        //mZoomManager.dismissZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.642 -0400", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "E07B281DC1082CEF8D829C6ED4C041BC")
     float getDefaultZoomScale() {
        float var952A9E36B82C4A93C3ADCF5509083504_649071043 = (mZoomManager.getDefaultScale());
        float var546ADE640B6EDFBC8A086EF31347E768_2128739717 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2128739717;
        // ---------- Original Method ----------
        //return mZoomManager.getDefaultScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.642 -0400", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "08101CD77EB3F3BBDB6F4198C9BD8EBD")
     float getZoomOverviewScale() {
        float varEF858DD667F2D952B7E5019CEC33E4DD_1722804284 = (mZoomManager.getZoomOverviewScale());
        float var546ADE640B6EDFBC8A086EF31347E768_1445604969 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1445604969;
        // ---------- Original Method ----------
        //return mZoomManager.getZoomOverviewScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.643 -0400", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "49B34CD1D3F0E3C4FC6C7FDFED649608")
    public boolean canZoomIn() {
        checkThread();
        boolean varB7D0C9863F46AF864AE5BCCDA2FEA388_1840260330 = (mZoomManager.canZoomIn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957242937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957242937;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.644 -0400", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "9378C6894C4FFAFAC7E5CEF01DA2E015")
    public boolean canZoomOut() {
        checkThread();
        boolean var55B9AB817324FC769B25B74F0D5FB277_756401979 = (mZoomManager.canZoomOut());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1093829180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1093829180;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.644 -0400", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "C78B86E1C004DBA6229AC89B8C691DC4")
    public boolean zoomIn() {
        checkThread();
        boolean varAC42C946D5F06586AAF06194E5591056_1928373653 = (mZoomManager.zoomIn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593378765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593378765;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.644 -0400", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "17DF0E07B066F408FFDC0CF216F8D3D0")
    public boolean zoomOut() {
        checkThread();
        boolean varA9C5CE6824B53568BAC50FAF0F581652_1436956480 = (mZoomManager.zoomOut());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246182708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246182708;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.645 -0400", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "48AFB1D4C92D3637F7483F34272B10ED")
    private void updateSelection() {
        mPrivateHandler.removeMessages(UPDATE_SELECTION);
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        Rect rect;
        rect = new Rect(contentX - slop, contentY - slop,
                contentX + slop, contentY + slop);
        nativeSelectBestAt(rect);
        mInitialHitTestResult = hitTestResult(null);
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return;
        //}
        //mPrivateHandler.removeMessages(UPDATE_SELECTION);
        //int contentX = viewToContentX(mLastTouchX + mScrollX);
        //int contentY = viewToContentY(mLastTouchY + mScrollY);
        //int slop = viewToContentDimension(mNavSlop);
        //Rect rect = new Rect(contentX - slop, contentY - slop,
                //contentX + slop, contentY + slop);
        //nativeSelectBestAt(rect);
        //mInitialHitTestResult = hitTestResult(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.647 -0400", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "502A114A7F4FCC91B2CF0AF2E0048E60")
     void scrollFocusedTextInputX(float xPercent) {
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1115318028 = (!inEditingMode() || mWebViewCore == null);
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                new Float(xPercent));
        addTaint(xPercent);
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                //new Float(xPercent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.651 -0400", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "64EC5CB3A93E682A6AB10C5E035AA070")
     void scrollFocusedTextInputY(int y) {
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_453984757 = (!inEditingMode() || mWebViewCore == null);
        } //End collapsed parenthetic
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
        addTaint(y);
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.657 -0400", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "278CF0468B8D32BEADA97B672F4B507F")
     void initiateTextFieldDrag(float x, float y, long eventTime) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_1452013879 = (!inEditingMode());
        } //End collapsed parenthetic
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        mLastTouchTime = eventTime;
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_567498789 = (!mScroller.isFinished());
            {
                abortAnimation();
            } //End block
        } //End collapsed parenthetic
        mSnapScrollMode = SNAP_NONE;
        mVelocityTracker = VelocityTracker.obtain();
        mTouchMode = TOUCH_DRAG_START_MODE;
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return;
        //}
        //mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        //mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        //mLastTouchTime = eventTime;
        //if (!mScroller.isFinished()) {
            //abortAnimation();
        //}
        //mSnapScrollMode = SNAP_NONE;
        //mVelocityTracker = VelocityTracker.obtain();
        //mTouchMode = TOUCH_DRAG_START_MODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.658 -0400", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "827828FA2B12CD6EECA62B539E78C35B")
     boolean textFieldDrag(MotionEvent event) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_35556424 = (!inEditingMode());
        } //End collapsed parenthetic
        mDragFromTextInput = true;
        event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                (float) (mWebTextView.getTop() - mScrollY));
        boolean result;
        result = onTouchEvent(event);
        mDragFromTextInput = false;
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448140398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448140398;
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return false;
        //}
        //mDragFromTextInput = true;
        //event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                //(float) (mWebTextView.getTop() - mScrollY));
        //boolean result = onTouchEvent(event);
        //mDragFromTextInput = false;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.658 -0400", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "DBB11B5845E76F4AB1AFAD2927AD59C7")
     void touchUpOnTextField(MotionEvent event) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_128178247 = (!inEditingMode());
        } //End collapsed parenthetic
        int x;
        x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        int y;
        y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        int slop;
        slop = viewToContentDimension(mNavSlop);
        nativeMotionUp(x, y, slop);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return;
        //}
        //int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        //int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        //int slop = viewToContentDimension(mNavSlop);
        //nativeMotionUp(x, y, slop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.663 -0400", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "07B7429CE92B5FFBFFF85A5139F60BF3")
     void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    //nativeCursorNodePointer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.665 -0400", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "BFFAB978238DC15483366061097DE582")
    private void doShortPress() {
        mTouchMode = TOUCH_DONE_MODE;
        updateSelection();
        switchOutDrawHistory();
        int contentX;
        contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY;
        contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean var4BAF6D43948FA1BCD9CF85CF914BDF89_1387020616 = (USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty());
            {
                mTouchHighlightRequested = 0;
                invalidate(mTouchHighlightRegion.getBounds());
                mPrivateHandler.postDelayed(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.664 -0400", hash_original_method = "862A653E9B61CDCF6EC82472350CCAAA", hash_generated_method = "E8C29D6A71E7E23B309BC73E875C4F22")
                    @Override
                    public void run() {
                        removeTouchHighlight();
                        // ---------- Original Method ----------
                        //removeTouchHighlight();
                    }
}, ViewConfiguration.getPressedStateDuration());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5F51EF0491BBB7096F9C5C6CD4BCA197_1350671391 = (getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
                WebViewCore.TouchUpData touchUpData;
                touchUpData = new WebViewCore.TouchUpData();
                touchUpData.mMoveGeneration = 0;
                mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
            } //End block
            {
                boolean varDA83C45CB8F2A6B5FD9F88AE0C10D3FD_957480933 = (nativePointInNavCache(contentX, contentY, slop));
                {
                    WebViewCore.MotionUpData motionUpData;
                    motionUpData = new WebViewCore
                    .MotionUpData();
                    motionUpData.mFrame = nativeCacheHitFramePointer();
                    motionUpData.mNode = nativeCacheHitNodePointer();
                    motionUpData.mBounds = nativeCacheHitNodeBounds();
                    motionUpData.mX = contentX;
                    motionUpData.mY = contentY;
                    mWebViewCore.sendMessageAtFrontOfQueue(EventHub.VALID_NODE_BOUNDS,
                    motionUpData);
                } //End block
                {
                    doMotionUp(contentX, contentY);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.665 -0400", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "023BA475C73990DEA84593F731544775")
    private void doMotionUp(int contentX, int contentY) {
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varC55016010C379CE34BF3B6896DDAD394_1527454836 = (nativeMotionUp(contentX, contentY, slop) && mLogEvent);
            {
                EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7C1BED8D4E1F2400404C847BC14812AF_1618472231 = (nativeHasCursorNode() && !nativeCursorIsTextInput());
            {
                playSoundEffect(SoundEffectConstants.CLICK);
            } //End block
        } //End collapsed parenthetic
        addTaint(contentX);
        addTaint(contentY);
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativeMotionUp(contentX, contentY, slop) && mLogEvent) {
            //EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
        //}
        //if (nativeHasCursorNode() && !nativeCursorIsTextInput()) {
            //playSoundEffect(SoundEffectConstants.CLICK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.670 -0400", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "C93F605E15A477EBB506444304D44C5C")
     void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.671 -0400", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "043D35303D5C0390AFDD95A1E6D9C51E")
     Rect getPluginBounds(int x, int y) {
        Rect varB4EAC82CA7396A68D541C85D26508E83_60313960 = null; //Variable for return #1
        Rect varB4EAC82CA7396A68D541C85D26508E83_529917919 = null; //Variable for return #2
        int slop;
        slop = viewToContentDimension(mNavSlop);
        {
            boolean varE761D0BE351A5DB0C46D78ECBD6C783A_864177668 = (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin());
            {
                varB4EAC82CA7396A68D541C85D26508E83_60313960 = nativeCacheHitNodeBounds();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_529917919 = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(x);
        addTaint(y);
        Rect varA7E53CE21691AB073D9660D615818899_1292024174; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1292024174 = varB4EAC82CA7396A68D541C85D26508E83_60313960;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1292024174 = varB4EAC82CA7396A68D541C85D26508E83_529917919;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1292024174.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1292024174;
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin()) {
            //return nativeCacheHitNodeBounds();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.676 -0400", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "10AEBCC4E075AA941F3458D038B251FF")
     boolean isRectFitOnScreen(Rect rect) {
        int rectWidth;
        rectWidth = rect.width();
        int rectHeight;
        rectHeight = rect.height();
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        boolean var21C05C69D4E6BB9F2891D7DC21CA89A0_1294886979 = (!mZoomManager.willScaleTriggerZoom(scale)
                && contentToViewX(rect.left) >= mScrollX
                && contentToViewX(rect.right) <= mScrollX + viewWidth
                && contentToViewY(rect.top) >= mScrollY
                && contentToViewY(rect.bottom) <= mScrollY + viewHeight);
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770417290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770417290;
        // ---------- Original Method ----------
        //final int rectWidth = rect.width();
        //final int rectHeight = rect.height();
        //final int viewWidth = getViewWidth();
        //final int viewHeight = getViewHeightWithTitle();
        //float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        //scale = mZoomManager.computeScaleWithLimits(scale);
        //return !mZoomManager.willScaleTriggerZoom(scale)
                //&& contentToViewX(rect.left) >= mScrollX
                //&& contentToViewX(rect.right) <= mScrollX + viewWidth
                //&& contentToViewY(rect.top) >= mScrollY
                //&& contentToViewY(rect.bottom) <= mScrollY + viewHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.683 -0400", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "CD07081ACC7BE94C8BFF63ED8C7B90C5")
     void centerFitRect(Rect rect) {
        int rectWidth;
        rectWidth = rect.width();
        int rectHeight;
        rectHeight = rect.height();
        int viewWidth;
        viewWidth = getViewWidth();
        int viewHeight;
        viewHeight = getViewHeightWithTitle();
        float scale;
        scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        {
            boolean varDD6431018C58684D7A37FFB96BEA1A10_532915703 = (!mZoomManager.willScaleTriggerZoom(scale));
            {
                pinScrollTo(contentToViewX(rect.left + rectWidth / 2) - viewWidth / 2,
                    contentToViewY(rect.top + rectHeight / 2) - viewHeight / 2,
                    true, 0);
            } //End block
            {
                float actualScale;
                actualScale = mZoomManager.getScale();
                float oldScreenX;
                oldScreenX = rect.left * actualScale - mScrollX;
                float rectViewX;
                rectViewX = rect.left * scale;
                float rectViewWidth;
                rectViewWidth = rectWidth * scale;
                float newMaxWidth;
                newMaxWidth = mContentWidth * scale;
                float newScreenX;
                newScreenX = (viewWidth - rectViewWidth) / 2;
                {
                    newScreenX = rectViewX;
                } //End block
                {
                    newScreenX = viewWidth - (newMaxWidth - rectViewX);
                } //End block
                float zoomCenterX;
                zoomCenterX = (oldScreenX * scale - newScreenX * actualScale)
                    / (scale - actualScale);
                float oldScreenY;
                oldScreenY = rect.top * actualScale + getTitleHeight()
                    - mScrollY;
                float rectViewY;
                rectViewY = rect.top * scale + getTitleHeight();
                float rectViewHeight;
                rectViewHeight = rectHeight * scale;
                float newMaxHeight;
                newMaxHeight = mContentHeight * scale + getTitleHeight();
                float newScreenY;
                newScreenY = (viewHeight - rectViewHeight) / 2;
                {
                    newScreenY = rectViewY;
                } //End block
                {
                    newScreenY = viewHeight - (newMaxHeight - rectViewY);
                } //End block
                float zoomCenterY;
                zoomCenterY = (oldScreenY * scale - newScreenY * actualScale)
                    / (scale - actualScale);
                mZoomManager.setZoomCenter(zoomCenterX, zoomCenterY);
                mZoomManager.startZoomAnimation(scale, false);
            } //End block
        } //End collapsed parenthetic
        addTaint(rect.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.683 -0400", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "65473085A53A9B680000D16ABFD331DC")
    private void overrideLoading(String url) {
        mCallbackProxy.uiOverrideUrlLoading(url);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
        //mCallbackProxy.uiOverrideUrlLoading(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.684 -0400", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "102478BA4AE98EA82A3A839BA4A13E33")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        boolean result;
        result = false;
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1116995295 = (inEditingMode());
            {
                result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
            } //End block
            {
                result = super.requestFocus(direction, previouslyFocusedRect);
                {
                    boolean varA494CE1F4ADF8E7072392AACBFD5D724_252597626 = (mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode());
                    {
                        int fakeKeyDirection;
                        fakeKeyDirection = 0;
                        //Begin case View.FOCUS_UP 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_UP;
                        //End case View.FOCUS_UP 
                        //Begin case View.FOCUS_DOWN 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_DOWN;
                        //End case View.FOCUS_DOWN 
                        //Begin case View.FOCUS_LEFT 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_LEFT;
                        //End case View.FOCUS_LEFT 
                        //Begin case View.FOCUS_RIGHT 
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_RIGHT;
                        //End case View.FOCUS_RIGHT 
                        {
                            boolean var191048386196A56D55A1FA6B9EBCC1D7_740640611 = (mNativeClass != 0 && !nativeHasCursorNode());
                            {
                                navHandledKey(fakeKeyDirection, 1, true, 0);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317806645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317806645;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.685 -0400", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "AECC8542F0CC3C0A56B7FBF99D72C752")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode;
        heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize;
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize;
        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight;
        measuredHeight = heightSize;
        int measuredWidth;
        measuredWidth = widthSize;
        int contentHeight;
        contentHeight = contentToViewDimension(mContentHeight);
        int contentWidth;
        contentWidth = contentToViewDimension(mContentWidth);
        {
            mHeightCanMeasure = true;
            measuredHeight = contentHeight;
            {
                {
                    measuredHeight = heightSize;
                    mHeightCanMeasure = false;
                    measuredHeight |= MEASURED_STATE_TOO_SMALL;
                } //End block
            } //End block
        } //End block
        {
            mHeightCanMeasure = false;
        } //End block
        {
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        } //End block
        {
            mWidthCanMeasure = true;
            measuredWidth = contentWidth;
        } //End block
        {
            {
                measuredWidth |= MEASURED_STATE_TOO_SMALL;
            } //End block
            mWidthCanMeasure = false;
        } //End block
        {
            setMeasuredDimension(measuredWidth, measuredHeight);
        } //End block
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.691 -0400", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "2D3E042932DEA967078B247A2CF44FB9")
    @Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        {
            boolean var264B566DF21DF74851E1F42772AB9C13_978544508 = (mZoomManager.isFixedLengthAnimationInProgress());
        } //End collapsed parenthetic
        rect.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        Rect content;
        content = new Rect(viewToContentX(mScrollX),
                viewToContentY(mScrollY),
                viewToContentX(mScrollX + getWidth()
                - getVerticalScrollbarWidth()),
                viewToContentY(mScrollY + getViewHeightWithTitle()));
        content = nativeSubtractLayers(content);
        int screenTop;
        screenTop = contentToViewY(content.top);
        int screenBottom;
        screenBottom = contentToViewY(content.bottom);
        int height;
        height = screenBottom - screenTop;
        int scrollYDelta;
        scrollYDelta = 0;
        {
            int oneThirdOfScreenHeight;
            oneThirdOfScreenHeight = height / 3;
            {
                boolean varD63CDEF6BD028FCFFAC8F4D0CD965025_5551898 = (rect.height() > 2 * oneThirdOfScreenHeight);
                {
                    scrollYDelta = rect.top - screenTop;
                } //End block
                {
                    scrollYDelta = rect.top - (screenTop + oneThirdOfScreenHeight);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            scrollYDelta = rect.top - screenTop;
        } //End block
        int screenLeft;
        screenLeft = contentToViewX(content.left);
        int screenRight;
        screenRight = contentToViewX(content.right);
        int width;
        width = screenRight - screenLeft;
        int scrollXDelta;
        scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_1068206581 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } //End block
                {
                    scrollXDelta += (rect.right - screenRight);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            scrollXDelta -= (screenLeft - rect.left);
        } //End block
        {
            boolean var5E8E4CF43F6392F54248EF881F3D0871_2543504 = (pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0));
        } //End block
        addTaint(child.getTaint());
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939649370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939649370;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.692 -0400", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "6D2FF4A3E9FCE6291A9DEF38A4E5B313")
     void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        WebViewCore.ReplaceTextData arg;
        arg = new WebViewCore.ReplaceTextData();
        arg.mReplace = replace;
        arg.mNewStart = newStart;
        arg.mNewEnd = newEnd;
        arg.mTextGeneration = mTextGeneration;
        mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
        addTaint(oldStart);
        addTaint(oldEnd);
        addTaint(replace.getTaint());
        addTaint(newStart);
        addTaint(newEnd);
        // ---------- Original Method ----------
        //WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
        //arg.mReplace = replace;
        //arg.mNewStart = newStart;
        //arg.mNewEnd = newEnd;
        //mTextGeneration++;
        //arg.mTextGeneration = mTextGeneration;
        //mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.692 -0400", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "39B98B2BB8B7DE04E55E37819D102BDF")
     void passToJavaScript(String currentText, KeyEvent event) {
        WebViewCore.JSKeyData arg;
        arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
        mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                cursorData(), 1000);
        addTaint(currentText.getTaint());
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (mWebViewCore == null) {
            //return;
        //}
        //WebViewCore.JSKeyData arg = new WebViewCore.JSKeyData();
        //arg.mEvent = event;
        //arg.mCurrentText = currentText;
        //mTextGeneration++;
        //mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        //mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        //mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                //cursorData(), 1000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.700 -0400", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "A8D265BD77A1860CDD1B6501DF1B6C39")
    public synchronized WebViewCore getWebViewCore() {
        WebViewCore varB4EAC82CA7396A68D541C85D26508E83_2095345655 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2095345655 = mWebViewCore;
        varB4EAC82CA7396A68D541C85D26508E83_2095345655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095345655;
        // ---------- Original Method ----------
        //return mWebViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.988 -0400", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "AA14EC5FF82C836D2E42E6B202944BA6")
    private void setTouchHighlightRects(ArrayList<Rect> rects) {
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
        {
            {
                Iterator<Rect> var667F73C18A060295B52BA65D5642C74D_1550555922 = (rects).iterator();
                var667F73C18A060295B52BA65D5642C74D_1550555922.hasNext();
                Rect rect = var667F73C18A060295B52BA65D5642C74D_1550555922.next();
                {
                    Rect viewRect;
                    viewRect = contentToViewRect(rect);
                    {
                        boolean varA5A6B8C49AB9156241CF88CA93A69E58_610771572 = (viewRect.width() < getWidth() >> 1
                        || viewRect.height() < getHeight() >> 1);
                        {
                            mTouchHighlightRegion.union(viewRect);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            invalidate(mTouchHighlightRegion.getBounds());
        } //End block
        addTaint(rects.getTaint());
        // ---------- Original Method ----------
        //invalidate(mTouchHighlightRegion.getBounds());
        //mTouchHighlightRegion.setEmpty();
        //if (rects != null) {
            //for (Rect rect : rects) {
                //Rect viewRect = contentToViewRect(rect);
                //if (viewRect.width() < getWidth() >> 1
                        //|| viewRect.height() < getHeight() >> 1) {
                    //mTouchHighlightRegion.union(viewRect);
                //} else {
                    //Log.w(LOGTAG, "Skip the huge selection rect:"
                            //+ viewRect);
                //}
            //}
            //invalidate(mTouchHighlightRegion.getBounds());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.999 -0400", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "6413C342D8DEBD5CE233683789B6F9B6")
    protected void pageSwapCallback(boolean notifyAnimationStarted) {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1603408165 = (inEditingMode());
            {
                didUpdateWebTextViewDimensions(ANYWHERE);
            } //End block
        } //End collapsed parenthetic
        {
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        } //End block
        addTaint(notifyAnimationStarted);
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //didUpdateWebTextViewDimensions(ANYWHERE);
        //}
        //if (notifyAnimationStarted) {
            //mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.001 -0400", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "9E566A1F611E9C329628B75099B176B5")
     void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
            } //End block
            mDelaySetPicture = draw;
        } //End block
        WebViewCore.ViewState viewState;
        viewState = draw.mViewState;
        boolean isPictureAfterFirstLayout;
        isPictureAfterFirstLayout = viewState != null;
        {
            boolean registerPageSwapCallback;
            registerPageSwapCallback = !mZoomManager.isFixedLengthAnimationInProgress() && inEditingMode();
            setBaseLayer(draw.mBaseLayer, draw.mInvalRegion,
                    getSettings().getShowVisualIndicator(),
                    isPictureAfterFirstLayout, registerPageSwapCallback);
        } //End block
        Point viewSize;
        viewSize = draw.mViewSize;
        boolean updateLayout;
        updateLayout = viewSize.x == mLastWidthSent
                && viewSize.y == mLastHeightSent;
        mSendScrollEvent = false;
        recordNewContentSize(draw.mContentSize.x,
                draw.mContentSize.y, updateLayout);
        {
            mLastWidthSent = 0;
            mZoomManager.onFirstLayout(draw);
            int scrollX;
            scrollX = getContentWidth();
            scrollX = viewState.mScrollX;
            int scrollY;
            scrollY = viewState.mScrollY;
            setContentScrollTo(scrollX, scrollY);
            {
                clearTextEntry();
            } //End block
        } //End block
        mSendScrollEvent = true;
        {
            Rect b;
            b = draw.mInvalRegion.getBounds();
        } //End block
        invalidateContentRect(draw.mInvalRegion.getBounds());
        {
            mPictureListener.onNewPicture(WebView.this, capturePicture());
        } //End block
        mZoomManager.onNewPicture(draw);
        {
            boolean var926A8D0B5C0D740061680329138C210C_906330949 = (draw.mFocusSizeChanged && inEditingMode());
            {
                mFocusSizeChanged = true;
            } //End block
        } //End collapsed parenthetic
        {
            mViewManager.postReadyToDrawAll();
        } //End block
        addTaint(updateBaseLayer);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.001 -0400", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "7ED72B88F10A387E4BE1B48655E1DEDD")
    private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        {
            boolean var179B09369C5FEC85CD8155FF224AECDC_1892202572 = (inEditingMode()
                && mWebTextView.isSameTextField(nodePointer)
                && textGeneration == mTextGeneration);
            {
                mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
            } //End block
        } //End collapsed parenthetic
        addTaint(nodePointer);
        addTaint(textGeneration);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& mWebTextView.isSameTextField(nodePointer)
                //&& textGeneration == mTextGeneration) {
            //mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.013 -0400", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "72518D41A969F6AADA3274F045C6C4AB")
     void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selectedArray[0]);
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selectedArray));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.014 -0400", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "4BBC44FF944EEE25CEBCF2D60BC591B7")
     void requestListBox(String[] array, int[] enabledArray, int selection) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selection);
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selection));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.014 -0400", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "C0A6683432D88BABDE764CF7D9D48742")
    private void sendMoveFocus(int frame, int node) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
        addTaint(frame);
        addTaint(node);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                //new WebViewCore.CursorData(frame, node, 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.014 -0400", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "DE647C1BE362E83812C6348952960A3D")
    private void sendMoveMouse(int frame, int node, int x, int y) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                new WebViewCore.CursorData(frame, node, x, y));
        addTaint(frame);
        addTaint(node);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                //new WebViewCore.CursorData(frame, node, x, y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.015 -0400", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "706049A02288C924DEFA0547590CF367")
    @SuppressWarnings("unused")
    private void sendMoveMouseIfLatest(boolean removeFocus, boolean stopPaintingCaret) {
        {
            clearTextEntry();
        } //End block
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                stopPaintingCaret ? 1 : 0, 0,
                cursorData());
        addTaint(removeFocus);
        addTaint(stopPaintingCaret);
        // ---------- Original Method ----------
        //if (removeFocus) {
            //clearTextEntry();
        //}
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                //stopPaintingCaret ? 1 : 0, 0,
                //cursorData());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.015 -0400", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "07D294FFE393BE05D4A724B5CFF28847")
    private void sendMotionUp(int touchGeneration,
            int frame, int node, int x, int y) {
        WebViewCore.TouchUpData touchUpData;
        touchUpData = new WebViewCore.TouchUpData();
        touchUpData.mMoveGeneration = touchGeneration;
        touchUpData.mFrame = frame;
        touchUpData.mNode = node;
        touchUpData.mX = x;
        touchUpData.mY = y;
        touchUpData.mNativeLayer = nativeScrollableLayer(
                x, y, touchUpData.mNativeLayerRect, null);
        mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
        addTaint(touchGeneration);
        addTaint(frame);
        addTaint(node);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
        //touchUpData.mMoveGeneration = touchGeneration;
        //touchUpData.mFrame = frame;
        //touchUpData.mNode = node;
        //touchUpData.mX = x;
        //touchUpData.mY = y;
        //touchUpData.mNativeLayer = nativeScrollableLayer(
                //x, y, touchUpData.mNativeLayerRect, null);
        //mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.019 -0400", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "8C716B04079F9E55C8E22C8252006059")
    private int getScaledMaxXScroll() {
        int width;
        {
            width = getViewWidth() / 4;
        } //End block
        {
            Rect visRect;
            visRect = new Rect();
            calcOurVisibleRect(visRect);
            width = visRect.width() / 2;
        } //End block
        int var4CD57EC65F046B376944293A38E9A187_1029013539 = (viewToContentX(width));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81304015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81304015;
        // ---------- Original Method ----------
        //int width;
        //if (mHeightCanMeasure == false) {
            //width = getViewWidth() / 4;
        //} else {
            //Rect visRect = new Rect();
            //calcOurVisibleRect(visRect);
            //width = visRect.width() / 2;
        //}
        //return viewToContentX(width);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.020 -0400", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "D56F89F14B9871D1FE249CC04E1CE3F6")
    private int getScaledMaxYScroll() {
        int height;
        {
            height = getViewHeight() / 4;
        } //End block
        {
            Rect visRect;
            visRect = new Rect();
            calcOurVisibleRect(visRect);
            height = visRect.height() / 2;
        } //End block
        int var3B6C50355F4C83B6515E3BB844F5C669_81636057 = (Math.round(height * mZoomManager.getInvScale()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403685543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403685543;
        // ---------- Original Method ----------
        //int height;
        //if (mHeightCanMeasure == false) {
            //height = getViewHeight() / 4;
        //} else {
            //Rect visRect = new Rect();
            //calcOurVisibleRect(visRect);
            //height = visRect.height() / 2;
        //}
        //return Math.round(height * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.020 -0400", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "43791F1CBB48DBD139A4E7B1FDB49008")
    private void viewInvalidate() {
        invalidate();
        // ---------- Original Method ----------
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.021 -0400", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "95BC529A73D63099BEDD6E10FBFC137A")
    private void letPageHandleNavKey(int keyCode, long time, boolean down, int metaState) {
        int keyEventAction;
        int eventHubAction;
        {
            keyEventAction = KeyEvent.ACTION_DOWN;
            eventHubAction = EventHub.KEY_DOWN;
            playSoundEffect(keyCodeToSoundsEffect(keyCode));
        } //End block
        {
            keyEventAction = KeyEvent.ACTION_UP;
            eventHubAction = EventHub.KEY_UP;
        } //End block
        KeyEvent event;
        event = new KeyEvent(time, time, keyEventAction, keyCode,
                1, (metaState & KeyEvent.META_SHIFT_ON)
                | (metaState & KeyEvent.META_ALT_ON)
                | (metaState & KeyEvent.META_SYM_ON)
                , KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        mWebViewCore.sendMessage(eventHubAction, event);
        addTaint(keyCode);
        addTaint(time);
        addTaint(down);
        addTaint(metaState);
        // ---------- Original Method ----------
        //int keyEventAction;
        //int eventHubAction;
        //if (down) {
            //keyEventAction = KeyEvent.ACTION_DOWN;
            //eventHubAction = EventHub.KEY_DOWN;
            //playSoundEffect(keyCodeToSoundsEffect(keyCode));
        //} else {
            //keyEventAction = KeyEvent.ACTION_UP;
            //eventHubAction = EventHub.KEY_UP;
        //}
        //KeyEvent event = new KeyEvent(time, time, keyEventAction, keyCode,
                //1, (metaState & KeyEvent.META_SHIFT_ON)
                //| (metaState & KeyEvent.META_ALT_ON)
                //| (metaState & KeyEvent.META_SYM_ON)
                //, KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        //mWebViewCore.sendMessage(eventHubAction, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.033 -0400", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "7630E6094C1E604F289607C935B4CCDE")
    private boolean navHandledKey(int keyCode, int count, boolean noScroll,
            long time) {
        mInitialHitTestResult = null;
        mLastCursorTime = time;
        mLastCursorBounds = nativeGetCursorRingBounds();
        boolean keyHandled;
        keyHandled = nativeMoveCursor(keyCode, count, noScroll) == false;
        Rect contentCursorRingBounds;
        contentCursorRingBounds = nativeGetCursorRingBounds();
        {
            boolean var78E9DE151C1DFEF7820F7C4599A2F8D0_825978781 = (contentCursorRingBounds.isEmpty());
        } //End collapsed parenthetic
        Rect viewCursorRingBounds;
        viewCursorRingBounds = contentToViewRect(contentCursorRingBounds);
        mLastTouchX = (viewCursorRingBounds.left + viewCursorRingBounds.right) / 2;
        mLastTouchY = (viewCursorRingBounds.top + viewCursorRingBounds.bottom) / 2;
        Rect visRect;
        visRect = new Rect();
        calcOurVisibleRect(visRect);
        Rect outset;
        outset = new Rect(visRect);
        int maxXScroll;
        maxXScroll = visRect.width() / 2;
        int maxYScroll;
        maxYScroll = visRect.height() / 2;
        outset.inset(-maxXScroll, -maxYScroll);
        {
            boolean varB6D877D107F828AA26477AA9FEE04EDD_1099672102 = (Rect.intersects(outset, viewCursorRingBounds) == false);
        } //End collapsed parenthetic
        int maxH;
        maxH = Math.min(viewCursorRingBounds.right - visRect.right,
                maxXScroll);
        {
            pinScrollBy(maxH, 0, true, 0);
        } //End block
        {
            maxH = Math.max(viewCursorRingBounds.left - visRect.left,
                    -maxXScroll);
            {
                pinScrollBy(maxH, 0, true, 0);
            } //End block
        } //End block
        {
            boolean var6A8A4E436D7412BEF448043644BD31DB_1019285345 = (mLastCursorBounds.isEmpty());
        } //End collapsed parenthetic
        {
            boolean var46EFF7D5420AE1A7A30F7E288D313B74_28440650 = (mLastCursorBounds.equals(contentCursorRingBounds));
        } //End collapsed parenthetic
        requestRectangleOnScreen(viewCursorRingBounds);
        addTaint(keyCode);
        addTaint(count);
        addTaint(noScroll);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_913259834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_913259834;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.034 -0400", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "2B4FF7016B98F2617C863128C52EF3B9")
    private boolean accessibilityScriptInjected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591000015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591000015;
        // ---------- Original Method ----------
        //return mAccessibilityScriptInjected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.034 -0400", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "1D06CA9D32CB95134D9BA15854D3E735")
    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
        // ---------- Original Method ----------
        //mBackgroundColor = color;
        //mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.047 -0400", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "85CCCEA00CCFC3C2990DD68DC174D234")
    @Deprecated
    public void debugDump() {
        checkThread();
        nativeDebugDump();
        mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
        // ---------- Original Method ----------
        //checkThread();
        //nativeDebugDump();
        //mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.047 -0400", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "740E405FE2A3E71A6CDDF433E033281A")
    public void drawPage(Canvas canvas) {
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.048 -0400", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "60F0103DEBE1A0FA6D924B8BF32F9420")
    public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        mHTML5VideoViewProxy = proxy;
        // ---------- Original Method ----------
        //mHTML5VideoViewProxy = proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.048 -0400", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "0341554DA62305A207D3B8C95E999187")
    public void setTouchInterval(int interval) {
        mCurrentTouchInterval = interval;
        // ---------- Original Method ----------
        //mCurrentTouchInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.048 -0400", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "F15B8CC0375CD9B31A9185033241B3A6")
    protected void updateCachedTextfield(String updatedText) {
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
        addTaint(updatedText.getTaint());
        // ---------- Original Method ----------
        //nativeUpdateCachedTextfield(updatedText, mTextGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.048 -0400", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "99F7C082FAD063DA8B04C011BE0023E3")
     void autoFillForm(int autoFillQueryId) {
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
        addTaint(autoFillQueryId);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.049 -0400", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "10F17271BF8F68C7296B0E13EB072B15")
     ViewManager getViewManager() {
        ViewManager varB4EAC82CA7396A68D541C85D26508E83_1240482732 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1240482732 = mViewManager;
        varB4EAC82CA7396A68D541C85D26508E83_1240482732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1240482732;
        // ---------- Original Method ----------
        //return mViewManager;
    }

    
        private static void checkThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Throwable throwable = new Throwable(
                    "Warning: A WebView method was called on thread '" +
                    Thread.currentThread().getName() + "'. " +
                    "All WebView methods must be called on the UI thread. " +
                    "Future versions of WebView may not support use on other threads.");
            Log.w(LOGTAG, Log.getStackTraceString(throwable));
            StrictMode.onWebViewMethodCalledOnWrongThread(throwable);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.049 -0400", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "2C8A3F643487BF9C4C932C87B894FD6E")
    protected void contentInvalidateAll() {
        {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.050 -0400", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "14F0772081BF82E7E18655BBAC5A6F22")
    protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
        // ---------- Original Method ----------
        //nativeRegisterPageSwapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.054 -0400", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "EAF06CEEDE2D5E5967608F86C355FE16")
    public void tileProfilingStart() {
        nativeTileProfilingStart();
        // ---------- Original Method ----------
        //nativeTileProfilingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.054 -0400", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "0BFCE9A6D323CDCA94E6CE4840FDD343")
    public float tileProfilingStop() {
        float varB18687EE139E5166CC9AF408D9889054_954437556 = (nativeTileProfilingStop());
        float var546ADE640B6EDFBC8A086EF31347E768_2001358930 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2001358930;
        // ---------- Original Method ----------
        //return nativeTileProfilingStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.054 -0400", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "8FDB7E2C7A9F51E9629172BAF0B24960")
    public void tileProfilingClear() {
        nativeTileProfilingClear();
        // ---------- Original Method ----------
        //nativeTileProfilingClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.055 -0400", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "C6FD230A625D26DCE9BF3FF09A5799C2")
    public int tileProfilingNumFrames() {
        int var169947B5FA60947E0B7BC7984522118F_1768450835 = (nativeTileProfilingNumFrames());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220533787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220533787;
        // ---------- Original Method ----------
        //return nativeTileProfilingNumFrames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.055 -0400", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "21AE80066C5A3145AF692C858B0DAB9C")
    public int tileProfilingNumTilesInFrame(int frame) {
        int varFDE1A8CA934CC4FCCFE59320104D4907_14203168 = (nativeTileProfilingNumTilesInFrame(frame));
        addTaint(frame);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952073849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_952073849;
        // ---------- Original Method ----------
        //return nativeTileProfilingNumTilesInFrame(frame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.055 -0400", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "7B8ACFC3FFAC67539DE130F8DE634CD6")
    public int tileProfilingGetInt(int frame, int tile, String key) {
        int varE7654B1D69F1E5F05A936A8E62104F88_1266059343 = (nativeTileProfilingGetInt(frame, tile, key));
        addTaint(frame);
        addTaint(tile);
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966623320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1966623320;
        // ---------- Original Method ----------
        //return nativeTileProfilingGetInt(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.063 -0400", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "3BEA020B09AF56BD8100621F7B41267A")
    public float tileProfilingGetFloat(int frame, int tile, String key) {
        float varFC830259BB0CC6250B57A21E07835342_214516642 = (nativeTileProfilingGetFloat(frame, tile, key));
        addTaint(frame);
        addTaint(tile);
        addTaint(key.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1572929442 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1572929442;
        // ---------- Original Method ----------
        //return nativeTileProfilingGetFloat(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.064 -0400", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "2AD122BAA10FC3DB006FB8B8DD39EBC8")
    private int nativeCacheHitFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526365935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526365935;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.064 -0400", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "65D6334E7FAA447A39E8DBB9929F9ED5")
    private boolean nativeCacheHitIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_958267328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_958267328;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.078 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "C211C5C405AAE9953CCBBEEF22D45B31")
    private Rect nativeCacheHitNodeBounds() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.079 -0400", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "43B7DADC7DBAAA544384DE275DFBF3E4")
    private int nativeCacheHitNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499169565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499169565;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.079 -0400", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "2C929D3168FE3E72D461E6649B6EC306")
     void nativeClearCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.079 -0400", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "7DFA4BA9D9D2F081C4674D9A23AF40D6")
    private void nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.080 -0400", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "C6244533594983851E82F55D781D6730")
    private int nativeCursorFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926509418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926509418;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.080 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "E271E918D4C574FDDE4719E4B98A8B2B")
    private Rect nativeCursorNodeBounds() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.080 -0400", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "8ECC08ABA40DFE594852FBA9A3FFC743")
    private int nativeCursorNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897006862 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897006862;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.080 -0400", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "DDA805DB2B9C36673BA942A2A76BD25B")
    private boolean nativeCursorIntersects(Rect visibleRect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194740082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194740082;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.080 -0400", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "7822FBFB849D38A0C79CD753E52833E6")
    private boolean nativeCursorIsAnchor() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698318667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698318667;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.081 -0400", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "7E71BA020746D9E0FEBCBA54B5054296")
    private boolean nativeCursorIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228076713 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228076713;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.081 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "2045A184BB97A2996B1887CC917B0804")
    private Point nativeCursorPosition() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.081 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "3E24BE9E7EBDB8C5312CC587887CD85C")
    private String nativeCursorText() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.081 -0400", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "77575C4305B70B25DC68811C5955A188")
    private boolean nativeCursorWantsKeyEvents() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693398705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693398705;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.081 -0400", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "F601101523F054AD48972FF053FC6215")
    private void nativeDebugDump() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.082 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.082 -0400", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "9965EE8FF1EA624C7928A320F970EC0C")
    private int nativeDraw(Canvas canvas, RectF visibleRect,
            int color, int extra, boolean splitIfNeeded) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826900713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826900713;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.082 -0400", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "DEC3E2BF23E95688EF02A9D60A934BC6")
    private void nativeDumpDisplayTree(String urlOrNull) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.082 -0400", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "8B01D74F863868B14387ACB8997B3D7B")
    private boolean nativeEvaluateLayersAnimations(int nativeInstance) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294571253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294571253;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.082 -0400", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "85A054F76C33A1995B396BBF605F47FF")
    private int nativeGetDrawGLFunction(int nativeInstance, Rect rect,
            Rect viewRect, RectF visibleRect, float scale, int extras) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807801389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1807801389;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.095 -0400", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "CE8A8077BABA841A2AD2D59A5548E6AE")
    private void nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
            RectF visibleRect) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.096 -0400", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "AAD4FC58EFA073FDC913BA79EDD7DCDA")
    private void nativeExtendSelection(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.096 -0400", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "B26935D0666F123D9C6C78EEB3B7D47F")
    private int nativeFindAll(String findLower, String findUpper,
            boolean sameAsLastSearch) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497472799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497472799;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.100 -0400", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "937E5B11B8379FE5830DBA653F9B7999")
    private void nativeFindNext(boolean forward) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.101 -0400", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "2C81B103A96CCD03333077AC8FA6061E")
     int nativeFocusCandidateFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47979254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47979254;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.101 -0400", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "BEAC96850A0DF3CA6B496BA2D191879A")
     boolean nativeFocusCandidateHasNextTextfield() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1426110363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1426110363;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.101 -0400", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "211F977EA2A00262860C6293C2D88BE3")
     boolean nativeFocusCandidateIsPassword() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313873150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313873150;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.101 -0400", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "1BC44A158EE523CF3CC77F50A38DBF99")
    private boolean nativeFocusCandidateIsRtlText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374361308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374361308;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.101 -0400", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "F641588A1C5B2DF1BA7B969A036BBD6C")
    private boolean nativeFocusCandidateIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1366599640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1366599640;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.102 -0400", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "17989170D2A0C05C23E75BB8D385AD90")
     int nativeFocusCandidateMaxLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126573182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_126573182;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.102 -0400", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "0A93206BD2D07A4C1005EF1BFD094111")
     boolean nativeFocusCandidateIsAutoComplete() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739990978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739990978;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.102 -0400", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "94DA3CE00E4EBAC54F1EE2DE397501B0")
     boolean nativeFocusCandidateIsSpellcheck() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520520926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520520926;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.102 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "482EB255509BA82D443BAA9D71623788")
     String nativeFocusCandidateName() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.102 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "E9FE505188BFAFC647C681A775DCAAFD")
    private Rect nativeFocusCandidateNodeBounds() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.103 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "8CA80E2A60FEEA9061A61B09DA68625A")
    private Rect nativeFocusCandidatePaddingRect() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.103 -0400", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "1D5FBACD957F8CCA8DE6997B587CC1F4")
     int nativeFocusCandidatePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878161926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878161926;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.103 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "B8D2D3434495629B87849A0DDE9761CA")
    private String nativeFocusCandidateText() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.103 -0400", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "97E930386B152BA0AB96483ECAC279E9")
     float nativeFocusCandidateTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_249013256 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_249013256;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.103 -0400", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "3974381EE61B0A52EE2D087BB6310C51")
     int nativeFocusCandidateLineHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134979442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134979442;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.120 -0400", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "3B6ABB48B238EA6D72B73A058D07B444")
    private int nativeFocusCandidateType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125842388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125842388;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.120 -0400", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "45A1BDC09A9B030665204B163CEC1290")
    private int nativeFocusCandidateLayerId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193244405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193244405;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.120 -0400", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "B531C62DD7DCE24991F89E03B1407AA1")
    private boolean nativeFocusIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1483473669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1483473669;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.120 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "65244A088D15DCA1F0C3C7F2D973DFD4")
    private Rect nativeFocusNodeBounds() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.121 -0400", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "27F959DFCE037102C8FEBD2A4844DEEE")
     int nativeFocusNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062279088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062279088;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.121 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "68114054688AC2ACF3B41A1E50F28F3A")
    private Rect nativeGetCursorRingBounds() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.121 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "CAEC1387621E6EAAC0BBE851878D90E6")
    private String nativeGetSelection() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.121 -0400", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "480F79280D6B68FAF59F5E03133D7227")
    private boolean nativeHasCursorNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698515924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698515924;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.121 -0400", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "81F1E6E5A587D7F18A4245EBD93FE8CE")
    private boolean nativeHasFocusNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98481078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98481078;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.125 -0400", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "C5D686BF12DF1683258EF31789BFD66A")
    private void nativeHideCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.125 -0400", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "5EC30B8345173584585636870298726D")
    private boolean nativeHitSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1822767492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1822767492;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.126 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "68E20D0E121FE807EF3A683540460D64")
    private String nativeImageURI(int x, int y) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.126 -0400", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "4931CD211AE029703EBE8600C611C50A")
    private void nativeInstrumentReport() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.126 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "0EF9BAF6479325B7AFB630E9F288D638")
    private Rect nativeLayerBounds(int layer) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.126 -0400", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "C70D3755CE6CD62445BFBA1F33DEAA39")
     boolean nativeMoveCursorToNextTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483070867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483070867;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.126 -0400", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "98C4714E8D0176F24A4DEDFDECD63BF5")
    private boolean nativeMotionUp(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235967114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235967114;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.137 -0400", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "02FB4DF052376CE846D3301817E0E457")
    private boolean nativeMoveCursor(int keyCode, int count,
            boolean noScroll) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446578429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446578429;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.138 -0400", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "CA763B48E8AAD51B9FE673CB254A244F")
    private int nativeMoveGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649176126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649176126;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.138 -0400", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "806420BABD34DA76CA52BDFCE6493234")
    private void nativeMoveSelection(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.138 -0400", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "5E9E5049B7A3E0480A39CAB1ADA673C5")
    private boolean nativePageShouldHandleShiftAndArrows() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862949703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862949703;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.138 -0400", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "C3682BEC00C2D7E4DA0D2D08214F46CC")
    private boolean nativePointInNavCache(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_337793484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_337793484;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.138 -0400", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "7E164F51BFD26BAEB37C17707BD8874E")
    private void nativeResetSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "4FCCB0475B387C1F5318EC92944C45EC")
    private Point nativeSelectableText() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "5DACEC38ECF99BF3DA52929D8D3AE5DA")
    private void nativeSelectAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "3D9F4D8FE552F46EDFE668F28DAC36F3")
    private void nativeSelectBestAt(Rect rect) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "5DFA19011F6357FF14C8F2E2695F621D")
    private void nativeSelectAt(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "11899DD354AA8EF0698F63512193BD89")
    private int nativeSelectionX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567279272 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567279272;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.139 -0400", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "DA7B0E281605D391F56D7B8B82EEE529")
    private int nativeSelectionY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963049887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963049887;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.140 -0400", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "BED9FCCF0E07172E980024A253E26143")
    private int nativeFindIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500773868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500773868;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.140 -0400", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "5AB5068259CCABEFACDEA5560EBD42C9")
    private void nativeSetExtendSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.140 -0400", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "BF3E2C6C0F834088FF260D2D57AB8864")
    private void nativeSetFindIsEmpty() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.140 -0400", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "256EAA7FD60D28E5E7062DFF998E2D2D")
    private void nativeSetFindIsUp(boolean isUp) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.140 -0400", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "7A8E31F2B5D777EBEC23BD7B2069CA12")
    private void nativeSetHeightCanMeasure(boolean measure) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.141 -0400", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "AA06B3FFAAA82012E0DCB53B80602404")
    private void nativeSetBaseLayer(int layer, Region invalRegion,
            boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
            boolean registerPageSwapCallback) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.141 -0400", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "71DEB090FE7B75820AA00535F5CDA233")
    private int nativeGetBaseLayer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164918814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164918814;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.141 -0400", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "7AA70DF267F5A3B8D5F1139BE8B04F95")
    private void nativeShowCursorTimed() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.141 -0400", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "2586905A54FC6D89F60FA868528B5ABD")
    private void nativeReplaceBaseContent(int content) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.141 -0400", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "0DD0F39A70B93DCE529A7DB104FE79BF")
    private void nativeCopyBaseContentToPicture(Picture pict) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.152 -0400", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "FA5793526E41430AF83F6E8A2653D499")
    private boolean nativeHasContent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993698116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993698116;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.152 -0400", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "646E5B0E2F3492FE7CA52836500770AC")
    private void nativeSetSelectionPointer(int nativeInstance,
            boolean set, float scale, int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.152 -0400", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "2EF34509ECFA943C87D87CFA3E1B5C56")
    private boolean nativeStartSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1583647924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1583647924;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.152 -0400", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "A11715011B8424E4C1DF23E23BC77CCA")
    private void nativeStopGL() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.155 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "59C253F3D708B1AEFB61B74588B1BC4B")
    private Rect nativeSubtractLayers(Rect content) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.156 -0400", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "74C813BD964A7541F8A2FE0FE8DE159F")
    private int nativeTextGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679709134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679709134;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.156 -0400", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "357B1EA2F63D3ED8C271D67AFCCC12A7")
    private void nativeRegisterPageSwapCallback() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.156 -0400", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "2E113EDF1B459505AA2AF4625DE30F08")
    private void nativeTileProfilingStart() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.171 -0400", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "378F60691BED0A62F04E518606AF350C")
    private float nativeTileProfilingStop() {
        float var546ADE640B6EDFBC8A086EF31347E768_1004986784 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1004986784;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.172 -0400", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "7EF0A6540C2A701F27B19DB98FD72058")
    private void nativeTileProfilingClear() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.172 -0400", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "21DD8FD72376A8D4507D9920DD832E18")
    private int nativeTileProfilingNumFrames() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572213213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572213213;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.172 -0400", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "797A5D64815828FF91DFFADC4CAA25BD")
    private int nativeTileProfilingNumTilesInFrame(int frame) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071358192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071358192;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.172 -0400", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "B63B35E2F4665907463E78FBCA433A16")
    private int nativeTileProfilingGetInt(int frame, int tile, String key) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681092573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1681092573;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.173 -0400", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "BE14A6B1D3814C44772F5CC9E8845ACE")
    private float nativeTileProfilingGetFloat(int frame, int tile, String key) {
        float var546ADE640B6EDFBC8A086EF31347E768_1900770262 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1900770262;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.173 -0400", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "3ABB45EA050CAA1CCC1C02DFC1E93D91")
    private void nativeUpdateCachedTextfield(String updatedText,
            int generation) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.174 -0400", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "FE26190C8313AD90EF53F110C8C465DF")
    private boolean nativeWordSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249087704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249087704;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.174 -0400", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "B328A25829C949DD6D99AD7AED92081F")
     int nativeGetBlockLeftEdge(int x, int y, float scale) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358177791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358177791;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.174 -0400", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "5002655B986F7D641C298CC95BBCC6C7")
    private void nativeUseHardwareAccelSkia(boolean enabled) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.175 -0400", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "FEB0B5D6BCAD52B70546E91C5F2190EC")
    private int nativeScrollableLayer(int x, int y, Rect scrollRect,
            Rect scrollBounds) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495780838 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495780838;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.175 -0400", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "5B4B178641BFD5A885A2F973A85CAD5B")
    private boolean nativeScrollLayer(int layer, int newX, int newY) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055331939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055331939;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.175 -0400", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "CD169E3A3B653F3A1D68A46881511434")
    private void nativeSetIsScrolling(boolean isScrolling) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.175 -0400", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "5435295CA274F2CF48FDEF28C00593CF")
    private int nativeGetBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996167086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996167086;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.176 -0400", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "17B3FCD24DF331AC506D6DCCF4ED3E9A")
     boolean nativeSetProperty(String key, String value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1121133317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1121133317;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.176 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "2CDC971A436EF25C108C6D2B163E982B")
     String nativeGetProperty(String key) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.177 -0400", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "1A68B083C5E652A8EAFCED90D7609277")
    private void nativeGetTextSelectionRegion(int instance, Region region) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.177 -0400", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "D9F1018CE749271C3133A021A996233E")
    private void nativeGetSelectionHandles(int instance, int[] handles) {
    }

    
        private static void nativeOnTrimMemory(int level) {
    }

    
        private static void nativeSetPauseDrawing(int instance, boolean pause) {
    }

    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.184 -0400", hash_original_method = "8AECAF07C584017DF10A77A8577569BA", hash_generated_method = "8AECAF07C584017DF10A77A8577569BA")
        public InnerGlobalLayoutListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.185 -0400", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "30299773BCF9B1D491EA22E5DE147A20")
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_2086973835 = (isShown());
                {
                    setGLRectViewport();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    private class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.185 -0400", hash_original_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D", hash_generated_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D")
        public InnerScrollChangedListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.186 -0400", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "3A651283DD28E2970A71A28129A9BCF6")
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_549878771 = (isShown());
                {
                    setGLRectViewport();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    public class WebViewTransport {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.186 -0400", hash_original_field = "873282A17E61E0691E2D2F15001F5346", hash_generated_field = "CE9B7FCDD03C866BC3B0AB067564E1E9")

        private WebView mWebview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.186 -0400", hash_original_method = "019254006A207FE7BCA503E59C7BDCD4", hash_generated_method = "019254006A207FE7BCA503E59C7BDCD4")
        public WebViewTransport ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.186 -0400", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "A9A4B57876E149A4CA9F2A29180461CF")
        public synchronized void setWebView(WebView webview) {
            mWebview = webview;
            // ---------- Original Method ----------
            //mWebview = webview;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.200 -0400", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "854504F9F22298AE954BA544BA39624C")
        public synchronized WebView getWebView() {
            WebView varB4EAC82CA7396A68D541C85D26508E83_1496953651 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1496953651 = mWebview;
            varB4EAC82CA7396A68D541C85D26508E83_1496953651.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1496953651;
            // ---------- Original Method ----------
            //return mWebview;
        }

        
    }


    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.201 -0400", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "C45AEFFBEC57E61111C9DF2D1A396FAF")
        private  OnTrimMemoryListener(Context c) {
            c.registerComponentCallbacks(this);
            addTaint(c.getTaint());
            // ---------- Original Method ----------
            //c.registerComponentCallbacks(this);
        }

        
                static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.201 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "E555930F6C60B6E43E637690DA6E289E")
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newConfig.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.202 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "703A059557F06AE044520D2E93D3D2F0")
        @Override
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.202 -0400", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "00EB74022956906F2D290B50848397C3")
        @Override
        public void onTrimMemory(int level) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                Log.d("WebView", "onTrimMemory: " + level);
            } //End block
            WebView.nativeOnTrimMemory(level);
            addTaint(level);
            // ---------- Original Method ----------
            //if (DebugFlags.WEB_VIEW) {
                //Log.d("WebView", "onTrimMemory: " + level);
            //}
            //WebView.nativeOnTrimMemory(level);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.202 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "C88183308993326DA3B8CE3C16E7E9BA")

        private static OnTrimMemoryListener sInstance = null;
    }


    
    public class HitTestResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.202 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.202 -0400", hash_original_field = "57351EA26C034458DF1F7B3C51D03D6E", hash_generated_field = "7473B88E9A243CF8ACFD2DDF98031A9D")

        private String mExtra;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.203 -0400", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "3E8436A0FC0A9040E95F25D444A899AD")
          HitTestResult() {
            mType = UNKNOWN_TYPE;
            // ---------- Original Method ----------
            //mType = UNKNOWN_TYPE;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.203 -0400", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "89AFF8CBC1B7750AC1399D58F1A48453")
        private void setType(int type) {
            mType = type;
            // ---------- Original Method ----------
            //mType = type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.209 -0400", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "66AE08DAEF8D5073B71F7FF854ADD4F3")
        private void setExtra(String extra) {
            mExtra = extra;
            // ---------- Original Method ----------
            //mExtra = extra;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.209 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "11B8C162D00ABA9FBA58099357D61AA6")
        public int getType() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731520650 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731520650;
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.209 -0400", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "B0BE425BB3967C464E722E801D32776C")
        public String getExtra() {
            String varB4EAC82CA7396A68D541C85D26508E83_1604250488 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1604250488 = mExtra;
            varB4EAC82CA7396A68D541C85D26508E83_1604250488.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1604250488;
            // ---------- Original Method ----------
            //return mExtra;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.209 -0400", hash_original_field = "B4460F979CFC4B3251D5DAAF48417617", hash_generated_field = "66339D0C16D16517633DFB08461D5C3F")

        public static final int UNKNOWN_TYPE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.211 -0400", hash_original_field = "CFFCF81F64F3B8E3F55FE79A095616A0", hash_generated_field = "C6E0A23956E4344E5A24770E8DEB80AF")

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "030676AD21D2EA5086C5086B51132C5A", hash_generated_field = "1F892F69F99B538EA9542E4188E9D049")

        public static final int PHONE_TYPE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "3C1637E264836E3E0897EBDAA762C14C", hash_generated_field = "609BC3DD941EE1B3F8DBCDEA6DC14E92")

        public static final int GEO_TYPE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "028C017E4197D9D445450EAF82927BDC", hash_generated_field = "AF4F62540D93A175F846244DE39FF3EA")

        public static final int EMAIL_TYPE = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "C069364739732F7370F9183BFBDA020C", hash_generated_field = "D1341758694A17E34931E15E5F9AE163")

        public static final int IMAGE_TYPE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "79DDA3DC402A59D3D78B1D118A52C31B", hash_generated_field = "A790FEB45D10D6E4493673EC8A439C5E")

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "2EFC0DDB47A85AFB33F856AA957A411D", hash_generated_field = "F746B9271AE854E19C3EA4F13285C847")

        public static final int SRC_ANCHOR_TYPE = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "8C48F79BD833571EE18B5D1083B6F30A", hash_generated_field = "C47A4D8A2B58A38AB94516810D897655")

        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_field = "B34737C311A023BD22EC23D2EE6165EC", hash_generated_field = "AD4F3515FDAD6418D5559EF03B760AC2")

        public static final int EDIT_TEXT_TYPE = 9;
    }


    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_method = "81C64DA14CD8ADA6B639EE9F61F2A898", hash_generated_method = "81C64DA14CD8ADA6B639EE9F61F2A898")
        public ProxyReceiver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.212 -0400", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "EF795E8246A67DCD523D63F233A44470")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean var5A158AEAA9529F1AFE9F1BFAB51F2DA9_1675452318 = (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION));
                {
                    handleProxyBroadcast(intent);
                } //End block
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION)) {
                //handleProxyBroadcast(intent);
            //}
        }

        
    }


    
    private static class PackageListener extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.213 -0400", hash_original_method = "F623A53A552E0B02B7648231F682A935", hash_generated_method = "F623A53A552E0B02B7648231F682A935")
        public PackageListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.213 -0400", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "47C1E0FFA64C94DC94D5DCC1CCB44A97")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            String action;
            action = intent.getAction();
            String packageName;
            packageName = intent.getData().getSchemeSpecificPart();
            boolean replacing;
            replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
            {
                boolean varFF4619C38D73ED134292A51CFC6DAD56_1091153599 = (Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing);
            } //End collapsed parenthetic
            {
                boolean varF3A5A3941CCE4017F61B8223025B4DC2_1321496028 = (sGoogleApps.contains(packageName));
                {
                    {
                        boolean var37328E8572988711DFAEB7B421756EDC_1051093170 = (Intent.ACTION_PACKAGE_ADDED.equals(action));
                        {
                            WebViewCore.sendStaticMessage(EventHub.ADD_PACKAGE_NAME, packageName);
                        } //End block
                        {
                            WebViewCore.sendStaticMessage(EventHub.REMOVE_PACKAGE_NAME, packageName);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            PluginManager pm;
            pm = PluginManager.getInstance(context);
            {
                boolean varB1BC6389427C1315076A84D35B8A1EAF_1353042258 = (pm.containsPluginPermissionAndSignatures(packageName));
                {
                    pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
                } //End block
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class SaveWebArchiveMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.227 -0400", hash_original_field = "A984B376DEA2CC7536617F280E80C1A1", hash_generated_field = "05C64ACC3BAB92D2CCE8178ABA3FDAE1")

        String mBasename;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.227 -0400", hash_original_field = "542D5B30128863188515FF03C3D6C8E3", hash_generated_field = "6BCA401625C852D06DCC273A17617FED")

        boolean mAutoname;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.227 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C752F5297A11E20E661B6130B21F3B9A")

        ValueCallback<String> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.227 -0400", hash_original_field = "7D4A7A325C0BFF5E64DDC794A8738C05", hash_generated_field = "047227D3BBCE6402C69D67FD47561A95")

        String mResultFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.227 -0400", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "4FAF880EC774D9F5D77B034A52E594C4")
          SaveWebArchiveMessage(String basename, boolean autoname, ValueCallback<String> callback) {
            mBasename = basename;
            mAutoname = autoname;
            mCallback = callback;
            // ---------- Original Method ----------
            //mBasename = basename;
            //mAutoname = autoname;
            //mCallback = callback;
        }

        
    }


    
    static class ViewSizeData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "46F4EE6FF41DA234C359DB3FA7F0E479", hash_generated_field = "78B7CCE03B515024F44B1EEDC44555A1")

        float mHeightWidthRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "D759EB5AB08C859641FBD87DB10B4D2E", hash_generated_field = "3A48A4BC51B3BD422EE46136E8931243")

        int mActualViewHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "8A785CDEA26539F62DF6BE00238F4644", hash_generated_field = "B26A0AD7DDE8F0FD05B17352E367406B")

        int mTextWrapWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F")

        int mAnchorX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "A5A5BAD4084BA0905925E24FE8CC16A6")

        int mAnchorY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "ABDB0A4470BBD1454ED388F3CD972EEE")

        float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "8CDB6CB0AFB9B4C0B69C02EB4DBB1F61", hash_generated_field = "63B858676F9D9765C256ADBE1D3B6A59")

        boolean mIgnoreHeight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_method = "0E4893AFBBF2A9B13986CA2BDFC332DE", hash_generated_method = "0E4893AFBBF2A9B13986CA2BDFC332DE")
        public ViewSizeData ()
        {
            //Synthesized constructor
        }


    }


    
    private class RequestFormData implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

        private String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "3D50CF99C0669CD527C0C69C4AE6B44B", hash_generated_field = "0487D88BABEAE0E64EE47FD1AEEB417C")

        private Message mUpdateMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "2A3109A682991470C8E7A9944372B1F8", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

        private boolean mAutoFillable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "5C4062DD484011F09E7BDF9F978C283A", hash_generated_field = "F9D9BCAC942E8D5C0FAF4BD1D37CB5CF")

        private boolean mAutoComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.228 -0400", hash_original_field = "EBB2C75EE511DE5780ECD7B092A5D38B", hash_generated_field = "93B1D4E2229B54F25A168656E4937615")

        private WebSettings mWebSettings;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.229 -0400", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "5B084D63C74BDE8B4C95B856FF4AC17D")
        public  RequestFormData(String name, String url, Message msg,
                boolean autoFillable, boolean autoComplete) {
            mName = name;
            mUrl = WebTextView.urlForAutoCompleteData(url);
            mUpdateMessage = msg;
            mAutoFillable = autoFillable;
            mAutoComplete = autoComplete;
            mWebSettings = getSettings();
            // ---------- Original Method ----------
            //mName = name;
            //mUrl = WebTextView.urlForAutoCompleteData(url);
            //mUpdateMessage = msg;
            //mAutoFillable = autoFillable;
            //mAutoComplete = autoComplete;
            //mWebSettings = getSettings();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.230 -0400", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "EAE878CD9594988AA48AA460028102C4")
        public void run() {
            ArrayList<String> pastEntries;
            pastEntries = new ArrayList<String>();
            {
                {
                    boolean var5288C74084AF99D20729B6F53A54E232_1053312226 = (mWebSettings != null && mWebSettings.getAutoFillProfile() != null);
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.autofill_this_form).toString() +
                            " " +
                            mAutoFillData.getPreviewString());
                        mWebTextView.setAutoFillProfileIsSet(true);
                    } //End block
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.setup_autofill).toString());
                        mWebTextView.setAutoFillProfileIsSet(false);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                pastEntries.addAll(mDatabase.getFormData(mUrl, mName));
            } //End block
            {
                boolean var3F0C3C91772BA4E0AAA044D02E105F29_915484713 = (pastEntries.size() > 0);
                {
                    AutoCompleteAdapter adapter;
                    adapter = new
                        AutoCompleteAdapter(mContext, pastEntries);
                    mUpdateMessage.obj = adapter;
                    mUpdateMessage.sendToTarget();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class QueuedTouch {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.230 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.230 -0400", hash_original_field = "9F267F577D54234C4E24847A8B17E76A", hash_generated_field = "20EA73C9A7F9F149019985C98DE3A38D")

        MotionEvent mEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.230 -0400", hash_original_field = "7C6961287A3682FFFA13151222676CCD", hash_generated_field = "C7A09A520003D6660CD5B4796D1273F4")

        TouchEventData mTed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.243 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "BEE6F088ABCC206EAF882A35EEC82861")

        QueuedTouch mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.243 -0400", hash_original_method = "FA8EC88E2AD519ABBE81A37B882E4019", hash_generated_method = "FA8EC88E2AD519ABBE81A37B882E4019")
        public QueuedTouch ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.244 -0400", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "8F00A3DC4A31A716586BC089D88370EC")
        public QueuedTouch set(TouchEventData ted) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_1434982692 = null; //Variable for return #1
            mSequence = ted.mSequence;
            mTed = ted;
            mEvent = null;
            mNext = null;
            varB4EAC82CA7396A68D541C85D26508E83_1434982692 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1434982692.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1434982692;
            // ---------- Original Method ----------
            //mSequence = ted.mSequence;
            //mTed = ted;
            //mEvent = null;
            //mNext = null;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.246 -0400", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "2D24833D50B11CD581AE7B065F84D1DA")
        public QueuedTouch set(MotionEvent ev, long sequence) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_497020162 = null; //Variable for return #1
            mEvent = MotionEvent.obtain(ev);
            mSequence = sequence;
            mTed = null;
            mNext = null;
            varB4EAC82CA7396A68D541C85D26508E83_497020162 = this;
            varB4EAC82CA7396A68D541C85D26508E83_497020162.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_497020162;
            // ---------- Original Method ----------
            //mEvent = MotionEvent.obtain(ev);
            //mSequence = sequence;
            //mTed = null;
            //mNext = null;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "6D0E58A8EAE42070299DAC9444701C52")
        public QueuedTouch add(QueuedTouch other) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_199509820 = null; //Variable for return #1
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_1638189829 = null; //Variable for return #2
            {
                other.mNext = this;
                varB4EAC82CA7396A68D541C85D26508E83_199509820 = other;
            } //End block
            QueuedTouch insertAt;
            insertAt = this;
            {
                insertAt = insertAt.mNext;
            } //End block
            other.mNext = insertAt.mNext;
            insertAt.mNext = other;
            varB4EAC82CA7396A68D541C85D26508E83_1638189829 = this;
            QueuedTouch varA7E53CE21691AB073D9660D615818899_1422445015; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1422445015 = varB4EAC82CA7396A68D541C85D26508E83_199509820;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1422445015 = varB4EAC82CA7396A68D541C85D26508E83_1638189829;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1422445015.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1422445015;
            // ---------- Original Method ----------
            //if (other.mSequence < mSequence) {
                //other.mNext = this;
                //return other;
            //}
            //QueuedTouch insertAt = this;
            //while (insertAt.mNext != null && insertAt.mNext.mSequence < other.mSequence) {
                //insertAt = insertAt.mNext;
            //}
            //other.mNext = insertAt.mNext;
            //insertAt.mNext = other;
            //return this;
        }

        
    }


    
    private class TouchEventQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "99261C2FE4C4592C38DF4A927D54353D", hash_generated_field = "127F03A306165D2D03A139A6F1583390")

        private long mNextTouchSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "059351212566DAAB66E521AE56B5D1B9", hash_generated_field = "266156A22BD39F4F0BEF086C9C7B63E5")

        private long mLastHandledTouchSequence = Long.MIN_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "61FC8120FAFF1BD1B830C4B5C36F1B56", hash_generated_field = "AF7570BA97F43827805CB02058F37277")

        private long mIgnoreUntilSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "3964746921DBFB2211578ED44A2B4F3B", hash_generated_field = "21DBEB15ECA49C1E87E853FA0180CD65")

        private QueuedTouch mTouchEventQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "052E5BF59E84B47B0BA6B00A861D46BC", hash_generated_field = "08077047985BEF38D8C3F6BC11BCAC86")

        private QueuedTouch mPreQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "97C53AD1CE6FE2BC2B01D5BE11253B74", hash_generated_field = "F259F7EDDF59F6CEF0FD59699D3FC834")

        private QueuedTouch mQueuedTouchRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.247 -0400", hash_original_field = "160DA3898A622FF8D6DFD4C04ADCBAA4", hash_generated_field = "778CCCFD60C85F5AB4F8F90308D45BB5")

        private int mQueuedTouchRecycleCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.259 -0400", hash_original_field = "B8562DF9262860FE73F90E0012C8DE0F", hash_generated_field = "1E79D4489BE43CB9AEB55D3B13DF96A3")

        private long mLastEventTime = Long.MAX_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.259 -0400", hash_original_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25", hash_generated_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25")
        public TouchEventQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.260 -0400", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "799A7F3226FFB3FED8E29082E5649E9D")
        private QueuedTouch obtainQueuedTouch() {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_1772868009 = null; //Variable for return #1
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_623749884 = null; //Variable for return #2
            {
                QueuedTouch result;
                result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
                varB4EAC82CA7396A68D541C85D26508E83_1772868009 = result;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_623749884 = new QueuedTouch();
            QueuedTouch varA7E53CE21691AB073D9660D615818899_1061757267; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1061757267 = varB4EAC82CA7396A68D541C85D26508E83_1772868009;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1061757267 = varB4EAC82CA7396A68D541C85D26508E83_623749884;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1061757267.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1061757267;
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleBin != null) {
                //QueuedTouch result = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = result.mNext;
                //mQueuedTouchRecycleCount--;
                //return result;
            //}
            //return new QueuedTouch();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.260 -0400", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "FF19A2C62E6D784032ABEC06DA4B653A")
        public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
            // ---------- Original Method ----------
            //mIgnoreUntilSequence = mNextTouchSequence;
            //runQueuedAndPreQueuedEvents();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.261 -0400", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "FB156250A9C3BD0F183BF7E5E47EAFEF")
        private void runQueuedAndPreQueuedEvents() {
            QueuedTouch qd;
            qd = mPreQueue;
            boolean fromPreQueue;
            fromPreQueue = true;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe;
                recycleMe = qd;
                {
                    mPreQueue = qd.mNext;
                } //End block
                {
                    mTouchEventQueue = qd.mNext;
                } //End block
                recycleQueuedTouch(recycleMe);
                long nextPre;
                nextPre = mPreQueue.mSequence;
                nextPre = Long.MAX_VALUE;
                long nextQueued;
                nextQueued = mTouchEventQueue.mSequence;
                nextQueued = Long.MAX_VALUE;
                fromPreQueue = nextPre < nextQueued;
                qd = fromPreQueue ? mPreQueue : mTouchEventQueue;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.275 -0400", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "0595C1A7763EACF17D91D18AC4875D70")
        public void preQueueTouchEventData(TouchEventData ted) {
            QueuedTouch newTouch;
            newTouch = obtainQueuedTouch().set(ted);
            {
                mPreQueue = newTouch;
            } //End block
            {
                QueuedTouch insertionPoint;
                insertionPoint = mPreQueue;
                {
                    insertionPoint = insertionPoint.mNext;
                } //End block
                newTouch.mNext = insertionPoint.mNext;
                insertionPoint.mNext = newTouch;
            } //End block
            addTaint(ted.getTaint());
            // ---------- Original Method ----------
            //QueuedTouch newTouch = obtainQueuedTouch().set(ted);
            //if (mPreQueue == null) {
                //mPreQueue = newTouch;
            //} else {
                //QueuedTouch insertionPoint = mPreQueue;
                //while (insertionPoint.mNext != null &&
                        //insertionPoint.mNext.mSequence < newTouch.mSequence) {
                    //insertionPoint = insertionPoint.mNext;
                //}
                //newTouch.mNext = insertionPoint.mNext;
                //insertionPoint.mNext = newTouch;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.275 -0400", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "23ACD9865FD3C2DC7344B474F0472DC4")
        private void recycleQueuedTouch(QueuedTouch qd) {
            {
                qd.mNext = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = qd;
            } //End block
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH) {
                //qd.mNext = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = qd;
                //mQueuedTouchRecycleCount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.276 -0400", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "10E51E5BBAB2D5CE78007C28414A1712")
        public void reset() {
            mNextTouchSequence = Long.MIN_VALUE + 1;
            mLastHandledTouchSequence = Long.MIN_VALUE;
            mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            {
                QueuedTouch recycleMe;
                recycleMe = mTouchEventQueue;
                mTouchEventQueue = mTouchEventQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            {
                QueuedTouch recycleMe;
                recycleMe = mPreQueue;
                mPreQueue = mPreQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            // ---------- Original Method ----------
            //mNextTouchSequence = Long.MIN_VALUE + 1;
            //mLastHandledTouchSequence = Long.MIN_VALUE;
            //mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            //while (mTouchEventQueue != null) {
                //QueuedTouch recycleMe = mTouchEventQueue;
                //mTouchEventQueue = mTouchEventQueue.mNext;
                //recycleQueuedTouch(recycleMe);
            //}
            //while (mPreQueue != null) {
                //QueuedTouch recycleMe = mPreQueue;
                //mPreQueue = mPreQueue.mNext;
                //recycleQueuedTouch(recycleMe);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.276 -0400", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "245FBC8229495C251F8E70B8A0A3573F")
        public long nextTouchSequence() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1452716338 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1452716338;
            // ---------- Original Method ----------
            //return mNextTouchSequence++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.277 -0400", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "EB347127BF7974D5278D13D5857276F4")
        public boolean enqueueTouchEvent(TouchEventData ted) {
            QueuedTouch preQueue;
            preQueue = mPreQueue;
            {
                {
                    mPreQueue = preQueue.mNext;
                } //End block
                {
                    QueuedTouch prev;
                    prev = preQueue;
                    preQueue = null;
                    {
                        {
                            preQueue = prev.mNext;
                            prev.mNext = preQueue.mNext;
                        } //End block
                        {
                            prev = prev.mNext;
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                boolean varBE43CED5DAEAE4AB789CEEFCCB879ABB_1349525783 = (dropStaleGestures(ted.mMotionEvent, ted.mSequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                } //End block
                handleQueuedTouchEventData(ted);
                runNextQueuedEvents();
            } //End block
            {
                QueuedTouch qd;
                qd = preQueue;
                qd = obtainQueuedTouch().set(ted);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
            addTaint(ted.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712607383 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_712607383;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.278 -0400", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "83497F441078B5A05E7A4AC74710D398")
        public void enqueueTouchEvent(MotionEvent ev) {
            long sequence;
            sequence = nextTouchSequence();
            {
                boolean varC743B531629C8022D99C282BCE55BA59_681028622 = (dropStaleGestures(ev, sequence));
            } //End collapsed parenthetic
            runNextQueuedEvents();
            {
                handleQueuedMotionEvent(ev);
                runNextQueuedEvents();
            } //End block
            {
                QueuedTouch qd;
                qd = obtainQueuedTouch().set(ev, sequence);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
            addTaint(ev.getTaint());
            // ---------- Original Method ----------
            //final long sequence = nextTouchSequence();
            //if (dropStaleGestures(ev, sequence)) {
                //return;
            //}
            //runNextQueuedEvents();
            //if (mLastHandledTouchSequence + 1 == sequence) {
                //handleQueuedMotionEvent(ev);
                //mLastHandledTouchSequence++;
                //runNextQueuedEvents();
            //} else {
                //QueuedTouch qd = obtainQueuedTouch().set(ev, sequence);
                //mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.278 -0400", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "B5D89403867D41355387842DF49AFAEE")
        private void runNextQueuedEvents() {
            QueuedTouch qd;
            qd = mTouchEventQueue;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe;
                recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            mTouchEventQueue = qd;
            // ---------- Original Method ----------
            //QueuedTouch qd = mTouchEventQueue;
            //while (qd != null && qd.mSequence == mLastHandledTouchSequence + 1) {
                //handleQueuedTouch(qd);
                //QueuedTouch recycleMe = qd;
                //qd = qd.mNext;
                //recycleQueuedTouch(recycleMe);
                //mLastHandledTouchSequence++;
            //}
            //mTouchEventQueue = qd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.283 -0400", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "F10AC64F3D80338C6FDB3C379EC0B9AF")
        private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            {
                boolean var6660B004F1AFFBD2AD367F81FA8A8ECB_596689277 = (ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove);
                {
                    int dx;
                    dx = Math.round(ev.getX()) - mLastTouchX;
                    int dy;
                    dy = Math.round(ev.getY()) - mLastTouchY;
                    {
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDD96473448E99D0068A310672554EE17_852554433 = (ev != null && ev.getAction() == MotionEvent.ACTION_DOWN);
                {
                    long eventTime;
                    eventTime = ev.getEventTime();
                    long lastHandledEventTime;
                    lastHandledEventTime = mLastEventTime;
                    {
                        runQueuedAndPreQueuedEvents();
                        QueuedTouch qd;
                        qd = mTouchEventQueue;
                        {
                            QueuedTouch recycleMe;
                            recycleMe = qd;
                            qd = qd.mNext;
                            recycleQueuedTouch(recycleMe);
                        } //End block
                        mTouchEventQueue = qd;
                        mLastHandledTouchSequence = sequence - 1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                QueuedTouch qd;
                qd = mTouchEventQueue;
                {
                    QueuedTouch recycleMe;
                    recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mTouchEventQueue = qd;
                mLastHandledTouchSequence = mIgnoreUntilSequence - 1;
            } //End block
            {
                QueuedTouch qd;
                qd = mPreQueue;
                {
                    QueuedTouch recycleMe;
                    recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mPreQueue = qd;
            } //End block
            addTaint(ev.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907571301 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907571301;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.291 -0400", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "A141C3DAD1F9122DF97E0B8D7BF53D83")
        private void handleQueuedTouch(QueuedTouch qt) {
            {
                handleQueuedTouchEventData(qt.mTed);
            } //End block
            {
                handleQueuedMotionEvent(qt.mEvent);
                qt.mEvent.recycle();
            } //End block
            addTaint(qt.getTaint());
            // ---------- Original Method ----------
            //if (qt.mTed != null) {
                //handleQueuedTouchEventData(qt.mTed);
            //} else {
                //handleQueuedMotionEvent(qt.mEvent);
                //qt.mEvent.recycle();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.292 -0400", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "6D9B2B2138EE733E24F6EF8B7AC34DE6")
        private void handleQueuedMotionEvent(MotionEvent ev) {
            mLastEventTime = ev.getEventTime();
            int action;
            action = ev.getActionMasked();
            {
                boolean var5547CC292C3C07AC5E49CBFC5588305F_319166592 = (ev.getPointerCount() > 1);
                {
                    handleMultiTouchInWebView(ev);
                } //End block
                {
                    ScaleGestureDetector detector;
                    detector = mZoomManager.getMultiTouchGestureDetector();
                    {
                        detector.onTouchEvent(ev);
                    } //End block
                    handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mLastEventTime = ev.getEventTime();
            //int action = ev.getActionMasked();
            //if (ev.getPointerCount() > 1) {  
                //handleMultiTouchInWebView(ev);
            //} else {
                //final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                //if (detector != null && mPreventDefault != PREVENT_DEFAULT_YES) {
                    //detector.onTouchEvent(ev);
                //}
                //handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.365 -0400", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "1B51BE9D0FCFF278240FD094BFEB5935")
        private void handleQueuedTouchEventData(TouchEventData ted) {
            {
                mLastEventTime = ted.mMotionEvent.getEventTime();
            } //End block
            {
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN;
                } //End block
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO;
                } //End block
                {
                    mTouchHighlightRegion.setEmpty();
                } //End block
            } //End block
            {
                {
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                        handleMultiTouchInWebView(ted.mMotionEvent);
                    } //End block
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } //End block
                } //End block
                {
                    //Begin case MotionEvent.ACTION_DOWN 
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_DOWN 
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_DOWN 
                    mDeferTouchMode = TOUCH_INIT_MODE;
                    //End case MotionEvent.ACTION_DOWN 
                    //Begin case MotionEvent.ACTION_MOVE 
                    {
                        int x;
                        x = ted.mPointsInView[0].x;
                        int y;
                        y = ted.mPointsInView[0].y;
                        {
                            mDeferTouchMode = TOUCH_DRAG_MODE;
                            mLastDeferTouchX = x;
                            mLastDeferTouchY = y;
                            startScrollingLayer(x, y);
                            startDrag();
                        } //End block
                        int deltaX;
                        deltaX = pinLocX((int) (mScrollX
                                    + mLastDeferTouchX - x))
                                    - mScrollX;
                        int deltaY;
                        deltaY = pinLocY((int) (mScrollY
                                    + mLastDeferTouchY - y))
                                    - mScrollY;
                        doDrag(deltaX, deltaY);
                        mLastDeferTouchX = x;
                        mLastDeferTouchY = y;
                    } //End block
                    //End case MotionEvent.ACTION_MOVE 
                    //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    {
                        mScroller.springBack(mScrollX, mScrollY, 0,
                                        computeMaxScrollX(), 0,
                                        computeMaxScrollY());
                        invalidate();
                        WebViewCore.resumePriority();
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    } //End block
                    //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    //Begin case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case MotionEvent.ACTION_UP MotionEvent.ACTION_CANCEL 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_DOUBLETAP 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case WebViewCore.ACTION_DOUBLETAP 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    HitTestResult hitTest;
                    hitTest = getHitTestResult();
                    //End case WebViewCore.ACTION_LONGPRESS 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    {
                        performLongClick();
                    } //End block
                    //End case WebViewCore.ACTION_LONGPRESS 
                    //Begin case WebViewCore.ACTION_LONGPRESS 
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    //End case WebViewCore.ACTION_LONGPRESS 
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.366 -0400", hash_original_field = "5842E73A351A2BBCD4BC86770C0E9B9A", hash_generated_field = "075EDC13A480C594C7E71C1FB6ADEC1C")

        private static int MAX_RECYCLED_QUEUED_TOUCH = 15;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.366 -0400", hash_original_field = "09C062B1DCE117D7E9D6F9016B9F35A1", hash_generated_field = "C767ECD5C47F612DDD8958087E4D4774")

        private static int QUEUED_GESTURE_TIMEOUT = 1000;
    }


    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.366 -0400", hash_original_method = "827423792FD52B61F0723B9DB59191FF", hash_generated_method = "827423792FD52B61F0723B9DB59191FF")
        public PrivateHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.403 -0400", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "E09202514630C0A7715803A4C44DB2F9")
        @Override
        public void handleMessage(Message msg) {
            //Begin case REMEMBER_PASSWORD 
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"),
                            msg.getData().getString("username"),
                            msg.getData().getString("password"));
                ((Message) msg.obj).sendToTarget();
            } //End block
            //End case REMEMBER_PASSWORD 
            //Begin case NEVER_REMEMBER_PASSWORD 
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"), null, null);
                ((Message) msg.obj).sendToTarget();
            } //End block
            //End case NEVER_REMEMBER_PASSWORD 
            //Begin case PREVENT_DEFAULT_TIMEOUT 
            {
                {
                    cancelWebCoreTouchEvent(
                                viewToContentX(mLastTouchX + mScrollX),
                                viewToContentY(mLastTouchY + mScrollY),
                                true);
                } //End block
            } //End block
            //End case PREVENT_DEFAULT_TIMEOUT 
            //Begin case SCROLL_SELECT_TEXT 
            {
                {
                    mSentAutoScrollMessage = false;
                } //End block
                {
                    pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                } //End block
                {
                    scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX,
                                mScrollingLayerRect.top + mAutoScrollY);
                } //End block
                sendEmptyMessageDelayed(
                            SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
            } //End block
            //End case SCROLL_SELECT_TEXT 
            //Begin case UPDATE_SELECTION 
            {
                {
                    updateSelection();
                } //End block
            } //End block
            //End case UPDATE_SELECTION 
            //Begin case SWITCH_TO_SHORTPRESS 
            {
                mInitialHitTestResult = null;
                {
                    {
                        boolean var8FF10029C08AB4FC7C05FF2A261CB23D_1638199277 = (!getSettings().supportTouchOnly()
                                && mPreventDefault != PREVENT_DEFAULT_YES);
                        {
                            mTouchMode = TOUCH_SHORTPRESS_START_MODE;
                            updateSelection();
                        } //End block
                        {
                            mTouchMode = TOUCH_SHORTPRESS_MODE;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    mTouchMode = TOUCH_DONE_MODE;
                } //End block
            } //End block
            //End case SWITCH_TO_SHORTPRESS 
            //Begin case SWITCH_TO_LONGPRESS 
            {
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_769188403 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_475380844 = (inFullScreenMode() || mDeferTouchProcess);
                    {
                        TouchEventData ted;
                        ted = new TouchEventData();
                        ted.mAction = WebViewCore.ACTION_LONGPRESS;
                        ted.mIds = new int[1];
                        ted.mIds[0] = 0;
                        ted.mPoints = new Point[1];
                        ted.mPoints[0] = new Point(viewToContentX(mLastTouchX + mScrollX),
                                                   viewToContentY(mLastTouchY + mScrollY));
                        ted.mPointsInView = new Point[1];
                        ted.mPointsInView[0] = new Point(mLastTouchX, mLastTouchY);
                        ted.mMetaState = 0;
                        ted.mReprocess = mDeferTouchProcess;
                        ted.mNativeLayer = nativeScrollableLayer(
                                ted.mPoints[0].x, ted.mPoints[0].y,
                                ted.mNativeLayerRect, null);
                        ted.mSequence = mTouchEventQueue.nextTouchSequence();
                        mTouchEventQueue.preQueueTouchEventData(ted);
                        mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
                    } //End block
                    {
                        mTouchMode = TOUCH_DONE_MODE;
                        performLongClick();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            //End case SWITCH_TO_LONGPRESS 
            //Begin case RELEASE_SINGLE_TAP 
            {
                doShortPress();
            } //End block
            //End case RELEASE_SINGLE_TAP 
            //Begin case SCROLL_TO_MSG_ID 
            {
                {
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        boolean varC08B8A0171CF85CA13986B7A742C9FAC_1165427748 = (imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView))));
                    } //End collapsed parenthetic
                } //End block
                Point p;
                p = (Point) msg.obj;
                {
                    spawnContentScrollTo(p.x, p.y);
                } //End block
                {
                    setContentScrollTo(p.x, p.y);
                } //End block
            } //End block
            //End case SCROLL_TO_MSG_ID 
            //Begin case UPDATE_ZOOM_RANGE 
            {
                WebViewCore.ViewState viewState;
                viewState = (WebViewCore.ViewState) msg.obj;
                mZoomManager.updateZoomRange(viewState, getViewWidth(), viewState.mScrollX);
            } //End block
            //End case UPDATE_ZOOM_RANGE 
            //Begin case UPDATE_ZOOM_DENSITY 
            {
                float density;
                density = (Float) msg.obj;
                mZoomManager.updateDefaultZoomDensity(density);
            } //End block
            //End case UPDATE_ZOOM_DENSITY 
            //Begin case REPLACE_BASE_CONTENT 
            {
                nativeReplaceBaseContent(msg.arg1);
            } //End block
            //End case REPLACE_BASE_CONTENT 
            //Begin case NEW_PICTURE_MSG_ID 
            {
                WebViewCore.DrawData draw;
                draw = (WebViewCore.DrawData) msg.obj;
                setNewPicture(draw, true);
            } //End block
            //End case NEW_PICTURE_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            String drawableDir;
            drawableDir = BrowserFrame.getRawResFilename(
                            BrowserFrame.DRAWABLEDIR, mContext);
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            WindowManager windowManager;
            windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            Display display;
            display = windowManager.getDefaultDisplay();
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            nativeCreate(msg.arg1, drawableDir,
                            ActivityManager.isHighEndGfx(display));
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            {
                setNewPicture(mDelaySetPicture, true);
                mDelaySetPicture = null;
            } //End block
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case WEBCORE_INITIALIZED_MSG_ID 
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            //End case WEBCORE_INITIALIZED_MSG_ID 
            //Begin case UPDATE_TEXTFIELD_TEXT_MSG_ID 
            {
                boolean var24ED917A45E165B2D0DB73D1C228849D_453685639 = (inEditingMode() &&
                            mWebTextView.isSameTextField(msg.arg1));
                {
                    {
                        String text;
                        text = (String) msg.obj;
                        {
                            text = "";
                        } //End block
                        mWebTextView.setTextAndKeepSelection(text);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //End case UPDATE_TEXTFIELD_TEXT_MSG_ID 
            //Begin case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID 
            displaySoftKeyboard(true);
            //End case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID 
            //Begin case UPDATE_TEXT_SELECTION_MSG_ID 
            updateTextSelectionFromMessage(msg.arg1, msg.arg2,
                            (WebViewCore.TextSelectionData) msg.obj);
            //End case UPDATE_TEXT_SELECTION_MSG_ID 
            //Begin case FORM_DID_BLUR 
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1671975341 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    hideSoftKeyboard();
                } //End block
            } //End collapsed parenthetic
            //End case FORM_DID_BLUR 
            //Begin case RETURN_LABEL 
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1209989697 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setHint((String) msg.obj);
                    InputMethodManager imm;
                    imm = InputMethodManager.peekInstance();
                    {
                        boolean varE86969381D8E084EE7486B0BCDFB9761_1432102810 = (imm != null && imm.isActive(mWebTextView));
                        {
                            imm.restartInput(mWebTextView);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case RETURN_LABEL 
            //Begin case UNHANDLED_NAV_KEY 
            navHandledKey(msg.arg1, 1, false, 0);
            //End case UNHANDLED_NAV_KEY 
            //Begin case UPDATE_TEXT_ENTRY_MSG_ID 
            {
                boolean var0513EDBB647F1B1B0CEC2398CB7258CB_34977765 = (inEditingMode() && nativeCursorIsTextInput());
                {
                    updateWebTextViewPosition();
                } //End block
            } //End collapsed parenthetic
            //End case UPDATE_TEXT_ENTRY_MSG_ID 
            //Begin case CLEAR_TEXT_ENTRY 
            clearTextEntry();
            //End case CLEAR_TEXT_ENTRY 
            //Begin case INVAL_RECT_MSG_ID 
            {
                Rect r;
                r = (Rect)msg.obj;
                {
                    invalidate();
                } //End block
                {
                    viewInvalidate(r.left, r.top, r.right, r.bottom);
                } //End block
            } //End block
            //End case INVAL_RECT_MSG_ID 
            //Begin case REQUEST_FORM_DATA 
            AutoCompleteAdapter adapter;
            adapter = (AutoCompleteAdapter) msg.obj;
            //End case REQUEST_FORM_DATA 
            //Begin case REQUEST_FORM_DATA 
            {
                boolean var543595A323B4887B7F3AF5971C508703_532193769 = (mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setAdapterCustom(adapter);
                } //End block
            } //End collapsed parenthetic
            //End case REQUEST_FORM_DATA 
            //Begin case LONG_PRESS_CENTER 
            mGotCenterDown = false;
            //End case LONG_PRESS_CENTER 
            //Begin case LONG_PRESS_CENTER 
            mTrackballDown = false;
            //End case LONG_PRESS_CENTER 
            //Begin case LONG_PRESS_CENTER 
            performLongClick();
            //End case LONG_PRESS_CENTER 
            //Begin case WEBCORE_NEED_TOUCH_EVENTS 
            mForwardTouchEvents = (msg.arg1 != 0);
            //End case WEBCORE_NEED_TOUCH_EVENTS 
            //Begin case PREVENT_TOUCH_ID 
            {
                boolean varA9995E2AE703E9AF13E24802C20B989A_945916225 = (inFullScreenMode());
            } //End collapsed parenthetic
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            TouchEventData ted;
            ted = (TouchEventData) msg.obj;
            //End case PREVENT_TOUCH_ID 
            //Begin case PREVENT_TOUCH_ID 
            {
                boolean var25F0555089CC470A412F802E26A1BE83_401509967 = (mTouchEventQueue.enqueueTouchEvent(ted));
                {
                    removeMessages(PREVENT_DEFAULT_TIMEOUT);
                } //End block
            } //End collapsed parenthetic
            //End case PREVENT_TOUCH_ID 
            //Begin case REQUEST_KEYBOARD 
            {
                hideSoftKeyboard();
            } //End block
            {
                displaySoftKeyboard(false);
            } //End block
            //End case REQUEST_KEYBOARD 
            //Begin case FIND_AGAIN 
            {
                mFindCallback.findAll();
            } //End block
            //End case FIND_AGAIN 
            //Begin case DRAG_HELD_MOTIONLESS 
            mHeldMotionless = MOTIONLESS_TRUE;
            //End case DRAG_HELD_MOTIONLESS 
            //Begin case DRAG_HELD_MOTIONLESS 
            invalidate();
            //End case DRAG_HELD_MOTIONLESS 
            //Begin case AWAKEN_SCROLL_BARS 
            {
                awakenScrollBars(ViewConfiguration
                                .getScrollDefaultDelay(), false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(AWAKEN_SCROLL_BARS),
                                ViewConfiguration.getScrollDefaultDelay());
            } //End block
            //End case AWAKEN_SCROLL_BARS 
            //Begin case DO_MOTION_UP 
            doMotionUp(msg.arg1, msg.arg2);
            //End case DO_MOTION_UP 
            //Begin case SCREEN_ON 
            setKeepScreenOn(msg.arg1 == 1);
            //End case SCREEN_ON 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            int layerId;
            layerId = msg.arg1;
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            String url;
            url = (String) msg.obj;
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case ENTER_FULLSCREEN_VIDEO 
            {
                mHTML5VideoViewProxy.enterFullScreenVideo(layerId, url);
            } //End block
            //End case ENTER_FULLSCREEN_VIDEO 
            //Begin case SHOW_FULLSCREEN 
            {
                View view;
                view = (View) msg.obj;
                int orientation;
                orientation = msg.arg1;
                int npp;
                npp = msg.arg2;
                {
                    boolean var193BD8982A9C597816FCA9FE1F0F7BC4_338087002 = (inFullScreenMode());
                    {
                        dismissFullScreenMode();
                    } //End block
                } //End collapsed parenthetic
                mFullScreenHolder = new PluginFullScreenHolder(WebView.this, orientation, npp);
                mFullScreenHolder.setContentView(view);
                mFullScreenHolder.show();
            } //End block
            //End case SHOW_FULLSCREEN 
            //Begin case HIDE_FULLSCREEN 
            dismissFullScreenMode();
            //End case HIDE_FULLSCREEN 
            //Begin case DOM_FOCUS_CHANGED 
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_1749414260 = (inEditingMode());
                {
                    nativeClearCursor();
                    rebuildWebTextView();
                } //End block
            } //End collapsed parenthetic
            //End case DOM_FOCUS_CHANGED 
            //Begin case SHOW_RECT_MSG_ID 
            {
                WebViewCore.ShowRectData data;
                data = (WebViewCore.ShowRectData) msg.obj;
                int x;
                x = mScrollX;
                int left;
                left = contentToViewX(data.mLeft);
                int width;
                width = contentToViewDimension(data.mWidth);
                int maxWidth;
                maxWidth = contentToViewDimension(data.mContentWidth);
                int viewWidth;
                viewWidth = getViewWidth();
                {
                    x += left + width / 2 - mScrollX - viewWidth / 2;
                } //End block
                {
                    x += (int) (left + data.mXPercentInDoc * width
                                - mScrollX - data.mXPercentInView * viewWidth);
                } //End block
                x = Math.max(0,
                            (Math.min(maxWidth, x + viewWidth)) - viewWidth);
                int top;
                top = contentToViewY(data.mTop);
                int height;
                height = contentToViewDimension(data.mHeight);
                int maxHeight;
                maxHeight = contentToViewDimension(data.mContentHeight);
                int viewHeight;
                viewHeight = getViewHeight();
                int y;
                y = (int) (top + data.mYPercentInDoc * height -
                                   data.mYPercentInView * viewHeight);
                y = Math.max(0,
                            (Math.min(maxHeight, y + viewHeight) - viewHeight));
                y = Math.max(0, y - getVisibleTitleHeightImpl());
                scrollTo(x, y);
            } //End block
            //End case SHOW_RECT_MSG_ID 
            //Begin case CENTER_FIT_RECT 
            centerFitRect((Rect)msg.obj);
            //End case CENTER_FIT_RECT 
            //Begin case SET_SCROLLBAR_MODES 
            mHorizontalScrollBarMode = msg.arg1;
            //End case SET_SCROLLBAR_MODES 
            //Begin case SET_SCROLLBAR_MODES 
            mVerticalScrollBarMode = msg.arg2;
            //End case SET_SCROLLBAR_MODES 
            //Begin case SELECTION_STRING_CHANGED 
            {
                String selectionString;
                selectionString = (String) msg.obj;
                mAccessibilityInjector.onSelectionStringChange(selectionString);
            } //End block
            //End case SELECTION_STRING_CHANGED 
            //Begin case SET_TOUCH_HIGHLIGHT_RECTS 
            @SuppressWarnings("unchecked") ArrayList<Rect> rects;
            rects = (ArrayList<Rect>) msg.obj;
            //End case SET_TOUCH_HIGHLIGHT_RECTS 
            //Begin case SET_TOUCH_HIGHLIGHT_RECTS 
            setTouchHighlightRects(rects);
            //End case SET_TOUCH_HIGHLIGHT_RECTS 
            //Begin case SAVE_WEBARCHIVE_FINISHED 
            SaveWebArchiveMessage saveMessage;
            saveMessage = (SaveWebArchiveMessage)msg.obj;
            //End case SAVE_WEBARCHIVE_FINISHED 
            //Begin case SAVE_WEBARCHIVE_FINISHED 
            {
                saveMessage.mCallback.onReceiveValue(saveMessage.mResultFile);
            } //End block
            //End case SAVE_WEBARCHIVE_FINISHED 
            //Begin case SET_AUTOFILLABLE 
            mAutoFillData = (WebViewCore.AutoFillData) msg.obj;
            //End case SET_AUTOFILLABLE 
            //Begin case SET_AUTOFILLABLE 
            {
                mWebTextView.setAutoFillable(mAutoFillData.getQueryId());
                rebuildWebTextView();
            } //End block
            //End case SET_AUTOFILLABLE 
            //Begin case AUTOFILL_COMPLETE 
            {
                mWebTextView.setAdapterCustom(null);
            } //End block
            //End case AUTOFILL_COMPLETE 
            //Begin case SELECT_AT 
            nativeSelectAt(msg.arg1, msg.arg2);
            //End case SELECT_AT 
            //Begin case default 
            super.handleMessage(msg);
            //End case default 
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class InvokeListBox implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.414 -0400", hash_original_field = "AE78DDD4E1B4460118053782D7B99832", hash_generated_field = "44EE6B10D8B13CA54299546EDE76F988")

        private boolean mMultiple;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.415 -0400", hash_original_field = "A17946B2F76705FFA0DE3EA576AD2A14", hash_generated_field = "665B478A898DF171CBB5A5C66E041F86")

        private int[] mSelectedArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.415 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "C4C82616B1A0974C29170CF176A905F6")

        private int mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.415 -0400", hash_original_field = "5F8D1AB50E5C83BC9CBB9FBEC119B3B0", hash_generated_field = "9EF3ABDF3C19BF934708240D666FC0CB")

        private Container[] mContainers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.426 -0400", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "1187D66EE31CE21B4A9180CDB8366B4F")
        private  InvokeListBox(String[] array, int[] enabled, int[] selected) {
            mMultiple = true;
            mSelectedArray = selected;
            int length;
            length = array.length;
            mContainers = new Container[length];
            {
                int i;
                i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mMultiple = true;
            //mSelectedArray = selected;
            //int length = array.length;
            //mContainers = new Container[length];
            //for (int i = 0; i < length; i++) {
                //mContainers[i] = new Container();
                //mContainers[i].mString = array[i];
                //mContainers[i].mEnabled = enabled[i];
                //mContainers[i].mId = i;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.427 -0400", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "2CBEDAE747B28202D789A21CDD901E60")
        private  InvokeListBox(String[] array, int[] enabled, int selection) {
            mSelection = selection;
            mMultiple = false;
            int length;
            length = array.length;
            mContainers = new Container[length];
            {
                int i;
                i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //mSelection = selection;
            //mMultiple = false;
            //int length = array.length;
            //mContainers = new Container[length];
            //for (int i = 0; i < length; i++) {
                //mContainers[i] = new Container();
                //mContainers[i].mString = array[i];
                //mContainers[i].mEnabled = enabled[i];
                //mContainers[i].mId = i;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "8BDA2AD19E4FD3340BDA53E90F7758E5")
        public void run() {
            ListView listView;
            listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            MyArrayListAdapter adapter;
            adapter = new MyArrayListAdapter();
            AlertDialog.Builder b;
            b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);
            {
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.428 -0400", hash_original_method = "3150D57594E9A243EB2796EE1880D262", hash_generated_method = "3F6B021AED45769734F28F07ADA17DDB")
                    public void onClick(DialogInterface dialog, int which) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        mWebViewCore.sendMessage(
                                EventHub.LISTBOX_CHOICES,
                                adapter.getCount(), 0,
                                listView.getCheckedItemPositions());
                        addTaint(dialog.getTaint());
                        addTaint(which);
                        // ---------- Original Method ----------
                        //mWebViewCore.sendMessage(
                                //EventHub.LISTBOX_CHOICES,
                                //adapter.getCount(), 0,
                                //listView.getCheckedItemPositions());
                    }
});
                b.setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.437 -0400", hash_original_method = "167C789BB5CCECE2A545076849F2D943", hash_generated_method = "59C07BDADDA6A0C254998825263AE2FF")
                    public void onClick(DialogInterface dialog, int which) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                        addTaint(dialog.getTaint());
                        addTaint(which);
                        // ---------- Original Method ----------
                        //mWebViewCore.sendMessage(
                                //EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    }
});
            } //End block
            mListBoxDialog = b.create();
            listView.setAdapter(adapter);
            listView.setFocusableInTouchMode(true);
            listView.setTextFilterEnabled(!mMultiple);
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                int length;
                length = mSelectedArray.length;
                {
                    int i;
                    i = 0;
                    {
                        listView.setItemChecked(mSelectedArray[i], true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                listView.setOnItemClickListener(new OnItemClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.438 -0400", hash_original_method = "4FB59E3EE3C723FAB3D9C696C9283630", hash_generated_method = "EB5DE1DC2EC2F6B1D40394864B2401AC")
                    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        mListBoxDialog.dismiss();
                        mListBoxDialog = null;
                        addTaint(parent.getTaint());
                        addTaint(v.getTaint());
                        addTaint(position);
                        addTaint(id);
                        // ---------- Original Method ----------
                        //mListBoxMessage = Message.obtain(null,
                                //EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        //mListBoxDialog.dismiss();
                        //mListBoxDialog = null;
                    }
});
                {
                    listView.setSelection(mSelection);
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listView.setItemChecked(mSelection, true);
                    DataSetObserver observer;
                    observer = new SingleDataSetObserver(
                            adapter.getItemId(mSelection), listView, adapter);
                    adapter.registerDataSetObserver(observer);
                } //End block
            } //End block
            mListBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_method = "718CBFBF20241D8F0DF84EA7F924765B", hash_generated_method = "03CF01EF3CCA98BA2D99C73624A0B668")
                public void onCancel(DialogInterface dialog) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    mListBoxDialog = null;
                    addTaint(dialog.getTaint());
                    // ---------- Original Method ----------
                    //mWebViewCore.sendMessage(
                                //EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    //mListBoxDialog = null;
                }
});
            mListBoxDialog.show();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private class Container extends Object {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "0DD8A30A5B66E3389BB7F1641026A732")

            String mString;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "3811FA45E31C1288EF4A5CD0AF26B346")

            int mEnabled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

            int mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.442 -0400", hash_original_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4", hash_generated_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4")
            public Container ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.443 -0400", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "A766F4BED3B6547ED5727A283732DBD3")
            @Override
            public String toString() {
                String varB4EAC82CA7396A68D541C85D26508E83_724974936 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_724974936 = mString;
                varB4EAC82CA7396A68D541C85D26508E83_724974936.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_724974936;
                // ---------- Original Method ----------
                //return mString;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.443 -0400", hash_original_field = "D6517EB4E1F45C61EEFB510AAF08C057", hash_generated_field = "9010DD39CAD85B7087FF86DE81CC730A")

            static int OPTGROUP = -1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.443 -0400", hash_original_field = "EADC20B7F6688B86F7C891B4EEEBB80D", hash_generated_field = "FEC29E74DD4596809EBA8602F307D251")

            static int OPTION_DISABLED = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.443 -0400", hash_original_field = "5B1BBEBA286149605978186AE4B3FCC0", hash_generated_field = "7D9994F43E265673F7E9D9EFF51D90B6")

            static int OPTION_ENABLED = 1;
        }


        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.444 -0400", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "49BA01A9414CEFE48019AF33DD04C46A")
            public  MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.453 -0400", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "7D8BC2DA8B23FBA65CBD4AFA92468C50")
            @Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                View varB4EAC82CA7396A68D541C85D26508E83_1629266249 = null; //Variable for return #1
                View varB4EAC82CA7396A68D541C85D26508E83_662907979 = null; //Variable for return #2
                convertView = super.getView(position, null, parent);
                Container c;
                c = item(position);
                {
                    LinearLayout layout;
                    layout = new LinearLayout(mContext);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    {
                        View dividerTop;
                        dividerTop = new View(mContext);
                        dividerTop.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerTop);
                    } //End block
                    {
                        {
                            Assert.assertTrue(convertView instanceof CheckedTextView);
                            ((CheckedTextView) convertView).setCheckMarkDrawable(null);
                        } //End block
                    } //End block
                    {
                        convertView.setEnabled(false);
                    } //End block
                    layout.addView(convertView);
                    {
                        boolean var29E3F9545B0C5E6979D96B1ACDAB027D_1265662137 = (position < getCount() - 1);
                        {
                            View dividerBottom;
                            dividerBottom = new View(mContext);
                            dividerBottom.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                            layout.addView(dividerBottom);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1629266249 = layout;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_662907979 = convertView;
                addTaint(position);
                addTaint(convertView.getTaint());
                addTaint(parent.getTaint());
                View varA7E53CE21691AB073D9660D615818899_1443721209; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_1443721209 = varB4EAC82CA7396A68D541C85D26508E83_1629266249;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1443721209 = varB4EAC82CA7396A68D541C85D26508E83_662907979;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1443721209.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_1443721209;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.457 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "BF77B2AF7F4FAE036DCA19387C296757")
            @Override
            public boolean hasStableIds() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252642847 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_252642847;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.458 -0400", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "288D26A108B94BD70469396BC2A36F49")
            private Container item(int position) {
                Container varB4EAC82CA7396A68D541C85D26508E83_1683756052 = null; //Variable for return #1
                Container varB4EAC82CA7396A68D541C85D26508E83_346054437 = null; //Variable for return #2
                {
                    boolean var46FB1B51094929768D004AD98A0CD79D_419598101 = (position < 0 || position >= getCount());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1683756052 = null;
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_346054437 = (Container) getItem(position);
                addTaint(position);
                Container varA7E53CE21691AB073D9660D615818899_1930741799; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_1930741799 = varB4EAC82CA7396A68D541C85D26508E83_1683756052;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1930741799 = varB4EAC82CA7396A68D541C85D26508E83_346054437;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1930741799.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_1930741799;
                // ---------- Original Method ----------
                //if (position < 0 || position >= getCount()) {
                    //return null;
                //}
                //return (Container) getItem(position);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.458 -0400", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "A6D9DBB881147A0600D08973A683FC9B")
            @Override
            public long getItemId(int position) {
                Container item;
                item = item(position);
                addTaint(position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1688345967 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1688345967;
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return -1;
                //}
                //return item.mId;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.458 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "C859BF01DC4D7014D8472EA5CA4621A0")
            @Override
            public boolean areAllItemsEnabled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312482013 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312482013;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.459 -0400", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "447A7825F96CACB67D5DFC2826A93366")
            @Override
            public boolean isEnabled(int position) {
                Container item;
                item = item(position);
                addTaint(position);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372618128 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372618128;
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return false;
                //}
                //return Container.OPTION_ENABLED == item.mEnabled;
            }

            
        }


        
        private class SingleDataSetObserver extends DataSetObserver {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.459 -0400", hash_original_field = "1628F13DF17E9E9D9F9B263B8D9EDD6C", hash_generated_field = "2D84C7F454FDE105876BFC5F1B67C86D")

            private long mCheckedId;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.459 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

            private ListView mListView;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.459 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6E193E3C34AABA5E66E6DED38A82989F")

            private Adapter mAdapter;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.459 -0400", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "E96D6794E0A94B47CBCDFF86041C30D5")
            public  SingleDataSetObserver(long id, ListView l, Adapter a) {
                mCheckedId = id;
                mListView = l;
                mAdapter = a;
                // ---------- Original Method ----------
                //mCheckedId = id;
                //mListView = l;
                //mAdapter = a;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "3FCE61910055480C3A4F964A99CF8BE3")
            @Override
            public void onChanged() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                int position;
                position = mListView.getCheckedItemPosition();
                long id;
                id = mAdapter.getItemId(position);
                {
                    mListView.clearChoices();
                    int count;
                    count = mAdapter.getCount();
                    {
                        int i;
                        i = 0;
                        {
                            {
                                boolean varA60FED54EC8179E35E73102579F12B18_412439254 = (mAdapter.getItemId(i) == mCheckedId);
                                {
                                    mListView.setItemChecked(i, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                //int position = mListView.getCheckedItemPosition();
                //long id = mAdapter.getItemId(position);
                //if (mCheckedId != id) {
                    //mListView.clearChoices();
                    //int count = mAdapter.getCount();
                    //for (int i = 0; i < count; i++) {
                        //if (mAdapter.getItemId(i) == mCheckedId) {
                            //mListView.setItemChecked(i, true);
                            //break;
                        //}
                    //}
                //}
            }

            
        }


        
    }


    
    @Deprecated public interface PictureListener {
        
        @Deprecated
        public void onNewPicture(WebView view, Picture picture);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "BE33F1BA0BEAFDD282FD866A71F8C820", hash_generated_field = "0DE82CE12549BBE2EE6E221400489036")

    static private boolean AUTO_REDRAW_HACK = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "B69D7271B5B04F230CFD3A39801848FE", hash_generated_field = "7B15BA079BA20CCB483F253C6190867C")

    static String LOGTAG = "webview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "401D0C50F5B5682013FF8501F0AE4992", hash_generated_field = "70E2AD8F622BBF7A515BED5856422DC2")

    private static int TOUCH_SENT_INTERVAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "FDA2833B881423CF2382162CF73E5DD8", hash_generated_field = "0592CB5F5D75E3AACE2B4A486B41470D")

    private static float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "830E36417005DF9041C9C155F5AF0C5E", hash_generated_field = "DEB7F0F5A267E7F1EBF7274DDE832AF2")

    private static int TOUCH_INIT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "BC0287058F8F9C0519ADF1B05059B082", hash_generated_field = "DE5466B926CFD1F119623E6F24506406")

    private static int TOUCH_DRAG_START_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "60FF79799CAE259EC9644FE4567C81E9", hash_generated_field = "980F13E3A369491764B3CA1523297FF6")

    private static int TOUCH_DRAG_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "8C98CB345A5C0960936AFB57236AE88D", hash_generated_field = "D4B0632693E88A759B0F28C46888481D")

    private static int TOUCH_SHORTPRESS_START_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "4EE5240F8B0AE93BC98E85CB9DC7832A", hash_generated_field = "0A800FC8F56F3053CADF79C5D1F1DBE8")

    private static int TOUCH_SHORTPRESS_MODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "45A1C3A3DFB55C39DB0613949B81D56D", hash_generated_field = "A6B65A17B97CE049CC9FA47F34C9093C")

    private static int TOUCH_DOUBLE_TAP_MODE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "542A404318769EFE31C3373EC72F80C0", hash_generated_field = "59C76DA17BB7195F6513AF7E774FB87C")

    private static int TOUCH_DONE_MODE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "50B3C9A9C73BD42555AEF7EF2E21DDBF", hash_generated_field = "B6D82EDAE59057BC5E664E6EB9016501")

    private static int TOUCH_PINCH_DRAG = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "53FA87A229E47122811D2AC915236BDB", hash_generated_field = "6F6BC05CF86798416DD3BB1A9E15B475")

    private static int TOUCH_DRAG_LAYER_MODE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "243187813A74B6724D1D7D013A4914BF", hash_generated_field = "219CF4168BC7A6A24EA5548CDB3E87AB")

    private static int PREVENT_DEFAULT_NO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "114BA0DFA413E46BD05BCCCAE52F7CE9", hash_generated_field = "5C9B952680DD072D481B017D9C501C9A")

    private static int PREVENT_DEFAULT_MAYBE_YES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "764EAA1B45BBED56BEFF79F78CCCC30F", hash_generated_field = "889D86831E820B1FD6E538D1F217E90C")

    private static int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "115EA2E1D84C5A2DBB3A66D18E55207E", hash_generated_field = "432430A5BA1A750193FBE539BFD0CE0E")

    private static int PREVENT_DEFAULT_YES = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.460 -0400", hash_original_field = "6E418AA2FF2BF9C4AAC516F3D1516EB4", hash_generated_field = "5D5F735DC5875CF6BAF0FBDE217EBB1B")

    private static int PREVENT_DEFAULT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "01D9479B5CB4E71DC6D0011835E1DB7F", hash_generated_field = "07FA1BF9C483282446FCF4ADBF73D5CF")

    private static int TAP_TIMEOUT = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "DAFA273212F04FC87B65CE7853DD4431", hash_generated_field = "86517CB718FD0B41927C6B62F9ACEAF8")

    private static int LONG_PRESS_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "3615EDC2077354E3863F1AA174E54A2F", hash_generated_field = "640641F9D4E27DEE131BF1EBB3CBD96C")

    private static int MIN_FLING_TIME = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "D58A8B27FE3FA5C832771535E3640C37", hash_generated_field = "ECE800E7DFA86832B50257C695A6352C")

    private static int MOTIONLESS_TIME = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "1CD32C13456CF785393CD5CEF1F8FE90", hash_generated_field = "ACE91B95EE8863AAD173FFB347729F5C")

    private static int PAGE_SCROLL_OVERLAP = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "85BC58835EF22EB8B7BFF6BF6659DAB0", hash_generated_field = "961152F11D1F9EBBE07F95EB5B5C9D19")

    private static int STD_SPEED = 480;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "C5EECEC275CDFA7928896A1923B370C6", hash_generated_field = "24BE6DD2AF1512348CC1FA6F6D72DE3D")

    private static int MAX_DURATION = 750;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "EF4821831D32A9783A9848E8A3E2A3A6", hash_generated_field = "0F97CD77E0B200EAE79C81D8E12FA5E6")

    private static int SLIDE_TITLE_DURATION = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "24A904D49EE9497D9F59EB6815718BD9", hash_generated_field = "E8C9A528EEF567C1C6F71F0F8BDD0AD6")

    private static Paint mOverScrollBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "73148EE68E3BF99A9D7C02B4BA6163F6", hash_generated_field = "9CFFB41CE7C3DFBAB932F7E5B2B5A059")

    private static Paint mOverScrollBorder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "BB8DFFB09685AD77BA9927AC1D758774", hash_generated_field = "1840D3C8114EC272E64A471477C63DF6")

    private static int MOTIONLESS_FALSE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "9B547B86098357EF9040837C5801F603", hash_generated_field = "02A1494FC3008F0786329995B33A1A5A")

    private static int MOTIONLESS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "B0E7FFFCB301B45048F9EEB47D7877B9", hash_generated_field = "0F283B7CBAEBB6E10A1C922C9CACDE0F")

    private static int MOTIONLESS_TRUE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "3DE6CF176FEB4908AE3D96A9A6F4F88B", hash_generated_field = "71890E9622B6B79833A9A8C5A3A131A1")

    private static int MOTIONLESS_IGNORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "73FED487255AE81470218D0CBF3A09FE", hash_generated_field = "867AC9104446DD42C0F7B342271492B9")

    static boolean USE_JAVA_TEXT_SELECTION = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "51619C191BA20D95DACC60375D2D07F0", hash_generated_field = "F33496254347E9904C0CAF81A01E96B5")

    static boolean DEBUG_TEXT_HANDLES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "1AEBD097FC2E1CD6F89DD1815A965E31", hash_generated_field = "567583BEA9B825474340C9444F234C5C")

    static boolean USE_WEBKIT_RINGS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "B282E941A1CF3225E10262EA2884F7C3", hash_generated_field = "349D45C6F62F04E2B59A993A50E60904")

    private static int HIGHLIGHT_COLOR = 0x6633b5e5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "9BDC47B861E33CE5CF5D947AD0F57B59", hash_generated_field = "F0A479ECCCC43547754742980255542B")

    private static float TOUCH_HIGHLIGHT_ARC = 5.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "ED37554492F6447916EB8E7CD93BD07D", hash_generated_field = "B3EC959180BCFE9F058F3187D04D32DB")

    private static boolean DEBUG_TOUCH_HIGHLIGHT = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "EB8E2B25D453DF18B2094FCBD1B00BD9", hash_generated_field = "E185BD79DCD02BE8D5704505DBC1F36A")

    private static int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "49AC45054CF7856A64543A32C588FA23", hash_generated_field = "E5E974C3C519583A23B7BF8883AE3111")

    private static int REMEMBER_PASSWORD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "E4E660C7AE61BE902790AC4D73AC49CF", hash_generated_field = "D2C294D4D4BDDCE7248268B6005FD190")

    private static int NEVER_REMEMBER_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "10435B44801FE7F48C9F6D6372BDBB48", hash_generated_field = "35291BE20C3A22DF5962BF6D3031D636")

    private static int SWITCH_TO_SHORTPRESS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "530A8354858626CD11B71F031040A8E8", hash_generated_field = "FA130D875AFECE1BEFD922B763008BC0")

    private static int SWITCH_TO_LONGPRESS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "4D5243D5F746CB51670C65AA9BE7F05E", hash_generated_field = "AC76D2D506ACDA71D5FEB615314EBABC")

    private static int RELEASE_SINGLE_TAP = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "1289E896C38EE9E355229E2F451A0BC9", hash_generated_field = "6AED51EC5F3E25BE5F7C2E362AD7DBC7")

    private static int REQUEST_FORM_DATA = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "A43738E6619122218BEFFA63A7C1E03F", hash_generated_field = "73D1E8C720DF024B58DE5837E0636049")

    private static int DRAG_HELD_MOTIONLESS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "C113C7F74C1996CA65C2696D86748284", hash_generated_field = "0BBD4A062AAC410612D10244B3D013D8")

    private static int AWAKEN_SCROLL_BARS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.461 -0400", hash_original_field = "B65F2CF00C901DE7591BAC977345FBC8", hash_generated_field = "A16ACED86CE97DF9E91723FE2CD6E67B")

    private static int PREVENT_DEFAULT_TIMEOUT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.462 -0400", hash_original_field = "7CB2EB69693E24C1E3251BB6A2E4B18C", hash_generated_field = "ECED4315C6FA75B7802AC8730E1A3EA8")

    private static int SCROLL_SELECT_TEXT = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.462 -0400", hash_original_field = "3059CA9576FD841DE6A4EABDD0120D8A", hash_generated_field = "5345BF9A7CC27B5CB8F300152D398E50")

    private static int FIRST_PRIVATE_MSG_ID = REMEMBER_PASSWORD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "519D5D8383980F94F362D163FA1DD3A4", hash_generated_field = "17EB7FA9DFBE0264F32AFE072D391A3D")

    private static int LAST_PRIVATE_MSG_ID = SCROLL_SELECT_TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "D55D1847289294695B340BDD6B988D61", hash_generated_field = "AE734EAA13CD3BC284F71E542DD67643")

    static int SCROLL_TO_MSG_ID = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "7C3FDB228096679810DC186C1CF5D088", hash_generated_field = "FF2C5BA074ED26933CAF7AEDA1B4E600")

    static int NEW_PICTURE_MSG_ID = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "5D4D86559B515C33EA45F74EAD2CC2C9", hash_generated_field = "15903DC57055E7F9DD4443360778BF47")

    static int UPDATE_TEXT_ENTRY_MSG_ID = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "27425AA4F646CE9409853E6F26DBF525", hash_generated_field = "122EB9E87C61685D79156097D29B42D9")

    static int WEBCORE_INITIALIZED_MSG_ID = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "5AC192AFA63C2DA703CD387DE90D4698", hash_generated_field = "EC833314F1972CE901E982654A0155BE")

    static int UPDATE_TEXTFIELD_TEXT_MSG_ID = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "C609D9E92E308266EDF2BEBD11FE2195", hash_generated_field = "F4D74D754F509FB144F490FD2249A5B6")

    static int UPDATE_ZOOM_RANGE = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "54C3FACEFBED28B431192B4CDBE80F30", hash_generated_field = "A81400DF51C4638A16DBBD2604238F20")

    static int UNHANDLED_NAV_KEY = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "E29CE477AA12360FD97442B94DAA604D", hash_generated_field = "8D3EF93FC39504678D909773F340633E")

    static int CLEAR_TEXT_ENTRY = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "8C4DA7752E60D44364A5ECFCEF99A265", hash_generated_field = "79D4A9AED8F784FA0B2D199AC315E0ED")

    static int UPDATE_TEXT_SELECTION_MSG_ID = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "84608AF3D8EA7A17339C6FED52EFB3A5", hash_generated_field = "12E1464FC48D88D0F422768771B6C82B")

    static int SHOW_RECT_MSG_ID = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "EA5BFD49CB9CF50F04845C0B4CE85222", hash_generated_field = "D8F547A9675B9483A55F57C70F8371D8")

    static int LONG_PRESS_CENTER = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "69651E0CF2DFC70C890C9154E5E8EEC9", hash_generated_field = "8271327CF7AE3BD1AD799F329715833E")

    static int PREVENT_TOUCH_ID = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "1AA05479A95D5BD8B976401AEBB8CCDE", hash_generated_field = "4BEF45F462B015434130A5D403F569CF")

    static int WEBCORE_NEED_TOUCH_EVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "FAF53D01BEE8944F7215354C856F468D", hash_generated_field = "C36DD12153FC66400C009B4B0FE6EE41")

    static int INVAL_RECT_MSG_ID = 117;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "F47CC7CACF8E20748A09BD16E3A63C93", hash_generated_field = "1EA87CB6B889A1105DC9B47C1D060DD9")

    static int REQUEST_KEYBOARD = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "6DC3FF7954CA1B8684172C35663F6018", hash_generated_field = "68E1112F1F593F669229DB070E25CDA1")

    static int DO_MOTION_UP = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "003B744EDA0119EC87BE6E2D37CC9FD0", hash_generated_field = "6A5ED92794C8A977F9A9E43CFA998E17")

    static int SHOW_FULLSCREEN = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "6916AD38396C039CF7A2A9D6861B5AF3", hash_generated_field = "EAFAFFFDC33CC49FE094DC6971410D80")

    static int HIDE_FULLSCREEN = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "9566E946872EB8E7E6449806A9DF33D9", hash_generated_field = "250A8D5D239B821AE3C48F14ACD67B29")

    static int DOM_FOCUS_CHANGED = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "2EF259B427BB991D0C937BFB2BE3C42B", hash_generated_field = "AD6368FFF2D3CCC3BC742A488FD63022")

    static int REPLACE_BASE_CONTENT = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.471 -0400", hash_original_field = "8F6D1F23B16393627AFD799A33AAFF06", hash_generated_field = "1D014582D60F6D2259A37FBD43DE5B77")

    static int FORM_DID_BLUR = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "2EC1934D71D80965F1B69F5FF6FED113", hash_generated_field = "3B57BA025670625B794DA49794CC6B01")

    static int RETURN_LABEL = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "AEB0E9A0D786D281759570E1D3D1AF21", hash_generated_field = "0BED49EB73C5A889BA65CB9C6FF24A85")

    static int FIND_AGAIN = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "5B535484FC890961BE35B4A3205AA615", hash_generated_field = "DEEB14A5C70081666D75D3E41B80EE27")

    static int CENTER_FIT_RECT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "A7D2B49B5AE9081B8DDDD83C00736EE3", hash_generated_field = "BAA3A2D7CDC723F2F621E8B7DD938400")

    static int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "C7E93A778889DDC7932BAEEB5BCEE567", hash_generated_field = "1323AFE87D3BF5120D94C81CFD52ABD7")

    static int SET_SCROLLBAR_MODES = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "B3177134897C8DFFA9BAB5BA3C05B8B7", hash_generated_field = "7A008D815946AB8D12F758F023F51330")

    static int SELECTION_STRING_CHANGED = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "CA6D15AAF79CDD46037E73B025B37834", hash_generated_field = "B53542F9F3D2BE6BF0E98D549085F251")

    static int SET_TOUCH_HIGHLIGHT_RECTS = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "2EA3BEAA3C901DC2BB377FB00BECFE92", hash_generated_field = "7D664DBCF2AA3B3F29367991ADEF145B")

    static int SAVE_WEBARCHIVE_FINISHED = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "50AB73069C58FAC296166BC532CB5760", hash_generated_field = "EC087557632F0D4AE3E4FE7D0582163B")

    static int SET_AUTOFILLABLE = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "0A1BEFD7E68E18BF9CC202EF323666D4", hash_generated_field = "0842AC463818D6E40B26CC577860FC45")

    static int AUTOFILL_COMPLETE = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "E7E3A002FB23C3217F9D944DEA5F5B54", hash_generated_field = "0A72998E2B0A472F7952AFD3980FC5CD")

    static int SELECT_AT = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "3A8C6A82BDA7D9C95C7EFB68018C9372", hash_generated_field = "88F31CFBA3E83A0EFEB04A27092C46CE")

    static int SCREEN_ON = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "E361A725E223177E8552B43A81658190", hash_generated_field = "150F57589441739BD60DA231682C98FC")

    static int ENTER_FULLSCREEN_VIDEO = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "204186BCD7E786A5A01B660759D544CF", hash_generated_field = "8F9DE48243C35D7E3B5132A8436BB2A1")

    static int UPDATE_SELECTION = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "BFE5627CEC722F03BA59FF5AF23934A4", hash_generated_field = "3CE79BD0D9A3495D2878AB6C21B2105C")

    static int UPDATE_ZOOM_DENSITY = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "AFEBA1F2632AD4DE0C180140E8F1E592", hash_generated_field = "35717F258D8A128541D207F844BFA3A9")

    private static int FIRST_PACKAGE_MSG_ID = SCROLL_TO_MSG_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "071F2F9C86F5CED219B8D50D1677ECBC", hash_generated_field = "6FE84A3DFF320B3F2F009616213E0686")

    private static int LAST_PACKAGE_MSG_ID = SET_TOUCH_HIGHLIGHT_RECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "F8621D1D7316FE89A39C049148B16B1D", hash_generated_field = "A156FF045CE1D36ABE6E4C7DC2D82C73")

    static String[] HandlerPrivateDebugString = {
        "REMEMBER_PASSWORD", 
        "NEVER_REMEMBER_PASSWORD", 
        "SWITCH_TO_SHORTPRESS", 
        "SWITCH_TO_LONGPRESS", 
        "RELEASE_SINGLE_TAP", 
        "REQUEST_FORM_DATA", 
        "RESUME_WEBCORE_PRIORITY", 
        "DRAG_HELD_MOTIONLESS", 
        "AWAKEN_SCROLL_BARS", 
        "PREVENT_DEFAULT_TIMEOUT", 
        "SCROLL_SELECT_TEXT" 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "E469D0A32FE5EEFBB04FAC2135540B9A", hash_generated_field = "8F381BE8D1B09F377BA82D2EAA750293")

    static String[] HandlerPackageDebugString = {
        "SCROLL_TO_MSG_ID", 
        "102", 
        "103", 
        "104", 
        "NEW_PICTURE_MSG_ID", 
        "UPDATE_TEXT_ENTRY_MSG_ID", 
        "WEBCORE_INITIALIZED_MSG_ID", 
        "UPDATE_TEXTFIELD_TEXT_MSG_ID", 
        "UPDATE_ZOOM_RANGE", 
        "UNHANDLED_NAV_KEY", 
        "CLEAR_TEXT_ENTRY", 
        "UPDATE_TEXT_SELECTION_MSG_ID", 
        "SHOW_RECT_MSG_ID", 
        "LONG_PRESS_CENTER", 
        "PREVENT_TOUCH_ID", 
        "WEBCORE_NEED_TOUCH_EVENTS", 
        "INVAL_RECT_MSG_ID", 
        "REQUEST_KEYBOARD", 
        "DO_MOTION_UP", 
        "SHOW_FULLSCREEN", 
        "HIDE_FULLSCREEN", 
        "DOM_FOCUS_CHANGED", 
        "REPLACE_BASE_CONTENT", 
        "FORM_DID_BLUR", 
        "RETURN_LABEL", 
        "FIND_AGAIN", 
        "CENTER_FIT_RECT", 
        "REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID", 
        "SET_SCROLLBAR_MODES", 
        "SELECTION_STRING_CHANGED", 
        "SET_TOUCH_HIGHLIGHT_RECTS", 
        "SAVE_WEBARCHIVE_FINISHED", 
        "SET_AUTOFILLABLE", 
        "AUTOFILL_COMPLETE", 
        "SELECT_AT", 
        "SCREEN_ON", 
        "ENTER_FULLSCREEN_VIDEO", 
        "UPDATE_SELECTION", 
        "UPDATE_ZOOM_DENSITY" 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "B0207B3D1F105BD4C6FF1DFB3397F6BE", hash_generated_field = "56CC945B71F79817609A4DF93D3AD828")

    static int DEFAULT_VIEWPORT_WIDTH = 980;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "C7C52A666164DF7B3E364496B072FA1B", hash_generated_field = "38CEEAAAB3790DFAD8857A5E87A0E5A9")

    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "EFE4F3F527E58E1F472661269CB21F20", hash_generated_field = "D41F0EF6B0D06D4A13D74AC7FE7AD45F")

    private static int SNAP_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "40DB83FCE6FE454744F6D2EA70F24618", hash_generated_field = "215220FBA24D5690414AD8A354CD251B")

    private static int SNAP_LOCK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.472 -0400", hash_original_field = "1173B417EA85A1FE1B2816EC3B3B9805", hash_generated_field = "C14D10CECF4EDBE03B6A46F58F6B9AE0")

    private static int SNAP_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "80C11D80611607FDE87E0C854EDA9C19", hash_generated_field = "F3776A162BFDB821AFAEA1CC35251704")

    private static int SNAP_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "4662EDB02CABDC9825DB87E85EA0A479", hash_generated_field = "5D6D8AF18C49A3F86C6E7FA2584B8106")

    private static int DRAW_EXTRAS_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "03D3C784194DBDDB8EF2D8674C4CB97E", hash_generated_field = "0C1949DC0180FB2850FA8DB92EF9B7DC")

    private static int DRAW_EXTRAS_FIND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "13C056443A8265E118C25957CACC59A9", hash_generated_field = "D435A1EEA4541941AEB0973818A8C4C3")

    private static int DRAW_EXTRAS_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "72B04644BE104633F973AB39BEFF1D92", hash_generated_field = "357F9A81E7EE0E09433B45337E278136")

    private static int DRAW_EXTRAS_CURSOR_RING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "94CE3CC595BF8C31C237A3991205B7A7", hash_generated_field = "F09BBA7676B86D31627968C89DC97959")

    private static int SCROLLBAR_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "08412D589FB359281E6F51BDCD28A4F1", hash_generated_field = "0CC7F51FE405412E9DFA7C00FAA9FC8E")

    private static int SCROLLBAR_ALWAYSOFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "05E7871F3F6659B23C0E3D2C6201072C", hash_generated_field = "D9D9EEA6FF35475FC2CB9B3C4E96C5F2")

    private static int SCROLLBAR_ALWAYSON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "1AFD361CD4099877E4EE1B9DBAB07A29", hash_generated_field = "3E4B9537BC1EEEA236BF130470F7FC34")

    private static int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "DA7BB58AAB3614069121B03E82B783E3", hash_generated_field = "D695EF20F0424518D580BABCC5C73CAF")

    private static int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "A737E64624713D057C27854F572D03CE", hash_generated_field = "D56BDEF46D38685023A3575381103CCD")

    private static int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "FD3BAC1D0E0B96B8A53C06BB67C68A8F", hash_generated_field = "79A71E576E4F27E91A4AFFBACE38D872")

    private static String ALIAS_ACCESSIBILITY_JS_INTERFACE = "accessibility";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "2F570EB1C0B5AF92ED302A83FC29354A", hash_generated_field = "98351C7BF42667334B5DB065240BD0A9")

    private static String ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT = "javascript:(function() {" +
        "    var chooser = document.createElement('script');" +
        "    chooser.type = 'text/javascript';" +
        "    chooser.src = 'https://ssl.gstatic.com/accessibility/javascript/android/AndroidScriptChooser.user.js';" +
        "    document.getElementsByTagName('head')[0].appendChild(chooser);" +
        "  })();";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "B5113A5B1DAE52AA872D7A1E0158A2B6", hash_generated_field = "4FE2D74A51F4E6DE9D3EEB0878DA0390")

    private static String PATTERN_MATCH_AXS_URL_PARAMETER = "(\\?axs=(0|1))|(&axs=(0|1))";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "4207D404B869699B69E8B9A28FF0112D", hash_generated_field = "0B476E3CCACC629DB9A3D288788EC4D4")

    static boolean mLogEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "B932813E6159962053C79AB9C0A459E5", hash_generated_field = "EED2A629500C8CA0653CD2F48FDAD9D7")

    private static boolean sNotificationsEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "FD797E3F2ECF357959667B87D54163F3", hash_generated_field = "1105526185EEB7FC5A898096FC617896")

    public static final String SCHEME_TEL = "tel:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "225D791BAFA68A3EC0D62F0726E1C7DB", hash_generated_field = "36F5F4D1322A91FC8551EC5BF47D4080")

    public static final String SCHEME_MAILTO = "mailto:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "95B5491231B2BD8A25696C3FDBF06E01", hash_generated_field = "7B183832849E08B748A127FC4F00AF3D")

    public static final String SCHEME_GEO = "geo:0,0?q=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "051179065C958003073ADEEFBDE35A13", hash_generated_field = "92926BA0A9D920C6FA6BAC54700DC236")

    private static long SELECT_SCROLL_INTERVAL = 1000 / 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "8E886A75D21BC0A8EDA5A50DD2A2B661", hash_generated_field = "E9A626874BEA31BC13B6B41907D72FD5")

    private static boolean mIncrementEGLContextHack = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "05C1F221F8421AA338F917FB17984ED7", hash_generated_field = "4EA311A46057E2E819D49F1C54EBACAA")

    private static ProxyReceiver sProxyReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "B04F1E80E74352FC14B6E673A4415CE7", hash_generated_field = "BE2C046AC7C6AC534B7DCBF692384BF9")

    private static boolean sPackageInstallationReceiverAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "D4FB0BB6CF479A72D29BD86B9884DB2C", hash_generated_field = "D793892490DD0E214DB1F20B155AEC44")

    private static Set<String> sGoogleApps;
    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "4D9F0ACF100BF12F3249E38226B0B830", hash_generated_field = "C3B92A556D2B9F3B35BC3BC05435A314")

    private static int FULLY_ON_SCREEN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "B3DAEF4CBC835FE704F50BAB24E8A713", hash_generated_field = "511D953E79D4F6678293A7F2B95D82B0")

    private static int INTERSECTS_SCREEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "7D0FC8807A6DAD03A3EEF8D4870C9F1C", hash_generated_field = "EE5E0DEF1C7210896CF2E8A78A1EEC7E")

    private static int ANYWHERE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.473 -0400", hash_original_field = "33C657D7990E0880732140E3FDF51E3B", hash_generated_field = "5769EE32C6D2C10B6BEDBD1541FD7E1F")

    private static int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "81B6014E51F8640F4C3BE886B84FFC2F", hash_generated_field = "9C1499B9E339541A42AA653BBD39CE12")

    private static int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "143FC8BD92F9F5E41D5B5AA2ACC23EAF", hash_generated_field = "2FB310E450E06BF143D98C0E4E82F048")

    private static float HSLOPE_TO_START_SNAP = .25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "57D22AEB68A352A473B3BB324D0706C6", hash_generated_field = "513107FB8852C0254E7FB218D21558D8")

    private static float HSLOPE_TO_BREAK_SNAP = .4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "37354A8D270C32257C72BE5597FB7279", hash_generated_field = "08EAA55462138815903D8221FF4A7E65")

    private static float VSLOPE_TO_START_SNAP = 1.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "745986FED15EB48957154C828FC231A2", hash_generated_field = "B7C4FC296A0692B1D9DB5266D180A3B3")

    private static float VSLOPE_TO_BREAK_SNAP = .95f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "74A90F27F6687BD7AEDE42DCCF796A92", hash_generated_field = "7B1DAE3D9979B7F1A1F31E4ADAF56D78")

    private static float ANGLE_VERT = 2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "58AA9F4B68153F9977887D7962B27368", hash_generated_field = "8B7BE7FEBC87CF05893EF36473B40240")

    private static float ANGLE_HORIZ = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "4A747B48E4EBAF042963963238305567", hash_generated_field = "2E1845A72C6F89B4D1519B0147947733")

    private static float MMA_WEIGHT_N = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "9F27E3A2EA0479B09454B6F4F4C36594", hash_generated_field = "CEC61D06B8E3047B33C95B8A4A7341CD")

    private static int DRAG_LAYER_FINGER_DISTANCE = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "94CF454460F3D9B267AD1D71FC1B9BF2", hash_generated_field = "E5D8A1E8B9071E358CBF08680BDB4CD2")

    private static int TRACKBALL_KEY_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "D17AF2C8459C9B012E8B75A161A5E702", hash_generated_field = "A87D274D7A1A61DE6706E242F0008E38")

    private static int TRACKBALL_TIMEOUT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "AD0F5C36BF5024E1632C3A949A30653F", hash_generated_field = "B811025888C18EE8FA4B39707AA4BB61")

    private static int TRACKBALL_WAIT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "8598DD7F0E8E1CF6A80EFC6EE9950550", hash_generated_field = "91CD774365794032CC997781A3FDFDD2")

    private static int TRACKBALL_SCALE = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "2417DDD0E0F947309A148BA8C5E5E454", hash_generated_field = "48FF663B140404740588AF7CF7737BA3")

    private static int TRACKBALL_SCROLL_COUNT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "C28FA06E3FF6020B796AC6D6D435CCBE", hash_generated_field = "71A336155704F216B54AF4965003E06E")

    private static int TRACKBALL_MOVE_COUNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "B90911B82DAA7EFF1DCFDF49CEFDEC81", hash_generated_field = "3CAEF66B58D11105BBC82464DDDC8579")

    private static int TRACKBALL_MULTIPLIER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "52736B1F2556D5D3FE54D29A35887B61", hash_generated_field = "8B4805485A4F7CD9EE8BCE669DCAC950")

    private static int SELECT_CURSOR_OFFSET = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "81637AAEC67A193923C7C5B16D17CE5D", hash_generated_field = "103DB1C686C0A609643E61C83F1B3D4F")

    private static int SELECT_SCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:08.474 -0400", hash_original_field = "08F02E86CCFB75F0CC70FDFDEBC67BF2", hash_generated_field = "682356E4869FF6FD4ADAA36FD92ABA70")

    static int NO_LEFTEDGE = -1;
}

