package com.shop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.proc.Product;
import com.shop.proc.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	List<Product> list = null;
	@Inject
	ProductService service;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		list = service.findAll();
		model.addAttribute("product", list);
		return "product";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newMerchant(ModelMap model) {
		model.addAttribute("films", new Product());
		return "newProduct";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String addMerchant(@ModelAttribute("product") Product product, ModelMap model) {
		service.save(product);
		list = service.findAll();
		model.addAttribute("product", list);
		return "product";
	}
	
}
