package cn.tarena.ht.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Encrpty {
	public static String getMD5Hash(String password,String username){
		Md5Hash md5Password = new Md5Hash(password, username, 3);
		return md5Password.toString();
	}
	public static void main(String[] args) {
		/**md5hash
		 * source 代表明文密码
		 * salt   盐    添加作料
		 * hash  次数
		 */
		Md5Hash password = new Md5Hash("123", "admin", 3);
		System.out.println(password);
	}

}
