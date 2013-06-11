package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class AnimatorSet extends Animator {
    private ArrayList<Animator> mPlayingSet = new ArrayList<Animator>();
    private HashMap<Animator, Node> mNodeMap = new HashMap<Animator, Node>();
    private ArrayList<Node> mNodes = new ArrayList<Node>();
    private ArrayList<Node> mSortedNodes = new ArrayList<Node>();
    private boolean mNeedsSort = true;
    private AnimatorSetListener mSetListener = null;
    boolean mTerminated = false;
    private boolean mStarted = false;
    private long mStartDelay = 0;
    private ValueAnimator mDelayAnim = null;
    private long mDuration = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.983 -0400", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "B11B272EF6341CC8F2B20D47F98B5746")
    @DSModeled(DSC.SAFE)
    public void playTogether(Animator... items) {
        dsTaint.addTaint(items.dsTaint);
        {
            mNeedsSort = true;
            Builder builder;
            builder = play(items[0]);
            {
                int i;
                i = 1;
                {
                    builder.with(items[i]);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.984 -0400", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "67E2BBF66713244DDF90C26B9C7AADFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playTogether(Collection<Animator> items) {
        dsTaint.addTaint(items.dsTaint);
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1972300274 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                Builder builder;
                builder = null;
                {
                    Iterator<Animator> seatecAstronomy42 = items.iterator();
                    seatecAstronomy42.hasNext();
                    Animator anim = seatecAstronomy42.next();
                    {
                        {
                            builder = play(anim);
                        } //End block
                        {
                            builder.with(anim);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.986 -0400", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "BC273572FD6E3CCDF75A398FB10E7548")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSequentially(Animator... items) {
        dsTaint.addTaint(items.dsTaint);
        {
            mNeedsSort = true;
            {
                play(items[0]);
            } //End block
            {
                {
                    int i;
                    i = 0;
                    {
                        play(items[i]).before(items[i+1]);
                    } //End block
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.987 -0400", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "B98AD4B12A2F94D0D31BE0F5D755D030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSequentially(List<Animator> items) {
        dsTaint.addTaint(items.dsTaint);
        {
            boolean varDBDD00862D2499954D5577669FA506EB_894649787 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                {
                    boolean var3DA64BAE48B6A767AE46B5F34638725F_989593683 = (items.size() == 1);
                    {
                        play(items.get(0));
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            boolean var3F263A3674EDCC9514BA7F671DBD0DE6_1787967548 = (i < items.size() - 1);
                            {
                                play(items.get(i)).before(items.get(i+1));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.988 -0400", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "95B9BB1401DF0F2A26BB9487E63DBF40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> childList;
        childList = new ArrayList<Animator>();
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                childList.add(node.animation);
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<Animator>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Animator> childList = new ArrayList<Animator>();
        //for (Node node : mNodes) {
            //childList.add(node.animation);
        //}
        //return childList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.989 -0400", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "96F9508441E2951B0DF9A4AD74BF8CD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTarget(Object target) {
        dsTaint.addTaint(target.dsTaint);
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                Animator animation;
                animation = node.animation;
                {
                    ((AnimatorSet)animation).setTarget(target);
                } //End block
                {
                    ((ObjectAnimator)animation).setTarget(target);
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.990 -0400", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "E7A679A2673443BCADDCA4E68843040B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setInterpolator(TimeInterpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                node.animation.setInterpolator(interpolator);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setInterpolator(interpolator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.990 -0400", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "2CC296B0B723A82210FD8B50ADCA23FB")
    @DSModeled(DSC.SAFE)
    public Builder play(Animator anim) {
        dsTaint.addTaint(anim.dsTaint);
        {
            mNeedsSort = true;
        } //End block
        return (Builder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (anim != null) {
            //mNeedsSort = true;
            //return new Builder(anim);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.992 -0400", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "C9E1C6F74B309C73F5053E335B8FF7F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_278238575 = (isStarted());
            {
                ArrayList<AnimatorListener> tmpListeners;
                tmpListeners = null;
                {
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> seatecAstronomy42 = tmpListeners.iterator();
                        seatecAstronomy42.hasNext();
                        AnimatorListener listener = seatecAstronomy42.next();
                        {
                            listener.onAnimationCancel(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8BB2BFDAD6968BF48372B4777D136D94_1411467021 = (mDelayAnim != null && mDelayAnim.isRunning());
                    {
                        mDelayAnim.cancel();
                    } //End block
                    {
                        boolean varC7AADD45FD9F54D7C7758EDE2DB4AB5A_1796741016 = (mSortedNodes.size() > 0);
                        {
                            {
                                Iterator<Node> seatecAstronomy42 = mSortedNodes.iterator();
                                seatecAstronomy42.hasNext();
                                Node node = seatecAstronomy42.next();
                                {
                                    node.animation.cancel();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    {
                        Iterator<AnimatorListener> seatecAstronomy42 = tmpListeners.iterator();
                        seatecAstronomy42.hasNext();
                        AnimatorListener listener = seatecAstronomy42.next();
                        {
                            listener.onAnimationEnd(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                mStarted = false;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.995 -0400", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "283E1C8D2860D683884D8D9698089F6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void end() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_461671084 = (isStarted());
            {
                {
                    boolean var7320623FD878E3DC8E3103403DCBB72C_562785397 = (mSortedNodes.size() != mNodes.size());
                    {
                        sortNodes();
                        {
                            Iterator<Node> seatecAstronomy42 = mSortedNodes.iterator();
                            seatecAstronomy42.hasNext();
                            Node node = seatecAstronomy42.next();
                            {
                                {
                                    mSetListener = new AnimatorSetListener(this);
                                } //End block
                                node.animation.addListener(mSetListener);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    mDelayAnim.cancel();
                } //End block
                {
                    boolean var230EE46EC79704D29C8FEAB7F43E06E4_118575930 = (mSortedNodes.size() > 0);
                    {
                        {
                            Iterator<Node> seatecAstronomy42 = mSortedNodes.iterator();
                            seatecAstronomy42.hasNext();
                            Node node = seatecAstronomy42.next();
                            {
                                node.animation.end();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> seatecAstronomy42 = tmpListeners.iterator();
                        seatecAstronomy42.hasNext();
                        AnimatorListener listener = seatecAstronomy42.next();
                        {
                            listener.onAnimationEnd(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                mStarted = false;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.996 -0400", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "CA5936A55F11ED84B780C0B890023BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isRunning() {
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                {
                    boolean varC93073F2E0F049EE49B3906C3BBE89FD_689077253 = (node.animation.isRunning());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //if (node.animation.isRunning()) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.997 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "2F12445662AB59FE001C808F3C1B9BF9")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.998 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "71353F1241FB5D4BC8E82F6E3D1A43D7")
    @DSModeled(DSC.SAFE)
    @Override
    public long getStartDelay() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.998 -0400", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "D4485077D6DA7F7A8D8E20F7217E1214")
    @DSModeled(DSC.SAFE)
    @Override
    public void setStartDelay(long startDelay) {
        dsTaint.addTaint(startDelay);
        // ---------- Original Method ----------
        //mStartDelay = startDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.999 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "E0832288BBA15F1185CF0720EFEEA98F")
    @DSModeled(DSC.SAFE)
    @Override
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.000 -0400", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "36374C561C9FE95D5FCFF76BA5156C55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AnimatorSet setDuration(long duration) {
        dsTaint.addTaint(duration);
        {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        } //End block
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                node.animation.setDuration(duration);
            } //End block
        } //End collapsed parenthetic
        return (AnimatorSet)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.000 -0400", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "5F1264BE7B770B51E63B01B14F07A751")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setupStartValues() {
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                node.animation.setupStartValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupStartValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.001 -0400", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "ABC6CA1A878D636F0952E807FC37D83E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setupEndValues() {
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                node.animation.setupEndValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupEndValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.005 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "FE8B5C91B3CD9715EE926032D2504FF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public void start() {
        mTerminated = false;
        mStarted = true;
        sortNodes();
        int numSortedNodes;
        numSortedNodes = mSortedNodes.size();
        {
            int i;
            i = 0;
            {
                Node node;
                node = mSortedNodes.get(i);
                ArrayList<AnimatorListener> oldListeners;
                oldListeners = node.animation.getListeners();
                {
                    boolean var9ACEE8033582BBDB9B4CB98E4081BA91_1686742458 = (oldListeners != null && oldListeners.size() > 0);
                    {
                        final ArrayList<AnimatorListener> clonedListeners;
                        clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
                        {
                            Iterator<AnimatorListener> seatecAstronomy42 = clonedListeners.iterator();
                            seatecAstronomy42.hasNext();
                            AnimatorListener listener = seatecAstronomy42.next();
                            {
                                {
                                    node.animation.removeListener(listener);
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        final ArrayList<Node> nodesToStart;
        nodesToStart = new ArrayList<Node>();
        {
            int i;
            i = 0;
            {
                Node node;
                node = mSortedNodes.get(i);
                {
                    mSetListener = new AnimatorSetListener(this);
                } //End block
                {
                    boolean varE407B8E8668F490B90923B90830F3953_1192038502 = (node.dependencies == null || node.dependencies.size() == 0);
                    {
                        nodesToStart.add(node);
                    } //End block
                    {
                        int numDependencies;
                        numDependencies = node.dependencies.size();
                        {
                            int j;
                            j = 0;
                            {
                                Dependency dependency;
                                dependency = node.dependencies.get(j);
                                dependency.node.animation.addListener(
                            new DependencyListener(this, node, dependency.rule));
                            } //End block
                        } //End collapsed parenthetic
                        node.tmpDependencies = (ArrayList<Dependency>) node.dependencies.clone();
                    } //End block
                } //End collapsed parenthetic
                node.animation.addListener(mSetListener);
            } //End block
        } //End collapsed parenthetic
        {
            {
                Iterator<Node> seatecAstronomy42 = nodesToStart.iterator();
                seatecAstronomy42.hasNext();
                Node node = seatecAstronomy42.next();
                {
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {
                boolean canceled = false;
                public void onAnimationCancel(Animator anim) {
                    canceled = true;
                }
                public void onAnimationEnd(Animator anim) {
                    if (!canceled) {
                        int numNodes = nodesToStart.size();
                        for (int i = 0; i < numNodes; ++i) {
                            Node node = nodesToStart.get(i);
                            node.animation.start();
                            mPlayingSet.add(node.animation);
                        }
                    }
                }
            });
            mDelayAnim.start();
        } //End block
        {
            ArrayList<AnimatorListener> tmpListeners;
            tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
            int numListeners;
            numListeners = tmpListeners.size();
            {
                int i;
                i = 0;
                {
                    tmpListeners.get(i).onAnimationStart(this);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varE5C319B3E9148866563870C4DF81C81D_1001827701 = (mNodes.size() == 0 && mStartDelay == 0);
            {
                mStarted = false;
                {
                    ArrayList<AnimatorListener> tmpListeners;
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    int numListeners;
                    numListeners = tmpListeners.size();
                    {
                        int i;
                        i = 0;
                        {
                            tmpListeners.get(i).onAnimationEnd(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.009 -0400", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "D239AAB8BAD980037CAC3647A2E4B783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AnimatorSet clone() {
        final AnimatorSet anim;
        anim = (AnimatorSet) super.clone();
        anim.mNeedsSort = true;
        anim.mTerminated = false;
        anim.mStarted = false;
        anim.mPlayingSet = new ArrayList<Animator>();
        anim.mNodeMap = new HashMap<Animator, Node>();
        anim.mNodes = new ArrayList<Node>();
        anim.mSortedNodes = new ArrayList<Node>();
        HashMap<Node, Node> nodeCloneMap;
        nodeCloneMap = new HashMap<Node, Node>();
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                Node nodeClone;
                nodeClone = node.clone();
                nodeCloneMap.put(node, nodeClone);
                anim.mNodes.add(nodeClone);
                anim.mNodeMap.put(nodeClone.animation, nodeClone);
                nodeClone.dependencies = null;
                nodeClone.tmpDependencies = null;
                nodeClone.nodeDependents = null;
                nodeClone.nodeDependencies = null;
                ArrayList<AnimatorListener> cloneListeners;
                cloneListeners = nodeClone.animation.getListeners();
                {
                    ArrayList<AnimatorListener> listenersToRemove;
                    listenersToRemove = null;
                    {
                        Iterator<AnimatorListener> seatecAstronomy42 = cloneListeners.iterator();
                        seatecAstronomy42.hasNext();
                        AnimatorListener listener = seatecAstronomy42.next();
                        {
                            {
                                {
                                    listenersToRemove = new ArrayList<AnimatorListener>();
                                } //End block
                                listenersToRemove.add(listener);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        {
                            Iterator<AnimatorListener> seatecAstronomy42 = listenersToRemove.iterator();
                            seatecAstronomy42.hasNext();
                            AnimatorListener listener = seatecAstronomy42.next();
                            {
                                cloneListeners.remove(listener);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<Node> seatecAstronomy42 = mNodes.iterator();
            seatecAstronomy42.hasNext();
            Node node = seatecAstronomy42.next();
            {
                Node nodeClone;
                nodeClone = nodeCloneMap.get(node);
                {
                    {
                        Iterator<Dependency> seatecAstronomy42 = node.dependencies.iterator();
                        seatecAstronomy42.hasNext();
                        Dependency dependency = seatecAstronomy42.next();
                        {
                            Node clonedDependencyNode;
                            clonedDependencyNode = nodeCloneMap.get(dependency.node);
                            Dependency cloneDependency;
                            cloneDependency = new Dependency(clonedDependencyNode,
                            dependency.rule);
                            nodeClone.addDependency(cloneDependency);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (AnimatorSet)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.014 -0400", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "7FB5C8F6736CFD4001097C10C4CF1509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sortNodes() {
        {
            mSortedNodes.clear();
            ArrayList<Node> roots;
            roots = new ArrayList<Node>();
            int numNodes;
            numNodes = mNodes.size();
            {
                int i;
                i = 0;
                {
                    Node node;
                    node = mNodes.get(i);
                    {
                        boolean var0D1480BBE27A084BABF64DD1A6FC3773_1765159380 = (node.dependencies == null || node.dependencies.size() == 0);
                        {
                            roots.add(node);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ArrayList<Node> tmpRoots;
            tmpRoots = new ArrayList<Node>();
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_1288305779 = (roots.size() > 0);
                {
                    int numRoots;
                    numRoots = roots.size();
                    {
                        int i;
                        i = 0;
                        {
                            Node root;
                            root = roots.get(i);
                            mSortedNodes.add(root);
                            {
                                int numDependents;
                                numDependents = root.nodeDependents.size();
                                {
                                    int j;
                                    j = 0;
                                    {
                                        Node node;
                                        node = root.nodeDependents.get(j);
                                        node.nodeDependencies.remove(root);
                                        {
                                            boolean var21891AE5AAFE8EB96113B08DED5B940C_1773679376 = (node.nodeDependencies.size() == 0);
                                            {
                                                tmpRoots.add(node);
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    roots.clear();
                    roots.addAll(tmpRoots);
                    tmpRoots.clear();
                } //End block
            } //End collapsed parenthetic
            mNeedsSort = false;
            {
                boolean varDD5278C4A821B04466EA81991E002294_104196258 = (mSortedNodes.size() != mNodes.size());
                {
                    throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in AnimatorSet");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int numNodes;
            numNodes = mNodes.size();
            {
                int i;
                i = 0;
                {
                    Node node;
                    node = mNodes.get(i);
                    {
                        boolean var60187AACFF822DE3E56322B4A4D489FB_1911988424 = (node.dependencies != null && node.dependencies.size() > 0);
                        {
                            int numDependencies;
                            numDependencies = node.dependencies.size();
                            {
                                int j;
                                j = 0;
                                {
                                    Dependency dependency;
                                    dependency = node.dependencies.get(j);
                                    {
                                        node.nodeDependencies = new ArrayList<Node>();
                                    } //End block
                                    {
                                        boolean varF4A971F3E1E7ED2E8AD23CBB7EC95189_662555720 = (!node.nodeDependencies.contains(dependency.node));
                                        {
                                            node.nodeDependencies.add(dependency.node);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    node.done = false;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class DependencyListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.015 -0400", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "AD525E2B736B5DF43693156DB205DCB5")
        @DSModeled(DSC.SAFE)
        public DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            dsTaint.addTaint(node.dsTaint);
            dsTaint.addTaint(rule);
            dsTaint.addTaint(animatorSet.dsTaint);
            // ---------- Original Method ----------
            //this.mAnimatorSet = animatorSet;
            //this.mNode = node;
            //this.mRule = rule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.016 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "43AC1A14C8F454B4E6E99E8529E9BEAA")
        @DSModeled(DSC.SAFE)
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.017 -0400", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "CBE12733FB25DFE649FC92766A48B56A")
        @DSModeled(DSC.SAFE)
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                startIfReady(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mRule == Dependency.AFTER) {
                //startIfReady(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.018 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "8A5F13005333A2C85BED28A03CD6C3D0")
        @DSModeled(DSC.SAFE)
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.019 -0400", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "D9FC4D97CB6FDEFD6F3015E686B95440")
        @DSModeled(DSC.SAFE)
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                startIfReady(animation);
            } //End block
            // ---------- Original Method ----------
            //if (mRule == Dependency.WITH) {
                //startIfReady(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.020 -0400", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "DB351C820C5C341AB38D11A9B8DFB44A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void startIfReady(Animator dependencyAnimation) {
            dsTaint.addTaint(dependencyAnimation.dsTaint);
            Dependency dependencyToRemove;
            dependencyToRemove = null;
            int numDependencies;
            numDependencies = mNode.tmpDependencies.size();
            {
                int i;
                i = 0;
                {
                    Dependency dependency;
                    dependency = mNode.tmpDependencies.get(i);
                    {
                        dependencyToRemove = dependency;
                        dependencyAnimation.removeListener(this);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mNode.tmpDependencies.remove(dependencyToRemove);
            {
                boolean var87E4D5B3F0E82C7E3E2C2DE17D172229_563583163 = (mNode.tmpDependencies.size() == 0);
                {
                    mNode.animation.start();
                    mAnimatorSet.mPlayingSet.add(mNode.animation);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class AnimatorSetListener implements AnimatorListener {
        private AnimatorSet mAnimatorSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.021 -0400", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "C4CF3FD37594365ABC9C53812213A634")
        @DSModeled(DSC.SAFE)
         AnimatorSetListener(AnimatorSet animatorSet) {
            dsTaint.addTaint(animatorSet.dsTaint);
            // ---------- Original Method ----------
            //mAnimatorSet = animatorSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.022 -0400", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "1C33492179F06C47008048CDC3520FF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                {
                    boolean varA027FC078EF92D056A51186849417200_160412938 = (mPlayingSet.size() == 0);
                    {
                        {
                            int numListeners;
                            numListeners = mListeners.size();
                            {
                                int i;
                                i = 0;
                                {
                                    mListeners.get(i).onAnimationCancel(mAnimatorSet);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.024 -0400", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "24B3D7A0EDB2862A24630DB76A3DA3D5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            animation.removeListener(this);
            mPlayingSet.remove(animation);
            Node animNode;
            animNode = mAnimatorSet.mNodeMap.get(animation);
            animNode.done = true;
            {
                ArrayList<Node> sortedNodes;
                sortedNodes = mAnimatorSet.mSortedNodes;
                boolean allDone;
                allDone = true;
                int numSortedNodes;
                numSortedNodes = sortedNodes.size();
                {
                    int i;
                    i = 0;
                    {
                        {
                            boolean varAF8C797863CB13C46D6EC7230251F511_1583598013 = (!sortedNodes.get(i).done);
                            {
                                allDone = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    {
                        ArrayList<AnimatorListener> tmpListeners;
                        tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                        int numListeners;
                        numListeners = tmpListeners.size();
                        {
                            int i;
                            i = 0;
                            {
                                tmpListeners.get(i).onAnimationEnd(mAnimatorSet);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mAnimatorSet.mStarted = false;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.025 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "8A5F13005333A2C85BED28A03CD6C3D0")
        @DSModeled(DSC.SAFE)
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.025 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "EB4C4DAE58327CD31D5B71EA0CA76EF2")
        @DSModeled(DSC.SAFE)
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Dependency {
        static final int WITH = 0;
        static final int AFTER = 1;
        public Node node;
        public int rule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.026 -0400", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "DE992F98CAEA5B4D3E7D082C8090251D")
        @DSModeled(DSC.SAFE)
        public Dependency(Node node, int rule) {
            dsTaint.addTaint(node.dsTaint);
            dsTaint.addTaint(rule);
            // ---------- Original Method ----------
            //this.node = node;
            //this.rule = rule;
        }

        
    }


    
    private static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public ArrayList<Dependency> tmpDependencies = null;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.027 -0400", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "9F7BBD94B578B2804AD599ABD1FD444C")
        @DSModeled(DSC.SAFE)
        public Node(Animator animation) {
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
            //this.animation = animation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.028 -0400", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "46B39338F9E7BFE7810DABBDD30F818F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addDependency(Dependency dependency) {
            dsTaint.addTaint(dependency.dsTaint);
            {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            } //End block
            dependencies.add(dependency);
            {
                boolean var9E27E0C5E8A816EDD775D65EEBC2A7AE_1388869804 = (!nodeDependencies.contains(dependency.node));
                {
                    nodeDependencies.add(dependency.node);
                } //End block
            } //End collapsed parenthetic
            Node dependencyNode;
            dependencyNode = dependency.node;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.029 -0400", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "80E0E540D629F7554DD62F6BDB18FAAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Node clone() {
            try 
            {
                Node node;
                node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
            } //End block
            catch (CloneNotSupportedException e)
            {
                throw new AssertionError();
            } //End block
            return (Node)dsTaint.getTaint();
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
        private Node mCurrentNode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.030 -0400", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "E15760253B140EB4648E4C0796CCABAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Builder(Animator anim) {
            dsTaint.addTaint(anim.dsTaint);
            mCurrentNode = mNodeMap.get(anim);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.031 -0400", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "D984DDA7C32DB9CDBF097E253D42069A")
        @DSModeled(DSC.SAFE)
        public Builder with(Animator anim) {
            dsTaint.addTaint(anim.dsTaint);
            Node node;
            node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency;
            dependency = new Dependency(mCurrentNode, Dependency.WITH);
            node.addDependency(dependency);
            return (Builder)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.032 -0400", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "3151717C71F9E8611617BBFE81E4DB73")
        @DSModeled(DSC.SAFE)
        public Builder before(Animator anim) {
            dsTaint.addTaint(anim.dsTaint);
            Node node;
            node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency;
            dependency = new Dependency(mCurrentNode, Dependency.AFTER);
            node.addDependency(dependency);
            return (Builder)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.034 -0400", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "448C270864B0445A5853A80EC30407B1")
        @DSModeled(DSC.SAFE)
        public Builder after(Animator anim) {
            dsTaint.addTaint(anim.dsTaint);
            Node node;
            node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } //End block
            Dependency dependency;
            dependency = new Dependency(node, Dependency.AFTER);
            mCurrentNode.addDependency(dependency);
            return (Builder)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:57.035 -0400", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "847D3079BBACBB39C05DC2ECA1571F48")
        @DSModeled(DSC.SAFE)
        public Builder after(long delay) {
            dsTaint.addTaint(delay);
            ValueAnimator anim;
            anim = ValueAnimator.ofFloat(0f, 1f);
            anim.setDuration(delay);
            after(anim);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            //anim.setDuration(delay);
            //after(anim);
            //return this;
        }

        
    }


    
}


