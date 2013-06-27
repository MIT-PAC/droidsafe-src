package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.ServerLogger;
import gov.nist.core.StackLogger;
import gov.nist.core.net.AddressResolver;
import gov.nist.core.net.NetworkLayer;
import gov.nist.core.net.SslNetworkLayer;
import gov.nist.javax.sip.clientauthutils.AccountManager;
import gov.nist.javax.sip.clientauthutils.AuthenticationHelper;
import gov.nist.javax.sip.clientauthutils.AuthenticationHelperImpl;
import gov.nist.javax.sip.clientauthutils.SecureAccountManager;
import gov.nist.javax.sip.parser.StringMsgParser;
import gov.nist.javax.sip.stack.DefaultMessageLogFactory;
import gov.nist.javax.sip.stack.DefaultRouter;
import gov.nist.javax.sip.stack.MessageProcessor;
import gov.nist.javax.sip.stack.SIPTransactionStack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.ObjectInUseException;
import javax.sip.PeerUnavailableException;
import javax.sip.ProviderDoesNotExistException;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.SipProvider;
import javax.sip.SipStack;
import javax.sip.TransportNotSupportedException;
import javax.sip.address.Router;
import javax.sip.header.HeaderFactory;
import javax.sip.message.Request;

public class SipStackImpl extends SIPTransactionStack implements javax.sip.SipStack, SipStackExt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "3AEF05BEBD52A17EF95A5D808F4FFFA4")

    private Hashtable<String, ListeningPointImpl> listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "70438560708F29EEC903E8857CAD5F87", hash_generated_field = "4D9EE92C5E84922DC5B8DC3AD8BDEAEF")

    private LinkedList<SipProviderImpl> sipProviders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "1E7A0E62B6D1C3ABE8645330F49CA7A4", hash_generated_field = "C05D7B5683B60CB11426E6CCECD30C55")

    boolean reEntrantListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "B9D95CF1DDB3EF5E2FB32454D5FBE60B")

    SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "9AFB2542ACFDA41CD0B947306A200374", hash_generated_field = "14BC1D7F6107A47B988CB81CBFA69682")

    boolean deliverTerminatedEventForAck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "E7CFB3101E29334B0125A1F7E7C03AD9", hash_generated_field = "30FBBF692AD048CF0FD21C922D56959C")

    boolean deliverUnsolicitedNotify = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "FFD25253325702F7B54013D4F86C77C7", hash_generated_field = "3D24F5BF02841FC581DDB4BFBB9A4EDB")

    private Semaphore stackSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "CC92C21F17FEFA346C3D963B8A88779D", hash_generated_field = "9CA40ABAEC743F8616782649ED73D898")

    private String[] cipherSuites = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.588 -0400", hash_original_field = "09CE383C325D1DAAE0EF1312788048B5", hash_generated_field = "72BB7694C21C73B17A9C2E783F51B323")

    private String[] enabledProtocols = ;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.590 -0400", hash_original_method = "BD80EAD073CED4ACABB1B92EBB481070", hash_generated_method = "F00734DF929FFCE4B8C489EA2C1C39AD")
    protected  SipStackImpl() {
        super();
        NistSipMessageFactoryImpl msgFactory;
        msgFactory = new NistSipMessageFactoryImpl(
				this);
        super.setMessageFactory(msgFactory);
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        // ---------- Original Method ----------
        //NistSipMessageFactoryImpl msgFactory = new NistSipMessageFactoryImpl(
				//this);
        //super.setMessageFactory(msgFactory);
        //this.eventScanner = new EventScanner(this);
        //this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        //this.sipProviders = new LinkedList<SipProviderImpl>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.629 -0400", hash_original_method = "31E9570F9C2C0C73DA51527B7C89A7AA", hash_generated_method = "A71E1108C4566D63D6F5732BD959B5DF")
    public  SipStackImpl(Properties configurationProperties) throws PeerUnavailableException {
        this();
        String address;
        address = configurationProperties
				.getProperty("javax.sip.IP_ADDRESS");
        try 
        {
            {
                super.setHostAddress(address);
            } //End block
        } //End block
        catch (java.net.UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("bad address " + address);
        } //End block
        String name;
        name = configurationProperties
				.getProperty("javax.sip.STACK_NAME");
        if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("stack name is missing");
        super.setStackName(name);
        String stackLoggerClassName;
        stackLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.STACK_LOGGER");
        stackLoggerClassName = "gov.nist.core.LogWriter";
        try 
        {
            Class<?> stackLoggerClass;
            stackLoggerClass = Class.forName(stackLoggerClassName);
            Class<?>[] constructorArgs;
            constructorArgs = new Class[0];
            Constructor<?> cons;
            cons = stackLoggerClass
						.getConstructor(constructorArgs);
            Object[] args;
            args = new Object[0];
            StackLogger stackLogger;
            stackLogger = (StackLogger) cons.newInstance(args);
            stackLogger.setStackProperties(configurationProperties);
            super.setStackLogger(stackLogger);
        } //End block
        catch (InvocationTargetException ex1)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
        } //End block
        String serverLoggerClassName;
        serverLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.SERVER_LOGGER");
        serverLoggerClassName = "gov.nist.javax.sip.stack.ServerLog";
        try 
        {
            Class<?> serverLoggerClass;
            serverLoggerClass = Class
						.forName(serverLoggerClassName);
            Class<?>[] constructorArgs;
            constructorArgs = new Class[0];
            Constructor<?> cons;
            cons = serverLoggerClass
						.getConstructor(constructorArgs);
            Object[] args;
            args = new Object[0];
            this.serverLogger = (ServerLogger) cons.newInstance(args);
            serverLogger.setSipStack(this);
            serverLogger.setStackProperties(configurationProperties);
        } //End block
        catch (InvocationTargetException ex1)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
        } //End block
        this.outboundProxy = configurationProperties
				.getProperty("javax.sip.OUTBOUND_PROXY");
        this.defaultRouter = new DefaultRouter(this, outboundProxy);
        String routerPath;
        routerPath = configurationProperties
				.getProperty("javax.sip.ROUTER_PATH");
        routerPath = "gov.nist.javax.sip.stack.DefaultRouter";
        try 
        {
            Class<?> routerClass;
            routerClass = Class.forName(routerPath);
            Class<?>[] constructorArgs;
            constructorArgs = new Class[2];
            constructorArgs[0] = javax.sip.SipStack.class;
            constructorArgs[1] = String.class;
            Constructor<?> cons;
            cons = routerClass.getConstructor(constructorArgs);
            Object[] args;
            args = new Object[2];
            args[0] = (SipStack) this;
            args[1] = outboundProxy;
            Router router;
            router = (Router) cons.newInstance(args);
            super.setRouter(router);
        } //End block
        catch (InvocationTargetException ex1)
        {
            getStackLogger()
					.logError(
							"could not instantiate router -- invocation target problem",
							(Exception) ex1.getCause());
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
					"Cound not instantiate router - check constructor", ex1);
        } //End block
        catch (Exception ex)
        {
            getStackLogger().logError("could not instantiate router",
					(Exception) ex.getCause());
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("Could not instantiate router",
					ex);
        } //End block
        String useRouterForAll;
        useRouterForAll = configurationProperties
				.getProperty("javax.sip.USE_ROUTER_FOR_ALL_URIS");
        this.useRouterForAll = true;
        {
            this.useRouterForAll = "true".equalsIgnoreCase(useRouterForAll);
        } //End block
        String extensionMethods;
        extensionMethods = configurationProperties
				.getProperty("javax.sip.EXTENSION_METHODS");
        {
            java.util.StringTokenizer st;
            st = new java.util.StringTokenizer(
					extensionMethods);
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_1865348710 = (st.hasMoreTokens());
                {
                    String em;
                    em = st.nextToken(":");
                    {
                        boolean var1C9F764402151B0CADD6690CAF645002_954969641 = (em.equalsIgnoreCase(Request.BYE)
						|| em.equalsIgnoreCase(Request.INVITE)
						|| em.equalsIgnoreCase(Request.SUBSCRIBE)
						|| em.equalsIgnoreCase(Request.NOTIFY)
						|| em.equalsIgnoreCase(Request.ACK)
						|| em.equalsIgnoreCase(Request.OPTIONS));
                        if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("Bad extension method "
							+ em);
                        this.addExtensionMethod(em);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        String keyStoreFile;
        keyStoreFile = configurationProperties
				.getProperty("javax.net.ssl.keyStore");
        String trustStoreFile;
        trustStoreFile = configurationProperties
				.getProperty("javax.net.ssl.trustStore");
        {
            {
                trustStoreFile = keyStoreFile;
            } //End block
            String keyStorePassword;
            keyStorePassword = configurationProperties
					.getProperty("javax.net.ssl.keyStorePassword");
            try 
            {
                this.networkLayer = new SslNetworkLayer(trustStoreFile,
						keyStoreFile, keyStorePassword.toCharArray(),
						configurationProperties
								.getProperty("javax.net.ssl.keyStoreType"));
            } //End block
            catch (Exception e1)
            {
                getStackLogger().logError(
						"could not instantiate SSL networking", e1);
            } //End block
        } //End block
        super.isAutomaticDialogSupportEnabled = configurationProperties
				.getProperty("javax.sip.AUTOMATIC_DIALOG_SUPPORT", "on")
				.equalsIgnoreCase("on");
        super.isAutomaticDialogErrorHandlingEnabled = configurationProperties
					.getProperty("gov.nist.javax.sip.AUTOMATIC_DIALOG_ERROR_HANDLING","true")
					.equals(Boolean.TRUE.toString());
        {
            super.isAutomaticDialogErrorHandlingEnabled = true;
        } //End block
        {
            boolean var1C3541C2E25E99D1D76736CA13213A2E_1574406251 = (configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME") != null);
            {
                super.maxListenerResponseTime = Integer
					.parseInt(configurationProperties
							.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME"));
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"Bad configuration parameter gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME : should be positive");
            } //End block
            {
                super.maxListenerResponseTime = -1;
            } //End block
        } //End collapsed parenthetic
        this.deliverTerminatedEventForAck = configurationProperties
				.getProperty(
						"gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_ACK",
						"false").equalsIgnoreCase("true");
        this.deliverUnsolicitedNotify = configurationProperties.getProperty(
				"gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY", "false")
				.equalsIgnoreCase("true");
        String forkedSubscriptions;
        forkedSubscriptions = configurationProperties
				.getProperty("javax.sip.FORKABLE_EVENTS");
        {
            StringTokenizer st;
            st = new StringTokenizer(forkedSubscriptions);
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_191089082 = (st.hasMoreTokens());
                {
                    String nextEvent;
                    nextEvent = st.nextToken();
                    this.forkedEvents.add(nextEvent);
                } //End block
            } //End collapsed parenthetic
        } //End block
        String NETWORK_LAYER_KEY;
        NETWORK_LAYER_KEY = "gov.nist.javax.sip.NETWORK_LAYER";
        {
            boolean varF258C0FAA8E1F85954E47A799F455F6E_327798463 = (configurationProperties.containsKey(NETWORK_LAYER_KEY));
            {
                String path;
                path = configurationProperties
					.getProperty(NETWORK_LAYER_KEY);
                try 
                {
                    Class<?> clazz;
                    clazz = Class.forName(path);
                    Constructor<?> c;
                    c = clazz.getConstructor(new Class[0]);
                    networkLayer = (NetworkLayer) c.newInstance(new Object[0]);
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"can't find or instantiate NetworkLayer implementation: "
								+ path);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String ADDRESS_RESOLVER_KEY;
        ADDRESS_RESOLVER_KEY = "gov.nist.javax.sip.ADDRESS_RESOLVER";
        {
            boolean var886A0DD9CBB41591ABEEBB662D860AF3_492056322 = (configurationProperties.containsKey(ADDRESS_RESOLVER_KEY));
            {
                String path;
                path = configurationProperties
					.getProperty(ADDRESS_RESOLVER_KEY);
                try 
                {
                    Class<?> clazz;
                    clazz = Class.forName(path);
                    Constructor<?> c;
                    c = clazz.getConstructor(new Class[0]);
                    this.addressResolver = (AddressResolver) c
						.newInstance(new Object[0]);
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"can't find or instantiate AddressResolver implementation: "
								+ path);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String maxConnections;
        maxConnections = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CONNECTIONS");
        {
            try 
            {
                this.maxConnections = new Integer(maxConnections).intValue();
            } //End block
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_210781912 = (isLoggingEnabled());
                    getStackLogger().logError(
						"max connections - bad value " + ex.getMessage());
                } //End collapsed parenthetic
            } //End block
        } //End block
        String threadPoolSize;
        threadPoolSize = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_POOL_SIZE");
        {
            try 
            {
                this.threadPoolSize = new Integer(threadPoolSize).intValue();
            } //End block
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_923770366 = (isLoggingEnabled());
                    this.getStackLogger().logError(
						"thread pool size - bad value " + ex.getMessage());
                } //End collapsed parenthetic
            } //End block
        } //End block
        String serverTransactionTableSize;
        serverTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_SERVER_TRANSACTIONS");
        {
            try 
            {
                this.serverTransactionTableHighwaterMark = new Integer(
						serverTransactionTableSize).intValue();
                this.serverTransactionTableLowaterMark = this.serverTransactionTableHighwaterMark * 80 / 100;
            } //End block
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_668869615 = (isLoggingEnabled());
                    this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            this.unlimitedServerTransactionTableSize = true;
        } //End block
        String clientTransactionTableSize;
        clientTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CLIENT_TRANSACTIONS");
        {
            try 
            {
                this.clientTransactionTableHiwaterMark = new Integer(
						clientTransactionTableSize).intValue();
                this.clientTransactionTableLowaterMark = this.clientTransactionTableLowaterMark * 80 / 100;
            } //End block
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_556697374 = (isLoggingEnabled());
                    this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            this.unlimitedClientTransactionTableSize = true;
        } //End block
        super.cacheServerConnections = true;
        String flag;
        flag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS");
        {
            boolean var62D017072D65FD1D09DBD7F6061DE1CE_1334956133 = (flag != null && "false".equalsIgnoreCase(flag.trim()));
            {
                super.cacheServerConnections = false;
            } //End block
        } //End collapsed parenthetic
        super.cacheClientConnections = true;
        String cacheflag;
        cacheflag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");
        {
            boolean var5C60FBB93A7763124F4B58FC1DB64B9C_758306919 = (cacheflag != null && "false".equalsIgnoreCase(cacheflag.trim()));
            {
                super.cacheClientConnections = false;
            } //End block
        } //End collapsed parenthetic
        String readTimeout;
        readTimeout = configurationProperties
				.getProperty("gov.nist.javax.sip.READ_TIMEOUT");
        {
            try 
            {
                int rt;
                rt = Integer.parseInt(readTimeout);
                {
                    super.readTimeout = rt;
                } //End block
                {
                    System.err.println("Value too low " + readTimeout);
                } //End block
            } //End block
            catch (NumberFormatException nfe)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1198572201 = (isLoggingEnabled());
                    getStackLogger().logError("Bad read timeout " + readTimeout);
                } //End collapsed parenthetic
            } //End block
        } //End block
        String stunAddr;
        stunAddr = configurationProperties
				.getProperty("gov.nist.javax.sip.STUN_SERVER");
        this.getStackLogger().logWarning(
					"Ignoring obsolete property "
							+ "gov.nist.javax.sip.STUN_SERVER");
        String maxMsgSize;
        maxMsgSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_MESSAGE_SIZE");
        try 
        {
            {
                super.maxMessageSize = new Integer(maxMsgSize).intValue();
                super.maxMessageSize = 4096;
            } //End block
            {
                super.maxMessageSize = 0;
            } //End block
        } //End block
        catch (NumberFormatException ex)
        {
            {
                boolean var3AA2E1654FE39F4FB102DBD7DEE5C388_1125303327 = (isLoggingEnabled());
                getStackLogger().logError(
					"maxMessageSize - bad value " + ex.getMessage());
            } //End collapsed parenthetic
        } //End block
        String rel;
        rel = configurationProperties
				.getProperty("gov.nist.javax.sip.REENTRANT_LISTENER");
        this.reEntrantListener = (rel != null && "true".equalsIgnoreCase(rel));
        String interval;
        interval = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_AUDIT_INTERVAL_IN_MILLISECS");
        {
            try 
            {
                getThreadAuditor().setPingIntervalInMillisecs(
						Long.valueOf(interval).longValue() / 2);
            } //End block
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_231540738 = (isLoggingEnabled());
                    getStackLogger().logError(
						"THREAD_AUDIT_INTERVAL_IN_MILLISECS - bad value ["
								+ interval + "] " + ex.getMessage());
                } //End collapsed parenthetic
            } //End block
        } //End block
        this
				.setNon2XXAckPassedToListener(Boolean
						.valueOf(
								configurationProperties
										.getProperty(
												"gov.nist.javax.sip.PASS_INVITE_NON_2XX_ACK_TO_LISTENER",
												"false")).booleanValue());
        this.generateTimeStampHeader = Boolean.valueOf(
				configurationProperties.getProperty(
						"gov.nist.javax.sip.AUTO_GENERATE_TIMESTAMP", "false"))
				.booleanValue();
        String messageLogFactoryClasspath;
        messageLogFactoryClasspath = configurationProperties
				.getProperty("gov.nist.javax.sip.LOG_FACTORY");
        {
            try 
            {
                Class<?> clazz;
                clazz = Class.forName(messageLogFactoryClasspath);
                Constructor<?> c;
                c = clazz.getConstructor(new Class[0]);
                this.logRecordFactory = (LogRecordFactory) c
						.newInstance(new Object[0]);
            } //End block
            catch (Exception ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_972156622 = (isLoggingEnabled());
                    getStackLogger()
						.logError(
								"Bad configuration value for LOG_FACTORY -- using default logger");
                } //End collapsed parenthetic
                this.logRecordFactory = new DefaultMessageLogFactory();
            } //End block
        } //End block
        {
            this.logRecordFactory = new DefaultMessageLogFactory();
        } //End block
        boolean computeContentLength;
        computeContentLength = configurationProperties.getProperty(
				"gov.nist.javax.sip.COMPUTE_CONTENT_LENGTH_FROM_MESSAGE_BODY",
				"false").equalsIgnoreCase("true");
        StringMsgParser
				.setComputeContentLengthFromMessage(computeContentLength);
        String tlsClientProtocols;
        tlsClientProtocols = configurationProperties.getProperty(
				"gov.nist.javax.sip.TLS_CLIENT_PROTOCOLS");
        {
            StringTokenizer st;
            st = new StringTokenizer(tlsClientProtocols, " ,");
            String[] protocols;
            protocols = new String[st.countTokens()];
            int i;
            i = 0;
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_1817007385 = (st.hasMoreTokens());
                {
                    protocols[i++] = st.nextToken();
                } //End block
            } //End collapsed parenthetic
            this.enabledProtocols = protocols;
        } //End block
        super.rfc2543Supported = configurationProperties.getProperty(
				"gov.nist.javax.sip.RFC_2543_SUPPORT_ENABLED", "true")
				.equalsIgnoreCase("true");
        super.cancelClientTransactionChecked = configurationProperties
				.getProperty(
						"gov.nist.javax.sip.CANCEL_CLIENT_TRANSACTION_CHECKED",
						"true").equalsIgnoreCase("true");
        super.logStackTraceOnMessageSend = configurationProperties.getProperty(
				"gov.nist.javax.sip.LOG_STACK_TRACE_ON_MESSAGE_SEND", "false")
				.equalsIgnoreCase("true");
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_644577019 = (isLoggingEnabled());
            getStackLogger().logDebug(
				"created Sip stack. Properties = " + configurationProperties);
        } //End collapsed parenthetic
        InputStream in;
        in = getClass().getResourceAsStream("/TIMESTAMP");
        {
            BufferedReader streamReader;
            streamReader = new BufferedReader(
					new InputStreamReader(in));
            try 
            {
                String buildTimeStamp;
                buildTimeStamp = streamReader.readLine();
                {
                    in.close();
                } //End block
                getStackLogger().setBuildTimeStamp(buildTimeStamp);
            } //End block
            catch (IOException ex)
            {
                getStackLogger().logError("Could not open build timestamp.");
            } //End block
        } //End block
        String bufferSize;
        bufferSize = configurationProperties.getProperty(
				"gov.nist.javax.sip.RECEIVE_UDP_BUFFER_SIZE", MAX_DATAGRAM_SIZE
						.toString());
        int bufferSizeInteger;
        bufferSizeInteger = new Integer(bufferSize).intValue();
        super.setReceiveUdpBufferSize(bufferSizeInteger);
        bufferSize = configurationProperties.getProperty(
				"gov.nist.javax.sip.SEND_UDP_BUFFER_SIZE", MAX_DATAGRAM_SIZE
						.toString());
        bufferSizeInteger = new Integer(bufferSize).intValue();
        super.setSendUdpBufferSize(bufferSizeInteger);
        boolean congetstionControlEnabled;
        congetstionControlEnabled = Boolean
				.parseBoolean(configurationProperties.getProperty(
						"gov.nist.javax.sip.CONGESTION_CONTROL_ENABLED",
						Boolean.TRUE.toString()));
        super.stackDoesCongestionControl = congetstionControlEnabled;
        super.isBackToBackUserAgent = Boolean
				.parseBoolean(configurationProperties.getProperty(
						"gov.nist.javax.sip.IS_BACK_TO_BACK_USER_AGENT",
						Boolean.FALSE.toString()));
        super.checkBranchId = Boolean.parseBoolean(configurationProperties
				.getProperty("gov.nist.javax.sip.REJECT_STRAY_RESPONSES",
						Boolean.FALSE.toString()));
        super.isDialogTerminatedEventDeliveredForNullDialog = (Boolean.parseBoolean(configurationProperties.getProperty("gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_NULL_DIALOG",
		        Boolean.FALSE.toString())));
        super.maxForkTime = Integer.parseInt(
		        configurationProperties.getProperty("gov.nist.javax.sip.MAX_FORK_TIME_SECONDS","0"));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.645 -0400", hash_original_method = "4F314CDF94BE73A82A3392DB747CDD4B", hash_generated_method = "8970D290BC5634C680040A422CAB7B77")
    private void reInitialize() {
        super.reInit();
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.sipListener = null;
        // ---------- Original Method ----------
        //super.reInit();
        //this.eventScanner = new EventScanner(this);
        //this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        //this.sipProviders = new LinkedList<SipProviderImpl>();
        //this.sipListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.645 -0400", hash_original_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8", hash_generated_method = "1983A9E9D12CFC1BC1E0D43050CCCC0D")
     boolean isAutomaticDialogSupportEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465210125 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465210125;
        // ---------- Original Method ----------
        //return super.isAutomaticDialogSupportEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.658 -0400", hash_original_method = "20194A28F7CD206898B50945BA95F1CA", hash_generated_method = "28ECE2B25F29E528D1254B28A761323E")
    public synchronized ListeningPoint createListeningPoint(String address,
			int port, String transport) throws TransportNotSupportedException,
			InvalidArgumentException {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_557315263 = null; //Variable for return #1
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1617594839 = null; //Variable for return #2
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_238228524 = (isLoggingEnabled());
            getStackLogger().logDebug(
				"createListeningPoint : address = " + address + " port = "
						+ port + " transport = " + transport);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Address for listening point is null!");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null transport");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad port");
        {
            boolean varCC577C6206F9622B8D4018CF7CFE5AA3_601576947 = (!transport.equalsIgnoreCase("UDP")
				&& !transport.equalsIgnoreCase("TLS")
				&& !transport.equalsIgnoreCase("TCP")
				&& !transport.equalsIgnoreCase("SCTP"));
            if (DroidSafeAndroidRuntime.control) throw new TransportNotSupportedException("bad transport "
					+ transport);
        } //End collapsed parenthetic
        {
            boolean var77293F5E778B02817B1FCCDD8603CFF1_1312559553 = (!this.isAlive());
            {
                this.toExit = false;
                this.reInitialize();
            } //End block
        } //End collapsed parenthetic
        String key;
        key = ListeningPointImpl.makeKey(address, port, transport);
        ListeningPointImpl lip;
        lip = (ListeningPointImpl) listeningPoints.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_557315263 = lip;
        } //End block
        {
            try 
            {
                InetAddress inetAddr;
                inetAddr = InetAddress.getByName(address);
                MessageProcessor messageProcessor;
                messageProcessor = this
						.createMessageProcessor(inetAddr, port, transport);
                {
                    boolean varA9D08F7458A1E36C8AEA7D0F50E63182_1325706852 = (this.isLoggingEnabled());
                    {
                        this.getStackLogger().logDebug(
							"Created Message Processor: " + address
									+ " port = " + port + " transport = "
									+ transport);
                    } //End block
                } //End collapsed parenthetic
                lip = new ListeningPointImpl(this, port, transport);
                lip.messageProcessor = messageProcessor;
                messageProcessor.setListeningPoint(lip);
                this.listeningPoints.put(key, lip);
                messageProcessor.start();
                varB4EAC82CA7396A68D541C85D26508E83_1617594839 = (ListeningPoint) lip;
            } //End block
            catch (java.io.IOException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_128518442 = (isLoggingEnabled());
                    getStackLogger().logError(
						"Invalid argument address = " + address + " port = "
								+ port + " transport = " + transport);
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(ex.getMessage(), ex);
            } //End block
        } //End block
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        ListeningPoint varA7E53CE21691AB073D9660D615818899_1778485489; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1778485489 = varB4EAC82CA7396A68D541C85D26508E83_557315263;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1778485489 = varB4EAC82CA7396A68D541C85D26508E83_1617594839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1778485489.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1778485489;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.660 -0400", hash_original_method = "BBB69BC5565AF0A227A798564DF93404", hash_generated_method = "71AE2F3C15237A520E2E09F97A210772")
    public SipProvider createSipProvider(ListeningPoint listeningPoint) throws ObjectInUseException {
        SipProvider varB4EAC82CA7396A68D541C85D26508E83_1946167005 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint");
        {
            boolean var3D7F860628E378FC3C92E3EDB5A5C1DB_555341837 = (this.isLoggingEnabled());
            this.getStackLogger().logDebug(
					"createSipProvider: " + listeningPoint);
        } //End collapsed parenthetic
        ListeningPointImpl listeningPointImpl;
        listeningPointImpl = (ListeningPointImpl) listeningPoint;
        if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException("Provider already attached!");
        SipProviderImpl provider;
        provider = new SipProviderImpl(this);
        provider.setListeningPoint(listeningPointImpl);
        listeningPointImpl.sipProvider = provider;
        this.sipProviders.add(provider);
        varB4EAC82CA7396A68D541C85D26508E83_1946167005 = provider;
        addTaint(listeningPoint.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1946167005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1946167005;
        // ---------- Original Method ----------
        //if (listeningPoint == null)
			//throw new NullPointerException("null listeningPoint");
        //if (this.isLoggingEnabled())
			//this.getStackLogger().logDebug(
					//"createSipProvider: " + listeningPoint);
        //ListeningPointImpl listeningPointImpl = (ListeningPointImpl) listeningPoint;
        //if (listeningPointImpl.sipProvider != null)
			//throw new ObjectInUseException("Provider already attached!");
        //SipProviderImpl provider = new SipProviderImpl(this);
        //provider.setListeningPoint(listeningPointImpl);
        //listeningPointImpl.sipProvider = provider;
        //this.sipProviders.add(provider);
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.661 -0400", hash_original_method = "A92DFE7C9B9D7EE522B2B525B8C69A65", hash_generated_method = "ED124C70BE7EF132AD4BD96A207AE4F8")
    public void deleteListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint arg");
        ListeningPointImpl lip;
        lip = (ListeningPointImpl) listeningPoint;
        super.removeMessageProcessor(lip.messageProcessor);
        String key;
        key = lip.getKey();
        this.listeningPoints.remove(key);
        addTaint(listeningPoint.getTaint());
        // ---------- Original Method ----------
        //if (listeningPoint == null)
			//throw new NullPointerException("null listeningPoint arg");
        //ListeningPointImpl lip = (ListeningPointImpl) listeningPoint;
        //super.removeMessageProcessor(lip.messageProcessor);
        //String key = lip.getKey();
        //this.listeningPoints.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.665 -0400", hash_original_method = "0933EE30851621D7E3F65B407D39A5B8", hash_generated_method = "E8FFA0A4B31BA5761AE6FABDAC528090")
    public void deleteSipProvider(SipProvider sipProvider) throws ObjectInUseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null provider arg");
        SipProviderImpl sipProviderImpl;
        sipProviderImpl = (SipProviderImpl) sipProvider;
        {
            boolean var262CC069AC78E6BC358C9AD7EB716837_1256707917 = (sipProviderImpl.getSipListener() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
					"SipProvider still has an associated SipListener!");
            } //End block
        } //End collapsed parenthetic
        sipProviderImpl.removeListeningPoints();
        sipProviderImpl.stop();
        sipProviders.remove(sipProvider);
        {
            boolean varC8D7C599E8FF3D1091C8CDC607D82580_2116072075 = (sipProviders.isEmpty());
            {
                this.stopStack();
            } //End block
        } //End collapsed parenthetic
        addTaint(sipProvider.getTaint());
        // ---------- Original Method ----------
        //if (sipProvider == null)
			//throw new NullPointerException("null provider arg");
        //SipProviderImpl sipProviderImpl = (SipProviderImpl) sipProvider;
        //if (sipProviderImpl.getSipListener() != null) {
			//throw new ObjectInUseException(
					//"SipProvider still has an associated SipListener!");
		//}
        //sipProviderImpl.removeListeningPoints();
        //sipProviderImpl.stop();
        //sipProviders.remove(sipProvider);
        //if (sipProviders.isEmpty()) {
			//this.stopStack();
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.666 -0400", hash_original_method = "81685A4D06B7F9B5E6CCB2DE2C1BD9F0", hash_generated_method = "98DBB4E4ECC0570593FBBCB03A4359E3")
    public String getIPAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_251434630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_251434630 = super.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_251434630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_251434630;
        // ---------- Original Method ----------
        //return super.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.672 -0400", hash_original_method = "287349EDD4D46CE4DB7C5F6D8E2D772E", hash_generated_method = "28CEE9926466A079E147924FD675F3FD")
    public java.util.Iterator getListeningPoints() {
        java.util.Iterator varB4EAC82CA7396A68D541C85D26508E83_1597167363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1597167363 = this.listeningPoints.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1597167363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597167363;
        // ---------- Original Method ----------
        //return this.listeningPoints.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.673 -0400", hash_original_method = "BCFD29C2FE3D7BF7BBC15432578BF66F", hash_generated_method = "AD1B6FC20B4E8E259997299BD0443829")
    public boolean isRetransmissionFilterActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866022082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866022082;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.674 -0400", hash_original_method = "88A6DC9DED9CE5F7635E348CD4A3C5F8", hash_generated_method = "C9D4135741D08A155126DC3B23BBA383")
    public java.util.Iterator<SipProviderImpl> getSipProviders() {
        java.util.Iterator<SipProviderImpl> varB4EAC82CA7396A68D541C85D26508E83_1042538827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1042538827 = this.sipProviders.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1042538827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042538827;
        // ---------- Original Method ----------
        //return this.sipProviders.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.683 -0400", hash_original_method = "98CDA556C50A8E057D89E8EADBB5B35E", hash_generated_method = "D1F824747603F5B74A0D2819E7804E1D")
    public String getStackName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1214933211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1214933211 = this.stackName;
        varB4EAC82CA7396A68D541C85D26508E83_1214933211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1214933211;
        // ---------- Original Method ----------
        //return this.stackName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.684 -0400", hash_original_method = "E5E5510E122401D8059641DFB570004B", hash_generated_method = "4F65158BCEAB41157A8538BE408747AF")
    protected void finalize() {
        this.stopStack();
        // ---------- Original Method ----------
        //this.stopStack();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.684 -0400", hash_original_method = "E9BAFB829F6434607FADA475E44C9773", hash_generated_method = "1AC2DE4ADE679383B560DA16400CAAA2")
    public ListeningPoint createListeningPoint(int port, String transport) throws TransportNotSupportedException, InvalidArgumentException {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_673152573 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Stack does not have a default IP Address!");
        varB4EAC82CA7396A68D541C85D26508E83_673152573 = this.createListeningPoint(super.stackAddress, port, transport);
        addTaint(port);
        addTaint(transport.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_673152573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_673152573;
        // ---------- Original Method ----------
        //if (super.stackAddress == null)
			//throw new NullPointerException(
					//"Stack does not have a default IP Address!");
        //return this.createListeningPoint(super.stackAddress, port, transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.685 -0400", hash_original_method = "8379090E51BF18D65A472A61653181B8", hash_generated_method = "1FF54A496B1A4C6229CFF87AE08FCC47")
    public void stop() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_1153411247 = (isLoggingEnabled());
            {
                getStackLogger().logDebug("stopStack -- stoppping the stack");
            } //End block
        } //End collapsed parenthetic
        this.stopStack();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.eventScanner.forceStop();
        this.eventScanner = null;
        // ---------- Original Method ----------
        //if (isLoggingEnabled()) {
			//getStackLogger().logDebug("stopStack -- stoppping the stack");
		//}
        //this.stopStack();
        //this.sipProviders = new LinkedList<SipProviderImpl>();
        //this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        //if (this.eventScanner != null)
			//this.eventScanner.forceStop();
        //this.eventScanner = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.685 -0400", hash_original_method = "64980175D45C88025DB0BF7ED31DD55C", hash_generated_method = "66A76CF67CCD26E199C0BC50C8ED70B6")
    public void start() throws ProviderDoesNotExistException, SipException {
        {
            this.eventScanner = new EventScanner(this);
        } //End block
        // ---------- Original Method ----------
        //if (this.eventScanner == null) {
			//this.eventScanner = new EventScanner(this);
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.686 -0400", hash_original_method = "007AB23FB90DEFAA901334391BCA8574", hash_generated_method = "2720A7F36C76B469E60576DE2CC41896")
    public SipListener getSipListener() {
        SipListener varB4EAC82CA7396A68D541C85D26508E83_1991420067 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1991420067 = this.sipListener;
        varB4EAC82CA7396A68D541C85D26508E83_1991420067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1991420067;
        // ---------- Original Method ----------
        //return this.sipListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.686 -0400", hash_original_method = "41341CEB98E5DA012DCAACB9910CCA31", hash_generated_method = "B98D90DFCD51C54F84848826D86BD0E6")
    public LogRecordFactory getLogRecordFactory() {
        LogRecordFactory varB4EAC82CA7396A68D541C85D26508E83_576477968 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_576477968 = super.logRecordFactory;
        varB4EAC82CA7396A68D541C85D26508E83_576477968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_576477968;
        // ---------- Original Method ----------
        //return super.logRecordFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.691 -0400", hash_original_method = "DD6917F16C5DC825A79D8F74525C77AA", hash_generated_method = "4198BADFF3F961607D5597EA4710EB24")
    @Deprecated
    public EventScanner getEventScanner() {
        EventScanner varB4EAC82CA7396A68D541C85D26508E83_595412327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_595412327 = eventScanner;
        varB4EAC82CA7396A68D541C85D26508E83_595412327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_595412327;
        // ---------- Original Method ----------
        //return eventScanner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.691 -0400", hash_original_method = "DDBB9B823124CA2B241AC7D56A934729", hash_generated_method = "4ACFB3E6AFCE0DD0AD4F897070C6EE4D")
    public AuthenticationHelper getAuthenticationHelper(
			AccountManager accountManager, HeaderFactory headerFactory) {
        AuthenticationHelper varB4EAC82CA7396A68D541C85D26508E83_1098266367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1098266367 = new AuthenticationHelperImpl(this, accountManager, headerFactory);
        addTaint(accountManager.getTaint());
        addTaint(headerFactory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1098266367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1098266367;
        // ---------- Original Method ----------
        //return new AuthenticationHelperImpl(this, accountManager, headerFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.695 -0400", hash_original_method = "9BC4A63758F96D1DFC890C8072E9A8F9", hash_generated_method = "0A80363710615BB949D07E68CD498CCB")
    public AuthenticationHelper getSecureAuthenticationHelper(
			SecureAccountManager accountManager, HeaderFactory headerFactory) {
        AuthenticationHelper varB4EAC82CA7396A68D541C85D26508E83_1772064854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1772064854 = new AuthenticationHelperImpl(this, accountManager, headerFactory);
        addTaint(accountManager.getTaint());
        addTaint(headerFactory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1772064854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772064854;
        // ---------- Original Method ----------
        //return new AuthenticationHelperImpl(this, accountManager, headerFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.695 -0400", hash_original_method = "23CB36659469F37B2B1A4E89C6C5A109", hash_generated_method = "EEF876C7AA37CA82F9A54624D848F42A")
    public void setEnabledCipherSuites(String[] newCipherSuites) {
        cipherSuites = newCipherSuites;
        // ---------- Original Method ----------
        //cipherSuites = newCipherSuites;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.696 -0400", hash_original_method = "15C35F67057574B0384681051DA88AFD", hash_generated_method = "D43B5B40894AE7C3686307B064914C2C")
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1054811935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1054811935 = cipherSuites;
        varB4EAC82CA7396A68D541C85D26508E83_1054811935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1054811935;
        // ---------- Original Method ----------
        //return cipherSuites;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.696 -0400", hash_original_method = "146720FA6D9E688CD139244E691C1622", hash_generated_method = "367AACC0BB535AEDE0F21EE0BE1604FA")
    public void setEnabledProtocols(String[] newProtocols) {
        enabledProtocols = newProtocols;
        // ---------- Original Method ----------
        //enabledProtocols = newProtocols;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.697 -0400", hash_original_method = "36B040AE4C1B32E20301E5CF570A7C53", hash_generated_method = "4EE248BFCD9F85445D51A00FAB62EEC0")
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_532225981 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532225981 = enabledProtocols;
        varB4EAC82CA7396A68D541C85D26508E83_532225981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532225981;
        // ---------- Original Method ----------
        //return enabledProtocols;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.697 -0400", hash_original_method = "B3A8DF498FA0698B770F05249042765A", hash_generated_method = "03886AAE7E894E0D90DA83D6366182F2")
    public void setIsBackToBackUserAgent(boolean flag) {
        super.isBackToBackUserAgent = flag;
        addTaint(flag);
        // ---------- Original Method ----------
        //super.isBackToBackUserAgent = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.702 -0400", hash_original_method = "1623111994CBCA0890DA0FF2A1E140E0", hash_generated_method = "58C19C86BEB069D6F0808B8CC31FA751")
    public boolean isBackToBackUserAgent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738441723 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738441723;
        // ---------- Original Method ----------
        //return super.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.703 -0400", hash_original_method = "8A30592F142C300BD40BD8A31AEE1D8D", hash_generated_method = "E132727963E44A100F6B3AB8E900F698")
    public boolean isAutomaticDialogErrorHandlingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240676756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_240676756;
        // ---------- Original Method ----------
        //return super.isAutomaticDialogErrorHandlingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.703 -0400", hash_original_method = "1CDF5A6FEBA76AB1A61A70742324066C", hash_generated_method = "B24E63AAE4FD42E4A8F22181F2105F9B")
    public boolean acquireSem() {
        try 
        {
            boolean var6CD91398C6667EFBFA92956988AFCF80_2105164322 = (this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS));
        } //End block
        catch (InterruptedException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955770106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955770106;
        // ---------- Original Method ----------
        //try {
            //return this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS);
        //} catch ( InterruptedException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.703 -0400", hash_original_method = "2B4EDB484E691FD8761CF130C9353BAF", hash_generated_method = "ABCF4EEA47ACCF6FD64218E3A8D948F5")
    public void releaseSem() {
        this.stackSemaphore.release();
        // ---------- Original Method ----------
        //this.stackSemaphore.release();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.703 -0400", hash_original_field = "26B86A1C916CC4B7BAB489AF94B9502C", hash_generated_field = "DC1BA291E655CE21E8210560B23E074D")

    public static final Integer MAX_DATAGRAM_SIZE = 8 * 1024;
}

