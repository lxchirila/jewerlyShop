package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.jdbc.dao.ProductDAO;
import org.fasttrackit.jdbc.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	@RequestMapping(value = "lista-produse.htm")
	public ModelAndView listaProduse() throws SQLException {

		ProductDAO pdao = new ProductDAO();
		ArrayList<Product> products = (ArrayList<Product>) pdao.getProducts();

		ModelMap model = new ModelMap();
		model.put("product", products);

		return new ModelAndView("WEB-INF/produse/list.jsp", "model", model);
	}

		@RequestMapping(value = "editare-produs.htm")
		public ModelAndView editareProdus(@RequestParam("id") int productId, Model model) throws SQLException {

			ProductDAO pdao = new ProductDAO();
			Product product = pdao.getProductById(productId);

			model.addAttribute("product", product);

			return new ModelAndView("WEB-INF/produse/edit.jsp", "model", model);
		}

		@RequestMapping(value = "salvare-produs.htm")
		public ModelAndView salvareProdus(@ModelAttribute("product") Product product, Model model, BindingResult result)
				throws SQLException {

			ProductDAO pdao = new ProductDAO();
			pdao.updateProduct(product);

			return new ModelAndView("redirect:/lista-produse.htm");
		}

		@RequestMapping(value = "adaugare-produs.htm")
		public ModelAndView adaugareProdus(Model model) throws SQLException {

			Product product = new Product();

			model.addAttribute("product", product);

			return new ModelAndView("WEB-INF/produse/add.jsp", "model", model);
		}

		@RequestMapping(value = "creare-produs.htm")
		public ModelAndView creareProdus(@ModelAttribute("product") Product product, Model model, BindingResult result)
				throws SQLException {

			ProductDAO pdao = new ProductDAO();
			pdao.insertProduct(product);

			return new ModelAndView("redirect:/lista-produse.htm");
		}

		@RequestMapping(value = "stergere-produs.htm")
		public ModelAndView stergereBijutier(@RequestParam("id") int productId, Model model) throws SQLException {

			ProductDAO pdao = new ProductDAO();
			pdao.deleteProduct(productId);

			return new ModelAndView("redirect:/lista-produse.htm");
			
		}
		@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
		public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) {
		    modelMap.addAttribute("file", file);
		    return "fileUploadView";
		}

	}
