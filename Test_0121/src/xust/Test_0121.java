package xust;

/*
1.��һ
����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�
����Լ���������� 0 ֮�⣬��������������㿪ͷ��

ʾ�� 1:
����: [1,2,3]
���: [1,2,4]
����: ���������ʾ���� 123��

ʾ�� 2:
����: [4,3,2,1]
���: [4,3,2,2]
����: ���������ʾ���� 4321��
 */
/*
 * �㷨˼�룺
 * �ȸ�����������ĩλ��1����ĩλ��ʼ���������λ��ʼ�����������λС��10�����������ֱ�ӷ����޸ĺ��ԭ����
 * �����λ��С��10������Ҫ��λ����λʱ�Ƚ���λ���㣬�ٸ�ǰһλ��1��ֱ��ѭ��������
 * ѭ����ϻ�û�з����޸ĺ��ԭ���飬˵�����λҲ�����˽�λ
 * ���½����飬�������λ��λ�������
 */
//public class Test_0121 {
//	public static void main(String[] args) {
//		Solution So = new Solution();
//		int[] digits = {9,9};
//		//��ӡ����
//		int[] ret_digits = So.plusOne(digits);
//		for(int i=0; i<ret_digits.length; i++){
//			System.out.print(ret_digits[i]+" ");
//		}
//	}
//}
//class Solution {
//    public int[] plusOne(int[] digits) {
//    	digits[digits.length-1]++;//ĩλ��һ
//    	for(int i=digits.length-1; i>=0; i--){
//    		if(digits[i]<10){//С��10��ֱ�ӷ����޸ĺ��ԭ����
//    			return digits;
//    		}
//    		//ĩλ��С��10����Ҫ��λ
//    		else{
//    			digits[i]=0;//��λ����
//    			if(i!=0){
//    				digits[i-1]++;//ǰһλ��1
//    			}
//    		}
//    	}
//    	//ѭ����ϻ�û�з����޸ĺ��ԭ���飬˵�����λҲ�����˽�λ
//    	//�½����鷵�����λ��λ�������
//    	int[] ret_digits = new int[digits.length+1];
//		ret_digits[0]=1;
//		for(int j=1; j<ret_digits.length; j++){
//			ret_digits[j]=digits[j-1];
//		}
//		return ret_digits;
//    }
//}
/*
2.���������
���������������ַ������������ǵĺͣ��ö����Ʊ�ʾ����
����Ϊ�ǿ��ַ�����ֻ�������� 1 �� 0��
ʾ�� 1:
����: a = "11", b = "1"
���: "100"

ʾ�� 2:
����: a = "1010", b = "1011"
���: "10101"
 */
/*
 * �㷨˼�룺��������һ�����ƣ�������������ַ����Ӻ���ǰ������ai��bj�ֱ���a��b��Ӧλ��ֵ��carry��ʾ��λֵ��
 * �����Ӧλ�ĺ�c = ai + bj + carry����c>2,���ʾ��Ҫ��λ����ret��λ�ϵ�ֵΪ1����c==2,��λ1��ret��λΪ0��
 * ��c<2,��λΪ0��ret��λֵΪc��ÿ�μ����걾λ�ϵ�ֵ��Ӧ����ret��ѭ����ϣ�����λΪ1���ٽ���λ����ret.
 * ����ѭ��ʱret���ɵ�λ���λ��ģ���˻���Ҫ��ret��ת��Ȼ�󷵻�ret.
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
        int carry = 0;//��λ
        for(int i =a.length()-1,j=b.length()-1; i>=0 || j>=0; i--,j--){
        	int ai = i>=0 ? a.charAt(i)-'0' : 0;
        	int bj = j>=0 ? b.charAt(j)-'0' : 0;
        	int c = ai + bj + carry;//��λ�ϵ�ֵ���ڶ�Ӧλ��ֵ��Ӻͽ�λ�ĺ�
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
        //��ת
        String ret_reverse = "";
        for(int i=ret.length()-1; i>=0; i--){
        	ret_reverse += (ret.charAt(i) + "");
        }
        return ret_reverse;
    }
}
