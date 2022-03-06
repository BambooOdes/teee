package datastruct.algrithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sort {
    public static void main(String[] args){
        int[] mergeNum = new int[]{1, 3, 5, 2, 3, 6,8,2,35,6,6};
        int[] insertNum = new int[]{1, 3, 5, 2, 3, 6,8,2,35,6,6};
        MergeSort.mergeSort(mergeNum,0,mergeNum.length-1);
        InsertSort.insertSort(insertNum);
        System.out.println("mergeNum "+Arrays.toString(mergeNum));
        System.out.println("insertNum "+Arrays.toString(insertNum));
    }


}
class InsertSort{
    public static void insertSort(int[] num ){
        for(int i = 1;i< num.length;i++){
            int temp = num[i];
            int j;
            for(j = i - 1;j>=0&&num[j]>temp;j--){
                num[j+1] = num[j];
            }
            num[j+1] = temp;
        }
    }
}
class MergeSort{
    public static void mergeSort(int[] num,int start,int end){
        if(start != end){
            int mid = (start + end)/2;
            mergeSort(num,0,mid);
            mergeSort(num,mid+1,end);
            merge(num,0,mid+1,end);
        }
    }
    private static void merge(int[] num,int start,int mid,int end){
        int[] left = Arrays.copyOfRange(num,start,mid);
        int[] right = Arrays.copyOfRange(num,mid,end+1);
        int l = 0;
        int r = 0;
        int i = 0;
        for(;l<left.length&&r<right.length;i++){
            if(left[l] <= right[r] ){
                num[i] = left[l];
                l++;
            }
            else {
                num[i] = right[r];
                r++;
            }
        }
        while (r < right.length){
            num[i] = right[r];
            i++;
            r++;
        }
        while (l <left.length){
            num[i] = left[l];
            i++;
            l++;
        }
    }
}