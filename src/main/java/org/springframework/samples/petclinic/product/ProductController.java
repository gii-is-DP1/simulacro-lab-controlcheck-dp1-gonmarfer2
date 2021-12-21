package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/create")
	public String createProduct(ModelMap modelMap, HttpServletResponse response) {
		Product p = new Product();
		modelMap.addAttribute("product",p);
		
		List<ProductType> lpt = productService.getAllProductTypes();
		modelMap.addAttribute("producttypes",lpt);
		
		return "redirect:/product/create";
	}
	
	@PostMapping("/create")
	public String processPost(@Valid Product product, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			modelMap.addAttribute("product", product);
			return "product/create";

		}else {
			
			productService.save(product);
		}
		return "redirect:/";
	}
	
}
