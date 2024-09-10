package ao.tsukuyomi.datastructures;

import ao.tsukuyomi.game.objects.Skill;

import java.util.ArrayList;
import java.util.List;

import ao.tsukuyomi.game.objects.Skill;

public class BinaryTree {
    private No root;

    public void addNode(Skill skill) {
        No newNode = new No(skill);          // Create a new No with the Skill

        if (root == null) {
            root = newNode;  // If the tree is empty, set the new node as the root
        } else {
            insertNode(root, newNode);  // Otherwise, insert the new node into the tree
        }
    }

    private void insertNode(No currentNode, No newNode) {
        if (currentNode.getSkill().hashCode() > newNode.getSkill().hashCode()) {
            // If the current node's skill is greater, move to the left child
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);  // Insert the new node as the left child
            } else {
                insertNode(currentNode.getLeft(), newNode);  // Recursively insert into the left subtree
            }
        } else if (currentNode.getSkill().hashCode() < newNode.getSkill().hashCode()) {
            // If the current node's skill is lesser, move to the right child
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);  // Insert the new node as the right child
            } else {
                insertNode(currentNode.getRight(), newNode);  // Recursively insert into the right subtree
            }
        }
        // If the hashcodes are equal, do nothing (assuming duplicate skills are not allowed)
    }

    public void removeNode(String skillName) {
        root = removeNode(root, skillName);
    }

    //aiiases
    public void removeAllSkills(){
        root = null;
    }

    public void createSkill(Skill skill){
        addNode(skill);
    }

    private No removeNode(No currentNode, String skillName) {
        if (currentNode == null) {
            return null;  // Reached the end of a subtree, skill not found
        }

        if (currentNode.getSkill().getName().equalsIgnoreCase(skillName)) {
            // Found the node to be removed
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                // Case 1: Node is a leaf, simply remove it
                return null;
            } else if (currentNode.getLeft() == null) {
                // Case 2: Node has only a right child, replace it with the right child
                return currentNode.getRight();
            } else if (currentNode.getRight() == null) {
                // Case 3: Node has only a left child, replace it with the left child
                return currentNode.getLeft();
            } else {
                // Case 4: Node has both left and right children
                No successor = getSuccessor(currentNode.getRight());
                currentNode.setSkill(successor.getSkill());
                currentNode.setRight(removeNode(currentNode.getRight(), successor.getSkill().getName()));
                return currentNode;
            }
        } else if (currentNode.getSkill().hashCode() > skillName.hashCode()) {
            // Move to the left subtree
            currentNode.setLeft(removeNode(currentNode.getLeft(), skillName));
        } else {
            // Move to the right subtree
            currentNode.setRight(removeNode(currentNode.getRight(), skillName));
        }
        return currentNode;
    }

    private No getSuccessor(No node) {
        No current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public No searchSkill(String skillName) {
        return searchSkill(root, skillName);
    }

    private No searchSkill(No currentNode, String skillName) {
        if (currentNode == null || currentNode.getSkill().getName().equalsIgnoreCase(skillName)) {
            return currentNode;  // Found the node or reached the end of a subtree
        }

        if (currentNode.getSkill().hashCode() > skillName.hashCode()) {
            return searchSkill(currentNode.getLeft(), skillName);  // Move to the left subtree
        } else {
            return searchSkill(currentNode.getRight(), skillName);  // Move to the right subtree
        }
    }

    public void listNodes() {
        listNodes(root);
    }

    private void listNodes(No currentNode) {
        if (currentNode != null) {
            listNodes(currentNode.getLeft());    // Visit left subtree
            System.out.println(currentNode);     // Print the node
            listNodes(currentNode.getRight());   // Visit right subtree
        }
    }
}
