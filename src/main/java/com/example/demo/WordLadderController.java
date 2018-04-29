package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.WordLadder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
public class WordLadderController {
    WordLadder wl = new WordLadder();

    protected static Logger logger=LoggerFactory.getLogger(WordLadderController.class);

    @GetMapping("/wordladder")
    @RequestMapping(value="/wordladder", method = RequestMethod.GET)
    public String helloworld(@RequestParam String w1, @RequestParam String w2) {
        logger.debug("输入w1,Name={}",w1);
        logger.debug("输入w2,Name={}",w2);
        Set<String> dic = new HashSet<String>();
        wl.getKeyWords(dic);
        return wl.getLadder(w1, w2, dic);
    }
}
