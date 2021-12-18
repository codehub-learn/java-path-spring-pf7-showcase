package gr.codelearn.spring.showcase.app.controller.demo;

import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mvc")
@AllArgsConstructor
public class MvcController {

	private ProductService productService;

	@GetMapping
	public String index(){
		return "index";
	}

	@GetMapping("/products")
	public String showAllOurProducts(Model model) {
		final List<Product> allProducts = productService.findAll();
		model.addAttribute("products", allProducts);
		return "products";
	}
}
