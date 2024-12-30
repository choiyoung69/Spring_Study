package lecture_review.start.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
