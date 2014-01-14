package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.AppGlobals;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.SparseArray;

public class ViewConfiguration {

    /**
     * Returns a configuration for the specified context. The configuration depends on
     * various parameters of the context, like the dimension of the display or the
     * density of the display.
     *
     * @param context The application context used to initialize the view configuration.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.372 -0500", hash_original_method = "EAB98871E057FCDFFF813B18E6EC4641", hash_generated_method = "65D047D00C018AF4F4B8E7987373C246")
    
public static ViewConfiguration get(Context context) {
        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final int density = (int) (100.0f * metrics.density);

        ViewConfiguration configuration = sConfigurations.get(density);
        if (configuration == null) {
            configuration = new ViewConfiguration(context);
            sConfigurations.put(density, configuration);
        }

        return configuration;
    }

    /**
     * @return The width of the horizontal scrollbar and the height of the vertical
     *         scrollbar in pixels
     *
     * @deprecated Use {@link #getScaledScrollBarSize()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.375 -0500", hash_original_method = "0A2417CF394B936A6105A27E128EFF04", hash_generated_method = "1DE964CC2B413D99F6C6AAADB5B01F9C")
    
@Deprecated
    public static int getScrollBarSize() {
        return SCROLL_BAR_SIZE;
    }

    /**
     * @return Duration of the fade when scrollbars fade away in milliseconds
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.380 -0500", hash_original_method = "E421242C09568631C50949743537018E", hash_generated_method = "0299A692E41855E9E03F6A872BF18F19")
    
public static int getScrollBarFadeDuration() {
        return SCROLL_BAR_FADE_DURATION;
    }

    /**
     * @return Default delay before the scrollbars fade in milliseconds
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.383 -0500", hash_original_method = "EE4CEAB6942F44112E7DC4BE20D131BC", hash_generated_method = "F67C562244575945C8A8615AD4819D70")
    
public static int getScrollDefaultDelay() {
        return SCROLL_BAR_DEFAULT_DELAY;
    }
    
    /**
     * @return the length of the fading edges in pixels
     *
     * @deprecated Use {@link #getScaledFadingEdgeLength()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.385 -0500", hash_original_method = "8C64B9F8A7003C13690A959F566BECFE", hash_generated_method = "18196CB12B81238D19D1C78AB9B072E4")
    
@Deprecated
    public static int getFadingEdgeLength() {
        return FADING_EDGE_LENGTH;
    }

    /**
     * @return the duration in milliseconds of the pressed state in child
     * components.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.389 -0500", hash_original_method = "986F5CD389833E1A3B848F5DFC09AF7E", hash_generated_method = "88D4DB715B5E66C35FDF33DA6308CA9F")
    
public static int getPressedStateDuration() {
        return PRESSED_STATE_DURATION;
    }

    /**
     * @return the duration in milliseconds before a press turns into
     * a long press
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.392 -0500", hash_original_method = "4FEA2532A879AC8499A02B1497AE3156", hash_generated_method = "5BDFE3F6B4823EA868E8FC12A1E27412")
    
public static int getLongPressTimeout() {
        return AppGlobals.getIntCoreSetting(Settings.Secure.LONG_PRESS_TIMEOUT,
                DEFAULT_LONG_PRESS_TIMEOUT);
    }

    /**
     * @return the time before the first key repeat in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.394 -0500", hash_original_method = "56C3332D841CB845ED684C3342A8EF80", hash_generated_method = "6A8AFDD302B5F0B5F5471E434824883E")
    
public static int getKeyRepeatTimeout() {
        return getLongPressTimeout();
    }

    /**
     * @return the time between successive key repeats in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.396 -0500", hash_original_method = "952410958896B72F9892DD38AA0BACAC", hash_generated_method = "304F4022BE61A4A795ECF5CEF744DB12")
    
public static int getKeyRepeatDelay() {
        return KEY_REPEAT_DELAY;
    }

    /**
     * @return the duration in milliseconds we will wait to see if a touch event
     * is a tap or a scroll. If the user does not move within this interval, it is
     * considered to be a tap. 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.399 -0500", hash_original_method = "2054B3BE796FC76059006CC8B92F3425", hash_generated_method = "5AD9BFA0A5FAC59C26025C95AC442E44")
    
public static int getTapTimeout() {
        return TAP_TIMEOUT;
    }

    /**
     * @return the duration in milliseconds we will wait to see if a touch event
     * is a jump tap. If the user does not move within this interval, it is
     * considered to be a tap. 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.401 -0500", hash_original_method = "712BEBBA15DDE6D9B5BA141CEBD73697", hash_generated_method = "324F7B30BF1EA0EB5F37DD6924F78453")
    
public static int getJumpTapTimeout() {
        return JUMP_TAP_TIMEOUT;
    }
    
    /**
     * @return the duration in milliseconds between the first tap's up event and
     * the second tap's down event for an interaction to be considered a
     * double-tap.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.404 -0500", hash_original_method = "C6977CF707F5347B0F237AB856D16490", hash_generated_method = "2CBE85464FBF2DA33E26EE594A400A04")
    
public static int getDoubleTapTimeout() {
        return DOUBLE_TAP_TIMEOUT;
    }

    /**
     * @return the maximum duration in milliseconds between a touch pad
     * touch and release for a given touch to be considered a tap (click) as
     * opposed to a hover movement gesture.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.406 -0500", hash_original_method = "285032CB4BAC3764E315512D2B9D5FFB", hash_generated_method = "FB8D1F641C08E03888A12A63F453578C")
    
public static int getHoverTapTimeout() {
        return HOVER_TAP_TIMEOUT;
    }

    /**
     * @return the maximum distance in pixels that a touch pad touch can move
     * before being released for it to be considered a tap (click) as opposed
     * to a hover movement gesture.
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.408 -0500", hash_original_method = "B475AFBEADA30C05164C37D5565D4F02", hash_generated_method = "CEF9D27BD30BC4765AB0199F95597FAC")
    
public static int getHoverTapSlop() {
        return HOVER_TAP_SLOP;
    }

    /**
     * @return Inset in pixels to look for touchable content when the user touches the edge of the
     *         screen
     *
     * @deprecated Use {@link #getScaledEdgeSlop()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.410 -0500", hash_original_method = "0D971D69CF54747E28FD325D51504DA1", hash_generated_method = "C1B49118EDD5BD4713CFADB8DE2B32D8")
    
@Deprecated
    public static int getEdgeSlop() {
        return EDGE_SLOP;
    }

    /**
     * @return Distance a touch can wander before we think the user is scrolling in pixels
     *
     * @deprecated Use {@link #getScaledTouchSlop()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.416 -0500", hash_original_method = "B61AC12A34EFA6AB10E7C5F3FBA1C69E", hash_generated_method = "FF1EC43C2C2F4503BA634627B550A9DB")
    
@Deprecated
    public static int getTouchSlop() {
        return TOUCH_SLOP;
    }

    /**
     * @return Distance between the first touch and second touch to still be
     *         considered a double tap
     * @deprecated Use {@link #getScaledDoubleTapSlop()} instead.
     * @hide The only client of this should be GestureDetector, which needs this
     *       for clients that still use its deprecated constructor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.423 -0500", hash_original_method = "B21C34C9A7C650B71FC2E1314F2C1946", hash_generated_method = "DF88559979C7BF644876949C3111B086")
    
@Deprecated
    public static int getDoubleTapSlop() {
        return DOUBLE_TAP_SLOP;
    }

    /**
     * Interval for dispatching a recurring accessibility event in milliseconds.
     * This interval guarantees that a recurring event will be send at most once
     * during the {@link #getSendRecurringAccessibilityEventsInterval()} time frame.
     *
     * @return The delay in milliseconds.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.429 -0500", hash_original_method = "41F28C9DB7B309BD1951DBE065F93772", hash_generated_method = "96FC8E748105E1AA0A906BA11C4ECA53")
    
public static long getSendRecurringAccessibilityEventsInterval() {
        return SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS;
    }

    /**
     * @return Distance a touch must be outside the bounds of a window for it
     * to be counted as outside the window for purposes of dismissing that
     * window.
     *
     * @deprecated Use {@link #getScaledWindowTouchSlop()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.432 -0500", hash_original_method = "C4429676118726C50723506C01DBC891", hash_generated_method = "12B3ABDAF6B1DD4FC59AA5EF6A467D5B")
    
@Deprecated
    public static int getWindowTouchSlop() {
        return WINDOW_TOUCH_SLOP;
    }
    
    /**
     * @return Minimum velocity to initiate a fling, as measured in pixels per second.
     *
     * @deprecated Use {@link #getScaledMinimumFlingVelocity()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.437 -0500", hash_original_method = "546B6EB3FB7821963DFBB7988B40EAE1", hash_generated_method = "47EC8BFCFE253501827EF425964422BE")
    
@Deprecated
    public static int getMinimumFlingVelocity() {
        return MINIMUM_FLING_VELOCITY;
    }

    /**
     * @return Maximum velocity to initiate a fling, as measured in pixels per second.
     *
     * @deprecated Use {@link #getScaledMaximumFlingVelocity()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.441 -0500", hash_original_method = "B6BA12BC9FC63D5E48FA275CC038AC53", hash_generated_method = "5913DEFCBF0FB56BD450B397A23625CD")
    
@Deprecated
    public static int getMaximumFlingVelocity() {
        return MAXIMUM_FLING_VELOCITY;
    }
    
    /**
     * The maximum drawing cache size expressed in bytes.
     *
     * @return the maximum size of View's drawing cache expressed in bytes
     *
     * @deprecated Use {@link #getScaledMaximumDrawingCacheSize()} instead.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.446 -0500", hash_original_method = "75E98CDAD9F30C5A8AB1E3F56D4A9D35", hash_generated_method = "8141C2C73CD1435566C615C41005EBF8")
    
@Deprecated
    public static int getMaximumDrawingCacheSize() {
        //noinspection deprecation
        return MAXIMUM_DRAWING_CACHE_SIZE;
    }

    /**
     * The amount of time that the zoom controls should be
     * displayed on the screen expressed in milliseconds.
     * 
     * @return the time the zoom controls should be visible expressed
     * in milliseconds.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.455 -0500", hash_original_method = "5E4968614D1816EAF1E214BAA3A99C49", hash_generated_method = "F13D58897F350F38BD659664B6311E5C")
    
public static long getZoomControlsTimeout() {
        return ZOOM_CONTROLS_TIMEOUT;
    }

    /**
     * The amount of time a user needs to press the relevant key to bring up
     * the global actions dialog.
     *
     * @return how long a user needs to press the relevant key to bring up
     *   the global actions dialog.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.457 -0500", hash_original_method = "8D8BF00437B1A756760393177D6EECAF", hash_generated_method = "5CB17041FF4493D07E9A4B41C3507088")
    
public static long getGlobalActionKeyTimeout() {
        return GLOBAL_ACTIONS_KEY_TIMEOUT;
    }

    /**
     * The amount of friction applied to scrolls and flings.
     * 
     * @return A scalar dimensionless value representing the coefficient of
     *         friction.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.460 -0500", hash_original_method = "91748064AA7D196E0821A0CDB0FFFE72", hash_generated_method = "0793C6AAAD831A0F9B0498382432C7C6")
    
public static float getScrollFriction() {
        return SCROLL_FRICTION;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.251 -0500", hash_original_field = "47D836A660014D5B80D968A7366BE708", hash_generated_field = "9747DCAA618DB198D5B9A1CE115BFF97")

    public static final float PANEL_BIT_DEPTH = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.253 -0500", hash_original_field = "22CB8F46B591EDE55CD4FA6B441EF972", hash_generated_field = "A32F9F21F286F09C5FFE13705521F9D3")

    public static final float ALPHA_THRESHOLD = 0.5f / PANEL_BIT_DEPTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.256 -0500", hash_original_field = "96E94F8EDBC874E2FD85219D1C8036CE", hash_generated_field = "35907D06006F393F45FB2B825ED40F7E")

    public static final float ALPHA_THRESHOLD_INT = 0x7f / PANEL_BIT_DEPTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.258 -0500", hash_original_field = "FE10F6E4591AFEDA229721599ABE0EE3", hash_generated_field = "3C1AEDD67D3CBB2346030240E15975B8")

    private static final int SCROLL_BAR_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.261 -0500", hash_original_field = "1195C0BD8C1E681B340B1C36DE8590DB", hash_generated_field = "69F1E09B4DFF23ED0400BB441B773E33")

    private static final int SCROLL_BAR_FADE_DURATION = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.263 -0500", hash_original_field = "C83D9D4E08F718D00E9171F2B4BFE8E4", hash_generated_field = "19E2096CA52B8B5AB2F0EAD8007373AA")

    private static final int SCROLL_BAR_DEFAULT_DELAY = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.266 -0500", hash_original_field = "9E8E163C2455D8E80E25D8F40FACCECE", hash_generated_field = "768D465CF398D0FEDC762F453F3623FE")

    private static final int FADING_EDGE_LENGTH = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.269 -0500", hash_original_field = "C0F9C63E56BF472EA111A0646B0EB264", hash_generated_field = "31F150ED1E5B1E3235C847EC46AC2706")

    private static final int PRESSED_STATE_DURATION = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.271 -0500", hash_original_field = "D33F69DDA569D60A4106DA4AC807FB3A", hash_generated_field = "C5A105FE1289431C0CEFF3BB7FF405DA")

    private static final int DEFAULT_LONG_PRESS_TIMEOUT = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.274 -0500", hash_original_field = "5F27EBD2FC714BC9D3386585BC9A6C6A", hash_generated_field = "3D836E3388C779C8690BE80FA4A6F639")

    private static final int KEY_REPEAT_DELAY = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.276 -0500", hash_original_field = "6BDAAF022F25CE10223356C3E0959661", hash_generated_field = "43F76CA836CE9CF3A61450B7AEB8F1C4")

    private static final int GLOBAL_ACTIONS_KEY_TIMEOUT = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.279 -0500", hash_original_field = "3EC08BE219B1E8973CFC2BD8AE1C3727", hash_generated_field = "3B1ECBEFF4C233CD9096673DB2F61155")

    private static final int TAP_TIMEOUT = 180;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.281 -0500", hash_original_field = "B6E884A5E466642020BFD773FDC960A5", hash_generated_field = "B908F38E70932BF1EFBA4B20FA1600BC")

    private static final int JUMP_TAP_TIMEOUT = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.284 -0500", hash_original_field = "66464FB45CC419A4389F3C42B373CE8F", hash_generated_field = "B64EC6E883DFD581B5107E3F1C037D53")

    private static final int DOUBLE_TAP_TIMEOUT = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.286 -0500", hash_original_field = "DDEAA31DB1078BFA8CAD69E301E026E3", hash_generated_field = "1D5315E446DB64B1CC0113AAC2F20BB3")

    private static final int HOVER_TAP_TIMEOUT = 150;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.288 -0500", hash_original_field = "CD62A944236B136FBE1B70ED2A5052E1", hash_generated_field = "826505813607467A967020234193803D")

    private static final int HOVER_TAP_SLOP = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.290 -0500", hash_original_field = "EEAD655B8FEA60903B146C21764618EA", hash_generated_field = "7D5B0868A3F0CD926510FAE9036FE33E")

    private static final int ZOOM_CONTROLS_TIMEOUT = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.293 -0500", hash_original_field = "A3C379742A4F9EDFF0A70804C19F68DE", hash_generated_field = "767C6F21B4C4A54A1D58C8845A829D24")

    private static final int EDGE_SLOP = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.296 -0500", hash_original_field = "A54DB198367C890D7818E0748D91CEF8", hash_generated_field = "F9B41BB7FB919140842B55419F14CC34")

    private static final int TOUCH_SLOP = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.298 -0500", hash_original_field = "A77592D4A4631E246163834C88C972E6", hash_generated_field = "C45984564C2B2B383F066672D6ECDA36")

    private static final int PAGING_TOUCH_SLOP = TOUCH_SLOP * 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.301 -0500", hash_original_field = "C5DC0B55884AAB2A0EC6203B38E44CBB", hash_generated_field = "05521582705C7F65706759CD1CD8CECE")

    private static final int DOUBLE_TAP_SLOP = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.303 -0500", hash_original_field = "FAE6AE5DE939D866F8C6139FF0DE0353", hash_generated_field = "0A7EC28EE18866A9A9040E60DC4AC97B")

    private static final int WINDOW_TOUCH_SLOP = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.306 -0500", hash_original_field = "2734BB9B43475F48F61B09A800CE0875", hash_generated_field = "590039E7A300DBFA22B66BABAA6920B7")

    private static final int MINIMUM_FLING_VELOCITY = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.308 -0500", hash_original_field = "8EFB64CD915FC8024DF73BB42D6CD45F", hash_generated_field = "C16FA29D3B701C0D89C79F0F0AD1AFBD")

    private static final int MAXIMUM_FLING_VELOCITY = 8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.311 -0500", hash_original_field = "E7EF4739A2B16DE7CE51F82621D9B937", hash_generated_field = "EFD34AF3F488A3C760252D09EC59545A")

    private static final int TOUCH_EXPLORATION_TAP_SLOP = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.314 -0500", hash_original_field = "6204EC10654B0931635D82577469B819", hash_generated_field = "F01671ACC3F6966DA3CE6C8E1BE7CEB3")

    private static final long SEND_RECURRING_ACCESSIBILITY_EVENTS_INTERVAL_MILLIS = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.316 -0500", hash_original_field = "BC720E6C90342F86D40B7D946654546E", hash_generated_field = "F8FD2906DEF15086D200C8CDD2D0C403")

    @Deprecated
    private static final int MAXIMUM_DRAWING_CACHE_SIZE = 480 * 800 * 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.319 -0500", hash_original_field = "41073FC9BE7B3EF6B14D1C22DA366D4D", hash_generated_field = "ACF2C9F1C4DCC334B940273666CBC879")

    /**
     * The coefficient of friction applied to flings/scrolls.
     */
    private static final float SCROLL_FRICTION = 0.015f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.321 -0500", hash_original_field = "850977B924814773A10F26DF22D6B08C", hash_generated_field = "A04E9AC91D01157C378DC4613C063B24")

    private static final int OVERSCROLL_DISTANCE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.323 -0500", hash_original_field = "76AA66231644A854AB3BA2469EBF8672", hash_generated_field = "DA2D178DBF8807F9A6080C62905A485A")

    private static final int OVERFLING_DISTANCE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.363 -0500", hash_original_field = "D513F44D45A1B462B46A4F046199DF99", hash_generated_field = "EEDF2561C792A30151768943796E598A")

    static final SparseArray<ViewConfiguration> sConfigurations =
            new SparseArray<ViewConfiguration>(2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.326 -0500", hash_original_field = "935208C22F528795DA4A6D0F0A9B1E0C", hash_generated_field = "28AD0F459ECA25E08B8AF100A990B431")

    private  int mEdgeSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.328 -0500", hash_original_field = "038B36D4D8587CE53F588774BF59DC97", hash_generated_field = "BDC56F2B5F3D2AC25089A5150086EC5F")

    private  int mFadingEdgeLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.330 -0500", hash_original_field = "5030B66C4E6C852287D391072C8046A5", hash_generated_field = "19DF3CA9C4A086C5604F6C8FC7721322")

    private  int mMinimumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.332 -0500", hash_original_field = "3B70336BAB0F826E0E6552B2A74F553D", hash_generated_field = "7F5E59D933F0155E107640D32355B310")

    private  int mMaximumFlingVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.335 -0500", hash_original_field = "E53FD3541B2ED4D31217BC629EDD3AFA", hash_generated_field = "5F6809D206F835FAE286C3238D869AC7")

    private  int mScrollbarSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.337 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private  int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.339 -0500", hash_original_field = "E3196A9DCAB8AAFEB802DE568A88A1E7", hash_generated_field = "D1E477DC8F276E48EC9C9AAEB9FC42A1")

    private  int mPagingTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.342 -0500", hash_original_field = "C26E914F9A1490FD480D68DF2FAF551A", hash_generated_field = "E3F200D7EF3C7FA6B9D85E756BD947D5")

    private  int mDoubleTapSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.344 -0500", hash_original_field = "71C3DBF09235F6273D63669106649D07", hash_generated_field = "F1E4C8B8C10EED258C69F3270B427286")

    private  int mScaledTouchExplorationTapSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.347 -0500", hash_original_field = "9FF1945D70582050F9452BEFD73F30D7", hash_generated_field = "7AAF281D4CF32CCE4AFDDFD12AA22E61")

    private  int mWindowTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.349 -0500", hash_original_field = "7EB92C03D6FAE092D819250AF33E8DF9", hash_generated_field = "496A8039FEB96FF34A34BAD3DDBFCA0A")

    private  int mMaximumDrawingCacheSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.351 -0500", hash_original_field = "3140A319F32CA873045621864B655537", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private  int mOverscrollDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.354 -0500", hash_original_field = "F239C82AEB45C28104273F86A78E6F04", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private  int mOverflingDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.357 -0500", hash_original_field = "59B606441FF4DB15F4578C7B1F2487D2", hash_generated_field = "249C70833B7AE5BEEF7C58B3181D1CF0")

    private  boolean mFadingMarqueeEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.359 -0500", hash_original_field = "647AFA978A4333C46FD536BA1614EE90", hash_generated_field = "F0C5D2873D8EDEF272362A711C85BDB5")

    private boolean sHasPermanentMenuKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.361 -0500", hash_original_field = "518B090DAB896C2DEF68B77A1EA56B05", hash_generated_field = "885609D211F3B6965A8D53C92F40BA67")

    private boolean sHasPermanentMenuKeySet;

    /**
     * @deprecated Use {@link android.view.ViewConfiguration#get(android.content.Context)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.366 -0500", hash_original_method = "24918D20351FE8A86EAEEE2EEBA5EB08", hash_generated_method = "9E19C6DE73B3C14DD0E2FF28C2CCBCDA")
    
@Deprecated
    public ViewConfiguration() {
        mEdgeSlop = EDGE_SLOP;
        mFadingEdgeLength = FADING_EDGE_LENGTH;
        mMinimumFlingVelocity = MINIMUM_FLING_VELOCITY;
        mMaximumFlingVelocity = MAXIMUM_FLING_VELOCITY;
        mScrollbarSize = SCROLL_BAR_SIZE;
        mTouchSlop = TOUCH_SLOP;
        mPagingTouchSlop = PAGING_TOUCH_SLOP;
        mDoubleTapSlop = DOUBLE_TAP_SLOP;
        mScaledTouchExplorationTapSlop = TOUCH_EXPLORATION_TAP_SLOP;
        mWindowTouchSlop = WINDOW_TOUCH_SLOP;
        //noinspection deprecation
        mMaximumDrawingCacheSize = MAXIMUM_DRAWING_CACHE_SIZE;
        mOverscrollDistance = OVERSCROLL_DISTANCE;
        mOverflingDistance = OVERFLING_DISTANCE;
        mFadingMarqueeEnabled = true;
    }

    /**
     * Creates a new configuration for the specified context. The configuration depends on
     * various parameters of the context, like the dimension of the display or the density
     * of the display.
     *
     * @param context The application context used to initialize this view configuration.
     *
     * @see #get(android.content.Context) 
     * @see android.util.DisplayMetrics
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.369 -0500", hash_original_method = "815441BD896E00C6B865EAF3CE23B912", hash_generated_method = "46434ADDCFE39D65CA30D116EE67ED55")
    
private ViewConfiguration(Context context) {
        final Resources res = context.getResources();
        final DisplayMetrics metrics = res.getDisplayMetrics();
        final Configuration config = res.getConfiguration();
        final float density = metrics.density;
        final float sizeAndDensity;
        if (config.isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_XLARGE)) {
            sizeAndDensity = density * 1.5f;
        } else {
            sizeAndDensity = density;
        }

        mEdgeSlop = (int) (sizeAndDensity * EDGE_SLOP + 0.5f);
        mFadingEdgeLength = (int) (sizeAndDensity * FADING_EDGE_LENGTH + 0.5f);
        mMinimumFlingVelocity = (int) (density * MINIMUM_FLING_VELOCITY + 0.5f);
        mMaximumFlingVelocity = (int) (density * MAXIMUM_FLING_VELOCITY + 0.5f);
        mScrollbarSize = (int) (density * SCROLL_BAR_SIZE + 0.5f);
        mDoubleTapSlop = (int) (sizeAndDensity * DOUBLE_TAP_SLOP + 0.5f);
        mScaledTouchExplorationTapSlop = (int) (density * TOUCH_EXPLORATION_TAP_SLOP + 0.5f);
        mWindowTouchSlop = (int) (sizeAndDensity * WINDOW_TOUCH_SLOP + 0.5f);

        // Size of the screen in bytes, in ARGB_8888 format
        mMaximumDrawingCacheSize = 4 * metrics.widthPixels * metrics.heightPixels;

        mOverscrollDistance = (int) (sizeAndDensity * OVERSCROLL_DISTANCE + 0.5f);
        mOverflingDistance = (int) (sizeAndDensity * OVERFLING_DISTANCE + 0.5f);

        if (!sHasPermanentMenuKeySet) {
            IWindowManager wm = Display.getWindowManager();
            try {
                sHasPermanentMenuKey = wm.canStatusBarHide() && !wm.hasNavigationBar();
                sHasPermanentMenuKeySet = true;
            } catch (RemoteException ex) {
                sHasPermanentMenuKey = false;
            }
        }

        mFadingMarqueeEnabled = res.getBoolean(
                com.android.internal.R.bool.config_ui_enableFadingMarquee);
        mTouchSlop = res.getDimensionPixelSize(
                com.android.internal.R.dimen.config_viewConfigurationTouchSlop);
        mPagingTouchSlop = mTouchSlop * 2;
    }

    /**
     * @return The width of the horizontal scrollbar and the height of the vertical
     *         scrollbar in pixels
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.378 -0500", hash_original_method = "64B2CB77402813F2D85B7730CCF96AEF", hash_generated_method = "C9AFBA96DE4004D718B97E1E95C3F724")
    
public int getScaledScrollBarSize() {
        return mScrollbarSize;
    }

    /**
     * @return the length of the fading edges in pixels
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.387 -0500", hash_original_method = "DBA79B5462EB99E7DC2C8AF68ED4F8B2", hash_generated_method = "73C1D1F3892CC6BF705AA4DAD5B69D69")
    
public int getScaledFadingEdgeLength() {
        return mFadingEdgeLength;
    }

    /**
     * @return Inset in pixels to look for touchable content when the user touches the edge of the
     *         screen
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.412 -0500", hash_original_method = "26568609E943FB4B92788BE90A3C6865", hash_generated_method = "3BEDBBCF3580D310683AFAF9C62430F5")
    
public int getScaledEdgeSlop() {
        return mEdgeSlop;
    }

    /**
     * @return Distance a touch can wander before we think the user is scrolling in pixels
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.418 -0500", hash_original_method = "60BD37725F7CBB3A1C18E0C12D7EC92F", hash_generated_method = "E802D556E6ABBEE6F96FBE3BE1B8413A")
    
public int getScaledTouchSlop() {
        return mTouchSlop;
    }
    
    /**
     * @return Distance a touch can wander before we think the user is scrolling a full page
     *         in dips
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.420 -0500", hash_original_method = "4AE776F4126E41D66D9D9E5C3DD06CAD", hash_generated_method = "9E7AEC3E9084B4301C8E6EFAB2887388")
    
public int getScaledPagingTouchSlop() {
        return mPagingTouchSlop;
    }
    
    /**
     * @return Distance between the first touch and second touch to still be
     *         considered a double tap
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.425 -0500", hash_original_method = "6B30BD1A6859DBFC35C31996D22D0A66", hash_generated_method = "1B58B94371B51D3B39CAAF7010CA5769")
    
public int getScaledDoubleTapSlop() {
        return mDoubleTapSlop;
    }

    /**
     * @return Distance between a touch up event denoting the end of a touch exploration
     * gesture and the touch up event of a subsequent tap for the latter tap to be
     * considered as a tap i.e. to perform a click.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.427 -0500", hash_original_method = "B7560D2EBF5FE44925FF9E0F817886D6", hash_generated_method = "2C344D67371A3909E3B569EDC0D37E19")
    
public int getScaledTouchExplorationTapSlop() {
        return mScaledTouchExplorationTapSlop;
    }

    /**
     * @return Distance a touch must be outside the bounds of a window for it
     * to be counted as outside the window for purposes of dismissing that
     * window.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.434 -0500", hash_original_method = "C43D675F470050DADBFF4CBA809EB35A", hash_generated_method = "B7635E8EE7E00FFEA7708B5AB9EA898C")
    
public int getScaledWindowTouchSlop() {
        return mWindowTouchSlop;
    }

    /**
     * @return Minimum velocity to initiate a fling, as measured in pixels per second.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.439 -0500", hash_original_method = "0486ED6F0D874BB9D1C234D99788A23A", hash_generated_method = "1F4D3A154C5ECE9F6A3AA812BF168D34")
    
public int getScaledMinimumFlingVelocity() {
        return mMinimumFlingVelocity;
    }

    /**
     * @return Maximum velocity to initiate a fling, as measured in pixels per second.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.443 -0500", hash_original_method = "FB70B19A53E289FD25C6D1F0C8994CAD", hash_generated_method = "5D95E56454A0B57E4EA671E692E22083")
    
public int getScaledMaximumFlingVelocity() {
        return mMaximumFlingVelocity;
    }

    /**
     * The maximum drawing cache size expressed in bytes.
     *
     * @return the maximum size of View's drawing cache expressed in bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.449 -0500", hash_original_method = "C4F1814F49D0F58AC601C99A9F6FDB3F", hash_generated_method = "1E6AF0B128AE26797C68E9283466C723")
    
public int getScaledMaximumDrawingCacheSize() {
        return mMaximumDrawingCacheSize;
    }

    /**
     * @return The maximum distance a View should overscroll by when showing edge effects.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.451 -0500", hash_original_method = "36377B5ABE3B6C0802B86BCCF5BB67A1", hash_generated_method = "D03E6D6068982638E728538D607E7860")
    
public int getScaledOverscrollDistance() {
        return mOverscrollDistance;
    }

    /**
     * @return The maximum distance a View should overfling by when showing edge effects.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.453 -0500", hash_original_method = "1172E195811EBBA2C8358246D6F16FAF", hash_generated_method = "C49764C1C709AD1AAAFC819D624E1DA3")
    
public int getScaledOverflingDistance() {
        return mOverflingDistance;
    }

    /**
     * Report if the device has a permanent menu key available to the user.
     *
     * <p>As of Android 3.0, devices may not have a permanent menu key available.
     * Apps should use the action bar to present menu options to users.
     * However, there are some apps where the action bar is inappropriate
     * or undesirable. This method may be used to detect if a menu key is present.
     * If not, applications should provide another on-screen affordance to access
     * functionality.
     *
     * @return true if a permanent menu key is present, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.462 -0500", hash_original_method = "545A02CAD62F49742EF9C21476AFC78D", hash_generated_method = "6C956466F8F18FEFA6F27CCAA6695F8A")
    
public boolean hasPermanentMenuKey() {
        return sHasPermanentMenuKey;
    }

    /**
     * @hide
     * @return Whether or not marquee should use fading edges.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:55.464 -0500", hash_original_method = "B98AC48BC285AD77A873792B80842BAD", hash_generated_method = "A7A0096CE0399516CA71E4997951327E")
    
public boolean isFadingMarqueeEnabled() {
        return mFadingMarqueeEnabled;
    }
}

