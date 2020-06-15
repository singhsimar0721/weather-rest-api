package com.service.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Default Controller for root maping of the application.
 * Redirects root page to swagger-ui.html
 * 
 * @author Simarpreet Singh, created on 10 April 2020.
 * 
 */

@Controller
@ApiIgnore
public class HomeController
{

	/**
	 * Root path default mapping.
	 * @return
	 */
    @RequestMapping("/")
    public String home()
    {
        return "redirect:swagger-ui.html";
    }

}
