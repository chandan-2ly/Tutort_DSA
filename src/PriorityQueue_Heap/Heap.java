package PriorityQueue_Heap;

public class Heap {
    int capacity;
    int count;
    int[] arr;
    int heapType;

    Heap(int _capacity, int _heapType){
        this.heapType = _heapType;
        this.capacity = _capacity;
        this.count = 0;
        this.arr = new int[_capacity];
    }

    public static int getMax(Heap h){
        if(h.count == 0)
            return -1;
        if(h.heapType == 1)
            return h.arr[0];
        return h.arr[h.count - 1];
    }

    public static int getMin(Heap h){
        if(h.count == 0)
            return -1;
        if(h.heapType == 0)
            return h.arr[0];
        return h.arr[h.count - 1];
    }

    public static int findParent(Heap h, int i){
        int p = (i-1)/2;

        if(p < 0)
            return -1;
        return p;
    }
    public static int findLeftChild(Heap h, int i){
        int lc = 2 * i + 1;
        if(lc > h.count - 1)
            return -1;
        return lc;
    }

    public static int findRightChild(Heap h, int i){
        int rc = 2 * i + 2;
        if(rc > h.count - 1)
            return -1;
        return rc;
    }

    public static void perculateDown(Heap h, int i){
        int max = i;

        int lc = findLeftChild(h, i);
        int rc = findRightChild(h, i);

        if(lc != -1 && h.arr[lc] > h.arr[i]){
            max = lc;
        }
        if(rc != -1 && h.arr[rc] > h.arr[max] ){
            max = rc;
        }

        if(max != i){
            swap(h, i, max);
            perculateDown(h, max);

        }
    }

    private static void swap(Heap h, int i, int j){
        int temp = h.arr[i];
        h.arr[i] = h.arr[j];
        h.arr[j] = temp;
    }
    public static int deleteElement(Heap h, int i){
        if(h.count == 0 || i >= h.count)
            return -1;
        int data = h.arr[i];
        int last = h.count - 1;
        swap(h, i, last);
        h.count--;
        //re-heapify the tree
        perculateDown(h, i);

        return data;
    }

    public static void perculateUp(Heap h, int i){
        int parent = findParent(h, i);
        while (i >= 0 && h.arr[i] > h.arr[parent]){
            swap(h, i, parent);
            i = (i-1)/2;
            parent = findParent(h, i);
        }
    }

    public static void insert(Heap h, int data){
        if(h.count == h.capacity)
            resizeHeap(h);

        h.count++;
        int i = h.count - 1;
        h.arr[i] = data;
        perculateDown(h, i);

    }

    private static void resizeHeap(Heap h) {
        int[] arr = h.arr;
        int[] newArr = new int[arr.length*2];
        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        h.arr = newArr;
    }
}
