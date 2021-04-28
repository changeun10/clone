package todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tododao.TodoDao;
import tododto.TodoDto;

@WebServlet("/changeservlet")
public class TodoChangeServlet extends HttpServlet {
	private static final long serialVersionUID = -6912063488313759615L;

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("id"));

		TodoDto dto = new TodoDto();
		dto.setType(type);
		dto.setId(id);

		TodoDao dao = TodoDao.getInstance();
		int updateResult = dao.updateTodo(dto);

		PrintWriter out = response.getWriter();
		if (updateResult == 1) {
			out.print("success");
		} else {
			out.print("fail");
		}
		out.close();
	}

}
