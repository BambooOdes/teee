package datastruct.struct;

public class linkedListTest {
}
class linkedList<T>{
    private linkedListElements<T> sentinel;

}
class linkedListElements<T>{
    private linkedListElements<T> pre;
    private  linkedListElements<T> next;
    private T area;
    public linkedListElements(T t){
        this.area = t;
    }
    public void setPre(linkedListElements<T> pre){
        this.pre = pre;
    }
}
