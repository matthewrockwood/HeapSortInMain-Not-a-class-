package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
      /*  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(2);
        priorityQueue.add(19);
        priorityQueue.add(56);
        priorityQueue.add(28);

        priorityQueue.remove();
        priorityQueue.remove();
        System.out.println(priorityQueue);*/

        int[] arr = new int[]{3,6,4,23,6,1,8};
        printArr(arr);

        System.out.println("--");
        heapsort(arr);
        printArr(arr);

        Random rand = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] array1000 = new int[1000];
        for(int i = 0; i<1000;i++){
            int x = rand.nextInt(1000);
            array1000[i] = x;
            arrayList.add(x);
            System.out.println(array1000[i]);
        }
        heapsort(array1000);

        arrayList.sort(null);
        printArr(array1000);
        System.out.println("--");
        System.out.println("--");
        System.out.println("--");
        System.out.println("--");

        for (Integer x: arrayList) {
            System.out.println(x);
            
        }
        System.out.println(compare2Lists(arrayList,array1000));






    }
    public static void heapsort(int[] a){
        int[] heap = new int[a.length];
        int heapLength = heap.length;
        for(int i = 0; i<a.length;i++){
            heap[i] = a[i];
            heapifyUp(heap,i);
        }
        for(int i = 0; i<heap.length;i++){
            a[i] = getMin(heap,heapLength);
            heapLength--;
        }


    }
    public static int getMin(int[] heap, int heapLength){
        int ans = heap[0];
        heap[0] = heap[heapLength-1];
        heapifyDown(heap,heapLength);


        return ans;
    }

    private static void heapifyDown(int[] heap,int heapLength) {
        int temp = 0;
        while (true) {
            int leastChildIndex = getLeastChildIndex(heap, heapLength, temp);
            if (leastChildIndex == -1 || heap[temp] <= heap[leastChildIndex]) {
                break;
            }
            swap(heap, temp, leastChildIndex);
            temp = leastChildIndex;
        }
    }



    public static void printArr(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
    public static void heapifyUp(int[] data, int index){

        while(data[getParentIndex(index)]>data[index]){
            swap(data,index,getParentIndex(index));
            index = getParentIndex(index);
            if(index==0) return;
        }
    }
    public static int getParentIndex(int index){
        return (index-1)/2;
    }
    public static int getLeftChildIndex(int index){
        return 2 * index +1;
    }
    public static int getRightChildIndex(int index){
        return 2*index+2;
    }
    public static int getLeastChildIndex(int[] a, int heapLength, int index){

        int left = getLeftChildIndex(index);
        int right = getRightChildIndex(index);

        if (left < heapLength && right < heapLength) {
            if (a[left] < a[right]) {
                return left;
            } else {
                return right;
            }
        } else if (left < heapLength) {
            return left;
        } else if (right < heapLength) {
            return right;
        }
        return -1;
    }
    public static boolean compare2Lists(ArrayList<Integer> x, int[] y){
        if(x.size()!=y.length)return false;
        for (int i =0; i<y.length;i++) {
            if(x.get(i)!=y[i])return false;

        }
        return true;
    }
}