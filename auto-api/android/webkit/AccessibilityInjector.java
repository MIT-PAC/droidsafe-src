package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebViewCore.EventHub;
import java.util.ArrayList;
import java.util.Stack;

class AccessibilityInjector {
    private WebView mWebView;
    private Stack<AccessibilityEvent> mScheduledEventStack = new Stack<AccessibilityEvent>();
    private int mCurrentAxis = 2;
    private boolean mLastDownEventHandled;
    private boolean mIsLastSelectionStringNull;
    private int mLastDirection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.583 -0400", hash_original_method = "EF4641FD66F12CE398EFC703194D8E58", hash_generated_method = "F7C36284050E2E8B4B8E55642661462F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityInjector(WebView webView) {
        dsTaint.addTaint(webView.dsTaint);
        ensureWebContentKeyBindings();
        // ---------- Original Method ----------
        //mWebView = webView;
        //ensureWebContentKeyBindings();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.599 -0400", hash_original_method = "EB800BB0EE5BEF185F11F0CA48ECBE70", hash_generated_method = "F30622F0968B10055F92F751118A0A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyEvent(KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var2964D75E6F1F5379056302BD290CFBBC_1029967397 = (isEnterActionKey(event.getKeyCode()));
        } //End collapsed parenthetic
        {
            boolean varCEE3787BA6CC35DE8C5C148EB02E679E_1757369651 = (event.getAction() == KeyEvent.ACTION_UP);
        } //End collapsed parenthetic
        mLastDownEventHandled = false;
        AccessibilityWebContentKeyBinding binding;
        binding = null;
        {
            Iterator<AccessibilityWebContentKeyBinding> var75D817242CC163C72A2B345E5E7E8568_794581894 = (sBindings).iterator();
            var75D817242CC163C72A2B345E5E7E8568_794581894.hasNext();
            AccessibilityWebContentKeyBinding candidate = var75D817242CC163C72A2B345E5E7E8568_794581894.next();
            {
                {
                    boolean varF74C93D19B4CBA4D7890314550B6A4A6_2089497159 = (event.getKeyCode() == candidate.getKeyCode()
                    && event.hasModifiers(candidate.getModifiers()));
                    {
                        binding = candidate;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i, count;
            i = 0;
            count = binding.getActionCount();
            {
                int actionCode;
                actionCode = binding.getActionCode(i);
                String contentDescription;
                contentDescription = Integer.toHexString(binding.getAction(i));
                //Begin case ACTION_SET_CURRENT_AXIS 
                int axis;
                axis = binding.getFirstArgument(i);
                //End case ACTION_SET_CURRENT_AXIS 
                //Begin case ACTION_SET_CURRENT_AXIS 
                boolean sendEvent;
                sendEvent = (binding.getSecondArgument(i) == 1);
                //End case ACTION_SET_CURRENT_AXIS 
                //Begin case ACTION_SET_CURRENT_AXIS 
                setCurrentAxis(axis, sendEvent, contentDescription);
                //End case ACTION_SET_CURRENT_AXIS 
                //Begin case ACTION_SET_CURRENT_AXIS 
                mLastDownEventHandled = true;
                //End case ACTION_SET_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_CURRENT_AXIS 
                int direction;
                direction = binding.getFirstArgument(i);
                //End case ACTION_TRAVERSE_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_CURRENT_AXIS 
                {
                    mIsLastSelectionStringNull = false;
                } //End block
                //End case ACTION_TRAVERSE_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_CURRENT_AXIS 
                mLastDirection = direction;
                //End case ACTION_TRAVERSE_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_CURRENT_AXIS 
                sendEvent = (binding.getSecondArgument(i) == 1);
                //End case ACTION_TRAVERSE_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_CURRENT_AXIS 
                mLastDownEventHandled = traverseCurrentAxis(direction, sendEvent,
                            contentDescription);
                //End case ACTION_TRAVERSE_CURRENT_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                direction = binding.getFirstArgument(i);
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                {
                    mIsLastSelectionStringNull = false;
                } //End block
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                mLastDirection = direction;
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                axis =  binding.getSecondArgument(i);
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                sendEvent = (binding.getThirdArgument(i) == 1);
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                traverseGivenAxis(direction, axis, sendEvent, contentDescription);
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_TRAVERSE_GIVEN_AXIS 
                mLastDownEventHandled = true;
                //End case ACTION_TRAVERSE_GIVEN_AXIS 
                //Begin case ACTION_PERFORM_AXIS_TRANSITION 
                int fromAxis;
                fromAxis = binding.getFirstArgument(i);
                //End case ACTION_PERFORM_AXIS_TRANSITION 
                //Begin case ACTION_PERFORM_AXIS_TRANSITION 
                int toAxis;
                toAxis = binding.getSecondArgument(i);
                //End case ACTION_PERFORM_AXIS_TRANSITION 
                //Begin case ACTION_PERFORM_AXIS_TRANSITION 
                sendEvent = (binding.getThirdArgument(i) == 1);
                //End case ACTION_PERFORM_AXIS_TRANSITION 
                //Begin case ACTION_PERFORM_AXIS_TRANSITION 
                prefromAxisTransition(fromAxis, toAxis, sendEvent, contentDescription);
                //End case ACTION_PERFORM_AXIS_TRANSITION 
                //Begin case ACTION_PERFORM_AXIS_TRANSITION 
                mLastDownEventHandled = true;
                //End case ACTION_PERFORM_AXIS_TRANSITION 
                //Begin case ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS 
                {
                    mLastDirection = binding.getFirstArgument(i);
                    sendEvent = (binding.getSecondArgument(i) == 1);
                    traverseGivenAxis(mLastDirection, NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR,
                            sendEvent, contentDescription);
                    mLastDownEventHandled = false;
                } //End block
                {
                    mLastDownEventHandled = true;
                } //End block
                //End case ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS 
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.599 -0400", hash_original_method = "3B116BB7452CBE6872A5E570E7D08041", hash_generated_method = "EE4205669D2A04290E15A6D238F9F405")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCurrentAxis(int axis, boolean sendEvent, String contentDescription) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(sendEvent);
        {
            AccessibilityEvent event;
            event = getPartialyPopulatedAccessibilityEvent();
            event.getText().add(String.valueOf(axis));
            event.setContentDescription(contentDescription);
            sendAccessibilityEvent(event);
        } //End block
        // ---------- Original Method ----------
        //mCurrentAxis = axis;
        //if (sendEvent) {
            //AccessibilityEvent event = getPartialyPopulatedAccessibilityEvent();
            //event.getText().add(String.valueOf(axis));
            //event.setContentDescription(contentDescription);
            //sendAccessibilityEvent(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.600 -0400", hash_original_method = "60CFCAC68A8E46E83373A5BD6B186EBB", hash_generated_method = "74C851AD6433305AC8849188303B39C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void prefromAxisTransition(int fromAxis, int toAxis, boolean sendEvent,
            String contentDescription) {
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(fromAxis);
        dsTaint.addTaint(toAxis);
        dsTaint.addTaint(sendEvent);
        {
            setCurrentAxis(toAxis, sendEvent, contentDescription);
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentAxis == fromAxis) {
            //setCurrentAxis(toAxis, sendEvent, contentDescription);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.600 -0400", hash_original_method = "FD1B61A72867CD7ABA9E4FFEC34475BF", hash_generated_method = "0F44D115381DFD742780B5D4458686B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean traverseCurrentAxis(int direction, boolean sendEvent,
            String contentDescription) {
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(sendEvent);
        boolean var956738CB2E778C2CA33EB6671A7DEDFD_740439756 = (traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.600 -0400", hash_original_method = "D76A1821B2762F1F39CCFC0B2614F6FE", hash_generated_method = "309D3C5BFA385F0F3D70CA9C77A84E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean traverseGivenAxis(int direction, int axis, boolean sendEvent,
            String contentDescription) {
        dsTaint.addTaint(axis);
        dsTaint.addTaint(contentDescription);
        dsTaint.addTaint(direction);
        dsTaint.addTaint(sendEvent);
        WebViewCore webViewCore;
        webViewCore = mWebView.getWebViewCore();
        AccessibilityEvent event;
        event = null;
        {
            event = getPartialyPopulatedAccessibilityEvent();
            event.setContentDescription(contentDescription);
        } //End block
        mScheduledEventStack.push(event);
        webViewCore.sendMessage(EventHub.MODIFY_SELECTION, direction, axis);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //WebViewCore webViewCore = mWebView.getWebViewCore();
        //if (webViewCore == null) {
            //return false;
        //}
        //AccessibilityEvent event = null;
        //if (sendEvent) {
            //event = getPartialyPopulatedAccessibilityEvent();
            //event.setContentDescription(contentDescription);
        //}
        //mScheduledEventStack.push(event);
        //if (axis == NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR) {
            //return false;
        //}
        //webViewCore.sendMessage(EventHub.MODIFY_SELECTION, direction, axis);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.600 -0400", hash_original_method = "C444A575AEA295F9C8E995BA1405A425", hash_generated_method = "554B8BBE3D72E69CF347C719E673FFF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onSelectionStringChange(String selectionString) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(selectionString);
        {
            Log.d(LOG_TAG, "Selection string: " + selectionString);
        } //End block
        mIsLastSelectionStringNull = (selectionString == null);
        {
            boolean var420EBB15FD269B45EC982C512D58732B_1119824809 = (mScheduledEventStack.isEmpty());
        } //End collapsed parenthetic
        AccessibilityEvent event;
        event = mScheduledEventStack.pop();
        {
            event.getText().add(selectionString);
            sendAccessibilityEvent(event);
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) {
            //Log.d(LOG_TAG, "Selection string: " + selectionString);
        //}
        //mIsLastSelectionStringNull = (selectionString == null);
        //if (mScheduledEventStack.isEmpty()) {
            //return;
        //}
        //AccessibilityEvent event = mScheduledEventStack.pop();
        //if (event != null) {
            //event.getText().add(selectionString);
            //sendAccessibilityEvent(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.601 -0400", hash_original_method = "A93E1B734733D18B27A729FA6BA2D3D4", hash_generated_method = "1B533DE7FBEAA2098F301A13B3C97D60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            Log.d(LOG_TAG, "Dispatching: " + event);
        } //End block
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(mWebView.getContext());
        {
            boolean var47733DA0ED268A7603912057BB45854B_1068010500 = (accessibilityManager.isEnabled());
            {
                accessibilityManager.sendAccessibilityEvent(event);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (DEBUG) {
            //Log.d(LOG_TAG, "Dispatching: " + event);
        //}
        //AccessibilityManager accessibilityManager =
            //AccessibilityManager.getInstance(mWebView.getContext());
        //if (accessibilityManager.isEnabled()) {
            //accessibilityManager.sendAccessibilityEvent(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.601 -0400", hash_original_method = "97CE5C613C0F00A9204AE55F86D0A1E4", hash_generated_method = "F551088EB699DEBB90F68328624AA6FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent() {
        AccessibilityEvent event;
        event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        event.setClassName(mWebView.getClass().getName());
        event.setPackageName(mWebView.getContext().getPackageName());
        event.setEnabled(mWebView.isEnabled());
        return (AccessibilityEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //event.setClassName(mWebView.getClass().getName());
        //event.setPackageName(mWebView.getContext().getPackageName());
        //event.setEnabled(mWebView.isEnabled());
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.602 -0400", hash_original_method = "391E7039B2527FA351ED94B9C1004246", hash_generated_method = "028CEEE48381F2E0FAA2C14FBFBB6F29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensureWebContentKeyBindings() {
        {
            boolean var6B7CD2D285653ADDA05685B01C7CB438_563257535 = (sBindings.size() > 0);
        } //End collapsed parenthetic
        String webContentKeyBindingsString;
        webContentKeyBindingsString = Settings.Secure.getString(
                mWebView.getContext().getContentResolver(),
                Settings.Secure.ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS);
        SimpleStringSplitter semiColonSplitter;
        semiColonSplitter = new SimpleStringSplitter(';');
        semiColonSplitter.setString(webContentKeyBindingsString);
        {
            boolean var31424E76797A103C5B3C4482299A3938_1100871007 = (semiColonSplitter.hasNext());
            {
                String bindingString;
                bindingString = semiColonSplitter.next();
                {
                    boolean var796F041A7ECC98C6880099122F8E0173_643594609 = (TextUtils.isEmpty(bindingString));
                } //End collapsed parenthetic
                String[] keyValueArray;
                keyValueArray = bindingString.split("=");
                try 
                {
                    long keyCodeAndModifiers;
                    keyCodeAndModifiers = Long.decode(keyValueArray[0].trim());
                    String[] actionStrings;
                    actionStrings = keyValueArray[1].split(":");
                    int[] actions;
                    actions = new int[actionStrings.length];
                    {
                        int i, count;
                        i = 0;
                        count = actions.length;
                        {
                            actions[i] = Integer.decode(actionStrings[i].trim());
                        } //End block
                    } //End collapsed parenthetic
                    sBindings.add(new AccessibilityWebContentKeyBinding(keyCodeAndModifiers, actions));
                } //End block
                catch (NumberFormatException nfe)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.602 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "AFF3891DE7800AE77A23AA8639AB239E")
    @DSModeled(DSC.SAFE)
    private boolean isEnterActionKey(int keyCode) {
        dsTaint.addTaint(keyCode);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    private static final class AccessibilityWebContentKeyBinding {
        private long mKeyCodeAndModifiers;
        private int [] mActionSequence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.602 -0400", hash_original_method = "A50D0B5AC0368A8E12CF6CC75EC809BD", hash_generated_method = "E92BE9FE23B5DEC14B0EF38EA206C5E4")
        @DSModeled(DSC.SAFE)
        public AccessibilityWebContentKeyBinding(long keyCodeAndModifiers, int[] actionSequence) {
            dsTaint.addTaint(keyCodeAndModifiers);
            dsTaint.addTaint(actionSequence[0]);
            // ---------- Original Method ----------
            //mKeyCodeAndModifiers = keyCodeAndModifiers;
            //mActionSequence = actionSequence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "8E50A2B3D320E1E0EE376617185D134A", hash_generated_method = "C71DE32A089FE2347264549831F272C2")
        @DSModeled(DSC.SAFE)
        public int getKeyCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (int) ((mKeyCodeAndModifiers & KEY_CODE_MASK) >> KEY_CODE_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "C813CFA88B40923E17E3BC75AACF9837", hash_generated_method = "E9A16A6235B5043189219790D034C10A")
        @DSModeled(DSC.SAFE)
        public int getModifiers() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (int) ((mKeyCodeAndModifiers & MODIFIERS_MASK) >> MODIFIERS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "7BDD12B6399A0F96D6927AAB9227781B", hash_generated_method = "3288DFB4DEB18FFFAF34CD58BF57CDA0")
        @DSModeled(DSC.SAFE)
        public int getActionCount() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mActionSequence.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "7D2F0A4FD4E90A95C2DF2F50740199D4", hash_generated_method = "D75D4E10F22E041A97A071D4CDEA68EE")
        @DSModeled(DSC.SAFE)
        public int getAction(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mActionSequence[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "CA4B639111BCEE7DB87E06F000E025C0", hash_generated_method = "032A6572342E3B24DA2AC1170C5DF845")
        @DSModeled(DSC.SAFE)
        public int getActionCode(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (mActionSequence[index] & ACTION_MASK) >> ACTION_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.603 -0400", hash_original_method = "D4FD6DE193B436AB1DC7E71BD25D2E14", hash_generated_method = "E978B56ABA5D1A34AC2FF61462A5A6BE")
        @DSModeled(DSC.SAFE)
        public int getFirstArgument(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (mActionSequence[index] & FIRST_ARGUMENT_MASK) >> FIRST_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.604 -0400", hash_original_method = "632B802F886C3F34DA2DAC0FE9DCCFBA", hash_generated_method = "3494F1C85DB0866CD20D1966AF9C258F")
        @DSModeled(DSC.SAFE)
        public int getSecondArgument(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (mActionSequence[index] & SECOND_ARGUMENT_MASK) >> SECOND_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.604 -0400", hash_original_method = "F37454AACD85ADFC551E32B3CAA53EB4", hash_generated_method = "58DCDB41843B5CA6763CF0300DDC5952")
        @DSModeled(DSC.SAFE)
        public int getThirdArgument(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (mActionSequence[index] & THIRD_ARGUMENT_MASK) >> THIRD_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.604 -0400", hash_original_method = "DADE2DD09F8576C0E4A43D6B7E83F05B", hash_generated_method = "1162B4F38588EB3F2CFD2715DD6EACE2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder builder;
            builder = new StringBuilder();
            builder.append("modifiers: ");
            builder.append(getModifiers());
            builder.append(", keyCode: ");
            builder.append(getKeyCode());
            builder.append(", actions[");
            {
                int i, count;
                i = 0;
                count = getActionCount();
                {
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
                } //End block
            } //End collapsed parenthetic
            builder.append("]");
            String varCEB98099F8B5AF9267E3A4873F9FB1DE_713707870 = (builder.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final int MODIFIERS_OFFSET = 32;
        private static final long MODIFIERS_MASK = 0xFFFFFFF00000000L;
        private static final int KEY_CODE_OFFSET = 0;
        private static final long KEY_CODE_MASK = 0x00000000FFFFFFFFL;
        private static final int ACTION_OFFSET = 24;
        private static final int ACTION_MASK = 0xFF000000;
        private static final int FIRST_ARGUMENT_OFFSET = 16;
        private static final int FIRST_ARGUMENT_MASK = 0x00FF0000;
        private static final int SECOND_ARGUMENT_OFFSET = 8;
        private static final int SECOND_ARGUMENT_MASK = 0x0000FF00;
        private static final int THIRD_ARGUMENT_OFFSET = 0;
        private static final int THIRD_ARGUMENT_MASK = 0x000000FF;
    }


    
    private static final String LOG_TAG = "AccessibilityInjector";
    private static final boolean DEBUG = true;
    private static final int ACTION_SET_CURRENT_AXIS = 0;
    private static final int ACTION_TRAVERSE_CURRENT_AXIS = 1;
    private static final int ACTION_TRAVERSE_GIVEN_AXIS = 2;
    private static final int ACTION_PERFORM_AXIS_TRANSITION = 3;
    private static final int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
    private static final int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
    private static ArrayList<AccessibilityWebContentKeyBinding> sBindings =
        new ArrayList<AccessibilityWebContentKeyBinding>();
}

