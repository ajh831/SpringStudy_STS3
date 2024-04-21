package com.loginform.myapp;

import com.loginform.dao.UserDAO;
import com.loginform.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    UserDAO userDao;

    @Autowired
    RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        System.out.println("registerForm.jsp");
        String id = request.getParameter("id");
        String password = request.getParameter("pwd");
        String name = request.getParameter("uName");
//        Date birth = request.getParameter("birth");
        String birthStr = request.getParameter("birth");

        if (id.equals("") || password.equals("") || name.equals("") || birthStr.equals("")) {
            model.addAttribute("errorMessageALL", "아이디, 비밀번호, 이름, 생년월일은 필수입력입니다.");
            return "registerForm";
        }

//        if (birthStr.equals("")) {
//            model.addAttribute("errorMessageBirth", "생년월일을 입력해주세요.");
//            return  "registerForm";
//        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = dateFormat.parse(birthStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String address = request.getParameter("address");
        System.out.println("userId : " + id);
        System.out.println("userPwd : " + password);
        System.out.println("userName : " + name);
        System.out.println("userBirth : " + birth);
        System.out.println("userAddress : " + address);

        if(registerService.idCheck(id) == 1) {
            System.out.println(registerService.idCheck(id) + " cnt 확인중");
            System.out.println("아이디 존재함");
            model.addAttribute("errorMessage", "이미 등록된 아이디입니다. 다른 아이디를 사용해주세요.");
            return "registerForm";
        } else {
            User user = new User();
            user.setId(id);
            System.out.println("user id 담긴지 확인 : " + user.getId());
            user.setPwd(password);
            user.setName(name);
            user.setBirth(birth);
            user.setAddress(address);

            registerService.register(user);



//        if ()
            return "index";
        }


    }

}
