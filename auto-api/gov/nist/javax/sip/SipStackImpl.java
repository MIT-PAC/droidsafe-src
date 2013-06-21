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
    private EventScanner eventScanner;
    private Hashtable<String, ListeningPointImpl> listeningPoints;
    private LinkedList<SipProviderImpl> sipProviders;
    boolean reEntrantListener;
    SipListener sipListener;
    boolean deliverTerminatedEventForAck = false;
    boolean deliverUnsolicitedNotify = false;
    private Semaphore stackSemaphore = new Semaphore(1);
    private String[] cipherSuites = {
			"TLS_RSA_WITH_AES_128_CBC_SHA", 
											
			
			"SSL_RSA_WITH_3DES_EDE_CBC_SHA", 

			
			
			"TLS_DH_anon_WITH_AES_128_CBC_SHA",
			"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", };
    private String[] enabledProtocols = {
			"SSLv3",
			"SSLv2Hello",
			"TLSv1"
	};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.318 -0400", hash_original_method = "BD80EAD073CED4ACABB1B92EBB481070", hash_generated_method = "F00734DF929FFCE4B8C489EA2C1C39AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SipStackImpl() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.322 -0400", hash_original_method = "31E9570F9C2C0C73DA51527B7C89A7AA", hash_generated_method = "FACFB87FF486AA9C6637200405160E01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipStackImpl(Properties configurationProperties) throws PeerUnavailableException {
        this();
        dsTaint.addTaint(configurationProperties.dsTaint);
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
                boolean varA9BBA9119DD90070115272E6F9D4D419_717327634 = (st.hasMoreTokens());
                {
                    String em;
                    em = st.nextToken(":");
                    {
                        boolean var1C9F764402151B0CADD6690CAF645002_1569891101 = (em.equalsIgnoreCase(Request.BYE)
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
            boolean var1C3541C2E25E99D1D76736CA13213A2E_163193482 = (configurationProperties
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
                boolean varA9BBA9119DD90070115272E6F9D4D419_1426744458 = (st.hasMoreTokens());
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
            boolean varF258C0FAA8E1F85954E47A799F455F6E_691636790 = (configurationProperties.containsKey(NETWORK_LAYER_KEY));
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
            boolean var886A0DD9CBB41591ABEEBB662D860AF3_918240099 = (configurationProperties.containsKey(ADDRESS_RESOLVER_KEY));
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_520908902 = (isLoggingEnabled());
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1087096149 = (isLoggingEnabled());
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_2006509065 = (isLoggingEnabled());
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_288108506 = (isLoggingEnabled());
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
            boolean var62D017072D65FD1D09DBD7F6061DE1CE_1989687104 = (flag != null && "false".equalsIgnoreCase(flag.trim()));
            {
                super.cacheServerConnections = false;
            } //End block
        } //End collapsed parenthetic
        super.cacheClientConnections = true;
        String cacheflag;
        cacheflag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");
        {
            boolean var5C60FBB93A7763124F4B58FC1DB64B9C_1241452555 = (cacheflag != null && "false".equalsIgnoreCase(cacheflag.trim()));
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_352925293 = (isLoggingEnabled());
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
                boolean var3AA2E1654FE39F4FB102DBD7DEE5C388_298471612 = (isLoggingEnabled());
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1240119034 = (isLoggingEnabled());
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
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1079811726 = (isLoggingEnabled());
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
                boolean varA9BBA9119DD90070115272E6F9D4D419_1100212571 = (st.hasMoreTokens());
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
            boolean var53869E3A88D96F4415B2EAEAC904AA86_508047163 = (isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.323 -0400", hash_original_method = "4F314CDF94BE73A82A3392DB747CDD4B", hash_generated_method = "8970D290BC5634C680040A422CAB7B77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.323 -0400", hash_original_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8", hash_generated_method = "516BA3467AF245BE5EAA79901F343A7C")
    @DSModeled(DSC.SAFE)
     boolean isAutomaticDialogSupportEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.isAutomaticDialogSupportEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.323 -0400", hash_original_method = "20194A28F7CD206898B50945BA95F1CA", hash_generated_method = "C9950C58FBFD86FB55E5317333EB8DB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized ListeningPoint createListeningPoint(String address,
			int port, String transport) throws TransportNotSupportedException,
			InvalidArgumentException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(transport);
        dsTaint.addTaint(address);
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_653263492 = (isLoggingEnabled());
            getStackLogger().logDebug(
				"createListeningPoint : address = " + address + " port = "
						+ port + " transport = " + transport);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Address for listening point is null!");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null transport");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad port");
        {
            boolean varCC577C6206F9622B8D4018CF7CFE5AA3_1366660552 = (!transport.equalsIgnoreCase("UDP")
				&& !transport.equalsIgnoreCase("TLS")
				&& !transport.equalsIgnoreCase("TCP")
				&& !transport.equalsIgnoreCase("SCTP"));
            if (DroidSafeAndroidRuntime.control) throw new TransportNotSupportedException("bad transport "
					+ transport);
        } //End collapsed parenthetic
        {
            boolean var77293F5E778B02817B1FCCDD8603CFF1_2116367640 = (!this.isAlive());
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
            try 
            {
                InetAddress inetAddr;
                inetAddr = InetAddress.getByName(address);
                MessageProcessor messageProcessor;
                messageProcessor = this
						.createMessageProcessor(inetAddr, port, transport);
                {
                    boolean varA9D08F7458A1E36C8AEA7D0F50E63182_1618421194 = (this.isLoggingEnabled());
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
            } //End block
            catch (java.io.IOException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1887680301 = (isLoggingEnabled());
                    getStackLogger().logError(
						"Invalid argument address = " + address + " port = "
								+ port + " transport = " + transport);
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(ex.getMessage(), ex);
            } //End block
        } //End block
        return (ListeningPoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.324 -0400", hash_original_method = "BBB69BC5565AF0A227A798564DF93404", hash_generated_method = "C7345BBDF05A5C932CFB13716D7CD37C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SipProvider createSipProvider(ListeningPoint listeningPoint) throws ObjectInUseException {
        dsTaint.addTaint(listeningPoint.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint");
        {
            boolean var3D7F860628E378FC3C92E3EDB5A5C1DB_997109505 = (this.isLoggingEnabled());
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
        return (SipProvider)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.324 -0400", hash_original_method = "A92DFE7C9B9D7EE522B2B525B8C69A65", hash_generated_method = "519FA3F8399F94A21BF1CFF41FEB5E25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        dsTaint.addTaint(listeningPoint.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint arg");
        ListeningPointImpl lip;
        lip = (ListeningPointImpl) listeningPoint;
        super.removeMessageProcessor(lip.messageProcessor);
        String key;
        key = lip.getKey();
        this.listeningPoints.remove(key);
        // ---------- Original Method ----------
        //if (listeningPoint == null)
			//throw new NullPointerException("null listeningPoint arg");
        //ListeningPointImpl lip = (ListeningPointImpl) listeningPoint;
        //super.removeMessageProcessor(lip.messageProcessor);
        //String key = lip.getKey();
        //this.listeningPoints.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.324 -0400", hash_original_method = "0933EE30851621D7E3F65B407D39A5B8", hash_generated_method = "5B0BC54D25E7B028E5B02E4F47D8E55A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteSipProvider(SipProvider sipProvider) throws ObjectInUseException {
        dsTaint.addTaint(sipProvider.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null provider arg");
        SipProviderImpl sipProviderImpl;
        sipProviderImpl = (SipProviderImpl) sipProvider;
        {
            boolean var262CC069AC78E6BC358C9AD7EB716837_1387202219 = (sipProviderImpl.getSipListener() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
					"SipProvider still has an associated SipListener!");
            } //End block
        } //End collapsed parenthetic
        sipProviderImpl.removeListeningPoints();
        sipProviderImpl.stop();
        sipProviders.remove(sipProvider);
        {
            boolean varC8D7C599E8FF3D1091C8CDC607D82580_790302996 = (sipProviders.isEmpty());
            {
                this.stopStack();
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.324 -0400", hash_original_method = "81685A4D06B7F9B5E6CCB2DE2C1BD9F0", hash_generated_method = "628067EDD5FF40250B478BFB1B7FD79C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getIPAddress() {
        String varC29A76C41BBFD3D165FF7D837BC1F489_1278647100 = (super.getHostAddress());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "287349EDD4D46CE4DB7C5F6D8E2D772E", hash_generated_method = "4FA46039BDEC99258D3C5D31AE8844A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.Iterator getListeningPoints() {
        java.util.Iterator varCEFAA34416E46E6FC6CC51C43954F8CD_674828026 = (this.listeningPoints.values().iterator());
        return (java.util.Iterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.listeningPoints.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "BCFD29C2FE3D7BF7BBC15432578BF66F", hash_generated_method = "165CD114F61AC9746039377577CFDF39")
    @DSModeled(DSC.SAFE)
    public boolean isRetransmissionFilterActive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "88A6DC9DED9CE5F7635E348CD4A3C5F8", hash_generated_method = "07FDEF21413DC9F17E42E538D6DFA937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.Iterator<SipProviderImpl> getSipProviders() {
        java.util.Iterator<SipProviderImpl> var16B51D408699CF50475A78E3E642C1F8_1263466921 = (this.sipProviders.iterator());
        return (java.util.Iterator<SipProviderImpl>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.sipProviders.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "98CDA556C50A8E057D89E8EADBB5B35E", hash_generated_method = "0D7EA9CBC828398B3A21657205D1C6DA")
    @DSModeled(DSC.SAFE)
    public String getStackName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.stackName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "E5E5510E122401D8059641DFB570004B", hash_generated_method = "4F65158BCEAB41157A8538BE408747AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        this.stopStack();
        // ---------- Original Method ----------
        //this.stopStack();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.325 -0400", hash_original_method = "E9BAFB829F6434607FADA475E44C9773", hash_generated_method = "548D6D4552474D07115140070FA23531")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListeningPoint createListeningPoint(int port, String transport) throws TransportNotSupportedException, InvalidArgumentException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(transport);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Stack does not have a default IP Address!");
        ListeningPoint varE83737C8086E730A59A7FE85AC52A6CB_1679210125 = (this.createListeningPoint(super.stackAddress, port, transport));
        return (ListeningPoint)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (super.stackAddress == null)
			//throw new NullPointerException(
					//"Stack does not have a default IP Address!");
        //return this.createListeningPoint(super.stackAddress, port, transport);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.326 -0400", hash_original_method = "8379090E51BF18D65A472A61653181B8", hash_generated_method = "EBB7975FC717E17D3722FBDDC26E6B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_1030474494 = (isLoggingEnabled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.326 -0400", hash_original_method = "64980175D45C88025DB0BF7ED31DD55C", hash_generated_method = "66A76CF67CCD26E199C0BC50C8ED70B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() throws ProviderDoesNotExistException, SipException {
        {
            this.eventScanner = new EventScanner(this);
        } //End block
        // ---------- Original Method ----------
        //if (this.eventScanner == null) {
			//this.eventScanner = new EventScanner(this);
		//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.326 -0400", hash_original_method = "007AB23FB90DEFAA901334391BCA8574", hash_generated_method = "83C762DAC437C92F628510C8DD87B898")
    @DSModeled(DSC.SAFE)
    public SipListener getSipListener() {
        return (SipListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.sipListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.326 -0400", hash_original_method = "41341CEB98E5DA012DCAACB9910CCA31", hash_generated_method = "B1D2A4AC134F60E69C4770B37F9D07F2")
    @DSModeled(DSC.SAFE)
    public LogRecordFactory getLogRecordFactory() {
        return (LogRecordFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.logRecordFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.326 -0400", hash_original_method = "DD6917F16C5DC825A79D8F74525C77AA", hash_generated_method = "8C140D595D94BB3A5EE3D597BE5BCC31")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public EventScanner getEventScanner() {
        return (EventScanner)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return eventScanner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.327 -0400", hash_original_method = "DDBB9B823124CA2B241AC7D56A934729", hash_generated_method = "62D5B9C87A68277CDA5628E0E733CC07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHelper getAuthenticationHelper(
			AccountManager accountManager, HeaderFactory headerFactory) {
        dsTaint.addTaint(headerFactory.dsTaint);
        dsTaint.addTaint(accountManager.dsTaint);
        AuthenticationHelper var9E267521ECF363F2C1A7D299950B5104_94293467 = (new AuthenticationHelperImpl(this, accountManager, headerFactory));
        return (AuthenticationHelper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AuthenticationHelperImpl(this, accountManager, headerFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.327 -0400", hash_original_method = "9BC4A63758F96D1DFC890C8072E9A8F9", hash_generated_method = "3F2DDC1EA8B8F8801F28B9FBDD719307")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AuthenticationHelper getSecureAuthenticationHelper(
			SecureAccountManager accountManager, HeaderFactory headerFactory) {
        dsTaint.addTaint(headerFactory.dsTaint);
        dsTaint.addTaint(accountManager.dsTaint);
        AuthenticationHelper var9E267521ECF363F2C1A7D299950B5104_1603789559 = (new AuthenticationHelperImpl(this, accountManager, headerFactory));
        return (AuthenticationHelper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AuthenticationHelperImpl(this, accountManager, headerFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.327 -0400", hash_original_method = "23CB36659469F37B2B1A4E89C6C5A109", hash_generated_method = "9BA2E0FDECA6C861D665119915F93C7F")
    @DSModeled(DSC.SAFE)
    public void setEnabledCipherSuites(String[] newCipherSuites) {
        dsTaint.addTaint(newCipherSuites[0]);
        // ---------- Original Method ----------
        //cipherSuites = newCipherSuites;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.327 -0400", hash_original_method = "15C35F67057574B0384681051DA88AFD", hash_generated_method = "0447486D1416FFAD47662AE7FC04FC87")
    @DSModeled(DSC.SAFE)
    public String[] getEnabledCipherSuites() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return cipherSuites;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.327 -0400", hash_original_method = "146720FA6D9E688CD139244E691C1622", hash_generated_method = "58EF29EE858D10586DEB83B524E3E96A")
    @DSModeled(DSC.SAFE)
    public void setEnabledProtocols(String[] newProtocols) {
        dsTaint.addTaint(newProtocols[0]);
        // ---------- Original Method ----------
        //enabledProtocols = newProtocols;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "36B040AE4C1B32E20301E5CF570A7C53", hash_generated_method = "AE93E55C40D576EC9E2151CA31CAC7A2")
    @DSModeled(DSC.SAFE)
    public String[] getEnabledProtocols() {
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledProtocols;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "B3A8DF498FA0698B770F05249042765A", hash_generated_method = "BFBFB7091F980D97443A8CC84F2432C8")
    @DSModeled(DSC.SAFE)
    public void setIsBackToBackUserAgent(boolean flag) {
        dsTaint.addTaint(flag);
        super.isBackToBackUserAgent = flag;
        // ---------- Original Method ----------
        //super.isBackToBackUserAgent = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "1623111994CBCA0890DA0FF2A1E140E0", hash_generated_method = "538947CC2C64538CA0BC9EB7A57D90C6")
    @DSModeled(DSC.SAFE)
    public boolean isBackToBackUserAgent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.isBackToBackUserAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "8A30592F142C300BD40BD8A31AEE1D8D", hash_generated_method = "C54DCD8FA19D5711B11D7BF1A11330B1")
    @DSModeled(DSC.SAFE)
    public boolean isAutomaticDialogErrorHandlingEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.isAutomaticDialogErrorHandlingEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "1CDF5A6FEBA76AB1A61A70742324066C", hash_generated_method = "D6810E2D56B82F31709622845A68F020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean acquireSem() {
        try 
        {
            boolean var6CD91398C6667EFBFA92956988AFCF80_207032270 = (this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS));
        } //End block
        catch (InterruptedException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //return this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS);
        //} catch ( InterruptedException ex) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.328 -0400", hash_original_method = "2B4EDB484E691FD8761CF130C9353BAF", hash_generated_method = "ABCF4EEA47ACCF6FD64218E3A8D948F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void releaseSem() {
        this.stackSemaphore.release();
        // ---------- Original Method ----------
        //this.stackSemaphore.release();
    }

    
    public static final Integer MAX_DATAGRAM_SIZE = 8 * 1024;
}

