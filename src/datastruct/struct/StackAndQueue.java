package datastruct.struct;


import java.lang.reflect.Array;


public class StackAndQueue{

    public static void main(String[] args){
        testTwoQueue();
        // testTwoStack();
        //testDeque();
        //testStack();
        //testQueue();
        //testDoubleStack();
    }
    public static void testDeque(){
        deque<Integer> deque = new deque<>(Integer.class,19);
        for (int i = 0;i < 10;i++){
            System.out.println("FIRST人队: "+i+" "+deque.enqueueHead(i));
            System.out.println("SECOND人队: "+i+" "+deque.enqueueTail(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("FIRST出队: " + deque.dequeueHead());
            System.out.println("SECOND出队: "+deque.dequeueTail());
        }
    }
    public static void testDoubleStack(){
        doubleStack<Integer> doubleStack = new doubleStack<>(Integer.class,19);
        for (int i = 0;i < 10;i++){
            System.out.println("FIRST人队: "+i+" "+doubleStack.pushFirst(i));
            System.out.println("SECOND人队: "+i+" "+doubleStack.pushSecond(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("FIRST出队: " + doubleStack.popFirst());
            System.out.println("SECOND出队: "+doubleStack.popSecond());
        }
    }
    public static void testStack(){
        stack<Integer> stack = new stack<>(Integer.class,9);
        for (int i = 0;i < 10;i++){
            System.out.println("人队: "+i+" "+stack.push(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出队: "+stack.pop());
        }
    }
    public static void testQueue(){
        queue<Integer> queue = new queue<>(Integer.class,9);
        for (int i = 0;i < 10;i++){
            System.out.println("人队: "+i+" "+queue.enqueue(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出队: "+queue.dequeue());
        }
        for (int i = 0;i < 10;i++){
            System.out.println("人队: "+i+" "+queue.enqueue(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出队: "+queue.dequeue());
        }
    }
    public static void testTwoStack(){
        twoStackOneQueue<Integer> queue = new twoStackOneQueue<>(Integer.class,9);
        for (int i = 0;i < 10;i++){
            System.out.println("人队: "+i+" "+queue.enqueue(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出队: "+queue.dequeue());
        }
        for (int i = 0;i < 10;i++){
            System.out.println("人队: "+i+" "+queue.enqueue(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出队: "+queue.dequeue());
        }
    }
    public static void testTwoQueue(){
        twoQueueOneStack<Integer> queue = new twoQueueOneStack<>(Integer.class,9);
        for (int i = 0;i < 10;i++){
            System.out.println("入栈: "+i+" "+queue.push(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出栈: "+queue.pop());
        }
        for (int i = 0;i < 10;i++){
            System.out.println("人栈: "+i+" "+queue.push(i));
        }
        for(int i = 0;i<11;i++){
            System.out.println("出栈: "+queue.pop());
        }

    }

}
class stack<T>{
    private int maxSize = 10;
    private int quote = 0;
    private final T[] stack;
    @SuppressWarnings("unchecked")
    public stack(Class<T> type,int maxSize){
        this.maxSize = maxSize;
        stack = (T[]) Array.newInstance(type,maxSize);
    }
    @SuppressWarnings("unchecked")
    public stack(Class<T> type){
        stack = (T[]) Array.newInstance(type,maxSize);
    }
    public boolean push(T t){
        if(quote == stack.length){
            System.out.println("栈上溢");
            return false;
        }
        stack[quote] = t;
        quote++;
        return true;
    }
    public T pop(){
        if(quote == 0){
            System.out.println("栈下溢");
            return null;
        }
        quote--;
        return stack[quote];
    }
}
class queue<T>{
    private int length = 0;
    private int head = 0;
    private int tail = 0;
    private final T[] queue;
    private int maxSize = 10;
    @SuppressWarnings("unchecked")
    public queue(Class<T> type,int maxSize){
        this.maxSize = maxSize;
        queue = (T[]) Array.newInstance(type,maxSize);
    }
    @SuppressWarnings("unchecked")
    public queue(Class<T> type){
        queue = (T[]) Array.newInstance(type,maxSize);
    }
    public boolean enqueue(T t){
        if(tail - head >= maxSize){
            System.out.println("队列上溢");
            return false;
        }
        queue[tail%maxSize] = t;
        tail++;
        length++;
        return true;
    }
    public T dequeue(){
        if(tail == head){
            System.out.println("队列下溢");
            return null;
        }
        length--;
        return queue[(head++)%maxSize];
        //return queue[head++];
    }

    public int getLength() {
        return length;
    }
}
class doubleStack<T>{
    private final T[] doubleStack;
    private int first = 0;
    private int second = 9;
    private int maxSize = 10;
    @SuppressWarnings("unchecked")
    public doubleStack(Class<T> type,int maxSize){
        this.maxSize = maxSize;
        this.second = maxSize - 1;
        doubleStack = (T[]) Array.newInstance(type,maxSize);
    }
    @SuppressWarnings("unchecked")
    public doubleStack(Class<T> type){
        doubleStack = (T[]) Array.newInstance(type,maxSize);
    }
    public boolean pushFirst(T t){
        if(first == second + 1){
            System.out.println("FIRST栈上溢");
            return false;
        }
        doubleStack[first++] = t;
        return true;
    }
    public T popFirst(){
        if(first == 0){
            System.out.println("FIRST栈下溢");
            return null;
        }
        return doubleStack[--first];
    }
    public boolean pushSecond(T t){
        if(second == first - 1){
            System.out.println("SECONd栈上溢");
            return false;
        }
        doubleStack[second--] = t;
        return true;
    }
    public T popSecond(){
        if(second == maxSize - 1){
            System.out.println("SECOND栈下溢");
            return null;
        }
        return doubleStack[++second];
    }
}
class deque<T>{
    private final T[] deque;
    private int maxSize = 10;
    private int tail = 1;
    private int head = 0;
    @SuppressWarnings("unchecked")
    public deque(Class<T> type,int maxSize){
        this.maxSize = maxSize;
        deque = (T[]) Array.newInstance(type,maxSize);
    }
    @SuppressWarnings("unchecked")
    public deque(Class<T> type){
        deque = (T[]) Array.newInstance(type,maxSize);
    }
    public boolean enqueueHead(T t){
        if(tail - head == maxSize+1){
            System.out.println("栈上溢");
            return false;
        }
        deque[Math.floorMod(head,maxSize)] = t;
        head --;
        return true;
    }
    public T dequeueHead(){
        if(tail - head == 1){
            System.out.println("栈下溢");
            return null;
        }
        return deque[Math.floorMod(++head,maxSize)];
    }
    public boolean enqueueTail(T t){
        if (tail - head == maxSize + 1) {
            System.out.println("栈上溢");
            return false;
        }
        deque[Math.floorMod(tail++,maxSize)] = t;
        return true;
    }
    public T dequeueTail(){
        if(tail - head == 1){
            System.out.println("栈下溢");
            return null;
        }
        return deque[Math.floorMod(--tail,maxSize)];
    }
}
class twoStackOneQueue<T>{
    private final stack<T> stack_one;
    private final stack<T> stack_two;
    public twoStackOneQueue(Class<T> type,int maxSize){
        stack_one = new stack<>(type, maxSize);
        stack_two = new stack<>(type, maxSize);
    }
    public twoStackOneQueue(Class<T> type){
        stack_one = new stack<>(type);
        stack_two = new stack<>(type);
    }
    public boolean enqueue(T t){
        return stack_one.push(t);
    }
    public T dequeue(){
        T t = stack_two.pop();
        if(t == null){
            while ((t=stack_one.pop())!=null){
                stack_two.push(t);
            }

            return stack_two.pop();
        }
        return t;
    }
}
class twoQueueOneStack<T>{
    private final queue<T> queue_one;
    private final queue<T> queue_two;
    public twoQueueOneStack(Class<T> type,int maxSize){
        queue_one = new queue<>(type,maxSize);
        queue_two = new queue<>(type,maxSize);
    }
    public twoQueueOneStack(Class<T> type){
        queue_one = new queue<>(type);
        queue_two = new queue<>(type);
    }
    public boolean push(T t){
        if(queue_one.getLength() != 0 || queue_one.getLength() == queue_two.getLength()){
            System.out.println("queue_one enqueue " + t);
            return queue_one.enqueue(t);
        }
        return queue_two.enqueue(t);
    }
    public T pop(){
        //T t;
        if(queue_one.getLength() != 0 || queue_one.getLength() == queue_two.getLength()){
            int queue_one_length = queue_one.getLength();
            for(int i = 0; i < queue_one_length - 1;i++){
                //t = queue_one.dequeue();
                //System.out.println("queue_one dequeue " + t);
                queue_two.enqueue(queue_one.dequeue());
            }
            return queue_one.dequeue();
        }
        int queue_two_length = queue_two.getLength();
        for(int i = 0; i < queue_two_length - 1;i++){
            //t = queue_two.dequeue();
            //System.out.println("queue_two dequeue " + t);
            queue_one.enqueue(queue_two.dequeue());
        }
        return queue_two.dequeue();
    }

}










