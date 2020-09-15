package com.company;
public class List<E> implements Options<E> {
    private Node<E> obj;
    private int size = 0;
   public List(){
        obj = new Node<>(null ,null);
    }

    @Override
    public void add(E elem) {
        Node<E> newElem = new Node<>(null ,elem);
        Node<E> shell = obj;
        if(size == 0){
            obj.setNext(newElem);
        }
        else {
            for (int i = 0; i < size; i++){
                shell = shell.getNext();
            }
            shell.setNext(newElem);
        }
        size++;
    }

    @Override
    public E get(int index) {
       if(index>=size || index<0 )
           throw new IndexOutOfBoundsException("Index: " + index+ ", Size: " + size);

        Node<E> elem = obj.getNext();
       for(int i = 0; i<index; i++){
            elem = elem.getNext();
       }
       return elem.getElem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(E elem, int index) {
       if(index>size){
           System.out.println("Temporary mistake");
           return;
       }
       Node<E> newElem = new Node<>(null, elem);
       Node<E> startElem = obj;
       for(int i = 0; i<index; i++){
            startElem = startElem.getNext();
        }
       newElem.setNext(startElem.getNext().getNext());
       startElem.setNext(newElem);
    }

    @Override
    public boolean IsEmpty() {
        return size==0;
    }

    @Override
    public void clear() {
        obj.setNext(null);
    }

    @Override
    public void remove(int index) {
       if(size<=index || index<0){
           throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
       }
       Node<E>object = obj;
        for(int i = 0; i<index; i++){
            object = object.getNext();
        }
        object.setNext(object.getNext().getNext());
        size--;
    }

    protected static class Node<E> {
        private Node<E> next;
        private E elem;

        protected Node(Node<E> next, E elem) {
            this.next = next;
            this.elem = elem;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }
    }
}

