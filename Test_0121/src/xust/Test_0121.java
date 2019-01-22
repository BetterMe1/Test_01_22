package xust;

/*
1.加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
/*
 * 算法思想：
 * 先给传入的数组的末位加1，从末位开始向数组的首位开始遍历，如果本位小于10，计算结束，直接返回修改后的原数组
 * 如果本位不小于10，则需要进位，进位时先将本位清零，再给前一位加1，直到循环结束。
 * 循环完毕还没有返回修改后的原数组，说明最高位也进行了进位
 * 则新建数组，返回最高位进位后的数组
 */
//public class Test_0121 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] digits = {9,9};
//		//打印数组
//		int[] ret_digits = So.plusOne(digits);
//		for(int i=0; i<ret_digits.length; i++){
//			System.out.print(ret_digits[i]+" ");
//		}
//	}
//}
//class Solution {
//    public int[] plusOne(int[] digits) {
//    	digits[digits.length-1]++;//末位加一
//    	for(int i=digits.length-1; i>=0; i--){
//    		if(digits[i]<10){//小于10，直接返回修改后的原数组
//    			return digits;
//    		}
//    		//末位不小于10，需要进位
//    		else{
//    			digits[i]=0;//本位清零
//    			if(i!=0){
//    				digits[i-1]++;//前一位加1
//    			}
//    		}
//    	}
//    	//循环完毕还没有返回修改后的原数组，说明最高位也进行了进位
//    	//新建数组返回最高位进位后的数组
//    	int[] ret_digits = new int[digits.length+1];
//		ret_digits[0]=1;
//		for(int j=1; j<ret_digits.length; j++){
//			ret_digits[j]=digits[j-1];
//		}
//		return ret_digits;
//    }
//}
/*
2.二进制求和
给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。
示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"
 */
/*
 * 算法思想：此题与上一题相似，将传入的两个字符串从后向前遍历，ai、bj分别是a、b对应位的值，carry表示进位值，
 * 计算对应位的和c = ai + bj + carry，若c>2,则表示需要进位，且ret本位上的值为1，若c==2,进位1，ret本位为0，
 * 若c<2,进位为0，ret本位值为c，每次计算完本位上的值都应存入ret，循环完毕，若进位为1，再将进位存入ret.
 * 由于循环时ret是由低位向高位存的，因此还需要将ret逆转，然后返回ret.
 */
public class Test_0121 {
	public static void main(String[] args) {
		Solution So = new Solution();
		String a = "1010";
		String b = "1011";
		System.out.println(So.addBinary(a, b));
	}
}
class Solution {
    public String addBinary(String a, String b) {
        String ret="";
        int carry = 0;//进位
        for(int i =a.length()-1,j=b.length()-1; i>=0 || j>=0; i--,j--){
        	int ai = i>=0 ? a.charAt(i)-'0' : 0;
        	int bj = j>=0 ? b.charAt(j)-'0' : 0;
        	int c = ai + bj + carry;//本位上的值等于对应位的值相加和进位的和
        	if(c > 2){
        		carry = 1;
        		ret += "1";
        	}
        	else if(c == 2){
        		carry = 1;
        		ret += "0";
        	}
        	else{
        		carry = 0;
        		ret += (c + "");
        	}
        }
        if(carry == 1){
        	ret += (carry + "");
        }
        //逆转
        String ret_reverse = "";
        for(int i=ret.length()-1; i>=0; i--){
        	ret_reverse += (ret.charAt(i) + "");
        }
        return ret_reverse;
    }
}
