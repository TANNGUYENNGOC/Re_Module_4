package com.exercise.service.borrowAndPay;

import com.exercise.model.Order;
import com.exercise.service.IGeneralService;

public interface IOrderService extends IGeneralService<Order> {
    Order borrowAndPay (int code);
}
