package com.android.dumprendertree2;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import name.fraser.neil.plaintext.diff_match_patch;
import java.util.LinkedList;

public class TextResult extends AbstractResult {
    private static int MSG_DOCUMENT_AS_TEXT = 0;
    private String mExpectedResult;
    private String mExpectedResultPath;
    private String mActualResult;
    private String mRelativePath;
    private boolean mDidTimeOut;
    private ResultCode mResultCode;
    transient private Message mResultObtainedMsg;
    private boolean mDumpChildFramesAsText;
    transient private Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.260 -0400", hash_original_method = "DA70965CB666200C4279BBA75F20D595", hash_generated_method = "F89D6183A9EA2A714D50DE125229D6DC")
        @DSModeled(DSC.SAFE)
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            {
                mActualResult = (String)msg.obj;
                mResultObtainedMsg.sendToTarget();
            } //End block
            // ---------- Original Method ----------
            //if (msg.what == MSG_DOCUMENT_AS_TEXT) {
                //mActualResult = (String)msg.obj;
                //mResultObtainedMsg.sendToTarget();
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.271 -0400", hash_original_method = "5147B76275071BA9DFF9BE1CC9EFFF8A", hash_generated_method = "74BD2A440C3F4A5C28F426233EC23791")
    @DSModeled(DSC.SAFE)
    public TextResult(String relativePath) {
        dsTaint.addTaint(relativePath);
        // ---------- Original Method ----------
        //mRelativePath = relativePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.289 -0400", hash_original_method = "57B21B7B64091FA42B15BF7EF1E790FD", hash_generated_method = "226033E1CDEEB72A168643B558B8BD11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextResult(Bundle bundle) {
        dsTaint.addTaint(bundle.dsTaint);
        mExpectedResult = bundle.getString("expectedTextualResult");
        mExpectedResultPath = bundle.getString("expectedTextualResultPath");
        mActualResult = bundle.getString("actualTextualResult");
        setAdditionalTextOutputString(bundle.getString("additionalTextOutputString"));
        mRelativePath = bundle.getString("relativePath");
        mDidTimeOut = bundle.getBoolean("didTimeOut");
        // ---------- Original Method ----------
        //mExpectedResult = bundle.getString("expectedTextualResult");
        //mExpectedResultPath = bundle.getString("expectedTextualResultPath");
        //mActualResult = bundle.getString("actualTextualResult");
        //setAdditionalTextOutputString(bundle.getString("additionalTextOutputString"));
        //mRelativePath = bundle.getString("relativePath");
        //mDidTimeOut = bundle.getBoolean("didTimeOut");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.301 -0400", hash_original_method = "FAD1B592E3CA0F7B226A5F4DF6307435", hash_generated_method = "3AB7298F068DF48A3259CE2C8B08BF37")
    @DSModeled(DSC.SAFE)
    public void setDumpChildFramesAsText(boolean dumpChildFramesAsText) {
        dsTaint.addTaint(dumpChildFramesAsText);
        // ---------- Original Method ----------
        //mDumpChildFramesAsText = dumpChildFramesAsText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.311 -0400", hash_original_method = "15D885547CD4BBD49092F51A6196182A", hash_generated_method = "4FE56C10CC1C2922B3646C67457D2C4A")
    @DSModeled(DSC.SAFE)
    @Override
    public void clearResults() {
        super.clearResults();
        mExpectedResult = null;
        mActualResult = null;
        // ---------- Original Method ----------
        //super.clearResults();
        //mExpectedResult = null;
        //mActualResult = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.334 -0400", hash_original_method = "048F05E57D15DF9CCA849D5C1EA34B5F", hash_generated_method = "5CBC4D63EA97A1BA8A3F82B435509BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ResultCode getResultCode() {
        {
            mResultCode = resultsMatch() ? AbstractResult.ResultCode.RESULTS_MATCH
                    : AbstractResult.ResultCode.RESULTS_DIFFER;
        } //End block
        return (ResultCode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mResultCode == null) {
            //mResultCode = resultsMatch() ? AbstractResult.ResultCode.RESULTS_MATCH
                    //: AbstractResult.ResultCode.RESULTS_DIFFER;
        //}
        //return mResultCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.357 -0400", hash_original_method = "42D783EE18D5CEABA112ECC4D4A19757", hash_generated_method = "B4BCE8A4B897270DEE9BE2A5565B7BA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean resultsMatch() {
        String leadingEmptyLines;
        leadingEmptyLines = "^\\n+";
        String trailingEmptyLines;
        trailingEmptyLines = "\\n+$";
        String trimmedExpectedResult;
        trimmedExpectedResult = mExpectedResult.replaceFirst(leadingEmptyLines, "")
                .replaceFirst(trailingEmptyLines, "");
        String trimmedActualResult;
        trimmedActualResult = mActualResult.replaceFirst(leadingEmptyLines, "")
                .replaceFirst(trailingEmptyLines, "");
        boolean var18CD153FC4E73DE92EBE36F688F04E5F_851357828 = (trimmedExpectedResult.equals(trimmedActualResult));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //assert mExpectedResult != null;
        //assert mActualResult != null;
        //String leadingEmptyLines = "^\\n+";
        //String trailingEmptyLines = "\\n+$";
        //String trimmedExpectedResult = mExpectedResult.replaceFirst(leadingEmptyLines, "")
                //.replaceFirst(trailingEmptyLines, "");
        //String trimmedActualResult = mActualResult.replaceFirst(leadingEmptyLines, "")
                //.replaceFirst(trailingEmptyLines, "");
        //return trimmedExpectedResult.equals(trimmedActualResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.365 -0400", hash_original_method = "0EA40FFC6DED4575CCB65077751E8A37", hash_generated_method = "51B660CF351A50302BB92965477F0B57")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean didCrash() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.373 -0400", hash_original_method = "DEAE3908D5755B035CF60EBAF85926AD", hash_generated_method = "756321372668D41FF13A078EDDC4ECC5")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean didTimeOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDidTimeOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.379 -0400", hash_original_method = "C9CBA15B5FDA091DED6969ECF1A0E3AA", hash_generated_method = "DC8CD1A60AD9BE68ECE0EF3BB39A442B")
    @DSModeled(DSC.SAFE)
    @Override
    public void setDidTimeOut() {
        mDidTimeOut = true;
        // ---------- Original Method ----------
        //mDidTimeOut = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.385 -0400", hash_original_method = "8F9AC94610EC33F03FD4617964E31F22", hash_generated_method = "9CA361FCB7429E719573418A12043662")
    @DSModeled(DSC.SAFE)
    @Override
    public byte[] getActualImageResult() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.396 -0400", hash_original_method = "E5740447E18E0CF3CEBB8E114D343701", hash_generated_method = "52F23923DDEC233FCE89D76643B22BB1")
    @DSModeled(DSC.SAFE)
    @Override
    public String getActualTextResult() {
        String additionalTextResultString;
        additionalTextResultString = getAdditionalTextOutputString();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String additionalTextResultString = getAdditionalTextOutputString();
        //if (additionalTextResultString != null) {
            //return additionalTextResultString + mActualResult;
        //}
        //return mActualResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.413 -0400", hash_original_method = "B5BCB138C30D4DCAED2BED1E2CA485AB", hash_generated_method = "389B6DE6B7FCAA43BB6FC990DBDB0EAB")
    @DSModeled(DSC.SAFE)
    @Override
    public void setExpectedImageResult(byte[] expectedResult) {
        dsTaint.addTaint(expectedResult[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.417 -0400", hash_original_method = "6B4409CB1446FD2ED5D1B6C29C8A592E", hash_generated_method = "C60152419FB08DDB80D10FD28D322CB7")
    @DSModeled(DSC.SAFE)
    @Override
    public void setExpectedImageResultPath(String relativePath) {
        dsTaint.addTaint(relativePath);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.426 -0400", hash_original_method = "FCCC4B3A62A5C0167DF43E53D5014ADD", hash_generated_method = "18BA49541997E67E538E19B4F807BF23")
    @DSModeled(DSC.SAFE)
    @Override
    public String getExpectedImageResultPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.435 -0400", hash_original_method = "C033F732141C5B4749F07A49F54ECBD5", hash_generated_method = "63E33BA28603775416ECFBD64BC54E8C")
    @DSModeled(DSC.SAFE)
    @Override
    public void setExpectedTextResultPath(String relativePath) {
        dsTaint.addTaint(relativePath);
        // ---------- Original Method ----------
        //mExpectedResultPath = relativePath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.441 -0400", hash_original_method = "F2F1A1ED7E3AD23752297DAD1E7D2B9C", hash_generated_method = "2706D0763B4CAEE23319F52ACDD9F63A")
    @DSModeled(DSC.SAFE)
    @Override
    public String getExpectedTextResultPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mExpectedResultPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.448 -0400", hash_original_method = "F8D59763DEFA9F8D85B6AA8B1C0E5E90", hash_generated_method = "AC665254848F3B7B4CF661D32AF97A2D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setExpectedTextResult(String expectedResult) {
        dsTaint.addTaint(expectedResult);
        mExpectedResult = expectedResult == null ? "" : expectedResult;
        // ---------- Original Method ----------
        //mExpectedResult = expectedResult == null ? "" : expectedResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.485 -0400", hash_original_method = "5424FD728057B0DC0C061F8D67871B86", hash_generated_method = "C6F9F5A4114AA00B904D30782585C9F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getDiffAsHtml() {
        StringBuilder html;
        html = new StringBuilder();
        html.append("<table class=\"visual_diff\">");
        html.append("    <tr class=\"headers\">");
        html.append("        <td colspan=\"2\">Expected result:</td>");
        html.append("        <td class=\"space\"></td>");
        html.append("        <td colspan=\"2\">Actual result:</td>");
        html.append("    </tr>");
        appendDiffHtml(html);
        html.append("    <tr class=\"footers\">");
        html.append("        <td colspan=\"2\"></td>");
        html.append("        <td class=\"space\"></td>");
        html.append("        <td colspan=\"2\"></td>");
        html.append("    </tr>");
        html.append("</table>");
        String var8193F61828E4186E5041F20E7074DDF7_859908896 = (html.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //assert mExpectedResult != null;
        //assert mActualResult != null;
        //StringBuilder html = new StringBuilder();
        //html.append("<table class=\"visual_diff\">");
        //html.append("    <tr class=\"headers\">");
        //html.append("        <td colspan=\"2\">Expected result:</td>");
        //html.append("        <td class=\"space\"></td>");
        //html.append("        <td colspan=\"2\">Actual result:</td>");
        //html.append("    </tr>");
        //appendDiffHtml(html);
        //html.append("    <tr class=\"footers\">");
        //html.append("        <td colspan=\"2\"></td>");
        //html.append("        <td class=\"space\"></td>");
        //html.append("        <td colspan=\"2\"></td>");
        //html.append("    </tr>");
        //html.append("</table>");
        //return html.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.518 -0400", hash_original_method = "E8E096EC4382F8796F2593E77B897A21", hash_generated_method = "A8FBD056A6E212B8B3FE4E2F6FEAE43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void appendDiffHtml(StringBuilder html) {
        dsTaint.addTaint(html.dsTaint);
        LinkedList<diff_match_patch.Diff> diffs;
        diffs = new diff_match_patch().diff_main(mExpectedResult, mActualResult);
        diffs = VisualDiffUtils.splitDiffsOnNewline(diffs);
        LinkedList<String> expectedLines;
        expectedLines = new LinkedList<String>();
        LinkedList<Integer> expectedLineNums;
        expectedLineNums = new LinkedList<Integer>();
        LinkedList<String> actualLines;
        actualLines = new LinkedList<String>();
        LinkedList<Integer> actualLineNums;
        actualLineNums = new LinkedList<Integer>();
        VisualDiffUtils.generateExpectedResultLines(diffs, expectedLineNums, expectedLines);
        VisualDiffUtils.generateActualResultLines(diffs, actualLineNums, actualLines);
        html.append(VisualDiffUtils.getHtml(expectedLineNums, expectedLines,
                actualLineNums, actualLines));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.531 -0400", hash_original_method = "9A786E433EF85A914742F9FEB08DA569", hash_generated_method = "38AED497012B05311D9C413246EF6968")
    @DSModeled(DSC.SAFE)
    @Override
    public TestType getType() {
        return (TestType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return TestType.TEXT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.540 -0400", hash_original_method = "3ED448ECE87E937A31E9C9612D5E122C", hash_generated_method = "AECAC1774CB2AF700BF2AD953AE3DFD0")
    @DSModeled(DSC.SAFE)
    @Override
    public void obtainActualResults(WebView webview, Message resultObtainedMsg) {
        dsTaint.addTaint(webview.dsTaint);
        dsTaint.addTaint(resultObtainedMsg.dsTaint);
        Message msg;
        msg = mHandler.obtainMessage(MSG_DOCUMENT_AS_TEXT);
        msg.arg1 = 1;
        msg.arg2 = mDumpChildFramesAsText ? 1 : 0;
        webview.documentAsText(msg);
        // ---------- Original Method ----------
        //mResultObtainedMsg = resultObtainedMsg;
        //Message msg = mHandler.obtainMessage(MSG_DOCUMENT_AS_TEXT);
        //msg.arg1 = 1;
        //msg.arg2 = mDumpChildFramesAsText ? 1 : 0;
        //webview.documentAsText(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.555 -0400", hash_original_method = "F21FF0F5A17C308034E1A79DFBEE49E0", hash_generated_method = "879F41337B4C100684D7B2B69358CE61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Bundle getBundle() {
        Bundle bundle;
        bundle = new Bundle();
        bundle.putString("expectedTextualResult", mExpectedResult);
        bundle.putString("expectedTextualResultPath", mExpectedResultPath);
        bundle.putString("actualTextualResult", getActualTextResult());
        bundle.putString("additionalTextOutputString", getAdditionalTextOutputString());
        bundle.putString("relativePath", mRelativePath);
        bundle.putBoolean("didTimeOut", mDidTimeOut);
        bundle.putString("type", getType().name());
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bundle bundle = new Bundle();
        //bundle.putString("expectedTextualResult", mExpectedResult);
        //bundle.putString("expectedTextualResultPath", mExpectedResultPath);
        //bundle.putString("actualTextualResult", getActualTextResult());
        //bundle.putString("additionalTextOutputString", getAdditionalTextOutputString());
        //bundle.putString("relativePath", mRelativePath);
        //bundle.putBoolean("didTimeOut", mDidTimeOut);
        //bundle.putString("type", getType().name());
        //return bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:18:45.560 -0400", hash_original_method = "C3208B0D8B1F1251E3BC70B3758FFEA9", hash_generated_method = "02BAEB87D0F37FFE7FBFB650665CD57F")
    @DSModeled(DSC.SAFE)
    @Override
    public String getRelativePath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mRelativePath;
    }

    
}


