package com.ingym.DailyTracking.start;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class hard_work {
// " say-hard work and smart work both" => "I t is the only way to achieve goals"
  @RequestMapping("say-letsStart")
  @ResponseBody
  public String sayitStart() {
	  return "hard work and smart work both are required for success";
  }
  @RequestMapping("say-HTML")
  @ResponseBody
  public String sayHTML() {
	  StringBuffer sb=new StringBuffer();
	  sb.append("<html>");
	  sb.append("<head>");
	  sb.append("<title> Muscle Building </title>");
	  sb.append("</head>");
	  sb.append("<body>");
	  sb.append("Three pillars:"+"\n"
	  		+ "Diet > Workout > Sleep \n");
	
	
	  sb.append("</body>");
	  sb.append("</html>");
	  
	  return sb.toString();
  }
  
  @RequestMapping("say-letsStart-jsp")
 
  public String sayitJsp() {
	  return "sayitJsp";
  }
}
