package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.065 -0400", hash_original_field = "F9F7A5E45113174158FDC3089D6C6283", hash_generated_field = "6CC6F5C62728D3C43873C2A6A3501E11")

    private InnerGlobalLayoutListener mGlobalLayoutListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.065 -0400", hash_original_field = "0E0493252E026C6EA3F70ED0CEA041F3", hash_generated_field = "FD3918832A54C40DD17CB93DF3C9E96F")

    private InnerScrollChangedListener mScrollChangedListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.065 -0400", hash_original_field = "283494DD2489884EBB23EB11D733BBAA", hash_generated_field = "AD74579540B42D36D4D6B2635A693432")

    private boolean mAutoRedraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.065 -0400", hash_original_field = "631EA221F424C96FC79D8EF82B96482B", hash_generated_field = "7D5C951A42871D1563A5277A77D69AA0")

    private AlertDialog mListBoxDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "61BC42C317CA14BCEFF4FD2F3EBC8E34", hash_generated_field = "9B99C2FE2EA0A3C0CAEC1D267CB6150C")

    private ZoomManager mZoomManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "1DCBF34BD649218E7E7E803AE2E625E3", hash_generated_field = "36ADFB8E74B62C4DEE5D800A76CE9C6D")

    private final Rect mGLRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "7884AA5B33C53128E178BF578BDB1C5A", hash_generated_field = "FB5FB956134A1E202B8B65301622285A")

    private final Rect mViewRectViewport = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "6E968EC3CE4F44C293C8CC1068A55218", hash_generated_field = "51BDAF2CD4D275E8CED0563368F453CE")

    private final RectF mVisibleContentRect = new RectF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "58BC8D59DE819547D473EF71E61BA24F", hash_generated_field = "6BED6DB5622AA2BCDA57E6A48F00385A")

    private boolean mGLViewportEmpty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "957B64C4FA99E51BCE1B62690725D115", hash_generated_field = "62789CA10670C708EA4D387AB18C5F89")

    private CallbackProxy mCallbackProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "8C0B67E1F99496AB4CD09433C231BEB3", hash_generated_field = "7BDDBEC30F299EE26388591EE1BF8D76")

    private WebViewDatabase mDatabase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "1229A917B4D1D7ED185029644D045D14", hash_generated_field = "B46B2FBDC77E7FD9B4E8141E1595B5DC")

    private SslCertificate mCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "CAA038815C3D0F5CB3961BAB79010E61", hash_generated_field = "2BD5B1AE4AB832378640307848134713")

    private int mNativeClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "9371E2004CE9EC2E60E3F0EBE8ED2E84", hash_generated_field = "73DACDCC92B5BF8822959B0368CF2255")

    private WebViewCore mWebViewCore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "81AD246FEEE7A484C6193AF867C6EF00", hash_generated_field = "51FF718FA193A9082443FB458F488215")

    final Handler mPrivateHandler = new PrivateHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "F87E097FF47BA15D994C901A5A6D99A5", hash_generated_field = "AFC642D7CC3CCD87E0FAB3BD2F752688")

    private WebTextView mWebTextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "9456149C71095D688A9DAD35901D5775", hash_generated_field = "CE8894D1C6FD3CAD90CF4E2DA3FDFD51")

    private int mTextGeneration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "E0A5EC485E1AB1339DCAF115AA8CA6AB", hash_generated_field = "998C24A93F5A243548630A07FBEEBABF")

    ViewManager mViewManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "8736C5FCC696BB24A7172AFF742B5642", hash_generated_field = "E9614F2B38AB4DEABFFB87F7486CC59B")

    PluginFullScreenHolder mFullScreenHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "86DEF530EB8B5EC2AE73B42C569FD23E", hash_generated_field = "BD4968058047E8092403B263696B6E7C")

    private int mLastTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "39477E387A7C3E4961468DBE4905BD45", hash_generated_field = "69A36CEAFC0963888AC8B4ED2F6D4978")

    private int mLastTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "3EBA7D9209AD375AB705928FB27FBC2B", hash_generated_field = "4D8D56CD18597A03E84AFA3541D74E0F")

    private int mStartTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "B83D230CA90AA46F0C6A30E0AAC3CB3B", hash_generated_field = "CEF59ED5F74695F1C489B12BA9877E2B")

    private int mStartTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "1CD1134B2ECCABF83DF9A5F9EF7AD3D9", hash_generated_field = "5C401664BB9D608028617F5EDF66E2AF")

    private float mAverageAngle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "97232569F8A97636E52CBF699FA36058", hash_generated_field = "47C433080713997997212745A4983F8F")

    private long mLastTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "BEE1113C77861A2600AB5722E55AA68B", hash_generated_field = "0990A940DEEA6D528A067E6EA87B7F9C")

    private long mLastSentTouchTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "F6A36EBCCDACC91845D214DEBFD2393F", hash_generated_field = "561D6233D1FB6E93F053BC05FD8FA507")

    private int mCurrentTouchInterval = TOUCH_SENT_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "507D8F8387EDC230B54D84A5AD8E5830")

    VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "91DDB870C2F2A4ADB7E5CD21262D80AB", hash_generated_field = "F4AD22AFC08761D5F541EC696D9C09FE")

    private int mMaximumFling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "2576CD7ADC881F56890EF9B827984445", hash_generated_field = "36A6D141DB1FFF457C16610ED5D633AD")

    private float mLastVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "38861757C9935B722CDBC8FAA59326C8", hash_generated_field = "C0F88FE2C7B9E7C7BB7B21BE6A587FCF")

    private float mLastVelX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "A7C0A582CF6C6FEDA681D202ABEFCD38", hash_generated_field = "28065D974B22FD4A98645752CE5547CF")

    private float mLastVelY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "91572FA34BDD6F68B726B50C83FB5238", hash_generated_field = "607EC8CFE97408F4374FF8F7ACABB92F")

    private int mCurrentScrollingLayerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "2A1146D1F64188A252C8E3346E729DDB", hash_generated_field = "2C565358915D9304934306126B23D037")

    private Rect mScrollingLayerRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "461524481BA85E1763B9C327D56C2779", hash_generated_field = "066849BFFA66413DA55C64140E71033C")

    private int mTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "B48B34463BD947BC8FA39E87FA3940DF", hash_generated_field = "A09D145690CCE7A19F079502BA967C9A")

    private boolean mForwardTouchEvents = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "DF19140A515EFFD1E2B2BC58874945B7", hash_generated_field = "E1D1C001302DE5375C735E7EF10D1D17")

    private int mPreventDefault = PREVENT_DEFAULT_IGNORE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "00424BCD47A1D1F32C7A4DCCF85229CA", hash_generated_field = "7A19B98B2EFB8BB31AEC747F1CA41B97")

    private boolean mConfirmMove;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "00B4977EA0CCB7CE00BDFAF3F868B20F", hash_generated_field = "BFA5428ED65131EF1CA223DF188A1122")

    private boolean mDeferTouchProcess;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "B054F7035076C1AC0991A455B3154B5A", hash_generated_field = "9F890F647D029D28EDDE18F99565D3EC")

    private int mDeferTouchMode = TOUCH_DONE_MODE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "5D2AA10D50C57E3B997C5B872BD919DA", hash_generated_field = "0B464B8324C284C9331034B27020C3DF")

    private float mLastDeferTouchX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "FE45999F6371D9229F7127CEE75A1CE3", hash_generated_field = "BB913DF57D5D59E382435C22DB0D167C")

    private float mLastDeferTouchY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "733138DD0E6826F705B37E7B22FD49C1", hash_generated_field = "1AAAA5D187A798CA7E8F507E98CEFDFE")

    boolean mDragFromTextInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "DAD3A38A52F21026BBC341FAA256F725", hash_generated_field = "73F680AEDB48E6ACAF7DB5B88D2B7A20")

    private boolean mDrawCursorRing = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "E5E0AF0CF7EBA0195F7043E5E0A523EC", hash_generated_field = "4940A67E026325EBC1382989DD930EDC")

    private boolean mIsPaused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "319A7C3B614BC1472DF37FFF84145BC0", hash_generated_field = "9F291EA33B1111436C86DAFA7D749E10")

    private HitTestResult mInitialHitTestResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "46ABC6D9AB45AE8835C53F4C51724A79", hash_generated_field = "5E5708EA89972028E86242DA050969CA")

    private int mTouchSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "2C56C8DD2FA1BBC384FAD39727EC1B9F", hash_generated_field = "6A78E5989D06DA4C68BA85646B379C51")

    private int mDoubleTapSlopSquare;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "1E242EFC2D09358FD71C3C1F7213838B", hash_generated_field = "3648C260E562DC86BDAAC7F94E7352D4")

    private int mNavSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "73C5E2D5ECE0EA511A9594C461C19390", hash_generated_field = "B290C2276932B172EE2AB0CAFBE30BAE")

    boolean mWidthCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "D476D4A439B1ACBFD02CFE299CF64FB4", hash_generated_field = "61DC23F447FF0AD3EC3A81B971B9006E")

    boolean mHeightCanMeasure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "B7A225A89985C2F4AD49415356B283C2", hash_generated_field = "0A23B55D1A7DFF5E5D35E13264ADE9DE")

    int mLastWidthSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "5C861C15724C8416BEC6F0FCF23FE8C7", hash_generated_field = "DC0C48A78A79993E34C7065A16800A42")

    int mLastHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "95E3B6E798315DEF186341A6887424F3", hash_generated_field = "03CB436788BF47F35B484535A1648867")

    int mLastActualHeightSent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "8CAE9DDC87DDEC99A752E150A6F5EE2F", hash_generated_field = "5F8C94CB44AF6FE0EF7A765D1E3AFD13")

    private int mContentWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "F40FB88A5310D2E8A8F0AC8C692796A5", hash_generated_field = "2B9929C05137BEFD1EEE8192DEC02202")

    private int mContentHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.066 -0400", hash_original_field = "1E54F53AE3E1C8B8A15A951BCE77B126", hash_generated_field = "9218818BF270D645A91FA187FE0DB745")

    private boolean mOverlayHorizontalScrollbar = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "CD5EA9067C416EBE91DDE5675BE3BA1B", hash_generated_field = "C373EF1100F74B3BFFFB5DEE30CCBD07")

    private boolean mOverlayVerticalScrollbar = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "63F6CA74EEC786DAEE7A49BF47815C33")

    OverScroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "E56E9228A5AACA55E31613E7D75FBAC2", hash_generated_field = "3C483E4AA361608032CA95612E8DD525")

    private boolean mInOverScrollMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "7B0FA1257BD698096D1B4055A23524FB", hash_generated_field = "DC1AD28F6DE5AE5C8271D33DC8A73FB4")

    private boolean mWrapContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "2CD2F011886EB329722C01D53AAD1158", hash_generated_field = "9FDC3D0BB72A7D1D7962780902257BB3")

    private int mHeldMotionless;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "501651D2D9CDF82EB68647AFA394001A", hash_generated_field = "0EF707A46ED94117316BA91515555C35")

    private AccessibilityInjector mAccessibilityInjector;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "9B2A884FD52D291BA7C8707BFD34EE95", hash_generated_field = "8427EB0277906CD3E949E13293EBEFB6")

    private boolean mAccessibilityScriptInjected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "2B2A7D23B49A9F6C312AFA3CB2DE3E9C", hash_generated_field = "61AC3E065C8F6175E76224FE4B7A0FF2")

    private Region mTextSelectionRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "4B4DC0386BBEFEBC172968A7DC512309", hash_generated_field = "BD311CF93A193EF9001A97A5DA8FE989")

    private Paint mTextSelectionPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "C68967AB1B9693AAC052C4158F7203F8", hash_generated_field = "72952B5254D373336CA0A7F293822C5C")

    private Drawable mSelectHandleLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "8DC2F2BCAE53DF5B1B45FBFA787F7CC7", hash_generated_field = "BE0700D1B06984983D5C63B2FD49DB15")

    private Drawable mSelectHandleRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "F005B92875383CAF2D0DB91BD5A06195", hash_generated_field = "19F67E28C78216AF79F5581C6BC23DEC")

    private Region mTouchHighlightRegion = new Region();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "1CD5876DA908B551FE7B696524AAF1CE", hash_generated_field = "FA05D517E862A9B2474EE135EA332D18")

    private Paint mTouchHightlightPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "621C5AE5845066BF4D6199BCBECC6B1D", hash_generated_field = "CCDC3EB9EBCFF4D16ABA2CE80EB3455A")

    private Paint mTouchCrossHairColor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "FA58B09EC58295EE657C6DB007ACFBC3", hash_generated_field = "1735D38F75F52C24227B746378768B7B")

    private int mTouchHighlightX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "0382BD0FE846CC0A70AF1041656AB97E", hash_generated_field = "44E768B9D358A889E8F0FC8017DD211E")

    private int mTouchHighlightY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "759C5A16C191C0BE465C99BF80A22070", hash_generated_field = "BCDAE3999FBCFDE5BC7A1BE619AB74DD")

    private long mTouchHighlightRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "DD91CBEAFCEF912983FE3661E07D2F39", hash_generated_field = "B9D740536C60C6D670F313EEADBF93E0")

    private HTML5VideoViewProxy mHTML5VideoViewProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "96860C09A1BA3099AD8D1DF6F1CBC12B", hash_generated_field = "D395AA199126908FEE3B0F46BA4F9C62")

    private boolean mBlockWebkitViewMessages = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "4CA2A324C4541CD9D0F4EA48A9F96383", hash_generated_field = "0A90F6A7499839588E833D7BE890E1AE")

    private boolean mHardwareAccelSkia = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "17569E5D7AFEAF1F09675CAFEE70AC45", hash_generated_field = "0E203AC987BF40A8DEA081542906FFB5")

    private int mInitialScaleInPercent = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "96C56F8983B9F3C60DFD313C8334C7F2", hash_generated_field = "C15F1FC7F9EA7829C177678DC8510856")

    private boolean mSendScrollEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "C33D97725BC57DA6085707EA571DC635", hash_generated_field = "006CA1330A69406C602E466B10C43D72")

    private int mSnapScrollMode = SNAP_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "3E6B71038C2F931B40871ADC21100E0A", hash_generated_field = "761337948FA4302FD3F9FCADBD7D6775")

    private boolean mSnapPositive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "6A001518D701D6CB7B53ADEF55E3DE3F", hash_generated_field = "E5F7424044C4D04F0D77F776582A67ED")

    private int mHorizontalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "82FBFD1714C191943520823A75AEA1E2", hash_generated_field = "4A97F423DAA345C75890FCC344743D6F")

    private int mVerticalScrollBarMode = SCROLLBAR_AUTO;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "4CDBB0B2FA9CF742D95CBF19A618E45C", hash_generated_field = "4036B77E67867608087C8B2F001B55D5")

    private TextToSpeech mTextToSpeech;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "BD6DEF1112239E4FD783977C03835AC3", hash_generated_field = "1642D7423FB15C64A4AAEE8A9C5243AD")

    private Pattern mMatchAxsUrlParameterPattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "7A5B6F76BA72A8D6AFCFCEA14B8C2556", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "755491871A4FCE3E01181030F8FEB178", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "12FFA59C64ABCA100CADAD14F3FD0971", hash_generated_field = "8B88748678D320254190188B25A37155")

    private OverScrollGlow mOverScrollGlow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "253CDCFA3EDA8CD5A1C74364F08744EB", hash_generated_field = "6DAF40C63FBB9494FA268E54C51A621E")

    private Vector<Integer> mKeysPressed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "9A53CADB33F5EF303A655D0610777BC3", hash_generated_field = "5D52BE334296C573389C0CB6810E8EF8")

    private long mLastTouchUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "1AF983C29060F075D25F478B9AD3B9FF", hash_generated_field = "EF5F7F128924D81624F7C082EE5C57AB")

    private WebViewCore.AutoFillData mAutoFillData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "1CDAE4CD4FD9DD53B530C97864727050", hash_generated_field = "72384577DFC3FC75A8B033CE6FF0A482")

    private int mBackgroundColor = Color.WHITE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "1E1680EF469A58DE61BC02D7AFF61B2E", hash_generated_field = "ABB6666AC59D2544A6D12F224E33C262")

    private int mAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "270BCD801986623A11031595AB527ABF", hash_generated_field = "A4B68D036567B21BC4865DE6F61A2F9B")

    private int mAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "02BDCA068C258B2AE7788247D564611A", hash_generated_field = "D6CD5D682502282E9E072F16ACF14D05")

    private int mMinAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "641BB905CC99A501F0B0F8356763995C", hash_generated_field = "DC36203DB61C91E1CACF31ED43B3363B")

    private int mMaxAutoScrollX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "25F76E58B1DE86A232329EAD37D8C757", hash_generated_field = "57F79EF124C5DBD88EF9E9E66F10A308")

    private int mMinAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "691CA821B0A61C2E346F0E8E6011C386", hash_generated_field = "CE9836AC2A30ED3AE38A49B2B5FD58DC")

    private int mMaxAutoScrollY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "0FAB21F904D8725647FA51D825321CFE", hash_generated_field = "C04A6808A8A8B578AE175BC815BEE12B")

    private Rect mScrollingLayerBounds = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "17862449FB2B442EDC276FAB4B340E0E", hash_generated_field = "D0A94ECA1348E1AFEFD396947BC74CA0")

    private boolean mSentAutoScrollMessage = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "51E582AA9ED1103B99D1859ED86F2854", hash_generated_field = "A3939324652696BBD6D583F09CF597D7")

    private final TouchEventQueue mTouchEventQueue = new TouchEventQueue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "FC1A1C2CFC7559351BA0746CF8CD1A87", hash_generated_field = "333D865FCED73682C738B5A705E887AA")

    private boolean mPictureUpdatePausedForFocusChange = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "5F766E69223CE3A2DD6353FDB4DA4646", hash_generated_field = "4A0FE46DD2984BED2A76807E9415B4B3")

    private PictureListener mPictureListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "E18B289B1AA9BF6AD41D419FE01ECF5C", hash_generated_field = "4EFDB68AF38CE1FE479B1628CB5C7FFE")

    private int mCachedOverlappingActionModeHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "786E4D2F6EFE89D31565DA0FBE9E6BFF", hash_generated_field = "3E16AF791F0C585BB692C30369E75608")

    private View mTitleBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "8A19A8B2E6CC6A8D99F96047D8675D0D", hash_generated_field = "82DF3ED5B282B44B1689BB6A67100AAF")

    private int mTitleGravity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "A522C70E18CD127AD691E6C09162B718", hash_generated_field = "CC333D0F8AD8FFDB25F1E8D239DE82EF")

    private Rect mLastVisibleRectSent = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.067 -0400", hash_original_field = "87BDD77C765BA4E430F3B4163B2BF16A", hash_generated_field = "9D8EB240679F63D7259D12AA2646AE20")

    private Rect mLastGlobalRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "C986798C734C496FF0C3E00A9F0B3B1C", hash_generated_field = "DBEA6A01B6683DAB3422424D4E5AF629")

    private Rect mVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "67FC07F6472A7CF0FC43C91CA1D4DE06", hash_generated_field = "78FDC6EA268F3080B428BCC4885254FD")

    private Rect mGlobalVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "89FE35C70477102B77E7D54111929F5B", hash_generated_field = "F65CE097DE2BD38B5640202605D44DCF")

    private Point mScrollOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "182F4E4C854FDC192EE5021ED6D73891", hash_generated_field = "B98693B51D24477EB14AD942E0AB2A10")

    private Point mGlobalVisibleOffset = new Point();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "C4180242D5623216D09A451DBE43E063", hash_generated_field = "E9C8FCC78A563BE608DAE1158D0138F1")

    private Rect mContentVisibleRect = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "199407FA51469180784ACB4D27639417", hash_generated_field = "18201BE28AF4897CDDE04B91A8BAC40D")

    private FindActionModeCallback mFindCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "F1DB086181F0CAC01A724E5F6A7B01A7", hash_generated_field = "339E62FC94CB6B24EC49EE818A39B374")

    private boolean mFindIsUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "97CF19FB685E1A8A858ED964EA1788D6", hash_generated_field = "B9830F0B5F0F8F825605A44BD1F53A5D")

    private String mLastFind;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "89EE3BF752EA23CCAF0158617873F303", hash_generated_field = "11CC91033432A6D33F6833384C84316E")

    private String mPageThatNeedsToSlideTitleBarOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "7901B46F62AE2A39929FC7686BE3652E", hash_generated_field = "39C14D863975598F1C60036A4E9EC22E")

    private int mYDistanceToSlideTitleOffScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "981019EBE62A3A536D4CB6BC9F6F8F10", hash_generated_field = "A47FD3369D923B9B9858ECC0900495AB")

    private int mOrientation = Configuration.ORIENTATION_UNDEFINED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "0BC67DE7618E378A590238F274E662F1", hash_generated_field = "CFB51504048F92C552B87D79FF631083")

    private SelectActionModeCallback mSelectCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "F23C74FF3A4CFCDCF12548440968300D", hash_generated_field = "588110A2CFA9E9678107331C0D2C96FA")

    private final DrawFilter mZoomFilter = new PaintFlagsDrawFilter(ZOOM_BITS, Paint.LINEAR_TEXT_FLAG);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "7FCBABA887C1AA6F4DB8B724B4D064B7", hash_generated_field = "6C99E5AC4C9CFFB5676D7E9B3F3366A7")

    private final DrawFilter mScrollFilter = new PaintFlagsDrawFilter(SCROLL_BITS, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "F3965BD9CE5BD1D03F6F6203AE992A4E", hash_generated_field = "51BC097A03E0230FE4DFAD304AA0C022")

    private boolean mDrawHistory = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "A3DEC6AFE03B45A019E4379B3CC37DA6", hash_generated_field = "E6AB03F308839A8ED10716B0A06579B2")

    private Picture mHistoryPicture = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "FCAA8D38A90DCCE574CDD58B10BDC3DE", hash_generated_field = "0C64A62751DA7E49704757557E14D916")

    private int mHistoryWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "DE2C97D507C51A2C10B04B06C4A0520E", hash_generated_field = "75F48CB3330D09CEFA904F7B84BDA417")

    private int mHistoryHeight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "683052C48052D547F9C4DC5445DC348E", hash_generated_field = "7C2550436BC0D9C9C62992FF098D00A6")

    private boolean mGotCenterDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "2BCFC118E8C010852ED640AC6552D75C", hash_generated_field = "4552704BCBDED6171FFAB0743A94FADB")

    private float DRAG_LAYER_INVERSE_DENSITY_SQUARED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "A5876C56A233FC714E9E635000FC8324", hash_generated_field = "C1BDD4A6558DC5330CEE7B5578017A71")

    private long mTrackballFirstTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "4F199D2B7F6B6927B5DB55656A242B98", hash_generated_field = "7A8E9CA6466F4282ADE2CFEAB9543F99")

    private long mTrackballLastTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "6293B146FD282AC72DBA2F0AB6B0AC97", hash_generated_field = "D0AAD41F7AF21E3C814A3CE6751CC65E")

    private float mTrackballRemainsX = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "B2F0B8878F51B0E28A6BEF74822FA868", hash_generated_field = "43DEE62CF8478127489DCB48CC70FD45")

    private float mTrackballRemainsY = 0.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "C7D88DC101403CC24F4E91CFBF164519", hash_generated_field = "7912151F282E7C954771498A3F49BAA2")

    private int mTrackballXMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "03A8324A1166DF2061C66FA4F1B4B614", hash_generated_field = "E884F524A10E52504DC2311DBDFD6B80")

    private int mTrackballYMove = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "B5FAF4AB270D8A7A37D27E98B4B0DA18", hash_generated_field = "17DE07DD7201E373F3679F7C8E42D936")

    private boolean mSelectingText = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "5CF44BCD23C9689722F24A78A3607960", hash_generated_field = "E66D148FB016EBE0AB6A510827B8EDE8")

    private boolean mSelectionStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "2DC721FB7A3355375D94983913C44B71", hash_generated_field = "A0828D99C4C5AD1E7FE83A66318FB99D")

    private boolean mExtendSelection = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "66CA05FE0F91FDFE03B5D50C0A49D303", hash_generated_field = "2908E3A71D3F7575EE5D63922F38ADEA")

    private boolean mDrawSelectionPointer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "FCD57EA55C1642A2C24E20C0B62317F7", hash_generated_field = "DF8E0D848DB8117787785920A7B48359")

    private int mSelectX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "9915E013A84779B49E4428F98E4F07FE", hash_generated_field = "FE7922D4E6B26989A17C6608E2D41B9A")

    private int mSelectY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "4CDBF52C30D68AEC1295EF779063DEAE", hash_generated_field = "F7FF545538C9AFAAB77E510B3626B30E")

    private boolean mFocusSizeChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "BDBAF306CE7923A2CD4FBC04A8D8990B", hash_generated_field = "9FA6435FA400DA07C2707641944C195D")

    private boolean mTrackballDown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "15CB522E76D287D5578A77504CB5F3BF", hash_generated_field = "7F383DE2FB2467193D38739089AE9AA7")

    private long mTrackballUpTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "02AA2026C10F3BF98FC17F7FD0E5857A", hash_generated_field = "36CFD91777BA610BB27907D3ED4B1532")

    private long mLastCursorTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "E56966E13D19AF45D41D8A9B8A5BB828", hash_generated_field = "628DA4E196378CFBF1F4C373208CA500")

    private Rect mLastCursorBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "4CAE411D150BF4CB8D1C810C5FF6BB7E", hash_generated_field = "448727DCE5669EFD2A0C0572D1060E63")

    private boolean mMapTrackballToArrowKeys = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "105553D6B610F07A7928FCC8D847A035", hash_generated_field = "AD498406B1DE6FEBF53F73747731D143")

    private DrawData mDelaySetPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "AA72F0DA830E064FB42B03478A210C1D", hash_generated_field = "200C54AE573D3744441934A403CEA512")

    private DrawData mLoadedPicture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.068 -0400", hash_original_field = "79ABB18FC2CD6E346A08940B8816FEAD", hash_generated_field = "0BBC35906DDA57724DA9629F2934A2C3")

    private Message mListBoxMessage;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.069 -0400", hash_original_method = "21880E8B1C262D01AA21DDC9EA2C3D9A", hash_generated_method = "76CCE6E01409674C3B15972BB599643B")
    public  WebView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.069 -0400", hash_original_method = "2BC47759F145D8E46BE84713D18EFE55", hash_generated_method = "AEDAEDCB684C4CD96578416A0420598D")
    public  WebView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.webViewStyle);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.069 -0400", hash_original_method = "8D09D1B25D4C4E3EEA9DADC46EE54404", hash_generated_method = "DDB3AE0225F2C452A7044B5986F7AC3C")
    public  WebView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs, defStyle, false);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.070 -0400", hash_original_method = "BE11AB5DD0D3637413B429DAD28044B2", hash_generated_method = "DEAA26941AA68230DE61FB80B1123115")
    public  WebView(Context context, AttributeSet attrs, int defStyle,
            boolean privateBrowsing) {
        this(context, attrs, defStyle, null, privateBrowsing);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(privateBrowsing);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.070 -0400", hash_original_method = "7ADEC5165C9B887ADF22EE4CFBB5B6F5", hash_generated_method = "FB8C7E363D890A457FB580DCBFCCD3D1")
    protected  WebView(Context context, AttributeSet attrs, int defStyle,
            Map<String, Object> javaScriptInterfaces, boolean privateBrowsing) {
        super(context, attrs, defStyle);
        checkThread();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid context argument");
        } 
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
        } 
        mAutoFillData = new WebViewCore.AutoFillData();
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        addTaint(privateBrowsing);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.070 -0400", hash_original_method = "1AA2C9794D97C2364A0DADD5E85D90A7", hash_generated_method = "04CCCA39115104D6AC5BA74803FE09D2")
     void incrementTextGeneration() {
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.072 -0400", hash_original_method = "A1AC2273DC9871BE36F47E0040D2078E", hash_generated_method = "9C7128487C24CA57CE3694923A1A645C")
    private void setupPackageListener(Context context) {
        {
            IntentFilter filter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
            filter.addAction(Intent.ACTION_PACKAGE_REMOVED);
            filter.addDataScheme("package");
            BroadcastReceiver packageListener = new PackageListener();
            context.getApplicationContext().registerReceiver(packageListener, filter);
            sPackageInstallationReceiverAdded = true;
        } 
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
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.072 -0400", hash_original_method = "D171E06F145F8F81C3868B74C7C19479", hash_generated_method = "BF74BFBB573850BF530E6100C5C3FAA9")
     void updateMultiTouchSupport(Context context) {
        mZoomManager.updateMultiTouchSupport(context);
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.073 -0400", hash_original_method = "EFDB63BBA889FC9B3B2A0CD1CBF7D3B4", hash_generated_method = "E456EE68EC1B170793E8BFABDE86BD08")
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.073 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "76706BC9F2CEA6C2EFA15D23451ECE58")
    @Override
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068102719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068102719;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.074 -0400", hash_original_method = "BD76970572878EAC0D8885497B30A455", hash_generated_method = "5A69CE7180A0BAC77FD0775FA436ABE3")
    private void addAccessibilityApisToJavaScript() {
        {
            boolean varBB290631FF6BE4C8F44D202E8FB380A0_1107064146 = (AccessibilityManager.getInstance(mContext).isEnabled()
                && getSettings().getJavaScriptEnabled());
            {
                final Context ctx = getContext();
                {
                    final String packageName = ctx.getPackageName();
                    {
                        mTextToSpeech = new TextToSpeech(getContext(), null, null,
                            packageName + ".**webview**");
                        addJavascriptInterface(mTextToSpeech, ALIAS_ACCESSIBILITY_JS_INTERFACE);
                    } 
                } 
            } 
        } 
        
        
                
            
            
                
                
                    
                            
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.074 -0400", hash_original_method = "57403340D85DDC97E8E063410342EC34", hash_generated_method = "A2288C92C983D5D3246AA0C172C80D09")
    private void removeAccessibilityApisFromJavaScript() {
        {
            removeJavascriptInterface(ALIAS_ACCESSIBILITY_JS_INTERFACE);
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.074 -0400", hash_original_method = "A141DE82EA292EFC5B808A2A34BC42D1", hash_generated_method = "BF2F1698187FD089D29324B55BE56A7C")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(isScrollableForAccessibility());
        addTaint(info.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.075 -0400", hash_original_method = "8DCFDD538D967DF80BFE6CF931F08E30", hash_generated_method = "1AE7F6539BE9C2FBE2F962DA6B8F52FA")
    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
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
        addTaint(event.getTaint());
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.075 -0400", hash_original_method = "127E46CC3614DA43EDC358D86D6FD6F1", hash_generated_method = "66E5B1CD7A60AF909BDADF49FD315EB6")
    private boolean isScrollableForAccessibility() {
        boolean var2E51EF2A2B51F29427B40369CE73A1BE_1126355488 = ((contentToViewX(getContentWidth()) > getWidth() - mPaddingLeft - mPaddingRight
                || contentToViewY(getContentHeight()) > getHeight() - mPaddingTop - mPaddingBottom));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131921921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131921921;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.076 -0400", hash_original_method = "54B3F9F93CD715ABE05B0EE7E2D97801", hash_generated_method = "8DB6F7DE3422AA77FA17DE80FDD068CC")
    @Override
    public void setOverScrollMode(int mode) {
        super.setOverScrollMode(mode);
        {
            {
                mOverScrollGlow = new OverScrollGlow(this);
            } 
        } 
        {
            mOverScrollGlow = null;
        } 
        addTaint(mode);
        
        
        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.076 -0400", hash_original_method = "BA4B31C47DE4BA2971C30454C84EA63B", hash_generated_method = "C90FE5FABF7FB3FAC24A237206315C9F")
     void adjustDefaultZoomDensity(int zoomDensity) {
        final float density = mContext.getResources().getDisplayMetrics().density
                * 100 / zoomDensity;
        updateDefaultZoomDensity(density);
        addTaint(zoomDensity);
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.076 -0400", hash_original_method = "7567DCE8E5EACCE5FE0A82F6C23C0491", hash_generated_method = "688F1816A2901C03B061988243CC1670")
     void updateDefaultZoomDensity(float density) {
        mNavSlop = (int) (16 * density);
        mZoomManager.updateDefaultZoomDensity(density);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.079 -0400", hash_original_method = "1B5D77CF114B98B5EB6A625E4FFAB1C2", hash_generated_method = "B43CA8C97E5632C9C2CFEA6ABA207A0B")
     boolean onSavePassword(String schemePlusHost, String username,
            String password, final Message resumeMsg) {
        
        boolean rVal = false;
        {
            mDatabase.setUsernamePassword(schemePlusHost, username, password);
        } 
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.078 -0400", hash_original_method = "99DE72360AB23E9BF4985BE8ED3FB8CE", hash_generated_method = "047177DCDA433E769B05E9723991172F")
                public void onClick(DialogInterface dialog, int which) {
                    
                    resumeMsg.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    
                    
                }
})
                    .setNeutralButton(com.android.internal.R.string.save_password_remember,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.078 -0400", hash_original_method = "BC12A66C673827B889B0C1DFB7251A66", hash_generated_method = "42BE6E1313BE7B33B1DC669B1F3396A7")
                public void onClick(DialogInterface dialog, int which) {
                    
                    remember.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    
                    
                }
})
                    .setNegativeButton(com.android.internal.R.string.save_password_never,
                    new DialogInterface.OnClickListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.078 -0400", hash_original_method = "873315778F761CDAFA793A9437C366FC", hash_generated_method = "9F2C8A88C91D099DE00989B2C8E7E335")
                public void onClick(DialogInterface dialog, int which) {
                    
                    neverRemember.sendToTarget();
                    addTaint(dialog.getTaint());
                    addTaint(which);
                    
                    
                }
})
                    .setOnCancelListener(new OnCancelListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.079 -0400", hash_original_method = "93C3AC18FD9E5633ABD9F836EA5CC3F9", hash_generated_method = "A876EDE090C42B673504583186D51370")
                public void onCancel(DialogInterface dialog) {
                    
                    resumeMsg.sendToTarget();
                    addTaint(dialog.getTaint());
                    
                    
                }
}).show();
            rVal = true;
        } 
        addTaint(schemePlusHost.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        addTaint(resumeMsg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040752626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040752626;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.079 -0400", hash_original_method = "B1C529B2D720558A64029A0709B532B0", hash_generated_method = "5EC9E0986DCAB66F1E34844CECF5992D")
    @Override
    public void setScrollBarStyle(int style) {
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = false;
        } 
        {
            mOverlayHorizontalScrollbar = mOverlayVerticalScrollbar = true;
        } 
        super.setScrollBarStyle(style);
        addTaint(style);
        
        
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.080 -0400", hash_original_method = "9DB949F09AC5FC0CFB5C5FAD8F7F9B82", hash_generated_method = "49957A37EDFF2774BB0F59A959CBDB39")
    public void setHorizontalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayHorizontalScrollbar = overlay;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.080 -0400", hash_original_method = "19F76FAFECC3C2E007D4C97071DFD1B7", hash_generated_method = "B9F69862443AC26CC9A977C090485865")
    public void setVerticalScrollbarOverlay(boolean overlay) {
        checkThread();
        mOverlayVerticalScrollbar = overlay;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.080 -0400", hash_original_method = "79022E291D0927B669A30B414A679C76", hash_generated_method = "53B9D9D0F5D67562C429D97CA073841C")
    public boolean overlayHorizontalScrollbar() {
        checkThread();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971042648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971042648;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.080 -0400", hash_original_method = "4DBC16C3345995B155158B938FDBD9A1", hash_generated_method = "6EE4EE7515834A54CC2192E22D5A17DB")
    public boolean overlayVerticalScrollbar() {
        checkThread();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312837662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312837662;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.081 -0400", hash_original_method = "3E12E9F04DFD10E2EA667E9B6D755EF7", hash_generated_method = "A82C3F893A1070F7A791AD8876CCAE53")
     int getViewWidth() {
        {
            boolean var292598F3B8B58F58543813175CA4B8DD_73674390 = (!isVerticalScrollBarEnabled() || mOverlayVerticalScrollbar);
            {
                int var6198C346AE8689F1D3DC081BB775DCCC_1836022784 = (getWidth());
            } 
            {
                int var140744BAF485A6F88159B58920081848_1733884548 = (Math.max(0, getWidth() - getVerticalScrollbarWidth()));
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389936040 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389936040;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.081 -0400", hash_original_method = "D4E0969C713C5E24E5BE169F82EFFB15", hash_generated_method = "EDBB68C74CF6992688AB7937F2B19244")
    protected int getTitleHeight() {
        {
            Object var89620761E813C776D9C3C42E19001F67_2096055863 = (mTitleBar.getHeight());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209849417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209849417;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.082 -0400", hash_original_method = "1C2BE72B33EB5D6AC861291319186F00", hash_generated_method = "FC7420B15EE0901CCE51533CA85FC5DA")
    public int getVisibleTitleHeight() {
        checkThread();
        int var723012357A221391980D0C0C10B6FF34_542610900 = (getVisibleTitleHeightImpl());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379025026 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379025026;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.082 -0400", hash_original_method = "6B1A00AEB1BAFA2920EE3EBA3107330E", hash_generated_method = "9084E39B8826D41DE39FB3FD14D09329")
    private int getVisibleTitleHeightImpl() {
        int var92FBB9603EF7E293DE9CA0F22B9E46D3_1391417987 = (Math.max(getTitleHeight() - Math.max(0, mScrollY),
                getOverlappingActionModeHeight()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546476648 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1546476648;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.083 -0400", hash_original_method = "9C29FD1C74CC561A99240A746B5E0BD5", hash_generated_method = "A61377651315FADA858194C49A50260B")
    private int getOverlappingActionModeHeight() {
        {
            getGlobalVisibleRect(mGlobalVisibleRect, mGlobalVisibleOffset);
            mCachedOverlappingActionModeHeight = Math.max(0,
                    mFindCallback.getActionModeGlobalBottom() - mGlobalVisibleRect.top);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014906155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014906155;
        
        
            
        
        
            
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.084 -0400", hash_original_method = "16F04C5EBC3B8E93A1D61DBBB33F796C", hash_generated_method = "45CB5973D493DBFD4CE52EFFEF55AEB7")
     int getViewHeight() {
        int varD548A0758944BD119F0830EAB903948B_1592137799 = (getViewHeightWithTitle() - getVisibleTitleHeightImpl());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149706125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149706125;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.085 -0400", hash_original_method = "F3F8EC43F8C9AD092589A17909A5F537", hash_generated_method = "34202BF6670434630995E6CC4AEE4A88")
     int getViewHeightWithTitle() {
        int height = getHeight();
        {
            boolean varEFFBBF75692B423920E06898DB33B47D_1854338338 = (isHorizontalScrollBarEnabled() && !mOverlayHorizontalScrollbar);
            {
                height -= getHorizontalScrollbarHeight();
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153285307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153285307;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.086 -0400", hash_original_method = "AD476A7428E3DA09ACFA510788381864", hash_generated_method = "DF81E1731511A58559125E6C89C63ADF")
    public SslCertificate getCertificate() {
        SslCertificate varB4EAC82CA7396A68D541C85D26508E83_1956789672 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1956789672 = mCertificate;
        varB4EAC82CA7396A68D541C85D26508E83_1956789672.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1956789672;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.086 -0400", hash_original_method = "9F5F4C3FB4149381051B5B6E8EFEC316", hash_generated_method = "7ABF7DE15A0CC376B74CCCEE0287D121")
    public void setCertificate(SslCertificate certificate) {
        checkThread();
        mCertificate = certificate;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.087 -0400", hash_original_method = "B1F295415F58B1AD64D910B9D074F1EA", hash_generated_method = "121BB62325326162CB4746406BA8C639")
    public void savePassword(String host, String username, String password) {
        checkThread();
        mDatabase.setUsernamePassword(host, username, password);
        addTaint(host.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.087 -0400", hash_original_method = "BDA26C26689AA9615ED03418D91ABD81", hash_generated_method = "3592FC1AE9692AE0D81C80A8D8C55954")
    public void setHttpAuthUsernamePassword(String host, String realm,
            String username, String password) {
        checkThread();
        mDatabase.setHttpAuthUsernamePassword(host, realm, username, password);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        addTaint(username.getTaint());
        addTaint(password.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.088 -0400", hash_original_method = "ECF11FA1B5D29EA7B85A642A97A37762", hash_generated_method = "DB897005E56F393D4786135656D7A931")
    public String[] getHttpAuthUsernamePassword(String host, String realm) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1070832929 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1070832929 = mDatabase.getHttpAuthUsernamePassword(host, realm);
        addTaint(host.getTaint());
        addTaint(realm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1070832929.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1070832929;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.088 -0400", hash_original_method = "1CE2D8D4EA92FC33AF3A97234BDE819A", hash_generated_method = "96EAAC7786E159D4BA71959CCD2826C5")
    private void clearActionModes() {
        {
            mSelectCallback.finish();
        } 
        {
            mFindCallback.finish();
        } 
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.088 -0400", hash_original_method = "86393BEB33857F548E995C7BECB35839", hash_generated_method = "448F915BE7E908A0F655BF91243B2A40")
    private void clearHelpers() {
        clearTextEntry();
        clearActionModes();
        dismissFullScreenMode();
        cancelSelectDialog();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.088 -0400", hash_original_method = "F6A790EDCFCA88D00C142E5D96511FC2", hash_generated_method = "6484E292F95762A26C284C86BD93A17F")
    private void cancelSelectDialog() {
        {
            mListBoxDialog.cancel();
            mListBoxDialog = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.089 -0400", hash_original_method = "887AD2FC267FFEAA463698CC892DD0CD", hash_generated_method = "38021AB430F2F37CB9A4606BEC6303C5")
    public void destroy() {
        checkThread();
        destroyImpl();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.089 -0400", hash_original_method = "164C30B5EFB8BB703D9BED2E17C86012", hash_generated_method = "819FA58952E102A0628FCE72C1E7CF64")
    private void destroyImpl() {
        clearHelpers();
        {
            mListBoxDialog.dismiss();
            mListBoxDialog = null;
        } 
        {
            mWebTextView.remove();
            mWebTextView = null;
        } 
        nativeStopGL();
        {
            mCallbackProxy.setWebViewClient(null);
            mCallbackProxy.setWebChromeClient(null);
            {
                WebViewCore webViewCore = mWebViewCore;
                mWebViewCore = null;
                webViewCore.destroy();
            } 
            mPrivateHandler.removeCallbacksAndMessages(null);
            mCallbackProxy.removeCallbacksAndMessages(null);
            {
                mCallbackProxy.notify();
            } 
        } 
        {
            nativeDestroy();
            mNativeClass = 0;
        } 
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.090 -0400", hash_original_method = "7BBC39F88A3BCFEE2D1CD0F83F959130", hash_generated_method = "B71D193F47F9D4DFA364F5F09F93088B")
    public void setJsFlags(String flags) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_JS_FLAGS, flags);
        addTaint(flags.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.090 -0400", hash_original_method = "D24B46DD870FF327FD5851F64F7AA698", hash_generated_method = "B1147815A844E554696EC64B02A849F1")
    public void setNetworkAvailable(boolean networkUp) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_STATE,
                networkUp ? 1 : 0, 0);
        addTaint(networkUp);
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.090 -0400", hash_original_method = "92950478ADA3088DEDA2C784FD56433D", hash_generated_method = "0FEF53A1C48DA59CFC5323CF9FB3C1B0")
    public void setNetworkType(String type, String subtype) {
        checkThread();
        Map<String, String> map = new HashMap<String, String>();
        map.put("type", type);
        map.put("subtype", subtype);
        mWebViewCore.sendMessage(EventHub.SET_NETWORK_TYPE, map);
        addTaint(type.getTaint());
        addTaint(subtype.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.092 -0400", hash_original_method = "D76FC1BD4962410EDA97F2F673ACB95E", hash_generated_method = "5C428DD8B68C2D9F6408891BE245DEDB")
    public WebBackForwardList saveState(Bundle outState) {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1802615569 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_610594547 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1342061175 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1932904239 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_835243209 = null; 
        checkThread();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1802615569 = null;
        } 
        WebBackForwardList list = copyBackForwardList();
        final int currentIndex = list.getCurrentIndex();
        final int size = list.getSize();
        {
            varB4EAC82CA7396A68D541C85D26508E83_610594547 = null;
        } 
        outState.putInt("index", currentIndex);
        ArrayList<byte[]> history = new ArrayList<byte[]>(size);
        {
            int i = 0;
            {
                WebHistoryItem item = list.getItemAtIndex(i);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1342061175 = null;
                } 
                byte[] data = item.getFlattenedData();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1932904239 = null;
                } 
                history.add(data);
            } 
        } 
        outState.putSerializable("history", history);
        {
            outState.putBundle("certificate",
                               SslCertificate.saveState(mCertificate));
        } 
        outState.putBoolean("privateBrowsingEnabled", isPrivateBrowsingEnabled());
        mZoomManager.saveZoomState(outState);
        varB4EAC82CA7396A68D541C85D26508E83_835243209 = list;
        addTaint(outState.getTaint());
        WebBackForwardList varA7E53CE21691AB073D9660D615818899_1488203315; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1488203315 = varB4EAC82CA7396A68D541C85D26508E83_1802615569;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1488203315 = varB4EAC82CA7396A68D541C85D26508E83_610594547;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1488203315 = varB4EAC82CA7396A68D541C85D26508E83_1342061175;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1488203315 = varB4EAC82CA7396A68D541C85D26508E83_1932904239;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1488203315 = varB4EAC82CA7396A68D541C85D26508E83_835243209;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1488203315.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1488203315;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.094 -0400", hash_original_method = "CE24DEA1F6D46B468FBCF361CE56E08B", hash_generated_method = "CCED26911563F85A361D7B5087A198A8")
    @Deprecated
    public boolean savePicture(Bundle b, final File dest) {
        checkThread();
        final Picture p = capturePicture();
        final File temp = new File(dest.getPath() + ".writing");
        new Thread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.094 -0400", hash_original_method = "71F2765D1125FA36D6758E11ABE47081", hash_generated_method = "65D0623D60BE79FECBACD867119EA9B1")
            public void run() {
                FileOutputStream out = null;
                try 
                {
                    out = new FileOutputStream(temp);
                    p.writeToStream(out);
                    temp.renameTo(dest);
                } 
                catch (Exception e)
                { }
                finally 
                {
                    {
                        try 
                        {
                            out.close();
                        } 
                        catch (Exception e)
                        { }
                    } 
                    temp.delete();
                } 
                
                
                
                    
                    
                    
                
                
                    
                        
                            
                        
                        
                    
                    
                
            }
}).start();
        b.putInt("scrollX", mScrollX);
        b.putInt("scrollY", mScrollY);
        mZoomManager.saveZoomState(b);
        addTaint(b.getTaint());
        addTaint(dest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291756772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291756772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.095 -0400", hash_original_method = "9C44211FBECA32C3186269A913CFD39B", hash_generated_method = "0DCDED80D7FAA4D4E07901B30264F5BF")
    private void restoreHistoryPictureFields(Picture p, Bundle b) {
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
        addTaint(b.getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.097 -0400", hash_original_method = "7C45A69236EC18D01E70EB4417CC5ECC", hash_generated_method = "EE616867E1095D41D8835501B73D82ED")
    @Deprecated
    public boolean restorePicture(Bundle b, File src) {
        checkThread();
        {
            boolean varE83409CFB365F3AF171C437BEF6A7D4D_592739943 = (!src.exists());
        } 
        try 
        {
            final FileInputStream in = new FileInputStream(src);
            final Bundle copy = new Bundle(b);
            new Thread(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.096 -0400", hash_original_method = "724A0503E9DDAB096FD7727D625B3A77", hash_generated_method = "E2ADDD01AFAF57C5136E9DD9DAD559C7")
                public void run() {
                    try 
                    {
                        final Picture p = Picture.createFromStream(in);
                        {
                            mPrivateHandler.post(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.096 -0400", hash_original_method = "C56555B2959C7B009BAA3230DF6B18BD", hash_generated_method = "99D4A60111AD5243B646F29DC3E7007E")
                                public void run() {
                                    restoreHistoryPictureFields(p, copy);
                                    
                                    
                                }
});
                        } 
                    } 
                    finally 
                    {
                        try 
                        {
                            in.close();
                        } 
                        catch (Exception e)
                        { }
                    } 
                    
                    
                        
                        
                            
                                
                                    
                                
                            
                        
                    
                        
                            
                        
                        
                    
                }
}).start();
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } 
        addTaint(b.getTaint());
        addTaint(src.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579562475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579562475;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.097 -0400", hash_original_method = "03FECD617F3DC4E21DFB1850BBD7D3BE", hash_generated_method = "22C98EB503C52F4537292272B4341FCB")
    public boolean saveViewState(OutputStream stream) {
        try 
        {
            boolean varD8E0513B299C4708A843791F787A4612_2032945045 = (ViewStateSerializer.serializeViewState(stream, this));
        } 
        catch (IOException e)
        { }
        addTaint(stream.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367854405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367854405;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.097 -0400", hash_original_method = "28412F1BEA5DA0380D77A85C33B32795", hash_generated_method = "552F14D5F420E1C4F6F790381A02BBC1")
    public boolean loadViewState(InputStream stream) {
        try 
        {
            mLoadedPicture = ViewStateSerializer.deserializeViewState(stream, this);
            mBlockWebkitViewMessages = true;
            setNewPicture(mLoadedPicture, true);
            mLoadedPicture.mViewState = null;
        } 
        catch (IOException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358719005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358719005;
        
        
            
            
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.098 -0400", hash_original_method = "695078F0281F742F92C54217699378FF", hash_generated_method = "732621B4DF183E8125FE78ECB6DCCC1E")
    public void clearViewState() {
        mBlockWebkitViewMessages = false;
        mLoadedPicture = null;
        invalidate();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.099 -0400", hash_original_method = "99FE452D222A3AA897B1F81F94FFC5BD", hash_generated_method = "914A97025EA9EDA7D5D78DA87F760077")
    public WebBackForwardList restoreState(Bundle inState) {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_415104060 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_664132717 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_246577357 = null; 
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_1057527952 = null; 
        checkThread();
        WebBackForwardList returnList = null;
        {
            varB4EAC82CA7396A68D541C85D26508E83_415104060 = returnList;
        } 
        {
            boolean var2DC9EFB7F916A118778C320ECAEAF366_849514138 = (inState.containsKey("index") && inState.containsKey("history"));
            {
                mCertificate = SslCertificate.restoreState(
                inState.getBundle("certificate"));
                final WebBackForwardList list = mCallbackProxy.getBackForwardList();
                final int index = inState.getInt("index");
                {
                    final List<byte[]> history = (List<byte[]>) inState.getSerializable("history");
                    final int size = history.size();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_664132717 = null;
                    } 
                    {
                        int i = 0;
                        {
                            byte[] data = history.remove(0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_246577357 = null;
                            } 
                            WebHistoryItem item = new WebHistoryItem(data);
                            list.addHistoryItem(item);
                        } 
                    } 
                    returnList = copyBackForwardList();
                    returnList.setCurrentIndex(index);
                } 
                {
                    boolean varA762F755263E0165E9C21EFA8E349BE2_1423966137 = (inState.getBoolean("privateBrowsingEnabled"));
                    {
                        getSettings().setPrivateBrowsingEnabled(true);
                    } 
                } 
                mZoomManager.restoreZoomState(inState);
                mWebViewCore.removeMessages();
                mWebViewCore.sendMessage(EventHub.RESTORE_STATE, index);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1057527952 = returnList;
        WebBackForwardList varA7E53CE21691AB073D9660D615818899_1647924466; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1647924466 = varB4EAC82CA7396A68D541C85D26508E83_415104060;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1647924466 = varB4EAC82CA7396A68D541C85D26508E83_664132717;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1647924466 = varB4EAC82CA7396A68D541C85D26508E83_246577357;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1647924466 = varB4EAC82CA7396A68D541C85D26508E83_1057527952;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1647924466.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1647924466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.099 -0400", hash_original_method = "66CEDD7560D58AC5C6DF5108A28592A9", hash_generated_method = "E2F8EA7B289D935D185CCD3A0D96C130")
    public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
        checkThread();
        loadUrlImpl(url, additionalHttpHeaders);
        addTaint(url.getTaint());
        addTaint(additionalHttpHeaders.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.099 -0400", hash_original_method = "1BCC17243147768FF726FCE9A98025DC", hash_generated_method = "25F0E9C8651522573AF5756C6CB0E4AC")
    private void loadUrlImpl(String url, Map<String, String> extraHeaders) {
        switchOutDrawHistory();
        WebViewCore.GetUrlData arg = new WebViewCore.GetUrlData();
        arg.mUrl = url;
        arg.mExtraHeaders = extraHeaders;
        mWebViewCore.sendMessage(EventHub.LOAD_URL, arg);
        clearHelpers();
        addTaint(url.getTaint());
        addTaint(extraHeaders.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.100 -0400", hash_original_method = "900343F64392479D278DAE2853AD0CAD", hash_generated_method = "55B96F0FDDFA5E946455029D5EADA0CB")
    public void loadUrl(String url) {
        checkThread();
        loadUrlImpl(url);
        addTaint(url.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.100 -0400", hash_original_method = "9F389BEC5E499016577EC1A6216F8CDA", hash_generated_method = "7CA7E52126ED4448E3184304DDCA2AE1")
    private void loadUrlImpl(String url) {
        loadUrlImpl(url, null);
        addTaint(url.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.100 -0400", hash_original_method = "4D8085D3E47A5523B39E9E45FB3B56EB", hash_generated_method = "9917D0EBF0A6157637E3C992B1E9E109")
    public void postUrl(String url, byte[] postData) {
        checkThread();
        {
            boolean var4F95E4BDE23CE2774CDB1234D95999CA_901164635 = (URLUtil.isNetworkUrl(url));
            {
                switchOutDrawHistory();
                WebViewCore.PostUrlData arg = new WebViewCore.PostUrlData();
                arg.mUrl = url;
                arg.mPostData = postData;
                mWebViewCore.sendMessage(EventHub.POST_URL, arg);
                clearHelpers();
            } 
            {
                loadUrlImpl(url);
            } 
        } 
        addTaint(url.getTaint());
        addTaint(postData[0]);
        
        
        
            
            
            
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.101 -0400", hash_original_method = "36CBAFDF58E1CD9C6313A9EA95B15170", hash_generated_method = "57093C4DAC7FB94A2276E35291C35BE3")
    public void loadData(String data, String mimeType, String encoding) {
        checkThread();
        loadDataImpl(data, mimeType, encoding);
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.101 -0400", hash_original_method = "EA9B15D987357D071ADD9ABEB7CE7EDF", hash_generated_method = "B29F08BE2A4E31C2D97A81482DEDC8DE")
    private void loadDataImpl(String data, String mimeType, String encoding) {
        StringBuilder dataUrl = new StringBuilder("data:");
        dataUrl.append(mimeType);
        {
            boolean var42C80751A5B21E94C93713173917F7B9_839593299 = ("base64".equals(encoding));
            {
                dataUrl.append(";base64");
            } 
        } 
        dataUrl.append(",");
        dataUrl.append(data);
        loadUrlImpl(dataUrl.toString());
        addTaint(data.getTaint());
        addTaint(mimeType.getTaint());
        addTaint(encoding.getTaint());
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.102 -0400", hash_original_method = "1E8C089561768F21EB025C4FB395A147", hash_generated_method = "AEDF72B748D6193D283BBAFD2B74E735")
    public void loadDataWithBaseURL(String baseUrl, String data,
            String mimeType, String encoding, String historyUrl) {
        checkThread();
        {
            boolean var66719BDAFAA36B530D74BC3839E26AEE_1701345746 = (baseUrl != null && baseUrl.toLowerCase().startsWith("data:"));
            {
                loadDataImpl(data, mimeType, encoding);
            } 
        } 
        switchOutDrawHistory();
        WebViewCore.BaseUrlData arg = new WebViewCore.BaseUrlData();
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
        
        
        
            
            
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.102 -0400", hash_original_method = "701452CD8FBCF1E85233BEC49B4E7329", hash_generated_method = "84864D77370F74BC26B21B7246B02AFF")
    public void saveWebArchive(String filename) {
        checkThread();
        saveWebArchiveImpl(filename, false, null);
        addTaint(filename.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.103 -0400", hash_original_method = "7D135A62D01ADC63E34527E77FB3A29E", hash_generated_method = "28DC10B689ED103B34E9A1B4EBFC11E7")
    public void saveWebArchive(String basename, boolean autoname, ValueCallback<String> callback) {
        checkThread();
        saveWebArchiveImpl(basename, autoname, callback);
        addTaint(basename.getTaint());
        addTaint(autoname);
        addTaint(callback.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.103 -0400", hash_original_method = "701D82D0DEE4646F76C490ED450C3E9F", hash_generated_method = "F2EF15EAE862FCC49D90ACF820842AF1")
    private void saveWebArchiveImpl(String basename, boolean autoname,
            ValueCallback<String> callback) {
        mWebViewCore.sendMessage(EventHub.SAVE_WEBARCHIVE,
            new SaveWebArchiveMessage(basename, autoname, callback));
        addTaint(basename.getTaint());
        addTaint(autoname);
        addTaint(callback.getTaint());
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.104 -0400", hash_original_method = "9E6E104E06C1A86CDD5F58189E9D6C54", hash_generated_method = "2C395E4AC53467FAD68E24848E941787")
    public void stopLoading() {
        checkThread();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.STOP_LOADING);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.105 -0400", hash_original_method = "012D905CFE3C40A166231928A7F6FD85", hash_generated_method = "8F4D6179589A516B470113791CFEE8A4")
    public void reload() {
        checkThread();
        clearHelpers();
        switchOutDrawHistory();
        mWebViewCore.sendMessage(EventHub.RELOAD);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.105 -0400", hash_original_method = "88FE306DA6AFC5714A3F873305A6EA3E", hash_generated_method = "FF8B131E8BBC124FCD32BAAF4BE0CA21")
    public boolean canGoBack() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_766176834 = (l.getClearPending());
                {
                    boolean var206A5F4DC30C9911DE984FA8A632E8D0_1524346937 = (l.getCurrentIndex() > 0);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961652836 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961652836;
        
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.105 -0400", hash_original_method = "2B11D82AA68F54138F546C5942C42E38", hash_generated_method = "63D2353E5F881AC0C773B9FBCC91A18D")
    public void goBack() {
        checkThread();
        goBackOrForwardImpl(-1);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.106 -0400", hash_original_method = "A6DBD0DBF14922EF2AF63B2C61F82174", hash_generated_method = "34BD1C8B04401C29A9DC55500ADD089C")
    public boolean canGoForward() {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_1542721647 = (l.getClearPending());
                {
                    boolean varCC6932F1C4388293E5C6020CC2BE99D1_1144201917 = (l.getCurrentIndex() < l.getSize() - 1);
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608939199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608939199;
        
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.106 -0400", hash_original_method = "A9A03BA6D011D5E19312AAC07DA5C107", hash_generated_method = "7DBF91244690F3215087518F21FF9C8A")
    public void goForward() {
        checkThread();
        goBackOrForwardImpl(1);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.106 -0400", hash_original_method = "0C5B3517F02B44F88C085BB892A31735", hash_generated_method = "01B5F4C181AADC45E0895E1CFD205A33")
    public boolean canGoBackOrForward(int steps) {
        checkThread();
        WebBackForwardList l = mCallbackProxy.getBackForwardList();
        {
            {
                boolean varC92AFB479800BB86205BB740F728BF6F_1986507258 = (l.getClearPending());
                {
                    int newIndex = l.getCurrentIndex() + steps;
                    boolean varC96153442818D1ECADD5777B6D61A76F_810711597 = (newIndex >= 0 && newIndex < l.getSize());
                } 
            } 
        } 
        addTaint(steps);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662952874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662952874;
        
        
        
        
            
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.107 -0400", hash_original_method = "6FDA5530D13A94A2D5C86F111CD2B374", hash_generated_method = "ABFA7D864F6303240B59D0F63705A218")
    public void goBackOrForward(int steps) {
        checkThread();
        goBackOrForwardImpl(steps);
        addTaint(steps);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.107 -0400", hash_original_method = "5ADA028E11EBC9149BDC8BA6E207C9FC", hash_generated_method = "EE65BD760FCE049A904C0471FA3FC639")
    private void goBackOrForwardImpl(int steps) {
        goBackOrForward(steps, false);
        addTaint(steps);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.107 -0400", hash_original_method = "EEAA9975E0AEEDF00E46876B0481B6FE", hash_generated_method = "1DC4E0D76CB6E1A79A3D0ACBE1BD9353")
    private void goBackOrForward(int steps, boolean ignoreSnapshot) {
        {
            clearHelpers();
            mWebViewCore.sendMessage(EventHub.GO_BACK_FORWARD, steps,
                    ignoreSnapshot ? 1 : 0);
        } 
        addTaint(steps);
        addTaint(ignoreSnapshot);
        
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.107 -0400", hash_original_method = "8CF019D7F7FFF081EEAFEFCB78ED95C5", hash_generated_method = "07F0EE5687DFBB59CEF3BB156D82B5EC")
    public boolean isPrivateBrowsingEnabled() {
        checkThread();
        boolean varB1BAC2416E34E6087A203AED7444A817_1699375123 = (getSettings().isPrivateBrowsingEnabled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703192204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703192204;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.108 -0400", hash_original_method = "8FFE0E78B013518E5DDE540FAA1F9039", hash_generated_method = "07E57C68BA1FFA2F79AE67648A8B3103")
    private void startPrivateBrowsing() {
        getSettings().setPrivateBrowsingEnabled(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.108 -0400", hash_original_method = "8924521FA24CD8FD195D656EDEA65F65", hash_generated_method = "90EE3B0D86DB2B4464594FDA0ED19086")
    private boolean extendScroll(int y) {
        int finalY = mScroller.getFinalY();
        int newY = pinLocY(finalY + y);
        mScroller.setFinalY(newY);
        mScroller.extendDuration(computeDuration(0, y));
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844488375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844488375;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.109 -0400", hash_original_method = "B84DD5AFD0438FF77AF5113B3021ECBE", hash_generated_method = "46C3DC191E7B4DA68459D38411C17548")
    public boolean pageUp(boolean top) {
        checkThread();
        nativeClearCursor();
        {
            boolean varEC29A5852D76967DDCD92AF6EF13DA1B_1654742980 = (pinScrollTo(mScrollX, 0, true, 0));
        } 
        int h = getHeight();
        int y;
        {
            y = -h + PAGE_SCROLL_OVERLAP;
        } 
        {
            y = -h / 2;
        } 
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_391500474 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_1288598411 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_469474039 = (extendScroll(y));
        } 
        addTaint(top);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676441592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676441592;
        
        
        
            
        
        
        
            
        
        
        
        
            
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.109 -0400", hash_original_method = "8C3AB4FBBE1760CE6D8647585D27DDAF", hash_generated_method = "A07443CA6A4DD1D026E96FB0157B18DD")
    public boolean pageDown(boolean bottom) {
        checkThread();
        nativeClearCursor();
        {
            boolean var20824CBC7D9295AF4224D9CEA1714AF5_1069069270 = (pinScrollTo(mScrollX, computeRealVerticalScrollRange(), true, 0));
        } 
        int h = getHeight();
        int y;
        {
            y = h - PAGE_SCROLL_OVERLAP;
        } 
        {
            y = h / 2;
        } 
        {
            boolean var7B9D43EC2E9A844D127FEEDB2354EC90_351954678 = (mScroller.isFinished());
            Object var94F8675E9768F954AF02C70C976682F4_29183228 = (pinScrollBy(0, y, true, 0));
            Object var449359DF1FA0CB82149A78CBDB32B0F8_654960793 = (extendScroll(y));
        } 
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664907932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664907932;
        
        
        
            
        
        
        
            
        
        
        
        
            
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.110 -0400", hash_original_method = "D943026BA3CFBD26E3744ACB50DE12A9", hash_generated_method = "96502640F44EE6B02C635F6CE1A50F1B")
    public void clearView() {
        checkThread();
        mContentWidth = 0;
        mContentHeight = 0;
        setBaseLayer(0, null, false, false, false);
        mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.110 -0400", hash_original_method = "7931D11F61B3E2C3E211E17879AF060C", hash_generated_method = "B49B9F16C48626D87CFEA8F85FDADC67")
    public Picture capturePicture() {
        Picture varB4EAC82CA7396A68D541C85D26508E83_1587787964 = null; 
        Picture varB4EAC82CA7396A68D541C85D26508E83_914965525 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1587787964 = null;
        Picture result = new Picture();
        nativeCopyBaseContentToPicture(result);
        varB4EAC82CA7396A68D541C85D26508E83_914965525 = result;
        Picture varA7E53CE21691AB073D9660D615818899_1441926836; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1441926836 = varB4EAC82CA7396A68D541C85D26508E83_1587787964;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1441926836 = varB4EAC82CA7396A68D541C85D26508E83_914965525;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1441926836.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1441926836;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.111 -0400", hash_original_method = "A191A9FDF945A553C0983AC50396EE1C", hash_generated_method = "7404FC5953F394196788D1DC1F37E1C8")
    private boolean inEditingMode() {
        boolean var5AD34046046BD5597D48FAE1E55DF94F_11117932 = (mWebTextView != null && mWebTextView.getParent() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1268147157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1268147157;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.111 -0400", hash_original_method = "EDC14EE498FB917CBE42CED3155A7560", hash_generated_method = "128C2865ABF53EA8C2A12B7083EBE09F")
    private void clearTextEntry() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_729709714 = (inEditingMode());
            {
                mWebTextView.remove();
            } 
            {
                hideSoftKeyboard();
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.111 -0400", hash_original_method = "7CCA6028A56577FC53B8EAA02010B4CB", hash_generated_method = "064C68B5AC69F18F0859002C5F1C6DE6")
    public float getScale() {
        checkThread();
        float var7BDB5950E779A8350C7AFF5485D9A1D9_130445621 = (mZoomManager.getScale());
        float var546ADE640B6EDFBC8A086EF31347E768_1079012077 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1079012077;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.111 -0400", hash_original_method = "8FE7DEBB03549EA34C695CA1BEB039D3", hash_generated_method = "23D1D4A332EE9E8B653D320E4FE63046")
     float getTextHandleScale() {
        float density = mContext.getResources().getDisplayMetrics().density;
        float varE59D2240C31D06227A739295405DD61F_131533538 = (density / getScale());
        float var546ADE640B6EDFBC8A086EF31347E768_2004046578 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2004046578;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.112 -0400", hash_original_method = "53ABC037DDC33F33CA1EED7753E7BC53", hash_generated_method = "975851B0D2A3D6CB64646664FB952003")
     float getReadingLevelScale() {
        float var44DB53B9B3C50B031CB12B3205E80427_313493828 = (mZoomManager.getReadingLevelScale());
        float var546ADE640B6EDFBC8A086EF31347E768_1598863605 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1598863605;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.112 -0400", hash_original_method = "71F885EF6D599D2C56A5D45C189C25F2", hash_generated_method = "A669DD2428D6D398CDA8A0507B53AE6C")
    public void setInitialScale(int scaleInPercent) {
        checkThread();
        mZoomManager.setInitialScaleInPercent(scaleInPercent);
        addTaint(scaleInPercent);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.112 -0400", hash_original_method = "D8A55AE21DB4411650D445BD9AD624A1", hash_generated_method = "071799D94FBC724A292901A2633BADE7")
    public void invokeZoomPicker() {
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_1345917960 = (!getSettings().supportZoom());
        } 
        clearHelpers();
        mZoomManager.invokeZoomPicker();
        
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.113 -0400", hash_original_method = "F0061B4E013540D6EEECC96F5AFE231A", hash_generated_method = "A3D8DA90C234BC7CA56A34C798241854")
    public HitTestResult getHitTestResult() {
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_213762242 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_213762242 = hitTestResult(mInitialHitTestResult);
        varB4EAC82CA7396A68D541C85D26508E83_213762242.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_213762242;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.115 -0400", hash_original_method = "E04AFCDB529274E922EB45C8B3D3ACC8", hash_generated_method = "12F5FD313F52AD8DFD63B8C1B9712AFD")
    private HitTestResult hitTestResult(HitTestResult fallback) {
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_1156544621 = null; 
        HitTestResult varB4EAC82CA7396A68D541C85D26508E83_750362292 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1156544621 = null;
        } 
        HitTestResult result = new HitTestResult();
        {
            boolean var5225ACD2E56334E54962D68427F36819_490010464 = (nativeHasCursorNode());
            {
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_89325032 = (nativeCursorIsTextInput());
                    {
                        result.setType(HitTestResult.EDIT_TEXT_TYPE);
                    } 
                    {
                        String text = nativeCursorText();
                        {
                            {
                                boolean varC002F8AFED7F549F33D23662D5EE005B_345564408 = (text.startsWith(SCHEME_TEL));
                                {
                                    result.setType(HitTestResult.PHONE_TYPE);
                                    result.setExtra(text.substring(SCHEME_TEL.length()));
                                } 
                                {
                                    boolean var8892C872AF1A0DE7CA908AB563D8630A_54630909 = (text.startsWith(SCHEME_MAILTO));
                                    {
                                        result.setType(HitTestResult.EMAIL_TYPE);
                                        result.setExtra(text.substring(SCHEME_MAILTO.length()));
                                    } 
                                    {
                                        boolean varC83048191C80A2E63B6D052EA1A2AF29_1193106355 = (text.startsWith(SCHEME_GEO));
                                        {
                                            result.setType(HitTestResult.GEO_TYPE);
                                            result.setExtra(URLDecoder.decode(text
                                .substring(SCHEME_GEO.length())));
                                        } 
                                        {
                                            boolean var559FEC73A68A4A49F5AE8D79C0655989_154453844 = (nativeCursorIsAnchor());
                                            {
                                                result.setType(HitTestResult.SRC_ANCHOR_TYPE);
                                                result.setExtra(text);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                result = fallback;
            } 
        } 
        int type = result.getType();
        {
            int contentX = viewToContentX(mLastTouchX + mScrollX);
            int contentY = viewToContentY(mLastTouchY + mScrollY);
            String text = nativeImageURI(contentX, contentY);
            {
                result.setType(type == HitTestResult.UNKNOWN_TYPE ?
                        HitTestResult.IMAGE_TYPE :
                        HitTestResult.SRC_IMAGE_ANCHOR_TYPE);
                result.setExtra(text);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_750362292 = result;
        addTaint(fallback.getTaint());
        HitTestResult varA7E53CE21691AB073D9660D615818899_972640311; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_972640311 = varB4EAC82CA7396A68D541C85D26508E83_1156544621;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_972640311 = varB4EAC82CA7396A68D541C85D26508E83_750362292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_972640311.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_972640311;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.115 -0400", hash_original_method = "5BB69CB5DC238C6825AFABD5537E0280", hash_generated_method = "BA8D0933CB5B3668BB1F4FFF825D2EB6")
    private void domChangedFocus() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1955989557 = (inEditingMode());
            {
                mPrivateHandler.obtainMessage(DOM_FOCUS_CHANGED).sendToTarget();
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.116 -0400", hash_original_method = "6AC64EA8F8F94D2C883BC504CD4F8D37", hash_generated_method = "7E451BF1DDF886B453EA495B38A46108")
    public void requestFocusNodeHref(Message hrefMsg) {
        checkThread();
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        {
            boolean var5225ACD2E56334E54962D68427F36819_802623732 = (nativeHasCursorNode());
            {
                Rect cursorBounds = nativeGetCursorRingBounds();
                {
                    boolean var445EE3E02909E3AEE38EC98CDB8981EE_1158464172 = (!cursorBounds.contains(contentX, contentY));
                    {
                        int slop = viewToContentDimension(mNavSlop);
                        cursorBounds.inset(-slop, -slop);
                        {
                            boolean varADAA650ED0CC8F602CC684B55A8BD54B_1297607821 = (cursorBounds.contains(contentX, contentY));
                            {
                                contentX = (int) cursorBounds.centerX();
                                contentY = (int) cursorBounds.centerY();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        mWebViewCore.sendMessage(EventHub.REQUEST_CURSOR_HREF,
                contentX, contentY, hrefMsg);
        addTaint(hrefMsg.getTaint());
        
        
        
            
        
        
        
        
            
            
                
                
                
                    
                    
                
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.116 -0400", hash_original_method = "5A2BB4254B6DBB18790F8920A9D183E3", hash_generated_method = "5D646DFC57A20A6BF90C5E83D1D8B3D2")
    public void requestImageRef(Message msg) {
        checkThread();
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        String ref = nativeImageURI(contentX, contentY);
        Bundle data = msg.getData();
        data.putString("url", ref);
        msg.setData(data);
        msg.sendToTarget();
        addTaint(msg.getTaint());
        
        
        
        
        
        
        
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.117 -0400", hash_original_method = "2E6BB99E9F0ADE9CFE2EB3651509758F", hash_generated_method = "1E56987F6F04CD10896FFB95B426A446")
     int pinLocX(int x) {
        int var07118715F745D512C238AD2FEDFE6515_430330598 = (pinLoc(x, getViewWidth(), computeRealHorizontalScrollRange()));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272978085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_272978085;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.117 -0400", hash_original_method = "A92B9630A61300140C3AE67C3AC12BE5", hash_generated_method = "850D4411877553FDE0AFFDCC8C927EFB")
     int pinLocY(int y) {
        int var2B535EA2474A113BEF6C4806B3E88FC9_1705881592 = (pinLoc(y, getViewHeightWithTitle(),
                      computeRealVerticalScrollRange() + getTitleHeight()));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091808604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091808604;
        
        
        
                      
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.118 -0400", hash_original_method = "F2B49B794E838778EA56C092F32F7D11", hash_generated_method = "ACD1483F1BBDEE0E7592DDAEFDFCCB2F")
    public void setEmbeddedTitleBar(View v) {
        {
            removeView(mTitleBar);
        } 
        {
            addView(v, new AbsoluteLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0));
        } 
        mTitleBar = v;
        
        
        
            
        
        
            
                    
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.118 -0400", hash_original_method = "880F2B180816DB74BD332356E5E88DD6", hash_generated_method = "105D592E955DBF7BD60D7B2C46CA6B79")
    public void setTitleBarGravity(int gravity) {
        mTitleGravity = gravity;
        invalidate();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.118 -0400", hash_original_method = "7D8A90845F2BDB760A65D1033D0ADDEF", hash_generated_method = "9D57D57B6EA47BFDEA890E5654959F17")
    private int viewToContentDimension(int d) {
        int var6C6E42DD517C7D3B9A717F110B422373_1679697661 = (Math.round(d * mZoomManager.getInvScale()));
        addTaint(d);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712040327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712040327;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.119 -0400", hash_original_method = "35AD2AB5BD1F513BBF06CEB9122EB14F", hash_generated_method = "736DAC4225C382FA3C3E32295CEAB9D6")
     int viewToContentX(int x) {
        int var8DEE0558B14D500E1B85CE5222A73912_303955388 = (viewToContentDimension(x));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481159395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_481159395;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.119 -0400", hash_original_method = "B6A85EDC570728FDA84445069164B6A2", hash_generated_method = "E2B8065D2BD08B61510DB9CD5B3C6E33")
     int viewToContentY(int y) {
        int var7B97DA5C6E7937A4956BCED3C768F5E3_893100281 = (viewToContentDimension(y - getTitleHeight()));
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031423173 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031423173;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.119 -0400", hash_original_method = "ADD6B0F172718733B8A8534B7635217A", hash_generated_method = "3A117FC4CAE14638893518E2FFBD4EE7")
    private float viewToContentXf(int x) {
        float var8A8AB39BD9FBE3D7753B44FE92DB7211_580915497 = (x * mZoomManager.getInvScale());
        addTaint(x);
        float var546ADE640B6EDFBC8A086EF31347E768_535865883 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_535865883;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.119 -0400", hash_original_method = "B93D95D5A6EEF01D1FE0CB334EF27611", hash_generated_method = "52F203ADA3966E3AD64715A07CD22637")
    private float viewToContentYf(int y) {
        float var831D90CB537843A85A184EBC2C0DA386_1114923142 = ((y - getTitleHeight()) * mZoomManager.getInvScale());
        addTaint(y);
        float var546ADE640B6EDFBC8A086EF31347E768_730735598 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_730735598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.120 -0400", hash_original_method = "74D1F48A89696DCA5EDA08E03AD6C35A", hash_generated_method = "50B29ACC60B0EE3AC25190C779128D64")
     int contentToViewDimension(int d) {
        int var330434C37CE0501EDFCFE74FEF711C69_730679005 = (Math.round(d * mZoomManager.getScale()));
        addTaint(d);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595230660 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_595230660;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.120 -0400", hash_original_method = "3F90909ED8FDB4D6012C971C04745DE8", hash_generated_method = "900D6428DBB91CABCD00F6ACE6DE6C3D")
     int contentToViewX(int x) {
        int var5F9CD9178F56CA92BE57B17CD7626740_1504043256 = (contentToViewDimension(x));
        addTaint(x);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527888076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527888076;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.120 -0400", hash_original_method = "2F9E81A812F0B78A638AA2019B02FF67", hash_generated_method = "1F4DBF788F85A55F2A78BDD1E800FD3F")
     int contentToViewY(int y) {
        int varFF4BC4A064C1180EFE780BDD5AD7DDE0_1187651247 = (contentToViewDimension(y) + getTitleHeight());
        addTaint(y);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569291515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569291515;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.121 -0400", hash_original_method = "419A85B9EA8E1CC7B182C84B68EBA53A", hash_generated_method = "9617064E711F1FDBA171CEAA7F686D29")
    private Rect contentToViewRect(Rect x) {
        Rect varB4EAC82CA7396A68D541C85D26508E83_249467971 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_249467971 = new Rect(contentToViewX(x.left), contentToViewY(x.top),
                        contentToViewX(x.right), contentToViewY(x.bottom));
        addTaint(x.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_249467971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_249467971;
        
        
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.121 -0400", hash_original_method = "0C5DEEA6F08865561187177C6226401E", hash_generated_method = "029AA09D38DD4E59AF480D240707FDEE")
    private void viewInvalidate(int l, int t, int r, int b) {
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
        invalidate((int)Math.floor(l * scale),
                   (int)Math.floor(t * scale) + dy,
                   (int)Math.ceil(r * scale),
                   (int)Math.ceil(b * scale) + dy);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
        
                   
                   
                   
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.121 -0400", hash_original_method = "68BCA4878A0964E9837E2F11D8AE8FC1", hash_generated_method = "B0AE9B3D6448A3C3EAC8FB45E67CB87C")
    private void viewInvalidateDelayed(long delay, int l, int t, int r, int b) {
        final float scale = mZoomManager.getScale();
        final int dy = getTitleHeight();
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
        
        
        
        
                              
                              
                              
                              
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.122 -0400", hash_original_method = "2E01C3991660191202512A949AB63B43", hash_generated_method = "B54B454F3534075365CB5855DEB81B75")
    private void invalidateContentRect(Rect r) {
        viewInvalidate(r.left, r.top, r.right, r.bottom);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.122 -0400", hash_original_method = "32315872E42732386C20D9FBACAAE397", hash_generated_method = "5847048DB193138D46100A4DCE1A2FEE")
    private void abortAnimation() {
        mScroller.abortAnimation();
        mLastVelocity = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.122 -0400", hash_original_method = "3B00F034A86BA33B005463DB04D13851", hash_generated_method = "8D7711452744B039D8A859694523E34F")
    private void recordNewContentSize(int w, int h, boolean updateLayout) {
        {
            mContentWidth = w;
            mContentHeight = h;
            {
                updateScrollCoordinates(pinLocX(mScrollX), pinLocY(mScrollY));
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_293581069 = (!mScroller.isFinished());
                    {
                        mScroller.setFinalX(pinLocX(mScroller.getFinalX()));
                        mScroller.setFinalY(pinLocY(mScroller.getFinalY()));
                    } 
                } 
            } 
        } 
        contentSizeChanged(updateLayout);
        addTaint(updateLayout);
        
        
            
        
        
            
            
            
                
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.124 -0400", hash_original_method = "C2A5E734893A55C378E9D7B3FADB3F17", hash_generated_method = "472856BFC108E057962CD8DC4F0F9B72")
     Rect sendOurVisibleRect() {
        Rect varB4EAC82CA7396A68D541C85D26508E83_1356869606 = null; 
        Rect varB4EAC82CA7396A68D541C85D26508E83_1056922326 = null; 
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_2042882803 = (mZoomManager.isPreventingWebkitUpdates());
            varB4EAC82CA7396A68D541C85D26508E83_1356869606 = mLastVisibleRectSent;
        } 
        calcOurContentVisibleRect(mVisibleRect);
        {
            boolean var00DE442F9F80E5CC469870BAE951674E_1026225099 = (!mVisibleRect.equals(mLastVisibleRectSent));
            {
                {
                    mScrollOffset.set(mVisibleRect.left, mVisibleRect.top);
                    mWebViewCore.removeMessages(EventHub.SET_SCROLL_OFFSET);
                    mWebViewCore.sendMessage(EventHub.SET_SCROLL_OFFSET,
                        nativeMoveGeneration(), mSendScrollEvent ? 1 : 0, mScrollOffset);
                } 
                mLastVisibleRectSent.set(mVisibleRect);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            } 
        } 
        {
            boolean var3D2FB3EC4A2EF0714518F74D7378575D_432483606 = (getGlobalVisibleRect(mGlobalVisibleRect)
                && !mGlobalVisibleRect.equals(mLastGlobalRect));
            {
                {
                    mWebViewCore.sendMessage(EventHub.SET_GLOBAL_BOUNDS, mGlobalVisibleRect);
                } 
                mLastGlobalRect.set(mGlobalVisibleRect);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1056922326 = mVisibleRect;
        Rect varA7E53CE21691AB073D9660D615818899_3822487; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_3822487 = varB4EAC82CA7396A68D541C85D26508E83_1356869606;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_3822487 = varB4EAC82CA7396A68D541C85D26508E83_1056922326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_3822487.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_3822487;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.124 -0400", hash_original_method = "95980AF7CA609DF1DA8494DB56190195", hash_generated_method = "621284844C145592B489342B5A7E1CD8")
    private void calcOurVisibleRect(Rect r) {
        getGlobalVisibleRect(r, mGlobalVisibleOffset);
        r.offset(-mGlobalVisibleOffset.x, -mGlobalVisibleOffset.y);
        addTaint(r.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.125 -0400", hash_original_method = "E11CE204142F1ECC32EEF48C7463E98D", hash_generated_method = "E477C760DC9C30F068516CB5785134AA")
    private void calcOurContentVisibleRect(Rect r) {
        calcOurVisibleRect(r);
        r.left = viewToContentX(r.left);
        r.top = viewToContentY(r.top + getVisibleTitleHeightImpl());
        r.right = viewToContentX(r.right);
        r.bottom = viewToContentY(r.bottom);
        addTaint(r.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.125 -0400", hash_original_method = "D90BE89766066DE7610CCC580DD1B107", hash_generated_method = "ADD074226841074401ED75CFBAECD66A")
    private void calcOurContentVisibleRectF(RectF r) {
        calcOurVisibleRect(mContentVisibleRect);
        r.left = viewToContentXf(mContentVisibleRect.left);
        r.top = viewToContentYf(mContentVisibleRect.top + getVisibleTitleHeightImpl());
        r.right = viewToContentXf(mContentVisibleRect.right);
        r.bottom = viewToContentYf(mContentVisibleRect.bottom);
        addTaint(r.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.126 -0400", hash_original_method = "F57343AFF9749E562523F07516DD1814", hash_generated_method = "106C4B181D31217A412AC02A0FBF4C06")
     boolean sendViewSizeZoom(boolean force) {
        {
            boolean varAE4ECBB9AF2032911A6639ABEB801BF6_1982261291 = (mZoomManager.isPreventingWebkitUpdates());
        } 
        int viewWidth = getViewWidth();
        int newWidth = Math.round(viewWidth * mZoomManager.getInvScale());
        int viewHeight = getViewHeightWithTitle() - getTitleHeight();
        int newHeight = Math.round(viewHeight * mZoomManager.getInvScale());
        float heightWidthRatio = (float) viewHeight / viewWidth;
        {
            newHeight = 0;
            heightWidthRatio = 0;
        } 
        int actualViewHeight = Math.round(getViewHeight() * mZoomManager.getInvScale());
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
        } 
        addTaint(force);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929864369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929864369;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.126 -0400", hash_original_method = "68D4F7C7314D54768CC2FFDD5D69C2D7", hash_generated_method = "66D3D3FD49D711BB73D221CCBEFC543D")
     void updateDoubleTapZoom(int doubleTapZoom) {
        mZoomManager.updateDoubleTapZoom(doubleTapZoom);
        addTaint(doubleTapZoom);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.127 -0400", hash_original_method = "D0DCA44D41EF177D0AFC894BF5E52308", hash_generated_method = "87B3E0F999FAB80F7B0C017656385672")
    private int computeRealHorizontalScrollRange() {
        {
            int varFC9DBABA45B6BB7366F73B80D989E991_826054522 = ((int) Math.floor(mContentWidth * mZoomManager.getScale()));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146260581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146260581;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.127 -0400", hash_original_method = "7C4F278B6BD93271722857221FD0D9C8", hash_generated_method = "AA4BDE68381A7AB04F888A03B2EB7FA7")
    @Override
    protected int computeHorizontalScrollRange() {
        int range = computeRealHorizontalScrollRange();
        final int scrollX = mScrollX;
        final int overscrollRight = computeMaxScrollX();
        {
            range -= scrollX;
        } 
        {
            range += scrollX - overscrollRight;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218793178 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218793178;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.127 -0400", hash_original_method = "0063C600F53290B450E1A53F41F0EDD1", hash_generated_method = "9BDC2FE48B49CC6A05A548C86AB99842")
    @Override
    protected int computeHorizontalScrollOffset() {
        int var39399E7590852488423D31BF8E113523_1704633925 = (Math.max(mScrollX, 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935471012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935471012;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.127 -0400", hash_original_method = "2F4E7F6214963F500759D2BE70B2F59A", hash_generated_method = "520376BD83BCF55AE669ABDBD9BA50BE")
    private int computeRealVerticalScrollRange() {
        {
            int var6B23C2077842EB549029F0B0D2DC4BA6_1590606383 = ((int) Math.floor(mContentHeight * mZoomManager.getScale()));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036345328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036345328;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.128 -0400", hash_original_method = "95D066BAD337A1BCD6552EF2CEEE5772", hash_generated_method = "2D7FB508EA6E925A4140892181E24013")
    @Override
    protected int computeVerticalScrollRange() {
        int range = computeRealVerticalScrollRange();
        final int scrollY = mScrollY;
        final int overscrollBottom = computeMaxScrollY();
        {
            range -= scrollY;
        } 
        {
            range += scrollY - overscrollBottom;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198659220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198659220;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.128 -0400", hash_original_method = "DA16FD39DE2B497C892BDF80D2E46593", hash_generated_method = "D9E7FFCC92B6699C7960D2F22F4F2D4B")
    @Override
    protected int computeVerticalScrollOffset() {
        int var34E847664C51512EE9641EF813607EB4_2129337462 = (Math.max(mScrollY - getTitleHeight(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755749594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1755749594;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.128 -0400", hash_original_method = "9B8C40BC2B17CAA747C155F52C82160F", hash_generated_method = "C75F56B656D96E2E4D851ED333EC9A72")
    @Override
    protected int computeVerticalScrollExtent() {
        int varE85BFDDBDAAF56CEC1CA21E104DA822F_525622249 = (getViewHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666654639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666654639;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.129 -0400", hash_original_method = "9312769E8F10D487895744226F1C1776", hash_generated_method = "C078B8AB53436C68A73322BA00A5B7EA")
    @Override
    protected void onDrawVerticalScrollBar(Canvas canvas,
                                           Drawable scrollBar,
                                           int l, int t, int r, int b) {
        
        {
            t -= mScrollY;
        } 
        scrollBar.setBounds(l, t + getVisibleTitleHeightImpl(), r, b);
        scrollBar.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(scrollBar.getTaint());
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.129 -0400", hash_original_method = "821A5122154DDC58201D4B1F6746E260", hash_generated_method = "014B51950612BA645D22B647054778C7")
    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
            boolean clampedY) {
        
        {
            scrollLayerTo(scrollX, scrollY);
        } 
        mInOverScrollMode = false;
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();
        {
            scrollX = pinLocX(scrollX);
        } 
        {
            mInOverScrollMode = true;
        } 
        {
            mInOverScrollMode = true;
        } 
        int oldX = mScrollX;
        int oldY = mScrollY;
        super.scrollTo(scrollX, scrollY);
        {
            mOverScrollGlow.pullGlow(mScrollX, mScrollY, oldX, oldY, maxX, maxY);
        } 
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        
        
            
            
        
        
        
        
        
            
        
            
        
        
            
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.130 -0400", hash_original_method = "C4EBBFF9818941C5D5824E8B3F51971E", hash_generated_method = "3A0D0ADDDBE01E6ACA65B128DA4D0A9B")
    public String getUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1237694061 = null; 
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1237694061 = h != null ? h.getUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1237694061.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1237694061;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.130 -0400", hash_original_method = "FC3C6716276F1756949A9C3C5723F4FD", hash_generated_method = "CAED9447DC0BC5CD28D0934F12E5964A")
    public String getOriginalUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_854121754 = null; 
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_854121754 = h != null ? h.getOriginalUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_854121754.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_854121754;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.130 -0400", hash_original_method = "D4595F49299490B58C966C4A02CB7245", hash_generated_method = "A3847748FCDD986C6BDA1AA39A3FAC05")
    public String getTitle() {
        String varB4EAC82CA7396A68D541C85D26508E83_438981922 = null; 
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_438981922 = h != null ? h.getTitle() : null;
        varB4EAC82CA7396A68D541C85D26508E83_438981922.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_438981922;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.131 -0400", hash_original_method = "A06DF5A940D8D02EBDDFDE57ABD78936", hash_generated_method = "C6CB4EFCCF3A70B2B94B0EAB65EB3345")
    public Bitmap getFavicon() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1682682073 = null; 
        checkThread();
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_1682682073 = h != null ? h.getFavicon() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1682682073.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1682682073;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.131 -0400", hash_original_method = "12FD5D0FD740156EA8AA35C005AD1672", hash_generated_method = "4901E9A29A1382218937AF5224F044C8")
    public String getTouchIconUrl() {
        String varB4EAC82CA7396A68D541C85D26508E83_544877657 = null; 
        WebHistoryItem h = mCallbackProxy.getBackForwardList().getCurrentItem();
        varB4EAC82CA7396A68D541C85D26508E83_544877657 = h != null ? h.getTouchIconUrl() : null;
        varB4EAC82CA7396A68D541C85D26508E83_544877657.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_544877657;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.132 -0400", hash_original_method = "1FE22EBDB3E8C56C40A407C1A0E083D0", hash_generated_method = "9ECD946F010489A2C544C6913B1DCE6A")
    public int getProgress() {
        checkThread();
        int var7E8F23F5531EF375BC02F70B93667140_555300065 = (mCallbackProxy.getProgress());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185912778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185912778;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.132 -0400", hash_original_method = "9280AE473B4D22C8C4242E7098408E11", hash_generated_method = "1EA7A840B10384132B2F5E2E5D870E6A")
    public int getContentHeight() {
        checkThread();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898768215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898768215;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.132 -0400", hash_original_method = "CC08B3036F1FD603613A57F943902091", hash_generated_method = "692C4B604C14A71FA735182A48B61F1E")
    public int getContentWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89283109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89283109;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.132 -0400", hash_original_method = "2D2276F4E8C0430A926499D45A99B96A", hash_generated_method = "2AB6345C64EC96845DEB1B10526B0A19")
    public int getPageBackgroundColor() {
        int varDEEC2470ADDE0DE678B2B89837C36FF8_1398821414 = (nativeGetBackgroundColor());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887791684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887791684;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.133 -0400", hash_original_method = "F4269AC1BA46586A96C0F97DD25B0051", hash_generated_method = "651F867BAFC105E7B600DA6E0DB6200B")
    public void pauseTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.PAUSE_TIMERS);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.133 -0400", hash_original_method = "9E286A490B2D9B3B0A47FD01965221C0", hash_generated_method = "FCEBD265F9D78FA6297E394388314989")
    public void resumeTimers() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.RESUME_TIMERS);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.133 -0400", hash_original_method = "1CC368C251E77C3E9F8955DD9780AFB9", hash_generated_method = "9A2C91217964AFD85BD7C1DC25019147")
    public void onPause() {
        
        checkThread();
        {
            mIsPaused = true;
            mWebViewCore.sendMessage(EventHub.ON_PAUSE);
            {
                mHTML5VideoViewProxy.pauseAndDispatch();
            } 
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } 
            cancelSelectDialog();
        } 
        
        
        
            
            
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.134 -0400", hash_original_method = "C4F3357DF5076A3856C176A86E0CF6FC", hash_generated_method = "FCFC44FC2D661CF352F4B01F8E0B1C18")
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        
        super.onWindowVisibilityChanged(visibility);
        updateDrawingState();
        addTaint(visibility);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.134 -0400", hash_original_method = "79814C5B2A5EB8E3D8936785FBEE125A", hash_generated_method = "1A21533528FA1C3FADAB6824759F6616")
     void updateDrawingState() {
        {
            boolean var7C64E366ECC1C3C33738983696089D46_1856487225 = (getWindowVisibility() != VISIBLE);
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } 
            {
                boolean varA0A81FC19EFCAB05136A17FC3377BBD3_299414270 = (getVisibility() != VISIBLE);
                {
                    nativeSetPauseDrawing(mNativeClass, true);
                } 
                {
                    nativeSetPauseDrawing(mNativeClass, false);
                } 
            } 
        } 
        
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.134 -0400", hash_original_method = "9F5D63D4787FAE81A0CC8C6A7CD50DBE", hash_generated_method = "FED5B336FC4FDC2946193D66C38CB80D")
    public void onResume() {
        
        checkThread();
        {
            mIsPaused = false;
            mWebViewCore.sendMessage(EventHub.ON_RESUME);
            {
                nativeSetPauseDrawing(mNativeClass, false);
            } 
        } 
        
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.135 -0400", hash_original_method = "0A4A277C67A1CBC7C62543C182164A85", hash_generated_method = "907B05EE07EAB7221F148E8C74A83F21")
    public boolean isPaused() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873618120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_873618120;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.135 -0400", hash_original_method = "DC3AADF3E379C94BA0FE1BFB930E916E", hash_generated_method = "7D54396D1E9C804F1A90D8C86B6B65FA")
    public void freeMemory() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.FREE_MEMORY);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.135 -0400", hash_original_method = "D5CF836D2D5BF2EB481CE4AEABE5D4B8", hash_generated_method = "0D4899F7FD9DC156BDFBF42FF0AB7E69")
    public void clearCache(boolean includeDiskFiles) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_CACHE,
                includeDiskFiles ? 1 : 0, 0);
        addTaint(includeDiskFiles);
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.135 -0400", hash_original_method = "89D3268D382ADF247005DA9907E08532", hash_generated_method = "550A95E6BD2D96A7F88BBCF46B915B8A")
    public void clearFormData() {
        checkThread();
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_870537551 = (inEditingMode());
            {
                mWebTextView.setAdapterCustom(null);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.135 -0400", hash_original_method = "73CAD65505EA4C263B5AF0640152FBB6", hash_generated_method = "2F018CB7C6DC1FE54A157AEDF3AD6E80")
    public void clearHistory() {
        checkThread();
        mCallbackProxy.getBackForwardList().setClearPending();
        mWebViewCore.sendMessage(EventHub.CLEAR_HISTORY);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.136 -0400", hash_original_method = "6A590B9D1F2C4C3632643CECDB78BB62", hash_generated_method = "36E442E384C566FE65DE22F84677463B")
    public void clearSslPreferences() {
        checkThread();
        mWebViewCore.sendMessage(EventHub.CLEAR_SSL_PREF_TABLE);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.136 -0400", hash_original_method = "4E2B6300B08A6182455A3348E7987460", hash_generated_method = "B268BE1489F8A45CC240A64B53DFA648")
    public WebBackForwardList copyBackForwardList() {
        WebBackForwardList varB4EAC82CA7396A68D541C85D26508E83_2091511935 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_2091511935 = mCallbackProxy.getBackForwardList().clone();
        varB4EAC82CA7396A68D541C85D26508E83_2091511935.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2091511935;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.136 -0400", hash_original_method = "D37A67FFAE0C4C71AD4307C99398F031", hash_generated_method = "22FA17683790C382B57E0A3D679867C2")
    public void findNext(boolean forward) {
        checkThread();
        nativeFindNext(forward);
        addTaint(forward);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.137 -0400", hash_original_method = "861EB608CE0EDDAE03DBAF1C277E0255", hash_generated_method = "ABD3775A9A30C1D9C0351D984D52FEEF")
    public int findAll(String find) {
        checkThread();
        int result;
        result = nativeFindAll(find.toLowerCase(),
                find.toUpperCase(), find.equalsIgnoreCase(mLastFind));
        result = 0;
        invalidate();
        mLastFind = find;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537956472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537956472;
        
        
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.137 -0400", hash_original_method = "D9C8E35CBE38CEA4EFA2830E75049E7E", hash_generated_method = "1E574801955BE5AFD6FC2ECBB8F2429E")
    public boolean showFindDialog(String text, boolean showIme) {
        checkThread();
        FindActionModeCallback callback = new FindActionModeCallback(mContext);
        {
            boolean varD263546D355C6FB3DF70E9DF8F0F7FDE_1400911275 = (getParent() == null || startActionMode(callback) == null);
        } 
        mCachedOverlappingActionModeHeight = -1;
        mFindCallback = callback;
        setFindIsUp(true);
        mFindCallback.setWebView(this);
        {
            mFindCallback.showSoftInput();
        } 
        {
            mFindCallback.setText(text);
            mFindCallback.findAll();
        } 
        {
            text = mLastFind;
        } 
        {
            mFindCallback.setText(text);
        } 
        addTaint(text.getTaint());
        addTaint(showIme);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859655684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859655684;
        
        
        
        
            
        
        
        
        
        
        
            
        
            
            
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.137 -0400", hash_original_method = "644CAA236916E64D282AC7E803A66C65", hash_generated_method = "004C2AC6F57CA6FE3ADD79D9BCCEDF05")
    private void setFindIsUp(boolean isUp) {
        mFindIsUp = isUp;
        nativeSetFindIsUp(isUp);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.137 -0400", hash_original_method = "FBDEE77A8BCDC35814DF27DAD18B5857", hash_generated_method = "77E1DA89DCC239CBB6212D642793634E")
     int findIndex() {
        int var790C769C9D30EC8562E6C6B0E7276107_990736243 = (nativeFindIndex());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161699867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161699867;
        
        
        
    }

    
        public static String findAddress(String addr) {
        checkThread();
        return findAddress(addr, false);
    }

    
        public static String findAddress(String addr, boolean caseInsensitive) {
        return WebViewCore.nativeFindAddress(addr, caseInsensitive);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.138 -0400", hash_original_method = "6CC02C87B3D427E709246FBDB5B416E2", hash_generated_method = "1AF0A7969A405E9ACF74B77D7B7D1CBC")
    public void clearMatches() {
        checkThread();
        nativeSetFindIsEmpty();
        invalidate();
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.138 -0400", hash_original_method = "7F58BEA15D7EE718F7A7F29AAFC19859", hash_generated_method = "948A2F13512D200DBE7FFC5B15A696B2")
     void notifyFindDialogDismissed() {
        mFindCallback = null;
        mCachedOverlappingActionModeHeight = -1;
        clearMatches();
        setFindIsUp(false);
        pinScrollTo(mScrollX, mScrollY, false, 0);
        invalidate();
        
        
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.138 -0400", hash_original_method = "7D4A54E050E4305969EB7285D4EE527F", hash_generated_method = "3103CDCAFE9D854CB60AB60E61FA0C11")
    public void documentHasImages(Message response) {
        checkThread();
        mWebViewCore.sendMessage(EventHub.DOC_HAS_IMAGES, response);
        addTaint(response.getTaint());
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.139 -0400", hash_original_method = "493087CEBEB51D22E8A8F5533F5901E6", hash_generated_method = "A83853DA38B09ACCE7BA0F75693DED2D")
    public void stopScroll() {
        mScroller.forceFinished(true);
        mLastVelocity = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.139 -0400", hash_original_method = "397FDDDC8F121B7E1915BEE82ADAC8FD", hash_generated_method = "467BE9BFBDBAACDCC1128D51DBFEDD74")
    @Override
    public void computeScroll() {
        {
            boolean varE7DE5EF6873640B86AA94D9EE969CCF1_1694238023 = (mScroller.computeScrollOffset());
            {
                int oldX = mScrollX;
                int oldY = mScrollY;
                int x = mScroller.getCurrX();
                int y = mScroller.getCurrY();
                invalidate();
                {
                    boolean var8ED3C4A638769CFEBC66BFFEC229D1E8_1321781696 = (!mScroller.isFinished());
                    {
                        int rangeX = computeMaxScrollX();
                        int rangeY = computeMaxScrollY();
                        int overflingDistance = mOverflingDistance;
                        {
                            oldX = mScrollingLayerRect.left;
                            oldY = mScrollingLayerRect.top;
                            rangeX = mScrollingLayerRect.right;
                            rangeY = mScrollingLayerRect.bottom;
                            overflingDistance = 0;
                        } 
                        overScrollBy(x - oldX, y - oldY, oldX, oldY,
                        rangeX, rangeY,
                        overflingDistance, overflingDistance, false);
                        {
                            mOverScrollGlow.absorbGlow(x, y, oldX, oldY, rangeX, rangeY);
                        } 
                    } 
                    {
                        {
                            mScrollX = x;
                            mScrollY = y;
                        } 
                        {
                            scrollLayerTo(x, y);
                        } 
                        abortAnimation();
                        nativeSetIsScrolling(false);
                        {
                            WebViewCore.resumePriority();
                            {
                                WebViewCore.resumeUpdatePicture(mWebViewCore);
                            } 
                        } 
                        {
                            sendOurVisibleRect();
                        } 
                    } 
                } 
            } 
            {
                super.computeScroll();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.140 -0400", hash_original_method = "A78CC18CC5D952B5F0E408E587D6B954", hash_generated_method = "9A67CBAEF8EBBB17AC6D00ACF10632ED")
    private void scrollLayerTo(int x, int y) {
        nativeScrollLayer(mCurrentScrollingLayerId, x, y);
        mScrollingLayerRect.left = x;
        mScrollingLayerRect.top = y;
        onScrollChanged(mScrollX, mScrollY, mScrollX, mScrollY);
        invalidate();
        
        
            
        
        
        
        
        
        
    }

    
        private static int computeDuration(int dx, int dy) {
        int distance = Math.max(Math.abs(dx), Math.abs(dy));
        int duration = distance * 1000 / STD_SPEED;
        return Math.min(duration, MAX_DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.140 -0400", hash_original_method = "8D1A8D2F87370E55C84C6950D8E209BA", hash_generated_method = "50B6FC137AAC91360903DAB40BDBB1A5")
    private boolean pinScrollBy(int dx, int dy, boolean animate, int animationDuration) {
        boolean varDDCD3B201102A2B6BF7DF6BB672D50B5_368687247 = (pinScrollTo(mScrollX + dx, mScrollY + dy, animate, animationDuration));
        addTaint(dx);
        addTaint(dy);
        addTaint(animate);
        addTaint(animationDuration);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305725206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305725206;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.173 -0400", hash_original_method = "28406564CFF019B04CBA9BE766B0B079", hash_generated_method = "D692F8423EF5B84C4984C3E2932293C0")
    private boolean pinScrollTo(int x, int y, boolean animate, int animationDuration) {
        x = pinLocX(x);
        y = pinLocY(y);
        int dx = x - mScrollX;
        int dy = y - mScrollY;
        abortAnimation();
        {
            mScroller.startScroll(mScrollX, mScrollY, dx, dy,
                    animationDuration > 0 ? animationDuration : computeDuration(dx, dy));
            awakenScrollBars(mScroller.getDuration());
            invalidate();
        } 
        {
            scrollTo(x, y);
        } 
        addTaint(x);
        addTaint(y);
        addTaint(animate);
        addTaint(animationDuration);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1472175104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1472175104;
        
        
        
        
        
        
            
        
        
        
            
                    
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.174 -0400", hash_original_method = "CEE0332A10F7E30FB891410D05453CB6", hash_generated_method = "EF8F8E79DB4DED898FA80F63DACFC57F")
    private boolean setContentScrollBy(int cx, int cy, boolean animate) {
        cx = contentToViewDimension(cx);
        cy = contentToViewDimension(cy);
        {
            {
                Rect tempRect = new Rect();
                calcOurVisibleRect(tempRect);
                tempRect.offset(cx, cy);
                requestRectangleOnScreen(tempRect);
            } 
            boolean var3FCDFFB9E4E3AC0EFF489E7F0EAB193B_1228947003 = (cy == 0 && cx != 0 && pinScrollBy(cx, 0, animate, 0));
        } 
        {
            boolean var29BB42B254A3ABD17ABD36618645F129_2060869595 = (pinScrollBy(cx, cy, animate, 0));
        } 
        addTaint(cx);
        addTaint(cy);
        addTaint(animate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_558284466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_558284466;
        
        
            
        
        
        
        
            
                
                
                
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.174 -0400", hash_original_method = "F9449ED22C56BBB497563553E364031E", hash_generated_method = "FF087F6777B3DE1118FABF8CF93039F6")
     void onPageStarted(String url) {
        
        setCertificate(null);
        mAccessibilityScriptInjected = false;
        addTaint(url.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.175 -0400", hash_original_method = "5AA3ECE4362C1B5CB5D5CB21F96F8C24", hash_generated_method = "FE79C621D28DB7E7BE8B64A98CA6602A")
     void onPageFinished(String url) {
        
        {
            {
                boolean varE94AF5A5E140E4B674F99180E2533924_1164145031 = (mPageThatNeedsToSlideTitleBarOffScreen.equals(url)
                    && mScrollX == 0 && mScrollY == 0);
                {
                    pinScrollTo(0, mYDistanceToSlideTitleOffScreen, true,
                        SLIDE_TITLE_DURATION);
                } 
            } 
            mPageThatNeedsToSlideTitleBarOffScreen = null;
        } 
        mZoomManager.onPageFinished(url);
        injectAccessibilityForUrl(url);
        addTaint(url.getTaint());
        
        
            
                    
                
                        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.175 -0400", hash_original_method = "34573C30CF8606C23162A7936083773B", hash_generated_method = "E3D785D3B095C0CE4B82865F25BE20A7")
    private void injectAccessibilityForUrl(String url) {
        AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mContext);
        {
            boolean var2F55789C2BAEC4B54A3769DF00E1201A_1793808314 = (!accessibilityManager.isEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(false);
            } 
        } 
        {
            boolean var257A8D7DF44254A8F3AFFC587333D831_442031094 = (!getSettings().getJavaScriptEnabled());
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } 
        } 
        int axsParameterValue = getAxsUrlParameterValue(url);
        {
            boolean onDeviceScriptInjectionEnabled = (Settings.Secure.getInt(mContext
                    .getContentResolver(), Settings.Secure.ACCESSIBILITY_SCRIPT_INJECTION, 0) == 1);
            {
                ensureAccessibilityScriptInjectorInstance(false);
                loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
                mAccessibilityScriptInjected = true;
            } 
            {
                ensureAccessibilityScriptInjectorInstance(true);
            } 
        } 
        {
            ensureAccessibilityScriptInjectorInstance(true);
        } 
        {
            ensureAccessibilityScriptInjectorInstance(false);
            loadUrl(ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT);
        } 
        addTaint(url.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.176 -0400", hash_original_method = "C4BE45F17F777AB336F1167296A12C7F", hash_generated_method = "335FDA94246D087A35BA7BC63B85318F")
    private void ensureAccessibilityScriptInjectorInstance(boolean present) {
        {
            {
                mAccessibilityInjector = new AccessibilityInjector(this);
            } 
        } 
        {
            mAccessibilityInjector = null;
        } 
        addTaint(present);
        
        
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.177 -0400", hash_original_method = "C287DB70122330F3E4C4ACC26E03627A", hash_generated_method = "3DC9E4F9B3BE8504CC9B8836A10BB410")
    private int getAxsUrlParameterValue(String url) {
        {
            mMatchAxsUrlParameterPattern = Pattern.compile(PATTERN_MATCH_AXS_URL_PARAMETER);
        } 
        Matcher matcher = mMatchAxsUrlParameterPattern.matcher(url);
        {
            boolean var0CA07C7E05B5FB943A39E313382D5DA2_775069163 = (matcher.find());
            {
                String keyValuePair = url.substring(matcher.start(), matcher.end());
                int varB4575FE2088203A669F7AEBE1DD89AA0_2111560192 = (Integer.parseInt(keyValuePair.split("=")[1]));
            } 
        } 
        addTaint(url.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292124737 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1292124737;
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.177 -0400", hash_original_method = "85469FC376270F66ED556D9DF3F3E4CA", hash_generated_method = "48B05BA065177F59CF0D7EE0CAEEAF72")
    private boolean setContentScrollTo(int cx, int cy) {
        int vx;
        int vy;
        {
            vx = 0;
            vy = 0;
        } 
        {
            vx = contentToViewX(cx);
            vy = contentToViewY(cy);
        } 
        {
            {
                boolean varBB2C6738F4D3DE5D7DC74ECC3D92899E_1007720276 = (getProgress() < 100);
                {
                    mPageThatNeedsToSlideTitleBarOffScreen = getUrl();
                    mYDistanceToSlideTitleOffScreen = vy;
                } 
                {
                    pinScrollTo(vx, vy, true, SLIDE_TITLE_DURATION);
                } 
            } 
        } 
        pinScrollTo(vx, vy, false, 0);
        addTaint(cx);
        addTaint(cy);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672732211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672732211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.178 -0400", hash_original_method = "0B2E263F6664B54FB6A39EB15568F032", hash_generated_method = "98FD1A3A1837727189C41C1FC8FB9BCD")
    private void spawnContentScrollTo(int cx, int cy) {
        int vx = contentToViewX(cx);
        int vy = contentToViewY(cy);
        pinScrollTo(vx, vy, true, 0);
        addTaint(cx);
        addTaint(cy);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.178 -0400", hash_original_method = "B2689D58B72FEADBF95CE586A18113DD", hash_generated_method = "D0AF15F623531C78FDD35F9D15E21DCE")
    private void contentSizeChanged(boolean updateLayout) {
        {
            {
                boolean var687FC976609C320EB23E747E9ECBC12A_1954396947 = (getMeasuredHeight() != contentToViewDimension(mContentHeight)
                    || updateLayout);
                {
                    requestLayout();
                } 
            } 
        } 
        {
            {
                boolean var7183AB9F5F71646AEDE7ABA21E1DCB83_1814152045 = (getMeasuredWidth() != contentToViewDimension(mContentWidth)
                    || updateLayout);
                {
                    requestLayout();
                } 
            } 
        } 
        {
            sendViewSizeZoom(false);
        } 
        addTaint(updateLayout);
        
        
            
        
        
            
                    
                
            
        
            
                    
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.178 -0400", hash_original_method = "769F6743ED2D17827D8530B0462AC06C", hash_generated_method = "F3B729784BD18A25F5FDBD218DCB7288")
    public void setWebViewClient(WebViewClient client) {
        checkThread();
        mCallbackProxy.setWebViewClient(client);
        addTaint(client.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.179 -0400", hash_original_method = "9510E1691A13C745A9F2E9F4F8D6E00C", hash_generated_method = "C85958358DE9C04B2B4EA84DB0C99DD3")
    public WebViewClient getWebViewClient() {
        WebViewClient varB4EAC82CA7396A68D541C85D26508E83_585041390 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_585041390 = mCallbackProxy.getWebViewClient();
        varB4EAC82CA7396A68D541C85D26508E83_585041390.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_585041390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.179 -0400", hash_original_method = "93122A4EB9BFF9B6681CFF27CAD9AD68", hash_generated_method = "7DE0F204CFF3CDDC346E0D85FFBBBA36")
    public void setDownloadListener(DownloadListener listener) {
        checkThread();
        mCallbackProxy.setDownloadListener(listener);
        addTaint(listener.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.179 -0400", hash_original_method = "2B899D0DAE9F57DC761251705A20EE74", hash_generated_method = "3D9E8DD1B6C4DFF817488E138E88D2CD")
    public void setWebChromeClient(WebChromeClient client) {
        checkThread();
        mCallbackProxy.setWebChromeClient(client);
        addTaint(client.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.180 -0400", hash_original_method = "0856D3AA879CE0F9861CD0E5275F79DF", hash_generated_method = "AE5ECD0A4FD00914E12BDFF0DE5178FF")
    public WebChromeClient getWebChromeClient() {
        WebChromeClient varB4EAC82CA7396A68D541C85D26508E83_479213529 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_479213529 = mCallbackProxy.getWebChromeClient();
        varB4EAC82CA7396A68D541C85D26508E83_479213529.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_479213529;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.180 -0400", hash_original_method = "EB13F653C5834D1CFEF8685699E42E7B", hash_generated_method = "151C3157D35633F4DDA39549C419F0CD")
    public void setWebBackForwardListClient(WebBackForwardListClient client) {
        mCallbackProxy.setWebBackForwardListClient(client);
        addTaint(client.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.180 -0400", hash_original_method = "2196B00F919C4231D836D65762ED39B4", hash_generated_method = "0E71F04C6174F36C9BA11B6E1DE2FD28")
    public WebBackForwardListClient getWebBackForwardListClient() {
        WebBackForwardListClient varB4EAC82CA7396A68D541C85D26508E83_1661135065 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1661135065 = mCallbackProxy.getWebBackForwardListClient();
        varB4EAC82CA7396A68D541C85D26508E83_1661135065.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1661135065;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.181 -0400", hash_original_method = "810505B18EC3CA9A02B80DBEC4016604", hash_generated_method = "C3EF422014BE5A0F4249AE48165752C1")
    @Deprecated
    public void setPictureListener(PictureListener listener) {
        checkThread();
        mPictureListener = listener;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.181 -0400", hash_original_method = "C9D6AA4C78A3F7F7014DB2B673D8246B", hash_generated_method = "AB44FF5C87D068F8B66D0EB04B5B59EC")
    public void externalRepresentation(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_EXT_REPRESENTATION, callback);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.181 -0400", hash_original_method = "9222F93D44C1AF98B52A79785079897C", hash_generated_method = "F1D6619F174949CADCC64CC888204E8C")
    public void documentAsText(Message callback) {
        mWebViewCore.sendMessage(EventHub.REQUEST_DOC_AS_TEXT, callback);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.181 -0400", hash_original_method = "F8CD5D2DFF3A220BC823A466CE0A8012", hash_generated_method = "F28884778D8EF5B5C4DC4F361088F14B")
    public void addJavascriptInterface(Object obj, String interfaceName) {
        checkThread();
        WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
        arg.mObject = obj;
        arg.mInterfaceName = interfaceName;
        mWebViewCore.sendMessage(EventHub.ADD_JS_INTERFACE, arg);
        addTaint(obj.getTaint());
        addTaint(interfaceName.getTaint());
        
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.182 -0400", hash_original_method = "6F484DEFA49403C25BA0D9D40F6428C2", hash_generated_method = "885A40D67107E881C92F4FF6B739B55D")
    public void removeJavascriptInterface(String interfaceName) {
        checkThread();
        {
            WebViewCore.JSInterfaceData arg = new WebViewCore.JSInterfaceData();
            arg.mInterfaceName = interfaceName;
            mWebViewCore.sendMessage(EventHub.REMOVE_JS_INTERFACE, arg);
        } 
        addTaint(interfaceName.getTaint());
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.182 -0400", hash_original_method = "AE8854F55F54F48403D38F822FA4F88C", hash_generated_method = "37C99CA7D641205323D8FAC4770438F6")
    public WebSettings getSettings() {
        WebSettings varB4EAC82CA7396A68D541C85D26508E83_1581230192 = null; 
        checkThread();
        varB4EAC82CA7396A68D541C85D26508E83_1581230192 = (mWebViewCore != null) ? mWebViewCore.getSettings() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1581230192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1581230192;
        
        
        
    }

    
        @Deprecated
    public static synchronized PluginList getPluginList() {
        checkThread();
        return new PluginList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.183 -0400", hash_original_method = "71E7F8783CA517B5FA7921BE8B9AA4B1", hash_generated_method = "F63CF9890D2496C37BAC81075ED36118")
    @Deprecated
    public void refreshPlugins(boolean reloadOpenPages) {
        checkThread();
        addTaint(reloadOpenPages);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.183 -0400", hash_original_method = "4D6290BFCDFFE96473D2F2579D955F79", hash_generated_method = "0FF9D65A8838DA893081FA9FCF1DA2B1")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                mPrivateHandler.post(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.183 -0400", hash_original_method = "C35D8FF76F468647EBD4843DB70BD70E", hash_generated_method = "1D1962C885A4B76385563869BB6544A0")
                    @Override
                    public void run() {
                        destroy();
                        
                        
                    }
});
            } 
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
                    
                    
                        
                    
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.184 -0400", hash_original_method = "C0BB867D65C0EAF3817C046AEAC99DE7", hash_generated_method = "73FD78EA9073F323471AB9191B64E8D5")
    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        {
            mTitleBar.offsetLeftAndRight(mScrollX - mTitleBar.getLeft());
            int newTop = 0;
            {
                newTop = Math.min(0, mScrollY);
            } 
            {
                newTop = mScrollY;
            } 
            mTitleBar.setBottom(newTop + mTitleBar.getHeight());
            mTitleBar.setTop(newTop);
        } 
        boolean var2713BACF81F43D1C388D129F1A927E0D_1301717787 = (super.drawChild(canvas, child, drawingTime));
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083057976 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083057976;
        
        
            
            
            
                
            
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.184 -0400", hash_original_method = "8CA21866933B94441ABE2CA5F3F3FCD2", hash_generated_method = "B19EBDB86B0C7374E5043A66E795BD08")
    private void drawContent(Canvas canvas, boolean drawRings) {
        drawCoreAndCursorRing(canvas, mBackgroundColor,
                mDrawCursorRing && drawRings);
        addTaint(canvas.getTaint());
        addTaint(drawRings);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.184 -0400", hash_original_method = "8D8CCAD0F71723FDFE9FDDA329E53267", hash_generated_method = "077AF611FBE8B8914C6D85A6FEE36190")
    private void drawOverScrollBackground(Canvas canvas) {
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
        } 
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
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.185 -0400", hash_original_method = "2571802D3B47DE5AF167AF15E2038D31", hash_generated_method = "DB8CFE245C3F29E4E499CEE0060597B8")
    @Override
    protected void onDraw(Canvas canvas) {
        
        {
            canvas.drawColor(mBackgroundColor);
        } 
        {
            canvas.drawColor(mBackgroundColor);
        } 
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_288675994 = (canvas.isHardwareAccelerated());
            {
                {
                    mIncrementEGLContextHack = true;
                    EGL10 egl = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglDisplay = egl.eglGetDisplay(EGL_DEFAULT_DISPLAY);
                    int[] version = new int[2];
                    egl.eglInitialize(eglDisplay, version);
                } 
                mZoomManager.setHardwareAccelerated();
            } 
        } 
        int saveCount = canvas.save();
        {
            boolean var4322EE85B805CBD21A094B57F62ADC23_1963454312 = (mInOverScrollMode && !getSettings()
                .getUseWebViewBackgroundForOverscrollBackground());
            {
                drawOverScrollBackground(canvas);
            } 
        } 
        {
            canvas.translate(0, getTitleHeight());
        } 
        boolean drawJavaRings = !mTouchHighlightRegion.isEmpty()
                && (mTouchMode == TOUCH_INIT_MODE
                || mTouchMode == TOUCH_SHORTPRESS_START_MODE
                || mTouchMode == TOUCH_SHORTPRESS_MODE
                || mTouchMode == TOUCH_DONE_MODE);
        boolean drawNativeRings = !drawJavaRings;
        {
            drawNativeRings = !drawJavaRings && !isInTouchMode();
        } 
        drawContent(canvas, drawNativeRings);
        canvas.restoreToCount(saveCount);
        {
            invalidate();
        } 
        mWebViewCore.signalRepaintDone();
        {
            boolean varEFDBDAC0A2DEB3E5103984743E3C9A57_2098663904 = (mOverScrollGlow != null && mOverScrollGlow.drawEdgeGlows(canvas));
            {
                invalidate();
            } 
        } 
        {
            long delay = System.currentTimeMillis() - mTouchHighlightRequested;
            {
                boolean varBCA1B79D766932AE90DE8B5336B437FC_1526906015 = (delay < ViewConfiguration.getTapTimeout());
                {
                    Rect r = mTouchHighlightRegion.getBounds();
                    postInvalidateDelayed(delay, r.left, r.top, r.right, r.bottom);
                } 
                {
                    {
                        mTouchHightlightPaint = new Paint();
                        mTouchHightlightPaint.setColor(HIGHLIGHT_COLOR);
                    } 
                    RegionIterator iter = new RegionIterator(mTouchHighlightRegion);
                    Rect r = new Rect();
                    {
                        boolean var777D1BAEECB4D7088A7F6E66A69B6796_2082453955 = (iter.next(r));
                        {
                            canvas.drawRect(r, mTouchHightlightPaint);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                boolean var7909E0FF363982F909528C78CCCF0F02_1331810436 = (getSettings().getNavDump());
                {
                    {
                        {
                            mTouchCrossHairColor = new Paint();
                            mTouchCrossHairColor.setColor(Color.RED);
                        } 
                        canvas.drawLine(mTouchHighlightX - mNavSlop,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    + mNavSlop + 1, mTouchHighlightY + mNavSlop
                                    + 1, mTouchCrossHairColor);
                        canvas.drawLine(mTouchHighlightX + mNavSlop + 1,
                            mTouchHighlightY - mNavSlop, mTouchHighlightX
                                    - mNavSlop,
                            mTouchHighlightY + mNavSlop + 1,
                            mTouchCrossHairColor);
                    } 
                } 
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.186 -0400", hash_original_method = "AEC7BCD069002037ED8CEC0E70FF25BF", hash_generated_method = "34A310392E72BEC0A58EE1BE45DD1549")
    private void removeTouchHighlight() {
        mWebViewCore.removeMessages(EventHub.GET_TOUCH_HIGHLIGHT_RECTS);
        mPrivateHandler.removeMessages(SET_TOUCH_HIGHLIGHT_RECTS);
        setTouchHighlightRects(null);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.187 -0400", hash_original_method = "4D6ED72E1D8734DB9F91C39D11CC17A8", hash_generated_method = "6021645F500B5EC19CBD1C4A017AD7F8")
    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        {
            mWrapContent = true;
        } 
        super.setLayoutParams(params);
        addTaint(params.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.188 -0400", hash_original_method = "C7905858831C273DDDC35E48675F4933", hash_generated_method = "E7399374FBDE8597F1E2044CD528F802")
    @Override
    public boolean performLongClick() {
        {
            boolean var88AD79EA276C28AD3B3469360BCE1788_278952375 = (getParent() == null);
        } 
        final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
        {
            boolean var13D92B99C938B0F2FF8CCF00F803E8A6_1068894468 = (detector != null && detector.isInProgress());
        } 
        {
            boolean var780C0185A33DB3757005E772477A414D_337540330 = (mNativeClass != 0 && nativeCursorIsTextInput());
            {
                centerKeyPressOnTextField();
                rebuildWebTextView();
            } 
            {
                clearTextEntry();
            } 
        } 
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_906395250 = (inEditingMode());
            {
                mWebTextView.ensureLayout();
                AbsoluteLayout.LayoutParams params = (AbsoluteLayout.LayoutParams) mWebTextView.getLayoutParams();
                MotionEvent fake = MotionEvent.obtain(mLastTouchTime,
                    mLastTouchTime, MotionEvent.ACTION_DOWN,
                    mLastTouchX - params.x + mScrollX,
                    mLastTouchY - params.y + mScrollY, 0);
                mWebTextView.dispatchTouchEvent(fake);
                boolean var8E1B4A2E9B8893A37E1A84490A65FC9A_559302066 = (mWebTextView.performLongClick());
            } 
        } 
        {
            boolean varC298D59926924FB0808A70DC864C4372_429641369 = (super.performLongClick());
        } 
        final boolean isSelecting = selectText();
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118261536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118261536;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.189 -0400", hash_original_method = "D97A4633ECE316AAA5200B243AD2A3B8", hash_generated_method = "C52C141BE7D627D8D033B26726E6F5EE")
    public boolean selectText() {
        int x = viewToContentX(mLastTouchX + mScrollX);
        int y = viewToContentY(mLastTouchY + mScrollY);
        boolean varB29E32086CAB7981D2C629145B25F904_1327239491 = (selectText(x, y));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343035733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343035733;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.189 -0400", hash_original_method = "B52E6A452332503A396253DC5399F744", hash_generated_method = "3C2F2CC5DA54E7DD692ADD30A3335DA1")
     boolean selectText(int x, int y) {
        {
            boolean varC5ECEC29B03BE800BB553180A5BFDF02_380155655 = (!setUpSelect(true, x, y));
        } 
        nativeSetExtendSelection();
        mDrawSelectionPointer = false;
        mTouchMode = TOUCH_DRAG_MODE;
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348749048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348749048;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.190 -0400", hash_original_method = "279BA211E48B838241155C78A3D48F21", hash_generated_method = "F99C07CA889DE93B7B3F7B16E73BA782")
    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        
        mCachedOverlappingActionModeHeight = -1;
        {
            selectionDone();
        } 
        mOrientation = newConfig.orientation;
        {
            mWebViewCore.sendMessage(EventHub.CLEAR_CONTENT);
        } 
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.190 -0400", hash_original_method = "3BB8A922C1BFB6AF7AED5E5F98A84271", hash_generated_method = "CA8BAFB23881A09755CC1088E9EA0E1A")
    private boolean didUpdateWebTextViewDimensions(int intersection) {
        Rect contentBounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(contentBounds);
        Rect visibleRect = new Rect();
        calcOurVisibleRect(visibleRect);
        offsetByLayerScrollPosition(vBox);
        boolean onScreen;
        
        onScreen = visibleRect.contains(vBox);
        
        
        onScreen = Rect.intersects(visibleRect, vBox);
        
        
        onScreen = true;
        
        
        if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                        "invalid parameter passed to didUpdateWebTextViewDimensions");
        
        {
            mWebTextView.setRect(vBox.left, vBox.top, vBox.width(),
                    vBox.height());
            mWebTextView.updateTextSize();
            updateWebTextViewPadding();
        } 
        {
            mWebTextView.remove();
        } 
        addTaint(intersection);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_271188513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_271188513;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.191 -0400", hash_original_method = "64A55D885CFF85A868AD631AC47EB4F7", hash_generated_method = "0037ECBF77E17B86BA5EC4B1D6A0948C")
    private void offsetByLayerScrollPosition(Rect box) {
        {
            boolean var9CB7C6698CC8E4B39807B6B5CCF588EA_917597873 = ((mCurrentScrollingLayerId != 0)
                && (mCurrentScrollingLayerId == nativeFocusCandidateLayerId()));
            {
                box.offsetTo(box.left - mScrollingLayerRect.left,
                    box.top - mScrollingLayerRect.top);
            } 
        } 
        addTaint(box.getTaint());
        
        
                
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.191 -0400", hash_original_method = "EEC8B8BD4BCC37CE97FE27801B9F6E07", hash_generated_method = "A0B57FA589AEBAA7F23307B996001032")
     void setBaseLayer(int layer, Region invalRegion, boolean showVisualIndicator,
            boolean isPictureAfterFirstLayout, boolean registerPageSwapCallback) {
        nativeSetBaseLayer(layer, invalRegion, showVisualIndicator,
                isPictureAfterFirstLayout, registerPageSwapCallback);
        {
            mHTML5VideoViewProxy.setBaseLayer(layer);
        } 
        addTaint(layer);
        addTaint(invalRegion.getTaint());
        addTaint(showVisualIndicator);
        addTaint(isPictureAfterFirstLayout);
        addTaint(registerPageSwapCallback);
        
        
            
        
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.191 -0400", hash_original_method = "D4D775641116CD07F30FDC12383A0B44", hash_generated_method = "8FB60ADDFE38F012F62B3C49C324E473")
     int getBaseLayer() {
        int var56C10FDD99E0FDF412C413A619660025_792432056 = (nativeGetBaseLayer());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512099589 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1512099589;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.192 -0400", hash_original_method = "F7CF662997AC144B39454757FD69ADFA", hash_generated_method = "143DFBADFB52DAD691DFD1ED979DFFD7")
    private void onZoomAnimationStart() {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_289724200 = (inEditingMode());
            {
                mWebTextView.setVisibility(INVISIBLE);
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.192 -0400", hash_original_method = "3939BC80E5E1B1FDB27A84D1BC47EF32", hash_generated_method = "4658060DEF68764032C5836FA3E006E3")
    private void onZoomAnimationEnd() {
        {
            boolean var7CF3A0FDB7A5E846FB3F76D951F33983_1997986193 = (inEditingMode()
                && didUpdateWebTextViewDimensions(FULLY_ON_SCREEN));
            {
                mWebTextView.setVisibility(VISIBLE);
            } 
        } 
        
        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.192 -0400", hash_original_method = "D76312EAEA392F17B2BD7F48A7BA5E85", hash_generated_method = "1DA8D4977752B15EE1DC244719C6FA7D")
     void onFixedLengthZoomAnimationStart() {
        
        WebViewCore.pauseUpdatePicture(getWebViewCore());
        onZoomAnimationStart();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.192 -0400", hash_original_method = "7728365CE5185BB89BE1B9394D71C9F8", hash_generated_method = "101EE64BBEBED819506DCE68CFA9A134")
     void onFixedLengthZoomAnimationEnd() {
        
        {
            WebViewCore.resumeUpdatePicture(mWebViewCore);
        } 
        onZoomAnimationEnd();
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.193 -0400", hash_original_method = "9DFCB5378C52F24DE36DEA58BF2CF89C", hash_generated_method = "D057FA96112B345DBE71F921695D0880")
    private void drawCoreAndCursorRing(Canvas canvas, int color,
        boolean drawCursorRing) {
        {
            canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            canvas.drawPicture(mHistoryPicture);
        } 
        boolean animateZoom = mZoomManager.isFixedLengthAnimationInProgress();
        boolean animateScroll = ((!mScroller.isFinished()
                || mVelocityTracker != null)
                && (mTouchMode != TOUCH_DRAG_MODE ||
                mHeldMotionless != MOTIONLESS_TRUE))
                || mDeferTouchMode == TOUCH_DRAG_MODE;
        {
            {
                mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
                mHeldMotionless = MOTIONLESS_FALSE;
            } 
            {
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(DRAG_HELD_MOTIONLESS), MOTIONLESS_TIME);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
                mHeldMotionless = MOTIONLESS_PENDING;
            } 
        } 
        int saveCount = canvas.save();
        {
            mZoomManager.animateZoom(canvas);
        } 
        {
            boolean var5969E37520F40BCD8DA013ED3783BF82_1899193951 = (!canvas.isHardwareAccelerated());
            {
                canvas.scale(mZoomManager.getScale(), mZoomManager.getScale());
            } 
        } 
        boolean UIAnimationsRunning = false;
        {
            boolean var438456B32769D6A7B316667DCB4406FE_1582402070 = (mNativeClass != 0 && !canvas.isHardwareAccelerated()
                && nativeEvaluateLayersAnimations(mNativeClass));
            {
                UIAnimationsRunning = true;
                mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
                invalidate();
            } 
        } 
        int extras = DRAW_EXTRAS_NONE;
        {
            extras = DRAW_EXTRAS_FIND;
        } 
        {
            extras = DRAW_EXTRAS_SELECTION;
            nativeSetSelectionPointer(mNativeClass,
                    mDrawSelectionPointer,
                    mZoomManager.getInvScale(), mSelectX, mSelectY - getTitleHeight());
        } 
        {
            extras = DRAW_EXTRAS_CURSOR_RING;
        } 
        calcOurContentVisibleRectF(mVisibleContentRect);
        {
            boolean var6EF828C6190BFBF42FDAC581E2D619E5_27160252 = (canvas.isHardwareAccelerated());
            {
                Rect glRectViewport;
                glRectViewport = null;
                glRectViewport = mGLRectViewport;
                Rect viewRectViewport;
                viewRectViewport = null;
                viewRectViewport = mViewRectViewport;
                int functor = nativeGetDrawGLFunction(mNativeClass, glRectViewport,
                    viewRectViewport, mVisibleContentRect, getScale(), extras);
                ((HardwareCanvas) canvas).callDrawGLFunction(functor);
                {
                    boolean varB9C4161DF2F7ECD45BDF12D53A873278_1286130547 = (mHardwareAccelSkia != getSettings().getHardwareAccelSkiaEnabled());
                    {
                        mHardwareAccelSkia = getSettings().getHardwareAccelSkiaEnabled();
                        nativeUseHardwareAccelSkia(mHardwareAccelSkia);
                    } 
                } 
            } 
            {
                DrawFilter df = null;
                {
                    boolean varDFCE6862E0CA36047A4C3134A0AB6043_54746173 = (mZoomManager.isZoomAnimating() || UIAnimationsRunning);
                    {
                        df = mZoomFilter;
                    } 
                    {
                        df = mScrollFilter;
                    } 
                } 
                canvas.setDrawFilter(df);
                int content = nativeDraw(canvas, mVisibleContentRect, color,
                    extras, false);
                canvas.setDrawFilter(null);
                {
                    mWebViewCore.sendMessage(EventHub.SPLIT_PICTURE_SET, content, 0);
                } 
            } 
        } 
        canvas.restoreToCount(saveCount);
        {
            drawTextSelectionHandles(canvas);
        } 
        {
            {
                mTouchMode = TOUCH_SHORTPRESS_MODE;
            } 
        } 
        {
            mFocusSizeChanged = false;
            {
                boolean varF6566AA8A24398D5119084D846E17436_516865844 = (!canvas.isHardwareAccelerated() && !animateZoom && inEditingMode());
                {
                    didUpdateWebTextViewDimensions(ANYWHERE);
                } 
            } 
        } 
        addTaint(canvas.getTaint());
        addTaint(color);
        addTaint(drawCursorRing);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.195 -0400", hash_original_method = "84F642247187E7F65AD5E0661D3002C2", hash_generated_method = "6A19A5675CF31176516A5DF9062AC72C")
    private void drawTextSelectionHandles(Canvas canvas) {
        {
            mTextSelectionPaint = new Paint();
            mTextSelectionPaint.setColor(HIGHLIGHT_COLOR);
        } 
        mTextSelectionRegion.setEmpty();
        nativeGetTextSelectionRegion(mNativeClass, mTextSelectionRegion);
        Rect r = new Rect();
        RegionIterator iter = new RegionIterator(mTextSelectionRegion);
        Rect clip = canvas.getClipBounds();
        {
            boolean varE3C5F3369D1CDF36597C49DAB102029E_1188717827 = (iter.next(r));
            {
                r.set(contentToViewDimension(r.left),
                    contentToViewDimension(r.top),
                    contentToViewDimension(r.right),
                    contentToViewDimension(r.bottom));
                {
                    boolean var6DFFCCE966800787D5E5EFDDEDE35151_2001786709 = (r.intersect(clip));
                    {
                        canvas.drawRect(r, mTextSelectionPaint);
                    } 
                } 
            } 
        } 
        {
            mSelectHandleLeft = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_left);
        } 
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
        {
            mSelectHandleRight = mContext.getResources().getDrawable(
                    com.android.internal.R.drawable.text_select_handle_right);
        } 
        end_x -= mSelectHandleRight.getIntrinsicWidth() / 4;
        mSelectHandleRight.setBounds(end_x, end_y,
                end_x + mSelectHandleRight.getIntrinsicWidth(),
                end_y + mSelectHandleRight.getIntrinsicHeight());
        {
            mSelectHandleLeft.setAlpha(125);
            mSelectHandleRight.setAlpha(125);
        } 
        mSelectHandleLeft.draw(canvas);
        mSelectHandleRight.draw(canvas);
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.196 -0400", hash_original_method = "079D561B903F747D50B5A79B1ECD14A7", hash_generated_method = "F513A52672CB1E550463E4D37F381A27")
     boolean drawHistory() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823551315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_823551315;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.196 -0400", hash_original_method = "03914C35D57FCC88F6BB8A1539696293", hash_generated_method = "05E0AA476F31092A23AB57D41422D9DB")
     int getHistoryPictureWidth() {
        {
            Object var5C92612DE9888EAC00CA7C21ECDC0B5E_1545242793 = (mHistoryPicture.getWidth());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491452822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1491452822;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.197 -0400", hash_original_method = "7335367FF0BA609D40F9DF844F4A133D", hash_generated_method = "CB1BDF46C513DF6931177B129A81CE1F")
     void switchOutDrawHistory() {
        {
            boolean var4213A82FBAD6D3C76E09EE9714EFE36E_1085084825 = (mDrawHistory && (getProgress() == 100 || nativeHasContent()));
            {
                mDrawHistory = false;
                mHistoryPicture = null;
                invalidate();
                int oldScrollX = mScrollX;
                int oldScrollY = mScrollY;
                mScrollX = pinLocX(mScrollX);
                mScrollY = pinLocY(mScrollY);
                {
                    onScrollChanged(mScrollX, mScrollY, oldScrollX, oldScrollY);
                } 
                {
                    sendOurVisibleRect();
                } 
            } 
        } 
        
        
        
            
            
            
            
            
            
            
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.199 -0400", hash_original_method = "C39AA31A6BA8457E4DE9A390830947C7", hash_generated_method = "CE6490B7CAD5B5F6FD30D77F4A974112")
     WebViewCore.CursorData cursorData() {
        WebViewCore.CursorData varB4EAC82CA7396A68D541C85D26508E83_30452665 = null; 
        WebViewCore.CursorData result = cursorDataNoPosition();
        Point position = nativeCursorPosition();
        result.mX = position.x;
        result.mY = position.y;
        varB4EAC82CA7396A68D541C85D26508E83_30452665 = result;
        varB4EAC82CA7396A68D541C85D26508E83_30452665.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_30452665;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.199 -0400", hash_original_method = "A984EE77267D92EBC297A83944E36AE0", hash_generated_method = "664A40409CD5BEA2CFF82743CD4C872B")
     WebViewCore.CursorData cursorDataNoPosition() {
        WebViewCore.CursorData varB4EAC82CA7396A68D541C85D26508E83_1115379988 = null; 
        WebViewCore.CursorData result = new WebViewCore.CursorData();
        result.mMoveGeneration = nativeMoveGeneration();
        result.mFrame = nativeCursorFramePointer();
        varB4EAC82CA7396A68D541C85D26508E83_1115379988 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1115379988.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1115379988;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.199 -0400", hash_original_method = "7E748FE119FB7A0AE13E567E94DF9EED", hash_generated_method = "D14B4D4826ABDCCF2FB38E7C9F2B3E4B")
     void deleteSelection(int start, int end) {
        WebViewCore.TextSelectionData data = new WebViewCore.TextSelectionData(start, end);
        mWebViewCore.sendMessage(EventHub.DELETE_SELECTION, mTextGeneration, 0,
                data);
        addTaint(start);
        addTaint(end);
        
        
        
                
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.200 -0400", hash_original_method = "894990055202EB09B0889C114864FFFB", hash_generated_method = "91B7B763D0AA43085D3C084297DA933B")
     void setSelection(int start, int end) {
        {
            mWebViewCore.sendMessage(EventHub.SET_SELECTION, start, end);
        } 
        addTaint(start);
        addTaint(end);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.200 -0400", hash_original_method = "B8CB424E6752CDBFC65482B92F3C8AF0", hash_generated_method = "AEA82FCE7F7F7C1631932CA20748FA31")
    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_786888004 = null; 
        InputConnection connection = super.onCreateInputConnection(outAttrs);
        outAttrs.imeOptions |= EditorInfo.IME_FLAG_NO_FULLSCREEN;
        varB4EAC82CA7396A68D541C85D26508E83_786888004 = connection;
        addTaint(outAttrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_786888004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_786888004;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.201 -0400", hash_original_method = "35FF71ED3364FC4ED9901C133D6E0D9F", hash_generated_method = "8AAD900C22EFB1784EE1F29DCCEBD21C")
    private void displaySoftKeyboard(boolean isTextView) {
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean zoom = mZoomManager.getScale() < mZoomManager.getDefaultScale();
        {
            mZoomManager.setZoomCenter(mLastTouchX, mLastTouchY);
            mZoomManager.setZoomScale(mZoomManager.getDefaultScale(), false);
        } 
        {
            rebuildWebTextView();
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_1774126036 = (inEditingMode());
                {
                    imm.showSoftInput(mWebTextView, 0, mWebTextView.getResultReceiver());
                    {
                        didUpdateWebTextViewDimensions(INTERSECTS_SCREEN);
                    } 
                } 
            } 
        } 
        imm.showSoftInput(this, 0);
        addTaint(isTextView);
        
        
                
        
        
            
            
        
        
            
            
                
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.201 -0400", hash_original_method = "F8A091E3601665AC035538CDDA7ED67D", hash_generated_method = "8688C53ECC6FEC79A7C1D18BABD8759B")
    private void hideSoftKeyboard() {
        InputMethodManager imm = InputMethodManager.peekInstance();
        {
            boolean var1C65995F61E387B4C34088A3BF18BF15_617651928 = (imm != null && (imm.isActive(this)
                || (inEditingMode() && imm.isActive(mWebTextView))));
            {
                imm.hideSoftInputFromWindow(this.getWindowToken(), 0);
            } 
        } 
        
        
        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.202 -0400", hash_original_method = "6D8514504292131ECC7954334CE4F306", hash_generated_method = "CC8838B8956DA1A336FFE1EBADA9733E")
     void rebuildWebTextView() {
        {
            boolean varD65E3F1F95872BCE9675FDBCB6E52A34_1026514184 = (!hasFocus() && (null == mWebTextView || !mWebTextView.hasFocus()));
        } 
        boolean alreadyThere = inEditingMode();
        {
            boolean var7605F9B50D3E6B1FCD1B43262B1DB86A_1945377177 = (0 == mNativeClass || !nativeFocusCandidateIsTextInput());
            {
                {
                    mWebTextView.remove();
                } 
            } 
        } 
        {
            mWebTextView = new WebTextView(mContext, WebView.this, mAutoFillData.getQueryId());
            mTextGeneration = 0;
        } 
        mWebTextView.updateTextSize();
        updateWebTextViewPosition();
        String text = nativeFocusCandidateText();
        int nodePointer = nativeFocusCandidatePointer();
        mWebTextView.setNodePointer(nodePointer);
        mWebTextView.setType(nativeFocusCandidateType());
        mWebTextView.setGravityForRtl(nativeFocusCandidateIsRtlText());
        {
            text = "";
        } 
        mWebTextView.setTextAndKeepSelection(text);
        InputMethodManager imm = InputMethodManager.peekInstance();
        {
            boolean varBCF51FD17B0A78CB3F43132D03F914EA_447223439 = (imm != null && imm.isActive(mWebTextView));
            {
                imm.restartInput(mWebTextView);
                mWebTextView.clearComposingText();
            } 
        } 
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1084535377 = (isFocused());
            {
                mWebTextView.requestFocus();
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.202 -0400", hash_original_method = "28AA7EC59D0CFC92CB83B5BA433F7135", hash_generated_method = "C96CDD7C8E2F5D095C896239683F2817")
    private void updateWebTextViewPosition() {
        Rect visibleRect = new Rect();
        calcOurContentVisibleRect(visibleRect);
        Rect bounds = nativeFocusCandidateNodeBounds();
        Rect vBox = contentToViewRect(bounds);
        offsetByLayerScrollPosition(vBox);
        mWebTextView.setRect(vBox.left, vBox.top, vBox.width(), vBox.height());
        {
            boolean var5F1F7DC9987FB452C0CD065A1A522578_1326896535 = (!Rect.intersects(bounds, visibleRect));
            {
                revealSelection();
            } 
        } 
        updateWebTextViewPadding();
        
        
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.203 -0400", hash_original_method = "D2A7E839F1E8013BBB62CFB32702DC75", hash_generated_method = "38E7F29DA438793303D551920FC0FBDB")
     void updateWebTextViewPadding() {
        Rect paddingRect = nativeFocusCandidatePaddingRect();
        {
            mWebTextView.setPadding(
                    contentToViewDimension(paddingRect.left),
                    contentToViewDimension(paddingRect.top),
                    contentToViewDimension(paddingRect.right),
                    contentToViewDimension(paddingRect.bottom));
        } 
        
        
        
            
                    
                    
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.203 -0400", hash_original_method = "75BA4FD21197C06422E03F26B8B18909", hash_generated_method = "C79360889439696E82BC1DD990D797CB")
     void revealSelection() {
        {
            mWebViewCore.sendMessage(EventHub.REVEAL_SELECTION);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.203 -0400", hash_original_method = "276F36A490F8AABA2644120A754BA7BF", hash_generated_method = "EC25B5CBC7A2649D70F2F11065A5A273")
     void requestFormData(String name, int nodePointer,
            boolean autoFillable, boolean autoComplete) {
        {
            boolean varF44B622654F1EDE6833649178C55B74F_932198477 = (mWebViewCore.getSettings().getSaveFormData());
            {
                Message update = mPrivateHandler.obtainMessage(REQUEST_FORM_DATA);
                update.arg1 = nodePointer;
                RequestFormData updater = new RequestFormData(name, getUrl(),
                    update, autoFillable, autoComplete);
                Thread t = new Thread(updater);
                t.start();
            } 
        } 
        addTaint(name.getTaint());
        addTaint(nodePointer);
        addTaint(autoFillable);
        addTaint(autoComplete);
        
        
            
            
            
                    
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.203 -0400", hash_original_method = "91B9F6932FB01733CE18E8B916887FAE", hash_generated_method = "4E406C36A9EFE6FCE6CD5643E5552132")
     void requestLabel(int framePointer, int nodePointer) {
        mWebViewCore.sendMessage(EventHub.REQUEST_LABEL, framePointer,
                nodePointer);
        addTaint(framePointer);
        addTaint(nodePointer);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.204 -0400", hash_original_method = "7F39E56A7BC2D02DC2DB6CE203AFE9D8", hash_generated_method = "095BD32945AB1C2E270DEA25ED8552A3")
    public void dumpDisplayTree() {
        nativeDumpDisplayTree(getUrl());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.204 -0400", hash_original_method = "BC129AB1D77AD49F25DDF2E06EF6AA32", hash_generated_method = "C493561456B7E508A662A631D1007010")
    public void dumpDomTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_DOMTREE, toFile ? 1 : 0, 0);
        addTaint(toFile);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.204 -0400", hash_original_method = "0623AB400C9EBCFBF28E030B28B0F81B", hash_generated_method = "A26D8E7753BF05537B07532849ADBB9D")
    public void dumpRenderTree(boolean toFile) {
        mWebViewCore.sendMessage(EventHub.DUMP_RENDERTREE, toFile ? 1 : 0, 0);
        addTaint(toFile);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.205 -0400", hash_original_method = "3DB0DADC92374DC10778E60C87786EFD", hash_generated_method = "5A01FAE035DC9B2B19C3CFCD95128CE9")
    public void useMockDeviceOrientation() {
        mWebViewCore.sendMessage(EventHub.USE_MOCK_DEVICE_ORIENTATION);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.205 -0400", hash_original_method = "5AB0DE0D4529F872E2FC6E29539F7BEB", hash_generated_method = "39F9B2BF9F6D95390C669F91AF6E2339")
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
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.205 -0400", hash_original_method = "6E90BAFCBD427E00C5425E554C19CD44", hash_generated_method = "AD73DDA9DEE4DBACADAAC65BAB256F86")
    public void dumpV8Counters() {
        mWebViewCore.sendMessage(EventHub.DUMP_V8COUNTERS);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.206 -0400", hash_original_method = "0AE890042DF6DCC9BC247C89484B6A70", hash_generated_method = "A177D34D58948BE0C067105BDA60868C")
    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        {
            boolean var858C72F44AB8CD41BC0BE3BD37D47DCB_1814297850 = (keyCode == KeyEvent.KEYCODE_UNKNOWN && event.getCharacters() != null);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } 
        } 
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073953294 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073953294;
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.206 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "F0AD0DD9D019471AD6C4EFC6041C70B7")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584430128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584430128;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.208 -0400", hash_original_method = "C4CB11A0D6E4EE15235D7023465A85CF", hash_generated_method = "4F21353EA4E25776940054F7D7E0F850")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        {
            boolean var057857A71DAAF22FA381D228F5183695_2118778568 = (event.isCtrlPressed());
        } 
        {
            mAutoRedraw = !mAutoRedraw;
            {
                invalidate();
            } 
        } 
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_1524222709 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } 
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_1072109249 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1776654752 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
                    } 
                    {
                        mAccessibilityScriptInjected = false;
                    } 
                } 
            } 
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_899050293 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_48568023 = (mAccessibilityInjector.onKeyEvent(event));
                        } 
                    } 
                    {
                        mAccessibilityInjector = null;
                    } 
                } 
            } 
        } 
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_2085201346 = (event.hasNoModifiers());
                {
                    pageUp(false);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_887036438 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageUp(true);
                    } 
                } 
            } 
        } 
        {
            {
                boolean var01265F35364458CD2A88FFB15C2C1B92_838464412 = (event.hasNoModifiers());
                {
                    pageDown(false);
                } 
                {
                    boolean varAB36CD08CFCE6244F546B808D5F456D4_824420853 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                    {
                        pageDown(true);
                    } 
                } 
            } 
        } 
        {
            boolean var4D7637BE3E5BB8DFB8BE9F5DEBBD0190_1840569169 = (keyCode == KeyEvent.KEYCODE_MOVE_HOME && event.hasNoModifiers());
            {
                pageUp(true);
            } 
        } 
        {
            boolean varCDA174DB103BE1133CABA578513ECF4C_492700550 = (keyCode == KeyEvent.KEYCODE_MOVE_END && event.hasNoModifiers());
            {
                pageDown(true);
            } 
        } 
        {
            switchOutDrawHistory();
            {
                boolean var5EC168B85D610989E99D878E0C758737_816212123 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), true, event.getMetaState());
                } 
            } 
            {
                boolean varAC7A24F7600680817ED76B813249DD81_1749120993 = (event.hasModifiers(KeyEvent.META_ALT_ON));
                {
                    
                    pageUp(true);
                    
                    
                    pageDown(true);
                    
                    
                    nativeClearCursor();
                    
                    
                    boolean var563F44E657D7D016C02306EF7D73B63C_1013350932 = (pinScrollTo(0, mScrollY, true, 0));
                    
                    
                    nativeClearCursor();
                    
                    
                    boolean var05C6B866B6258D11272BBA227622E49C_328485817 = (pinScrollTo(mContentWidth, mScrollY, true, 0));
                    
                } 
            } 
            {
                int xRate;
                xRate = 1;
                xRate = 0;
                int yRate;
                yRate = 1;
                yRate = 0;
                int multiplier = event.getRepeatCount() + 1;
                moveSelection(xRate * multiplier, yRate * multiplier);
            } 
            {
                boolean varECFDC30B9B17E54572F391464D24DDCA_108197937 = (navHandledKey(keyCode, 1, false, event.getEventTime()));
                {
                    playSoundEffect(keyCodeToSoundsEffect(keyCode));
                } 
            } 
        } 
        {
            switchOutDrawHistory();
            boolean wantsKeyEvents = nativeCursorNodePointer() == 0
                || nativeCursorWantsKeyEvents();
            {
                boolean var1C3F6BC8881ADE70AD0B6D90845DAEAD_165335925 = (event.getRepeatCount() == 0);
                {
                    mGotCenterDown = true;
                    mPrivateHandler.sendMessageDelayed(mPrivateHandler
                        .obtainMessage(LONG_PRESS_CENTER), LONG_PRESS_TIMEOUT);
                } 
            } 
        } 
        {
            boolean var887BE5E0D671A1E9580BF5C98186B06D_583056535 = (getSettings().getNavDump());
            {
                
                dumpDisplayTree();
                
                
                dumpDomTree(keyCode == KeyEvent.KEYCODE_5);
                
                
                dumpRenderTree(keyCode == KeyEvent.KEYCODE_7);
                
                
                nativeInstrumentReport();
                
            } 
        } 
        {
            boolean varFBB0B09776F969247DB212E1762B7005_1099941368 = (nativeCursorIsTextInput());
            {
                mWebViewCore.sendMessage(EventHub.FAKE_CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
                rebuildWebTextView();
                {
                    boolean var91CFAA6DBB8ACD778F334172661A353F_336706028 = (inEditingMode());
                    {
                        mWebTextView.setDefaultSelection();
                        boolean var0E01D6F0C9B3C4661498B390117F08D9_431095827 = (mWebTextView.dispatchKeyEvent(event));
                    } 
                } 
            } 
            {
                boolean var4BF8F7F944B1F59AAF473CC034212BAF_505812688 = (nativeHasFocusNode());
                {
                    rebuildWebTextView();
                    {
                        boolean varCC7B651C81D6575D905B32AE4D2DE9FF_652758697 = (inEditingMode());
                        {
                            mWebTextView.setDefaultSelection();
                            boolean var94D478091AA1B30B7403F71D4EA231CE_2067102244 = (mWebTextView.dispatchKeyEvent(event));
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_538274927 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_DOWN, event);
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369146629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369146629;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.210 -0400", hash_original_method = "64393B626C93173F66EDDE91781ECC7E", hash_generated_method = "694CCD3DD88A7819E6265950FD9996EF")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        {
            boolean varFB3D894E81BEF45C7836AA612BE5CF4E_190825746 = (keyCode == KeyEvent.KEYCODE_CALL && nativeHasCursorNode());
            {
                String text = nativeCursorText();
                {
                    boolean var0730AC3C43F6F231E2E36B9DE5B4A786_294202818 = (!nativeCursorIsTextInput() && text != null
                    && text.startsWith(SCHEME_TEL));
                    {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(text));
                        getContext().startActivity(intent);
                    } 
                } 
            } 
        } 
        {
            boolean var418B2724488F40E407E2D4BA258E6AE2_400219967 = (event.isSystem()
                || mCallbackProxy.uiOverrideKeyEvent(event));
        } 
        {
            boolean var3BE26FC96DB7CC9256AE59FD11B8D37F_1506725983 = (accessibilityScriptInjected());
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1767317993 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        mWebViewCore.sendMessage(EventHub.KEY_UP, event);
                    } 
                    {
                        mAccessibilityScriptInjected = false;
                    } 
                } 
            } 
            {
                {
                    boolean var32F79E636ABE2CC743BABA6B1971036F_1420289365 = (AccessibilityManager.getInstance(mContext).isEnabled());
                    {
                        {
                            boolean varF5E342B5F1F37AD0D35FEF217CDDF732_280710773 = (mAccessibilityInjector.onKeyEvent(event));
                        } 
                    } 
                    {
                        mAccessibilityInjector = null;
                    } 
                } 
            } 
        } 
        {
            {
                boolean var5EC168B85D610989E99D878E0C758737_2118924434 = (nativePageShouldHandleShiftAndArrows());
                {
                    letPageHandleNavKey(keyCode, event.getEventTime(), false, event.getMetaState());
                } 
            } 
        } 
        {
            boolean varF2C062DAF4D50BEAFF0E218848138E20_1398487477 = (isEnterActionKey(keyCode));
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mGotCenterDown = false;
                {
                    {
                        copySelection();
                        selectionDone();
                    } 
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } 
                } 
                Rect visibleRect = sendOurVisibleRect();
                {
                    boolean var1C0F8D4E9F76762BB9ABC943F1506101_94572478 = (!nativeCursorIntersects(visibleRect));
                } 
                WebViewCore.CursorData data = cursorData();
                mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
                playSoundEffect(SoundEffectConstants.CLICK);
                {
                    boolean var42403AA5DE61CBA02330C9C817D2DC22_1840960483 = (nativeCursorIsTextInput());
                    {
                        rebuildWebTextView();
                        centerKeyPressOnTextField();
                        {
                            boolean varDB1B9C12ED48DAB084977319495C514C_971996683 = (inEditingMode());
                            {
                                mWebTextView.setDefaultSelection();
                            } 
                        } 
                    } 
                } 
                clearTextEntry();
                nativeShowCursorTimed();
                {
                    boolean var34E3725E8E3257788672BB9D0420AAC0_2087172445 = (mCallbackProxy.uiOverrideUrlLoading(nativeCursorText()));
                } 
                {
                    boolean var2B73408B18669E3ED44DEC84F3F8FE87_729291125 = (nativeCursorNodePointer() != 0 && !nativeCursorWantsKeyEvents());
                    {
                        mWebViewCore.sendMessage(EventHub.CLICK, data.mFrame,
                        nativeCursorNodePointer());
                    } 
                } 
            } 
        } 
        {
            boolean varADCBAC66F6FA9B5781277EF260313BDF_1785116147 = (nativeCursorWantsKeyEvents() || true);
            {
                mWebViewCore.sendMessage(EventHub.KEY_UP, event);
            } 
        } 
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364420683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_364420683;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.211 -0400", hash_original_method = "1094CDA57E7CD3D29BED0080B255608D", hash_generated_method = "0C8A12420FA180EC39BFDEFAE94A4EF7")
    private boolean setUpSelect(boolean selectWord, int x, int y) {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_2027985237 = (inFullScreenMode());
        } 
        nativeResetSelection();
        {
            boolean var5D0F3C45A3AF9494DFD7437F551FA15B_1001047455 = (selectWord && !nativeWordSelection(x, y));
            {
                selectionDone();
            } 
        } 
        mSelectCallback = new SelectActionModeCallback();
        mSelectCallback.setWebView(this);
        {
            boolean varB8A3B697E17C784F74A8FDA17CF85863_1349063863 = (startActionMode(mSelectCallback) == null);
            {
                selectionDone();
            } 
        } 
        mExtendSelection = false;
        mSelectingText = mDrawSelectionPointer = true;
        {
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        } 
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        {
            boolean var5225ACD2E56334E54962D68427F36819_1150958491 = (nativeHasCursorNode());
            {
                Rect rect = nativeCursorNodeBounds();
                mSelectX = contentToViewX(rect.left);
                mSelectY = contentToViewY(rect.top);
            } 
            {
                boolean varBE337274F3E43C04FF66B457B0EF7AE1_1605510775 = (mLastTouchY > getVisibleTitleHeightImpl());
                {
                    mSelectX = mScrollX + mLastTouchX;
                    mSelectY = mScrollY + mLastTouchY;
                } 
                {
                    mSelectX = mScrollX + getViewWidth() / 2;
                    mSelectY = mScrollY + getViewHeightWithTitle() / 2;
                } 
            } 
        } 
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
            } 
            {
                mMinAutoScrollY = Math.max(mMinAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.top));
                mMaxAutoScrollY = Math.min(mMaxAutoScrollY,
                        contentToViewY(mScrollingLayerBounds.bottom));
            } 
        } 
        mMinAutoScrollX += SELECT_SCROLL;
        mMaxAutoScrollX -= SELECT_SCROLL;
        mMinAutoScrollY += SELECT_SCROLL;
        mMaxAutoScrollY -= SELECT_SCROLL;
        addTaint(selectWord);
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780630638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780630638;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.212 -0400", hash_original_method = "10EA3DD38A8D8F7C4FB5485E67E838FA", hash_generated_method = "397EF000EB5841A9556B40D05B9E7E33")
    @Deprecated
    public void emulateShiftHeld() {
        checkThread();
        setUpSelect(false, 0, 0);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.212 -0400", hash_original_method = "D2254062ADB30DEB5D8F45E2460A23C1", hash_generated_method = "D148C393D61214BBF9E0BC915F7EC0AF")
    public void selectAll() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_201678652 = (inFullScreenMode());
        } 
        {
            Point select = nativeSelectableText();
            {
                boolean varAEB90306D9A88D63001E6EB8A442969D_1032362072 = (!selectText(select.x, select.y));
            } 
        } 
        nativeSelectAll();
        mDrawSelectionPointer = false;
        mExtendSelection = true;
        invalidate();
        
        
        
        
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.212 -0400", hash_original_method = "FDD46B52078C43ED31EADC8D71AB7E57", hash_generated_method = "52C98EE1C4524A42D0A6137208BBFA56")
     void selectionDone() {
        {
            mSelectingText = false;
            {
                setLayerType(LAYER_TYPE_NONE, null);
            } 
            mSelectCallback.finish();
            mSelectCallback = null;
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            invalidate();
            mAutoScrollX = 0;
            mAutoScrollY = 0;
            mSentAutoScrollMessage = false;
        } 
        
        
            
            
                
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.213 -0400", hash_original_method = "DC0265742DAD8EA1ACC283442CB78016", hash_generated_method = "ABF7B17B04AEBBF0F77F0A9431F4A7C1")
    public boolean copySelection() {
        boolean copiedSomething = false;
        String selection = getSelection();
        {
            Toast.makeText(mContext
                    , com.android.internal.R.string.text_copied
                    , Toast.LENGTH_SHORT).show();
            copiedSomething = true;
            ClipboardManager cm = (ClipboardManager)getContext()
                    .getSystemService(Context.CLIPBOARD_SERVICE);
            cm.setText(selection);
        } 
        invalidate();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166764209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166764209;
        
        
        
        
            
                
            
            
                    
                    
            
            
                    
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.214 -0400", hash_original_method = "42C460FC98EE957E1B7569B278C0F15C", hash_generated_method = "13BDEA6A884103C80DD6E45A3E107F23")
    public SearchBox getSearchBox() {
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_601587404 = null; 
        SearchBox varB4EAC82CA7396A68D541C85D26508E83_1827824394 = null; 
        {
            boolean var575F4597422E60100014A3F178C01D0F_990929828 = ((mWebViewCore == null) || (mWebViewCore.getBrowserFrame() == null));
            {
                varB4EAC82CA7396A68D541C85D26508E83_601587404 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1827824394 = mWebViewCore.getBrowserFrame().getSearchBox();
        SearchBox varA7E53CE21691AB073D9660D615818899_1503437201; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1503437201 = varB4EAC82CA7396A68D541C85D26508E83_601587404;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1503437201 = varB4EAC82CA7396A68D541C85D26508E83_1827824394;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1503437201.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1503437201;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.214 -0400", hash_original_method = "A676AD565525EE3D82CB063563895008", hash_generated_method = "671314791BC40F9DEEBBC91DDB3C52DF")
     String getSelection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1091903973 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_832570816 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1091903973 = "";
        varB4EAC82CA7396A68D541C85D26508E83_832570816 = nativeGetSelection();
        String varA7E53CE21691AB073D9660D615818899_1152879486; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1152879486 = varB4EAC82CA7396A68D541C85D26508E83_1091903973;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1152879486 = varB4EAC82CA7396A68D541C85D26508E83_832570816;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1152879486.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1152879486;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.215 -0400", hash_original_method = "0F7A2D956AFF32B8C983C9EE90417286", hash_generated_method = "F7596C9F1C935B61C9608ECFC9A21F61")
    @Override
    protected void onAttachedToWindow() {
        
        super.onAttachedToWindow();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_1931621803 = (hasWindowFocus());
            setActive(true);
        } 
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        {
            mGlobalLayoutListener = new InnerGlobalLayoutListener();
            treeObserver.addOnGlobalLayoutListener(mGlobalLayoutListener);
        } 
        {
            mScrollChangedListener = new InnerScrollChangedListener();
            treeObserver.addOnScrollChangedListener(mScrollChangedListener);
        } 
        addAccessibilityApisToJavaScript();
        mTouchEventQueue.reset();
        
        
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.215 -0400", hash_original_method = "6AF9BAC713EAF420417C9DD3E95BAD84", hash_generated_method = "1FB18883EEA64EABDFA4CDF65FB3B70A")
    @Override
    protected void onDetachedFromWindow() {
        
        clearHelpers();
        mZoomManager.dismissZoomPicker();
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_930271753 = (hasWindowFocus());
            setActive(false);
        } 
        final ViewTreeObserver treeObserver = getViewTreeObserver();
        {
            treeObserver.removeGlobalOnLayoutListener(mGlobalLayoutListener);
            mGlobalLayoutListener = null;
        } 
        {
            treeObserver.removeOnScrollChangedListener(mScrollChangedListener);
            mScrollChangedListener = null;
        } 
        removeAccessibilityApisFromJavaScript();
        super.onDetachedFromWindow();
        
        
        
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.216 -0400", hash_original_method = "371011809B792FC8D4394C397E7E010A", hash_generated_method = "ED1A1C337A69915E6C6C26CE222A7D32")
    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        
        super.onVisibilityChanged(changedView, visibility);
        {
            mZoomManager.dismissZoomPicker();
        } 
        updateDrawingState();
        addTaint(changedView.getTaint());
        addTaint(visibility);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.216 -0400", hash_original_method = "1F5E023ED4B943F886020EF0C3C728C0", hash_generated_method = "B273FE7D61E13E6CE45FEB7014C0E93B")
    @Deprecated
    public void onChildViewAdded(View parent, View child) {
        
        addTaint(parent.getTaint());
        addTaint(child.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.217 -0400", hash_original_method = "A1852453035469FD96D226C7DED2259E", hash_generated_method = "C170B29F38EB702918070B8FAF483BB6")
    @Deprecated
    public void onChildViewRemoved(View p, View child) {
        
        addTaint(p.getTaint());
        addTaint(child.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.217 -0400", hash_original_method = "41543FFF07459A3CC35AF53F19C64652", hash_generated_method = "03699C1B0285E84E7176C9EC92F4A5C1")
    @Deprecated
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        
        addTaint(oldFocus.getTaint());
        addTaint(newFocus.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.218 -0400", hash_original_method = "D747B199CC4AE0DD8D876C9BFFAB17AF", hash_generated_method = "ED32B82071B7AD5DF2009E2C7D22A831")
     void setActive(boolean active) {
        {
            {
                boolean varC68F8DA53A6E7AE533DF2B6E0273984A_846526114 = (hasFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } 
                {
                    mDrawCursorRing = false;
                    {
                        boolean var82DF510B98047A24212E03E202533075_285504146 = (!inEditingMode());
                        {
                            setFocusControllerActive(false);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                boolean varB5F2F3BA6162A40E6EBD61229A1DF48F_2044470054 = (!mZoomManager.isZoomPickerVisible());
                {
                    mDrawCursorRing = false;
                } 
            } 
            mKeysPressed.clear();
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            mTouchMode = TOUCH_DONE_MODE;
            setFocusControllerActive(false);
        } 
        invalidate();
        addTaint(active);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.219 -0400", hash_original_method = "41ADC5D401D396C45811340AC3A1CFB7", hash_generated_method = "A6D90FC0DBB9B2F6415FE9714B5C5EAB")
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        setActive(hasWindowFocus);
        {
            JWebCoreJavaBridge.setActiveWebView(this);
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                mPictureUpdatePausedForFocusChange = false;
            } 
        } 
        {
            JWebCoreJavaBridge.removeActiveWebView(this);
            final WebSettings settings = getSettings();
            {
                boolean var1D74215CA3033399C095EF1282AE5BE7_323830129 = (settings != null && settings.enableSmoothTransition() &&
                    mWebViewCore != null && !WebViewCore.isUpdatePicturePaused(mWebViewCore));
                {
                    WebViewCore.pauseUpdatePicture(mWebViewCore);
                    mPictureUpdatePausedForFocusChange = true;
                } 
            } 
        } 
        super.onWindowFocusChanged(hasWindowFocus);
        addTaint(hasWindowFocus);
        
        
        
            
            
                
                
            
        
            
            
            
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.220 -0400", hash_original_method = "CA7A099877867493E27DC28FFE79DAAD", hash_generated_method = "A1384AD20E5374D9BEF18AEB73755D7C")
     void setFocusControllerActive(boolean active) {
        mWebViewCore.sendMessage(EventHub.SET_ACTIVE, active ? 1 : 0, 0);
        {
            mWebViewCore.sendMessage(mListBoxMessage);
            mListBoxMessage = null;
        } 
        addTaint(active);
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.220 -0400", hash_original_method = "9FF117E3AF871F35C872419F81A40955", hash_generated_method = "82C1B8BE8C302EB5E13267C0C212F40B")
    @Override
    protected void onFocusChanged(boolean focused, int direction,
            Rect previouslyFocusedRect) {
        
        {
            {
                boolean var7FF7C69BF2546C1B46A75E34BBC40609_1686746438 = (hasWindowFocus());
                {
                    mDrawCursorRing = !inEditingMode();
                    setFocusControllerActive(true);
                } 
            } 
        } 
        {
            mDrawCursorRing = false;
            {
                boolean varD52AFE2B2A5DD9C2C2CA64ADDFB71D04_868985961 = (!inEditingMode());
                {
                    setFocusControllerActive(false);
                } 
            } 
            mKeysPressed.clear();
        } 
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        addTaint(focused);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
            
        
        
            
                
                
            
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.221 -0400", hash_original_method = "043C8177EBF75417F2794C71F1056B0D", hash_generated_method = "EECD1EC47A943F868AFF182408D045FA")
     void setGLRectViewport() {
        boolean visible = getGlobalVisibleRect(mGLRectViewport);
        {
            View rootView = getRootView();
            int rootViewHeight = rootView.getHeight();
            mViewRectViewport.set(mGLRectViewport);
            int savedWebViewBottom = mGLRectViewport.bottom;
            mGLRectViewport.bottom = rootViewHeight - mGLRectViewport.top - getVisibleTitleHeightImpl();
            mGLRectViewport.top = rootViewHeight - savedWebViewBottom;
            mGLViewportEmpty = false;
        } 
        {
            mGLViewportEmpty = true;
        } 
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeUpdateDrawGLFunction(mGLViewportEmpty ? null : mGLRectViewport,
                mGLViewportEmpty ? null : mViewRectViewport, mVisibleContentRect);
        
        
        
            
            
            
            
            
            
            
        
            
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.221 -0400", hash_original_method = "DC0F97319FBB396763626C12AC61DD09", hash_generated_method = "6F8D4326EFCED4D263799ADEF13F771A")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed = super.setFrame(left, top, right, bottom);
        {
            sendViewSizeZoom(false);
        } 
        setGLRectViewport();
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1266913532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1266913532;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.221 -0400", hash_original_method = "CF3FF8B5BD5D2F01947052917B339811", hash_generated_method = "26757D6D1D6C51D7FEA34E95D372E7EA")
    @Override
    protected void onSizeChanged(int w, int h, int ow, int oh) {
        
        super.onSizeChanged(w, h, ow, oh);
        int newMaxViewportWidth = (int) (Math.max(w, h) / mZoomManager.getDefaultMinZoomScale());
        {
            sMaxViewportWidth = newMaxViewportWidth;
        } 
        mZoomManager.onSizeChanged(w, h, ow, oh);
        {
            setNewPicture(mLoadedPicture, false);
        } 
        addTaint(w);
        addTaint(h);
        addTaint(ow);
        addTaint(oh);
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.222 -0400", hash_original_method = "0CEF3ADF8A81283D4C4955ED8FEB1A86", hash_generated_method = "04DF6DC1844BC08724E2D2C396590E0E")
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        
        super.onScrollChanged(l, t, oldl, oldt);
        {
            sendOurVisibleRect();
            int titleHeight = getTitleHeight();
            {
                boolean varB4D4A6A79DEACE1E888BD156FFAF1F5C_1561667227 = (Math.max(titleHeight - t, 0) != Math.max(titleHeight - oldt, 0));
                {
                    sendViewSizeZoom(false);
                } 
            } 
        } 
        addTaint(l);
        addTaint(t);
        addTaint(oldl);
        addTaint(oldt);
        
        
        
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.222 -0400", hash_original_method = "49826ABE0ED23F6056684562F9F9C220", hash_generated_method = "6BCF71A5F64697FC3C38F6DD6F3CC8C7")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            Object var9E1FBD251DF7E53AB77C3A31F15B2B38_1137365596 = (event.getAction());
            
            mKeysPressed.add(Integer.valueOf(event.getKeyCode()));
            
            
            int location = mKeysPressed.indexOf(Integer.valueOf(event.getKeyCode()));
            
            
            {
                mKeysPressed.remove(location);
            } 
            
        } 
        {
            boolean var5B06505CBCDCB8DEE1F6FB0FBB28CE94_1606644592 = (inEditingMode() && mWebTextView.isFocused());
            {
                boolean var055C27F4AD9E2119212195DD41858BDC_1464704375 = (mWebTextView.dispatchKeyEvent(event));
            } 
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_217583903 = (super.dispatchKeyEvent(event));
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713175606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713175606;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.223 -0400", hash_original_method = "055AF43BFB28451173BD81CF001D1550", hash_generated_method = "3E416EF2B23C9E058B742004C18DA81A")
    private boolean hitFocusedPlugin(int contentX, int contentY) {
        {
            Rect r = nativeFocusNodeBounds();
        } 
        boolean varAADFA5397280FFF07498DCDB610497F5_567700975 = (nativeFocusIsPlugin()
                && nativeFocusNodeBounds().contains(contentX, contentY));
        addTaint(contentX);
        addTaint(contentY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399271897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399271897;
        
        
            
            
            
                    
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.223 -0400", hash_original_method = "E716E368428AC43DD861FB41DD4177B7", hash_generated_method = "8E9B9035D0B0E6632641AD1EAA5717BB")
    private boolean shouldForwardTouchEvent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846340227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846340227;
        
        
        
        
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.223 -0400", hash_original_method = "D8A5E5AFACABC5E7BA1118E01B4C441A", hash_generated_method = "20E8C5429A7C0912720614D969929EB1")
    private boolean inFullScreenMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242898654 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242898654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.223 -0400", hash_original_method = "9C2AE76A2AC6B55BAB3CF2FEB8A77756", hash_generated_method = "945B9C149DBE784AFCCC60AAD8A1902F")
    private void dismissFullScreenMode() {
        {
            boolean var1C653723DC415BF11BF974AF60071D68_708523273 = (inFullScreenMode());
            {
                mFullScreenHolder.hide();
                mFullScreenHolder = null;
            } 
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.224 -0400", hash_original_method = "E1BA99DFD58D25B484C78D43B2B15680", hash_generated_method = "ADA24DB953E0EB7EB11E71E67325FC31")
     void onPinchToZoomAnimationStart() {
        
        cancelTouch();
        onZoomAnimationStart();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.224 -0400", hash_original_method = "0EB0C83A18A49941F40FFE292C35177E", hash_generated_method = "4AD7518CAF79EBF2E3378FCEB538018C")
     void onPinchToZoomAnimationEnd(ScaleGestureDetector detector) {
        
        onZoomAnimationEnd();
        mTouchMode = TOUCH_PINCH_DRAG;
        mConfirmMove = true;
        startTouch(detector.getFocusX(), detector.getFocusY(), mLastTouchTime);
        addTaint(detector.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.224 -0400", hash_original_method = "51F97B516A7846416F2F48D7EC453A08", hash_generated_method = "CE19E5FEB3CA1E9B1FFAA8B579A093A8")
    private void startScrollingLayer(float x, float y) {
        int contentX = viewToContentX((int) x + mScrollX);
        int contentY = viewToContentY((int) y + mScrollY);
        mCurrentScrollingLayerId = nativeScrollableLayer(contentX, contentY,
                mScrollingLayerRect, mScrollingLayerBounds);
        {
            mTouchMode = TOUCH_DRAG_LAYER_MODE;
        } 
        addTaint(x);
        addTaint(y);
        
        
        
        
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.225 -0400", hash_original_method = "4E27D08D80EBD257E376FA7C97AE0256", hash_generated_method = "5537E6DC12B0FF1DDA170C0031744A29")
    @Override
    public boolean onHoverEvent(MotionEvent event) {
        
        WebViewCore.CursorData data = cursorDataNoPosition();
        data.mX = viewToContentX((int) event.getX() + mScrollX);
        data.mY = viewToContentY((int) event.getY() + mScrollY);
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE, data);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059310152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059310152;
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.225 -0400", hash_original_method = "4ABFBBEB2C120C2EC8658D81232A5900", hash_generated_method = "D2E4621ED5CB6ECA20B4B84AC5B2AC5D")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        
        {
            boolean varAD562CF087912EB5FF0170636C3B2B0D_696403983 = (mNativeClass == 0 || (!isClickable() && !isLongClickable()));
        } 
        {
            boolean varDD40B025666699E2A78E1AD03139D936_1336094603 = (ev.getPointerCount() > 1 && mPreventDefault != PREVENT_DEFAULT_NO);
            {
                passMultiTouchToWebKit(ev, mTouchEventQueue.nextTouchSequence());
            } 
            {
                mTouchEventQueue.enqueueTouchEvent(ev);
            } 
        } 
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349432210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349432210;
        
        
            
        
        
            
                
                
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.226 -0400", hash_original_method = "8F73CA33DFAADDF7A08C06DCB80137EA", hash_generated_method = "E7B935DCADED8D1320DDD754849AD805")
    private float calculateDragAngle(int dx, int dy) {
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        float var0DC0C40463DA1E6DC4A725D44FA13B49_656253191 = ((float) Math.atan2(dy, dx));
        addTaint(dx);
        addTaint(dy);
        float var546ADE640B6EDFBC8A086EF31347E768_1200957253 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1200957253;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.232 -0400", hash_original_method = "44C7DCF41F1CB5AEFC240F43E0D9FBAA", hash_generated_method = "14141D8D8CBAD181ECE8D596E090EF5E")
    private boolean handleTouchEventCommon(MotionEvent ev, int action, int x, int y) {
        long eventTime = ev.getEventTime();
        x = Math.min(x, getViewWidth() - 1);
        y = Math.min(y, getViewHeightWithTitle() - 1);
        int deltaX = mLastTouchX - x;
        int deltaY = mLastTouchY - y;
        int contentX = viewToContentX(x + mScrollX);
        int contentY = viewToContentY(y + mScrollY);
        
        {
            mPreventDefault = PREVENT_DEFAULT_NO;
            mConfirmMove = false;
            mInitialHitTestResult = null;
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1113081394 = (!mScroller.isFinished());
                {
                    mScroller.abortAnimation();
                    mTouchMode = TOUCH_DRAG_START_MODE;
                    mConfirmMove = true;
                    nativeSetIsScrolling(false);
                } 
                {
                    boolean varBDC63CBFC1D5292A90395B799377E3CA_1364211148 = (mPrivateHandler.hasMessages(RELEASE_SINGLE_TAP));
                    {
                        mPrivateHandler.removeMessages(RELEASE_SINGLE_TAP);
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_668100244 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                removeTouchHighlight();
                            } 
                        } 
                        {
                            mTouchMode = TOUCH_DOUBLE_TAP_MODE;
                        } 
                        {
                            doShortPress();
                            mTouchMode = TOUCH_INIT_MODE;
                            mDeferTouchProcess = !mBlockWebkitViewMessages
                                && (!inFullScreenMode() && mForwardTouchEvents)
                                ? hitFocusedPlugin(contentX, contentY)
                                : false;
                        } 
                    } 
                    {
                        mTouchMode = TOUCH_INIT_MODE;
                        mDeferTouchProcess = !mBlockWebkitViewMessages
                            && (!inFullScreenMode() && mForwardTouchEvents)
                            ? hitFocusedPlugin(contentX, contentY)
                            : false;
                        {
                            mWebViewCore.sendMessage(
                                EventHub.UPDATE_FRAME_CACHE_IF_LOADING);
                        } 
                        {
                            boolean var06EBCE9F7031CD206C1CA9247D6B0EF2_604258214 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                            {
                                TouchHighlightData data = new TouchHighlightData();
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
                                } 
                                {
                                    {
                                        boolean varD778979F37708EA925216FB277FD8D27_1478487075 = (getSettings().getNavDump());
                                        {
                                            mTouchHighlightX = (int) x + mScrollX;
                                            mTouchHighlightY = (int) y + mScrollY;
                                            mPrivateHandler.postDelayed(new Runnable() {                                                
                                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.229 -0400", hash_original_method = "7498706CCC2860B05B7071008D2A72AF", hash_generated_method = "BDEB34128B671E054A924D53CAF12B4F")
                                                public void run() {
                                                    mTouchHighlightX = mTouchHighlightY = 0;
                                                    invalidate();
                                                    
                                                    
                                                    
                                                }
}, TOUCH_HIGHLIGHT_ELAPSE_TIME);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            EventLog.writeEvent(EventLogTags.BROWSER_DOUBLE_TAP_DURATION,
                                (eventTime - mLastTouchUpTime), eventTime);
                        } 
                        {
                            mDrawSelectionPointer = false;
                            mSelectionStarted = nativeStartSelection(contentX, contentY);
                            invalidate();
                        } 
                    } 
                } 
            } 
            {
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_SHORTPRESS, TAP_TIMEOUT);
                mPrivateHandler.sendEmptyMessageDelayed(
                            SWITCH_TO_LONGPRESS, LONG_PRESS_TIMEOUT);
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_1406281022 = (inFullScreenMode() || mDeferTouchProcess);
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } 
                    {
                        mPreventDefault = PREVENT_DEFAULT_MAYBE_YES;
                    } 
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                    } 
                } 
                {
                    boolean var8932DD5DB07C85349F24CECE7642DABD_1247979880 = (shouldForwardTouchEvent());
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
                        {
                            mLastTouchX = x;
                            mLastTouchY = y;
                        } 
                        {
                            boolean var6904F2C5D7BEAFC799CAAF4B382483D5_487922751 = (!inFullScreenMode());
                            {
                                mPrivateHandler.removeMessages(PREVENT_DEFAULT_TIMEOUT);
                                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                    .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                            action, 0), TAP_TIMEOUT);
                            } 
                        } 
                    } 
                } 
            } 
            startTouch(x, y, eventTime);
        } 
        
        
        {
            boolean firstMove = false;
            {
                mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                mConfirmMove = true;
                firstMove = true;
                {
                    mTouchMode = TOUCH_INIT_MODE;
                } 
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_147829610 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } 
                } 
            } 
            {
                boolean varD5BC4EB905AD1A9E62B09D5876DE7CFA_1154519746 = (shouldForwardTouchEvent() && mConfirmMove && (firstMove
                        || eventTime - mLastSentTouchTime > mCurrentTouchInterval));
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
                    {
                        boolean varEF4783D596E01CB01D0208E403EB969C_162715578 = (firstMove && !inFullScreenMode());
                        {
                            mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(PREVENT_DEFAULT_TIMEOUT,
                                        action, 0), TAP_TIMEOUT);
                        } 
                    } 
                } 
            } 
            {
                mVelocityTracker.addMovement(ev);
            } 
            {
                ViewParent parent = getParent();
                {
                    parent.requestDisallowInterceptTouchEvent(true);
                } 
                mAutoScrollX = x <= mMinAutoScrollX ? -SELECT_SCROLL
                            : x >= mMaxAutoScrollX ? SELECT_SCROLL : 0;
                mAutoScrollY = y <= mMinAutoScrollY ? -SELECT_SCROLL
                            : y >= mMaxAutoScrollY ? SELECT_SCROLL : 0;
                {
                    mSentAutoScrollMessage = true;
                    mPrivateHandler.sendEmptyMessageDelayed(
                                SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
                } 
                {
                    nativeExtendSelection(contentX, contentY);
                    invalidate();
                } 
            } 
            {
                {
                    mLastTouchTime = eventTime;
                } 
                final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                mAverageAngle = calculateDragAngle(deltaX, deltaY);
                {
                    boolean varA7D01DAA9313836025F53EEF13EC7FDA_663055676 = (detector == null || !detector.isInProgress());
                    {
                        {
                            mSnapScrollMode = SNAP_X;
                            mSnapPositive = deltaX > 0;
                            mAverageAngle = ANGLE_HORIZ;
                        } 
                        {
                            mSnapScrollMode = SNAP_Y;
                            mSnapPositive = deltaY > 0;
                            mAverageAngle = ANGLE_VERT;
                        } 
                    } 
                } 
                mTouchMode = TOUCH_DRAG_MODE;
                mLastTouchX = x;
                mLastTouchY = y;
                deltaX = 0;
                deltaY = 0;
                startScrollingLayer(x, y);
                startDrag();
            } 
            boolean done = false;
            boolean keepScrollBarsVisible = false;
            {
                keepScrollBarsVisible = done = true;
            } 
            {
                mAverageAngle +=
                        (calculateDragAngle(deltaX, deltaY) - mAverageAngle)
                        / MMA_WEIGHT_N;
                {
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } 
                    } 
                    {
                        {
                            mSnapScrollMode = SNAP_NONE;
                        } 
                    } 
                } 
                {
                    {
                        mSnapScrollMode = SNAP_X;
                        mSnapPositive = deltaX > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_HORIZ) / 2;
                    } 
                    {
                        mSnapScrollMode = SNAP_Y;
                        mSnapPositive = deltaY > 0;
                        mAverageAngle = (mAverageAngle + ANGLE_VERT) / 2;
                    } 
                } 
                {
                    {
                        deltaY = 0;
                    } 
                    {
                        deltaX = 0;
                    } 
                } 
                mLastTouchX = x;
                mLastTouchY = y;
                {
                    mHeldMotionless = MOTIONLESS_FALSE;
                    nativeSetIsScrolling(true);
                } 
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    nativeSetIsScrolling(false);
                    keepScrollBarsVisible = true;
                } 
                mLastTouchTime = eventTime;
            } 
            doDrag(deltaX, deltaY);
            {
                {
                    mHeldMotionless = MOTIONLESS_TRUE;
                    invalidate();
                } 
                awakenScrollBars(ViewConfiguration.getScrollDefaultDelay(),
                            false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                            .obtainMessage(AWAKEN_SCROLL_BARS),
                            ViewConfiguration.getScrollDefaultDelay());
            } 
            {
                mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            } 
        } 
        
        
        {
            {
                boolean varCCB6FB0842D1DC09DCB72C373334A6F6_591246561 = (!isFocused());
                requestFocus();
            } 
            {
                boolean var4F0E2B9C4455366734F8A4D46CDF3837_1774049736 = (shouldForwardTouchEvent());
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
                } 
            } 
            mLastTouchUpTime = eventTime;
            {
                mAutoScrollX = mAutoScrollY = 0;
            } 
            
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            
            
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            
            
            {
                boolean var99D9C999635D25840B0CAFFCC353615B_1462770515 = (inFullScreenMode() || mDeferTouchProcess);
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
                } 
                {
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    mTouchMode = TOUCH_DONE_MODE;
                } 
            } 
            
            
            mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
            
            
            mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
            
            
            {
                {
                    boolean var9A35F484FD2A3035C5778E7274850AEE_1097129381 = (mPreventDefault != PREVENT_DEFAULT_YES
                                    && (computeMaxScrollX() > 0
                                            || computeMaxScrollY() > 0));
                    {
                        WebViewCore.reducePriority();
                        WebViewCore.pauseUpdatePicture(mWebViewCore);
                    } 
                    {
                        invalidate();
                    } 
                } 
            } 
            {
                {
                    {
                        boolean var52238646ADDC3EDB53CF60FF8D752DAA_135160181 = (!nativeHitSelection(contentX, contentY));
                        {
                            selectionDone();
                        } 
                    } 
                } 
                {
                    boolean var7ECA0E1176F50826819D1E05F7BE240D_199426858 = (mTouchMode == TOUCH_INIT_MODE
                                    && (canZoomIn() || canZoomOut()));
                    {
                        mPrivateHandler.sendEmptyMessageDelayed(
                                        RELEASE_SINGLE_TAP, ViewConfiguration
                                                .getDoubleTapTimeout());
                    } 
                    {
                        doShortPress();
                    } 
                } 
            } 
            
            
            mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
            
            
            mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
            
            
            {
                {
                    mVelocityTracker.addMovement(ev);
                } 
                mHeldMotionless = MOTIONLESS_IGNORE;
                doFling();
            } 
            {
                {
                    boolean varBCFC69392A8766EDCCDAD1B162C3D405_746526648 = (mScroller.springBack(mScrollX, mScrollY, 0,
                                    computeMaxScrollX(), 0,
                                    computeMaxScrollY()));
                    {
                        invalidate();
                    } 
                } 
            } 
            
            
            mHeldMotionless = MOTIONLESS_TRUE;
            
            
            invalidate();
            
            
            mLastVelocity = 0;
            
            
            WebViewCore.resumePriority();
            
            
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } 
            
            stopTouch();
        } 
        
        
        {
            {
                mScroller.springBack(mScrollX, mScrollY, 0,
                            computeMaxScrollX(), 0, computeMaxScrollY());
                invalidate();
            } 
            cancelWebCoreTouchEvent(contentX, contentY, false);
            cancelTouch();
        } 
        
        addTaint(ev.getTaint());
        addTaint(action);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862437386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862437386;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.233 -0400", hash_original_method = "0AD80AF48713050FA0EC4A54A38A141B", hash_generated_method = "2505BD8B62B4C30B9F84546193D4C704")
    private void passMultiTouchToWebKit(MotionEvent ev, long sequence) {
        TouchEventData ted = new TouchEventData();
        ted.mAction = ev.getActionMasked();
        final int count = ev.getPointerCount();
        ted.mIds = new int[count];
        ted.mPoints = new Point[count];
        ted.mPointsInView = new Point[count];
        {
            int c = 0;
            {
                ted.mIds[c] = ev.getPointerId(c);
                int x = viewToContentX((int) ev.getX(c) + mScrollX);
                int y = viewToContentY((int) ev.getY(c) + mScrollY);
                ted.mPoints[c] = new Point(x, y);
                ted.mPointsInView[c] = new Point((int) ev.getX(c), (int) ev.getY(c));
            } 
        } 
        {
            ted.mActionIndex = ev.getActionIndex();
        } 
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.234 -0400", hash_original_method = "6E14A620AB97FDF158C486462D2DDC0C", hash_generated_method = "467514CD86D13B276992056040EBBD40")
     void handleMultiTouchInWebView(MotionEvent ev) {
        final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
        float x = ev.getX();
        float y = ev.getY();
        {
            detector.onTouchEvent(ev);
            {
                boolean var57DA30FC8CBBE7A73D9281B93734CBB1_1238084837 = (detector.isInProgress());
                {
                    mLastTouchTime = ev.getEventTime();
                    x = detector.getFocusX();
                    y = detector.getFocusY();
                    cancelLongPress();
                    mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    {
                        boolean var1701A38F89582DE3B703C873F3E6A99C_1801242739 = (!mZoomManager.supportsPanDuringZoom());
                    } 
                    mTouchMode = TOUCH_DRAG_MODE;
                    {
                        mVelocityTracker = VelocityTracker.obtain();
                    } 
                } 
            } 
        } 
        int action = ev.getActionMasked();
        {
            cancelTouch();
            action = MotionEvent.ACTION_DOWN;
        } 
        {
            boolean var3FCFE6069F8C28D647A3D03480A488F3_1712028234 = (action == MotionEvent.ACTION_POINTER_UP && ev.getPointerCount() >= 2);
            {
                mLastTouchX = Math.round(x);
                mLastTouchY = Math.round(y);
            } 
        } 
        handleTouchEventCommon(ev, action, Math.round(x), Math.round(y));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.235 -0400", hash_original_method = "C8342437C245315DF96B88E254178C15", hash_generated_method = "FAA5A8641ECBF7601571972CC8DAF77A")
    private void cancelWebCoreTouchEvent(int x, int y, boolean removeEvents) {
        {
            boolean var3C4264CDBD1B465E519441FFC519D662_2018568470 = (shouldForwardTouchEvent());
            {
                {
                    mWebViewCore.removeMessages(EventHub.TOUCH_EVENT);
                } 
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
                {
                    mTouchEventQueue.ignoreCurrentlyMissingEvents();
                } 
            } 
        } 
        addTaint(x);
        addTaint(y);
        addTaint(removeEvents);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.235 -0400", hash_original_method = "89D469327F4BC3825A4395DE1840B519", hash_generated_method = "0D7562C6FBA96481178741005DE5C3EB")
    private void startTouch(float x, float y, long eventTime) {
        mStartTouchX = mLastTouchX = Math.round(x);
        mStartTouchY = mLastTouchY = Math.round(y);
        mLastTouchTime = eventTime;
        mVelocityTracker = VelocityTracker.obtain();
        mSnapScrollMode = SNAP_NONE;
        mPrivateHandler.sendEmptyMessageDelayed(UPDATE_SELECTION,
                ViewConfiguration.getTapTimeout());
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.236 -0400", hash_original_method = "C5A9FE6FD5A8A7CC8BBAE81A258CF68D", hash_generated_method = "319FC1C72835795F52968677012BD08A")
    private void startDrag() {
        WebViewCore.reducePriority();
        WebViewCore.pauseUpdatePicture(mWebViewCore);
        nativeSetIsScrolling(true);
        {
            nativeHideCursor();
        } 
        {
            mZoomManager.invokeZoomPicker();
        } 
        
        
        
        
        
            
        
        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.237 -0400", hash_original_method = "7EB5408DBB6A63C7305064CC51791450", hash_generated_method = "21E97A23CE7BE796F4167ED451EB223B")
    private void doDrag(int deltaX, int deltaY) {
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            int rangeX = computeMaxScrollX();
            int rangeY = computeMaxScrollY();
            int overscrollDistance = mOverscrollDistance;
            {
                final int contentX = viewToContentDimension(deltaX);
                final int contentY = viewToContentDimension(deltaY);
                final int maxX = mScrollingLayerRect.right;
                final int maxY = mScrollingLayerRect.bottom;
                final int resultX = Math.max(0,
                        Math.min(mScrollingLayerRect.left + contentX, maxX));
                final int resultY = Math.max(0,
                        Math.min(mScrollingLayerRect.top + contentY, maxY));
                {
                    mTouchMode = TOUCH_DRAG_LAYER_MODE;
                    deltaX = contentX;
                    deltaY = contentY;
                    oldX = mScrollingLayerRect.left;
                    oldY = mScrollingLayerRect.top;
                    rangeX = maxX;
                    rangeY = maxY;
                } 
                {
                    mTouchMode = TOUCH_DRAG_MODE;
                } 
            } 
            {
                mOverScrollGlow.setOverScrollDeltas(deltaX, deltaY);
            } 
            overScrollBy(deltaX, deltaY, oldX, oldY,
                    rangeX, rangeY,
                    mOverscrollDistance, mOverscrollDistance, true);
            {
                boolean var5792E174AFE968D06415B5B7AAC36535_636284132 = (mOverScrollGlow != null && mOverScrollGlow.isAnimating());
                {
                    invalidate();
                } 
            } 
        } 
        mZoomManager.keepZoomPickerVisible();
        addTaint(deltaX);
        addTaint(deltaY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.237 -0400", hash_original_method = "F4EF3B6C775161D575CB5ACE4F88630F", hash_generated_method = "7F8C400CE3A43836081D9AE9E499CA7C")
    private void stopTouch() {
        {
            boolean varCAF00077668D04F986EAAEC815FA20E7_454001817 = (mScroller.isFinished() && !mSelectingText
                && (mTouchMode == TOUCH_DRAG_MODE || mTouchMode == TOUCH_DRAG_LAYER_MODE));
            {
                WebViewCore.resumePriority();
                WebViewCore.resumeUpdatePicture(mWebViewCore);
                nativeSetIsScrolling(false);
            } 
        } 
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        {
            mOverScrollGlow.releaseAll();
        } 
        
        
                
            
            
            
        
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.239 -0400", hash_original_method = "D27D2CECC952EFBD52768C36F3295776", hash_generated_method = "91A22C60948B7AF97B6952B353957F2F")
    private void cancelTouch() {
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } 
        {
            WebViewCore.resumePriority();
            WebViewCore.resumeUpdatePicture(mWebViewCore);
            nativeSetIsScrolling(false);
        } 
        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
        mPrivateHandler.removeMessages(DRAG_HELD_MOTIONLESS);
        mPrivateHandler.removeMessages(AWAKEN_SCROLL_BARS);
        {
            boolean varAC20DC667EA914A16B375E9527C79DFD_72736230 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
            } 
        } 
        mHeldMotionless = MOTIONLESS_TRUE;
        mTouchMode = TOUCH_DONE_MODE;
        nativeHideCursor();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.240 -0400", hash_original_method = "BE8755468291C2952085EDEBFE1C6BFA", hash_generated_method = "958BEE7C04D621A8D75A29CAA96D0269")
    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        {
            boolean varB5CEEFE1A0B0FE6CF2A2378211A03C4D_1176443902 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            {
                {
                    Object varC2BF00F96F1D1B1ABEF4B0E3FC4FE9EC_1074781271 = (event.getAction());
                    
                    {
                        float vscroll;
                        float hscroll;
                        {
                            boolean varB4D6A432BD6856FDF71FC12482F4DB92_50140563 = ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0);
                            {
                                vscroll = 0;
                                hscroll = event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                            } 
                            {
                                vscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                                hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                            } 
                        } 
                        {
                            final int vdelta = (int) (vscroll * getVerticalScrollFactor());
                            final int hdelta = (int) (hscroll * getHorizontalScrollFactor());
                            {
                                boolean var2D3D9D2324BD436DC860CC59381AD41D_1179210434 = (pinScrollBy(hdelta, vdelta, false, 0));
                            } 
                        } 
                    } 
                    
                } 
            } 
        } 
        boolean var32C1E3DF40BCC120C79428C7AEB27DD1_1893372758 = (super.onGenericMotionEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275454355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275454355;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.240 -0400", hash_original_method = "38B49C08CE5650B743168C2E2BE5CA65", hash_generated_method = "791AAE015ADF7CA304395081F6AC4FBB")
    public void setMapTrackballToArrowKeys(boolean setMap) {
        checkThread();
        mMapTrackballToArrowKeys = setMap;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.241 -0400", hash_original_method = "B9600CE64DC445389C4969B83D045257", hash_generated_method = "6AC8F93A7F315BEE56D465931AC8D27F")
     void resetTrackballTime() {
        mTrackballLastTime = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.242 -0400", hash_original_method = "09EA1A78F8275AF35981C9BD94B08432", hash_generated_method = "8E783977F9B43269FFAC9D4BBBAA89F8")
    @Override
    public boolean onTrackballEvent(MotionEvent ev) {
        
        long time = ev.getEventTime();
        {
            boolean varF89B2554B17216A1EC58B9D61476F71F_2119775039 = ((ev.getMetaState() & KeyEvent.META_ALT_ON) != 0);
            {
                {
                    boolean varF71C9C4037B7A9B705CFAAB9834929D8_1011728223 = (ev.getY() > 0);
                    pageDown(true);
                } 
                {
                    boolean var07FD34B1A3496FC381CDBE7EFC3BB0AA_829642780 = (ev.getY() < 0);
                    pageUp(true);
                } 
            } 
        } 
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_1365676349 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                mTrackballDown = true;
                {
                    boolean varD7E949BAB427F90FF96CAA2888F6F2C4_1184566352 = (time - mLastCursorTime <= TRACKBALL_TIMEOUT
                    && !mLastCursorBounds.equals(nativeGetCursorRingBounds()));
                    {
                        nativeSelectBestAt(mLastCursorBounds);
                    } 
                } 
                {
                    boolean varAFC77293C02F773029137FDE42129C14_198324859 = (isInTouchMode());
                    requestFocusFromTouch();
                } 
            } 
        } 
        {
            boolean var9BE2C50B8CBB194C9242022F6D5B67CC_845724167 = (ev.getAction() == MotionEvent.ACTION_UP);
            {
                mPrivateHandler.removeMessages(LONG_PRESS_CENTER);
                mTrackballDown = false;
                mTrackballUpTime = time;
                {
                    {
                        copySelection();
                        selectionDone();
                    } 
                    {
                        mExtendSelection = true;
                        nativeSetExtendSelection();
                        invalidate();
                    } 
                } 
            } 
        } 
        {
            boolean var963F7CE81FE031C5E5B8879F84F3644B_1886761836 = ((mMapTrackballToArrowKeys && (ev.getMetaState() & KeyEvent.META_SHIFT_ON) == 0) ||
                AccessibilityManager.getInstance(mContext).isEnabled());
        } 
        switchOutDrawHistory();
        {
            mTrackballFirstTime = time;
            mTrackballXMove = mTrackballYMove = 0;
        } 
        mTrackballLastTime = time;
        mTrackballRemainsX += ev.getX();
        mTrackballRemainsY += ev.getY();
        doTrackball(time, ev.getMetaState());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191721212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191721212;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.242 -0400", hash_original_method = "D182A136D0B4338F5A241BF2E86510C3", hash_generated_method = "44A4BFD70BF7E2213A018EA3732A2604")
     void moveSelection(float xRate, float yRate) {
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
        nativeMoveSelection(viewToContentX(mSelectX), viewToContentY(mSelectY));
        int scrollX;
        scrollX = SELECT_CURSOR_OFFSET;
        scrollX = 0;
        int scrollY;
        scrollY = SELECT_CURSOR_OFFSET;
        scrollY = 0;
        pinScrollBy(scrollX, scrollY, true, 0);
        Rect select = new Rect(mSelectX, mSelectY, mSelectX + 1, mSelectY + 1);
        requestRectangleOnScreen(select);
        invalidate();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.243 -0400", hash_original_method = "44B6EC62F94A30D145B4D96D02167D11", hash_generated_method = "FBCA9C82A43BF41364053D9792BEE036")
    private int scaleTrackballX(float xRate, int width) {
        int xMove = (int) (xRate / TRACKBALL_SCALE * width);
        int nextXMove = xMove;
        {
            {
                xMove -= mTrackballXMove;
            } 
        } 
        {
            xMove -= mTrackballXMove;
        } 
        mTrackballXMove = nextXMove;
        addTaint(xRate);
        addTaint(width);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499203261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499203261;
        
        
        
        
            
                
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.243 -0400", hash_original_method = "4955ADB09DEAD56B8F7C2CA183746984", hash_generated_method = "6BC3CB498E4751DE1488F5195BB6A877")
    private int scaleTrackballY(float yRate, int height) {
        int yMove = (int) (yRate / TRACKBALL_SCALE * height);
        int nextYMove = yMove;
        {
            {
                yMove -= mTrackballYMove;
            } 
        } 
        {
            yMove -= mTrackballYMove;
        } 
        mTrackballYMove = nextYMove;
        addTaint(yRate);
        addTaint(height);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422832395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422832395;
        
        
        
        
            
                
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.243 -0400", hash_original_method = "FC3532FF1DC00329EC70D001979FADB3", hash_generated_method = "1BDBC91363EB1B8A1DEEE61F2DEF96F5")
    private int keyCodeToSoundsEffect(int keyCode) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("keyCode must be one of " +
                "{KEYCODE_DPAD_UP, KEYCODE_DPAD_RIGHT, KEYCODE_DPAD_DOWN, " +
                "KEYCODE_DPAD_LEFT}.");
        addTaint(keyCode);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267720515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267720515;
        
        
            
                
            
                
            
                
            
                
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.244 -0400", hash_original_method = "299C759A4C01FF41318B69F16F83C43D", hash_generated_method = "CA7231FE0B0F107525D581EF37C79C37")
    private void doTrackball(long time, int metaState) {
        int elapsed = (int) (mTrackballLastTime - mTrackballFirstTime);
        {
            elapsed = TRACKBALL_TIMEOUT;
        } 
        float xRate = mTrackballRemainsX * 1000 / elapsed;
        float yRate = mTrackballRemainsY * 1000 / elapsed;
        int viewWidth = getViewWidth();
        int viewHeight = getViewHeight();
        {
            {
                mSelectX = contentToViewX(nativeSelectionX());
                mSelectY = contentToViewY(nativeSelectionY());
                mDrawSelectionPointer = mExtendSelection = true;
                nativeSetExtendSelection();
            } 
            moveSelection(scaleTrackballX(xRate, viewWidth),
                    scaleTrackballY(yRate, viewHeight));
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } 
        float ax = Math.abs(xRate);
        float ay = Math.abs(yRate);
        float maxA = Math.max(ax, ay);
        int width = mContentWidth - viewWidth;
        int height = mContentHeight - viewHeight;
        width = 0;
        height = 0;
        ax = Math.abs(mTrackballRemainsX * TRACKBALL_MULTIPLIER);
        ay = Math.abs(mTrackballRemainsY * TRACKBALL_MULTIPLIER);
        maxA = Math.max(ax, ay);
        int count = Math.max(0, (int) maxA);
        int oldScrollX = mScrollX;
        int oldScrollY = mScrollY;
        {
            int selectKeyCode;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_LEFT;
            selectKeyCode = KeyEvent.KEYCODE_DPAD_RIGHT;
            count = Math.min(count, TRACKBALL_MOVE_COUNT);
            {
                boolean var13243A190284240A17DA938A95FFCA4B_1234350172 = (mNativeClass != 0 && nativePageShouldHandleShiftAndArrows());
                {
                    {
                        int i = 0;
                        {
                            letPageHandleNavKey(selectKeyCode, time, true, metaState);
                        } 
                    } 
                    letPageHandleNavKey(selectKeyCode, time, false, metaState);
                } 
                {
                    boolean var9216DDA0E70E02F03C94252CA6894A26_661019540 = (navHandledKey(selectKeyCode, count, false, time));
                    {
                        playSoundEffect(keyCodeToSoundsEffect(selectKeyCode));
                    } 
                } 
            } 
            mTrackballRemainsX = mTrackballRemainsY = 0;
        } 
        {
            int xMove = scaleTrackballX(xRate, width);
            int yMove = scaleTrackballY(yRate, height);
            {
                boolean var1510D01512E341B4186F1DC473D82D5C_1196544334 = (Math.abs(mScrollX - oldScrollX) > Math.abs(xMove));
                {
                    xMove = 0;
                } 
            } 
            {
                boolean varEA9F4D4529504DF5B7FB3F15ED262404_238748067 = (Math.abs(mScrollY - oldScrollY) > Math.abs(yMove));
                {
                    yMove = 0;
                } 
            } 
            {
                pinScrollBy(xMove, yMove, true, 0);
            } 
        } 
        addTaint(time);
        addTaint(metaState);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.245 -0400", hash_original_method = "3D3DDB29824BD983AC62807A5552B60B", hash_generated_method = "115D7CC37E7B44B8FA3C92916CF96391")
     int computeMaxScrollX() {
        int varA25CFD9DF68C570DBFC28D80EAD42611_859819868 = (Math.max(computeRealHorizontalScrollRange() - getViewWidth(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273470257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273470257;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.245 -0400", hash_original_method = "9E8EF9B58CA6D488566369B6B3CF8AF1", hash_generated_method = "A50C65026AF1FE9A1A89182F5D6577AD")
     int computeMaxScrollY() {
        int varBA3EE78DB7716D218FE9D8E3CD2F2343_2081711838 = (Math.max(computeRealVerticalScrollRange() + getTitleHeight()
                - getViewHeightWithTitle(), 0));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1405740180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1405740180;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.245 -0400", hash_original_method = "57089A20002C2A6AB0E32C20C9225985", hash_generated_method = "4F7F68DCE80FD6A1257D14A50A8B3542")
     boolean updateScrollCoordinates(int x, int y) {
        int oldX = mScrollX;
        int oldY = mScrollY;
        mScrollX = x;
        mScrollY = y;
        {
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
        } 
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633395623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633395623;
        
        
        
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.246 -0400", hash_original_method = "20CABBB6F7D9BE500508DAA3AAEA4482", hash_generated_method = "5F5421322FCE4E8262F4AA0CAC479CF1")
    public void flingScroll(int vx, int vy) {
        checkThread();
        mScroller.fling(mScrollX, mScrollY, vx, vy, 0, computeMaxScrollX(), 0,
                computeMaxScrollY(), mOverflingDistance, mOverflingDistance);
        invalidate();
        addTaint(vx);
        addTaint(vy);
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.248 -0400", hash_original_method = "ED37FE66A13D9BCCB3B61317B8789C6E", hash_generated_method = "1CDE9906E2B2C9C2027C137BE7CAF2C0")
    private void doFling() {
        int maxX = computeMaxScrollX();
        int maxY = computeMaxScrollY();
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFling);
        int vx = (int) mVelocityTracker.getXVelocity();
        int vy = (int) mVelocityTracker.getYVelocity();
        int scrollX = mScrollX;
        int scrollY = mScrollY;
        int overscrollDistance = mOverscrollDistance;
        int overflingDistance = mOverflingDistance;
        {
            scrollX = mScrollingLayerRect.left;
            scrollY = mScrollingLayerRect.top;
            maxX = mScrollingLayerRect.right;
            maxY = mScrollingLayerRect.bottom;
            overscrollDistance = overflingDistance = 0;
        } 
        {
            {
                vy = 0;
            } 
            {
                vx = 0;
            } 
        } 
        {
            WebViewCore.resumePriority();
            {
                WebViewCore.resumeUpdatePicture(mWebViewCore);
            } 
            {
                boolean var294FD332965037BDDAF5E40360BE82C6_2061624352 = (mScroller.springBack(scrollX, scrollY, 0, maxX, 0, maxY));
                {
                    invalidate();
                } 
            } 
        } 
        float currentVelocity = mScroller.getCurrVelocity();
        float velocity = (float) Math.hypot(vx, vy);
        {
            float deltaR = (float) (Math.abs(Math.atan2(mLastVelY, mLastVelX)
                    - Math.atan2(vy, vx)));
            final float circle = (float) (Math.PI) * 2.0f;
            {
                vx += currentVelocity * mLastVelX / mLastVelocity;
                vy += currentVelocity * mLastVelY / mLastVelocity;
                velocity = (float) Math.hypot(vx, vy);
            } 
        } 
        {
            boolean var7D437B480773CFFE36BF196E1126697F_158226518 = ((scrollX == 0 || scrollX == maxX) && Math.abs(vx) < Math.abs(vy));
            {
                vx = 0;
            } 
        } 
        {
            boolean var062E5EDAB50CDBF113CFC310D559CF03_845985635 = ((scrollY == 0 || scrollY == maxY) && Math.abs(vy) < Math.abs(vx));
            {
                vy = 0;
            } 
        } 
        {
            {
                vx = 0;
            } 
            {
                vy = 0;
            } 
        } 
        mLastVelX = vx;
        mLastVelY = vy;
        mLastVelocity = velocity;
        mScroller.fling(scrollX, scrollY, -vx, -vy, 0, maxX, 0, maxY,
                maxX == 0 ? 0 : overflingDistance, overflingDistance);
        final int time = mScroller.getDuration();
        {
            awakenScrollBars(time);
        } 
        invalidate();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.250 -0400", hash_original_method = "086CD418AC6EC8E39C422734998A48D8", hash_generated_method = "93BEE8786FC13E18C379FA0D729DD7B2")
    @Deprecated
    public View getZoomControls() {
        View varB4EAC82CA7396A68D541C85D26508E83_415175399 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_574556167 = null; 
        checkThread();
        {
            boolean varC7ECA0C6BE9760830C0E65857F85DC44_345235906 = (!getSettings().supportZoom());
            {
                varB4EAC82CA7396A68D541C85D26508E83_415175399 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_574556167 = mZoomManager.getExternalZoomPicker();
        View varA7E53CE21691AB073D9660D615818899_789628577; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_789628577 = varB4EAC82CA7396A68D541C85D26508E83_415175399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_789628577 = varB4EAC82CA7396A68D541C85D26508E83_574556167;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_789628577.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_789628577;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.250 -0400", hash_original_method = "EC89FF2696E56191A01C387CAC6B0B5A", hash_generated_method = "E0110D1A2A491ABF92EE451CB29B8360")
     void dismissZoomControl() {
        mZoomManager.dismissZoomPicker();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.251 -0400", hash_original_method = "6F08586F43D113F982C701D06B48528D", hash_generated_method = "9664EB04C8337C6B4B5B8F633803432F")
     float getDefaultZoomScale() {
        float var952A9E36B82C4A93C3ADCF5509083504_457751984 = (mZoomManager.getDefaultScale());
        float var546ADE640B6EDFBC8A086EF31347E768_294197846 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_294197846;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.251 -0400", hash_original_method = "E79BB21DF563AB4A37FFCD3F87B40C92", hash_generated_method = "49E9CAE01E27E856CE8102177C92F74E")
     float getZoomOverviewScale() {
        float varEF858DD667F2D952B7E5019CEC33E4DD_1701190954 = (mZoomManager.getZoomOverviewScale());
        float var546ADE640B6EDFBC8A086EF31347E768_25732293 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_25732293;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.251 -0400", hash_original_method = "0C05EAD0D1EEEAA58A49C31BBD13A081", hash_generated_method = "8AF728B94C45D5FF99135195760BF173")
    public boolean canZoomIn() {
        checkThread();
        boolean varB7D0C9863F46AF864AE5BCCDA2FEA388_871048298 = (mZoomManager.canZoomIn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1923581208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1923581208;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.251 -0400", hash_original_method = "144F9C44485F578B0B69BF2C63E6709A", hash_generated_method = "451876BA25788E5CFC7F8E830EB12ADE")
    public boolean canZoomOut() {
        checkThread();
        boolean var55B9AB817324FC769B25B74F0D5FB277_805737259 = (mZoomManager.canZoomOut());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703272025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703272025;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.252 -0400", hash_original_method = "4D255039FA4DEE2C76FFD18FB9311ECB", hash_generated_method = "45513219A9FE35792B791C8060320CF3")
    public boolean zoomIn() {
        checkThread();
        boolean varAC42C946D5F06586AAF06194E5591056_2023623377 = (mZoomManager.zoomIn());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1049846302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1049846302;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.252 -0400", hash_original_method = "646D57A50A23BECF2F2C02D141894A6A", hash_generated_method = "05188408087BEFE0AA635F0B804559E8")
    public boolean zoomOut() {
        checkThread();
        boolean varA9C5CE6824B53568BAC50FAF0F581652_1992059016 = (mZoomManager.zoomOut());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2016050325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2016050325;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.252 -0400", hash_original_method = "FEF43605D6CD2490E153092E2A1109E2", hash_generated_method = "B4F366A419193F3CAA0E5429BFB9C471")
    private void updateSelection() {
        mPrivateHandler.removeMessages(UPDATE_SELECTION);
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
        Rect rect = new Rect(contentX - slop, contentY - slop,
                contentX + slop, contentY + slop);
        nativeSelectBestAt(rect);
        mInitialHitTestResult = hitTestResult(null);
        
        
            
        
        
        
        
        
        
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.253 -0400", hash_original_method = "B1C37D04459D7444D73F65FC3A93C13A", hash_generated_method = "46A62C16575717CEF1B5B41D8C274EF4")
     void scrollFocusedTextInputX(float xPercent) {
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_672092771 = (!inEditingMode() || mWebViewCore == null);
        } 
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0,
                new Float(xPercent));
        addTaint(xPercent);
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.253 -0400", hash_original_method = "0440BEEC9E3517FB16518560397B0D7B", hash_generated_method = "0B345DCC6C6F3D87B7A3FC3DE43A7FCA")
     void scrollFocusedTextInputY(int y) {
        {
            boolean varBE52B901E21441491C172E8AFC4E1E7E_1511463893 = (!inEditingMode() || mWebViewCore == null);
        } 
        mWebViewCore.sendMessage(EventHub.SCROLL_TEXT_INPUT, 0, viewToContentDimension(y));
        addTaint(y);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.253 -0400", hash_original_method = "8B2CD9AB316A7F800AB44456E462AE1F", hash_generated_method = "AAEDFD532D8DEEE65FF111DF2FF3CAE1")
     void initiateTextFieldDrag(float x, float y, long eventTime) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_759310418 = (!inEditingMode());
        } 
        mLastTouchX = Math.round(x + mWebTextView.getLeft() - mScrollX);
        mLastTouchY = Math.round(y + mWebTextView.getTop() - mScrollY);
        mLastTouchTime = eventTime;
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_661135278 = (!mScroller.isFinished());
            {
                abortAnimation();
            } 
        } 
        mSnapScrollMode = SNAP_NONE;
        mVelocityTracker = VelocityTracker.obtain();
        mTouchMode = TOUCH_DRAG_START_MODE;
        
        
            
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.254 -0400", hash_original_method = "6C960439C25AF77774221479666CDCA6", hash_generated_method = "C8953A31A60B28305780789A08D78984")
     boolean textFieldDrag(MotionEvent event) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_529073644 = (!inEditingMode());
        } 
        mDragFromTextInput = true;
        event.offsetLocation((float) (mWebTextView.getLeft() - mScrollX),
                (float) (mWebTextView.getTop() - mScrollY));
        boolean result = onTouchEvent(event);
        mDragFromTextInput = false;
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_900396053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_900396053;
        
        
            
        
        
        
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.254 -0400", hash_original_method = "CCB59B7D57EBC2BB253C2DA42141CFB6", hash_generated_method = "084A6EBE4D0D240C368A8E7D48412425")
     void touchUpOnTextField(MotionEvent event) {
        {
            boolean varF4B4E2AD6FDD8C203E6AF24A1C36EF5D_1014571108 = (!inEditingMode());
        } 
        int x = viewToContentX((int) event.getX() + mWebTextView.getLeft());
        int y = viewToContentY((int) event.getY() + mWebTextView.getTop());
        int slop = viewToContentDimension(mNavSlop);
        nativeMotionUp(x, y, slop);
        addTaint(event.getTaint());
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.255 -0400", hash_original_method = "035659BEB020AB9C28AA205B5DB17F79", hash_generated_method = "07B7429CE92B5FFBFFF85A5139F60BF3")
     void centerKeyPressOnTextField() {
        mWebViewCore.sendMessage(EventHub.CLICK, nativeCursorFramePointer(),
                    nativeCursorNodePointer());
        
        
                    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.256 -0400", hash_original_method = "587EA2695180238A6D2AA2CD9C2DE7DA", hash_generated_method = "39533823539CF49A203EE7163210F0BC")
    private void doShortPress() {
        mTouchMode = TOUCH_DONE_MODE;
        updateSelection();
        switchOutDrawHistory();
        int contentX = viewToContentX(mLastTouchX + mScrollX);
        int contentY = viewToContentY(mLastTouchY + mScrollY);
        int slop = viewToContentDimension(mNavSlop);
        {
            boolean var4BAF6D43948FA1BCD9CF85CF914BDF89_155994267 = (USE_WEBKIT_RINGS && !mTouchHighlightRegion.isEmpty());
            {
                mTouchHighlightRequested = 0;
                invalidate(mTouchHighlightRegion.getBounds());
                mPrivateHandler.postDelayed(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.255 -0400", hash_original_method = "862A653E9B61CDCF6EC82472350CCAAA", hash_generated_method = "E8C29D6A71E7E23B309BC73E875C4F22")
                    @Override
                    public void run() {
                        removeTouchHighlight();
                        
                        
                    }
}, ViewConfiguration.getPressedStateDuration());
            } 
        } 
        {
            boolean var5F51EF0491BBB7096F9C5C6CD4BCA197_1048282814 = (getSettings().supportTouchOnly());
            {
                removeTouchHighlight();
                WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
                touchUpData.mMoveGeneration = 0;
                mWebViewCore.sendMessage(EventHub.TOUCH_UP, touchUpData);
            } 
            {
                boolean varDA83C45CB8F2A6B5FD9F88AE0C10D3FD_206394172 = (nativePointInNavCache(contentX, contentY, slop));
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
                } 
                {
                    doMotionUp(contentX, contentY);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.256 -0400", hash_original_method = "1E7A23E4171AF135A41457A6A5A2ABBA", hash_generated_method = "722FA257059B376B204593E54FAE38E2")
    private void doMotionUp(int contentX, int contentY) {
        int slop = viewToContentDimension(mNavSlop);
        {
            boolean varC55016010C379CE34BF3B6896DDAD394_545211838 = (nativeMotionUp(contentX, contentY, slop) && mLogEvent);
            {
                EventLog.writeEvent(EventLogTags.BROWSER_SNAP_CENTER);
            } 
        } 
        {
            boolean var7C1BED8D4E1F2400404C847BC14812AF_188860347 = (nativeHasCursorNode() && !nativeCursorIsTextInput());
            {
                playSoundEffect(SoundEffectConstants.CLICK);
            } 
        } 
        addTaint(contentX);
        addTaint(contentY);
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.257 -0400", hash_original_method = "BED1306FE0550DFB625B165B53E3B66F", hash_generated_method = "C93F605E15A477EBB506444304D44C5C")
     void sendPluginDrawMsg() {
        mWebViewCore.sendMessage(EventHub.PLUGIN_SURFACE_READY);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.258 -0400", hash_original_method = "D3A185A17D693CB3B7C02952CB7AEB22", hash_generated_method = "5CA71B8A5D02738A905E972799F9562B")
     Rect getPluginBounds(int x, int y) {
        Rect varB4EAC82CA7396A68D541C85D26508E83_738033477 = null; 
        Rect varB4EAC82CA7396A68D541C85D26508E83_749421613 = null; 
        int slop = viewToContentDimension(mNavSlop);
        {
            boolean varE761D0BE351A5DB0C46D78ECBD6C783A_1810086499 = (nativePointInNavCache(x, y, slop) && nativeCacheHitIsPlugin());
            {
                varB4EAC82CA7396A68D541C85D26508E83_738033477 = nativeCacheHitNodeBounds();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_749421613 = null;
            } 
        } 
        addTaint(x);
        addTaint(y);
        Rect varA7E53CE21691AB073D9660D615818899_979399580; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_979399580 = varB4EAC82CA7396A68D541C85D26508E83_738033477;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_979399580 = varB4EAC82CA7396A68D541C85D26508E83_749421613;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_979399580.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_979399580;
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.259 -0400", hash_original_method = "DC9D6EF2856B92F6E87ED36BA942B258", hash_generated_method = "BE0855144519BEE9ACD3F8E94536D8D2")
     boolean isRectFitOnScreen(Rect rect) {
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        boolean var21C05C69D4E6BB9F2891D7DC21CA89A0_1552567026 = (!mZoomManager.willScaleTriggerZoom(scale)
                && contentToViewX(rect.left) >= mScrollX
                && contentToViewX(rect.right) <= mScrollX + viewWidth
                && contentToViewY(rect.top) >= mScrollY
                && contentToViewY(rect.bottom) <= mScrollY + viewHeight);
        addTaint(rect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126233755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126233755;
        
        
        
        
        
        
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.260 -0400", hash_original_method = "B66E52833C3805904E708A792E852C4F", hash_generated_method = "E84AA86E6571F62700F0F398A66CCB0B")
     void centerFitRect(Rect rect) {
        final int rectWidth = rect.width();
        final int rectHeight = rect.height();
        final int viewWidth = getViewWidth();
        final int viewHeight = getViewHeightWithTitle();
        float scale = Math.min((float) viewWidth / rectWidth, (float) viewHeight
                / rectHeight);
        scale = mZoomManager.computeScaleWithLimits(scale);
        {
            boolean varDD6431018C58684D7A37FFB96BEA1A10_1908039769 = (!mZoomManager.willScaleTriggerZoom(scale));
            {
                pinScrollTo(contentToViewX(rect.left + rectWidth / 2) - viewWidth / 2,
                    contentToViewY(rect.top + rectHeight / 2) - viewHeight / 2,
                    true, 0);
            } 
            {
                float actualScale = mZoomManager.getScale();
                float oldScreenX = rect.left * actualScale - mScrollX;
                float rectViewX = rect.left * scale;
                float rectViewWidth = rectWidth * scale;
                float newMaxWidth = mContentWidth * scale;
                float newScreenX = (viewWidth - rectViewWidth) / 2;
                {
                    newScreenX = rectViewX;
                } 
                {
                    newScreenX = viewWidth - (newMaxWidth - rectViewX);
                } 
                float zoomCenterX = (oldScreenX * scale - newScreenX * actualScale)
                    / (scale - actualScale);
                float oldScreenY = rect.top * actualScale + getTitleHeight()
                    - mScrollY;
                float rectViewY = rect.top * scale + getTitleHeight();
                float rectViewHeight = rectHeight * scale;
                float newMaxHeight = mContentHeight * scale + getTitleHeight();
                float newScreenY = (viewHeight - rectViewHeight) / 2;
                {
                    newScreenY = rectViewY;
                } 
                {
                    newScreenY = viewHeight - (newMaxHeight - rectViewY);
                } 
                float zoomCenterY = (oldScreenY * scale - newScreenY * actualScale)
                    / (scale - actualScale);
                mZoomManager.setZoomCenter(zoomCenterX, zoomCenterY);
                mZoomManager.startZoomAnimation(scale, false);
            } 
        } 
        addTaint(rect.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.261 -0400", hash_original_method = "847080961D49DB66DC7CCC3281C33F59", hash_generated_method = "65473085A53A9B680000D16ABFD331DC")
    private void overrideLoading(String url) {
        mCallbackProxy.uiOverrideUrlLoading(url);
        addTaint(url.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.261 -0400", hash_original_method = "691C64C606B2F351F3DACFC131AE0C5B", hash_generated_method = "605555808ED5F98929CB2000B50429D3")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        boolean result = false;
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_2095896096 = (inEditingMode());
            {
                result = mWebTextView.requestFocus(direction,
                    previouslyFocusedRect);
            } 
            {
                result = super.requestFocus(direction, previouslyFocusedRect);
                {
                    boolean varA494CE1F4ADF8E7072392AACBFD5D724_1441014444 = (mWebViewCore.getSettings().getNeedInitialFocus() && !isInTouchMode());
                    {
                        int fakeKeyDirection = 0;
                        
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_UP;
                        
                        
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_DOWN;
                        
                        
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_LEFT;
                        
                        
                        fakeKeyDirection = KeyEvent.KEYCODE_DPAD_RIGHT;
                        
                        {
                            boolean var191048386196A56D55A1FA6B9EBCC1D7_730219911 = (mNativeClass != 0 && !nativeHasCursorNode());
                            {
                                navHandledKey(fakeKeyDirection, 1, true, 0);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136262753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136262753;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.262 -0400", hash_original_method = "B3C79783D1B73E1F2F2D459408EF6637", hash_generated_method = "74E87C6658AB4D24F69114429E64ACDD")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int measuredHeight = heightSize;
        int measuredWidth = widthSize;
        int contentHeight = contentToViewDimension(mContentHeight);
        int contentWidth = contentToViewDimension(mContentWidth);
        {
            mHeightCanMeasure = true;
            measuredHeight = contentHeight;
            {
                {
                    measuredHeight = heightSize;
                    mHeightCanMeasure = false;
                    measuredHeight |= MEASURED_STATE_TOO_SMALL;
                } 
            } 
        } 
        {
            mHeightCanMeasure = false;
        } 
        {
            nativeSetHeightCanMeasure(mHeightCanMeasure);
        } 
        {
            mWidthCanMeasure = true;
            measuredWidth = contentWidth;
        } 
        {
            {
                measuredWidth |= MEASURED_STATE_TOO_SMALL;
            } 
            mWidthCanMeasure = false;
        } 
        {
            setMeasuredDimension(measuredWidth, measuredHeight);
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.262 -0400", hash_original_method = "2BFDB3D81C6D917EC4CB2C36361E36DD", hash_generated_method = "34EB2CEF4BCAC33A8860C27239F122AF")
    @Override
    public boolean requestChildRectangleOnScreen(View child,
                                                 Rect rect,
                                                 boolean immediate) {
        {
            boolean var264B566DF21DF74851E1F42772AB9C13_557909567 = (mZoomManager.isFixedLengthAnimationInProgress());
        } 
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
        {
            int oneThirdOfScreenHeight = height / 3;
            {
                boolean varD63CDEF6BD028FCFFAC8F4D0CD965025_2032379288 = (rect.height() > 2 * oneThirdOfScreenHeight);
                {
                    scrollYDelta = rect.top - screenTop;
                } 
                {
                    scrollYDelta = rect.top - (screenTop + oneThirdOfScreenHeight);
                } 
            } 
        } 
        {
            scrollYDelta = rect.top - screenTop;
        } 
        int screenLeft = contentToViewX(content.left);
        int screenRight = contentToViewX(content.right);
        int width = screenRight - screenLeft;
        int scrollXDelta = 0;
        {
            {
                boolean varAE73F3F4DF09B867223301D92BC7E6F0_731748358 = (rect.width() > width);
                {
                    scrollXDelta += (rect.left - screenLeft);
                } 
                {
                    scrollXDelta += (rect.right - screenRight);
                } 
            } 
        } 
        {
            scrollXDelta -= (screenLeft - rect.left);
        } 
        {
            boolean var5E8E4CF43F6392F54248EF881F3D0871_81612585 = (pinScrollBy(scrollXDelta, scrollYDelta, !immediate, 0));
        } 
        addTaint(child.getTaint());
        addTaint(rect.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573506984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573506984;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.263 -0400", hash_original_method = "9DCDBD91FCFEDA12D8B253252355D461", hash_generated_method = "A45BE8CAE06FC50D5BCB738CC4008C0B")
     void replaceTextfieldText(int oldStart, int oldEnd,
            String replace, int newStart, int newEnd) {
        WebViewCore.ReplaceTextData arg = new WebViewCore.ReplaceTextData();
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
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.263 -0400", hash_original_method = "8DF2FF9E9DCDD713805C578C2A03D87C", hash_generated_method = "3B643A7F0BDD580CC8DBB999FE44A530")
     void passToJavaScript(String currentText, KeyEvent event) {
        WebViewCore.JSKeyData arg = new WebViewCore.JSKeyData();
        arg.mEvent = event;
        arg.mCurrentText = currentText;
        mWebViewCore.sendMessage(EventHub.PASS_TO_JS, mTextGeneration, 0, arg);
        mWebViewCore.removeMessages(EventHub.SAVE_DOCUMENT_STATE);
        mWebViewCore.sendMessageDelayed(EventHub.SAVE_DOCUMENT_STATE,
                cursorData(), 1000);
        addTaint(currentText.getTaint());
        addTaint(event.getTaint());
        
        
            
        
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.264 -0400", hash_original_method = "9E9681EB8914AFEDBD59BEDC85F3A0A3", hash_generated_method = "6ACAFA145EAD2B911B21FF242758AD91")
    public synchronized WebViewCore getWebViewCore() {
        WebViewCore varB4EAC82CA7396A68D541C85D26508E83_957640153 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_957640153 = mWebViewCore;
        varB4EAC82CA7396A68D541C85D26508E83_957640153.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_957640153;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.282 -0400", hash_original_method = "231BBD0BB3D07F6E430EE6811E6CB666", hash_generated_method = "3B39F297BDCB49D2C3E0E4D7F2A5FD67")
    private void setTouchHighlightRects(ArrayList<Rect> rects) {
        invalidate(mTouchHighlightRegion.getBounds());
        mTouchHighlightRegion.setEmpty();
        {
            {
                Iterator<Rect> var667F73C18A060295B52BA65D5642C74D_890733128 = (rects).iterator();
                var667F73C18A060295B52BA65D5642C74D_890733128.hasNext();
                Rect rect = var667F73C18A060295B52BA65D5642C74D_890733128.next();
                {
                    Rect viewRect = contentToViewRect(rect);
                    {
                        boolean varA5A6B8C49AB9156241CF88CA93A69E58_1703713003 = (viewRect.width() < getWidth() >> 1
                        || viewRect.height() < getHeight() >> 1);
                        {
                            mTouchHighlightRegion.union(viewRect);
                        } 
                    } 
                } 
            } 
            invalidate(mTouchHighlightRegion.getBounds());
        } 
        addTaint(rects.getTaint());
        
        
        
        
            
                
                
                        
                    
                
                    
                            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.282 -0400", hash_original_method = "DD697F875647141F1D50DBA1CC27AA2B", hash_generated_method = "427EAAB37C3DA966BEAD43DB447E63F0")
    protected void pageSwapCallback(boolean notifyAnimationStarted) {
        {
            boolean varA3F78F0FFF8DCFA8325B8A0EE1160508_1317715600 = (inEditingMode());
            {
                didUpdateWebTextViewDimensions(ANYWHERE);
            } 
        } 
        {
            mWebViewCore.sendMessage(EventHub.NOTIFY_ANIMATION_STARTED);
        } 
        addTaint(notifyAnimationStarted);
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.283 -0400", hash_original_method = "425ACB704C87DFAC733173C352BB3607", hash_generated_method = "37618FC3B056E004D02C380451DADC5A")
     void setNewPicture(final WebViewCore.DrawData draw, boolean updateBaseLayer) {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Tried to setNewPicture with"
                        + " a delay picture already set! (memory leak)");
            } 
            mDelaySetPicture = draw;
        } 
        WebViewCore.ViewState viewState = draw.mViewState;
        boolean isPictureAfterFirstLayout = viewState != null;
        {
            boolean registerPageSwapCallback = !mZoomManager.isFixedLengthAnimationInProgress() && inEditingMode();
            setBaseLayer(draw.mBaseLayer, draw.mInvalRegion,
                    getSettings().getShowVisualIndicator(),
                    isPictureAfterFirstLayout, registerPageSwapCallback);
        } 
        final Point viewSize = draw.mViewSize;
        final boolean updateLayout = viewSize.x == mLastWidthSent
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
            int scrollY = viewState.mScrollY;
            setContentScrollTo(scrollX, scrollY);
            {
                clearTextEntry();
            } 
        } 
        mSendScrollEvent = true;
        {
            Rect b = draw.mInvalRegion.getBounds();
        } 
        invalidateContentRect(draw.mInvalRegion.getBounds());
        {
            mPictureListener.onNewPicture(WebView.this, capturePicture());
        } 
        mZoomManager.onNewPicture(draw);
        {
            boolean var926A8D0B5C0D740061680329138C210C_6349299 = (draw.mFocusSizeChanged && inEditingMode());
            {
                mFocusSizeChanged = true;
            } 
        } 
        {
            mViewManager.postReadyToDrawAll();
        } 
        addTaint(updateBaseLayer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.284 -0400", hash_original_method = "410F6FE259AD698FE0C8F471085A619D", hash_generated_method = "BDA00880E537194F58D7C3D76E821FF7")
    private void updateTextSelectionFromMessage(int nodePointer,
            int textGeneration, WebViewCore.TextSelectionData data) {
        {
            boolean var179B09369C5FEC85CD8155FF224AECDC_2119366443 = (inEditingMode()
                && mWebTextView.isSameTextField(nodePointer)
                && textGeneration == mTextGeneration);
            {
                mWebTextView.setSelectionFromWebKit(data.mStart, data.mEnd);
            } 
        } 
        addTaint(nodePointer);
        addTaint(textGeneration);
        addTaint(data.getTaint());
        
        
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.284 -0400", hash_original_method = "16D6BAB9A7D75CB7761DB162A42C30B0", hash_generated_method = "72518D41A969F6AADA3274F045C6C4AB")
     void requestListBox(String[] array, int[] enabledArray, int[]
            selectedArray) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selectedArray));
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selectedArray[0]);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.285 -0400", hash_original_method = "DFD9151F49FF1E4FE4A084739CADF16D", hash_generated_method = "4BBC44FF944EEE25CEBCF2D60BC591B7")
     void requestListBox(String[] array, int[] enabledArray, int selection) {
        mPrivateHandler.post(
                new InvokeListBox(array, enabledArray, selection));
        addTaint(array[0].getTaint());
        addTaint(enabledArray[0]);
        addTaint(selection);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.285 -0400", hash_original_method = "9B3CC3105C503DB54A28E02BA06BD886", hash_generated_method = "C0A6683432D88BABDE764CF7D9D48742")
    private void sendMoveFocus(int frame, int node) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_FOCUS,
                new WebViewCore.CursorData(frame, node, 0, 0));
        addTaint(frame);
        addTaint(node);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.285 -0400", hash_original_method = "676A1DFE7D55EA50FF767CCBEF73038A", hash_generated_method = "DE647C1BE362E83812C6348952960A3D")
    private void sendMoveMouse(int frame, int node, int x, int y) {
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE,
                new WebViewCore.CursorData(frame, node, x, y));
        addTaint(frame);
        addTaint(node);
        addTaint(x);
        addTaint(y);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.286 -0400", hash_original_method = "A9BB88C1B996C560A53605B008D4B193", hash_generated_method = "706049A02288C924DEFA0547590CF367")
    @SuppressWarnings("unused")
    private void sendMoveMouseIfLatest(boolean removeFocus, boolean stopPaintingCaret) {
        {
            clearTextEntry();
        } 
        mWebViewCore.sendMessage(EventHub.SET_MOVE_MOUSE_IF_LATEST,
                stopPaintingCaret ? 1 : 0, 0,
                cursorData());
        addTaint(removeFocus);
        addTaint(stopPaintingCaret);
        
        
            
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.286 -0400", hash_original_method = "5F7CCC7C6BE5794AFB5E2A4E37472C6C", hash_generated_method = "D7087CF415B618059D53B85EA23126F7")
    private void sendMotionUp(int touchGeneration,
            int frame, int node, int x, int y) {
        WebViewCore.TouchUpData touchUpData = new WebViewCore.TouchUpData();
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
        
        
        
        
        
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.286 -0400", hash_original_method = "97CBEAC381039721C67FB90272936008", hash_generated_method = "B1A6E8C2DFD5832F4F26E8BD9DBDD3CA")
    private int getScaledMaxXScroll() {
        int width;
        {
            width = getViewWidth() / 4;
        } 
        {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            width = visRect.width() / 2;
        } 
        int var4CD57EC65F046B376944293A38E9A187_1153331563 = (viewToContentX(width));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581777689 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581777689;
        
        
        
            
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.287 -0400", hash_original_method = "0E981DAE407E215BB1F63BA2BC3A6528", hash_generated_method = "65CDBC0C67653F0AB312B11E81774A08")
    private int getScaledMaxYScroll() {
        int height;
        {
            height = getViewHeight() / 4;
        } 
        {
            Rect visRect = new Rect();
            calcOurVisibleRect(visRect);
            height = visRect.height() / 2;
        } 
        int var3B6C50355F4C83B6515E3BB844F5C669_1047023311 = (Math.round(height * mZoomManager.getInvScale()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146176024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146176024;
        
        
        
            
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.287 -0400", hash_original_method = "3D16E8C41705C4F17CEB73CEF0309E84", hash_generated_method = "43791F1CBB48DBD139A4E7B1FDB49008")
    private void viewInvalidate() {
        invalidate();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.287 -0400", hash_original_method = "AE882AB879F5D1C777FA8D86AE17F1CA", hash_generated_method = "FB249104308509CD39074C1E07D6FD9A")
    private void letPageHandleNavKey(int keyCode, long time, boolean down, int metaState) {
        int keyEventAction;
        int eventHubAction;
        {
            keyEventAction = KeyEvent.ACTION_DOWN;
            eventHubAction = EventHub.KEY_DOWN;
            playSoundEffect(keyCodeToSoundsEffect(keyCode));
        } 
        {
            keyEventAction = KeyEvent.ACTION_UP;
            eventHubAction = EventHub.KEY_UP;
        } 
        KeyEvent event = new KeyEvent(time, time, keyEventAction, keyCode,
                1, (metaState & KeyEvent.META_SHIFT_ON)
                | (metaState & KeyEvent.META_ALT_ON)
                | (metaState & KeyEvent.META_SYM_ON)
                , KeyCharacterMap.VIRTUAL_KEYBOARD, 0, 0);
        mWebViewCore.sendMessage(eventHubAction, event);
        addTaint(keyCode);
        addTaint(time);
        addTaint(down);
        addTaint(metaState);
        
        
        
        
            
            
            
        
            
            
        
        
                
                
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.288 -0400", hash_original_method = "5CECE89A14EDD8F6809BD94CD59D9DF4", hash_generated_method = "C90415970BCE144F60B755BB437AD949")
    private boolean navHandledKey(int keyCode, int count, boolean noScroll,
            long time) {
        mInitialHitTestResult = null;
        mLastCursorTime = time;
        mLastCursorBounds = nativeGetCursorRingBounds();
        boolean keyHandled = nativeMoveCursor(keyCode, count, noScroll) == false;
        Rect contentCursorRingBounds = nativeGetCursorRingBounds();
        {
            boolean var78E9DE151C1DFEF7820F7C4599A2F8D0_103513542 = (contentCursorRingBounds.isEmpty());
        } 
        Rect viewCursorRingBounds = contentToViewRect(contentCursorRingBounds);
        mLastTouchX = (viewCursorRingBounds.left + viewCursorRingBounds.right) / 2;
        mLastTouchY = (viewCursorRingBounds.top + viewCursorRingBounds.bottom) / 2;
        Rect visRect = new Rect();
        calcOurVisibleRect(visRect);
        Rect outset = new Rect(visRect);
        int maxXScroll = visRect.width() / 2;
        int maxYScroll = visRect.height() / 2;
        outset.inset(-maxXScroll, -maxYScroll);
        {
            boolean varB6D877D107F828AA26477AA9FEE04EDD_1710449557 = (Rect.intersects(outset, viewCursorRingBounds) == false);
        } 
        int maxH = Math.min(viewCursorRingBounds.right - visRect.right,
                maxXScroll);
        {
            pinScrollBy(maxH, 0, true, 0);
        } 
        {
            maxH = Math.max(viewCursorRingBounds.left - visRect.left,
                    -maxXScroll);
            {
                pinScrollBy(maxH, 0, true, 0);
            } 
        } 
        {
            boolean var6A8A4E436D7412BEF448043644BD31DB_57764583 = (mLastCursorBounds.isEmpty());
        } 
        {
            boolean var46EFF7D5420AE1A7A30F7E288D313B74_854123999 = (mLastCursorBounds.equals(contentCursorRingBounds));
        } 
        requestRectangleOnScreen(viewCursorRingBounds);
        addTaint(keyCode);
        addTaint(count);
        addTaint(noScroll);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657871649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657871649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.289 -0400", hash_original_method = "32BD565DE772EAA014BAC9C9F2C97315", hash_generated_method = "532DEB102DF9CA4E589F44849288BE45")
    private boolean accessibilityScriptInjected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247876817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247876817;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.289 -0400", hash_original_method = "7544C03241648A3354186187AA9F4EF5", hash_generated_method = "1D06CA9D32CB95134D9BA15854D3E735")
    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
        mWebViewCore.sendMessage(EventHub.SET_BACKGROUND_COLOR, color);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.289 -0400", hash_original_method = "320D93ED3FE4BB21AF7B96209103BAEA", hash_generated_method = "85CCCEA00CCFC3C2990DD68DC174D234")
    @Deprecated
    public void debugDump() {
        checkThread();
        nativeDebugDump();
        mWebViewCore.sendMessage(EventHub.DUMP_NAVTREE);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.289 -0400", hash_original_method = "D2F7EB276C06F981CB2DDCC2D4FDE965", hash_generated_method = "740E405FE2A3E71A6CDDF433E033281A")
    public void drawPage(Canvas canvas) {
        calcOurContentVisibleRectF(mVisibleContentRect);
        nativeDraw(canvas, mVisibleContentRect, 0, 0, false);
        addTaint(canvas.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.290 -0400", hash_original_method = "74367596F95573C97AD83A4084EC0CCE", hash_generated_method = "60F0103DEBE1A0FA6D924B8BF32F9420")
    public void setHTML5VideoViewProxy(HTML5VideoViewProxy proxy) {
        mHTML5VideoViewProxy = proxy;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.290 -0400", hash_original_method = "3903E5FDBADBBF10F8555758708758EA", hash_generated_method = "0341554DA62305A207D3B8C95E999187")
    public void setTouchInterval(int interval) {
        mCurrentTouchInterval = interval;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.290 -0400", hash_original_method = "92F0F0981ADBE35814BFFD03DF7418C4", hash_generated_method = "F15B8CC0375CD9B31A9185033241B3A6")
    protected void updateCachedTextfield(String updatedText) {
        nativeUpdateCachedTextfield(updatedText, mTextGeneration);
        addTaint(updatedText.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.290 -0400", hash_original_method = "3CF6C47456C4627A4E71259B24DD81E5", hash_generated_method = "99F7C082FAD063DA8B04C011BE0023E3")
     void autoFillForm(int autoFillQueryId) {
        mWebViewCore.sendMessage(EventHub.AUTOFILL_FORM, autoFillQueryId, 0);
        addTaint(autoFillQueryId);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.291 -0400", hash_original_method = "D7B2726C13999E8A86361BD414F1463C", hash_generated_method = "42B86BC72D9CF2B6B71B5A6190BDE8E3")
     ViewManager getViewManager() {
        ViewManager varB4EAC82CA7396A68D541C85D26508E83_1971455825 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1971455825 = mViewManager;
        varB4EAC82CA7396A68D541C85D26508E83_1971455825.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1971455825;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.291 -0400", hash_original_method = "F114C181662976B0748914D06833E4C4", hash_generated_method = "2C8A3F643487BF9C4C932C87B894FD6E")
    protected void contentInvalidateAll() {
        {
            mWebViewCore.sendMessage(EventHub.CONTENT_INVALIDATE_ALL);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.291 -0400", hash_original_method = "1FF0BF24E873DB84A51E12C89558A9C5", hash_generated_method = "14F0772081BF82E7E18655BBAC5A6F22")
    protected void registerPageSwapCallback() {
        nativeRegisterPageSwapCallback();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.291 -0400", hash_original_method = "78011EF84CA4BFD753BA4CD3D418707C", hash_generated_method = "EAF06CEEDE2D5E5967608F86C355FE16")
    public void tileProfilingStart() {
        nativeTileProfilingStart();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.292 -0400", hash_original_method = "32002139586DB6CB41F7EC0F15CAA909", hash_generated_method = "E320EE64EDDAEE93B470D39F22BD5341")
    public float tileProfilingStop() {
        float varB18687EE139E5166CC9AF408D9889054_603454298 = (nativeTileProfilingStop());
        float var546ADE640B6EDFBC8A086EF31347E768_961288806 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_961288806;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.292 -0400", hash_original_method = "D8A15D848E8D038C149DEA2A80E82057", hash_generated_method = "8FDB7E2C7A9F51E9629172BAF0B24960")
    public void tileProfilingClear() {
        nativeTileProfilingClear();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.292 -0400", hash_original_method = "F0EFA667D5FE086F8525F77F744D7E51", hash_generated_method = "526510F792EE3FDB6275EFE335528E01")
    public int tileProfilingNumFrames() {
        int var169947B5FA60947E0B7BC7984522118F_1955652625 = (nativeTileProfilingNumFrames());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240731887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_240731887;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.292 -0400", hash_original_method = "CF8277545826DEA2EBA7C1A26519CDD4", hash_generated_method = "1F54CE58BD6CB9DB9A9120104391D6A7")
    public int tileProfilingNumTilesInFrame(int frame) {
        int varFDE1A8CA934CC4FCCFE59320104D4907_1078770870 = (nativeTileProfilingNumTilesInFrame(frame));
        addTaint(frame);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408516598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408516598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.293 -0400", hash_original_method = "2372189F21F0B42B206CEFCF7562FB37", hash_generated_method = "D944F0CCC87ABE93C3B9B4B78C3A14A6")
    public int tileProfilingGetInt(int frame, int tile, String key) {
        int varE7654B1D69F1E5F05A936A8E62104F88_534732172 = (nativeTileProfilingGetInt(frame, tile, key));
        addTaint(frame);
        addTaint(tile);
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88880752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88880752;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.293 -0400", hash_original_method = "C6C564D8914C6385ADD2286893F549C6", hash_generated_method = "B2F28A221838EEC02BC9D31EBA6482E3")
    public float tileProfilingGetFloat(int frame, int tile, String key) {
        float varFC830259BB0CC6250B57A21E07835342_1881087455 = (nativeTileProfilingGetFloat(frame, tile, key));
        addTaint(frame);
        addTaint(tile);
        addTaint(key.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1210886025 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1210886025;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.293 -0400", hash_original_method = "AD2D640C3667F77EA8D9A6F6AFA42937", hash_generated_method = "321A598B9EA7A08C50920125DF55FD16")
    private int nativeCacheHitFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89830374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_89830374;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.293 -0400", hash_original_method = "C5535D5868AF8EFE71BDF7284C12F351", hash_generated_method = "2A9C10B1A8BA18FF1F5FCC6403A75DF7")
    private boolean nativeCacheHitIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790871375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790871375;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "C7D338FF64B881B2FAA82154B2896288", hash_generated_method = "C211C5C405AAE9953CCBBEEF22D45B31")
    private Rect nativeCacheHitNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "E7CF5B837B37AF1FB0FFA94B1E5A9C49", hash_generated_method = "007D8B606161EFD4C610C8DE5DBE4B9F")
    private int nativeCacheHitNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863031923 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863031923;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "21C51F3D001D4692500D45D045D1D1A2", hash_generated_method = "2C929D3168FE3E72D461E6649B6EC306")
     void nativeClearCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "D5BD5BC1C047EF29A0BA74787ABFA8DB", hash_generated_method = "7DFA4BA9D9D2F081C4674D9A23AF40D6")
    private void nativeCreate(int ptr, String drawableDir, boolean isHighEndGfx) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.294 -0400", hash_original_method = "12D518518F45FEF02F029B364840A9CD", hash_generated_method = "804D0084D6C283A843E091EC4BE740A8")
    private int nativeCursorFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067539569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067539569;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "843882909A38B2FC0D8F4867EE2AC0A0", hash_generated_method = "E271E918D4C574FDDE4719E4B98A8B2B")
    private Rect nativeCursorNodeBounds() {
    	return new Rect();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "F74724E9A0C85C98C40FDE06FDCC4B7E", hash_generated_method = "831F48CD64451AD326D17E68C78906DC")
    private int nativeCursorNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461270621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461270621;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "0CCAA8E51DFECB80A1DAAA18BBAA93E1", hash_generated_method = "7BE9839CA8AB04C00421D8962961A333")
    private boolean nativeCursorIntersects(Rect visibleRect) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1025240703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1025240703;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.295 -0400", hash_original_method = "8A09EF437BF7C2698409EA0A7A76891D", hash_generated_method = "FE4ADE4F0B5F2FB98BA36F5CC3A81439")
    private boolean nativeCursorIsAnchor() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421134912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421134912;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "EE630232B25B714D7F7B153A20D259D0", hash_generated_method = "ADE207A01EDF777F3E185785C3C63AD3")
    private boolean nativeCursorIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131245656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131245656;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "CB263EC43145C659054742CE0640D198", hash_generated_method = "2045A184BB97A2996B1887CC917B0804")
    private Point nativeCursorPosition() {
    	
    	return new Point();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "05985317D344F6F01EE48FCED9442B85", hash_generated_method = "3E24BE9E7EBDB8C5312CC587887CD85C")
    private String nativeCursorText() {
    	return new String();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "883A2B6BC8DFA6DE2AE51F0C99D32AC6", hash_generated_method = "E6E17FF2BCD2C628E5794E66D9715B8D")
    private boolean nativeCursorWantsKeyEvents() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715829123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715829123;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.296 -0400", hash_original_method = "BCDACACF9A7294298FFE59BBEA2E56E6", hash_generated_method = "F601101523F054AD48972FF053FC6215")
    private void nativeDebugDump() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.297 -0400", hash_original_method = "E34EA3919C76BD220428BD59B66C56DD", hash_generated_method = "1439525E8540D7F69358452344174A0D")
    private void nativeDestroy() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.297 -0400", hash_original_method = "C2ECE2AA332B7BCDEACB0B8BAB186CAE", hash_generated_method = "5BB7B1A8CCF4941EA0743B341B0680CE")
    private int nativeDraw(Canvas canvas, RectF visibleRect,
            int color, int extra, boolean splitIfNeeded) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729756016 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729756016;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.297 -0400", hash_original_method = "B94EBE52746C23266AA56FE8E26D2041", hash_generated_method = "DEC3E2BF23E95688EF02A9D60A934BC6")
    private void nativeDumpDisplayTree(String urlOrNull) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.297 -0400", hash_original_method = "37CA92648450960165CE0DC4D7461803", hash_generated_method = "C8933FC5725D5ECC7D426DA5A3E25463")
    private boolean nativeEvaluateLayersAnimations(int nativeInstance) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260473596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260473596;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.297 -0400", hash_original_method = "AC4C8B7485570D2501FDB7D14AD52EF3", hash_generated_method = "A717151181B62D2A8B6F4E62DE191E9C")
    private int nativeGetDrawGLFunction(int nativeInstance, Rect rect,
            Rect viewRect, RectF visibleRect, float scale, int extras) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415448749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_415448749;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.298 -0400", hash_original_method = "5F36FDF1F0F523C00D52E094440893E0", hash_generated_method = "CE8A8077BABA841A2AD2D59A5548E6AE")
    private void nativeUpdateDrawGLFunction(Rect rect, Rect viewRect,
            RectF visibleRect) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.298 -0400", hash_original_method = "20D90A20109930F09B8AC2021CC572AC", hash_generated_method = "AAD4FC58EFA073FDC913BA79EDD7DCDA")
    private void nativeExtendSelection(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.298 -0400", hash_original_method = "985C1C45895761A3003321E2C6FD0B56", hash_generated_method = "11DC1172052E40C290A2DF2E8F4C52BA")
    private int nativeFindAll(String findLower, String findUpper,
            boolean sameAsLastSearch) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315810441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1315810441;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.298 -0400", hash_original_method = "E9CD8F854D329A9FF8E3CC0A72C785E4", hash_generated_method = "937E5B11B8379FE5830DBA653F9B7999")
    private void nativeFindNext(boolean forward) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.298 -0400", hash_original_method = "EABE56EC33C0D8AE2F7016F541E31965", hash_generated_method = "9C13CAB2DD1A3C783E8E38BC42916081")
     int nativeFocusCandidateFramePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787334893 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_787334893;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "7C3995367E82B6D7312732D654157F4F", hash_generated_method = "370DCFBAF79FC79630CC0AB872D52381")
     boolean nativeFocusCandidateHasNextTextfield() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134143428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134143428;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "24F608E9C25D3CEA18DC40F168470BAE", hash_generated_method = "22855BF4561EADEFC9CA3B75ED54DF19")
     boolean nativeFocusCandidateIsPassword() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252160613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252160613;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "CA3BBE06DE230A233DBE6462F7BDC345", hash_generated_method = "FD6DB1721C60C932CCCC3FA1DF4578E0")
    private boolean nativeFocusCandidateIsRtlText() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849490932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849490932;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "FC5F0AF7060BA9D9D74BB55FE6CCEE91", hash_generated_method = "59449299BD55BCCB23FCEC6B2E803819")
    private boolean nativeFocusCandidateIsTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276130161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276130161;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "64EE2979CD9E511D4C9D292EB40853CA", hash_generated_method = "DB15833C1EA4B5F1E0CF1300C17E6E4F")
     int nativeFocusCandidateMaxLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035772968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2035772968;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.299 -0400", hash_original_method = "94ADCAD0C90E2D8B1D617C0CE4175108", hash_generated_method = "0E4231119E7D3EE7CB2EB8E26B986240")
     boolean nativeFocusCandidateIsAutoComplete() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342523229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_342523229;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "AC7BA3D73ADA11038E3573CC7BEA31D0", hash_generated_method = "DD135175E8F55F87574E4EC5BCAC72F6")
     boolean nativeFocusCandidateIsSpellcheck() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951870542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951870542;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "86B0A32819E6798AA0F2F34418D25901", hash_generated_method = "482EB255509BA82D443BAA9D71623788")
     String nativeFocusCandidateName() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "784E4422EBCAC3915206737F2EF978E9", hash_generated_method = "E9FE505188BFAFC647C681A775DCAAFD")
    private Rect nativeFocusCandidateNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "D493BA74B0D04E6E35C47B87F2973345", hash_generated_method = "8CA80E2A60FEEA9061A61B09DA68625A")
    private Rect nativeFocusCandidatePaddingRect() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "6C37516810160216239ECA2C27DBBDE1", hash_generated_method = "DAB518E7248CCB99FCC21EE04091DF64")
     int nativeFocusCandidatePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655035570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655035570;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "AA9102676E28CA1EE920093EBAB8030A", hash_generated_method = "B8D2D3434495629B87849A0DDE9761CA")
    private String nativeFocusCandidateText() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.300 -0400", hash_original_method = "4B89B6EF718BD6147261DEC98F6C6A16", hash_generated_method = "656E0D75A8990960188D64B98A2430CB")
     float nativeFocusCandidateTextSize() {
        float var546ADE640B6EDFBC8A086EF31347E768_202471343 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_202471343;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "082CC9662FD544AEC67B8D4963511576", hash_generated_method = "B5E00049CD4F8A9F146AE77D68DF29C3")
     int nativeFocusCandidateLineHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642828409 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_642828409;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "C99437A2BF0BA310505C74B618275504", hash_generated_method = "01477897C48EF06ABC0DF8254A0FB8F2")
    private int nativeFocusCandidateType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379550709 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1379550709;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "6657822939CE46802B84DA6445C72EDE", hash_generated_method = "71B838960EE15619DB777A105C284008")
    private int nativeFocusCandidateLayerId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170852794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170852794;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "38CCA0E50FE8BE9EE5C40886CF34F6A3", hash_generated_method = "E4562DB3A13D9D1FD1CC25FB827F4FC3")
    private boolean nativeFocusIsPlugin() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119367859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119367859;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "899095159EA7E211C628ECE871CC9E5E", hash_generated_method = "65244A088D15DCA1F0C3C7F2D973DFD4")
    private Rect nativeFocusNodeBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.301 -0400", hash_original_method = "2168CEA1D043FC34995E51661BDC9CBF", hash_generated_method = "09FB0B87E29F775C7811DFCC436B429A")
     int nativeFocusNodePointer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446492351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_446492351;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "6FF91C20F7461FC76B80187F5F0D17F4", hash_generated_method = "68114054688AC2ACF3B41A1E50F28F3A")
    private Rect nativeGetCursorRingBounds() {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "B8443DF7AEBDC7EB5C8A06305D57CB4B", hash_generated_method = "CAEC1387621E6EAAC0BBE851878D90E6")
    private String nativeGetSelection() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "FA5B299A908E966DB0A85AB880BBEA98", hash_generated_method = "489C9414961A8C19409D6A9ED36AFB89")
    private boolean nativeHasCursorNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509007134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509007134;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "1230EC94ADDF74636FD1B9B93024FF53", hash_generated_method = "34F72896BFFFA82B04D407EC980B57AC")
    private boolean nativeHasFocusNode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2128281885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2128281885;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "3CDE90299F8497C5A30DB753AD8E9AB4", hash_generated_method = "C5D686BF12DF1683258EF31789BFD66A")
    private void nativeHideCursor() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "6D847FD6DBE9A26EB9B01E37604B0ED1", hash_generated_method = "724D435BFFBD6A38CF468EFA5F7FD275")
    private boolean nativeHitSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804316481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804316481;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.302 -0400", hash_original_method = "D8C9CADCD399CD2B0D790CF6CE41AE1A", hash_generated_method = "68E20D0E121FE807EF3A683540460D64")
    private String nativeImageURI(int x, int y) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "289E95AB759FD8B3BECC4FA3039C950F", hash_generated_method = "4931CD211AE029703EBE8600C611C50A")
    private void nativeInstrumentReport() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "BE6268DADB8C47F15DBBDF42ECD48F77", hash_generated_method = "0EF9BAF6479325B7AFB630E9F288D638")
    private Rect nativeLayerBounds(int layer) {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "23983C5AE9F3B90E3D90CC6935289B58", hash_generated_method = "D4E20DDE30A48524240665AA463E1184")
     boolean nativeMoveCursorToNextTextInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932765078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932765078;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "7F3259156FFC0A38C18AAEF5C0591DB3", hash_generated_method = "BF1249223408503F2BE1B73CC8178EDB")
    private boolean nativeMotionUp(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134331200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134331200;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "094B8659C7254EEB01CFCE7FBFE8BBED", hash_generated_method = "5402A388B47DA7C7A26B0DE01AABFB25")
    private boolean nativeMoveCursor(int keyCode, int count,
            boolean noScroll) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339352095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339352095;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.303 -0400", hash_original_method = "748DDF93C93929F1CD9BE00B19B3BA55", hash_generated_method = "8BD2C624A7D950CF84857F47CC6EE483")
    private int nativeMoveGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109195430 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109195430;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "3DA7CADF6D4BEBD104A91ECB891DF4CA", hash_generated_method = "806420BABD34DA76CA52BDFCE6493234")
    private void nativeMoveSelection(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "05DCCA381B09C4BC3817018280EDAE42", hash_generated_method = "84BB33B3EBCF4473147475AA464C3DD6")
    private boolean nativePageShouldHandleShiftAndArrows() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162248701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162248701;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "0AA207E0F2BD4C326B970B5B7BF77061", hash_generated_method = "A7340D2C70E82F229BE735FDDF1E04D8")
    private boolean nativePointInNavCache(int x, int y, int slop) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842122433 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842122433;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "43FBFCC191D9F061753D0D417BC9C6C2", hash_generated_method = "7E164F51BFD26BAEB37C17707BD8874E")
    private void nativeResetSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "F89A02659B72CC4FB73CF3CB2176116A", hash_generated_method = "4FCCB0475B387C1F5318EC92944C45EC")
    private Point nativeSelectableText() {
    	Point p = new Point();
    	p.addTaint(taint);
    	return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.304 -0400", hash_original_method = "F11E44988F58D9D39319A53083CB7329", hash_generated_method = "5DACEC38ECF99BF3DA52929D8D3AE5DA")
    private void nativeSelectAll() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.305 -0400", hash_original_method = "AF42FC37DCBBE7E470931D41D8D7F10A", hash_generated_method = "3D9F4D8FE552F46EDFE668F28DAC36F3")
    private void nativeSelectBestAt(Rect rect) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.305 -0400", hash_original_method = "171731039A93A1C88CEFD0B973727269", hash_generated_method = "5DFA19011F6357FF14C8F2E2695F621D")
    private void nativeSelectAt(int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.305 -0400", hash_original_method = "76F5F718978066DCC4CD2ED10AE577B5", hash_generated_method = "F0F806D45544C9BC7253FEF749CA2943")
    private int nativeSelectionX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717350876 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717350876;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.305 -0400", hash_original_method = "E124736544D40704ACD3DCD907FAABD1", hash_generated_method = "4E16D3976FA7F348FA07EF6C563B67BD")
    private int nativeSelectionY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032343888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032343888;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "08AE00555578B509AEAB57063B9D57A8", hash_generated_method = "15A92B8CA4A8C98B5D6D22400AA9A1DA")
    private int nativeFindIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670353399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670353399;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "DED8D9D80421F30F4F05109978E5FD6C", hash_generated_method = "5AB5068259CCABEFACDEA5560EBD42C9")
    private void nativeSetExtendSelection() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "2C274D2245FB0A8D7528ABFEC087E1D5", hash_generated_method = "BF3E2C6C0F834088FF260D2D57AB8864")
    private void nativeSetFindIsEmpty() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "71074D26EBA852989A8E599F8DC99CDA", hash_generated_method = "256EAA7FD60D28E5E7062DFF998E2D2D")
    private void nativeSetFindIsUp(boolean isUp) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "1A40DDCBB5C6BAC480C205B4EFEFF411", hash_generated_method = "7A8E31F2B5D777EBEC23BD7B2069CA12")
    private void nativeSetHeightCanMeasure(boolean measure) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.306 -0400", hash_original_method = "42797342EBEAC39A012069DBF3959CE4", hash_generated_method = "AA06B3FFAAA82012E0DCB53B80602404")
    private void nativeSetBaseLayer(int layer, Region invalRegion,
            boolean showVisualIndicator, boolean isPictureAfterFirstLayout,
            boolean registerPageSwapCallback) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "8D8AA88701C38C5931114ED0C0161C5D", hash_generated_method = "2FA77398F4EC5F822D6FFC8BDFBC50E5")
    private int nativeGetBaseLayer() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143472725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2143472725;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "D25F410799B2D3B48F5A317D9083959F", hash_generated_method = "7AA70DF267F5A3B8D5F1139BE8B04F95")
    private void nativeShowCursorTimed() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "C916B75893AF77B1961F4CFBD5CF9E23", hash_generated_method = "2586905A54FC6D89F60FA868528B5ABD")
    private void nativeReplaceBaseContent(int content) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "FDA26A90E4050D5E65C761F188A7935F", hash_generated_method = "0DD0F39A70B93DCE529A7DB104FE79BF")
    private void nativeCopyBaseContentToPicture(Picture pict) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "93FAC0611A3E6EEE3FD4009FA5AD9BAF", hash_generated_method = "DD3F2FD809DEC23B2E8CEADAEF8A4ACA")
    private boolean nativeHasContent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571317116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571317116;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.307 -0400", hash_original_method = "F42CB5D0D8C6F398F22A64C079F97418", hash_generated_method = "646E5B0E2F3492FE7CA52836500770AC")
    private void nativeSetSelectionPointer(int nativeInstance,
            boolean set, float scale, int x, int y) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "166887E4A34037559593792A54186A9D", hash_generated_method = "A417873FA2AA5B077ABC533178F8C367")
    private boolean nativeStartSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584481196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584481196;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "5D555E1F640D417609912A2DCA84BA2D", hash_generated_method = "A11715011B8424E4C1DF23E23BC77CCA")
    private void nativeStopGL() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "BB5930F93E7BD301B785F374DEB45F7F", hash_generated_method = "59C253F3D708B1AEFB61B74588B1BC4B")
    private Rect nativeSubtractLayers(Rect content) {
    	Rect r = new Rect();
    	r.addTaint(taint);
    	return r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "25A60C73C1815A9FF162B041F21F90EA", hash_generated_method = "174587258FFCEC512EEB0C6A9C9072F1")
    private int nativeTextGeneration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847112592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847112592;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "0D7B3DBB181E1128790AEAAF27B15FC3", hash_generated_method = "357B1EA2F63D3ED8C271D67AFCCC12A7")
    private void nativeRegisterPageSwapCallback() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "D3632E330863903E3989B40201820082", hash_generated_method = "2E113EDF1B459505AA2AF4625DE30F08")
    private void nativeTileProfilingStart() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.308 -0400", hash_original_method = "519320FD6756673905506146600ACF0A", hash_generated_method = "C89CDC1F1859DE39B8BCF3028BAAAB46")
    private float nativeTileProfilingStop() {
        float var546ADE640B6EDFBC8A086EF31347E768_260972059 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_260972059;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "AEAE2ACA1E9867F86B84209E17FE783E", hash_generated_method = "7EF0A6540C2A701F27B19DB98FD72058")
    private void nativeTileProfilingClear() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "86701842D3863B80BD61F786E7AD5328", hash_generated_method = "93852F4E2B3E7BEFB078D33758053A18")
    private int nativeTileProfilingNumFrames() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652918318 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_652918318;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "DE63339DB4EA006DCE5F905546A74593", hash_generated_method = "7EBFF432286671F5898618198673BD6C")
    private int nativeTileProfilingNumTilesInFrame(int frame) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715888567 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715888567;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "5EBAC4ACE18C38FBC9AF365A21A2808A", hash_generated_method = "3465BAFFB2ECF698827BBC79A8574782")
    private int nativeTileProfilingGetInt(int frame, int tile, String key) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593303027 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1593303027;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "CFD0B3800F002661BCFC975AAB28BBE6", hash_generated_method = "DEA1653B280EABEC3601CACD33112533")
    private float nativeTileProfilingGetFloat(int frame, int tile, String key) {
        float var546ADE640B6EDFBC8A086EF31347E768_993286774 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_993286774;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.309 -0400", hash_original_method = "683C18D758473E94C91EEFF634790572", hash_generated_method = "3ABB45EA050CAA1CCC1C02DFC1E93D91")
    private void nativeUpdateCachedTextfield(String updatedText,
            int generation) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "618779B5001C09E40268503B4D70EE37", hash_generated_method = "D6D74C38D49867BF0215D702C0ACEA1F")
    private boolean nativeWordSelection(int x, int y) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843782671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843782671;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "4ED84BC2578D8932046470A1A989D8EC", hash_generated_method = "C218DD9F4DC4D9403AC2EFCA54E54805")
     int nativeGetBlockLeftEdge(int x, int y, float scale) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125544039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125544039;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "AB72670D7F17311A218110AB090BFE5C", hash_generated_method = "5002655B986F7D641C298CC95BBCC6C7")
    private void nativeUseHardwareAccelSkia(boolean enabled) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "E3322754F569B0B21B53AD98F12F9737", hash_generated_method = "50AC541CFA354C6C31618E223ABE27DD")
    private int nativeScrollableLayer(int x, int y, Rect scrollRect,
            Rect scrollBounds) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904750492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904750492;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "C9A386E9B72701103ACB4832FD09DAEB", hash_generated_method = "1E77DD6A59483ED8165DD8045C0707C7")
    private boolean nativeScrollLayer(int layer, int newX, int newY) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2108488021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2108488021;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.310 -0400", hash_original_method = "160FD188DECAD1E6A3D02C4EB5DCA1CC", hash_generated_method = "CD169E3A3B653F3A1D68A46881511434")
    private void nativeSetIsScrolling(boolean isScrolling) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "17D1DE14A7938D6C86D5133FB1C7A6A4", hash_generated_method = "31DFF13C2DB8E16C4B8B90F55E2DEC07")
    private int nativeGetBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709036975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709036975;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "0783F3130E130E529F16479AC73581A6", hash_generated_method = "663E86D5DD6DDB9FA80FBE9BAB095D77")
     boolean nativeSetProperty(String key, String value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580504073 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580504073;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "11B431686EC785B8746B288CFEF25EFA", hash_generated_method = "2CDC971A436EF25C108C6D2B163E982B")
     String nativeGetProperty(String key) {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "964ED52A62649E4E15C185190ECEDB3A", hash_generated_method = "1A68B083C5E652A8EAFCED90D7609277")
    private void nativeGetTextSelectionRegion(int instance, Region region) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.311 -0400", hash_original_method = "B3ADAA854D5758BDC9F0620E40CA4927", hash_generated_method = "D9F1018CE749271C3133A021A996233E")
    private void nativeGetSelectionHandles(int instance, int[] handles) {
    }

    
        private static void nativeOnTrimMemory(int level) {
    }

    
        private static void nativeSetPauseDrawing(int instance, boolean pause) {
    }

    
    private class InnerGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "8AECAF07C584017DF10A77A8577569BA", hash_generated_method = "8AECAF07C584017DF10A77A8577569BA")
        public InnerGlobalLayoutListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "7975E69377E2D4E4371FF984BC41AAFC", hash_generated_method = "6A33CF0332E38AE23B78BC7DFD92F5B0")
        public void onGlobalLayout() {
            
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_605322002 = (isShown());
                {
                    setGLRectViewport();
                } 
            } 
            
            
                
            
        }

        
    }


    
    private class InnerScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D", hash_generated_method = "D47E1EF344A2CD9F3C47AE9E7A00C49D")
        public InnerScrollChangedListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "352B17A157C2643E97C8BB6217499D7C", hash_generated_method = "3092C69FC10FCA5FAA46EF2B014FBD07")
        public void onScrollChanged() {
            
            {
                boolean varA5A6BE3BA1D3A444C74F3EF11E88B324_1246732607 = (isShown());
                {
                    setGLRectViewport();
                } 
            } 
            
            
                
            
        }

        
    }


    
    public class WebViewTransport {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_field = "873282A17E61E0691E2D2F15001F5346", hash_generated_field = "CE9B7FCDD03C866BC3B0AB067564E1E9")

        private WebView mWebview;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "019254006A207FE7BCA503E59C7BDCD4", hash_generated_method = "019254006A207FE7BCA503E59C7BDCD4")
        public WebViewTransport ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.312 -0400", hash_original_method = "425DF0BB46AC42AA7BF0BE404A263B4A", hash_generated_method = "A9A4B57876E149A4CA9F2A29180461CF")
        public synchronized void setWebView(WebView webview) {
            mWebview = webview;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.313 -0400", hash_original_method = "FCFE2F49718195B26DF12E8855D16060", hash_generated_method = "3D37A83044703632008A075C79F8F92D")
        public synchronized WebView getWebView() {
            WebView varB4EAC82CA7396A68D541C85D26508E83_1414644641 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1414644641 = mWebview;
            varB4EAC82CA7396A68D541C85D26508E83_1414644641.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1414644641;
            
            
        }

        
    }


    
    private static class OnTrimMemoryListener implements ComponentCallbacks2 {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.313 -0400", hash_original_method = "014523D0C8502735A043ABC10443E9AE", hash_generated_method = "C45AEFFBEC57E61111C9DF2D1A396FAF")
        private  OnTrimMemoryListener(Context c) {
            c.registerComponentCallbacks(this);
            addTaint(c.getTaint());
            
            
        }

        
                static void init(Context c) {
            if (sInstance == null) {
                sInstance = new OnTrimMemoryListener(c.getApplicationContext());
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "E555930F6C60B6E43E637690DA6E289E")
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            
            addTaint(newConfig.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "703A059557F06AE044520D2E93D3D2F0")
        @Override
        public void onLowMemory() {
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_method = "F302D96FF2DE7B0F1AFDB07E6DA881CC", hash_generated_method = "00EB74022956906F2D290B50848397C3")
        @Override
        public void onTrimMemory(int level) {
            
            {
                Log.d("WebView", "onTrimMemory: " + level);
            } 
            WebView.nativeOnTrimMemory(level);
            addTaint(level);
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_field = "CEBC5A2FE2A04C1669E8EF2F3D151E4D", hash_generated_field = "C88183308993326DA3B8CE3C16E7E9BA")

        private static OnTrimMemoryListener sInstance = null;
    }


    
    public class HitTestResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "E6B4AC7A48E0E54E09A504C828AF50C5")

        private int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.314 -0400", hash_original_field = "57351EA26C034458DF1F7B3C51D03D6E", hash_generated_field = "7473B88E9A243CF8ACFD2DDF98031A9D")

        private String mExtra;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.315 -0400", hash_original_method = "22122A9CDE290DEBAA97D7928999F948", hash_generated_method = "3E8436A0FC0A9040E95F25D444A899AD")
          HitTestResult() {
            mType = UNKNOWN_TYPE;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.315 -0400", hash_original_method = "08A67C8151DE1D5470E41F8D364D7EBB", hash_generated_method = "89AFF8CBC1B7750AC1399D58F1A48453")
        private void setType(int type) {
            mType = type;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.315 -0400", hash_original_method = "5A11195D61FECD91E6C46251DAE6160C", hash_generated_method = "66AE08DAEF8D5073B71F7FF854ADD4F3")
        private void setExtra(String extra) {
            mExtra = extra;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.316 -0400", hash_original_method = "E9AD68D49398B2B9D86D12D221B14582", hash_generated_method = "43C9D416B03E1E096EB9FFA14C657AEC")
        public int getType() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468696597 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1468696597;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.316 -0400", hash_original_method = "993DAEFB4C11E7BC5E9CBC52DC4B1BBC", hash_generated_method = "8E28350825FF3FE313FD51A71410673F")
        public String getExtra() {
            String varB4EAC82CA7396A68D541C85D26508E83_454671782 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_454671782 = mExtra;
            varB4EAC82CA7396A68D541C85D26508E83_454671782.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_454671782;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "B4460F979CFC4B3251D5DAAF48417617", hash_generated_field = "66339D0C16D16517633DFB08461D5C3F")

        public static final int UNKNOWN_TYPE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "CFFCF81F64F3B8E3F55FE79A095616A0", hash_generated_field = "C6E0A23956E4344E5A24770E8DEB80AF")

        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "030676AD21D2EA5086C5086B51132C5A", hash_generated_field = "1F892F69F99B538EA9542E4188E9D049")

        public static final int PHONE_TYPE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "3C1637E264836E3E0897EBDAA762C14C", hash_generated_field = "609BC3DD941EE1B3F8DBCDEA6DC14E92")

        public static final int GEO_TYPE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "028C017E4197D9D445450EAF82927BDC", hash_generated_field = "AF4F62540D93A175F846244DE39FF3EA")

        public static final int EMAIL_TYPE = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "C069364739732F7370F9183BFBDA020C", hash_generated_field = "D1341758694A17E34931E15E5F9AE163")

        public static final int IMAGE_TYPE = 5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "79DDA3DC402A59D3D78B1D118A52C31B", hash_generated_field = "A790FEB45D10D6E4493673EC8A439C5E")

        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "2EFC0DDB47A85AFB33F856AA957A411D", hash_generated_field = "F746B9271AE854E19C3EA4F13285C847")

        public static final int SRC_ANCHOR_TYPE = 7;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "8C48F79BD833571EE18B5D1083B6F30A", hash_generated_field = "C47A4D8A2B58A38AB94516810D897655")

        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_field = "B34737C311A023BD22EC23D2EE6165EC", hash_generated_field = "AD4F3515FDAD6418D5559EF03B760AC2")

        public static final int EDIT_TEXT_TYPE = 9;
    }


    
    private static class ProxyReceiver extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_method = "81C64DA14CD8ADA6B639EE9F61F2A898", hash_generated_method = "81C64DA14CD8ADA6B639EE9F61F2A898")
        public ProxyReceiver ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_method = "C1BF85501C9C720293FF5A0F8027F066", hash_generated_method = "AB97D2264FF7D057BCFCB26ED3DF7FEF")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean var5A158AEAA9529F1AFE9F1BFAB51F2DA9_993140750 = (intent.getAction().equals(Proxy.PROXY_CHANGE_ACTION));
                {
                    handleProxyBroadcast(intent);
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
                
            
        }

        
    }


    
    private static class PackageListener extends BroadcastReceiver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.317 -0400", hash_original_method = "F623A53A552E0B02B7648231F682A935", hash_generated_method = "F623A53A552E0B02B7648231F682A935")
        public PackageListener ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_method = "4BDCCDF31B8D55EFD7432A60E1C7C253", hash_generated_method = "38ED85F109FF5FCE3B870EF4B961001F")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            final String action = intent.getAction();
            final String packageName = intent.getData().getSchemeSpecificPart();
            final boolean replacing = intent.getBooleanExtra(Intent.EXTRA_REPLACING, false);
            {
                boolean varFF4619C38D73ED134292A51CFC6DAD56_1263769069 = (Intent.ACTION_PACKAGE_REMOVED.equals(action) && replacing);
            } 
            {
                boolean varF3A5A3941CCE4017F61B8223025B4DC2_197581651 = (sGoogleApps.contains(packageName));
                {
                    {
                        boolean var37328E8572988711DFAEB7B421756EDC_2032821276 = (Intent.ACTION_PACKAGE_ADDED.equals(action));
                        {
                            WebViewCore.sendStaticMessage(EventHub.ADD_PACKAGE_NAME, packageName);
                        } 
                        {
                            WebViewCore.sendStaticMessage(EventHub.REMOVE_PACKAGE_NAME, packageName);
                        } 
                    } 
                } 
            } 
            PluginManager pm = PluginManager.getInstance(context);
            {
                boolean varB1BC6389427C1315076A84D35B8A1EAF_801354795 = (pm.containsPluginPermissionAndSignatures(packageName));
                {
                    pm.refreshPlugins(Intent.ACTION_PACKAGE_ADDED.equals(action));
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
            
        }

        
    }


    
    static class SaveWebArchiveMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "A984B376DEA2CC7536617F280E80C1A1", hash_generated_field = "05C64ACC3BAB92D2CCE8178ABA3FDAE1")

        String mBasename;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "542D5B30128863188515FF03C3D6C8E3", hash_generated_field = "6BCA401625C852D06DCC273A17617FED")

        boolean mAutoname;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C752F5297A11E20E661B6130B21F3B9A")

        ValueCallback<String> mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "7D4A7A325C0BFF5E64DDC794A8738C05", hash_generated_field = "047227D3BBCE6402C69D67FD47561A95")

        String mResultFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_method = "D64671432E0583E419B88EDB6B668A93", hash_generated_method = "4FAF880EC774D9F5D77B034A52E594C4")
          SaveWebArchiveMessage(String basename, boolean autoname, ValueCallback<String> callback) {
            mBasename = basename;
            mAutoname = autoname;
            mCallback = callback;
            
            
            
            
        }

        
    }


    
    static class ViewSizeData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

        int mWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

        int mHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "46F4EE6FF41DA234C359DB3FA7F0E479", hash_generated_field = "78B7CCE03B515024F44B1EEDC44555A1")

        float mHeightWidthRatio;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "D759EB5AB08C859641FBD87DB10B4D2E", hash_generated_field = "3A48A4BC51B3BD422EE46136E8931243")

        int mActualViewHeight;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "8A785CDEA26539F62DF6BE00238F4644", hash_generated_field = "B26A0AD7DDE8F0FD05B17352E367406B")

        int mTextWrapWidth;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "E7657EDDA986C0D1CC052B8F112FE09D", hash_generated_field = "4E9F1D0675C6E9FD9207FBE824AD8A0F")

        int mAnchorX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "87FAE44598E10061776ABA72BF200D70", hash_generated_field = "A5A5BAD4084BA0905925E24FE8CC16A6")

        int mAnchorY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "ABDB0A4470BBD1454ED388F3CD972EEE")

        float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "8CDB6CB0AFB9B4C0B69C02EB4DBB1F61", hash_generated_field = "63B858676F9D9765C256ADBE1D3B6A59")

        boolean mIgnoreHeight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_method = "0E4893AFBBF2A9B13986CA2BDFC332DE", hash_generated_method = "0E4893AFBBF2A9B13986CA2BDFC332DE")
        public ViewSizeData ()
        {
            
        }


    }


    
    private class RequestFormData implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.318 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

        private String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "9C2E85EC79E8F8349BF2E81BA4AC7991")

        private String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_field = "3D50CF99C0669CD527C0C69C4AE6B44B", hash_generated_field = "0487D88BABEAE0E64EE47FD1AEEB417C")

        private Message mUpdateMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_field = "2A3109A682991470C8E7A9944372B1F8", hash_generated_field = "D46CADD5A6770F085C96392C484CE8BB")

        private boolean mAutoFillable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_field = "5C4062DD484011F09E7BDF9F978C283A", hash_generated_field = "F9D9BCAC942E8D5C0FAF4BD1D37CB5CF")

        private boolean mAutoComplete;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_field = "EBB2C75EE511DE5780ECD7B092A5D38B", hash_generated_field = "93B1D4E2229B54F25A168656E4937615")

        private WebSettings mWebSettings;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_method = "2B641E0500D328F53000CE6E93123686", hash_generated_method = "5B084D63C74BDE8B4C95B856FF4AC17D")
        public  RequestFormData(String name, String url, Message msg,
                boolean autoFillable, boolean autoComplete) {
            mName = name;
            mUrl = WebTextView.urlForAutoCompleteData(url);
            mUpdateMessage = msg;
            mAutoFillable = autoFillable;
            mAutoComplete = autoComplete;
            mWebSettings = getSettings();
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.319 -0400", hash_original_method = "DC6B246047C951370A98CE14CBC8CC44", hash_generated_method = "6502C86366402AF974B980977B36424B")
        public void run() {
            ArrayList<String> pastEntries = new ArrayList<String>();
            {
                {
                    boolean var5288C74084AF99D20729B6F53A54E232_423536054 = (mWebSettings != null && mWebSettings.getAutoFillProfile() != null);
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.autofill_this_form).toString() +
                            " " +
                            mAutoFillData.getPreviewString());
                        mWebTextView.setAutoFillProfileIsSet(true);
                    } 
                    {
                        pastEntries.add(getResources().getText(
                            com.android.internal.R.string.setup_autofill).toString());
                        mWebTextView.setAutoFillProfileIsSet(false);
                    } 
                } 
            } 
            {
                pastEntries.addAll(mDatabase.getFormData(mUrl, mName));
            } 
            {
                boolean var3F0C3C91772BA4E0AAA044D02E105F29_25239833 = (pastEntries.size() > 0);
                {
                    AutoCompleteAdapter adapter = new
                        AutoCompleteAdapter(mContext, pastEntries);
                    mUpdateMessage.obj = adapter;
                    mUpdateMessage.sendToTarget();
                } 
            } 
            
            
        }

        
    }


    
    private static class QueuedTouch {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_field = "DFA2A9B34C4EF6A435AC62654D16526E", hash_generated_field = "B8B6644602DD2683A7B0A4778A62DE29")

        long mSequence;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_field = "9F267F577D54234C4E24847A8B17E76A", hash_generated_field = "20EA73C9A7F9F149019985C98DE3A38D")

        MotionEvent mEvent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_field = "7C6961287A3682FFFA13151222676CCD", hash_generated_field = "C7A09A520003D6660CD5B4796D1273F4")

        TouchEventData mTed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "BEE6F088ABCC206EAF882A35EEC82861")

        QueuedTouch mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_method = "FA8EC88E2AD519ABBE81A37B882E4019", hash_generated_method = "FA8EC88E2AD519ABBE81A37B882E4019")
        public QueuedTouch ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.320 -0400", hash_original_method = "201239734E7C46277BDFD2F489AEF42B", hash_generated_method = "03CCE174D35E97095F8C0B0526FC6876")
        public QueuedTouch set(TouchEventData ted) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_1866541369 = null; 
            mSequence = ted.mSequence;
            mTed = ted;
            mEvent = null;
            mNext = null;
            varB4EAC82CA7396A68D541C85D26508E83_1866541369 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1866541369.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1866541369;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.321 -0400", hash_original_method = "7C5D585955A9AAE4BE1049B4A96093DC", hash_generated_method = "18FA7029D242ECA4FE1B00BB4388417B")
        public QueuedTouch set(MotionEvent ev, long sequence) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_2145882245 = null; 
            mEvent = MotionEvent.obtain(ev);
            mSequence = sequence;
            mTed = null;
            mNext = null;
            varB4EAC82CA7396A68D541C85D26508E83_2145882245 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2145882245.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2145882245;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.321 -0400", hash_original_method = "2404A1906D32ADB8867231DC065AA7FE", hash_generated_method = "4008EE34916008C059BAD9BB773601AE")
        public QueuedTouch add(QueuedTouch other) {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_726710008 = null; 
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_353508929 = null; 
            {
                other.mNext = this;
                varB4EAC82CA7396A68D541C85D26508E83_726710008 = other;
            } 
            QueuedTouch insertAt = this;
            {
                insertAt = insertAt.mNext;
            } 
            other.mNext = insertAt.mNext;
            insertAt.mNext = other;
            varB4EAC82CA7396A68D541C85D26508E83_353508929 = this;
            QueuedTouch varA7E53CE21691AB073D9660D615818899_1151610096; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1151610096 = varB4EAC82CA7396A68D541C85D26508E83_726710008;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1151610096 = varB4EAC82CA7396A68D541C85D26508E83_353508929;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1151610096.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1151610096;
            
            
                
                
            
            
            
                
            
            
            
            
        }

        
    }


    
    private class TouchEventQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.321 -0400", hash_original_field = "99261C2FE4C4592C38DF4A927D54353D", hash_generated_field = "127F03A306165D2D03A139A6F1583390")

        private long mNextTouchSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.321 -0400", hash_original_field = "059351212566DAAB66E521AE56B5D1B9", hash_generated_field = "266156A22BD39F4F0BEF086C9C7B63E5")

        private long mLastHandledTouchSequence = Long.MIN_VALUE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.321 -0400", hash_original_field = "61FC8120FAFF1BD1B830C4B5C36F1B56", hash_generated_field = "AF7570BA97F43827805CB02058F37277")

        private long mIgnoreUntilSequence = Long.MIN_VALUE + 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_field = "3964746921DBFB2211578ED44A2B4F3B", hash_generated_field = "21DBEB15ECA49C1E87E853FA0180CD65")

        private QueuedTouch mTouchEventQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_field = "052E5BF59E84B47B0BA6B00A861D46BC", hash_generated_field = "08077047985BEF38D8C3F6BC11BCAC86")

        private QueuedTouch mPreQueue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_field = "97C53AD1CE6FE2BC2B01D5BE11253B74", hash_generated_field = "F259F7EDDF59F6CEF0FD59699D3FC834")

        private QueuedTouch mQueuedTouchRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_field = "160DA3898A622FF8D6DFD4C04ADCBAA4", hash_generated_field = "778CCCFD60C85F5AB4F8F90308D45BB5")

        private int mQueuedTouchRecycleCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_field = "B8562DF9262860FE73F90E0012C8DE0F", hash_generated_field = "1E79D4489BE43CB9AEB55D3B13DF96A3")

        private long mLastEventTime = Long.MAX_VALUE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25", hash_generated_method = "5D2C1BE02BC07B13BBE8FE5DC638DF25")
        public TouchEventQueue ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.322 -0400", hash_original_method = "AB5D44DF048A232DDA2EFFA345FEA34E", hash_generated_method = "F8B953318BD4D919A022828413251F60")
        private QueuedTouch obtainQueuedTouch() {
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_66594832 = null; 
            QueuedTouch varB4EAC82CA7396A68D541C85D26508E83_1646119043 = null; 
            {
                QueuedTouch result = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = result.mNext;
                varB4EAC82CA7396A68D541C85D26508E83_66594832 = result;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1646119043 = new QueuedTouch();
            QueuedTouch varA7E53CE21691AB073D9660D615818899_1163909100; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1163909100 = varB4EAC82CA7396A68D541C85D26508E83_66594832;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1163909100 = varB4EAC82CA7396A68D541C85D26508E83_1646119043;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1163909100.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1163909100;
            
            
                
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.323 -0400", hash_original_method = "06BF5793F93F6133CAA3E663E6CDD054", hash_generated_method = "FF19A2C62E6D784032ABEC06DA4B653A")
        public void ignoreCurrentlyMissingEvents() {
            mIgnoreUntilSequence = mNextTouchSequence;
            runQueuedAndPreQueuedEvents();
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.323 -0400", hash_original_method = "BC66F06E28076E0AF905E37605905569", hash_generated_method = "98DF7ABB03FC7879E7985D264716D11F")
        private void runQueuedAndPreQueuedEvents() {
            QueuedTouch qd = mPreQueue;
            boolean fromPreQueue = true;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
                {
                    mPreQueue = qd.mNext;
                } 
                {
                    mTouchEventQueue = qd.mNext;
                } 
                recycleQueuedTouch(recycleMe);
                long nextPre;
                nextPre = mPreQueue.mSequence;
                nextPre = Long.MAX_VALUE;
                long nextQueued;
                nextQueued = mTouchEventQueue.mSequence;
                nextQueued = Long.MAX_VALUE;
                fromPreQueue = nextPre < nextQueued;
                qd = fromPreQueue ? mPreQueue : mTouchEventQueue;
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.323 -0400", hash_original_method = "FC0D76F5CB4E5B42797F23D72B4290DD", hash_generated_method = "6622E20DE442F7D089DF53EB4BF3E370")
        public void preQueueTouchEventData(TouchEventData ted) {
            QueuedTouch newTouch = obtainQueuedTouch().set(ted);
            {
                mPreQueue = newTouch;
            } 
            {
                QueuedTouch insertionPoint = mPreQueue;
                {
                    insertionPoint = insertionPoint.mNext;
                } 
                newTouch.mNext = insertionPoint.mNext;
                insertionPoint.mNext = newTouch;
            } 
            addTaint(ted.getTaint());
            
            
            
                
            
                
                
                        
                    
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.324 -0400", hash_original_method = "1A49831775AEFA2CD0798618E9FF10FB", hash_generated_method = "23ACD9865FD3C2DC7344B474F0472DC4")
        private void recycleQueuedTouch(QueuedTouch qd) {
            {
                qd.mNext = mQueuedTouchRecycleBin;
                mQueuedTouchRecycleBin = qd;
            } 
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.324 -0400", hash_original_method = "97C4AAC2AC6BC3BB9C84B0DC4AF0AD0A", hash_generated_method = "EFC7E9291730C15C48AF94A14D8E6D62")
        public void reset() {
            mNextTouchSequence = Long.MIN_VALUE + 1;
            mLastHandledTouchSequence = Long.MIN_VALUE;
            mIgnoreUntilSequence = Long.MIN_VALUE + 1;
            {
                QueuedTouch recycleMe = mTouchEventQueue;
                mTouchEventQueue = mTouchEventQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } 
            {
                QueuedTouch recycleMe = mPreQueue;
                mPreQueue = mPreQueue.mNext;
                recycleQueuedTouch(recycleMe);
            } 
            
            
            
            
            
                
                
                
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.324 -0400", hash_original_method = "3F8E561F61CC5D0495097299D7328F1D", hash_generated_method = "025E3C6F9E85B71D64151E2AFD2033F4")
        public long nextTouchSequence() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2018403085 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2018403085;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.325 -0400", hash_original_method = "F5E406D9ACD0445760ECDD686848E1FF", hash_generated_method = "6E334C038DE6890626C81CA64A2C77F6")
        public boolean enqueueTouchEvent(TouchEventData ted) {
            QueuedTouch preQueue = mPreQueue;
            {
                {
                    mPreQueue = preQueue.mNext;
                } 
                {
                    QueuedTouch prev = preQueue;
                    preQueue = null;
                    {
                        {
                            preQueue = prev.mNext;
                            prev.mNext = preQueue.mNext;
                        } 
                        {
                            prev = prev.mNext;
                        } 
                    } 
                } 
            } 
            {
                boolean varBE43CED5DAEAE4AB789CEEFCCB879ABB_308550 = (dropStaleGestures(ted.mMotionEvent, ted.mSequence));
            } 
            runNextQueuedEvents();
            {
                {
                    recycleQueuedTouch(preQueue);
                    preQueue = null;
                } 
                handleQueuedTouchEventData(ted);
                runNextQueuedEvents();
            } 
            {
                QueuedTouch qd;
                qd = preQueue;
                qd = obtainQueuedTouch().set(ted);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } 
            addTaint(ted.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461806981 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461806981;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.326 -0400", hash_original_method = "040ADC5295C28ABEDCF4DDDC88DD65B2", hash_generated_method = "521723943987C57A3B79045940AE2BC7")
        public void enqueueTouchEvent(MotionEvent ev) {
            final long sequence = nextTouchSequence();
            {
                boolean varC743B531629C8022D99C282BCE55BA59_292535290 = (dropStaleGestures(ev, sequence));
            } 
            runNextQueuedEvents();
            {
                handleQueuedMotionEvent(ev);
                runNextQueuedEvents();
            } 
            {
                QueuedTouch qd = obtainQueuedTouch().set(ev, sequence);
                mTouchEventQueue = mTouchEventQueue == null ? qd : mTouchEventQueue.add(qd);
            } 
            addTaint(ev.getTaint());
            
            
            
                
            
            
            
                
                
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.327 -0400", hash_original_method = "B35A0836059198E99EEAB9F92B215EE3", hash_generated_method = "B67C06E45BDA146A0E00034590A2DBB6")
        private void runNextQueuedEvents() {
            QueuedTouch qd = mTouchEventQueue;
            {
                handleQueuedTouch(qd);
                QueuedTouch recycleMe = qd;
                qd = qd.mNext;
                recycleQueuedTouch(recycleMe);
            } 
            mTouchEventQueue = qd;
            
            
            
                
                
                
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.328 -0400", hash_original_method = "876EAE84BE45B8A3C65BF901D953FD95", hash_generated_method = "B7E66EBBA436BA38B01920B1386FE3B3")
        private boolean dropStaleGestures(MotionEvent ev, long sequence) {
            {
                boolean var6660B004F1AFFBD2AD367F81FA8A8ECB_531479230 = (ev != null && ev.getAction() == MotionEvent.ACTION_MOVE && !mConfirmMove);
                {
                    final int dx = Math.round(ev.getX()) - mLastTouchX;
                    final int dy = Math.round(ev.getY()) - mLastTouchY;
                    {
                        mPrivateHandler.removeMessages(SWITCH_TO_SHORTPRESS);
                        mPrivateHandler.removeMessages(SWITCH_TO_LONGPRESS);
                    } 
                } 
            } 
            {
                boolean varDD96473448E99D0068A310672554EE17_1698602337 = (ev != null && ev.getAction() == MotionEvent.ACTION_DOWN);
                {
                    long eventTime = ev.getEventTime();
                    long lastHandledEventTime = mLastEventTime;
                    {
                        runQueuedAndPreQueuedEvents();
                        QueuedTouch qd = mTouchEventQueue;
                        {
                            QueuedTouch recycleMe = qd;
                            qd = qd.mNext;
                            recycleQueuedTouch(recycleMe);
                        } 
                        mTouchEventQueue = qd;
                        mLastHandledTouchSequence = sequence - 1;
                    } 
                } 
            } 
            {
                QueuedTouch qd = mTouchEventQueue;
                {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } 
                mTouchEventQueue = qd;
                mLastHandledTouchSequence = mIgnoreUntilSequence - 1;
            } 
            {
                QueuedTouch qd = mPreQueue;
                {
                    QueuedTouch recycleMe = qd;
                    qd = qd.mNext;
                    recycleQueuedTouch(recycleMe);
                } 
                mPreQueue = qd;
            } 
            addTaint(ev.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812543486 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812543486;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.328 -0400", hash_original_method = "9DAA26212DAF501113FFC4FAEFECD88C", hash_generated_method = "A141C3DAD1F9122DF97E0B8D7BF53D83")
        private void handleQueuedTouch(QueuedTouch qt) {
            {
                handleQueuedTouchEventData(qt.mTed);
            } 
            {
                handleQueuedMotionEvent(qt.mEvent);
                qt.mEvent.recycle();
            } 
            addTaint(qt.getTaint());
            
            
                
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.328 -0400", hash_original_method = "956B4575EAFC48637C003FC34CF05D7B", hash_generated_method = "46F8E91939C57F54AA0FAC5DCA1987D3")
        private void handleQueuedMotionEvent(MotionEvent ev) {
            mLastEventTime = ev.getEventTime();
            int action = ev.getActionMasked();
            {
                boolean var5547CC292C3C07AC5E49CBFC5588305F_2056170172 = (ev.getPointerCount() > 1);
                {
                    handleMultiTouchInWebView(ev);
                } 
                {
                    final ScaleGestureDetector detector = mZoomManager.getMultiTouchGestureDetector();
                    {
                        detector.onTouchEvent(ev);
                    } 
                    handleTouchEventCommon(ev, action, Math.round(ev.getX()), Math.round(ev.getY()));
                } 
            } 
            
            
            
            
                
            
                
                
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.329 -0400", hash_original_method = "889E601774788FF80FB077F7958B040F", hash_generated_method = "BD5386679B9F4DB8AC1B2C598C8B708B")
        private void handleQueuedTouchEventData(TouchEventData ted) {
            {
                mLastEventTime = ted.mMotionEvent.getEventTime();
            } 
            {
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN;
                } 
                {
                    mPreventDefault = ted.mNativeResult ? PREVENT_DEFAULT_YES
                            : PREVENT_DEFAULT_NO;
                } 
                {
                    mTouchHighlightRegion.setEmpty();
                } 
            } 
            {
                {
                    {
                        mPreventDefault = PREVENT_DEFAULT_NO;
                        handleMultiTouchInWebView(ted.mMotionEvent);
                    } 
                    {
                        mPreventDefault = PREVENT_DEFAULT_YES;
                    } 
                } 
                {
                    
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    
                    
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    
                    
                    mDeferTouchMode = TOUCH_INIT_MODE;
                    
                    
                    {
                        int x = ted.mPointsInView[0].x;
                        int y = ted.mPointsInView[0].y;
                        {
                            mDeferTouchMode = TOUCH_DRAG_MODE;
                            mLastDeferTouchX = x;
                            mLastDeferTouchY = y;
                            startScrollingLayer(x, y);
                            startDrag();
                        } 
                        int deltaX = pinLocX((int) (mScrollX
                                    + mLastDeferTouchX - x))
                                    - mScrollX;
                        int deltaY = pinLocY((int) (mScrollY
                                    + mLastDeferTouchY - y))
                                    - mScrollY;
                        doDrag(deltaX, deltaY);
                        mLastDeferTouchX = x;
                        mLastDeferTouchY = y;
                    } 
                    
                    
                    {
                        mScroller.springBack(mScrollX, mScrollY, 0,
                                        computeMaxScrollX(), 0,
                                        computeMaxScrollY());
                        invalidate();
                        WebViewCore.resumePriority();
                        WebViewCore.resumeUpdatePicture(mWebViewCore);
                    } 
                    
                    
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    
                    
                    mLastDeferTouchX = ted.mPointsInView[0].x;
                    
                    
                    mLastDeferTouchY = ted.mPointsInView[0].y;
                    
                    
                    mZoomManager.handleDoubleTap(mLastTouchX, mLastTouchY);
                    
                    
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    
                    
                    HitTestResult hitTest = getHitTestResult();
                    
                    
                    {
                        performLongClick();
                    } 
                    
                    
                    mDeferTouchMode = TOUCH_DONE_MODE;
                    
                } 
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.330 -0400", hash_original_field = "5842E73A351A2BBCD4BC86770C0E9B9A", hash_generated_field = "BB5877DC49413A9228D8F9DC3EDA4B0C")

        private static final int MAX_RECYCLED_QUEUED_TOUCH = 15;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.330 -0400", hash_original_field = "09C062B1DCE117D7E9D6F9016B9F35A1", hash_generated_field = "E348FC28D39D22D6D781B3B929F27054")

        private static final int QUEUED_GESTURE_TIMEOUT = 1000;
    }


    
    class PrivateHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.330 -0400", hash_original_method = "827423792FD52B61F0723B9DB59191FF", hash_generated_method = "827423792FD52B61F0723B9DB59191FF")
        public PrivateHandler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.333 -0400", hash_original_method = "9A7677F45780C792E5B09EADF3925AD6", hash_generated_method = "8538D9655251436C3C6BB383D319A649")
        @Override
        public void handleMessage(Message msg) {
            
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"),
                            msg.getData().getString("username"),
                            msg.getData().getString("password"));
                ((Message) msg.obj).sendToTarget();
            } 
            
            
            {
                mDatabase.setUsernamePassword(
                            msg.getData().getString("host"), null, null);
                ((Message) msg.obj).sendToTarget();
            } 
            
            
            {
                {
                    cancelWebCoreTouchEvent(
                                viewToContentX(mLastTouchX + mScrollX),
                                viewToContentY(mLastTouchY + mScrollY),
                                true);
                } 
            } 
            
            
            {
                {
                    mSentAutoScrollMessage = false;
                } 
                {
                    pinScrollBy(mAutoScrollX, mAutoScrollY, true, 0);
                } 
                {
                    scrollLayerTo(mScrollingLayerRect.left + mAutoScrollX,
                                mScrollingLayerRect.top + mAutoScrollY);
                } 
                sendEmptyMessageDelayed(
                            SCROLL_SELECT_TEXT, SELECT_SCROLL_INTERVAL);
            } 
            
            
            {
                {
                    updateSelection();
                } 
            } 
            
            
            {
                mInitialHitTestResult = null;
                {
                    {
                        boolean var8FF10029C08AB4FC7C05FF2A261CB23D_459521691 = (!getSettings().supportTouchOnly()
                                && mPreventDefault != PREVENT_DEFAULT_YES);
                        {
                            mTouchMode = TOUCH_SHORTPRESS_START_MODE;
                            updateSelection();
                        } 
                        {
                            mTouchMode = TOUCH_SHORTPRESS_MODE;
                        } 
                    } 
                } 
                {
                    mTouchMode = TOUCH_DONE_MODE;
                } 
            } 
            
            
            {
                {
                    boolean varE1DF6CCB4D16FC90F8DBFFED5F41299F_1736520799 = (USE_WEBKIT_RINGS || getSettings().supportTouchOnly());
                    {
                        removeTouchHighlight();
                    } 
                } 
                {
                    boolean var72609C462D4DCD4473D0A433CA78D370_73877739 = (inFullScreenMode() || mDeferTouchProcess);
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
                    } 
                    {
                        mTouchMode = TOUCH_DONE_MODE;
                        performLongClick();
                    } 
                } 
            } 
            
            
            {
                doShortPress();
            } 
            
            
            {
                {
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    {
                        boolean varC08B8A0171CF85CA13986B7A742C9FAC_274298977 = (imm == null || !imm.isAcceptingText()
                                || (!imm.isActive(WebView.this) && (!inEditingMode()
                                || !imm.isActive(mWebTextView))));
                    } 
                } 
                final Point p = (Point) msg.obj;
                {
                    spawnContentScrollTo(p.x, p.y);
                } 
                {
                    setContentScrollTo(p.x, p.y);
                } 
            } 
            
            
            {
                WebViewCore.ViewState viewState = (WebViewCore.ViewState) msg.obj;
                mZoomManager.updateZoomRange(viewState, getViewWidth(), viewState.mScrollX);
            } 
            
            
            {
                final float density = (Float) msg.obj;
                mZoomManager.updateDefaultZoomDensity(density);
            } 
            
            
            {
                nativeReplaceBaseContent(msg.arg1);
            } 
            
            
            {
                final WebViewCore.DrawData draw = (WebViewCore.DrawData) msg.obj;
                setNewPicture(draw, true);
            } 
            
            
            String drawableDir = BrowserFrame.getRawResFilename(
                            BrowserFrame.DRAWABLEDIR, mContext);
            
            
            WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            
            
            Display display = windowManager.getDefaultDisplay();
            
            
            nativeCreate(msg.arg1, drawableDir,
                            ActivityManager.isHighEndGfx(display));
            
            
            {
                setNewPicture(mDelaySetPicture, true);
                mDelaySetPicture = null;
            } 
            
            
            {
                nativeSetPauseDrawing(mNativeClass, true);
            } 
            
            
            {
                boolean var24ED917A45E165B2D0DB73D1C228849D_887084606 = (inEditingMode() &&
                            mWebTextView.isSameTextField(msg.arg1));
                {
                    {
                        String text = (String) msg.obj;
                        {
                            text = "";
                        } 
                        mWebTextView.setTextAndKeepSelection(text);
                    } 
                } 
            } 
            
            
            displaySoftKeyboard(true);
            
            
            updateTextSelectionFromMessage(msg.arg1, msg.arg2,
                            (WebViewCore.TextSelectionData) msg.obj);
            
            
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1518295527 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    hideSoftKeyboard();
                } 
            } 
            
            
            {
                boolean varC0F3E2F619BB6609BFF377ECAF6294F7_1178575011 = (inEditingMode()
                            && mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setHint((String) msg.obj);
                    InputMethodManager imm = InputMethodManager.peekInstance();
                    {
                        boolean varE86969381D8E084EE7486B0BCDFB9761_2057171054 = (imm != null && imm.isActive(mWebTextView));
                        {
                            imm.restartInput(mWebTextView);
                        } 
                    } 
                } 
            } 
            
            
            navHandledKey(msg.arg1, 1, false, 0);
            
            
            {
                boolean var0513EDBB647F1B1B0CEC2398CB7258CB_1766923152 = (inEditingMode() && nativeCursorIsTextInput());
                {
                    updateWebTextViewPosition();
                } 
            } 
            
            
            clearTextEntry();
            
            
            {
                Rect r = (Rect)msg.obj;
                {
                    invalidate();
                } 
                {
                    viewInvalidate(r.left, r.top, r.right, r.bottom);
                } 
            } 
            
            
            AutoCompleteAdapter adapter = (AutoCompleteAdapter) msg.obj;
            
            
            {
                boolean var543595A323B4887B7F3AF5971C508703_2092886483 = (mWebTextView.isSameTextField(msg.arg1));
                {
                    mWebTextView.setAdapterCustom(adapter);
                } 
            } 
            
            
            mGotCenterDown = false;
            
            
            mTrackballDown = false;
            
            
            performLongClick();
            
            
            mForwardTouchEvents = (msg.arg1 != 0);
            
            
            {
                boolean varA9995E2AE703E9AF13E24802C20B989A_904386186 = (inFullScreenMode());
            } 
            
            
            TouchEventData ted = (TouchEventData) msg.obj;
            
            
            {
                boolean var25F0555089CC470A412F802E26A1BE83_564445650 = (mTouchEventQueue.enqueueTouchEvent(ted));
                {
                    removeMessages(PREVENT_DEFAULT_TIMEOUT);
                } 
            } 
            
            
            {
                hideSoftKeyboard();
            } 
            {
                displaySoftKeyboard(false);
            } 
            
            
            {
                mFindCallback.findAll();
            } 
            
            
            mHeldMotionless = MOTIONLESS_TRUE;
            
            
            invalidate();
            
            
            {
                awakenScrollBars(ViewConfiguration
                                .getScrollDefaultDelay(), false);
                mPrivateHandler.sendMessageDelayed(mPrivateHandler
                                .obtainMessage(AWAKEN_SCROLL_BARS),
                                ViewConfiguration.getScrollDefaultDelay());
            } 
            
            
            doMotionUp(msg.arg1, msg.arg2);
            
            
            setKeepScreenOn(msg.arg1 == 1);
            
            
            int layerId = msg.arg1;
            
            
            String url = (String) msg.obj;
            
            
            {
                mHTML5VideoViewProxy.enterFullScreenVideo(layerId, url);
            } 
            
            
            {
                View view = (View) msg.obj;
                int orientation = msg.arg1;
                int npp = msg.arg2;
                {
                    boolean var193BD8982A9C597816FCA9FE1F0F7BC4_1143531125 = (inFullScreenMode());
                    {
                        dismissFullScreenMode();
                    } 
                } 
                mFullScreenHolder = new PluginFullScreenHolder(WebView.this, orientation, npp);
                mFullScreenHolder.setContentView(view);
                mFullScreenHolder.show();
            } 
            
            
            dismissFullScreenMode();
            
            
            {
                boolean var6767F8BCFB94E18C6E871E21723BAE8C_1032111058 = (inEditingMode());
                {
                    nativeClearCursor();
                    rebuildWebTextView();
                } 
            } 
            
            
            {
                WebViewCore.ShowRectData data = (WebViewCore.ShowRectData) msg.obj;
                int x = mScrollX;
                int left = contentToViewX(data.mLeft);
                int width = contentToViewDimension(data.mWidth);
                int maxWidth = contentToViewDimension(data.mContentWidth);
                int viewWidth = getViewWidth();
                {
                    x += left + width / 2 - mScrollX - viewWidth / 2;
                } 
                {
                    x += (int) (left + data.mXPercentInDoc * width
                                - mScrollX - data.mXPercentInView * viewWidth);
                } 
                x = Math.max(0,
                            (Math.min(maxWidth, x + viewWidth)) - viewWidth);
                int top = contentToViewY(data.mTop);
                int height = contentToViewDimension(data.mHeight);
                int maxHeight = contentToViewDimension(data.mContentHeight);
                int viewHeight = getViewHeight();
                int y = (int) (top + data.mYPercentInDoc * height -
                                   data.mYPercentInView * viewHeight);
                y = Math.max(0,
                            (Math.min(maxHeight, y + viewHeight) - viewHeight));
                y = Math.max(0, y - getVisibleTitleHeightImpl());
                scrollTo(x, y);
            } 
            
            
            centerFitRect((Rect)msg.obj);
            
            
            mHorizontalScrollBarMode = msg.arg1;
            
            
            mVerticalScrollBarMode = msg.arg2;
            
            
            {
                String selectionString = (String) msg.obj;
                mAccessibilityInjector.onSelectionStringChange(selectionString);
            } 
            
            
            @SuppressWarnings("unchecked") ArrayList<Rect> rects = (ArrayList<Rect>) msg.obj;
            
            
            setTouchHighlightRects(rects);
            
            
            SaveWebArchiveMessage saveMessage = (SaveWebArchiveMessage)msg.obj;
            
            
            {
                saveMessage.mCallback.onReceiveValue(saveMessage.mResultFile);
            } 
            
            
            mAutoFillData = (WebViewCore.AutoFillData) msg.obj;
            
            
            {
                mWebTextView.setAutoFillable(mAutoFillData.getQueryId());
                rebuildWebTextView();
            } 
            
            
            {
                mWebTextView.setAdapterCustom(null);
            } 
            
            
            nativeSelectAt(msg.arg1, msg.arg2);
            
            
            super.handleMessage(msg);
            
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    private class InvokeListBox implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.334 -0400", hash_original_field = "AE78DDD4E1B4460118053782D7B99832", hash_generated_field = "44EE6B10D8B13CA54299546EDE76F988")

        private boolean mMultiple;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.334 -0400", hash_original_field = "A17946B2F76705FFA0DE3EA576AD2A14", hash_generated_field = "665B478A898DF171CBB5A5C66E041F86")

        private int[] mSelectedArray;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.334 -0400", hash_original_field = "D53310829851F4FC641DE95C4A986129", hash_generated_field = "C4C82616B1A0974C29170CF176A905F6")

        private int mSelection;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.334 -0400", hash_original_field = "5F8D1AB50E5C83BC9CBB9FBEC119B3B0", hash_generated_field = "9EF3ABDF3C19BF934708240D666FC0CB")

        private Container[] mContainers;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.334 -0400", hash_original_method = "1F2BA0C7FD517ADA10536B78F51B1307", hash_generated_method = "5C303F077B9C9F85E3890F12C016F3B2")
        private  InvokeListBox(String[] array, int[] enabled, int[] selected) {
            mMultiple = true;
            mSelectedArray = selected;
            int length = array.length;
            mContainers = new Container[length];
            {
                int i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } 
            } 
            
            
            
            
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.335 -0400", hash_original_method = "54E13209A09FCCA516A20E22E270B0C2", hash_generated_method = "8378B3B97AC00BC093B4B894624322FB")
        private  InvokeListBox(String[] array, int[] enabled, int selection) {
            mSelection = selection;
            mMultiple = false;
            int length = array.length;
            mContainers = new Container[length];
            {
                int i = 0;
                {
                    mContainers[i] = new Container();
                    mContainers[i].mString = array[i];
                    mContainers[i].mEnabled = enabled[i];
                    mContainers[i].mId = i;
                } 
            } 
            
            
            
            
            
            
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.338 -0400", hash_original_method = "CCFADA0468DA91B20D0D6A2BBC10B3D9", hash_generated_method = "B2BF2AA608D7BD24C7BEE14232AB4FA7")
        public void run() {
            final ListView listView = (ListView) LayoutInflater.from(mContext)
                    .inflate(com.android.internal.R.layout.select_dialog, null);
            final MyArrayListAdapter adapter = new MyArrayListAdapter();
            AlertDialog.Builder b = new AlertDialog.Builder(mContext)
                    .setView(listView).setCancelable(true)
                    .setInverseBackgroundForced(true);
            {
                b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.336 -0400", hash_original_method = "3150D57594E9A243EB2796EE1880D262", hash_generated_method = "3F6B021AED45769734F28F07ADA17DDB")
                    public void onClick(DialogInterface dialog, int which) {
                        
                        mWebViewCore.sendMessage(
                                EventHub.LISTBOX_CHOICES,
                                adapter.getCount(), 0,
                                listView.getCheckedItemPositions());
                        addTaint(dialog.getTaint());
                        addTaint(which);
                        
                        
                                
                                
                                
                    }
});
                b.setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.336 -0400", hash_original_method = "167C789BB5CCECE2A545076849F2D943", hash_generated_method = "59C07BDADDA6A0C254998825263AE2FF")
                    public void onClick(DialogInterface dialog, int which) {
                        
                        mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                        addTaint(dialog.getTaint());
                        addTaint(which);
                        
                        
                                
                    }
});
            } 
            mListBoxDialog = b.create();
            listView.setAdapter(adapter);
            listView.setFocusableInTouchMode(true);
            listView.setTextFilterEnabled(!mMultiple);
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                int length = mSelectedArray.length;
                {
                    int i = 0;
                    {
                        listView.setItemChecked(mSelectedArray[i], true);
                    } 
                } 
            } 
            {
                listView.setOnItemClickListener(new OnItemClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.337 -0400", hash_original_method = "4FB59E3EE3C723FAB3D9C696C9283630", hash_generated_method = "EB5DE1DC2EC2F6B1D40394864B2401AC")
                    public void onItemClick(AdapterView<?> parent, View v,
                            int position, long id) {
                        
                        mListBoxMessage = Message.obtain(null,
                                EventHub.SINGLE_LISTBOX_CHOICE, (int) id, 0);
                        mListBoxDialog.dismiss();
                        mListBoxDialog = null;
                        addTaint(parent.getTaint());
                        addTaint(v.getTaint());
                        addTaint(position);
                        addTaint(id);
                        
                        
                                
                        
                        
                    }
});
                {
                    listView.setSelection(mSelection);
                    listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                    listView.setItemChecked(mSelection, true);
                    DataSetObserver observer = new SingleDataSetObserver(
                            adapter.getItemId(mSelection), listView, adapter);
                    adapter.registerDataSetObserver(observer);
                } 
            } 
            mListBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.337 -0400", hash_original_method = "718CBFBF20241D8F0DF84EA7F924765B", hash_generated_method = "03CF01EF3CCA98BA2D99C73624A0B668")
                public void onCancel(DialogInterface dialog) {
                    
                    mWebViewCore.sendMessage(
                                EventHub.SINGLE_LISTBOX_CHOICE, -2, 0);
                    mListBoxDialog = null;
                    addTaint(dialog.getTaint());
                    
                    
                                
                    
                }
});
            mListBoxDialog.show();
            
            
        }

        
        private class Container extends Object {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.338 -0400", hash_original_field = "18E347BCBCDD07E01563671B6BDE7905", hash_generated_field = "0DD8A30A5B66E3389BB7F1641026A732")

            String mString;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.338 -0400", hash_original_field = "6F84A7F10C955D3C78F44E5278F6195B", hash_generated_field = "3811FA45E31C1288EF4A5CD0AF26B346")

            int mEnabled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.338 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

            int mId;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.340 -0400", hash_original_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4", hash_generated_method = "DD3B8E29C865D4F7AB0FED0D35D8C8B4")
            public Container ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.341 -0400", hash_original_method = "47413D805E887745DF3971F679277823", hash_generated_method = "2F50B5CE5FC93A952122151657D68C6D")
            @Override
            public String toString() {
                String varB4EAC82CA7396A68D541C85D26508E83_1677942168 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1677942168 = mString;
                varB4EAC82CA7396A68D541C85D26508E83_1677942168.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1677942168;
                
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.341 -0400", hash_original_field = "D6517EB4E1F45C61EEFB510AAF08C057", hash_generated_field = "286E6252D1F55A019AFE2E7F01596CD3")

            final static int OPTGROUP = -1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.341 -0400", hash_original_field = "EADC20B7F6688B86F7C891B4EEEBB80D", hash_generated_field = "B55392C731ABAA66EEF81A3CED619863")

            final static int OPTION_DISABLED = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.341 -0400", hash_original_field = "5B1BBEBA286149605978186AE4B3FCC0", hash_generated_field = "4F0BC4F0AB9BA9C14CA01391DF9AFF29")

            final static int OPTION_ENABLED = 1;
        }


        
        private class MyArrayListAdapter extends ArrayAdapter<Container> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.341 -0400", hash_original_method = "F310EECB41F4E7684327810A6A6A37C7", hash_generated_method = "49BA01A9414CEFE48019AF33DD04C46A")
            public  MyArrayListAdapter() {
                super(mContext,
                        mMultiple ? com.android.internal.R.layout.select_dialog_multichoice :
                        com.android.internal.R.layout.webview_select_singlechoice,
                        mContainers);
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.342 -0400", hash_original_method = "118F3A9AABBB86291F17A77CAC96C3E2", hash_generated_method = "8084E4C51885D0634A6FCF3347DA91F3")
            @Override
            public View getView(int position, View convertView,
                    ViewGroup parent) {
                View varB4EAC82CA7396A68D541C85D26508E83_714226047 = null; 
                View varB4EAC82CA7396A68D541C85D26508E83_464609130 = null; 
                convertView = super.getView(position, null, parent);
                Container c = item(position);
                {
                    LinearLayout layout = new LinearLayout(mContext);
                    layout.setOrientation(LinearLayout.VERTICAL);
                    {
                        View dividerTop = new View(mContext);
                        dividerTop.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                        layout.addView(dividerTop);
                    } 
                    {
                        {
                            Assert.assertTrue(convertView instanceof CheckedTextView);
                            ((CheckedTextView) convertView).setCheckMarkDrawable(null);
                        } 
                    } 
                    {
                        convertView.setEnabled(false);
                    } 
                    layout.addView(convertView);
                    {
                        boolean var29E3F9545B0C5E6979D96B1ACDAB027D_739259464 = (position < getCount() - 1);
                        {
                            View dividerBottom = new View(mContext);
                            dividerBottom.setBackgroundResource(
                                android.R.drawable.divider_horizontal_bright);
                            layout.addView(dividerBottom);
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_714226047 = layout;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_464609130 = convertView;
                addTaint(position);
                addTaint(convertView.getTaint());
                addTaint(parent.getTaint());
                View varA7E53CE21691AB073D9660D615818899_1027428069; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_1027428069 = varB4EAC82CA7396A68D541C85D26508E83_714226047;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1027428069 = varB4EAC82CA7396A68D541C85D26508E83_464609130;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1027428069.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_1027428069;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.342 -0400", hash_original_method = "715CB29FF3CEE320E11EC1BD997C9D63", hash_generated_method = "23CBDB00C2A3EC14AE90E92F42FB382B")
            @Override
            public boolean hasStableIds() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1431948331 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1431948331;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.343 -0400", hash_original_method = "00B4C931839B7CE79C0BDBB195CA9D3C", hash_generated_method = "4D12C4F1ECFA01C04EB620F7F0DE382E")
            private Container item(int position) {
                Container varB4EAC82CA7396A68D541C85D26508E83_388833174 = null; 
                Container varB4EAC82CA7396A68D541C85D26508E83_1952757157 = null; 
                {
                    boolean var46FB1B51094929768D004AD98A0CD79D_1559042269 = (position < 0 || position >= getCount());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_388833174 = null;
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1952757157 = (Container) getItem(position);
                addTaint(position);
                Container varA7E53CE21691AB073D9660D615818899_1014034044; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_1014034044 = varB4EAC82CA7396A68D541C85D26508E83_388833174;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1014034044 = varB4EAC82CA7396A68D541C85D26508E83_1952757157;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1014034044.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_1014034044;
                
                
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.343 -0400", hash_original_method = "71138EED54E53D23C3276CE2823C27F9", hash_generated_method = "BCB32586429AD2B523415F04EC96DC42")
            @Override
            public long getItemId(int position) {
                Container item = item(position);
                addTaint(position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1528780506 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1528780506;
                
                
                
                    
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "7DF26D899C54947031F6630296829B71")
            @Override
            public boolean areAllItemsEnabled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121695107 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_121695107;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_method = "66B4CEB83428A6B0A2524002D770BF9B", hash_generated_method = "4A7F0525974B1D7D527596802C972E16")
            @Override
            public boolean isEnabled(int position) {
                Container item = item(position);
                addTaint(position);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124727877 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_124727877;
                
                
                
                    
                
                
            }

            
        }


        
        private class SingleDataSetObserver extends DataSetObserver {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_field = "1628F13DF17E9E9D9F9B263B8D9EDD6C", hash_generated_field = "2D84C7F454FDE105876BFC5F1B67C86D")

            private long mCheckedId;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_field = "3F37B910066E368A8F9F00CF63E3318B", hash_generated_field = "7E41BBAA7AC45D61F96A7CC2A5AFF94F")

            private ListView mListView;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "6E193E3C34AABA5E66E6DED38A82989F")

            private Adapter mAdapter;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.344 -0400", hash_original_method = "B51F7BE865C9F15328D10FA16646547D", hash_generated_method = "E96D6794E0A94B47CBCDFF86041C30D5")
            public  SingleDataSetObserver(long id, ListView l, Adapter a) {
                mCheckedId = id;
                mListView = l;
                mAdapter = a;
                
                
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_method = "C5592B2337B812BBABE83D8EC12313CA", hash_generated_method = "BDBBB8630E6EE4497FF0B8DFB56A8C9F")
            @Override
            public void onChanged() {
                
                int position = mListView.getCheckedItemPosition();
                long id = mAdapter.getItemId(position);
                {
                    mListView.clearChoices();
                    int count = mAdapter.getCount();
                    {
                        int i = 0;
                        {
                            {
                                boolean varA60FED54EC8179E35E73102579F12B18_255669053 = (mAdapter.getItemId(i) == mCheckedId);
                                {
                                    mListView.setItemChecked(i, true);
                                } 
                            } 
                        } 
                    } 
                } 
                
                
                
                
                    
                    
                    
                        
                            
                            
                        
                    
                
            }

            
        }


        
    }


    
    @Deprecated public interface PictureListener {
        
        @Deprecated
        public void onNewPicture(WebView view, Picture picture);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "BE33F1BA0BEAFDD282FD866A71F8C820", hash_generated_field = "C884772B85D7A19B6E7193901BB68389")

    static private final boolean AUTO_REDRAW_HACK = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "B69D7271B5B04F230CFD3A39801848FE", hash_generated_field = "3DDB64784E4CB9C9D138ACE428331F35")

    static final String LOGTAG = "webview";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "401D0C50F5B5682013FF8501F0AE4992", hash_generated_field = "18A327C2449F72346CC969AA861F8DED")

    private static final int TOUCH_SENT_INTERVAL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "FDA2833B881423CF2382162CF73E5DD8", hash_generated_field = "53225B6EA9B5E46653E7A2FF841F62C6")

    private static final float MINIMUM_VELOCITY_RATIO_FOR_ACCELERATION = 0.2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "830E36417005DF9041C9C155F5AF0C5E", hash_generated_field = "0E03AEB798357E5423FA6ECC32D0ACBF")

    private static final int TOUCH_INIT_MODE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "BC0287058F8F9C0519ADF1B05059B082", hash_generated_field = "1E0980F04B2FCD375BEABB7363B8FF68")

    private static final int TOUCH_DRAG_START_MODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "60FF79799CAE259EC9644FE4567C81E9", hash_generated_field = "83AE715CF0D0671A947C87A1241F0CA1")

    private static final int TOUCH_DRAG_MODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "8C98CB345A5C0960936AFB57236AE88D", hash_generated_field = "0CF4A98B15B6BE2EA0162F1E9D30FC12")

    private static final int TOUCH_SHORTPRESS_START_MODE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "4EE5240F8B0AE93BC98E85CB9DC7832A", hash_generated_field = "FECEEB0AF4271E899239BD7E9D392EBF")

    private static final int TOUCH_SHORTPRESS_MODE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "45A1C3A3DFB55C39DB0613949B81D56D", hash_generated_field = "64F3E1DC401E3A13C6A5A084547AFA2E")

    private static final int TOUCH_DOUBLE_TAP_MODE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "542A404318769EFE31C3373EC72F80C0", hash_generated_field = "A9451B2FBF47965DCA0749E0900C1CA7")

    private static final int TOUCH_DONE_MODE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "50B3C9A9C73BD42555AEF7EF2E21DDBF", hash_generated_field = "D21FFBF08857043ABC578F1B36B815A5")

    private static final int TOUCH_PINCH_DRAG = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "53FA87A229E47122811D2AC915236BDB", hash_generated_field = "06D188067A2E01E8C0722603047A2705")

    private static final int TOUCH_DRAG_LAYER_MODE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "243187813A74B6724D1D7D013A4914BF", hash_generated_field = "00B1D06ABC60B4D9DE848C3A99A708E8")

    private static final int PREVENT_DEFAULT_NO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "114BA0DFA413E46BD05BCCCAE52F7CE9", hash_generated_field = "DE6AB7A95401C72A4B1DD8181041E794")

    private static final int PREVENT_DEFAULT_MAYBE_YES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "764EAA1B45BBED56BEFF79F78CCCC30F", hash_generated_field = "ED8840ED75A291E8054A7C1BB5671FBA")

    private static final int PREVENT_DEFAULT_NO_FROM_TOUCH_DOWN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "115EA2E1D84C5A2DBB3A66D18E55207E", hash_generated_field = "F777B90C70D246657A3C6B01F65E2838")

    private static final int PREVENT_DEFAULT_YES = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "6E418AA2FF2BF9C4AAC516F3D1516EB4", hash_generated_field = "4874F2F37BC83962E22DDD1E2023B942")

    private static final int PREVENT_DEFAULT_IGNORE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "01D9479B5CB4E71DC6D0011835E1DB7F", hash_generated_field = "446CCE199F5D3015561B78678D2F07D8")

    private static final int TAP_TIMEOUT = 300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "DAFA273212F04FC87B65CE7853DD4431", hash_generated_field = "E78B19BF94D0E2E7ABD1F2CBBC9D67B8")

    private static final int LONG_PRESS_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "3615EDC2077354E3863F1AA174E54A2F", hash_generated_field = "37FBC39ACE1B888AF1A1226526A7D957")

    private static final int MIN_FLING_TIME = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "D58A8B27FE3FA5C832771535E3640C37", hash_generated_field = "A558F8CE44ACC3F82805560DA4A932C7")

    private static final int MOTIONLESS_TIME = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.345 -0400", hash_original_field = "1CD32C13456CF785393CD5CEF1F8FE90", hash_generated_field = "F573EA34E02588F19A8B5DB8F4B4F895")

    private static final int PAGE_SCROLL_OVERLAP = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "85BC58835EF22EB8B7BFF6BF6659DAB0", hash_generated_field = "9F54938D22845D58128476233294B76A")

    private static final int STD_SPEED = 480;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "C5EECEC275CDFA7928896A1923B370C6", hash_generated_field = "9CD1C2BB172E17A60A57E99E0950EF4F")

    private static final int MAX_DURATION = 750;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "EF4821831D32A9783A9848E8A3E2A3A6", hash_generated_field = "02D03CB624675F55BDCD5E41671FD647")

    private static final int SLIDE_TITLE_DURATION = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "24A904D49EE9497D9F59EB6815718BD9", hash_generated_field = "E8C9A528EEF567C1C6F71F0F8BDD0AD6")

    private static Paint mOverScrollBackground;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "73148EE68E3BF99A9D7C02B4BA6163F6", hash_generated_field = "9CFFB41CE7C3DFBAB932F7E5B2B5A059")

    private static Paint mOverScrollBorder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "BB8DFFB09685AD77BA9927AC1D758774", hash_generated_field = "BF51A867D871DC62C484459645C786EE")

    private static final int MOTIONLESS_FALSE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "9B547B86098357EF9040837C5801F603", hash_generated_field = "221783611900669BBF31AB8C03851102")

    private static final int MOTIONLESS_PENDING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "B0E7FFFCB301B45048F9EEB47D7877B9", hash_generated_field = "1D92A2861F83A93813AB357DE4223391")

    private static final int MOTIONLESS_TRUE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "3DE6CF176FEB4908AE3D96A9A6F4F88B", hash_generated_field = "C6E1D10F9F9872B9A144832957CA340B")

    private static final int MOTIONLESS_IGNORE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "73FED487255AE81470218D0CBF3A09FE", hash_generated_field = "56E82801D034FBA81618FDC04F23AD89")

    static final boolean USE_JAVA_TEXT_SELECTION = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "51619C191BA20D95DACC60375D2D07F0", hash_generated_field = "76611AB1485AA5FC8BD8987CF3E25BA9")

    static final boolean DEBUG_TEXT_HANDLES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "1AEBD097FC2E1CD6F89DD1815A965E31", hash_generated_field = "F714A1E692291741531539A5847EE5E7")

    static final boolean USE_WEBKIT_RINGS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "B282E941A1CF3225E10262EA2884F7C3", hash_generated_field = "D99D6450883933EC3EDB9D544EA20E89")

    private static final int HIGHLIGHT_COLOR = 0x6633b5e5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "9BDC47B861E33CE5CF5D947AD0F57B59", hash_generated_field = "B9E672C8C92E4F02476A87E5E8F00EFF")

    private static final float TOUCH_HIGHLIGHT_ARC = 5.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "ED37554492F6447916EB8E7CD93BD07D", hash_generated_field = "D9CFD52B18DD7ACE5C7B4C9B8DCE0FB8")

    private static final boolean DEBUG_TOUCH_HIGHLIGHT = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "EB8E2B25D453DF18B2094FCBD1B00BD9", hash_generated_field = "9694C60ABD71F7A40135B185FF8C39AE")

    private static final int TOUCH_HIGHLIGHT_ELAPSE_TIME = 2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "49AC45054CF7856A64543A32C588FA23", hash_generated_field = "845FF623ACA8C5E4C6AACC50D38E08AD")

    private static final int REMEMBER_PASSWORD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "E4E660C7AE61BE902790AC4D73AC49CF", hash_generated_field = "4FF8F5E62D23B1965B10DFC91A32FDAE")

    private static final int NEVER_REMEMBER_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "10435B44801FE7F48C9F6D6372BDBB48", hash_generated_field = "B588C19F42988465D315DA2A4FBBA3FD")

    private static final int SWITCH_TO_SHORTPRESS = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "530A8354858626CD11B71F031040A8E8", hash_generated_field = "657A48B0D0DC22729992E21828434A12")

    private static final int SWITCH_TO_LONGPRESS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "4D5243D5F746CB51670C65AA9BE7F05E", hash_generated_field = "186CFC188140DCBE345F602F7F0C2905")

    private static final int RELEASE_SINGLE_TAP = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "1289E896C38EE9E355229E2F451A0BC9", hash_generated_field = "79842F5FC0B8AB67D642FA8B9A679175")

    private static final int REQUEST_FORM_DATA = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "A43738E6619122218BEFFA63A7C1E03F", hash_generated_field = "A32950EE1B5E9CE33CFBA9FC2515D222")

    private static final int DRAG_HELD_MOTIONLESS = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "C113C7F74C1996CA65C2696D86748284", hash_generated_field = "EE164C411576EF13FF1F4368945ABBDA")

    private static final int AWAKEN_SCROLL_BARS = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "B65F2CF00C901DE7591BAC977345FBC8", hash_generated_field = "9AA9F86C18770C4CCDF9B4E83C0A3AE1")

    private static final int PREVENT_DEFAULT_TIMEOUT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "7CB2EB69693E24C1E3251BB6A2E4B18C", hash_generated_field = "1A30728C562EE960FCAE38492FDF5A10")

    private static final int SCROLL_SELECT_TEXT = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "3059CA9576FD841DE6A4EABDD0120D8A", hash_generated_field = "C4C2FB6BF24B5B91EE6F668B637E3F5E")

    private static final int FIRST_PRIVATE_MSG_ID = REMEMBER_PASSWORD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "519D5D8383980F94F362D163FA1DD3A4", hash_generated_field = "CC36E89D4F3E8BDB7A3B14B8623FFDC6")

    private static final int LAST_PRIVATE_MSG_ID = SCROLL_SELECT_TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "D55D1847289294695B340BDD6B988D61", hash_generated_field = "7254467C2E49F4861061982FEF332006")

    static final int SCROLL_TO_MSG_ID = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "7C3FDB228096679810DC186C1CF5D088", hash_generated_field = "7065AF08B8A2C65D18732F27B9BF7699")

    static final int NEW_PICTURE_MSG_ID = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "5D4D86559B515C33EA45F74EAD2CC2C9", hash_generated_field = "277D21369AF0DCC3922F2C0900E0BF83")

    static final int UPDATE_TEXT_ENTRY_MSG_ID = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "27425AA4F646CE9409853E6F26DBF525", hash_generated_field = "2190393FA6B05377859E2EC02FC609B1")

    static final int WEBCORE_INITIALIZED_MSG_ID = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "5AC192AFA63C2DA703CD387DE90D4698", hash_generated_field = "363113902179F1670C84BE84F2AB8C31")

    static final int UPDATE_TEXTFIELD_TEXT_MSG_ID = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "C609D9E92E308266EDF2BEBD11FE2195", hash_generated_field = "4013CBF1F8ABDA417E1F0266A418CE84")

    static final int UPDATE_ZOOM_RANGE = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "54C3FACEFBED28B431192B4CDBE80F30", hash_generated_field = "ACAC39F47E162B00CF5452C8D285224A")

    static final int UNHANDLED_NAV_KEY = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "E29CE477AA12360FD97442B94DAA604D", hash_generated_field = "D4C9BC4EE92065A4B38085E347EBFF2D")

    static final int CLEAR_TEXT_ENTRY = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "8C4DA7752E60D44364A5ECFCEF99A265", hash_generated_field = "FE149D6B2BEA3EF65A0F281FAAB4BD1B")

    static final int UPDATE_TEXT_SELECTION_MSG_ID = 112;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "84608AF3D8EA7A17339C6FED52EFB3A5", hash_generated_field = "AAAC74426AC96A03AD3699140276236E")

    static final int SHOW_RECT_MSG_ID = 113;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "EA5BFD49CB9CF50F04845C0B4CE85222", hash_generated_field = "5AAABADC1AB3CEBAA78D6532F857C623")

    static final int LONG_PRESS_CENTER = 114;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "69651E0CF2DFC70C890C9154E5E8EEC9", hash_generated_field = "201D6503E6272B55C420339E2E7BDE7C")

    static final int PREVENT_TOUCH_ID = 115;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "1AA05479A95D5BD8B976401AEBB8CCDE", hash_generated_field = "A86F64A6A36838BB94E4B146AB31DF86")

    static final int WEBCORE_NEED_TOUCH_EVENTS = 116;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "FAF53D01BEE8944F7215354C856F468D", hash_generated_field = "79B69F5D8A24CF7E46EB19A46659BFA2")

    static final int INVAL_RECT_MSG_ID = 117;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "F47CC7CACF8E20748A09BD16E3A63C93", hash_generated_field = "924815315D700D740440DFA55EE36D91")

    static final int REQUEST_KEYBOARD = 118;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.346 -0400", hash_original_field = "6DC3FF7954CA1B8684172C35663F6018", hash_generated_field = "4768152ADFCA823C71171A5E37B97106")

    static final int DO_MOTION_UP = 119;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "003B744EDA0119EC87BE6E2D37CC9FD0", hash_generated_field = "E7977AC2556CED43CF07CEE5AF8FDE33")

    static final int SHOW_FULLSCREEN = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "6916AD38396C039CF7A2A9D6861B5AF3", hash_generated_field = "B95AC15CEB23F6D073C96BA18C56AFC4")

    static final int HIDE_FULLSCREEN = 121;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "9566E946872EB8E7E6449806A9DF33D9", hash_generated_field = "11B42A13FA8326EB24C2CB47B363607D")

    static final int DOM_FOCUS_CHANGED = 122;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "2EF259B427BB991D0C937BFB2BE3C42B", hash_generated_field = "993E493207463D5A7619CFA9914C444F")

    static final int REPLACE_BASE_CONTENT = 123;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "8F6D1F23B16393627AFD799A33AAFF06", hash_generated_field = "656F7FC823E801D32B0F7134A367764C")

    static final int FORM_DID_BLUR = 124;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "2EC1934D71D80965F1B69F5FF6FED113", hash_generated_field = "96DB2122D5F33DFDA3965819F33C1149")

    static final int RETURN_LABEL = 125;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "AEB0E9A0D786D281759570E1D3D1AF21", hash_generated_field = "E77F6B5D2A8DAA7E01A4E6E904DA5730")

    static final int FIND_AGAIN = 126;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "5B535484FC890961BE35B4A3205AA615", hash_generated_field = "72BDFF2047DC48D536EFABE2C6EBF63A")

    static final int CENTER_FIT_RECT = 127;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "A7D2B49B5AE9081B8DDDD83C00736EE3", hash_generated_field = "8BE537A1AEFB91D6733828F1CA586112")

    static final int REQUEST_KEYBOARD_WITH_SELECTION_MSG_ID = 128;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "C7E93A778889DDC7932BAEEB5BCEE567", hash_generated_field = "A9F84DE94816567373BF26E254C087FE")

    static final int SET_SCROLLBAR_MODES = 129;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "B3177134897C8DFFA9BAB5BA3C05B8B7", hash_generated_field = "AD64A4F8822122E1A34DBBC79E31614C")

    static final int SELECTION_STRING_CHANGED = 130;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "CA6D15AAF79CDD46037E73B025B37834", hash_generated_field = "8CDB94B0E367FF9B79372CF48343B648")

    static final int SET_TOUCH_HIGHLIGHT_RECTS = 131;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "2EA3BEAA3C901DC2BB377FB00BECFE92", hash_generated_field = "03CC030275D6F647B2B790C448B6FE84")

    static final int SAVE_WEBARCHIVE_FINISHED = 132;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "50AB73069C58FAC296166BC532CB5760", hash_generated_field = "FFD1C9BADD0FACA49935CBF0B35A5383")

    static final int SET_AUTOFILLABLE = 133;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "0A1BEFD7E68E18BF9CC202EF323666D4", hash_generated_field = "BC4DF909BBCB4938EDEA9A6C5ED1E05E")

    static final int AUTOFILL_COMPLETE = 134;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "E7E3A002FB23C3217F9D944DEA5F5B54", hash_generated_field = "1A34A6FEE310D5268F65BDDC9AB9E463")

    static final int SELECT_AT = 135;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "3A8C6A82BDA7D9C95C7EFB68018C9372", hash_generated_field = "170B2EC041BE3DE273500B68E73B6761")

    static final int SCREEN_ON = 136;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "E361A725E223177E8552B43A81658190", hash_generated_field = "73783E2BCB2A1F25F9EF7718CCC75157")

    static final int ENTER_FULLSCREEN_VIDEO = 137;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "204186BCD7E786A5A01B660759D544CF", hash_generated_field = "8C35AD6313526A4AA2605C4FC66BF0A4")

    static final int UPDATE_SELECTION = 138;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "BFE5627CEC722F03BA59FF5AF23934A4", hash_generated_field = "9390DCDC12CE0060B9E23ED7E29C5AC0")

    static final int UPDATE_ZOOM_DENSITY = 139;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "AFEBA1F2632AD4DE0C180140E8F1E592", hash_generated_field = "8C572792B03EEB5427DEDA49100454ED")

    private static final int FIRST_PACKAGE_MSG_ID = SCROLL_TO_MSG_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "071F2F9C86F5CED219B8D50D1677ECBC", hash_generated_field = "4E7D46918644EB2075A696C11D88350A")

    private static final int LAST_PACKAGE_MSG_ID = SET_TOUCH_HIGHLIGHT_RECTS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "F8621D1D7316FE89A39C049148B16B1D", hash_generated_field = "EC4F303E77A821379320E37664FF35DF")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "E469D0A32FE5EEFBB04FAC2135540B9A", hash_generated_field = "901B45DD84C4CF5B9A7D7031ADD68131")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "B0207B3D1F105BD4C6FF1DFB3397F6BE", hash_generated_field = "9761827C7845EFC6D5CF4797497EE272")

    static final int DEFAULT_VIEWPORT_WIDTH = 980;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "C7C52A666164DF7B3E364496B072FA1B", hash_generated_field = "38CEEAAAB3790DFAD8857A5E87A0E5A9")

    static int sMaxViewportWidth = DEFAULT_VIEWPORT_WIDTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "EFE4F3F527E58E1F472661269CB21F20", hash_generated_field = "12DD7BA1ECB0CEEABEAEA8C19EA4EEC0")

    private static final int SNAP_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "40DB83FCE6FE454744F6D2EA70F24618", hash_generated_field = "44F29DF20F3360AEBB95E56773127AF4")

    private static final int SNAP_LOCK = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "1173B417EA85A1FE1B2816EC3B3B9805", hash_generated_field = "6DBF6AE108E04D4351B186A179DF3FCA")

    private static final int SNAP_X = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "80C11D80611607FDE87E0C854EDA9C19", hash_generated_field = "5AFF215A3A6D74F76184DEFB1B36A42A")

    private static final int SNAP_Y = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "4662EDB02CABDC9825DB87E85EA0A479", hash_generated_field = "93A7BEEBD6A337BD2002A7AF261BA794")

    private static final int DRAW_EXTRAS_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "03D3C784194DBDDB8EF2D8674C4CB97E", hash_generated_field = "5DEF86C95A734C2BFB2CF176BC8AC764")

    private static final int DRAW_EXTRAS_FIND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "13C056443A8265E118C25957CACC59A9", hash_generated_field = "F45EEC0EFD9D990731D68240BE77F3B6")

    private static final int DRAW_EXTRAS_SELECTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "72B04644BE104633F973AB39BEFF1D92", hash_generated_field = "DB426EFE262457E5F8DE02B93DD898EE")

    private static final int DRAW_EXTRAS_CURSOR_RING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "94CE3CC595BF8C31C237A3991205B7A7", hash_generated_field = "9CB3776FCE6B53D91225CA998E19D152")

    private static final int SCROLLBAR_AUTO = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "08412D589FB359281E6F51BDCD28A4F1", hash_generated_field = "A8314BA3A711CC792258269C0F75D504")

    private static final int SCROLLBAR_ALWAYSOFF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "05E7871F3F6659B23C0E3D2C6201072C", hash_generated_field = "91745CC4B7D62D037FA8FA9A02FEAC20")

    private static final int SCROLLBAR_ALWAYSON = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "1AFD361CD4099877E4EE1B9DBAB07A29", hash_generated_field = "5F56089957CE2AA577D90FD2366DCB5C")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_UNDEFINED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.347 -0400", hash_original_field = "DA7BB58AAB3614069121B03E82B783E3", hash_generated_field = "C154CE6C5A7DD848C5458E579A34E977")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_OPTED_OUT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "A737E64624713D057C27854F572D03CE", hash_generated_field = "3EE141793CAB7DBE4F282C0A0792360A")

    private static final int ACCESSIBILITY_SCRIPT_INJECTION_PROVIDED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "FD3BAC1D0E0B96B8A53C06BB67C68A8F", hash_generated_field = "7FEACEF0FBD261C47258EABED39A961E")

    private static final String ALIAS_ACCESSIBILITY_JS_INTERFACE = "accessibility";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "2F570EB1C0B5AF92ED302A83FC29354A", hash_generated_field = "B29CA3A404F2C496300BF93ECDFE7B1F")

    private static final String ACCESSIBILITY_SCRIPT_CHOOSER_JAVASCRIPT = "javascript:(function() {" +
        "    var chooser = document.createElement('script');" +
        "    chooser.type = 'text/javascript';" +
        "    chooser.src = 'https://ssl.gstatic.com/accessibility/javascript/android/AndroidScriptChooser.user.js';" +
        "    document.getElementsByTagName('head')[0].appendChild(chooser);" +
        "  })();";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "B5113A5B1DAE52AA872D7A1E0158A2B6", hash_generated_field = "AEB0CAD4A217DE1EC3D3A6DD22EAA58A")

    private static final String PATTERN_MATCH_AXS_URL_PARAMETER = "(\\?axs=(0|1))|(&axs=(0|1))";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "4207D404B869699B69E8B9A28FF0112D", hash_generated_field = "0B476E3CCACC629DB9A3D288788EC4D4")

    static boolean mLogEvent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "B932813E6159962053C79AB9C0A459E5", hash_generated_field = "EED2A629500C8CA0653CD2F48FDAD9D7")

    private static boolean sNotificationsEnabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "FD797E3F2ECF357959667B87D54163F3", hash_generated_field = "1105526185EEB7FC5A898096FC617896")

    public static final String SCHEME_TEL = "tel:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "225D791BAFA68A3EC0D62F0726E1C7DB", hash_generated_field = "36F5F4D1322A91FC8551EC5BF47D4080")

    public static final String SCHEME_MAILTO = "mailto:";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "95B5491231B2BD8A25696C3FDBF06E01", hash_generated_field = "7B183832849E08B748A127FC4F00AF3D")

    public static final String SCHEME_GEO = "geo:0,0?q=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "051179065C958003073ADEEFBDE35A13", hash_generated_field = "12AA7BB1627971F332190446E320A104")

    private static final long SELECT_SCROLL_INTERVAL = 1000 / 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "8E886A75D21BC0A8EDA5A50DD2A2B661", hash_generated_field = "E9A626874BEA31BC13B6B41907D72FD5")

    private static boolean mIncrementEGLContextHack = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "05C1F221F8421AA338F917FB17984ED7", hash_generated_field = "4EA311A46057E2E819D49F1C54EBACAA")

    private static ProxyReceiver sProxyReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "B04F1E80E74352FC14B6E673A4415CE7", hash_generated_field = "BE2C046AC7C6AC534B7DCBF692384BF9")

    private static boolean sPackageInstallationReceiverAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "D4FB0BB6CF479A72D29BD86B9884DB2C", hash_generated_field = "D793892490DD0E214DB1F20B155AEC44")

    private static Set<String> sGoogleApps;
    static {
        sGoogleApps = new HashSet<String>();
        sGoogleApps.add("com.google.android.youtube");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "4D9F0ACF100BF12F3249E38226B0B830", hash_generated_field = "739202D5461617487329E2B164F8902F")

    private static final int FULLY_ON_SCREEN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "B3DAEF4CBC835FE704F50BAB24E8A713", hash_generated_field = "CE05C08766D95F4E3F036CF82E22E80D")

    private static final int INTERSECTS_SCREEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "7D0FC8807A6DAD03A3EEF8D4870C9F1C", hash_generated_field = "0FFC4C37CCC54707516F4AEADC8D4AB0")

    private static final int ANYWHERE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "33C657D7990E0880732140E3FDF51E3B", hash_generated_field = "2489EBB9D342B040697800D9D9593C68")

    private static final int ZOOM_BITS = Paint.FILTER_BITMAP_FLAG |
                                         Paint.DITHER_FLAG |
                                         Paint.SUBPIXEL_TEXT_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "81B6014E51F8640F4C3BE886B84FFC2F", hash_generated_field = "AF1F828F986930EB290A0C1ACE51C53E")

    private static final int SCROLL_BITS = Paint.FILTER_BITMAP_FLAG |
                                           Paint.DITHER_FLAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "143FC8BD92F9F5E41D5B5AA2ACC23EAF", hash_generated_field = "0002A73C608BB024BD4E79AB8BAC6B7C")

    private static final float HSLOPE_TO_START_SNAP = .25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "57D22AEB68A352A473B3BB324D0706C6", hash_generated_field = "A4A8D0695FF84A162831C09369F3446A")

    private static final float HSLOPE_TO_BREAK_SNAP = .4f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "37354A8D270C32257C72BE5597FB7279", hash_generated_field = "6129E624D18CD718742AEA8DBDBB14BE")

    private static final float VSLOPE_TO_START_SNAP = 1.25f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "745986FED15EB48957154C828FC231A2", hash_generated_field = "B98021F16BB475A9FDBFB533AE2C5734")

    private static final float VSLOPE_TO_BREAK_SNAP = .95f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "74A90F27F6687BD7AEDE42DCCF796A92", hash_generated_field = "F2D9920A33A34535ECA37BEBE3D0D75B")

    private static final float ANGLE_VERT = 2f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "58AA9F4B68153F9977887D7962B27368", hash_generated_field = "D881007596C110DADFB66D030A1AE042")

    private static final float ANGLE_HORIZ = 0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "4A747B48E4EBAF042963963238305567", hash_generated_field = "02A991FD63390E5D8237C6CD740E3288")

    private static final float MMA_WEIGHT_N = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "9F27E3A2EA0479B09454B6F4F4C36594", hash_generated_field = "6160B4B901E476897B185DB9EAAB3142")

    private static final int DRAG_LAYER_FINGER_DISTANCE = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "94CF454460F3D9B267AD1D71FC1B9BF2", hash_generated_field = "6A677A0E966C283B8B607D7ECEA95F9F")

    private static final int TRACKBALL_KEY_TIMEOUT = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "D17AF2C8459C9B012E8B75A161A5E702", hash_generated_field = "B007269D873CD11DCF66489AD37A9EAD")

    private static final int TRACKBALL_TIMEOUT = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "AD0F5C36BF5024E1632C3A949A30653F", hash_generated_field = "38263236B59C07C6CAD6AC61CCFF665A")

    private static final int TRACKBALL_WAIT = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "8598DD7F0E8E1CF6A80EFC6EE9950550", hash_generated_field = "9569AC1D1AEE74878270EB42C805F75F")

    private static final int TRACKBALL_SCALE = 400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "2417DDD0E0F947309A148BA8C5E5E454", hash_generated_field = "8C66096D385ED6DA92A759E273B8AD09")

    private static final int TRACKBALL_SCROLL_COUNT = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "C28FA06E3FF6020B796AC6D6D435CCBE", hash_generated_field = "6749FB93CFC3225830453166B1116D09")

    private static final int TRACKBALL_MOVE_COUNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "B90911B82DAA7EFF1DCFDF49CEFDEC81", hash_generated_field = "E7BC40FBD90C7DEFDA42D41012CE3CB4")

    private static final int TRACKBALL_MULTIPLIER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "52736B1F2556D5D3FE54D29A35887B61", hash_generated_field = "0A2B827BEE20945621FE1CF47839A0CD")

    private static final int SELECT_CURSOR_OFFSET = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.348 -0400", hash_original_field = "81637AAEC67A193923C7C5B16D17CE5D", hash_generated_field = "60B8D37D0EC66557053483F48A69616B")

    private static final int SELECT_SCROLL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:07.349 -0400", hash_original_field = "08F02E86CCFB75F0CC70FDFDEBC67BF2", hash_generated_field = "A9F4333AC17378DA2BC1CE8FE8AF3863")

    static final int NO_LEFTEDGE = -1;
}

