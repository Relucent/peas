package com.peas.framework.email;


/**
 * 邮件测试类
 * @author 
 * @since 2013-8-2
 */

public class MailTest {
	public static void main(String[] args){
     //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();
     mailInfo.setMailServerHost("smtp.163.com");
     mailInfo.setMailServerPort("25");
     mailInfo.setValidate(true);
     mailInfo.setUserName("ly_0199@163.com");//邮箱用户名
     mailInfo.setPassword("lijinquan163");//您的邮箱密码
     mailInfo.setFromAddress("ly_0199@163.com");
     mailInfo.setToAddress("ly_0199@163.com");//收件人
     mailInfo.setSubject("标题");//标题
     mailInfo.setContent("邮件内容");//邮件内容
     //mailInfo.addFile("附件路径");//添加附件,给的是附件路径,如d://test.xls
     //这个类主要来发送邮件
     SimpleMailSender sms = new SimpleMailSender();
     sms.sendHtmlMail(mailInfo);//发送邮件
   }  
}
