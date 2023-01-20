import java.util.Iterator;

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

public class MyNode<T> implements Iterator<MyNode<T>>{
    
    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.nextNode = next;
    }
    
    public T getValue() { return data; }
    public MyNode<T> getNext() { return nextNode; }
    public void setValue(T data) { this.data = data; }
    public void setNext(MyNode<T> next) { this.nextNode = next; }
    @Override public boolean hasNext() { return (this.nextNode != null); }
    @Override public MyNode<T> next() { return this.nextNode; }
    @Override public String toString() { return "MyNode [data=" + data + ", nextNode= MyNode@" + this.nextNode.hashCode() + "]";}

    private T data;
    private MyNode<T> nextNode;
}