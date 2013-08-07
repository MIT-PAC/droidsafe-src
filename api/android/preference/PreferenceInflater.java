package android.preference;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;

import com.android.internal.util.XmlUtils;




class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.650 -0400", hash_original_field = "D1487CA8252F4AA0A95324AB4DDD5316", hash_generated_field = "13262EB3751B753EEB3302EF75D8B1E5")

    private PreferenceManager mPreferenceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.650 -0400", hash_original_method = "50527EB8D19F2F0D64584B04C3D41EF2", hash_generated_method = "3AC8636CE3A2B25D5F0AC6173BE6EB23")
    public  PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        addTaint(preferenceManager.getTaint());
        addTaint(context.getTaint());
        init(preferenceManager);
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.654 -0400", hash_original_method = "CBCBABB7FE70B103F3E123A80F4BFEB8", hash_generated_method = "759351EECEA66993392A126F9FE6E27C")
      PreferenceInflater(GenericInflater<Preference, PreferenceGroup> original, PreferenceManager preferenceManager, Context newContext) {
        super(original, newContext);
        addTaint(newContext.getTaint());
        addTaint(preferenceManager.getTaint());
        addTaint(original.getTaint());
        init(preferenceManager);
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.655 -0400", hash_original_method = "FF1F94752C869BA06052B7A67A109910", hash_generated_method = "E8A0CDC6F7C7DD633F9FF716A090F16A")
    @Override
    public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context newContext) {
        addTaint(newContext.getTaint());
GenericInflater<Preference, PreferenceGroup> varDC7DDB264446171E53B77F6F68C4AD64_1317841494 =         new PreferenceInflater(this, mPreferenceManager, newContext);
        varDC7DDB264446171E53B77F6F68C4AD64_1317841494.addTaint(taint);
        return varDC7DDB264446171E53B77F6F68C4AD64_1317841494;
        // ---------- Original Method ----------
        //return new PreferenceInflater(this, mPreferenceManager, newContext);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.655 -0400", hash_original_method = "7B227AC4C6BF5338AF52F597A9EDC5E2", hash_generated_method = "97D721084DFEECEA5417B367F5EF73D1")
    private void init(PreferenceManager preferenceManager) {
        mPreferenceManager = preferenceManager;
        setDefaultPackage("android.preference.");
        // ---------- Original Method ----------
        //mPreferenceManager = preferenceManager;
        //setDefaultPackage("android.preference.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.657 -0400", hash_original_method = "295C055EC64DF7189FE6DF67209CBBC4", hash_generated_method = "46BD23B1206B2ED50D6BC343F35C4E98")
    @Override
    protected boolean onCreateCustomFromTag(XmlPullParser parser, Preference parentPreference,
            AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(attrs.getTaint());
        addTaint(parentPreference.getTaint());
        addTaint(parser.getTaint());
        final String tag = parser.getName();
        if(tag.equals(INTENT_TAG_NAME))        
        {
            Intent intent = null;
            try 
            {
                intent = Intent.parseIntent(getContext().getResources(), parser, attrs);
            } //End block
            catch (IOException e)
            {
                XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                ex.initCause(e);
                ex.addTaint(taint);
                throw ex;
            } //End block
            if(intent != null)            
            {
                parentPreference.setIntent(intent);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1205033843 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588822963 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588822963;
        } //End block
        else
        if(tag.equals(EXTRA_TAG_NAME))        
        {
            getContext().getResources().parseBundleExtra(EXTRA_TAG_NAME, attrs,
                    parentPreference.getExtras());
            try 
            {
                XmlUtils.skipCurrentTag(parser);
            } //End block
            catch (IOException e)
            {
                XmlPullParserException ex = new XmlPullParserException(
                        "Error parsing preference");
                ex.initCause(e);
                ex.addTaint(taint);
                throw ex;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_552643424 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089673182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089673182;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1446458362 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903561148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903561148;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.661 -0400", hash_original_method = "677330D7578A225E3A8F3B018B853A0C", hash_generated_method = "3BC39A2ED39C74DE00DF5F8CE2873AD4")
    @Override
    protected PreferenceGroup onMergeRoots(PreferenceGroup givenRoot, boolean attachToGivenRoot,
            PreferenceGroup xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(xmlRoot.getTaint());
        addTaint(attachToGivenRoot);
        addTaint(givenRoot.getTaint());
        if(givenRoot == null)        
        {
            xmlRoot.onAttachedToHierarchy(mPreferenceManager);
PreferenceGroup varCBFCBF588E89F8CE897CCC58BE8F27B0_1108175871 =             xmlRoot;
            varCBFCBF588E89F8CE897CCC58BE8F27B0_1108175871.addTaint(taint);
            return varCBFCBF588E89F8CE897CCC58BE8F27B0_1108175871;
        } //End block
        else
        {
PreferenceGroup var8684B8CF102173B1E0B883EE19F403C8_1420507547 =             givenRoot;
            var8684B8CF102173B1E0B883EE19F403C8_1420507547.addTaint(taint);
            return var8684B8CF102173B1E0B883EE19F403C8_1420507547;
        } //End block
        // ---------- Original Method ----------
        //if (givenRoot == null) {
            //xmlRoot.onAttachedToHierarchy(mPreferenceManager);
            //return xmlRoot;
        //} else {
            //return givenRoot;
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.662 -0400", hash_original_field = "CC8ACA106F6290F3A7C71CC6BC7F2325", hash_generated_field = "51862D8DBF3975C527844ECFFE8161D7")

    private static final String TAG = "PreferenceInflater";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.662 -0400", hash_original_field = "1D953FC9E39CE8F449C111E1CEABB7F3", hash_generated_field = "92DCFA625A163150FAF710C1B8511031")

    private static final String INTENT_TAG_NAME = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.662 -0400", hash_original_field = "82F944EA1D0CD5852D3BD9F756FE9CEE", hash_generated_field = "7482A4F6F924E88A63D3F01DD26DE8B7")

    private static final String EXTRA_TAG_NAME = "extra";
}

