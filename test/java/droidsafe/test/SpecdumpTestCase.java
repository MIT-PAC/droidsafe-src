package droidsafe.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

import java.net.URL;
import java.net.URLClassLoader;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.main.Config;

@RunWith(value = Parameterized.class)
public class SpecdumpTestCase {

  private static final Logger logger = LoggerFactory.getLogger(SpecdumpTestCase.class);

  public String appRoot;
	private volatile boolean hasTimedout;
	private int timeout;

  private static Collection<Object[]> appDirs = new ArrayList<Object[]>();

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Constructors
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public SpecdumpTestCase(String appRoot) {
		this.appRoot = appRoot;
		this.hasTimedout=false;

    /* timeout passed from build.xml */
    this.timeout = Integer.parseInt(System.getProperty("timeout", "-1"));
    if (this.timeout == -1) {
      this.timeout = Integer.MAX_VALUE/1000;
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Test Setup
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  /**
   * Finds all the apps that we want to test
   */
  @Parameters(name = "{0}")
	public static Collection<Object[]> data() {
    String pathToSearch = System.getenv("APAC_HOME") + "/" + Config.ANDROID_APP_DIR_REL + "/";

    String dirToSearch = System.getProperty("dir-to-search");
    if(dirToSearch != null)
      pathToSearch += dirToSearch;

    File appSearchDir =  new File(pathToSearch);
    if (!appSearchDir.exists()) {
      logger.error("Could not open app search directory", appSearchDir);
      System.exit(1);
    }
    findApps(appSearchDir);
    return appDirs;
  }
	
	@Before
	public void buildApp() throws Exception {    
		ProcessBuilder pb = new ProcessBuilder();
		Process makeSubprocess;
		pb.directory(new File(this.appRoot));
		pb.command("make","build");
		pb.redirectErrorStream(true);
		makeSubprocess = pb.start();
		
		// we must do this haquery to get the subprocess output
		InputStream is = makeSubprocess.getInputStream();
		while(true) {
			int c = is.read();
			if(c==-1) break;
			System.out.write((char)c);
		}
		
		// wait for process completion
		makeSubprocess.waitFor();
		Assert.assertEquals("Make Failure",makeSubprocess.exitValue(),0);
	
	}

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Tests
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	
	@Test
	public void testDroidsafe() throws Exception {
		ProcessBuilder pb = new ProcessBuilder();
		Process droidsafeSubprocess;
   
    pb.command("java",
				// inherit the caller's classpath
				"-cp", getCurrentClasspath(),
				"droidsafe.main.Main",
				"-t","specdump",
				"-approot", this.appRoot);
		pb.redirectErrorStream(true);
		droidsafeSubprocess = pb.start();
		
		// start the timeout thread so we don't have to poll system clock
		Thread timeoutThread = new Thread(new Runnable() {
			public void run() {
				try{Thread.sleep(timeout * 1000);} catch(Exception e) {};
				SpecdumpTestCase.this.hasTimedout = true; // volatile assures visibility
			}
		});
		timeoutThread.start();
		
		// we must do this haquery to get the subprocess output
		InputStream is = droidsafeSubprocess.getInputStream();

		while(!this.hasTimedout) { // volatile assures visibility
			int c = is.read();
			if(c==-1) break;
			System.out.write((char)c);
		}
		
		if(this.hasTimedout) {
			// timeout expired - kill droidsafe
			droidsafeSubprocess.destroy();
			Assert.fail("Droidsafe TestCase timed out at " + timeout + " seconds.");
		} else {
			// droidsafe completed, end timeout and check for failure
			timeoutThread.interrupt(); // do this here because lazy coding make this set the timeout flag
			droidsafeSubprocess.waitFor();
      Assert.assertEquals("Droidsafe Failure",0,droidsafeSubprocess.exitValue());
		}
	}

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // Helper functions
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  /* Used to find all android apps */
  private static void findApps(File directory){
    boolean foundManifest = false;
    boolean foundMakefile = false;
    for (File file : directory.listFiles()) {
      if(file.isDirectory())
        findApps(file);
      else if(file.getName().equals("AndroidManifest.xml")){
        foundManifest = true;
      } else if(file.getName().equals("Makefile")) {
        foundMakefile = true;
      }
      if(foundManifest && foundMakefile) {
        appDirs.add( new Object[]{file.getParent()});
        break;
      }
    }
  }

  // The fact that I have to do this is all ANT's fault
	private String getCurrentClasspath() {
		StringBuilder sb = new StringBuilder();
		sb.append(System.getenv("APAC_HOME")+"/bin/droidsafe-core.jar");
		sb.append(System.getProperty("path.separator"));
		sb.append(System.getenv("APAC_HOME")+"/bin/droidsafe-libs.jar");
		sb.append(System.getProperty("path.separator"));
		sb.append(System.getenv("APAC_HOME")+"/config-files");
		return sb.toString();
	}


}
