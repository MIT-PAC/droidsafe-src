package droidsafe.test.regression;

import droidsafe.test.regression.RegressionTestUtils;

import java.io.File;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * This test case assumes that "ant run-engagement-tests" was run beforehand
 */
@RunWith(value = Parameterized.class)
  public class SpecdumpRegressionTestCase {
    private static final Logger logger = LoggerFactory.getLogger(SpecdumpRegressionTestCase.class);

    final static String engagementTestReportDir = "engagement/";

    private String appRoot;
    private Boolean specdumpTestPassed;

    public SpecdumpRegressionTestCase(String appRoot, Boolean specdumpTestPassed) {
      this.appRoot = appRoot;
      this.specdumpTestPassed = specdumpTestPassed;
    }

    @Parameters(name="{0} should have passed: {1}")
    public static Collection<Object[]> data() {
      Map<String, Boolean> currSpecdumpTestResults = RegressionTestUtils.getCurrSpecdumpTestResults();
      Object[][] data = new Object[currSpecdumpTestResults.size()][2];
      int counter = 0;
      for(Map.Entry<String, Boolean> entry : currSpecdumpTestResults.entrySet()){
        data[counter][0] = entry.getKey();
        data[counter][1] = entry.getValue();
        counter++;
      }
      return Arrays.asList(data);
    }

    /**
     * Make sure that no engagement app that wasn't broken before is broken now
     */
    @Test
    public void didNotBreakEngagementAppsTest() throws Exception {
      String regressionValueContainerFilePath = this.appRoot + "/" + RegressionTestUtils.REGRESSION_VALUE_CONTAINER_FILE;
      File regressionValueContainerFile = new File(regressionValueContainerFilePath);
      Assert.assertTrue("Regression value container file " + RegressionTestUtils.REGRESSION_VALUE_CONTAINER_FILE + " does not exist for " + this.appRoot, regressionValueContainerFile.exists());
      // If we can't figure out if the test passed or not, there is a bug in the regression test code
      Assert.assertTrue(this.specdumpTestPassed != null);
      // If the current test passed, we don't care whether it passed or not before
      if (!this.specdumpTestPassed) {
        System.out.println(regressionValueContainerFilePath);
        Boolean specdumpTestShouldHavePassed = RegressionTestUtils.getSpecdumpTestRegressionValue(regressionValueContainerFilePath);
        Assert.assertTrue("No specdumpTestCase regression value present for " + this.appRoot, specdumpTestShouldHavePassed != null);
        Assert.assertTrue("SpecdumpTest should have passed for " + this.appRoot + " but didn't. If this is not going to be fixed anytime soon, consider updating the regression value using ant update-regression-values.", !specdumpTestShouldHavePassed);
      }
    }
  }
