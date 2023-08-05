package LabProgram1022;

public class SortedNameList {
    LLNode head;

    public SortedNameList() {
        head = null;
    }

    public LLNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Name name) {
        LLNode newNode = new LLNode(name, null);
        add(newNode);
    }

    public void add(LLNode newNode) {
        if (head == null || head.getName().compareTo(newNode.getName()) >= 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            LLNode current = head.getNext();
            LLNode prev = head;
            while (current != null && current.getName().compareTo(newNode.getName()) < 0) {
                prev = current;
                current = current.getNext();
            }
            newNode.setNext(current);
            prev.setNext(newNode);
        }
    }

    public int size() {
        int count = 0;
        LLNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public boolean isFull() {
        return false;
    }

    public int search(Name name) {
        LLNode current = head;
        int index = 0;
        while (current != null) {
            if (current.getName().equals(name)) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    public LLNode get(int index) {
        if (index < 0) {
            return null;
        }
        LLNode current = head;
        int count = 0;
        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }
        return current;
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            LLNode current = head.getNext();
            LLNode prev = head;
            int count = 1;
            while (current != null && count < index) {
                prev = current;
                current = current.getNext();
                count++;
            }
            prev.setNext(current.getNext());
        }
    }

    public void remove(Name name) {
        LLNode current = head;
        LLNode prev = null;
        while (current != null) {
            if (current.getName().equals(name)) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
            } else {
                prev = current;
            }
            current = current.getNext();
        }
    }

    public void removeAll() {
        head = null;
    }
}
