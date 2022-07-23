package ex02;

public class Calculator {
    private int sizeArr;
    private int countThread;
    private int countGaps;
    private int tail;
    private int elementsGaps;
    private int elementsTail;

    public Calculator(int sizeArr, int countThread) {
        this.sizeArr = sizeArr;
        this.countThread = countThread;
    }

    public void countGaps() {
        if (sizeArr % countThread == 0) {
            countGaps = countThread;
            elementsGaps = sizeArr / countGaps;
            tail = 0;
            elementsTail = 0;

        } else {
            elementsGaps = (sizeArr - 1) / (countThread - 1);
            countGaps = countThread - 1;
            tail = 1;
            elementsTail = sizeArr - elementsGaps * (countThread - 1);
        }
        System.out.println("countTread = "+countThread+" sizeArr = "+sizeArr);
        System.out.println("gaps = "+countGaps+" elementsGaps = "+elementsGaps);
        System.out.println("tail = "+tail+" elementsTail = "+ elementsTail);
    }

    public int getSizeArr() {
        return sizeArr;
    }

    public void setSizeArr(int sizeArr) {
        this.sizeArr = sizeArr;
    }

    public int getCountThread() {
        return countThread;
    }

    public void setCountThread(int countThread) {
        this.countThread = countThread;
    }

    public int getCountGaps() {
        return countGaps;
    }

    public void setCountGaps(int countGaps) {
        this.countGaps = countGaps;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getElementsGaps() {
        return elementsGaps;
    }

    public void setElementsGaps(int elementsGaps) {
        this.elementsGaps = elementsGaps;
    }

    public int getElementsTail() {
        return elementsTail;
    }

    public void setElementsTail(int elementsTail) {
        this.elementsTail = elementsTail;
    }
}
