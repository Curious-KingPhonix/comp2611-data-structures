import java.util.ArrayList;

// Copyright 2023 Kyle King
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

public class MyLinkedList<T> implements SinglyLinkedList<T>{
    
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(34);
        linkedList.append(50);
        linkedList.append(20);
        linkedList.append(1);
        System.out.println("Before removing \'"+50+"\' -> "+linkedList);
        System.out.println(linkedList.removeNode(50));
        System.out.println("After removing \'"+50+"\' -> "+linkedList);
    }
    
    public MyLinkedList() {
        this.head = null;
        this.listSize = 0;
    }
    @Override public void addFirst(T data) {this.prepend(data);}
    @Override public void addLast(T data) {this.append(data);}
    @Override public T getFirst() { return this.head.getValue();}
    @Override public T getLast() {
        if(this.head == null ) return null;
        MyNode<T> iter = this.head;
        while(iter.hasNext()) iter = iter.next();
        return iter.getValue();
    }
    @Override public boolean isEmpty() { return (this.head == null);}
    @Override public T removeFirst() { 
        if(this.head != null) { 
            T val = this.head.getValue();
            this.head = this.head.getNext();
            this.listSize -= 1;
            return val;
        }
        return null;
    }
    @Override public T removeLast() {
        if(this.head != null) {
            T val = this.head.getValue();
            if(this.head.next() == null) this.head = null;
            else {
                MyNode<T> iter = this.head;
                while(iter.next().hasNext()) iter = iter.next();
                val = iter.next().getValue();
                iter.setNext(null);
            }
            this.listSize -= 1;
            return val;
        }
        return null;
    }
    @Override public int size() {return this.getSize();}
    private void prepend( T value ) {
        MyNode<T> node = new MyNode<T>(value, head);
        this.head = node;
        this.listSize += 1;
    }
    private MyNode<T> getNode(T value) {
        if( this.head == null ) return this.head;
        MyNode<T> iter = this.head;
        while(iter.hasNext()) {
            if(iter.getValue() == value) {return iter;}
            iter = iter.next();
        }
        return null;
    }
    private MyNode<T> removeNode(T value) {
        MyNode<T> res = this.getNode(value);
        if( res != null ) {
            if(res == this.head) {
                this.head = null;
                return res;
            }
            MyNode<T> iter = this.head;
            while(iter.hasNext()){
                if(iter.next() == res){
                    iter.setNext(res.getNext());
                    break;
                }
            }
        }
        return res;
    }
    private int getSize() { return this.listSize; }
    private void append( T value ) {
        MyNode<T> node = new MyNode<T>(value, null);
        if(this.head == null) {
            this.head = node;
        } else {
            MyNode<T> iter = this.head;
            while(iter.hasNext()) iter = iter.next();
            iter.setNext(node);
        }
        this.listSize += 1;
    }
    @Override public String toString() {
        ArrayList<T> buffer = new ArrayList<>();
        MyNode<T> iter = this.head;
        while(iter != null){
            buffer.add(iter.getValue());
            iter = iter.next();
        }
        return buffer.toString();
    }
    private MyNode<T> head;
    private int listSize;
}