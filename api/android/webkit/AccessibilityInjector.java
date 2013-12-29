package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Stack;

import android.provider.Settings;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebViewCore.EventHub;





class AccessibilityInjector {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.868 -0500", hash_original_field = "ACB89AAF1263E8A9795CBB4955DE9A0D", hash_generated_field = "355BE79B3786523315A38F99C8EFD0EF")

    private static final String LOG_TAG = "AccessibilityInjector";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.869 -0500", hash_original_field = "9C97D618612CFF386E7AF19655372855", hash_generated_field = "0DA17BC1AEF6DBF011A4A750F5A71D57")


    private static final boolean DEBUG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.870 -0500", hash_original_field = "56A03426DE70624A8891C135C791DBBC", hash_generated_field = "12B31C0D92351F48989DB7D421B336D5")


    private static final int ACTION_SET_CURRENT_AXIS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.870 -0500", hash_original_field = "49A6DB3A3DCCBA3C0FC1476BBB715506", hash_generated_field = "58291536D1F80FD93588C2E4178BDAD6")

    private static final int ACTION_TRAVERSE_CURRENT_AXIS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.871 -0500", hash_original_field = "EB9696F0E7BFE80B2B9708B9C90B493C", hash_generated_field = "BBB0B8A34D0FE9233A286CF9AF35FBDF")

    private static final int ACTION_TRAVERSE_GIVEN_AXIS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.872 -0500", hash_original_field = "6E074BB111789B91D07F4570AF2469BE", hash_generated_field = "9DC1A870966F6613A76EDD9AF5A52F83")

    private static final int ACTION_PERFORM_AXIS_TRANSITION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.873 -0500", hash_original_field = "DC595DB654F514814E1AE9AA60E5BAF6", hash_generated_field = "795FF9003847153FEDDC6135D24C99D1")

    private static final int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.874 -0500", hash_original_field = "ECECC5BFA46FF57F472BF8DF0648875A", hash_generated_field = "2A75193CE584F6498192A47349148458")

    private static final int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.875 -0500", hash_original_field = "CA8C5E839923CC2BB6341C82D5D4938C", hash_generated_field = "4C5C7E9C43BB16E424C598EA8932A1C4")

    private static ArrayList<AccessibilityWebContentKeyBinding> sBindings =
        new ArrayList<AccessibilityWebContentKeyBinding>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.876 -0500", hash_original_field = "E044D69EE05B24F4B93E3A3B208F5343", hash_generated_field = "99346B50377E115231263981E00655CA")

    private  WebView mWebView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.877 -0500", hash_original_field = "B430A06153AF4C02B94D687BF212EA90", hash_generated_field = "3E57A1C4DB07EE64FCEAD72CC440E45E")

    private final Stack<AccessibilityEvent> mScheduledEventStack = new Stack<AccessibilityEvent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.878 -0500", hash_original_field = "84FC2C5913D6861EA052018925079A5E", hash_generated_field = "4330EB8AA5A2FE255DBD22415D04ED16")

    private int mCurrentAxis = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:01.127 -0500", hash_original_field = "EB715AD3A256DBE3990BA7ACE73D6261", hash_generated_field = "A930633B2A9AAAF914D3D7A7480791B6")


    // we need to consume the up if we have handled the last down
    private boolean mLastDownEventHandled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.879 -0500", hash_original_field = "E87655336A9AF866922667147DF6332C", hash_generated_field = "8A7EF6B120836C189817F81132C96CE4")

    private boolean mIsLastSelectionStringNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.880 -0500", hash_original_field = "F552E35E5E42D4C9C7235D3663258934", hash_generated_field = "20DA94CEADB2B1E6F5C2261C53B2ECE7")

    private int mLastDirection;

    /**
     * Creates a new injector associated with a given {@link WebView}.
     *
     * @param webView The associated WebView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.881 -0500", hash_original_method = "EF4641FD66F12CE398EFC703194D8E58", hash_generated_method = "ECA7A8ADF8DCF430DD17A60E305CD34B")
    public AccessibilityInjector(WebView webView) {
        mWebView = webView;
        ensureWebContentKeyBindings();
    }

    /**
     * Processes a key down <code>event</code>.
     *
     * @return True if the event was processed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.883 -0500", hash_original_method = "EB800BB0EE5BEF185F11F0CA48ECBE70", hash_generated_method = "9F673CA79464E8D7D448ED1AD5F9D034")
    public boolean onKeyEvent(KeyEvent event) {
        // We do not handle ENTER in any circumstances.
        if (isEnterActionKey(event.getKeyCode())) {
            return false;
        }

        if (event.getAction() == KeyEvent.ACTION_UP) {
            return mLastDownEventHandled;
        }

        mLastDownEventHandled = false;

        AccessibilityWebContentKeyBinding binding = null;
        for (AccessibilityWebContentKeyBinding candidate : sBindings) {
            if (event.getKeyCode() == candidate.getKeyCode()
                    && event.hasModifiers(candidate.getModifiers())) {
                binding = candidate;
                break;
            }
        }

        if (binding == null) {
            return false;
        }

        for (int i = 0, count = binding.getActionCount(); i < count; i++) {
            int actionCode = binding.getActionCode(i);
            String contentDescription = Integer.toHexString(binding.getAction(i));
            switch (actionCode) {
                case ACTION_SET_CURRENT_AXIS:
                    int axis = binding.getFirstArgument(i);
                    boolean sendEvent = (binding.getSecondArgument(i) == 1);
                    setCurrentAxis(axis, sendEvent, contentDescription);
                    mLastDownEventHandled = true;
                    break;
                case ACTION_TRAVERSE_CURRENT_AXIS:
                    int direction = binding.getFirstArgument(i);
                    // on second null selection string in same direction - WebView handles the event
                    if (direction == mLastDirection && mIsLastSelectionStringNull) {
                        mIsLastSelectionStringNull = false;
                        return false;
                    }
                    mLastDirection = direction;
                    sendEvent = (binding.getSecondArgument(i) == 1);
                    mLastDownEventHandled = traverseCurrentAxis(direction, sendEvent,
                            contentDescription);
                    break;
                case ACTION_TRAVERSE_GIVEN_AXIS:
                    direction = binding.getFirstArgument(i);
                    // on second null selection string in same direction => WebView handle the event
                    if (direction == mLastDirection && mIsLastSelectionStringNull) {
                        mIsLastSelectionStringNull = false;
                        return false;
                    }
                    mLastDirection = direction;
                    axis =  binding.getSecondArgument(i);
                    sendEvent = (binding.getThirdArgument(i) == 1);
                    traverseGivenAxis(direction, axis, sendEvent, contentDescription);
                    mLastDownEventHandled = true;
                    break;
                case ACTION_PERFORM_AXIS_TRANSITION:
                    int fromAxis = binding.getFirstArgument(i);
                    int toAxis = binding.getSecondArgument(i);
                    sendEvent = (binding.getThirdArgument(i) == 1);
                    prefromAxisTransition(fromAxis, toAxis, sendEvent, contentDescription);
                    mLastDownEventHandled = true;
                    break;
                case ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS:
                    // This is a special case since we treat the default WebView navigation
                    // behavior as one of the possible navigation axis the user can use.
                    // If we are not on the default WebView navigation axis this is NOP.
                    if (mCurrentAxis == NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR) {
                        // While WebVew handles navigation we do not get null selection
                        // strings so do not check for that here as the cases above.
                        mLastDirection = binding.getFirstArgument(i);
                        sendEvent = (binding.getSecondArgument(i) == 1);
                        traverseGivenAxis(mLastDirection, NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR,
                            sendEvent, contentDescription);
                        mLastDownEventHandled = false;
                    } else {
                        mLastDownEventHandled = true;
                    }
                    break;
                default:
                    Log.w(LOG_TAG, "Unknown action code: " + actionCode);
            }
        }

        return mLastDownEventHandled;
    }

    
    private static final class AccessibilityWebContentKeyBinding {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.892 -0500", hash_original_field = "41D4F6636ABD75FA51662DE9262FB0E2", hash_generated_field = "F8D2FA352C0BA0C64C99BC74D59C6DE5")


        private static final int MODIFIERS_OFFSET = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.893 -0500", hash_original_field = "7056BD87623FB8ADCEE799472F810C7E", hash_generated_field = "F15D255C8A53F382E8E42786FABAD969")

        private static final long MODIFIERS_MASK = 0xFFFFFFF00000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.894 -0500", hash_original_field = "F1D3E04A6F4A9CE347535E9E4DA2586F", hash_generated_field = "20B9B8442924C25F1223DFD4562CD64E")


        private static final int KEY_CODE_OFFSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.895 -0500", hash_original_field = "1E906E29D4C89ED504FEE37F0001DBB2", hash_generated_field = "B2CEF4BD57CC748D47EB33527D82B47A")

        private static final long KEY_CODE_MASK = 0x00000000FFFFFFFFL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.896 -0500", hash_original_field = "5B4CB7BA768A1DEC937DE0A1D5755E4B", hash_generated_field = "8F5435B4DF6B7CFAD8E1946F8438D2B5")


        private static final int ACTION_OFFSET = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.897 -0500", hash_original_field = "4CCBF76D1138EDBD003691AC4CCD7451", hash_generated_field = "32DF52DD728ADC6D34953391F47C41D6")

        private static final int ACTION_MASK = 0xFF000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.897 -0500", hash_original_field = "6446895D134867947C9F6DB054D34058", hash_generated_field = "B9AF7AE6175C7800E8579A20EC2D26D0")


        private static final int FIRST_ARGUMENT_OFFSET = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.898 -0500", hash_original_field = "C803E5ABD1C04F57FDAC85C9B0796E20", hash_generated_field = "E574C2A0E6EC1F21410525FD57E75FF1")

        private static final int FIRST_ARGUMENT_MASK = 0x00FF0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.899 -0500", hash_original_field = "FA120277FA8E34FE342E8D61ABEC6C0E", hash_generated_field = "B17B97D0AC9CE57566EDCD781528A4A2")


        private static final int SECOND_ARGUMENT_OFFSET = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.900 -0500", hash_original_field = "A5465F69553CEC1DC69E0A816DB8E0CC", hash_generated_field = "817F021C237E947C0BC3253F16A7EA47")

        private static final int SECOND_ARGUMENT_MASK = 0x0000FF00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.901 -0500", hash_original_field = "FE693384BC24063D6A7D0ACC69CAE62D", hash_generated_field = "63F3F631667C122A4E9AB568B7FA393E")


        private static final int THIRD_ARGUMENT_OFFSET = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.902 -0500", hash_original_field = "F123833A02A5F6C7D7FDF97461DCEC50", hash_generated_field = "532061882B38166B9A4AFA798321EC67")

        private static final int THIRD_ARGUMENT_MASK = 0x000000FF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.903 -0500", hash_original_field = "C7EF2968598FE2B648085E2C95612262", hash_generated_field = "ED9AFF5D0BE3F3908705CAFA2BF1844E")


        private  long mKeyCodeAndModifiers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.904 -0500", hash_original_field = "B3C4F9C18E062F366016C41A99B374F3", hash_generated_field = "3C3518CA99FABFDBA4EEED5204CA0958")


        private  int [] mActionSequence;

        /**
         * Creates a new instance.
         * @param keyCodeAndModifiers The key for the binding (key and modifiers).
         * @param actionSequence The sequence of action for the binding.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.911 -0500", hash_original_method = "A50D0B5AC0368A8E12CF6CC75EC809BD", hash_generated_method = "6D2CBD014CB05323E58D6ECF135C506E")
        public AccessibilityWebContentKeyBinding(long keyCodeAndModifiers, int[] actionSequence) {
            mKeyCodeAndModifiers = keyCodeAndModifiers;
            mActionSequence = actionSequence;
        }

        /**
         * @return The key code of the binding key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.905 -0500", hash_original_method = "8E50A2B3D320E1E0EE376617185D134A", hash_generated_method = "463E89BA3DE0C91F64F637735933E3F1")
        public int getKeyCode() {
            return (int) ((mKeyCodeAndModifiers & KEY_CODE_MASK) >> KEY_CODE_OFFSET);
        }

        /**
         * @return The meta state of the binding key.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.906 -0500", hash_original_method = "C813CFA88B40923E17E3BC75AACF9837", hash_generated_method = "FBF62286FBC080E8009FEBAD169CC0EB")
        public int getModifiers() {
            return (int) ((mKeyCodeAndModifiers & MODIFIERS_MASK) >> MODIFIERS_OFFSET);
        }

        /**
         * @return The number of actions in the key binding.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.907 -0500", hash_original_method = "7BDD12B6399A0F96D6927AAB9227781B", hash_generated_method = "3CB9E34A989438B7D037060947024172")
        public int getActionCount() {
            return mActionSequence.length;
        }

        /**
         * @param index The action for a given action <code>index</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.907 -0500", hash_original_method = "7D2F0A4FD4E90A95C2DF2F50740199D4", hash_generated_method = "13E85B00BD6A0B96484A78D38D600ADE")
        public int getAction(int index) {
            return mActionSequence[index];
        }

        /**
         * @param index The action code for a given action <code>index</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.908 -0500", hash_original_method = "CA4B639111BCEE7DB87E06F000E025C0", hash_generated_method = "B6AB1F50D29F52FFF438913497513DF5")
        public int getActionCode(int index) {
            return (mActionSequence[index] & ACTION_MASK) >> ACTION_OFFSET;
        }

        /**
         * @param index The first argument for a given action <code>index</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.909 -0500", hash_original_method = "D4FD6DE193B436AB1DC7E71BD25D2E14", hash_generated_method = "B580A4336AD2F27C685321604084BA0B")
        public int getFirstArgument(int index) {
            return (mActionSequence[index] & FIRST_ARGUMENT_MASK) >> FIRST_ARGUMENT_OFFSET;
        }

        /**
         * @param index The second argument for a given action <code>index</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.910 -0500", hash_original_method = "632B802F886C3F34DA2DAC0FE9DCCFBA", hash_generated_method = "66366F3F047C54B32EDD374CD3BF7F8E")
        public int getSecondArgument(int index) {
            return (mActionSequence[index] & SECOND_ARGUMENT_MASK) >> SECOND_ARGUMENT_OFFSET;
        }

        /**
         * @param index The third argument for a given action <code>index</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.911 -0500", hash_original_method = "F37454AACD85ADFC551E32B3CAA53EB4", hash_generated_method = "9DF1A778A4A6698D325F9C0E58013BEB")
        public int getThirdArgument(int index) {
            return (mActionSequence[index] & THIRD_ARGUMENT_MASK) >> THIRD_ARGUMENT_OFFSET;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.913 -0500", hash_original_method = "DADE2DD09F8576C0E4A43D6B7E83F05B", hash_generated_method = "E6A6AAD15ACE8C8260621F1150C5B272")
        @Override
public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("modifiers: ");
            builder.append(getModifiers());
            builder.append(", keyCode: ");
            builder.append(getKeyCode());
            builder.append(", actions[");
            for (int i = 0, count = getActionCount(); i < count; i++) {
                builder.append("{actionCode");
                builder.append(i);
                builder.append(": ");
                builder.append(getActionCode(i));
                builder.append(", firstArgument: ");
                builder.append(getFirstArgument(i));
                builder.append(", secondArgument: ");
                builder.append(getSecondArgument(i));
                builder.append(", thirdArgument: ");
                builder.append(getThirdArgument(i));
                builder.append("}");
            }
            builder.append("]");
            return builder.toString();
        }
    }

    /**
     * Set the current navigation axis which will be used while
     * calling {@link #traverseCurrentAxis(int, boolean, String)}.
     *
     * @param axis The axis to set.
     * @param sendEvent Whether to send an accessibility event to
     *        announce the change.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.884 -0500", hash_original_method = "3B116BB7452CBE6872A5E570E7D08041", hash_generated_method = "158B7F9D08A3F76C8015220613332334")
    private void setCurrentAxis(int axis, boolean sendEvent, String contentDescription) {
        mCurrentAxis = axis;
        if (sendEvent) {
            AccessibilityEvent event = getPartialyPopulatedAccessibilityEvent();
            event.getText().add(String.valueOf(axis));
            event.setContentDescription(contentDescription);
            sendAccessibilityEvent(event);
        }
    }

    /**
     * Performs conditional transition one axis to another.
     *
     * @param fromAxis The axis which must be the current for the transition to occur.
     * @param toAxis The axis to which to transition.
     * @param sendEvent Flag if to send an event to announce successful transition.
     * @param contentDescription A description of the performed action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.885 -0500", hash_original_method = "60CFCAC68A8E46E83373A5BD6B186EBB", hash_generated_method = "FDCD7ECCD5F7A2026D8F5CFF20A42996")
    private void prefromAxisTransition(int fromAxis, int toAxis, boolean sendEvent,
            String contentDescription) {
        if (mCurrentAxis == fromAxis) {
            setCurrentAxis(toAxis, sendEvent, contentDescription);
        }
    }

    /**
     * Traverse the document along the current navigation axis.
     *
     * @param direction The direction of traversal.
     * @param sendEvent Whether to send an accessibility event to
     *        announce the change.
     * @param contentDescription A description of the performed action.
     * @see #setCurrentAxis(int, boolean, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.885 -0500", hash_original_method = "FD1B61A72867CD7ABA9E4FFEC34475BF", hash_generated_method = "B9FEA51B2B2B7EBC32DCE6FE614CFE0E")
    private boolean traverseCurrentAxis(int direction, boolean sendEvent,
            String contentDescription) {
        return traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription);
    }

    /**
     * Traverse the document along the given navigation axis.
     *
     * @param direction The direction of traversal.
     * @param axis The axis along which to traverse.
     * @param sendEvent Whether to send an accessibility event to
     *        announce the change.
     * @param contentDescription A description of the performed action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.886 -0500", hash_original_method = "D76A1821B2762F1F39CCFC0B2614F6FE", hash_generated_method = "85DCEA3C9ED01CD1E637E6BEF09DDAC7")
    private boolean traverseGivenAxis(int direction, int axis, boolean sendEvent,
            String contentDescription) {
        WebViewCore webViewCore = mWebView.getWebViewCore();
        if (webViewCore == null) {
            return false;
        }

        AccessibilityEvent event = null;
        if (sendEvent) {
            event = getPartialyPopulatedAccessibilityEvent();
            // the text will be set upon receiving the selection string
            event.setContentDescription(contentDescription);
        }
        mScheduledEventStack.push(event);

        // if the axis is the default let WebView handle the event which will
        // result in cursor ring movement and selection of its content
        if (axis == NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR) {
            return false;
        }

        webViewCore.sendMessage(EventHub.MODIFY_SELECTION, direction, axis);
        return true;
    }

    /**
     * Called when the <code>selectionString</code> has changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.887 -0500", hash_original_method = "C444A575AEA295F9C8E995BA1405A425", hash_generated_method = "F4FA90B78B2EB701CCA6C72BBED426F8")
    public void onSelectionStringChange(String selectionString) {
        if (DEBUG) {
            Log.d(LOG_TAG, "Selection string: " + selectionString);
        }
        mIsLastSelectionStringNull = (selectionString == null);
        if (mScheduledEventStack.isEmpty()) {
            return;
        }
        AccessibilityEvent event = mScheduledEventStack.pop();
        if (event != null) {
            event.getText().add(selectionString);
            sendAccessibilityEvent(event);
        }
    }

    /**
     * Sends an {@link AccessibilityEvent}.
     *
     * @param event The event to send.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.888 -0500", hash_original_method = "A93E1B734733D18B27A729FA6BA2D3D4", hash_generated_method = "2FC0F06CF4A4D54F5682496E2A763FA6")
    private void sendAccessibilityEvent(AccessibilityEvent event) {
        if (DEBUG) {
            Log.d(LOG_TAG, "Dispatching: " + event);
        }
        // accessibility may be disabled while waiting for the selection string
        AccessibilityManager accessibilityManager =
            AccessibilityManager.getInstance(mWebView.getContext());
        if (accessibilityManager.isEnabled()) {
            accessibilityManager.sendAccessibilityEvent(event);
        }
    }

    /**
     * @return An accessibility event whose members are populated except its
     *         text and content description.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.889 -0500", hash_original_method = "97CE5C613C0F00A9204AE55F86D0A1E4", hash_generated_method = "77662BA77326FE621C60C6B05D073523")
    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent() {
        AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        event.setClassName(mWebView.getClass().getName());
        event.setPackageName(mWebView.getContext().getPackageName());
        event.setEnabled(mWebView.isEnabled());
        return event;
    }

    /**
     * Ensures that the Web content key bindings are loaded.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.890 -0500", hash_original_method = "391E7039B2527FA351ED94B9C1004246", hash_generated_method = "579B77F351718BE58AD7B7B280502260")
    private void ensureWebContentKeyBindings() {
        if (sBindings.size() > 0) {
            return;
        }

        String webContentKeyBindingsString  = Settings.Secure.getString(
                mWebView.getContext().getContentResolver(),
                Settings.Secure.ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS);

        SimpleStringSplitter semiColonSplitter = new SimpleStringSplitter(';');
        semiColonSplitter.setString(webContentKeyBindingsString);

        while (semiColonSplitter.hasNext()) {
            String bindingString = semiColonSplitter.next();
            if (TextUtils.isEmpty(bindingString)) {
                Log.e(LOG_TAG, "Disregarding malformed Web content key binding: "
                        + webContentKeyBindingsString);
                continue;
            }
            String[] keyValueArray = bindingString.split("=");
            if (keyValueArray.length != 2) {
                Log.e(LOG_TAG, "Disregarding malformed Web content key binding: " + bindingString);
                continue;
            }
            try {
                long keyCodeAndModifiers = Long.decode(keyValueArray[0].trim());
                String[] actionStrings = keyValueArray[1].split(":");
                int[] actions = new int[actionStrings.length];
                for (int i = 0, count = actions.length; i < count; i++) {
                    actions[i] = Integer.decode(actionStrings[i].trim());
                }
                sBindings.add(new AccessibilityWebContentKeyBinding(keyCodeAndModifiers, actions));
            } catch (NumberFormatException nfe) {
                Log.e(LOG_TAG, "Disregarding malformed key binding: " + bindingString);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.891 -0500", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "A11ABE9645CFB85AB3245D436E4A8107")
    private boolean isEnterActionKey(int keyCode) {
        return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                || keyCode == KeyEvent.KEYCODE_ENTER
                || keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }
}

