package cn.linkbook.registry.biz.service.Object;

import org.springframework.util.StringUtils;

/**
 * @author 王琦 <1124602935@qq.com>
 * @DATE 2018/10/28 3:21.
 * @Description 邮件发送对象
 */
public class EmailMessage {

    /** 用户名 **/
    private String pickName;

    /** 接受人邮箱地址 **/
    private String emailAddress;

    /** 邮件标题 **/
    private String title;

    /** 邮件内容 **/
    private String content;

    /** 邮件正文模板 **/
    enum EmailMode{
        account_activation("账号激活", "【LinkBook账号激活】 %s 您好, 感谢注册链书搜索，点击下面链接进行邮箱账号激活/n http://*********/%s, [10分钟内有效]"),
        change_password("找回密码", "【LinkBook找回密码】 %s 您好, 点击下方链接重新设定密码/n http://*********/%s, [10分钟内有效]");

        private String type;
        private String model;

        EmailMode(String type, String model){
            this.type = type;
            this.model = model;
        }
    }


    public EmailMessage(){

    }

    public EmailMessage(String emailAddress, String title, String content) {
        this.emailAddress = emailAddress;
        this.title = title;
        this.content = content;
    }

    public EmailMessage(String pickName, String emailAddress, String title, String content) {
        this.pickName = pickName;
        this.emailAddress = emailAddress;
        this.title = title;
        this.content = content;
    }

    public String getPickName() {
        return pickName;
    }

    public void setPickName(String pickName) {
        this.pickName = pickName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentModel(EmailMode msgModel) {
        String name = StringUtils.isEmpty(this.pickName) ? this.emailAddress : this.pickName;
        this.content = String.format(msgModel.model, name, this.emailAddress);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EmailMessage{");
        sb.append("pickName='").append(pickName).append('\'');
        sb.append(", emailAddress='").append(emailAddress).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
