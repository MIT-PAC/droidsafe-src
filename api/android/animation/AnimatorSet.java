package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class AnimatorSet extends Animator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.000 -0400", hash_original_field = "481906F29B88D36C651268313AA99F9C", hash_generated_field = "78867B83FFE4557154B28EC301F67602")

    private ArrayList<Animator> mPlayingSet = new ArrayList<Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.001 -0400", hash_original_field = "2CC48382609FD4F3FEC0CF6660DD7962", hash_generated_field = "F38E02C0F09CF00758E07C1CC5650AAE")

    private HashMap<Animator, Node> mNodeMap = new HashMap<Animator, Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.002 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

    private ArrayList<Node> mNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.004 -0400", hash_original_field = "380E108BE067245CE9715E7ABDA0FF63", hash_generated_field = "E9EC8321AA5FBFA3AD5392BA81212767")

    private ArrayList<Node> mSortedNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.004 -0400", hash_original_field = "D431998331275038BB7C0DD8851F8324", hash_generated_field = "85FDA93549065D0B768B7599D0ED4292")

    private boolean mNeedsSort = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.005 -0400", hash_original_field = "4305573E026146BBA24A84B6A06149F8", hash_generated_field = "E140240C038E8A4BB9AE350DA570B1A7")

    private AnimatorSetListener mSetListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.006 -0400", hash_original_field = "DE76B6AA416614DFE053747730C60267", hash_generated_field = "6D37E5BBEF916EC90B750BBB805CC32B")

    boolean mTerminated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.006 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.007 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.007 -0400", hash_original_field = "0050D5176A9407A418561438385DC63D", hash_generated_field = "0B2CF66D82E234938F59A1069E6EEEDE")

    private ValueAnimator mDelayAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.008 -0400", hash_original_field = "1F2FC4A63449C82899F1C64113BB8CAC", hash_generated_field = "0C5BD3F1F0DE8D2738EE5A7B893414D1")

    private long mDuration = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.008 -0400", hash_original_method = "A9DDD8ED58932E64D4F5BE029FA05ABF", hash_generated_method = "A9DDD8ED58932E64D4F5BE029FA05ABF")
    public AnimatorSet ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.010 -0400", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "A19870BF86C8630117E54BA9568156FE")
    public void playTogether(Animator... items) {
        addTaint(items[0].getTaint());
    if(items != null)        
        {
            mNeedsSort = true;
            Builder builder = play(items[0]);
for(int i = 1;i < items.length;++i)
            {
                builder.with(items[i]);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (items != null) {
            //mNeedsSort = true;
            //Builder builder = play(items[0]);
            //for (int i = 1; i < items.length; ++i) {
                //builder.with(items[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.012 -0400", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "5F822F684D180D2172F0D4783C49EF05")
    public void playTogether(Collection<Animator> items) {
        addTaint(items.getTaint());
    if(items != null && items.size() > 0)        
        {
            mNeedsSort = true;
            Builder builder = null;
for(Animator anim : items)
            {
    if(builder == null)                
                {
                    builder = play(anim);
                } //End block
                else
                {
                    builder.with(anim);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (items != null && items.size() > 0) {
            //mNeedsSort = true;
            //Builder builder = null;
            //for (Animator anim : items) {
                //if (builder == null) {
                    //builder = play(anim);
                //} else {
                    //builder.with(anim);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.016 -0400", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "73C1DC006536A7CDF58455175D464E47")
    public void playSequentially(Animator... items) {
        addTaint(items[0].getTaint());
    if(items != null)        
        {
            mNeedsSort = true;
    if(items.length == 1)            
            {
                play(items[0]);
            } //End block
            else
            {
for(int i = 0;i < items.length - 1;++i)
                {
                    play(items[i]).before(items[i+1]);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (items != null) {
            //mNeedsSort = true;
            //if (items.length == 1) {
                //play(items[0]);
            //} else {
                //for (int i = 0; i < items.length - 1; ++i) {
                    //play(items[i]).before(items[i+1]);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.019 -0400", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "71BE700E7897EAD1E9A145DCF60C87DF")
    public void playSequentially(List<Animator> items) {
        addTaint(items.getTaint());
    if(items != null && items.size() > 0)        
        {
            mNeedsSort = true;
    if(items.size() == 1)            
            {
                play(items.get(0));
            } //End block
            else
            {
for(int i = 0;i < items.size() - 1;++i)
                {
                    play(items.get(i)).before(items.get(i+1));
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (items != null && items.size() > 0) {
            //mNeedsSort = true;
            //if (items.size() == 1) {
                //play(items.get(0));
            //} else {
                //for (int i = 0; i < items.size() - 1; ++i) {
                    //play(items.get(i)).before(items.get(i+1));
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.021 -0400", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "84E3A58C2975177A405E0FF22E51CBED")
    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> childList = new ArrayList<Animator>();
for(Node node : mNodes)
        {
            childList.add(node.animation);
        } //End block
ArrayList<Animator> varDADFE646C33414C4DBF274E94AA88940_438241585 =         childList;
        varDADFE646C33414C4DBF274E94AA88940_438241585.addTaint(taint);
        return varDADFE646C33414C4DBF274E94AA88940_438241585;
        // ---------- Original Method ----------
        //ArrayList<Animator> childList = new ArrayList<Animator>();
        //for (Node node : mNodes) {
            //childList.add(node.animation);
        //}
        //return childList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.024 -0400", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "E0DC6D778D499F283FB885385A810433")
    @Override
    public void setTarget(Object target) {
        addTaint(target.getTaint());
for(Node node : mNodes)
        {
            Animator animation = node.animation;
    if(animation instanceof AnimatorSet)            
            {
                ((AnimatorSet)animation).setTarget(target);
            } //End block
            else
    if(animation instanceof ObjectAnimator)            
            {
                ((ObjectAnimator)animation).setTarget(target);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //Animator animation = node.animation;
            //if (animation instanceof AnimatorSet) {
                //((AnimatorSet)animation).setTarget(target);
            //} else if (animation instanceof ObjectAnimator) {
                //((ObjectAnimator)animation).setTarget(target);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.029 -0400", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "07E64E3E75EE44710BA858A1845987D7")
    @Override
    public void setInterpolator(TimeInterpolator interpolator) {
        addTaint(interpolator.getTaint());
for(Node node : mNodes)
        {
            node.animation.setInterpolator(interpolator);
        } //End block
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setInterpolator(interpolator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.033 -0400", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "8FFE5863397238EDBC5D50F81A854402")
    public Builder play(Animator anim) {
        addTaint(anim.getTaint());
    if(anim != null)        
        {
            mNeedsSort = true;
Builder varD0B2F73A29CA6700BDF09D023EBE15EE_1276977567 =             new Builder(anim);
            varD0B2F73A29CA6700BDF09D023EBE15EE_1276977567.addTaint(taint);
            return varD0B2F73A29CA6700BDF09D023EBE15EE_1276977567;
        } //End block
Builder var540C13E9E156B687226421B24F2DF178_625931760 =         null;
        var540C13E9E156B687226421B24F2DF178_625931760.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_625931760;
        // ---------- Original Method ----------
        //if (anim != null) {
            //mNeedsSort = true;
            //return new Builder(anim);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.042 -0400", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "4DC678A190C2A28711AE3ECC83B7A0B8")
    @SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
    if(isStarted())        
        {
            ArrayList<AnimatorListener> tmpListeners = null;
    if(mListeners != null)            
            {
                tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
for(AnimatorListener listener : tmpListeners)
                {
                    listener.onAnimationCancel(this);
                } //End block
            } //End block
    if(mDelayAnim != null && mDelayAnim.isRunning())            
            {
                mDelayAnim.cancel();
            } //End block
            else
    if(mSortedNodes.size() > 0)            
            {
for(Node node : mSortedNodes)
                {
                    node.animation.cancel();
                } //End block
            } //End block
    if(tmpListeners != null)            
            {
for(AnimatorListener listener : tmpListeners)
                {
                    listener.onAnimationEnd(this);
                } //End block
            } //End block
            mStarted = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.048 -0400", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "86686145CD8A4CD12E63ED003730CAF8")
    @Override
    public void end() {
        mTerminated = true;
    if(isStarted())        
        {
    if(mSortedNodes.size() != mNodes.size())            
            {
                sortNodes();
for(Node node : mSortedNodes)
                {
    if(mSetListener == null)                    
                    {
                        mSetListener = new AnimatorSetListener(this);
                    } //End block
                    node.animation.addListener(mSetListener);
                } //End block
            } //End block
    if(mDelayAnim != null)            
            {
                mDelayAnim.cancel();
            } //End block
    if(mSortedNodes.size() > 0)            
            {
for(Node node : mSortedNodes)
                {
                    node.animation.end();
                } //End block
            } //End block
    if(mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
for(AnimatorListener listener : tmpListeners)
                {
                    listener.onAnimationEnd(this);
                } //End block
            } //End block
            mStarted = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.051 -0400", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "B33D751E0475D5026488FF4D048B18D6")
    @Override
    public boolean isRunning() {
for(Node node : mNodes)
        {
    if(node.animation.isRunning())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1530599220 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055308700 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055308700;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1765909906 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682508455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682508455;
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //if (node.animation.isRunning()) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.053 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "AA7ED5172229C6AA5EC857166A175240")
    @Override
    public boolean isStarted() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_581676989 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1505545887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1505545887;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.056 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "3A96AFFC521A3E8568DA624DF6CD662A")
    @Override
    public long getStartDelay() {
        long varD6348B0CF9AA194EA8CCE71E8A2B9F80_542656976 = (mStartDelay);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1177364048 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1177364048;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.062 -0400", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "DFD3698D1A235894B218DEC62F508D58")
    @Override
    public void setStartDelay(long startDelay) {
        mStartDelay = startDelay;
        // ---------- Original Method ----------
        //mStartDelay = startDelay;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.065 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "EDA2552770A5CEF948232498DA83D069")
    @Override
    public long getDuration() {
        long var25395741BFE51A7D136A5C7109AAD2D8_1428430986 = (mDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1436758819 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1436758819;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.069 -0400", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "E8034AD05AC87E7572811F2F0A89CEFD")
    @Override
    public AnimatorSet setDuration(long duration) {
    if(duration < 0)        
        {
            IllegalArgumentException var5300C05DBA8F30F8F7BB04CD2031A57C_346708913 = new IllegalArgumentException("duration must be a value of zero or greater");
            var5300C05DBA8F30F8F7BB04CD2031A57C_346708913.addTaint(taint);
            throw var5300C05DBA8F30F8F7BB04CD2031A57C_346708913;
        } //End block
for(Node node : mNodes)
        {
            node.animation.setDuration(duration);
        } //End block
        mDuration = duration;
AnimatorSet var72A74007B2BE62B849F475C7BDA4658B_2015923374 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2015923374.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2015923374;
        // ---------- Original Method ----------
        //if (duration < 0) {
            //throw new IllegalArgumentException("duration must be a value of zero or greater");
        //}
        //for (Node node : mNodes) {
            //node.animation.setDuration(duration);
        //}
        //mDuration = duration;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.071 -0400", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "238287CB4D3A523C7DB9C9E9D453E70F")
    @Override
    public void setupStartValues() {
for(Node node : mNodes)
        {
            node.animation.setupStartValues();
        } //End block
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupStartValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.072 -0400", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "50E4469033975174D79AE0C046CCB612")
    @Override
    public void setupEndValues() {
for(Node node : mNodes)
        {
            node.animation.setupEndValues();
        } //End block
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupEndValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.100 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "4D821FDE32524527D8A2C8B105C0309F")
    @SuppressWarnings("unchecked")
    @Override
    public void start() {
        mTerminated = false;
        mStarted = true;
        sortNodes();
        int numSortedNodes = mSortedNodes.size();
for(int i = 0;i < numSortedNodes;++i)
        {
            Node node = mSortedNodes.get(i);
            ArrayList<AnimatorListener> oldListeners = node.animation.getListeners();
    if(oldListeners != null && oldListeners.size() > 0)            
            {
                final ArrayList<AnimatorListener> clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
for(AnimatorListener listener : clonedListeners)
                {
    if(listener instanceof DependencyListener ||
                            listener instanceof AnimatorSetListener)                    
                    {
                        node.animation.removeListener(listener);
                    } //End block
                } //End block
            } //End block
        } //End block
        final ArrayList<Node> nodesToStart = new ArrayList<Node>();
for(int i = 0;i < numSortedNodes;++i)
        {
            Node node = mSortedNodes.get(i);
    if(mSetListener == null)            
            {
                mSetListener = new AnimatorSetListener(this);
            } //End block
    if(node.dependencies == null || node.dependencies.size() == 0)            
            {
                nodesToStart.add(node);
            } //End block
            else
            {
                int numDependencies = node.dependencies.size();
for(int j = 0;j < numDependencies;++j)
                {
                    Dependency dependency = node.dependencies.get(j);
                    dependency.node.animation.addListener(
                            new DependencyListener(this, node, dependency.rule));
                } //End block
                node.tmpDependencies = (ArrayList<Dependency>) node.dependencies.clone();
            } //End block
            node.animation.addListener(mSetListener);
        } //End block
    if(mStartDelay <= 0)        
        {
for(Node node : nodesToStart)
            {
                node.animation.start();
                mPlayingSet.add(node.animation);
            } //End block
        } //End block
        else
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.096 -0400", hash_original_field = "990982D89CFB60D5939A88FB81C4FE88", hash_generated_field = "41402EB62AB9E9D5CBE01FDA6E9433EB")
        boolean canceled = false;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.097 -0400", hash_original_method = "BE87F1813CBA8EA740D5C2234F834512", hash_generated_method = "EA8E6D839DDAAE296AD06F3B683EC7FB")
        public void onAnimationCancel(Animator anim) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(anim.getTaint());
            canceled = true;
            // ---------- Original Method ----------
            //canceled = true;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.098 -0400", hash_original_method = "445AE985C63B218AFF9EAABB75FAC581", hash_generated_method = "3F1FC494E71441DC5827B8EAC06D3923")
        public void onAnimationEnd(Animator anim) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(anim.getTaint());
    if(!canceled)            
            {
                int numNodes = nodesToStart.size();
for(int i = 0;i < numNodes;++i)
                {
                    Node node = nodesToStart.get(i);
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (!canceled) {
                        //int numNodes = nodesToStart.size();
                        //for (int i = 0; i < numNodes; ++i) {
                            //Node node = nodesToStart.get(i);
                            //node.animation.start();
                            //mPlayingSet.add(node.animation);
                        //}
                    //}
        }
});
            mDelayAnim.start();
        } //End block
    if(mListeners != null)        
        {
            ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
            {
                tmpListeners.get(i).onAnimationStart(this);
            } //End block
        } //End block
    if(mNodes.size() == 0 && mStartDelay == 0)        
        {
            mStarted = false;
    if(mListeners != null)            
            {
                ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
                {
                    tmpListeners.get(i).onAnimationEnd(this);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.111 -0400", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "73599E7F10B2BABE29882010CCF970B4")
    @Override
    public AnimatorSet clone() {
        final AnimatorSet anim = (AnimatorSet) super.clone();
        anim.mNeedsSort = true;
        anim.mTerminated = false;
        anim.mStarted = false;
        anim.mPlayingSet = new ArrayList<Animator>();
        anim.mNodeMap = new HashMap<Animator, Node>();
        anim.mNodes = new ArrayList<Node>();
        anim.mSortedNodes = new ArrayList<Node>();
        HashMap<Node, Node> nodeCloneMap = new HashMap<Node, Node>();
for(Node node : mNodes)
        {
            Node nodeClone = node.clone();
            nodeCloneMap.put(node, nodeClone);
            anim.mNodes.add(nodeClone);
            anim.mNodeMap.put(nodeClone.animation, nodeClone);
            nodeClone.dependencies = null;
            nodeClone.tmpDependencies = null;
            nodeClone.nodeDependents = null;
            nodeClone.nodeDependencies = null;
            ArrayList<AnimatorListener> cloneListeners = nodeClone.animation.getListeners();
    if(cloneListeners != null)            
            {
                ArrayList<AnimatorListener> listenersToRemove = null;
for(AnimatorListener listener : cloneListeners)
                {
    if(listener instanceof AnimatorSetListener)                    
                    {
    if(listenersToRemove == null)                        
                        {
                            listenersToRemove = new ArrayList<AnimatorListener>();
                        } //End block
                        listenersToRemove.add(listener);
                    } //End block
                } //End block
    if(listenersToRemove != null)                
                {
for(AnimatorListener listener : listenersToRemove)
                    {
                        cloneListeners.remove(listener);
                    } //End block
                } //End block
            } //End block
        } //End block
for(Node node : mNodes)
        {
            Node nodeClone = nodeCloneMap.get(node);
    if(node.dependencies != null)            
            {
for(Dependency dependency : node.dependencies)
                {
                    Node clonedDependencyNode = nodeCloneMap.get(dependency.node);
                    Dependency cloneDependency = new Dependency(clonedDependencyNode,
                            dependency.rule);
                    nodeClone.addDependency(cloneDependency);
                } //End block
            } //End block
        } //End block
AnimatorSet var6E2178F33F884BED37C5DEBCD18F9A96_1759729129 =         anim;
        var6E2178F33F884BED37C5DEBCD18F9A96_1759729129.addTaint(taint);
        return var6E2178F33F884BED37C5DEBCD18F9A96_1759729129;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.120 -0400", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "E6FEA6B1372EAC16364385F769BDCB64")
    private void sortNodes() {
    if(mNeedsSort)        
        {
            mSortedNodes.clear();
            ArrayList<Node> roots = new ArrayList<Node>();
            int numNodes = mNodes.size();
for(int i = 0;i < numNodes;++i)
            {
                Node node = mNodes.get(i);
    if(node.dependencies == null || node.dependencies.size() == 0)                
                {
                    roots.add(node);
                } //End block
            } //End block
            ArrayList<Node> tmpRoots = new ArrayList<Node>();
            while
(roots.size() > 0)            
            {
                int numRoots = roots.size();
for(int i = 0;i < numRoots;++i)
                {
                    Node root = roots.get(i);
                    mSortedNodes.add(root);
    if(root.nodeDependents != null)                    
                    {
                        int numDependents = root.nodeDependents.size();
for(int j = 0;j < numDependents;++j)
                        {
                            Node node = root.nodeDependents.get(j);
                            node.nodeDependencies.remove(root);
    if(node.nodeDependencies.size() == 0)                            
                            {
                                tmpRoots.add(node);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                roots.clear();
                roots.addAll(tmpRoots);
                tmpRoots.clear();
            } //End block
            mNeedsSort = false;
    if(mSortedNodes.size() != mNodes.size())            
            {
                IllegalStateException var262329B5D3EB6C270EBEF48A24CB8EF9_1238578539 = new IllegalStateException("Circular dependencies cannot exist"
                        + " in AnimatorSet");
                var262329B5D3EB6C270EBEF48A24CB8EF9_1238578539.addTaint(taint);
                throw var262329B5D3EB6C270EBEF48A24CB8EF9_1238578539;
            } //End block
        } //End block
        else
        {
            int numNodes = mNodes.size();
for(int i = 0;i < numNodes;++i)
            {
                Node node = mNodes.get(i);
    if(node.dependencies != null && node.dependencies.size() > 0)                
                {
                    int numDependencies = node.dependencies.size();
for(int j = 0;j < numDependencies;++j)
                    {
                        Dependency dependency = node.dependencies.get(j);
    if(node.nodeDependencies == null)                        
                        {
                            node.nodeDependencies = new ArrayList<Node>();
                        } //End block
    if(!node.nodeDependencies.contains(dependency.node))                        
                        {
                            node.nodeDependencies.add(dependency.node);
                        } //End block
                    } //End block
                } //End block
                node.done = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DependencyListener implements AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.124 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.124 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "298BE469E9769EF16537BF922B91FDA5")

        private Node mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.125 -0400", hash_original_field = "C29D48DB82CAC5F7D6125EB9E5BDD4B3", hash_generated_field = "F35AEC1D0C05BC027541025D8E7C024E")

        private int mRule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.128 -0400", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "2CEF4FD9DA42A82DAEC47138680208B3")
        public  DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = rule;
            // ---------- Original Method ----------
            //this.mAnimatorSet = animatorSet;
            //this.mNode = node;
            //this.mRule = rule;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.129 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "C2873E3A5F96230B9841E1221FD8122E")
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.132 -0400", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "0DD90CFF71BA1F067EEB5B3B01665D39")
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mRule == Dependency.AFTER)            
            {
                startIfReady(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mRule == Dependency.AFTER) {
                //startIfReady(animation);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.138 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.142 -0400", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "5113DE5D5EBE4848556F7CCA7A0815C5")
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(mRule == Dependency.WITH)            
            {
                startIfReady(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mRule == Dependency.WITH) {
                //startIfReady(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.146 -0400", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "AEFB16E18AD97431E69DBCE15B364897")
        private void startIfReady(Animator dependencyAnimation) {
            addTaint(dependencyAnimation.getTaint());
    if(mAnimatorSet.mTerminated)            
            {
                return;
            } //End block
            Dependency dependencyToRemove = null;
            int numDependencies = mNode.tmpDependencies.size();
for(int i = 0;i < numDependencies;++i)
            {
                Dependency dependency = mNode.tmpDependencies.get(i);
    if(dependency.rule == mRule &&
                        dependency.node.animation == dependencyAnimation)                
                {
                    dependencyToRemove = dependency;
                    dependencyAnimation.removeListener(this);
                    break;
                } //End block
            } //End block
            mNode.tmpDependencies.remove(dependencyToRemove);
    if(mNode.tmpDependencies.size() == 0)            
            {
                mNode.animation.start();
                mAnimatorSet.mPlayingSet.add(mNode.animation);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class AnimatorSetListener implements AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.148 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.149 -0400", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "5149E3B3F385A46C24F32667B339D036")
          AnimatorSetListener(AnimatorSet animatorSet) {
            mAnimatorSet = animatorSet;
            // ---------- Original Method ----------
            //mAnimatorSet = animatorSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.150 -0400", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "DFAD45D548A2BD004BF93B85F83DA755")
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
    if(!mTerminated)            
            {
    if(mPlayingSet.size() == 0)                
                {
    if(mListeners != null)                    
                    {
                        int numListeners = mListeners.size();
for(int i = 0;i < numListeners;++i)
                        {
                            mListeners.get(i).onAnimationCancel(mAnimatorSet);
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (!mTerminated) {
                //if (mPlayingSet.size() == 0) {
                    //if (mListeners != null) {
                        //int numListeners = mListeners.size();
                        //for (int i = 0; i < numListeners; ++i) {
                            //mListeners.get(i).onAnimationCancel(mAnimatorSet);
                        //}
                    //}
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.154 -0400", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "C06CE48BB5BB01F584E3BBFE004D298A")
        @SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            animation.removeListener(this);
            mPlayingSet.remove(animation);
            Node animNode = mAnimatorSet.mNodeMap.get(animation);
            animNode.done = true;
    if(!mTerminated)            
            {
                ArrayList<Node> sortedNodes = mAnimatorSet.mSortedNodes;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
for(int i = 0;i < numSortedNodes;++i)
                {
    if(!sortedNodes.get(i).done)                    
                    {
                        allDone = false;
                        break;
                    } //End block
                } //End block
    if(allDone)                
                {
    if(mListeners != null)                    
                    {
                        ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                        int numListeners = tmpListeners.size();
for(int i = 0;i < numListeners;++i)
                        {
                            tmpListeners.get(i).onAnimationEnd(mAnimatorSet);
                        } //End block
                    } //End block
                    mAnimatorSet.mStarted = false;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.156 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.158 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "4F1E500BA39728FB7A49E02540A0C5AA")
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Dependency {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.162 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "220314E1B8A64C8F8406491E2C312A28")

        public Node node;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.163 -0400", hash_original_field = "981C1E7B3795DA18687613FBD66D4954", hash_generated_field = "5BCB5D76D9FE8D00C97FD248D276BEFB")

        public int rule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.167 -0400", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "11E9E1642757F63DD999DD0DC47CC81E")
        public  Dependency(Node node, int rule) {
            this.node = node;
            this.rule = rule;
            // ---------- Original Method ----------
            //this.node = node;
            //this.rule = rule;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.168 -0400", hash_original_field = "1334D2D6495806F754F66024F08499AE", hash_generated_field = "D2E63A1F901C713BA822C6F070CEAD0C")

        static final int WITH = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.169 -0400", hash_original_field = "DA0977069E1F00C63DBCD6472D3A83BD", hash_generated_field = "B2EDF4A77A9D7AC10EE81BB78B2A3B97")

        static final int AFTER = 1;
    }


    
    private static class Node implements Cloneable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.170 -0400", hash_original_field = "6F1C25ED1523962F1BBF9DEE9BE5092B", hash_generated_field = "85D1EE31923D44CB9D3110ADDD29D65D")

        public Animator animation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.171 -0400", hash_original_field = "3341DF3F2BE5741254627C20B0B01F51", hash_generated_field = "46C94882CA4285AE3FB52FBE346AC349")

        public ArrayList<Dependency> dependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.171 -0400", hash_original_field = "200E0333937676F14E2E34EDC6377C4C", hash_generated_field = "B8C6459C87326A52248B3A69C1AD5ACC")

        public ArrayList<Dependency> tmpDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.172 -0400", hash_original_field = "47751C8F1D02529930E31B5653CEA54A", hash_generated_field = "4B254F155DE5D18E0880E4E9DEF81A08")

        public ArrayList<Node> nodeDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.173 -0400", hash_original_field = "974D2A11D6D39C71254A79C0E7E4343C", hash_generated_field = "D83CBAAD32ACD2DF620D72FD4EEEA1F1")

        public ArrayList<Node> nodeDependents = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.174 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "3C1F0C530EFFEA18D19D1DCE04D244D2")

        public boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.177 -0400", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "C7E970336EB0D2C23CBE821EB59549EA")
        public  Node(Animator animation) {
            this.animation = animation;
            // ---------- Original Method ----------
            //this.animation = animation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.180 -0400", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "5ADFC5C40A7DFA7E303BA28F7508D5AC")
        public void addDependency(Dependency dependency) {
            addTaint(dependency.getTaint());
    if(dependencies == null)            
            {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            } //End block
            dependencies.add(dependency);
    if(!nodeDependencies.contains(dependency.node))            
            {
                nodeDependencies.add(dependency.node);
            } //End block
            Node dependencyNode = dependency.node;
    if(dependencyNode.nodeDependents == null)            
            {
                dependencyNode.nodeDependents = new ArrayList<Node>();
            } //End block
            dependencyNode.nodeDependents.add(this);
            // ---------- Original Method ----------
            //if (dependencies == null) {
                //dependencies = new ArrayList<Dependency>();
                //nodeDependencies = new ArrayList<Node>();
            //}
            //dependencies.add(dependency);
            //if (!nodeDependencies.contains(dependency.node)) {
                //nodeDependencies.add(dependency.node);
            //}
            //Node dependencyNode = dependency.node;
            //if (dependencyNode.nodeDependents == null) {
                //dependencyNode.nodeDependents = new ArrayList<Node>();
            //}
            //dependencyNode.nodeDependents.add(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.184 -0400", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "166FB69F42B70950D6FBBE2BE6E95336")
        @Override
        public Node clone() {
            try 
            {
                Node node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
Node var1924C94B76524D1C3D7310EA17B0EF94_1365417166 =                 node;
                var1924C94B76524D1C3D7310EA17B0EF94_1365417166.addTaint(taint);
                return var1924C94B76524D1C3D7310EA17B0EF94_1365417166;
            } //End block
            catch (CloneNotSupportedException e)
            {
                AssertionError varA81442E36297E737EB908877E58260E8_2067619309 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_2067619309.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_2067619309;
            } //End block
            // ---------- Original Method ----------
            //try {
                //Node node = (Node) super.clone();
                //node.animation = (Animator) animation.clone();
                //return node;
            //} catch (CloneNotSupportedException e) {
               //throw new AssertionError();
            //}
        }

        
    }


    
    public class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.186 -0400", hash_original_field = "804B3EF3A920EEBB8C5E4C902948FD7E", hash_generated_field = "A3A3172265405E9566BFFCC4660589E1")

        private Node mCurrentNode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.188 -0400", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "865F4ADA611B22E99402EC52F457EC73")
          Builder(Animator anim) {
            mCurrentNode = mNodeMap.get(anim);
    if(mCurrentNode == null)            
            {
                mCurrentNode = new Node(anim);
                mNodeMap.put(anim, mCurrentNode);
                mNodes.add(mCurrentNode);
            } //End block
            // ---------- Original Method ----------
            //mCurrentNode = mNodeMap.get(anim);
            //if (mCurrentNode == null) {
                //mCurrentNode = new Node(anim);
                //mNodeMap.put(anim, mCurrentNode);
                //mNodes.add(mCurrentNode);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.190 -0400", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "5F3F726645776688976ED7DC3F62DA2A")
        public Builder with(Animator anim) {
            addTaint(anim.getTaint());
            Node node = mNodeMap.get(anim);
    if(node == null)            
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency = new Dependency(mCurrentNode, Dependency.WITH);
            node.addDependency(dependency);
Builder var72A74007B2BE62B849F475C7BDA4658B_369905869 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_369905869.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_369905869;
            // ---------- Original Method ----------
            //Node node = mNodeMap.get(anim);
            //if (node == null) {
                //node = new Node(anim);
                //mNodeMap.put(anim, node);
                //mNodes.add(node);
            //}
            //Dependency dependency = new Dependency(mCurrentNode, Dependency.WITH);
            //node.addDependency(dependency);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.193 -0400", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "49FD93FEC6F4E612AF725E174F1AAEA2")
        public Builder before(Animator anim) {
            addTaint(anim.getTaint());
            Node node = mNodeMap.get(anim);
    if(node == null)            
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency = new Dependency(mCurrentNode, Dependency.AFTER);
            node.addDependency(dependency);
Builder var72A74007B2BE62B849F475C7BDA4658B_1236901208 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1236901208.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1236901208;
            // ---------- Original Method ----------
            //Node node = mNodeMap.get(anim);
            //if (node == null) {
                //node = new Node(anim);
                //mNodeMap.put(anim, node);
                //mNodes.add(node);
            //}
            //Dependency dependency = new Dependency(mCurrentNode, Dependency.AFTER);
            //node.addDependency(dependency);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.197 -0400", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "961A1292B8B8E8E35834A8B919635370")
        public Builder after(Animator anim) {
            addTaint(anim.getTaint());
            Node node = mNodeMap.get(anim);
    if(node == null)            
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency = new Dependency(node, Dependency.AFTER);
            mCurrentNode.addDependency(dependency);
Builder var72A74007B2BE62B849F475C7BDA4658B_175612213 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_175612213.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_175612213;
            // ---------- Original Method ----------
            //Node node = mNodeMap.get(anim);
            //if (node == null) {
                //node = new Node(anim);
                //mNodeMap.put(anim, node);
                //mNodes.add(node);
            //}
            //Dependency dependency = new Dependency(node, Dependency.AFTER);
            //mCurrentNode.addDependency(dependency);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:33.198 -0400", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "E8EB16D555FF82530E7EAAFFDA63CBD8")
        public Builder after(long delay) {
            addTaint(delay);
            ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            anim.setDuration(delay);
            after(anim);
Builder var72A74007B2BE62B849F475C7BDA4658B_1810381298 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1810381298.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1810381298;
            // ---------- Original Method ----------
            //ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            //anim.setDuration(delay);
            //after(anim);
            //return this;
        }

        
    }


    
}

