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
    
    /**
     * load debug file into tree data structure (this 
     * @param file 
     */
    public void load(File file) {
        InputStream apiListFile = null;
        try {
            apiListFile = new FileInputStream(file);
            List<String> apiList;
            apiList = IOUtils.readLines(apiListFile);
            apiListFile.close();
            
            Map<String, Stack<CallNode>> callStackMap = new HashMap<String, Stack<CallNode>>();
        
       
            for (String line : apiList) {
                         
                if (!line.contains("/DSI")) {
                    continue;
                }
                
                List<String> tokens = parseLine(line);
                if (tokens == null || tokens.size() == 0)
                    continue;
                
                if (tokens.size() < 3) {
                    // need to dump out the error
                    continue;
                }
                
                String direction = tokens.get(0);
                String threadId  = tokens.get(1);
                String method  = tokens.get(2);
                boolean traverseDown = (direction.equals("+"));
                
                if (!callStackMap.containsKey(threadId)) {
                    logger.info("Adding stack for thread <{}> ", threadId);
                    callStackMap.put(threadId, new Stack<CallNode>());
                }
                
                Stack<CallNode> callStack = callStackMap.get(threadId);
                
                if (callStack.size() == 0) {
                    CallNode threadNode = new CallNode(threadId);
                    root.addChild(threadNode);
                    callStack.push(threadNode);
                }
                
                CallNode parent = callStack.peek();
                
                if (traverseDown) {
                    CallNode newNode = new CallNode(method);
                    logger.info("Adding method {} ", method); 
                    parent.addChild(newNode);
                    callStack.push(newNode);                 
                }
                else {
                    callStack.pop();
                }                       
                logger.info("callStack: {} ", callStack);
            }

        } catch (Exception ex) {
            logger.warn("Exception {}", ex.getStackTrace());
        }

    }
    
    private List<String> parseLine(String line) {
        List<String> list = new LinkedList<String>();
        int ind = line.indexOf(":");
        
        if (ind == -1)
            return list;
        line = line.substring(ind+1).trim();
                

        list.add("" + line.charAt(0));
        
        ind = line.indexOf("[");
        int endInd = line.indexOf("]");       
        list.add(line.substring(ind+1, endInd));
        ind = line.indexOf("<");
        endInd = line.indexOf(")>");
        list.add(line.substring(ind+1, endInd+2));
        
        return list;

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