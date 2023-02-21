package com.sky.service;

import com.sky.model.Result;
import com.sky.model.Request;
import com.sky.model.Response;
import com.sky.model.Information;
import org.springframework.http.HttpStatus;
import com.sky.entity.UserInformationEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import com.sky.repository.UserInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserInformationService {

    @Autowired
    private UserInformationRepository userInformationRepository;

    public ResponseEntity<Response> consult(Request request) {

        Result result = new Result();
        Response response = new Response();
        Information information = new Information();
        UserInformationEntity userInformationEntity = new UserInformationEntity();

        try {

            if(request.getCredentials() != null){

                if (request.getCredentials().getUser() != null && !request.getCredentials().getUser().trim().isEmpty()) {

                    if(request.getCredentials().getCode() != null && !request.getCredentials().getCode().trim().isEmpty()){

                        userInformationEntity = userInformationRepository.getInformation(request.getCredentials().getUser().trim(), request.getCredentials().getCode().trim());

                        if (userInformationEntity != null) {

                            result.setCode("100");
                            result.setDescription("Petición realizada con éxito.");

                            information.setIdentifier(userInformationEntity.getIdentifier().toString());
                            information.setAccount(userInformationEntity.getAccount());
                            information.setName(userInformationEntity.getName());
                            information.setLastName(userInformationEntity.getLastName());
                            information.setCreationDate(userInformationEntity.getCreationDate().toString());
                            information.setUpdateDate(userInformationEntity.getUpdateDate().toString());

                            response.setResult(result);
                            response.setInformation(information);

                            return new ResponseEntity(response, HttpStatus.ACCEPTED);

                        } else {

                            result.setCode("500");
                            result.setDescription("Credenciales incorrectas.");

                            response.setResult(result);
                            response.setInformation(information);

                            return new ResponseEntity(response, HttpStatus.NOT_FOUND);

                        }

                    }else{

                        result.setCode("400");
                        result.setDescription("Ingresar código.");

                        response.setResult(result);
                        response.setInformation(information);

                        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

                    }

                } else {

                    result.setCode("300");
                    result.setDescription("Ingresar usuario.");

                    response.setResult(result);
                    response.setInformation(information);

                    return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

                }

            }else{

                result.setCode("200");
                result.setDescription("Ingresar credenciales.");

                response.setResult(result);
                response.setInformation(information);

                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

            if(e.getMessage() != null){

                result.setCode("-51");
                result.setDescription("Excepción al tratar de consultar información del usuario.");

                response.setResult(result);
                response.setInformation(information);

                return new ResponseEntity(response, HttpStatus.NOT_FOUND);

            }else{

                result.setCode("-50");
                result.setDescription("Solicitud incorrecta.");

                response.setResult(result);
                response.setInformation(information);

                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

            }

        }

    }

}
