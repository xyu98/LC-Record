public class Solution860 {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        Solution860_1 s = new Solution860_1();
        System.out.println(s.lemonadeChange(bills));
    }
}

class Solution860_1 {
    public boolean lemonadeChange(int[] bills) {
        int need = 0;
        int five = 0, ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5: five++; break;
                case 10: ten++; break;
                case 20: ;
            }
            need = bill - 5;
            if (need == 5) {
                if (five == 0) return false;
                else five--;
            }
            if (need == 10) {
                if (five < 2 && ten == 0) return false;
                if (ten > 0) ten--;
                else five -= 2;
            }
            if (need == 15) {
                if ((five == 0 && ten > 0) || (five < 3 && ten == 0)) return false;
                if (ten == 0) five -= 3;
                else {
                    five--;
                    ten--;
                }
            }
        }
        return true;
    }
}