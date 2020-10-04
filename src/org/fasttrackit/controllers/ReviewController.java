package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.jdbc.dao.ReviewDAO;
import org.fasttrackit.jdbc.pojo.Review;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReviewController {
	@RequestMapping(value = "lista-review.htm")
	public ModelAndView listareReview() throws SQLException {

		ReviewDAO rdao = new ReviewDAO();
		ArrayList<Review> reviews = rdao.getReviews();

		ModelMap model = new ModelMap();
		model.put("reviews", reviews);

		return new ModelAndView("WEB-INF/review/list.jsp", "model", model);

	}

	@RequestMapping(value = "editare-review.htm")
	public ModelAndView editareReview(@RequestParam("id") int jewelerId, Model model) throws SQLException {

		ReviewDAO rdao = new ReviewDAO();
		Review review = rdao.getReviewById(jewelerId);

		model.addAttribute("review", review);

		return new ModelAndView("WEB-INF/review/edit.jsp", "model", model);
	}

	@RequestMapping(value = "salvare-review.htm")
	public ModelAndView salvareReview(@ModelAttribute("review") Review review, Model model, BindingResult result)
			throws SQLException {

		ReviewDAO rdao = new ReviewDAO();
		rdao.updateReview(review);

		return new ModelAndView("redirect:/lista-review.htm");
	}

	@RequestMapping(value = "adaugare-review.htm")
	public ModelAndView adaugareReview(Model model) throws SQLException {

		Review review = new Review();

		model.addAttribute("review", review);

		return new ModelAndView("WEB-INF/review/add.jsp", "model", model);
	}

	@RequestMapping(value = "creare-review.htm")
	public ModelAndView creareReview(@ModelAttribute("review") Review review, Model model, BindingResult result)
			throws SQLException {

		ReviewDAO rdao = new ReviewDAO();
		rdao.insertReview(review);

		return new ModelAndView("redirect:/lista-review.htm");
	}

	@RequestMapping(value = "stergere-review.htm")
	public ModelAndView stergereReview(@RequestParam("id") int jewelerId, Model model) throws SQLException {

		ReviewDAO rdao = new ReviewDAO();
		rdao.deleteReview(jewelerId);

		return new ModelAndView("redirect:/lista-review.htm");
	}

}
