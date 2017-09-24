package TestOne.others;


public class EightQueen {  // recurse

    private static final int NUM = 8;
    private int[] chess = new int[8];
    private int count;

    private void print() {
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                if (chess[i] == j) {
                    System.out.print("● ");
                } else {
                    System.out.print("○ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean canPlace(int row, int position) {
        for (int i = 0; i < row; i++) {
            if (chess[i] == position || Math.abs(position - chess[i]) == Math.abs(row - i)) {
                //System.out.println("false");
                return false;
            }
        }
        //System.out.println(position);
        return true;
    }

    private void place(int row) {
        //System.out.println(row);
        if (row == 8) {
            print();
            count++;
            return;
        }
        for (int i = 0;i < 8;i++){
            if (canPlace(row, i)) {
                //System.out.println(row);
                //System.out.println(i);
                chess[row] = i;
                //print();
                place(row + 1);                // can't use ++row! you can't change row's value! very important!
            }
        }
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.place(0);
        //eightQueen.print();
        System.out.println("解法有：" + eightQueen.count + "种");
    }
}
