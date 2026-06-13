package com.woowa.study.order;

public interface OrderService {

    Order creawteOrder(Long memberId, String itemName, int itemPrice);
}
