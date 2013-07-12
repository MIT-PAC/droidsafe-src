package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.Arrays;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.StateSet;

public class StateListDrawable extends DrawableContainer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.808 -0400", hash_original_field = "98224A175F5DD299C71B89DE954A0408", hash_generated_field = "980C8FFE9150BE923FD62F944FCAAAEC")

    private StateListState mStateListState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.808 -0400", hash_original_field = "9FB80C30383848C8D006680B5F3BDAF9", hash_generated_field = "5CA5A1EF3CAA45117BCACBC34EF05952")

    private boolean mMutated;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.808 -0400", hash_original_method = "2C05F8B66F3CA072BC0F3CED1F3E988B", hash_generated_method = "3034A7A547BD403E1E0F238C476B9227")
    public  StateListDrawable() {
        this(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.809 -0400", hash_original_method = "90179FAF2CD102672779F3C6B59674D6", hash_generated_method = "A626E1BEE80BB60E02C9F2063D8F77B3")
    private  StateListDrawable(StateListState state, Resources res) {
        addTaint(res.getTaint());
        addTaint(state.getTaint());
        StateListState as = new StateListState(state, this, res);
        mStateListState = as;
        setConstantState(as);
        onStateChange(getState());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.809 -0400", hash_original_method = "AF6407614B20F66E7E774377847CB658", hash_generated_method = "62DA5A55CBC1255046C96ED6B524D7D9")
    public void addState(int[] stateSet, Drawable drawable) {
        addTaint(drawable.getTaint());
        addTaint(stateSet[0]);
    if(drawable != null)        
        {
            mStateListState.addStateSet(stateSet, drawable);
            onStateChange(getState());
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.809 -0400", hash_original_method = "DFB1FDC7F6EFB1E210EFD5F6F91EF45F", hash_generated_method = "3C8EDD348631AA1B4195522A69E03D37")
    @Override
    public boolean isStateful() {
        boolean varB326B5062B2F0E69046810717534CB09_607296384 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795654346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795654346;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.810 -0400", hash_original_method = "3B1FAED12170A69A129A87EF9824D4D4", hash_generated_method = "07C0D28BF10F5BE24DFE40798374A6AE")
    @Override
    protected boolean onStateChange(int[] stateSet) {
        
        addTaint(stateSet[0]);
        int idx = mStateListState.indexOfStateSet(stateSet);
    if(DEBUG)        
        android.util.Log.i(TAG, "onStateChange " + this + " states "
                + Arrays.toString(stateSet) + " found " + idx);
    if(idx < 0)        
        {
            idx = mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        } 
    if(selectDrawable(idx))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1292666688 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089065490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089065490;
        } 
        boolean var2475A1EF1D2059E35A5F3692280BA2E6_894216776 = (super.onStateChange(stateSet));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648865744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648865744;
        
        
        
                
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.812 -0400", hash_original_method = "60A0EEC92FC73D4C3C226304BAFE6ED2", hash_generated_method = "ECD8C4D0AE28F9E35D4333DC0E89232F")
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
            } 
    if(depth > innerDepth || !parser.getName().equals("item"))            
            {
                continue;
            } 
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
                } 
                else
                {
                    states[j++] = attrs.getAttributeBooleanValue(i, false)
                            ? stateResId
                            : -stateResId;
                } 
            } 
            states = StateSet.trimStateSet(states, j);
            Drawable dr;
    if(drawableRes != 0)            
            {
                dr = r.getDrawable(drawableRes);
            } 
            else
            {
                while
((type = parser.next()) == XmlPullParser.TEXT)                
                {
                } 
    if(type != XmlPullParser.START_TAG)                
                {
                    XmlPullParserException var323689A2E36B2E80C03C4E544ECA8A7C_356146887 = new XmlPullParserException(
                            parser.getPositionDescription()
                                    + ": <item> tag requires a 'drawable' attribute or "
                                    + "child tag defining a drawable");
                    var323689A2E36B2E80C03C4E544ECA8A7C_356146887.addTaint(taint);
                    throw var323689A2E36B2E80C03C4E544ECA8A7C_356146887;
                } 
                dr = Drawable.createFromXmlInner(r, parser, attrs);
            } 
            mStateListState.addStateSet(states, dr);
        } 
        onStateChange(getState());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.814 -0400", hash_original_method = "C30AAB7A53F4234B41E4C7F0859B0584", hash_generated_method = "A086411AEE698E2039C7E0920FA0E3FD")
     StateListState getStateListState() {
StateListState var15CA3D3F03B1B8383B2D584EC564E071_1431988457 =         mStateListState;
        var15CA3D3F03B1B8383B2D584EC564E071_1431988457.addTaint(taint);
        return var15CA3D3F03B1B8383B2D584EC564E071_1431988457;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.814 -0400", hash_original_method = "D9E3394F970F5413D258086831B5CB36", hash_generated_method = "880B0E281BC906BCD0CB383168295EA5")
    public int getStateCount() {
        int varC9D05DAF97FA1C61954CF19B96CC7A92_847590728 = (mStateListState.getChildCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870574562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1870574562;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.815 -0400", hash_original_method = "55D68A9E9C260DCF60D1CBBC77B3FC0F", hash_generated_method = "D1DE916EA3F4DF2561DA390D3F75AC95")
    public int[] getStateSet(int index) {
        addTaint(index);
        int[] var9B0DC66BD913DD81387D6393C221AE0D_1624973621 = (mStateListState.mStateSets[index]);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2060383852 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2060383852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.816 -0400", hash_original_method = "266BB2A523416F0BDAD03984AE85B606", hash_generated_method = "E7E90733F1162E0096CE7A758D107127")
    public Drawable getStateDrawable(int index) {
        addTaint(index);
Drawable var2B920C6B2A8938211FBB77210BF418E6_1499241904 =         mStateListState.getChildren()[index];
        var2B920C6B2A8938211FBB77210BF418E6_1499241904.addTaint(taint);
        return var2B920C6B2A8938211FBB77210BF418E6_1499241904;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.817 -0400", hash_original_method = "410013485164C1DC2E995A85C1D3348C", hash_generated_method = "157169831FC3F382E723C6AC67EC4BAA")
    public int getStateDrawableIndex(int[] stateSet) {
        addTaint(stateSet[0]);
        int var98E7D7844B02ED003A5B36EC8B681104_635472280 = (mStateListState.indexOfStateSet(stateSet));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270443865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270443865;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.818 -0400", hash_original_method = "92CD1CD82DD5DEA6E7693E9ED80EE90B", hash_generated_method = "73ABFC62E59BF4C24E78193AE580ABA1")
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
                } 
            } 
            mMutated = true;
        } 
Drawable var72A74007B2BE62B849F475C7BDA4658B_1721325811 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1721325811.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1721325811;
        
        
            
            
            
            
                
                
                    
                
            
            
        
        
    }

    
    static final class StateListState extends DrawableContainerState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.819 -0400", hash_original_field = "E8D0B0AF3911ED511F9C0E4BFADA96AB", hash_generated_field = "108E8057EC0E2571E1A7E53C160D9BCF")

        int[][] mStateSets;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.819 -0400", hash_original_method = "51F130A45558C85B3D3E7CFC8D91F8BC", hash_generated_method = "F2BDA02434E71B3CCA25723DE4414543")
          StateListState(StateListState orig, StateListDrawable owner, Resources res) {
            super(orig, owner, res);
            addTaint(res.getTaint());
            addTaint(owner.getTaint());
    if(orig != null)            
            {
                mStateSets = orig.mStateSets;
            } 
            else
            {
                mStateSets = new int[getChildren().length][];
            } 
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.820 -0400", hash_original_method = "E4505B2AE7EA07FF537AEC799B3546D0", hash_generated_method = "C5C9AE550C8C3CF350A4B210666DC7B8")
         int addStateSet(int[] stateSet, Drawable drawable) {
            addTaint(drawable.getTaint());
            final int pos = addChild(drawable);
            mStateSets[pos] = stateSet;
            int var5E0BDCBDDCCCA4D66D74BA8C1CEE1A68_256676249 = (pos);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578988396 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1578988396;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.820 -0400", hash_original_method = "A182AEBDD3B8E6EFB499434DA2A68669", hash_generated_method = "4F06AC4C38B276274699A152EB0FB9B7")
        private int indexOfStateSet(int[] stateSet) {
            addTaint(stateSet[0]);
            final int[][] stateSets = mStateSets;
            final int N = getChildCount();
for(int i = 0;i < N;i++)
            {
    if(StateSet.stateSetMatches(stateSets[i], stateSet))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1616977234 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117489485 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_117489485;
                } 
            } 
            int var6BB61E3B7BCE0931DA574D19D1D82C88_272583791 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697805344 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697805344;
            
            
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.821 -0400", hash_original_method = "56C51D0FF73BF2A3F52E87DDE967AFF6", hash_generated_method = "E9FCA9FF486F46222C32B21B1C0FCFEE")
        @Override
        public Drawable newDrawable() {
Drawable varEED792F364498887068F4C843B499730_1050662249 =             new StateListDrawable(this, null);
            varEED792F364498887068F4C843B499730_1050662249.addTaint(taint);
            return varEED792F364498887068F4C843B499730_1050662249;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.821 -0400", hash_original_method = "DF4CF834DF74C8FC36C20E482CEB7672", hash_generated_method = "C8DC0B0CBC16C0AAB19C2141B2DB176D")
        @Override
        public Drawable newDrawable(Resources res) {
            addTaint(res.getTaint());
Drawable var4086C67B7F04528705B04C50F83B6E68_1835181920 =             new StateListDrawable(this, res);
            var4086C67B7F04528705B04C50F83B6E68_1835181920.addTaint(taint);
            return var4086C67B7F04528705B04C50F83B6E68_1835181920;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.822 -0400", hash_original_method = "CF45914111E05D752375948053626E9D", hash_generated_method = "35731A7145287B4685FFB18DAE69FE9E")
        @Override
        public void growArray(int oldSize, int newSize) {
            addTaint(newSize);
            addTaint(oldSize);
            super.growArray(oldSize, newSize);
            final int[][] newStateSets = new int[newSize][];
            System.arraycopy(mStateSets, 0, newStateSets, 0, oldSize);
            mStateSets = newStateSets;
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.822 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.822 -0400", hash_original_field = "011133FE6FD59A0326A277B2E59F7350", hash_generated_field = "344FFFED067AA98CA906512A50739761")

    private static final String TAG = "StateListDrawable";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:20.822 -0400", hash_original_field = "786AC07A1E16FDB1F134271AA028A7C1", hash_generated_field = "17A3499D3AE1DB6784657D5E8AE3951F")

    private static final boolean DEFAULT_DITHER = true;
}

