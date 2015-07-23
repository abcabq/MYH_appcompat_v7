package com.appcompat.Tool;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class Tools {
	public static List<String> contentList = new ArrayList<String>();
	public static List<Integer> contentList1 = new ArrayList<Integer>();

	public static int dp2px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	public static int px2dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	public static void logException(String s) {
		Log.i("exception", s);
	}

	/*
	 * 返回实际大小对应的像素值
	 */
	public static float getDensity(double d, Context context) {
		float density = 0;// 像素值
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		int y = dm.densityDpi;
		density = (float) (d * (y / 2.54));
		return density;
	}

	public static float getLength(double d, Context context) {
		float density = 0;// 像素值
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		int y = dm.densityDpi;
		density = (float) (d * (y / 2.54));
		return (float) Math.sqrt(density);
	}

	/*
	 * 设置屏幕亮度
	 */
	public static void setScreenBrightness(Activity activity, int value) {
		WindowManager.LayoutParams params = activity.getWindow()
				.getAttributes();
		params.screenBrightness = value / 255f;
		activity.getWindow().setAttributes(params);
	}

	public static List<String> getRadomChar(String ss) {
		contentList.clear();
		char[] allChar = new char[26];
		for (int i = 65; i < 91; i++) {
			allChar[i - 65] = (char) i;
		}
		// 存放已经取到的字符。为了方便使用list以及查找已经获取过的字符，因此使用list，目标是使用它的contains方法。
		int count = 3;

		while (count > 0) {
			try {
				// 取随机数，用以乘以26，得到[0,26)（大于等于零，小于26）的数字。
				double numDouble = Math.random() * 26;
				// 用得到的结果除以1，可得到0-25一共26个数字中的任何一个。
				int position = (int) numDouble / 1;
				// 判断对应位置上面的字符是否已经被取到，如果取到则直接进入下一个循环，不做保存处理。
				if (contentList.contains(String.valueOf(allChar[position]))){
					continue;
				}
				// 如果之前没有被取到，则保存到结果集当中，并将计数数字减一。
				if(String.valueOf(allChar[position]).equals(ss)){
					continue;
				}
				contentList.add(String.valueOf(allChar[position]));
				count--;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i("info", "随机数异常："+e.toString());
			}
		}
		// 获取到了指定数目的不同字符，循环输出

		return contentList;
	}

	public static List<Integer> getRadomInt() {
		contentList1.clear();
		// 存放已经取到的字符。为了方便使用list以及查找已经获取过的字符，因此使用list，目标是使用它的contains方法。
		int count = 4;
		while (count > 0) {
			// 取随机数，用以乘以26，得到[0,26)（大于等于零，小于26）的数字。
			double numDouble = Math.random() * 4;
			// 用得到的结果除以1，可得到0-25一共26个数字中的任何一个。
			int position = (int) numDouble / 1;
			// 判断对应位置上面的字符是否已经被取到，如果取到则直接进入下一个循环，不做保存处理。
			if (contentList1.contains(position))
				continue;
			// 如果之前没有被取到，则保存到结果集当中，并将计数数字减一。
			contentList1.add(position);
			count--;
		}
		// 获取到了指定数目的不同字符，循环输出

		return contentList1;
	}
}
