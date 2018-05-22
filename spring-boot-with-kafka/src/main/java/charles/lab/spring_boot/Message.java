package charles.lab.spring_boot;

import java.util.Date;

public class Message {
  private Long id;
  private String msg;
  private Date sendDate;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public Date getSendDate() {
    return sendDate;
  }
  public void setSendDate(Date sendDate) {
    this.sendDate = sendDate;
  }
  
  
}
