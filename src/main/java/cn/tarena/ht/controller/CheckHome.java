package cn.tarena.ht.controller;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CheckHome {
	public static void main(String[] args) {
		File file = new File("C:/Users/Administrator/Desktop/D_Oracle");
		String names="周华强,马武,陈俊,方程伟,顾家梁,王忻禕,施春华,胡实,王浩,汤敏,苏志鹏,陈天文,陈琦,程乔,丁洋,邱斌权,袁洲洋,丁健立,王振雷,曹嘉丰,吴锐,杨超,田原,郭鹏,阚健飞,庄耀明,吕辉,朱建华,钱旭东,秦天能,朱峰,唐小俊,李琦,张俊,孟猛,梁杏杏,米芮平,李再起,章钱亮,邢龙,白露," +
				"黄赣龙,陈赛花,赵宇欣,陈皓,沈元军,邹军,张毅,黄一波,廖敏,吴鹏君,张满意,王东东,张健,石兆平,";
		Map<String,String> map=new HashMap<String,String>();
		String[] split = names.split(",");
		for (int i = 0; i < split.length; i++) {
			map.put(split[i], "");
		}
		File[] listFile = file.listFiles();
		for (File file2 : listFile) {
			String s=names;
			File[] listFiles = file2.listFiles();
			String[] array=new String[listFiles.length];
			int i=0;
			for (File file3 : listFiles) {
				array[i++]=file3.getName().replaceAll("\\w","").replaceAll("\\.","").trim();
			}
			for (int j = 0; j < array.length; j++) {
				s=s.replaceAll(array[j]+",","");
			}
			String[] split2 = s.split(",");
			for (int j = 0; j < split2.length; j++) {
				map.put(split2[j],map.get(split2[j])+file2.getName()+"未提交 ");
			}
		}

		Set<Entry<String,String>> entrySet = map.entrySet();
		int index=1;
		for (Entry<String, String> entry : entrySet) {
			if(entry.getValue().equals("")){
				System.out.println(index+++"      "+entry.getKey()+" 全 部 提 交 , 表 扬 下 ! ! !");
				continue;
			}
			System.out.println(entry);

		}



	}
}
