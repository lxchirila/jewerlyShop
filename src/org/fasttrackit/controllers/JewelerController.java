package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;


import org.fasttrackit.jdbc.dao.JewelerDAO;
import org.fasttrackit.jdbc.pojo.Jeweler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JewelerController {

	@RequestMapping(value = "lista-bijutieri.htm")
	public ModelAndView listareBijutieri() throws SQLException {

		JewelerDAO jdao = new JewelerDAO();
		ArrayList<Jeweler> bijutieri =jdao.getJewelers();

		ModelMap model = new ModelMap();
		model.put("bijutieri", bijutieri);

		return new ModelAndView("WEB-INF/bijutieri/list.jsp", "model", model);

	}

	@RequestMapping(value = "editare-bijutier.htm")
	public ModelAndView editareBijutier(@RequestParam("id") int jewelerId, Model model) throws SQLException {

		JewelerDAO jdao = new JewelerDAO();
		Jeweler jeweler = jdao.getJewelerById(jewelerId);

		model.addAttribute("jeweler", jeweler);

		return new ModelAndView("WEB-INF/bijutieri/edit.jsp", "model", model);
	}

	@RequestMapping(value = "salvare-bijutier.htm")
	public ModelAndView salvareBijutier(@ModelAttribute("jeweler") Jeweler jeweler, Model model, BindingResult result)
			throws SQLException {

		JewelerDAO jdao = new JewelerDAO();
		jdao.updateJeweler(jeweler);

		return new ModelAndView("redirect:/lista-bijutieri.htm");
	}

	@RequestMapping(value = "adaugare-bijutier.htm")
	public ModelAndView adaugareBijutier(Model model) throws SQLException {

		Jeweler jeweler = new Jeweler();

		model.addAttribute("jeweler", jeweler);

		return new ModelAndView("WEB-INF/bijutieri/add.jsp", "model", model);
	}

	@RequestMapping(value = "creare-bijutier.htm")
	public ModelAndView creareBijutier(@ModelAttribute("jeweler") Jeweler jeweler, Model model, BindingResult result)
			throws SQLException {

		JewelerDAO jdao = new JewelerDAO();
		jdao.insertJeweler(jeweler);

		return new ModelAndView("redirect:/lista-bijutieri.htm");
	}

	@RequestMapping(value = "stergere-bijutier.htm")
	public ModelAndView stergereBijutier(@RequestParam("id") int jewelerId, Model model) throws SQLException {

		JewelerDAO jdao = new JewelerDAO();
		jdao.deleteJeweler(jewelerId);

		return new ModelAndView("redirect:/lista-bijutieri.htm");
	}

}
