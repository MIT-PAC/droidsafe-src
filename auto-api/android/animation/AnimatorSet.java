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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.154 -0400", hash_original_field = "481906F29B88D36C651268313AA99F9C", hash_generated_field = "78867B83FFE4557154B28EC301F67602")

    private ArrayList<Animator> mPlayingSet = new ArrayList<Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.166 -0400", hash_original_field = "2CC48382609FD4F3FEC0CF6660DD7962", hash_generated_field = "F38E02C0F09CF00758E07C1CC5650AAE")

    private HashMap<Animator, Node> mNodeMap = new HashMap<Animator, Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.167 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

    private ArrayList<Node> mNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.168 -0400", hash_original_field = "380E108BE067245CE9715E7ABDA0FF63", hash_generated_field = "E9EC8321AA5FBFA3AD5392BA81212767")

    private ArrayList<Node> mSortedNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.178 -0400", hash_original_field = "D431998331275038BB7C0DD8851F8324", hash_generated_field = "85FDA93549065D0B768B7599D0ED4292")

    private boolean mNeedsSort = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.178 -0400", hash_original_field = "4305573E026146BBA24A84B6A06149F8", hash_generated_field = "E140240C038E8A4BB9AE350DA570B1A7")

    private AnimatorSetListener mSetListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.185 -0400", hash_original_field = "DE76B6AA416614DFE053747730C60267", hash_generated_field = "6D37E5BBEF916EC90B750BBB805CC32B")

    boolean mTerminated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.186 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.187 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.201 -0400", hash_original_field = "0050D5176A9407A418561438385DC63D", hash_generated_field = "0B2CF66D82E234938F59A1069E6EEEDE")

    private ValueAnimator mDelayAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.202 -0400", hash_original_field = "1F2FC4A63449C82899F1C64113BB8CAC", hash_generated_field = "0C5BD3F1F0DE8D2738EE5A7B893414D1")

    private long mDuration = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.210 -0400", hash_original_method = "A9DDD8ED58932E64D4F5BE029FA05ABF", hash_generated_method = "A9DDD8ED58932E64D4F5BE029FA05ABF")
    public AnimatorSet ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:10:50.229 -0400", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "6D7236E74CA3ADE8F5097F5D6AA3A6A2")
    public void playTogether(Animator... items) {
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
        addTaint(items[0].getTaint());
        // ---------- Original Method ----------
        //if (items != null) {
            //mNeedsSort = true;
            //Builder builder = play(items[0]);
            //for (int i = 1; i < items.length; ++i) {
                //builder.with(items[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.288 -0400", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "C3AFB27854256F00F2D7C5AEBAEDC7AA")
    public void playTogether(Collection<Animator> items) {
        {
            boolean varDBDD00862D2499954D5577669FA506EB_799834430 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                Builder builder;
                builder = null;
                {
                    Iterator<Animator> varF50336E7D87DFE8F4D77B947E51EA1D6_360390917 = (items).iterator();
                    varF50336E7D87DFE8F4D77B947E51EA1D6_360390917.hasNext();
                    Animator anim = varF50336E7D87DFE8F4D77B947E51EA1D6_360390917.next();
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
        addTaint(items.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.310 -0400", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "84DE0EF939CAF62B11F5BF768F3660C7")
    public void playSequentially(Animator... items) {
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
        addTaint(items[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.347 -0400", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "C690B7261E6DF3390070CA9BEC01627E")
    public void playSequentially(List<Animator> items) {
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1460327960 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                {
                    boolean var3DA64BAE48B6A767AE46B5F34638725F_979833927 = (items.size() == 1);
                    {
                        play(items.get(0));
                    } //End block
                    {
                        {
                            int i;
                            i = 0;
                            boolean var3F263A3674EDCC9514BA7F671DBD0DE6_2098287326 = (i < items.size() - 1);
                            {
                                play(items.get(i)).before(items.get(i+1));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(items.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.429 -0400", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "5276AC37EC0CA7A4F488EE6D75171567")
    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> varB4EAC82CA7396A68D541C85D26508E83_917673026 = null; //Variable for return #1
        ArrayList<Animator> childList;
        childList = new ArrayList<Animator>();
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_2145032006 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_2145032006.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_2145032006.next();
            {
                childList.add(node.animation);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_917673026 = childList;
        varB4EAC82CA7396A68D541C85D26508E83_917673026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_917673026;
        // ---------- Original Method ----------
        //ArrayList<Animator> childList = new ArrayList<Animator>();
        //for (Node node : mNodes) {
            //childList.add(node.animation);
        //}
        //return childList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.553 -0400", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "C7728947E23143822CAEE9C22F1EC5ED")
    @Override
    public void setTarget(Object target) {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_49186432 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_49186432.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_49186432.next();
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
        addTaint(target.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:35.995 -0400", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "A9E1EE4AB86CA0BD95DFB162643ED092")
    @Override
    public void setInterpolator(TimeInterpolator interpolator) {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1913833729 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1913833729.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1913833729.next();
            {
                node.animation.setInterpolator(interpolator);
            } //End block
        } //End collapsed parenthetic
        addTaint(interpolator.getTaint());
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setInterpolator(interpolator);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.014 -0400", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "0D47AFF553DE0AB135EEC8D13CB94FFE")
    public Builder play(Animator anim) {
        Builder varB4EAC82CA7396A68D541C85D26508E83_1251836801 = null; //Variable for return #1
        Builder varB4EAC82CA7396A68D541C85D26508E83_319747588 = null; //Variable for return #2
        {
            mNeedsSort = true;
            varB4EAC82CA7396A68D541C85D26508E83_1251836801 = new Builder(anim);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_319747588 = null;
        addTaint(anim.getTaint());
        Builder varA7E53CE21691AB073D9660D615818899_679030766; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_679030766 = varB4EAC82CA7396A68D541C85D26508E83_1251836801;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_679030766 = varB4EAC82CA7396A68D541C85D26508E83_319747588;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_679030766.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_679030766;
        // ---------- Original Method ----------
        //if (anim != null) {
            //mNeedsSort = true;
            //return new Builder(anim);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.367 -0400", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "AA97AA02B468FCFC7512C50D5EBB8304")
    @SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_758389662 = (isStarted());
            {
                ArrayList<AnimatorListener> tmpListeners;
                tmpListeners = null;
                {
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_2144398585 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_2144398585.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_2144398585.next();
                        {
                            listener.onAnimationCancel(this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var8BB2BFDAD6968BF48372B4777D136D94_1217192271 = (mDelayAnim != null && mDelayAnim.isRunning());
                    {
                        mDelayAnim.cancel();
                    } //End block
                    {
                        boolean varC7AADD45FD9F54D7C7758EDE2DB4AB5A_527833924 = (mSortedNodes.size() > 0);
                        {
                            {
                                Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_2034122447 = (mSortedNodes).iterator();
                                varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_2034122447.hasNext();
                                Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_2034122447.next();
                                {
                                    node.animation.cancel();
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_226886722 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_226886722.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_226886722.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.772 -0400", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "697CB73D8E7308ED286FDE754D89D3E3")
    @Override
    public void end() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_1403774530 = (isStarted());
            {
                {
                    boolean var7320623FD878E3DC8E3103403DCBB72C_2019366116 = (mSortedNodes.size() != mNodes.size());
                    {
                        sortNodes();
                        {
                            Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_90883823 = (mSortedNodes).iterator();
                            varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_90883823.hasNext();
                            Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_90883823.next();
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
                    boolean var230EE46EC79704D29C8FEAB7F43E06E4_1852102623 = (mSortedNodes.size() > 0);
                    {
                        {
                            Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_981612002 = (mSortedNodes).iterator();
                            varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_981612002.hasNext();
                            Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_981612002.next();
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
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_434383095 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_434383095.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_434383095.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.931 -0400", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "8475AE1EF00520D828EB5F2FFC1D23B0")
    @Override
    public boolean isRunning() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1517631338 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1517631338.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1517631338.next();
            {
                {
                    boolean varC93073F2E0F049EE49B3906C3BBE89FD_592153212 = (node.animation.isRunning());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983341941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983341941;
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //if (node.animation.isRunning()) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.941 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "7BC60120169108977B8D794E30048FB1")
    @Override
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904329889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904329889;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.967 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "5DB3AB91A9136AB8EA7BE7DBA5A2DE7A")
    @Override
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1107899616 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1107899616;
        // ---------- Original Method ----------
        //return mStartDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.973 -0400", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "DFD3698D1A235894B218DEC62F508D58")
    @Override
    public void setStartDelay(long startDelay) {
        mStartDelay = startDelay;
        // ---------- Original Method ----------
        //mStartDelay = startDelay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.975 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "647DB639316797DA5BFCBD3DC10FD40F")
    @Override
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2114563685 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2114563685;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.226 -0400", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "3453AC54EFC058897C91F4F2666F5EFF")
    @Override
    public AnimatorSet setDuration(long duration) {
        AnimatorSet varB4EAC82CA7396A68D541C85D26508E83_2050896660 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("duration must be a value of zero or greater");
        } //End block
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_658858022 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_658858022.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_658858022.next();
            {
                node.animation.setDuration(duration);
            } //End block
        } //End collapsed parenthetic
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_2050896660 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2050896660.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2050896660;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.386 -0400", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "6369770B600EB00BB058E54326555B55")
    @Override
    public void setupStartValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1361584188 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1361584188.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1361584188.next();
            {
                node.animation.setupStartValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupStartValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.750 -0400", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "9F75C043227ED797D55E5E643F80632A")
    @Override
    public void setupEndValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_214963756 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_214963756.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_214963756.next();
            {
                node.animation.setupEndValues();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Node node : mNodes) {
            //node.animation.setupEndValues();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.103 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "18BB125A5B3F5DC94D0DC0C8AF904F2E")
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
                    boolean var9ACEE8033582BBDB9B4CB98E4081BA91_527269021 = (oldListeners != null && oldListeners.size() > 0);
                    {
                        ArrayList<AnimatorListener> clonedListeners;
                        clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
                        {
                            Iterator<AnimatorListener> var3139CC75491E20BD070F538CEF2A01BC_1255807911 = (clonedListeners).iterator();
                            var3139CC75491E20BD070F538CEF2A01BC_1255807911.hasNext();
                            AnimatorListener listener = var3139CC75491E20BD070F538CEF2A01BC_1255807911.next();
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
                    boolean varE407B8E8668F490B90923B90830F3953_2093034923 = (node.dependencies == null || node.dependencies.size() == 0);
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
                Iterator<Node> var6627A46BC32D1BB288C28BACC946CACC_977281241 = (nodesToStart).iterator();
                var6627A46BC32D1BB288C28BACC946CACC_977281241.hasNext();
                Node node = var6627A46BC32D1BB288C28BACC946CACC_977281241.next();
                {
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.061 -0400", hash_original_field = "990982D89CFB60D5939A88FB81C4FE88", hash_generated_field = "41402EB62AB9E9D5CBE01FDA6E9433EB")
                boolean canceled = false;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.063 -0400", hash_original_method = "BE87F1813CBA8EA740D5C2234F834512", hash_generated_method = "F05C5FC7C3998BE3DF1CA0A34A4A4332")
                public void onAnimationCancel(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
                    canceled = true;
                    addTaint(anim.getTaint());
                    // ---------- Original Method ----------
                    //canceled = true;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.085 -0400", hash_original_method = "445AE985C63B218AFF9EAABB75FAC581", hash_generated_method = "0232A4558E61F61B922B5B1476945205")
                public void onAnimationEnd(Animator anim) {
                    //DSFIXME:  CODE0009: Possible callback target function detected
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
                    addTaint(anim.getTaint());
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
            boolean varE5C319B3E9148866563870C4DF81C81D_211579123 = (mNodes.size() == 0 && mStartDelay == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.779 -0400", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "13C1B429AAF08EEDE9CD6938D3226182")
    @Override
    public AnimatorSet clone() {
        AnimatorSet varB4EAC82CA7396A68D541C85D26508E83_1390027918 = null; //Variable for return #1
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
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_846768407 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_846768407.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_846768407.next();
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
                        Iterator<AnimatorListener> varD7B40EC36D902B674F9251BD59AD5B02_1740646407 = (cloneListeners).iterator();
                        varD7B40EC36D902B674F9251BD59AD5B02_1740646407.hasNext();
                        AnimatorListener listener = varD7B40EC36D902B674F9251BD59AD5B02_1740646407.next();
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
                            Iterator<AnimatorListener> varCBAA8D83D3B98A5F09C128BBCC8C530B_678634257 = (listenersToRemove).iterator();
                            varCBAA8D83D3B98A5F09C128BBCC8C530B_678634257.hasNext();
                            AnimatorListener listener = varCBAA8D83D3B98A5F09C128BBCC8C530B_678634257.next();
                            {
                                cloneListeners.remove(listener);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_756300404 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_756300404.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_756300404.next();
            {
                Node nodeClone;
                nodeClone = nodeCloneMap.get(node);
                {
                    {
                        Iterator<Dependency> var253BE40EA2AE0291BE9458DD3CF55453_685893956 = (node.dependencies).iterator();
                        var253BE40EA2AE0291BE9458DD3CF55453_685893956.hasNext();
                        Dependency dependency = var253BE40EA2AE0291BE9458DD3CF55453_685893956.next();
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
        varB4EAC82CA7396A68D541C85D26508E83_1390027918 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_1390027918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1390027918;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.836 -0400", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "CD6D4AFCC7582C9F8E5DBFA69C8A4A27")
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
                        boolean var0D1480BBE27A084BABF64DD1A6FC3773_1489564893 = (node.dependencies == null || node.dependencies.size() == 0);
                        {
                            roots.add(node);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            ArrayList<Node> tmpRoots;
            tmpRoots = new ArrayList<Node>();
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_1653729332 = (roots.size() > 0);
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
                                            boolean var21891AE5AAFE8EB96113B08DED5B940C_282221579 = (node.nodeDependencies.size() == 0);
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
                boolean varDD5278C4A821B04466EA81991E002294_1510717944 = (mSortedNodes.size() != mNodes.size());
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
                        boolean var60187AACFF822DE3E56322B4A4D489FB_53546267 = (node.dependencies != null && node.dependencies.size() > 0);
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
                                        boolean varF4A971F3E1E7ED2E8AD23CBB7EC95189_1893103836 = (!node.nodeDependencies.contains(dependency.node));
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.838 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.854 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "298BE469E9769EF16537BF922B91FDA5")

        private Node mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.855 -0400", hash_original_field = "C29D48DB82CAC5F7D6125EB9E5BDD4B3", hash_generated_field = "F35AEC1D0C05BC027541025D8E7C024E")

        private int mRule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.857 -0400", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "2CEF4FD9DA42A82DAEC47138680208B3")
        public  DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = rule;
            // ---------- Original Method ----------
            //this.mAnimatorSet = animatorSet;
            //this.mNode = node;
            //this.mRule = rule;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.858 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "C2873E3A5F96230B9841E1221FD8122E")
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.859 -0400", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "7300700F99E8AA30766F21D7E3F32AD5")
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                startIfReady(animation);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mRule == Dependency.AFTER) {
                //startIfReady(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.942 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.946 -0400", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "A948E6845DD4322DA93742FD24A3E7F7")
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                startIfReady(animation);
            } //End block
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            //if (mRule == Dependency.WITH) {
                //startIfReady(animation);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.949 -0400", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "9BF0C59BF0BD0EEF277D52BF70824145")
        private void startIfReady(Animator dependencyAnimation) {
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
                boolean var87E4D5B3F0E82C7E3E2C2DE17D172229_1122147128 = (mNode.tmpDependencies.size() == 0);
                {
                    mNode.animation.start();
                    mAnimatorSet.mPlayingSet.add(mNode.animation);
                } //End block
            } //End collapsed parenthetic
            addTaint(dependencyAnimation.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private class AnimatorSetListener implements AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.950 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:43.982 -0400", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "5149E3B3F385A46C24F32667B339D036")
          AnimatorSetListener(AnimatorSet animatorSet) {
            mAnimatorSet = animatorSet;
            // ---------- Original Method ----------
            //mAnimatorSet = animatorSet;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.005 -0400", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "13048047E431FBE7BE8B4A8C14984870")
        public void onAnimationCancel(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                {
                    boolean varA027FC078EF92D056A51186849417200_1679074132 = (mPlayingSet.size() == 0);
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
            addTaint(animation.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.024 -0400", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "FFF6B65D876166EC51B1D42D4FBB7611")
        @SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
                            boolean varAF8C797863CB13C46D6EC7230251F511_1104520010 = (!sortedNodes.get(i).done);
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
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.042 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.043 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "4F1E500BA39728FB7A49E02540A0C5AA")
        public void onAnimationStart(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    private static class Dependency {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.047 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "220314E1B8A64C8F8406491E2C312A28")

        public Node node;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.047 -0400", hash_original_field = "981C1E7B3795DA18687613FBD66D4954", hash_generated_field = "5BCB5D76D9FE8D00C97FD248D276BEFB")

        public int rule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.074 -0400", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "11E9E1642757F63DD999DD0DC47CC81E")
        public  Dependency(Node node, int rule) {
            this.node = node;
            this.rule = rule;
            // ---------- Original Method ----------
            //this.node = node;
            //this.rule = rule;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.074 -0400", hash_original_field = "1334D2D6495806F754F66024F08499AE", hash_generated_field = "3FB08785514118E1A291AA41E4DC0732")

        static int WITH = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.075 -0400", hash_original_field = "DA0977069E1F00C63DBCD6472D3A83BD", hash_generated_field = "75D8FEA93F168F783AB53D5D5A8FD7EE")

        static int AFTER = 1;
    }


    
    private static class Node implements Cloneable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.091 -0400", hash_original_field = "6F1C25ED1523962F1BBF9DEE9BE5092B", hash_generated_field = "85D1EE31923D44CB9D3110ADDD29D65D")

        public Animator animation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.092 -0400", hash_original_field = "3341DF3F2BE5741254627C20B0B01F51", hash_generated_field = "46C94882CA4285AE3FB52FBE346AC349")

        public ArrayList<Dependency> dependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.092 -0400", hash_original_field = "200E0333937676F14E2E34EDC6377C4C", hash_generated_field = "B8C6459C87326A52248B3A69C1AD5ACC")

        public ArrayList<Dependency> tmpDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.093 -0400", hash_original_field = "47751C8F1D02529930E31B5653CEA54A", hash_generated_field = "4B254F155DE5D18E0880E4E9DEF81A08")

        public ArrayList<Node> nodeDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.094 -0400", hash_original_field = "974D2A11D6D39C71254A79C0E7E4343C", hash_generated_field = "D83CBAAD32ACD2DF620D72FD4EEEA1F1")

        public ArrayList<Node> nodeDependents = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.101 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "3C1F0C530EFFEA18D19D1DCE04D244D2")

        public boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.103 -0400", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "C7E970336EB0D2C23CBE821EB59549EA")
        public  Node(Animator animation) {
            this.animation = animation;
            // ---------- Original Method ----------
            //this.animation = animation;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.133 -0400", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "EE0EA8D967D8B10A910F4B2926B23534")
        public void addDependency(Dependency dependency) {
            {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            } //End block
            dependencies.add(dependency);
            {
                boolean var9E27E0C5E8A816EDD775D65EEBC2A7AE_1534459144 = (!nodeDependencies.contains(dependency.node));
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
            addTaint(dependency.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.145 -0400", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "DACF47F25A91F7848FB29DEA041A50E1")
        @Override
        public Node clone() {
            Node varB4EAC82CA7396A68D541C85D26508E83_1022543412 = null; //Variable for return #1
            try 
            {
                Node node;
                node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
                varB4EAC82CA7396A68D541C85D26508E83_1022543412 = node;
            } //End block
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1022543412.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1022543412;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.146 -0400", hash_original_field = "804B3EF3A920EEBB8C5E4C902948FD7E", hash_generated_field = "A3A3172265405E9566BFFCC4660589E1")

        private Node mCurrentNode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.167 -0400", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "D400691F8684211CE780557AB7EE40C2")
          Builder(Animator anim) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.173 -0400", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "D86F5F1610DCB87B8C4D4332BD5C5AC8")
        public Builder with(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_98972393 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_98972393 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_98972393.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_98972393;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.208 -0400", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "2F9CAC953CD9350604794602F22D750C")
        public Builder before(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_341243470 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_341243470 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_341243470.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_341243470;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.213 -0400", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "0375ED475F4AB49C1DE699098FF6666F")
        public Builder after(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1420483445 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1420483445 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1420483445.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1420483445;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.233 -0400", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "52FC2ADA1C13613874E94B15761535DC")
        public Builder after(long delay) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_161213025 = null; //Variable for return #1
            ValueAnimator anim;
            anim = ValueAnimator.ofFloat(0f, 1f);
            anim.setDuration(delay);
            after(anim);
            varB4EAC82CA7396A68D541C85D26508E83_161213025 = this;
            addTaint(delay);
            varB4EAC82CA7396A68D541C85D26508E83_161213025.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_161213025;
            // ---------- Original Method ----------
            //ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            //anim.setDuration(delay);
            //after(anim);
            //return this;
        }

        
    }


    
}

