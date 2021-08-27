package hh.tot_systems.test.controller;

import hh.tot_systems.test.enteties.HistoryOfSecurities;
import hh.tot_systems.test.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public String allHistory() {
        return "allHistory";
    }

    @PostMapping("getAllHistory")
    public String getAllHistory(Model model) {
        List<HistoryOfSecurities> allHistory = historyService.getAllHistory();
        model.addAttribute("allHistory", allHistory);
        return "allHistory";
    }

    @PostMapping("deleteHistory")
    public String deleteHistory(@RequestParam(name = "sec_id") String sec_id,
                                @RequestParam(name = "trade_date") String trade_date,
                                @RequestParam(name = "num_trades") String num_trades) {
        historyService.delete(sec_id, trade_date, num_trades);
        return "allHistory";
    }

    @PostMapping("addHistory")
    public String createHistory(@RequestParam(name = "sec_id") String sec_id,
                                @RequestParam(name = "trade_date") String trade_date,
                                @RequestParam(name = "num_trades") String num_trades,
                                @RequestParam(name = "open") String open,
                                @RequestParam(name = "close") String close) {

        historyService.create(new HistoryOfSecurities(sec_id,
                Date.valueOf(trade_date),
                Double.parseDouble(num_trades),
                Double.parseDouble(open),
                Double.parseDouble(close)));

        return "allHistory";
    }

    @PostMapping("getHistory")
    public String getHistory(@RequestParam(name = "sec_id") String sec_id, Model model) {

        model.addAttribute("getHistory", historyService.getHistory(sec_id));

        return "allHistory";
    }
}
