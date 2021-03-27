package org.example.controller;

import org.example.Entity.TypereservationEntity;
import org.example.Entity.UseradminEntity;
import org.example.Repostory.UserRepostory;
import org.example.service.TypeResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TypeResController {


    @Autowired
    private TypeResService typeResService;



    @RequestMapping(value = "TypeRes")
    public String DisplayType(@ModelAttribute("typeRes")TypereservationEntity typereservationEntity, Model model, HttpSession session){


        List<TypereservationEntity> types = typeResService.getAllTypeRes();

        model.addAttribute("types",types);

        return "TypeReservation";
    }


    @RequestMapping(value = "ModifType")
    public String DisplayModifType(@ModelAttribute("typeRes")TypereservationEntity typereservationEntity, HttpServletRequest req,Model model){


        int id= Integer.parseInt(req.getParameter("id"));

        typereservationEntity=typeResService.getTypeResById(id);
        model.addAttribute("type",typereservationEntity);

        return "ModifType";
    }


}
