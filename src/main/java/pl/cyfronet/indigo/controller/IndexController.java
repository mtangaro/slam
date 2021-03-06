package pl.cyfronet.indigo.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.cyfronet.indigo.security.PortalUser;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView home(PortalUser user) {
        ArrayList<String> roles = new ArrayList<>();

        for (GrantedAuthority authority : user.getAuthorities()) {
            roles.add(authority.getAuthority());
        }

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", user);
        mav.addObject("user_roles", roles);
        mav.addObject("admin_sites", roles);
        String version  = System.getProperty("app.version");
        if (version==null){
            version = String.class.getPackage().getImplementationVersion();
        }
        mav.getModelMap().addAttribute("version", version);
        return mav;
    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/");
        return redirectView;
    }
}
