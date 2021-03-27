package com.ltts.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.project.Dao.CheckoutDao;
import com.ltts.project.Dao.MovieDao;
import com.ltts.project.model.Checkout;
import com.ltts.project.model.Movie;

public class checkoutController {

	
	@Autowired
	CheckoutDao cod;
	
	
	}

