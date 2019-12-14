package linklist;

/**
 * 用单链表来存储一个字符串,并判断字符串是否是回文字符串
 *
 * @author hzm
 */
@SuppressWarnings("all")
public class SingleLinkList {


    private SingleLinkListNode root = null;

    public SingleLinkList() {
    }


    /**
     * 在尾部添加
     */
    public void addTail(SingleLinkListNode node) {
        //如果链表没有初始化,把要插入的节点设置位头节点
        SingleLinkListNode crtNode = this.root;
        if (crtNode == null) {
            this.root = node;
            return;
        }
        //获取尾节点
        while (crtNode.hasNext()) {
            crtNode = crtNode.next;
        }
        crtNode.next = node;
    }

    /**
     * 移除并返回头结点
     *
     * @return
     */
    public SingleLinkListNode getAndRemoveHead() {
        if (this.root == null) {
            return null;
        }
        SingleLinkListNode rmNode = this.root;
        this.root = this.root.next;
        return rmNode;
    }

    /**
     * 移除并返回尾结点
     */
    public SingleLinkListNode getAndRemoveTail() {
        if (this.root == null) {
            return null;
        }
        SingleLinkListNode crtNode = this.root;
        //通过判断节点的下联节点是否有下联节点,识别当前节点的下个节点是否为尾部
        while (crtNode.hasNext() && crtNode.next.hasNext()) {
            crtNode = crtNode.next;
        }

        SingleLinkListNode tailNode = null;
        if (crtNode.hasNext()) {
            tailNode = crtNode.next;
        } else {
            tailNode = crtNode;
        }
        crtNode.next = null;
        return tailNode;
    }


    /**
     * 在头部添加
     */
    public void addHead(SingleLinkListNode node) {
        //如果链表没有初始化,把要插入的节点设置位头节点
        if (this.root == null) {
            this.root = node;
            return;
        }
        //更换头节点
        SingleLinkListNode oldRoot = this.root.next;
        node.setNext(oldRoot);
        this.root = node;
    }


    static class SingleLinkListNode {
        /**
         * 节点存储的字符
         */
        private char data;
        /**
         * 节点的下联节点
         */
        private SingleLinkListNode next;

        public boolean hasNext() {
            return this.next != null;
        }

        /**
         * 创建节点
         */
        public SingleLinkListNode(char c) {
            super();
            this.data = c;
        }

        /**
         * 设置节点下联节点
         */
        public void setNext(SingleLinkListNode node) {
            this.next = node;
        }

        /**
         * 获取节点的下联节点
         *
         * @return
         */
        public SingleLinkListNode getNext() {
            return this.next;
        }

        public char getData() {
            return this.data;
        }
    }

    /**
     * 判断字符串是否回文
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = args[0];
        if (str == null || str.length() == 0) {
            System.out.println("请输入有效的字符串...");
            return;
        }

        SingleLinkList sglList = new SingleLinkList();
        char[] chars = str.toCharArray();
        //字符串存入链表
        int len = chars.length;
        if (len < 2) {
            System.out.println("字符串" + str + "长度小于 2,必定是回文字符串...");
            return;
        }
        for (int i = 0; i < len; i++) {
            SingleLinkListNode sglNode = new SingleLinkListNode(chars[i]);
            sglList.addTail(sglNode);
        }

        int halfLen = len >> 1;
        for (int i = 0; i < halfLen; i++) {
            SingleLinkListNode head = sglList.getAndRemoveHead();
            SingleLinkListNode tail = sglList.getAndRemoveTail();
            if (head.getData() != tail.getData()) {
                System.out.println("字符串" + str + "不是回文...");
                return;
            }
        }
        System.out.println("字符串" + str + "是回文...");
    }
}
