package com.xwd.study.javastruct;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class InputClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		InputClass.inputClass("src/com/cdai/jvm/bytecode/ByteCodeSample.class","C:/Users/Administrator/Desktop/byteCode.txt",true);
		InputClass.inputClass("src/EnumTest$xwdT.class","C:/Users/Administrator/Desktop/byteCode.txt",false);

	}
	public static void inputClass(String inputPath,String outputpath,boolean isAdd){
		try{
			InputStream inputStream=new FileInputStream(inputPath);
			int r=0;
			int ifBreakLine=1;
			try{
				FileWriter outF=new FileWriter(outputpath,isAdd);
				do{
					r=inputStream.read();
					outF.write((Integer.toHexString(r).toUpperCase().replaceAll("^(.*)$","0$1").replaceAll("^.?(.{2})$","$1")));
//					System.out.print(String.valueOf(r).replaceAll("^(.*)$","  $1").replaceAll("^.*(.{3})$","$1"));
					if(ifBreakLine%16==0){
						outF.write("\n");
					}else{
						outF.write(" ");
					}
					ifBreakLine++;
				}while(r!=-1);
				outF.flush();
				outF.close();
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				
			}
				
			
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
		}
	}
	public static void inputClass(String inputPath){
		try{
			InputStream inputStream=new FileInputStream(inputPath);
//			InputStream outputStream=new FileInputStream(outputpath);
			int r=0;
			int ifBreakLine=1;
			try{
				do{
					r=inputStream.read();
					System.out.print(Integer.toHexString(r).toUpperCase().replaceAll("^(.*)$","0$1").replaceAll("^.?(.{2})$","$1"));
//					System.out.print(String.valueOf(r).replaceAll("^(.*)$","  $1").replaceAll("^.*(.{3})$","$1"));
					if(ifBreakLine%16==0){
						System.out.println();
					}else{
						System.out.print(" ");
					}
					ifBreakLine++;
				}while(r!=-1);
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				
			}
				
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}finally{
		}
	}

}
