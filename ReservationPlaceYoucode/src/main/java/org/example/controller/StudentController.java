package org.example.controller;


import org.example.DAO.TypeResDaoImpl;
import org.example.Entity.*;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.Repostory.TypeResRepository;
import org.example.service.ReservationService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeResDaoImpl typeResDao;

    @RequestMapping(value = "/prossecRes", method = RequestMethod.POST)

    public  String ProsseRes(@ModelAttribute("res") ReservationEntity reservationEntity, HttpServletRequest req, Model model, HttpSession session)
    {
        reservationEntity.setUser(AuthenticatedUser.user);
        ReservationRepostory reservationRepostory=new ReservationRepostory();
        int idType = reservationEntity.getTypeRes().getId();
        TypereservationEntity typereservationEntity = typeResDao.getTypeResById(idType);
        if(typereservationEntity.getNomberClass()>reservationRepostory.getAllReservationsDat(reservationEntity.getDateRes()).size())
        {
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            reservationEntity.setConfirmation(true);
            model.addAttribute("reservations",reservations);
            reservationService.addRes(reservationEntity);
            model.addAttribute("msg",  "Well add");
            return "DashbordStudent";
        }
        else
        {
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            model.addAttribute("reservations",reservations);

            reservationEntity.setConfirmation(false);
            reservationService.addRes(reservationEntity);
            model.addAttribute("msg",  "Well add");
            return "DashbordStudent";
        }


    }

    @RequestMapping(value = "dashbord")
    public String rege(@ModelAttribute("dashbord") ReservationEntity reservationEntity, Model model, HttpSession session){

        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("student"))
        {
            ReservationRepostory reservationRepostory=new ReservationRepostory();
            Object idUser=session.getAttribute("id");
            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsById((Integer) idUser);
            model.addAttribute("msg", "");
            model.addAttribute("reservations",reservations);

            return "DashbordStudent";
        }
        else
        {
            return "redirect:/";

        }

    }

    @RequestMapping(value = "EditPfS")
    public String Edit(@ModelAttribute("EditPfS") UseradminEntity useradminEntity,Model model,HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        useradminEntity=userService.getUserById((Integer) idUser);
        model.addAttribute("user",useradminEntity);
        return "EdtiProfileST";
    }


    @RequestMapping(value = "ProsseModifPr")
    public String ModifProfile(HttpServletRequest req, HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        int id=(Integer)idUser;
        String FName=req.getParameter("firstName");
        String LName=req.getParameter("lastName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        UseradminEntity useradminEntity=new UseradminEntity(id,FName,LName,email,password);

        userService.updateUser(useradminEntity);

        AuthenticatedUser.user=useradminEntity;

        session.setAttribute("Fname",AuthenticatedUser.user.getFirstName());
        session.setAttribute("lasname",AuthenticatedUser.user.getLastName());
        return "redirect:/dashbord";
    }

    @RequestMapping(value = "deleteRestudent")
    public String deleteRes(HttpServletRequest req)
    {

        int id= Integer.parseInt(req.getParameter("id"));

        reservationService.deleteRes(id);

        return "redirect:/dashbord";
    }

}
