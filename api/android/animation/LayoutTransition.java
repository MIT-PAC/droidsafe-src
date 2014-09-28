package android.animation;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class LayoutTransition {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.958 -0500", hash_original_field = "4C19ABB566B055A3E37A924670A808DA", hash_generated_field = "E63A0521AAA8C6DC4279BA44E098FD23")

    public static final int CHANGE_APPEARING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.960 -0500", hash_original_field = "AF12ADCFA393E8E86815AE4F98E3D85F", hash_generated_field = "A5E247EB4D6439D9A98E49F907931252")

    public static final int CHANGE_DISAPPEARING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.963 -0500", hash_original_field = "617D8D451E869F839F4CBB2D7759B943", hash_generated_field = "F22B7CC5AA7D7298C87C59E48B6986CB")

    public static final int APPEARING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.965 -0500", hash_original_field = "8DC6C4F5080BEB5EF1670D11AEEC341A", hash_generated_field = "2B4B660177B7589D2F5A7A330CB80759")

    public static final int DISAPPEARING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.976 -0500", hash_original_field = "18DE96D777456C523D7D3BB6A1CE5F81", hash_generated_field = "F23425A4D82261A0713821E518F1C782")

    private static ObjectAnimator defaultChangeIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.978 -0500", hash_original_field = "4A1E3DEEEB5BB2C11B59AD401D564741", hash_generated_field = "383D2DB6CC8BE4F70A8FC6AE24EF0892")

    private static ObjectAnimator defaultChangeOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.980 -0500", hash_original_field = "86FB6FBD261F12D7DB91CCD29E2C1D72", hash_generated_field = "9FE642298321DB1BFB3B90AC8C413400")

    private static ObjectAnimator defaultFadeIn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.982 -0500", hash_original_field = "F3BAD51C6DD8E4FA21C315D29C704485", hash_generated_field = "25D149E4F7D04D3FBA535A38951E6CA0")

    private static ObjectAnimator defaultFadeOut;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.984 -0500", hash_original_field = "D654CBBF7E1044E4E025795BDBB6A0A2", hash_generated_field = "B0EA698E636B3BDA7398DDB39E975802")

    private static long DEFAULT_DURATION = 300;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.967 -0500", hash_original_field = "207532A5D14CD4FA8F863FE1CCF3410B", hash_generated_field = "75E407E7333EB2D59F0ED20EAD88E34E")

    private Animator mDisappearingAnim = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.969 -0500", hash_original_field = "941DD54D732E4B02C6E3F02ADB6F7821", hash_generated_field = "F269A266B00229E5734E5B06B519CF4D")

    private Animator mAppearingAnim = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.971 -0500", hash_original_field = "AF86CCA2DE57A65ADCD1D91B87079796", hash_generated_field = "8569DC611F2B171274327A8DFA6BA137")

    private Animator mChangingAppearingAnim = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.973 -0500", hash_original_field = "741BA5E69D672EE008AD28409FF430FB", hash_generated_field = "295E17A6E98CD794E342CB0517EC6D87")

    private Animator mChangingDisappearingAnim = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.986 -0500", hash_original_field = "401DCA7348BFB495967F8B16D52F83DE", hash_generated_field = "A5577F39C2927B8AF67AB98D2B541767")

    private long mChangingAppearingDuration = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.988 -0500", hash_original_field = "489F97FD6457AAE7C534761F9CC86F23", hash_generated_field = "463C58461ED789E13A8EEFA59D868711")

    private long mChangingDisappearingDuration = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.990 -0500", hash_original_field = "45E72D08C240CEC0A63E06EBBA6786FB", hash_generated_field = "B1A031389441AED70DA8674A9CDD4213")

    private long mAppearingDuration = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.992 -0500", hash_original_field = "3140CFC0064E3A5DB10F873D0180C094", hash_generated_field = "83E0F49BD50CEA25C451F339C8D938A9")

    private long mDisappearingDuration = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.995 -0500", hash_original_field = "15AA9320328EF848673755BF1E9570A5", hash_generated_field = "6B89F75DB8D18324FDA519C3D6E9C3E1")

    private long mAppearingDelay = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.997 -0500", hash_original_field = "EB600507D5DC4B177A7595EBC05176D1", hash_generated_field = "EE2346FE7169B9AB19EA56A1B913BA60")

    private long mDisappearingDelay = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:35.999 -0500", hash_original_field = "F6B70F97A0BBBC294C0483CD74D07531", hash_generated_field = "B72CDDC89FC836C2633888FAF590185E")

    private long mChangingAppearingDelay = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.001 -0500", hash_original_field = "6870591B4CF9194694FB70D98FE7173F", hash_generated_field = "A8B24D136EA5EC6890818CC10AD17C05")

    private long mChangingDisappearingDelay = DEFAULT_DURATION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.003 -0500", hash_original_field = "C69E40C26ABC3CD2EE37272CE52B66A8", hash_generated_field = "715370DF92240EF0021A1CA25FFC6060")

    private long mChangingAppearingStagger = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.006 -0500", hash_original_field = "1C9A58E46D3413ECE51DD1780CDEA3FD", hash_generated_field = "95B0E8048A3A312DC3734A9E265C8176")

    private long mChangingDisappearingStagger = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.008 -0500", hash_original_field = "53D30455682B73128BC0B4EED743B79D", hash_generated_field = "3164C261F18E7FCC582837BE79E7E946")

    private TimeInterpolator mAppearingInterpolator = new AccelerateDecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.010 -0500", hash_original_field = "8F3AD636B706F6BCE0C73EE23C1B7106", hash_generated_field = "44480B19C903085EE0CD5A188A9C0404")

    private TimeInterpolator mDisappearingInterpolator = new AccelerateDecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.012 -0500", hash_original_field = "A2AE8B29E642071A7FAF0789443B0A30", hash_generated_field = "6AD343EAC627700E45ADD7F9BC2E498E")

    private TimeInterpolator mChangingAppearingInterpolator = new DecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.013 -0500", hash_original_field = "6AB96FAA09712C3951FA8522CF378B86", hash_generated_field = "002DBF51FA8D471B18C74A9B6E24123D")

    private TimeInterpolator mChangingDisappearingInterpolator = new DecelerateInterpolator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.016 -0500", hash_original_field = "E1330B8A29F59AE7629A4826050E9280", hash_generated_field = "E1CDEDB0BCFDEF2A4DF3C7DEFC5DB240")

    private final HashMap<View, Animator> pendingAnimations =
            new HashMap<View, Animator>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.018 -0500", hash_original_field = "AE55086C2A1AB873E001356F4B577B15", hash_generated_field = "8713B14FF07C44A33F515A732D4D8076")

    private final LinkedHashMap<View, Animator> currentChangingAnimations =
            new LinkedHashMap<View, Animator>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.020 -0500", hash_original_field = "40EB9361456D86D2BE4E109759C65FA3", hash_generated_field = "755F172D8CEDE1F2AF3C01713E92C67E")

    private final LinkedHashMap<View, Animator> currentAppearingAnimations =
            new LinkedHashMap<View, Animator>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.023 -0500", hash_original_field = "66F4D0544BDC0696F122543A3C831417", hash_generated_field = "81FCC6D3A7C9183D354AEB95CEBC1072")

    private final LinkedHashMap<View, Animator> currentDisappearingAnimations =
            new LinkedHashMap<View, Animator>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.025 -0500", hash_original_field = "DBFEBE51CE6DFDCC1EDE6A540F6971E5", hash_generated_field = "41A143D43A4B7FD3193B7EDB883D2AE9")

    private final HashMap<View, View.OnLayoutChangeListener> layoutChangeListenerMap =
            new HashMap<View, View.OnLayoutChangeListener>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.027 -0500", hash_original_field = "B59E57CCDC399C3D4E1E24DC89EEB19F", hash_generated_field = "62799693C20798E5E433F1B0AF6A3DC5")

    private long staggerDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.029 -0500", hash_original_field = "8CC3982710C523CBC6F66C910948FFD6", hash_generated_field = "F165C7B3902835B1E7EE6F9F45B1EBD6")

    private ArrayList<TransitionListener> mListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.031 -0500", hash_original_field = "C20731C8230F3770F75D2E852F726EE8", hash_generated_field = "E61C51FC893874C4BB912FEBE4441512")

    private boolean mAnimateParentHierarchy = true;

    /**
     * Constructs a LayoutTransition object. By default, the object will listen to layout
     * events on any ViewGroup that it is set on and will run default animations for each
     * type of layout event.
     */
    @DSComment("Animation class")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.034 -0500", hash_original_method = "52DB630B34835349C84181A9ADA45542", hash_generated_method = "D6FD60071C2464339504599926CC4579")
    
public LayoutTransition() {
        if (defaultChangeIn == null) {
            // "left" is just a placeholder; we'll put real properties/values in when needed
            PropertyValuesHolder pvhLeft = PropertyValuesHolder.ofInt("left", 0, 1);
            PropertyValuesHolder pvhTop = PropertyValuesHolder.ofInt("top", 0, 1);
            PropertyValuesHolder pvhRight = PropertyValuesHolder.ofInt("right", 0, 1);
            PropertyValuesHolder pvhBottom = PropertyValuesHolder.ofInt("bottom", 0, 1);
            PropertyValuesHolder pvhScrollX = PropertyValuesHolder.ofInt("scrollX", 0, 1);
            PropertyValuesHolder pvhScrollY = PropertyValuesHolder.ofInt("scrollY", 0, 1);
            defaultChangeIn = ObjectAnimator.ofPropertyValuesHolder((Object)null,
                    pvhLeft, pvhTop, pvhRight, pvhBottom, pvhScrollX, pvhScrollY);
            defaultChangeIn.setDuration(DEFAULT_DURATION);
            defaultChangeIn.setStartDelay(mChangingAppearingDelay);
            defaultChangeIn.setInterpolator(mChangingAppearingInterpolator);
            defaultChangeOut = defaultChangeIn.clone();
            defaultChangeOut.setStartDelay(mChangingDisappearingDelay);
            defaultChangeOut.setInterpolator(mChangingDisappearingInterpolator);

            defaultFadeIn = ObjectAnimator.ofFloat(null, "alpha", 0f, 1f);
            defaultFadeIn.setDuration(DEFAULT_DURATION);
            defaultFadeIn.setStartDelay(mAppearingDelay);
            defaultFadeIn.setInterpolator(mAppearingInterpolator);
            defaultFadeOut = ObjectAnimator.ofFloat(null, "alpha", 1f, 0f);
            defaultFadeOut.setDuration(DEFAULT_DURATION);
            defaultFadeOut.setStartDelay(mDisappearingDelay);
            defaultFadeOut.setInterpolator(mDisappearingInterpolator);
        }
        mChangingAppearingAnim = defaultChangeIn;
        mChangingDisappearingAnim = defaultChangeOut;
        mAppearingAnim = defaultFadeIn;
        mDisappearingAnim = defaultFadeOut;
    }

    /**
     * Sets the duration to be used by all animations of this transition object. If you want to
     * set the duration of just one of the animations in particular, use the
     * {@link #setDuration(int, long)} method.
     *
     * @param duration The length of time, in milliseconds, that the transition animations
     * should last.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.036 -0500", hash_original_method = "24394BA80BA94B39DCA5B438DC3EBDB1", hash_generated_method = "139CBBC6BDE68B4B096EC42CE56154C3")
    
public void setDuration(long duration) {
        mChangingAppearingDuration = duration;
        mChangingDisappearingDuration = duration;
        mAppearingDuration = duration;
        mDisappearingDuration = duration;
    }

    /**
     * Sets the start delay on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose start delay
     * is being set.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose start
     * delay is being set.
     * @param delay The length of time, in milliseconds, to delay before starting the animation.
     * @see Animator#setStartDelay(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.039 -0500", hash_original_method = "939FBD8B4C5590BFCAA9E14AEC15ED50", hash_generated_method = "0B2404D63C14F2FDF7CDF15FACE94E31")
    
public void setStartDelay(int transitionType, long delay) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                mChangingAppearingDelay = delay;
                break;
            case CHANGE_DISAPPEARING:
                mChangingDisappearingDelay = delay;
                break;
            case APPEARING:
                mAppearingDelay = delay;
                break;
            case DISAPPEARING:
                mDisappearingDelay = delay;
                break;
        }
    }

    /**
     * Gets the start delay on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose start delay
     * is returned.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose start
     * delay is returned.
     * @return long The start delay of the specified animation.
     * @see Animator#getStartDelay()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.042 -0500", hash_original_method = "3F88CD33B6864BEBC3B576EB6504FB35", hash_generated_method = "8508466D282632DE4A1219D3A48B67BA")
    
public long getStartDelay(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                return mChangingAppearingDuration;
            case CHANGE_DISAPPEARING:
                return mChangingDisappearingDuration;
            case APPEARING:
                return mAppearingDuration;
            case DISAPPEARING:
                return mDisappearingDuration;
        }
        // shouldn't reach here
        return 0;
    }

    /**
     * Sets the duration on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose duration
     * is being set.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is being set.
     * @param duration The length of time, in milliseconds, that the specified animation should run.
     * @see Animator#setDuration(long)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.044 -0500", hash_original_method = "2851CBF3AA331995F771441E9F6D0AAD", hash_generated_method = "AF0CF4855990622955D2C8F2DA3126B4")
    
public void setDuration(int transitionType, long duration) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                mChangingAppearingDuration = duration;
                break;
            case CHANGE_DISAPPEARING:
                mChangingDisappearingDuration = duration;
                break;
            case APPEARING:
                mAppearingDuration = duration;
                break;
            case DISAPPEARING:
                mDisappearingDuration = duration;
                break;
        }
    }

    /**
     * Gets the duration on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose duration
     * is returned.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is returned.
     * @return long The duration of the specified animation.
     * @see Animator#getDuration()
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.046 -0500", hash_original_method = "F259A86CD3BB3A6D515EAAF2335DC6DD", hash_generated_method = "BCEE60D56F7309AF485DEAE31950E1F5")
    
public long getDuration(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                return mChangingAppearingDuration;
            case CHANGE_DISAPPEARING:
                return mChangingDisappearingDuration;
            case APPEARING:
                return mAppearingDuration;
            case DISAPPEARING:
                return mDisappearingDuration;
        }
        // shouldn't reach here
        return 0;
    }

    /**
     * Sets the length of time to delay between starting each animation during one of the
     * CHANGE animations.
     *
     * @param transitionType A value of {@link #CHANGE_APPEARING} or @link #CHANGE_DISAPPEARING}.
     * @param duration The length of time, in milliseconds, to delay before launching the next
     * animation in the sequence.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.048 -0500", hash_original_method = "DB3710D74B2FBFD7C44693C4FBA40808", hash_generated_method = "111B1870A075A175A5AEEA478B5AB237")
    
public void setStagger(int transitionType, long duration) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                mChangingAppearingStagger = duration;
                break;
            case CHANGE_DISAPPEARING:
                mChangingDisappearingStagger = duration;
                break;
            // noop other cases
        }
    }

    /**
     * Tets the length of time to delay between starting each animation during one of the
     * CHANGE animations.
     *
     * @param transitionType A value of {@link #CHANGE_APPEARING} or @link #CHANGE_DISAPPEARING}.
     * @return long The length of time, in milliseconds, to delay before launching the next
     * animation in the sequence.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.051 -0500", hash_original_method = "70FCFF77D9C405B5FA9E6B4579BF3D8B", hash_generated_method = "6D42613D172E51766B0C3C2E27283690")
    
public long getStagger(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                return mChangingAppearingStagger;
            case CHANGE_DISAPPEARING:
                return mChangingDisappearingStagger;
        }
        // shouldn't reach here
        return 0;
    }

    /**
     * Sets the interpolator on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose interpolator
     * is being set.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is being set.
     * @param interpolator The interpolator that the specified animation should use.
     * @see Animator#setInterpolator(TimeInterpolator)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.053 -0500", hash_original_method = "2AD5234EB4F80ED9C0D5C1F0BD7735E5", hash_generated_method = "2269DBFCD5437FCA81DA4790A143D0DE")
    
public void setInterpolator(int transitionType, TimeInterpolator interpolator) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                mChangingAppearingInterpolator = interpolator;
                break;
            case CHANGE_DISAPPEARING:
                mChangingDisappearingInterpolator = interpolator;
                break;
            case APPEARING:
                mAppearingInterpolator = interpolator;
                break;
            case DISAPPEARING:
                mDisappearingInterpolator = interpolator;
                break;
        }
    }

    /**
     * Gets the interpolator on one of the animation objects used by this transition. The
     * <code>transitionType</code> parameter determines the animation whose interpolator
     * is returned.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is being set.
     * @return TimeInterpolator The interpolator that the specified animation uses.
     * @see Animator#setInterpolator(TimeInterpolator)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.055 -0500", hash_original_method = "11C2A17826922B819D4ABA31B32AF7FD", hash_generated_method = "6097A50CFE1AAE0F3F7BC0B8D1D65D63")
    
public TimeInterpolator getInterpolator(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                return mChangingAppearingInterpolator;
            case CHANGE_DISAPPEARING:
                return mChangingDisappearingInterpolator;
            case APPEARING:
                return mAppearingInterpolator;
            case DISAPPEARING:
                return mDisappearingInterpolator;
        }
        // shouldn't reach here
        return null;
    }

    /**
     * Sets the animation used during one of the transition types that may run. Any
     * Animator object can be used, but to be most useful in the context of layout
     * transitions, the animation should either be a ObjectAnimator or a AnimatorSet
     * of animations including PropertyAnimators. Also, these ObjectAnimator objects
     * should be able to get and set values on their target objects automatically. For
     * example, a ObjectAnimator that animates the property "left" is able to set and get the
     * <code>left</code> property from the View objects being animated by the layout
     * transition. The transition works by setting target objects and properties
     * dynamically, according to the pre- and post-layoout values of those objects, so
     * having animations that can handle those properties appropriately will work best
     * for custom animation. The dynamic setting of values is only the case for the
     * CHANGE animations; the APPEARING and DISAPPEARING animations are simply run with
     * the values they have.
     *
     * <p>It is also worth noting that any and all animations (and their underlying
     * PropertyValuesHolder objects) will have their start and end values set according
     * to the pre- and post-layout values. So, for example, a custom animation on "alpha"
     * as the CHANGE_APPEARING animation will inherit the real value of alpha on the target
     * object (presumably 1) as its starting and ending value when the animation begins.
     * Animations which need to use values at the beginning and end that may not match the
     * values queried when the transition begins may need to use a different mechanism
     * than a standard ObjectAnimator object.</p>
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is being set.
     * @param animator The animation being assigned. A value of <code>null</code> means that no
     * animation will be run for the specified transitionType.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.057 -0500", hash_original_method = "1CE02B172FBE4A7CE10D1F87669E47EA", hash_generated_method = "4C4074951E5B1E4F9398D7CFF83A1884")
    
public void setAnimator(int transitionType, Animator animator) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                mChangingAppearingAnim = animator;
                break;
            case CHANGE_DISAPPEARING:
                mChangingDisappearingAnim = animator;
                break;
            case APPEARING:
                mAppearingAnim = animator;
                break;
            case DISAPPEARING:
                mDisappearingAnim = animator;
                break;
        }
    }

    /**
     * Gets the animation used during one of the transition types that may run.
     *
     * @param transitionType one of {@link #CHANGE_APPEARING}, {@link #CHANGE_DISAPPEARING},
     * {@link #APPEARING}, or {@link #DISAPPEARING}, which determines the animation whose
     * duration is being set.
     * @return Animator The animation being used for the given transition type.
     * @see #setAnimator(int, Animator)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.060 -0500", hash_original_method = "FF737FAA09DE0C7945DD1E6E302C4C89", hash_generated_method = "C51A0AF56F6A393099373922DBD79008")
    
public Animator getAnimator(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
                return mChangingAppearingAnim;
            case CHANGE_DISAPPEARING:
                return mChangingDisappearingAnim;
            case APPEARING:
                return mAppearingAnim;
            case DISAPPEARING:
                return mDisappearingAnim;
        }
        // shouldn't reach here
        return null;
    }

    /**
     * This function sets up animations on all of the views that change during layout.
     * For every child in the parent, we create a change animation of the appropriate
     * type (appearing or disappearing) and ask it to populate its start values from its
     * target view. We add layout listeners to all child views and listen for changes. For
     * those views that change, we populate the end values for those animations and start them.
     * Animations are not run on unchanging views.
     *
     * @param parent The container which is undergoing an appearing or disappearing change.
     * @param newView The view being added to or removed from the parent.
     * @param changeReason A value of APPEARING or DISAPPEARING, indicating whether the
     * transition is occuring because an item is being added to or removed from the parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.066 -0500", hash_original_method = "388160589FFEE2126FAAE5CBAFC89998", hash_generated_method = "620CC03CF597F8CBF6D5987D96E996A8")
    
private void runChangeTransition(final ViewGroup parent, View newView, final int changeReason) {

        Animator baseAnimator = (changeReason == APPEARING) ?
                mChangingAppearingAnim : mChangingDisappearingAnim;
        // If the animation is null, there's nothing to do
        if (baseAnimator == null) {
            return;
        }

        // reset the inter-animation delay, in case we use it later
        staggerDelay = 0;
        final long duration = (changeReason == APPEARING) ?
                mChangingAppearingDuration : mChangingDisappearingDuration;

        final ViewTreeObserver observer = parent.getViewTreeObserver(); // used for later cleanup
        if (!observer.isAlive()) {
            // If the observer's not in a good state, skip the transition
            return;
        }
        int numChildren = parent.getChildCount();

        for (int i = 0; i < numChildren; ++i) {
            final View child = parent.getChildAt(i);

            // only animate the views not being added or removed
            if (child != newView) {
                setupChangeAnimation(parent, changeReason, baseAnimator, duration, child);
            }
        }
        if (mAnimateParentHierarchy) {
            Animator parentAnimator = (changeReason == APPEARING) ?
                    defaultChangeIn : defaultChangeOut;
            ViewGroup tempParent = parent;
            while (tempParent != null) {
                ViewParent parentParent = tempParent.getParent();
                if (parentParent instanceof ViewGroup) {
                    setupChangeAnimation((ViewGroup)parentParent, changeReason, parentAnimator,
                            duration, tempParent);
                    tempParent = (ViewGroup) parentParent;
                } else {
                    tempParent = null;
                }

            }
        }

        // This is the cleanup step. When we get this rendering event, we know that all of
        // the appropriate animations have been set up and run. Now we can clear out the
        // layout listeners.
        observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                parent.getViewTreeObserver().removeOnPreDrawListener(this);
                int count = layoutChangeListenerMap.size();
                if (count > 0) {
                    Collection<View> views = layoutChangeListenerMap.keySet();
                    for (View view : views) {
                        View.OnLayoutChangeListener listener = layoutChangeListenerMap.get(view);
                        view.removeOnLayoutChangeListener(listener);
                    }
                }
                layoutChangeListenerMap.clear();
                return true;
            }
        });
    }

    /**
     * This flag controls whether CHANGE_APPEARING or CHANGE_DISAPPEARING animations will
     * cause the default changing animation to be run on the parent hierarchy as well. This allows
     * containers of transitioning views to also transition, which may be necessary in situations
     * where the containers bounds change between the before/after states and may clip their
     * children during the transition animations. For example, layouts with wrap_content will
     * adjust their bounds according to the dimensions of their children.
     *
     * <p>The default changing transitions animate the bounds and scroll positions of the
     * target views. These are the animations that will run on the parent hierarchy, not
     * the custom animations that happen to be set on the transition. This allows custom
     * behavior for the children of the transitioning container, but uses standard behavior
     * of resizing/rescrolling on any changing parents.
     *
     * @param animateParentHierarchy A boolean value indicating whether the parents of
     * transitioning views should also be animated during the transition. Default value is true.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.068 -0500", hash_original_method = "5ECFD2D430BE870F40C042D01FD8A2D6", hash_generated_method = "83C54A14C0718ED0F9CD4ADC14FF78AB")
    
public void setAnimateParentHierarchy(boolean animateParentHierarchy) {
        mAnimateParentHierarchy = animateParentHierarchy;
    }

    /**
     * Utility function called by runChangingTransition for both the children and the parent
     * hierarchy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.089 -0500", hash_original_method = "108854515942B7EF6A63499B84E31466", hash_generated_method = "08E07596C8E954E87ED92336E5211220")
    
private void setupChangeAnimation(final ViewGroup parent, final int changeReason,
            Animator baseAnimator, final long duration, final View child) {

        // If we already have a listener for this child, then we've already set up the
        // changing animation we need. Multiple calls for a child may occur when several
        // add/remove operations are run at once on a container; each one will trigger
        // changes for the existing children in the container.
        if (layoutChangeListenerMap.get(child) != null) {
            return;
        }

        // Make a copy of the appropriate animation
        final Animator anim = baseAnimator.clone();

        // Set the target object for the animation
        anim.setTarget(child);

        // A ObjectAnimator (or AnimatorSet of them) can extract start values from
        // its target object
        anim.setupStartValues();

        // If there's an animation running on this view already, cancel it
        Animator currentAnimation = pendingAnimations.get(child);
        if (currentAnimation != null) {
            currentAnimation.cancel();
            pendingAnimations.remove(child);
        }
        // Cache the animation in case we need to cancel it later
        pendingAnimations.put(child, anim);

        // For the animations which don't get started, we have to have a means of
        // removing them from the cache, lest we leak them and their target objects.
        // We run an animator for the default duration+100 (an arbitrary time, but one
        // which should far surpass the delay between setting them up here and
        // handling layout events which start them.
        ValueAnimator pendingAnimRemover = ValueAnimator.ofFloat(0f, 1f).
                setDuration(duration + 100);
        pendingAnimRemover.addListener(new AnimatorListenerAdapter() {
            @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
            public void onAnimationEnd(Animator animation) {
                pendingAnimations.remove(child);
            }
        });
        pendingAnimRemover.start();

        // Add a listener to track layout changes on this view. If we don't get a callback,
        // then there's nothing to animate.
        final View.OnLayoutChangeListener listener = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View v, int left, int top, int right, int bottom,
                    int oldLeft, int oldTop, int oldRight, int oldBottom) {

                // Tell the animation to extract end values from the changed object
                anim.setupEndValues();
                if (anim instanceof ValueAnimator) {
                    boolean valuesDiffer = false;
                    ValueAnimator valueAnim = (ValueAnimator)anim;
                    PropertyValuesHolder[] oldValues = valueAnim.getValues();
                    for (int i = 0; i < oldValues.length; ++i) {
                        PropertyValuesHolder pvh = oldValues[i];
                        KeyframeSet keyframeSet = pvh.mKeyframeSet;
                        if (keyframeSet.mFirstKeyframe == null ||
                                keyframeSet.mLastKeyframe == null ||
                                !keyframeSet.mFirstKeyframe.getValue().equals(
                                keyframeSet.mLastKeyframe.getValue())) {
                            valuesDiffer = true;
                        }
                    }
                    if (!valuesDiffer) {
                        return;
                    }
                }

                long startDelay;
                if (changeReason == APPEARING) {
                    startDelay = mChangingAppearingDelay + staggerDelay;
                    staggerDelay += mChangingAppearingStagger;
                } else {
                    startDelay = mChangingDisappearingDelay + staggerDelay;
                    staggerDelay += mChangingDisappearingStagger;
                }
                anim.setStartDelay(startDelay);
                anim.setDuration(duration);

                Animator prevAnimation = currentChangingAnimations.get(child);
                if (prevAnimation != null) {
                    prevAnimation.cancel();
                }
                Animator pendingAnimation = pendingAnimations.get(child);
                if (pendingAnimation != null) {
                    pendingAnimations.remove(child);
                }
                // Cache the animation in case we need to cancel it later
                currentChangingAnimations.put(child, anim);

                parent.requestTransitionStart(LayoutTransition.this);

                // this only removes listeners whose views changed - must clear the
                // other listeners later
                child.removeOnLayoutChangeListener(this);
                layoutChangeListenerMap.remove(child);
            }
        };
        // Remove the animation from the cache when it ends
        anim.addListener(new AnimatorListenerAdapter() {

            @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
            public void onAnimationStart(Animator animator) {
                if (mListeners != null) {
                    for (TransitionListener listener : mListeners) {
                        listener.startTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    }
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                child.removeOnLayoutChangeListener(listener);
                layoutChangeListenerMap.remove(child);
            }

            @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
            public void onAnimationEnd(Animator animator) {
                currentChangingAnimations.remove(child);
                if (mListeners != null) {
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child,
                                changeReason == APPEARING ?
                                        CHANGE_APPEARING : CHANGE_DISAPPEARING);
                    }
                }
            }
        });

        child.addOnLayoutChangeListener(listener);
        // cache the listener for later removal
        layoutChangeListenerMap.put(child, listener);
    }

    /**
     * Starts the animations set up for a CHANGING transition. We separate the setup of these
     * animations from actually starting them, to avoid side-effects that starting the animations
     * may have on the properties of the affected objects. After setup, we tell the affected parent
     * that this transition should be started. The parent informs its ViewAncestor, which then
     * starts the transition after the current layout/measurement phase, just prior to drawing
     * the view hierarchy.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.092 -0500", hash_original_method = "7222BE89A56886A0CF62DC8766C00475", hash_generated_method = "FAC29BD5275371BFCD9C73BB60490696")
    
public void startChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy =
                (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        for (Animator anim : currentAnimCopy.values()) {
            if (anim instanceof ObjectAnimator) {
                ((ObjectAnimator) anim).setCurrentPlayTime(0);
            }
            anim.start();
        }
    }

    /**
     * Ends the animations that are set up for a CHANGING transition. This is a variant of
     * startChangingAnimations() which is called when the window the transition is playing in
     * is not visible. We need to make sure the animations put their targets in their end states
     * and that the transition finishes to remove any mid-process state (such as isRunning()).
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.094 -0500", hash_original_method = "7BA742550F1E1298AB8FE77F45C4383D", hash_generated_method = "DDAB7213622B60870B3DDF4B8F9529AA")
    
public void endChangingAnimations() {
        LinkedHashMap<View, Animator> currentAnimCopy =
                (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
        for (Animator anim : currentAnimCopy.values()) {
            anim.start();
            anim.end();
        }
    }

    /**
     * Returns true if animations are running which animate layout-related properties. This
     * essentially means that either CHANGE_APPEARING or CHANGE_DISAPPEARING animations
     * are running, since these animations operate on layout-related properties.
     *
     * @return true if CHANGE_APPEARING or CHANGE_DISAPPEARING animations are currently
     * running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.096 -0500", hash_original_method = "8C9364165F532DD8BD43415668542398", hash_generated_method = "D88BD879963879B9E1B8DEA5D63DE73C")
    
public boolean isChangingLayout() {
        return toTaintBoolean(currentChangingAnimations.size()); 
    }

    /**
     * Returns true if any of the animations in this transition are currently running.
     *
     * @return true if any animations in the transition are running.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.098 -0500", hash_original_method = "7F683046BB72ECC23A172B1D3B81B266", hash_generated_method = "56869A7660E1C3AD74C0D688406DECD5")
    
public boolean isRunning() {
        return toTaintBoolean(currentChangingAnimations.size() +
                              currentAppearingAnimations.size() + 
                              currentDisappearingAnimations.size()); 
    }

    /**
     * Cancels the currently running transition. Note that we cancel() the changing animations
     * but end() the visibility animations. This is because this method is currently called
     * in the context of starting a new transition, so we want to move things from their mid-
     * transition positions, but we want them to have their end-transition visibility.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.101 -0500", hash_original_method = "2E46A59670A61A0AF64FD97BDAF7B728", hash_generated_method = "828BE72ADF06D717936B8246B18C9535")
    
public void cancel() {
        if (currentChangingAnimations.size() > 0) {
            LinkedHashMap<View, Animator> currentAnimCopy =
                    (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
            for (Animator anim : currentAnimCopy.values()) {
                anim.cancel();
            }
            currentChangingAnimations.clear();
        }
        if (currentAppearingAnimations.size() > 0) {
            LinkedHashMap<View, Animator> currentAnimCopy =
                    (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
            for (Animator anim : currentAnimCopy.values()) {
                anim.end();
            }
            currentAppearingAnimations.clear();
        }
        if (currentDisappearingAnimations.size() > 0) {
            LinkedHashMap<View, Animator> currentAnimCopy =
                    (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
            for (Animator anim : currentAnimCopy.values()) {
                anim.end();
            }
            currentDisappearingAnimations.clear();
        }
    }

    /**
     * Cancels the specified type of transition. Note that we cancel() the changing animations
     * but end() the visibility animations. This is because this method is currently called
     * in the context of starting a new transition, so we want to move things from their mid-
     * transition positions, but we want them to have their end-transition visibility.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.103 -0500", hash_original_method = "19B870791205108BA3B602A2E8CB5138", hash_generated_method = "ED4F98EBA2B28BCF9848A8F63679AE29")
    
public void cancel(int transitionType) {
        switch (transitionType) {
            case CHANGE_APPEARING:
            case CHANGE_DISAPPEARING:
                if (currentChangingAnimations.size() > 0) {
                    LinkedHashMap<View, Animator> currentAnimCopy =
                            (LinkedHashMap<View, Animator>) currentChangingAnimations.clone();
                    for (Animator anim : currentAnimCopy.values()) {
                        anim.cancel();
                    }
                    currentChangingAnimations.clear();
                }
                break;
            case APPEARING:
                if (currentAppearingAnimations.size() > 0) {
                    LinkedHashMap<View, Animator> currentAnimCopy =
                            (LinkedHashMap<View, Animator>) currentAppearingAnimations.clone();
                    for (Animator anim : currentAnimCopy.values()) {
                        anim.end();
                    }
                    currentAppearingAnimations.clear();
                }
                break;
            case DISAPPEARING:
                if (currentDisappearingAnimations.size() > 0) {
                    LinkedHashMap<View, Animator> currentAnimCopy =
                            (LinkedHashMap<View, Animator>) currentDisappearingAnimations.clone();
                    for (Animator anim : currentAnimCopy.values()) {
                        anim.end();
                    }
                    currentDisappearingAnimations.clear();
                }
                break;
        }
    }
    
    public interface TransitionListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType);
    }

    /**
     * This method runs the animation that makes an added item appear.
     *
     * @param parent The ViewGroup to which the View is being added.
     * @param child The View being added to the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.109 -0500", hash_original_method = "071036D6A0EA050ACF09A35752DC1D52", hash_generated_method = "AD15DD92D58E9CC695BBD917D3BF7904")
    
private void runAppearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation = currentDisappearingAnimations.get(child);
        if (currentAnimation != null) {
            currentAnimation.cancel();
        }
        if (mAppearingAnim == null) {
            if (mListeners != null) {
                for (TransitionListener listener : mListeners) {
                    listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                }
            }
            return;
        }
        Animator anim = mAppearingAnim.clone();
        anim.setTarget(child);
        anim.setStartDelay(mAppearingDelay);
        anim.setDuration(mAppearingDuration);
        if (anim instanceof ObjectAnimator) {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        }
        if (mListeners != null) {
            anim.addListener(new AnimatorListenerAdapter() {
                @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
                public void onAnimationEnd(Animator anim) {
                    currentAppearingAnimations.remove(child);
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child, APPEARING);
                    }
                }
            });
        }
        currentAppearingAnimations.put(child, anim);
        anim.start();
    }

    /**
     * This method runs the animation that makes a removed item disappear.
     *
     * @param parent The ViewGroup from which the View is being removed.
     * @param child The View being removed from the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.115 -0500", hash_original_method = "202CDBACC5F0926CC1D7E1540267464D", hash_generated_method = "CDF12FD46F3BA8C8CF298C4F939667E9")
    
private void runDisappearingTransition(final ViewGroup parent, final View child) {
        Animator currentAnimation = currentAppearingAnimations.get(child);
        if (currentAnimation != null) {
            currentAnimation.cancel();
        }
        if (mDisappearingAnim == null) {
            if (mListeners != null) {
                for (TransitionListener listener : mListeners) {
                    listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                }
            }
            return;
        }
        Animator anim = mDisappearingAnim.clone();
        anim.setStartDelay(mDisappearingDelay);
        anim.setDuration(mDisappearingDuration);
        anim.setTarget(child);
        if (mListeners != null) {
            anim.addListener(new AnimatorListenerAdapter() {
                @DSSafe(DSCat.ANDROID_ANIMATION)
        @Override
                public void onAnimationEnd(Animator anim) {
                    currentDisappearingAnimations.remove(child);
                    for (TransitionListener listener : mListeners) {
                        listener.endTransition(LayoutTransition.this, parent, child, DISAPPEARING);
                    }
                }
            });
        }
        if (anim instanceof ObjectAnimator) {
            ((ObjectAnimator) anim).setCurrentPlayTime(0);
        }
        currentDisappearingAnimations.put(child, anim);
        anim.start();
    }

    /**
     * This method is called by ViewGroup when a child view is about to be added to the
     * container. This callback starts the process of a transition; we grab the starting
     * values, listen for changes to all of the children of the container, and start appropriate
     * animations.
     *
     * @param parent The ViewGroup to which the View is being added.
     * @param child The View being added to the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.118 -0500", hash_original_method = "05533C05F33D5C5B655A5BABA4CC6F65", hash_generated_method = "97F066157AF6A5B4BB9E2F793964FAF4")
    
public void addChild(ViewGroup parent, View child) {
        // Want disappearing animations to finish up before proceeding
        cancel(DISAPPEARING);
        // Also, cancel changing animations so that we start fresh ones from current locations
        cancel(CHANGE_APPEARING);
        if (mListeners != null) {
            for (TransitionListener listener : mListeners) {
                listener.startTransition(this, parent, child, APPEARING);
            }
        }
        runChangeTransition(parent, child, APPEARING);
        runAppearingTransition(parent, child);
    }

    /**
     * This method is called by ViewGroup when a child view is about to be added to the
     * container. This callback starts the process of a transition; we grab the starting
     * values, listen for changes to all of the children of the container, and start appropriate
     * animations.
     *
     * @param parent The ViewGroup to which the View is being added.
     * @param child The View being added to the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.120 -0500", hash_original_method = "5867E97EE566113A4AD2D7416A9B4CB1", hash_generated_method = "D390D692C34DE48F67E907E2804A3BE8")
    
public void showChild(ViewGroup parent, View child) {
        addChild(parent, child);
    }

    /**
     * This method is called by ViewGroup when a child view is about to be removed from the
     * container. This callback starts the process of a transition; we grab the starting
     * values, listen for changes to all of the children of the container, and start appropriate
     * animations.
     *
     * @param parent The ViewGroup from which the View is being removed.
     * @param child The View being removed from the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.122 -0500", hash_original_method = "E23F457F66AC508EC3728A00193F4832", hash_generated_method = "B653AD6F86B79032AB814C58C8307159")
    
public void removeChild(ViewGroup parent, View child) {
        // Want appearing animations to finish up before proceeding
        cancel(APPEARING);
        // Also, cancel changing animations so that we start fresh ones from current locations
        cancel(CHANGE_DISAPPEARING);
        if (mListeners != null) {
            for (TransitionListener listener : mListeners) {
                listener.startTransition(this, parent, child, DISAPPEARING);
            }
        }
        runChangeTransition(parent, child, DISAPPEARING);
        runDisappearingTransition(parent, child);
    }

    /**
     * This method is called by ViewGroup when a child view is about to be removed from the
     * container. This callback starts the process of a transition; we grab the starting
     * values, listen for changes to all of the children of the container, and start appropriate
     * animations.
     *
     * @param parent The ViewGroup from which the View is being removed.
     * @param child The View being removed from the ViewGroup.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.125 -0500", hash_original_method = "59CF94EEC1336BEEB8FFF5467E6ED5F9", hash_generated_method = "63BFB9BB3D76E970A92ECED557CACBB5")
    
public void hideChild(ViewGroup parent, View child) {
        removeChild(parent, child);
    }

    /**
     * Add a listener that will be called when the bounds of the view change due to
     * layout processing.
     *
     * @param listener The listener that will be called when layout bounds change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.127 -0500", hash_original_method = "167EED27AB5F7469F2545513C43EBDC4", hash_generated_method = "22C1304A7D61036CDD4AFDF25D7CF527")
    
public void addTransitionListener(TransitionListener listener) {
        if (mListeners == null) {
            mListeners = new ArrayList<TransitionListener>();
        }
        mListeners.add(listener);
    }

    /**
     * Remove a listener for layout changes.
     *
     * @param listener The listener for layout bounds change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.129 -0500", hash_original_method = "CD0DE6419C69039B8FDEE8C2D5BC497D", hash_generated_method = "248C1C952D163FCE25996597B9DE3951")
    
public void removeTransitionListener(TransitionListener listener) {
        if (mListeners == null) {
            return;
        }
        mListeners.remove(listener);
    }

    /**
     * Gets the current list of listeners for layout changes.
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:36.132 -0500", hash_original_method = "F0DD3EC0CE94CE6304D7C3009A3E39A6", hash_generated_method = "881B9E5CA5AA55FE67201917DF3AE25A")
    
public List<TransitionListener> getTransitionListeners() {
        return mListeners;
    }
}

