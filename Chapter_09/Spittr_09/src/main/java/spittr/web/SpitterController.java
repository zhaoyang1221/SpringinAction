package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

/**
 * <p>Title: SpitterController</p>
 *
 * @description: 用户
 * @author: xiongzy
 * @date: 2018-10-23
 **/
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors,
            RedirectAttributes model) { // RedirectAttributes 扩展了model类
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);  // flash属性可以携带数据直到下一次请求
        // model.addAttribute("spitterId", spitter.getId()); // 会以查询参数的形式附加到重定向的URL上， 例如："spitterhabuma?spitterId=42"
        // return "redirect:/spitter/" + spitter.getUsername(); //直接拼接string，如果username中存在特殊字符可能导致url解析出错
        return "redirect:/spitter/{username}"; //URL模板方式 使用占位符可以对username进行转义，可以使用任意字符
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {

            model.addAttribute(spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}