package droidsafe.test;

import droidsafe.test.regression.RegressionTestUtils;

import java.io.IOException;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.PosixParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Main entry class for DroidSafe tests.
 */

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
    Options options = new Options();
    Option approot = OptionBuilder.withArgName("target").hasArg().withDescription("The target to execute").isRequired().create("target");
		options.addOption(approot);
	
    CommandLineParser parser = new GnuParser();
    CommandLine cmd = null;
		try {
			cmd = parser.parse( options, args);
		} catch (Exception e) {
      printHelp(options);
      System.exit(1);
		}
	
    String target = cmd.getOptionValue("target");
    if(target.equals("update-specdump-regression-values")) {
      RegressionTestUtils.updateSpecdumpRegressionValues();
    }

    if(target.equals("show-regression-stats")) {
      RegressionTestUtils.showRegressionStats();
    }

    return;
  }

  private static void printHelp(Options options) {
    HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("droidsafe-test", options);
  }
}
