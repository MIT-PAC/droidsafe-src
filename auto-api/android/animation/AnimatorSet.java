package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.957 -0400", hash_original_method = "DA26DB1564F7ECFF5A0EEA0B07BDD989", hash_generated_method = "DA26DB1564F7ECFF5A0EEA0B07BDD989")
        public AnimatorSet ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:30.958 -0400", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "27506DAB7B35A955DC94DFD5D41E9B79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playTogether(Animator... items) {
        dsTaint.addTaint(items[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.139 -0400", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "F1EDADDEBDB0ABD05F9D10257834C4B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playTogether(Collection<Animator> items) {
        dsTaint.addTaint(items.dsTaint);
        {
            boolean varDBDD00862D2499954D5577669FA506EB_457518613 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                Builder builder;
                builder = null;
                {
                    Iterator<Animator> varF50336E7D87DFE8F4D77B947E51EA1D6_107195186 = (items).iterator();
                    varF50336E7D87DFE8F4D77B947E51EA1D6_107195186.hasNext();
                    Animator anim = varF50336E7D87DFE8F4D77B947E51EA1D6_107195186.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.140 -0400", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "51A82D696BC393EF9D2A5003EEDB1A86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSequentially(Animator... items) {
        dsTaint.addTaint(items[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.142 -0400", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "17F16B1A92EF12D3E880ABDAA1EB4762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void playSequentially(List<Animator> items) {
        dsTaint.addTaint(items.dsTaint);
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1845737097 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                {
                    boolean var3DA64BAE48B6A767AE46B5F34638725F_1710714189 = (items.size() == 1);
                    {
                        play(items.get(0));
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            boolean var3F263A3674EDCC9514BA7F671DBD0DE6_541263548 = (i < items.size() - 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.158 -0400", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "3744B90DE94E0D455FFB1C2A714A54CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> childList;
        childList = new ArrayList<Animator>();
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_534406940 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_534406940.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_534406940.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.183 -0400", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "D6B32B733C3AD23CE82DA57AF6BD9496")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTarget(Object target) {
        dsTaint.addTaint(target.dsTaint);
        {
            Node node = mNodes[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.212 -0400", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "A69BECABE95F205F214A180D38A47EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setInterpolator(TimeInterpolator interpolator) {
        dsTaint.addTaint(interpolator.dsTaint);
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_562605672 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_562605672.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_562605672.next();
            {
                node.animation.setInterpolator(interpolator);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setInterpolator(interpolator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.213 -0400", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "1D1EFA29CB26C048AD669184DC2FC872")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Builder play(Animator anim) {
        dsTaint.addTaint(anim.dsTaint);
        {
            mNeedsSort = true;
            Builder var3F204613760582B826BAF424A32190FB_838830873 = (new Builder(anim));
        } //End block
        return (Builder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (anim != null) {
            //mNeedsSort = true;
            //return new Builder(anim);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.272 -0400", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "25CAB32A02EDBF5E2569BB02E30C5C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_395668998 = (isStarted());
            {
                ArrayList<AnimatorListener> tmpListeners;
                tmpListeners = null;
                {
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        AnimatorListener listener = tmpListeners[0];
                        {
                            listener.onAnimationCancel(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8BB2BFDAD6968BF48372B4777D136D94_1951332444 = (mDelayAnim != null && mDelayAnim.isRunning());
                    {
                        mDelayAnim.cancel();
                    } //End block
                    {
                        boolean varC7AADD45FD9F54D7C7758EDE2DB4AB5A_1294727661 = (mSortedNodes.size() > 0);
                        {
                            {
                                Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1980986695 = (mSortedNodes).iterator();
                                varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1980986695.hasNext();
                                Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1980986695.next();
                                {
                                    node.animation.cancel();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1874824905 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1874824905.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1874824905.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.334 -0400", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "438C3064146663AB5AE6446C2833C069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void end() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_957519381 = (isStarted());
            {
                {
                    boolean var7320623FD878E3DC8E3103403DCBB72C_935095095 = (mSortedNodes.size() != mNodes.size());
                    {
                        sortNodes();
                        {
                            Node node = mSortedNodes[0];
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
                    boolean var230EE46EC79704D29C8FEAB7F43E06E4_1089589544 = (mSortedNodes.size() > 0);
                    {
                        {
                            Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_52099984 = (mSortedNodes).iterator();
                            varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_52099984.hasNext();
                            Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_52099984.next();
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
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1929117267 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1929117267.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1929117267.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.351 -0400", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "7536FB63AF83013C9E49D375E29FAD01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isRunning() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_2026379012 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_2026379012.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_2026379012.next();
            {
                {
                    boolean varC93073F2E0F049EE49B3906C3BBE89FD_124008299 = (node.animation.isRunning());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.352 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "18F903773E382D89BF9EEA19FD1903C0")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.353 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "E3E1A995A502977F513E8CDA8EA733E9")
    @DSModeled(DSC.SAFE)
    @Override
    public long getStartDelay() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.354 -0400", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "83B2E833F5CF79EF20FF47D2CB57F398")
    @DSModeled(DSC.SAFE)
    @Override
    public void setStartDelay(long startDelay) {
        dsTaint.addTaint(startDelay);
        // ---------- Original Method ----------
        //mStartDelay = startDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.356 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "0859072FD67394FFFAD0A7C7B8D28DBE")
    @DSModeled(DSC.SAFE)
    @Override
    public long getDuration() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.381 -0400", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "FE9A8F22C947C6F2C1359659AA93624D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AnimatorSet setDuration(long duration) {
        dsTaint.addTaint(duration);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("duration must be a value of zero or greater");
        } //End block
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1602106982 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1602106982.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1602106982.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.403 -0400", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "C9460357E76FC40DB86CC1ED0BC0BCF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setupStartValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1577459651 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1577459651.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1577459651.next();
            {
                node.animation.setupStartValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupStartValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.414 -0400", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "FCF12C4D9CFDEA0291280C6F22FE93E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setupEndValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1847119067 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1847119067.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1847119067.next();
            {
                node.animation.setupEndValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupEndValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.534 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "E5F9D552648C6A3AF45ED7B63F977215")
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
                    boolean var9ACEE8033582BBDB9B4CB98E4081BA91_481825986 = (oldListeners != null && oldListeners.size() > 0);
                    {
                        ArrayList<AnimatorListener> clonedListeners;
                        clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
                        {
                            Iterator<AnimatorListener> var3139CC75491E20BD070F538CEF2A01BC_347128021 = (clonedListeners).iterator();
                            var3139CC75491E20BD070F538CEF2A01BC_347128021.hasNext();
                            AnimatorListener listener = var3139CC75491E20BD070F538CEF2A01BC_347128021.next();
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
        ArrayList<Node> nodesToStart;
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
                    boolean varE407B8E8668F490B90923B90830F3953_1586670688 = (node.dependencies == null || node.dependencies.size() == 0);
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
                Node node = nodesToStart[0];
                {
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {                boolean canceled = false;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.531 -0400", hash_original_method = "BE87F1813CBA8EA740D5C2234F834512", hash_generated_method = "D14895005ACE55C132E646E44ABFD1D5")
                @DSModeled(DSC.SAFE)
                public void onAnimationCancel(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(anim.dsTaint);
                    canceled = true;
                    // ---------- Original Method ----------
                    //canceled = true;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.532 -0400", hash_original_method = "445AE985C63B218AFF9EAABB75FAC581", hash_generated_method = "96CE65CA197D6B2CF5B523B30AB3CE81")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    dsTaint.addTaint(anim.dsTaint);
                    {
                        int numNodes;
                        numNodes = nodesToStart.size();
                        {
                            int i;
                            i = 0;
                            {
                                Node node;
                                node = nodesToStart.get(i);
                                node.animation.start();
                                mPlayingSet.add(node.animation);
                            } //End block
                        } //End collapsed parenthetic
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
            boolean varE5C319B3E9148866563870C4DF81C81D_1666533401 = (mNodes.size() == 0 && mStartDelay == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.625 -0400", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "2D61E1F66DE12EBCF13D16AB15920802")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AnimatorSet clone() {
        AnimatorSet anim;
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
            Node node = mNodes[0];
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
                        Iterator<AnimatorListener> varD7B40EC36D902B674F9251BD59AD5B02_1884537517 = (cloneListeners).iterator();
                        varD7B40EC36D902B674F9251BD59AD5B02_1884537517.hasNext();
                        AnimatorListener listener = varD7B40EC36D902B674F9251BD59AD5B02_1884537517.next();
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
                            Iterator<AnimatorListener> varCBAA8D83D3B98A5F09C128BBCC8C530B_136389902 = (listenersToRemove).iterator();
                            varCBAA8D83D3B98A5F09C128BBCC8C530B_136389902.hasNext();
                            AnimatorListener listener = varCBAA8D83D3B98A5F09C128BBCC8C530B_136389902.next();
                            {
                                cloneListeners.remove(listener);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Node node = mNodes[0];
            {
                Node nodeClone;
                nodeClone = nodeCloneMap.get(node);
                {
                    {
                        Dependency dependency = node.dependencies[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.637 -0400", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "35364AB0378210DF504B0D0F93D09D74")
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
                        boolean var0D1480BBE27A084BABF64DD1A6FC3773_364413332 = (node.dependencies == null || node.dependencies.size() == 0);
                        {
                            roots.add(node);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ArrayList<Node> tmpRoots;
            tmpRoots = new ArrayList<Node>();
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_1873723507 = (roots.size() > 0);
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
                                            boolean var21891AE5AAFE8EB96113B08DED5B940C_1226111755 = (node.nodeDependencies.size() == 0);
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
                boolean varDD5278C4A821B04466EA81991E002294_936336187 = (mSortedNodes.size() != mNodes.size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Circular dependencies cannot exist"
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
                        boolean var60187AACFF822DE3E56322B4A4D489FB_591400546 = (node.dependencies != null && node.dependencies.size() > 0);
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
                                        boolean varF4A971F3E1E7ED2E8AD23CBB7EC95189_453422382 = (!node.nodeDependencies.contains(dependency.node));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.639 -0400", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "34388B8A7E57D71527DD9257AA3E0ACE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.650 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "B87539F575849C46371708B04A4B28CD")
        @DSModeled(DSC.SAFE)
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.651 -0400", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "3A27E0A29F1281A75F22980BBEFF53FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.652 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "AD894D139064FB61C21E73B1A738D1AF")
        @DSModeled(DSC.SAFE)
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.654 -0400", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "05DAE957E87B899FEACABE42D48044A4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.657 -0400", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "A9006C215EB307723DCE1ECF9FF88787")
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
                boolean var87E4D5B3F0E82C7E3E2C2DE17D172229_1609072033 = (mNode.tmpDependencies.size() == 0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.658 -0400", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "BF2D54BCB04A17A6EC54437F4971E78F")
        @DSModeled(DSC.SAFE)
         AnimatorSetListener(AnimatorSet animatorSet) {
            dsTaint.addTaint(animatorSet.dsTaint);
            // ---------- Original Method ----------
            //mAnimatorSet = animatorSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.659 -0400", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "15A3F354FF61DFA8C069B51D6FDB754F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            {
                {
                    boolean varA027FC078EF92D056A51186849417200_2000826632 = (mPlayingSet.size() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.671 -0400", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "F1FA53350CBED243066E41AB6FAA7500")
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
                            boolean varAF8C797863CB13C46D6EC7230251F511_252431289 = (!sortedNodes.get(i).done);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.672 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "AD894D139064FB61C21E73B1A738D1AF")
        @DSModeled(DSC.SAFE)
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.672 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "60C99F238C0B65FA78E3D750E3013053")
        @DSModeled(DSC.SAFE)
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Dependency {
        public Node node;
        public int rule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.673 -0400", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "62F5E86ABF24271D3543B356170BD5D0")
        @DSModeled(DSC.SAFE)
        public Dependency(Node node, int rule) {
            dsTaint.addTaint(node.dsTaint);
            dsTaint.addTaint(rule);
            // ---------- Original Method ----------
            //this.node = node;
            //this.rule = rule;
        }

        
        static final int WITH = 0;
        static final int AFTER = 1;
    }


    
    private static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public ArrayList<Dependency> tmpDependencies = null;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.674 -0400", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "B85091F8EECC49E758722FD5A24902C5")
        @DSModeled(DSC.SAFE)
        public Node(Animator animation) {
            dsTaint.addTaint(animation.dsTaint);
            // ---------- Original Method ----------
            //this.animation = animation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.676 -0400", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "628E46D2909355786E950681B61024A2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void addDependency(Dependency dependency) {
            dsTaint.addTaint(dependency.dsTaint);
            {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            } //End block
            dependencies.add(dependency);
            {
                boolean var9E27E0C5E8A816EDD775D65EEBC2A7AE_1327304337 = (!nodeDependencies.contains(dependency.node));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.686 -0400", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "041E21656215D93AB605A8EC76123EF2")
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
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.689 -0400", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "8A9094CE65417BFB0D18C7C3A199094F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.690 -0400", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "5AA5E8816A13CD172EF1884B35A68D2E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.691 -0400", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "92FB0132BC91603BA748E0D1589062A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.693 -0400", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "B14D86A6E2A79EBCC7CBF118D554C52A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:31.693 -0400", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "6BD5E1C7EEBABC80FA516385816DEEBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

