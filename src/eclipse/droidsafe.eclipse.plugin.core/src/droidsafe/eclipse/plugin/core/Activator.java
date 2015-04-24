/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.eclipse.plugin.core;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import droidsafe.main.Config;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Marcel Becker (becker@kestrel.edu)
 * 
 */
public class Activator extends AbstractUIPlugin {

  /** The plug-in ID */
  public static final String PLUGIN_ID = "droidsafe.eclipse.plugin.core"; //$NON-NLS-1$

  /** The shared instance */
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {}

  /**
   * Default plugin start method.
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext )
   */
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
    
    //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    //StatusPrinter.print(lc);
    //configureDebugLog();
    //lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    //StatusPrinter.print(lc);

  }


  @SuppressWarnings("unused")
  private void configureDebugLog() {
    String pluginId = Activator.PLUGIN_ID;
    Bundle bundle = Platform.getBundle(pluginId);
    try {
      File file = FileLocator.getBundleFile(bundle);
      Config.v().setApacHome(file.getAbsolutePath());
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    // we want to create a debug log file, so load the
    // logback-debug.xml from the config files directory
    // assume SLF4J is bound to logback in the current environment
    LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
    try {
      JoranConfigurator configurator = new JoranConfigurator();
      configurator.setContext(context);
      // Call context.reset() to clear any previous configuration, e.g. default
      // configuration. For multi-step configuration, omit calling context.reset().
      context.reset();
      String configLogFile = "config-files/logback.xml";
      configurator.doConfigure(Config.v().getApacHome() + File.separator + configLogFile);
    } catch (JoranException je) {
      // StatusPrinter will handle this
    }
    StatusPrinter.printInCaseOfErrorsOrWarnings(context);
  }



  /**
   * Default plugin stop method.
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext )
   */
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

  /**
   * Returns an image descriptor for the image file at the given plug-in relative path
   * 
   * @param path the path
   * @return the image descriptor
   */
  public static ImageDescriptor getImageDescriptor(String path) {
    return imageDescriptorFromPlugin(PLUGIN_ID, path);
  }
}
