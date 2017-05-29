package com.example32.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linus on 08.04.2017.
 */
@Controller
public class SampleController {

   @Autowired
    public PersonDB personDB;
    @Autowired
    public CarDB carDB;
    @Autowired
    public RentsDB rentsDB;
    @RequestMapping("/signUp")
        public String signUp(Model model){
        model.addAttribute("person",new Person());
        model.addAttribute("message", "HELLO!");
        return "hello";
    }


    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("carsAmount",new HomeDao().countCars(carDB));
        model.addAttribute("usersAmount",personDB.count());
        return "index";
    }


    @RequestMapping("/showAllCars")
    public String showAllCars(Model model) {
        model.addAttribute("car",new Car());
        StringBuilder sb= new StringBuilder();
        List<Car> cars=new ArrayList<>();
       for(Car c: carDB.findAll())
           cars.add(c);
           // sb.append("<li class=\"list-group-item\">Model: "+c.getModel()).append( " Surname: "+c.getNr()).append(" Nr: "+.getNumber()).append("</li>");*/  = carDB.fin;
        model.addAttribute("cars",cars);
        return "showAllCars";
    }

    @RequestMapping("/chooseCar")
    public String chooseCar(Model model) {

        List<Car> cars=new ArrayList<>();
        List<String> time=new ArrayList<>();
        List<Car> carsRent=new ArrayList<>();
        for(Car c: carDB.findAll()){
            if(rentsDB.exists(c.getId())){
            carsRent.add(c);
            LocalDateTime  rentTime =rentsDB.findOne(c.getId()).getTime();
            LocalDateTime actualTime= LocalDateTime.now();
                if(actualTime.getDayOfYear()-rentTime.getDayOfYear()!=0){
                    time.add("Rent: "+(actualTime.getDayOfYear()-rentTime.getDayOfYear())+" days ago ");
                }
                else {
                    time.add("Rent: "+(actualTime.getHour()-rentTime.getHour())+" hours ago ");
                }

            }
            else
                cars.add(c);
        }

        model.addAttribute("cars",cars);
        model.addAttribute("time",time);
        model.addAttribute("carsRent",carsRent);
        return "showAllCars";
    }


    @RequestMapping("/showAllUsers")
    public String showAllUsers(Model model) {

       StringBuilder sb= new StringBuilder();
            for(Person p: personDB.findAll())
            sb.append("<li class=\"list-group-item\">Name: "+p.getName()).append( " Surname: "+p.getSurname()).append(" Nr: "+p.getNumber()).append("</li>");
        model.addAttribute("list",sb);
        return "show";
    }

    @RequestMapping("/saveCar")
    public String save(@ModelAttribute("Car") @Valid Car car, BindingResult result) {
        if ( result.hasErrors()) {
            return "redirect:/";
        }
        carDB.save(car);
        return "redirect:/showAllCars";
    }

    @RequestMapping("/saveUser")
    public String save(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if ( result.hasErrors()) {
            return "redirect:/";
        }
       personDB.save(person);
        return "redirect:/showAllUsers";
    }

    @RequestMapping("/userExist/{imie}")
    @ResponseBody
    public Person userExist( @PathVariable("imie") String username) {
       return personDB.findByName(username);

    }
    @RequestMapping("/rentCar")
    public String rentCar(@ModelAttribute("person") @Valid Person person, BindingResult result) {
        if ( result.hasErrors()) {
            return "redirect:/";
        }
        personDB.save(person);
        return "redirect:/showAllUsers";
    }




    /*@RequestMapping("/login")

    public String login( ) {
        return "login";

    }*/

}
