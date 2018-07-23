package app06a;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectElementTag extends SimpleTagSupport {
	private String[] arr = { "usa", "china", "brazil" };

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspContext jspcontext = getJspContext();
		JspWriter out = jspcontext.getOut();
		out.print("<select>\n");
		for (int i = 0; i < 3; i++) {
			getJspContext().setAttribute("value", arr[i]);
			getJspContext().setAttribute("text", arr[i]);
			getJspBody().invoke(null);
		}
		out.print("</select>\n");
	}

}
