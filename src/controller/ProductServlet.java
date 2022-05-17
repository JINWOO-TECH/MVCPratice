package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MainDAOImpl;
import model.ProductVO;


@WebServlet("*.do")
public class ProductServlet extends HttpServlet {

    public ProductServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getRequestURI();
		int lastIndex = command.lastIndexOf("/");
		String str = command.substring(lastIndex);
		
		//main
		if(str.equals("/main.do")) {
			//디스페처
			RequestDispatcher rd= request.getRequestDispatcher("/main.html");
			rd.forward(request, response);	
		}
		
		//제품삽입 폼
		else if(str.equals("/insertForm.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			try {
				request.setAttribute("groupCode", dao.selectGcode());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd= request.getRequestDispatcher("/insertProductForm.jsp");
			rd.forward(request, response);
		}
		//제품삽입
		else if(str.equals("/insert.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			ProductVO product= new ProductVO();
			int count=0; //업데이트갯수
			product.setCode(request.getParameter("code"));
			product.setPname(request.getParameter("pname"));
			product.setCost(Integer.parseInt(request.getParameter("cost")));
			product.setPnum(Integer.parseInt(request.getParameter("pnum")));
			product.setJnum(Integer.parseInt(request.getParameter("jnum")));
			product.setSale(Integer.parseInt(request.getParameter("sale")));
			product.setGcode(request.getParameter("gcode"));
			//insert
			try {
				count=dao.create(product);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("count", count);
			RequestDispatcher rd= request.getRequestDispatcher("/insert.jsp");
			rd.forward(request, response);
		}
		
		//제품조회&수정 입력폼
		else if(str.equals("/selectProductForm.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			try {
				request.setAttribute("groupCode", dao.selectGcode());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd= request.getRequestDispatcher("/selectProductForm.jsp");
			rd.forward(request, response);
		}
		
		//제품  조회후 양식
		else if(str.equals("/select.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			String code=request.getParameter("code");
			ProductVO  product = new ProductVO();
			try {
				product  = dao.readOne(code);
				request.setAttribute("groupCode", dao.selectGcode());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("product", product);
			RequestDispatcher rd= request.getRequestDispatcher("/selectProductForm.jsp");
			rd.forward(request, response);
		}
		
		//제품 업데이트 
		else if(str.equals("/update.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			ProductVO product  = new  ProductVO();
			int count=0; //업데이트갯수
			product.setCode(request.getParameter("code"));
			product.setPname(request.getParameter("pname"));
			product.setCost(Integer.parseInt(request.getParameter("cost")));
			product.setPnum(Integer.parseInt(request.getParameter("pnum")));
			product.setJnum(Integer.parseInt(request.getParameter("jnum")));
			product.setSale(Integer.parseInt(request.getParameter("sale")));
			product.setGcode(request.getParameter("gcode"));
//			System.out.println("업데이트제품확인"+product);//제품확인
			try {
				count  = dao.update(product);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("count", count);
			RequestDispatcher rd= request.getRequestDispatcher("/update.jsp");
			rd.forward(request, response);
			
		}
		
		//제품 삭제
		else if(str.equals("/delete.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			int count=0; //삭제갯수
			try {
				count=dao.delete(request.getParameter("code"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("count", count);
			RequestDispatcher rd= request.getRequestDispatcher("/delete.jsp");
			rd.forward(request, response);
			
		}
		
		else if(str.equals("/PreferredProduct.do") || str.equals("/selectRank.do") ) {
			MainDAOImpl dao = new MainDAOImpl();
			RequestDispatcher rd=null;
			String sql = null;
			if(str.equals("/PreferredProduct.do")){
				try {
					sql = "select * from  product  where 목표수량*0.2 > 재고수량";
					request.setAttribute("list",dao.ProductList(sql) );
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rd= request.getRequestDispatcher("/PreferredProduct.jsp");
			}
			else {
				try {
					sql = "select * from  product  order by(출고가-제품원가)*재고수량 desc";
					request.setAttribute("list",dao.ProductList(sql) );
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rd= request.getRequestDispatcher("/selectRank.jsp");
			}

			rd.forward(request, response);	
		}
		
		else if(str.equals("/groupRemain.do")) {
			MainDAOImpl dao = new MainDAOImpl();
			try {
				request.setAttribute("list",dao.groupRemain() );
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd= request.getRequestDispatcher("/groupRemain.jsp");
			rd.forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
