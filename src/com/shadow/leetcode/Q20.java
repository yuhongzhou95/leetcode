//package com.shadow.leetcode;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * https://leetcode-cn.com/problems/valid-parentheses/
// */
//public class Q20 {
//
//    public static void main(String[] args) {
//        Q20 q20 = new Q20();
//        System.out.println(q20.isValid("()"));
//        System.out.println(q20.isValid("()[]{}"));
//        System.out.println(q20.isValid("(]"));
//        System.out.println(q20.isValid("([)]"));
//        System.out.println(q20.isValid("{[]}"));
//    }
//
//    /**
//     * 方法：栈
//     * 自己实现
//     * @param s
//     * @return
//     */
//    public boolean isValid1(String s) {
//        if (s == null) {
//            return false;
//        }
//        if (s.length() == 0) {
//            return true;
//        }
//        Map<Character, Character> map = new HashMap<>();
//        map.put('(', ')');
//        map.put('[', ']');
//        map.put('{', '}');
//        java.util.Stack<Character> stack = new java.util.Stack<>();
//        stack.push(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            if (!stack.empty()) {
//                Character peek = stack.peek();
//                if ((peek.equals('(') && s.charAt(i) == ')') || (peek.equals('{') && s.charAt(i) == '}') || (peek.equals('[') && s.charAt(i) == ']')) {
//                    stack.pop();
//                    continue;
//                }
//            }
//            stack.push(s.charAt(i));
//        }
//        return stack.isEmpty();
//    }
//
//    /**
//     * 最佳解法：栈
//     * @param s
//     * @return
//     */
//    public boolean isValid2(String s) {
//        if(s == null){
//            throw new IllegalArgumentException("参数错误");
//        }
//        java.util.Stack<Character> stack = new java.util.Stack<>();
//        for(Character c : s.toCharArray()){
//            if (c == '(')
//                stack.push(')');
//            else if (c == '{')
//                stack.push('}');
//            else if (c == '[')
//                stack.push(']');
//            else if (stack.isEmpty() || stack.pop() != c)
//                return false;
//        }
//        return stack.isEmpty();
//    }
//
//    /**
//     * 使用我们自己的工具类
//     *
//     * @param s
//     * @return
//     */
//    public boolean isValid(String s) {
//        if (s.equals("")) {
//            return true;
//        }
//        Stack<Character> stack = new ArrayStack<>();
//        stack.push(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            if (!stack.isEmpty()) {
//                Character peek = stack.peek();
//                if ((peek.equals('(') && s.charAt(i) == ')') || (peek.equals('{') && s.charAt(i) == '}') || (peek.equals('[') && s.charAt(i) == ']')) {
//                    stack.pop();
//                    continue;
//                }
//            }
//            stack.push(s.charAt(i));
//        }
//        return stack.isEmpty();
//    }
//}
//
//interface Stack<E> {
//    /**
//     * 添加一个元素
//     *
//     * @param e
//     */
//    void push(E e);
//
//    /**
//     * 删除一个元素
//     *
//     * @return
//     */
//    E pop();
//
//    /**
//     * 查看栈顶元素
//     *
//     * @return
//     */
//    E peek();
//
//    /**
//     * 查看栈的空间
//     *
//     * @return
//     */
//    int getSize();
//
//    /**
//     * 判断当前栈是否为空
//     *
//     * @return
//     */
//    boolean isEmpty();
//}
//
//class Array<E> {
//
//    private E[] data;
//    private int size;
//
//    // 构造函数，传入数组的容量capacity构造Array
//    public Array(int capacity) {
//        data = (E[]) new Object[capacity];
//        size = 0;
//    }
//
//    // 无参数的构造函数，默认数组的容量capacity=10
//    public Array() {
//        this(10);
//    }
//
//    // 获取数组的容量
//    public int getCapacity() {
//        return data.length;
//    }
//
//    // 获取数组中的元素个数
//    public int getSize() {
//        return size;
//    }
//
//    // 返回数组是否为空
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // 在index索引的位置插入一个新元素e
//    public void add(int index, E e) {
//        if (index < 0 || index > size) {
//            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
//        }
//        if (size == data.length) {
//            grow(getCapacity());
//        }
//        for (int i = size - 1; i >= index; i--) {
//            data[i + 1] = data[i];
//        }
//        data[index] = e;
//        size++;
//    }
//
//
//    // 向所有元素后添加一个新元素
//    public void addLast(E e) {
//        add(size, e);
//    }
//
//    // 在所有元素前添加一个新元素
//    public void addFirst(E e) {
//        add(0, e);
//    }
//
//    // 获取index索引位置的元素
//    public E get(int index) {
//        if (index < 0 || index >= size)
//            throw new IllegalArgumentException("Get failed. Index is illegal.");
//        return data[index];
//    }
//
//    // 获取第一个元素
//    public E getFirst() {
//        return get(0);
//    }
//
//    // 获取最后一个元素
//    public E getLast() {
//        return get(getSize() - 1);
//    }
//
//    // 修改index索引位置的元素为e
//    public void set(int index, E e) {
//        if (index < 0 || index >= size)
//            throw new IllegalArgumentException("Set failed. Index is illegal.");
//        data[index] = e;
//    }
//
//    // 查找数组中是否有元素e
//    public boolean contains(E e) {
//        for (int i = 0; i < size; i++) {
//            if (data[i].equals(e))
//                return true;
//        }
//        return false;
//    }
//
//    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
//    public int find(E e) {
//        for (int i = 0; i < size; i++) {
//            if (data[i].equals(e))
//                return i;
//        }
//        return -1;
//    }
//
//    // 从数组中删除index位置的元素, 返回删除的元素
//    public E remove(int index) {
//        if (index < 0 || index >= size)
//            throw new IllegalArgumentException("Remove failed. Index is illegal.");
//
//        E ret = data[index];
//        for (int i = index + 1; i < size; i++)
//            data[i - 1] = data[i];
//        size--;
//        data[size] = null; // loitering objects != memory leak
//        if (size < getCapacity() / 2 && getCapacity() / 2 != 0) {
//            decrease(getCapacity());
//        }
//        return ret;
//    }
//
//    // 从数组中删除第一个元素, 返回删除的元素
//    public E removeFirst() {
//        return remove(0);
//    }
//
//    // 从数组中删除最后一个元素, 返回删除的元素
//    public E removeLast() {
//        return remove(size - 1);
//    }
//
//    // 从数组中删除元素e
//    public void removeElement(E e) {
//        int index = find(e);
//        if (index != -1)
//            remove(index);
//    }
//
//    private void grow(int capacity) {
//        int newCapacity = capacity + (capacity >> 1);
//        resize(newCapacity);
//    }
//
//    private void decrease(int capacity) {
//        int newCapacity = capacity - (capacity >> 2);
//        resize(newCapacity);
//    }
//
//    private void resize(int capacity) {
//        E[] newData = (E[]) new Object[capacity];
//        for (int i = 0; i < getSize(); i++) {
//            newData[i] = data[i];
//        }
//        data = newData;
//    }
//
//    @Override
//    public String toString() {
//
//        StringBuilder res = new StringBuilder();
//        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
//        res.append('[');
//        for (int i = 0; i < size; i++) {
//            res.append(data[i]);
//            if (i != size - 1)
//                res.append(", ");
//        }
//        res.append(']');
//        return res.toString();
//    }
//}
//
//class ArrayStack<E> implements Stack<E> {
//    private Array<E> array;
//
//    public ArrayStack() {
//        array = new Array<>();
//    }
//
//    public ArrayStack(int capacity) {
//        array = new Array<>(capacity);
//    }
//
//    @Override
//    public void push(E e) {
//        array.addLast(e);
//    }
//
//    @Override
//    public E pop() {
//        return array.removeLast();
//    }
//
//    @Override
//    public E peek() {
//        return array.getLast();
//    }
//
//    @Override
//    public int getSize() {
//        return array.getSize();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return array.isEmpty();
//    }
//
//    public int getCapacity() {
//        return array.getCapacity();
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder res = new StringBuilder();
//        res.append("Stack: ");
//        res.append('[');
//        for (int i = 0; i < array.getSize(); i++) {
//            res.append(array.get(i));
//            if (i != array.getSize() - 1)
//                res.append(", ");
//        }
//        res.append("] top");
//        return res.toString();
//    }
//
//}
