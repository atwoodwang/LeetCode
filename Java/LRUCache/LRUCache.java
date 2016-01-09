public class LRUCache {
    public class Node{
        int key;
        int value;
        Node pre;
        Node post;
    }

    public void addNode(Node node){
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }

    public void removeNode(Node node){
        Node pre = node.pre;
        Node post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    public void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }

    public Node popTail(){
        Node pre = tail.pre;
        removeNode(pre);
        return pre;
    }

    HashMap<Integer,Node> cache = new HashMap<>();
    private Node head,tail;
    int size,count;
    public LRUCache(int capacity) {
        size = capacity;
        count = 0;

        head = new Node();
        tail = new Node();
        head.pre = null;
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key,newNode);
        count++;
        if(count>size){
            Node tail = popTail();
            cache.remove(tail.key);
            count--;
        }
    }
}