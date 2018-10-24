package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.exeception.SpittleNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: SpittleController</p>
 *
 * @description:
 * @author: xiongzy
 * @date: 2018-10-22
 **/
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
        // model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        // return "spittles";
    }

    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {

        spittleRepository.save(new Spittle(form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";

    }

    /*
     * 加入控制器通知类 就不需要了
     */
    // @ExceptionHandler(DuplicateSpittleException.class)
    // public String handleDuplicateSpittle() {
    //     return "error/duplicate";
    // }
}