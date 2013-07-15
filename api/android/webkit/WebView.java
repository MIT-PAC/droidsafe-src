package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "F9F7A5E45113174158FDC3089D6C6283", hash_generated_field = "6CC6F5C62728D3C43873C2A6A3501E11")

    private InnerGlobalLayoutListener mGlobalLayoutListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "0E0493252E026C6EA3F70ED0CEA041F3", hash_generated_field = "FD3918832A54C40DD17CB93DF3C9E96F")

    private InnerScrollChangedListener mScrollChangedListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "283494DD2489884EBB23EB11D733BBAA", hash_generated_field = "AD74579540B42D36D4D6B2635A693432")

    private boolean mAutoRedraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "631EA221F424C96FC79D8EF82B96482B", hash_generated_field = "7D5C951A42871D1563A5277A77D69AA0")

    private AlertDialog mListBoxDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "1DCBF34BD649218E7E7E803AE2E625E3", hash_generated_field = "36ADFB8E74B62C4DEE5D800A76CE9C6D")

    private final Rect mGLRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "7884AA5B33C53128E178BF578BDB1C5A", hash_generated_field = "FB5FB956134A1E202B8B65301622285A")

    private final Rect mViewRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "6E968EC3CE4F44C293C8CC1068A55218", hash_generated_field = "51BDAF2CD4D275E8CED0563368F453CE")

    private final RectF mVisibleContentRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "58BC8D59DE819547D473EF71E61BA24F", hash_generated_field = "6BED6DB5622AA2BCDA57E6A48F00385A")

    private boolean mGLViewportEmpty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "1229A917B4D1D7ED185029644D045D14", hash_generated_field = "B46B2FBDC77E7FD9B4E8141E1595B5DC")

    private SslCertificate mCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "CAA038815C3D0F5CB3961BAB79010E61", hash_generated_field = "2BD5B1AE4AB832378640307848134713")

    private int mNativeClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "81AD246FEEE7A484C6193AF867C6EF00", hash_generated_field = "51FF718FA193A9082443FB458F488215")

    final Handler mPrivateHandler = new PrivateHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.301 -0400", hash_original_field = "F87E097FF47BA15D994C901A5A6D99A5", hash_generated_field = "AFC642D7CC3CCD87E0FAB3BD2F752688")

    private WebTextView mWebTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "9456149C71095D688A9DAD35901D5775", hash_generated_field = "CE8894D1C6FD3CAD90CF4E2DA3FDFD51")

    private int mTextGeneration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "E0A5EC485E1AB1339DCAF115AA8CA6AB", hash_generated_field = "998C24A93F5A243548630A07FBEEBABF")

    ViewManager mViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "8736C5FCC696BB24A7172AFF742B5642", hash_generated_field = "E9614F2B38AB4DEABFFB87F7486CC59B")

    PluginFullScreenHolder mFullScreenHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "86DEF530EB8B5EC2AE73B42C569FD23E", hash_generated_field = "BD4968058047E8092403B263696B6E7C")

    private int mLastTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "39477E387A7C3E4961468DBE4905BD45", hash_generated_field = "69A36CEAFC0963888AC8B4ED2F6D4978")

    private int mLastTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "3EBA7D9209AD375AB705928FB27FBC2B", hash_generated_field = "4D8D56CD18597A03E84AFA3541D74E0F")

    private int mStartTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "B83D230CA90AA46F0C6A30E0AAC3CB3B", hash_generated_field = "CEF59ED5F74695F1C489B12BA9877E2B")

    private int mStartTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "1CD1134B2ECCABF83DF9A5F9EF7AD3D9", hash_generated_field = "5C401664BB9D608028617F5EDF66E2AF")

    private float mAverageAngle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "97232569F8A97636E52CBF699FA36058", hash_generated_field = "47C433080713997997212745A4983F8F")

    private long mLastTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "BEE1113C77861A2600AB5722E55AA68B", hash_generated_field = "0990A940DEEA6D528A067E6EA87B7F9C")

    private long mLastSentTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "F6A36EBCCDACC91845D214DEBFD2393F", hash_generated_field = "561D6233D1FB6E93F053BC05FD8FA507")

    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "507D8F8387EDC230B54D84A5AD8E5830")

    VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "91DDB870C2F2A4ADB7E5CD21262D80AB", hash_generated_field = "F4AD22AFC08761D5F541EC696D9C09FE")

    private int mMaximumFling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "2576CD7ADC881F56890EF9B827984445", hash_generated_field = "36A6D141DB1FFF457C16610ED5D633AD")

    private float mLastVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "38861757C9935B722CDBC8FAA59326C8", hash_generated_field = "C0F88FE2C7B9E7C7BB7B21BE6A587FCF")

    private float mLastVelX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "A7C0A582CF6C6FEDA681D202ABEFCD38", hash_generated_field = "28065D974B22FD4A98645752CE5547CF")

    private float mLastVelY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "91572FA34BDD6F68B726B50C83FB5238", hash_generated_field = "607EC8CFE97408F4374FF8F7ACABB92F")

    private int mCurrentScrollingLayerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "2A1146D1F64188A252C8E3346E729DDB", hash_generated_field = "2C565358915D9304934306126B23D037")

    private Rect mScrollingLayerRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "461524481BA85E1763B9C327D56C2779", hash_generated_field = "066849BFFA66413DA55C64140E71033C")

    private int mTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "B48B34463BD947BC8FA39E87FA3940DF", hash_generated_field = "A09D145690CCE7A19F079502BA967C9A")

    private boolean mForwardTouchEvents = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "DF19140A515EFFD1E2B2BC58874945B7", hash_generated_field = "E1D1C001302DE5375C735E7EF10D1D17")

    private int mPreventDefault = PREVENT_DEFAULT_IGNORE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "00424BCD47A1D1F32C7A4DCCF85229CA", hash_generated_field = "7A19B98B2EFB8BB31AEC747F1CA41B97")

    private boolean mConfirmMove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "00B4977EA0CCB7CE00BDFAF3F868B20F", hash_generated_field = "BFA5428ED65131EF1CA223DF188A1122")

    private boolean mDeferTouchProcess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "B054F7035076C1AC0991A455B3154B5A", hash_generated_field = "9F890F647D029D28EDDE18F99565D3EC")

    private int mDeferTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "5D2AA10D50C57E3B997C5B872BD919DA", hash_generated_field = "0B464B8324C284C9331034B27020C3DF")

    private float mLastDeferTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "FE45999F6371D9229F7127CEE75A1CE3", hash_generated_field = "BB913DF57D5D59E382435C22DB0D167C")

    private float mLastDeferTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "733138DD0E6826F705B37E7B22FD49C1", hash_generated_field = "1AAAA5D187A798CA7E8F507E98CEFDFE")

    boolean mDragFromTextInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "DAD3A38A52F21026BBC341FAA256F725", hash_generated_field = "73F680AEDB48E6ACAF7DB5B88D2B7A20")

    private boolean mDrawCursorRing = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "E5E0AF0CF7EBA0195F7043E5E0A523EC", hash_generated_field = "4940A67E026325EBC1382989DD930EDC")

    private boolean mIsPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "319A7C3B614BC1472DF37FFF84145BC0", hash_generated_field = "9F291EA33B1111436C86DAFA7D749E10")

    private HitTestResult mInitialHitTestResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.302 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "1E242EFC2D09358FD71C3C1F7213838B", hash_generated_field = "3648C260E562DC86BDAAC7F94E7352D4")

    private int mNavSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "73C5E2D5ECE0EA511A9594C461C19390", hash_generated_field = "B290C2276932B172EE2AB0CAFBE30BAE")

    boolean mWidthCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "D476D4A439B1ACBFD02CFE299CF64FB4", hash_generated_field = "61DC23F447FF0AD3EC3A81B971B9006E")

    boolean mHeightCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "B7A225A89985C2F4AD49415356B283C2", hash_generated_field = "0A23B55D1A7DFF5E5D35E13264ADE9DE")

    int mLastWidthSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "5C861C15724C8416BEC6F0FCF23FE8C7", hash_generated_field = "DC0C48A78A79993E34C7065A16800A42")

    int mLastHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "95E3B6E798315DEF186341A6887424F3", hash_generated_field = "03CB436788BF47F35B484535A1648867")

    int mLastActualHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "8CAE9DDC87DDEC99A752E150A6F5EE2F", hash_generated_field = "5F8C94CB44AF6FE0EF7A765D1E3AFD13")

    private int mContentWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "1E54F53AE3E1C8B8A15A951BCE77B126", hash_generated_field = "9218818BF270D645A91FA187FE0DB745")

    private boolean mOverlayHorizontalScrollbar = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "CD5EA9067C416EBE91DDE5675BE3BA1B", hash_generated_field = "C373EF1100F74B3BFFFB5DEE30CCBD07")

    private boolean mOverlayVerticalScrollbar = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "63F6CA74EEC786DAEE7A49BF47815C33")

    OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "E56E9228A5AACA55E31613E7D75FBAC2", hash_generated_field = "3C483E4AA361608032CA95612E8DD525")

    private boolean mInOverScrollMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "7B0FA1257BD698096D1B4055A23524FB", hash_generated_field = "DC1AD28F6DE5AE5C8271D33DC8A73FB4")

    private boolean mWrapContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "2CD2F011886EB329722C01D53AAD1158", hash_generated_field = "9FDC3D0BB72A7D1D7962780902257BB3")

    private int mHeldMotionless;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "501651D2D9CDF82EB68647AFA394001A", hash_generated_field = "0EF707A46ED94117316BA91515555C35")

    private AccessibilityInjector mAccessibilityInjector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "9B2A884FD52D291BA7C8707BFD34EE95", hash_generated_field = "8427EB0277906CD3E949E13293EBEFB6")

    private boolean mAccessibilityScriptInjected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "2B2A7D23B49A9F6C312AFA3CB2DE3E9C", hash_generated_field = "61AC3E065C8F6175E76224FE4B7A0FF2")

    private Region mTextSelectionRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "4B4DC0386BBEFEBC172968A7DC512309", hash_generated_field = "BD311CF93A193EF9001A97A5DA8FE989")

    private Paint mTextSelectionPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "F005B92875383CAF2D0DB91BD5A06195", hash_generated_field = "19F67E28C78216AF79F5581C6BC23DEC")

    private Region mTouchHighlightRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "1CD5876DA908B551FE7B696524AAF1CE", hash_generated_field = "FA05D517E862A9B2474EE135EA332D18")

    private Paint mTouchHightlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "621C5AE5845066BF4D6199BCBECC6B1D", hash_generated_field = "CCDC3EB9EBCFF4D16ABA2CE80EB3455A")

    private Paint mTouchCrossHairColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "FA58B09EC58295EE657C6DB007ACFBC3", hash_generated_field = "1735D38F75F52C24227B746378768B7B")

    private int mTouchHighlightX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "0382BD0FE846CC0A70AF1041656AB97E", hash_generated_field = "44E768B9D358A889E8F0FC8017DD211E")

    private int mTouchHighlightY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "759C5A16C191C0BE465C99BF80A22070", hash_generated_field = "BCDAE3999FBCFDE5BC7A1BE619AB74DD")

    private long mTouchHighlightRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "DD91CBEAFCEF912983FE3661E07D2F39", hash_generated_field = "B9D740536C60C6D670F313EEADBF93E0")

    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "96860C09A1BA3099AD8D1DF6F1CBC12B", hash_generated_field = "D395AA199126908FEE3B0F46BA4F9C62")

    private boolean mBlockWebkitViewMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "17569E5D7AFEAF1F09675CAFEE70AC45", hash_generated_field = "0E203AC987BF40A8DEA081542906FFB5")

    private int mInitialScaleInPercent = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.303 -0400", hash_original_field = "96C56F8983B9F3C60DFD313C8334C7F2", hash_generated_field = "C15F1FC7F9EA7829C177678DC8510856")

    private boolean mSendScrollEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "C33D97725BC57DA6085707EA571DC635", hash_generated_field = "006CA1330A69406C602E466B10C43D72")

    private int mSnapScrollMode = SNAP_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "3E6B71038C2F931B40871ADC21100E0A", hash_generated_field = "761337948FA4302FD3F9FCADBD7D6775")

    private boolean mSnapPositive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "6A001518D701D6CB7B53ADEF55E3DE3F", hash_generated_field = "E5F7424044C4D04F0D77F776582A67ED")

    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "82FBFD1714C191943520823A75AEA1E2", hash_generated_field = "4A97F423DAA345C75890FCC344743D6F")

    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "4CDBB0B2FA9CF742D95CBF19A618E45C", hash_generated_field = "4036B77E67867608087C8B2F001B55D5")

    private TextToSpeech mTextToSpeech;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "BD6DEF1112239E4FD783977C03835AC3", hash_generated_field = "1642D7423FB15C64A4AAEE8A9C5243AD")

    private Pattern mMatchAxsUrlParameterPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "12FFA59C64ABCA100CADAD14F3FD0971", hash_generated_field = "8B88748678D320254190188B25A37155")

    private OverScrollGlow mOverScrollGlow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "253CDCFA3EDA8CD5A1C74364F08744EB", hash_generated_field = "6DAF40C63FBB9494FA268E54C51A621E")

    private Vector<Integer> mKeysPressed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "9A53CADB33F5EF303A655D0610777BC3", hash_generated_field = "5D52BE334296C573389C0CB6810E8EF8")

    private long mLastTouchUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "1AF983C29060F075D25F478B9AD3B9FF", hash_generated_field = "EF5F7F128924D81624F7C082EE5C57AB")

    private WebViewCore.AutoFillData mAutoFillData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "1CDAE4CD4FD9DD53B530C97864727050", hash_generated_field = "72384577DFC3FC75A8B033CE6FF0A482")

    private int mBackgroundColor = Color.WHITE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "1E1680EF469A58DE61BC02D7AFF61B2E", hash_generated_field = "ABB6666AC59D2544A6D12F224E33C262")

    private int mAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "270BCD801986623A11031595AB527ABF", hash_generated_field = "A4B68D036567B21BC4865DE6F61A2F9B")

    private int mAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "02BDCA068C258B2AE7788247D564611A", hash_generated_field = "D6CD5D682502282E9E072F16ACF14D05")

    private int mMinAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "641BB905CC99A501F0B0F8356763995C", hash_generated_field = "DC36203DB61C91E1CACF31ED43B3363B")

    private int mMaxAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "25F76E58B1DE86A232329EAD37D8C757", hash_generated_field = "57F79EF124C5DBD88EF9E9E66F10A308")

    private int mMinAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "691CA821B0A61C2E346F0E8E6011C386", hash_generated_field = "CE9836AC2A30ED3AE38A49B2B5FD58DC")

    private int mMaxAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "0FAB21F904D8725647FA51D825321CFE", hash_generated_field = "C04A6808A8A8B578AE175BC815BEE12B")

    private Rect mScrollingLayerBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "17862449FB2B442EDC276FAB4B340E0E", hash_generated_field = "D0A94ECA1348E1AFEFD396947BC74CA0")

    private boolean mSentAutoScrollMessage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "51E582AA9ED1103B99D1859ED86F2854", hash_generated_field = "A3939324652696BBD6D583F09CF597D7")

    private final TouchEventQueue mTouchEventQueue = new TouchEventQueue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "FC1A1C2CFC7559351BA0746CF8CD1A87", hash_generated_field = "333D865FCED73682C738B5A705E887AA")

    private boolean mPictureUpdatePausedForFocusChange = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "5F766E69223CE3A2DD6353FDB4DA4646", hash_generated_field = "4A0FE46DD2984BED2A76807E9415B4B3")

    private PictureListener mPictureListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "E18B289B1AA9BF6AD41D419FE01ECF5C", hash_generated_field = "4EFDB68AF38CE1FE479B1628CB5C7FFE")

    private int mCachedOverlappingActionModeHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "786E4D2F6EFE89D31565DA0FBE9E6BFF", hash_generated_field = "3E16AF791F0C585BB692C30369E75608")

    private View mTitleBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.304 -0400", hash_original_field = "8A19A8B2E6CC6A8D99F96047D8675D0D", hash_generated_field = "82DF3ED5B282B44B1689BB6A67100AAF")

    private int mTitleGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "A522C70E18CD127AD691E6C09162B718", hash_generated_field = "CC333D0F8AD8FFDB25F1E8D239DE82EF")

    private Rect mLastVisibleRectSent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "87BDD77C765BA4E430F3B4163B2BF16A", hash_generated_field = "9D8EB240679F63D7259D12AA2646AE20")

    private Rect mLastGlobalRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "C986798C734C496FF0C3E00A9F0B3B1C", hash_generated_field = "DBEA6A01B6683DAB3422424D4E5AF629")

    private Rect mVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "67FC07F6472A7CF0FC43C91CA1D4DE06", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "89FE35C70477102B77E7D54111929F5B", hash_generated_field = "F65CE097DE2BD38B5640202605D44DCF")

    private Point mScrollOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "182F4E4C854FDC192EE5021ED6D73891", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "C4180242D5623216D09A451DBE43E063", hash_generated_field = "E9C8FCC78A563BE608DAE1158D0138F1")

    private Rect mContentVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "199407FA51469180784ACB4D27639417", hash_generated_field = "18201BE28AF4897CDDE04B91A8BAC40D")

    private FindActionModeCallback mFindCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "F1DB086181F0CAC01A724E5F6A7B01A7", hash_generated_field = "339E62FC94CB6B24EC49EE818A39B374")

    private boolean mFindIsUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "97CF19FB685E1A8A858ED964EA1788D6", hash_generated_field = "B9830F0B5F0F8F825605A44BD1F53A5D")

    private String mLastFind;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "89EE3BF752EA23CCAF0158617873F303", hash_generated_field = "11CC91033432A6D33F6833384C84316E")

    private String mPageThatNeedsToSlideTitleBarOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "7901B46F62AE2A39929FC7686BE3652E", hash_generated_field = "39C14D863975598F1C60036A4E9EC22E")

    private int mYDistanceToSlideTitleOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "981019EBE62A3A536D4CB6BC9F6F8F10", hash_generated_field = "A47FD3369D923B9B9858ECC0900495AB")

    private int mOrientation = Configuration.ORIENTATION_UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "0BC67DE7618E378A590238F274E662F1", hash_generated_field = "CFB51504048F92C552B87D79FF631083")

    private SelectActionModeCallback mSelectCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "F23C74FF3A4CFCDCF12548440968300D", hash_generated_field = "588110A2CFA9E9678107331C0D2C96FA")

    private final DrawFilter mZoomFilter = new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "7FCBABA887C1AA6F4DB8B724B4D064B7", hash_generated_field = "6C99E5AC4C9CFFB5676D7E9B3F3366A7")

    private final DrawFilter mScrollFilter = new PaintFlagsDrawFilter(SCROLL_BITS, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.305 -0400", hash_original_field = "F3965BD9CE5BD1D03F6F6203AE992A4E", hash_generated_field = "51BC097A03E0230FE4DFAD304AA0C022")

    private boolean mDrawHistory = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "A3DEC6AFE03B45A019E4379B3CC37DA6", hash_generated_field = "E6AB03F308839A8ED10716B0A06579B2")

    private Picture mHistoryPicture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "FCAA8D38A90DCCE574CDD58B10BDC3DE", hash_generated_field = "0C64A62751DA7E49704757557E14D916")

    private int mHistoryWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "DE2C97D507C51A2C10B04B06C4A0520E", hash_generated_field = "75F48CB3330D09CEFA904F7B84BDA417")

    private int mHistoryHeight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "683052C48052D547F9C4DC5445DC348E", hash_generated_field = "7C2550436BC0D9C9C62992FF098D00A6")

    private boolean mGotCenterDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "2BCFC118E8C010852ED640AC6552D75C", hash_generated_field = "4552704BCBDED6171FFAB0743A94FADB")

    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "A5876C56A233FC714E9E635000FC8324", hash_generated_field = "C1BDD4A6558DC5330CEE7B5578017A71")

    private long mTrackballFirstTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "4F199D2B7F6B6927B5DB55656A242B98", hash_generated_field = "7A8E9CA6466F4282ADE2CFEAB9543F99")

    private long mTrackballLastTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "6293B146FD282AC72DBA2F0AB6B0AC97", hash_generated_field = "D0AAD41F7AF21E3C814A3CE6751CC65E")

    private float mTrackballRemainsX = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "B2F0B8878F51B0E28A6BEF74822FA868", hash_generated_field = "43DEE62CF8478127489DCB48CC70FD45")

    private float mTrackballRemainsY = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "C7D88DC101403CC24F4E91CFBF164519", hash_generated_field = "7912151F282E7C954771498A3F49BAA2")

    private int mTrackballXMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "03A8324A1166DF2061C66FA4F1B4B614", hash_generated_field = "E884F524A10E52504DC2311DBDFD6B80")

    private int mTrackballYMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "B5FAF4AB270D8A7A37D27E98B4B0DA18", hash_generated_field = "17DE07DD7201E373F3679F7C8E42D936")

    private boolean mSelectingText = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "5CF44BCD23C9689722F24A78A3607960", hash_generated_field = "E66D148FB016EBE0AB6A510827B8EDE8")

    private boolean mSelectionStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "2DC721FB7A3355375D94983913C44B71", hash_generated_field = "A0828D99C4C5AD1E7FE83A66318FB99D")

    private boolean mExtendSelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "66CA05FE0F91FDFE03B5D50C0A49D303", hash_generated_field = "2908E3A71D3F7575EE5D63922F38ADEA")

    private boolean mDrawSelectionPointer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "FCD57EA55C1642A2C24E20C0B62317F7", hash_generated_field = "DF8E0D848DB8117787785920A7B48359")

    private int mSelectX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "9915E013A84779B49E4428F98E4F07FE", hash_generated_field = "FE7922D4E6B26989A17C6608E2D41B9A")

    private int mSelectY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "4CDBF52C30D68AEC1295EF779063DEAE", hash_generated_field = "F7FF545538C9AFAAB77E510B3626B30E")

    private boolean mFocusSizeChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "BDBAF306CE7923A2CD4FBC04A8D8990B", hash_generated_field = "9FA6435FA400DA07C2707641944C195D")

    private boolean mTrackballDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "15CB522E76D287D5578A77504CB5F3BF", hash_generated_field = "7F383DE2FB2467193D38739089AE9AA7")

    private long mTrackballUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "02AA2026C10F3BF98FC17F7FD0E5857A", hash_generated_field = "36CFD91777BA610BB27907D3ED4B1532")

    private long mLastCursorTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "E56966E13D19AF45D41D8A9B8A5BB828", hash_generated_field = "628DA4E196378CFBF1F4C373208CA500")

    private Rect mLastCursorBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "4CAE411D150BF4CB8D1C810C5FF6BB7E", hash_generated_field = "448727DCE5669EFD2A0C0572D1060E63")

    private boolean mMapTrackballToArrowKeys = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "105553D6B610F07A7928FCC8D847A035", hash_generated_field = "AD498406B1DE6FEBF53F73747731D143")

    private DrawData mDelaySetPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "AA72F0DA830E064FB42B03478A210C1D", hash_generated_field = "200C54AE573D3744441934A403CEA512")

    private DrawData mLoadedPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_field = "79ABB18FC2CD6E346A08940B8816FEAD", hash_generated_field = "0BBC35906DDA57724DA9629F2934A2C3")

    private Message mListBoxMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.306 -0400", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "76CCE6E01409674C3B15972BB599643B")
    public  WebView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.307 -0400", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "0842CF8367472FB0E7D586ECE2B49A5E")
    public  WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.307 -0400", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "FEA05CE45ADE51A0AC46DBADB2CA041D")
    public  WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.307 -0400", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "907EFE28E97C78509DA41774F5D94750")
    public  WebView(Context context, AttributeSet attrs, int defStyle,
            boolean privateBrowsing) {
        this(context, attrs, defStyle, null, privateBrowsing);
        addTaint(privateBrowsing);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.307 -0400", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "68CA141E7210398B5A037C72FC3F83AF")
    protected  WebView(Context context, AttributeSet attrs, int defStyle,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyle);
        addTaint(privateBrowsing);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        checkThread();
    if(context == null)        
        {
            IllegalArgumentException varAC5E05FF553C8C13AE75F63CC8B0F24F_976153226 = new IllegalArgumentException("Invalid context argument");
            varAC5E05FF553C8C13AE75F63CC8B0F24F_976153226.addTaint(taint);
            throw varAC5E05FF553C8C13AE75F63CC8B0F24F_976153226;
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
    if(privateBrowsing)        
        {
            startPrivateBrowsing();
        } //End block
        mAutoFillData = new WebViewCore.AutoFillData();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.307 -0400", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "C219C46BFE188BCD99CF5769D824C1F6")
     void incrementTextGeneration() {
        mTextGeneration++;
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

    
        @DSModeled(DSC.SPEC)
    private static void handleProxyBroadcast(Intent intent) {
        ProxyProperties proxyProperties = (ProxyProperties)intent.getExtra(Proxy.EXTRA_PROXY_INFO);
        if (proxyProperties == null || proxyProperties.getHost() == null) {
            WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, null);
            return;
        }
        WebViewCore.sendStaticMessage(EventHub.PROXY_CHANGED, proxyProperties);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.308 -0400", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "F6ED3F63B1747EA4644FE561FE95869C")
    private void setupPackageListener(Context context) {
        addTaint(context.getTaint());
        synchronized
(WebView.class)        {
    if(sPackageInstallationReceiverAdded)            
            {
                return;
            } //End block
            IntentFilter filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addDataScheme("package");
            BroadcastReceiver packageListener = new PackageListener();
            context.getApplicationContext().registerReceiver(packageListener, filter);
            sPackageInstallationReceiverAdded = true;
        } //End block
        AsyncTask<Void, Void, Set<String>> task = new AsyncTask<Void, Void, Set<String>>() {
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.308 -0400", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "C26C5F5A1EDFA0CEC7F41B1D31308CDF")
     void updateMultiTouchSupport(Context context) {
        addTaint(context.getTaint());
        mZoomManager.updateMultiTouchSupport(context);
        // ---------- Original Method ----------
        //mZoomManager.updateMultiTouchSupport(context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.308 -0400", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "E456EE68EC1B170793E8BFABDE86BD08")
    private void init() {
        OnTrimMemoryListener.init(getContext());
        setWillNotDraw(false);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        setLongClickable(true);
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        int slop = configuration.getScaledTouchSlop();
        mTouchSlopSquare = slop * slop;
        slop = configuration.getScaledDoubleTapSlop();
        mDoubleTapSlopSquare = slop * slop;
        final float density = getContext().getResources().getDisplayMetrics().density;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.309 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "BE7C7F55C9A647443C0DD0EBE3ADFFAD")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean varB326B5062B2F0E69046810717534CB09_1875680477 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823784401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823784401;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.309 -0400", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "CBC15F32650CA4C4EE8A2C2946C4B9D5")
    private void addAccessibilityApisToJavaScript() {
    if(AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled())        
        {
            final Context ctx = getContext();
    if(ctx != null)            
            {
                final String packageName = ctx.getPackageName();
    if(packageName != null)                
                {
                    mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            packageName + ".**webview**");
                    addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.309 -0400", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "C87B12841E3C33774E498D7DE73A0BF8")
    private void removeAccessibilityApisFromJavaScript() {
    if(mTextToSpeech != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.309 -0400", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "CCE25516215BEF5A13742772D73EB947")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfo(info);
        //info.setScrollable(isScrollableForAccessibility());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.310 -0400", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "E723E6C8FF00B96CAF493A3647F611ED")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(isScrollableForAccessibility());
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        final int convertedContentWidth = contentToViewX(getContentWidth());
        final int adjustedViewWidth = getWidth() - mPaddingLeft - mPaddingRight;
        event.setMaxScrollX(Math.max(convertedContentWidth - adjustedViewWidth, 0));
        final int convertedContentHeight = contentToViewY(getContentHeight());
        final int adjustedViewHeight = getHeight() - mPaddingTop - mPaddingBottom;
        event.setMaxScrollY(Math.max(convertedContentHeight - adjustedViewHeight, 0));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.310 -0400", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "E1FDF31C297C45384E02A33297A99394")
    private boolean isScrollableForAccessibility() {
        boolean var89081E46DAC03FF56CD7E128BF677BF2_721630652 = ((contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1896091910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1896091910;
        // ---------- Original Method ----------
        //return (contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                //|| contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.310 -0400", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "EE5E5FF6D4D4FA212811EB0C72394E75")
    @Override
    public void setOverScrollMode(int mode) {
        addTaint(mode);
        super.setOverScrollMode(mode);
    if(mode != OVER_SCROLL_NEVER)        
        {
    if(mOverScrollGlow == null)            
            {
                mOverScrollGlow = new OverScrollGlow(this);
            } //End block
        } //End block
        else
        {
            mOverScrollGlow = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.310 -0400", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "B08B267119E7673111581DEDEBE1615E")
     void adjustDefaultZoomDensity(int zoomDensity) {
        addTaint(zoomDensity);
        final float density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //final float density = mContext.getResources().getDisplayMetrics().density
                //* 100 / zoomDensity;
        //updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.310 -0400", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "688F1816A2901C03B061988243CC1670")
     void updateDefaultZoomDensity(float density) {
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
        // ---------- Original Method ----------
        //mNavSlop = (int) (16 * density);
        //mZoomManager.updateDefaultZoomDensity(density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.312 -0400", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "EA4E04CA12057E3CA3F48EAC247FC778")
     boolean onSavePassword(String schemePlusHost, String username,
            String password, final Message resumeMsg) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resumeMsg.getTaint());
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(schemePlusHost.getTaint());
        boolean rVal = false;
    if(resumeMsg == null)        
        {
            mDatabase.setUsernamePassword(schemePlusHost, username, password);
        } //End block
        else
        {
            final Message remember = mPrivateHandler.obtainMessage(
                    REMEMBER_PASSWORD);
            remember.getData().putString("host", schemePlusHost);
            remember.getData().putString("username", username);
            remember.getData().putString("password", password);
            remember.obj = resumeMsg;
            final Message neverRemember = mPrivateHandler.obtainMessage(
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.311 -0400", hash_original_method = "99DE72360AB23E9BF4985BE8ED3FB8CE", hash_generated_method = "F8E9258B2EC56E8EED034B4EC6B530CC")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            resumeMsg.sendToTarget();
            // ---------- Original Method ----------
            //resumeMsg.sendToTarget();
        }
})
                    .setNeutralButton(com.android.internal.R.string.save_password_remember,
                    new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.311 -0400", hash_original_method = "BC12A66C673827B889B0C1DFB7251A66", hash_generated_method = "21E265B2B315700F71FF854722D7E1AE")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            remember.sendToTarget();
            // ---------- Original Method ----------
            //remember.sendToTarget();
        }
})
                    .setNegativeButton(com.android.internal.R.string.save_password_never,
                    new DialogInterface.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.312 -0400", hash_original_method = "873315778F761CDAFA793A9437C366FC", hash_generated_method = "655385BAF479CC155D4C5865BD5AF0AD")
        public void onClick(DialogInterface dialog, int which) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(which);
            addTaint(dialog.getTaint());
            neverRemember.sendToTarget();
            // ---------- Original Method ----------
            //neverRemember.sendToTarget();
        }
})
                    .setOnCancelListener(new OnCancelListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.312 -0400", hash_original_method = "93C3AC18FD9E5633ABD9F836EA5CC3F9", hash_generated_method = "C0DC9A6363B937FC5E40684F9FB7668E")
        public void onCancel(DialogInterface dialog) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(dialog.getTaint());
            resumeMsg.sendToTarget();
            // ---------- Original Method ----------
            //resumeMsg.sendToTarget();
        }
}).show();
            rVal = true;
        } //End block
        boolean var20508299B85163673D9F87606948A577_809642911 = (rVal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043135685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043135685;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.313 -0400", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "B6E22B207C8CBC20FD2F97270BD83157")
    @Override
    public void setScrollBarStyle(int style) {
        addTaint(style);
    if(style == View.SCROLLBARS_INSIDE_INSET
                || style == View.SCROLLBARS_OUTSIDE_INSET)        
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        } //End block
        else
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        } //End block
        super.setScrollBarStyle(style);
        // ---------- Original Method ----------
        //if (style == View.SCROLLBARS_INSIDE_INSET
                //|| style == View.SCROLLBARS_OUTSIDE_INSET) {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        //} else {
            //mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        //}
        //super.setScrollBarStyle(style);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.313 -0400", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "49957A37EDFF2774BB0F59A959CBDB39")
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayHorizontalScrollbar = overlay;
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayHorizontalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.313 -0400", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "B9F69862443AC26CC9A977C090485865")
    public void setVerticalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayVerticalScrollbar = overlay;
        // ---------- Original Method ----------
        //checkThread();
        //mOverlayVerticalScrollbar = overlay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.313 -0400", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "0EC4EE361C685144050D9C917025FB56")
    public boolean overlayHorizontalScrollbar() {
        checkThread();
        boolean var7125F777BF001EA0D59C54225ACCF48B_506940458 = (mOverlayHorizontalScrollbar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301927426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301927426;
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayHorizontalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.313 -0400", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "CEEA0A3234AF6AD913FF55153177397F")
    public boolean overlayVerticalScrollbar() {
        checkThread();
        boolean var14C75D8FD51FE61AB27348919F43BDC1_178456932 = (mOverlayVerticalScrollbar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253827457 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253827457;
        // ---------- Original Method ----------
        //checkThread();
        //return mOverlayVerticalScrollbar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "35B7F6AD5469EBB2B6163789D5D1D769")
     int getViewWidth() {
    if(!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar)        
        {
            int var36131DBB2E2F5BCF2181A419796EF343_1496033630 = (getWidth());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926962097 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1926962097;
        } //End block
        else
        {
            int var9EE8071874AB7DE11E1FA914B8A42AEA_990529576 = (Math.max(0, getWidth() - getVerticalScrollbarWidth()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443106661 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443106661;
        } //End block
        // ---------- Original Method ----------
        //if (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar) {
            //return getWidth();
        //} else {
            //return Math.max(0, getWidth() - getVerticalScrollbarWidth());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "8BAB579CDF7BC7DF636557EE1D2340BE")
    protected int getTitleHeight() {
        int var1782B77706C8C279D43ACD4F95E9C886_1898156456 = (mTitleBar != null ? mTitleBar.getHeight() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496543307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1496543307;
        // ---------- Original Method ----------
        //return mTitleBar != null ? mTitleBar.getHeight() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "BEA5889CA78EF0808E7A4E526FA0CA5D")
    public int getVisibleTitleHeight() {
        checkThread();
        int varE6162E44C751F43A820FFCE5B03E8672_1178059783 = (getVisibleTitleHeightImpl());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017630006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017630006;
        // ---------- Original Method ----------
        //checkThread();
        //return getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "1CA3D45E3A784A0032D42481DCAD82D6")
    private int getVisibleTitleHeightImpl() {
        int var2490DF7F50692E1CC7BD2AF5CB809A97_97176596 = (Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180973546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180973546;
        // ---------- Original Method ----------
        //return Math.max(getTitleHeight() - Math.max(0, mScrollY),
                //getOverlappingActionModeHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "A7898B8B66E0A70C292D5120F30996B4")
    private int getOverlappingActionModeHeight() {
    if(mFindCallback == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1767344208 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388904742 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388904742;
        } //End block
    if(mCachedOverlappingActionModeHeight < 0)        
        {
            getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            mCachedOverlappingActionModeHeight = Math.max(0,
                    mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        } //End block
        int var2B40A5211BE79A3994F2BA561CF603EB_458928994 = (mCachedOverlappingActionModeHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248680750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248680750;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.314 -0400", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "38A3F9167DBA9191DBE5D500DD296D9C")
     int getViewHeight() {
        int var40137606306AA861F99E67B85BAAABB4_1712605489 = (getViewHeightWithTitle() - getVisibleTitleHeightImpl());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065812986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2065812986;
        // ---------- Original Method ----------
        //return getViewHeightWithTitle() - getVisibleTitleHeightImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "C0CD8D41B69602D2171DDE16B9BCEE23")
     int getViewHeightWithTitle() {
        int height = getHeight();
    if(isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar)        
        {
            height -= getHorizontalScrollbarHeight();
        } //End block
        int varB435E227D5DD201E1768B2BCB2E0AA81_834086773 = (height);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229956717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229956717;
        // ---------- Original Method ----------
        //int height = getHeight();
        //if (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar) {
            //height -= getHorizontalScrollbarHeight();
        //}
        //return height;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "7939280B0E75F2101DC9A48BFB02A558")
    public SslCertificate getCertificate() {
        checkThread();
SslCertificate varAD9FB3E799180A1D9497E2C35C2EA89C_1464966798 =         mCertificate;
        varAD9FB3E799180A1D9497E2C35C2EA89C_1464966798.addTaint(taint);
        return varAD9FB3E799180A1D9497E2C35C2EA89C_1464966798;
        // ---------- Original Method ----------
        //checkThread();
        //return mCertificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "D801B2BE4E6E9186E0F244936B2A21A7")
    public void setCertificate(SslCertificate certificate) {
        checkThread();
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        mCertificate = certificate;
        // ---------- Original Method ----------
        //checkThread();
        //if (DebugFlags.WEB_VIEW) {
            //Log.v(LOGTAG, "setCertificate=" + certificate);
        //}
        //mCertificate = certificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "89BF763A224C9836A90C3707969D2F42")
    public void savePassword(String host, String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(host.getTaint());
        checkThread();
        mDatabase.setUsernamePassword(host, username, password);
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setUsernamePassword(host, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "C3FB5B9DF727CAF7EF4EEBE31B898D15")
    public void setHttpAuthUsernamePassword(String host, String realm,
            String username, String password) {
        addTaint(password.getTaint());
        addTaint(username.getTaint());
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        checkThread();
        mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
        // ---------- Original Method ----------
        //checkThread();
        //mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "0B4A42F821D7BD104FB587146E1E0E64")
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        addTaint(realm.getTaint());
        addTaint(host.getTaint());
        checkThread();
String[] var03EB5852932B926CB5C056A344A2B894_1173299124 =         mDatabase.getHttpAuthUsernamePassword(host, realm);
        var03EB5852932B926CB5C056A344A2B894_1173299124.addTaint(taint);
        return var03EB5852932B926CB5C056A344A2B894_1173299124;
        // ---------- Original Method ----------
        //checkThread();
        //return mDatabase.getHttpAuthUsernamePassword(host, realm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "AF8A1EA68559CB35AF988427C5466C6A")
    private void clearActionModes() {
    if(mSelectCallback != null)        
        {
            mSelectCallback.finish();
        } //End block
    if(mFindCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.315 -0400", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "448F915BE7E908A0F655BF91243B2A40")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.316 -0400", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "7A297DB81FDF9086ECA2BB196BA7091C")
    private void cancelSelectDialog() {
    if(mListBoxDialog != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.316 -0400", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "38021AB430F2F37CB9A4606BEC6303C5")
    public void destroy() {
        checkThread();
        destroyImpl();
        // ---------- Original Method ----------
        //checkThread();
        //destroyImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.316 -0400", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "CA14FEEACA12F54C0865F36AE9D438B4")
    private void destroyImpl() {
        clearHelpers();
    if(mListBoxDialog != null)        
        {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        } //End block
    if(mWebTextView != null)        
        {
            mWebTextView.remove();
            mWebTextView = null;
        } //End block
    if(mNativeClass != 0)        
        nativeStopGL();
    if(mWebViewCore != null)        
        {
            mCallbackProxy.setWebViewClient(null);
            mCallbackProxy.setWebChromeClient(null);
            synchronized
(this)            {
                WebViewCore webViewCore = mWebViewCore;
                mWebViewCore = null;
                webViewCore.destroy();
            } //End block
            mPrivateHandler.removeCallbacksAndMessages(null);
            mCallbackProxy.removeCallbacksAndMessages(null);
            synchronized
(mCallbackProxy)            {
                mCallbackProxy.notify();
            } //End block
        } //End block
    if(mNativeClass != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.316 -0400", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "9223DD2C15D7902C4F58FF85BA927871")
    public void setJsFlags(String flags) {
        addTaint(flags.getTaint());
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.316 -0400", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "42860AE97485F9BC37D65E3947A362A9")
    public void setNetworkAvailable(boolean networkUp) {
        addTaint(networkUp);
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                networkUp ? 1 : 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                //networkUp ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.317 -0400", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "20DDF4F810B2CA0A26A4F969AA7B3B5F")
    public void setNetworkType(String type, String subtype) {
        addTaint(subtype.getTaint());
        addTaint(type.getTaint());
        checkThread();
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("subtype", subtype);
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
        // ---------- Original Method ----------
        //checkThread();
        //Map<String, String> map = new HashMap<String, String>();
        //map.put("type", type);
        //map.put("subtype", subtype);
        //mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.317 -0400", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "8E4F477017C09EE687C273EFB90B5035")
    public WebBackForwardList saveState(Bundle outState) {
        addTaint(outState.getTaint());
        checkThread();
    if(outState == null)        
        {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_487491678 =             null;
            var540C13E9E156B687226421B24F2DF178_487491678.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_487491678;
        } //End block
        WebBackForwardList list = copyBackForwardList();
        final int currentIndex = list.getCurrentIndex();
        final int size = list.getSize();
    if(currentIndex < 0 || currentIndex >= size || size == 0)        
        {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_1391015023 =             null;
            var540C13E9E156B687226421B24F2DF178_1391015023.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1391015023;
        } //End block
        outState.putInt("index", currentIndex);
        ArrayList<byte[]> history = new ArrayList<byte[]>(size);
for(int i = 0;i < size;i++)
        {
            WebHistoryItem item = list.getItemAtIndex(i);
    if(null == item)            
            {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_2095781738 =                 null;
                var540C13E9E156B687226421B24F2DF178_2095781738.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2095781738;
            } //End block
            byte[] data = item.getFlattenedData();
    if(data == null)            
            {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_1235554743 =                 null;
                var540C13E9E156B687226421B24F2DF178_1235554743.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1235554743;
            } //End block
            history.add(data);
        } //End block
        outState.putSerializable("history", history);
    if(mCertificate != null)        
        {
            outState.putBundle("certificate",
                               SslCertificate.saveState(mCertificate));
        } //End block
        outState.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(outState);
WebBackForwardList varED12C351C2E8CA4F85F097DDC7E77B4D_1483558989 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1483558989.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1483558989;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.318 -0400", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "3BDF7285EDB75BF2988B50D7129FD417")
    @Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        addTaint(dest.getTaint());
        addTaint(b.getTaint());
        checkThread();
    if(dest == null || b == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1738215029 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1230487751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1230487751;
        } //End block
        final Picture p = capturePicture();
        final File temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.318 -0400", hash_original_method = "71F2765D1125FA36D6758E11ABE47081", hash_generated_method = "14C6C07BEC2882E62E634063A3228922")
        public void run() {
            FileOutputStream out = null;
            try 
            {
                out = new FileOutputStream(temp);
                p.writeToStream(out);
                temp.renameTo(dest);
            } //End block
            catch (Exception e)
            {
            } //End block
            finally 
            {
    if(out != null)                
                {
                    try 
                    {
                        out.close();
                    } //End block
                    catch (Exception e)
                    {
                    } //End block
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
        boolean varB326B5062B2F0E69046810717534CB09_591370540 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_201265748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_201265748;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.318 -0400", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "30089A070CE7B5F5E815718ED541E6B8")
    private void restoreHistoryPictureFields(Picture p, Bundle b) {
        addTaint(b.getTaint());
        int sx = b.getInt("scrollX", 0);
        int sy = b.getInt("scrollY", 0);
        mDrawHistory = true;
        mHistoryPicture = p;
        mScrollX = sx;
        mScrollY = sy;
        mZoomManager.restoreZoomState(b);
        final float scale = mZoomManager.getScale();
        mHistoryWidth = Math.round(p.getWidth() * scale);
        mHistoryHeight = Math.round(p.getHeight() * scale);
        invalidate();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.319 -0400", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "5D7256A969BBBBB08C6964B2148155EE")
    @Deprecated
    public boolean restorePicture(Bundle b, File src) {
        addTaint(src.getTaint());
        addTaint(b.getTaint());
        checkThread();
    if(src == null || b == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_344398845 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787218701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_787218701;
        } //End block
    if(!src.exists())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2013130594 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357595413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_357595413;
        } //End block
        try 
        {
            final FileInputStream in = new FileInputStream(src);
            final Bundle copy = new Bundle(b);
            new Thread(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.319 -0400", hash_original_method = "724A0503E9DDAB096FD7727D625B3A77", hash_generated_method = "B7192EC9AD303DAAB5E9695BA8F18635")
        public void run() {
            try 
            {
                final Picture p = Picture.createFromStream(in);
    if(p != null)                
                {
                    mPrivateHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.319 -0400", hash_original_method = "C56555B2959C7B009BAA3230DF6B18BD", hash_generated_method = "99D4A60111AD5243B646F29DC3E7007E")
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
                {
                } //End block
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
        boolean varB326B5062B2F0E69046810717534CB09_679760970 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1570956123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1570956123;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.319 -0400", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "91294C65764F631F8C4CCC7B3AF8DA7B")
    public boolean saveViewState(OutputStream stream) {
        addTaint(stream.getTaint());
        try 
        {
            boolean var2DB0C2108328008A496B628B399CB45B_1584844850 = (ViewStateSerializer.serializeViewState(stream, this));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659927873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659927873;
        } //End block
        catch (IOException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_249179114 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1475417232 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1475417232;
        // ---------- Original Method ----------
        //try {
            //return ViewStateSerializer.serializeViewState(stream, this);
        //} catch (IOException e) {
            //Log.w(LOGTAG, "Failed to saveViewState", e);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.320 -0400", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "F8F53FA420A11868B752546C3A534E04")
    public boolean loadViewState(InputStream stream) {
        try 
        {
            mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            mBlockWebkitViewMessages = true;
            setNewPicture(mLoadedPicture, true);
            mLoadedPicture.mViewState = null;
            boolean varB326B5062B2F0E69046810717534CB09_1798248432 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368798914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_368798914;
        } //End block
        catch (IOException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1605023576 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115360342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115360342;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.320 -0400", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "732621B4DF183E8125FE78ECB6DCCC1E")
    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
        // ---------- Original Method ----------
        //mBlockWebkitViewMessages = false;
        //mLoadedPicture = null;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.321 -0400", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "0A0F0BEA06E0C0A3E0E79C15EBA60BED")
    public WebBackForwardList restoreState(Bundle inState) {
        checkThread();
        WebBackForwardList returnList = null;
    if(inState == null)        
        {
WebBackForwardList var195207CFC264788B20A079C8C3E1371E_44542504 =             returnList;
            var195207CFC264788B20A079C8C3E1371E_44542504.addTaint(taint);
            return var195207CFC264788B20A079C8C3E1371E_44542504;
        } //End block
    if(inState.containsKey("index") && inState.containsKey("history"))        
        {
            mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));
            final WebBackForwardList list = mCallbackProxy.getBackForwardList();
            final int index = inState.getInt("index");
            synchronized
(list)            {
                final List<byte[]> history = (List<byte[]>) inState.getSerializable("history");
                final int size = history.size();
    if(index < 0 || index >= size)                
                {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_1683167817 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1683167817.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1683167817;
                } //End block
for(int i = 0;i < size;i++)
                {
                    byte[] data = history.remove(0);
    if(data == null)                    
                    {
WebBackForwardList var540C13E9E156B687226421B24F2DF178_1958978075 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1958978075.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1958978075;
                    } //End block
                    WebHistoryItem item = new WebHistoryItem(data);
                    list.addHistoryItem(item);
                } //End block
                returnList = copyBackForwardList();
                returnList.setCurrentIndex(index);
            } //End block
    if(inState.getBoolean("privateBrowsingEnabled"))            
            {
                getSettings().setPrivateBrowsingEnabled(true);
            } //End block
            mZoomManager.restoreZoomState(inState);
            mWebViewCore.removeMessages();
            mWebViewCore.sendMessage(EventHub.RESTORE_STATE, index);
        } //End block
WebBackForwardList var195207CFC264788B20A079C8C3E1371E_459665746 =         returnList;
        var195207CFC264788B20A079C8C3E1371E_459665746.addTaint(taint);
        return var195207CFC264788B20A079C8C3E1371E_459665746;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.321 -0400", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "CE5F5812341DAC96950CAC4442F925B4")
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        addTaint(additionalHttpHeaders.getTaint());
        addTaint(url.getTaint());
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url, additionalHttpHeaders);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.321 -0400", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "9305BEA489F539449E5A0FAE31171954")
    private void loadUrlImpl(String url, Map<String, String> extraHeaders) {
        addTaint(extraHeaders.getTaint());
        addTaint(url.getTaint());
        switchOutDrawHistory();
        WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        arg.mUrl = url;
        arg.mExtraHeaders = extraHeaders;
        mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        clearHelpers();
        // ---------- Original Method ----------
        //switchOutDrawHistory();
        //WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        //arg.mUrl = url;
        //arg.mExtraHeaders = extraHeaders;
        //mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        //clearHelpers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.321 -0400", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "62BF212BD9003A7D97865864687A7E0A")
    public void loadUrl(String url) {
        addTaint(url.getTaint());
        checkThread();
        loadUrlImpl(url);
        // ---------- Original Method ----------
        //checkThread();
        //loadUrlImpl(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.321 -0400", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "34116C8C359F11AADA18FB983643CED6")
    private void loadUrlImpl(String url) {
        addTaint(url.getTaint());
    if(url == null)        
        {
            return;
        } //End block
        loadUrlImpl(url, null);
        // ---------- Original Method ----------
        //if (url == null) {
            //return;
        //}
        //loadUrlImpl(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "1051B44E09623DC1CE27FA2E0D800D19")
    public void postUrl(String url, byte[] postData) {
        addTaint(postData[0]);
        addTaint(url.getTaint());
        checkThread();
    if(URLUtil.isNetworkUrl(url))        
        {
            switchOutDrawHistory();
            WebViewCore.PostUrlData arg = new WebViewCore.PostUrlData();
            arg.mUrl = url;
            arg.mPostData = postData;
            mWebViewCore.sendMessage(EventHub.POST_URL, arg);
            clearHelpers();
        } //End block
        else
        {
            loadUrlImpl(url);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "DF54346D8128F19A61E66E6D9CA23EE9")
    public void loadData(String data, String mimeType, String encoding) {
        addTaint(encoding.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(data.getTaint());
        checkThread();
        loadDataImpl(data, mimeType, encoding);
        // ---------- Original Method ----------
        //checkThread();
        //loadDataImpl(data, mimeType, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "8D01EBAA3CB7E1F417CE09C1451A3788")
    private void loadDataImpl(String data, String mimeType, String encoding) {
        addTaint(encoding.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(data.getTaint());
        StringBuilder dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
    if("base64".equals(encoding))        
        {
            dataUrl.append(";base64");
        } //End block
        dataUrl.append(",");
        dataUrl.append(data);
        loadUrlImpl(dataUrl.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "94FFCD8C6A2038690D48F1755659FA81")
    public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        addTaint(historyUrl.getTaint());
        addTaint(encoding.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(data.getTaint());
        addTaint(baseUrl.getTaint());
        checkThread();
    if(baseUrl != null && baseUrl.toLowerCase().startsWith("data:"))        
        {
            loadDataImpl(data, mimeType, encoding);
            return;
        } //End block
        switchOutDrawHistory();
        WebViewCore.BaseUrlData arg = new WebViewCore.BaseUrlData();
        arg.mBaseUrl = baseUrl;
        arg.mData = data;
        arg.mMimeType = mimeType;
        arg.mEncoding = encoding;
        arg.mHistoryUrl = historyUrl;
        mWebViewCore.sendMessage(EventHub.LOAD_DATA, arg);
        clearHelpers();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "89874483DE523A525B953B755544C01B")
    public void saveWebArchive(String filename) {
        addTaint(filename.getTaint());
        checkThread();
        saveWebArchiveImpl(filename, false, null);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(filename, false, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.322 -0400", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "F816C0F5273F33F3F2F4B77D59582DAF")
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        addTaint(callback.getTaint());
        addTaint(autoname);
        addTaint(basename.getTaint());
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
        // ---------- Original Method ----------
        //checkThread();
        //saveWebArchiveImpl(basename, autoname, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.324 -0400", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "0F34E29BF0EB968E3DDD220D35A2DB57")
    private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        addTaint(callback.getTaint());
        addTaint(autoname);
        addTaint(basename.getTaint());
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            //new SaveWebArchiveMessage(basename, autoname, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.324 -0400", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "2C395E4AC53467FAD68E24848E941787")
    public void stopLoading() {
        checkThread();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
        // ---------- Original Method ----------
        //checkThread();
        //switchOutDrawHistory();
        //mWebViewCore.sendMessage(EventHub.STOP_LOADING);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.324 -0400", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "8F4D6179589A516B470113791CFEE8A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.325 -0400", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "EED45022CB188D93B701665FD9279772")
    public boolean canGoBack() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized
(l)        {
    if(l.getClearPending())            
            {
                boolean var68934A3E9455FA72420237EB05902327_918289202 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819733380 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_819733380;
            } //End block
            else
            {
                boolean var3B88FE12DF307E1A8BBA25E9BC0E4B8E_63436730 = (l.getCurrentIndex() > 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52046578 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_52046578;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.325 -0400", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "63D2353E5F881AC0C773B9FBCC91A18D")
    public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.325 -0400", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "668CA45E8E18FDABF7331B6D3BA65E49")
    public boolean canGoForward() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized
(l)        {
    if(l.getClearPending())            
            {
                boolean var68934A3E9455FA72420237EB05902327_521657632 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105309413 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_105309413;
            } //End block
            else
            {
                boolean var7B11DA70DC5BDE5511225C4F7F0A899B_2099509143 = (l.getCurrentIndex() < l.getSize() - 1);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_918592762 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_918592762;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.325 -0400", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "7DBF91244690F3215087518F21FF9C8A")
    public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.325 -0400", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "E015C55C7663F33B482C9B6CD041A15F")
    public boolean canGoBackOrForward(int steps) {
        addTaint(steps);
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        synchronized
(l)        {
    if(l.getClearPending())            
            {
                boolean var68934A3E9455FA72420237EB05902327_2023962413 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749096590 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749096590;
            } //End block
            else
            {
                int newIndex = l.getCurrentIndex() + steps;
                boolean var42F0607CE86ACFDAB80CEFAB95795FF7_1901178132 = (newIndex >= 0 && newIndex < l.getSize());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684043026 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684043026;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.326 -0400", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "0592AB772E0C75B029344C3397777D30")
    public void goBackOrForward(int steps) {
        addTaint(steps);
        checkThread();
        goBackOrForwardImpl(steps);
        // ---------- Original Method ----------
        //checkThread();
        //goBackOrForwardImpl(steps);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.326 -0400", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "F1ED7B5476353BE797B931EE1FB0917B")
    private void goBackOrForwardImpl(int steps) {
        addTaint(steps);
        goBackOrForward(steps, false);
        // ---------- Original Method ----------
        //goBackOrForward(steps, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.327 -0400", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "73115BA9BF55F2C5B3504951A54768CE")
    private void goBackOrForward(int steps, boolean ignoreSnapshot) {
        addTaint(ignoreSnapshot);
        addTaint(steps);
    if(steps != 0)        
        {
            clearHelpers();
            mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    ignoreSnapshot ? 1 : 0);
        } //End block
        // ---------- Original Method ----------
        //if (steps != 0) {
            //clearHelpers();
            //mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    //ignoreSnapshot ? 1 : 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.327 -0400", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "DDB0D943E851903E86A5917FF13C729D")
    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        boolean var4606A522ACC7152B3EBB8AC3A8C6586F_715627722 = (getSettings().isPrivateBrowsingEnabled());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195809622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195809622;
        // ---------- Original Method ----------
        //checkThread();
        //return getSettings().isPrivateBrowsingEnabled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.327 -0400", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "07E57C68BA1FFA2F79AE67648A8B3103")
    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
        // ---------- Original Method ----------
        //getSettings().setPrivateBrowsingEnabled(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.327 -0400", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "F99F47977A3FCF18AA715B7B59E2AD92")
    private boolean extendScroll(int y) {
        addTaint(y);
        int finalY = mScroller.getFinalY();
        int newY = pinLocY(finalY + y);
    if(newY == finalY)        
        {
        boolean var68934A3E9455FA72420237EB05902327_196691191 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915388977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915388977;
        }
        mScroller.setFinalY(newY);
        mScroller.extendDuration(computeDuration(0, y));
        boolean varB326B5062B2F0E69046810717534CB09_1482988094 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156334266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156334266;
        // ---------- Original Method ----------
        //int finalY = mScroller.getFinalY();
        //int newY = pinLocY(finalY + y);
        //if (newY == finalY) return false;
        //mScroller.setFinalY(newY);
        //mScroller.extendDuration(computeDuration(0, y));
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.328 -0400", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "0B1E8A75C79A73F4B14760BD550615C4")
    public boolean pageUp(boolean top) {
        addTaint(top);
        checkThread();
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1443925763 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635167431 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635167431;
        } //End block
        nativeClearCursor();
    if(top)        
        {
            boolean var4C59CAD36443284539DFFCDC6A016F9F_1490752929 = (pinScrollTo(mScrollX, 0, true, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482261281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482261281;
        } //End block
        int h = getHeight();
        int y;
    if(h > 2 * PAGE_SCROLL_OVERLAP)        
        {
            y = -h + PAGE_SCROLL_OVERLAP;
        } //End block
        else
        {
            y = -h / 2;
        } //End block
        boolean varFB2115E4282FB616CF377AF9D4C14F6E_241019098 = (mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                : extendScroll(y));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787839059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_787839059;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.329 -0400", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "C8694CF4607533A5915A451621750518")
    public boolean pageDown(boolean bottom) {
        addTaint(bottom);
        checkThread();
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1176144039 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674426483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674426483;
        } //End block
        nativeClearCursor();
    if(bottom)        
        {
            boolean var61F114FD73DBBFFAA34F73862B820C63_1164543463 = (pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410129459 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_410129459;
        } //End block
        int h = getHeight();
        int y;
    if(h > 2 * PAGE_SCROLL_OVERLAP)        
        {
            y = h - PAGE_SCROLL_OVERLAP;
        } //End block
        else
        {
            y = h / 2;
        } //End block
        boolean varFB2115E4282FB616CF377AF9D4C14F6E_1181767721 = (mScroller.isFinished() ? pinScrollBy(0, y, true, 0)
                : extendScroll(y));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763813819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763813819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.329 -0400", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "96502640F44EE6B02C635F6CE1A50F1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.330 -0400", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "3CCC1F3DA960EFB8FBD81EE2F7A89B58")
    public Picture capturePicture() {
        checkThread();
    if(mNativeClass == 0)        
        {
Picture var540C13E9E156B687226421B24F2DF178_361734208 =         null;
        var540C13E9E156B687226421B24F2DF178_361734208.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_361734208;
        }
        Picture result = new Picture();
        nativeCopyBaseContentToPicture(result);
Picture varDC838461EE2FA0CA4C9BBB70A15456B0_1764803728 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1764803728.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1764803728;
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0) return null;
        //Picture result = new Picture();
        //nativeCopyBaseContentToPicture(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.330 -0400", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "0E2201900E58AA39520F047AFCF28D88")
    private boolean inEditingMode() {
        boolean varBCFB33807603EBACC728D135FFFC721A_2056858119 = (mWebTextView != null && mWebTextView.getParent() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1288097760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1288097760;
        // ---------- Original Method ----------
        //return mWebTextView != null && mWebTextView.getParent() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.330 -0400", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "C103DFC9C405E7F5467898ADD83725D4")
    private void clearTextEntry() {
    if(inEditingMode())        
        {
            mWebTextView.remove();
        } //End block
        else
        {
            hideSoftKeyboard();
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.remove();
        //} else {
            //hideSoftKeyboard();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.331 -0400", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "E78C570246C3B95EF092940821DEA496")
    public float getScale() {
        checkThread();
        float varA024FFAF9C7E592F895A1902C4FD0C82_1972726113 = (mZoomManager.getScale());
                float var546ADE640B6EDFBC8A086EF31347E768_1060084980 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1060084980;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.331 -0400", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "BDC26C867C1D168086A4DEFFBAD8B10C")
     float getTextHandleScale() {
        float density = mContext.getResources().getDisplayMetrics().density;
        float varAC12149A4BA723ADD0C7CF3690500199_1825977096 = (density / getScale());
                float var546ADE640B6EDFBC8A086EF31347E768_678214408 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_678214408;
        // ---------- Original Method ----------
        //float density = mContext.getResources().getDisplayMetrics().density;
        //return density / getScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.331 -0400", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "A96977A492367A0CDCA1647ACB57DCFB")
     float getReadingLevelScale() {
        float var24A56A23FDAF3965CB0BF70AA0A70C43_1428924279 = (mZoomManager.getReadingLevelScale());
                float var546ADE640B6EDFBC8A086EF31347E768_601803286 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_601803286;
        // ---------- Original Method ----------
        //return mZoomManager.getReadingLevelScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.331 -0400", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "D619D8D5BDC027669937895C34BC8E9F")
    public void setInitialScale(int scaleInPercent) {
        addTaint(scaleInPercent);
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
        // ---------- Original Method ----------
        //checkThread();
        //mZoomManager.setInitialScaleInPercent(scaleInPercent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.331 -0400", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "9B3BFA3D077D2FF3D1F358EE3222699F")
    public void invokeZoomPicker() {
        checkThread();
    if(!getSettings().supportZoom())        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.332 -0400", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "1A31AA374ED1A6880128B3A0495634FC")
    public HitTestResult getHitTestResult() {
        checkThread();
HitTestResult var7ECDA7443E0694C3BFCEFC83728CEB93_1144979032 =         hitTestResult(mInitialHitTestResult);
        var7ECDA7443E0694C3BFCEFC83728CEB93_1144979032.addTaint(taint);
        return var7ECDA7443E0694C3BFCEFC83728CEB93_1144979032;
        // ---------- Original Method ----------
        //checkThread();
        //return hitTestResult(mInitialHitTestResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.332 -0400", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "821CA4A8CDE9F3BDB20D6FCB043D7EC2")
    private HitTestResult hitTestResult(HitTestResult fallback) {
        addTaint(fallback.getTaint());
    if(mNativeClass == 0)        
        {
HitTestResult var540C13E9E156B687226421B24F2DF178_1025271208 =             null;
            var540C13E9E156B687226421B24F2DF178_1025271208.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1025271208;
        } //End block
        HitTestResult result = new HitTestResult();
    if(nativeHasCursorNode())        
        {
    if(nativeCursorIsTextInput())            
            {
                result.setType(HitTestResult.EDIT_TEXT_TYPE);
            } //End block
            else
            {
                String text = nativeCursorText();
    if(text != null)                
                {
    if(text.startsWith(SCHEME_TEL))                    
                    {
                        result.setType(HitTestResult.PHONE_TYPE);
                        result.setExtra(text.substring(SCHEME_TEL.length()));
                    } //End block
                    else
    if(text.startsWith(SCHEME_MAILTO))                    
                    {
                        result.setType(HitTestResult.EMAIL_TYPE);
                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                    } //End block
                    else
    if(text.startsWith(SCHEME_GEO))                    
                    {
                        result.setType(HitTestResult.GEO_TYPE);
                        result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                    } //End block
                    else
    if(nativeCursorIsAnchor())                    
                    {
                        result.setType(HitTestResult.SRC_ANCHOR_TYPE);
                        result.setExtra(text);
                    } //End block
                } //End block
            } //End block
        } //End block
        else
    if(fallback != null)        
        {
            result = fallback;
        } //End block
        int type = result.getType();
    if(type == HitTestResult.UNKNOWN_TYPE
                || type == HitTestResult.SRC_ANCHOR_TYPE)        
        {
            int contentX = viewToContentX(mLastTouchX + mScrollX);
            int contentY = viewToContentY(mLastTouchY + mScrollY);
            String text = nativeImageURI(contentX, contentY);
    if(text != null)            
            {
                result.setType(type == HitTestResult.UNKNOWN_TYPE ?
                        HitTestResult.IMAGE_TYPE :
                        HitTestResult.SRC_IMAGE_ANCHOR_TYPE);
                result.setExtra(text);
            } //End block
        } //End block
HitTestResult varDC838461EE2FA0CA4C9BBB70A15456B0_585754064 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_585754064.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_585754064;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.334 -0400", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "2AE6A4D66BA653D228310654E23CB469")
    private void domChangedFocus() {
    if(inEditingMode())        
        {
            mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.335 -0400", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "3E608F6A9DC9AEBB1928B9DEA54A7012")
    public void requestFocusNodeHref(Message hrefMsg) {
        addTaint(hrefMsg.getTaint());
        checkThread();
    if(hrefMsg == null)        
        {
            return;
        } //End block
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
    if(nativeHasCursorNode())        
        {
            Rect cursorBounds = nativeGetCursorRingBounds();
    if(!cursorBounds.contains(contentX, contentY))            
            {
                int slop = viewToContentDimension(mNavSlop);
                cursorBounds.inset(-slop, -slop);
    if(cursorBounds.contains(contentX, contentY))                
                {
                    contentX = (int) cursorBounds.centerX();
                    contentY = (int) cursorBounds.centerY();
                } //End block
            } //End block
        } //End block
        mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                contentX, contentY, hrefMsg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.335 -0400", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "9F2624CC34DB5439EA2E0797462D2A16")
    public void requestImageRef(Message msg) {
        addTaint(msg.getTaint());
        checkThread();
    if(0 == mNativeClass)        
        return;
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        String ref = nativeImageURI(contentX, contentY);
        Bundle data = msg.getData();
        data.putString("url", ref);
        msg.setData(data);
        msg.sendToTarget();
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.338 -0400", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "AABFEB79C5ADC448D58B964E43D3F654")
     int pinLocX(int x) {
        addTaint(x);
    if(mInOverScrollMode)        
        {
        int var9DD4E461268C8034F5C8564E155C67A6_1773890535 = (x);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122480546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1122480546;
        }
        int var5FDDD782EE589204F9FF8F9AD8A76DBA_1926905906 = (pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711961957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711961957;
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return x;
        //return pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.338 -0400", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "FD3844C42E03BF49EF059742003DAE88")
     int pinLocY(int y) {
        addTaint(y);
    if(mInOverScrollMode)        
        {
        int var415290769594460E2E485922904F345D_729876021 = (y);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125480810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1125480810;
        }
        int varD8E51123A7BA7E5284E6EEA74CF49769_408148711 = (pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361318529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1361318529;
        // ---------- Original Method ----------
        //if (mInOverScrollMode) return y;
        //return pinLoc(y, getViewHeightWithTitle(),
                      //computeRealVerticalScrollRange() + getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.339 -0400", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "C08AC918F692EE5538CBD555F43DDF82")
    public void setEmbeddedTitleBar(View v) {
    if(mTitleBar == v)        
        return;
    if(mTitleBar != null)        
        {
            removeView(mTitleBar);
        } //End block
    if(null != v)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.339 -0400", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "105D592E955DBF7BD60D7B2C46CA6B79")
    public void setTitleBarGravity(int gravity) {
        mTitleGravity = gravity;
        invalidate();
        // ---------- Original Method ----------
        //mTitleGravity = gravity;
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.339 -0400", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "E6394C67BC393353B3802778F3707207")
    private int viewToContentDimension(int d) {
        addTaint(d);
        int varFD2912197D86065BB4337FF216333D0C_508443316 = (Math.round(d * mZoomManager.getInvScale()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199729356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1199729356;
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getInvScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "10A7BE6FBE855E17AEAFC5E8B5AF987B")
     int viewToContentX(int x) {
        addTaint(x);
        int varB32E916A9CDFFD1B2DC4D2C996D4D009_1697111791 = (viewToContentDimension(x));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910977009 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910977009;
        // ---------- Original Method ----------
        //return viewToContentDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "16D117CA9AAE42407E10338D09950AC7")
     int viewToContentY(int y) {
        addTaint(y);
        int varC929CE12B72AD2A367A967ABF1480615_1212977366 = (viewToContentDimension(y - getTitleHeight()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119412823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1119412823;
        // ---------- Original Method ----------
        //return viewToContentDimension(y - getTitleHeight());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "ACED9798A825A263EFC8651F7934F9C6")
    private float viewToContentXf(int x) {
        addTaint(x);
        float varD3B3500E485AE5F7EC32256B9DE7518C_1108282955 = (x * mZoomManager.getInvScale());
                float var546ADE640B6EDFBC8A086EF31347E768_309891442 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_309891442;
        // ---------- Original Method ----------
        //return x * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "78E1BC21683BA011FADA7192352D5586")
    private float viewToContentYf(int y) {
        addTaint(y);
        float var0C303002CA1A967A7128E6BC3B820CC3_1808983626 = ((y - getTitleHeight()) * mZoomManager.getInvScale());
                float var546ADE640B6EDFBC8A086EF31347E768_664252947 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_664252947;
        // ---------- Original Method ----------
        //return (y - getTitleHeight()) * mZoomManager.getInvScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "7F6D0DFA3DCA4A2A93598F8A9AFEAB1C")
     int contentToViewDimension(int d) {
        addTaint(d);
        int var51BED05ABDBCACF6925678B939995AE7_57865926 = (Math.round(d * mZoomManager.getScale()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996158101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996158101;
        // ---------- Original Method ----------
        //return Math.round(d * mZoomManager.getScale());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "2D15456CC70171CF32F88149B5E55C4F")
     int contentToViewX(int x) {
        addTaint(x);
        int var11AFDCF8C4C4CC177E044D75A01A324F_885255263 = (contentToViewDimension(x));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744528462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1744528462;
        // ---------- Original Method ----------
        //return contentToViewDimension(x);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "4D1AA69F98D8CD196DF0FA985F89E420")
     int contentToViewY(int y) {
        addTaint(y);
        int var320623E19C0ABCAFD2DD705ABF84E8DC_812959629 = (contentToViewDimension(y) + getTitleHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549995973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549995973;
        // ---------- Original Method ----------
        //return contentToViewDimension(y) + getTitleHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.340 -0400", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "01BED638CF7BFB2AB42918FF548C75E1")
    private Rect contentToViewRect(Rect x) {
        addTaint(x.getTaint());
Rect var93C56F8BA52845EAB4B9C28F88C2ED52_1933032589 =         new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom));
        var93C56F8BA52845EAB4B9C28F88C2ED52_1933032589.addTaint(taint);
        return var93C56F8BA52845EAB4B9C28F88C2ED52_1933032589;
        // ---------- Original Method ----------
        //return new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        //contentToViewX(x.right), contentToViewY(x.bottom));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.341 -0400", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "425C0FBCB3C8F135BB803DEB59B5B10B")
    private void viewInvalidate(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
        invalidate((int)Math.floor(l * scale),
                   (int)Math.floor(t * scale) + dy,
                   (int)Math.ceil(r * scale),
                   (int)Math.ceil(b * scale) + dy);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //invalidate((int)Math.floor(l * scale),
                   //(int)Math.floor(t * scale) + dy,
                   //(int)Math.ceil(r * scale),
                   //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.343 -0400", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "B027B0329FDEA7628C306C53A7C69230")
    private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(delay);
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
        postInvalidateDelayed(delay,
                              (int)Math.floor(l * scale),
                              (int)Math.floor(t * scale) + dy,
                              (int)Math.ceil(r * scale),
                              (int)Math.ceil(b * scale) + dy);
        // ---------- Original Method ----------
        //final float scale = mZoomManager.getScale();
        //final int dy = getTitleHeight();
        //postInvalidateDelayed(delay,
                              //(int)Math.floor(l * scale),
                              //(int)Math.floor(t * scale) + dy,
                              //(int)Math.ceil(r * scale),
                              //(int)Math.ceil(b * scale) + dy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.343 -0400", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "D09A38A9F1750A68BA0E592F6554501A")
    private void invalidateContentRect(Rect r) {
        addTaint(r.getTaint());
        viewInvalidate(r.left, r.top, r.right, r.bottom);
        // ---------- Original Method ----------
        //viewInvalidate(r.left, r.top, r.right, r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.343 -0400", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "5847048DB193138D46100A4DCE1A2FEE")
    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.abortAnimation();
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.343 -0400", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "9F1C3B19EDD62F9F0E65E9CDBFA55A6D")
    private void recordNewContentSize(int w, int h, boolean updateLayout) {
        addTaint(updateLayout);
    if((w | h) == 0)        
        {
            return;
        } //End block
    if(mContentWidth != w || mContentHeight != h)        
        {
            mContentWidth = w;
            mContentHeight = h;
    if(!mDrawHistory)            
            {
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
    if(!mScroller.isFinished())                
                {
                    mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                    mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                } //End block
            } //End block
        } //End block
        contentSizeChanged(updateLayout);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.343 -0400", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "67EFEDBD2B76522DE06C7114C34BE7B1")
     Rect sendOurVisibleRect() {
    if(mZoomManager.isPreventingWebkitUpdates())        
        {
Rect var7A3775FAC262EC2CE2BD77F17390F9EF_1073922524 =         mLastVisibleRectSent;
        var7A3775FAC262EC2CE2BD77F17390F9EF_1073922524.addTaint(taint);
        return var7A3775FAC262EC2CE2BD77F17390F9EF_1073922524;
        }
        calcOurContentVisibleRect(mVisibleRect);
    if(!mVisibleRect.equals(mLastVisibleRectSent))        
        {
    if(!mBlockWebkitViewMessages)            
            {
                mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                mWebViewCore.removeMessages(EventHub.SET_SCROLL_OFFSET);
                mWebViewCore.sendMessage(EventHub.SET_SCROLL_OFFSET,
                        nativeMoveGeneration(), mSendScrollEvent ? 1 : 0, mScrollOffset);
            } //End block
            mLastVisibleRectSent.set(mVisibleRect);
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        } //End block
    if(getGlobalVisibleRect(mGlobalVisibleRect)
                && !mGlobalVisibleRect.equals(mLastGlobalRect))        
        {
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
    if(!mBlockWebkitViewMessages)            
            {
                mWebViewCore.sendMessage(EventHub.SET_GLOBAL_BOUNDS, mGlobalVisibleRect);
            } //End block
            mLastGlobalRect.set(mGlobalVisibleRect);
        } //End block
Rect var3993412C4980019E814D9AE2E8B71F53_607092845 =         mVisibleRect;
        var3993412C4980019E814D9AE2E8B71F53_607092845.addTaint(taint);
        return var3993412C4980019E814D9AE2E8B71F53_607092845;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.345 -0400", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "BEA82C19EC86B67EBF18C29CDAB9151F")
    private void calcOurVisibleRect(Rect r) {
        addTaint(r.getTaint());
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
        // ---------- Original Method ----------
        //getGlobalVisibleRect(r, mGlobalVisibleOffset);
        //r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.345 -0400", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "D7A37EBF374F053F5FE46D83A30C836A")
    private void calcOurContentVisibleRect(Rect r) {
        addTaint(r.getTaint());
        calcOurVisibleRect(r);
        r.left = viewToContentX(r.left);
        r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        r.right = viewToContentX(r.right);
        r.bottom = viewToContentY(r.bottom);
        // ---------- Original Method ----------
        //calcOurVisibleRect(r);
        //r.left = viewToContentX(r.left);
        //r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentX(r.right);
        //r.bottom = viewToContentY(r.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.345 -0400", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "560BD83C7428027B2DCCF7B70EA58A78")
    private void calcOurContentVisibleRectF(RectF r) {
        addTaint(r.getTaint());
        calcOurVisibleRect(mContentVisibleRect);
        r.left = viewToContentXf(mContentVisibleRect.left);
        r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        r.right = viewToContentXf(mContentVisibleRect.right);
        r.bottom = viewToContentYf(mContentVisibleRect.bottom);
        // ---------- Original Method ----------
        //calcOurVisibleRect(mContentVisibleRect);
        //r.left = viewToContentXf(mContentVisibleRect.left);
        //r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        //r.right = viewToContentXf(mContentVisibleRect.right);
        //r.bottom = viewToContentYf(mContentVisibleRect.bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.347 -0400", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "4B41F6460E9944F9A349DE777790D0CC")
     boolean sendViewSizeZoom(boolean force) {
        addTaint(force);
    if(mBlockWebkitViewMessages)        
        {
        boolean var68934A3E9455FA72420237EB05902327_289693646 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803358291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803358291;
        }
    if(mZoomManager.isPreventingWebkitUpdates())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1059796735 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327803778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327803778;
        }
        int viewWidth = getViewWidth();
        int newWidth = Math.round(viewWidth * mZoomManager.getInvScale());
        int viewHeight = getViewHeightWithTitle() - getTitleHeight();
        int newHeight = Math.round(viewHeight * mZoomManager.getInvScale());
        float heightWidthRatio = (float) viewHeight / viewWidth;
    if(newWidth > mLastWidthSent && mWrapContent)        
        {
            newHeight = 0;
            heightWidthRatio = 0;
        } //End block
        int actualViewHeight = Math.round(getViewHeight() * mZoomManager.getInvScale());
    if(newWidth != mLastWidthSent || newHeight != mLastHeightSent || force ||
                actualViewHeight != mLastActualHeightSent)        
        {
            ViewSizeData data = new ViewSizeData();
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
            boolean varB326B5062B2F0E69046810717534CB09_907104352 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2041714036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2041714036;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1578323407 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067759550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067759550;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.349 -0400", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "7399A060EC93F7A04F2BDD6708FBE713")
     void updateDoubleTapZoom(int doubleTapZoom) {
        addTaint(doubleTapZoom);
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
        // ---------- Original Method ----------
        //mZoomManager.updateDoubleTapZoom(doubleTapZoom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.349 -0400", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "1EC371C0C47CE58F5ECB9B3A914483F4")
    private int computeRealHorizontalScrollRange() {
    if(mDrawHistory)        
        {
            int var38C0A3A006476C84FF6171E4B430E8AC_1778703938 = (mHistoryWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128343576 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128343576;
        } //End block
        else
        {
            int varBCB142270C5B4A54D456C644E081FE40_2106709216 = ((int) Math.floor(mContentWidth * mZoomManager.getScale()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237887051 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237887051;
        } //End block
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryWidth;
        //} else {
            //return (int) Math.floor(mContentWidth * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.349 -0400", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "24127CD4FA5DCA7229C3EC04826A071E")
    @Override
    protected int computeHorizontalScrollRange() {
        int range = computeRealHorizontalScrollRange();
        final int scrollX = mScrollX;
        final int overscrollRight = computeMaxScrollX();
    if(scrollX < 0)        
        {
            range -= scrollX;
        } //End block
        else
    if(scrollX > overscrollRight)        
        {
            range += scrollX - overscrollRight;
        } //End block
        int var37B19816109A32106D109E83BBB3C97D_295239885 = (range);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034559556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1034559556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.349 -0400", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "06BE2A9B5C3113A1D0C02B5DBE35D9CB")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var8E0A7AF2608E5AEEB8B4A02DE4489468_592254457 = (Math.max(mScrollX, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83083349 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83083349;
        // ---------- Original Method ----------
        //return Math.max(mScrollX, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.349 -0400", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "F71625D787D6DD83B3789ECB04C73A49")
    private int computeRealVerticalScrollRange() {
    if(mDrawHistory)        
        {
            int varC30FF925574AC27834AAEA84ED7CE642_699033390 = (mHistoryHeight);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804397317 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1804397317;
        } //End block
        else
        {
            int var756A953EF52E36029687E94ABAC58EDC_1448232681 = ((int) Math.floor(mContentHeight * mZoomManager.getScale()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266813142 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_266813142;
        } //End block
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return mHistoryHeight;
        //} else {
            //return (int) Math.floor(mContentHeight * mZoomManager.getScale());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.351 -0400", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "D610DE7FD0CBA5CBAA6B4EB4A3187C28")
    @Override
    protected int computeVerticalScrollRange() {
        int range = computeRealVerticalScrollRange();
        final int scrollY = mScrollY;
        final int overscrollBottom = computeMaxScrollY();
    if(scrollY < 0)        
        {
            range -= scrollY;
        } //End block
        else
    if(scrollY > overscrollBottom)        
        {
            range += scrollY - overscrollBottom;
        } //End block
        int var37B19816109A32106D109E83BBB3C97D_110827077 = (range);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722433384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1722433384;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.351 -0400", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "CABEEF4E0AB591653718D1115830BB68")
    @Override
    protected int computeVerticalScrollOffset() {
        int varD9A8F5D029D6C01BABEED36E6CD210E8_443348512 = (Math.max(mScrollY - getTitleHeight(), 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155444687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155444687;
        // ---------- Original Method ----------
        //return Math.max(mScrollY - getTitleHeight(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.352 -0400", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "BB6EB2F81FB5181A20A5363D6286B256")
    @Override
    protected int computeVerticalScrollExtent() {
        int var45AA5597054F0B571CDC94BCD9E7F5EC_1989411056 = (getViewHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818176924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818176924;
        // ---------- Original Method ----------
        //return getViewHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.352 -0400", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "3B75390357FC44477EC88AC6ED86BDDF")
    @Override
    protected void onDrawVerticalScrollBar(Canvas canvas,
                                           Drawable scrollBar,
                                           int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(scrollBar.getTaint());
        addTaint(canvas.getTaint());
    if(mScrollY < 0)        
        {
            t -= mScrollY;
        } //End block
        scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //if (mScrollY < 0) {
            //t -= mScrollY;
        //}
        //scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.352 -0400", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "0068E8D2B775CEC29482B19BB97D5840")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(clampedY);
        addTaint(clampedX);
        addTaint(scrollY);
        addTaint(scrollX);
    if(mTouchMode == TOUCH_DRAG_LAYER_MODE)        
        {
            scrollLayerTo(scrollX, scrollY);
            return;
        } //End block
        mInOverScrollMode = false;
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();
    if(maxX == 0)        
        {
            scrollX = pinLocX(scrollX);
        } //End block
        else
    if(scrollX < 0 || scrollX > maxX)        
        {
            mInOverScrollMode = true;
        } //End block
    if(scrollY < 0 || scrollY > maxY)        
        {
            mInOverScrollMode = true;
        } //End block
        int oldX = mScrollX;
        int oldY = mScrollY;
        super.scrollTo(scrollX, scrollY);
    if(mOverScrollGlow != null)        
        {
            mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.353 -0400", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "1BFB7BFA922D408ECC85FA2B0163213B")
    public String getUrl() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
String var3B9E2737860C8AED14CAEC081AFCAAF8_136671895 =         h != null ? h.getUrl() : null;
        var3B9E2737860C8AED14CAEC081AFCAAF8_136671895.addTaint(taint);
        return var3B9E2737860C8AED14CAEC081AFCAAF8_136671895;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "AF766D5538C4BB0CEFA5BABD5C88EB08")
    public String getOriginalUrl() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
String var525D43DC5C890558DD822FD75512C7F1_23845795 =         h != null ? h.getOriginalUrl() : null;
        var525D43DC5C890558DD822FD75512C7F1_23845795.addTaint(taint);
        return var525D43DC5C890558DD822FD75512C7F1_23845795;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getOriginalUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "66F26B382EB58A8A02F146F245EC5A6E")
    public String getTitle() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
String varFC0DD24DED1526C57BC288F7E7B92921_1092112517 =         h != null ? h.getTitle() : null;
        varFC0DD24DED1526C57BC288F7E7B92921_1092112517.addTaint(taint);
        return varFC0DD24DED1526C57BC288F7E7B92921_1092112517;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTitle() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "D47B5DF4284A4DF451B790CB84FC153B")
    public Bitmap getFavicon() {
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
Bitmap varFC58C785D4250A08FC1154F99A8376F0_439880511 =         h != null ? h.getFavicon() : null;
        varFC58C785D4250A08FC1154F99A8376F0_439880511.addTaint(taint);
        return varFC58C785D4250A08FC1154F99A8376F0_439880511;
        // ---------- Original Method ----------
        //checkThread();
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getFavicon() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "6149F61E9B9BB0B467F437A554A211FC")
    public String getTouchIconUrl() {
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
String varBE51B2FB5E404874F69E99A47C0CB6E9_1468323628 =         h != null ? h.getTouchIconUrl() : null;
        varBE51B2FB5E404874F69E99A47C0CB6E9_1468323628.addTaint(taint);
        return varBE51B2FB5E404874F69E99A47C0CB6E9_1468323628;
        // ---------- Original Method ----------
        //WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        //return h != null ? h.getTouchIconUrl() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "3478C0FAE1A8248D6961A3EC6CA3C4B4")
    public int getProgress() {
        checkThread();
        int varBD43385672D352C6421C668C4EAF6A27_598908605 = (mCallbackProxy.getProgress());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990919698 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990919698;
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getProgress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "B0D98121F71F01527F63DE63CB4BBC33")
    public int getContentHeight() {
        checkThread();
        int varF40FB88A5310D2E8A8F0AC8C692796A5_2066564685 = (mContentHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045129964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045129964;
        // ---------- Original Method ----------
        //checkThread();
        //return mContentHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.354 -0400", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "A8CB18F405AA54920D06D128CAF36CE1")
    public int getContentWidth() {
        int var8CAE9DDC87DDEC99A752E150A6F5EE2F_610994716 = (mContentWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471554179 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1471554179;
        // ---------- Original Method ----------
        //return mContentWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.356 -0400", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "541C2F9098B24EE7BBEC4FD368230A03")
    public int getPageBackgroundColor() {
        int varDFD78FFD2225AF9CD329CE4D91BCA41F_1084056390 = (nativeGetBackgroundColor());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822055049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_822055049;
        // ---------- Original Method ----------
        //return nativeGetBackgroundColor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "651F867BAFC105E7B600DA6E0DB6200B")
    public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "FCEBD265F9D78FA6297E394388314989")
    public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "FD8CF4A193C107BE126D47D7CF33ECC1")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
    if(!mIsPaused)        
        {
            mIsPaused = true;
            mWebViewCore.sendMessage(EventHub.ON_PAUSE);
    if(mHTML5VideoViewProxy != null)            
            {
                mHTML5VideoViewProxy.pauseAndDispatch();
            } //End block
    if(mNativeClass != 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "6C6BA2BBD6A68ACAE00C9BDBE3CF86BD")
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        super.onWindowVisibilityChanged(visibility);
        updateDrawingState();
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //updateDrawingState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "65180BB6AE643F3FF654CDD696190E92")
     void updateDrawingState() {
    if(mNativeClass == 0 || mIsPaused)        
        return;
    if(getWindowVisibility() != VISIBLE)        
        {
            nativeSetPauseDrawing(mNativeClass, true);
        } //End block
        else
    if(getVisibility() != VISIBLE)        
        {
            nativeSetPauseDrawing(mNativeClass, true);
        } //End block
        else
        {
            nativeSetPauseDrawing(mNativeClass, false);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.357 -0400", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "D601E04994AD428A1887746ACD2D8393")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        checkThread();
    if(mIsPaused)        
        {
            mIsPaused = false;
            mWebViewCore.sendMessage(EventHub.ON_RESUME);
    if(mNativeClass != 0)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.359 -0400", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "14DDA02CB5A68D8E45A270007762C25A")
    public boolean isPaused() {
        boolean varE5E0AF0CF7EBA0195F7043E5E0A523EC_1921081053 = (mIsPaused);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274826363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274826363;
        // ---------- Original Method ----------
        //return mIsPaused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.359 -0400", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "7D54396D1E9C804F1A90D8C86B6B65FA")
    public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.359 -0400", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "26341B263DFFCB256EEBD22A4B11ACC0")
    public void clearCache(boolean includeDiskFiles) {
        addTaint(includeDiskFiles);
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                includeDiskFiles ? 1 : 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                //includeDiskFiles ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.359 -0400", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "E8965C98DAF3A0C6A977C3A3040963A9")
    public void clearFormData() {
        checkThread();
    if(inEditingMode())        
        {
            mWebTextView.setAdapterCustom(null);
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (inEditingMode()) {
            //mWebTextView.setAdapterCustom(null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.360 -0400", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "2F018CB7C6DC1FE54A157AEDF3AD6E80")
    public void clearHistory() {
        checkThread();
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.getBackForwardList().setClearPending();
        //mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.360 -0400", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "36E442E384C566FE65DE22F84677463B")
    public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
        // ---------- Original Method ----------
        //checkThread();
        //mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.360 -0400", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "831E9F34BEFFE48EE8B347B8C4340EC8")
    public WebBackForwardList copyBackForwardList() {
        checkThread();
WebBackForwardList varA600F65CA71BDFE56E1956B5658F76F2_1824772337 =         mCallbackProxy.getBackForwardList().clone();
        varA600F65CA71BDFE56E1956B5658F76F2_1824772337.addTaint(taint);
        return varA600F65CA71BDFE56E1956B5658F76F2_1824772337;
        // ---------- Original Method ----------
        //checkThread();
        //return mCallbackProxy.getBackForwardList().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.360 -0400", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "E5497581A15439F3C062412D5B77A1AD")
    public void findNext(boolean forward) {
        addTaint(forward);
        checkThread();
    if(0 == mNativeClass)        
        return;
        nativeFindNext(forward);
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return;
        //nativeFindNext(forward);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.362 -0400", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "10F14D2B883D7D8972020055AFF49B2F")
    public int findAll(String find) {
        checkThread();
    if(0 == mNativeClass)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1340047277 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363845699 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363845699;
        }
        int result = find != null ? nativeFindAll(find.toLowerCase(),
                find.toUpperCase(), find.equalsIgnoreCase(mLastFind)) : 0;
        invalidate();
        mLastFind = find;
        int varB4A88417B3D0170D754C647C30B7216A_1483415535 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863260789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863260789;
        // ---------- Original Method ----------
        //checkThread();
        //if (0 == mNativeClass) return 0;
        //int result = find != null ? nativeFindAll(find.toLowerCase(),
                //find.toUpperCase(), find.equalsIgnoreCase(mLastFind)) : 0;
        //invalidate();
        //mLastFind = find;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.363 -0400", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "49957DC3C1C3FB67CA00E2B1BA02FFBA")
    public boolean showFindDialog(String text, boolean showIme) {
        addTaint(showIme);
        addTaint(text.getTaint());
        checkThread();
        FindActionModeCallback callback = new FindActionModeCallback(mContext);
    if(getParent() == null || startActionMode(callback) == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_946604554 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_296635129 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_296635129;
        } //End block
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = callback;
        setFindIsUp(true);
        mFindCallback.setWebView(this);
    if(showIme)        
        {
            mFindCallback.showSoftInput();
        } //End block
        else
    if(text != null)        
        {
            mFindCallback.setText(text);
            mFindCallback.findAll();
            boolean varB326B5062B2F0E69046810717534CB09_766310318 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327195056 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_327195056;
        } //End block
    if(text == null)        
        {
            text = mLastFind;
        } //End block
    if(text != null)        
        {
            mFindCallback.setText(text);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1539208157 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677633275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_677633275;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.363 -0400", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "86C2FFAAD41DDC92952FE941B592AAAE")
    private void setFindIsUp(boolean isUp) {
        mFindIsUp = isUp;
    if(0 == mNativeClass)        
        return;
        nativeSetFindIsUp(isUp);
        // ---------- Original Method ----------
        //mFindIsUp = isUp;
        //if (0 == mNativeClass) return;
        //nativeSetFindIsUp(isUp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.363 -0400", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "E075C60A58B4345343482418DEC4D177")
     int findIndex() {
    if(0 == mNativeClass)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1190593019 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264431293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264431293;
        }
        int varE7965D8DA9895EDB381AE68B1038DCD5_1159711190 = (nativeFindIndex());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866764115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866764115;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.365 -0400", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "716B76CC7493F75281D2C31C084A6617")
    public void clearMatches() {
        checkThread();
    if(mNativeClass == 0)        
        return;
        nativeSetFindIsEmpty();
        invalidate();
        // ---------- Original Method ----------
        //checkThread();
        //if (mNativeClass == 0)
            //return;
        //nativeSetFindIsEmpty();
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.365 -0400", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "8E7A489998FD7306020D43B72D3FA90F")
     void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
    if(mWebViewCore == null)        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.365 -0400", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "CA8A249440086BFBD5B3C7DA71B43C4D")
    public void documentHasImages(Message response) {
        addTaint(response.getTaint());
        checkThread();
    if(response == null)        
        {
            return;
        } //End block
        mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
        // ---------- Original Method ----------
        //checkThread();
        //if (response == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.365 -0400", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "A83853DA38B09ACCE7BA0F75693DED2D")
    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
        // ---------- Original Method ----------
        //mScroller.forceFinished(true);
        //mLastVelocity = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.368 -0400", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "211F0407DA1BF0CC72D54007FF21BD70")
    @Override
    public void computeScroll() {
    if(mScroller.computeScrollOffset())        
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            invalidate();
    if(!mScroller.isFinished())            
            {
                int rangeX = computeMaxScrollX();
                int rangeY = computeMaxScrollY();
                int overflingDistance = mOverflingDistance;
    if(mTouchMode == TOUCH_DRAG_LAYER_MODE)                
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
    if(mOverScrollGlow != null)                
                {
                    mOverScrollGlow.absorbGlow(x, y, oldX, oldY, rangeX, rangeY);
                } //End block
            } //End block
            else
            {
    if(mTouchMode != TOUCH_DRAG_LAYER_MODE)                
                {
                    mScrollX = x;
                    mScrollY = y;
                } //End block
                else
                {
                    scrollLayerTo(x, y);
                } //End block
                abortAnimation();
                nativeSetIsScrolling(false);
    if(!mBlockWebkitViewMessages)                
                {
                    WebViewCore.resumePriority();
    if(!mSelectingText)                    
                    {
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    } //End block
                } //End block
    if(oldX != mScrollX || oldY != mScrollY)                
                {
                    sendOurVisibleRect();
                } //End block
            } //End block
        } //End block
        else
        {
            super.computeScroll();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.368 -0400", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "22451A5418CC6844694B5126D7A208F4")
    private void scrollLayerTo(int x, int y) {
    if(x == mScrollingLayerRect.left && y == mScrollingLayerRect.top)        
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.370 -0400", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "F93EBA7608B75D90C905F1674C1A32A3")
    private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        addTaint(animationDuration);
        addTaint(animate);
        addTaint(dy);
        addTaint(dx);
        boolean var6F62792B94D75DB585CDD2A11D2EE133_1102869932 = (pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562115174 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562115174;
        // ---------- Original Method ----------
        //return pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.370 -0400", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "EABCC911D1BBD08ABCC64A1CEBED0069")
    private boolean pinScrollTo(int x, int y, boolean animate, int animationDuration) {
        addTaint(animationDuration);
        addTaint(animate);
        addTaint(y);
        addTaint(x);
        x = pinLocX(x);
        y = pinLocY(y);
        int dx = x - mScrollX;
        int dy = y - mScrollY;
    if((dx | dy) == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2101987227 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2042326234 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2042326234;
        } //End block
        abortAnimation();
    if(animate)        
        {
            mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            awakenScrollBars(mScroller.getDuration());
            invalidate();
        } //End block
        else
        {
            scrollTo(x, y);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1346150538 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383216244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383216244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.370 -0400", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "AB08E0EEAFC564A407B1E25A0AAFEDDD")
    private boolean setContentScrollBy(int cx, int cy, boolean animate) {
        addTaint(animate);
        addTaint(cy);
        addTaint(cx);
    if(mDrawHistory)        
        {
            boolean var68934A3E9455FA72420237EB05902327_496472792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020117600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020117600;
        } //End block
        cx = contentToViewDimension(cx);
        cy = contentToViewDimension(cy);
    if(mHeightCanMeasure)        
        {
    if(cy != 0)            
            {
                Rect tempRect = new Rect();
                calcOurVisibleRect(tempRect);
                tempRect.offset(cx, cy);
                requestRectangleOnScreen(tempRect);
            } //End block
            boolean var72BADAB50E5D95FF8A6E6265ADBBA15C_952104816 = (cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598090257 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_598090257;
        } //End block
        else
        {
            boolean varD35D833D0CD2FF60AA0CD2FAFE5B97EB_2100572186 = (pinScrollBy(cx, cy, animate, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354688170 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_354688170;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.372 -0400", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "5EA65BDA6FB2354BC5EF9819C2E1D449")
     void onPageStarted(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
        setCertificate(null);
        mAccessibilityScriptInjected = false;
        // ---------- Original Method ----------
        //setCertificate(null);
        //mAccessibilityScriptInjected = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.372 -0400", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "037EE6F8AAADA152F433CD0BC4BF5F47")
     void onPageFinished(String url) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(url.getTaint());
    if(mPageThatNeedsToSlideTitleBarOffScreen != null)        
        {
    if(mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    && mScrollX == 0 && mScrollY == 0)            
            {
                pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        SLIDE_TITLE_DURATION);
            } //End block
            mPageThatNeedsToSlideTitleBarOffScreen = null;
        } //End block
        mZoomManager.onPageFinished(url);
        injectAccessibilityForUrl(url);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.373 -0400", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "8CA3BFD997E7DE8331F3B658EFB90505")
    private void injectAccessibilityForUrl(String url) {
        addTaint(url.getTaint());
    if(mWebViewCore == null)        
        {
            return;
        } //End block
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mContext);
    if(!accessibilityManager.isEnabled())        
        {
            ensureAccessibilityScriptInjectorInstance(false);
            return;
        } //End block
    if(!getSettings().getJavaScriptEnabled())        
        {
            ensureAccessibilityScriptInjectorInstance(true);
            return;
        } //End block
        int axsParameterValue = getAxsUrlParameterValue(url);
    if(axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED)        
        {
            boolean onDeviceScriptInjectionEnabled = (Settings.Secure.getInt(mContext
                    .getContentResolver(), Settings.Secure.ACCESSIBILITY_SCRIPT_INJECTION, 0) == 1);
    if(onDeviceScriptInjectionEnabled)            
            {
                ensureAccessibilityScriptInjectorInstance(false);
                loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
                mAccessibilityScriptInjected = true;
            } //End block
            else
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } //End block
        } //End block
        else
    if(axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT)        
        {
            ensureAccessibilityScriptInjectorInstance(true);
        } //End block
        else
    if(axsParameterValue == ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED)        
        {
            ensureAccessibilityScriptInjectorInstance(false);
            loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
        } //End block
        else
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.373 -0400", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "8ADA433A0F60ED9775E5ACA504524B12")
    private void ensureAccessibilityScriptInjectorInstance(boolean present) {
        addTaint(present);
    if(present)        
        {
    if(mAccessibilityInjector == null)            
            {
                mAccessibilityInjector = new AccessibilityInjector(this);
            } //End block
        } //End block
        else
        {
            mAccessibilityInjector = null;
        } //End block
        // ---------- Original Method ----------
        //if (present) {
            //if (mAccessibilityInjector == null) {
                //mAccessibilityInjector = new AccessibilityInjector(this);
            //}
        //} else {
            //mAccessibilityInjector = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.374 -0400", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "736FE5384BB54A4BD635FA4632EE0CA5")
    private int getAxsUrlParameterValue(String url) {
        addTaint(url.getTaint());
    if(mMatchAxsUrlParameterPattern == null)        
        {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        } //End block
        Matcher matcher = mMatchAxsUrlParameterPattern.matcher(url);
    if(matcher.find())        
        {
            String keyValuePair = url.substring(matcher.start(), matcher.end());
            int varB06FBC90DF77F035264E5D2B52D04450_954343006 = (Integer.parseInt(keyValuePair.split("=")[1]));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499560324 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499560324;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_31290800 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394837668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394837668;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.375 -0400", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "1CCB250868CFD022F519B604A436997D")
    private boolean setContentScrollTo(int cx, int cy) {
        addTaint(cy);
        addTaint(cx);
    if(mDrawHistory)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1494375405 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163377190 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_163377190;
        } //End block
        int vx;
        int vy;
    if((cx | cy) == 0)        
        {
            vx = 0;
            vy = 0;
        } //End block
        else
        {
            vx = contentToViewX(cx);
            vy = contentToViewY(cy);
        } //End block
    if(cx == 0 && cy == 1 && mScrollX == 0 && mScrollY == 0
                && mTitleBar != null)        
        {
    if(getProgress() < 100)            
            {
                mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                mYDistanceToSlideTitleOffScreen = vy;
            } //End block
            else
            {
                pinScrollTo(vx, vy, true, SLIDE_TITLE_DURATION);
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2016247769 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573500437 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_573500437;
        } //End block
        pinScrollTo(vx, vy, false, 0);
    if((mScrollX != vx && cx >= 0) || (mScrollY != vy && cy >= 0))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1252402706 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196856696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196856696;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2012807796 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953444732 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_953444732;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.378 -0400", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "D7CC5551A6CDE06DDACA80070B84CA6C")
    private void spawnContentScrollTo(int cx, int cy) {
        addTaint(cy);
        addTaint(cx);
    if(mDrawHistory)        
        {
            return;
        } //End block
        int vx = contentToViewX(cx);
        int vy = contentToViewY(cy);
        pinScrollTo(vx, vy, true, 0);
        // ---------- Original Method ----------
        //if (mDrawHistory) {
            //return;
        //}
        //int vx = contentToViewX(cx);
        //int vy = contentToViewY(cy);
        //pinScrollTo(vx, vy, true, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.378 -0400", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "EDE04E719BFC02378B734463E60738EE")
    private void contentSizeChanged(boolean updateLayout) {
        addTaint(updateLayout);
    if((mContentWidth | mContentHeight) == 0)        
        {
            return;
        } //End block
    if(mHeightCanMeasure)        
        {
    if(getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout)            
            {
                requestLayout();
            } //End block
        } //End block
        else
    if(mWidthCanMeasure)        
        {
    if(getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    || updateLayout)            
            {
                requestLayout();
            } //End block
        } //End block
        else
        {
            sendViewSizeZoom(false);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "FE8FEEAFCEB1754631BDB7F96F90F263")
    public void setWebViewClient(WebViewClient client) {
        addTaint(client.getTaint());
        checkThread();
        mCallbackProxy.setWebViewClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebViewClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "D94985C2DF0E4F77B5F108FD03337464")
    public WebViewClient getWebViewClient() {
WebViewClient var6180F3310140862846D6DF771003449C_1347176200 =         mCallbackProxy.getWebViewClient();
        var6180F3310140862846D6DF771003449C_1347176200.addTaint(taint);
        return var6180F3310140862846D6DF771003449C_1347176200;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebViewClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "183FD393048395B96236D5FA616F2C8A")
    public void setDownloadListener(DownloadListener listener) {
        addTaint(listener.getTaint());
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setDownloadListener(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "D230F16E6DDF74CB44372999E8FB8E88")
    public void setWebChromeClient(WebChromeClient client) {
        addTaint(client.getTaint());
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
        // ---------- Original Method ----------
        //checkThread();
        //mCallbackProxy.setWebChromeClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "182A125634D16873992BBA929CEA2C3A")
    public WebChromeClient getWebChromeClient() {
WebChromeClient var18FB91BBE51C85AE4F82E1005499258E_113656113 =         mCallbackProxy.getWebChromeClient();
        var18FB91BBE51C85AE4F82E1005499258E_113656113.addTaint(taint);
        return var18FB91BBE51C85AE4F82E1005499258E_113656113;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebChromeClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "FDA9D27F33F98234D2A1C660AF5B2083")
    public void setWebBackForwardListClient(WebBackForwardListClient client) {
        addTaint(client.getTaint());
        mCallbackProxy.setWebBackForwardListClient(client);
        // ---------- Original Method ----------
        //mCallbackProxy.setWebBackForwardListClient(client);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "2295C151C5544770784A9F738E3CC05B")
    public WebBackForwardListClient getWebBackForwardListClient() {
WebBackForwardListClient var7C9928513CCF495C7DDD85A607246D50_802681906 =         mCallbackProxy.getWebBackForwardListClient();
        var7C9928513CCF495C7DDD85A607246D50_802681906.addTaint(taint);
        return var7C9928513CCF495C7DDD85A607246D50_802681906;
        // ---------- Original Method ----------
        //return mCallbackProxy.getWebBackForwardListClient();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "C3EF422014BE5A0F4249AE48165752C1")
    @Deprecated
    public void setPictureListener(PictureListener listener) {
        checkThread();
        mPictureListener = listener;
        // ---------- Original Method ----------
        //checkThread();
        //mPictureListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.379 -0400", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "0A9BF41255B6BB2E8D99E06EA2BA2324")
    public void externalRepresentation(Message callback) {
        addTaint(callback.getTaint());
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.380 -0400", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "A3AA2EC0F8B102F70072AB4F0B8BBA72")
    public void documentAsText(Message callback) {
        addTaint(callback.getTaint());
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.380 -0400", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "AB5B6E33ADE1E239760D4CA418CB5CCC")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        addTaint(interfaceName.getTaint());
        addTaint(obj.getTaint());
        checkThread();
    if(obj == null)        
        {
            return;
        } //End block
        WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
        arg.mObject = obj;
        arg.mInterfaceName = interfaceName;
        mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.381 -0400", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "F32C472A9D0ECFE2BF9B7B6858B5668D")
    public void removeJavascriptInterface(String interfaceName) {
        addTaint(interfaceName.getTaint());
        checkThread();
    if(mWebViewCore != null)        
        {
            WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            arg.mInterfaceName = interfaceName;
            mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mWebViewCore != null) {
            //WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            //arg.mInterfaceName = interfaceName;
            //mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.381 -0400", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "54C8880C704B15A57EAF427651A29ACB")
    public WebSettings getSettings() {
        checkThread();
WebSettings varC9549A92BE055654588A601A41C2D82C_1032793936 =         (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
        varC9549A92BE055654588A601A41C2D82C_1032793936.addTaint(taint);
        return varC9549A92BE055654588A601A41C2D82C_1032793936;
        // ---------- Original Method ----------
        //checkThread();
        //return (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
    }

    
        @Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.382 -0400", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "701388A3FC6037399EDF7263A065415F")
    @Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        addTaint(reloadOpenPages);
        checkThread();
        // ---------- Original Method ----------
        //checkThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.382 -0400", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "022A2AB107DC6E6D5A563AA7CE19C7F7")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(mNativeClass != 0)            
            {
                mPrivateHandler.post(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.382 -0400", hash_original_method = "C35D8FF76F468647EBD4843DB70BD70E", hash_generated_method = "1D1962C885A4B76385563869BB6544A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.385 -0400", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "08AEC2DDBC2C9B711E358F15F2631DB2")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        addTaint(drawingTime);
        addTaint(child.getTaint());
        addTaint(canvas.getTaint());
    if(child == mTitleBar)        
        {
            mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            int newTop = 0;
    if(mTitleGravity == Gravity.NO_GRAVITY)            
            {
                newTop = Math.min(0, mScrollY);
            } //End block
            else
    if(mTitleGravity == Gravity.TOP)            
            {
                newTop = mScrollY;
            } //End block
            mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            mTitleBar.setTop(newTop);
        } //End block
        boolean varC1CAB5F89F7BBD877DB44D454088FF65_1327596229 = (super.drawChild(canvas, child, drawingTime));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236557854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236557854;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.385 -0400", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "199B4FD4AF077EFA520ECA2B2BFE9D19")
    private void drawContent(Canvas canvas, boolean drawRings) {
        addTaint(drawRings);
        addTaint(canvas.getTaint());
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
        // ---------- Original Method ----------
        //drawCoreAndCursorRing(canvas, mBackgroundColor,
                //mDrawCursorRing && drawRings);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.386 -0400", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "AE237DBCE095BB6E09FB2B09C402FAAB")
    private void drawOverScrollBackground(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mOverScrollBackground == null)        
        {
            mOverScrollBackground = new Paint();
            Bitmap bm = BitmapFactory.decodeResource(
                    mContext.getResources(),
                    com.android.internal.R.drawable.status_bar_background);
            mOverScrollBackground.setShader(new BitmapShader(bm,
                    Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            mOverScrollBorder = new Paint();
            mOverScrollBorder.setStyle(Paint.Style.STROKE);
            mOverScrollBorder.setStrokeWidth(0);
            mOverScrollBorder.setColor(0xffbbbbbb);
        } //End block
        int top = 0;
        int right = computeRealHorizontalScrollRange();
        int bottom = top + computeRealVerticalScrollRange();
        canvas.save();
        canvas.translate(mScrollX, mScrollY);
        canvas.clipRect(-mScrollX, top - mScrollY, right - mScrollX, bottom
                - mScrollY, Region.Op.DIFFERENCE);
        canvas.drawPaint(mOverScrollBackground);
        canvas.restore();
        canvas.drawRect(-1, top - 1, right, bottom, mOverScrollBorder);
        canvas.clipRect(0, top, right, bottom);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.387 -0400", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "69B6B69424DD931F28BF9A6B94C75125")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
    if(mNativeClass == 0)        
        {
            canvas.drawColor(mBackgroundColor);
            return;
        } //End block
    if((mContentWidth | mContentHeight) == 0 && mHistoryPicture == null)        
        {
            canvas.drawColor(mBackgroundColor);
            return;
        } //End block
    if(canvas.isHardwareAccelerated())        
        {
    if(mIncrementEGLContextHack == false)            
            {
                mIncrementEGLContextHack = true;
                EGL10 egl = (EGL10) EGLContext.getEGL();
                EGLDisplay eglDisplay = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                int[] version = new int[2];
                egl.eglInitialize(eglDisplay, version);
            } //End block
            mZoomManager.setHardwareAccelerated();
        } //End block
        int saveCount = canvas.save();
    if(mInOverScrollMode && !getSettings()
                .getUseWebViewBackgroundForOverscrollBackground())        
        {
            drawOverScrollBackground(canvas);
        } //End block
    if(mTitleBar != null)        
        {
            canvas.translate(0, getTitleHeight());
        } //End block
        boolean drawJavaRings = !mTouchHighlightRegion.isEmpty()
                && (mTouchMode == TOUCH_INIT_MODE
                || mTouchMode == TOUCH_SHORTPRESS_START_MODE
                || mTouchMode == TOUCH_SHORTPRESS_MODE
                || mTouchMode == TOUCH_DONE_MODE);
        boolean drawNativeRings = !drawJavaRings;
    if(USE_WEBKIT_RINGS)        
        {
            drawNativeRings = !drawJavaRings && !isInTouchMode();
        } //End block
        drawContent(canvas, drawNativeRings);
        canvas.restoreToCount(saveCount);
    if(AUTO_REDRAW_HACK && mAutoRedraw)        
        {
            invalidate();
        } //End block
        mWebViewCore.signalRepaintDone();
    if(mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas))        
        {
            invalidate();
        } //End block
    if(drawJavaRings)        
        {
            long delay = System.currentTimeMillis() - mTouchHighlightRequested;
    if(delay < ViewConfiguration.getTapTimeout())            
            {
                Rect r = mTouchHighlightRegion.getBounds();
                postInvalidateDelayed(delay, r.left, r.top, r.right, r.bottom);
            } //End block
            else
            {
    if(mTouchHightlightPaint == null)                
                {
                    mTouchHightlightPaint = new Paint();
                    mTouchHightlightPaint.setColor(HIGHLIGHT_COLOR);
                } //End block
                RegionIterator iter = new RegionIterator(mTouchHighlightRegion);
                Rect r = new Rect();
                while
(iter.next(r))                
                {
                    canvas.drawRect(r, mTouchHightlightPaint);
                } //End block
            } //End block
        } //End block
    if(DEBUG_TOUCH_HIGHLIGHT)        
        {
    if(getSettings().getNavDump())            
            {
    if((mTouchHighlightX | mTouchHighlightY) != 0)                
                {
    if(mTouchCrossHairColor == null)                    
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.388 -0400", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "34A310392E72BEC0A58EE1BE45DD1549")
    private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
        // ---------- Original Method ----------
        //mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        //mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        //setTouchHighlightRects(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.388 -0400", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "5325297249917435EFDD039EDDDA66E9")
    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
    if(params.height == LayoutParams.WRAP_CONTENT)        
        {
            mWrapContent = true;
        } //End block
        super.setLayoutParams(params);
        // ---------- Original Method ----------
        //if (params.height == LayoutParams.WRAP_CONTENT) {
            //mWrapContent = true;
        //}
        //super.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.388 -0400", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "E377798104599227B9A1C88EB8C3F194")
    @Override
    public boolean performLongClick() {
    if(getParent() == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1789272127 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951841156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951841156;
        }
        final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
    if(detector != null && detector.isInProgress())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1757922015 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447880013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447880013;
        } //End block
    if(mNativeClass != 0 && nativeCursorIsTextInput())        
        {
            centerKeyPressOnTextField();
            rebuildWebTextView();
        } //End block
        else
        {
            clearTextEntry();
        } //End block
    if(inEditingMode())        
        {
            mWebTextView.ensureLayout();
            AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) mWebTextView.getLayoutParams();
            MotionEvent fake = MotionEvent.obtain(mLastTouchTime,
                    mLastTouchTime, MotionEvent.ACTION_DOWN,
                    mLastTouchX - params.x + mScrollX,
                    mLastTouchY - params.y + mScrollY, 0);
            mWebTextView.dispatchTouchEvent(fake);
            boolean varB1E181E0608CD079E497B1A149C09B7E_1205874210 = (mWebTextView.performLongClick());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334826690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_334826690;
        } //End block
    if(mSelectingText)        
        {
        boolean var68934A3E9455FA72420237EB05902327_443539195 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000978324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000978324;
        }
    if(super.performLongClick())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1134608863 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519614275 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_519614275;
        } //End block
        final boolean isSelecting = selectText();
    if(isSelecting)        
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        boolean var590AB75FE3A95E7CA4A4495D0194C981_73010397 = (isSelecting);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461728942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461728942;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.390 -0400", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "435F907D274E67F3DD32EA2730B67B2F")
    public boolean selectText() {
        int x = viewToContentX(mLastTouchX + mScrollX);
        int y = viewToContentY(mLastTouchY + mScrollY);
        boolean var9B72FB61F0A90897D4FF9E95CF672ED2_685284427 = (selectText(x, y));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661841840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661841840;
        // ---------- Original Method ----------
        //int x = viewToContentX(mLastTouchX + mScrollX);
        //int y = viewToContentY(mLastTouchY + mScrollY);
        //return selectText(x, y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.390 -0400", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "C1E515E1FD5077ECE275CF52611BF860")
     boolean selectText(int x, int y) {
        addTaint(y);
        addTaint(x);
    if(!setUpSelect(true, x, y))        
        {
            boolean var68934A3E9455FA72420237EB05902327_456719675 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1051613334 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1051613334;
        } //End block
        nativeSetExtendSelection();
        mDrawSelectionPointer = false;
        mTouchMode = TOUCH_DRAG_MODE;
        boolean varB326B5062B2F0E69046810717534CB09_469152236 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367414507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367414507;
        // ---------- Original Method ----------
        //if (!setUpSelect(true, x, y)) {
            //return false;
        //}
        //nativeSetExtendSelection();
        //mDrawSelectionPointer = false;
        //mTouchMode = TOUCH_DRAG_MODE;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.390 -0400", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "F2E920C7DB0ADA8CDC7044383638E729")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCachedOverlappingActionModeHeight = -1;
    if(mSelectingText && mOrientation != newConfig.orientation)        
        {
            selectionDone();
        } //End block
        mOrientation = newConfig.orientation;
    if(mWebViewCore != null && !mBlockWebkitViewMessages)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.390 -0400", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "C2E80E33D57EBE3C935FDBC58CA41ECC")
    private boolean didUpdateWebTextViewDimensions(int intersection) {
        addTaint(intersection);
        Rect contentBounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(contentBounds);
        Rect visibleRect = new Rect();
        calcOurVisibleRect(visibleRect);
        offsetByLayerScrollPosition(vBox);
        boolean onScreen;
switch(intersection){
        case FULLY_ON_SCREEN:
        onScreen = visibleRect.contains(vBox);
        break;
        case INTERSECTS_SCREEN:
        onScreen = Rect.intersects(visibleRect, vBox);
        break;
        case ANYWHERE:
        onScreen = true;
        break;
        default:
        AssertionError varFE495E887F428E9E4C20A867F02FB0A5_2073781502 = new AssertionError(
                        "invalid parameter passed to didUpdateWebTextViewDimensions");
        varFE495E887F428E9E4C20A867F02FB0A5_2073781502.addTaint(taint);
        throw varFE495E887F428E9E4C20A867F02FB0A5_2073781502;
}    if(onScreen)        
        {
            mWebTextView.setRect(vBox.left, vBox.top, vBox.width(),
                    vBox.height());
            mWebTextView.updateTextSize();
            updateWebTextViewPadding();
            boolean varB326B5062B2F0E69046810717534CB09_427046889 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1811429485 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1811429485;
        } //End block
        else
        {
            mWebTextView.remove();
            boolean var68934A3E9455FA72420237EB05902327_110898133 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92945619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_92945619;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.391 -0400", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "567E23F933403EF9C5A7A0BC8BD055CA")
    private void offsetByLayerScrollPosition(Rect box) {
        addTaint(box.getTaint());
    if((mCurrentScrollingLayerId != 0)
                && (mCurrentScrollingLayerId == nativeFocusCandidateLayerId()))        
        {
            box.offsetTo(box.left - mScrollingLayerRect.left,
                    box.top - mScrollingLayerRect.top);
        } //End block
        // ---------- Original Method ----------
        //if ((mCurrentScrollingLayerId != 0)
                //&& (mCurrentScrollingLayerId == nativeFocusCandidateLayerId())) {
            //box.offsetTo(box.left - mScrollingLayerRect.left,
                    //box.top - mScrollingLayerRect.top);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "B62E312DEEF1F0F854E00A61DF93F994")
     void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        addTaint(registerPageSwapCallback);
        addTaint(isPictureAfterFirstLayout);
        addTaint(showVisualIndicator);
        addTaint(invalRegion.getTaint());
        addTaint(layer);
    if(mNativeClass == 0)        
        return;
        nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                isPictureAfterFirstLayout, registerPageSwapCallback);
    if(mHTML5VideoViewProxy != null)        
        {
            mHTML5VideoViewProxy.setBaseLayer(layer);
        } //End block
        // ---------- Original Method ----------
        //if (mNativeClass == 0)
            //return;
        //nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                //isPictureAfterFirstLayout, registerPageSwapCallback);
        //if (mHTML5VideoViewProxy != null) {
            //mHTML5VideoViewProxy.setBaseLayer(layer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "D8FD3061AA8E8E9D0CF2868296CC045E")
     int getBaseLayer() {
    if(mNativeClass == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_127260836 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044073657 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044073657;
        } //End block
        int var7C612DA0CB40C0B6BFE6A1442200BE02_1403825822 = (nativeGetBaseLayer());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8220339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8220339;
        // ---------- Original Method ----------
        //if (mNativeClass == 0) {
            //return 0;
        //}
        //return nativeGetBaseLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "2CDFF8F1F2A375F8CD10E80C0A71AC50")
    private void onZoomAnimationStart() {
    if(inEditingMode())        
        {
            mWebTextView.setVisibility(INVISIBLE);
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //mWebTextView.setVisibility(INVISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "B9DEF7FC63124C969ADB34892C9BA997")
    private void onZoomAnimationEnd() {
    if(inEditingMode()
                && didUpdateWebTextViewDimensions(FULLY_ON_SCREEN))        
        {
            mWebTextView.setVisibility(VISIBLE);
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& didUpdateWebTextViewDimensions(FULLY_ON_SCREEN)) {
            //mWebTextView.setVisibility(VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "1DA8D4977752B15EE1DC244719C6FA7D")
     void onFixedLengthZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //WebViewCore.pauseUpdatePicture(getWebViewCore());
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.392 -0400", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "1586BBCA34309C3F8A6FFCD815421968")
     void onFixedLengthZoomAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(!mBlockWebkitViewMessages && !mSelectingText)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.394 -0400", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "422FA483B8AFD73232A74E6CF8BC10CF")
    private void drawCoreAndCursorRing(Canvas canvas, int color,
        boolean drawCursorRing) {
        addTaint(drawCursorRing);
        addTaint(color);
        addTaint(canvas.getTaint());
    if(mDrawHistory)        
        {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            canvas.drawPicture(mHistoryPicture);
            return;
        } //End block
    if(mNativeClass == 0)        
        return;
        boolean animateZoom = mZoomManager.isFixedLengthAnimationInProgress();
        boolean animateScroll = ((!mScroller.isFinished()
                || mVelocityTracker != null)
                && (mTouchMode != TOUCH_DRAG_MODE ||
                mHeldMotionless != MOTIONLESS_TRUE))
                || mDeferTouchMode == TOUCH_DRAG_MODE;
    if(mTouchMode == TOUCH_DRAG_MODE)        
        {
    if(mHeldMotionless == MOTIONLESS_PENDING)            
            {
                mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                mHeldMotionless = MOTIONLESS_FALSE;
            } //End block
    if(mHeldMotionless == MOTIONLESS_FALSE)            
            {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(DRAG_HELD_MOTIONLESS), MOTIONLESS_TIME);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                mHeldMotionless = MOTIONLESS_PENDING;
            } //End block
        } //End block
        int saveCount = canvas.save();
    if(animateZoom)        
        {
            mZoomManager.animateZoom(canvas);
        } //End block
        else
    if(!canvas.isHardwareAccelerated())        
        {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
        } //End block
        boolean UIAnimationsRunning = false;
    if(mNativeClass != 0 && !canvas.isHardwareAccelerated()
                && nativeEvaluateLayersAnimations(mNativeClass))        
        {
            UIAnimationsRunning = true;
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
            invalidate();
        } //End block
        int extras = DRAW_EXTRAS_NONE;
    if(mFindIsUp)        
        {
            extras = DRAW_EXTRAS_FIND;
        } //End block
        else
    if(mSelectingText && (!USE_JAVA_TEXT_SELECTION || DEBUG_TEXT_HANDLES))        
        {
            extras = DRAW_EXTRAS_SELECTION;
            nativeSetSelectionPointer(mNativeClass,
                    mDrawSelectionPointer,
                    mZoomManager.getInvScale(), mSelectX, mSelectY - getTitleHeight());
        } //End block
        else
    if(drawCursorRing)        
        {
            extras = DRAW_EXTRAS_CURSOR_RING;
        } //End block
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        calcOurContentVisibleRectF(mVisibleContentRect);
    if(canvas.isHardwareAccelerated())        
        {
            Rect glRectViewport = mGLViewportEmpty ? null : mGLRectViewport;
            Rect viewRectViewport = mGLViewportEmpty ? null : mViewRectViewport;
            int functor = nativeGetDrawGLFunction(mNativeClass, glRectViewport,
                    viewRectViewport, mVisibleContentRect, getScale(), extras);
            ((HardwareCanvas) canvas).callDrawGLFunction(functor);
    if(mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled())            
            {
                mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                nativeUseHardwareAccelSkia(mHardwareAccelSkia);
            } //End block
        } //End block
        else
        {
            DrawFilter df = null;
    if(mZoomManager.isZoomAnimating() || UIAnimationsRunning)            
            {
                df = mZoomFilter;
            } //End block
            else
    if(animateScroll)            
            {
                df = mScrollFilter;
            } //End block
            canvas.setDrawFilter(df);
            int content = nativeDraw(canvas, mVisibleContentRect, color,
                    extras, false);
            canvas.setDrawFilter(null);
    if(!mBlockWebkitViewMessages && content != 0)            
            {
                mWebViewCore.sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
            } //End block
        } //End block
        canvas.restoreToCount(saveCount);
    if(mSelectingText && USE_JAVA_TEXT_SELECTION)        
        {
            drawTextSelectionHandles(canvas);
        } //End block
    if(extras == DRAW_EXTRAS_CURSOR_RING)        
        {
    if(mTouchMode == TOUCH_SHORTPRESS_START_MODE)            
            {
                mTouchMode = TOUCH_SHORTPRESS_MODE;
            } //End block
        } //End block
    if(mFocusSizeChanged)        
        {
            mFocusSizeChanged = false;
    if(!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode())            
            {
                didUpdateWebTextViewDimensions(ANYWHERE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.396 -0400", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "7125FB05B841B6C8BBD55BD8F5C63DB7")
    private void drawTextSelectionHandles(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mTextSelectionPaint == null)        
        {
            mTextSelectionPaint = new Paint();
            mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        } //End block
        mTextSelectionRegion.setEmpty();
        nativeGetTextSelectionRegion(mNativeClass, mTextSelectionRegion);
        Rect r = new Rect();
        RegionIterator iter = new RegionIterator(mTextSelectionRegion);
        Rect clip = canvas.getClipBounds();
        while
(iter.next(r))        
        {
            r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
    if(r.intersect(clip))            
            {
                canvas.drawRect(r, mTextSelectionPaint);
            } //End block
        } //End block
    if(mSelectHandleLeft == null)        
        {
            mSelectHandleLeft = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_left);
        } //End block
        int[] handles = new int[4];
        nativeGetSelectionHandles(mNativeClass, handles);
        int start_x = contentToViewDimension(handles[0]);
        int start_y = contentToViewDimension(handles[1]);
        int end_x = contentToViewDimension(handles[2]);
        int end_y = contentToViewDimension(handles[3]);
        start_x -= (mSelectHandleLeft.getIntrinsicWidth() * 3) / 4;
        mSelectHandleLeft.setBounds(start_x, start_y,
                start_x + mSelectHandleLeft.getIntrinsicWidth(),
                start_y + mSelectHandleLeft.getIntrinsicHeight());
    if(mSelectHandleRight == null)        
        {
            mSelectHandleRight = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_right);
        } //End block
        end_x -= mSelectHandleRight.getIntrinsicWidth() / 4;
        mSelectHandleRight.setBounds(end_x, end_y,
                end_x + mSelectHandleRight.getIntrinsicWidth(),
                end_y + mSelectHandleRight.getIntrinsicHeight());
    if(DEBUG_TEXT_HANDLES)        
        {
            mSelectHandleLeft.setAlpha(125);
            mSelectHandleRight.setAlpha(125);
        } //End block
        mSelectHandleLeft.draw(canvas);
        mSelectHandleRight.draw(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.396 -0400", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "B7D733EF759D9410C438CC776E92C889")
     boolean drawHistory() {
        boolean var94A720C55645969070AB4D7063CCF3B8_1885758308 = (mDrawHistory);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679500877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679500877;
        // ---------- Original Method ----------
        //return mDrawHistory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.397 -0400", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "EA08C4B37C385E73450831EC0C0363CA")
     int getHistoryPictureWidth() {
        int varEB6DA60D77A4B13FFFED15E023C63FFA_2116015696 = ((mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144970622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144970622;
        // ---------- Original Method ----------
        //return (mHistoryPicture != null) ? mHistoryPicture.getWidth() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.397 -0400", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "844CFA48080BB487235F29AF4AF5DDCB")
     void switchOutDrawHistory() {
    if(null == mWebViewCore)        
        return;
    if(mDrawHistory && (getProgress() == 100 || nativeHasContent()))        
        {
            mDrawHistory = false;
            mHistoryPicture = null;
            invalidate();
            int oldScrollX = mScrollX;
            int oldScrollY = mScrollY;
            mScrollX = pinLocX(mScrollX);
            mScrollY = pinLocY(mScrollY);
    if(oldScrollX != mScrollX || oldScrollY != mScrollY)            
            {
                onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
            } //End block
            else
            {
                sendOurVisibleRect();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.398 -0400", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "38E72674362CC08639569D8E3726B86B")
     WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData result = cursorDataNoPosition();
        Point position = nativeCursorPosition();
        result.mX = position.x;
        result.mY = position.y;
WebViewCore.CursorData varDC838461EE2FA0CA4C9BBB70A15456B0_793960849 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_793960849.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_793960849;
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = cursorDataNoPosition();
        //Point position = nativeCursorPosition();
        //result.mX = position.x;
        //result.mY = position.y;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.399 -0400", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "2C8D54F3A6B8E7FE65F0AD3D2D6492E0")
     WebViewCore.CursorData cursorDataNoPosition() {
        WebViewCore.CursorData result = new WebViewCore.CursorData();
        result.mMoveGeneration = nativeMoveGeneration();
        result.mFrame = nativeCursorFramePointer();
WebViewCore.CursorData varDC838461EE2FA0CA4C9BBB70A15456B0_2062221153 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2062221153.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2062221153;
        // ---------- Original Method ----------
        //WebViewCore.CursorData result = new WebViewCore.CursorData();
        //result.mMoveGeneration = nativeMoveGeneration();
        //result.mFrame = nativeCursorFramePointer();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.399 -0400", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "68C6216F4AF9ABD2E30193F4659D9493")
     void deleteSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        mTextGeneration++;
        WebViewCore.TextSelectionData data = new WebViewCore.TextSelectionData(start, end);
        mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                data);
        // ---------- Original Method ----------
        //mTextGeneration++;
        //WebViewCore.TextSelectionData data
                //= new WebViewCore.TextSelectionData(start, end);
        //mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                //data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.399 -0400", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "4D63D362E3FEBB06216D04ABD96B7747")
     void setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(mWebViewCore != null)        
        {
            mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.399 -0400", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "82D1034C95D3C793CD07812B5F24A636")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outAttrs.getTaint());
        InputConnection connection = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
InputConnection var9911BB1C5F1522C1630847C40E8BC67E_1718615068 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_1718615068.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_1718615068;
        // ---------- Original Method ----------
        //InputConnection connection = super.onCreateInputConnection(outAttrs);
        //outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.399 -0400", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "D82072B41E0CE0837FE8B6F4C96217F4")
    private void displaySoftKeyboard(boolean isTextView) {
        addTaint(isTextView);
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
    if(zoom)        
        {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        } //End block
    if(isTextView)        
        {
            rebuildWebTextView();
    if(inEditingMode())            
            {
                imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
    if(zoom)                
                {
                    didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                } //End block
                return;
            } //End block
        } //End block
        imm.showSoftInput(this, 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.401 -0400", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "1865C211F74F56750E99AE43C550F928")
    private void hideSoftKeyboard() {
        InputMethodManager imm = InputMethodManager.peekInstance();
    if(imm != null && (imm.isActive(this)
                || (inEditingMode() && imm.isActive(mWebTextView))))        
        {
            imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
        } //End block
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (imm != null && (imm.isActive(this)
                //|| (inEditingMode() && imm.isActive(mWebTextView)))) {
            //imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.401 -0400", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "CF00D5308255F6316F9249ED932A5F18")
     void rebuildWebTextView() {
    if(!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus()))        
        {
            return;
        } //End block
        boolean alreadyThere = inEditingMode();
    if(0 == mNativeClass || !nativeFocusCandidateIsTextInput())        
        {
    if(alreadyThere)            
            {
                mWebTextView.remove();
            } //End block
            return;
        } //End block
    if(mWebTextView == null)        
        {
            mWebTextView = new WebTextView(mContext, WebView.this, mAutoFillData.getQueryId());
            mTextGeneration = 0;
        } //End block
        mWebTextView.updateTextSize();
        updateWebTextViewPosition();
        String text = nativeFocusCandidateText();
        int nodePointer = nativeFocusCandidatePointer();
        mWebTextView.setNodePointer(nodePointer);
        mWebTextView.setType(nativeFocusCandidateType());
        mWebTextView.setGravityForRtl(nativeFocusCandidateIsRtlText());
    if(null == text)        
        {
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
            text = "";
        } //End block
        mWebTextView.setTextAndKeepSelection(text);
        InputMethodManager imm = InputMethodManager.peekInstance();
    if(imm != null && imm.isActive(mWebTextView))        
        {
            imm.restartInput(mWebTextView);
            mWebTextView.clearComposingText();
        } //End block
    if(isFocused())        
        {
            mWebTextView.requestFocus();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.402 -0400", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "B65BBFC6077D69A8BF765D442485FA8F")
    private void updateWebTextViewPosition() {
        Rect visibleRect = new Rect();
        calcOurContentVisibleRect(visibleRect);
        Rect bounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(bounds);
        offsetByLayerScrollPosition(vBox);
        mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
    if(!Rect.intersects(bounds, visibleRect))        
        {
            revealSelection();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.402 -0400", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "DE7AC7ED05CF3DF53B2D26EC442A9312")
     void updateWebTextViewPadding() {
        Rect paddingRect = nativeFocusCandidatePaddingRect();
    if(paddingRect != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.402 -0400", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "D195905CD9B47CBF5A3450AEECD8707D")
     void revealSelection() {
    if(mWebViewCore != null)        
        {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null) {
            //mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.403 -0400", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "000CFD00FF2AE7B7AE30423469D454B8")
     void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        addTaint(autoComplete);
        addTaint(autoFillable);
        addTaint(nodePointer);
        addTaint(name.getTaint());
    if(mWebViewCore.getSettings().getSaveFormData())        
        {
            Message update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
            update.arg1 = nodePointer;
            RequestFormData updater = new RequestFormData(name, getUrl(),
                    update, autoFillable, autoComplete);
            Thread t = new Thread(updater);
            t.start();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.403 -0400", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "11CDC0D25EE48B07E9F125EB70CADACF")
     void requestLabel(int framePointer, int nodePointer) {
        addTaint(nodePointer);
        addTaint(framePointer);
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                //nodePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.403 -0400", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "095BD32945AB1C2E270DEA25ED8552A3")
    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
        // ---------- Original Method ----------
        //nativeDumpDisplayTree(getUrl());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.403 -0400", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "4FBEFDC5954FC7B8022CAC2F2180D8CD")
    public void dumpDomTree(boolean toFile) {
        addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.404 -0400", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "5A1A5D199F58A2AD0DC5737A78055D5C")
    public void dumpRenderTree(boolean toFile) {
        addTaint(toFile);
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.404 -0400", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "5A01FAE035DC9B2B19C3CFCD95128CE9")
    public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.404 -0400", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "68A63BA9EB70A615422F89379ACDAD6F")
    public void setMockDeviceOrientation(boolean canProvideAlpha, double alpha,
            boolean canProvideBeta, double beta, boolean canProvideGamma, double gamma) {
        addTaint(gamma);
        addTaint(canProvideGamma);
        addTaint(beta);
        addTaint(canProvideBeta);
        addTaint(alpha);
        addTaint(canProvideAlpha);
        mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                canProvideGamma, gamma);
        // ---------- Original Method ----------
        //mWebViewCore.setMockDeviceOrientation(canProvideAlpha, alpha, canProvideBeta, beta,
                //canProvideGamma, gamma);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.406 -0400", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "AD73DDA9DEE4DBACADAAC65BAB256F86")
    public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.406 -0400", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "CDB2091B6466EBDA2E38C2925A952BB7")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
    if(mBlockWebkitViewMessages)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1118849247 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1718462462 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1718462462;
        } //End block
    if(keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null)        
        {
            mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            boolean varB326B5062B2F0E69046810717534CB09_189101300 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493576183 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493576183;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_374994219 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547219461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547219461;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.407 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "4E52C149ED60B8DA1FBEA19E6F6336B7")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var70CD4F4EC1EE6CA63BEE6D7DF6CF566D_44404485 = (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                || keyCode == KeyEvent.KEYCODE_ENTER
                || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1195541571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1195541571;
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.408 -0400", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "8906542E3355F3DB48697FC2C3B5B376")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if(mBlockWebkitViewMessages)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1263850172 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010230926 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010230926;
        } //End block
    if(event.isCtrlPressed())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1162203169 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610520374 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610520374;
        } //End block
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_638116109 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_642527740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_642527740;
        } //End block
    if(AUTO_REDRAW_HACK && (keyCode == KeyEvent.KEYCODE_CALL))        
        {
            mAutoRedraw = !mAutoRedraw;
    if(mAutoRedraw)            
            {
                invalidate();
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_668031367 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498688354 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_498688354;
        } //End block
    if(event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event))        
        {
            boolean var68934A3E9455FA72420237EB05902327_859598773 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355717686 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_355717686;
        } //End block
    if(accessibilityScriptInjected())        
        {
    if(AccessibilityManager.getInstance(mContext).isEnabled())            
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                boolean varB326B5062B2F0E69046810717534CB09_302889519 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515771095 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_515771095;
            } //End block
            else
            {
                mAccessibilityScriptInjected = false;
            } //End block
        } //End block
        else
    if(mAccessibilityInjector != null)        
        {
    if(AccessibilityManager.getInstance(mContext).isEnabled())            
            {
    if(mAccessibilityInjector.onKeyEvent(event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_349635931 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1039061691 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1039061691;
                } //End block
            } //End block
            else
            {
                mAccessibilityInjector = null;
            } //End block
        } //End block
    if(keyCode == KeyEvent.KEYCODE_PAGE_UP)        
        {
    if(event.hasNoModifiers())            
            {
                pageUp(false);
                boolean varB326B5062B2F0E69046810717534CB09_1062983154 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969853167 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969853167;
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                pageUp(true);
                boolean varB326B5062B2F0E69046810717534CB09_1848138713 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074776525 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074776525;
            } //End block
        } //End block
    if(keyCode == KeyEvent.KEYCODE_PAGE_DOWN)        
        {
    if(event.hasNoModifiers())            
            {
                pageDown(false);
                boolean varB326B5062B2F0E69046810717534CB09_472692120 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552753701 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552753701;
            } //End block
            else
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
                pageDown(true);
                boolean varB326B5062B2F0E69046810717534CB09_987964199 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257681916 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_257681916;
            } //End block
        } //End block
    if(keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers())        
        {
            pageUp(true);
            boolean varB326B5062B2F0E69046810717534CB09_2093096326 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612145267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_612145267;
        } //End block
    if(keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers())        
        {
            pageDown(true);
            boolean varB326B5062B2F0E69046810717534CB09_845135594 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492866412 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_492866412;
        } //End block
    if(keyCode >= KeyEvent.KEYCODE_DPAD_UP
                && keyCode <= KeyEvent.KEYCODE_DPAD_RIGHT)        
        {
            switchOutDrawHistory();
    if(nativePageShouldHandleShiftAndArrows())            
            {
                letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                boolean varB326B5062B2F0E69046810717534CB09_1735561511 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440579631 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440579631;
            } //End block
    if(event.hasModifiers(KeyEvent.META_ALT_ON))            
            {
switch(keyCode){
                case KeyEvent.KEYCODE_DPAD_UP:
                pageUp(true);
                boolean varB326B5062B2F0E69046810717534CB09_264476639 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_444338895 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_444338895;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                pageDown(true);
                boolean varB326B5062B2F0E69046810717534CB09_623154974 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559155127 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559155127;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                nativeClearCursor();
                boolean var7468790FAEF4239B5A83FF5E25100267_1803601301 = (pinScrollTo(0, mScrollY, true, 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755840581 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755840581;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                nativeClearCursor();
                boolean varAD0D85BDA19EC4CA5C0A4CED04C93479_1081640718 = (pinScrollTo(mContentWidth, mScrollY, true, 0));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755765885 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755765885;
}
            } //End block
    if(mSelectingText)            
            {
                int xRate = keyCode == KeyEvent.KEYCODE_DPAD_LEFT
                    ? -1 : keyCode == KeyEvent.KEYCODE_DPAD_RIGHT ? 1 : 0;
                int yRate = keyCode == KeyEvent.KEYCODE_DPAD_UP ?
                    -1 : keyCode == KeyEvent.KEYCODE_DPAD_DOWN ? 1 : 0;
                int multiplier = event.getRepeatCount() + 1;
                moveSelection(xRate * multiplier, yRate * multiplier);
                boolean varB326B5062B2F0E69046810717534CB09_551750859 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366198551 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_366198551;
            } //End block
    if(navHandledKey(keyCode, 1, false, event.getEventTime()))            
            {
                playSoundEffect(keyCodeToSoundsEffect(keyCode));
                boolean varB326B5062B2F0E69046810717534CB09_557532360 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20322714 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_20322714;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1057997136 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399794725 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399794725;
        } //End block
    if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER)        
        {
            switchOutDrawHistory();
            boolean wantsKeyEvents = nativeCursorNodePointer() == 0
                || nativeCursorWantsKeyEvents();
    if(event.getRepeatCount() == 0)            
            {
    if(mSelectingText)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_716970473 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235731215 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_235731215;
                } //End block
                mGotCenterDown = true;
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
    if(!wantsKeyEvents)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1106482835 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520698325 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_520698325;
                }
            } //End block
    if(!wantsKeyEvents)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1215902652 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524943073 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524943073;
            }
        } //End block
    if(getSettings().getNavDump())        
        {
switch(keyCode){
            case KeyEvent.KEYCODE_4:
            dumpDisplayTree();
            break;
            case KeyEvent.KEYCODE_5:
            case KeyEvent.KEYCODE_6:
            dumpDomTree(keyCode == KeyEvent.KEYCODE_5);
            break;
            case KeyEvent.KEYCODE_7:
            case KeyEvent.KEYCODE_8:
            dumpRenderTree(keyCode == KeyEvent.KEYCODE_7);
            break;
            case KeyEvent.KEYCODE_9:
            nativeInstrumentReport();
            boolean varB326B5062B2F0E69046810717534CB09_600979677 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129910661 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129910661;
}
        } //End block
    if(nativeCursorIsTextInput())        
        {
            mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
            rebuildWebTextView();
    if(inEditingMode())            
            {
                mWebTextView.setDefaultSelection();
                boolean varE374527F3251E6C7C06DEF18EFBA143A_537929543 = (mWebTextView.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020253429 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020253429;
            } //End block
        } //End block
        else
    if(nativeHasFocusNode())        
        {
            rebuildWebTextView();
    if(inEditingMode())            
            {
                mWebTextView.setDefaultSelection();
                boolean varE374527F3251E6C7C06DEF18EFBA143A_1507214521 = (mWebTextView.dispatchKeyEvent(event));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862426080 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_862426080;
            } //End block
        } //End block
    if(nativeCursorWantsKeyEvents() || true)        
        {
            mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            boolean varB326B5062B2F0E69046810717534CB09_71305995 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1953301985 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1953301985;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1078649523 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773919859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773919859;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.412 -0400", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "FBF1D1405E6FB8BCD13F5D5855A13151")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if(mBlockWebkitViewMessages)        
        {
            boolean var68934A3E9455FA72420237EB05902327_900402535 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353718029 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353718029;
        } //End block
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_602595047 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_998294143 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_998294143;
        } //End block
    if(keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode())        
        {
            String text = nativeCursorText();
    if(!nativeCursorIsTextInput() && text != null
                    && text.startsWith(SCHEME_TEL))            
            {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(text));
                getContext().startActivity(intent);
                boolean varB326B5062B2F0E69046810717534CB09_1101344334 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553620999 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_553620999;
            } //End block
        } //End block
    if(event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1903213070 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348285712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348285712;
        } //End block
    if(accessibilityScriptInjected())        
        {
    if(AccessibilityManager.getInstance(mContext).isEnabled())            
            {
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
                boolean varB326B5062B2F0E69046810717534CB09_544359920 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197255840 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197255840;
            } //End block
            else
            {
                mAccessibilityScriptInjected = false;
            } //End block
        } //End block
        else
    if(mAccessibilityInjector != null)        
        {
    if(AccessibilityManager.getInstance(mContext).isEnabled())            
            {
    if(mAccessibilityInjector.onKeyEvent(event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1530028178 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_919142322 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_919142322;
                } //End block
            } //End block
            else
            {
                mAccessibilityInjector = null;
            } //End block
        } //End block
    if(keyCode >= KeyEvent.KEYCODE_DPAD_UP
                && keyCode <= KeyEvent.KEYCODE_DPAD_RIGHT)        
        {
    if(nativePageShouldHandleShiftAndArrows())            
            {
                letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                boolean varB326B5062B2F0E69046810717534CB09_175902711 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018584811 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018584811;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_775743589 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745709038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745709038;
        } //End block
    if(isEnterActionKey(keyCode))        
        {
            mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            mGotCenterDown = false;
    if(mSelectingText)            
            {
    if(mExtendSelection)                
                {
                    copySelection();
                    selectionDone();
                } //End block
                else
                {
                    mExtendSelection = true;
                    nativeSetExtendSelection();
                    invalidate();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_1004310430 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1354009426 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1354009426;
            } //End block
            Rect visibleRect = sendOurVisibleRect();
    if(!nativeCursorIntersects(visibleRect))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1968603954 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308140476 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308140476;
            } //End block
            WebViewCore.CursorData data = cursorData();
            mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
            playSoundEffect(SoundEffectConstants.CLICK);
    if(nativeCursorIsTextInput())            
            {
                rebuildWebTextView();
                centerKeyPressOnTextField();
    if(inEditingMode())                
                {
                    mWebTextView.setDefaultSelection();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_378648823 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300595413 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300595413;
            } //End block
            clearTextEntry();
            nativeShowCursorTimed();
    if(mCallbackProxy.uiOverrideUrlLoading(nativeCursorText()))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_170573 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794278589 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_794278589;
            } //End block
    if(nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents())            
            {
                mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                boolean varB326B5062B2F0E69046810717534CB09_1905877639 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070806295 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070806295;
            } //End block
        } //End block
    if(nativeCursorWantsKeyEvents() || true)        
        {
            mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            boolean varB326B5062B2F0E69046810717534CB09_1874587861 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1020246643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1020246643;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_336870410 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316084159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316084159;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.416 -0400", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "A7B5D12F7CB86D2676CAA3D78975EC36")
    private boolean setUpSelect(boolean selectWord, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(selectWord);
    if(0 == mNativeClass)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1935030540 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003966976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003966976;
        }
    if(inFullScreenMode())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1315710212 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1375062968 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1375062968;
        }
    if(mSelectingText)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_739902674 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421738328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_421738328;
        }
        nativeResetSelection();
    if(selectWord && !nativeWordSelection(x, y))        
        {
            selectionDone();
            boolean var68934A3E9455FA72420237EB05902327_2068708875 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835332961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_835332961;
        } //End block
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
    if(startActionMode(mSelectCallback) == null)        
        {
            selectionDone();
            boolean var68934A3E9455FA72420237EB05902327_1079285849 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_683928134 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_683928134;
        } //End block
        mExtendSelection = false;
        mSelectingText = mDrawSelectionPointer = true;
    if(DEBUG_TEXT_HANDLES)        
        {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        } //End block
        WebViewCore.pauseUpdatePicture(mWebViewCore);
    if(nativeHasCursorNode())        
        {
            Rect rect = nativeCursorNodeBounds();
            mSelectX = contentToViewX(rect.left);
            mSelectY = contentToViewY(rect.top);
        } //End block
        else
    if(mLastTouchY > getVisibleTitleHeightImpl())        
        {
            mSelectX = mScrollX + mLastTouchX;
            mSelectY = mScrollY + mLastTouchY;
        } //End block
        else
        {
            mSelectX = mScrollX + getViewWidth() / 2;
            mSelectY = mScrollY + getViewHeightWithTitle() / 2;
        } //End block
        nativeHideCursor();
        mMinAutoScrollX = 0;
        mMaxAutoScrollX = getViewWidth();
        mMinAutoScrollY = 0;
        mMaxAutoScrollY = getViewHeightWithTitle();
        mCurrentScrollingLayerId = nativeScrollableLayer(viewToContentX(mSelectX),
                viewToContentY(mSelectY), mScrollingLayerRect,
                mScrollingLayerBounds);
    if(mCurrentScrollingLayerId != 0)        
        {
    if(mScrollingLayerRect.left != mScrollingLayerRect.right)            
            {
                mMinAutoScrollX = Math.max(mMinAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.left));
                mMaxAutoScrollX = Math.min(mMaxAutoScrollX,
                        contentToViewX(mScrollingLayerBounds.right));
            } //End block
    if(mScrollingLayerRect.top != mScrollingLayerRect.bottom)            
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
        boolean varB326B5062B2F0E69046810717534CB09_1606656739 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985250549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985250549;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.416 -0400", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "397EF000EB5841A9556B40D05B9E7E33")
    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
        // ---------- Original Method ----------
        //checkThread();
        //setUpSelect(false, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.417 -0400", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "68805AB78CC7EA309DD065BBBCD9FF19")
    public void selectAll() {
    if(0 == mNativeClass)        
        return;
    if(inFullScreenMode())        
        return;
    if(!mSelectingText)        
        {
            Point select = nativeSelectableText();
    if(!selectText(select.x, select.y))            
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.418 -0400", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "422E23AEB07EC7FBC6D0343161413EA2")
     void selectionDone() {
    if(mSelectingText)        
        {
            mSelectingText = false;
    if(DEBUG_TEXT_HANDLES)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.418 -0400", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "756527C6FAB879A6F6D91FA5FCEB32DA")
    public boolean copySelection() {
        boolean copiedSomething = false;
        String selection = getSelection();
    if(selection != null && selection != "")        
        {
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
            Toast.makeText(mContext
                    , com.android.internal.R.string.text_copied
                    , Toast.LENGTH_SHORT).show();
            copiedSomething = true;
            ClipboardManager cm = (ClipboardManager)getContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(selection);
        } //End block
        invalidate();
        boolean varBE294C7FCF508B07FE5ABD720C5FD29B_1545497619 = (copiedSomething);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303923209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303923209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.418 -0400", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "5D30A907E1D9B4C64B254BB925ED1F4B")
    public SearchBox getSearchBox() {
    if((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null))        
        {
SearchBox var540C13E9E156B687226421B24F2DF178_545725275 =             null;
            var540C13E9E156B687226421B24F2DF178_545725275.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_545725275;
        } //End block
SearchBox var07AA8F1B7DBAB2E330E37B2ABC2FD4DC_492639445 =         mWebViewCore.getBrowserFrame().getSearchBox();
        var07AA8F1B7DBAB2E330E37B2ABC2FD4DC_492639445.addTaint(taint);
        return var07AA8F1B7DBAB2E330E37B2ABC2FD4DC_492639445;
        // ---------- Original Method ----------
        //if ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null)) {
            //return null;
        //}
        //return mWebViewCore.getBrowserFrame().getSearchBox();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.420 -0400", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "B0B7EFB12F6E6F8CA89C892A3751F173")
     String getSelection() {
    if(mNativeClass == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1049435983 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1049435983.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1049435983;
        }
String varF85628CF6C2DBDD3244BAA520BECF1DA_1010761095 =         nativeGetSelection();
        varF85628CF6C2DBDD3244BAA520BECF1DA_1010761095.addTaint(taint);
        return varF85628CF6C2DBDD3244BAA520BECF1DA_1010761095;
        // ---------- Original Method ----------
        //if (mNativeClass == 0) return "";
        //return nativeGetSelection();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.421 -0400", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "B7D1BB8842F9B9FC70C97B21A14ED5CE")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
    if(hasWindowFocus())        
        setActive(true);
        final ViewTreeObserver treeObserver = getViewTreeObserver();
    if(mGlobalLayoutListener == null)        
        {
            mGlobalLayoutListener = new InnerGlobalLayoutListener();
            treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        } //End block
    if(mScrollChangedListener == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.421 -0400", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "771B186037DE7F7679A8572F028C3048")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        clearHelpers();
        mZoomManager.dismissZoomPicker();
    if(hasWindowFocus())        
        setActive(false);
        final ViewTreeObserver treeObserver = getViewTreeObserver();
    if(mGlobalLayoutListener != null)        
        {
            treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            mGlobalLayoutListener = null;
        } //End block
    if(mScrollChangedListener != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.421 -0400", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "F2F97AE31B49CB47C081010DE6FAB09E")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(changedView.getTaint());
        super.onVisibilityChanged(changedView, visibility);
    if(visibility != View.VISIBLE && mZoomManager != null)        
        {
            mZoomManager.dismissZoomPicker();
        } //End block
        updateDrawingState();
        // ---------- Original Method ----------
        //super.onVisibilityChanged(changedView, visibility);
        //if (visibility != View.VISIBLE && mZoomManager != null) {
            //mZoomManager.dismissZoomPicker();
        //}
        //updateDrawingState();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.421 -0400", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "1AF1B3DDAE61DC0E5428556A33A15E13")
    @Deprecated
    public void onChildViewAdded(View parent, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(child.getTaint());
        addTaint(parent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.422 -0400", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "0108A2C2A3FFC6D4E3404B8B9CA0F455")
    @Deprecated
    public void onChildViewRemoved(View p, View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(child.getTaint());
        addTaint(p.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.422 -0400", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "8EA661CD453ECE394AF7766CC3210E74")
    @Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newFocus.getTaint());
        addTaint(oldFocus.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.422 -0400", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "946527AC45F0660CA35F162533AFA4F7")
     void setActive(boolean active) {
        addTaint(active);
    if(active)        
        {
    if(hasFocus())            
            {
                mDrawCursorRing = !inEditingMode();
                setFocusControllerActive(true);
            } //End block
            else
            {
                mDrawCursorRing = false;
    if(!inEditingMode())                
                {
                    setFocusControllerActive(false);
                } //End block
            } //End block
        } //End block
        else
        {
    if(!mZoomManager.isZoomPickerVisible())            
            {
                mDrawCursorRing = false;
            } //End block
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            mTouchMode = TOUCH_DONE_MODE;
            setFocusControllerActive(false);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.423 -0400", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "3F8E5E6AE95728B0FE5EC7ADE0E0E195")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        setActive(hasWindowFocus);
    if(hasWindowFocus)        
        {
            JWebCoreJavaBridge.setActiveWebView(this);
    if(mPictureUpdatePausedForFocusChange)            
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = false;
            } //End block
        } //End block
        else
        {
            JWebCoreJavaBridge.removeActiveWebView(this);
            final WebSettings settings = getSettings();
    if(settings != null && settings.enableSmoothTransition() &&
                    mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore))            
            {
                WebViewCore.pauseUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = true;
            } //End block
        } //End block
        super.onWindowFocusChanged(hasWindowFocus);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.424 -0400", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "8A16C527A0457711EABB04DB8507072F")
     void setFocusControllerActive(boolean active) {
        addTaint(active);
    if(mWebViewCore == null)        
        return;
        mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
    if(active && mListBoxMessage != null)        
        {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore == null) return;
        //mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        //if (active && mListBoxMessage != null) {
            //mWebViewCore.sendMessage(mListBoxMessage);
            //mListBoxMessage = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.424 -0400", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "C1ECC5FB0DE74BBA3C0D204BC831F3D3")
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(focused);
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if(focused)        
        {
    if(hasWindowFocus())            
            {
                mDrawCursorRing = !inEditingMode();
                setFocusControllerActive(true);
            } //End block
        } //End block
        else
        {
            mDrawCursorRing = false;
    if(!inEditingMode())            
            {
                setFocusControllerActive(false);
            } //End block
            mKeysPressed.clear();
        } //End block
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.425 -0400", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "22270C74E6DD214693175E5C99599154")
     void setGLRectViewport() {
        boolean visible = getGlobalVisibleRect(mGLRectViewport);
    if(visible)        
        {
            View rootView = getRootView();
            int rootViewHeight = rootView.getHeight();
            mViewRectViewport.set(mGLRectViewport);
            int savedWebViewBottom = mGLRectViewport.bottom;
            mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            mGLViewportEmpty = false;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.427 -0400", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "F03A5BD0931620392DE8A7D6A9609C3F")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean changed = super.setFrame(left, top, right, bottom);
    if(!changed && mHeightCanMeasure)        
        {
            sendViewSizeZoom(false);
        } //End block
        setGLRectViewport();
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_1065867873 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496930607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496930607;
        // ---------- Original Method ----------
        //boolean changed = super.setFrame(left, top, right, bottom);
        //if (!changed && mHeightCanMeasure) {
            //sendViewSizeZoom(false);
        //}
        //setGLRectViewport();
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.427 -0400", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "A6C82D66F1D3113D8F06ED9E165B5B9A")
    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oh);
        addTaint(ow);
        addTaint(h);
        addTaint(w);
        super.onSizeChanged(w, h, ow, oh);
        int newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
    if(newMaxViewportWidth > sMaxViewportWidth)        
        {
            sMaxViewportWidth = newMaxViewportWidth;
        } //End block
        mZoomManager.onSizeChanged(w, h, ow, oh);
    if(mLoadedPicture != null && mDelaySetPicture == null)        
        {
            setNewPicture(mLoadedPicture, false);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.427 -0400", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "24B45946C3F9BAA1E4117315172DA423")
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldt);
        addTaint(oldl);
        addTaint(t);
        addTaint(l);
        super.onScrollChanged(l, t, oldl, oldt);
    if(!mInOverScrollMode)        
        {
            sendOurVisibleRect();
            int titleHeight = getTitleHeight();
    if(Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0))            
            {
                sendViewSizeZoom(false);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.427 -0400", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "D1E6C3A8AA393FC80C637C4F17E721B3")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
switch(event.getAction()){
        case KeyEvent.ACTION_DOWN:
        mKeysPressed.add(Integer.valueOf(event.getKeyCode()));
        break;
        case KeyEvent.ACTION_MULTIPLE:
        break;
        case KeyEvent.ACTION_UP:
        int location = mKeysPressed.indexOf(Integer.valueOf(event.getKeyCode()));
    if(location == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_169272829 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_31515745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_31515745;
        } //End block
        else
        {
            mKeysPressed.remove(location);
        } //End block
        break;
        default:
        break;
}    if(inEditingMode() && mWebTextView.isFocused())        
        {
            boolean varE374527F3251E6C7C06DEF18EFBA143A_1243055423 = (mWebTextView.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878961734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878961734;
        } //End block
        else
        {
            boolean var639DD27D10E8FF69097B1398D445D1B9_279293459 = (super.dispatchKeyEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511267156 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_511267156;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.429 -0400", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "BC20FCC84528CFC2214428150EE523EC")
    private boolean hitFocusedPlugin(int contentX, int contentY) {
        addTaint(contentY);
        addTaint(contentX);
    if(DebugFlags.WEB_VIEW)        
        {
            Rect r = nativeFocusNodeBounds();
        } //End block
        boolean var84C8F71178512CD995AE8FBE10A4615E_1230525727 = (nativeFocusIsPlugin()
                && nativeFocusNodeBounds().contains(contentX, contentY));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974650839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974650839;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.429 -0400", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "BDCF671795F80F96A47A359C0C22D214")
    private boolean shouldForwardTouchEvent() {
    if(mFullScreenHolder != null)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1088039797 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046582927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046582927;
        }
    if(mBlockWebkitViewMessages)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1316064465 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804668260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804668260;
        }
        boolean var391D8A6A20CECDA23B774D54B30E03FB_1767418916 = (mForwardTouchEvents
                && !mSelectingText
                && mPreventDefault != PREVENT_DEFAULT_IGNORE
                && mPreventDefault != PREVENT_DEFAULT_NO);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107271942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107271942;
        // ---------- Original Method ----------
        //if (mFullScreenHolder != null) return true;
        //if (mBlockWebkitViewMessages) return false;
        //return mForwardTouchEvents
                //&& !mSelectingText
                //&& mPreventDefault != PREVENT_DEFAULT_IGNORE
                //&& mPreventDefault != PREVENT_DEFAULT_NO;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.429 -0400", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "26B3A01575B029B3E5B0A1D839F93859")
    private boolean inFullScreenMode() {
        boolean var0EF4E33ED660D4A81C2C55B9F26DE750_1821440310 = (mFullScreenHolder != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159126183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159126183;
        // ---------- Original Method ----------
        //return mFullScreenHolder != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.429 -0400", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "854D63CAE75DE8141B96187C2146E590")
    private void dismissFullScreenMode() {
    if(inFullScreenMode())        
        {
            mFullScreenHolder.hide();
            mFullScreenHolder = null;
        } //End block
        // ---------- Original Method ----------
        //if (inFullScreenMode()) {
            //mFullScreenHolder.hide();
            //mFullScreenHolder = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.429 -0400", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "ADA24DB953E0EB7EB11E71E67325FC31")
     void onPinchToZoomAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        cancelTouch();
        onZoomAnimationStart();
        // ---------- Original Method ----------
        //cancelTouch();
        //onZoomAnimationStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.430 -0400", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "2A4002AACFB507E526D66B858C2C9948")
     void onPinchToZoomAnimationEnd(ScaleGestureDetector detector) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(detector.getTaint());
        onZoomAnimationEnd();
        mTouchMode = TOUCH_PINCH_DRAG;
        mConfirmMove = true;
        startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
        // ---------- Original Method ----------
        //onZoomAnimationEnd();
        //mTouchMode = TOUCH_PINCH_DRAG;
        //mConfirmMove = true;
        //startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.430 -0400", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "3657409C6D0449ABA558E952A031FBF0")
    private void startScrollingLayer(float x, float y) {
        addTaint(y);
        addTaint(x);
        int contentX = viewToContentX((int) x + mScrollX);
        int contentY = viewToContentY((int) y + mScrollY);
        mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                mScrollingLayerRect, mScrollingLayerBounds);
    if(mCurrentScrollingLayerId != 0)        
        {
            mTouchMode = TOUCH_DRAG_LAYER_MODE;
        } //End block
        // ---------- Original Method ----------
        //int contentX = viewToContentX((int) x + mScrollX);
        //int contentY = viewToContentY((int) y + mScrollY);
        //mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                //mScrollingLayerRect, mScrollingLayerBounds);
        //if (mCurrentScrollingLayerId != 0) {
            //mTouchMode = TOUCH_DRAG_LAYER_MODE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.431 -0400", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "1EB292D7080B1B67607700B3A945C3E6")
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_134157057 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136450269 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_136450269;
        } //End block
        WebViewCore.CursorData data = cursorDataNoPosition();
        data.mX = viewToContentX((int) event.getX() + mScrollX);
        data.mY = viewToContentY((int) event.getY() + mScrollY);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        boolean varB326B5062B2F0E69046810717534CB09_461562001 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545273275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545273275;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.431 -0400", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "4782A0C0ECFE48997A4467AF022FE1DC")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
    if(mNativeClass == 0 || (!isClickable() && !isLongClickable()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1309271378 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107287596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_107287596;
        } //End block
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if(ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO)        
        {
            passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
        } //End block
        else
        {
            mTouchEventQueue.enqueueTouchEvent(ev);
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1199407212 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144825750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144825750;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.432 -0400", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "772946FD3BA808A42612A8503316A113")
    private float calculateDragAngle(int dx, int dy) {
        addTaint(dy);
        addTaint(dx);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        float varE8467E5398FA970C48BF909C486D155E_401129793 = ((float) Math.atan2(dy, dx));
                float var546ADE640B6EDFBC8A086EF31347E768_1264302927 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1264302927;
        // ---------- Original Method ----------
        //dx = Math.abs(dx);
        //dy = Math.abs(dy);
        //return (float) Math.atan2(dy, dx);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.448 -0400", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "1E6757EF907BD014DEF4BC20AFC06B5B")
    private boolean handleTouchEventCommon(MotionEvent ev, int action, int x, int y) {
        addTaint(action);
        addTaint(ev.getTaint());
        long eventTime = ev.getEventTime();
        x = Math.min(x, getViewWidth() - 1);
        y = Math.min(y, getViewHeightWithTitle() - 1);
        int deltaX = mLastTouchX - x;
        int deltaY = mLastTouchY - y;
        int contentX = viewToContentX(x + mScrollX);
        int contentY = viewToContentY(y + mScrollY);
switch(action){
        case MotionEvent.ACTION_DOWN:
        {
            mPreventDefault = PREVENT_DEFAULT_NO;
            mConfirmMove = false;
            mInitialHitTestResult = null;
    if(!mScroller.isFinished())            
            {
                mScroller.abortAnimation();
                mTouchMode = TOUCH_DRAG_START_MODE;
                mConfirmMove = true;
                nativeSetIsScrolling(false);
            } //End block
            else
    if(mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP))            
            {
                mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
    if(USE_WEBKIT_RINGS || getSettings().supportTouchOnly())                
                {
                    removeTouchHighlight();
                } //End block
    if(deltaX * deltaX + deltaY * deltaY < mDoubleTapSlopSquare)                
                {
                    mTouchMode = TOUCH_DOUBLE_TAP_MODE;
                } //End block
                else
                {
                    doShortPress();
                    mTouchMode = TOUCH_INIT_MODE;
                    mDeferTouchProcess = !mBlockWebkitViewMessages
                                && (!inFullScreenMode() && mForwardTouchEvents)
                                ? hitFocusedPlugin(contentX, contentY)
                                : false;
                } //End block
            } //End block
            else
            {
                mTouchMode = TOUCH_INIT_MODE;
                mDeferTouchProcess = !mBlockWebkitViewMessages
                            && (!inFullScreenMode() && mForwardTouchEvents)
                            ? hitFocusedPlugin(contentX, contentY)
                            : false;
    if(!mBlockWebkitViewMessages)                
                {
                    mWebViewCore.sendMessage(
                                EventHub.UPDATE_FRAME_CACHE_IF_LOADING);
                } //End block
    if(USE_WEBKIT_RINGS || getSettings().supportTouchOnly())                
                {
                    TouchHighlightData data = new TouchHighlightData();
                    data.mX = contentX;
                    data.mY = contentY;
                    data.mNativeLayerRect = new Rect();
                    data.mNativeLayer = nativeScrollableLayer(
                                contentX, contentY, data.mNativeLayerRect, null);
                    data.mSlop = viewToContentDimension(mNavSlop);
                    mTouchHighlightRegion.setEmpty();
    if(!mBlockWebkitViewMessages)                    
                    {
                        mTouchHighlightRequested = System.currentTimeMillis();
                        mWebViewCore.sendMessageAtFrontOfQueue(
                                    EventHub.GET_TOUCH_HIGHLIGHT_RECTS, data);
                    } //End block
    if(DEBUG_TOUCH_HIGHLIGHT)                    
                    {
    if(getSettings().getNavDump())                        
                        {
                            mTouchHighlightX = (int) x + mScrollX;
                            mTouchHighlightY = (int) y + mScrollY;
                            mPrivateHandler.postDelayed(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.435 -0400", hash_original_method = "7498706CCC2860B05B7071008D2A72AF", hash_generated_method = "BDEB34128B671E054A924D53CAF12B4F")
        public void run() {
            mTouchHighlightX = mTouchHighlightY = 0;
            invalidate();
            // ---------- Original Method ----------
            //mTouchHighlightX = mTouchHighlightY = 0;
            //invalidate();
        }
}, TOUCH_HIGHLIGHT_ELAPSE_TIME);
                        } //End block
                    } //End block
                } //End block
    if(mLogEvent && eventTime - mLastTouchUpTime < 1000)                
                {
                    EventLog.writeEvent(EventLogTags.BROWSER_DOUBLE_TAP_DURATION,
                                (eventTime - mLastTouchUpTime), eventTime);
                } //End block
    if(mSelectingText)                
                {
                    mDrawSelectionPointer = false;
                    mSelectionStarted = nativeStartSelection(contentX, contentY);
    if(DebugFlags.WEB_VIEW)                    
                    {
                    } //End block
                    invalidate();
                } //End block
            } //End block
    if(!mSelectingText && (mTouchMode == TOUCH_INIT_MODE
                        || mTouchMode == TOUCH_DOUBLE_TAP_MODE))            
            {
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_SHORTPRESS, TAP_TIMEOUT);
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_LONGPRESS, LONG_PRESS_TIMEOUT);
    if(inFullScreenMode() || mDeferTouchProcess)                
                {
                    mPreventDefault = PREVENT_DEFAULT_YES;
                } //End block
                else
    if(!mBlockWebkitViewMessages && mForwardTouchEvents)                
                {
                    mPreventDefault = PREVENT_DEFAULT_MAYBE_YES;
                } //End block
                else
                {
                    mPreventDefault = PREVENT_DEFAULT_NO;
                } //End block
    if(shouldForwardTouchEvent())                
                {
                    TouchEventData ted = new TouchEventData();
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
    if(mDeferTouchProcess)                    
                    {
                        mLastTouchX = x;
                        mLastTouchY = y;
                        break;
                    } //End block
    if(!inFullScreenMode())                    
                    {
                        mPrivateHandler.removeMessages(PREVENT_DEFAULT_TIMEOUT);
                        mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                    .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                            action, 0), TAP_TIMEOUT);
                    } //End block
                } //End block
            } //End block
            startTouch(x, y, eventTime);
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
        {
            boolean firstMove = false;
    if(!mConfirmMove && (deltaX * deltaX + deltaY * deltaY)
                        >= mTouchSlopSquare)            
            {
                mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                mConfirmMove = true;
                firstMove = true;
    if(mTouchMode == TOUCH_DOUBLE_TAP_MODE)                
                {
                    mTouchMode = TOUCH_INIT_MODE;
                } //End block
    if(USE_WEBKIT_RINGS || getSettings().supportTouchOnly())                
                {
                    removeTouchHighlight();
                } //End block
            } //End block
    if(shouldForwardTouchEvent() && mConfirmMove && (firstMove
                        || eventTime - mLastSentTouchTime > mCurrentTouchInterval))            
            {
                TouchEventData ted = new TouchEventData();
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
    if(mDeferTouchProcess)                
                {
                    break;
                } //End block
    if(firstMove && !inFullScreenMode())                
                {
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                        action, 0), TAP_TIMEOUT);
                } //End block
            } //End block
    if(mTouchMode == TOUCH_DONE_MODE
                        || mPreventDefault == PREVENT_DEFAULT_YES)            
            {
                break;
            } //End block
    if(mVelocityTracker == null)            
            {
            } //End block
            else
            {
                mVelocityTracker.addMovement(ev);
            } //End block
    if(mSelectingText && mSelectionStarted)            
            {
    if(DebugFlags.WEB_VIEW)                
                {
                } //End block
                ViewParent parent = getParent();
    if(parent != null)                
                {
                    parent.requestDisallowInterceptTouchEvent(true);
                } //End block
                mAutoScrollX = x <= mMinAutoScrollX ? -SELECT_SCROLL
                            : x >= mMaxAutoScrollX ? SELECT_SCROLL : 0;
                mAutoScrollY = y <= mMinAutoScrollY ? -SELECT_SCROLL
                            : y >= mMaxAutoScrollY ? SELECT_SCROLL : 0;
    if((mAutoScrollX != 0 || mAutoScrollY != 0)
                            && !mSentAutoScrollMessage)                
                {
                    mSentAutoScrollMessage = true;
                    mPrivateHandler.sendEmptyMessageDelayed(
                                SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                } //End block
    if(deltaX != 0 || deltaY != 0)                
                {
                    nativeExtendSelection(contentX, contentY);
                    invalidate();
                } //End block
                break;
            } //End block
    if(mTouchMode != TOUCH_DRAG_MODE &&
                        mTouchMode != TOUCH_DRAG_LAYER_MODE)            
            {
    if(!mConfirmMove)                
                {
                    break;
                } //End block
    if(mPreventDefault == PREVENT_DEFAULT_MAYBE_YES
                            || mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN)                
                {
                    mLastTouchTime = eventTime;
                    break;
                } //End block
                final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                mAverageAngle = calculateDragAngle(deltaX, deltaY);
    if(detector == null || !detector.isInProgress())                
                {
    if(mAverageAngle < HSLOPE_TO_START_SNAP)                    
                    {
                        mSnapScrollMode = SNAP_X;
                        mSnapPositive = deltaX > 0;
                        mAverageAngle = ANGLE_HORIZ;
                    } //End block
                    else
    if(mAverageAngle > VSLOPE_TO_START_SNAP)                    
                    {
                        mSnapScrollMode = SNAP_Y;
                        mSnapPositive = deltaY > 0;
                        mAverageAngle = ANGLE_VERT;
                    } //End block
                } //End block
                mTouchMode = TOUCH_DRAG_MODE;
                mLastTouchX = x;
                mLastTouchY = y;
                deltaX = 0;
                deltaY = 0;
                startScrollingLayer(x, y);
                startDrag();
            } //End block
            boolean done = false;
            boolean keepScrollBarsVisible = false;
    if(deltaX == 0 && deltaY == 0)            
            {
                keepScrollBarsVisible = done = true;
            } //End block
            else
            {
                mAverageAngle +=
                        (calculateDragAngle(deltaX, deltaY) - mAverageAngle)
                        / MMA_WEIGHT_N;
    if(mSnapScrollMode != SNAP_NONE)                
                {
    if(mSnapScrollMode == SNAP_Y)                    
                    {
    if(mAverageAngle < VSLOPE_TO_BREAK_SNAP)                        
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
    if(mSnapScrollMode == SNAP_X)                    
                    {
    if(mAverageAngle > HSLOPE_TO_BREAK_SNAP)                        
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } //End block
                    } //End block
                } //End block
                else
                {
    if(mAverageAngle < HSLOPE_TO_START_SNAP)                    
                    {
                        mSnapScrollMode = SNAP_X;
                        mSnapPositive = deltaX > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_HORIZ) / 2;
                    } //End block
                    else
    if(mAverageAngle > VSLOPE_TO_START_SNAP)                    
                    {
                        mSnapScrollMode = SNAP_Y;
                        mSnapPositive = deltaY > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_VERT) / 2;
                    } //End block
                } //End block
    if(mSnapScrollMode != SNAP_NONE)                
                {
    if((mSnapScrollMode & SNAP_X) == SNAP_X)                    
                    {
                        deltaY = 0;
                    } //End block
                    else
                    {
                        deltaX = 0;
                    } //End block
                } //End block
                mLastTouchX = x;
                mLastTouchY = y;
    if(deltaX * deltaX + deltaY * deltaY > mTouchSlopSquare)                
                {
                    mHeldMotionless = MOTIONLESS_FALSE;
                    nativeSetIsScrolling(true);
                } //End block
                else
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    nativeSetIsScrolling(false);
                    keepScrollBarsVisible = true;
                } //End block
                mLastTouchTime = eventTime;
            } //End block
            doDrag(deltaX, deltaY);
    if(keepScrollBarsVisible &&
                        mTouchMode != TOUCH_DRAG_LAYER_MODE)            
            {
    if(mHeldMotionless != MOTIONLESS_TRUE)                
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    invalidate();
                } //End block
                awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(),
                            false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                            .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                boolean var6DABEAB0127B9F1E5B175E9280E71311_271420222 = (!done);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1274203340 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1274203340;
            } //End block
            else
            {
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_UP:
        {
    if(!isFocused())            
            requestFocus();
    if(shouldForwardTouchEvent())            
            {
                TouchEventData ted = new TouchEventData();
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
            mLastTouchUpTime = eventTime;
    if(mSentAutoScrollMessage)            
            {
                mAutoScrollX = mAutoScrollY = 0;
            } //End block
switch(mTouchMode){
            case TOUCH_DOUBLE_TAP_MODE:
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
    if(inFullScreenMode() || mDeferTouchProcess)            
            {
                TouchEventData ted = new TouchEventData();
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
            else
    if(mPreventDefault != PREVENT_DEFAULT_YES)            
            {
                mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                mTouchMode = TOUCH_DONE_MODE;
            } //End block
            break;
            case TOUCH_INIT_MODE:
            case TOUCH_SHORTPRESS_START_MODE:
            case TOUCH_SHORTPRESS_MODE:
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
    if(mConfirmMove)            
            {
    if(mPreventDefault != PREVENT_DEFAULT_YES
                                    && (computeMaxScrollX() > 0
                                            || computeMaxScrollY() > 0))                
                {
                    WebViewCore.reducePriority();
                    WebViewCore.pauseUpdatePicture(mWebViewCore);
                } //End block
                else
                {
                    invalidate();
                    break;
                } //End block
            } //End block
            else
            {
    if(mSelectingText)                
                {
    if(!nativeHitSelection(contentX, contentY))                    
                    {
                        selectionDone();
                    } //End block
                    break;
                } //End block
    if(mTouchMode == TOUCH_INIT_MODE
                                    && (canZoomIn() || canZoomOut()))                
                {
                    mPrivateHandler.sendEmptyMessageDelayed(
                                        RELEASE_SINGLE_TAP, ViewConfiguration
                                                .getDoubleTapTimeout());
                } //End block
                else
                {
                    doShortPress();
                } //End block
                break;
            } //End block
            case TOUCH_DRAG_MODE:
            case TOUCH_DRAG_LAYER_MODE:
            mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
            mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
    if(eventTime - mLastTouchTime <= MIN_FLING_TIME)            
            {
    if(mVelocityTracker == null)                
                {
                } //End block
                else
                {
                    mVelocityTracker.addMovement(ev);
                } //End block
                mHeldMotionless = MOTIONLESS_IGNORE;
                doFling();
                break;
            } //End block
            else
            {
    if(mScroller.springBack(mScrollX, mScrollY, 0,
                                    computeMaxScrollX(), 0,
                                    computeMaxScrollY()))                
                {
                    invalidate();
                } //End block
            } //End block
            mHeldMotionless = MOTIONLESS_TRUE;
            invalidate();
            case TOUCH_DRAG_START_MODE:
            mLastVelocity = 0;
            WebViewCore.resumePriority();
    if(!mSelectingText)            
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
            break;
}            stopTouch();
            break;
        } //End block
        case MotionEvent.ACTION_CANCEL:
        {
    if(mTouchMode == TOUCH_DRAG_MODE)            
            {
                mScroller.springBack(mScrollX, mScrollY, 0,
                            computeMaxScrollX(), 0, computeMaxScrollY());
                invalidate();
            } //End block
            cancelWebCoreTouchEvent(contentX, contentY, false);
            cancelTouch();
            break;
        } //End block
}        boolean varB326B5062B2F0E69046810717534CB09_1448201757 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_109040704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_109040704;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.454 -0400", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "2B4ED1A4233ADED0C69DFF19C69D91C0")
    private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        addTaint(sequence);
        addTaint(ev.getTaint());
        TouchEventData ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        final int count = ev.getPointerCount();
        ted.mIds = new int[count];
        ted.mPoints = new Point[count];
        ted.mPointsInView = new Point[count];
for(int c = 0;c < count;c++)
        {
            ted.mIds[c] = ev.getPointerId(c);
            int x = viewToContentX((int) ev.getX(c) + mScrollX);
            int y = viewToContentY((int) ev.getY(c) + mScrollY);
            ted.mPoints[c] = new Point(x, y);
            ted.mPointsInView[c] = new Point((int) ev.getX(c), (int) ev.getY(c));
        } //End block
    if(ted.mAction == MotionEvent.ACTION_POINTER_DOWN
            || ted.mAction == MotionEvent.ACTION_POINTER_UP)        
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.455 -0400", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "5DA386B6C968ABF5CF9BCD0717DA0EB5")
     void handleMultiTouchInWebView(MotionEvent ev) {
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
    if(detector == null)        
        return;
        float x = ev.getX();
        float y = ev.getY();
    if(mPreventDefault != PREVENT_DEFAULT_YES)        
        {
            detector.onTouchEvent(ev);
    if(detector.isInProgress())            
            {
    if(DebugFlags.WEB_VIEW)                
                {
                } //End block
                mLastTouchTime = ev.getEventTime();
                x = detector.getFocusX();
                y = detector.getFocusY();
                cancelLongPress();
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
    if(!mZoomManager.supportsPanDuringZoom())                
                {
                    return;
                } //End block
                mTouchMode = TOUCH_DRAG_MODE;
    if(mVelocityTracker == null)                
                {
                    mVelocityTracker = VelocityTracker.obtain();
                } //End block
            } //End block
        } //End block
        int action = ev.getActionMasked();
    if(action == MotionEvent.ACTION_POINTER_DOWN)        
        {
            cancelTouch();
            action = MotionEvent.ACTION_DOWN;
        } //End block
        else
    if(action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2)        
        {
            mLastTouchX = Math.round(x);
            mLastTouchY = Math.round(y);
        } //End block
        else
    if(action == MotionEvent.ACTION_MOVE)        
        {
    if(x < 0 || y < 0)            
            {
                return;
            } //End block
        } //End block
        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.456 -0400", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "71408726F30138B75C10CE2D10CDD01A")
    private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        addTaint(removeEvents);
        addTaint(y);
        addTaint(x);
    if(shouldForwardTouchEvent())        
        {
    if(removeEvents)            
            {
                mWebViewCore.removeMessages(EventHub.TOUCH_EVENT);
            } //End block
            TouchEventData ted = new TouchEventData();
            ted.mIds = new int[1];
            ted.mIds[0] = 0;
            ted.mPoints = new Point[1];
            ted.mPoints[0] = new Point(x, y);
            ted.mPointsInView = new Point[1];
            int viewX = contentToViewX(x) - mScrollX;
            int viewY = contentToViewY(y) - mScrollY;
            ted.mPointsInView[0] = new Point(viewX, viewY);
            ted.mAction = MotionEvent.ACTION_CANCEL;
            ted.mNativeLayer = nativeScrollableLayer(
                    x, y, ted.mNativeLayerRect, null);
            ted.mSequence = mTouchEventQueue.nextTouchSequence();
            mWebViewCore.sendMessage(EventHub.TOUCH_EVENT, ted);
            mPreventDefault = PREVENT_DEFAULT_IGNORE;
    if(removeEvents)            
            {
                mTouchEventQueue.ignoreCurrentlyMissingEvents();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.459 -0400", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "0D7562C6FBA96481178741005DE5C3EB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.460 -0400", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "02F98729621FBE8BA9F16B53CDCA54E9")
    private void startDrag() {
        WebViewCore.reducePriority();
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);
    if(!mDragFromTextInput)        
        {
            nativeHideCursor();
        } //End block
    if(mHorizontalScrollBarMode != SCROLLBAR_ALWAYSOFF
                || mVerticalScrollBarMode != SCROLLBAR_ALWAYSOFF)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.463 -0400", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "231C3518496F82D3711FBF5FC3443459")
    private void doDrag(int deltaX, int deltaY) {
        addTaint(deltaY);
        addTaint(deltaX);
    if((deltaX | deltaY) != 0)        
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int rangeX = computeMaxScrollX();
            int rangeY = computeMaxScrollY();
            int overscrollDistance = mOverscrollDistance;
    if(mCurrentScrollingLayerId != 0)            
            {
                final int contentX = viewToContentDimension(deltaX);
                final int contentY = viewToContentDimension(deltaY);
                final int maxX = mScrollingLayerRect.right;
                final int maxY = mScrollingLayerRect.bottom;
                final int resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                final int resultY = Math.max(0,
                        Math.min(mScrollingLayerRect.top + contentY, maxY));
    if(resultX != mScrollingLayerRect.left ||
                        resultY != mScrollingLayerRect.top)                
                {
                    mTouchMode = TOUCH_DRAG_LAYER_MODE;
                    deltaX = contentX;
                    deltaY = contentY;
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = maxX;
                    rangeY = maxY;
                } //End block
                else
                {
                    mTouchMode = TOUCH_DRAG_MODE;
                } //End block
            } //End block
    if(mOverScrollGlow != null)            
            {
                mOverScrollGlow.setOverScrollDeltas(deltaX, deltaY);
            } //End block
            overScrollBy(deltaX, deltaY, oldX, oldY,
                    rangeX, rangeY,
                    mOverscrollDistance, mOverscrollDistance, true);
    if(mOverScrollGlow != null && mOverScrollGlow.isAnimating())            
            {
                invalidate();
            } //End block
        } //End block
        mZoomManager.keepZoomPickerVisible();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.463 -0400", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "7BCA9829C89BEAEAD7E47551CDC78D22")
    private void stopTouch() {
    if(mScroller.isFinished() && !mSelectingText
                && (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE))        
        {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        } //End block
    if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
    if(mOverScrollGlow != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.464 -0400", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "2F807793E9755989E112E71C3F7391EE")
    private void cancelTouch() {
    if(mVelocityTracker != null)        
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
    if((mTouchMode == TOUCH_DRAG_MODE
                || mTouchMode == TOUCH_DRAG_LAYER_MODE) && !mSelectingText)        
        {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        } //End block
        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
    if(USE_WEBKIT_RINGS || getSettings().supportTouchOnly())        
        {
            removeTouchHighlight();
        } //End block
        mHeldMotionless = MOTIONLESS_TRUE;
        mTouchMode = TOUCH_DONE_MODE;
        nativeHideCursor();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.465 -0400", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "A4C271BBB28170BDFFA8818710C57D91")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
switch(event.getAction()){
            case MotionEvent.ACTION_SCROLL:
            {
                float vscroll;
                float hscroll;
    if((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0)                
                {
                    vscroll = 0;
                    hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                } //End block
                else
                {
                    vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                    hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                } //End block
    if(hscroll != 0 || vscroll != 0)                
                {
                    final int vdelta = (int) (vscroll * getVerticalScrollFactor());
                    final int hdelta = (int) (hscroll * getHorizontalScrollFactor());
    if(pinScrollBy(hdelta, vdelta, false, 0))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1738766512 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055542202 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055542202;
                    } //End block
                } //End block
            } //End block
}
        } //End block
        boolean var3B54C423A43BA14BBEA440506237FA4B_756231211 = (super.onGenericMotionEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21252396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_21252396;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.465 -0400", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "791AAE015ADF7CA304395081F6AC4FBB")
    public void setMapTrackballToArrowKeys(boolean setMap) {
        checkThread();
        mMapTrackballToArrowKeys = setMap;
        // ---------- Original Method ----------
        //checkThread();
        //mMapTrackballToArrowKeys = setMap;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.466 -0400", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "6AC8F93A7F315BEE56D465931AC8D27F")
     void resetTrackballTime() {
        mTrackballLastTime = 0;
        // ---------- Original Method ----------
        //mTrackballLastTime = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.467 -0400", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "1993074EF9BD76D7F2E5C52D8467FBE3")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        long time = ev.getEventTime();
    if((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0)        
        {
    if(ev.getY() > 0)            
            pageDown(true);
    if(ev.getY() < 0)            
            pageUp(true);
            boolean varB326B5062B2F0E69046810717534CB09_1923394651 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369521526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_369521526;
        } //End block
    if(ev.getAction() == MotionEvent.ACTION_DOWN)        
        {
    if(mSelectingText)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_107283768 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1750615136 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1750615136;
            } //End block
            mTrackballDown = true;
    if(mNativeClass == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1485795545 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159409885 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_159409885;
            } //End block
    if(time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds()))            
            {
                nativeSelectBestAt(mLastCursorBounds);
            } //End block
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
    if(isInTouchMode())            
            requestFocusFromTouch();
            boolean var68934A3E9455FA72420237EB05902327_739893616 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073661942 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073661942;
        } //End block
    if(ev.getAction() == MotionEvent.ACTION_UP)        
        {
            mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
            mTrackballDown = false;
            mTrackballUpTime = time;
    if(mSelectingText)            
            {
    if(mExtendSelection)                
                {
                    copySelection();
                    selectionDone();
                } //End block
                else
                {
                    mExtendSelection = true;
                    nativeSetExtendSelection();
                    invalidate();
                } //End block
                boolean varB326B5062B2F0E69046810717534CB09_391386574 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521674200 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_521674200;
            } //End block
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1435144517 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1906233783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1906233783;
        } //End block
    if((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
                AccessibilityManager.getInstance(mContext).isEnabled())        
        {
    if(DebugFlags.WEB_VIEW){ }            boolean var68934A3E9455FA72420237EB05902327_940202188 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131665128 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131665128;
        } //End block
    if(mTrackballDown)        
        {
    if(DebugFlags.WEB_VIEW){ }            boolean varB326B5062B2F0E69046810717534CB09_1194358687 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451319624 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451319624;
        } //End block
    if(time - mTrackballUpTime < TRACKBALL_TIMEOUT)        
        {
    if(DebugFlags.WEB_VIEW){ }            boolean varB326B5062B2F0E69046810717534CB09_2016248536 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640016127 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_640016127;
        } //End block
        switchOutDrawHistory();
    if(time - mTrackballLastTime > TRACKBALL_TIMEOUT)        
        {
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
            mTrackballFirstTime = time;
            mTrackballXMove = mTrackballYMove = 0;
        } //End block
        mTrackballLastTime = time;
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        mTrackballRemainsX += ev.getX();
        mTrackballRemainsY += ev.getY();
        doTrackball(time, ev.getMetaState());
        boolean varB326B5062B2F0E69046810717534CB09_1854880102 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082490803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082490803;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.470 -0400", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "3433ED65C31717719D61F82559FBEC93")
     void moveSelection(float xRate, float yRate) {
    if(mNativeClass == 0)        
        return;
        int width = getViewWidth();
        int height = getViewHeight();
        mSelectX += xRate;
        mSelectY += yRate;
        int maxX = width + mScrollX;
        int maxY = height + mScrollY;
        mSelectX = Math.min(maxX, Math.max(mScrollX - SELECT_CURSOR_OFFSET
                , mSelectX));
        mSelectY = Math.min(maxY, Math.max(mScrollY - SELECT_CURSOR_OFFSET
                , mSelectY));
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        nativeMoveSelection(viewToContentX(mSelectX), viewToContentY(mSelectY));
        int scrollX = mSelectX < mScrollX ? -SELECT_CURSOR_OFFSET
                : mSelectX > maxX - SELECT_CURSOR_OFFSET ? SELECT_CURSOR_OFFSET
                : 0;
        int scrollY = mSelectY < mScrollY ? -SELECT_CURSOR_OFFSET
                : mSelectY > maxY - SELECT_CURSOR_OFFSET ? SELECT_CURSOR_OFFSET
                : 0;
        pinScrollBy(scrollX, scrollY, true, 0);
        Rect select = new Rect(mSelectX, mSelectY, mSelectX + 1, mSelectY + 1);
        requestRectangleOnScreen(select);
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.470 -0400", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "734794B027AEAFBA201CD3C1AC0ADE08")
    private int scaleTrackballX(float xRate, int width) {
        addTaint(width);
        addTaint(xRate);
        int xMove = (int) (xRate / TRACKBALL_SCALE * width);
        int nextXMove = xMove;
    if(xMove > 0)        
        {
    if(xMove > mTrackballXMove)            
            {
                xMove -= mTrackballXMove;
            } //End block
        } //End block
        else
    if(xMove < mTrackballXMove)        
        {
            xMove -= mTrackballXMove;
        } //End block
        mTrackballXMove = nextXMove;
        int var729881097F518DADE4FDEF63884A629B_1074876361 = (xMove);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444837914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444837914;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.471 -0400", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "2705EAAFFCBA8FD87232C97A33278C98")
    private int scaleTrackballY(float yRate, int height) {
        addTaint(height);
        addTaint(yRate);
        int yMove = (int) (yRate / TRACKBALL_SCALE * height);
        int nextYMove = yMove;
    if(yMove > 0)        
        {
    if(yMove > mTrackballYMove)            
            {
                yMove -= mTrackballYMove;
            } //End block
        } //End block
        else
    if(yMove < mTrackballYMove)        
        {
            yMove -= mTrackballYMove;
        } //End block
        mTrackballYMove = nextYMove;
        int varBBBA6C5224FCB3E78E4F97427B93E6DF_1476123233 = (yMove);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425281875 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1425281875;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.471 -0400", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "8F86DAFF991B3D164A2314A9C26DD361")
    private int keyCodeToSoundsEffect(int keyCode) {
        addTaint(keyCode);
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_UP:
        int var45BCEC2C5217044AD024B49CD1CC7DB9_1404024857 = (SoundEffectConstants.NAVIGATION_UP);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894115191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894115191;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        int var01076640A6F15609B0D4446B7308A37E_1833831067 = (SoundEffectConstants.NAVIGATION_RIGHT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561328721 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_561328721;
        case KeyEvent.KEYCODE_DPAD_DOWN:
        int var5F6B41D2798EB85F03A282FBC865CB51_402157590 = (SoundEffectConstants.NAVIGATION_DOWN);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473146743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_473146743;
        case KeyEvent.KEYCODE_DPAD_LEFT:
        int varF076895921A00F80B7BCCEE9AE4497E7_1487483587 = (SoundEffectConstants.NAVIGATION_LEFT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991949701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991949701;
}        IllegalArgumentException varB54AE9EAB7B4D25B76FD0813BB88D2E8_589014141 = new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
        varB54AE9EAB7B4D25B76FD0813BB88D2E8_589014141.addTaint(taint);
        throw varB54AE9EAB7B4D25B76FD0813BB88D2E8_589014141;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.473 -0400", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "AF2F2D92E6F13D2EBD96545CE7C71C11")
    private void doTrackball(long time, int metaState) {
        addTaint(metaState);
        addTaint(time);
        int elapsed = (int) (mTrackballLastTime - mTrackballFirstTime);
    if(elapsed == 0)        
        {
            elapsed = TRACKBALL_TIMEOUT;
        } //End block
        float xRate = mTrackballRemainsX * 1000 / elapsed;
        float yRate = mTrackballRemainsY * 1000 / elapsed;
        int viewWidth = getViewWidth();
        int viewHeight = getViewHeight();
    if(mSelectingText)        
        {
    if(!mDrawSelectionPointer)            
            {
                mSelectX = contentToViewX(nativeSelectionX());
                mSelectY = contentToViewY(nativeSelectionY());
                mDrawSelectionPointer = mExtendSelection = true;
                nativeSetExtendSelection();
            } //End block
            moveSelection(scaleTrackballX(xRate, viewWidth),
                    scaleTrackballY(yRate, viewHeight));
            mTrackballRemainsX = mTrackballRemainsY = 0;
            return;
        } //End block
        float ax = Math.abs(xRate);
        float ay = Math.abs(yRate);
        float maxA = Math.max(ax, ay);
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        int width = mContentWidth - viewWidth;
        int height = mContentHeight - viewHeight;
    if(width < 0)        
        width = 0;
    if(height < 0)        
        height = 0;
        ax = Math.abs(mTrackballRemainsX * TRACKBALL_MULTIPLIER);
        ay = Math.abs(mTrackballRemainsY * TRACKBALL_MULTIPLIER);
        maxA = Math.max(ax, ay);
        int count = Math.max(0, (int) maxA);
        int oldScrollX = mScrollX;
        int oldScrollY = mScrollY;
    if(count > 0)        
        {
            int selectKeyCode = ax < ay ? mTrackballRemainsY < 0 ?
                    KeyEvent.KEYCODE_DPAD_UP : KeyEvent.KEYCODE_DPAD_DOWN :
                    mTrackballRemainsX < 0 ? KeyEvent.KEYCODE_DPAD_LEFT :
                    KeyEvent.KEYCODE_DPAD_RIGHT;
            count = Math.min(count, TRACKBALL_MOVE_COUNT);
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
    if(mNativeClass != 0 && nativePageShouldHandleShiftAndArrows())            
            {
for(int i = 0;i < count;i++)
                {
                    letPageHandleNavKey(selectKeyCode, time, true, metaState);
                } //End block
                letPageHandleNavKey(selectKeyCode, time, false, metaState);
            } //End block
            else
    if(navHandledKey(selectKeyCode, count, false, time))            
            {
                playSoundEffect(keyCodeToSoundsEffect(selectKeyCode));
            } //End block
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } //End block
    if(count >= TRACKBALL_SCROLL_COUNT)        
        {
            int xMove = scaleTrackballX(xRate, width);
            int yMove = scaleTrackballY(yRate, height);
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
    if(Math.abs(mScrollX - oldScrollX) > Math.abs(xMove))            
            {
                xMove = 0;
            } //End block
    if(Math.abs(mScrollY - oldScrollY) > Math.abs(yMove))            
            {
                yMove = 0;
            } //End block
    if(xMove != 0 || yMove != 0)            
            {
                pinScrollBy(xMove, yMove, true, 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.474 -0400", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "B178D802F02DA188B54502C3C4CA0530")
     int computeMaxScrollX() {
        int varBF84EEBF7C57D11EC397947FA75A61A2_1874176945 = (Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753642403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753642403;
        // ---------- Original Method ----------
        //return Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.474 -0400", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "AED6365779CC5973916CC3D37E744307")
     int computeMaxScrollY() {
        int var4AD6AEB9C9795A0A6CF9791F9A010C45_541611023 = (Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220914044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220914044;
        // ---------- Original Method ----------
        //return Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                //- getViewHeightWithTitle(), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.474 -0400", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "F27A1837773C3C47D11CF81EB0A93FF1")
     boolean updateScrollCoordinates(int x, int y) {
        addTaint(y);
        addTaint(x);
        int oldX = mScrollX;
        int oldY = mScrollY;
        mScrollX = x;
        mScrollY = y;
    if(oldX != mScrollX || oldY != mScrollY)        
        {
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            boolean varB326B5062B2F0E69046810717534CB09_1976820524 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1334621837 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1334621837;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1670030723 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736171723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_736171723;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.474 -0400", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "6B091C2788506421E26623024D1D07D5")
    public void flingScroll(int vx, int vy) {
        addTaint(vy);
        addTaint(vx);
        checkThread();
        mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
        // ---------- Original Method ----------
        //checkThread();
        //mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                //computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.477 -0400", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "333699E2E3F641E5BE626265B85F2C6C")
    private void doFling() {
    if(mVelocityTracker == null)        
        {
            return;
        } //End block
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int vx = (int) mVelocityTracker.getXVelocity();
        int vy = (int) mVelocityTracker.getYVelocity();
        int scrollX = mScrollX;
        int scrollY = mScrollY;
        int overscrollDistance = mOverscrollDistance;
        int overflingDistance = mOverflingDistance;
    if(mTouchMode == TOUCH_DRAG_LAYER_MODE)        
        {
            scrollX = mScrollingLayerRect.left;
            scrollY = mScrollingLayerRect.top;
            maxX = mScrollingLayerRect.right;
            maxY = mScrollingLayerRect.bottom;
            overscrollDistance = overflingDistance = 0;
        } //End block
    if(mSnapScrollMode != SNAP_NONE)        
        {
    if((mSnapScrollMode & SNAP_X) == SNAP_X)            
            {
                vy = 0;
            } //End block
            else
            {
                vx = 0;
            } //End block
        } //End block
    if((maxX == 0 && vy == 0) || (maxY == 0 && vx == 0))        
        {
            WebViewCore.resumePriority();
    if(!mSelectingText)            
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } //End block
    if(mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY))            
            {
                invalidate();
            } //End block
            return;
        } //End block
        float currentVelocity = mScroller.getCurrVelocity();
        float velocity = (float) Math.hypot(vx, vy);
    if(mLastVelocity > 0 && currentVelocity > 0 && velocity
                > mLastVelocity * MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION)        
        {
            float deltaR = (float) (Math.abs(Math.atan2(mLastVelY, mLastVelX)
                    - Math.atan2(vy, vx)));
            final float circle = (float) (Math.PI) * 2.0f;
    if(deltaR > circle * 0.9f || deltaR < circle * 0.1f)            
            {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
    if(DebugFlags.WEB_VIEW)                
                {
                } //End block
            } //End block
            else
    if(DebugFlags.WEB_VIEW)            
            {
            } //End block
        } //End block
        else
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy))        
        {
            vx = 0;
        } //End block
    if((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx))        
        {
            vy = 0;
        } //End block
    if(overscrollDistance < overflingDistance)        
        {
    if((vx > 0 && scrollX == -overscrollDistance) ||
                    (vx < 0 && scrollX == maxX + overscrollDistance))            
            {
                vx = 0;
            } //End block
    if((vy > 0 && scrollY == -overscrollDistance) ||
                    (vy < 0 && scrollY == maxY + overscrollDistance))            
            {
                vy = 0;
            } //End block
        } //End block
        mLastVelX = vx;
        mLastVelY = vy;
        mLastVelocity = velocity;
        mScroller.fling(scrollX, scrollY, -vx, -vy, 0, maxX, 0, maxY,
                maxX == 0 ? 0 : overflingDistance, overflingDistance);
        final int time = mScroller.getDuration();
    if(mTouchMode != TOUCH_DRAG_LAYER_MODE)        
        {
            awakenScrollBars(time);
        } //End block
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.477 -0400", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "624DF42CA88A559663BF1A04778653EE")
    @Deprecated
    public View getZoomControls() {
        checkThread();
    if(!getSettings().supportZoom())        
        {
View var540C13E9E156B687226421B24F2DF178_439026333 =             null;
            var540C13E9E156B687226421B24F2DF178_439026333.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_439026333;
        } //End block
View varE522DFEAF26BB27E7E175409C427F17B_1398638386 =         mZoomManager.getExternalZoomPicker();
        varE522DFEAF26BB27E7E175409C427F17B_1398638386.addTaint(taint);
        return varE522DFEAF26BB27E7E175409C427F17B_1398638386;
        // ---------- Original Method ----------
        //checkThread();
        //if (!getSettings().supportZoom()) {
            //Log.w(LOGTAG, "This WebView doesn't support zoom.");
            //return null;
        //}
        //return mZoomManager.getExternalZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.477 -0400", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "E0110D1A2A491ABF92EE451CB29B8360")
     void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
        // ---------- Original Method ----------
        //mZoomManager.dismissZoomPicker();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.477 -0400", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "5AF54831B506F0373548A38CEDF997CB")
     float getDefaultZoomScale() {
        float var7A2937D093A613F3F0AE23872818A457_1626107605 = (mZoomManager.getDefaultScale());
                float var546ADE640B6EDFBC8A086EF31347E768_173717448 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_173717448;
        // ---------- Original Method ----------
        //return mZoomManager.getDefaultScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.477 -0400", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "33C7606682157A910293582FB5BEC2A5")
     float getZoomOverviewScale() {
        float var5D461E9D99291E49B05255942AB11CEA_1712091676 = (mZoomManager.getZoomOverviewScale());
                float var546ADE640B6EDFBC8A086EF31347E768_1329052323 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1329052323;
        // ---------- Original Method ----------
        //return mZoomManager.getZoomOverviewScale();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.478 -0400", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "AB4C1806A46B9209DB8581D8FDD27F90")
    public boolean canZoomIn() {
        checkThread();
        boolean var431FB15B6AA289429D18CF9F9CDF5A1A_11917616 = (mZoomManager.canZoomIn());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60138109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_60138109;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.478 -0400", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "DE3286C9AFE9D9B989F046A1E27161B9")
    public boolean canZoomOut() {
        checkThread();
        boolean var806434BFF78B34B67FC825F14C25298F_915655141 = (mZoomManager.canZoomOut());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867009821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867009821;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.canZoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.478 -0400", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "F600B6E964433EA687FB2645262903E0")
    public boolean zoomIn() {
        checkThread();
        boolean var87A1FB5C73C5FCCE2B2B6F4799F291B7_1749772795 = (mZoomManager.zoomIn());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849690955 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849690955;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomIn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.481 -0400", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "0E17B9823A16D2928B40FDB097D01E18")
    public boolean zoomOut() {
        checkThread();
        boolean varB5EE6569F4A0880A0ECB31376FAFC271_181278099 = (mZoomManager.zoomOut());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1793036730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1793036730;
        // ---------- Original Method ----------
        //checkThread();
        //return mZoomManager.zoomOut();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.482 -0400", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "4F844C8A1F557E36E9207EB46CC3302E")
    private void updateSelection() {
    if(mNativeClass == 0)        
        {
            return;
        } //End block
        mPrivateHandler.removeMessages(UPDATE_SELECTION);
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
        Rect rect = new Rect(contentX - slop, contentY - slop,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.482 -0400", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "E72C7BAE9F7B83D261BCFFEC57C60BC9")
     void scrollFocusedTextInputX(float xPercent) {
        addTaint(xPercent);
    if(!inEditingMode() || mWebViewCore == null)        
        {
            return;
        } //End block
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                new Float(xPercent));
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                //new Float(xPercent));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.482 -0400", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "7A477F3B5D699C33721807919468FA7D")
     void scrollFocusedTextInputY(int y) {
        addTaint(y);
    if(!inEditingMode() || mWebViewCore == null)        
        {
            return;
        } //End block
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
        // ---------- Original Method ----------
        //if (!inEditingMode() || mWebViewCore == null) {
            //return;
        //}
        //mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.483 -0400", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "C6C13FC1DD62A7DE61F2B02BFCDA8461")
     void initiateTextFieldDrag(float x, float y, long eventTime) {
    if(!inEditingMode())        
        {
            return;
        } //End block
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        mLastTouchTime = eventTime;
    if(!mScroller.isFinished())        
        {
            abortAnimation();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.484 -0400", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "6E6712DF229CFF1FA3A5111B102C3845")
     boolean textFieldDrag(MotionEvent event) {
        addTaint(event.getTaint());
    if(!inEditingMode())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1988006502 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525547618 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525547618;
        } //End block
        mDragFromTextInput = true;
        event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                (float) (mWebTextView.getTop() - mScrollY));
        boolean result = onTouchEvent(event);
        mDragFromTextInput = false;
        boolean varB4A88417B3D0170D754C647C30B7216A_199069825 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250349073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250349073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.484 -0400", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "EC21AC140BE5B148662252BA1DFF17A9")
     void touchUpOnTextField(MotionEvent event) {
        addTaint(event.getTaint());
    if(!inEditingMode())        
        {
            return;
        } //End block
        int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        int slop = viewToContentDimension(mNavSlop);
        nativeMotionUp(x, y, slop);
        // ---------- Original Method ----------
        //if (!inEditingMode()) {
            //return;
        //}
        //int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        //int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        //int slop = viewToContentDimension(mNavSlop);
        //nativeMotionUp(x, y, slop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.484 -0400", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "07B7429CE92B5FFBFFF85A5139F60BF3")
     void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    //nativeCursorNodePointer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.487 -0400", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "231D49F979034FB1675C69FEADE98B12")
    private void doShortPress() {
    if(mNativeClass == 0)        
        {
            return;
        } //End block
    if(mPreventDefault == PREVENT_DEFAULT_YES)        
        {
            return;
        } //End block
        mTouchMode = TOUCH_DONE_MODE;
        updateSelection();
        switchOutDrawHistory();
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
    if(USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty())        
        {
            mTouchHighlightRequested = 0;
            invalidate(mTouchHighlightRegion.getBounds());
            mPrivateHandler.postDelayed(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.485 -0400", hash_original_method = "862A653E9B61CDCF6EC82472350CCAAA", hash_generated_method = "E8C29D6A71E7E23B309BC73E875C4F22")
        @Override
        public void run() {
            removeTouchHighlight();
            // ---------- Original Method ----------
            //removeTouchHighlight();
        }
}, ViewConfiguration.getPressedStateDuration());
        } //End block
    if(getSettings().supportTouchOnly())        
        {
            removeTouchHighlight();
            WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
            touchUpData.mMoveGeneration = 0;
            mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
        } //End block
        else
    if(nativePointInNavCache(contentX, contentY, slop))        
        {
            WebViewCore.MotionUpData motionUpData = new WebViewCore
                    .MotionUpData();
            motionUpData.mFrame = nativeCacheHitFramePointer();
            motionUpData.mNode = nativeCacheHitNodePointer();
            motionUpData.mBounds = nativeCacheHitNodeBounds();
            motionUpData.mX = contentX;
            motionUpData.mY = contentY;
            mWebViewCore.sendMessageAtFrontOfQueue(EventHub.VALID_NODE_BOUNDS,
                    motionUpData);
        } //End block
        else
        {
            doMotionUp(contentX, contentY);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.487 -0400", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "99D39FCE041BEEA3AC9B249F11C1547F")
    private void doMotionUp(int contentX, int contentY) {
        addTaint(contentY);
        addTaint(contentX);
        int slop = viewToContentDimension(mNavSlop);
    if(nativeMotionUp(contentX, contentY, slop) && mLogEvent)        
        {
            EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
        } //End block
    if(nativeHasCursorNode() && !nativeCursorIsTextInput())        
        {
            playSoundEffect(SoundEffectConstants.CLICK);
        } //End block
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativeMotionUp(contentX, contentY, slop) && mLogEvent) {
            //EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
        //}
        //if (nativeHasCursorNode() && !nativeCursorIsTextInput()) {
            //playSoundEffect(SoundEffectConstants.CLICK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.487 -0400", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "C93F605E15A477EBB506444304D44C5C")
     void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.488 -0400", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "244ECC96A128FEA9961F33E736355A4E")
     Rect getPluginBounds(int x, int y) {
        addTaint(y);
        addTaint(x);
        int slop = viewToContentDimension(mNavSlop);
    if(nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin())        
        {
Rect varC3145DE198BF66B3957C493957629A45_198970259 =             nativeCacheHitNodeBounds();
            varC3145DE198BF66B3957C493957629A45_198970259.addTaint(taint);
            return varC3145DE198BF66B3957C493957629A45_198970259;
        } //End block
        else
        {
Rect var540C13E9E156B687226421B24F2DF178_182261413 =             null;
            var540C13E9E156B687226421B24F2DF178_182261413.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_182261413;
        } //End block
        // ---------- Original Method ----------
        //int slop = viewToContentDimension(mNavSlop);
        //if (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin()) {
            //return nativeCacheHitNodeBounds();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.488 -0400", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "AE1A8CDAEF341A536F530DA73BAFC80F")
     boolean isRectFitOnScreen(Rect rect) {
        addTaint(rect.getTaint());
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        boolean var5D3D449FE79085B17041ACC34149282E_1553363853 = (!mZoomManager.willScaleTriggerZoom(scale)
                && contentToViewX(rect.left) >= mScrollX
                && contentToViewX(rect.right) <= mScrollX + viewWidth
                && contentToViewY(rect.top) >= mScrollY
                && contentToViewY(rect.bottom) <= mScrollY + viewHeight);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602967247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602967247;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.489 -0400", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "8197A46525C766201524442AC0D28C4C")
     void centerFitRect(Rect rect) {
        addTaint(rect.getTaint());
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
    if(!mZoomManager.willScaleTriggerZoom(scale))        
        {
            pinScrollTo(contentToViewX(rect.left + rectWidth / 2) - viewWidth / 2,
                    contentToViewY(rect.top + rectHeight / 2) - viewHeight / 2,
                    true, 0);
        } //End block
        else
        {
            float actualScale = mZoomManager.getScale();
            float oldScreenX = rect.left * actualScale - mScrollX;
            float rectViewX = rect.left * scale;
            float rectViewWidth = rectWidth * scale;
            float newMaxWidth = mContentWidth * scale;
            float newScreenX = (viewWidth - rectViewWidth) / 2;
    if(newScreenX > rectViewX)            
            {
                newScreenX = rectViewX;
            } //End block
            else
    if(newScreenX > (newMaxWidth - rectViewX - rectViewWidth))            
            {
                newScreenX = viewWidth - (newMaxWidth - rectViewX);
            } //End block
            float zoomCenterX = (oldScreenX * scale - newScreenX * actualScale)
                    / (scale - actualScale);
            float oldScreenY = rect.top * actualScale + getTitleHeight()
                    - mScrollY;
            float rectViewY = rect.top * scale + getTitleHeight();
            float rectViewHeight = rectHeight * scale;
            float newMaxHeight = mContentHeight * scale + getTitleHeight();
            float newScreenY = (viewHeight - rectViewHeight) / 2;
    if(newScreenY > rectViewY)            
            {
                newScreenY = rectViewY;
            } //End block
            else
    if(newScreenY > (newMaxHeight - rectViewY - rectViewHeight))            
            {
                newScreenY = viewHeight - (newMaxHeight - rectViewY);
            } //End block
            float zoomCenterY = (oldScreenY * scale - newScreenY * actualScale)
                    / (scale - actualScale);
            mZoomManager.setZoomCenter(zoomCenterX, zoomCenterY);
            mZoomManager.startZoomAnimation(scale, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.490 -0400", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "3B243C40100076393C9FD2EEB63FE189")
    private void overrideLoading(String url) {
        addTaint(url.getTaint());
        mCallbackProxy.uiOverrideUrlLoading(url);
        // ---------- Original Method ----------
        //mCallbackProxy.uiOverrideUrlLoading(url);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.490 -0400", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "EE43A4B0F4FB3529C2B884801DB45053")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(mFindIsUp)        
        {
        boolean var68934A3E9455FA72420237EB05902327_521807659 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345213472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345213472;
        }
        boolean result = false;
    if(inEditingMode())        
        {
            result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
        } //End block
        else
        {
            result = super.requestFocus(direction, previouslyFocusedRect);
    if(mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode())            
            {
                int fakeKeyDirection = 0;
switch(direction){
                case View.FOCUS_UP:
                fakeKeyDirection = KeyEvent.KEYCODE_DPAD_UP;
                break;
                case View.FOCUS_DOWN:
                fakeKeyDirection = KeyEvent.KEYCODE_DPAD_DOWN;
                break;
                case View.FOCUS_LEFT:
                fakeKeyDirection = KeyEvent.KEYCODE_DPAD_LEFT;
                break;
                case View.FOCUS_RIGHT:
                fakeKeyDirection = KeyEvent.KEYCODE_DPAD_RIGHT;
                break;
                default:
                boolean varB4A88417B3D0170D754C647C30B7216A_2137174547 = (result);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110226263 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110226263;
}    if(mNativeClass != 0 && !nativeHasCursorNode())                
                {
                    navHandledKey(fakeKeyDirection, 1, true, 0);
                } //End block
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_790757750 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817738960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817738960;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.492 -0400", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "75320967C94DAFE72B9FD32B810121D5")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = heightSize;
        int measuredWidth = widthSize;
        int contentHeight = contentToViewDimension(mContentHeight);
        int contentWidth = contentToViewDimension(mContentWidth);
    if(heightMode != MeasureSpec.EXACTLY)        
        {
            mHeightCanMeasure = true;
            measuredHeight = contentHeight;
    if(heightMode == MeasureSpec.AT_MOST)            
            {
    if(measuredHeight > heightSize)                
                {
                    measuredHeight = heightSize;
                    mHeightCanMeasure = false;
                    measuredHeight |= MEASURED_STATE_TOO_SMALL;
                } //End block
            } //End block
        } //End block
        else
        {
            mHeightCanMeasure = false;
        } //End block
    if(mNativeClass != 0)        
        {
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        } //End block
    if(widthMode == MeasureSpec.UNSPECIFIED)        
        {
            mWidthCanMeasure = true;
            measuredWidth = contentWidth;
        } //End block
        else
        {
    if(measuredWidth < contentWidth)            
            {
                measuredWidth |= MEASURED_STATE_TOO_SMALL;
            } //End block
            mWidthCanMeasure = false;
        } //End block
        synchronized
(this)        {
            setMeasuredDimension(measuredWidth, measuredHeight);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.494 -0400", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "D8704E667F01B01FEB31EE58513981F2")
    @Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        addTaint(immediate);
        addTaint(rect.getTaint());
        addTaint(child.getTaint());
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1864485057 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476637463 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_476637463;
        } //End block
    if(mZoomManager.isFixedLengthAnimationInProgress())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1332355455 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818733234 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818733234;
        } //End block
        rect.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());
        Rect content = new Rect(viewToContentX(mScrollX),
                viewToContentY(mScrollY),
                viewToContentX(mScrollX + getWidth()
                - getVerticalScrollbarWidth()),
                viewToContentY(mScrollY + getViewHeightWithTitle()));
        content = nativeSubtractLayers(content);
        int screenTop = contentToViewY(content.top);
        int screenBottom = contentToViewY(content.bottom);
        int height = screenBottom - screenTop;
        int scrollYDelta = 0;
    if(rect.bottom > screenBottom)        
        {
            int oneThirdOfScreenHeight = height / 3;
    if(rect.height() > 2 * oneThirdOfScreenHeight)            
            {
                scrollYDelta = rect.top - screenTop;
            } //End block
            else
            {
                scrollYDelta = rect.top - (screenTop + oneThirdOfScreenHeight);
            } //End block
        } //End block
        else
    if(rect.top < screenTop)        
        {
            scrollYDelta = rect.top - screenTop;
        } //End block
        int screenLeft = contentToViewX(content.left);
        int screenRight = contentToViewX(content.right);
        int width = screenRight - screenLeft;
        int scrollXDelta = 0;
    if(rect.right > screenRight && rect.left > screenLeft)        
        {
    if(rect.width() > width)            
            {
                scrollXDelta += (rect.left - screenLeft);
            } //End block
            else
            {
                scrollXDelta += (rect.right - screenRight);
            } //End block
        } //End block
        else
    if(rect.left < screenLeft)        
        {
            scrollXDelta -= (screenLeft - rect.left);
        } //End block
    if((scrollYDelta | scrollXDelta) != 0)        
        {
            boolean var22D353885C229A794F29F5D29E13DB54_1798593134 = (pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700001280 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700001280;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1298753145 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997009273 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997009273;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.494 -0400", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "47E3E6E5CF93B3FC135AD78E10B72468")
     void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        addTaint(newEnd);
        addTaint(newStart);
        addTaint(replace.getTaint());
        addTaint(oldEnd);
        addTaint(oldStart);
        WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
        arg.mReplace = replace;
        arg.mNewStart = newStart;
        arg.mNewEnd = newEnd;
        mTextGeneration++;
        arg.mTextGeneration = mTextGeneration;
        mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
        // ---------- Original Method ----------
        //WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
        //arg.mReplace = replace;
        //arg.mNewStart = newStart;
        //arg.mNewEnd = newEnd;
        //mTextGeneration++;
        //arg.mTextGeneration = mTextGeneration;
        //mWebViewCore.sendMessage(EventHub.REPLACE_TEXT, oldStart, oldEnd, arg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.496 -0400", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "3283D4F8E4B8EA5CD67907AD1BADBB37")
     void passToJavaScript(String currentText, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(currentText.getTaint());
    if(mWebViewCore == null)        
        {
            return;
        } //End block
        WebViewCore.JSKeyData arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
        mTextGeneration++;
        mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                cursorData(), 1000);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.496 -0400", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "7E79E96C58DF6D64EA095C0C3F6BD52D")
    public synchronized WebViewCore getWebViewCore() {
WebViewCore var7DA989529687D42D280B8A13FA54DF21_1371995249 =         mWebViewCore;
        var7DA989529687D42D280B8A13FA54DF21_1371995249.addTaint(taint);
        return var7DA989529687D42D280B8A13FA54DF21_1371995249;
        // ---------- Original Method ----------
        //return mWebViewCore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.496 -0400", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "7DC4AC32E9C1542015FAEB8EEBAB87B9")
    private void setTouchHighlightRects(ArrayList<Rect> rects) {
        addTaint(rects.getTaint());
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
    if(rects != null)        
        {
for(Rect rect : rects)
            {
                Rect viewRect = contentToViewRect(rect);
    if(viewRect.width() < getWidth() >> 1
                        || viewRect.height() < getHeight() >> 1)                
                {
                    mTouchHighlightRegion.union(viewRect);
                } //End block
                else
                {
                } //End block
            } //End block
            invalidate(mTouchHighlightRegion.getBounds());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.496 -0400", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "E91DA443DFF4E78BB7D34263626931AB")
    protected void pageSwapCallback(boolean notifyAnimationStarted) {
        addTaint(notifyAnimationStarted);
    if(inEditingMode())        
        {
            didUpdateWebTextViewDimensions(ANYWHERE);
        } //End block
    if(notifyAnimationStarted)        
        {
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()) {
            //didUpdateWebTextViewDimensions(ANYWHERE);
        //}
        //if (notifyAnimationStarted) {
            //mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.499 -0400", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "D438A260D826F97F60433515DD0A2554")
     void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        addTaint(updateBaseLayer);
    if(mNativeClass == 0)        
        {
    if(mDelaySetPicture != null)            
            {
                IllegalStateException var82D6D4E1239835ECEAC5D2B9F5189EEE_1717977082 = new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
                var82D6D4E1239835ECEAC5D2B9F5189EEE_1717977082.addTaint(taint);
                throw var82D6D4E1239835ECEAC5D2B9F5189EEE_1717977082;
            } //End block
            mDelaySetPicture = draw;
            return;
        } //End block
        WebViewCore.ViewState viewState = draw.mViewState;
        boolean isPictureAfterFirstLayout = viewState != null;
    if(updateBaseLayer)        
        {
            boolean registerPageSwapCallback = !mZoomManager.isFixedLengthAnimationInProgress() && inEditingMode();
            setBaseLayer(draw.mBaseLayer, draw.mInvalRegion,
                    getSettings().getShowVisualIndicator(),
                    isPictureAfterFirstLayout, registerPageSwapCallback);
        } //End block
        final Point viewSize = draw.mViewSize;
        final boolean updateLayout = viewSize.x == mLastWidthSent
                && viewSize.y == mLastHeightSent;
        mSendScrollEvent = false;
        recordNewContentSize(draw.mContentSize.x,
                draw.mContentSize.y, updateLayout);
    if(isPictureAfterFirstLayout)        
        {
            mLastWidthSent = 0;
            mZoomManager.onFirstLayout(draw);
            int scrollX = viewState.mShouldStartScrolledRight
                    ? getContentWidth() : viewState.mScrollX;
            int scrollY = viewState.mScrollY;
            setContentScrollTo(scrollX, scrollY);
    if(!mDrawHistory)            
            {
                clearTextEntry();
            } //End block
        } //End block
        mSendScrollEvent = true;
    if(DebugFlags.WEB_VIEW)        
        {
            Rect b = draw.mInvalRegion.getBounds();
        } //End block
        invalidateContentRect(draw.mInvalRegion.getBounds());
    if(mPictureListener != null)        
        {
            mPictureListener.onNewPicture(WebView.this, capturePicture());
        } //End block
        mZoomManager.onNewPicture(draw);
    if(draw.mFocusSizeChanged && inEditingMode())        
        {
            mFocusSizeChanged = true;
        } //End block
    if(isPictureAfterFirstLayout)        
        {
            mViewManager.postReadyToDrawAll();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.499 -0400", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "6AB8D9A10C9DCA7240DDE0304B2FA57F")
    private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        addTaint(data.getTaint());
        addTaint(textGeneration);
        addTaint(nodePointer);
    if(inEditingMode()
                && mWebTextView.isSameTextField(nodePointer)
                && textGeneration == mTextGeneration)        
        {
            mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
        } //End block
        // ---------- Original Method ----------
        //if (inEditingMode()
                //&& mWebTextView.isSameTextField(nodePointer)
                //&& textGeneration == mTextGeneration) {
            //mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.499 -0400", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "466989181D0FE143C45B9FF3EBFA41DC")
     void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        addTaint(selectedArray[0]);
        addTaint(enabledArray[0]);
        addTaint(array[0].getTaint());
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selectedArray));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.499 -0400", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "8F43D1AEB9C85DCE276DE11BF3E15564")
     void requestListBox(String[] array, int[] enabledArray, int selection) {
        addTaint(selection);
        addTaint(enabledArray[0]);
        addTaint(array[0].getTaint());
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
        // ---------- Original Method ----------
        //mPrivateHandler.post(
                //new InvokeListBox(array, enabledArray, selection));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.499 -0400", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "835FC975E405B80066863AEC496621A8")
    private void sendMoveFocus(int frame, int node) {
        addTaint(node);
        addTaint(frame);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                //new WebViewCore.CursorData(frame, node, 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.501 -0400", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "FFC42FCA3AD9D5073C77BC861B37704D")
    private void sendMoveMouse(int frame, int node, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(node);
        addTaint(frame);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                new WebViewCore.CursorData(frame, node, x, y));
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                //new WebViewCore.CursorData(frame, node, x, y));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.501 -0400", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "50DEF2399850C9E2B3CB612062A976C4")
    @SuppressWarnings("unused")
    private void sendMoveMouseIfLatest(boolean removeFocus, boolean stopPaintingCaret) {
        addTaint(stopPaintingCaret);
        addTaint(removeFocus);
    if(removeFocus)        
        {
            clearTextEntry();
        } //End block
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                stopPaintingCaret ? 1 : 0, 0,
                cursorData());
        // ---------- Original Method ----------
        //if (removeFocus) {
            //clearTextEntry();
        //}
        //mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                //stopPaintingCaret ? 1 : 0, 0,
                //cursorData());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.501 -0400", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "95A5D42CFBF34EDC28C13C9E7B6BA923")
    private void sendMotionUp(int touchGeneration,
            int frame, int node, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(node);
        addTaint(frame);
        addTaint(touchGeneration);
        WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
        touchUpData.mMoveGeneration = touchGeneration;
        touchUpData.mFrame = frame;
        touchUpData.mNode = node;
        touchUpData.mX = x;
        touchUpData.mY = y;
        touchUpData.mNativeLayer = nativeScrollableLayer(
                x, y, touchUpData.mNativeLayerRect, null);
        mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.503 -0400", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "AF5F01C474372CF65F4D868C553EECCA")
    private int getScaledMaxXScroll() {
        int width;
    if(mHeightCanMeasure == false)        
        {
            width = getViewWidth() / 4;
        } //End block
        else
        {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            width = visRect.width() / 2;
        } //End block
        int var45676A0EEB938B9408B7DA31EC8097AC_1686800831 = (viewToContentX(width));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918721718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918721718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.503 -0400", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "A823335043D5DBAE05442BCB5B623628")
    private int getScaledMaxYScroll() {
        int height;
    if(mHeightCanMeasure == false)        
        {
            height = getViewHeight() / 4;
        } //End block
        else
        {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            height = visRect.height() / 2;
        } //End block
        int var6EBD15FF4A3CF77A519E8E148B86A237_2120077137 = (Math.round(height * mZoomManager.getInvScale()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000825602 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000825602;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.503 -0400", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "43791F1CBB48DBD139A4E7B1FDB49008")
    private void viewInvalidate() {
        invalidate();
        // ---------- Original Method ----------
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.504 -0400", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "6F662FF83C381AB34312BBDB77058AE7")
    private void letPageHandleNavKey(int keyCode, long time, boolean down, int metaState) {
        addTaint(metaState);
        addTaint(down);
        addTaint(time);
        addTaint(keyCode);
        int keyEventAction;
        int eventHubAction;
    if(down)        
        {
            keyEventAction = KeyEvent.ACTION_DOWN;
            eventHubAction = EventHub.KEY_DOWN;
            playSoundEffect(keyCodeToSoundsEffect(keyCode));
        } //End block
        else
        {
            keyEventAction = KeyEvent.ACTION_UP;
            eventHubAction = EventHub.KEY_UP;
        } //End block
        KeyEvent event = new KeyEvent(time, time, keyEventAction, keyCode,
                1, (metaState & KeyEvent.META_SHIFT_ON)
                | (metaState & KeyEvent.META_ALT_ON)
                | (metaState & KeyEvent.META_SYM_ON)
                , KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        mWebViewCore.sendMessage(eventHubAction, event);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.506 -0400", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "64CC2859604BBE24ADF8B66128F791F8")
    private boolean navHandledKey(int keyCode, int count, boolean noScroll,
            long time) {
        addTaint(noScroll);
        addTaint(count);
        addTaint(keyCode);
    if(mNativeClass == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_972594884 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375270883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_375270883;
        } //End block
        mInitialHitTestResult = null;
        mLastCursorTime = time;
        mLastCursorBounds = nativeGetCursorRingBounds();
        boolean keyHandled = nativeMoveCursor(keyCode, count, noScroll) == false;
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
    if(keyHandled == false)        
        {
            boolean varDB833059B4399C68C5B2ED1ED254D1A1_143734167 = (keyHandled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35199001 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_35199001;
        } //End block
        Rect contentCursorRingBounds = nativeGetCursorRingBounds();
    if(contentCursorRingBounds.isEmpty())        
        {
        boolean varDB833059B4399C68C5B2ED1ED254D1A1_691807678 = (keyHandled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073144660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073144660;
        }
        Rect viewCursorRingBounds = contentToViewRect(contentCursorRingBounds);
        mLastTouchX = (viewCursorRingBounds.left + viewCursorRingBounds.right) / 2;
        mLastTouchY = (viewCursorRingBounds.top + viewCursorRingBounds.bottom) / 2;
    if(mHeightCanMeasure == false)        
        {
            boolean varDB833059B4399C68C5B2ED1ED254D1A1_301392780 = (keyHandled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602356650 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_602356650;
        } //End block
        Rect visRect = new Rect();
        calcOurVisibleRect(visRect);
        Rect outset = new Rect(visRect);
        int maxXScroll = visRect.width() / 2;
        int maxYScroll = visRect.height() / 2;
        outset.inset(-maxXScroll, -maxYScroll);
    if(Rect.intersects(outset, viewCursorRingBounds) == false)        
        {
            boolean varDB833059B4399C68C5B2ED1ED254D1A1_836297455 = (keyHandled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238691513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238691513;
        } //End block
        int maxH = Math.min(viewCursorRingBounds.right - visRect.right,
                maxXScroll);
    if(maxH > 0)        
        {
            pinScrollBy(maxH, 0, true, 0);
        } //End block
        else
        {
            maxH = Math.max(viewCursorRingBounds.left - visRect.left,
                    -maxXScroll);
    if(maxH < 0)            
            {
                pinScrollBy(maxH, 0, true, 0);
            } //End block
        } //End block
    if(mLastCursorBounds.isEmpty())        
        {
        boolean varDB833059B4399C68C5B2ED1ED254D1A1_14059738 = (keyHandled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64819200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_64819200;
        }
    if(mLastCursorBounds.equals(contentCursorRingBounds))        
        {
            boolean varDB833059B4399C68C5B2ED1ED254D1A1_91669123 = (keyHandled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250745030 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_250745030;
        } //End block
    if(DebugFlags.WEB_VIEW)        
        {
        } //End block
        requestRectangleOnScreen(viewCursorRingBounds);
        boolean varDB833059B4399C68C5B2ED1ED254D1A1_1914581571 = (keyHandled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977870783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_977870783;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.506 -0400", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "20B8B700FA171769FD339AC291DD2451")
    private boolean accessibilityScriptInjected() {
        boolean var9B2A884FD52D291BA7C8707BFD34EE95_1257485048 = (mAccessibilityScriptInjected);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537782429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537782429;
        // ---------- Original Method ----------
        //return mAccessibilityScriptInjected;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.507 -0400", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "1D06CA9D32CB95134D9BA15854D3E735")
    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
        // ---------- Original Method ----------
        //mBackgroundColor = color;
        //mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "85CCCEA00CCFC3C2990DD68DC174D234")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "92B83D8E404DB72D4EF6CE9169BECAED")
    public void drawPage(Canvas canvas) {
        addTaint(canvas.getTaint());
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
        // ---------- Original Method ----------
        //calcOurContentVisibleRectF(mVisibleContentRect);
        //nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "60F0103DEBE1A0FA6D924B8BF32F9420")
    public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        mHTML5VideoViewProxy = proxy;
        // ---------- Original Method ----------
        //mHTML5VideoViewProxy = proxy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "0341554DA62305A207D3B8C95E999187")
    public void setTouchInterval(int interval) {
        mCurrentTouchInterval = interval;
        // ---------- Original Method ----------
        //mCurrentTouchInterval = interval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "C1D11BA2253ECB4650A75E4CB2BAF14E")
    protected void updateCachedTextfield(String updatedText) {
        addTaint(updatedText.getTaint());
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
        // ---------- Original Method ----------
        //nativeUpdateCachedTextfield(updatedText, mTextGeneration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "B1867135A3FA91AF80C166D8B8B574B6")
     void autoFillForm(int autoFillQueryId) {
        addTaint(autoFillQueryId);
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
        // ---------- Original Method ----------
        //mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.508 -0400", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "EDA8284E60DF76F764D6C963596C583C")
     ViewManager getViewManager() {
ViewManager var26FEA57E0624F30880F3CB39D38E2C18_558768446 =         mViewManager;
        var26FEA57E0624F30880F3CB39D38E2C18_558768446.addTaint(taint);
        return var26FEA57E0624F30880F3CB39D38E2C18_558768446;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.510 -0400", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "7E20A5F52A77118961198EA59EA59F5F")
    protected void contentInvalidateAll() {
    if(mWebViewCore != null && !mBlockWebkitViewMessages)        
        {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        } //End block
        // ---------- Original Method ----------
        //if (mWebViewCore != null && !mBlockWebkitViewMessages) {
            //mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.510 -0400", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "14F0772081BF82E7E18655BBAC5A6F22")
    protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
        // ---------- Original Method ----------
        //nativeRegisterPageSwapCallback();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "EAF06CEEDE2D5E5967608F86C355FE16")
    public void tileProfilingStart() {
        nativeTileProfilingStart();
        // ---------- Original Method ----------
        //nativeTileProfilingStart();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "1FC3771DD22D30DB1E061497E9B7BCAD")
    public float tileProfilingStop() {
        float var9AA7D365C2144A0C194CBDEA0133F10D_2086136205 = (nativeTileProfilingStop());
                float var546ADE640B6EDFBC8A086EF31347E768_584371031 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_584371031;
        // ---------- Original Method ----------
        //return nativeTileProfilingStop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "8FDB7E2C7A9F51E9629172BAF0B24960")
    public void tileProfilingClear() {
        nativeTileProfilingClear();
        // ---------- Original Method ----------
        //nativeTileProfilingClear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "D38C9942A394AD1EDC04B90FBC16C9B2")
    public int tileProfilingNumFrames() {
        int varF637B1184AC8C366714258B266C47952_1905038239 = (nativeTileProfilingNumFrames());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536510623 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536510623;
        // ---------- Original Method ----------
        //return nativeTileProfilingNumFrames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "C05A4B757E7448153A191F961D81CD89")
    public int tileProfilingNumTilesInFrame(int frame) {
        addTaint(frame);
        int var5AD1D90A16252C21E44B751A20BD43D8_986208354 = (nativeTileProfilingNumTilesInFrame(frame));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832207546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832207546;
        // ---------- Original Method ----------
        //return nativeTileProfilingNumTilesInFrame(frame);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.511 -0400", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "776E3F86F8F951AC3765F5327A0BBF96")
    public int tileProfilingGetInt(int frame, int tile, String key) {
        addTaint(key.getTaint());
        addTaint(tile);
        addTaint(frame);
        int var09BB1967AE5AAD9AB5697185F2DE2369_2014360622 = (nativeTileProfilingGetInt(frame, tile, key));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773820777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773820777;
        // ---------- Original Method ----------
        //return nativeTileProfilingGetInt(frame, tile, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.513 -0400", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "2B5998104DD3C164588C56ED0E6FE604")
    public float tileProfilingGetFloat(int frame, int tile, String key) {
        addTaint(key.getTaint());
        addTaint(tile);
        addTaint(frame);
        float var17AE1005406C3065A5A492BBEA0B5824_2135636033 = (nativeTileProfilingGetFloat(frame, tile, key));
                float var546ADE640B6EDFBC8A086EF31347E768_158979098 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_158979098;
        // ---------- Original Method ----------
        //return nativeTileProfilingGetFloat(frame, tile, key);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.513 -0400", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "F3B727E9F41CFD016EB5AAA7B887420D")
    private int nativeCacheHitFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207843557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207843557;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.513 -0400", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "8640BB84842ACCD392D36D1A371CB745")
    private boolean nativeCacheHitIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563358822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563358822;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "C211C5C405AAE9953CCBBEEF22D45B31")
    private Rect nativeCacheHitNodeBounds() {
    	return new Rect();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "AB01E81E1C8CF2299DC950D403B5088B")
    private int nativeCacheHitNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537839215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537839215;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "2C929D3168FE3E72D461E6649B6EC306")
     void nativeClearCursor() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "7DFA4BA9D9D2F081C4674D9A23AF40D6")
    private void nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "F74CBC226790A4875B8BAFC9A219989F")
    private int nativeCursorFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117130715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117130715;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "E271E918D4C574FDDE4719E4B98A8B2B")
    private Rect nativeCursorNodeBounds() {
    	return new Rect();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "080D6B46DB7149D1901F87B3495CB7E3")
    private int nativeCursorNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363982167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363982167;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.514 -0400", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "D1BAC327B0C24754C34CB3939A5D9221")
    private boolean nativeCursorIntersects(Rect visibleRect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658487269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658487269;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.515 -0400", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "9AE9221E40F2C64D30B225D921654033")
    private boolean nativeCursorIsAnchor() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151555644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151555644;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.515 -0400", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "D8E77F6BFA152073E507B24DE6BBDEC8")
    private boolean nativeCursorIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284881579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284881579;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "2045A184BB97A2996B1887CC917B0804")
    private Point nativeCursorPosition() {
    	return new Point();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "3E24BE9E7EBDB8C5312CC587887CD85C")
    private String nativeCursorText() {
    	return new String();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.515 -0400", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "92CB70ACCD9D08DD7FC7CD24FAC8138C")
    private boolean nativeCursorWantsKeyEvents() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292673879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292673879;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.515 -0400", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "F601101523F054AD48972FF053FC6215")
    private void nativeDebugDump() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.515 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    private void nativeDestroy() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.516 -0400", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "8CD664830383E71995EBF16B2511792C")
    private int nativeDraw(Canvas canvas, RectF visibleRect,
            int color, int extra, boolean splitIfNeeded) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559822406 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559822406;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.516 -0400", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "DEC3E2BF23E95688EF02A9D60A934BC6")
    private void nativeDumpDisplayTree(String urlOrNull) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.516 -0400", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "1C749118407BD8FE828CB5C2BFFE54E3")
    private boolean nativeEvaluateLayersAnimations(int nativeInstance) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9402808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9402808;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "FCA300991683FAFF3AABBD028F088A1C")
    private int nativeGetDrawGLFunction(int nativeInstance, Rect rect,
            Rect viewRect, RectF visibleRect, float scale, int extras) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752078668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752078668;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "CE8A8077BABA841A2AD2D59A5548E6AE")
    private void nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
            RectF visibleRect) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "AAD4FC58EFA073FDC913BA79EDD7DCDA")
    private void nativeExtendSelection(int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "1F7E293BEAE3A848695DF9A03CB1D901")
    private int nativeFindAll(String findLower, String findUpper,
            boolean sameAsLastSearch) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128025762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2128025762;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "937E5B11B8379FE5830DBA653F9B7999")
    private void nativeFindNext(boolean forward) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.517 -0400", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "2CDFDE6A2CAD6FEF511B80FAB4EDF9E6")
     int nativeFocusCandidateFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216141976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1216141976;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.518 -0400", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "F5773C307B4BAA8BC51481485555CB3C")
     boolean nativeFocusCandidateHasNextTextfield() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302367839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302367839;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.518 -0400", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "78A650A161256CDAC57199EDCD0881F7")
     boolean nativeFocusCandidateIsPassword() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1092374007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1092374007;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.518 -0400", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "8E72EFC194213E0EEF7A4108D82A8745")
    private boolean nativeFocusCandidateIsRtlText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312698044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312698044;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.518 -0400", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "613336789B65F2E3342DEC07D8799840")
    private boolean nativeFocusCandidateIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985674773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_985674773;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.518 -0400", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "4678BAE70A4EA126243B28B7F8F57999")
     int nativeFocusCandidateMaxLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709676449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709676449;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.519 -0400", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "A4D5AF88CFA51571848149F7001A7FE8")
     boolean nativeFocusCandidateIsAutoComplete() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656126786 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656126786;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.519 -0400", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "A08634C84A3CCEB5AC410C6FBCC8E980")
     boolean nativeFocusCandidateIsSpellcheck() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571187371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571187371;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "482EB255509BA82D443BAA9D71623788")
     String nativeFocusCandidateName() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "E9FE505188BFAFC647C681A775DCAAFD")
    private Rect nativeFocusCandidateNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "8CA80E2A60FEEA9061A61B09DA68625A")
    private Rect nativeFocusCandidatePaddingRect() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.519 -0400", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "2010DCF1151FAC0A54229769E5C58880")
     int nativeFocusCandidatePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028694703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028694703;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "B8D2D3434495629B87849A0DDE9761CA")
    private String nativeFocusCandidateText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.519 -0400", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "F4E640FD4848C57258C1174A86AB8918")
     float nativeFocusCandidateTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_1507211648 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1507211648;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.520 -0400", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "8B909EC73E85080E867DC5B49D71EE7A")
     int nativeFocusCandidateLineHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821396589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1821396589;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.520 -0400", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "8749C9887272C8AE98B882A94A35F24B")
    private int nativeFocusCandidateType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285344950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285344950;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.520 -0400", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "1F54950986718D1EE4F5358A28AAF695")
    private int nativeFocusCandidateLayerId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74089296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74089296;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.520 -0400", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "66174B745F76AC6870BE5F7D431F2D25")
    private boolean nativeFocusIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477487747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477487747;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "65244A088D15DCA1F0C3C7F2D973DFD4")
    private Rect nativeFocusNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.522 -0400", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "E195D320031D34AF9A5F38E7C8BEA922")
     int nativeFocusNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642020603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642020603;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "68114054688AC2ACF3B41A1E50F28F3A")
    private Rect nativeGetCursorRingBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "CAEC1387621E6EAAC0BBE851878D90E6")
    private String nativeGetSelection() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.522 -0400", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "0ADEEB9AB164664B0B651105FDB53D8E")
    private boolean nativeHasCursorNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013685649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013685649;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.522 -0400", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "E4B990DF0E002F7473E9C76A248D3528")
    private boolean nativeHasFocusNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1388264867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1388264867;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.522 -0400", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "C5D686BF12DF1683258EF31789BFD66A")
    private void nativeHideCursor() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.523 -0400", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "91C454E592D6B366D8AF7262B0E0893C")
    private boolean nativeHitSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744591930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744591930;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "68E20D0E121FE807EF3A683540460D64")
    private String nativeImageURI(int x, int y) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.523 -0400", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "4931CD211AE029703EBE8600C611C50A")
    private void nativeInstrumentReport() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "0EF9BAF6479325B7AFB630E9F288D638")
    private Rect nativeLayerBounds(int layer) {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.523 -0400", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "660AA22E4FE4C950C0D4F356B174FA24")
     boolean nativeMoveCursorToNextTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561083516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561083516;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "66A4AA2E4456B8333B0A945DD7EBC0BF")
    private boolean nativeMotionUp(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797846772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_797846772;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "C55DDF2A4FB9096DCC2AA66FEC1A2F5F")
    private boolean nativeMoveCursor(int keyCode, int count,
            boolean noScroll) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917594343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_917594343;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "C1BD7EC2E632485FA8495F85E1CED5E2")
    private int nativeMoveGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433995424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433995424;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "806420BABD34DA76CA52BDFCE6493234")
    private void nativeMoveSelection(int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "F3E4500AE9ADD95B358B2E3587FAE77E")
    private boolean nativePageShouldHandleShiftAndArrows() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591268809 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591268809;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "6D2B416AB6F7E56C4A49C22E0A8E283D")
    private boolean nativePointInNavCache(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661640335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661640335;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "7E164F51BFD26BAEB37C17707BD8874E")
    private void nativeResetSelection() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "4FCCB0475B387C1F5318EC92944C45EC")
    private Point nativeSelectableText() {
    	Point p = new Point();
    	p.addTaint(taint);
    	return p;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "5DACEC38ECF99BF3DA52929D8D3AE5DA")
    private void nativeSelectAll() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.524 -0400", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "3D9F4D8FE552F46EDFE668F28DAC36F3")
    private void nativeSelectBestAt(Rect rect) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "5DFA19011F6357FF14C8F2E2695F621D")
    private void nativeSelectAt(int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "26B3128D8E97F243BB8622CCFAEC87BA")
    private int nativeSelectionX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061373113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061373113;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "5281982F1AF5C9E3D29CD08CE845AF22")
    private int nativeSelectionY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728414782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1728414782;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "06D96C6937284C528EE2DD489A5B387D")
    private int nativeFindIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163560456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163560456;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "5AB5068259CCABEFACDEA5560EBD42C9")
    private void nativeSetExtendSelection() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "BF3E2C6C0F834088FF260D2D57AB8864")
    private void nativeSetFindIsEmpty() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "256EAA7FD60D28E5E7062DFF998E2D2D")
    private void nativeSetFindIsUp(boolean isUp) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "7A8E31F2B5D777EBEC23BD7B2069CA12")
    private void nativeSetHeightCanMeasure(boolean measure) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "AA06B3FFAAA82012E0DCB53B80602404")
    private void nativeSetBaseLayer(int layer, Region invalRegion,
            boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
            boolean registerPageSwapCallback) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "53B36A17124CADA3B6F74E58841C3199")
    private int nativeGetBaseLayer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235211288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235211288;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.526 -0400", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "7AA70DF267F5A3B8D5F1139BE8B04F95")
    private void nativeShowCursorTimed() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.527 -0400", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "2586905A54FC6D89F60FA868528B5ABD")
    private void nativeReplaceBaseContent(int content) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "0DD0F39A70B93DCE529A7DB104FE79BF")
    private void nativeCopyBaseContentToPicture(Picture pict) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "DB317B02B0B73E9435ACCDDB6DBF41E4")
    private boolean nativeHasContent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951464363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951464363;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "646E5B0E2F3492FE7CA52836500770AC")
    private void nativeSetSelectionPointer(int nativeInstance,
            boolean set, float scale, int x, int y) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "E8926725A3AB24C80DE389F855FAE02E")
    private boolean nativeStartSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1348677570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1348677570;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "A11715011B8424E4C1DF23E23BC77CCA")
    private void nativeStopGL() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "59C253F3D708B1AEFB61B74588B1BC4B")
    private Rect nativeSubtractLayers(Rect content) {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "C2D9F0C855212E0013EB4D7AA8122CE5")
    private int nativeTextGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328383086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328383086;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "357B1EA2F63D3ED8C271D67AFCCC12A7")
    private void nativeRegisterPageSwapCallback() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "2E113EDF1B459505AA2AF4625DE30F08")
    private void nativeTileProfilingStart() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "360CF8355F9F1583CEEA3ADA2C6F6C8E")
    private float nativeTileProfilingStop() {
        float var546ADE640B6EDFBC8A086EF31347E768_889375692 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_889375692;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.528 -0400", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "7EF0A6540C2A701F27B19DB98FD72058")
    private void nativeTileProfilingClear() {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.530 -0400", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "E05B1D32294BD68FCC82373865667471")
    private int nativeTileProfilingNumFrames() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878467204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_878467204;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.530 -0400", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "69FA864EC27CB9F77F0424FEFA59DEC1")
    private int nativeTileProfilingNumTilesInFrame(int frame) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792639501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792639501;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.530 -0400", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "97D40125E4063A0972DF64B5B7456334")
    private int nativeTileProfilingGetInt(int frame, int tile, String key) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628953958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628953958;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.530 -0400", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "A6C91E1DD7F20FCA7BD587DF7BAB0D76")
    private float nativeTileProfilingGetFloat(int frame, int tile, String key) {
        float var546ADE640B6EDFBC8A086EF31347E768_522764470 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_522764470;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.531 -0400", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "3ABB45EA050CAA1CCC1C02DFC1E93D91")
    private void nativeUpdateCachedTextfield(String updatedText,
            int generation) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.531 -0400", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "6123D394F533A5769E4BB11BB2FD3EF8")
    private boolean nativeWordSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655355215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_655355215;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.531 -0400", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "CF96C365BABAB4035AB0EE6C18F4C538")
     int nativeGetBlockLeftEdge(int x, int y, float scale) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825999873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825999873;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.531 -0400", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "5002655B986F7D641C298CC95BBCC6C7")
    private void nativeUseHardwareAccelSkia(boolean enabled) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.531 -0400", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "6AAF76516317F08E5CB095BDC26AF5D5")
    private int nativeScrollableLayer(int x, int y, Rect scrollRect,
            Rect scrollBounds) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651540658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651540658;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "6DED197C0CE3164D5618D97776A38BAB")
    private boolean nativeScrollLayer(int layer, int newX, int newY) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9499966 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9499966;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "CD169E3A3B653F3A1D68A46881511434")
    private void nativeSetIsScrolling(boolean isScrolling) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "CB21D7A3A20EADE6A741A1DEC5DEBF5A")
    private int nativeGetBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399934048 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1399934048;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "727A4EA95C2AA6D4EC43F6CB67F39252")
     boolean nativeSetProperty(String key, String value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756861493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756861493;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "2CDC971A436EF25C108C6D2B163E982B")
     String nativeGetProperty(String key) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "1A68B083C5E652A8EAFCED90D7609277")
    private void nativeGetTextSelectionRegion(int instance, Region region) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "D9F1018CE749271C3133A021A996233E")
    private void nativeGetSelectionHandles(int instance, int[] handles) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeOnTrimMemory(int level) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetPauseDrawing(int instance, boolean pause) {
    }

    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.533 -0400", hash_original_method = "8AECAF07C584017DF10A77A8577569BA", hash_generated_method = "8AECAF07C584017DF10A77A8577569BA")
        public InnerGlobalLayoutListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "BDE8634D3C7775A2E87DFF3E15E40528")
        public void onGlobalLayout() {
            //DSFIXME:  CODE0009: Possible callback target function detected
    if(isShown())            
            {
                setGLRectViewport();
            } //End block
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    private class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D", hash_generated_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D")
        public InnerScrollChangedListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "8B03CD623DBFBE4E062810D2854905D3")
        public void onScrollChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
    if(isShown())            
            {
                setGLRectViewport();
            } //End block
            // ---------- Original Method ----------
            //if (isShown()) {
                //setGLRectViewport();
            //}
        }

        
    }


    
    public class WebViewTransport {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_field = "873282A17E61E0691E2D2F15001F5346", hash_generated_field = "CE9B7FCDD03C866BC3B0AB067564E1E9")

        private WebView mWebview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "019254006A207FE7BCA503E59C7BDCD4", hash_generated_method = "019254006A207FE7BCA503E59C7BDCD4")
        public WebViewTransport ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "A9A4B57876E149A4CA9F2A29180461CF")
        public synchronized void setWebView(WebView webview) {
            mWebview = webview;
            // ---------- Original Method ----------
            //mWebview = webview;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "A3BC398C86B647AD6D1683425F578543")
        public synchronized WebView getWebView() {
WebView varB2F5B05B23D3BD7D25D64079184A239B_1065705941 =             mWebview;
            varB2F5B05B23D3BD7D25D64079184A239B_1065705941.addTaint(taint);
            return varB2F5B05B23D3BD7D25D64079184A239B_1065705941;
            // ---------- Original Method ----------
            //return mWebview;
        }

        
    }


    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "DCE63BA173AA93C5013F1A49F5264EB0")
        private  OnTrimMemoryListener(Context c) {
            addTaint(c.getTaint());
            c.registerComponentCallbacks(this);
            // ---------- Original Method ----------
            //c.registerComponentCallbacks(this);
        }

        
                static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.535 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "E555930F6C60B6E43E637690DA6E289E")
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newConfig.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.537 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "703A059557F06AE044520D2E93D3D2F0")
        @Override
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.537 -0400", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "8B6119E052C035A523C8AFB98A4FAD26")
        @Override
        public void onTrimMemory(int level) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(level);
    if(DebugFlags.WEB_VIEW)            
            {
                Log.d("WebView", "onTrimMemory: " + level);
            } //End block
            WebView.nativeOnTrimMemory(level);
            // ---------- Original Method ----------
            //if (DebugFlags.WEB_VIEW) {
                //Log.d("WebView", "onTrimMemory: " + level);
            //}
            //WebView.nativeOnTrimMemory(level);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.537 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "C88183308993326DA3B8CE3C16E7E9BA")

        private static OnTrimMemoryListener sInstance = null;
    }


    
    public class HitTestResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_field = "57351EA26C034458DF1F7B3C51D03D6E", hash_generated_field = "7473B88E9A243CF8ACFD2DDF98031A9D")

        private String mExtra;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "3E8436A0FC0A9040E95F25D444A899AD")
          HitTestResult() {
            mType = UNKNOWN_TYPE;
            // ---------- Original Method ----------
            //mType = UNKNOWN_TYPE;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "89AFF8CBC1B7750AC1399D58F1A48453")
        private void setType(int type) {
            mType = type;
            // ---------- Original Method ----------
            //mType = type;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "66AE08DAEF8D5073B71F7FF854ADD4F3")
        private void setExtra(String extra) {
            mExtra = extra;
            // ---------- Original Method ----------
            //mExtra = extra;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "DFDD2661CE4DA7799123DA435C203342")
        public int getType() {
            int var3462A1A18A0EE070E8953CCF1DD788C0_635877525 = (mType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800325160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_800325160;
            // ---------- Original Method ----------
            //return mType;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.538 -0400", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "5543D66C8178C49DB3ABBBAB5AC43D33")
        public String getExtra() {
String varB28E9DB870B54263DAD449908E436908_561971496 =             mExtra;
            varB28E9DB870B54263DAD449908E436908_561971496.addTaint(taint);
            return varB28E9DB870B54263DAD449908E436908_561971496;
            // ---------- Original Method ----------
            //return mExtra;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "B4460F979CFC4B3251D5DAAF48417617", hash_generated_field = "66339D0C16D16517633DFB08461D5C3F")

        public static final int UNKNOWN_TYPE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "CFFCF81F64F3B8E3F55FE79A095616A0", hash_generated_field = "C6E0A23956E4344E5A24770E8DEB80AF")

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "030676AD21D2EA5086C5086B51132C5A", hash_generated_field = "1F892F69F99B538EA9542E4188E9D049")

        public static final int PHONE_TYPE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "3C1637E264836E3E0897EBDAA762C14C", hash_generated_field = "609BC3DD941EE1B3F8DBCDEA6DC14E92")

        public static final int GEO_TYPE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "028C017E4197D9D445450EAF82927BDC", hash_generated_field = "AF4F62540D93A175F846244DE39FF3EA")

        public static final int EMAIL_TYPE = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "C069364739732F7370F9183BFBDA020C", hash_generated_field = "D1341758694A17E34931E15E5F9AE163")

        public static final int IMAGE_TYPE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "79DDA3DC402A59D3D78B1D118A52C31B", hash_generated_field = "A790FEB45D10D6E4493673EC8A439C5E")

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "2EFC0DDB47A85AFB33F856AA957A411D", hash_generated_field = "F746B9271AE854E19C3EA4F13285C847")

        public static final int SRC_ANCHOR_TYPE = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "8C48F79BD833571EE18B5D1083B6F30A", hash_generated_field = "C47A4D8A2B58A38AB94516810D897655")

        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_field = "B34737C311A023BD22EC23D2EE6165EC", hash_generated_field = "AD4F3515FDAD6418D5559EF03B760AC2")

        public static final int EDIT_TEXT_TYPE = 9;
    }


    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_method = "81C64DA14CD8ADA6B639EE9F61F2A898", hash_generated_method = "81C64DA14CD8ADA6B639EE9F61F2A898")
        public ProxyReceiver ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.539 -0400", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "C42EF95D44AA08AA5F831DA6844E92EF")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
    if(intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION))            
            {
                handleProxyBroadcast(intent);
            } //End block
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION)) {
                //handleProxyBroadcast(intent);
            //}
        }

        
    }


    
    private static class PackageListener extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_method = "F623A53A552E0B02B7648231F682A935", hash_generated_method = "F623A53A552E0B02B7648231F682A935")
        public PackageListener ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "F865EE376DBFBF90157ECB8238D4726E")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            final String action = intent.getAction();
            final String packageName = intent.getData().getSchemeSpecificPart();
            final boolean replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
    if(Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing)            
            {
                return;
            } //End block
    if(sGoogleApps.contains(packageName))            
            {
    if(Intent.ACTION_PACKAGE_ADDED.equals(action))                
                {
                    WebViewCore.sendStaticMessage(EventHub.ADD_PACKAGE_NAME, packageName);
                } //End block
                else
                {
                    WebViewCore.sendStaticMessage(EventHub.REMOVE_PACKAGE_NAME, packageName);
                } //End block
            } //End block
            PluginManager pm = PluginManager.getInstance(context);
    if(pm.containsPluginPermissionAndSignatures(packageName))            
            {
                pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class SaveWebArchiveMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_field = "A984B376DEA2CC7536617F280E80C1A1", hash_generated_field = "05C64ACC3BAB92D2CCE8178ABA3FDAE1")

        String mBasename;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_field = "542D5B30128863188515FF03C3D6C8E3", hash_generated_field = "6BCA401625C852D06DCC273A17617FED")

        boolean mAutoname;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C752F5297A11E20E661B6130B21F3B9A")

        ValueCallback<String> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_field = "7D4A7A325C0BFF5E64DDC794A8738C05", hash_generated_field = "047227D3BBCE6402C69D67FD47561A95")

        String mResultFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.540 -0400", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "4FAF880EC774D9F5D77B034A52E594C4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "46F4EE6FF41DA234C359DB3FA7F0E479", hash_generated_field = "78B7CCE03B515024F44B1EEDC44555A1")

        float mHeightWidthRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "D759EB5AB08C859641FBD87DB10B4D2E", hash_generated_field = "3A48A4BC51B3BD422EE46136E8931243")

        int mActualViewHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "8A785CDEA26539F62DF6BE00238F4644", hash_generated_field = "B26A0AD7DDE8F0FD05B17352E367406B")

        int mTextWrapWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F")

        int mAnchorX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "A5A5BAD4084BA0905925E24FE8CC16A6")

        int mAnchorY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "ABDB0A4470BBD1454ED388F3CD972EEE")

        float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "8CDB6CB0AFB9B4C0B69C02EB4DBB1F61", hash_generated_field = "63B858676F9D9765C256ADBE1D3B6A59")

        boolean mIgnoreHeight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_method = "0E4893AFBBF2A9B13986CA2BDFC332DE", hash_generated_method = "0E4893AFBBF2A9B13986CA2BDFC332DE")
        public ViewSizeData ()
        {
            //Synthesized constructor
        }


    }


    
    private class RequestFormData implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.542 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

        private String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_field = "3D50CF99C0669CD527C0C69C4AE6B44B", hash_generated_field = "0487D88BABEAE0E64EE47FD1AEEB417C")

        private Message mUpdateMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_field = "2A3109A682991470C8E7A9944372B1F8", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

        private boolean mAutoFillable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_field = "5C4062DD484011F09E7BDF9F978C283A", hash_generated_field = "F9D9BCAC942E8D5C0FAF4BD1D37CB5CF")

        private boolean mAutoComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_field = "EBB2C75EE511DE5780ECD7B092A5D38B", hash_generated_field = "93B1D4E2229B54F25A168656E4937615")

        private WebSettings mWebSettings;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "5B084D63C74BDE8B4C95B856FF4AC17D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.543 -0400", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "78F8812D1A5A7596E5CBB9186CE4FBF9")
        public void run() {
            ArrayList<String> pastEntries = new ArrayList<String>();
    if(mAutoFillable)            
            {
    if(mWebSettings != null && mWebSettings.getAutoFillProfile() != null)                
                {
                    pastEntries.add(getResources().getText(
                            com.android.internal.R.string.autofill_this_form).toString() +
                            " " +
                            mAutoFillData.getPreviewString());
                    mWebTextView.setAutoFillProfileIsSet(true);
                } //End block
                else
                {
                    pastEntries.add(getResources().getText(
                            com.android.internal.R.string.setup_autofill).toString());
                    mWebTextView.setAutoFillProfileIsSet(false);
                } //End block
            } //End block
    if(mAutoComplete)            
            {
                pastEntries.addAll(mDatabase.getFormData(mUrl, mName));
            } //End block
    if(pastEntries.size() > 0)            
            {
                AutoCompleteAdapter adapter = new
                        AutoCompleteAdapter(mContext, pastEntries);
                mUpdateMessage.obj = adapter;
                mUpdateMessage.sendToTarget();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static class QueuedTouch {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_field = "9F267F577D54234C4E24847A8B17E76A", hash_generated_field = "20EA73C9A7F9F149019985C98DE3A38D")

        MotionEvent mEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_field = "7C6961287A3682FFFA13151222676CCD", hash_generated_field = "C7A09A520003D6660CD5B4796D1273F4")

        TouchEventData mTed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "BEE6F088ABCC206EAF882A35EEC82861")

        QueuedTouch mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_method = "FA8EC88E2AD519ABBE81A37B882E4019", hash_generated_method = "FA8EC88E2AD519ABBE81A37B882E4019")
        public QueuedTouch ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "032E08FDF415D814433EDB689697ABD6")
        public QueuedTouch set(TouchEventData ted) {
            mSequence = ted.mSequence;
            mTed = ted;
            mEvent = null;
            mNext = null;
QueuedTouch var72A74007B2BE62B849F475C7BDA4658B_1628832883 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1628832883.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1628832883;
            // ---------- Original Method ----------
            //mSequence = ted.mSequence;
            //mTed = ted;
            //mEvent = null;
            //mNext = null;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.545 -0400", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "9488EE9595405AB6C1EF0F0AF949210D")
        public QueuedTouch set(MotionEvent ev, long sequence) {
            mEvent = MotionEvent.obtain(ev);
            mSequence = sequence;
            mTed = null;
            mNext = null;
QueuedTouch var72A74007B2BE62B849F475C7BDA4658B_1146374440 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1146374440.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1146374440;
            // ---------- Original Method ----------
            //mEvent = MotionEvent.obtain(ev);
            //mSequence = sequence;
            //mTed = null;
            //mNext = null;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.546 -0400", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "E6592116D7B8C2BBB1DF2EC3CED7EAF9")
        public QueuedTouch add(QueuedTouch other) {
    if(other.mSequence < mSequence)            
            {
                other.mNext = this;
QueuedTouch var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1395211767 =                 other;
                var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1395211767.addTaint(taint);
                return var4E21B9EBDCBB8C692A7FDE6A282BDC6C_1395211767;
            } //End block
            QueuedTouch insertAt = this;
            while
(insertAt.mNext != null && insertAt.mNext.mSequence < other.mSequence)            
            {
                insertAt = insertAt.mNext;
            } //End block
            other.mNext = insertAt.mNext;
            insertAt.mNext = other;
QueuedTouch var72A74007B2BE62B849F475C7BDA4658B_1325290988 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1325290988.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1325290988;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "99261C2FE4C4592C38DF4A927D54353D", hash_generated_field = "127F03A306165D2D03A139A6F1583390")

        private long mNextTouchSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "059351212566DAAB66E521AE56B5D1B9", hash_generated_field = "266156A22BD39F4F0BEF086C9C7B63E5")

        private long mLastHandledTouchSequence = Long.MIN_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "61FC8120FAFF1BD1B830C4B5C36F1B56", hash_generated_field = "AF7570BA97F43827805CB02058F37277")

        private long mIgnoreUntilSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "3964746921DBFB2211578ED44A2B4F3B", hash_generated_field = "21DBEB15ECA49C1E87E853FA0180CD65")

        private QueuedTouch mTouchEventQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "052E5BF59E84B47B0BA6B00A861D46BC", hash_generated_field = "08077047985BEF38D8C3F6BC11BCAC86")

        private QueuedTouch mPreQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "97C53AD1CE6FE2BC2B01D5BE11253B74", hash_generated_field = "F259F7EDDF59F6CEF0FD59699D3FC834")

        private QueuedTouch mQueuedTouchRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "160DA3898A622FF8D6DFD4C04ADCBAA4", hash_generated_field = "778CCCFD60C85F5AB4F8F90308D45BB5")

        private int mQueuedTouchRecycleCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_field = "B8562DF9262860FE73F90E0012C8DE0F", hash_generated_field = "1E79D4489BE43CB9AEB55D3B13DF96A3")

        private long mLastEventTime = Long.MAX_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25", hash_generated_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25")
        public TouchEventQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "69A31531703DF51E0854EC02F0B431BC")
        private QueuedTouch obtainQueuedTouch() {
    if(mQueuedTouchRecycleBin != null)            
            {
                QueuedTouch result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
                mQueuedTouchRecycleCount--;
QueuedTouch varDC838461EE2FA0CA4C9BBB70A15456B0_1317655173 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1317655173.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1317655173;
            } //End block
QueuedTouch var183328362E714AD503173BF9A8441F2C_976433545 =             new QueuedTouch();
            var183328362E714AD503173BF9A8441F2C_976433545.addTaint(taint);
            return var183328362E714AD503173BF9A8441F2C_976433545;
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleBin != null) {
                //QueuedTouch result = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = result.mNext;
                //mQueuedTouchRecycleCount--;
                //return result;
            //}
            //return new QueuedTouch();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.547 -0400", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "FF19A2C62E6D784032ABEC06DA4B653A")
        public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
            // ---------- Original Method ----------
            //mIgnoreUntilSequence = mNextTouchSequence;
            //runQueuedAndPreQueuedEvents();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.549 -0400", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "56D9E804B7C10C62A184EBEF253E5CCC")
        private void runQueuedAndPreQueuedEvents() {
            QueuedTouch qd = mPreQueue;
            boolean fromPreQueue = true;
            while
(qd != null && qd.mSequence == mLastHandledTouchSequence + 1)            
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
    if(fromPreQueue)                
                {
                    mPreQueue = qd.mNext;
                } //End block
                else
                {
                    mTouchEventQueue = qd.mNext;
                } //End block
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;
                long nextPre = mPreQueue != null ? mPreQueue.mSequence : Long.MAX_VALUE;
                long nextQueued = mTouchEventQueue != null ?
                        mTouchEventQueue.mSequence : Long.MAX_VALUE;
                fromPreQueue = nextPre < nextQueued;
                qd = fromPreQueue ? mPreQueue : mTouchEventQueue;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.549 -0400", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "439B484DE6C684EBDD4FAC7723E79F0A")
        public void preQueueTouchEventData(TouchEventData ted) {
            addTaint(ted.getTaint());
            QueuedTouch newTouch = obtainQueuedTouch().set(ted);
    if(mPreQueue == null)            
            {
                mPreQueue = newTouch;
            } //End block
            else
            {
                QueuedTouch insertionPoint = mPreQueue;
                while
(insertionPoint.mNext != null &&
                        insertionPoint.mNext.mSequence < newTouch.mSequence)                
                {
                    insertionPoint = insertionPoint.mNext;
                } //End block
                newTouch.mNext = insertionPoint.mNext;
                insertionPoint.mNext = newTouch;
            } //End block
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.549 -0400", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "9E38D05575A8E5A4585DDCDF765C3A99")
        private void recycleQueuedTouch(QueuedTouch qd) {
    if(mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH)            
            {
                qd.mNext = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = qd;
                mQueuedTouchRecycleCount++;
            } //End block
            // ---------- Original Method ----------
            //if (mQueuedTouchRecycleCount < MAX_RECYCLED_QUEUED_TOUCH) {
                //qd.mNext = mQueuedTouchRecycleBin;
                //mQueuedTouchRecycleBin = qd;
                //mQueuedTouchRecycleCount++;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.551 -0400", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "77EB87AF30611324028C928E8863EE84")
        public void reset() {
            mNextTouchSequence = Long.MIN_VALUE + 1;
            mLastHandledTouchSequence = Long.MIN_VALUE;
            mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            while
(mTouchEventQueue != null)            
            {
                QueuedTouch recycleMe = mTouchEventQueue;
                mTouchEventQueue = mTouchEventQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } //End block
            while
(mPreQueue != null)            
            {
                QueuedTouch recycleMe = mPreQueue;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.551 -0400", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "063B37C650AFCAE56AD21B5CE2D17F12")
        public long nextTouchSequence() {
            long varD32A9805A289418393939B182E7DD30D_1312932388 = (mNextTouchSequence++);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1038461199 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1038461199;
            // ---------- Original Method ----------
            //return mNextTouchSequence++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.551 -0400", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "F11038934AD30ED07981011329FF2A85")
        public boolean enqueueTouchEvent(TouchEventData ted) {
            addTaint(ted.getTaint());
            QueuedTouch preQueue = mPreQueue;
    if(preQueue != null)            
            {
    if(preQueue.mSequence == ted.mSequence)                
                {
                    mPreQueue = preQueue.mNext;
                } //End block
                else
                {
                    QueuedTouch prev = preQueue;
                    preQueue = null;
                    while
(prev.mNext != null)                    
                    {
    if(prev.mNext.mSequence == ted.mSequence)                        
                        {
                            preQueue = prev.mNext;
                            prev.mNext = preQueue.mNext;
                            break;
                        } //End block
                        else
                        {
                            prev = prev.mNext;
                        } //End block
                    } //End block
                } //End block
            } //End block
    if(ted.mSequence < mLastHandledTouchSequence)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1894760722 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382191607 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382191607;
            } //End block
    if(dropStaleGestures(ted.mMotionEvent, ted.mSequence))            
            {
                boolean var68934A3E9455FA72420237EB05902327_110498494 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448973028 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_448973028;
            } //End block
            runNextQueuedEvents();
    if(mLastHandledTouchSequence + 1 == ted.mSequence)            
            {
    if(preQueue != null)                
                {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                } //End block
                handleQueuedTouchEventData(ted);
                mLastHandledTouchSequence++;
                runNextQueuedEvents();
            } //End block
            else
            {
                QueuedTouch qd = preQueue != null ? preQueue : obtainQueuedTouch().set(ted);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1411459390 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879977817 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879977817;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.554 -0400", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "8E19C7ED2048FF69EEA73A78CA840618")
        public void enqueueTouchEvent(MotionEvent ev) {
            addTaint(ev.getTaint());
            final long sequence = nextTouchSequence();
    if(dropStaleGestures(ev, sequence))            
            {
                return;
            } //End block
            runNextQueuedEvents();
    if(mLastHandledTouchSequence + 1 == sequence)            
            {
                handleQueuedMotionEvent(ev);
                mLastHandledTouchSequence++;
                runNextQueuedEvents();
            } //End block
            else
            {
                QueuedTouch qd = obtainQueuedTouch().set(ev, sequence);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.554 -0400", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "FEF34E61A15745BF30DB0C3A1137C84E")
        private void runNextQueuedEvents() {
            QueuedTouch qd = mTouchEventQueue;
            while
(qd != null && qd.mSequence == mLastHandledTouchSequence + 1)            
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
                mLastHandledTouchSequence++;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.555 -0400", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "D88A616DDB93290ED0A849CE94E0DB97")
        private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            addTaint(ev.getTaint());
    if(ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove)            
            {
                final int dx = Math.round(ev.getX()) - mLastTouchX;
                final int dy = Math.round(ev.getY()) - mLastTouchY;
    if(dx * dx + dy * dy > mTouchSlopSquare)                
                {
                    mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                } //End block
            } //End block
    if(mTouchEventQueue == null)            
            {
                boolean varB8FB740DAA9B3C130F1A464E5F5A44B1_1762949536 = (sequence <= mLastHandledTouchSequence);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856725679 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_856725679;
            } //End block
    if(ev != null && ev.getAction() == MotionEvent.ACTION_DOWN)            
            {
                long eventTime = ev.getEventTime();
                long lastHandledEventTime = mLastEventTime;
    if(eventTime > lastHandledEventTime + QUEUED_GESTURE_TIMEOUT)                
                {
                    runQueuedAndPreQueuedEvents();
                    QueuedTouch qd = mTouchEventQueue;
                    while
(qd != null && qd.mSequence < sequence)                    
                    {
                        QueuedTouch recycleMe = qd;
                        qd = qd.mNext;
                        recycleQueuedTouch(recycleMe);
                    } //End block
                    mTouchEventQueue = qd;
                    mLastHandledTouchSequence = sequence - 1;
                } //End block
            } //End block
    if(mIgnoreUntilSequence - 1 > mLastHandledTouchSequence)            
            {
                QueuedTouch qd = mTouchEventQueue;
                while
(qd != null && qd.mSequence < mIgnoreUntilSequence)                
                {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mTouchEventQueue = qd;
                mLastHandledTouchSequence = mIgnoreUntilSequence - 1;
            } //End block
    if(mPreQueue != null)            
            {
                QueuedTouch qd = mPreQueue;
                while
(qd != null && qd.mSequence < mIgnoreUntilSequence)                
                {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } //End block
                mPreQueue = qd;
            } //End block
            boolean varB8FB740DAA9B3C130F1A464E5F5A44B1_785524393 = (sequence <= mLastHandledTouchSequence);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792384197 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792384197;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.556 -0400", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "BED44E3975894F58ABD5D896743E82FF")
        private void handleQueuedTouch(QueuedTouch qt) {
            addTaint(qt.getTaint());
    if(qt.mTed != null)            
            {
                handleQueuedTouchEventData(qt.mTed);
            } //End block
            else
            {
                handleQueuedMotionEvent(qt.mEvent);
                qt.mEvent.recycle();
            } //End block
            // ---------- Original Method ----------
            //if (qt.mTed != null) {
                //handleQueuedTouchEventData(qt.mTed);
            //} else {
                //handleQueuedMotionEvent(qt.mEvent);
                //qt.mEvent.recycle();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.556 -0400", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "F9358F79B156A9C6C4816F111C4C4FF2")
        private void handleQueuedMotionEvent(MotionEvent ev) {
            mLastEventTime = ev.getEventTime();
            int action = ev.getActionMasked();
    if(ev.getPointerCount() > 1)            
            {
                handleMultiTouchInWebView(ev);
            } //End block
            else
            {
                final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
    if(detector != null && mPreventDefault != PREVENT_DEFAULT_YES)                
                {
                    detector.onTouchEvent(ev);
                } //End block
                handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.557 -0400", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "72FC63629079713F4F748B3748BD3A8A")
        private void handleQueuedTouchEventData(TouchEventData ted) {
    if(ted.mMotionEvent != null)            
            {
                mLastEventTime = ted.mMotionEvent.getEventTime();
            } //End block
    if(!ted.mReprocess)            
            {
    if(ted.mAction == MotionEvent.ACTION_DOWN
                        && mPreventDefault == PREVENT_DEFAULT_MAYBE_YES)                
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN;
                } //End block
                else
    if(ted.mAction == MotionEvent.ACTION_MOVE
                        && mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN)                
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO;
                } //End block
    if(mPreventDefault == PREVENT_DEFAULT_YES)                
                {
                    mTouchHighlightRegion.setEmpty();
                } //End block
            } //End block
            else
            {
    if(ted.mPoints.length > 1)                
                {
    if(!ted.mNativeResult && mPreventDefault != PREVENT_DEFAULT_YES)                    
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                        handleMultiTouchInWebView(ted.mMotionEvent);
                    } //End block
                    else
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } //End block
                    return;
                } //End block
    if(!ted.mNativeResult)                
                {
switch(ted.mAction){
                    case MotionEvent.ACTION_DOWN:
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    mDeferTouchMode = TOUCH_INIT_MODE;
                    break;
                    case MotionEvent.ACTION_MOVE:
                    {
                        int x = ted.mPointsInView[0].x;
                        int y = ted.mPointsInView[0].y;
    if(mDeferTouchMode != TOUCH_DRAG_MODE)                        
                        {
                            mDeferTouchMode = TOUCH_DRAG_MODE;
                            mLastDeferTouchX = x;
                            mLastDeferTouchY = y;
                            startScrollingLayer(x, y);
                            startDrag();
                        } //End block
                        int deltaX = pinLocX((int) (mScrollX
                                    + mLastDeferTouchX - x))
                                    - mScrollX;
                        int deltaY = pinLocY((int) (mScrollY
                                    + mLastDeferTouchY - y))
                                    - mScrollY;
                        doDrag(deltaX, deltaY);
    if(deltaX != 0)                        
                        mLastDeferTouchX = x;
    if(deltaY != 0)                        
                        mLastDeferTouchY = y;
                        break;
                    } //End block
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
    if(mDeferTouchMode == TOUCH_DRAG_MODE)                    
                    {
                        mScroller.springBack(mScrollX, mScrollY, 0,
                                        computeMaxScrollX(), 0,
                                        computeMaxScrollY());
                        invalidate();
                        WebViewCore.resumePriority();
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    } //End block
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    break;
                    case WebViewCore.ACTION_DOUBLETAP:
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    break;
                    case WebViewCore.ACTION_LONGPRESS:
                    HitTestResult hitTest = getHitTestResult();
    if(hitTest != null && hitTest.mType
                                    != HitTestResult.UNKNOWN_TYPE)                    
                    {
                        performLongClick();
                    } //End block
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    break;
}
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.561 -0400", hash_original_field = "5842E73A351A2BBCD4BC86770C0E9B9A", hash_generated_field = "BB5877DC49413A9228D8F9DC3EDA4B0C")

        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.561 -0400", hash_original_field = "09C062B1DCE117D7E9D6F9016B9F35A1", hash_generated_field = "E348FC28D39D22D6D781B3B929F27054")

        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
    }


    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.563 -0400", hash_original_method = "827423792FD52B61F0723B9DB59191FF", hash_generated_method = "827423792FD52B61F0723B9DB59191FF")
        public PrivateHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.568 -0400", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "D47D1D84EB19D7F1356FF4AB17504C2D")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
    if(DebugFlags.WEB_VIEW && msg.what != INVAL_RECT_MSG_ID)            
            {
    if(msg.what >= FIRST_PRIVATE_MSG_ID
                        && msg.what <= LAST_PRIVATE_MSG_ID)                
                {
                } //End block
                else
    if(msg.what >= FIRST_PACKAGE_MSG_ID
                        && msg.what <= LAST_PACKAGE_MSG_ID)                
                {
                } //End block
                else
                {
                } //End block
            } //End block
    if(mWebViewCore == null)            
            {
                return;
            } //End block
    if(mBlockWebkitViewMessages
                    && msg.what != WEBCORE_INITIALIZED_MSG_ID)            
            {
                return;
            } //End block
switch(msg.what){
            case REMEMBER_PASSWORD:
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"),
                            msg.getData().getString("username"),
                            msg.getData().getString("password"));
                ((Message) msg.obj).sendToTarget();
                break;
            } //End block
            case NEVER_REMEMBER_PASSWORD:
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"), null, null);
                ((Message) msg.obj).sendToTarget();
                break;
            } //End block
            case PREVENT_DEFAULT_TIMEOUT:
            {
    if((msg.arg1 == MotionEvent.ACTION_DOWN
                            && mPreventDefault == PREVENT_DEFAULT_MAYBE_YES)
                            || (msg.arg1 == MotionEvent.ACTION_MOVE
                            && mPreventDefault == PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN))                
                {
                    cancelWebCoreTouchEvent(
                                viewToContentX(mLastTouchX + mScrollX),
                                viewToContentY(mLastTouchY + mScrollY),
                                true);
                } //End block
                break;
            } //End block
            case SCROLL_SELECT_TEXT:
            {
    if(mAutoScrollX == 0 && mAutoScrollY == 0)                
                {
                    mSentAutoScrollMessage = false;
                    break;
                } //End block
    if(mCurrentScrollingLayerId == 0)                
                {
                    pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                } //End block
                else
                {
                    scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX,
                                mScrollingLayerRect.top + mAutoScrollY);
                } //End block
                sendEmptyMessageDelayed(
                            SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                break;
            } //End block
            case UPDATE_SELECTION:
            {
    if(mTouchMode == TOUCH_INIT_MODE
                            || mTouchMode == TOUCH_SHORTPRESS_MODE
                            || mTouchMode == TOUCH_SHORTPRESS_START_MODE)                
                {
                    updateSelection();
                } //End block
                break;
            } //End block
            case SWITCH_TO_SHORTPRESS:
            {
                mInitialHitTestResult = null;
    if(mTouchMode == TOUCH_INIT_MODE)                
                {
    if(!getSettings().supportTouchOnly()
                                && mPreventDefault != PREVENT_DEFAULT_YES)                    
                    {
                        mTouchMode = TOUCH_SHORTPRESS_START_MODE;
                        updateSelection();
                    } //End block
                    else
                    {
                        mTouchMode = TOUCH_SHORTPRESS_MODE;
                    } //End block
                } //End block
                else
    if(mTouchMode == TOUCH_DOUBLE_TAP_MODE)                
                {
                    mTouchMode = TOUCH_DONE_MODE;
                } //End block
                break;
            } //End block
            case SWITCH_TO_LONGPRESS:
            {
    if(USE_WEBKIT_RINGS || getSettings().supportTouchOnly())                
                {
                    removeTouchHighlight();
                } //End block
    if(inFullScreenMode() || mDeferTouchProcess)                
                {
                    TouchEventData ted = new TouchEventData();
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
                else
    if(mPreventDefault != PREVENT_DEFAULT_YES)                
                {
                    mTouchMode = TOUCH_DONE_MODE;
                    performLongClick();
                } //End block
                break;
            } //End block
            case RELEASE_SINGLE_TAP:
            {
                doShortPress();
                break;
            } //End block
            case SCROLL_TO_MSG_ID:
            {
    if(msg.arg2 == 1)                
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
    if(imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView))))                    
                    {
                        break;
                    } //End block
                } //End block
                final Point p = (Point) msg.obj;
    if(msg.arg1 == 1)                
                {
                    spawnContentScrollTo(p.x, p.y);
                } //End block
                else
                {
                    setContentScrollTo(p.x, p.y);
                } //End block
                break;
            } //End block
            case UPDATE_ZOOM_RANGE:
            {
                WebViewCore.ViewState viewState = (WebViewCore.ViewState) msg.obj;
                mZoomManager.updateZoomRange(viewState, getViewWidth(), viewState.mScrollX);
                break;
            } //End block
            case UPDATE_ZOOM_DENSITY:
            {
                final float density = (Float) msg.obj;
                mZoomManager.updateDefaultZoomDensity(density);
                break;
            } //End block
            case REPLACE_BASE_CONTENT:
            {
                nativeReplaceBaseContent(msg.arg1);
                break;
            } //End block
            case NEW_PICTURE_MSG_ID:
            {
                final WebViewCore.DrawData draw = (WebViewCore.DrawData) msg.obj;
                setNewPicture(draw, true);
                break;
            } //End block
            case WEBCORE_INITIALIZED_MSG_ID:
            String drawableDir = BrowserFrame.getRawResFilename(
                            BrowserFrame.DRAWABLEDIR, mContext);
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            nativeCreate(msg.arg1, drawableDir,
                            ActivityManager.isHighEndGfx(display));
    if(mDelaySetPicture != null)            
            {
                setNewPicture(mDelaySetPicture, true);
                mDelaySetPicture = null;
            } //End block
    if(mIsPaused)            
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } //End block
            break;
            case UPDATE_TEXTFIELD_TEXT_MSG_ID:
    if(inEditingMode() &&
                            mWebTextView.isSameTextField(msg.arg1))            
            {
    if(msg.arg2 == mTextGeneration)                
                {
                    String text = (String) msg.obj;
    if(null == text)                    
                    {
                        text = "";
                    } //End block
                    mWebTextView.setTextAndKeepSelection(text);
                } //End block
            } //End block
            break;
            case REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID:
            displaySoftKeyboard(true);
            case UPDATE_TEXT_SELECTION_MSG_ID:
            updateTextSelectionFromMessage(msg.arg1, msg.arg2,
                            (WebViewCore.TextSelectionData) msg.obj);
            break;
            case FORM_DID_BLUR:
    if(inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1))            
            {
                hideSoftKeyboard();
            } //End block
            break;
            case RETURN_LABEL:
    if(inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1))            
            {
                mWebTextView.setHint((String) msg.obj);
                InputMethodManager imm = InputMethodManager.peekInstance();
    if(imm != null && imm.isActive(mWebTextView))                
                {
                    imm.restartInput(mWebTextView);
                } //End block
            } //End block
            break;
            case UNHANDLED_NAV_KEY:
            navHandledKey(msg.arg1, 1, false, 0);
            break;
            case UPDATE_TEXT_ENTRY_MSG_ID:
    if(inEditingMode() && nativeCursorIsTextInput())            
            {
                updateWebTextViewPosition();
            } //End block
            break;
            case CLEAR_TEXT_ENTRY:
            clearTextEntry();
            break;
            case INVAL_RECT_MSG_ID:
            {
                Rect r = (Rect)msg.obj;
    if(r == null)                
                {
                    invalidate();
                } //End block
                else
                {
                    viewInvalidate(r.left, r.top, r.right, r.bottom);
                } //End block
                break;
            } //End block
            case REQUEST_FORM_DATA:
            AutoCompleteAdapter adapter = (AutoCompleteAdapter) msg.obj;
    if(mWebTextView.isSameTextField(msg.arg1))            
            {
                mWebTextView.setAdapterCustom(adapter);
            } //End block
            break;
            case LONG_PRESS_CENTER:
            mGotCenterDown = false;
            mTrackballDown = false;
            performLongClick();
            break;
            case WEBCORE_NEED_TOUCH_EVENTS:
            mForwardTouchEvents = (msg.arg1 != 0);
            break;
            case PREVENT_TOUCH_ID:
    if(inFullScreenMode())            
            {
                break;
            } //End block
            TouchEventData ted = (TouchEventData) msg.obj;
    if(mTouchEventQueue.enqueueTouchEvent(ted))            
            {
                removeMessages(PREVENT_DEFAULT_TIMEOUT);
            } //End block
            break;
            case REQUEST_KEYBOARD:
    if(msg.arg1 == 0)            
            {
                hideSoftKeyboard();
            } //End block
            else
            {
                displaySoftKeyboard(false);
            } //End block
            break;
            case FIND_AGAIN:
    if(mFindIsUp && mFindCallback != null)            
            {
                mFindCallback.findAll();
            } //End block
            break;
            case DRAG_HELD_MOTIONLESS:
            mHeldMotionless = MOTIONLESS_TRUE;
            invalidate();
            case AWAKEN_SCROLL_BARS:
    if(mTouchMode == TOUCH_DRAG_MODE
                            && mHeldMotionless == MOTIONLESS_TRUE)            
            {
                awakenScrollBars(ViewConfiguration
                                .getScrollDefaultDelay(), false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(AWAKEN_SCROLL_BARS),
                                ViewConfiguration.getScrollDefaultDelay());
            } //End block
            break;
            case DO_MOTION_UP:
            doMotionUp(msg.arg1, msg.arg2);
            break;
            case SCREEN_ON:
            setKeepScreenOn(msg.arg1 == 1);
            break;
            case ENTER_FULLSCREEN_VIDEO:
            int layerId = msg.arg1;
            String url = (String) msg.obj;
    if(mHTML5VideoViewProxy != null)            
            {
                mHTML5VideoViewProxy.enterFullScreenVideo(layerId, url);
            } //End block
            break;
            case SHOW_FULLSCREEN:
            {
                View view = (View) msg.obj;
                int orientation = msg.arg1;
                int npp = msg.arg2;
    if(inFullScreenMode())                
                {
                    dismissFullScreenMode();
                } //End block
                mFullScreenHolder = new PluginFullScreenHolder(WebView.this, orientation, npp);
                mFullScreenHolder.setContentView(view);
                mFullScreenHolder.show();
                break;
            } //End block
            case HIDE_FULLSCREEN:
            dismissFullScreenMode();
            break;
            case DOM_FOCUS_CHANGED:
    if(inEditingMode())            
            {
                nativeClearCursor();
                rebuildWebTextView();
            } //End block
            break;
            case SHOW_RECT_MSG_ID:
            {
                WebViewCore.ShowRectData data = (WebViewCore.ShowRectData) msg.obj;
                int x = mScrollX;
                int left = contentToViewX(data.mLeft);
                int width = contentToViewDimension(data.mWidth);
                int maxWidth = contentToViewDimension(data.mContentWidth);
                int viewWidth = getViewWidth();
    if(width < viewWidth)                
                {
                    x += left + width / 2 - mScrollX - viewWidth / 2;
                } //End block
                else
                {
                    x += (int) (left + data.mXPercentInDoc * width
                                - mScrollX - data.mXPercentInView * viewWidth);
                } //End block
    if(DebugFlags.WEB_VIEW)                
                {
                } //End block
                x = Math.max(0,
                            (Math.min(maxWidth, x + viewWidth)) - viewWidth);
                int top = contentToViewY(data.mTop);
                int height = contentToViewDimension(data.mHeight);
                int maxHeight = contentToViewDimension(data.mContentHeight);
                int viewHeight = getViewHeight();
                int y = (int) (top + data.mYPercentInDoc * height -
                                   data.mYPercentInView * viewHeight);
    if(DebugFlags.WEB_VIEW)                
                {
                } //End block
                y = Math.max(0,
                            (Math.min(maxHeight, y + viewHeight) - viewHeight));
                y = Math.max(0, y - getVisibleTitleHeightImpl());
                scrollTo(x, y);
            } //End block
            break;
            case CENTER_FIT_RECT:
            centerFitRect((Rect)msg.obj);
            break;
            case SET_SCROLLBAR_MODES:
            mHorizontalScrollBarMode = msg.arg1;
            mVerticalScrollBarMode = msg.arg2;
            break;
            case SELECTION_STRING_CHANGED:
    if(mAccessibilityInjector != null)            
            {
                String selectionString = (String) msg.obj;
                mAccessibilityInjector.onSelectionStringChange(selectionString);
            } //End block
            break;
            case SET_TOUCH_HIGHLIGHT_RECTS:
            @SuppressWarnings("unchecked") ArrayList<Rect> rects = (ArrayList<Rect>) msg.obj;
            setTouchHighlightRects(rects);
            break;
            case SAVE_WEBARCHIVE_FINISHED:
            SaveWebArchiveMessage saveMessage = (SaveWebArchiveMessage)msg.obj;
    if(saveMessage.mCallback != null)            
            {
                saveMessage.mCallback.onReceiveValue(saveMessage.mResultFile);
            } //End block
            break;
            case SET_AUTOFILLABLE:
            mAutoFillData = (WebViewCore.AutoFillData) msg.obj;
    if(mWebTextView != null)            
            {
                mWebTextView.setAutoFillable(mAutoFillData.getQueryId());
                rebuildWebTextView();
            } //End block
            break;
            case AUTOFILL_COMPLETE:
    if(mWebTextView != null)            
            {
                mWebTextView.setAdapterCustom(null);
            } //End block
            break;
            case SELECT_AT:
            nativeSelectAt(msg.arg1, msg.arg2);
            break;
            default:
            super.handleMessage(msg);
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class InvokeListBox implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.569 -0400", hash_original_field = "AE78DDD4E1B4460118053782D7B99832", hash_generated_field = "44EE6B10D8B13CA54299546EDE76F988")

        private boolean mMultiple;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.569 -0400", hash_original_field = "A17946B2F76705FFA0DE3EA576AD2A14", hash_generated_field = "665B478A898DF171CBB5A5C66E041F86")

        private int[] mSelectedArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.569 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "C4C82616B1A0974C29170CF176A905F6")

        private int mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.569 -0400", hash_original_field = "5F8D1AB50E5C83BC9CBB9FBEC119B3B0", hash_generated_field = "9EF3ABDF3C19BF934708240D666FC0CB")

        private Container[] mContainers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.572 -0400", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "2BEBD4BED07CABA9760052B39F4E2B3A")
        private  InvokeListBox(String[] array, int[] enabled, int[] selected) {
            mMultiple = true;
            mSelectedArray = selected;
            int length = array.length;
            mContainers = new Container[length];
for(int i = 0;i < length;i++)
            {
                mContainers[i] = new Container();
                mContainers[i].mString = array[i];
                mContainers[i].mEnabled = enabled[i];
                mContainers[i].mId = i;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.572 -0400", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "A129A416D8D228FC5110EBCC6DA68346")
        private  InvokeListBox(String[] array, int[] enabled, int selection) {
            mSelection = selection;
            mMultiple = false;
            int length = array.length;
            mContainers = new Container[length];
for(int i = 0;i < length;i++)
            {
                mContainers[i] = new Container();
                mContainers[i].mString = array[i];
                mContainers[i].mEnabled = enabled[i];
                mContainers[i].mId = i;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.574 -0400", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "603A645A8187C28CC9C168F89AD2C26A")
        public void run() {
            final ListView listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            final MyArrayListAdapter adapter = new MyArrayListAdapter();
            AlertDialog.Builder b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);
    if(mMultiple)            
            {
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.573 -0400", hash_original_method = "3150D57594E9A243EB2796EE1880D262", hash_generated_method = "894DC618A9B1BF5650D02121F56BF05D")
            public void onClick(DialogInterface dialog, int which) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(which);
                addTaint(dialog.getTaint());
                mWebViewCore.sendMessage(
                                EventHub.LISTBOX_CHOICES,
                                adapter.getCount(), 0,
                                listView.getCheckedItemPositions());
                // ---------- Original Method ----------
                //mWebViewCore.sendMessage(
                                //EventHub.LISTBOX_CHOICES,
                                //adapter.getCount(), 0,
                                //listView.getCheckedItemPositions());
            }
});
                b.setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.574 -0400", hash_original_method = "167C789BB5CCECE2A545076849F2D943", hash_generated_method = "C7B30A7CB00FD8A4E057242B1AFC85BF")
            public void onClick(DialogInterface dialog, int which) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(which);
                addTaint(dialog.getTaint());
                mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
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
    if(mMultiple)            
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                int length = mSelectedArray.length;
for(int i = 0;i < length;i++)
                {
                    listView.setItemChecked(mSelectedArray[i], true);
                } //End block
            } //End block
            else
            {
                listView.setOnItemClickListener(new OnItemClickListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.574 -0400", hash_original_method = "4FB59E3EE3C723FAB3D9C696C9283630", hash_generated_method = "9BEE02C9DE646F9204A395E42CB64695")
            public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(id);
                addTaint(position);
                addTaint(v.getTaint());
                addTaint(parent.getTaint());
                mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                mListBoxDialog.dismiss();
                mListBoxDialog = null;
                // ---------- Original Method ----------
                //mListBoxMessage = Message.obtain(null,
                                //EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                //mListBoxDialog.dismiss();
                //mListBoxDialog = null;
            }
});
    if(mSelection != -1)                
                {
                    listView.setSelection(mSelection);
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listView.setItemChecked(mSelection, true);
                    DataSetObserver observer = new SingleDataSetObserver(
                            adapter.getItemId(mSelection), listView, adapter);
                    adapter.registerDataSetObserver(observer);
                } //End block
            } //End block
            mListBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.574 -0400", hash_original_method = "718CBFBF20241D8F0DF84EA7F924765B", hash_generated_method = "D45692B15DF1FC5F996733F2A1DF9BF2")
            public void onCancel(DialogInterface dialog) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                addTaint(dialog.getTaint());
                mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                mListBoxDialog = null;
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "0DD8A30A5B66E3389BB7F1641026A732")

            String mString;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "3811FA45E31C1288EF4A5CD0AF26B346")

            int mEnabled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

            int mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4", hash_generated_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4")
            public Container ()
            {
                //Synthesized constructor
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "877E66794E1D2A03DCD31937288B3DE8")
            @Override
            public String toString() {
String var75072598B7D3134F486D8124E4A05B56_786356874 =                 mString;
                var75072598B7D3134F486D8124E4A05B56_786356874.addTaint(taint);
                return var75072598B7D3134F486D8124E4A05B56_786356874;
                // ---------- Original Method ----------
                //return mString;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "D6517EB4E1F45C61EEFB510AAF08C057", hash_generated_field = "286E6252D1F55A019AFE2E7F01596CD3")

            final static int OPTGROUP = -1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "EADC20B7F6688B86F7C891B4EEEBB80D", hash_generated_field = "B55392C731ABAA66EEF81A3CED619863")

            final static int OPTION_DISABLED = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.575 -0400", hash_original_field = "5B1BBEBA286149605978186AE4B3FCC0", hash_generated_field = "4F0BC4F0AB9BA9C14CA01391DF9AFF29")

            final static int OPTION_ENABLED = 1;
        }


        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.576 -0400", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "49BA01A9414CEFE48019AF33DD04C46A")
            public  MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.576 -0400", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "03380DB8440C13A52F1FF484286A457E")
            @Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                addTaint(parent.getTaint());
                addTaint(convertView.getTaint());
                addTaint(position);
                convertView = super.getView(position, null, parent);
                Container c = item(position);
    if(c != null && Container.OPTION_ENABLED != c.mEnabled)                
                {
                    LinearLayout layout = new LinearLayout(mContext);
                    layout.setOrientation(LinearLayout.VERTICAL);
    if(position > 0)                    
                    {
                        View dividerTop = new View(mContext);
                        dividerTop.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerTop);
                    } //End block
    if(Container.OPTGROUP == c.mEnabled)                    
                    {
    if(mMultiple)                        
                        {
                            Assert.assertTrue(convertView instanceof CheckedTextView);
                            ((CheckedTextView) convertView).setCheckMarkDrawable(null);
                        } //End block
                    } //End block
                    else
                    {
                        convertView.setEnabled(false);
                    } //End block
                    layout.addView(convertView);
    if(position < getCount() - 1)                    
                    {
                        View dividerBottom = new View(mContext);
                        dividerBottom.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerBottom);
                    } //End block
View var6BB281F92ECF603ABC908502047A266C_1588984005 =                     layout;
                    var6BB281F92ECF603ABC908502047A266C_1588984005.addTaint(taint);
                    return var6BB281F92ECF603ABC908502047A266C_1588984005;
                } //End block
View var78FE9B874BBEC69B62B43EE963245978_189537325 =                 convertView;
                var78FE9B874BBEC69B62B43EE963245978_189537325.addTaint(taint);
                return var78FE9B874BBEC69B62B43EE963245978_189537325;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.576 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "445CBFE01AE79255B903BF90B7405879")
            @Override
            public boolean hasStableIds() {
                boolean var68934A3E9455FA72420237EB05902327_457466440 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884123586 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884123586;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "41F62C3584085CE5F53F0E8236FCE95D")
            private Container item(int position) {
                addTaint(position);
    if(position < 0 || position >= getCount())                
                {
Container var540C13E9E156B687226421B24F2DF178_1438767132 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1438767132.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1438767132;
                } //End block
Container var611A743F3067D78BE40B62E4826C2390_96331526 =                 (Container) getItem(position);
                var611A743F3067D78BE40B62E4826C2390_96331526.addTaint(taint);
                return var611A743F3067D78BE40B62E4826C2390_96331526;
                // ---------- Original Method ----------
                //if (position < 0 || position >= getCount()) {
                    //return null;
                //}
                //return (Container) getItem(position);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "1F6685F0386B027D77081ED9CB6760CC")
            @Override
            public long getItemId(int position) {
                addTaint(position);
                Container item = item(position);
    if(item == null)                
                {
                    long var6BB61E3B7BCE0931DA574D19D1D82C88_886264490 = (-1);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_726672301 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_726672301;
                } //End block
                long varCB9EEDB5F4805D084E04FBC459D0ECCE_654560907 = (item.mId);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_82396410 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_82396410;
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return -1;
                //}
                //return item.mId;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "6A5995FAFF925D1C979CB4DFBAE3E62E")
            @Override
            public boolean areAllItemsEnabled() {
                boolean var68934A3E9455FA72420237EB05902327_2117671353 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407113329 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407113329;
                // ---------- Original Method ----------
                //return false;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "DCF4B4D018A48200D41E962A5333614F")
            @Override
            public boolean isEnabled(int position) {
                addTaint(position);
                Container item = item(position);
    if(item == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1728042492 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681973732 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_681973732;
                } //End block
                boolean var07418C19DE243BC27D754335B9D739D0_327613124 = (Container.OPTION_ENABLED == item.mEnabled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992811715 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992811715;
                // ---------- Original Method ----------
                //Container item = item(position);
                //if (item == null) {
                    //return false;
                //}
                //return Container.OPTION_ENABLED == item.mEnabled;
            }

            
        }


        
        private class SingleDataSetObserver extends DataSetObserver {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_field = "1628F13DF17E9E9D9F9B263B8D9EDD6C", hash_generated_field = "2D84C7F454FDE105876BFC5F1B67C86D")

            private long mCheckedId;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

            private ListView mListView;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6E193E3C34AABA5E66E6DED38A82989F")

            private Adapter mAdapter;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "E96D6794E0A94B47CBCDFF86041C30D5")
            public  SingleDataSetObserver(long id, ListView l, Adapter a) {
                mCheckedId = id;
                mListView = l;
                mAdapter = a;
                // ---------- Original Method ----------
                //mCheckedId = id;
                //mListView = l;
                //mAdapter = a;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.577 -0400", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "FF44B9A0EC6EFFB899E6AB2A062FC77D")
            @Override
            public void onChanged() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                int position = mListView.getCheckedItemPosition();
                long id = mAdapter.getItemId(position);
    if(mCheckedId != id)                
                {
                    mListView.clearChoices();
                    int count = mAdapter.getCount();
for(int i = 0;i < count;i++)
                    {
    if(mAdapter.getItemId(i) == mCheckedId)                        
                        {
                            mListView.setItemChecked(i, true);
                            break;
                        } //End block
                    } //End block
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "BE33F1BA0BEAFDD282FD866A71F8C820", hash_generated_field = "C884772B85D7A19B6E7193901BB68389")

    static private final boolean AUTO_REDRAW_HACK = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "B69D7271B5B04F230CFD3A39801848FE", hash_generated_field = "3DDB64784E4CB9C9D138ACE428331F35")

    static final String LOGTAG = "webview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "401D0C50F5B5682013FF8501F0AE4992", hash_generated_field = "18A327C2449F72346CC969AA861F8DED")

    private static final int TOUCH_SENT_INTERVAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "FDA2833B881423CF2382162CF73E5DD8", hash_generated_field = "53225B6EA9B5E46653E7A2FF841F62C6")

    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "830E36417005DF9041C9C155F5AF0C5E", hash_generated_field = "0E03AEB798357E5423FA6ECC32D0ACBF")

    private static final int TOUCH_INIT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "BC0287058F8F9C0519ADF1B05059B082", hash_generated_field = "1E0980F04B2FCD375BEABB7363B8FF68")

    private static final int TOUCH_DRAG_START_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "60FF79799CAE259EC9644FE4567C81E9", hash_generated_field = "83AE715CF0D0671A947C87A1241F0CA1")

    private static final int TOUCH_DRAG_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "8C98CB345A5C0960936AFB57236AE88D", hash_generated_field = "0CF4A98B15B6BE2EA0162F1E9D30FC12")

    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "4EE5240F8B0AE93BC98E85CB9DC7832A", hash_generated_field = "FECEEB0AF4271E899239BD7E9D392EBF")

    private static final int TOUCH_SHORTPRESS_MODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "45A1C3A3DFB55C39DB0613949B81D56D", hash_generated_field = "64F3E1DC401E3A13C6A5A084547AFA2E")

    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "542A404318769EFE31C3373EC72F80C0", hash_generated_field = "A9451B2FBF47965DCA0749E0900C1CA7")

    private static final int TOUCH_DONE_MODE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "50B3C9A9C73BD42555AEF7EF2E21DDBF", hash_generated_field = "D21FFBF08857043ABC578F1B36B815A5")

    private static final int TOUCH_PINCH_DRAG = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "53FA87A229E47122811D2AC915236BDB", hash_generated_field = "06D188067A2E01E8C0722603047A2705")

    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "243187813A74B6724D1D7D013A4914BF", hash_generated_field = "00B1D06ABC60B4D9DE848C3A99A708E8")

    private static final int PREVENT_DEFAULT_NO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "114BA0DFA413E46BD05BCCCAE52F7CE9", hash_generated_field = "DE6AB7A95401C72A4B1DD8181041E794")

    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "764EAA1B45BBED56BEFF79F78CCCC30F", hash_generated_field = "ED8840ED75A291E8054A7C1BB5671FBA")

    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "115EA2E1D84C5A2DBB3A66D18E55207E", hash_generated_field = "F777B90C70D246657A3C6B01F65E2838")

    private static final int PREVENT_DEFAULT_YES = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "6E418AA2FF2BF9C4AAC516F3D1516EB4", hash_generated_field = "4874F2F37BC83962E22DDD1E2023B942")

    private static final int PREVENT_DEFAULT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "01D9479B5CB4E71DC6D0011835E1DB7F", hash_generated_field = "446CCE199F5D3015561B78678D2F07D8")

    private static final int TAP_TIMEOUT = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "DAFA273212F04FC87B65CE7853DD4431", hash_generated_field = "E78B19BF94D0E2E7ABD1F2CBBC9D67B8")

    private static final int LONG_PRESS_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.578 -0400", hash_original_field = "3615EDC2077354E3863F1AA174E54A2F", hash_generated_field = "37FBC39ACE1B888AF1A1226526A7D957")

    private static final int MIN_FLING_TIME = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "D58A8B27FE3FA5C832771535E3640C37", hash_generated_field = "A558F8CE44ACC3F82805560DA4A932C7")

    private static final int MOTIONLESS_TIME = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "1CD32C13456CF785393CD5CEF1F8FE90", hash_generated_field = "F573EA34E02588F19A8B5DB8F4B4F895")

    private static final int PAGE_SCROLL_OVERLAP = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "85BC58835EF22EB8B7BFF6BF6659DAB0", hash_generated_field = "9F54938D22845D58128476233294B76A")

    private static final int STD_SPEED = 480;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "C5EECEC275CDFA7928896A1923B370C6", hash_generated_field = "9CD1C2BB172E17A60A57E99E0950EF4F")

    private static final int MAX_DURATION = 750;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "EF4821831D32A9783A9848E8A3E2A3A6", hash_generated_field = "02D03CB624675F55BDCD5E41671FD647")

    private static final int SLIDE_TITLE_DURATION = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "24A904D49EE9497D9F59EB6815718BD9", hash_generated_field = "E8C9A528EEF567C1C6F71F0F8BDD0AD6")

    private static Paint mOverScrollBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "73148EE68E3BF99A9D7C02B4BA6163F6", hash_generated_field = "9CFFB41CE7C3DFBAB932F7E5B2B5A059")

    private static Paint mOverScrollBorder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "BB8DFFB09685AD77BA9927AC1D758774", hash_generated_field = "BF51A867D871DC62C484459645C786EE")

    private static final int MOTIONLESS_FALSE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "9B547B86098357EF9040837C5801F603", hash_generated_field = "221783611900669BBF31AB8C03851102")

    private static final int MOTIONLESS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "B0E7FFFCB301B45048F9EEB47D7877B9", hash_generated_field = "1D92A2861F83A93813AB357DE4223391")

    private static final int MOTIONLESS_TRUE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "3DE6CF176FEB4908AE3D96A9A6F4F88B", hash_generated_field = "C6E1D10F9F9872B9A144832957CA340B")

    private static final int MOTIONLESS_IGNORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "73FED487255AE81470218D0CBF3A09FE", hash_generated_field = "56E82801D034FBA81618FDC04F23AD89")

    static final boolean USE_JAVA_TEXT_SELECTION = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "51619C191BA20D95DACC60375D2D07F0", hash_generated_field = "76611AB1485AA5FC8BD8987CF3E25BA9")

    static final boolean DEBUG_TEXT_HANDLES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "1AEBD097FC2E1CD6F89DD1815A965E31", hash_generated_field = "F714A1E692291741531539A5847EE5E7")

    static final boolean USE_WEBKIT_RINGS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "B282E941A1CF3225E10262EA2884F7C3", hash_generated_field = "D99D6450883933EC3EDB9D544EA20E89")

    private static final int HIGHLIGHT_COLOR = 0x6633b5e5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "9BDC47B861E33CE5CF5D947AD0F57B59", hash_generated_field = "B9E672C8C92E4F02476A87E5E8F00EFF")

    private static final float TOUCH_HIGHLIGHT_ARC = 5.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "ED37554492F6447916EB8E7CD93BD07D", hash_generated_field = "D9CFD52B18DD7ACE5C7B4C9B8DCE0FB8")

    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "EB8E2B25D453DF18B2094FCBD1B00BD9", hash_generated_field = "9694C60ABD71F7A40135B185FF8C39AE")

    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "49AC45054CF7856A64543A32C588FA23", hash_generated_field = "845FF623ACA8C5E4C6AACC50D38E08AD")

    private static final int REMEMBER_PASSWORD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.579 -0400", hash_original_field = "E4E660C7AE61BE902790AC4D73AC49CF", hash_generated_field = "4FF8F5E62D23B1965B10DFC91A32FDAE")

    private static final int NEVER_REMEMBER_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "10435B44801FE7F48C9F6D6372BDBB48", hash_generated_field = "B588C19F42988465D315DA2A4FBBA3FD")

    private static final int SWITCH_TO_SHORTPRESS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "530A8354858626CD11B71F031040A8E8", hash_generated_field = "657A48B0D0DC22729992E21828434A12")

    private static final int SWITCH_TO_LONGPRESS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "4D5243D5F746CB51670C65AA9BE7F05E", hash_generated_field = "186CFC188140DCBE345F602F7F0C2905")

    private static final int RELEASE_SINGLE_TAP = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "1289E896C38EE9E355229E2F451A0BC9", hash_generated_field = "79842F5FC0B8AB67D642FA8B9A679175")

    private static final int REQUEST_FORM_DATA = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "A43738E6619122218BEFFA63A7C1E03F", hash_generated_field = "A32950EE1B5E9CE33CFBA9FC2515D222")

    private static final int DRAG_HELD_MOTIONLESS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "C113C7F74C1996CA65C2696D86748284", hash_generated_field = "EE164C411576EF13FF1F4368945ABBDA")

    private static final int AWAKEN_SCROLL_BARS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "B65F2CF00C901DE7591BAC977345FBC8", hash_generated_field = "9AA9F86C18770C4CCDF9B4E83C0A3AE1")

    private static final int PREVENT_DEFAULT_TIMEOUT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "7CB2EB69693E24C1E3251BB6A2E4B18C", hash_generated_field = "1A30728C562EE960FCAE38492FDF5A10")

    private static final int SCROLL_SELECT_TEXT = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "3059CA9576FD841DE6A4EABDD0120D8A", hash_generated_field = "C4C2FB6BF24B5B91EE6F668B637E3F5E")

    private static final int FIRST_PRIVATE_MSG_ID = REMEMBER_PASSWORD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "519D5D8383980F94F362D163FA1DD3A4", hash_generated_field = "CC36E89D4F3E8BDB7A3B14B8623FFDC6")

    private static final int LAST_PRIVATE_MSG_ID = SCROLL_SELECT_TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "D55D1847289294695B340BDD6B988D61", hash_generated_field = "7254467C2E49F4861061982FEF332006")

    static final int SCROLL_TO_MSG_ID = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "7C3FDB228096679810DC186C1CF5D088", hash_generated_field = "7065AF08B8A2C65D18732F27B9BF7699")

    static final int NEW_PICTURE_MSG_ID = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "5D4D86559B515C33EA45F74EAD2CC2C9", hash_generated_field = "277D21369AF0DCC3922F2C0900E0BF83")

    static final int UPDATE_TEXT_ENTRY_MSG_ID = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "27425AA4F646CE9409853E6F26DBF525", hash_generated_field = "2190393FA6B05377859E2EC02FC609B1")

    static final int WEBCORE_INITIALIZED_MSG_ID = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "5AC192AFA63C2DA703CD387DE90D4698", hash_generated_field = "363113902179F1670C84BE84F2AB8C31")

    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "C609D9E92E308266EDF2BEBD11FE2195", hash_generated_field = "4013CBF1F8ABDA417E1F0266A418CE84")

    static final int UPDATE_ZOOM_RANGE = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "54C3FACEFBED28B431192B4CDBE80F30", hash_generated_field = "ACAC39F47E162B00CF5452C8D285224A")

    static final int UNHANDLED_NAV_KEY = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "E29CE477AA12360FD97442B94DAA604D", hash_generated_field = "D4C9BC4EE92065A4B38085E347EBFF2D")

    static final int CLEAR_TEXT_ENTRY = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "8C4DA7752E60D44364A5ECFCEF99A265", hash_generated_field = "FE149D6B2BEA3EF65A0F281FAAB4BD1B")

    static final int UPDATE_TEXT_SELECTION_MSG_ID = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "84608AF3D8EA7A17339C6FED52EFB3A5", hash_generated_field = "AAAC74426AC96A03AD3699140276236E")

    static final int SHOW_RECT_MSG_ID = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.580 -0400", hash_original_field = "EA5BFD49CB9CF50F04845C0B4CE85222", hash_generated_field = "5AAABADC1AB3CEBAA78D6532F857C623")

    static final int LONG_PRESS_CENTER = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "69651E0CF2DFC70C890C9154E5E8EEC9", hash_generated_field = "201D6503E6272B55C420339E2E7BDE7C")

    static final int PREVENT_TOUCH_ID = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "1AA05479A95D5BD8B976401AEBB8CCDE", hash_generated_field = "A86F64A6A36838BB94E4B146AB31DF86")

    static final int WEBCORE_NEED_TOUCH_EVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "FAF53D01BEE8944F7215354C856F468D", hash_generated_field = "79B69F5D8A24CF7E46EB19A46659BFA2")

    static final int INVAL_RECT_MSG_ID = 117;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "F47CC7CACF8E20748A09BD16E3A63C93", hash_generated_field = "924815315D700D740440DFA55EE36D91")

    static final int REQUEST_KEYBOARD = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "6DC3FF7954CA1B8684172C35663F6018", hash_generated_field = "4768152ADFCA823C71171A5E37B97106")

    static final int DO_MOTION_UP = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "003B744EDA0119EC87BE6E2D37CC9FD0", hash_generated_field = "E7977AC2556CED43CF07CEE5AF8FDE33")

    static final int SHOW_FULLSCREEN = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "6916AD38396C039CF7A2A9D6861B5AF3", hash_generated_field = "B95AC15CEB23F6D073C96BA18C56AFC4")

    static final int HIDE_FULLSCREEN = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "9566E946872EB8E7E6449806A9DF33D9", hash_generated_field = "11B42A13FA8326EB24C2CB47B363607D")

    static final int DOM_FOCUS_CHANGED = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "2EF259B427BB991D0C937BFB2BE3C42B", hash_generated_field = "993E493207463D5A7619CFA9914C444F")

    static final int REPLACE_BASE_CONTENT = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "8F6D1F23B16393627AFD799A33AAFF06", hash_generated_field = "656F7FC823E801D32B0F7134A367764C")

    static final int FORM_DID_BLUR = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "2EC1934D71D80965F1B69F5FF6FED113", hash_generated_field = "96DB2122D5F33DFDA3965819F33C1149")

    static final int RETURN_LABEL = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "AEB0E9A0D786D281759570E1D3D1AF21", hash_generated_field = "E77F6B5D2A8DAA7E01A4E6E904DA5730")

    static final int FIND_AGAIN = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "5B535484FC890961BE35B4A3205AA615", hash_generated_field = "72BDFF2047DC48D536EFABE2C6EBF63A")

    static final int CENTER_FIT_RECT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "A7D2B49B5AE9081B8DDDD83C00736EE3", hash_generated_field = "8BE537A1AEFB91D6733828F1CA586112")

    static final int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "C7E93A778889DDC7932BAEEB5BCEE567", hash_generated_field = "A9F84DE94816567373BF26E254C087FE")

    static final int SET_SCROLLBAR_MODES = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "B3177134897C8DFFA9BAB5BA3C05B8B7", hash_generated_field = "AD64A4F8822122E1A34DBBC79E31614C")

    static final int SELECTION_STRING_CHANGED = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "CA6D15AAF79CDD46037E73B025B37834", hash_generated_field = "8CDB94B0E367FF9B79372CF48343B648")

    static final int SET_TOUCH_HIGHLIGHT_RECTS = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "2EA3BEAA3C901DC2BB377FB00BECFE92", hash_generated_field = "03CC030275D6F647B2B790C448B6FE84")

    static final int SAVE_WEBARCHIVE_FINISHED = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "50AB73069C58FAC296166BC532CB5760", hash_generated_field = "FFD1C9BADD0FACA49935CBF0B35A5383")

    static final int SET_AUTOFILLABLE = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "0A1BEFD7E68E18BF9CC202EF323666D4", hash_generated_field = "BC4DF909BBCB4938EDEA9A6C5ED1E05E")

    static final int AUTOFILL_COMPLETE = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "E7E3A002FB23C3217F9D944DEA5F5B54", hash_generated_field = "1A34A6FEE310D5268F65BDDC9AB9E463")

    static final int SELECT_AT = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "3A8C6A82BDA7D9C95C7EFB68018C9372", hash_generated_field = "170B2EC041BE3DE273500B68E73B6761")

    static final int SCREEN_ON = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "E361A725E223177E8552B43A81658190", hash_generated_field = "73783E2BCB2A1F25F9EF7718CCC75157")

    static final int ENTER_FULLSCREEN_VIDEO = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "204186BCD7E786A5A01B660759D544CF", hash_generated_field = "8C35AD6313526A4AA2605C4FC66BF0A4")

    static final int UPDATE_SELECTION = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.581 -0400", hash_original_field = "BFE5627CEC722F03BA59FF5AF23934A4", hash_generated_field = "9390DCDC12CE0060B9E23ED7E29C5AC0")

    static final int UPDATE_ZOOM_DENSITY = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "AFEBA1F2632AD4DE0C180140E8F1E592", hash_generated_field = "8C572792B03EEB5427DEDA49100454ED")

    private static final int FIRST_PACKAGE_MSG_ID = SCROLL_TO_MSG_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "071F2F9C86F5CED219B8D50D1677ECBC", hash_generated_field = "4E7D46918644EB2075A696C11D88350A")

    private static final int LAST_PACKAGE_MSG_ID = SET_TOUCH_HIGHLIGHT_RECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "F8621D1D7316FE89A39C049148B16B1D", hash_generated_field = "EC4F303E77A821379320E37664FF35DF")

    static final String[] HandlerPrivateDebugString = {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "E469D0A32FE5EEFBB04FAC2135540B9A", hash_generated_field = "901B45DD84C4CF5B9A7D7031ADD68131")

    static final String[] HandlerPackageDebugString = {
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "B0207B3D1F105BD4C6FF1DFB3397F6BE", hash_generated_field = "9761827C7845EFC6D5CF4797497EE272")

    static final int DEFAULT_VIEWPORT_WIDTH = 980;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "C7C52A666164DF7B3E364496B072FA1B", hash_generated_field = "38CEEAAAB3790DFAD8857A5E87A0E5A9")

    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "EFE4F3F527E58E1F472661269CB21F20", hash_generated_field = "12DD7BA1ECB0CEEABEAEA8C19EA4EEC0")

    private static final int SNAP_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.582 -0400", hash_original_field = "40DB83FCE6FE454744F6D2EA70F24618", hash_generated_field = "44F29DF20F3360AEBB95E56773127AF4")

    private static final int SNAP_LOCK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "1173B417EA85A1FE1B2816EC3B3B9805", hash_generated_field = "6DBF6AE108E04D4351B186A179DF3FCA")

    private static final int SNAP_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "80C11D80611607FDE87E0C854EDA9C19", hash_generated_field = "5AFF215A3A6D74F76184DEFB1B36A42A")

    private static final int SNAP_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "4662EDB02CABDC9825DB87E85EA0A479", hash_generated_field = "93A7BEEBD6A337BD2002A7AF261BA794")

    private static final int DRAW_EXTRAS_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "03D3C784194DBDDB8EF2D8674C4CB97E", hash_generated_field = "5DEF86C95A734C2BFB2CF176BC8AC764")

    private static final int DRAW_EXTRAS_FIND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "13C056443A8265E118C25957CACC59A9", hash_generated_field = "F45EEC0EFD9D990731D68240BE77F3B6")

    private static final int DRAW_EXTRAS_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "72B04644BE104633F973AB39BEFF1D92", hash_generated_field = "DB426EFE262457E5F8DE02B93DD898EE")

    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "94CE3CC595BF8C31C237A3991205B7A7", hash_generated_field = "9CB3776FCE6B53D91225CA998E19D152")

    private static final int SCROLLBAR_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "08412D589FB359281E6F51BDCD28A4F1", hash_generated_field = "A8314BA3A711CC792258269C0F75D504")

    private static final int SCROLLBAR_ALWAYSOFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "05E7871F3F6659B23C0E3D2C6201072C", hash_generated_field = "91745CC4B7D62D037FA8FA9A02FEAC20")

    private static final int SCROLLBAR_ALWAYSON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "1AFD361CD4099877E4EE1B9DBAB07A29", hash_generated_field = "5F56089957CE2AA577D90FD2366DCB5C")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "DA7BB58AAB3614069121B03E82B783E3", hash_generated_field = "C154CE6C5A7DD848C5458E579A34E977")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "A737E64624713D057C27854F572D03CE", hash_generated_field = "3EE141793CAB7DBE4F282C0A0792360A")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "FD3BAC1D0E0B96B8A53C06BB67C68A8F", hash_generated_field = "7FEACEF0FBD261C47258EABED39A961E")

    private static final String ALIAS_ACCESSIBILITY_JS_INTERFACE = "accessibility";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "2F570EB1C0B5AF92ED302A83FC29354A", hash_generated_field = "B29CA3A404F2C496300BF93ECDFE7B1F")

    private static final String ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT = "javascript:(function() {" +
        "    var chooser = document.createElement('script');" +
        "    chooser.type = 'text/javascript';" +
        "    chooser.src = 'https://ssl.gstatic.com/accessibility/javascript/android/AndroidScriptChooser.user.js';" +
        "    document.getElementsByTagName('head')[0].appendChild(chooser);" +
        "  })();";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "B5113A5B1DAE52AA872D7A1E0158A2B6", hash_generated_field = "AEB0CAD4A217DE1EC3D3A6DD22EAA58A")

    private static final String PATTERN_MATCH_AXS_URL_PARAMETER = "(\\?axs=(0|1))|(&axs=(0|1))";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "4207D404B869699B69E8B9A28FF0112D", hash_generated_field = "0B476E3CCACC629DB9A3D288788EC4D4")

    static boolean mLogEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "B932813E6159962053C79AB9C0A459E5", hash_generated_field = "EED2A629500C8CA0653CD2F48FDAD9D7")

    private static boolean sNotificationsEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "FD797E3F2ECF357959667B87D54163F3", hash_generated_field = "1105526185EEB7FC5A898096FC617896")

    public static final String SCHEME_TEL = "tel:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "225D791BAFA68A3EC0D62F0726E1C7DB", hash_generated_field = "36F5F4D1322A91FC8551EC5BF47D4080")

    public static final String SCHEME_MAILTO = "mailto:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "95B5491231B2BD8A25696C3FDBF06E01", hash_generated_field = "7B183832849E08B748A127FC4F00AF3D")

    public static final String SCHEME_GEO = "geo:0,0?q=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.583 -0400", hash_original_field = "051179065C958003073ADEEFBDE35A13", hash_generated_field = "12AA7BB1627971F332190446E320A104")

    private static final long SELECT_SCROLL_INTERVAL = 1000 / 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "8E886A75D21BC0A8EDA5A50DD2A2B661", hash_generated_field = "E9A626874BEA31BC13B6B41907D72FD5")

    private static boolean mIncrementEGLContextHack = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "05C1F221F8421AA338F917FB17984ED7", hash_generated_field = "4EA311A46057E2E819D49F1C54EBACAA")

    private static ProxyReceiver sProxyReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "B04F1E80E74352FC14B6E673A4415CE7", hash_generated_field = "BE2C046AC7C6AC534B7DCBF692384BF9")

    private static boolean sPackageInstallationReceiverAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "D4FB0BB6CF479A72D29BD86B9884DB2C", hash_generated_field = "D793892490DD0E214DB1F20B155AEC44")

    private static Set<String> sGoogleApps;
    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "4D9F0ACF100BF12F3249E38226B0B830", hash_generated_field = "739202D5461617487329E2B164F8902F")

    private static final int FULLY_ON_SCREEN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "B3DAEF4CBC835FE704F50BAB24E8A713", hash_generated_field = "CE05C08766D95F4E3F036CF82E22E80D")

    private static final int INTERSECTS_SCREEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "7D0FC8807A6DAD03A3EEF8D4870C9F1C", hash_generated_field = "0FFC4C37CCC54707516F4AEADC8D4AB0")

    private static final int ANYWHERE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "33C657D7990E0880732140E3FDF51E3B", hash_generated_field = "2489EBB9D342B040697800D9D9593C68")

    private static final int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "81B6014E51F8640F4C3BE886B84FFC2F", hash_generated_field = "AF1F828F986930EB290A0C1ACE51C53E")

    private static final int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "143FC8BD92F9F5E41D5B5AA2ACC23EAF", hash_generated_field = "0002A73C608BB024BD4E79AB8BAC6B7C")

    private static final float HSLOPE_TO_START_SNAP = .25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "57D22AEB68A352A473B3BB324D0706C6", hash_generated_field = "A4A8D0695FF84A162831C09369F3446A")

    private static final float HSLOPE_TO_BREAK_SNAP = .4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "37354A8D270C32257C72BE5597FB7279", hash_generated_field = "6129E624D18CD718742AEA8DBDBB14BE")

    private static final float VSLOPE_TO_START_SNAP = 1.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "745986FED15EB48957154C828FC231A2", hash_generated_field = "B98021F16BB475A9FDBFB533AE2C5734")

    private static final float VSLOPE_TO_BREAK_SNAP = .95f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.584 -0400", hash_original_field = "74A90F27F6687BD7AEDE42DCCF796A92", hash_generated_field = "F2D9920A33A34535ECA37BEBE3D0D75B")

    private static final float ANGLE_VERT = 2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "58AA9F4B68153F9977887D7962B27368", hash_generated_field = "D881007596C110DADFB66D030A1AE042")

    private static final float ANGLE_HORIZ = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "4A747B48E4EBAF042963963238305567", hash_generated_field = "02A991FD63390E5D8237C6CD740E3288")

    private static final float MMA_WEIGHT_N = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "9F27E3A2EA0479B09454B6F4F4C36594", hash_generated_field = "6160B4B901E476897B185DB9EAAB3142")

    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "94CF454460F3D9B267AD1D71FC1B9BF2", hash_generated_field = "6A677A0E966C283B8B607D7ECEA95F9F")

    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "D17AF2C8459C9B012E8B75A161A5E702", hash_generated_field = "B007269D873CD11DCF66489AD37A9EAD")

    private static final int TRACKBALL_TIMEOUT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "AD0F5C36BF5024E1632C3A949A30653F", hash_generated_field = "38263236B59C07C6CAD6AC61CCFF665A")

    private static final int TRACKBALL_WAIT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "8598DD7F0E8E1CF6A80EFC6EE9950550", hash_generated_field = "9569AC1D1AEE74878270EB42C805F75F")

    private static final int TRACKBALL_SCALE = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "2417DDD0E0F947309A148BA8C5E5E454", hash_generated_field = "8C66096D385ED6DA92A759E273B8AD09")

    private static final int TRACKBALL_SCROLL_COUNT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "C28FA06E3FF6020B796AC6D6D435CCBE", hash_generated_field = "6749FB93CFC3225830453166B1116D09")

    private static final int TRACKBALL_MOVE_COUNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "B90911B82DAA7EFF1DCFDF49CEFDEC81", hash_generated_field = "E7BC40FBD90C7DEFDA42D41012CE3CB4")

    private static final int TRACKBALL_MULTIPLIER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "52736B1F2556D5D3FE54D29A35887B61", hash_generated_field = "0A2B827BEE20945621FE1CF47839A0CD")

    private static final int SELECT_CURSOR_OFFSET = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "81637AAEC67A193923C7C5B16D17CE5D", hash_generated_field = "60B8D37D0EC66557053483F48A69616B")

    private static final int SELECT_SCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:01.585 -0400", hash_original_field = "08F02E86CCFB75F0CC70FDFDEBC67BF2", hash_generated_field = "A9F4333AC17378DA2BC1CE8FE8AF3863")

    static final int NO_LEFTEDGE = -1;
}

