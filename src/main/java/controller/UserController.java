package controller;

import dto.request.UserDto;
import model.HttpRequest;
import model.HttpResponse;
import service.UserService;

import static webserver.HttpStatus.BAD_REQUEST;

public class UserController {
    public static HttpResponse createUser(HttpRequest httpRequest){
        try{
            UserDto userDto = UserDto.from(httpRequest.getBody());
            UserService.signUp(userDto);
            return HttpResponse.redirect("/index.html");
        }catch (IllegalArgumentException | NullPointerException e){
            return HttpResponse.errorResponse(BAD_REQUEST, e.getMessage());
        }
    }
}
