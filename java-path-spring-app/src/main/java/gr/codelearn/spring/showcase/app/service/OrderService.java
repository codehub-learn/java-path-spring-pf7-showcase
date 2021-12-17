package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.domain.Customer;
import gr.codelearn.spring.showcase.app.domain.Order;
import gr.codelearn.spring.showcase.app.domain.PaymentMethod;
import gr.codelearn.spring.showcase.app.domain.Product;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomerCategoryDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService extends BaseService<Order, Long> {
	Order initiateOrder(Customer customer);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

	Order findLazy(Long id);

	List<Order> findAllLazy();

	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	Order findMostExpensiveOrder();

	List<PurchasesAndCostPerCustomerCategoryDto> findTotalNumberAndCostOfPurchasesPerCustomerCategory();

}
