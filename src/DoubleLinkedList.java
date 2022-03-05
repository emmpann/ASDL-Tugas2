public class DoubleLinkedList {

    private int size = 1;

    Node head;
    Node tail;

    static class Node{
        
        int data;
        Node prev;
        Node next;
        int index;

        Node(int d){
            index = 0;
            data = d;
            next = null;
            prev = null;
        }

        Node(){}

    }

    public void printList(boolean asc){
        Node n = null;

        if(asc){
            n = head;
        } else {
            n = tail;
        }

        System.out.print("[ ");

        while(n != null){
            System.out.print(n.data + " ");

            if(asc){
                n = n.next;
            } else {
                n = n.prev;
            }
        }


        System.out.print("]\n");
    }

    public void addFirst(int data, DoubleLinkedList dList){
        Node node = new Node(data);
        if(this.head == null){
            dList.head = node;
            head = node;
            head.next = null;
            head.index = 0;
        } else {
            node.next = head;
            node.prev = null;
            head.prev = node;

            head = node;
            increaseSize();
            Node n = head;
            for (int i = 1; i < getSize(); i++) {
                n.next.index = i;
                if(i == getSize()-1){
                    tail = n.next;
                }
                n = n.next;
            }
            
            //head.next.index++;
            // update index
            
        }
    }

    public void add(int index, int data){

        Node node = searchNodeByIndex(index);

        Node newNode = new Node(data);
        increaseSize();
        node.prev.next = newNode;
        newNode.prev = node.prev;
        newNode.next = node;
        if(newNode.next != null){
            newNode.next.prev = newNode;
            Node n = newNode;
            n.index = index;
            for (int i = (index + 1); i < getSize(); i++) {
                n.next.index = i;
                n = n.next;
            }
        }
    }

    public void addLast(int data){
        Node n = head;
        while(n.next != null){
            n = n.next;
        }

        Node lastNode = new Node(data);
        increaseSize();
        n.next = lastNode;
        lastNode.prev = n;
        //n = lastNode;
        tail = lastNode;
        tail.index = getSize() - 1;
    }

    public void removeFirst(){
        Node n = head.next;
        head = null;
        head = n;
        decreaseSize();

        Node node = head;
        for (int i = 0; i < getSize(); i++) {
            node.index = i;
            node = node.next;
        }
    }

    public void remove(int index){
        Node target = searchNodeByIndex(index);
        Node n = head;
        while(n.next != null){
            if(n.next == target){
                n.next = target.next;
                target.next.prev = n;
                decreaseSize();
                n = target.next;
                for (int i = index; i < getSize(); i++) {
                    n.index = i;
                    n = n.next;
                }
                break;
            }
            n = n.next;
        }
    }

    public void removeLast(){
        Node n = tail.prev;
        if(n == null){
            head = null;
            decreaseSize();
        } else {
            n.next = null;
            tail = n;
            decreaseSize();
        }
    }

    public void setData(int index, int element){
        try {
            Node n = searchNodeByIndex(index);
            n.data = element;
            System.out.println("Data berhasil diubah");
        } catch (Exception e) {
            System.err.println("Data tidak ditemukan");
        }
    }

    public boolean searchByData(int element){
        Node n = head;

        while(n != null){ 
            if(n.data == element){
                return true;
            }   
            n = n.next;
        }
        return false;
    }

    public Node searchNodeByIndex(int index){
        Node n = head;

        while(n != null){
            if(n.index == index){
                return n;
            }
            n = n.next;
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public void increaseSize() {
        this.size++;
    }

    public void decreaseSize(){
        this.size--;
    }
}
