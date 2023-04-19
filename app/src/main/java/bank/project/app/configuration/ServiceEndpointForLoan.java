package bank.project.app.configuration;

import bank.project.dao.model.Loan;
import bank.project.dao.service.BankService;
import bank.project.soap.ListLoanRequest;
import bank.project.soap.ListLoanResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//end point for loan xsd pojo
@Endpoint
public class ServiceEndpointForLoan {
    private static final String url = "http://soap.project.bank";
    private Logger logger = LoggerFactory.getLogger(ServiceEndpointForLoan.class);

    @Autowired
    private BankService bankService;

    @PayloadRoot(namespace = url, localPart = "listLoanRequest")
    @ResponsePayload
    //provides the list of loan
    public ListLoanResponse listOfficialResponse(@RequestPayload ListLoanRequest listLoanRequest) {
        logger.info("End point is getting called!");
        ListLoanResponse listLoanResponse = new ListLoanResponse();

        // pojo objects
        List<Loan> loanList = bankService.getAllLoans();
        logger.info(loanList.toString());
        //xml objects
        List<bank.project.soap.Loan> list = new ArrayList<>();

        Iterator<Loan> loanIterator = loanList.iterator();
        while (loanIterator.hasNext()) {
            bank.project.soap.Loan loan = new bank.project.soap.Loan();// XSD POJO
            BeanUtils.copyProperties(loanIterator.next(), loan);
            list.add(loan);
        }
        listLoanResponse.getLoan().addAll(list);
        logger.info(listLoanResponse.toString());
        return listLoanResponse;
    }
}