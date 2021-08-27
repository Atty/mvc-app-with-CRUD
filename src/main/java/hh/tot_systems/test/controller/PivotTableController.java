package hh.tot_systems.test.controller;

import hh.tot_systems.test.dao.PivotTableRepo;
import hh.tot_systems.test.enteties.PivotList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PivotTableController {

    @Autowired
    PivotTableRepo pivotTableRepo;


    @GetMapping("/")
    public String start() {
        return "start";
    }

    @GetMapping("/securitiesAndHistory")
    public String pivotTableStart() {
        return "securitiesAndHistory";
    }

    @PostMapping("getAll")
    public String pivotTable(Model model) {

        List<PivotList> pivot = pivotTableRepo.findPivot();

        model.addAttribute("pivot", pivot);

        return "securitiesAndHistory";
    }
}
