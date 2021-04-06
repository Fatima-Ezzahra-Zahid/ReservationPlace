package org.example.controller;

import org.example.Entity.ReservationEntity;
import org.example.Entity.StudentEntity;
import org.example.Entity.UseradminEntity;
import org.example.Global.AuthenticatedUser;
import org.example.Repostory.ReservationRepostory;
import org.example.Repostory.UserRepostory;
import org.example.service.ReservationService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    private UserService userService;


    @Autowired
    private JavaMailSender mailSender;

    ReservationRepostory reservationRepostory=new ReservationRepostory();


    @RequestMapping(value = "dashbordadmin")
    public String rege(@ModelAttribute("dashbord")UseradminEntity useradminEntity, Model model,HttpSession session){

        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("admin"))
        {
            UserRepostory userRepostory=new UserRepostory();

            List<UseradminEntity> users = userRepostory.getAllStudents();

            model.addAttribute("users",users);
            System.out.println(users);

            return "AdmiDashbord";
        }

        else
        {
            return "redirect:/";

        }
    }


    @RequestMapping(value = "confiEmail")
    public String ConfirmEmail(HttpServletRequest req)
    {
        UserRepostory userRepostory=new UserRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

      boolean accpeted=AuthenticatedUser.user.setAccepted(true);

        UseradminEntity useradminEntity=new UseradminEntity(id,accpeted);

        userRepostory.updateUserAccpect(useradminEntity);

       useradminEntity=userService.getUserById(id);

        //send mail
        String email = useradminEntity.getEmail();
        String subject = "request to join in ResApp";
        String message = " your account is accepted";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("ResApp");
        mailSender.send(simpleMailMessage);


        return "redirect:/dashbordadmin";
    }


    @RequestMapping(value = "deleteEmail")
    public String deletemEmail(HttpServletRequest req)
    {

        UserRepostory userRepostory=new UserRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=AuthenticatedUser.user.setAccepted(false);

        UseradminEntity useradminEntity=new UseradminEntity(id,accpeted);

        userRepostory.updateUserAccpect(useradminEntity);

        useradminEntity=userService.getUserById(id);

        //send mail
        String email = useradminEntity.getEmail();
        String subject = "Email to join in ResApp";
        String message = "your account is not accepted";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom("ResApp");
        mailSender.send(simpleMailMessage);




        return "redirect:/dashbordadmin";
    }



    @RequestMapping(value = "ShowRes")
    public String ShoweRes(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model,HttpSession session){


        if(session.getAttribute("id")!=null&&session.getAttribute("role").equals("admin")) {

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");


            System.out.println(dt);


            List<ReservationEntity> reservations = reservationRepostory.getAllReservationsDat(formatter.format(dt));

            model.addAttribute("res", reservations);


            return "ShowReservation";
        }
        else
        {
            return "redirect:/";
        }
    }



    @RequestMapping(value = "confiRes")
    public String ConfirRes(HttpServletRequest req)
    {


        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(true);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);




        return "redirect:/ShowRes";
    }


    @RequestMapping(value = "deleteRes")
    public String deleteRes(HttpServletRequest req)
    {

        ReservationEntity res=new ReservationEntity();
        ReservationRepostory resevationRepostory=new ReservationRepostory();
        int id= Integer.parseInt(req.getParameter("id"));

        boolean accpeted=res.setConfirmation(false);

        ReservationEntity reservationEntity=new ReservationEntity(id,accpeted);

        resevationRepostory.Confirm(reservationEntity);


        return "redirect:/ShowRes";
    }


    @RequestMapping(value = "EditPfAdmin")
    public String Edit(@ModelAttribute("EditPfS") UseradminEntity useradminEntity,Model model,HttpSession session)
    {
        Object idUser=session.getAttribute("id");
        useradminEntity=userService.getUserById((Integer) idUser);
        model.addAttribute("user",useradminEntity);
        return "EditePrAdmin";
    }


    @RequestMapping(value = "ProsseModifPrAdmin")
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
        return "redirect:/dashbordadmin";
    }



    @RequestMapping(value = "ShowResByDate")
    public String ShoweResDate(@ModelAttribute("dashbord")ReservationEntity reservationEntity, Model model,HttpServletRequest req){



        String dateres=req.getParameter("date");


        List<ReservationEntity> reservations = reservationRepostory.getAllReservationsDat(dateres);

        model.addAttribute("res",reservations);


        return "ShowReservation";
    }


}
