package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.app.AliasActivity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;

class PreferenceInflater extends GenericInflater<Preference, PreferenceGroup> {
    private PreferenceManager mPreferenceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.694 -0400", hash_original_method = "50527EB8D19F2F0D64584B04C3D41EF2", hash_generated_method = "B05E63022534BCA9A3BAC3C90F40D6A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        super(context);
        dsTaint.addTaint(preferenceManager.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        init(preferenceManager);
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.694 -0400", hash_original_method = "CBCBABB7FE70B103F3E123A80F4BFEB8", hash_generated_method = "8EADDA3F76D823C220D89DFAA845BF1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     PreferenceInflater(GenericInflater<Preference, PreferenceGroup> original, PreferenceManager preferenceManager, Context newContext) {
        super(original, newContext);
        dsTaint.addTaint(newContext.dsTaint);
        dsTaint.addTaint(preferenceManager.dsTaint);
        dsTaint.addTaint(original.dsTaint);
        init(preferenceManager);
        // ---------- Original Method ----------
        //init(preferenceManager);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.695 -0400", hash_original_method = "FF1F94752C869BA06052B7A67A109910", hash_generated_method = "83CCBC6B43DB11E8BCEC3BEEFF5E109A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public GenericInflater<Preference, PreferenceGroup> cloneInContext(Context newContext) {
        dsTaint.addTaint(newContext.dsTaint);
        GenericInflater<Preference, PreferenceGroup> varB09E589CD05BFB173DC590A570A0585B_37414562 = (new PreferenceInflater(this, mPreferenceManager, newContext));
        return (GenericInflater<Preference, PreferenceGroup>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new PreferenceInflater(this, mPreferenceManager, newContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.695 -0400", hash_original_method = "7B227AC4C6BF5338AF52F597A9EDC5E2", hash_generated_method = "B9DB4BE304E6C7D69C3395C040F1FD15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(PreferenceManager preferenceManager) {
        dsTaint.addTaint(preferenceManager.dsTaint);
        setDefaultPackage("android.preference.");
        // ---------- Original Method ----------
        //mPreferenceManager = preferenceManager;
        //setDefaultPackage("android.preference.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.696 -0400", hash_original_method = "295C055EC64DF7189FE6DF67209CBBC4", hash_generated_method = "4DA4632D4C871407BFD0DDD9C6ECF210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean onCreateCustomFromTag(XmlPullParser parser, Preference parentPreference,
            AttributeSet attrs) throws XmlPullParserException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(parentPreference.dsTaint);
        dsTaint.addTaint(parser.dsTaint);
        String tag;
        tag = parser.getName();
        {
            boolean var5BE944252877569CC94E888792E6D758_1897327362 = (tag.equals(INTENT_TAG_NAME));
            {
                Intent intent;
                intent = null;
                try 
                {
                    intent = Intent.parseIntent(getContext().getResources(), parser, attrs);
                } //End block
                catch (IOException e)
                {
                    XmlPullParserException ex;
                    ex = new XmlPullParserException(
                        "Error parsing preference");
                    ex.initCause(e);
                    if (DroidSafeAndroidRuntime.control) throw ex;
                } //End block
                {
                    parentPreference.setIntent(intent);
                } //End block
            } //End block
            {
                boolean varFA18FB7EC231D2706E0747E224A5CB67_228969400 = (tag.equals(EXTRA_TAG_NAME));
                {
                    getContext().getResources().parseBundleExtra(EXTRA_TAG_NAME, attrs,
                    parentPreference.getExtras());
                    try 
                    {
                        XmlUtils.skipCurrentTag(parser);
                    } //End block
                    catch (IOException e)
                    {
                        XmlPullParserException ex;
                        ex = new XmlPullParserException(
                        "Error parsing preference");
                        ex.initCause(e);
                        if (DroidSafeAndroidRuntime.control) throw ex;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.696 -0400", hash_original_method = "677330D7578A225E3A8F3B018B853A0C", hash_generated_method = "39A989201178844634956BE93478CBC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected PreferenceGroup onMergeRoots(PreferenceGroup givenRoot, boolean attachToGivenRoot,
            PreferenceGroup xmlRoot) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(givenRoot.dsTaint);
        dsTaint.addTaint(xmlRoot.dsTaint);
        dsTaint.addTaint(attachToGivenRoot);
        {
            xmlRoot.onAttachedToHierarchy(mPreferenceManager);
        } //End block
        return (PreferenceGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (givenRoot == null) {
            //xmlRoot.onAttachedToHierarchy(mPreferenceManager);
            //return xmlRoot;
        //} else {
            //return givenRoot;
        //}
    }

    
    private static final String TAG = "PreferenceInflater";
    private static final String INTENT_TAG_NAME = "intent";
    private static final String EXTRA_TAG_NAME = "extra";
}

