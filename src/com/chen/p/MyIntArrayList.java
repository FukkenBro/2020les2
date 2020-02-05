package com.chen.p;

public class MyIntArrayList implements IntList {

    private int size = 0;
    private int[] elementData = new int[10];

    public int[] getElementData() {
        return elementData;
    }

    private void ensureCapacity() {
        if (elementData.length <= size + 1) {
            int[] tmpArr = new int[elementData.length * 3 / 2 + 1];
            System.arraycopy(elementData, 0, tmpArr, 0, elementData.length);
            elementData = tmpArr;
        }
    }

    private void sizeValidator() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
    }

    private void indexValidator(int index) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("Index out of range");
        }
    }

    public void arrayCopy(int[] srcElementData, int srcFromIndex, int lenght) {
        System.arraycopy(srcElementData, srcFromIndex, elementData, 0, lenght);
        size = lenght;
    }

    @Override
    public boolean add(int element) {
        ensureCapacity();
        elementData[size] = element;
        size++;
        return true;
    }


    @Override
    public boolean add(int index, int element) throws Exception {
        indexValidator(index);
        ensureCapacity();
        if (index == size + 1) {
            add(element);
            return true;
        }
        int[] tmpArr = new int[elementData.length];
        tmpArr[index] = element;
        if (index == 0) {
            System.arraycopy(elementData, 0, tmpArr, 1, size);
        } else {
            System.arraycopy(elementData, 0, tmpArr, 0, index - 1);
            System.arraycopy(elementData, index, tmpArr, index + 1, size - index);
        }
        elementData = tmpArr;
        size++;
        return true;
    }

    @Override
    public void clear() throws Exception {
        sizeValidator();
        elementData = new int[10];
        size = 0;
    }

    @Override
    public int get(int index) throws Exception {
        indexValidator(index);
        return elementData[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) throws Exception {
        sizeValidator();
        indexValidator(index);
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        size--;
        return true;
    }

    @Override
    public boolean removeByValue(int value) throws Exception {
        sizeValidator();
        for (int i = 0; i <= size; i++) {
            if (value == elementData[i]) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int set(int index, int element) throws Exception {
        sizeValidator();
        indexValidator(index);
        int previousElement = elementData[index];
        elementData[index] = element;
        return previousElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIntArrayList subList(int fromIndex, int toIndex) throws Exception {
        sizeValidator();
        indexValidator(fromIndex);
        indexValidator(toIndex);
        if (toIndex <= fromIndex) {
            throw new Exception("toIndex !> fromIndex");
        }
        MyIntArrayList result = new MyIntArrayList();
        result.arrayCopy(elementData, fromIndex, (toIndex - fromIndex));
        return result;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(elementData, 0, result, 0, size);
        return result;
    }

    public void bubbleSort() throws Exception {
        sizeValidator();
        int[] arr = toArray();
        int n = size;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
        arrayCopy(arr, 0, size);
    }

}
