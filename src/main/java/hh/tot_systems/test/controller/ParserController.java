package hh.tot_systems.test.controller;

import hh.tot_systems.test.enteties.HistoryOfSecurities;
import hh.tot_systems.test.enteties.Securities;
import hh.tot_systems.test.parse.Parser;
import hh.tot_systems.test.service.HistoryService;
import hh.tot_systems.test.service.SecuritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParserController {

    @Autowired
    private SecuritiesService securitiesService;
    @Autowired
    private HistoryService    historyService;

    @GetMapping("/parser")
    public String parserStart() {
        return "parser";
    }

    @PostMapping("parseSecurities")
    public String parseSecuritiesFromFile(@RequestParam(name = "fileName") String fileName) {
        for (Securities securities : Parser.parseSecurities(fileName)) {
            securitiesService.create(securities);
        }
        return "redirect:/parser";
    }

    @PostMapping("parseHistoryOfSecurities")
    public String parseHistoryOfSecuritiesFromFile(@RequestParam(name = "fileName") String fileName) {
        for (HistoryOfSecurities history : Parser.parseHistoryOfSecurities(fileName)) {
            historyService.create(history);
        }
        return "parser";
    }

}
