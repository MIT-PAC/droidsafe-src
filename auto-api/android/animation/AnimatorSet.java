package android.animation;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class AnimatorSet extends Animator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.109 -0400", hash_original_field = "481906F29B88D36C651268313AA99F9C", hash_generated_field = "78867B83FFE4557154B28EC301F67602")

    private ArrayList<Animator> mPlayingSet = new ArrayList<Animator>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.110 -0400", hash_original_field = "2CC48382609FD4F3FEC0CF6660DD7962", hash_generated_field = "F38E02C0F09CF00758E07C1CC5650AAE")

    private HashMap<Animator, Node> mNodeMap = new HashMap<Animator, Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.110 -0400", hash_original_field = "DB82967F5D06BF98EFB4ACBA027F7402", hash_generated_field = "1B3148FB5A2450DADCF9B3CB97C1D5E0")

    private ArrayList<Node> mNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.110 -0400", hash_original_field = "380E108BE067245CE9715E7ABDA0FF63", hash_generated_field = "E9EC8321AA5FBFA3AD5392BA81212767")

    private ArrayList<Node> mSortedNodes = new ArrayList<Node>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.111 -0400", hash_original_field = "D431998331275038BB7C0DD8851F8324", hash_generated_field = "85FDA93549065D0B768B7599D0ED4292")

    private boolean mNeedsSort = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.111 -0400", hash_original_field = "4305573E026146BBA24A84B6A06149F8", hash_generated_field = "E140240C038E8A4BB9AE350DA570B1A7")

    private AnimatorSetListener mSetListener = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.111 -0400", hash_original_field = "DE76B6AA416614DFE053747730C60267", hash_generated_field = "6D37E5BBEF916EC90B750BBB805CC32B")

    boolean mTerminated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.112 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.112 -0400", hash_original_field = "59DE326DE1427310187F9B4749E42166", hash_generated_field = "7C883F9B967B7CFCC6422EEE44FD3782")

    private long mStartDelay = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.112 -0400", hash_original_field = "0050D5176A9407A418561438385DC63D", hash_generated_field = "0B2CF66D82E234938F59A1069E6EEEDE")

    private ValueAnimator mDelayAnim = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.113 -0400", hash_original_field = "1F2FC4A63449C82899F1C64113BB8CAC", hash_generated_field = "0C5BD3F1F0DE8D2738EE5A7B893414D1")

    private long mDuration = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.113 -0400", hash_original_method = "A9DDD8ED58932E64D4F5BE029FA05ABF", hash_generated_method = "A9DDD8ED58932E64D4F5BE029FA05ABF")
    public AnimatorSet ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.114 -0400", hash_original_method = "D3DC50F4C11146F18EBEE861B5ED6567", hash_generated_method = "AAE8EBBB8E2C544E873DFC29FBC01AC2")
    public void playTogether(Animator... items) {
        {
            mNeedsSort = true;
            Builder builder = play(items[0]);
            {
                int i = 1;
                {
                    builder.with(items[i]);
                } 
            } 
        } 
        addTaint(items[0].getTaint());
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.267 -0400", hash_original_method = "D25B7AF36D80C3FC72EA4BF2A0177D1E", hash_generated_method = "2DEF5FF2E8D265058E6AD0EFB596A405")
    public void playTogether(Collection<Animator> items) {
        {
            boolean varDBDD00862D2499954D5577669FA506EB_527471613 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                Builder builder = null;
                {
                    Iterator<Animator> varF50336E7D87DFE8F4D77B947E51EA1D6_154429456 = (items).iterator();
                    varF50336E7D87DFE8F4D77B947E51EA1D6_154429456.hasNext();
                    Animator anim = varF50336E7D87DFE8F4D77B947E51EA1D6_154429456.next();
                    {
                        {
                            builder = play(anim);
                        } 
                        {
                            builder.with(anim);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(items.getTaint());
        
        
            
            
            
                
                    
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.268 -0400", hash_original_method = "6DD5048753632FED7CFB0FE5E71CCF54", hash_generated_method = "68CDC81AF2932CF787EFE52BD90247A1")
    public void playSequentially(Animator... items) {
        {
            mNeedsSort = true;
            {
                play(items[0]);
            } 
            {
                {
                    int i = 0;
                    {
                        play(items[i]).before(items[i+1]);
                    } 
                } 
            } 
        } 
        addTaint(items[0].getTaint());
        
        
            
            
                
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.270 -0400", hash_original_method = "2D5A2EE93DC881BBD9D776B2A4798185", hash_generated_method = "397FE2799544D07909786021FDEF9519")
    public void playSequentially(List<Animator> items) {
        {
            boolean varDBDD00862D2499954D5577669FA506EB_1817734213 = (items != null && items.size() > 0);
            {
                mNeedsSort = true;
                {
                    boolean var3DA64BAE48B6A767AE46B5F34638725F_442070197 = (items.size() == 1);
                    {
                        play(items.get(0));
                    } 
                    {
                        {
                            int i = 0;
                            boolean var3F263A3674EDCC9514BA7F671DBD0DE6_517997965 = (i < items.size() - 1);
                            {
                                play(items.get(i)).before(items.get(i+1));
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(items.getTaint());
        
        
            
            
                
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.279 -0400", hash_original_method = "BD23BC3E594C29615E84753B4F440C27", hash_generated_method = "0FFD5F6FA5DD2C7F90531047C74A8772")
    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> varB4EAC82CA7396A68D541C85D26508E83_163791 = null; 
        ArrayList<Animator> childList = new ArrayList<Animator>();
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_919596386 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_919596386.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_919596386.next();
            {
                childList.add(node.animation);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_163791 = childList;
        varB4EAC82CA7396A68D541C85D26508E83_163791.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_163791;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.296 -0400", hash_original_method = "41A215E076D4B9AE460EA29EBF85AEE2", hash_generated_method = "00611149E06B3F4B741660A2D352BC78")
    @Override
    public void setTarget(Object target) {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1391726169 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1391726169.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1391726169.next();
            {
                Animator animation = node.animation;
                {
                    ((AnimatorSet)animation).setTarget(target);
                } 
                {
                    ((ObjectAnimator)animation).setTarget(target);
                } 
            } 
        } 
        addTaint(target.getTaint());
        
        
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.308 -0400", hash_original_method = "09C40C8100DC4A78048B11834DAF681E", hash_generated_method = "1DE25CE0767955D24951198F5C143F62")
    @Override
    public void setInterpolator(TimeInterpolator interpolator) {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_979242158 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_979242158.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_979242158.next();
            {
                node.animation.setInterpolator(interpolator);
            } 
        } 
        addTaint(interpolator.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.310 -0400", hash_original_method = "AC4AA224AE1E479BEEF0C5D37CBA15A0", hash_generated_method = "2C12B12537A4643149CACB067FA0B2F3")
    public Builder play(Animator anim) {
        Builder varB4EAC82CA7396A68D541C85D26508E83_1455336565 = null; 
        Builder varB4EAC82CA7396A68D541C85D26508E83_1802978713 = null; 
        {
            mNeedsSort = true;
            varB4EAC82CA7396A68D541C85D26508E83_1455336565 = new Builder(anim);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1802978713 = null;
        addTaint(anim.getTaint());
        Builder varA7E53CE21691AB073D9660D615818899_1789317914; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1789317914 = varB4EAC82CA7396A68D541C85D26508E83_1455336565;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1789317914 = varB4EAC82CA7396A68D541C85D26508E83_1802978713;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1789317914.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1789317914;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.342 -0400", hash_original_method = "E3B1DB55014BC169BEC681899C101562", hash_generated_method = "DABB4F97D947EC474D4E93FF87C6E04E")
    @SuppressWarnings("unchecked")
    @Override
    public void cancel() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_727610572 = (isStarted());
            {
                ArrayList<AnimatorListener> tmpListeners = null;
                {
                    tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1697402812 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1697402812.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1697402812.next();
                        {
                            listener.onAnimationCancel(this);
                        } 
                    } 
                } 
                {
                    boolean var8BB2BFDAD6968BF48372B4777D136D94_595184585 = (mDelayAnim != null && mDelayAnim.isRunning());
                    {
                        mDelayAnim.cancel();
                    } 
                    {
                        boolean varC7AADD45FD9F54D7C7758EDE2DB4AB5A_2039918701 = (mSortedNodes.size() > 0);
                        {
                            {
                                Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_40739772 = (mSortedNodes).iterator();
                                varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_40739772.hasNext();
                                Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_40739772.next();
                                {
                                    node.animation.cancel();
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1221893430 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1221893430.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1221893430.next();
                        {
                            listener.onAnimationEnd(this);
                        } 
                    } 
                } 
                mStarted = false;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.378 -0400", hash_original_method = "B4B8C3285FA05F4223F7D939EA476CBE", hash_generated_method = "C18B1D49A04C74F10A583DDBA0D6F9AA")
    @Override
    public void end() {
        mTerminated = true;
        {
            boolean varD892D561F22F67441CBDAA1DF2D74101_414353141 = (isStarted());
            {
                {
                    boolean var7320623FD878E3DC8E3103403DCBB72C_2127703565 = (mSortedNodes.size() != mNodes.size());
                    {
                        sortNodes();
                        {
                            Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1540130612 = (mSortedNodes).iterator();
                            varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1540130612.hasNext();
                            Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1540130612.next();
                            {
                                {
                                    mSetListener = new AnimatorSetListener(this);
                                } 
                                node.animation.addListener(mSetListener);
                            } 
                        } 
                    } 
                } 
                {
                    mDelayAnim.cancel();
                } 
                {
                    boolean var230EE46EC79704D29C8FEAB7F43E06E4_1805772126 = (mSortedNodes.size() > 0);
                    {
                        {
                            Iterator<Node> varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1471620078 = (mSortedNodes).iterator();
                            varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1471620078.hasNext();
                            Node node = varF1FCCAA4AAF37F324CA7B5CEDBECCBA6_1471620078.next();
                            {
                                node.animation.end();
                            } 
                        } 
                    } 
                } 
                {
                    ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                    {
                        Iterator<AnimatorListener> var654BA54CE39980A4AD9D75C7F4D7E493_1640588084 = (tmpListeners).iterator();
                        var654BA54CE39980A4AD9D75C7F4D7E493_1640588084.hasNext();
                        AnimatorListener listener = var654BA54CE39980A4AD9D75C7F4D7E493_1640588084.next();
                        {
                            listener.onAnimationEnd(this);
                        } 
                    } 
                } 
                mStarted = false;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.389 -0400", hash_original_method = "0B0086D752673B320D1D01C156228A84", hash_generated_method = "841D49DB88723535A8C4CAE486C16F61")
    @Override
    public boolean isRunning() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1755911761 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1755911761.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1755911761.next();
            {
                {
                    boolean varC93073F2E0F049EE49B3906C3BBE89FD_1783313276 = (node.animation.isRunning());
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513402923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513402923;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.390 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "100A87F7E97F79EEE92A8353F08E3F70")
    @Override
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032595681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032595681;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.391 -0400", hash_original_method = "36807B48FC1321C96D3D559AECDD954B", hash_generated_method = "938D3B113C68100B8EB3C5907AA45E22")
    @Override
    public long getStartDelay() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_933544212 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_933544212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.392 -0400", hash_original_method = "9B89801AA661B38F8303A0C7891B0195", hash_generated_method = "DFD3698D1A235894B218DEC62F508D58")
    @Override
    public void setStartDelay(long startDelay) {
        mStartDelay = startDelay;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.393 -0400", hash_original_method = "5E13B5E872677B59408FA3E6BB94A9F6", hash_generated_method = "5FEDEBCEEFB41CE47DCBCB6C5BEC7CC9")
    @Override
    public long getDuration() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1345977817 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1345977817;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.412 -0400", hash_original_method = "617F429F7C8E2B81C3248DA9CF3C7537", hash_generated_method = "216587A921E2FA0E7C3ABCF1ACD931CA")
    @Override
    public AnimatorSet setDuration(long duration) {
        AnimatorSet varB4EAC82CA7396A68D541C85D26508E83_277623816 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("duration must be a value of zero or greater");
        } 
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_960552325 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_960552325.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_960552325.next();
            {
                node.animation.setDuration(duration);
            } 
        } 
        mDuration = duration;
        varB4EAC82CA7396A68D541C85D26508E83_277623816 = this;
        varB4EAC82CA7396A68D541C85D26508E83_277623816.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_277623816;
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.421 -0400", hash_original_method = "354AE2554D427EB20F769441D86A2B8E", hash_generated_method = "2F415A046EBCEB5501FC096115BA8687")
    @Override
    public void setupStartValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_1514647910 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_1514647910.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_1514647910.next();
            {
                node.animation.setupStartValues();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.430 -0400", hash_original_method = "E9CD39B5113CBC59DEA2E6258E1C2EDB", hash_generated_method = "35A90CE78A00E6F3657419E496910F04")
    @Override
    public void setupEndValues() {
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_966412778 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_966412778.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_966412778.next();
            {
                node.animation.setupEndValues();
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.377 -0400", hash_original_method = "BC0D581AF5A0D28CE21AB6B82F02A4C9", hash_generated_method = "8C969A9169FE5C5CC40AB235C6CF92ED")
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
                    boolean var9ACEE8033582BBDB9B4CB98E4081BA91_1700165047 = (oldListeners != null && oldListeners.size() > 0);
                    {
                        ArrayList<AnimatorListener> clonedListeners;
                        clonedListeners = new
                        ArrayList<AnimatorListener>(oldListeners);
                        {
                            Iterator<AnimatorListener> var3139CC75491E20BD070F538CEF2A01BC_1345140273 = (clonedListeners).iterator();
                            var3139CC75491E20BD070F538CEF2A01BC_1345140273.hasNext();
                            AnimatorListener listener = var3139CC75491E20BD070F538CEF2A01BC_1345140273.next();
                            {
                                {
                                    node.animation.removeListener(listener);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
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
                } 
                {
                    boolean varE407B8E8668F490B90923B90830F3953_487582785 = (node.dependencies == null || node.dependencies.size() == 0);
                    {
                        nodesToStart.add(node);
                    } 
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
                            } 
                        } 
                        node.tmpDependencies = (ArrayList<Dependency>) node.dependencies.clone();
                    } 
                } 
                node.animation.addListener(mSetListener);
            } 
        } 
        {
            {
                Iterator<Node> var6627A46BC32D1BB288C28BACC946CACC_1963816020 = (nodesToStart).iterator();
                var6627A46BC32D1BB288C28BACC946CACC_1963816020.hasNext();
                Node node = var6627A46BC32D1BB288C28BACC946CACC_1963816020.next();
                {
                    node.animation.start();
                    mPlayingSet.add(node.animation);
                } 
            } 
        } 
        {
            mDelayAnim = ValueAnimator.ofFloat(0f, 1f);
            mDelayAnim.setDuration(mStartDelay);
            mDelayAnim.addListener(new AnimatorListenerAdapter() {                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.341 -0400", hash_original_field = "990982D89CFB60D5939A88FB81C4FE88", hash_generated_field = "41402EB62AB9E9D5CBE01FDA6E9433EB")
                boolean canceled = false;
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.359 -0400", hash_original_method = "BE87F1813CBA8EA740D5C2234F834512", hash_generated_method = "F05C5FC7C3998BE3DF1CA0A34A4A4332")
                public void onAnimationCancel(Animator anim) {
                    
                    canceled = true;
                    addTaint(anim.getTaint());
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.375 -0400", hash_original_method = "445AE985C63B218AFF9EAABB75FAC581", hash_generated_method = "0232A4558E61F61B922B5B1476945205")
                public void onAnimationEnd(Animator anim) {
                    
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
                            } 
                        } 
                    } 
                    addTaint(anim.getTaint());
                    
                    
                        
                        
                            
                            
                            
                        
                    
                }
});
            mDelayAnim.start();
        } 
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
                } 
            } 
        } 
        {
            boolean varE5C319B3E9148866563870C4DF81C81D_817336301 = (mNodes.size() == 0 && mStartDelay == 0);
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
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.500 -0400", hash_original_method = "7A64C2F75A97591C0B8FCD807815163D", hash_generated_method = "FFF2666F0223BFCA816A1B039F37B5DA")
    @Override
    public AnimatorSet clone() {
        AnimatorSet varB4EAC82CA7396A68D541C85D26508E83_2142363656 = null; 
        final AnimatorSet anim = (AnimatorSet) super.clone();
        anim.mNeedsSort = true;
        anim.mTerminated = false;
        anim.mStarted = false;
        anim.mPlayingSet = new ArrayList<Animator>();
        anim.mNodeMap = new HashMap<Animator, Node>();
        anim.mNodes = new ArrayList<Node>();
        anim.mSortedNodes = new ArrayList<Node>();
        HashMap<Node, Node> nodeCloneMap = new HashMap<Node, Node>();
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_2092399092 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_2092399092.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_2092399092.next();
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
                {
                    ArrayList<AnimatorListener> listenersToRemove = null;
                    {
                        Iterator<AnimatorListener> varD7B40EC36D902B674F9251BD59AD5B02_92486377 = (cloneListeners).iterator();
                        varD7B40EC36D902B674F9251BD59AD5B02_92486377.hasNext();
                        AnimatorListener listener = varD7B40EC36D902B674F9251BD59AD5B02_92486377.next();
                        {
                            {
                                {
                                    listenersToRemove = new ArrayList<AnimatorListener>();
                                } 
                                listenersToRemove.add(listener);
                            } 
                        } 
                    } 
                    {
                        {
                            Iterator<AnimatorListener> varCBAA8D83D3B98A5F09C128BBCC8C530B_691543863 = (listenersToRemove).iterator();
                            varCBAA8D83D3B98A5F09C128BBCC8C530B_691543863.hasNext();
                            AnimatorListener listener = varCBAA8D83D3B98A5F09C128BBCC8C530B_691543863.next();
                            {
                                cloneListeners.remove(listener);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            Iterator<Node> var554B648076DEF086CAED206F4C9E909E_96345275 = (mNodes).iterator();
            var554B648076DEF086CAED206F4C9E909E_96345275.hasNext();
            Node node = var554B648076DEF086CAED206F4C9E909E_96345275.next();
            {
                Node nodeClone = nodeCloneMap.get(node);
                {
                    {
                        Iterator<Dependency> var253BE40EA2AE0291BE9458DD3CF55453_599974295 = (node.dependencies).iterator();
                        var253BE40EA2AE0291BE9458DD3CF55453_599974295.hasNext();
                        Dependency dependency = var253BE40EA2AE0291BE9458DD3CF55453_599974295.next();
                        {
                            Node clonedDependencyNode = nodeCloneMap.get(dependency.node);
                            Dependency cloneDependency = new Dependency(clonedDependencyNode,
                            dependency.rule);
                            nodeClone.addDependency(cloneDependency);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2142363656 = anim;
        varB4EAC82CA7396A68D541C85D26508E83_2142363656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2142363656;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.506 -0400", hash_original_method = "FF30C4A715862D404FA915E9EED652EB", hash_generated_method = "34D5D47218EC257828B7F16A372B4745")
    private void sortNodes() {
        {
            mSortedNodes.clear();
            ArrayList<Node> roots = new ArrayList<Node>();
            int numNodes = mNodes.size();
            {
                int i = 0;
                {
                    Node node = mNodes.get(i);
                    {
                        boolean var0D1480BBE27A084BABF64DD1A6FC3773_1873717351 = (node.dependencies == null || node.dependencies.size() == 0);
                        {
                            roots.add(node);
                        } 
                    } 
                } 
            } 
            ArrayList<Node> tmpRoots = new ArrayList<Node>();
            {
                boolean varD630A3AB67E7A5775827EF03845CAC5C_1785864041 = (roots.size() > 0);
                {
                    int numRoots = roots.size();
                    {
                        int i = 0;
                        {
                            Node root = roots.get(i);
                            mSortedNodes.add(root);
                            {
                                int numDependents = root.nodeDependents.size();
                                {
                                    int j = 0;
                                    {
                                        Node node = root.nodeDependents.get(j);
                                        node.nodeDependencies.remove(root);
                                        {
                                            boolean var21891AE5AAFE8EB96113B08DED5B940C_1851583067 = (node.nodeDependencies.size() == 0);
                                            {
                                                tmpRoots.add(node);
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    roots.clear();
                    roots.addAll(tmpRoots);
                    tmpRoots.clear();
                } 
            } 
            mNeedsSort = false;
            {
                boolean varDD5278C4A821B04466EA81991E002294_909885490 = (mSortedNodes.size() != mNodes.size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Circular dependencies cannot exist"
                        + " in AnimatorSet");
                } 
            } 
        } 
        {
            int numNodes = mNodes.size();
            {
                int i = 0;
                {
                    Node node = mNodes.get(i);
                    {
                        boolean var60187AACFF822DE3E56322B4A4D489FB_208767171 = (node.dependencies != null && node.dependencies.size() > 0);
                        {
                            int numDependencies = node.dependencies.size();
                            {
                                int j = 0;
                                {
                                    Dependency dependency = node.dependencies.get(j);
                                    {
                                        node.nodeDependencies = new ArrayList<Node>();
                                    } 
                                    {
                                        boolean varF4A971F3E1E7ED2E8AD23CBB7EC95189_872340548 = (!node.nodeDependencies.contains(dependency.node));
                                        {
                                            node.nodeDependencies.add(dependency.node);
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                    node.done = false;
                } 
            } 
        } 
        
        
    }

    
    private static class DependencyListener implements AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.507 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.508 -0400", hash_original_field = "B109B7F70AB8D395A8E61064383C52BC", hash_generated_field = "298BE469E9769EF16537BF922B91FDA5")

        private Node mNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.508 -0400", hash_original_field = "C29D48DB82CAC5F7D6125EB9E5BDD4B3", hash_generated_field = "F35AEC1D0C05BC027541025D8E7C024E")

        private int mRule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.510 -0400", hash_original_method = "14BF3BE2BFE19AED1CD60C8FAD308911", hash_generated_method = "2CEF4FD9DA42A82DAEC47138680208B3")
        public  DependencyListener(AnimatorSet animatorSet, Node node, int rule) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = rule;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.511 -0400", hash_original_method = "16FF962612CA0CC38B4765F38064800C", hash_generated_method = "C2873E3A5F96230B9841E1221FD8122E")
        public void onAnimationCancel(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.513 -0400", hash_original_method = "E0F66F3A2F7DEFA05E43170D7FDC6E81", hash_generated_method = "7300700F99E8AA30766F21D7E3F32AD5")
        public void onAnimationEnd(Animator animation) {
            
            {
                startIfReady(animation);
            } 
            addTaint(animation.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.514 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.516 -0400", hash_original_method = "C319AA8CE810AC3271C178BB34DF8E30", hash_generated_method = "A948E6845DD4322DA93742FD24A3E7F7")
        public void onAnimationStart(Animator animation) {
            
            {
                startIfReady(animation);
            } 
            addTaint(animation.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.519 -0400", hash_original_method = "AF711F2A0E7E526F8B6CE8D71F56AFBE", hash_generated_method = "9B0136DFF28D77E816F453304EE83221")
        private void startIfReady(Animator dependencyAnimation) {
            Dependency dependencyToRemove = null;
            int numDependencies = mNode.tmpDependencies.size();
            {
                int i = 0;
                {
                    Dependency dependency = mNode.tmpDependencies.get(i);
                    {
                        dependencyToRemove = dependency;
                        dependencyAnimation.removeListener(this);
                    } 
                } 
            } 
            mNode.tmpDependencies.remove(dependencyToRemove);
            {
                boolean var87E4D5B3F0E82C7E3E2C2DE17D172229_2040708032 = (mNode.tmpDependencies.size() == 0);
                {
                    mNode.animation.start();
                    mAnimatorSet.mPlayingSet.add(mNode.animation);
                } 
            } 
            addTaint(dependencyAnimation.getTaint());
            
            
        }

        
    }


    
    private class AnimatorSetListener implements AnimatorListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.520 -0400", hash_original_field = "F6DD1E5B795EEAE98967652B45A2FB6C", hash_generated_field = "26BB44EB69421663EACF2A18D0E63EFE")

        private AnimatorSet mAnimatorSet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.521 -0400", hash_original_method = "F7A8B618CE707AD8B38E15DFED3CE3FB", hash_generated_method = "5149E3B3F385A46C24F32667B339D036")
          AnimatorSetListener(AnimatorSet animatorSet) {
            mAnimatorSet = animatorSet;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.522 -0400", hash_original_method = "BE6E1E1BF0ACB2CE5581D6C3A3287656", hash_generated_method = "57BFC833D8C5D100A395A64335960A96")
        public void onAnimationCancel(Animator animation) {
            
            {
                {
                    boolean varA027FC078EF92D056A51186849417200_464601184 = (mPlayingSet.size() == 0);
                    {
                        {
                            int numListeners = mListeners.size();
                            {
                                int i = 0;
                                {
                                    mListeners.get(i).onAnimationCancel(mAnimatorSet);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            addTaint(animation.getTaint());
            
            
                
                    
                        
                        
                            
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.609 -0400", hash_original_method = "18180E214611C82656F1013B7F322C73", hash_generated_method = "7798694BA09D3683A20484EFC302F89A")
        @SuppressWarnings("unchecked")
        public void onAnimationEnd(Animator animation) {
            
            animation.removeListener(this);
            mPlayingSet.remove(animation);
            Node animNode = mAnimatorSet.mNodeMap.get(animation);
            animNode.done = true;
            {
                ArrayList<Node> sortedNodes = mAnimatorSet.mSortedNodes;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
                {
                    int i = 0;
                    {
                        {
                            boolean varAF8C797863CB13C46D6EC7230251F511_1035623840 = (!sortedNodes.get(i).done);
                            {
                                allDone = false;
                            } 
                        } 
                    } 
                } 
                {
                    {
                        ArrayList<AnimatorListener> tmpListeners = (ArrayList<AnimatorListener>) mListeners.clone();
                        int numListeners = tmpListeners.size();
                        {
                            int i = 0;
                            {
                                tmpListeners.get(i).onAnimationEnd(mAnimatorSet);
                            } 
                        } 
                    } 
                    mAnimatorSet.mStarted = false;
                } 
            } 
            addTaint(animation.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.611 -0400", hash_original_method = "FA58700A4888ED9E658B43737D17A966", hash_generated_method = "2CC49AF6623F4CFFEDAE2EE5FA4412D5")
        public void onAnimationRepeat(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.612 -0400", hash_original_method = "B990D1A680B01C8A5486D22741D7E96B", hash_generated_method = "4F1E500BA39728FB7A49E02540A0C5AA")
        public void onAnimationStart(Animator animation) {
            
            addTaint(animation.getTaint());
            
        }

        
    }


    
    private static class Dependency {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.613 -0400", hash_original_field = "36C4536996CA5615DCF9911F068786DC", hash_generated_field = "220314E1B8A64C8F8406491E2C312A28")

        public Node node;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.614 -0400", hash_original_field = "981C1E7B3795DA18687613FBD66D4954", hash_generated_field = "5BCB5D76D9FE8D00C97FD248D276BEFB")

        public int rule;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.615 -0400", hash_original_method = "762AEC0CFA60BDA08F8DF742864617B6", hash_generated_method = "11E9E1642757F63DD999DD0DC47CC81E")
        public  Dependency(Node node, int rule) {
            this.node = node;
            this.rule = rule;
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.615 -0400", hash_original_field = "1334D2D6495806F754F66024F08499AE", hash_generated_field = "D2E63A1F901C713BA822C6F070CEAD0C")

        static final int WITH = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.616 -0400", hash_original_field = "DA0977069E1F00C63DBCD6472D3A83BD", hash_generated_field = "B2EDF4A77A9D7AC10EE81BB78B2A3B97")

        static final int AFTER = 1;
    }


    
    private static class Node implements Cloneable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.616 -0400", hash_original_field = "6F1C25ED1523962F1BBF9DEE9BE5092B", hash_generated_field = "85D1EE31923D44CB9D3110ADDD29D65D")

        public Animator animation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.617 -0400", hash_original_field = "3341DF3F2BE5741254627C20B0B01F51", hash_generated_field = "46C94882CA4285AE3FB52FBE346AC349")

        public ArrayList<Dependency> dependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.617 -0400", hash_original_field = "200E0333937676F14E2E34EDC6377C4C", hash_generated_field = "B8C6459C87326A52248B3A69C1AD5ACC")

        public ArrayList<Dependency> tmpDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.618 -0400", hash_original_field = "47751C8F1D02529930E31B5653CEA54A", hash_generated_field = "4B254F155DE5D18E0880E4E9DEF81A08")

        public ArrayList<Node> nodeDependencies = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.618 -0400", hash_original_field = "974D2A11D6D39C71254A79C0E7E4343C", hash_generated_field = "D83CBAAD32ACD2DF620D72FD4EEEA1F1")

        public ArrayList<Node> nodeDependents = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.618 -0400", hash_original_field = "FDA23B4A7B8EA42DC9AD75FF5257DE8D", hash_generated_field = "3C1F0C530EFFEA18D19D1DCE04D244D2")

        public boolean done = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.619 -0400", hash_original_method = "003188EC42D875435178AF0E478B9BB9", hash_generated_method = "C7E970336EB0D2C23CBE821EB59549EA")
        public  Node(Animator animation) {
            this.animation = animation;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.622 -0400", hash_original_method = "A5D3F28C11D8E50179A44FB484206D0C", hash_generated_method = "D15DD2DED209EA7CC34D66FED03C238F")
        public void addDependency(Dependency dependency) {
            {
                dependencies = new ArrayList<Dependency>();
                nodeDependencies = new ArrayList<Node>();
            } 
            dependencies.add(dependency);
            {
                boolean var9E27E0C5E8A816EDD775D65EEBC2A7AE_69463556 = (!nodeDependencies.contains(dependency.node));
                {
                    nodeDependencies.add(dependency.node);
                } 
            } 
            Node dependencyNode = dependency.node;
            {
                dependencyNode.nodeDependents = new ArrayList<Node>();
            } 
            dependencyNode.nodeDependents.add(this);
            addTaint(dependency.getTaint());
            
            
                
                
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.625 -0400", hash_original_method = "DEE80C65840F010A2F5E3A56F885F02B", hash_generated_method = "B9BC480CC9F9F8AB6CDA2FD28AAD620E")
        @Override
        public Node clone() {
            Node varB4EAC82CA7396A68D541C85D26508E83_1525837639 = null; 
            try 
            {
                Node node = (Node) super.clone();
                node.animation = (Animator) animation.clone();
                varB4EAC82CA7396A68D541C85D26508E83_1525837639 = node;
            } 
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1525837639.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1525837639;
            
            
                
                
                
            
               
            
        }

        
    }


    
    public class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.626 -0400", hash_original_field = "804B3EF3A920EEBB8C5E4C902948FD7E", hash_generated_field = "A3A3172265405E9566BFFCC4660589E1")

        private Node mCurrentNode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.630 -0400", hash_original_method = "B0114D66E7DF09FC47A74BA216B98164", hash_generated_method = "D400691F8684211CE780557AB7EE40C2")
          Builder(Animator anim) {
            mCurrentNode = mNodeMap.get(anim);
            {
                mCurrentNode = new Node(anim);
                mNodeMap.put(anim, mCurrentNode);
                mNodes.add(mCurrentNode);
            } 
            
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.640 -0400", hash_original_method = "B05ED6D6B491946B79783B58A8AC02E5", hash_generated_method = "11EA6E92A3088573D80DA7E4C965C7CA")
        public Builder with(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1521645420 = null; 
            Node node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } 
            Dependency dependency = new Dependency(mCurrentNode, Dependency.WITH);
            node.addDependency(dependency);
            varB4EAC82CA7396A68D541C85D26508E83_1521645420 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1521645420.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1521645420;
            
            
            
                
                
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.650 -0400", hash_original_method = "115926E0469E8C75055FFE822D9B435C", hash_generated_method = "E9619698092262F32E33FD3CFC6BF375")
        public Builder before(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_297955380 = null; 
            Node node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } 
            Dependency dependency = new Dependency(mCurrentNode, Dependency.AFTER);
            node.addDependency(dependency);
            varB4EAC82CA7396A68D541C85D26508E83_297955380 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_297955380.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_297955380;
            
            
            
                
                
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.659 -0400", hash_original_method = "83E010DE5FB75637ACD6CFFBA4AB1D7F", hash_generated_method = "F967F0E822333A53436C608BD75859F5")
        public Builder after(Animator anim) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1379484137 = null; 
            Node node = mNodeMap.get(anim);
            {
                node = new Node(anim);
                mNodeMap.put(anim, node);
                mNodes.add(node);
            } 
            Dependency dependency = new Dependency(node, Dependency.AFTER);
            mCurrentNode.addDependency(dependency);
            varB4EAC82CA7396A68D541C85D26508E83_1379484137 = this;
            addTaint(anim.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1379484137.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1379484137;
            
            
            
                
                
                
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:11.667 -0400", hash_original_method = "5E60D6733644E2424482AFF107063E09", hash_generated_method = "1FA87B06849258A1F9E446ABB9AABA1C")
        public Builder after(long delay) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1456134705 = null; 
            ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
            anim.setDuration(delay);
            after(anim);
            varB4EAC82CA7396A68D541C85D26508E83_1456134705 = this;
            addTaint(delay);
            varB4EAC82CA7396A68D541C85D26508E83_1456134705.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1456134705;
            
            
            
            
            
        }

        
    }


    
}

