package es.upm.miw.api.sports;

import es.upm.miw.api.sports.api.SportsResource;
import es.upm.miw.api.sports.api.UsersResource;
import es.upm.miw.api.sports.exceptions.InvalidExistingSportException;
import es.upm.miw.api.sports.exceptions.InvalidExistingUserException;
import es.upm.miw.api.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.api.sports.exceptions.InvalidRequestException;
import es.upm.miw.api.sports.exceptions.InvalidUserFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

    private UsersResource userResource = new UsersResource();

    private SportsResource sportResource = new SportsResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        // **/users
        if ("users".equals(request.getPath())) {
            response.setBody(userResource.userList().toString());
            // **/users/search?sport={id}
        } else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1])
                && (request.getParams().get("sport") != null)) {
            try {
                response.setBody(userResource.nickSportList(request.getParams().get("sport")).toString());

            } catch (Exception e) {
                responseError(response, e);
            }
        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) throws InvalidExistingUserException, InvalidSportFieldException {
        switch (request.getPath()) {
        // POST **/users body="nick:email"
        case "users":
            String userNick = request.getBody().split(":")[0];
            String userEmail = request.getBody().split(":")[1];

            try {
                userResource.createUser(userNick, userEmail);
                response.setStatus(HttpStatus.CREATED);
            } catch (InvalidUserFieldException e) {
                this.responseError(response, e);
            }
            break;
        // POST sports body="name"
        case "sports":

            try {
                sportResource.createSport(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } catch (InvalidExistingSportException e) {
                responseError(response, e);
            }
            break;
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        // PUT users/{nick}/sports body="sportName"
        if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
            String userNick = request.paths()[1];
            try {
                userResource.addSport(userNick, request.getBody());
                response.setStatus(HttpStatus.OK);
            } catch (Exception e) {
                responseError(response, e);
            }

        } else {
            responseError(response, new InvalidRequestException(request.getPath()));
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        switch (request.getPath()) {
        default:
            responseError(response, new InvalidRequestException(request.getPath()));
            break;
        }
    }

}
