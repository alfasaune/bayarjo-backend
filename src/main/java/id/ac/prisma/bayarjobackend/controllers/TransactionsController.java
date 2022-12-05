package id.ac.prisma.bayarjobackend.controllers;

import id.ac.prisma.bayarjobackend.data.model.TbTransactions;
import id.ac.prisma.bayarjobackend.data.repo.TbTransactionsRepository;
import id.ac.prisma.bayarjobackend.services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/transactions"})
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;

    @RequestMapping(value = "/submit-trx", method = RequestMethod.POST, produces = "application/json")
    public Map submitTrx(@RequestBody Map bodyRequest) {
        Map response = new HashMap();
//        1.1. Terima request
        String amount = bodyRequest.get("amount").toString();
        String transactionDate = bodyRequest.get("transaction_date").toString();
        String paymentMethod = bodyRequest.get("payment_method").toString();
        String merchantName = bodyRequest.get("merchant_name").toString();

        response = transactionsService.submitTrx(amount, transactionDate, paymentMethod, merchantName);
        return response;
    }
}
