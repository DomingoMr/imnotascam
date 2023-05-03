package com.backend.imnotascam.service;

import com.backend.imnotascam.dto.Response;
import com.backend.imnotascam.entity.TBlackList;
import com.backend.imnotascam.entity.TWhiteList;
import com.backend.imnotascam.repository.BlackListRepository;
import com.backend.imnotascam.repository.WhiteListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final BlackListRepository blackListRepository;

    private final WhiteListRepository whiteListRepository;

    public Response addToBlackList(String url) {
        Response response = new Response();
        blackListRepository.save(new TBlackList(url));

        response.setCode("0");
        response.setData("Url: " + url);
        response.setDescription("Url anadidia a la lista negra");


        return response;
    }

    public Response addToWhiteList(String url) {
        Response response = new Response();
        whiteListRepository.save(new TWhiteList(url));

        response.setCode("0");
        response.setData("Url: " + url);
        response.setDescription("Url anadidia a la lista blanca");


        return response;
    }
    public Response checkUrl(String url) {
        Response response = new Response();



        return response;
    }

}
