package com.xwd.studyjavainstruct;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.xwd.study.javastruct.OutputHTML;

public class WatchJavaP {
	public static void main(String[] args) {
		System.out.println("解析开始。。。");
		Runtime r = Runtime.getRuntime();
		Process p = null;
		Process p1 = null;
		File f = new File("I:/git/javainstruct/test/com/xwd/studyjavainstruct/");
		String className = "Test";
		File outF = new File("C:/Users/Administrator/Desktop/byteCode.html");
		try {
			p1 = r.exec("cmd /c javac " + className + ".java", null, f);
			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			p = r.exec("cmd /c javap -verbose " + className+".class", null, f);
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