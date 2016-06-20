package com.mcs.open;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorld
{
    @WebMethod
    public String sayHello();
}
