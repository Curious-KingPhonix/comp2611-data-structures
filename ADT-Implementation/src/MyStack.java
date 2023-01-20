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

public class MyStack<T> implements Stackable<T>{
    public MyStack() { this.list = new MyLinkedList<>(); }
    public MyStack(MyLinkedList<T> list) { this.list = list;}
    @Override public boolean isEmpty() { return this.list.isEmpty(); }
    @Override public T peek() { return this.list.getFirst(); }
    @Override public T pop() { return this.list.removeFirst(); }
    @Override public void push(T data) { this.list.addFirst(data); }
    @Override public int size() { return this.list.size(); }
    private MyLinkedList<T> list;
}