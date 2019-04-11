package cn.zmc.xtwh.servlet;

import cn.zmc.xtwh.domain.Admin;
import cn.zmc.xtwh.service.AdminService;
import cn.zmc.xtwh.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private AdminService service = new AdminServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletRespons response) throws ServletException,IOException{
        doGet(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletRespons response) throws ServletException,IOException{
        try {
            //设置响应头
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("utf-8");

            //设置参数 中文会出错
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            //分装对象
            Admin admin = new Admin(null,name,pwd,null);
            //查询数据库
            admin = (Admin) service.login(admin);
            //判断登录是否成功
            if (admin == null){
                System.out.println("登录失败："+admin);
                //跳去登录页，重新登录
                //重定向，标准路劲，302，是2洗请求，不能带数据
                //请求转发，可以携带数据，路径直接写，是服务端发出的
            }
        }catch (Exception e){

        }
    }

}
