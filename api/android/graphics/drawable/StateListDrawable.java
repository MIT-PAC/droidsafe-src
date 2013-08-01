package android.graphics.drawable;

// Droidsafe Imports
import java.io.IOException;
import java.util.Arrays;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class StateListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.707 -0400", hash_original_field = "98224A175F5DD299C71B89DE954A0408", hash_generated_field = "980C8FFE9150BE923FD62F944FCAAAEC")

    private StateListState mStateListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.707 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.707 -0400", hash_original_method = "2C05F8B66F3CA072BC0F3CED1F3E988B", hash_generated_method = "3034A7A547BD403E1E0F238C476B9227")
    public  StateListDrawable() {
        this(null, null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.708 -0400", hash_original_method = "90179FAF2CD102672779F3C6B59674D6", hash_generated_method = "A626E1BEE80BB60E02C9F2063D8F77B3")
    private  StateListDrawable(StateListState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        StateListState as = new StateListState(state, this, res);
        mStateListState = as;
        setConstantState(as);
        onStateChange(getState());
        // ---------- Original Method ----------
        //StateListState as = new StateListState(state, this, res);
        //mStateListState = as;
        //setConstantState(as);
        //onStateChange(getState());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.709 -0400", hash_original_method = "AF6407614B20F66E7E774377847CB658", hash_generated_method = "62DA5A55CBC1255046C96ED6B524D7D9")
    public void addState(int[] stateSet, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(stateSet[0]);
        if(drawable != null)        
        {
            mStateListState.addStateSet(stateSet, drawable);
            onStateChange(getState());
        } //End block
        // ---------- Original Method ----------
        //if (drawable != null) {
            //mStateListState.addStateSet(stateSet, drawable);
            //onStateChange(getState());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.709 -0400", hash_original_method = "DFB1FDC7F6EFB1E210EFD5F6F91EF45F", hash_generated_method = "97D2C9AA8D15AC4513358FB9BA391D96")
    @Override
    public boolean isStateful() {
        boolean varB326B5062B2F0E69046810717534CB09_1943244269 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778156392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778156392;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.710 -0400", hash_original_method = "3B1FAED12170A69A129A87EF9824D4D4", hash_generated_method = "61CBF3AEFF2AF1270910F974FE93186F")
    @Override
    protected boolean onStateChange(int[] stateSet) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(stateSet[0]);
        int idx = mStateListState.indexOfStateSet(stateSet);
        if(DEBUG)        
        android.util.Log.i(TAG, "onStateChange " + this + " states "
                + Arrays.toString(stateSet) + " found " + idx);
        if(idx < 0)        
        {
            idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        } //End block
        if(selectDrawable(idx))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1241924599 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1338758558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1338758558;
        } //End block
        boolean var2475A1EF1D2059E35A5F3692280BA2E6_416364125 = (super.onStateChange(stateSet));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613262530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613262530;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.712 -0400", hash_original_method = "60A0EEC92FC73D4C3C226304BAFE6ED2", hash_generated_method = "2B280E418F3EFEA18DD9B6DAE7A9124F")
    @Override
    public void inflate(Resources r, XmlPullParser parser,
            AttributeSet attrs) throws XmlPullParserException, IOException {
        addTaint(attrs.getTaint());
        addTaint(parser.getTaint());
        addTaint(r.getTaint());
        TypedArray a = r.obtainAttributes(attrs,
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
        final int innerDepth = parser.getDepth() + 1;
        int depth;
        while
((type = parser.next()) != XmlPullParser.END_DOCUMENT
                && ((depth = parser.getDepth()) >= innerDepth
                || type != XmlPullParser.END_TAG))        
        {
            if(type != XmlPullParser.START_TAG)            
            {
                continue;
            } //End block
            if(depth > innerDepth || !parser.getName().equals("item"))            
            {
                continue;
            } //End block
            int drawableRes = 0;
            int i;
            int j = 0;
            final int numAttrs = attrs.getAttributeCount();
            int[] states = new int[numAttrs];
for(i = 0;i < numAttrs;i++)
            {
                final int stateResId = attrs.getAttributeNameResource(i);
                if(stateResId == 0)                
                break;
                if(stateResId == com.android.internal.R.attr.drawable)                
                {
                    drawableRes = attrs.getAttributeResourceValue(i, 0);
                } //End block
                else
                {
                    states[j++] = attrs.getAttributeBooleanValue(i, false)
                            ? stateResId
                            : -stateResId;
                } //End block
            } //End block
            states = StateSet.trimStateSet(states, j);
            Drawable dr;
            if(drawableRes != 0)            
            {
                dr = r.getDrawable(drawableRes);
            } //End block
            else
            {
                while
((type = parser.next()) == XmlPullParser.TEXT)                
                {
                } //End block
                if(type != XmlPullParser.START_TAG)                
                {
                    XmlPullParserException var323689A2E36B2E80C03C4E544ECA8A7C_777328266 = new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    var323689A2E36B2E80C03C4E544ECA8A7C_777328266.addTaint(taint);
                    throw var323689A2E36B2E80C03C4E544ECA8A7C_777328266;
                } //End block
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } //End block
            mStateListState.addStateSet(states, dr);
        } //End block
        onStateChange(getState());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.713 -0400", hash_original_method = "C30AAB7A53F4234B41E4C7F0859B0584", hash_generated_method = "BD202A83167BD8FD884476074DAB7BCB")
     StateListState getStateListState() {
StateListState var15CA3D3F03B1B8383B2D584EC564E071_2069023105 =         mStateListState;
        var15CA3D3F03B1B8383B2D584EC564E071_2069023105.addTaint(taint);
        return var15CA3D3F03B1B8383B2D584EC564E071_2069023105;
        // ---------- Original Method ----------
        //return mStateListState;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.714 -0400", hash_original_method = "D9E3394F970F5413D258086831B5CB36", hash_generated_method = "0530ED42AB86A4317BE582860E4DC40F")
    public int getStateCount() {
        int varC9D05DAF97FA1C61954CF19B96CC7A92_529087623 = (mStateListState.getChildCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142584104 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142584104;
        // ---------- Original Method ----------
        //return mStateListState.getChildCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.715 -0400", hash_original_method = "55D68A9E9C260DCF60D1CBBC77B3FC0F", hash_generated_method = "617954BCF445C38C6D1918E1F4E3F5D7")
    public int[] getStateSet(int index) {
        addTaint(index);
        int[] var9B0DC66BD913DD81387D6393C221AE0D_2014532726 = (mStateListState.mStateSets[index]);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_907769398 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_907769398;
        // ---------- Original Method ----------
        //return mStateListState.mStateSets[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.715 -0400", hash_original_method = "266BB2A523416F0BDAD03984AE85B606", hash_generated_method = "7F66953A8A96887D4237711E8C49D26D")
    public Drawable getStateDrawable(int index) {
        addTaint(index);
Drawable var2B920C6B2A8938211FBB77210BF418E6_1554343870 =         mStateListState.getChildren()[index];
        var2B920C6B2A8938211FBB77210BF418E6_1554343870.addTaint(taint);
        return var2B920C6B2A8938211FBB77210BF418E6_1554343870;
        // ---------- Original Method ----------
        //return mStateListState.getChildren()[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.716 -0400", hash_original_method = "410013485164C1DC2E995A85C1D3348C", hash_generated_method = "F0A92B2BAFFF8B2905427A5C30F90AE8")
    public int getStateDrawableIndex(int[] stateSet) {
        addTaint(stateSet[0]);
        int var98E7D7844B02ED003A5B36EC8B681104_265246355 = (mStateListState.indexOfStateSet(stateSet));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272247254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1272247254;
        // ---------- Original Method ----------
        //return mStateListState.indexOfStateSet(stateSet);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.717 -0400", hash_original_method = "92CD1CD82DD5DEA6E7693E9ED80EE90B", hash_generated_method = "FD73AE96C8B293354757594C0B448FC5")
    @Override
    public Drawable mutate() {
        if(!mMutated && super.mutate() == this)        
        {
            final int[][] sets = mStateListState.mStateSets;
            final int count = sets.length;
            mStateListState.mStateSets = new int[count][];
for(int i = 0;i < count;i++)
            {
                final int[] set = sets[i];
                if(set != null)                
                {
                    mStateListState.mStateSets[i] = set.clone();
                } //End block
            } //End block
            mMutated = true;
        } //End block
Drawable var72A74007B2BE62B849F475C7BDA4658B_821147901 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_821147901.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_821147901;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.718 -0400", hash_original_field = "E8D0B0AF3911ED511F9C0E4BFADA96AB", hash_generated_field = "108E8057EC0E2571E1A7E53C160D9BCF")

        int[][] mStateSets;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.718 -0400", hash_original_method = "51F130A45558C85B3D3E7CFC8D91F8BC", hash_generated_method = "F2BDA02434E71B3CCA25723DE4414543")
          StateListState(StateListState orig, StateListDrawable owner, Resources res) {
            super(orig, owner, res);
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
            if(orig != null)            
            {
                mStateSets = orig.mStateSets;
            } //End block
            else
            {
                mStateSets = new int[getChildren().length][];
            } //End block
            // ---------- Original Method ----------
            //if (orig != null) {
                //mStateSets = orig.mStateSets;
            //} else {
                //mStateSets = new int[getChildren().length][];
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.719 -0400", hash_original_method = "E4505B2AE7EA07FF537AEC799B3546D0", hash_generated_method = "48D99F528E2900043B053DD239FD95DC")
         int addStateSet(int[] stateSet, Drawable drawable) {
            addTaint(drawable.getTaint());
            final int pos = addChild(drawable);
            mStateSets[pos] = stateSet;
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_733729037 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457375080 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457375080;
            // ---------- Original Method ----------
            //final int pos = addChild(drawable);
            //mStateSets[pos] = stateSet;
            //return pos;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.720 -0400", hash_original_method = "A182AEBDD3B8E6EFB499434DA2A68669", hash_generated_method = "9C7BA2243DE254CEFA414D626EEAC422")
        private int indexOfStateSet(int[] stateSet) {
            addTaint(stateSet[0]);
            final int[][] stateSets = mStateSets;
            final int N = getChildCount();
for(int i = 0;i < N;i++)
            {
                if(StateSet.stateSetMatches(stateSets[i], stateSet))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_2032440723 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817257274 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817257274;
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1768609762 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313967708 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_313967708;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.720 -0400", hash_original_method = "56C51D0FF73BF2A3F52E87DDE967AFF6", hash_generated_method = "D61E8E465E974C2679E95614BDDD67B3")
        @Override
        public Drawable newDrawable() {
Drawable varEED792F364498887068F4C843B499730_1010485200 =             new StateListDrawable(this, null);
            varEED792F364498887068F4C843B499730_1010485200.addTaint(taint);
            return varEED792F364498887068F4C843B499730_1010485200;
            // ---------- Original Method ----------
            //return new StateListDrawable(this, null);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.721 -0400", hash_original_method = "DF4CF834DF74C8FC36C20E482CEB7672", hash_generated_method = "CE117BF3470D94F92061B81FEFA566A5")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var4086C67B7F04528705B04C50F83B6E68_287091177 =             new StateListDrawable(this, res);
            var4086C67B7F04528705B04C50F83B6E68_287091177.addTaint(taint);
            return var4086C67B7F04528705B04C50F83B6E68_287091177;
            // ---------- Original Method ----------
            //return new StateListDrawable(this, res);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.721 -0400", hash_original_method = "CF45914111E05D752375948053626E9D", hash_generated_method = "35731A7145287B4685FFB18DAE69FE9E")
        @Override
        public void growArray(int oldSize, int newSize) {
            addTaint(newSize);
            addTaint(oldSize);
            super.growArray(oldSize, newSize);
            final int[][] newStateSets = new int[newSize][];
            System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            mStateSets = newStateSets;
            // ---------- Original Method ----------
            //super.growArray(oldSize, newSize);
            //final int[][] newStateSets = new int[newSize][];
            //System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            //mStateSets = newStateSets;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.722 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.722 -0400", hash_original_field = "011133FE6FD59A0326A277B2E59F7350", hash_generated_field = "344FFFED067AA98CA906512A50739761")

    private static final String TAG = "StateListDrawable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:12.722 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
}

