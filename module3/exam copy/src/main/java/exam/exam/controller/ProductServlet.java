package exam.exam.controller;

import exam.exam.model.Category;
import exam.exam.model.Product;
import exam.exam.service.IProductService;
import exam.exam.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {"/product",""})
public class ProductServlet extends HttpServlet {
    private IProductService productService;
    private final String[] listcolumn = {"STT", "Product Name", "Price", "Quantity", "Color", "Category", "Action"};

    public void init(){
        productService=new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "search":
                searchProduct(request,response);
                break;
            case "sort":
            default:
                listProduct(request, response);
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key=request.getParameter("key");
        String value=request.getParameter("value");
        List<Product> products=productService.search(key,value);
        List<Category> listCategory=productService.findListCategory();
        request.setAttribute("listColumn", listcolumn);
        request.setAttribute("listCategory",listCategory);
        request.setAttribute("products",products);
        request.setAttribute("key", key);
        request.setAttribute("value", value);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id= Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("/product?m=1");
//        request.setAttribute("products",products);
//        request.setAttribute("messageinfo","Delete sucessfully");
//        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
//        dispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String m = request.getParameter("m");
        if(m != null){
            request.setAttribute("m", Integer.parseInt(m));
        }
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Category> listCategory=productService.findListCategory();
        List<Product> products=productService.selectAllProduct((page - 1) * recordsPerPage, recordsPerPage);
        int noOfRecords = productService.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//        List<Product> products=productService.selectAllProduct();
        request.setAttribute("products",products);
        request.setAttribute("listCategory",listCategory);
        request.setAttribute("listColumn", listcolumn);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                try {
                    updateProduct(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                searchProduct(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        int category= Integer.parseInt(request.getParameter("category"));
        Product product=new Product(name,price,quantity,color,description,category);
        productService.insertProduct(product);
        response.sendRedirect("/product?m=3");

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String name=request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String description=request.getParameter("description");
        int code_category= Integer.parseInt(request.getParameter("category"));
//        int code_category = 0;
//        switch (category){
//            case "Phone":
//                code_category=1;
//                break;
//            case "Television":
//                code_category=2;
//                break;
//            case "Motorbike":
//                code_category=3;
//                break;
//
//        }
        Product product=new Product(id,name,price,quantity,color,description,code_category);
        productService.updateProduct(product);
        response.sendRedirect("/product?m=2");

    }
}
