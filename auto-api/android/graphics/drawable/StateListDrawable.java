package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.Arrays;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;

public class StateListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.481 -0400", hash_original_field = "98224A175F5DD299C71B89DE954A0408", hash_generated_field = "980C8FFE9150BE923FD62F944FCAAAEC")

    private StateListState mStateListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.481 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.482 -0400", hash_original_method = "2C05F8B66F3CA072BC0F3CED1F3E988B", hash_generated_method = "3034A7A547BD403E1E0F238C476B9227")
    public  StateListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.491 -0400", hash_original_method = "90179FAF2CD102672779F3C6B59674D6", hash_generated_method = "1F04BBA184832220D792B1EDEFD1CB8D")
    private  StateListDrawable(StateListState state, Resources res) {
        StateListState as;
        as = new StateListState(state, this, res);
        mStateListState = as;
        setConstantState(as);
        onStateChange(getState());
        addTaint(state.getTaint());
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        //StateListState as = new StateListState(state, this, res);
        //mStateListState = as;
        //setConstantState(as);
        //onStateChange(getState());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.493 -0400", hash_original_method = "AF6407614B20F66E7E774377847CB658", hash_generated_method = "26BE0C761E4E1CF40E7B3C02FB83EE5A")
    public void addState(int[] stateSet, Drawable drawable) {
        {
            mStateListState.addStateSet(stateSet, drawable);
            onStateChange(getState());
        } //End block
        addTaint(stateSet[0]);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mStateListState.addStateSet(stateSet, drawable);
            //onStateChange(getState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.494 -0400", hash_original_method = "DFB1FDC7F6EFB1E210EFD5F6F91EF45F", hash_generated_method = "88B9D0F37558E37070EF9806097104B3")
    @Override
    public boolean isStateful() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1883104239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1883104239;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.517 -0400", hash_original_method = "3B1FAED12170A69A129A87EF9824D4D4", hash_generated_method = "D3438909EEC193ACB396F667241BD4B7")
    @Override
    protected boolean onStateChange(int[] stateSet) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int idx;
        idx = mStateListState.indexOfStateSet(stateSet);
        android.util.Log.i(TAG, "onStateChange " + this + " states "
                + Arrays.toString(stateSet) + " found " + idx);
        {
            idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        } //End block
        {
            boolean var3E2B49468750734D46A6120849432D6B_868453234 = (selectDrawable(idx));
        } //End collapsed parenthetic
        boolean var6096784E4C4CB866A4D8B9C324F426C5_823470764 = (super.onStateChange(stateSet));
        addTaint(stateSet[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1623427537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1623427537;
        // ---------- Original Method ----------
        //int idx = mStateListState.indexOfStateSet(stateSet);
        //if (DEBUG) android.util.Log.i(TAG, "onStateChange " + this + " states "
                //+ Arrays.toString(stateSet) + " found " + idx);
        //if (idx < 0) {
            //idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        //}
        //if (selectDrawable(idx)) {
            //return true;
        //}
        //return super.onStateChange(stateSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.554 -0400", hash_original_method = "60A0EEC92FC73D4C3C226304BAFE6ED2", hash_generated_method = "B8BF0ABD78CA2F0DCF09AC9F1B889876")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        TypedArray a;
        a = r.obtainAttributes(attrs,
                com.android.internal.R.styleable.StateListDrawable);
        super.inflateWithAttributes(r, parser, a,
                com.android.internal.R.styleable.StateListDrawable_visible);
        mStateListState.setVariablePadding(a.getBoolean(
                com.android.internal.R.styleable.StateListDrawable_variablePadding, false));
        mStateListState.setConstantSize(a.getBoolean(
                com.android.internal.R.styleable.StateListDrawable_constantSize, false));
        mStateListState.setEnterFadeDuration(a.getInt(
                com.android.internal.R.styleable.StateListDrawable_enterFadeDuration, 0));
        mStateListState.setExitFadeDuration(a.getInt(
                com.android.internal.R.styleable.StateListDrawable_exitFadeDuration, 0));
        setDither(a.getBoolean(com.android.internal.R.styleable.StateListDrawable_dither,
                               DEFAULT_DITHER));
        a.recycle();
        int type;
        int innerDepth;
        innerDepth = parser.getDepth() + 1;
        int depth;
        {
            boolean var5C2AD857B4870B6E82338097BA87AA78_1030226781 = ((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG));
            {
                {
                    boolean var03C44ADC0346A0FD12ECFE38D2A0612F_1752195172 = (depth > innerDepth || !parser.getName().equals("item"));
                } //End collapsed parenthetic
                int drawableRes;
                drawableRes = 0;
                int i;
                int j;
                j = 0;
                int numAttrs;
                numAttrs = attrs.getAttributeCount();
                int[] states;
                states = new int[numAttrs];
                {
                    i = 0;
                    {
                        int stateResId;
                        stateResId = attrs.getAttributeNameResource(i);
                        {
                            drawableRes = attrs.getAttributeResourceValue(i, 0);
                        } //End block
                        {
                            states[j++] = attrs.getAttributeBooleanValue(i, false)
                            ? stateResId
                            : -stateResId;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                states = StateSet.trimStateSet(states, j);
                Drawable dr;
                {
                    dr = r.getDrawable(drawableRes);
                } //End block
                {
                    {
                        boolean var16E7483EB4C069010E58346DA2B7701B_137536045 = ((type = parser.next()) == XmlPullParser.TEXT);
                    } //End collapsed parenthetic
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    } //End block
                    dr = Drawable.createFromXmlInner(r, parser, attrs);
                } //End block
                mStateListState.addStateSet(states, dr);
            } //End block
        } //End collapsed parenthetic
        onStateChange(getState());
        addTaint(r.getTaint());
        addTaint(parser.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.555 -0400", hash_original_method = "C30AAB7A53F4234B41E4C7F0859B0584", hash_generated_method = "876F4D23DB7C5A70ECFD5832E51D3A4A")
     StateListState getStateListState() {
        StateListState varB4EAC82CA7396A68D541C85D26508E83_542777841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_542777841 = mStateListState;
        varB4EAC82CA7396A68D541C85D26508E83_542777841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542777841;
        // ---------- Original Method ----------
        //return mStateListState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.556 -0400", hash_original_method = "D9E3394F970F5413D258086831B5CB36", hash_generated_method = "26DBADE4FD7A89F69AF73C121A4A7AC5")
    public int getStateCount() {
        int var11CFE54020BD6DC70972CFC97D6175DA_1109754291 = (mStateListState.getChildCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231804395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1231804395;
        // ---------- Original Method ----------
        //return mStateListState.getChildCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.556 -0400", hash_original_method = "55D68A9E9C260DCF60D1CBBC77B3FC0F", hash_generated_method = "E75CBE03BC007BE0C1ED36073B1D90C0")
    public int[] getStateSet(int index) {
        addTaint(index);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1931762363 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1931762363;
        // ---------- Original Method ----------
        //return mStateListState.mStateSets[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.571 -0400", hash_original_method = "266BB2A523416F0BDAD03984AE85B606", hash_generated_method = "DFBB2DEFE7F21EE21B23B99B3A503337")
    public Drawable getStateDrawable(int index) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_746046972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746046972 = mStateListState.getChildren()[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_746046972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746046972;
        // ---------- Original Method ----------
        //return mStateListState.getChildren()[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.571 -0400", hash_original_method = "410013485164C1DC2E995A85C1D3348C", hash_generated_method = "5FC5993A48EB57864F32085626E5A9E1")
    public int getStateDrawableIndex(int[] stateSet) {
        int var32B7534748596CE25EEA3B111D541A0E_567122716 = (mStateListState.indexOfStateSet(stateSet));
        addTaint(stateSet[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389023865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389023865;
        // ---------- Original Method ----------
        //return mStateListState.indexOfStateSet(stateSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.578 -0400", hash_original_method = "92CD1CD82DD5DEA6E7693E9ED80EE90B", hash_generated_method = "770B59E453C8B7197B2A70A30624F211")
    @Override
    public Drawable mutate() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_554164917 = null; //Variable for return #1
        {
            boolean varC94B19053599294E7944C8C841976773_1511667854 = (!mMutated && super.mutate() == this);
            {
                int[][] sets;
                sets = mStateListState.mStateSets;
                int count;
                count = sets.length;
                mStateListState.mStateSets = new int[count][];
                {
                    int i;
                    i = 0;
                    {
                        int[] set;
                        set = sets[i];
                        {
                            mStateListState.mStateSets[i] = set.clone();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                mMutated = true;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_554164917 = this;
        varB4EAC82CA7396A68D541C85D26508E83_554164917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554164917;
        // ---------- Original Method ----------
        //if (!mMutated && super.mutate() == this) {
            //final int[][] sets = mStateListState.mStateSets;
            //final int count = sets.length;
            //mStateListState.mStateSets = new int[count][];
            //for (int i = 0; i < count; i++) {
                //final int[] set = sets[i];
                //if (set != null) {
                    //mStateListState.mStateSets[i] = set.clone();
                //}
            //}
            //mMutated = true;
        //}
        //return this;
    }

    
    static final class StateListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.578 -0400", hash_original_field = "E8D0B0AF3911ED511F9C0E4BFADA96AB", hash_generated_field = "108E8057EC0E2571E1A7E53C160D9BCF")

        int[][] mStateSets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.606 -0400", hash_original_method = "51F130A45558C85B3D3E7CFC8D91F8BC", hash_generated_method = "B82EAB11C0E1FF4E9CAE8D91C2BB124B")
          StateListState(StateListState orig, StateListDrawable owner, Resources res) {
            super(orig, owner, res);
            {
                mStateSets = orig.mStateSets;
            } //End block
            {
                mStateSets = new int[getChildren().length][];
            } //End block
            addTaint(owner.getTaint());
            addTaint(res.getTaint());
            // ---------- Original Method ----------
            //if (orig != null) {
                //mStateSets = orig.mStateSets;
            //} else {
                //mStateSets = new int[getChildren().length][];
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.608 -0400", hash_original_method = "E4505B2AE7EA07FF537AEC799B3546D0", hash_generated_method = "270110BC53DFBF9A76EDD2B4D10BE1CD")
         int addStateSet(int[] stateSet, Drawable drawable) {
            int pos;
            pos = addChild(drawable);
            mStateSets[pos] = stateSet;
            addTaint(drawable.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592909382 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592909382;
            // ---------- Original Method ----------
            //final int pos = addChild(drawable);
            //mStateSets[pos] = stateSet;
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.608 -0400", hash_original_method = "A182AEBDD3B8E6EFB499434DA2A68669", hash_generated_method = "2E13BE04B588AD86CBFD9BEDC43472BC")
        private int indexOfStateSet(int[] stateSet) {
            int[][] stateSets;
            stateSets = mStateSets;
            int N;
            N = getChildCount();
            {
                int i;
                i = 0;
                {
                    {
                        boolean var6FDC262EEEF0E02068C5811E55176A45_805716929 = (StateSet.stateSetMatches(stateSets[i], stateSet));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(stateSet[0]);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876374069 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876374069;
            // ---------- Original Method ----------
            //final int[][] stateSets = mStateSets;
            //final int N = getChildCount();
            //for (int i = 0; i < N; i++) {
                //if (StateSet.stateSetMatches(stateSets[i], stateSet)) {
                    //return i;
                //}
            //}
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.609 -0400", hash_original_method = "56C51D0FF73BF2A3F52E87DDE967AFF6", hash_generated_method = "2C102857BFC2FA2199DC0C394464DCFA")
        @Override
        public Drawable newDrawable() {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_525314033 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_525314033 = new StateListDrawable(this, null);
            varB4EAC82CA7396A68D541C85D26508E83_525314033.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_525314033;
            // ---------- Original Method ----------
            //return new StateListDrawable(this, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.625 -0400", hash_original_method = "DF4CF834DF74C8FC36C20E482CEB7672", hash_generated_method = "897325EAB17A6714E99C83BC465E8600")
        @Override
        public Drawable newDrawable(Resources res) {
            Drawable varB4EAC82CA7396A68D541C85D26508E83_681363259 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_681363259 = new StateListDrawable(this, res);
            addTaint(res.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_681363259.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_681363259;
            // ---------- Original Method ----------
            //return new StateListDrawable(this, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.626 -0400", hash_original_method = "CF45914111E05D752375948053626E9D", hash_generated_method = "F0B22900B24841B90C30DCE584163658")
        @Override
        public void growArray(int oldSize, int newSize) {
            super.growArray(oldSize, newSize);
            int[][] newStateSets;
            newStateSets = new int[newSize][];
            System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            mStateSets = newStateSets;
            addTaint(oldSize);
            addTaint(newSize);
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //final int[][] newStateSets = new int[newSize][];
            //System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            //mStateSets = newStateSets;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.626 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.626 -0400", hash_original_field = "011133FE6FD59A0326A277B2E59F7350", hash_generated_field = "F69C26884787EA873FF8D0D3E31E0B0F")

    private static String TAG = "StateListDrawable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:16.627 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "50E8831DF5E0728C9EF4B3F3FEDD2908")

    private static boolean DEFAULT_DITHER = true;
}

