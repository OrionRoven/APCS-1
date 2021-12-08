/*
Team Incredibly Cohesive (David Chen, Jaylen Zeng, Orion Roven)
APCS pd7
HW43 -- Array of Grade 316
12/7/21
time elapsed: 0.8 hours
DISCO:
our program requires a ton of memory because we have to create new temporary arrays and loop through them so the visualizer isn't helpful because it exceeds the time limit
QCC:
is there a simpler way to code toString() so that we don't have to loop through the array and exceed the visualizer time limit
*/

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray {

    private int[] _data; // underlying container
    private int _size; // number of elements in this SuperArray

    // default constructor – initializes 10-item array
    public SuperArray() {
        /* YOUR IMPLEMENTATION HERE */
        this._data = new int[10];
        this._size = this._data.length;
    }

    // output SuperArray in [a,b,c] format
    public String toString() {
        String result = "[";
        for (int i = 0; i < _data.length; i++) {
            result += _data[i];
            if (i != _data.length - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }

    // double capacity of SuperArray
    private void expand() {
        /* YOUR IMPLEMENTATION HERE */
        int[] temp = new int[_data.length * 2];
        for (int i = 0; i < _data.length; i++) {
            temp[i] = _data[i];
        }
        this._data = temp;
        this._size *= 2;
    }

    // accessor -- return value at specified index
    public int get(int index) {
        /* YOUR IMPLEMENTATION HERE */
        return this._data[index];
    }

    // mutator -- set value at index to newVal,
    // return old value at index
    public int set(int index, int newVal) {
        /* YOUR IMPLEMENTATION HERE */
        int oldVal = this._data[index];
        this._data[index] = newVal;
        return oldVal;
    }

    public void add(int num) {
        int[] temp = new int[_data.length + 1];
        for (int i = 0; i < _data.length; i++) {
            temp[i] = _data[i];
        }
        temp[temp.length - 1] = num;
        this._data = temp;
        this._size++;
    }

    public void add(int index, int num) {
        int[] temp = new int[_data.length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = _data[i];
        }
        temp[index] = num;
        for (int i = index; i < _data.length; i++) {
            temp[i + 1] = _data[i];
        }
        this._data = temp;
        this._size++;
    }

    public void remove() {
        int[] temp = new int[_data.length - 1];
        for (int i = 0; i < _data.length - 1; i++) {
            temp[i] = _data[i];
        }
        this._data = temp;
        this._size--;
    }

    public void remove(int index) {
        int[] temp = new int[_data.length - 1];
        for (int i = 0; i < index; i++) {
            if (i == index) {
                i = this._size - 1;
            }
            temp[i] = _data[i];
        }
        for (int i = index; i < _data.length - 1; i++) {
            temp[i] = _data[i + 1];
        }
        this._data = temp;
        this._size--;
    }

    // main method for testing
    public static void main(String[] args) {
        SuperArray curtis = new SuperArray();
        System.out.println("Printing empty SuperArray curtis...");
        System.out.println(curtis);
        for (int i = 0; i < curtis._data.length; i++) {
            curtis.set(i, i * 2);
        }
        System.out.println("Printing populated SuperArray curtis...");
        System.out.println(curtis);
        for (int i = 0; i < 3; i++) {
            curtis.expand();
            System.out.println("Printing expanded SuperArray curtis...");
            System.out.println(curtis);
        }

        SuperArray ra = new SuperArray();
        System.out.println("Initial ra: " + ra);
        ra.add(5);
        System.out.println("Ra after adding 5: ");
        System.out.println(ra);
        ra.add(2, 7);
        System.out.println("AddAtIndex ra: ");
        System.out.println(ra);
        System.out.println("Removing value at index 2...");
        ra.remove(2);
        System.out.println(ra);
        System.out.println("Removing, no parameters");
        ra.remove();
        System.out.println(ra);

    }// end main()

}
// end class
