package com.exercise.service.borrowAndPay;

import com.exercise.model.BorrowAndPay;
import com.exercise.service.IGeneralService;
import org.springframework.data.repository.query.Param;

public interface IBorrowAndPayService extends IGeneralService<BorrowAndPay> {
    BorrowAndPay borrowAndPay (int code);
}
