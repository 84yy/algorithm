package linklist;

/**
 * 用单链表来存储一个字符串,并判断字符串是否是回文字符串
 *
 * @author hzm
 */
public class SingleLinkList {


    private SingleLinkListNode root = null;

    public SingleLinkList() {
    }


    /**
     * 在尾部添加
     */
    public void addTail(SingleLinkListNode node) {
        //如果链表没有初始化,把要插入的节点设置位头节点
        if (this.root == null) {
            this.root = node;
            return;
        }
        if (this.root.hasNext()) {

        }
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
        private char c;
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
            this.c = c;
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
    }
}
