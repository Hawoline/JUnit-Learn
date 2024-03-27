import java.util.ArrayList;

public class Calculator {
    private int num1;
    private int num2;
    private ArrayList<Integer> nums = new ArrayList<>();
    
    
    public Calculator() {
        this(0, 0);
    }
    
    
    public Calculator(ArrayList<Integer> nums) {
        this(0, 0);
        this.nums.addAll(nums);
    }
    
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public int getNum1() {
        return num1;
    }
    
    public int getNum2() {
        return num2;
    }
    
    public ArrayList<Integer> getNums() {
        return nums;
    }
    
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    
    public void setNums(ArrayList<Integer> nums) {
        this.nums = nums;
    }
    
    public int sum() {
        if (nums == null || nums.size() < 2) {
            return num1 + num2;
        }
        
        return sumSeveralNums(nums);
    }
    
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
    
    public int sum(ArrayList<Integer> nums) {
        return sum();
    }
    
    private int sumSeveralNums(ArrayList<Integer> nums) {
        int result = 0;
        for (int num: nums) {
            result += num;
        }
        
        return result;
    }
}
