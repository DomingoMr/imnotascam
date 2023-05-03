package com.backend.imnotascam.service;

import com.backend.imnotascam.dto.Response;
import com.backend.imnotascam.entity.TBlackList;
import com.backend.imnotascam.entity.TWhiteList;
import com.backend.imnotascam.repository.BlackListRepository;
import com.backend.imnotascam.repository.WhiteListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final BlackListRepository blackListRepository;

    private final WhiteListRepository whiteListRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////BLACK LIST//////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Response addToBlackList(String url) {
        Response response = new Response();

        try {
            //Compruebo que la url no este ya registrada
            Optional<TBlackList> blackListOptional = blackListRepository.findByUrl(url);
            if (blackListOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Url ya registrada");
            }

            //Guardo el registro
            blackListRepository.save(new TBlackList(url));

            response.setCode("0");
            response.setData("Url: " + url);
            response.setDescription("Url anadidia a la lista negra");
        } catch (ResponseStatusException e) {
            response.setCode("1");
            response.setData(e.getMessage());
            response.setDescription("Error controlado");
        } catch (Exception e) {
            response.setCode("100");
            response.setData(e.getMessage());
            response.setDescription("Error no controlado");
        }

        return response;
    }

    public Response deleteBlackListUrl(String url){
        Response response = new Response();

        try {
            //Compruebo que la url este registrada
            Optional<TBlackList> blackListOptional = blackListRepository.findByUrl(url);
            if (!blackListOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url no econtrada");
            }

            //Guardo el registro
            blackListRepository.delete(blackListOptional.get());

            response.setCode("0");
            response.setData("Url: " + url);
            response.setDescription("Url borrada de la lista negra");
        } catch (ResponseStatusException e) {
            response.setCode("1");
            response.setData(e.getMessage());
            response.setDescription("Error controlado");
        } catch (Exception e) {
            response.setCode("100");
            response.setData(e.getMessage());
            response.setDescription("Error no controlado");
        }

        return response;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////WHITE LIST//////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Response addToWhiteList(String url) {
        Response response = new Response();

        try {
            //Compruebo que la url no este ya registrada
            Optional<TWhiteList> whiteListOptional = whiteListRepository.findByUrl(url);
            if (whiteListOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Url ya registrada");
            }

            //Guardo el registro
            whiteListRepository.save(new TWhiteList(url));

            response.setCode("0");
            response.setData("Url: " + url);
            response.setDescription("Url anadidia a la lista blanca");

        } catch (ResponseStatusException e) {
            response.setCode("1");
            response.setData(e.getMessage());
            response.setDescription("Error controlado");
        } catch (Exception e) {
            response.setCode("100");
            response.setData(e.getMessage());
            response.setDescription("Error no controlado");
        }
            return response;

    }

    public Response deleteWhiteListUrl(String url){
        Response response = new Response();

        try {
            //Compruebo que la url este registrada
            Optional<TWhiteList> whiteListOptional = whiteListRepository.findByUrl(url);
            if (!whiteListOptional.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url no econtrada");
            }

            //Guardo el registro
            whiteListRepository.delete(whiteListOptional.get());

            response.setCode("0");
            response.setData("Url: " + url);
            response.setDescription("Url borrada de la lista blanca");
        } catch (ResponseStatusException e) {
            response.setCode("1");
            response.setData(e.getMessage());
            response.setDescription("Error controlado");
        } catch (Exception e) {
            response.setCode("100");
            response.setData(e.getMessage());
            response.setDescription("Error no controlado");
        }

        return response;
    }


    public Response checkUrl(String url) {
        Response response = new Response();



        return response;
    }

}
