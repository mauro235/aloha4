package com.salesforce.tests.fs.filesystem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    public enum FileType {
        DIRECTORY,
        FILE
    }

    private Node parent;
    private List<Node> childs;

    public FileType type;
    public String name;

    public Node(String name, FileType type) {
        this.name = name;
        this.type = type;
        this.childs = new ArrayList<>();
    }

    public void setParent(Node parent) throws Exception {
        if (parent != null && parent.type == FileType.DIRECTORY) {
            this.parent = parent;
        } else {
            throw new Exception("Invalid FS operation");
        }
    }

    // Go through parents to get current path
    public String getPath() {
        String response = name;
        Node node = parent;

        while (node != null) {
            response = node.name + Filesystem.PATH_DELIMITER + response;
            node = node.parent;
        }

        response = Filesystem.PATH_DELIMITER + response;

        return response;
    }

    public void appendNode(Node node) {
        try {
            node.setParent(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.childs.add(node);
    }

    public List<Node> getChilds() {
        return childs;
    }

    public boolean hasParent() {
        return (parent != null) ? true : false;
    }

    public Node getParent() {
        return parent;
    }

    public String getChildList(boolean recursive) {
        String response = ".\n..\n";

        for (Node child : childs) {

            response += child.name + ((child.type == FileType.DIRECTORY) ? "/\n" : "\n");

            if (recursive) {

            }
        }

        return response;
    }

}
