package todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tododao.TodoDao;
import tododto.TodoDto;

@WebServlet("/mainservlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = -406301754822748447L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		TodoDao dao = TodoDao.getInstance();
		List<TodoDto> totalList = dao.getTodos();
		List<TodoDto> todoList = new ArrayList<>();
		List<TodoDto> doingList = new ArrayList<>();
		List<TodoDto> doneList = new ArrayList<>();

		for (TodoDto dto : totalList) {
			if (dto.getType().equals("TODO")) {
				todoList.add(dto);
			} else if (dto.getType().equals("DOING")) {
				doingList.add(dto);
			} else {
				doneList.add(dto);
			}
		}

		request.setAttribute("todolist", todoList);
		request.setAttribute("doinglist", doingList);
		request.setAttribute("donelist", doneList);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/main.jsp");
		requestDispatcher.forward(request, response);

	}

}
