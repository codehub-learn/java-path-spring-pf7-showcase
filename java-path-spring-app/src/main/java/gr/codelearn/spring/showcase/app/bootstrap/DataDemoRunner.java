package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.Category;
import gr.codelearn.spring.showcase.app.service.CategoryService;
import gr.codelearn.spring.showcase.app.service.CustomerService;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DataDemoRunner  extends AbstractLogComponent implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final CategoryService categoryService;
	private final CustomerService customerService;
	private final OrderService orderService;
	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("=============================");
		logger.info("====Finding Category by Id====");
		Category foundCategory = categoryService.find(1L);
		Optional.ofNullable(foundCategory).ifPresent(category -> logger.info(category.toString()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding All Categories====");
		categoryService.findAll().forEach(category -> logger.info(category.toString()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding Category By Description ====");
		logger.info(categoryService.findByDescription("DESKTOP PC").toString());
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Finding Customer by Email====");
		Optional.ofNullable(customerService.findByEmail("chrisperis@gmail.com"))
				.ifPresent(customer -> logger.info(customer.toString()));
		logger.info("=============================");
		logger.info("=============================");


		logger.info("=============================");
		logger.info("====Finding Product by Category ====");
		Optional.ofNullable(foundCategory).ifPresent(category ->
				logger.info(productService.findByCategory(foundCategory).toString()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Fetch Lazily orders ====");
		/*Either of below should throw LazyInitializationException since orderItems aren't fetched eagerly*/
		/*orderService.get(1L).getOrderItems();
		orderService.findAll()
					.forEach(order -> order.getOrderItems()
										   .forEach(oi -> logger.info(oi.toString())));*/
		logger.info("=============================");
		logger.info("=============================");

		orderService.findAllLazy().forEach(order -> order.getOrderItems()
														 .forEach(oi -> logger.info(oi.toString())));

		logger.info("=============================");
		logger.info("====Fetch data into custom dto with native query====");
		logger.info("REPORT: Displaying total number of purchases and corresponding cost per customer category");
		orderService.findTotalNumberAndCostOfPurchasesPerCustomerCategory().forEach(
				i -> logger.info("{} was purchased {} times costing in average {}€.", i.getCategory(), i.getPurchases(),
								 i.getCost()));
		logger.info("=============================");
		logger.info("=============================");

		logger.info("=============================");
		logger.info("====Fetch data into custom dto with native query====");
		logger.info("REPORT: Displaying total number of purchases and corresponding cost per customer");
		orderService.findTotalNumberAndTotalCostOfPurchasesPerCustomer().forEach(
				i -> logger.info("{} purchased {} times paying in total {}€.", i.getCustomerName(), i.getPurchases(),
								 i.getCost()));
		logger.info("=============================");
		logger.info("=============================");

	}
}
