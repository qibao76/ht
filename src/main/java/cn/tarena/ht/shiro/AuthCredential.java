package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.utils.Encrpty;

//这个类是用来加密的
public class AuthCredential extends  SimpleCredentialsMatcher{
	
	//如果想做自定义的密码算法 需要重写该方法  没有指定必须要加密  没做也没错
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//要将用户提交过来的密码进行加密处理
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		//log.getPassword()获取的是 char数组[]
        String password = String.valueOf(loginToken.getPassword());
		
		//进行加密
		password = Encrpty.getMD5Hash(password, username);
		System.out.println(password);
		loginToken.setPassword(password.toCharArray());
		
		return super.doCredentialsMatch(loginToken, info);
		
	}
	
	
}
