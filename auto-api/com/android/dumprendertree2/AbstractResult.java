package com.android.dumprendertree2;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class AbstractResult implements Comparable<AbstractResult>, Serializable {
    private static String LOG_TAG = "AbstractResult";
    String mAdditionalTextOutputString;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.081 -0400", hash_original_method = "296DBF04E21511E0EF2815A125E80F5B", hash_generated_method = "9CFFB2C7F30CAE63D252FCAFCA6CF54E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(AbstractResult another) {
        dsTaint.addTaint(another.dsTaint);
        int var148DC26F2EA98F31A7EBE971766CDF3D_953346020 = (getRelativePath().compareTo(another.getRelativePath()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getRelativePath().compareTo(another.getRelativePath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.091 -0400", hash_original_method = "DD750AAC14C1C3ED561AC26DC51FC1C0", hash_generated_method = "80F3F1AD05D108BC5EAA406F8E1C57EA")
    @DSModeled(DSC.SAFE)
    public void setAdditionalTextOutputString(String additionalTextOutputString) {
        dsTaint.addTaint(additionalTextOutputString);
        // ---------- Original Method ----------
        //mAdditionalTextOutputString = additionalTextOutputString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.099 -0400", hash_original_method = "5781DA2C13FF76E5E651EC66A4B32499", hash_generated_method = "1E17756E819214CE9BE60B8ACA783EAF")
    @DSModeled(DSC.SAFE)
    public String getAdditionalTextOutputString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAdditionalTextOutputString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.128 -0400", hash_original_method = "BEA5E5F0F8B74A8786DD7E55A31E91EC", hash_generated_method = "516D4FA90E12F70DC18EBF10CD568E7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getBytes() {
        ByteArrayOutputStream baos;
        baos = null;
        ObjectOutputStream oos;
        oos = null;
        try 
        {
            try 
            {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(this);
            } //End block
            finally 
            {
                {
                    baos.close();
                } //End block
                {
                    oos.close();
                } //End block
            } //End block
        } //End block
        catch (IOException e)
        { }
        {
            Object var99E4F7F59DC442B21AA2E171B7120389_445109754 = (baos.toByteArray());
        } //End flattened ternary
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //ByteArrayOutputStream baos = null;
        //ObjectOutputStream oos = null;
        //try {
            //try {
                //baos = new ByteArrayOutputStream();
                //oos = new ObjectOutputStream(baos);
                //oos.writeObject(this);
            //} finally {
                //if (baos != null) {
                    //baos.close();
                //}
                //if (oos != null) {
                    //oos.close();
                //}
            //}
        //} catch (IOException e) {
            //Log.e(LOG_TAG, "Unable to serialize result: " + getRelativePath(), e);
        //}
        //return baos == null ? null : baos.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.147 -0400", hash_original_method = "88ECAC63B18CE79C32E44B5ABAD6BFE1", hash_generated_method = "C672303CB6589EE1726A6421923135E8")
    public static AbstractResult create(byte[] bytes) {
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        AbstractResult result = null;
        try {
            try {
                bais = new ByteArrayInputStream(bytes);
                ois = new ObjectInputStream(bais);
                result = (AbstractResult)ois.readObject();
            } finally {
                if (bais != null) {
                    bais.close();
                }
                if (ois != null) {
                    ois.close();
                }
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Unable to deserialize result!", e);
        } catch (ClassNotFoundException e) {
            Log.e(LOG_TAG, "Unable to deserialize result!", e);
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.165 -0400", hash_original_method = "79BC3CF45F98EA17DA105C97A0046913", hash_generated_method = "832090FF34FE9772DE9A9078C8D27ECD")
    @DSModeled(DSC.SAFE)
    public void clearResults() {
        mAdditionalTextOutputString = null;
        // ---------- Original Method ----------
        //mAdditionalTextOutputString = null;
    }

    
    public abstract void obtainActualResults(WebView webview, Message resultObtainedMsg);

    
    public abstract void setExpectedImageResult(byte[] expectedResult);

    
    public abstract void setExpectedImageResultPath(String relativePath);

    
    public abstract String getExpectedImageResultPath();

    
    public abstract void setExpectedTextResult(String expectedResult);

    
    public abstract void setExpectedTextResultPath(String relativePath);

    
    public abstract String getExpectedTextResultPath();

    
    public abstract byte[] getActualImageResult();

    
    public abstract String getActualTextResult();

    
    public abstract ResultCode getResultCode();

    
    public abstract boolean didCrash();

    
    public abstract boolean didTimeOut();

    
    public abstract void setDidTimeOut();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:16:15.204 -0400", hash_original_method = "5FE12E9604ACFCD53F8125F889E53F1E", hash_generated_method = "3231E8962304C993E4F190DCCF1EC775")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean didPass() {
        boolean varAEED9C880AFDB31BEDE29754EB2A7D24_1783845577 = (!didCrash() && !didTimeOut() && getResultCode() == ResultCode.RESULTS_MATCH);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //assert !(didCrash() && didTimeOut());
        //assert !(didCrash() && getResultCode() != ResultCode.NO_ACTUAL_RESULT);
        //return !didCrash() && !didTimeOut() && getResultCode() == ResultCode.RESULTS_MATCH;
    }

    
    public abstract TestType getType();

    
    public abstract String getRelativePath();

    
    public abstract String getDiffAsHtml();

    
    public abstract Bundle getBundle();

    
    public enum TestType {
        TEXT {
            @Override
            public AbstractResult createResult(Bundle bundle) {
                return new TextResult(bundle);
            }
        },
        RENDER_TREE {
            @Override
            public AbstractResult createResult(Bundle bundle) {
                return null;
            }
        };
        public abstract AbstractResult createResult(Bundle bundle);
    }

    
    public enum ResultCode implements Serializable {
        RESULTS_MATCH("Results match"),
        RESULTS_DIFFER("Results differ"),
        NO_EXPECTED_RESULT("No expected result"),
        NO_ACTUAL_RESULT("No actual result");
        private String mTitle;
        private ResultCode(String title) {
            mTitle = title;
        }
        @Override
        public String toString() {
            return mTitle;
        }
    }

    
}


