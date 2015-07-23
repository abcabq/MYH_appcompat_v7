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
	 * ����ʵ�ʴ�С��Ӧ������ֵ
	 */
	public static float getDensity(double d, Context context) {
		float density = 0;// ����ֵ
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		int y = dm.densityDpi;
		density = (float) (d * (y / 2.54));
		return density;
	}

	public static float getLength(double d, Context context) {
		float density = 0;// ����ֵ
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		int y = dm.densityDpi;
		density = (float) (d * (y / 2.54));
		return (float) Math.sqrt(density);
	}

	/*
	 * ������Ļ����
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
		// ����Ѿ�ȡ�����ַ���Ϊ�˷���ʹ��list�Լ������Ѿ���ȡ�����ַ������ʹ��list��Ŀ����ʹ������contains������
		int count = 3;

		while (count > 0) {
			try {
				// ȡ����������Գ���26���õ�[0,26)�����ڵ����㣬С��26�������֡�
				double numDouble = Math.random() * 26;
				// �õõ��Ľ������1���ɵõ�0-25һ��26�������е��κ�һ����
				int position = (int) numDouble / 1;
				// �ж϶�Ӧλ��������ַ��Ƿ��Ѿ���ȡ�������ȡ����ֱ�ӽ�����һ��ѭ�����������洦��
				if (contentList.contains(String.valueOf(allChar[position]))){
					continue;
				}
				// ���֮ǰû�б�ȡ�����򱣴浽��������У������������ּ�һ��
				if(String.valueOf(allChar[position]).equals(ss)){
					continue;
				}
				contentList.add(String.valueOf(allChar[position]));
				count--;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i("info", "������쳣��"+e.toString());
			}
		}
		// ��ȡ����ָ����Ŀ�Ĳ�ͬ�ַ���ѭ�����

		return contentList;
	}

	public static List<Integer> getRadomInt() {
		contentList1.clear();
		// ����Ѿ�ȡ�����ַ���Ϊ�˷���ʹ��list�Լ������Ѿ���ȡ�����ַ������ʹ��list��Ŀ����ʹ������contains������
		int count = 4;
		while (count > 0) {
			// ȡ����������Գ���26���õ�[0,26)�����ڵ����㣬С��26�������֡�
			double numDouble = Math.random() * 4;
			// �õõ��Ľ������1���ɵõ�0-25һ��26�������е��κ�һ����
			int position = (int) numDouble / 1;
			// �ж϶�Ӧλ��������ַ��Ƿ��Ѿ���ȡ�������ȡ����ֱ�ӽ�����һ��ѭ�����������洦��
			if (contentList1.contains(position))
				continue;
			// ���֮ǰû�б�ȡ�����򱣴浽��������У������������ּ�һ��
			contentList1.add(position);
			count--;
		}
		// ��ȡ����ָ����Ŀ�Ĳ�ͬ�ַ���ѭ�����

		return contentList1;
	}
}
