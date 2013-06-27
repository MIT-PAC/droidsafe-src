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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "72439B8F99EB438C3DA5D9CD798C6786", hash_generated_field = "99346B50377E115231263981E00655CA")

    private WebView mWebView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "D1A330370DBEBA42FF52A0368B62EDD0", hash_generated_field = "4E60E8AF193EBDE87208E31FC448B0DF")

    private Stack<AccessibilityEvent> mScheduledEventStack = new Stack<AccessibilityEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "7F548E9293768117746509FFDB5A3057", hash_generated_field = "4330EB8AA5A2FE255DBD22415D04ED16")

    private int mCurrentAxis = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "C1651C38A7F93096FAEEABE5AEB2FDDD", hash_generated_field = "224025CAF4716F1644AA382FABDDDD40")

    private boolean mLastDownEventHandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "C35004E7DA14679F0A0D20E077785059", hash_generated_field = "8A7EF6B120836C189817F81132C96CE4")

    private boolean mIsLastSelectionStringNull;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_field = "56D9C42186B57F5F56DBBA60DCED4505", hash_generated_field = "20DA94CEADB2B1E6F5C2261C53B2ECE7")

    private int mLastDirection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.798 -0400", hash_original_method = "EF4641FD66F12CE398EFC703194D8E58", hash_generated_method = "2F86D7F6824D2022926CFD290AF26273")
    public  AccessibilityInjector(WebView webView) {
        mWebView = webView;
        ensureWebContentKeyBindings();
        // ---------- Original Method ----------
        //mWebView = webView;
        //ensureWebContentKeyBindings();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.954 -0400", hash_original_method = "EB800BB0EE5BEF185F11F0CA48ECBE70", hash_generated_method = "0212FAD7C2C3E86ABDA670521DF788DF")
    public boolean onKeyEvent(KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var2964D75E6F1F5379056302BD290CFBBC_2127560029 = (isEnterActionKey(event.getKeyCode()));
        } //End collapsed parenthetic
        {
            boolean varCEE3787BA6CC35DE8C5C148EB02E679E_149628414 = (event.getAction() == KeyEvent.ACTION_UP);
        } //End collapsed parenthetic
        mLastDownEventHandled = false;
        AccessibilityWebContentKeyBinding binding;
        binding = null;
        {
            Iterator<AccessibilityWebContentKeyBinding> var75D817242CC163C72A2B345E5E7E8568_33162447 = (sBindings).iterator();
            var75D817242CC163C72A2B345E5E7E8568_33162447.hasNext();
            AccessibilityWebContentKeyBinding candidate = var75D817242CC163C72A2B345E5E7E8568_33162447.next();
            {
                {
                    boolean varF74C93D19B4CBA4D7890314550B6A4A6_594028753 = (event.getKeyCode() == candidate.getKeyCode()
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
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961591724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961591724;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.970 -0400", hash_original_method = "3B116BB7452CBE6872A5E570E7D08041", hash_generated_method = "6D8CD3498057D44FE3F57E1FA2DD0181")
    private void setCurrentAxis(int axis, boolean sendEvent, String contentDescription) {
        mCurrentAxis = axis;
        {
            AccessibilityEvent event;
            event = getPartialyPopulatedAccessibilityEvent();
            event.getText().add(String.valueOf(axis));
            event.setContentDescription(contentDescription);
            sendAccessibilityEvent(event);
        } //End block
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        // ---------- Original Method ----------
        //mCurrentAxis = axis;
        //if (sendEvent) {
            //AccessibilityEvent event = getPartialyPopulatedAccessibilityEvent();
            //event.getText().add(String.valueOf(axis));
            //event.setContentDescription(contentDescription);
            //sendAccessibilityEvent(event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.970 -0400", hash_original_method = "60CFCAC68A8E46E83373A5BD6B186EBB", hash_generated_method = "2C9C52B5586EAA2862069B4B9A12D228")
    private void prefromAxisTransition(int fromAxis, int toAxis, boolean sendEvent,
            String contentDescription) {
        {
            setCurrentAxis(toAxis, sendEvent, contentDescription);
        } //End block
        addTaint(fromAxis);
        addTaint(toAxis);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        // ---------- Original Method ----------
        //if (mCurrentAxis == fromAxis) {
            //setCurrentAxis(toAxis, sendEvent, contentDescription);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.971 -0400", hash_original_method = "FD1B61A72867CD7ABA9E4FFEC34475BF", hash_generated_method = "51C2D241356A42905402CB7AC07CEC31")
    private boolean traverseCurrentAxis(int direction, boolean sendEvent,
            String contentDescription) {
        boolean var956738CB2E778C2CA33EB6671A7DEDFD_802152993 = (traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription));
        addTaint(direction);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901010672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901010672;
        // ---------- Original Method ----------
        //return traverseGivenAxis(direction, mCurrentAxis, sendEvent, contentDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.971 -0400", hash_original_method = "D76A1821B2762F1F39CCFC0B2614F6FE", hash_generated_method = "847DF68D29293D8DE320C07B9F61D0A3")
    private boolean traverseGivenAxis(int direction, int axis, boolean sendEvent,
            String contentDescription) {
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
        addTaint(direction);
        addTaint(axis);
        addTaint(sendEvent);
        addTaint(contentDescription.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_902973903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_902973903;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.972 -0400", hash_original_method = "C444A575AEA295F9C8E995BA1405A425", hash_generated_method = "DD978AD3EBC09D772632ACB7F5DA837D")
    public void onSelectionStringChange(String selectionString) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Log.d(LOG_TAG, "Selection string: " + selectionString);
        } //End block
        mIsLastSelectionStringNull = (selectionString == null);
        {
            boolean var420EBB15FD269B45EC982C512D58732B_1182046972 = (mScheduledEventStack.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.976 -0400", hash_original_method = "A93E1B734733D18B27A729FA6BA2D3D4", hash_generated_method = "974EC53030F8C39837795D0A900D8EB5")
    private void sendAccessibilityEvent(AccessibilityEvent event) {
        {
            Log.d(LOG_TAG, "Dispatching: " + event);
        } //End block
        AccessibilityManager accessibilityManager;
        accessibilityManager = AccessibilityManager.getInstance(mWebView.getContext());
        {
            boolean var47733DA0ED268A7603912057BB45854B_327141346 = (accessibilityManager.isEnabled());
            {
                accessibilityManager.sendAccessibilityEvent(event);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.977 -0400", hash_original_method = "97CE5C613C0F00A9204AE55F86D0A1E4", hash_generated_method = "1B48435C38045F8B145706193978969B")
    private AccessibilityEvent getPartialyPopulatedAccessibilityEvent() {
        AccessibilityEvent varB4EAC82CA7396A68D541C85D26508E83_234074942 = null; //Variable for return #1
        AccessibilityEvent event;
        event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        event.setClassName(mWebView.getClass().getName());
        event.setPackageName(mWebView.getContext().getPackageName());
        event.setEnabled(mWebView.isEnabled());
        varB4EAC82CA7396A68D541C85D26508E83_234074942 = event;
        varB4EAC82CA7396A68D541C85D26508E83_234074942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234074942;
        // ---------- Original Method ----------
        //AccessibilityEvent event = AccessibilityEvent.obtain(AccessibilityEvent.TYPE_VIEW_SELECTED);
        //event.setClassName(mWebView.getClass().getName());
        //event.setPackageName(mWebView.getContext().getPackageName());
        //event.setEnabled(mWebView.isEnabled());
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.991 -0400", hash_original_method = "391E7039B2527FA351ED94B9C1004246", hash_generated_method = "C4C38A00C31FB25B7AAA91E63DB8F50D")
    private void ensureWebContentKeyBindings() {
        {
            boolean var6B7CD2D285653ADDA05685B01C7CB438_97225430 = (sBindings.size() > 0);
        } //End collapsed parenthetic
        String webContentKeyBindingsString;
        webContentKeyBindingsString = Settings.Secure.getString(
                mWebView.getContext().getContentResolver(),
                Settings.Secure.ACCESSIBILITY_WEB_CONTENT_KEY_BINDINGS);
        SimpleStringSplitter semiColonSplitter;
        semiColonSplitter = new SimpleStringSplitter(';');
        semiColonSplitter.setString(webContentKeyBindingsString);
        {
            boolean var31424E76797A103C5B3C4482299A3938_1654205858 = (semiColonSplitter.hasNext());
            {
                String bindingString;
                bindingString = semiColonSplitter.next();
                {
                    boolean var796F041A7ECC98C6880099122F8E0173_980780159 = (TextUtils.isEmpty(bindingString));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.992 -0400", hash_original_method = "6AB19E93948D2A1BBE98A475D0E38626", hash_generated_method = "4B94EC0EF6D220F163594BC888E9A6E9")
    private boolean isEnterActionKey(int keyCode) {
        addTaint(keyCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58318018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58318018;
        // ---------- Original Method ----------
        //return keyCode == KeyEvent.KEYCODE_DPAD_CENTER
                //|| keyCode == KeyEvent.KEYCODE_ENTER
                //|| keyCode == KeyEvent.KEYCODE_NUMPAD_ENTER;
    }

    
    private static final class AccessibilityWebContentKeyBinding {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.992 -0400", hash_original_field = "CFAA3AA1A2D9FBFD8E3F4A62BE28F7AF", hash_generated_field = "ED9AFF5D0BE3F3908705CAFA2BF1844E")

        private long mKeyCodeAndModifiers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.992 -0400", hash_original_field = "FC1559E434165DEC394AC0678DE16FCB", hash_generated_field = "3C3518CA99FABFDBA4EEED5204CA0958")

        private int [] mActionSequence;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.992 -0400", hash_original_method = "A50D0B5AC0368A8E12CF6CC75EC809BD", hash_generated_method = "798F030C871F13812FE22F360B3AB5E6")
        public  AccessibilityWebContentKeyBinding(long keyCodeAndModifiers, int[] actionSequence) {
            mKeyCodeAndModifiers = keyCodeAndModifiers;
            mActionSequence = actionSequence;
            // ---------- Original Method ----------
            //mKeyCodeAndModifiers = keyCodeAndModifiers;
            //mActionSequence = actionSequence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.992 -0400", hash_original_method = "8E50A2B3D320E1E0EE376617185D134A", hash_generated_method = "54A1987F5BF07758EF2E4A450A1639D2")
        public int getKeyCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679054867 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_679054867;
            // ---------- Original Method ----------
            //return (int) ((mKeyCodeAndModifiers & KEY_CODE_MASK) >> KEY_CODE_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.993 -0400", hash_original_method = "C813CFA88B40923E17E3BC75AACF9837", hash_generated_method = "E32C7CFD5AF1BA8887621293EADC8054")
        public int getModifiers() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611688168 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611688168;
            // ---------- Original Method ----------
            //return (int) ((mKeyCodeAndModifiers & MODIFIERS_MASK) >> MODIFIERS_OFFSET);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.993 -0400", hash_original_method = "7BDD12B6399A0F96D6927AAB9227781B", hash_generated_method = "3346EDE49CE95E5AC63D21C24A189308")
        public int getActionCount() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406246111 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406246111;
            // ---------- Original Method ----------
            //return mActionSequence.length;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.993 -0400", hash_original_method = "7D2F0A4FD4E90A95C2DF2F50740199D4", hash_generated_method = "100D2478803AA883498613B50223E0BF")
        public int getAction(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11427446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_11427446;
            // ---------- Original Method ----------
            //return mActionSequence[index];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.993 -0400", hash_original_method = "CA4B639111BCEE7DB87E06F000E025C0", hash_generated_method = "983165290B77032307820783EE816587")
        public int getActionCode(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363244378 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_363244378;
            // ---------- Original Method ----------
            //return (mActionSequence[index] & ACTION_MASK) >> ACTION_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.994 -0400", hash_original_method = "D4FD6DE193B436AB1DC7E71BD25D2E14", hash_generated_method = "6F0B224638AA3745F18B751B7162241D")
        public int getFirstArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630887786 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630887786;
            // ---------- Original Method ----------
            //return (mActionSequence[index] & FIRST_ARGUMENT_MASK) >> FIRST_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.994 -0400", hash_original_method = "632B802F886C3F34DA2DAC0FE9DCCFBA", hash_generated_method = "74D94417E3DD09A37B985A83B68C5F47")
        public int getSecondArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278977638 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_278977638;
            // ---------- Original Method ----------
            //return (mActionSequence[index] & SECOND_ARGUMENT_MASK) >> SECOND_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.994 -0400", hash_original_method = "F37454AACD85ADFC551E32B3CAA53EB4", hash_generated_method = "8315C0BBCF774EA6D6A57CF5772797B8")
        public int getThirdArgument(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168237740 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1168237740;
            // ---------- Original Method ----------
            //return (mActionSequence[index] & THIRD_ARGUMENT_MASK) >> THIRD_ARGUMENT_OFFSET;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_method = "DADE2DD09F8576C0E4A43D6B7E83F05B", hash_generated_method = "B46E074E0A0B96C367E00ED73C0E15F7")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_515654578 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_515654578 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_515654578.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_515654578;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "0C0B71EEE0395BA6D7CBE31AC5F9AEC2", hash_generated_field = "03A6D3CF0F2488F5B4648D33C21AD82F")

        private static int MODIFIERS_OFFSET = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "4505992BBEFFAF0A453237676832770F", hash_generated_field = "D57566BAD213B3485B5EC995834C5511")

        private static long MODIFIERS_MASK = 0xFFFFFFF00000000L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "268BF15DBF6497E56A11F1B50F6CC54B", hash_generated_field = "8252CAEF755358D6025D5CDF9C3023D0")

        private static int KEY_CODE_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "A03F82C7BF66F13BCD5F7E1BEA4E3A63", hash_generated_field = "9B821313EC774ED7A092E24DED549865")

        private static long KEY_CODE_MASK = 0x00000000FFFFFFFFL;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "45C52D9E1A24CD6445095FA543065832", hash_generated_field = "7D444BEBD37B015C36DAA6F03C879E6A")

        private static int ACTION_OFFSET = 24;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.005 -0400", hash_original_field = "8D3C4D3FB51A62D4CB68E91C75A5376D", hash_generated_field = "063C4B4B51E22EB8C9CAF189DF67BEC4")

        private static int ACTION_MASK = 0xFF000000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "4B391CE42B2BE595405534F2DF2EFDA9", hash_generated_field = "F720EEAE76F5C6B1591230D37B150C44")

        private static int FIRST_ARGUMENT_OFFSET = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "E9317B50C32C42701F4886DE2617571A", hash_generated_field = "437E33522AB1E050FD5A31B6157C4EEA")

        private static int FIRST_ARGUMENT_MASK = 0x00FF0000;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "6EC87210E442CD14032D5F0F01B65FC7", hash_generated_field = "9510EA42021044F9992B196BA0E8B0C8")

        private static int SECOND_ARGUMENT_OFFSET = 8;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "AB08A64255E0C7B85E28CCDD77FCEA6F", hash_generated_field = "44DCB5A639B1D4FE5DB3E269FCF17896")

        private static int SECOND_ARGUMENT_MASK = 0x0000FF00;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "9E77A176E5CCF91A8D053D3475189A4E", hash_generated_field = "595358FA00F4B3DA503D590E12ADD593")

        private static int THIRD_ARGUMENT_OFFSET = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "A645DA048CC672D05E187D3253EC1A0B", hash_generated_field = "BAB61E164000575B8972C1D6FB83F27B")

        private static int THIRD_ARGUMENT_MASK = 0x000000FF;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "7A4A6FF299BC184104AF90C5A869703C", hash_generated_field = "4F2E62C6466170C13527568CDDC6539D")

    private static String LOG_TAG = "AccessibilityInjector";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "BC4FF4C62A62F66D6D2E0A35B84DD24A", hash_generated_field = "14C18EBA74F36E4DA6BB1F58245F971E")

    private static boolean DEBUG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "D174E8BCC0AED576327B0F1324BA60E7", hash_generated_field = "201E2B3B747A1DB6B2D4E6F67E336B6B")

    private static int ACTION_SET_CURRENT_AXIS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "D8B4D1E3B010BB703AB75B54023AF722", hash_generated_field = "862FAE1B3C6C439FAF96C907EEAB94BE")

    private static int ACTION_TRAVERSE_CURRENT_AXIS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "84277BDA8832766167541A97D9B03555", hash_generated_field = "2F3B048CFDA0D494595CDCFD50E3CCCB")

    private static int ACTION_TRAVERSE_GIVEN_AXIS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "914DC005E92F1387BA3876F25D96B7D9", hash_generated_field = "0491C97ED8A4ACD9539167743F6BA889")

    private static int ACTION_PERFORM_AXIS_TRANSITION = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "892EF700461E7EA84893534B3C007ED8", hash_generated_field = "0887DD3581FBCFBC5F0F7AD07FC56B16")

    private static int ACTION_TRAVERSE_DEFAULT_WEB_VIEW_BEHAVIOR_AXIS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "CEA850454B129A29D1E5F8174751004E", hash_generated_field = "995B8687A843997AA88F6E1F713EC3D7")

    private static int NAVIGATION_AXIS_DEFAULT_WEB_VIEW_BEHAVIOR = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.006 -0400", hash_original_field = "9952A1D46E5D034CB3461690E0BC8CAF", hash_generated_field = "4C5C7E9C43BB16E424C598EA8932A1C4")

    private static ArrayList<AccessibilityWebContentKeyBinding> sBindings = new ArrayList<AccessibilityWebContentKeyBinding>();
}

