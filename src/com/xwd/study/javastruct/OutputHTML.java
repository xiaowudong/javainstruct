package com.xwd.study.javastruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Pattern;

public class OutputHTML {
	private static Map<String,FiveTuple<String,String,String,String,String>> infoMap=InfoMap.infoMap;
	public static void outputHTML(PrintWriter pw,BufferedReader reader){
		outHead(pw);
		String message=null;
		try{
			int i=1;
			LineType lineType=null;
			pw.println("<div style='overflow:visible'>");
			pw.println("<div style='height:100%;z-index:1;overflow:auto;'>");
			while( (message = reader.readLine()) != null){
				pw.print(("000"+String.valueOf(i)).replaceAll("^.*(.{4})$","$1")+": ");//加入行号
				i++;
				lineType=getLineType(message);
				switch(lineType){
				case INSTRUCT :
					outInstruct(message,pw);
					break;
				case OTHER :
					outOther(message,pw);
					break;
				}
				pw.print("<br>");
				pw.println();
		    }
			pw.println("</div>");
			showHelp(pw);
			pw.println("</div>");
			bindEvent(pw);
		}catch(IOException e){
			e.printStackTrace();
		}
		outTail(pw);
    	pw.flush();
	}
	private static void outHead(PrintWriter pw){
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>");
		pw.println("字节码查看");
		pw.println("</title>");
		pw.println("</head>");
		pw.println("<body>");
	}
	private static void showHelp(PrintWriter pw){
		pw.println("<div id='showHelp' style='position:absolute;top:10;left:800px;z-index:2000;background-color:#F0FFF0;'>help info</div>");
		pw.println();
		pw.println();
		pw.println();
	}
	private static void outTail(PrintWriter pw){
		pw.println("</body>");
		pw.println("</html>");
	}
	private static  LineType getLineType(String line){
		LineType lineType=null;
		if(Pattern.matches("^ +\\d+:.*",line)){//该行是指令行
			lineType=LineType.INSTRUCT;
		}else{
			lineType=LineType.OTHER;
		}
		return lineType;
	}
	private static void outInstruct(String message,PrintWriter pw){
		String key=message.replaceAll("^\\s+\\d+:\\s+([^\\s]+).*$","$1");
		pw.print(message);
		pw.print("<input type='button' value='help' name='instructHelp' id='"+key+"'  onmouseover=\"instructHelpOnmouseover(this)\"/>");
	}
	private static void outOther(String message,PrintWriter pw){
		pw.print(message);
	}
	
	private static void bindEvent(PrintWriter pw){
		pw.println("<script type='text/javascript'>");
		pw.println(getJSON());//帮助信息
		pw.println("function instructHelpOnmouseover(e){");
		pw.println("var showObj=info.instructInfo[e.id]");
		pw.print("var showHTML=\"<table border='1'>");
		pw.print("<tr>");
		pw.print("<td>mnemonic</td><td>\"+showObj.mnemonic+\"</td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td>opcode</td><td>\"+showObj.opcode+\"</td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td>otherBytes</td><td>\"+showObj.otherBytes+\"</td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td>stack</td><td>\"+showObj.stack+\"</td>");
		pw.print("</tr>");
		pw.print("<tr>");
		pw.print("<td>description</td><td>\"+showObj.description+\"</td>");
		pw.print("</tr>");
		pw.println("</table>\";");
		pw.println("document.getElementById(\"showHelp\").innerHTML=showHTML;");
		pw.println("}");
		
		pw.println("</script>");
	}
	
	//得到帮助信息的js对象字符串
	private static String getJSON(){
		FiveTuple<String,String,String,String,String> fiveTupe=null;
		StringBuilder str=new StringBuilder();
		str.append("var info={");
		str.append("instructInfo:{");
		for(String instructName : infoMap.keySet()){
			fiveTupe=infoMap.get(instructName);
			str.append(instructName);
			str.append(":{");
			str.append("mnemonic");
			str.append(":");
			str.append("'"+fiveTupe.mnemonic+"',");
			str.append("opcode");
			str.append(":");
			str.append("'"+fiveTupe.opcode+"");
			try{
				str.append("_");
				str.append(Integer.parseInt(fiveTupe.opcode, 16));
//				str.append(fiveTupe.opcode);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				str.append("',");
			}
			str.append("otherBytes");
			str.append(":");
			str.append("'"+fiveTupe.otherBytes+"',");
			str.append("stack");
			str.append(":");
			str.append("'"+fiveTupe.stack+"',");
			str.append("description");
			str.append(":");
			str.append("'"+fiveTupe.description+"'");
			str.append("},");
		}
		str.delete(str.length()-1, str.length());
		str.append("}");
		str.append("}");
		return str.toString();
	}
	
}

