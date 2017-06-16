package app06a;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyFirstTag implements SimpleTag {
	JspContext jspcontext;

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dotag");
		jspcontext.getOut().print("this is my first tag");
	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub
		System.out.println("set parent");
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		System.out.println("get parent");
		return null;
	}

	@Override
	public void setJspContext(JspContext pc) {
		// TODO Auto-generated method stub
		System.out.println("set jspcontext");
		this.jspcontext = pc;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// TODO Auto-generated method stub
		System.out.println("set jspbody");
	}

}
