/**
 * 
 */
package com.mcs.util;

import java.util.Random;

public class RandomUtil {

	private static Random r = new Random();
	private static String ssource = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
	private static char[] src = ssource.toCharArray();
	/**
	 * 生成随机数字
	 * @param length 
	 */
	public static String randomDigit(int length){

		String s = "";
		for (int i = 0; i < length; i++)
        {
			s = s + r.nextInt(10);
        } 
		
		return s;
	}
	
	/**
     * 产生随机字符串
     * @param length
     * @return
     */
	public static String randomCode(int length)
    {
        char[] buf = new char[length];
        int rnd;
        for (int i = 0; i < length; i++)
        {
            rnd = Math.abs(r.nextInt()) % src.length;

            buf[i] = src[rnd];
        }
        return new String(buf);
    }
	
	
	/**
	 * 返回在start与end之间的一个数
	 */
	public static int randomDigit(int start, int end) {
		
//		int data = 0;
//		while(true) {
//			data = r.nextInt(end);
//			if(data > start && data < end)
//				break;
//		}
//		
//		return data;
		
		return r.nextInt(end - start) + start;
	}

	/**
	 * 返回n个在start与end之间的数
	 */
	public static Integer[] randomDigit(int start,int end, int n) {
		Integer[] data = new Integer[n];
		
		for(int i = 0; i < n;i ++) {
			int temp = r.nextInt(end - start) + start;
			
			data[i] = temp;
			
		}
		
		return data;
	}

	
	public static void main(String[] argv) {
		System.out.println(RandomUtil.randomDigit(8));
		System.out.println(RandomUtil.randomCode(6));
	}
	
}
