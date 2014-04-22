/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package droidsafe.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Nguyen Nguyen
 */
public class CallTree {

    private CallNode root = new CallNode("Root");
    private static Logger logger = LoggerFactory.getLogger(CallTree.class);

    public CallTree() {
    }

    public boolean hasChildren() {
        return (root.children.size() > 0);                
    }
    
    public void load(String fileName) {
        File file = new File(fileName);
        load(file);
    }
    
    public CallNode getRoot() { return root; }    
        public void load(File file) {
        root = new CallNode("Root");
        InputStream apiListFile = null;
        try {
            apiListFile = new FileInputStream(file);
            List<String> lines;
            lines = IOUtils.readLines(apiListFile);
            apiListFile.close();
            loadLines(lines);
        }
        catch (Exception ex) {
            
        }
    }
        
    /**
     * load debug file into tree data structure (this 
     * @param file 
     */
    public void loadLines(List<String> lines) {
        root = new CallNode("Root");

        Map<String, Stack<CallNode>> callStackMap = new HashMap<String, Stack<CallNode>>();

        TraceLine.TraceType prevTraceType = TraceLine.TraceType.UNKNOWN;

        for (String line : lines) {

            if (!line.contains("/DSI")) {
                continue;
            }

            TraceLine traceLine = TraceLine.parseTraceLine(line);

            if (traceLine == null) {
                logger.warn("Cannot parse trace line {} ", line);
                continue;
            }

            String threadIdString = String.format("Thread-%s", traceLine.threadId);

            if (!callStackMap.containsKey(threadIdString)) {
                logger.info("Adding stack for thread <{}> ", threadIdString);
                callStackMap.put(threadIdString, new Stack<CallNode>());
            }

            Stack<CallNode> callStack = callStackMap.get(threadIdString);

            if (callStack.size() == 0) {
                CallNode threadNode = new CallNode(threadIdString);
                root.addChild(threadNode);
                callStack.push(threadNode);
            }

            CallNode parent = callStack.peek();

            // Dealing with  entering method trace (+)
            switch(traceLine.traceType) {
                case ENTERING:
                {
                    logger.info("Adding method {} ", traceLine); 
                    CallNode newNode = new CallNode(traceLine);
                    parent.addChild(newNode);
                    callStack.push(newNode);      
                }
                break;

                case EXITING:
                {
                     // we probably should pop until it matches with the traceline
                    CallNode node = callStack.pop();      
                    logger.info("popping {} ", node);

                    //we may be able to detect exception

                    // Store data on the exit, it's the only place that has parameter value
                    if (node.data instanceof TraceLine) {
                        TraceLine myLine = (TraceLine)node.data;
                        myLine.parameterString = traceLine.parameterString;
                    }
                }
                break;

                case INSIDE:
                {
                    // we jump to the top if not coming from a previous entry
                    if (prevTraceType != TraceLine.TraceType.ENTERING) {
                        logger.info("Adding Entry method {} ", traceLine); 
                        CallNode newNode = new CallNode(traceLine);                            
                        while (callStack.size() > 1) {
                            parent = callStack.pop();
                        }
                        parent = callStack.peek();
                        parent.addChild(newNode);
                        callStack.push(newNode);                                  
                    }                        
                }
                break;

                default:
                    break;

            }

            logger.info("callStack: {} ", callStack);
            prevTraceType = traceLine.traceType;
        }
    }
    
    
    
    void dumpNode(StringBuilder sb, int indentLevel, CallNode node) {
        sb.append(String.format("[%d]: %s\n", indentLevel, node.data));
        for (CallNode childNode: node.children) {
            dumpNode(sb, indentLevel+1, childNode);
        }
    } 
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        dumpNode(sb, 0, root);
        return sb.toString();
    }
}