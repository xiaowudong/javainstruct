package com.xwd.study.javainstruct.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.xwd.study.javastruct.OutputHTML;

public class WatchJavaP {
	public static void main(String[] args) {
		Class<?> watchC=Test.class;//将要查看的类   该类必须在改项目中
		StringBuilder classFileDir=new StringBuilder(System.getProperty("user.dir"));
		classFileDir.append(java.io.File.separator);
		classFileDir.append("target");
		classFileDir.append(java.io.File.separator);
		classFileDir.append("test-classes");
		String[] classNameSplit=watchC.getName().split("\\.");
		for(int i=0;i<classNameSplit.length-1;i++){
			classFileDir.append(java.io.File.separator);
			classFileDir.append(classNameSplit[i]);
		}
		classFileDir.append(java.io.File.separator);
		System.out.println("解析开始。。。");
		Runtime r = Runtime.getRuntime();
		Process p = null;
		Process p1 = null;
		File f = new File(classFileDir.toString());
		//目标HTML文件路径
		File outF = new File(System.getProperty("user.dir")+java.io.File.separator+"target"+java.io.File.separator+watchC.getName()+".HTML");
		try {
//			p1 = r.exec("cmd /c javac " + className + ".java", null, f);
			BufferedReader reader = null;
//			reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			p = r.exec("cmd /c javap -verbose " + watchC.getSimpleName()+".class", null, f);
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			PrintWriter pw = new PrintWriter(outF);
			OutputHTML.outputHTML(pw, reader);
			pw.close();
			System.out.println("正常结束。。。");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}