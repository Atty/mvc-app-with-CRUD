package hh.tot_systems.test.controller;


import hh.tot_systems.test.enteties.HistoryOfSecurities;
import hh.tot_systems.test.enteties.Securities;
import hh.tot_systems.test.service.SecuritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SecuritiesController {

    @Autowired
    private SecuritiesService securitiesService;

    @GetMapping("/securities")
    public String allSecurities() {
        return "allSecurities";
    }

    @PostMapping("getAllSecurities")
    public String getAllSecurities(Model model) {
        List<Securities> allSecurities = securitiesService.getAllSecurities();
        for (Securities s : allSecurities) {
            System.out.println(s);
            for (HistoryOfSecurities h : s.getHistoryOfSecuritiesList()) {
                System.out.println(h);
            }
        }
        model.addAttribute("allSecurities", allSecurities);
        return "allSecurities";
    }

    @PostMapping("deleteSecurities")
    public String deleteSecurities(@RequestParam(name = "id") int id) {
        securitiesService.delete(id);
        return "allSecurities";
    }

    @PostMapping("addSecurities")
    public String addSecurities(@RequestParam(name = "id") int id,
                                @RequestParam(name = "sec_id") String sec_id,
                                @RequestParam(name = "reg_number") String reg_number,
                                @RequestParam(name = "name") String name,
                                @RequestParam(name = "emitent_title") String emitent_title) {
        securitiesService.create(new Securities(id, sec_id, reg_number, name, emitent_title));
        return "allSecurities";
    }

    @PostMapping("updateSecurities")
    public String updateSecurities(@RequestParam(name = "id") int id,
                                   @RequestParam(name = "reg_number") String reg_number,
                                   @RequestParam(name = "name") String name,
                                   @RequestParam(name = "emitent_title") String emitent_title) {

        securitiesService.update(id, new Securities(id, "", reg_number, name, emitent_title));

        return "allSecurities";
    }

    @PostMapping("getSecurities")
    public String getSecurities(@RequestParam(name = "id") int id, Model model) {
        model.addAttribute("getSecurities", securitiesService.getSecurities(id));
        return "allSecurities";
    }

}
