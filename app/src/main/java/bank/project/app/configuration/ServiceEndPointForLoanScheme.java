package bank.project.app.configuration;

import bank.project.dao.model.LoanScheme;
import bank.project.dao.service.BankService;
import bank.project.soap.ListLoanSchemeRequest;
import bank.project.soap.ListLoanSchemeResponse;
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
//end point for loanScheme xsd pojo
@Endpoint
public class ServiceEndPointForLoanScheme {
    private static final String url="http://soap.project.bank";
    private Logger logger= LoggerFactory.getLogger(ServiceEndPointForLoanScheme.class);

    @Autowired
    private BankService bankService;

    @PayloadRoot(namespace = url,localPart = "listLoanSchemeRequest")
    @ResponsePayload
    public ListLoanSchemeResponse listLoanResponse(@RequestPayload ListLoanSchemeRequest listLoanSchemeRequest){
        ListLoanSchemeResponse response=new ListLoanSchemeResponse();

        List<LoanScheme> loanSchemeList = bankService.getAllLoanScheme();// pojo objects
        List<bank.project.soap.LoanScheme> loanSchemeArrayList=new ArrayList<>();// xml list of objects as of its empty

        Iterator<LoanScheme> iterator = loanSchemeList.iterator();
        while(iterator.hasNext()){
            bank.project.soap.LoanScheme loanScheme = new bank.project.soap.LoanScheme();// XSD POJO
            BeanUtils.copyProperties(iterator.next(),loanScheme);
            loanSchemeArrayList.add(loanScheme);
        }

        response.getLoanScheme().addAll(loanSchemeArrayList);
        logger.info(response.toString());
        return response;
    }
}