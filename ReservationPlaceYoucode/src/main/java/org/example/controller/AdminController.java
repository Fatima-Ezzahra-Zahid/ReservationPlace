package org.example.controller;

import org.example.Entity.ReservationEntity;
import org.example.Entity.UseradminEntity;
import org.example.Repostory.UserRepostory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {



    @RequestMapping(value = "dashbordadmin")
    public String rege(@ModelAttribute("dashbord")UseradminEntity useradminEntity, Model model){

        UserRepostory userRepostory=new UserRepostory();

        List<UseradminEntity> users = userRepostory.getAllStudents();

         model.addAttribute("users",users);
        System.out.println(users);

        return "AdmiDashbord";
    }
}
